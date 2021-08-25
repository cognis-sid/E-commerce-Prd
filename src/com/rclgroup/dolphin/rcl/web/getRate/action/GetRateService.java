package com.rclgroup.dolphin.rcl.web.getRate.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import com.niit.control.common.GlobalConstants;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.getRate.actionForm.GetRateUim;
import com.rclgroup.dolphin.rcl.web.getRate.dao.GetRateDao;

public class GetRateService extends BaseAction implements GlobalConstants {

	 public static final PageSize[] pageSizes = {
	            PageSize.A3,
	            PageSize.A2,
	            PageSize.A1,
	    };
	 
	@Override
	public ActionForward executeAction(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
		String pageAction = null;
		String errorMsg = null;
		GetRateUim form = (GetRateUim) actionForm;
		String forwardPage=null;
		try {
			pageAction = actionMapping.getParameter();
			if ("onload".equals(pageAction)) {
				forwardPage = getOnload(form, request);
			} else if("getgetratedata".equals(pageAction)) {
				forwardPage = getRatedata(form, request,response);
			}
			 
		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
			// form.setErrMsg(errorMsg);

			forwardPage = FAILURE;
		}
		return actionMapping.findForward(forwardPage);
		
	}

	private String getOnload(GetRateUim form, HttpServletRequest request) throws Exception {
		System.out.println("getOnload() called...");
		EserviceRegistrationDao dao         = getEserviceRegistrationDao();
		form.setContryList(dao.getCountryCodeNameList()); 
		String forwardPage = null;
		forwardPage = SUCCESS;
		return forwardPage;
	}
	
	  private EserviceRegistrationDao getEserviceRegistrationDao() throws Exception {
	        EserviceRegistrationDao dao = null;
	        try {
	            dao = (EserviceRegistrationDao)getDao(EserviceRegistrationDao.DAO_NAME);
	        } catch (Exception ex) {
	            throw ex;
	        }
	        return dao;
	    } 
	  
	  
	private String getRatedata(GetRateUim rateUim, HttpServletRequest request,HttpServletResponse response) {
		System.out.println(rateUim.getPayload());		  
		UserAccountBean  userAcc =(UserAccountBean)request.getSession(false).getAttribute(USER_ACCOUNT_BEAN);
		rateUim.setEmaill(userAcc.getMailId());
		EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");		 
		GetRateDao dao = null;		 
        try {
        	      	
        	dao = (GetRateDao) getDao(GetRateDao.DAO_NAME);
			try{
				dao.saveData(rateUim,userAcc);    
			}catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
	        Map<String,Object> pdfFileParamter = new HashMap<>();
	        
	        pdfFileParamter.put("payload", rateUim.getPayload().replaceAll("display: none;", ""));
	        pdfFileParamter.put("rateUIInput", rateUim);
	        pdfFileParamter.put("bootstrap",EZLBeanFactory.class.getResource("./").toString()+"../../../../../../../pdf/bootstrap.min.css");
	        pdfFileParamter.put("rcl_logo",EZLBeanFactory.class.getResource("./").toString()+"../../../../../../../images/rcl_logo.png");
	        
	        String orderHtml = VelocityEngineUtils.mergeTemplateIntoString(mail.getVelocityEngine(),
					"com/rclgroup/dolphin/ezl/email/rate_inuiry_pdf_template.vm", pdfFileParamter);	         
	        ConverterProperties converterProperties = new ConverterProperties();	
	        
	        //ConverterProperties converterProperties = new ConverterProperties();

	        PdfWriter writer = new PdfWriter(response.getOutputStream());
	        PdfDocument pdfDoc = new PdfDocument(writer);
	        pdfDoc.setDefaultPageSize(pageSizes[rateUim.getNumberOfContainer()-1]);

	        
	         
	        
	        MediaDeviceDescription mediaDescription = new MediaDeviceDescription(MediaType.SCREEN);
	        mediaDescription.setWidth(1000);
	             
	        
	        converterProperties.setMediaDeviceDescription(mediaDescription);
	        
	                 
	        response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=" +"RCL QuotationNo "+rateUim.getQuotationRef()+ ".pdf");             
            
            HtmlConverter.convertToPdf(orderHtml, pdfDoc, converterProperties);
	        
             
			// copy it to response's OutputStream
			 response.setContentLength(orderHtml.length());
			
		        //Copy bytes from source to destination(outputstream in this example), closes both streams.
		     //   FileCopyUtils.copy(inputStream, response.getOutputStream());
		        try {
		        		//mail.sendRateInquireMail(rateUim, bytes);
		        		
		        }catch (Exception e) {
					// TODO: handle exception
				}
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
          
		 
		return SUCCESS;
	}
}

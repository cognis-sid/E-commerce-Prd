package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EvgmDeclarationPDFReportUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EvgmDeclarationUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionPrintDao;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EvgmDeclarationPDFReportSvc extends BaseAction {
    
    public static final String REPORT_FORMAT_PDF = "PDF";
    public static final String DAO_ESI = "EshippingInstructionPrintDao";
    
    public static final String ESV_VGM_PRE = "ESV_VGM_PRE";
    
    public EvgmDeclarationPDFReportSvc() {
    }
    
    public ActionForward executeAction(ActionMapping mapping, ActionForm form, 
                                       HttpServletRequest request, 
                                       HttpServletResponse response) throws Exception {
        
        EvgmDeclarationUim evgmDeclarationUim = (EvgmDeclarationUim)request.getSession().getAttribute("evgmDeclarationUim");
        
        String strAction = mapping.getParameter();
        String resultAction =SUCCESS;
        String pageAction = FormatUtil.nullToStr(request.getParameter("pageAction"));
        System.out.println("[EvgmDeclarationPDFReportSvc][execute]: Started");
        
        
        HttpSession session=request.getSession(false); 
//        String blNumber   = FormatUtil.toStringTrim(request.getParameter("blNumber"));
        String reportFormat = FormatUtil.getParameterToString(request, "reportFormat", REPORT_FORMAT_PDF, FormatUtil.CASE_TYPE_UPPER);
//        String userid =   getUserID(request);
        EvgmDeclarationPDFReportUim uim = new EvgmDeclarationPDFReportUim();
        
        
        uim.setBookingNo(evgmDeclarationUim.getBookingNo());
        uim.setDisplayVesslVoy(evgmDeclarationUim.getDisplayVesslVoy());
        uim.setShipperName(evgmDeclarationUim.getShipperName());
        uim.setRespresentName(evgmDeclarationUim.getRespresentName());
        uim.setAuthorizePerson(evgmDeclarationUim.getAuthorizePerson());
        uim.setSubmissionDate(evgmDeclarationUim.getSubmissionDate());
        
        uim.setReportFormat(reportFormat);
        uim.setPageAction(pageAction);
        
        System.out.println("uim.getShipperName() >>>>>>>>>>>>>>>> "+uim.getShipperName());
        
        resultAction = gotoPreviewPrint(uim,session);
        
        
        return mapping.findForward(resultAction);
    }
    
    
    public String gotoPreviewPrint(EvgmDeclarationPDFReportUim uim, HttpSession session){
        String    resultAction = SUCCESS;
        StringBuffer errorMsgBuffer = new StringBuffer();
        
        EshippingInstructionPrintDao objESIDao = (EshippingInstructionPrintDao)getDao(DAO_ESI);
        
//        URLEncoder.encode("", "UTF-8");
        String reportUrl = uim.getReportUrlConstant(objESIDao);
        System.out.println("##### reportUrl 1  = "+reportUrl);  
        
        try{
        reportUrl += ESV_VGM_PRE+".rdf&desformat=PDF";
        reportUrl += "&P_BOOKING_NO="+uim.getBookingNo()
                            +   "&P_VESSEL_VOY="+uim.getDisplayVesslVoy()
                            +   "&P_SHIPPER_NAME="+URLEncoder.encode(uim.getShipperName(), "UTF-8")
//                            +   "&P_SHIPPER_NAME="+uim.getShipperName()
//                            +   "&P_SHIPPER_NAME="+URLEncoder.encode("aa aaa", "UTF-8")
                            +   "&P_RESPRESENT_NAME="+URLEncoder.encode(uim.getRespresentName(), "UTF-8")
                            +   "&P_AUTH_NAME="+URLEncoder.encode(uim.getAuthorizePerson(), "UTF-8")
                            +   "&P_SUBMISS_DATE="+uim.getSubmissionDate();
                            
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("##### reportUrl = "+reportUrl);                
        uim.setReportUrl(reportUrl);
        session.setAttribute("errMsg",null);
        session.setAttribute("evgmDeclarationPDFReportUim",uim);
        resultAction = SUCCESS;
        
        
        return resultAction;
    }
}

/*
-------------------------------------------------------------------------------------------------------------
EservicePdfSvc.java
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePdfUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

import java.io.File;

import java.io.FileInputStream;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EservicePdfSvc extends BaseAction {

    private static final long serialVersionUID = 1L;
    
    private HttpServletRequest          request;
    private HttpServletResponse         response;
    private EserviceNewWebBookingDao    newWebObjDao;
    private EservicePdfUim              form = null;
        
    public EservicePdfSvc() {
        
    }

    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EservicePdfUim form1, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction   = null;
        String forwardPage  = null;
        
        try{
            pageAction = form1.getCurrPageAction();
            
            this.request            = request;
            this.response           = response;
            this.newWebObjDao       = getDao();
            this.form               = form1;
        
            if (ONLOAD.equals(pageAction)) {             
                this.form.setUserId(getUserID(request));
                forwardPage = this.onLoad();
            }
            
        } catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }

    /**
     *
     * Called from Action Servlet
     *
     * @param mapping ActionMapping
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EservicePdfUim                  form1           = null;
        String                          pageAction      = null;
        String                          errorMsg        = null;
        String                          forwardPage     = null;
        try{
            pageAction = getPageAction(mapping);

            form1 = getForm(actionForm, pageAction);
            form1.setCurrPageAction(pageAction);
            forwardPage = getForwardPage(mapping, actionForm, form1, request, response);
        } catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
            form1.setErrMsg(errorMsg);

            forwardPage = FAILURE;
        }
        return mapping.findForward(forwardPage);
    }

    private EservicePdfUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EservicePdfUim form1 = null;
        try{
            form1 = (EservicePdfUim) actionForm;
            if (form1 == null){
                form1 = new EservicePdfUim();
            }else if(ONLOAD.equals(pageAction)){
                form1.resetForm();
            }
        } catch(Exception ex){
            throw ex;
        }

        return form1;
    }

    private String getPageAction(ActionMapping mapping) throws Exception{
        String pageAction = null;
        try{
            pageAction = mapping.getParameter();
        } catch(Exception ex){
            pageAction = "";
        }

        return pageAction;
    }

    private EserviceNewWebBookingDao getDao() throws Exception{
        EserviceNewWebBookingDao dao = null;
        try{
            dao = (EserviceNewWebBookingDao) getDao(EserviceNewWebBookingDao.DAO_NAME);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }
    /**
     * This method called when screen loads
     * @return
     * @throws Exception
     */
    public String onLoad() throws Exception {
        System.out.println("[EservicePdfSvc][onLoad][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      pdfName                         = null;
        String                      fileName                        = null;
        String                      filePathConf                    = null;
        File                        pdfFile                         = null;
        FileInputStream             fileInputStream                 = null;
        OutputStream                responseOutputStream            = null;
        int                         bytes;
        
        try{
            forwardPage                 = SUCCESS;
            filePathConf                = this.newWebObjDao.getConfigPath();
            pdfName                     = this.request.getParameter("pdfName");
            fileName                    = this.request.getParameter("fileName");
            
            System.out.println("[EservicePdfSvc][onLoad] filePathConf :: " + filePathConf);
            System.out.println("[EservicePdfSvc][onLoad] pdfName :: " + pdfName);
            System.out.println("[EservicePdfSvc][onLoad] fileName :: " + fileName);
            
            //For test
//            filePathConf = "D:/uploads";
            
            pdfFile             = new File(filePathConf, fileName);
            
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=" + pdfName);
            response.setContentLength((int) pdfFile.length());
    
            fileInputStream         = new FileInputStream(pdfFile);
            responseOutputStream    = response.getOutputStream();
            
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EservicePdfSvc][onLoad][End]");

        }
        return null;

    } // end of onLoad method
}

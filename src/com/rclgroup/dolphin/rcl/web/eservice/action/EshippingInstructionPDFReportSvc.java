
/*------------------------------------------------------
EshippingInstructionPDFReportSvc.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author Teerakan Jongruk  05/07/13
 ## DD/MM/YY       -User-           -TaskRef-      -Short Description
 01 05/07/13      Teerakan                        Create Class
 02 11/07/13      Teerakan                        add Check null BL Print Data Befor goto report
 03 01/11/13      Teerakan              03          in  case All status  The Report Should be call ESH_BKG_PRI Report
------------------------------------------------------*/

package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionPrintDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EshippingInstructionPDFReportSvc extends BaseAction 
 {
    public static final String REPORT_FORMAT_PDF = "PDF";
    
    public static final String DAO_BEAN_ID = "EshippingInstructionPrintDao";
    public static final String EXCEPTION_NO_DATA = "No row(s) retrieved ";
    
    public static final String REPORT_MODE_BKG = "2";
    public static final String REPORT_MODE_BL = "3";
    public static final  String DEX_BL_PRI = "DEX_BL_PRI";
    public static final  String ESH_BKG_PRI = "ESH_BKG_PRI";
    
    public static String STATUS_IN_PROGRESS = "IN PROGRESS";
    public static String STATUS_SUBMITTED = "SUBMITTED";
    
    
    public EshippingInstructionPDFReportSvc() {
    }


    /**
     * 
     * Called from Action Servlet
     * 
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
     
    public ActionForward executeAction(ActionMapping mapping, ActionForm form, 
                                       HttpServletRequest request, 
                                       HttpServletResponse response) throws Exception {
     
        String strAction = mapping.getParameter();
        String resultAction =SUCCESS;
        String pageAction = FormatUtil.nullToStr(request.getParameter("pageAction"));
        System.out.println("[EshippingInstructionPDFReportSvc][execute]: Started");
        String esiStatus = FormatUtil.nullToStr(request.getParameter("esiStatus"));
        System.out.println("esiStatus = "+ esiStatus); 
        
        HttpSession session=request.getSession(false); 
        String blNumber   = FormatUtil.toStringTrim(request.getParameter("blNumber"));
        String reportFormat = FormatUtil.getParameterToString(request, "reportFormat", REPORT_FORMAT_PDF, FormatUtil.CASE_TYPE_UPPER);
        String userid =   getUserID(request);
        EshippingInstructionPrintReportUim uim = new EshippingInstructionPrintReportUim();

     
        //set parameter
        uim.setService("");
        uim.setVessel("");
        uim.setVoyage("");
        uim.setDirection("");
        uim.setOffice("");
        uim.setCreateOffice("");
        uim.setBl(blNumber);
        uim.setCocSoc("");
        uim.setPrint("");
        uim.setShipStatus("");
        uim.setDateFrom("");
        uim.setDateTo("");
        uim.setThirdLocation("");
        uim.setUserName(userid);
        uim.setUserCode(userid);
      
      
        uim.setPageAction(pageAction);
        uim.setReportFormat(reportFormat);
        uim.setListBlPrint(null);
        
        System.out.println("blNumber = "+ blNumber); 
        EshippingInstructionPrintDao objDao = (EshippingInstructionPrintDao)getDao(DAO_BEAN_ID);
//@03 Start
//        if(STATUS_SUBMITTED.equals(esiStatus))
//        {
//            System.out.println("##### REPORT_MODE_BL  Existing Report  = "+STATUS_SUBMITTED);             
//            resultAction = gotoBlPrint(objDao,uim,session);
//        } 
//        
//         if(STATUS_IN_PROGRESS.equals(esiStatus))
//         {
//             resultAction = gotoBKGPrint(objDao,uim,session,blNumber); 
//            System.out.println("##### REPORT_MODE_BKG  New Booking Report  = "+STATUS_IN_PROGRESS);             
//        } 
     
        resultAction = gotoBKGPrint(objDao,uim,session,blNumber); 
        //@03 End

        return mapping.findForward(resultAction);

    } //executeAction
    
    
    public String gotoBlPrint( EshippingInstructionPrintDao objDao,EshippingInstructionPrintReportUim uim, HttpSession session){
        String    resultAction = SUCCESS;
        StringBuffer errorMsgBuffer = new StringBuffer();
        uim.generateListBlPrint(objDao);
       
        if (uim.getListBlPrint() == null ){
            errorMsgBuffer.append(EXCEPTION_NO_DATA);
            uim.setErrMsg(errorMsgBuffer.toString());
            session.setAttribute("errMsg",errorMsgBuffer.toString());
            session.setAttribute("eshippingInstructionPrintReportUim",uim);
            resultAction = FAILURE;
        }else if(uim.getListBlPrint() != null && !(uim.getListBlPrint()).isEmpty()){
        //            errorMsgBuffer.append("* "+uim.getListBlPrint().size()+" rows retrieve");
        
        //            session.setAttribute("errMsg",errorMsgBuffer.toString());
        
            uim.setErrMsg("");
            uim.setPrintBL("D");
            uim.setIncludeCharge("FALSE");
            String reportUrl = uim.getReportUrlConstant(objDao);
            System.out.println("##### reportUrl 1  = "+reportUrl);  
            reportUrl += DEX_BL_PRI+".rdf&desformat=PDF";
            reportUrl += "&P_SID="+uim.getSessionID()
                                +   "&P_USR="+uim.getUserCode()
                                +   "&P_PRI="+uim.getPrintBL()
                                +   "&P_C="+uim.getIncludeCharge();
            System.out.println("##### reportUrl = "+reportUrl);                
            uim.setReportUrl(reportUrl);
            session.setAttribute("errMsg",null);
            session.setAttribute("eshippingInstructionPrintReportUim",uim);
            resultAction = SUCCESS;
        }
    return resultAction;
    }
    
    public String gotoBKGPrint( EshippingInstructionPrintDao objDao,EshippingInstructionPrintReportUim uim, HttpSession session,String blNumber){
        String    resultAction = SUCCESS;
        StringBuffer errorMsgBuffer = new StringBuffer();
        uim.generateListBKGPrint(objDao,blNumber);
       
        if (uim.getListBlPrint() == null ){
            errorMsgBuffer.append(EXCEPTION_NO_DATA);
            uim.setErrMsg(errorMsgBuffer.toString());
            session.setAttribute("errMsg",errorMsgBuffer.toString());
            session.setAttribute("eshippingInstructionPrintReportUim",uim);
            resultAction = FAILURE;
        }else if(uim.getListBlPrint() != null && !(uim.getListBlPrint()).isEmpty()){
        //            errorMsgBuffer.append("* "+uim.getListBlPrint().size()+" rows retrieve");
        
        //            session.setAttribute("errMsg",errorMsgBuffer.toString());
        
            uim.setErrMsg("");
            uim.setPrintBL("D");
            uim.setIncludeCharge("FALSE");
            String reportUrl = uim.getReportUrlConstant(objDao);
            System.out.println("##### reportUrl 1  = "+reportUrl);  
            reportUrl += ESH_BKG_PRI+".rdf&desformat=PDF";
            reportUrl += "&P_BOOKING_NO="+blNumber
                                +   "&P_PRI="+uim.getPrintBL()
                                +   "&P_USER_ID="+uim.getUserCode();
            System.out.println("##### reportUrl = "+reportUrl);                
            uim.setReportUrl(reportUrl);
            session.setAttribute("errMsg",null);
            session.setAttribute("eshippingInstructionPrintReportUim",uim);
            resultAction = SUCCESS;
        }
    return resultAction;
    }
}

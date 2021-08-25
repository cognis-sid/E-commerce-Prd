/*------------------------------------------------------
EserviceAcknowledgementSvc.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
1   01/08/2014  Pratya  @01         Eservice phase 3.1
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceBookingNumberPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EserviceAcknowledgementSvc extends BaseAction {

    public EserviceAcknowledgementSvc() {
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
        if (ONLOAD.equals(strAction)) 
        {
            onLoad(mapping, form, request);
        }
        
        return mapping.findForward(SUCCESS);

    } //executeAction

    /**
     * This method called when screen loads
     * @param mapping
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public ActionForward onLoad(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        EserviceNewWebBookingUim objForm = null;
        
        String bookingNo = null;
        String email = null;
        String customerName = null;
        try{
            objForm = (EserviceNewWebBookingUim)form;
            
            bookingNo = objForm.getBookingNo();
            if(bookingNo == null || BLANK.equals(bookingNo)){
                bookingNo = request.getParameter("bookingNo");    
            }
            email = objForm.getEmail();
            if(email == null || BLANK.equals(email)){
                email = request.getParameter("email");    
            }
            customerName = objForm.getCustomerName();
            if(customerName == null || BLANK.equals(customerName)){
                customerName = request.getParameter("customerName");    
            }
            objForm.setUserId(getEmpName(request));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return mapping.findForward(SUCCESS);

    } // end of onLoad method
}

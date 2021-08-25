/* -----------------------------------------------------------------------------
Name    : EservicePreviewUploadedDocSvc.java
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
Pratya         28/08/2014      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceBookingNumberPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePreviewUploadedDocUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rclgroup.dolphin.rcl.web.eservice.dao.*;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceBookingListMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EservicePreviewUploadedDocSvc extends BaseAction 
{
    public static String DAO_BEAN_ID            = "EservicePreviewUploadedDocDao";
    public static String SEARCH_DATA            = "searchData";
    
    private HttpServletRequest              request     = null;
    private HttpServletResponse             response    = null;
    private EservicePreviewUploadedDocUim   form        = null;

    public EservicePreviewUploadedDocSvc() {
        
    }
    

        private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EservicePreviewUploadedDocUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
            String pageAction = null;
            String forwardPage = null;
            try{
                pageAction = form.getCurrPageAction();
                
                this.request    = request;
                this.response   = response;
                this.form       = form;
            
                if (ONLOAD.equals(pageAction)) {
                    forwardPage = this.onLoad();
                } else if (SEARCH_DATA.equals(pageAction)) {
                    forwardPage = this.onCriteriaSearch();
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
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, 
                                       HttpServletRequest request, 
                                       HttpServletResponse response) throws Exception {

        String                          pageAction          = null;
        String                          errorMsg            = null;
        String                          forwardPage         = null;
        EservicePreviewUploadedDocUim   form                = null;
        
        try{
            pageAction  = mapping.getParameter();
            form        = getForm(actionForm, pageAction);
            
            form.setCurrPageAction(pageAction);
            forwardPage = getForwardPage(mapping, actionForm, form, request, response);
            
        } catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
            form.setErrMsg(errorMsg);

            forwardPage = FAILURE;
        }
        return mapping.findForward(forwardPage);

    }
    
    private EservicePreviewUploadedDocUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EservicePreviewUploadedDocUim form = null;
        
        try{
            form = (EservicePreviewUploadedDocUim) actionForm;
            if (form == null){
                form = new EservicePreviewUploadedDocUim();
            }else if(ONLOAD.equals(pageAction)){
                form.resetForm();
            }
        } catch(Exception ex){
            throw ex;
        }

        return form;
    }
    
    private EservicePreviewUploadedDocDao getDao() throws Exception{
        EservicePreviewUploadedDocDao dao = null;
        try{
            dao = (EservicePreviewUploadedDocDao) getDao(DAO_BEAN_ID);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }
    
     public String onLoad() throws Exception {
        System.out.println("[EservicePreviewUploadedDocSvc][onLoad][Begin]");
        
         String     forwardPage     = FAILURE;
         String     fscCode         = null;
         
         
         try{
             forwardPage    = SUCCESS;
             fscCode        = getUserFsc(request);
             
             this.form.setUserId(getUserID(this.request));
             this.form.setFscCode(fscCode);
             
             this.setComboBox(this.form);
             
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             System.out.println("[EservicePreviewUploadedDocSvc][onLoad][End]");
         }
         
         return forwardPage;

     }
    
    
    
    public void setComboBox(EservicePreviewUploadedDocUim objForm){
        objForm.setSortByComboList(this.getComboBoxSortBy());
        objForm.setOrderByComboList(this.getComboBoxOrderBy());
    }
    
    public List getComboBoxSortBy(){
        List list = new ArrayList();
        list.add(new ComboVO(BLANK, SELECT_ONE));
        list.add(new ComboVO("BABKNO"       , "Booking No"));
        list.add(new ComboVO("BABKDT"       , "Booking Date"));
        list.add(new ComboVO("BABKBY"       , "Booked By"));
        list.add(new ComboVO("FILE_NAME"    , "File Name "));
        return list;
    }
    
    public List getComboBoxOrderBy(){
        List list = new ArrayList();
        list.add(new ComboVO(EservicePreviewUploadedDocUim.ASC  , EservicePreviewUploadedDocUim.ASC_DESCRIPTION));
        list.add(new ComboVO(EservicePreviewUploadedDocUim.DESC , EservicePreviewUploadedDocUim.DESC_DESCRIPTION));
        return list;
    }
    
    public String onCriteriaSearch() throws Exception {
       System.out.println("[EservicePreviewUploadedDocSvc][onCriteriaSearch][Begin]");
       
        String                          forwardPage         = FAILURE;
        EservicePreviewUploadedDocDao   dao                 = null;
        List                            list                = null;
        int                             intTotDBRec         = 0;
        int                             intTotListRec       = 0;
        List                            lstTableData        = null;
        
        try{
            forwardPage         = SUCCESS;
            dao                 = this.getDao();
            
            dao.setUploadListDetail(this.form);
            list = this.form.getSearchResultsList();
            
            System.out.println("[EservicePreviewUploadedDocSvc][onCriteriaSearch] list :: " + list);
            
            if (null != list) {
                intTotListRec   = list.size();
                intTotDBRec     = -1;
                lstTableData    = getTableDataForPreviewUpload(list, this.form.getCurrPageNo());
            }
            
            System.out.println("[EservicePreviewUploadedDocSvc][onCriteriaSearch] lstTableData :: " + lstTableData);
            
            if (null == lstTableData) {
                this.form.setTotRecord(0);
                this.form.setSearchResultsList(new ArrayList());
            } else {
                this.form.setSearchPerformed("true");
                this.form.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                this.form.setSearchResultsList(lstTableData);
            }
            
            this.setComboBox(this.form);
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EservicePreviewUploadedDocSvc][onCriteriaSearch][End]");
        }
        
        return forwardPage;

    }
}

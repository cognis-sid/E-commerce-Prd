 /*------------------------------------------------------
 EserviceUserPortPairLookUpSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 21/10/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUserPortPairLookUpUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceUserPortPairLookUpDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUserPortPairLookUpMod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceUserPortPairLookUpSvc extends BaseAction {
    public  static final String DAO_BEAN_ID                 = "EserviceUserPortPairLookUpDao";
    private static final String LOOKUP_DATA                 = "lookUp";

    private HttpServletRequest              request         = null;
    private EserviceUserPortPairLookUpUim   form            = null;

    public EserviceUserPortPairLookUpSvc() {
        
    }
    
    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceUserPortPairLookUpUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction   = null;
        String forwardPage  = null;
        
        try{
            pageAction      = this.getPageAction(mapping);
            this.request    = request;
            this.form       = form;
        
            if (ONLOAD.equals(pageAction)) {
                forwardPage = this.lp_onloadPage();
            }else if (LOOKUP_DATA.equals(pageAction)) {
                forwardPage = this.lp_getdataList();
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

        EserviceUserPortPairLookUpUim       form            = null;
        String                              pageAction      = null;
        String                              errorMsg        = null;
        String                              forwardPage     = null;
        
        try{

            form        = this.getForm(actionForm, pageAction);
            forwardPage = this.getForwardPage(mapping, actionForm, form, request, response);
            
        } catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
            form.setErrorMsg(errorMsg);

            forwardPage = FAILURE;
        }
        return mapping.findForward(forwardPage);

    } //executeAction
    
     private EserviceUserPortPairLookUpUim getForm(ActionForm actionForm, String pageAction) throws Exception{
         EserviceUserPortPairLookUpUim form = null;
         try{
             form = (EserviceUserPortPairLookUpUim) actionForm;
             if (form == null){
                 form = new EserviceUserPortPairLookUpUim();
             }
//             form.resetForm();
             
         } catch(Exception ex){
             throw ex;
         }

         return form;
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

    public void populateComboData(EserviceUserPortPairLookUpUim objForm) {
        objForm.setColumnList(getColumnList());
        objForm.setSortByList(getColumnList());
        objForm.setOrderList(getComboBoxOrderBy());
        
    }
    
    private String lp_onloadPage() throws Exception {
        
        System.out.println("[EserviceUserPortPairLookUpSvc][lp_onloadPage][Begin]");
        
        EserviceUserPortPairLookUpDao                   objDao                  = null;
        String                                          userLoginId             = null;
        
        try {
        
            objDao              = (EserviceUserPortPairLookUpDao)getDao(DAO_BEAN_ID);
            userLoginId         = FormatUtil.nullToBlank(this.request.getParameter("userLoginId"));
            
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_onloadPage] userLoginId :: " + userLoginId);
            
            this.form.setUserLoginId(userLoginId);
            this.populateComboData(this.form);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_onloadPage][End]");
        }

        return SUCCESS;
    }

    public String lp_getdataList() throws Exception {
        System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList][Begin]");
        
        List                                    lstTableData        = null;
        int                                     intTotDBRec         = 0;
        int                                     intTotListRec       = 0;
        Map                                     result              = null;
        List<EserviceUserPortPairLookUpMod>     list                = null;
        EserviceUserPortPairLookUpDao           objDao              = null;
        String                                  forwardPage         = FAILURE;
        String                                  find                = null;
        String                                  column              = null;
        String                                  sortby              = null;
        String                                  order               = null;
        String                                  chkBoxWildCard      = null;
        String                                  userLoginId         = null;
        String                                  rowIndex            = null;
        
        try{
            objDao              = (EserviceUserPortPairLookUpDao)getDao(DAO_BEAN_ID);
            find                = this.request.getParameter("find");
            column              = this.request.getParameter("column");
            sortby              = this.request.getParameter("sortBy");
            order               = this.request.getParameter("order");
            userLoginId         = this.request.getParameter("userLoginId");
            rowIndex            = this.request.getParameter("rowIndex");
            chkBoxWildCard      = FormatUtil.chkNullForCheckBox(this.request.getParameter("chkBoxWildCard"));
            
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] find            :: " + find);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] column          :: " + column);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] sortby          :: " + sortby);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] order           :: " + order);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] userLoginId     :: " + userLoginId);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] rowIndex        :: " + rowIndex);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] chkBoxWildCard  :: " + chkBoxWildCard);
            
            if(find!=null)          this.form.setFind(find);
            if(column!=null)        this.form.setColumn(column);
            if(sortby!=null)        this.form.setSortBy(sortby);
            if(order!=null)         this.form.setOrder(order);
            if(userLoginId!=null)   this.form.setUserLoginId(userLoginId);
            if(rowIndex!=null)      this.form.setRowIndex(rowIndex);
            this.form.setChkBoxWildCard(chkBoxWildCard);
    
            result      = objDao.getUserPortPairList(this.form);
            list        = (List<EserviceUserPortPairLookUpMod>)result.get(EserviceUserPortPairLookUpDao.KEY_DATA);
            
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] list :: " + list);
    
            if (null != list) {
                intTotListRec   = (Integer)result.get(KEY_SIZE);
                intTotDBRec     = -1;
                lstTableData    = getTableDataNew(list, this.form.getCurrPageNo());
            }
            
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] CurrPageNo          :: " + this.form.getCurrPageNo());
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] lstTableData        :: " + lstTableData);
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList] lstTableData.size() :: " + lstTableData.size());
            
            if (null == lstTableData || lstTableData.size() == 0) {
                this.form.setTotRecord(0);
                this.form.setSearchResultsList(new ArrayList());
            } else {
                this.form.setSearchPerformed("true");
                this.form.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
                this.form.setSearchResultsList(lstTableData);
            }
    
            populateComboData(this.form);
            
            forwardPage = SUCCESS;
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceUserPortPairLookUpSvc][lp_getdataList][End]");
        }
        
        return forwardPage;
    }

    public List getComboBoxOrderBy()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EserviceUserPortPairLookUpDao.KEY_COLUMN_ORDER_ASC,  EserviceUserPortPairLookUpDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EserviceUserPortPairLookUpDao.KEY_COLUMN_ORDER_DESC, EserviceUserPortPairLookUpDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }
    
    public List getColumnList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("", "Select One..."));
        list.add(new ComboVO("a.FK_USER_ID"     , "User Id"));
        list.add(new ComboVO("t.USER_NAME"      , "User Name"));
        list.add(new ComboVO("t.COMPANY_NAME"   , "Company Name"));
        return list;
    }
    
    public List getSortByList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("a.FK_USER_ID"     , "User Id"));
        list.add(new ComboVO("t.USER_NAME"      , "User Name"));
        list.add(new ComboVO("t.COMPANY_NAME"   , "Company Name"));
        return list;
    }

}

/* * end of class * */

/* -----------------------------------------------------------------------------
System  : RCL-EZL
Module  : Common
Prog ID : ECM002 - EcmMasterLookupSvc.java
Name    : Master Lookup
Purpose : Action Bean for Master Lookup Screen
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Ankit       15/01/2011      <Initial version>
--Change Log--------------------------------------------------------------------
##  DD/MM/YY    –User-  -Task/CR No-    -Short Description-
01  07/10/14    Pratya  @01             PD_CR_20140826_ESV [Contract Party for registeration]
----------------------------------------------------------------------------- */


package com.rclgroup.dolphin.ezl.web.ecm.action;

import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.StringUtil;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.ezl.web.ecm.actionform.EcmMasterLookupUim;
import com.rclgroup.dolphin.ezl.web.ecm.dao.EcmMasterLookupDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/** 
 * Action Class Extends the BaseAction Class
 * @class EcmMasterLookupSvc
 * @author NTL) Ankit
 * @version v1.00 15/01/2011
 * @see
 */
public class EcmMasterLookupSvc extends BaseAction {


    /* JDBC Bean ID to be used to lookup DAO Instance */
    private static final String DAO_BEAN_ID = "masterLookupDAO";

    /*Parent ID in case of Service lookup*/
    private static final String MASTER_ID_SERVICE = "SERVICE";

    /*Parent ID in case of Service Group lookup*/
    private static final String MASTER_ID_SERVICE_GROUP = "SERVICE_GROUP";

    /*Parent ID in case of In Voyage lookup*/
    private static final String MASTER_ID_IN_VOYAGE = "IN_VOYAGE";

    /*Parent ID in case of In Voyage lookup*/
    private static final String MASTER_ID_OUT_VOYAGE = "OUT_VOYAGE";

    /*Parent ID in case of Vessel lookup*/
    private static final String MASTER_ID_VESSEL = "VESSEL";
    
    private static final String MASTER_ID_PARTNER_TERMINAL = "PARTNER_TERMINAL";

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
        Debug.log(" lookup action strAction=" + strAction);
        if (ONLOAD.equals(strAction)) {
            return onLoad(mapping, form, request);
        } else if (SEARCH.equals(strAction)) {
            return onSearch(mapping, form, request);
        }

        return mapping.findForward(SUCCESS);

    } //executeAction


    /**
     *
     * This function populates the Module combo box label and values at the load
     * time
     *
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward onLoad(ActionMapping mapping, ActionForm form, 
                                HttpServletRequest request) throws Exception {

        /* Action Errors Object to send Errors/Info to JSP */
        ActionErrors actionErrors = new ActionErrors();
        /* Parameter Map to the DAO for Search */
        Map mapParam = null;
        /* Total No of Records send from DAO-Refcursor */
        int intTotDBRec = 0;
        /* Total No of Records send from DAO-ResultSet List */
        int intTotListRec = 0;
        /* Original Result Set List from DAO */
        List lstTableDataOrg = null;
        /* Final Result Set List Created based on pagination */
        List lstTableData = null;

        /* Return Map for master config data from DAO */
        Map mapConfigReturn = null;

        /* Return Map for Result data from DAO */
        Map mapDataReturn = null;

        /* Cast to Action Form Bean */
        EcmMasterLookupUim objForm = (EcmMasterLookupUim)form;

        /* reset all search criteria fields & the table data to same as onload */
        objForm.resetFields();

        /* Get the DAO Instance */
        EcmMasterLookupDao objDao = (EcmMasterLookupDao)getDao(DAO_BEAN_ID);

        /* Get the pre-filled Map with search parameters */
        mapParam = createSearchParams(objForm, null);

        /* Call DAO Method to fetch master config */
        mapConfigReturn = objDao.getMasterConfig(mapParam);

        /* Set the Config Data to Form */
        objForm.setScreenTitle((String)mapConfigReturn.get(objDao.KEY_SCREEN_TITLE));
        objForm.setSectionTitle((String)mapConfigReturn.get(objDao.KEY_GRID_VIEW_TITLE));
        objForm.setFindInCode((String)mapConfigReturn.get(objDao.KEY_FIND_IN_CD));
        objForm.setFindInDesc((String)mapConfigReturn.get(objDao.KEY_FIND_IN_DESC));
        objForm.setSortByCode((String)mapConfigReturn.get(objDao.KEY_SORT_BY_CD));
        objForm.setSortByDesc((String)mapConfigReturn.get(objDao.KEY_SORT_BY_DESC));
        objForm.setNoOfColumn((String)mapConfigReturn.get(objDao.KEY_NO_OF_COLUMN));
        objForm.setColNames((String)mapConfigReturn.get(objDao.KEY_COLUMN_HEADER));
        objForm.setNoOfColumn((String)mapConfigReturn.get(objDao.KEY_NO_OF_COLUMN));
        objForm.setPreCriteria((String)mapConfigReturn.get(objDao.KEY_PRE_CRITERIA));
        
        /*Begin @01*/
        if(request.getParameter("prmRowIndex")!=null) objForm.setPrmRowIndex(request.getParameter("prmRowIndex"));
        /*End @01*/

        /* Set the values of all combo boxes to be populated */
        setComboData(objForm);

        if(objForm.getPrmMasterId().equals(MASTER_ID_PARTNER_TERMINAL)) {
            onSearch(mapping,form,request);
        }

        return mapping.findForward(SUCCESS);

    } // end of onLoad method


    /**
     * 
     * This function performs a search given the Module selected by the user
     * 
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward onSearch(ActionMapping mapping, ActionForm form, 
                                  HttpServletRequest request) throws Exception {

        /* Action Errors Object to send Errors/Info to JSP */
        ActionErrors actionErrors = new ActionErrors();
        /* Parameter Map to the DAO for Search */
        Map mapParam = null;
        /* Total No of Records send from DAO-Refcursor */
        int intTotDBRec = 0;
        /* Total No of Records send from DAO-ResultSet List */
        int intTotListRec = 0;
        /* Original Result Set List from DAO */
        List lstTableDataOrg = null;
        /* Final Result Set List Created based on pagination */
        List lstTableData = null;
        /* Return Map from DAO */
        Map mapDataReturn = null;

        /* Cast to Action Form Bean */
        EcmMasterLookupUim objForm = (EcmMasterLookupUim)form;

        /* Set the values of all combo boxes to be populated */
        setComboData(objForm);

        /* Get the DAO Instance */
        EcmMasterLookupDao objDao = (EcmMasterLookupDao)getDao(DAO_BEAN_ID);

        /* Get the pre-filled Map with search parameters with setting no of column*/
        mapParam = createSearchParams(objForm, null);


        /* Call DAO Method to fetch Search Result */
        mapDataReturn = objDao.getResultList(mapParam);

        /* Retrieve the Original Result of Search */
        lstTableDataOrg = (List)mapDataReturn.get(objDao.KEY_REF_RESULT_LIST);
        if (lstTableDataOrg != null) {
            /* Total No of Records of Original List */
            intTotListRec = lstTableDataOrg.size();
            /* Total No of Records from Ref Cursor */
            intTotDBRec = 
                    Integer.parseInt((String)mapDataReturn.get(KEY_TOT_REC_COUNT));
            /* Final Result for the screen - Require for Pagination screens */
            lstTableData = 
                    getTableData(lstTableDataOrg, objForm.getCurrPageNo());
        }

        /* Check if search result is empty */
        if (lstTableData == null || lstTableData.size() == 0) {
            objForm.setTotRecord(0);
            objForm.setValues(new ArrayList());
            //Show error if No Record Fetched
            actionErrors.add(APP_ERROR, new ActionError(GE0004));
            request.setAttribute(Globals.ERROR_KEY, actionErrors);
        } else {
            /*
          * Set the value in Form beans setter.
          * This Value (which is list) will
          * be used by the iterator tag of struts.
          */

            objForm.setSearchPerformed("true");
            objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
            objForm.setValues(lstTableData);
            //Show Imfromation about no of total record fetched
            actionErrors.add(APP_ERROR, 
                             new ActionError(GI0002, BLANK + objForm.getTotRecord()));
            request.setAttribute(Globals.ERROR_KEY, actionErrors);
        }

        return mapping.findForward(SUCCESS);

    } // end of onSearch method

    /**
     * createSearchParams : gets all search parameters and puts in a Map
     * @param ActionForm : EcmMasterlookupUim
     * @param String :astrUser
     * @return Map : screen search parameters 
     * @see
     */
    private Map createSearchParams(EcmMasterLookupUim aobjForm, 
                                   String astrUser) {

        /* Get the pre-filled Map with common parameters(sortBy, sortIn, recStatus & DocStatus) */
        Map mapParam = aobjForm.getFormParam();
        //In case of Service,Service Group,Vessel ,In Voyage Lookup set Master id ='SERVICE'
        if (aobjForm.getPrmMasterId().equals(MASTER_ID_SERVICE) || 
            aobjForm.getPrmMasterId().equals(MASTER_ID_SERVICE_GROUP) || 
            aobjForm.getPrmMasterId().equals(MASTER_ID_VESSEL) || 
            aobjForm.getPrmMasterId().equals(MASTER_ID_IN_VOYAGE) || 
            aobjForm.getPrmMasterId().equals(MASTER_ID_OUT_VOYAGE)) {
            mapParam.put(EcmMasterLookupDao.KEY_MASTER_ID, MASTER_ID_SERVICE);
        } else {
            mapParam.put(EcmMasterLookupDao.KEY_MASTER_ID, 
                         aobjForm.getPrmMasterId());
        }

        /* Get the search criteria values of the current screen & send to Next screen */
        //mapParam.put(EcmMasterLookupDao.KEY_MASTER_ID        , aobjForm.getPrmMasterId());
        mapParam.put(EcmMasterLookupDao.KEY_PRE_CRITERIA, 
                     aobjForm.getPrmValues());
        mapParam.put(KEY_FIND_VAL, aobjForm.getFindVal());
        mapParam.put(KEY_FIND_IN, aobjForm.getFindIn());
        mapParam.put(KEY_WILD_CARD, aobjForm.getWildCard());
        mapParam.put(KEY_SORT_BY, aobjForm.getSortBy());
        mapParam.put(KEY_SORT_IN, aobjForm.getSortIn());
        mapParam.put(KEY_REC_STATUS, aobjForm.getRecStatus());
        mapParam.put(KEY_CURR_PAGE_NO, aobjForm.getCurrPageNo());
        mapParam.put(EcmMasterLookupDao.KEY_ORDER_BY, aobjForm.getOrderBy());
        mapParam.put(EcmMasterLookupDao.KEY_ASC_DESC, aobjForm.getAscDesc());
        mapParam.put(EcmMasterLookupDao.KEY_NO_OF_COLUMN, 
                     aobjForm.getNoOfColumn());
        return mapParam;

    } // end of createSearchParams method

    /**
     * @return List - Sort By Combo Data
     */
    public List getDynComboValues(String codeValues, String descValues) {
        List llstComboData = new ArrayList();
        String[] strArrCode = StringUtil.extractTokens(codeValues, TILDE);
        String[] strArrDesc = StringUtil.extractTokens(descValues, TILDE);
        llstComboData.add(new ComboVO("", "Select One..."));
        for (int i = 0; i < strArrCode.length; i++)
            llstComboData.add(new ComboVO(strArrCode[i], strArrDesc[i]));

        return llstComboData;
    } // end of getDynComboValues method

    /**
     * @return List - Sort By Combo Data
     */
    public List getHeaderList(String headerValues) {
        List llstColumnHeader = new ArrayList();

        String[] colHeader = StringUtil.extractTokens(headerValues, TILDE);

        for (int i = 0; i < colHeader.length; i++)
            llstColumnHeader.add(colHeader[i]);

        return llstColumnHeader;
    } // end of getHeaderList method

    /**setComboData : Set the values of all combo boxes to be populated
     * @param ActionFormBean : VctMasterLookupUim
     */
    public void setComboData(EcmMasterLookupUim aobjForm) {
        /* Set the values of all combo boxes to be populated */
        aobjForm.setWildCardValues(getWildCardData());
        aobjForm.setSortInValues(getSortInData());
        aobjForm.setRecStatusValues(getRecStatusData());

        aobjForm.setFindInValues(getDynComboValues(aobjForm.getFindInCode(), 
                                                   aobjForm.getFindInDesc()));
        aobjForm.setSortByValues(getDynComboValues(aobjForm.getSortByCode(), 
                                                   aobjForm.getSortByDesc()));
        aobjForm.setColumnHeader(getHeaderList(aobjForm.getColNames()));
    } // end of setComboData method

}//end of class

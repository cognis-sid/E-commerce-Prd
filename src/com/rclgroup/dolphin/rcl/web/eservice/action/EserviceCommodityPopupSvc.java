package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceBookingNumberPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceCommodityPopupUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCommodityPopupDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityPopupMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceCommodityPopupSvc extends BaseAction {
    public static String DAO_BEAN_ID = "EserviceCommodityPopupDao";
    private static final String GET_LOOKUP_DATA = "lookUpData";


    public EserviceCommodityPopupSvc() {
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
        //
        //        EserviceCommodityPopupUim objForm = (EserviceCommodityPopupUim)form;
        //
        //        populateComboData(objForm);

        String strAction = mapping.getParameter();
        if (ONLOAD.equals(strAction)) {
//            return onLoad(mapping, form, request);
            return getLookupData(mapping, form, request);
        } else if (GET_LOOKUP_DATA.equals(strAction)) {
            return getLookupData(mapping, form, request);
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
    public ActionForward onLoad(ActionMapping mapping, ActionForm form, 
                                HttpServletRequest request) throws Exception {

        EserviceCommodityPopupUim objForm = (EserviceCommodityPopupUim)form;

        request.setAttribute("listLookupData", null);
//        request.setAttribute("commodityList", null);

        populateComboData(objForm);

        return mapping.findForward(SUCCESS);

    } // end of onLoad method

    public void populateComboData(EserviceCommodityPopupUim objForm) {
        objForm.setColumnList(getColumnList());
        objForm.setSortByList(getColumnList());
        objForm.setOrderList(getComboBoxOrderBy());
        
    }

    public List getBlankComboList() {
        List list = new ArrayList(0);
        list.add(0, new ComboVO("", SELECT_ONE));

        return list;
    }


    public ActionForward getLookupData(ActionMapping mapping, ActionForm form, 
                                       HttpServletRequest request) throws Exception {

        //------------------- varable declaration.
        List lstTableData = null;
        int intTotDBRec = 0;
        int intTotListRec = 0;
        Map mapParam = new HashMap();
        Map result = null;
        List list = null;
        EserviceCommodityPopupUim objForm = null;
        EserviceCommodityPopupDao objDao = null;

        //------------------- get object of form.
        objForm = (EserviceCommodityPopupUim)form;

        //------------------- get object of dao.
        objDao = (EserviceCommodityPopupDao)getDao(DAO_BEAN_ID);

        //------------------- 

        mapParam.put(KEY_CURR_PAGE_NO, objForm.getCurrPageNo());
        mapParam.put(KEY_USER_ID, getUserID(request));

        mapParam.put(EserviceCommodityPopupDao.KEY_CRITERIA_TEXT_FIND, 
                     objForm.getFind());
        mapParam.put(EserviceCommodityPopupDao.KEY_CRITERIA_COLUMN, 
                     objForm.getColumn());
        mapParam.put(EserviceCommodityPopupDao.KEY_CRITERIA_SORTBY, 
                     objForm.getSortBy());
        mapParam.put(EserviceCommodityPopupDao.KEY_CRITERIA_ORDER, 
                     objForm.getOrder());
        mapParam.put(EserviceCommodityPopupDao.KEY_CRITERIA_WILDCARD, 
                     objForm.getChkBoxWildCard());

        result = objDao.getList(mapParam);

        list = (List)result.get(EserviceCommodityPopupDao.KEY_DATA);

        if (null != list) {
            intTotListRec = (Integer)result.get(KEY_SIZE);
            intTotDBRec = -1;
            lstTableData = getTableData(list, objForm.getCurrPageNo());
        }

        if (null == lstTableData) {
            objForm.setTotRecord(0);
            objForm.setValues(new ArrayList());
        } else {
            objForm.setSearchPerformed("true");
            objForm.setTotRecord(getTotRec(intTotDBRec, intTotListRec));
            objForm.setValues(lstTableData);
        }

        populateComboData(objForm);

        request.setAttribute("listLookupData", objForm.getValues());

        return mapping.findForward(SUCCESS);
    }

    public List getComboBoxOrderBy()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_ORDER_ASC, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_ORDER_DESC, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }
    
    public List getColumnList()
    {
        List list = new ArrayList();
        list.add(new ComboVO("", "Select One..."));
//        list.add(new ComboVO("commodity_group_code", "Code"));
        list.add(new ComboVO("description", "Description"));
        return list;
    }
    
    public List getSortByList()
    {
        List list = new ArrayList();
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_ORDER_ASC, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_ORDER_ASC));
        list.add(new ComboVO(EserviceInquiryWebBookingDao.KEY_COLUMN_ORDER_DESC, EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_ORDER_DESC));
        return list;
    }

}

/* * end of class * */

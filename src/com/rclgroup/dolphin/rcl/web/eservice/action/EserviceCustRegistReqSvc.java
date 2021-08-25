/*
 -------------------------------------------------------------------------------------------------------------
 EserviceCustRegistReqSvc.java
 -------------------------------------------------------------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2007
 -------------------------------------------------------------------------------------------------------------
 Author Pratya Thanuchaisak 28/01/2014
 - Change Log ------------------------------------------------------------------------------------------------
 ## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
 -------------------------------------------------------------------------------------------------------------
 */
package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceCustRegistReqUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustRegistReqDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCustRegistReqMod;


public class EserviceCustRegistReqSvc extends BaseAction{
    private int TOT_REC_PER_PAGE = 50;
    private String getForwardPage(EserviceCustRegistReqUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction = null;
        String forwardPage = null;
        try{
            pageAction = form.getCurrPageAction();
            if("onload".equals(pageAction)){
                forwardPage = initCustoRegistReq(form, request);
            }
        } catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }

    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response){
        EserviceCustRegistReqUim form = null;

        String pageAction = null;
        String forwardPage = null;
        try{
            pageAction = getPageAction(mapping);

            form = getForm(actionForm, pageAction);
            form.setCurrPageAction(pageAction);

            forwardPage = getForwardPage(form, request, response);
        } catch(Exception ex){
            ex.printStackTrace();

            forwardPage = form.getPrevPageAction();
            if((forwardPage==null)||(BLANK.equals(forwardPage))){
                forwardPage = "initCustoRegistReq";
            }
        }
        return mapping.findForward(forwardPage);
    }

    public String initCustoRegistReq(EserviceCustRegistReqUim form, HttpServletRequest request) throws Exception{
        String errMsg = null;
        String fscCode = null;
        String forwardPage = SUCCESS;
        try{
            fscCode = getUserFsc(request);
            form.setFscCode(fscCode);

            forwardPage = lookUpCustomerRegisterRequest(form, request);
        } catch(Exception ex){
            errMsg = ex.getMessage();
            throw ex;
        } finally{
            form.setErrMsg(errMsg);
        }
        return forwardPage;
    }
    
    public String lookUpCustomerRegisterRequest(EserviceCustRegistReqUim form, HttpServletRequest request) throws Exception{
        EserviceCustRegistReqDao objDao = null;

        List<EserviceCustRegistReqMod> custRegistReqList = null;

        Map resultMap = null;

        String errMsg = null;
        String fscCode = null;
        String forwardPage = SUCCESS;
        
        int fromRecord = 0;
        int toRecord = 0;
        try{
            fscCode = getUserFsc(request);
            fromRecord = getFromRecord(form.getCurrPageNo());
            toRecord = getToRecord(form.getCurrPageNo());

            objDao = getDao();
            if(objDao!=null){
                resultMap = objDao.findCustRegistReq(fscCode);
            }
            if(resultMap!=null&&!resultMap.isEmpty()){
                if(resultMap.containsKey(EserviceCustRegistReqDao.P_O_V.LIST_CUST_REQ_DATA)){
                    custRegistReqList = (List<EserviceCustRegistReqMod>) resultMap.get(EserviceCustRegistReqDao.P_O_V.LIST_CUST_REQ_DATA);
                }
            }
        } catch(Exception ex){
            errMsg = ex.getMessage();
            throw ex;
        } finally{
            form.setCustRegistReqList(custRegistReqList);
            form.setErrMsg(errMsg);
            form.setFscCode(fscCode);
        }
        return forwardPage;
    }
    
    public int getFromRecord(int aintCurrPageNo){
        return ((aintCurrPageNo - 1) * this.TOT_REC_PER_PAGE);
    }
    
    public int getToRecord(int aintCurrPageNo){
        return (aintCurrPageNo * this.TOT_REC_PER_PAGE) - 1;
    }

    private EserviceCustRegistReqUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EserviceCustRegistReqUim form = null;
        try{
            form = (EserviceCustRegistReqUim) actionForm;
            if(form==null){
                form = new EserviceCustRegistReqUim();
            } else if("onload".equals(pageAction)){
                form.resetForm();
            }
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
            pageAction = BLANK;
        }

        return pageAction;
    }

    private EserviceCustRegistReqDao getDao() throws Exception{
        EserviceCustRegistReqDao dao = null;
        try{
            dao = (EserviceCustRegistReqDao) getDao(EserviceCustRegistReqDao.DAO_NAME);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }

    //    public static String DAO_BEAN_ID = "EserviceCustRegistReqDao";
    //
    //    private static final String CHANGE_COUNTRY_CODE = "changeCountryCode";
    //    private static final String SAVE_BOOKING_CODE = "saveBooking";
    //    private static final String GET_TEMPLATE_DATA = "templateData";
    //    private static final String DEL_EQ_SIZE_TYPE = "deleleEqSizeType";
    //    private static final String DEL_COMMODITY = "deleleCommodity";
    //    private static final String CHECK_QTN = "checkQuotation";
    //    private static final String GET_DATA_BT_QTN = "getQuotationData";
    //
    //    private static final String MSG_CHECK_QTN = "Selected quotation is invalid , pls choose another quotation";
    //
    //    private static final String CHECK_QTN_SIZE = "checkQuotationSize";
    //    private static final String SET_QUATATION_ROUTING_DATA = "setQuotationRoutingData";
    //
    //    public EserviceCustRegistReqSvc(){
    //    }
    //
    //    /**
    //     *
    //     * Called from Action Servlet
    //     *
    //     * @param mapping ActionMapping
    //     * @param form ActionForm
    //     * @param request HttpServletRequest
    //     * @param response HttpServletResponse
    //     * @return ActionForward
    //     * @throws Exception
    //     */
    //    public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    //
    //        String strAction = mapping.getParameter();
    //
    //        String forwardPage = SUCCESS;
    //
    //        if(ONLOAD.equals(strAction)){
    //            return onLoad(mapping, form, request);
    //        }
    //
    //        return mapping.findForward(forwardPage);
    //
    //    } //executeAction
    //    //@08 BEGIN
    //
    //    /**
    //     * This method called when screen loads
    //     * @param mapping
    //     * @param form
    //     * @param request
    //     * @return
    //     * @throws Exception
    //     */
    //    public ActionForward onLoad(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception{
    //
    //        EserviceCustRegistReqUim objForm = null;
    //
    //        Map mapParam = null;
    //
    //        String originCountry = null;
    //        try{
    //            objForm = (EserviceCustRegistReqUim) form;
    //
    //            mapParam = getOnloadData(objForm, request);
    //
    //        } catch(Exception ex){
    //            ex.printStackTrace();
    //        }
    //        return mapping.findForward(SUCCESS);
    //
    //    } // end of onLoad method
    //
    //    /**
    //     * Method to get data when screen loades.
    //     * 
    //     * @param aobjForm
    //     * @return
    //     * @throws Exception
    //     */
    //    private Map getOnloadData(EserviceCustRegistReqUim eserviceCustRegistReqUim, HttpServletRequest request) throws Exception{
    //
    //        String fscCode = null;
    //        EserviceCustRegistReqMod eserviceCustRegistReqMod = null;
    //        EserviceCustRegistReqMod eserviceCustRegistReqModFrm = null;
    //        EserviceCustRegistReqDao objDao = null;
    //        List listDb = new ArrayList<EserviceCustRegistReqMod>();
    //        Map mapParam = null;
    //
    //        try{
    //            fscCode = getUserFsc(request);
    //            objDao = (EserviceCustRegistReqDao) getDao(DAO_BEAN_ID);
    //            mapParam = new HashMap(0);
    //            System.out.println("fscCode :: "+fscCode);
    //            listDb = objDao.getCustRegistReq(fscCode);
    //
    //            if(eserviceCustRegistReqUim.getEserviceCustRegistReqList()==null){
    //                eserviceCustRegistReqUim.setEserviceCustRegistReqList(new ArrayList<EserviceCustRegistReqMod>());
    //            }
    //
    //            for(int i = 0; i<listDb.size(); i++){
    //                eserviceCustRegistReqMod = (EserviceCustRegistReqMod) listDb.get(i);
    //                eserviceCustRegistReqModFrm = new EserviceCustRegistReqMod();
    //
    //                eserviceCustRegistReqModFrm.setCountry(eserviceCustRegistReqMod.getCountry());
    //                eserviceCustRegistReqModFrm.setCity(eserviceCustRegistReqMod.getCity());
    //                eserviceCustRegistReqModFrm.setCompanyName(eserviceCustRegistReqMod.getCompanyName());
    //                eserviceCustRegistReqModFrm.setUserId(eserviceCustRegistReqMod.getUserId());
    //                eserviceCustRegistReqModFrm.setUserName(eserviceCustRegistReqMod.getUserName());
    //                eserviceCustRegistReqModFrm.setAddDateTime(eserviceCustRegistReqMod.getAddDateTime());
    //
    //                eserviceCustRegistReqUim.getEserviceCustRegistReqList().add(eserviceCustRegistReqModFrm);
    //            }
    //
    //            //              eserviceCustRegistReqUim.setCountry("1");
    //            //              eserviceCustRegistReqUim.setCity("2");
    //            //              eserviceCustRegistReqUim.setCompanyName("3");
    //            //              eserviceCustRegistReqUim.setUserName("Watcharee Choknakawaro");
    //            //              eserviceCustRegistReqUim.setAddDateTime("4");
    //            //              
    //            //              listDb.add(eserviceCustRegistReqUim);
    //            //              
    //            //              eserviceCustRegistReqUim.setCountry("Thailand ");
    //            //              eserviceCustRegistReqUim.setCity("Bangkok");
    //            //              eserviceCustRegistReqUim.setCompanyName("RCLAA Company");
    //            //              eserviceCustRegistReqUim.setUserName("Watcharee Choknakawaro");
    //            //              eserviceCustRegistReqUim.setAddDateTime("01/01/2014  11:10:00 AM");
    //
    //            //              listDb.add(eserviceCustRegistReqUim);
    //
    //            //              eserviceCustRegistReqUim.setEserviceCustRegistReqList(listDb);
    //
    //        } catch(Exception e){
    //            e.printStackTrace();
    //        } finally{
    //            request.getSession().setAttribute("eserviceCustRegistReqUim", eserviceCustRegistReqUim);
    //        }
    //
    //
    //        return mapParam;
    //    } // getOnloadData
}

 /* * end of class * */

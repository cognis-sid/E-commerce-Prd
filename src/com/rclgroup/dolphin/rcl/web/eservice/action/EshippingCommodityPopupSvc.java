 /*------------------------------------------------------
 EshippingCommodityPopupSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Yossawat Suntisukkasem 22/08/13
 - Change Log -------------------------------------------
 ## DD/MM/YY      –User-         -TaskRef-   -ShortDescription-
 ## 04/09/13      YOSSUN1        01          change field orderList to orderTypeList
 ------------------------------------------------------*/
 package com.rclgroup.dolphin.rcl.web.eservice.action;

 import com.niit.control.common.ComboVO;
 import com.niit.control.common.Debug;
 import com.niit.control.web.action.BaseAction;

 import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIConstants;
 import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIUtil;
 import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePortClassUim;
 import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingCommodityPopupUim;
 import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingCommodityPopupDao;
 import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityPopupMod;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;

 import java.math.BigDecimal;

 public class EshippingCommodityPopupSvc extends BaseAction {
     public EshippingCommodityPopupSvc() {
     }
     
     private String getForwardPage(EshippingCommodityPopupUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
         String pageAction = null;
         String forwardPage = FAILURE;
         try {
             pageAction = form.getCurrPageAction();
             if ("onload".equals(pageAction)){
                 forwardPage = initial(form, request);
             }else if("lookUpData".equals(pageAction)){
                 forwardPage = lookUpData(form, request);
             }
         } catch (Exception ex) {
             throw ex;
         }
         return forwardPage;
     }
     
     public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response){
         EshippingCommodityPopupUim form = null;
         
         String pageAction = null;
         String forwardPage = null;
         try {
             pageAction = getPageAction(mapping);
             
             form = getForm(actionForm, pageAction);
             form.setCurrPageAction(pageAction);
             
             forwardPage = getForwardPage(form, request, response);
         } catch (Exception ex) {
             ex.printStackTrace();

     //            forwardPage = form.getPrevPageAction();
     //            if ((forwardPage == null) || ("".equals(forwardPage))) {
                 forwardPage = FAILURE;
     //            }
         }

         return mapping.findForward(forwardPage);
     }
     
     private String initial(EshippingCommodityPopupUim form, HttpServletRequest request) throws Exception {
         EshippingCommodityPopupDao objDao = null;
         
         String commodityRowIndex = null;
         String commodityMode = null;
         String commodityValue = null;
         
         String forwardPage = SUCCESS;
         try{
             commodityRowIndex = request.getParameter("commodityRowIndex");
             commodityMode = request.getParameter("commodityMode");
             commodityMode = request.getParameter("commodityValue");
             
             Debug.logFramework("1.commodityRowIndex = "+commodityRowIndex+
             "\n2.commodityMode = "+commodityMode+"\n3.commodityValue = "+commodityValue);
             
             form.setCommodityRowIndex(commodityRowIndex);
         
             objDao = getDao();
             if(objDao != null){
                 if(form.getCommodityGroupList() == null || form.getCommodityGroupList().isEmpty() || form.getCommodityGroupList().size()==1){
                     form.setCommodityGroupList(ComboBoxESIUtil.getESIComboBox(null, objDao, ComboBoxESIConstants.COMBO_BOX_TYPE.COMMODITY));
                 }   
             }
 //            if(form.getSortByList() == null || form.getSortByList().isEmpty()){
 //                form.setSortByList(ComboBoxESIUtil.getCommodityDDList());
 //            }
 //            if(form.getOrderList() == null || form.getOrderList().isEmpty()){
 //                form.setOrderList(ComboBoxESIUtil.getOrderByDDList());
 //            }
             this.populateComboData(form);
             
             forwardPage = lookUpData(form, request);
         }catch(Exception ex){
             throw ex;
         }
         return forwardPage;
     }
     
     private String lookUpData(EshippingCommodityPopupUim form, HttpServletRequest request) throws Exception {
         System.out.println("[EshippingCommodityPopupSvc][lookUpData][Begin]");
         
         EshippingCommodityPopupDao          objDao                  = null;
         Map                                 paramsMap               = null;
         Map                                 resultMap               = null;
         List<EshippingCommodityPopupMod>    commodityList           = null;
         String                              commGroupCode           = null;
         String                              commCode                = null;
         String                              commDesc                = null;
         String                              sortBy                  = null;
         String                              orderBy                 = null;
         String                              searchPerformed         = "false";
         String                              forwardPage             = FAILURE;
         Integer                             keySize                 = null;
         int                                 intTotDBRec             = 0;
         int                                 intTotListRec           = 0;
         int                                 fromRecord              = 0;
         int                                 toRecord                = 0;
         int                                 totalRecord             = 0;
         String                              chkBoxWildCard          = null;
         
         try{
             fromRecord  = getFromRecord(form.getCurrPageNo());
             toRecord    = getToRecord(form.getCurrPageNo());
             
             if("true".equals(form.getDefaultSearch())){
                 
             } else {
                 
             }

             commGroupCode   = form.getCommodityGroup();
             commCode        = form.getCommodityCode();
             commDesc        = form.getCommodityDesc();
             sortBy          = form.getSortBy();
             orderBy         = form.getOrderBy();
             chkBoxWildCard  = request.getParameter("chkBoxWildCard")==null?"N":"Y";
             
             form.setChkBoxWildCard(chkBoxWildCard);
             
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] fromRecord     :: " + fromRecord);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] toRecord       :: " + toRecord);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] commGroupCode  :: " + commGroupCode);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] commCode       :: " + commCode);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] commDesc       :: " + commDesc);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] sortBy         :: " + sortBy);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] orderBy        :: " + orderBy);
             System.out.println("[EshippingCommodityPopupSvc][lookUpData] chkBoxWildCard :: " + chkBoxWildCard);
             
             paramsMap = new HashMap();
             paramsMap.put(KEY_CURR_PAGE_NO                                  , form.getCurrPageNo());
             paramsMap.put(KEY_CURR_PAGE_NO                                  , form.getCurrPageNo());
             paramsMap.put(KEY_USER_ID                                       , getUserID(request));
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.COMM_CODE        , commCode);
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.COMM_GROUP_CODE  , commGroupCode);
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.COMM_DESC        , commDesc);
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.SORT_BY          , sortBy);
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.ORDER_BY         , orderBy);
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.RECORD_START     , String.valueOf(fromRecord));
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.RECORD_END       , String.valueOf(toRecord));
             paramsMap.put(EshippingCommodityPopupDao.P_I_V.WILDCARD         , chkBoxWildCard);
             
             objDao = getDao();
             if(objDao != null){    
                 resultMap = objDao.getList(paramsMap);
                 if(resultMap != null && !resultMap.isEmpty()){
                     if(resultMap.containsKey(EshippingCommodityPopupDao.KEY_DATA)){
                         commodityList = (List<EshippingCommodityPopupMod>) resultMap.get(EshippingCommodityPopupDao.KEY_DATA);
                     }
                     if(resultMap.containsKey(KEY_SIZE)){
                         keySize =   (Integer) resultMap.get(KEY_SIZE);
                         intTotListRec = keySize.intValue();
                     }
                     
                     forwardPage = SUCCESS;
                 }
             }
         } catch(Exception ex){
             throw ex;
         } finally{
             if(commodityList != null && !commodityList.isEmpty()){
                 searchPerformed = "true";
                 intTotDBRec = -1;
                 totalRecord = getTotRec(intTotDBRec, intTotListRec);
             }else{
                 commodityList = new ArrayList<EshippingCommodityPopupMod>();
                 totalRecord = 0;
             }
             form.setSearchPerformed(searchPerformed);
             form.setTotRecord(totalRecord);
             form.setCommodityList(commodityList);
             
             request.setAttribute("listCommodity", commodityList);
             
             System.out.println("[EshippingCommodityPopupSvc][lookUpData][End]");
         }
         return forwardPage;
     }
     
     public int getFromRecord(int aintCurrPageNo){
         return ((aintCurrPageNo - 1) * this.TOT_REC_PER_PAGE) + 1;
     }
     
     public int getToRecord(int aintCurrPageNo){
         return (aintCurrPageNo * this.TOT_REC_PER_PAGE);
     }

     private EshippingCommodityPopupUim getForm(ActionForm actionForm, String pageAction) throws Exception {
         EshippingCommodityPopupUim form = null;
         try {
             form = (EshippingCommodityPopupUim) actionForm;
             if (form == null){
                 form = new EshippingCommodityPopupUim();
             }else if("onload".equals(pageAction)){
                 form.resetForm();
             }
         } catch (Exception ex) {
             throw ex;
         }

         return form;
     }

     private String getPageAction(ActionMapping mapping) throws Exception {
         String pageAction = null;
         try {
             pageAction = mapping.getParameter();
         } catch (Exception ex) {
             pageAction = "";
         }

         return pageAction;
     }

     private EshippingCommodityPopupDao getDao() throws Exception {
         EshippingCommodityPopupDao dao = null;
         try {
             dao = (EshippingCommodityPopupDao) getDao(EshippingCommodityPopupDao.DAO_NAME);
         } catch (Exception ex) {
             throw ex;
         }
         return dao;
     }
     
     public void populateComboData(EshippingCommodityPopupUim objForm) {
         objForm.setSortByList(getSortByList());
         objForm.setOrderList(getComboBoxOrderBy());
         
     }
     
     public List<ComboVO> getComboBoxOrderBy(){
         List<ComboVO> list = new ArrayList<ComboVO>();
         
         list.add(new ComboVO(EshippingCommodityPopupDao.KEY_COLUMN_ORDER_ASC,  EshippingCommodityPopupDao.KEY_COLUMN_SHOW_ORDER_ASC));
         list.add(new ComboVO(EshippingCommodityPopupDao.KEY_COLUMN_ORDER_DESC, EshippingCommodityPopupDao.KEY_COLUMN_SHOW_ORDER_DESC));
         
         return list;
     }
     
     public List<ComboVO> getSortByList()
     {
         List<ComboVO> list = new ArrayList<ComboVO>();
         
         list.add(new ComboVO(""  , "Select One..."));
         list.add(new ComboVO("COMM_CODE"        , "HS Code"));
         list.add(new ComboVO("COMM_DESC"        , "Commodity Description"));
         list.add(new ComboVO("COMM_GRP_DESC"    , "Commodity Group"));
         
         return list;
     }
 }

 /* * end of class * */

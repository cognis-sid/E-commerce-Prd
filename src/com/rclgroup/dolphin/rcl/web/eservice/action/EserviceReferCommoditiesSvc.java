/*
-------------------------------------------------------------------------------------------------------------
EserviceReferCommoditiesSvc.java
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;

import java.io.PrintWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceReferCommoditiesSvc extends BaseAction {
    private static final String SUBMIT              = "onSubmit";
    private static final String GET_DATA            = "getData";
    
    private HttpServletRequest          request;
    private HttpServletResponse         response;
    private EserviceNewWebBookingDao    newWebObjDao;
    private EserviceReferCommoditiesUim form = null;
        
    public EserviceReferCommoditiesSvc() {
        
    }

    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceReferCommoditiesUim form1, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction = null;
        String forwardPage = null;
        try{
            pageAction = form1.getCurrPageAction();
            
            this.request            = request;
            this.response           = response;
            this.newWebObjDao       = getDao();
            this.form               = form1;
        
            if (ONLOAD.equals(pageAction)) {             
                this.form.setUserId(getUserID(request));
                forwardPage = onLoad();
            }else if(SUBMIT.equals(pageAction)) {             
                forwardPage = onSubmit();
            }else if(GET_DATA.equals(pageAction)) {             
                forwardPage = onGetData();
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
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EserviceReferCommoditiesUim     form1           = null;
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

    private EserviceReferCommoditiesUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EserviceReferCommoditiesUim form1 = null;
        try{
            form1 = (EserviceReferCommoditiesUim) actionForm;
            if (form1 == null){
                form1 = new EserviceReferCommoditiesUim();
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
     * @param mapping
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public String onLoad() throws Exception {
        System.out.println("[EserviceReferCommoditiesSvc][onLoad][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      seqNo                           = null;
        String                      rowIndex                        = null;
        List<ComboVO>               refrModeList                    = null;
        
        try{        
            seqNo                       = this.request.getParameter("seqNo");
            rowIndex                    = this.request.getParameter("rowIndex");
            forwardPage                 = SUCCESS;
            refrModeList                = this.newWebObjDao.getRefrMode();
            
            this.form.setSeqNo(seqNo);
            this.form.setRowIndex(rowIndex);
            this.form.setRefrModeList(refrModeList);
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceReferCommoditiesSvc][onLoad][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
     /**
      * This method called when screen onSubmit
      * @param mapping
      * @param form
      * @param request
      * @return
      * @throws Exception
      */
     public String onSubmit() throws Exception {
         System.out.println("[EserviceReferCommoditiesSvc][onSubmit][Begin]");
         
         EserviceNewWebBookingUim       eserviceNewWebBookingUim        = null;
         String                         seqNo                           = null;
         List                           commodityVoDataList             = null;
         EserviceCommodityDetailsMod    commodityDetailsMod             =  null;
         String                         temperature                     = null;
         String                         ventilation                     = null;
         String                         remark                          = null;
         String                         humidity                        = null;
         String                         controlledAtmosphere            = null;
         String                         nitrogen                        = null;
         String                         oxygent                         = null;
         String                         co2                             = null;
         String                         refMode                         = null;
         String                         preCooled                       = null;
         EserviceReferCommoditiesUim    uim                             = null;
         String                         recordStatus                    = null;
         
         
         try{        
             eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
             seqNo                       = this.nullToSpace(this.request.getParameter("seqNo"));
             commodityVoDataList         = eserviceNewWebBookingUim.getCommodityVoDataList();
             uim                         = new EserviceReferCommoditiesUim();
             
             temperature                 = this.nullToSpace(this.request.getParameter("temperature")).replaceAll("\\,","");
             ventilation                 = this.nullToSpace(this.request.getParameter("ventilation")).replaceAll("\\,","");
             remark                      = this.nullToSpace(this.request.getParameter("remark"));
             humidity                    = this.nullToSpace(this.request.getParameter("humidity")).replaceAll("\\,","");
             controlledAtmosphere        = this.nullToSpaceForCheckbox(this.request.getParameter("controlledAtmosphere"));
             nitrogen                    = this.nullToSpace(this.request.getParameter("nitrogen")).replaceAll("\\,","");
             oxygent                     = this.nullToSpace(this.request.getParameter("oxygent")).replaceAll("\\,","");
             co2                         = this.nullToSpace(this.request.getParameter("co2")).replaceAll("\\,","");
             refMode                     = this.nullToSpace(this.request.getParameter("refMode"));
             preCooled                   = this.nullToSpaceForCheckbox(this.request.getParameter("preCooled"));
             
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] commodityVoDataList.size()::" + commodityVoDataList.size());
             
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] temperature::" + temperature);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] ventilation::" + ventilation);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] remark::" + remark);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] humidity::" + humidity);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] controlledAtmosphere::" + controlledAtmosphere);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] nitrogen::" + nitrogen);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] oxygent::" + oxygent);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] co2::" + co2);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] refMode::" + refMode);
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit] preCooled::" + preCooled);
             
             uim.setTemperature(temperature);
             uim.setVentilation(ventilation);
             uim.setRemark(remark);
             uim.setHumidity(humidity);
             uim.setControlledAtmosphere(controlledAtmosphere);
             uim.setNitrogen(nitrogen);
             uim.setOxygent(oxygent);
             uim.setCo2(co2);
             uim.setRefMode(refMode);
             uim.setPreCooled(preCooled);
             uim.setSeqNo(seqNo);
             
             for(int i=0;i<commodityVoDataList.size();i++){
                 commodityDetailsMod = (EserviceCommodityDetailsMod)commodityVoDataList.get(i);
                 
                 if(Integer.parseInt(seqNo)==commodityDetailsMod.getSeqNo()){
                     commodityDetailsMod.setEserviceReferCommoditiesUim(uim);
                     commodityDetailsMod.setRateTypeClassName(EserviceNewWebBookingDao.STYLE_GREEN);
                     commodityDetailsMod.setRateTypeFlag("Y");
                     
                     recordStatus = commodityDetailsMod.getRecordStatus();
                     if(recordStatus.equals("") || recordStatus.equals(EserviceNewWebBookingDao.SER_OPERATION)){
                         commodityDetailsMod.setRecordStatus(EserviceNewWebBookingDao.UPD_OPERATION);
                     }
                     
                     break;
                 }
             }
             this.writeMSG("OK");
             
         }catch(Exception e){
             e.printStackTrace();
             this.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceReferCommoditiesSvc][onSubmit][End]");
         }
         return null;

     }
     
     String nullToSpace(String av_obj){
         String lv_str = "";
         
         try{
             if(av_obj!=null){
                 lv_str = av_obj;
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         return lv_str;
     }
     
    String nullToSpaceForCheckbox(String av_obj){
        String lv_str = "N";
        
        try{
            if(av_obj!=null){
                lv_str = av_obj;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return lv_str;
    }
     
    /**
     * This method called when screen loads
     * @param mapping
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public String onGetData() throws Exception {
        System.out.println("[EserviceReferCommoditiesSvc][onGetData][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      seqNo                           = null;
        String                      rowIndex                        = null;
        String                      disBtn                          = null;
        List                        commodityVoDataList             = null;
        EserviceCommodityDetailsMod commodityDetailsMod             = null;
        EserviceNewWebBookingUim    eserviceNewWebBookingUim        = null;
        List<ComboVO>               refrModeList                    = null;
        EserviceReferCommoditiesUim eserviceReferCommoditiesUim     = null;
        
        
        try{
            eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
            commodityVoDataList         = eserviceNewWebBookingUim.getCommodityVoDataList();
            seqNo                       = this.request.getParameter("seqNo");
            rowIndex                    = this.request.getParameter("rowIndex");
            disBtn                      = this.request.getParameter("disBtn");
            forwardPage                 = SUCCESS;
            refrModeList                = this.newWebObjDao.getRefrMode();
            
            System.out.println("[EserviceReferCommoditiesSvc][onGetData] seqNo :: " + seqNo);
            System.out.println("[EserviceReferCommoditiesSvc][onGetData] rowIndex :: " + rowIndex);
            System.out.println("[EserviceReferCommoditiesSvc][onGetData] disBtn :: " + disBtn);
            
            for(int i=0;i<commodityVoDataList.size();i++){
                commodityDetailsMod             = (EserviceCommodityDetailsMod)commodityVoDataList.get(i);
                eserviceReferCommoditiesUim     = commodityDetailsMod.getEserviceReferCommoditiesUim();
                
                if(Integer.parseInt(seqNo)==commodityDetailsMod.getSeqNo()){
                    System.out.println("[EserviceReferCommoditiesSvc][onGetData] :: " + seqNo + " " + commodityDetailsMod.getSeqNo());

                    eserviceReferCommoditiesUim.setRefrModeList(refrModeList);
                    eserviceReferCommoditiesUim.setSeqNo(seqNo);
                    eserviceReferCommoditiesUim.setRowIndex(rowIndex);
                    
                    if(disBtn!=null && !disBtn.equals("")){
                        eserviceReferCommoditiesUim.setDisBtn(disBtn);
                    }
                    
//                    this.form                   = commodityDetailsMod.getEserviceReferCommoditiesUim();
                    this.request.getSession().setAttribute("feserv19", eserviceReferCommoditiesUim);
                    
                    break;
                }
            }
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceReferCommoditiesSvc][onGetData][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
     public String getUserFSC(String userId){
         
         Map paramsMap = null;
         Map resultMap = null;
         
         String userFSC = null;
         String errorMsg = null;
         try{
            paramsMap = new HashMap(0);
            paramsMap.put(KEY_USER_ID, userId);
            
            resultMap = this.newWebObjDao.getFSCDetails(paramsMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(resultMap != null && resultMap.containsKey(EserviceNewWebBookingDao.KEY_CODE)){
                userFSC = (String) resultMap.get(EserviceNewWebBookingDao.KEY_CODE);
            }
        }
        return userFSC;
     }
    
    private void writeMSG(String msg){
         PrintWriter            print                   = null;
         try{
            response.setContentType("text/html");
            print = response.getWriter();
            print.write(msg);
         }catch (Exception e) {
                e.printStackTrace();
         }
    }
}

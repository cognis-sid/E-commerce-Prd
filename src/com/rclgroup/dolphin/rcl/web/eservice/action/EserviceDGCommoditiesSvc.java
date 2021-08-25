/*
-------------------------------------------------------------------------------------------------------------
 EserviceDGCommoditiesSvc.java
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

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceDGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;

import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceDGCommoditiesSvc extends BaseAction {
    private static final String SUBMIT              = "onSubmit";
    private static final String GET_DATA            = "getData";
    private static final String VALIDIDATE_DG       = "validateDG";
    
    private HttpServletRequest          request;
    private HttpServletResponse         response;
    private EserviceNewWebBookingDao    newWebObjDao;
    private EserviceDGCommoditiesUim    form            = null;
        
    public EserviceDGCommoditiesSvc() {
        
    }

    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceDGCommoditiesUim form1, HttpServletRequest request, HttpServletResponse response) throws Exception{
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
            }else if(VALIDIDATE_DG.equals(pageAction)) {             
                forwardPage = validateDG();
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
        EserviceDGCommoditiesUim        form1           = null;
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

    private EserviceDGCommoditiesUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EserviceDGCommoditiesUim form1 = null;
        try{
            form1 = (EserviceDGCommoditiesUim) actionForm;
            if (form1 == null){
                form1 = new EserviceDGCommoditiesUim();
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
        System.out.println("[EserviceDGCommoditiesSvc][onLoad][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      seqNo                           = null;
        String                      rowIndex                        = null;
        List<ComboVO>               unitMeasurementComboList        = null;
        
        try{        
            seqNo                       = this.request.getParameter("seqNo");
            rowIndex                    = this.request.getParameter("rowIndex");
            forwardPage                 = SUCCESS;
            unitMeasurementComboList    = this.newWebObjDao.getUnitMeasurementCombo();
            
            this.form.setSeqNo(seqNo);
            this.form.setRowIndex(rowIndex);
            this.form.setUnitMeasurementComboList(unitMeasurementComboList);
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceDGCommoditiesSvc][onLoad][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
     /**
      * This method called when screen onSubmit
      * @return
      * @throws Exception
      */
     public String onSubmit() throws Exception {
         System.out.println("[EserviceDGCommoditiesSvc][onSubmit][Begin]");
         
         EserviceNewWebBookingUim       eserviceNewWebBookingUim        = null;
         String                         seqNo                           = null;
         List                           commodityVoDataList             = null;
         EserviceCommodityDetailsMod    commodityDetailsMod             =  null;
         String                         flashPoint                      = null;
         String                         unitMeasurement                 = null;
         String                         unNo                            = null;
         String                         variant                         = null;
         String                         imdgClass                       = null;
         String                         portClass                       = null;
         String                         residue                         = null;
         String                         fumigration                     = null;
         EserviceDGCommoditiesUim       uim                             = null;
         String                         recordStatus                    = null;
         
         
         try{        
             eserviceNewWebBookingUim       = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
             seqNo                          = this.nullToSpace(this.request.getParameter("seqNo"));
             commodityVoDataList            = eserviceNewWebBookingUim.getCommodityVoDataList();
             uim                            = new EserviceDGCommoditiesUim();
             
             flashPoint                     = this.nullToSpace(this.request.getParameter("flashPoint")).replaceAll("\\,","");
             unitMeasurement                = this.nullToSpace(this.request.getParameter("unitMeasurement"));
             unNo                           = this.nullToSpace(this.request.getParameter("unNo"));
             variant                        = this.nullToSpace(this.request.getParameter("variant"));
             imdgClass                      = this.nullToSpace(this.request.getParameter("imdgClass"));
             portClass                      = this.nullToSpace(this.request.getParameter("portClass"));
             residue                        = this.nullToSpaceForCheckbox(this.request.getParameter("residue"));
             fumigration                    = this.nullToSpaceForCheckbox(this.request.getParameter("fumigration"));
             
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] commodityVoDataList.size()::" + commodityVoDataList.size());
             
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] flashPoint::"                 + flashPoint);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] unitMeasurement::"            + unitMeasurement);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] unNo::"                       + unNo);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] variant::"                    + variant);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] imdgClass::"                  + imdgClass);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] portClass::"                  + portClass);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] residue::"                    + residue);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] fumigration::"                + fumigration);
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit] seqNo::"                      + seqNo);
             
             uim.setFlashPoint(flashPoint);
             uim.setUnitMeasurement(unitMeasurement);
             uim.setUnNo(unNo);
             uim.setVariant(variant);
             uim.setImdgClass(imdgClass);
             uim.setPortClass(portClass);
             uim.setResidue(residue);
             uim.setFumigration(fumigration);
             uim.setSeqNo(seqNo);
             
             uim.setUnNoDis(unNo);
             uim.setVariantDis(variant);
             uim.setImdgClassDis(imdgClass);
             
             for(int i=0;i<commodityVoDataList.size();i++){
                 commodityDetailsMod = (EserviceCommodityDetailsMod)commodityVoDataList.get(i);
                 
                 if(Integer.parseInt(seqNo)==commodityDetailsMod.getSeqNo()){
                     commodityDetailsMod.setEserviceDGCommoditiesUim(uim);
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
             System.out.println("[EserviceDGCommoditiesSvc][onSubmit][End]");
         }
         return null;

     }
     
     private String validateDG(){
         System.out.println("[EserviceDGCommoditiesSvc][validateDG][Begin]");
         
         EserviceNewWebBookingDao   dao         = null;
         String                     errMsg      = null;
         
         try{
             dao        = this.getDao();
             errMsg     = dao.validateDG(this.form);
             
             System.out.println("[EserviceDGCommoditiesSvc][validateDG] errMsg :: " + errMsg);
             
             if(errMsg!=null && !errMsg.equals(""))throw new CustomDataAccessException(errMsg);
             
             this.writeMSG("OK");
             
         }catch(CustomDataAccessException e){
             this.writeMSG("ERROR::" + e.getMessage());
         }catch(Exception e){
            e.printStackTrace();
         }finally{
             System.out.println("[EserviceDGCommoditiesSvc][validateDG][End]");
         }
         return null;
     }
     
     private String nullToSpace(String av_obj){
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
     
    private String nullToSpaceForCheckbox(String av_obj){
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
     * @return
     * @throws Exception
     */
    public String onGetData() throws Exception {
        System.out.println("[EserviceDGCommoditiesSvc][onGetData][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      seqNo                           = null;
        String                      rowIndex                        = null;
        List                        commodityVoDataList             = null;
        EserviceCommodityDetailsMod commodityDetailsMod             = null;
        EserviceNewWebBookingUim    eserviceNewWebBookingUim        = null;
        List<ComboVO>               unitMeasurementComboList        = null;
        String                      disBtn                          = null;
        
        
        try{
            eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
            commodityVoDataList         = eserviceNewWebBookingUim.getCommodityVoDataList();
            seqNo                       = this.request.getParameter("seqNo");
            rowIndex                    = this.request.getParameter("rowIndex");
            disBtn                      = this.request.getParameter("disBtn");
            forwardPage                 = SUCCESS;
            unitMeasurementComboList    = this.newWebObjDao.getUnitMeasurementCombo();
            
            for(int i=0;i<commodityVoDataList.size();i++){
                commodityDetailsMod = (EserviceCommodityDetailsMod)commodityVoDataList.get(i);
                
                if(Integer.parseInt(seqNo)==commodityDetailsMod.getSeqNo()){
                    commodityDetailsMod.getEserviceDGCommoditiesUim().setUnitMeasurementComboList(unitMeasurementComboList);
                    commodityDetailsMod.getEserviceDGCommoditiesUim().setSeqNo(seqNo);
                    commodityDetailsMod.getEserviceDGCommoditiesUim().setRowIndex(rowIndex);
                    
                    if(disBtn!=null && !disBtn.equals("")){
                        commodityDetailsMod.getEserviceDGCommoditiesUim().setDisBtn(disBtn);
                    }
                    
                    this.request.getSession().setAttribute("feserv20", commodityDetailsMod.getEserviceDGCommoditiesUim());
                    
                    break;
                }
            }
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceDGCommoditiesSvc][onGetData][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
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

/*
-------------------------------------------------------------------------------------------------------------
 EserviceOOGCommoditiesSvc.java
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceOOGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EserviceOOGCommoditiesSvc extends BaseAction {
    private static final String SUBMIT              = "onSubmit";
    private static final String GET_DATA            = "getData";
    
    private HttpServletRequest          request;
    private HttpServletResponse         response;
    private EserviceNewWebBookingDao    newWebObjDao;
    private EserviceOOGCommoditiesUim   form = null;
        
    public EserviceOOGCommoditiesSvc() {
        
    }

    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceOOGCommoditiesUim form1, HttpServletRequest request, HttpServletResponse response) throws Exception{
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
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EserviceOOGCommoditiesUim       form1           = null;
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

    private EserviceOOGCommoditiesUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EserviceOOGCommoditiesUim form1 = null;
        try{
            form1 = (EserviceOOGCommoditiesUim) actionForm;
            if (form1 == null){
                form1 = new EserviceOOGCommoditiesUim();
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
        System.out.println("[EserviceOOGCommoditiesSvc][onLoad][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      seqNo                           = null;
        String                      rowIndex                        = null;
        
        try{        
            seqNo                       = this.request.getParameter("seqNo");
            rowIndex                    = this.request.getParameter("rowIndex");
            forwardPage                 = SUCCESS;
            
            this.form.setSeqNo(seqNo);
            this.form.setRowIndex(rowIndex);
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceOOGCommoditiesSvc][onLoad][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
     /**
      * This method called when screen onSubmit
      * @return
      * @throws Exception
      */
     public String onSubmit() throws Exception {
         System.out.println("[EserviceOOGCommoditiesSvc][onSubmit][Begin]");
         
         EserviceNewWebBookingUim       eserviceNewWebBookingUim        = null;
         String                         seqNo                           = null;
         List                           commodityVoDataList             = null;
         EserviceCommodityDetailsMod    commodityDetailsMod             =  null;
         String                         length                          = null;
         String                         width                           = null;
         String                         height                          = null;
         String                         diameter                        = null;
         EserviceOOGCommoditiesUim      uim                             = null;
         String                         recordStatus                    = null;
         
         
         try{        
             eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
             seqNo                       = this.nullToSpace(this.request.getParameter("seqNo"));
             commodityVoDataList         = eserviceNewWebBookingUim.getCommodityVoDataList();
             uim                         = new EserviceOOGCommoditiesUim();
             
             length                      = this.nullToSpace(this.request.getParameter("txtLength")).replaceAll("\\,","");
             width                       = this.nullToSpace(this.request.getParameter("txtWidth")).replaceAll("\\,","");
             height                      = this.nullToSpace(this.request.getParameter("txtHeight")).replaceAll("\\,","");
             diameter                    = this.nullToSpace(this.request.getParameter("txtDiameter")).replaceAll("\\,","");
             
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit] commodityVoDataList.size()::"    + commodityVoDataList.size());
             
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit] seqNo::"                         + seqNo);
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit] length::"                        + length);
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit] width::"                         + width);
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit] height::"                        + height);
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit] diameter::"                      + diameter);
             
             uim.setTxtLength(length);
             uim.setTxtWidth(width);
             uim.setTxtHeight(height);
             uim.setTxtDiameter(diameter);
             uim.setSeqNo(seqNo);
             
             for(int i=0;i<commodityVoDataList.size();i++){
                 commodityDetailsMod = (EserviceCommodityDetailsMod)commodityVoDataList.get(i);
                 
                 if(Integer.parseInt(seqNo)==commodityDetailsMod.getSeqNo()){
                     commodityDetailsMod.setEserviceOOGCommoditiesUim(uim);
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
             System.out.println("[EserviceOOGCommoditiesSvc][onSubmit][End]");
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
     * @return
     * @throws Exception
     */
    public String onGetData() throws Exception {
        System.out.println("[EserviceOOGCommoditiesSvc][onGetData][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      seqNo                           = null;
        String                      rowIndex                        = null;
        List                        commodityVoDataList             = null;
        EserviceCommodityDetailsMod commodityDetailsMod             = null;
        EserviceNewWebBookingUim    eserviceNewWebBookingUim        = null;
        String                      disBtn                          = null;
        
        
        try{
            eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
            commodityVoDataList         = eserviceNewWebBookingUim.getCommodityVoDataList();
            seqNo                       = this.request.getParameter("seqNo");
            rowIndex                    = this.request.getParameter("rowIndex");
            disBtn                      = this.request.getParameter("disBtn");
            forwardPage                 = SUCCESS;
            
            for(int i=0;i<commodityVoDataList.size();i++){
                commodityDetailsMod = (EserviceCommodityDetailsMod)commodityVoDataList.get(i);
                
                if(Integer.parseInt(seqNo)==commodityDetailsMod.getSeqNo()){
                    System.out.println("[EserviceOOGCommoditiesSvc][onGetData] :: " + seqNo + " " + commodityDetailsMod.getSeqNo());
                    commodityDetailsMod.getEserviceOOGCommoditiesUim().setSeqNo(seqNo);
                    commodityDetailsMod.getEserviceOOGCommoditiesUim().setRowIndex(rowIndex);
                    
                    if(disBtn!=null && !disBtn.equals("")){
                        commodityDetailsMod.getEserviceOOGCommoditiesUim().setDisBtn(disBtn);
                    }
                    
                    this.request.getSession().setAttribute("feserv21", commodityDetailsMod.getEserviceOOGCommoditiesUim());
                    
                    break;
                }
            }
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceOOGCommoditiesSvc][onGetData][End]");

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

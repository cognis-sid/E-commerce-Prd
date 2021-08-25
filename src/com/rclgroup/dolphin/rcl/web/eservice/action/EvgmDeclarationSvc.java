package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EvgmDeclarationUim;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EvgmDeclarationDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationErrorMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationDetailMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationHeaderMod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;

import com.rclgroup.dolphin.rcl.web.util.ExcelField;
import com.rclgroup.dolphin.rcl.web.util.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.poi.ss.usermodel.*;

import java.util.Map;
import java.util.HashMap;

import java.util.Iterator;

import java.util.List;

import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.upload.FormFile;

import org.apache.poi.ss.usermodel.Workbook;

public class EvgmDeclarationSvc extends BaseAction{

    private static final String CHANGE_CREATE         = "changeCreate";
    private static final String CREATE_EXCEL_TEMPLATE         = "createExcelTemplate";
    private static final String UPLOAD_EXCEL        = "uploadExcel";
    private static final String FIND_DETAIL        = "findDetail";
    private static final String PAGINATION        = "paging";
    private static final String SAVE_VGM        = "save";
    private static final String VALIDATE_DETAIL        = "validateDetail";
    private static final String DEL        = "delete";
    
    private HttpServletRequest  request;
    private FormatUtil          formatUtil                  = null;

    public EvgmDeclarationSvc() {

    }
    
    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EvgmDeclarationUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction = null;
        String forwardPage = null;
        try{
            pageAction = form.getCurrPageAction();
            this.request        = request;
            this.formatUtil     = new FormatUtil(request, response);
            System.out.println("pageAction >>>>>>>>>>>>>>>>>>>>>>>>>> "+pageAction);
            
//            System.out.println("form.getEmpCode() 1 >>>>>>>>>>>>>> "+getEmpCode(request));
//            System.out.println("form.getEmpName() 1 >>>>>>>>>>>>>> "+getEmpName(request));
//            System.out.println("form.getAuthorizePerson() 1 >>>>>>>>>>>>>> "+form.getAuthorizePerson());
        if (ONLOAD.equals(pageAction)) {
            
            forwardPage = onLoad(form, request);
        }else if (CHANGE_CREATE.equals(pageAction)) {
            forwardPage = changeAction(form, request);
        }else if (CREATE_EXCEL_TEMPLATE.equals(pageAction)){
            forwardPage = createExcelTemplate(form, request,response);
        }else if (UPLOAD_EXCEL.equals(pageAction)){
            forwardPage = uploadExcel(form, request,response);
        }else if (FIND_DETAIL.equals(pageAction)){
            form.setCurrPageNo(1);
            form.setPagePrevNo(1);
            forwardPage = findDetail(form, request,response);
        }else if (PAGINATION.equals(pageAction)){
            forwardPage = gotoPaging(form, request,response);
        }else if (SAVE_VGM.equals(pageAction)){
            forwardPage = save(form, request,response);
        }else if (VALIDATE_DETAIL.equals(pageAction)){
            forwardPage = validateDetail(form, request,response);
        }else if (DEL.equals(pageAction)){
            forwardPage = deleteDetail(form, request,response);
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
     * @param actionForm ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EvgmDeclarationUim form = null;

        String pageAction = null;
        String errorMsg = null;
        String forwardPage = null;
        try{
            pageAction = getPageAction(mapping);
//System.out.println("pageAction 2 >>>>>>>>>>>>>>>>>>>>>>>>>>"+pageAction);
            form = getForm(actionForm, pageAction);
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
    
    public String validateDetail(EvgmDeclarationUim form, HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][validateDetail][Begin]");
        
        String msg = "OK";
        try{
            if(form.getSelectAction().equals("1")){
            
                if(form.getVgmDetailList() != null && form.getVgmDetailList().size() > 0){
                
                populateDetailData(form,request);
    //            System.out.println("form.getVgmDetailList() : "+form.getVgmDetailList().size());
                for(int i = 0; i < form.getVgmDetailList().size() ; i++){
                    EvgmDeclarationDetailMod mod = (EvgmDeclarationDetailMod)form.getVgmDetailList().get(i);
                    
                    if(mod.getContainer().equals("")){
                        msg = "Container# is mandatory.";
                        form.setErrMsg(msg);
                        break;
                    }
                    
                    if(mod.getVerGrossMass().equals("")){
                        msg = "Verified Gross Mass (KGS) is mandatory.";
                        form.setErrMsg(msg);
                        break;
                    }else{
                        if(Double.parseDouble(mod.getVerGrossMass().replaceAll(",","")) <= 0){
                            msg = "Verified Gross Mass (KGS) must be greater than 0.";
                            form.setErrMsg(msg);
                            break;
                        }
                    }
                    
    //                if(!mod.getGrossCargo().equals("")){
    //                    if(Integer.parseInt(mod.getGrossCargo()) < 0){
    //                        msg = "Gross Cargo Weight (KGS) must be greater than 0.";
    //                        break;
    //                    }
    //                }
                }
                
                }else{
                    msg = "At lease 1 Container should be in VGM Declaration Detail.";
                    form.setErrMsg(msg);
                }
            }
            
//            System.out.println("msg >>>>>>>>>>>>>>>>>> "+msg);
            this.formatUtil.writeMSG(msg);
            
        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }
        
        System.out.println("[EvgmDeclarationSvc][validateDetail][End]");
        return null;
    }
    
    public String deleteDetail_1(EvgmDeclarationUim form, HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][deleteDetail][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        
        EvgmDeclarationDao    objDao          = null;
        List newList = new ArrayList();
        try{
        
            objDao          = getDao();
            
            populateDetailData(form,request);
            
            String seq = form.getDelItem();
            
            List vgmList = form.getVgmDetailList();
            
            for(int i = 0; i < vgmList.size() ; i++){
                EvgmDeclarationDetailMod mod = (EvgmDeclarationDetailMod)vgmList.get(i);
                
                if(mod.getSelDelete().equals("Y")){
                    if(!mod.getRecordStatus().equals("")){
                        objDao.deleteContainer(mod.getDtlSeq(),form.getHdrSeq(),mod.getContainer());
                    }
                }else{
                    newList.add(mod);
                }
            }
            
            if(newList != null && newList.size() > 0){
                
                form.setSearchPerformed("true");
                form.setTotRecord(getTotRec(-1, newList.size()));
                List customerList    = getTableDataNew(newList, form.getCurrPageNo());
                
                if(customerList.size() == 0){
                    customerList    = getTableDataNew(newList, form.getCurrPageNo()-1);
                    form.setCurrPageNo(form.getCurrPageNo()-1);
                    form.setPagePrevNo(form.getCurrPageNo());
                }
                form.setVgmDetailList(newList);
                form.setDisplayDetailList(customerList);
                
            }else{
                form.setErrMsg("At lease 1 Container should be in VGM Declaration Detail.");
            }
            
            
            request.getSession().setAttribute("evgmDeclarationUim",form);
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationSvc][deleteDetail][End]");
        }
        return forwardPage;
    }   
    
    public String deleteDetail(EvgmDeclarationUim form, HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][deleteDetail][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        
        EvgmDeclarationDao    objDao          = null;
        
        String allSuccess = "N";
        
        try{
        
            objDao          = getDao();
            
            populateDetailData(form,request);
            
            String seq = form.getDelItem();
//            System.out.println("seq >>>>>>>>>>>>>>>>>.. "+seq);
            EvgmDeclarationDetailMod mod = (EvgmDeclarationDetailMod)form.getVgmDetailList().get(Integer.parseInt(seq));
            
            
            if(form.getVgmDetailList().size() > 1){
                if(mod.getRecordStatus().equals("")){
                    form.getVgmDetailList().remove(Integer.parseInt(seq));
    //                form.setVgmDetailList(detailList);
                    
                }else{
                    objDao.deleteContainer(mod.getDtlSeq(),form.getHdrSeq(),mod.getContainer());
                    form.getVgmDetailList().remove(Integer.parseInt(seq));
    //                System.out.println("DELETE SUCCESS");
//                    findDetailData(form,request,objDao);
                }
                
                 form.setSearchPerformed("true");
                 form.setTotRecord(getTotRec(-1, form.getVgmDetailList().size()));
                 List customerList    = getTableDataNew(form.getVgmDetailList(), form.getCurrPageNo());
                 
                 //                    System.out.println("form.getCurrPageNo()  >>>>>>>>>>>>>>>. "+form.getCurrPageNo());
                  
                  for(int i = 0; i < form.getVgmDetailList().size() ; i++){
                      EvgmDeclarationDetailMod detailMod = (EvgmDeclarationDetailMod)form.getVgmDetailList().get(i);
                      if(detailMod.getVgmStatus().equals("S")){
                          allSuccess = "Y";
                          
                      }else{
                          allSuccess = "N";
                          break;
                      }
                  }
                 
                 if(customerList.size() == 0){
                     customerList    = getTableDataNew(form.getVgmDetailList(), form.getCurrPageNo()-1);
                     form.setCurrPageNo(form.getCurrPageNo()-1);
                     form.setPagePrevNo(form.getCurrPageNo());
                 }
                 
                 form.setDisplayDetailList(customerList);
            }else{
                form.setErrMsg("At lease 1 Container should be in VGM Declaration Detail.");
            }
            
            
            
            request.getSession().setAttribute("evgmDeclarationUim",form);
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            form.setAllSuccess(allSuccess);
            System.out.println("[EvgmDeclarationSvc][deleteDetail][End]");
        }
        return forwardPage;
    }   
            
    
    public String save(EvgmDeclarationUim form, HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][save][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        
        EvgmDeclarationDao    objDao          = null;
        
        String msgError = "";
        
        try{
            if(form.getSelectAction().equals("1")){
                populateDetailData(form,request);
            }
            
            objDao          = getDao();
            String pkHdrSeq = "";
            if(form.getHdrSeq().equals("")){
                pkHdrSeq = objDao.insertVGMHdr(form.getBookingNo(),form.getShipperName(),form.getRespresentName(),form.getAuthorizePerson(),form.getUserId());
                form.setHdrSeq(pkHdrSeq);
            }
            
            String checkEnotice = "";
            
            for(int i = 0; i < form.getVgmDetailList().size() ; i++){
                EvgmDeclarationDetailMod mod = (EvgmDeclarationDetailMod)form.getVgmDetailList().get(i);
                
                if(mod.getRecordStatus().equals("")){
                    objDao.insertVGMDtl(mod,form.getUserId(),form.getHdrSeq());
                    checkEnotice = "Y";
                }else{
                    if(!mod.getVgmStatus().equals("S")){
                        objDao.updateVGMDtl(mod,form.getUserId(),form.getHdrSeq());
                        checkEnotice = "Y";
                    }
                }
            }
            
            
            if(checkEnotice.equals("Y")){
                msgError = objDao.submitEnotice(form.getBookingNo(),form.getUserId());
            }
            
            
            findDetailData(form,request,objDao);
            
            if(!msgError.equals("")){
                form.setErrMsg(msgError);
            }
            
            form.setSelectAction("1");
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
            
            msgError = ex.getMessage();
            
            form.setErrMsg(msgError);
        }finally{
        
            request.getSession().setAttribute("evgmDeclarationUim",form);
            
            forwardPage = SUCCESS;
            System.out.println("[EvgmDeclarationSvc][save][End]");
        }
            return forwardPage;
    }
    
    public String gotoPaging(EvgmDeclarationUim form, HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][gotoPaging][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;

        try{
//        System.out.println("getCurrPageNo >>>>>>>>>>>>>>>>>>>>>>>>>> :"+form.getCurrPageNo());
//            List detailList = new ArrayList();
            List customerList = new ArrayList();
            
//            for(int i = 0 ; i < 20 ; i++){
//                EvgmDeclarationMod mod = new EvgmDeclarationMod();
//                mod.setContainer(""+i);
//                detailList.add(mod);
//            }
            
            populateDetailData(form,request);
            
            
            form.setSearchPerformed("true");
//            form.setTotRecord(getTotRec(-1, 20));
            customerList    = getTableDataNew(form.getVgmDetailList(), form.getCurrPageNo());
            form.setDisplayDetailList(customerList);
//            System.out.println("TotRecord >>>>>>>>>> "+form.getTotRecord());
//            System.out.println("customerList   >>>>>>>>>>>> "+customerList.size());
//            System.out.println("detailList   >>>>>>>>>>>> "+form.getVgmDetailList().size());
//            form.setVgmDetailList(detailList);
            form.setPagePrevNo(form.getCurrPageNo());
            request.getSession().setAttribute("evgmDeclarationUim",form);
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationSvc][gotoPaging][End]");
        }
        return forwardPage;
        
    }
    
    private void populateDetailData(EvgmDeclarationUim form, HttpServletRequest request){
        System.out.println("[EvgmDeclarationSvc][populateDetailData][Begin]");
        int prevPage = form.getPagePrevNo();
//        System.out.println("form.getPagePrevNo() >>>>>>>>>>>>>> "+form.getPagePrevNo());
        
        int runNo = ((prevPage * 10)-10);
//        System.out.println("runNo >>>>>>>>>>>>>>>>>>>>. "+runNo);
        String[] method = this.request.getParameterValues("weightMethod");
        String[] vgm = this.request.getParameterValues("verGrossMass");
        String[] grossCargo = this.request.getParameterValues("grossCargo");
        String[] tareWeight = this.request.getParameterValues("tareWeight");
//        System.out.println("method >>>>>>>>>>>>>>>>>>>>. "+method.length);
        for(int i = 0 ; i < method.length ; i++){
        //                String container            = FormatUtil.nullToBlank((this.request.getParameter("container"+(runNo+i))));
//            System.out.println("method "+i+" :"+method[i]);
            
            ((EvgmDeclarationDetailMod)form.getVgmDetailList().get(runNo+i)).setWeightMethod(method[i]);
            ((EvgmDeclarationDetailMod)form.getVgmDetailList().get(runNo+i)).setVerGrossMass(vgm[i]);
            ((EvgmDeclarationDetailMod)form.getVgmDetailList().get(runNo+i)).setGrossCargo(grossCargo[i]);
            ((EvgmDeclarationDetailMod)form.getVgmDetailList().get(runNo+i)).setTareWeight(tareWeight[i]);
        }
        System.out.println("[EvgmDeclarationSvc][populateDetailData][End]");
    }
    
    private void findDetailData(EvgmDeclarationUim form, HttpServletRequest request,EvgmDeclarationDao    objDao){
        
        Map                         mapParam                    = null;
        int totRec = 0;
		List detailList = new ArrayList();
        List customerList = new ArrayList();
        String errMsg = "";
        
        form.setErrMsg("");
        
//        System.out.println("user id >>>>>>>>>>>>>>>>>>>>. "+form.getUserId());
//        System.out.println("booking no >>>>>>>>>>>>>>>>>>>>. "+form.getBookingNo());
        
        //            form.setVgmDetailList();
        mapParam = objDao.checkBookingAvailable(form.getBookingNo(),form.getUserId());
        
        if(mapParam.get(objDao.MSG_ERROR).equals("")){
//            form.setHdrSeq(FormatUtil.nullToBlank((String)mapParam.get(objDao.HDR_SEQ)));
            List headerList = (List)mapParam.get(objDao.RESULT);
            if(headerList != null && headerList.size() > 0){
                EvgmDeclarationHeaderMod mod = (EvgmDeclarationHeaderMod)headerList.get(0);
                
                form.setHdrSeq(mod.getHdrSeq());
                form.setDisplayVesslVoy(mod.getVesselVoy());
                form.setShipperName(mod.getShipperName());
                form.setRespresentName(mod.getRespresentName());
                form.setAuthorizePerson(mod.getAuthName());
                form.setSubmissionDate(mod.getSubmissionDate());
            }
            
        }else{
            form.setHdrSeq("");
            form.setDisplayVesslVoy("");
            form.setShipperName("");
            form.setRespresentName("");
            form.setAuthorizePerson("");
            form.setSubmissionDate("");
            form.setTotRecord(getTotRec(-1, detailList.size()));
            errMsg = (String)mapParam.get(objDao.MSG_ERROR);
        }
        
//        System.out.println("getHdrSeq >>>>>>>>>>>>>>>>>>>>. "+form.getHdrSeq());
//        System.out.println("errMsg >>>>>>>>>>>>>>>>>>>>. "+errMsg);

        
        //            for(int i = 0 ; i < 20 ; i++){
        //                EvgmDeclarationMod mod = new EvgmDeclarationMod();
        //                mod.setContainer(""+i);
        //                detailList.add(mod);
        //            }
//         if(detailList != null){
//             totRec = detailList.size();
//             if(detailList.size() > 0){
//                 EvgmDeclarationDetailMod mod = (EvgmDeclarationDetailMod)detailList.get(0);
//                 form.setVessel(mod.getVesselVoy());
//                 form.setSubmissionDate(mod.getSubmitDate());
//             }
//             
//         }
         String allSuccess = "N";
         if(errMsg.equals("")){
             detailList = objDao.getContainerList(form.getUserId(),form.getBookingNo(),form.getUserFsc());
            if(detailList == null || detailList.size() == 0){
                errMsg = "No Record Found.";
            }else{
                
                for(int i = 0; i < detailList.size() ; i++){
                    EvgmDeclarationDetailMod detailMod = (EvgmDeclarationDetailMod)detailList.get(i);
                    if(detailMod.getVgmStatus().equals("S")){
                        allSuccess = "Y";
                        
                    }else{
                        allSuccess = "N";
                        break;
                    }
                }
                
                form.setSearchPerformed("true");
                form.setTotRecord(getTotRec(-1, detailList.size()));
                customerList    = getTableDataNew(detailList, form.getCurrPageNo());
                
                if(customerList.size() == 0){
                    customerList    = getTableDataNew(detailList, form.getCurrPageNo()-1);
                    form.setCurrPageNo(form.getCurrPageNo()-1);
                    form.setPagePrevNo(form.getCurrPageNo());
                }
                
            }
         }
         
        form.setAllSuccess(allSuccess);
        
        form.setErrMsg(errMsg);
        
        form.setVgmDetailList(detailList);
        form.setDisplayDetailList(customerList);
    }
    
    public String findDetail(EvgmDeclarationUim form, HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][findDetail][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        
        EvgmDeclarationDao    objDao          = null;
        try{
            objDao          = getDao();
//            System.out.println("getCurrPageNo >>>>>>>>>>>>>>>>>>>>>>>>>> :"+form.getCurrPageNo());
            
            findDetailData(form,request,objDao);
            
            request.getSession().setAttribute("evgmDeclarationUim",form);
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationSvc][findDetail][End]");
        }
        return forwardPage;
        
    }
    
    public String onLoad(EvgmDeclarationUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EvgmDeclarationSvc][onLoad][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        
        EvgmDeclarationDao    objDao          = null;

        try{
            form.resetForm();
            form.setCurrPageNo(1);
            form.setPagePrevNo(1);
            form.setTotRecord(0);
            form.setDisplayDetailList(new ArrayList());
        
             Calendar gcutc = new GregorianCalendar(TimeZone.getTimeZone("GMT+0"));//Gregorian ???? default locale ??????????????? “en”,”US”
             String format = "dd/MM/yyyy HH:mm";
             Locale locale1 = new Locale("en", "US");
             
             DateFormat dateFormat1 = new SimpleDateFormat(format, locale1);
             dateFormat1.setTimeZone(TimeZone.getTimeZone("GMT+7"));
//             System.out.println(dateFormat1.format(gcutc.getTime()));//2013-11-11 17:41 ??? Calendar ?? timezone ????+0 locale ???? en ???? DateFormat ?? timezone ???? default +7 ?????????????????????? ????? locale ???? en ??????????????
             
            
            
            objDao          = getDao();
            String userId = getUserID(request);
//            String companyName = objDao.getCompanyName(userId);
            
            form.setUserFsc(getUserFsc(request));
            form.setUserId(userId);
            form.setOrgType(objDao.getOrgType(userId));
//            form.setUserName(companyName);
//            form.setShipperName(companyName);
//            form.setSubmissionDate(dateFormat1.format(gcutc.getTime()));
//            form.setAuthorizePerson(getEmpName(request));
            
//            form.setRespresentName(companyName);
//            System.out.println("form.getOrgType() 2 >>>>>>>>>>>>>> "+form.getOrgType());
//            System.out.println("form.getUserName() 2 >>>>>>>>>>>>>> "+form.getUserName());
//            System.out.println("form.getReportDate(request)() 2 >>>>>>>>>>>>>> "+getReportDate(request));
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationSvc][onLoad][End]");
        }
        return forwardPage;
        
    }
    
    public String changeAction(EvgmDeclarationUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EvgmDeclarationSvc][changeAction][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        EvgmDeclarationDao    objDao          = null;
        try{
            System.out.println("selectAction"+form.getSelectAction());
            objDao          = getDao();
            String selectAction = form.getSelectAction();
            
            form.resetForm();
            form.setTotRecord(0);
            form.setDisplayDetailList(new ArrayList());
            form.setSelectAction(selectAction);
            String userId = getUserID(request);
            
            form.setOrgType(objDao.getOrgType(userId));
            
            if(selectAction.equals("1")){
//                objDao          = getDao();
                
                
//                String companyName = objDao.getCompanyName(userId);
//                
//                form.setUserFsc(getUserFsc(request));
//                form.setUserId(userId);
//                form.setUserName(companyName);
                form.setShipperName("");
                form.setSubmissionDate("");
                form.setAuthorizePerson("");
//                
                form.setRespresentName("");
            }
            
            request.getSession().setAttribute("evgmDeclarationUim",form);
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationSvc][changeAction][End]");
        }
        return forwardPage;
        
    }
    
    public String uploadExcel(EvgmDeclarationUim form, HttpServletRequest request ,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][uploadExcel][Begin]");
        String                      forwardPage                 = FAILURE;
        boolean                         isMultipart                     = ServletFileUpload.isMultipartContent(this.request);
        String                          fileName                        = null;
        String                          newFileName                     = null;
        String[]                        fileTypeS                       = null;
        String                          fileType                        = null;
        int                             size                            = 0;
        long                            curr                            = System.currentTimeMillis();
//        EserviceUploadMod               eserviceUploadMod               = null;
        int                             totalSize                       = 0;
        int                             limitSize                       = 2048000;//2 MB
        EvgmDeclarationUim               evgmDeclarationUim               = null;
        int                             newSeq                          = 0;
        FormFile                        dataFile                        = null;
        String                          sizeDisplay                     = null;
        
        File                            uploadedFile            = null;
        FileItem                        item                    = null;
        POIFSFileSystem                 fileSystem              = null;
        HSSFWorkbook                    wb                      = null;
        int                             numberOfSheets          = 0;
        Row[]                       rowArray                = null;
        List errorList = new ArrayList();
        List detailList = new ArrayList();
        EvgmDeclarationDao    objDao          = null;
        Map                     msgMap        = null;
        try{        
            System.out.println("[EvgmDeclarationSvc][uploadExcel] isMultipart :: " + isMultipart);
            objDao = getDao();
            String userId = getUserID(request);
            String companyName = objDao.getCompanyName(userId);
            if (isMultipart) {
                evgmDeclarationUim               = form;
//                newSeq                          = Integer.parseInt(evgmDeclarationUim.getMaxSeq());
                dataFile                        = evgmDeclarationUim.getDataFile();
                
                System.out.println("[EvgmDeclarationSvc][uploadExcel] this.request :: " + this.request);
                System.out.println("[EvgmDeclarationSvc][uploadExcel] dataFile :: " + dataFile);
                
                if(dataFile!=null){
                    fileName                        = new File(dataFile.getFileName()).getName();
                    fileTypeS                       = fileName.split("\\.");
                    fileType                        = fileTypeS[(fileTypeS.length - 1)];
                    newFileName                     = String.valueOf(curr) + "." + fileType;
                    size                            = dataFile.getFileSize();
//                    totalSize                       = size + eserviceUploadUim.getTotalSize();
                    sizeDisplay                     = String.valueOf(Math.round(size/1000));
                    
                    System.out.println("EvgmDeclarationSvc][uploadExcel] fileName :: " + fileName);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] fileType :: " + fileType);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] size :: " + size);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] sizeDisplay :: " + sizeDisplay);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] totalSize :: " + totalSize);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] newFileName :: " + newFileName);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] seq :: " + newSeq);
                    
//         Workbook workbook = new XSSFWorkbook(inputStream);
//        Workbook workbook = getWorkbook(inputStream, fileName);
          Workbook  workbook = WorkbookFactory.create(dataFile.getInputStream());
//            HSSFSheet firstSheet = wb.getSheetAt(0);
            Sheet firstSheet = workbook.getSheetAt(0);
            rowArray  = ExcelUtil.getAllRows_EX(firstSheet);
                    System.out.println("EvgmDeclarationSvc][uploadExcel] rowArray.length :: " + rowArray.length);
                    
                    System.out.println("EvgmDeclarationSvc][uploadExcel] workbook :: " + workbook.getNumberOfSheets());
                    
                    numberOfSheets = workbook.getNumberOfSheets();
                    
                    System.out.println("EvgmDeclarationSvc][uploadExcel] numberOfSheets :: " + numberOfSheets);
                    String pathBooking = "N";
                    String pathContainer = "N";
                    int countBooking = 0;
                    
                    for(int j=0;j<rowArray.length;j++){
//                        System.out.println(" j >>>>>>>>>>>>>>>>>>>>>>> :"+j);
                        String msg1 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 0).getValue()); 
                        String msg2 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 1).getValue());                 
                        String msg3 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 2).getValue());        
                        String msg4 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 3).getValue());     
                        String msg5 = FormatUtil.nullToBlank(new ExcelField(rowArray[j], ".*", 4).getValue()); 
                        
                        
//                        System.out.println("seq >>>>>>>>>>>>>>>>>>>> "+msg1);
//                        System.out.println("activity >>>>>>>>>>>>>>>>>>>> "+msg2);
//                        System.out.println("rateBasis >>>>>>>>>>>>>>>>>>>> "+msg3);
//                        System.out.println("auto >>>>>>>>>>>>>>>>>>>> "+msg4);
//                        System.out.println("incl >>>>>>>>>>>>>>>>>>>> "+msg5);
//                        System.out.println("----------------------------------------------------");
                        
                        if(!pathBooking.equals("")){
                            if(pathBooking.equals("N")){
                                if(msg1.equals("Booking Number *") && msg2.equals("Shipper Name *") && msg3.equals("Authorized Person Name  *") && msg4.equals("Representative Name") && msg5.equals("Submit Date and Time")){
                                    pathBooking = "Y";
                                    continue;
                                } 
                            }else{
                                
                                if(!msg1.equals("") || !msg2.equals("") || !msg3.equals("") || !msg4.equals("") || !msg5.equals("")){
                                    if(msg1.equals("Container No. *") && msg2.equals("Weighing Method") && msg3.equals("Verified Gross Mass (KGS) *") && msg4.equals("Gross Cargo Weight (KGS)") && msg5.equals("Tare Weight")){
                                        
                                        pathContainer = "Y";
                                        pathBooking = "";
//                                        System.out.println("pathContainer ------------------------");
                                        continue;
                                    }else{
                                        form.setBookingNo(msg1);
                                        form.setShipperName(msg2);
                                        form.setAuthorizePerson(msg3);
                                        if(msg4.equals("")){
                                            form.setRespresentName(companyName);
                                        }else{
                                            form.setRespresentName(msg4);
                                        }
                                        
                                        form.setSubmissionDate(msg5);
                                        
                                        countBooking++;
//                                        System.out.println("countBooking >>>>>>>>>>>>>> "+countBooking);
                                        if(countBooking > 1){
                                            EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                                            mod.setContainer("");
                                            mod.setErrorDesc("Upload can not proceed due to there is more than 1 Booking#.");
                                            errorList.add(mod);
                                            break;
                                        }
                                    }
                                }
                                
                            }
                        }
                        
                        if(pathContainer.equals("Y")){
                            if(msg1.equals("") && msg2.equals("") && msg3.equals("") && msg4.equals("") && msg5.equals("")){
                                break;
                            }else{
                            
                                EvgmDeclarationDetailMod mod = new EvgmDeclarationDetailMod();
                                
                                
                                mod.setContainer(msg1);
                                mod.setWeightMethod(msg2);
//                                if(msg3.equals("")){
                                    mod.setVerGrossMass(msg3);
//                                }else{
//                                
//                                    
//                                    mod.setVerGrossMass(FormatUtil.getDecimalFormat(msg3,"#,##0.00"));
//                                }
//                                
//                                if(msg4.equals("")){
                                    mod.setGrossCargo(msg4);
//                                }else{
//                                    mod.setGrossCargo(FormatUtil.getDecimalFormat(msg4,"#,##0.00"));
//                                }
//                                if(msg5.equals("")){
                                    mod.setTareWeight(msg5);
//                                }else{
//                                    mod.setTareWeight(FormatUtil.getDecimalFormat(msg5,"#,##0.00"));
//                                }
                                
                                
                                detailList.add(mod);
                            }
                        }
                        
                    }
                    
//                    inputStream.close();
                }
            }
            
            msgMap = objDao.checkExcelBookingAvailable(form.getBookingNo(),form.getUserId());
            
            if(msgMap!= null){
                if(!msgMap.get(objDao.MSG_ERROR).equals("")){
                    EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                    mod.setContainer("");
                    mod.setErrorDesc((String)msgMap.get(objDao.MSG_ERROR));
                    errorList.add(mod);
                }
            }
            
            if(form.getShipperName().equals("")){
                EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                mod.setContainer("");
                mod.setErrorDesc("Shipper name is mandatory.");
                errorList.add(mod);
            }
            
            if(form.getShipperName().equals("")){
                EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                mod.setContainer("");
                mod.setErrorDesc("Authorized Person Name.");
                errorList.add(mod);
            }
            
            for(int i = 0 ; i < detailList.size() ; i++){
                EvgmDeclarationDetailMod mod1 = (EvgmDeclarationDetailMod)detailList.get(i);
                for(int j = i+1 ; j < detailList.size() ; j++){
                    EvgmDeclarationDetailMod mod2 = (EvgmDeclarationDetailMod)detailList.get(j);
                    if(mod1.getContainer().equals(mod2.getContainer())){
                        EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                        mod.setContainer(mod1.getContainer());
                        mod.setErrorDesc("Duplicate");
                        errorList.add(mod);
                    }
                }
                
//                System.out.println("objDao.checkContainer(mod1.getContainer()) "+objDao.checkContainer(mod1.getContainer()));
                
                if(objDao.checkContainer(mod1.getContainer())){
                    
                }else{
                    EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                    mod.setContainer(mod1.getContainer());
                    mod.setErrorDesc("Container not available.");
                    errorList.add(mod); 
                }
                
                if(mod1.getVerGrossMass().equals("")){
                    EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                    mod.setContainer(mod1.getContainer());
                    mod.setErrorDesc("Verified Gross Mass is mandatory.");
                    errorList.add(mod);
                }else{
                    if(isNumeric(mod1.getVerGrossMass().replaceAll(",",""))){
                        if(Double.parseDouble(mod1.getVerGrossMass().replaceAll(",","")) <= 0){
                            EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                            mod.setContainer(mod1.getContainer());
                            mod.setErrorDesc("Verified Gross Mass must be greater than 0.");
                            errorList.add(mod); 
                        }else{
                            ((EvgmDeclarationDetailMod)detailList.get(i)).setVerGrossMass(FormatUtil.getDecimalFormat(mod1.getVerGrossMass(),"#,##0.00"));
                        }
                    }else{
                        EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                        mod.setContainer(mod1.getContainer());
                        mod.setErrorDesc("Verified Gross Mass must be Numeric.");
                        errorList.add(mod);
                    }
                }
                
                if(!mod1.getTareWeight().equals("")){
                    if(!isNumeric(mod1.getGrossCargo().replaceAll(",",""))){
                        EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                        mod.setContainer(mod1.getContainer());
                        mod.setErrorDesc("Gross Cargo Weight must be Numeric.");
                        errorList.add(mod);
                    }else{
                        ((EvgmDeclarationDetailMod)detailList.get(i)).setGrossCargo(FormatUtil.getDecimalFormat(mod1.getGrossCargo(),"#,##0.00"));
                    }
                }
                
                if(!mod1.getTareWeight().equals("")){
                    if(!isNumeric(mod1.getTareWeight().replaceAll(",",""))){
                        EvgmDeclarationErrorMod mod = new EvgmDeclarationErrorMod();
                        mod.setContainer(mod1.getContainer());
                        mod.setErrorDesc("Tare Weight must be Numeric.");
                        errorList.add(mod);
                    }else{
                        ((EvgmDeclarationDetailMod)detailList.get(i)).setTareWeight(FormatUtil.getDecimalFormat(mod1.getTareWeight(),"#,##0.00"));
                    }
                }
            }
            
            form.setErrorList(errorList);
            if(errorList != null){
                if(errorList.size() == 0){
                    if(detailList != null){
                        form.setSearchPerformed("true");
                        form.setTotRecord(getTotRec(-1, detailList.size()));
                        List customerList    = getTableDataNew(detailList, 1);
//                        System.out.println("customerList   >>>>>>>>>>>> "+customerList.size());
//                        System.out.println("detailList   >>>>>>>>>>>> "+detailList.size());
                        form.setVgmDetailList(detailList);
                        form.setDisplayDetailList(customerList);
                        
                    }
                }
            }
            request.getSession().setAttribute("evgmDeclarationUim",form);
            forwardPage = SUCCESS;
        }catch(CustomDataAccessException e){
            e.printStackTrace();
//            this.writeMSG("ERROR::" + e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
//            this.writeMSG("ERROR::" + e.getMessage());
        }finally{
            System.out.println("[EserviceUploadSvc][uploadExcel][End]");
        }
        return forwardPage;
    }
    
    public String createExcelTemplate(EvgmDeclarationUim form, HttpServletRequest request ,HttpServletResponse response) throws Exception {
        System.out.println("[EvgmDeclarationSvc][createExcelTemplate][Begin]");
        
        UserAccountBean             account                     = null;
        Map                         mapParam                    = null;
        String                      originCountry               = null;
        String                      forwardPage                 = FAILURE;
        
        EvgmDeclarationDao    objDao          = null;

        try{
            objDao          = getDao();
            String userId = getUserID(request);
            String companyName = objDao.getCompanyName(userId);
            
            
            System.out.println("selectAction"+form.getSelectAction());
            String fileName;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String fileDate = dateFormat.format(Calendar.getInstance().getTime());
            fileName = "Excel_Template_" + fileDate;
            
            String[] titles1 = {"Booking Number *","Shipper Name *", "Authorized Person Name  *", "Representative Name ", "Submit Date and Time"};
            
            String[] titles2 = {"Container No. *","Weighing Method ", "Verified Gross Mass (KGS) *", "Gross Cargo Weight (KGS) ", "Tare Weight "};
            
            
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet worksheet = workBook.createSheet("Template");
            
            Map<String, CellStyle> styles = createStyles(workBook);
            
            HSSFRow row = null;
            HSSFCell cell = null;
            HSSFCellStyle cellStyle = workBook.createCellStyle();
            HSSFDataFormat hssfDataFormat = workBook.createDataFormat();
            
            short shRow = 0;
            short shRowMerge = 1;
            short shCol = 0;
            Region region = new org.apache.poi.hssf.util.Region();
            
            
            Row headerRow = worksheet.createRow(shRow);
            Cell headerCell;
            for (int i = 0; i < titles1.length; i++) {
                headerCell = headerRow.createCell(i);
                headerCell.setCellValue(titles1[i]);
               
                headerCell.setCellStyle(styles.get("header"));
            }
            
            Row detailRow = worksheet.createRow(shRow+1);
            Cell detailCell;
            detailCell = detailRow.createCell(0);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(1);
            detailCell.setCellValue(companyName);
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(2);
            detailCell.setCellValue(getEmpName(request));
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(3);
            detailCell.setCellValue(companyName);
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            detailCell = detailRow.createCell(4);
            detailCell.setCellValue(getReportDate(request));
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            
            headerRow = worksheet.createRow(shRow+3);
            
            for (int i = 0; i < titles1.length; i++) {
                headerCell = headerRow.createCell(i);
                headerCell.setCellValue(titles2[i]);
               
                headerCell.setCellStyle(styles.get("header"));
            }
            
            detailRow = worksheet.createRow(shRow+4);
            detailCell = detailRow.createCell(0);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(1);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            detailCell = detailRow.createCell(2);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(3);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            detailCell = detailRow.createCell(4);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            detailRow = worksheet.createRow(shRow+5);
            detailCell = detailRow.createCell(0);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(1);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            detailCell = detailRow.createCell(2);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_yellow"));
            
            detailCell = detailRow.createCell(3);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            detailCell = detailRow.createCell(4);
            detailCell.setCellValue("");
            detailCell.setCellStyle(styles.get("cell_gray"));
            
            
            detailRow = worksheet.createRow(shRow+8);
            detailCell = detailRow.createCell(0);
            detailCell.setCellValue("* Mandatory");
            detailCell.setCellStyle(styles.get("cell_common"));
            detailRow = worksheet.createRow(shRow+9);
            detailCell = detailRow.createCell(0);
            detailCell.setCellValue("*1 = Method 1  : Weighing of Packaged / Sealed Container.");
            detailCell.setCellStyle(styles.get("cell_common"));
            detailRow = worksheet.createRow(shRow+10);
            detailCell = detailRow.createCell(0);
            detailCell.setCellValue("*2 = Method 2 :  Weighing of all packed cargos plus packing material and Tare Weight");
            detailCell.setCellStyle(styles.get("cell_common"));
            
//            request.getSession().setAttribute("smtSalesForecastUim", uim);

            for (int i = 0; i < 5; i++) {
                worksheet.setColumnWidth(i, 30*256);  //30 characters wide
            }
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
            response.addHeader("Content-Type", "application/excel");
            OutputStream out = response.getOutputStream();
            workBook.write(out);
            out.flush();
            out.close();
            
            forwardPage = SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationSvc][onLoad][End]");
        }
        return forwardPage;
        
    }
    
    private static Map<String, CellStyle> createStyles(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)18);
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font monthFont = wb.createFont();
//        monthFont.setFontHeightInPoints((short)11);
//        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);
        
        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        styles.put("cell_common", style);
        
        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        styles.put("cell_gray", style);
        
        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        styles.put("cell_yellow", style);

        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula", style);

        style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula_2", style);

        return styles;
    }
    
    
    private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
            throws IOException {
        Workbook workbook = null;
     
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
     
        return workbook;
    }
    
    private EvgmDeclarationUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EvgmDeclarationUim form = null;
        try{
            form = (EvgmDeclarationUim) actionForm;
            if (form == null){
                form = new EvgmDeclarationUim();
            }else if(ONLOAD.equals(pageAction)){
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
            pageAction = "";
        }

        return pageAction;
    }
    
    private EvgmDeclarationDao getDao() throws Exception{
        EvgmDeclarationDao dao = null;
        try{
            dao = (EvgmDeclarationDao) getDao(EvgmDeclarationDao.DAO_NAME);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }
    
    private void responseOut(HttpServletResponse response,String msgError){
        PrintWriter print = null;
        String errMsg = "";
        
        try {
            response.setContentType("application/json");
            print = response.getWriter();
            
            if(msgError.equals("")){
                print.write("200#:#SUCCESS");
                System.out.println("SUCCESS");
            }else{
                print.write("500#:#" + msgError);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            print.write("500#:#" + e.getMessage());
            System.out.println("7,"+e.getMessage());
        } finally {
             if (print != null) {
                 print.close();
             }
         }
    }
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
}

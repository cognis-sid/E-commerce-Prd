package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.AccountUtil;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceMRESUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceMRESDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESNotificationsMod;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EserviceMRESSvc extends BaseAction {
    private final boolean TEST_MODE = false;
    private final int TOT_REC_PER_PAGE = 5;

    private String userIdParamName = null;
    private String passwordParamName = null;
    
    private String getForwardPage(EserviceMRESUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = form.getCurrPageAction();
            if ("onload".equals(pageAction)){
                if(TEST_MODE){
                    userIdParamName = "tbx_uid";
                    passwordParamName = "password";
                }else{
                    userIdParamName = "txtUserId";
                    passwordParamName = "txtPwd";
                }
                forwardPage = checkBhumnetAccount(form, request, response);
            }else if("lookUpData".equals(pageAction)){
                forwardPage = lookUpNotificationsData(form, request);
            }else if("logOut".equals(pageAction)){
                forwardPage = logOut(form, request, response);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return forwardPage;
    }
    public EserviceMRESSvc(){
    }

    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response){
        EserviceMRESUim form = null;
        
        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = getPageAction(mapping);

            form = getForm(actionForm);
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
    
    private String checkBhumnetAccount(EserviceMRESUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map paramsMap = null;
        Map resultMap  =null;
        
        EserviceMRESDao objDao = null;
        
        UserAccountBean userAccountBean = null;
        
        String appId = null;
        String userId = null;
        String password = null;
        String passwordDB = null;
        String errorMsg = null;
        
        String forwardPage = null;
        try{
//            if(!form.getAuthPass()){
                appId = request.getParameter("appId");
                userId = request.getParameter(userIdParamName);
                if(userId != null && !BLANK.equals(userId)){
                    userId = userId.toUpperCase();
                }
                
                System.out.println("userId::" + userId);
                
                password = request.getParameter(passwordParamName);
                if(TEST_MODE){
                    if(password == null || BLANK.equals(password)){
                        password = "dolphin1";
                    }
                }
                if(password != null && !BLANK.equals(password)){
                    passwordDB = EncryptDecryptUtil.convertStringToHex(password);
                }
            
                paramsMap = new HashMap();
                paramsMap.put(EserviceMRESDao.P_I_V.USR_ID, userId);
                paramsMap.put(EserviceMRESDao.P_I_V.PWD, passwordDB);
                
                objDao = getDao();
                resultMap = objDao.findPasswordAuthen(paramsMap);
                if(resultMap != null){
                    if(resultMap.containsKey(EserviceMRESDao.P_O_V.ERR_MSG)){
                        errorMsg = (String) resultMap.get(EserviceMRESDao.P_O_V.ERR_MSG);
                    }
                    if((errorMsg == null || BLANK.equals(errorMsg.trim()))){
                        form.setAuthPass(true);
                        
                        userAccountBean = AccountUtil.getUserAccountBean(request, userId, new String[]{"ESI01"});
                        userAccountBean.setPassword(passwordDB);
                        
                        request.getSession(true).setAttribute(USER_ACCOUNT_BEAN, userAccountBean);
                        
                        forwardPage = initMRES(form, request);
                    }else{
                        form.setAuthPass(false);
                    }
                }else{
                    form.setAuthPass(false);
                }
//            }
        }catch(Exception ex){
            form.setAuthPass(false);
            throw ex;
        }finally{
            form.setPasswordEncrypt(passwordDB);
        }
        return SUCCESS;
    }
    
    public static String sanitizeURLString(String av_val){
            
        System.out.println("[EserviceMRESSvc][sanitizeURLString][Begin]");
        String[]    la_symbol   = {"%" , "<" , ">" , "#" , "{" , "}" , "|" , "\\" , "^" , "~" , "[" , "]" , "`" , ";" , "/" , "?" , ":" , "@" , "=" , "&" , "$"};
        String[]    la_replace  = {"%25", "%3C", "%3E", "%23", "%7B", "%7D", "%7C", "%5C", "%5E", "%7E", "%5B", "%5D", "%60", "%3B", "%2F", "%3F", "%3A", "%40", "%3D", "%26", "%24"};
        String      lv_return   = null;
        
        try{
            
                lv_return = av_val;
                
            for(int i=0;i<la_symbol.length;i++){
                if(av_val.indexOf(la_symbol[i]) > -1){
                        
                    lv_return = lv_return.replaceAll("\\" + la_symbol[i], la_replace[i]);
                }
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceMRESSvc][sanitizeURLString][End]");
        }
        
        return lv_return;
    }
    
    private String getRCLCurrentDate(){
        SimpleDateFormat df = null;
        
        Calendar cal = null;

        String dateStr = null;
        String dateSuffix = null;
        String monthStr = null;
        String yearStr = null;
        String fullDate = null;
        
        Integer date = 0;
        
        Date currentDate = null;
        try{
            cal = Calendar.getInstance();
            currentDate  = cal.getTime();
         
            df = new SimpleDateFormat("dd", Locale.ENGLISH);
            dateStr = df.format(currentDate);
            date = Integer.valueOf(dateStr);
            switch(date.intValue()){
                case 1: dateSuffix = "st"; break;
                case 2: dateSuffix = "nd"; break;
                case 3: dateSuffix = "rd"; break;
                default: dateSuffix = "th"; break;
            }
            
            df = new SimpleDateFormat("MMM", Locale.ENGLISH);
            monthStr = df.format(currentDate);
            
            df = new SimpleDateFormat("yyyy", Locale.ENGLISH);
            yearStr = df.format(currentDate);
            
            fullDate = monthStr+" "+dateStr+dateSuffix+" "+yearStr;
        }catch(Exception ex){
            df = new SimpleDateFormat("MMM dd yyyy");
            fullDate = df.format(cal);
        }finally{
            System.out.println("Current Date = "+fullDate);
        }
        return fullDate;
    }

    public String initMRES(EserviceMRESUim form, HttpServletRequest request) throws Exception {
        String fullCurrentDate = null;
        String errMsg = null;
        String forwardPage = null;
        try {
            lookUpNotificationsData(form, request);
            
            lookUpMyEServiceData(form, request);
            
            fullCurrentDate = getRCLCurrentDate();
            
            forwardPage = "success";
        } catch (Exception ex) {
            errMsg = ex.getMessage();
            throw ex;
        } finally {
            form.setFullCurrentDate(fullCurrentDate);
            form.setErrMsg(errMsg);
            form.setPrevPageAction(null);
        }
        return forwardPage;
    }
    
    private String lookUpNotificationsData(EserviceMRESUim form, HttpServletRequest request) throws Exception {
        List<EserviceMRESNotificationsMod> notificationList = null;
        
        Map paramsMap = null;
        Map resultMap = null;
        
        EserviceMRESDao objDao = null;
        
        BigDecimal totalNotification = null;
        String forwardPage = SUCCESS;
        
        String sortCol = null;
        String orderBy = null;
        
        int fromRecord = 0;
        int toRecord = 0;
        int totalNoticeNew = 0;
        try{
            sortCol = form.getSortCol();
            orderBy = form.getOrderBy();
            fromRecord = getFromRecord(form.getCurrPageNo());
            toRecord = getToRecord(form.getCurrPageNo());
        
            paramsMap = new HashMap();
            paramsMap.put(EserviceMRESDao.P_I_V.USR_ID, getUserID(request));
            paramsMap.put(EserviceMRESDao.P_I_V.RECORD_START, String.valueOf(fromRecord+1));
            paramsMap.put(EserviceMRESDao.P_I_V.RECODE_END, String.valueOf(toRecord+1));
            paramsMap.put(EserviceMRESDao.P_I_V.SORT_COL, sortCol);    
            paramsMap.put(EserviceMRESDao.P_I_V.ORDERBY, orderBy);    
            //------------------- get object of dao.
            objDao = getDao();
            resultMap =  objDao.findNotifications(paramsMap);
            if(resultMap != null && !resultMap.isEmpty()){
                if(resultMap.containsKey(EserviceMRESDao.P_O_V.NOTICE_DATA)){
                    notificationList = (List<EserviceMRESNotificationsMod>) resultMap.get(EserviceMRESDao.P_O_V.NOTICE_DATA);
                }
                if(resultMap.containsKey(EserviceMRESDao.P_O_V.TOTAL_ROW)){
                    totalNotification = (BigDecimal) resultMap.get(EserviceMRESDao.P_O_V.TOTAL_ROW);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            forwardPage = FAILURE;
        }finally{
            if(notificationList == null){
                notificationList = new ArrayList<EserviceMRESNotificationsMod>();
            }else{
                for(EserviceMRESNotificationsMod mod: notificationList){
                    if(EserviceMRESDao.NOTIFICATION_FLAG.NEW.equals(mod.getFlag())){
                        ++totalNoticeNew;
                    }
                }
            }
            if(totalNotification == null){
                totalNotification = new BigDecimal(0);
            }
            if(EserviceMRESUim.SORT_IN_ASC.equals(orderBy)){
                orderBy = EserviceMRESUim.SORT_IN_DESC;
            }else{
                orderBy = EserviceMRESUim.SORT_IN_ASC;
            }
            form.setOrderBy(orderBy);
            if(EserviceMRESUim.SORT_TYPE_ID.equals(sortCol)){
                form.setIdOrderBy(orderBy);
                form.setSubjectOrderBy(EserviceMRESUim.ORDER_BY_DEFAULT);
                form.setDateOrderBy(EserviceMRESUim.ORDER_BY_DEFAULT);
            }else if(EserviceMRESUim.SORT_TYPE_SUBJECT.equals(sortCol)){
                form.setIdOrderBy(EserviceMRESUim.ORDER_BY_DEFAULT);
                form.setSubjectOrderBy(orderBy);
                form.setDateOrderBy(EserviceMRESUim.ORDER_BY_DEFAULT);
            }else if(EserviceMRESUim.SORT_TYPE_DATE.equals(sortCol)){
                form.setIdOrderBy(EserviceMRESUim.ORDER_BY_DEFAULT);
                form.setSubjectOrderBy(EserviceMRESUim.ORDER_BY_DEFAULT);
                form.setDateOrderBy(orderBy);
            }
            
            form.setNotificationsList(notificationList);
            form.setTotalNotification(totalNoticeNew);
            form.setTotRecord(totalNotification.intValue());
            form.setFormName("feserv13");
        }
        return forwardPage;
    }

    private String lookUpMyEServiceData(EserviceMRESUim form, HttpServletRequest request) throws Exception {
        List<EserviceMRESMyEServiceMod> myEServiceList = null;
        
        List<EserviceMRESMyEServiceMod> moduleList = null;
        
        Map paramsMap = null;
        Map resultMap = null;
        
        Map<String, List<EserviceMRESMyEServiceMod>> esvMap = null;
        
        String module = null;
        
        EserviceMRESDao objDao = null;
        
        String userId = null;
        String forwardPage = SUCCESS;
        try{
            userId = getUserID(request);
            
            paramsMap = new HashMap();
            paramsMap.put(EserviceMRESDao.P_I_V.USR_ID, userId);        
            //------------------- get object of dao.
            objDao = getDao();
            resultMap =  objDao.findMyEService(paramsMap);
            if(resultMap != null && !resultMap.isEmpty()){
                if(resultMap.containsKey(EserviceMRESDao.P_O_V.SFU_DATA)){
                    myEServiceList = (List<EserviceMRESMyEServiceMod>) resultMap.get(EserviceMRESDao.P_O_V.SFU_DATA);
                    if(myEServiceList != null && !myEServiceList.isEmpty()){
//                        GET All Module                    
                        esvMap = new LinkedHashMap<String, List<EserviceMRESMyEServiceMod>>();
                        
                        for(EserviceMRESMyEServiceMod mod: myEServiceList){
                            
                            System.out.println("xx userId::" + sanitizeURLString(userId));
                            
//                            mod.setUrl(mod.getUrl()+ sanitizeURLString(userId));
                            mod.setUrl(mod.getUrl());
                            mod.setUsrLogin(sanitizeURLString(userId));
                            
                            module = mod.getModule();
                            if(!esvMap.containsKey(module)){
                                moduleList = new ArrayList<EserviceMRESMyEServiceMod>();
                                
                                esvMap.put(module, moduleList);
                            }else{
                                moduleList = esvMap.get(module);
                            }
                            moduleList.add(mod);
                        }
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            forwardPage = FAILURE;
        }finally{
            form.setEsvMap(esvMap);
        }
        return forwardPage;
    }
    
    private String logOut(EserviceMRESUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = null;
        Cookie[] cookies = null;
        
        UserAccountBean userAccountBean = null;
        
        String appId = null;
        String errMsg = null;
        String forwardPage = null;
        try {
            session = request.getSession(true);
            
            userAccountBean = (UserAccountBean) session.getAttribute(USER_ACCOUNT_BEAN);
            appId = userAccountBean.getCallAppId();
            
            cookies = request.getCookies();
            if (cookies != null){
                for (int i = 0; i < cookies.length; i++) {
                    cookies[i].setValue("");
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            
            session.removeAttribute(USER_ACCOUNT_BEAN);
            session.invalidate();
            
            if(DOLPHIN.equals(appId)){
                forwardPage = request.getServerName()+"/SealinerRCL/login.jsp?remove=all";
            }else{
                forwardPage = "http://www.rclgroup.com";
//                forwardPage = "file:///D:/Project/Prototype/RCL/RCL_Page/RCL_Page/RCL_Group.htm";
            }

            response.sendRedirect(forwardPage);    
        } catch (Exception ex) {
            errMsg = ex.getMessage();
            throw ex;
        }
        return forwardPage;
    }
    
    public int getFromRecord(int aintCurrPageNo){
        return ((aintCurrPageNo - 1) * this.TOT_REC_PER_PAGE);
    }
    
    public int getToRecord(int aintCurrPageNo){
        return (aintCurrPageNo * this.TOT_REC_PER_PAGE) - 1;
    }

    private EserviceMRESUim getForm(ActionForm actionForm) throws Exception {
        EserviceMRESUim form = null;
        try {
            form = (EserviceMRESUim) actionForm;
            if (form == null)
                form = new EserviceMRESUim();
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

    private EserviceMRESDao getDao() throws Exception {
        EserviceMRESDao dao = null;
        try {
            dao = (EserviceMRESDao) getDao(EserviceMRESDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }

        return dao;
    }
}

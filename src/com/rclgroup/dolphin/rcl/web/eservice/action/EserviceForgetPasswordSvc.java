package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.common.Debug;
import com.niit.control.web.action.BaseAction;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceForgetPasswordUim;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceMRESUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceForgetPasswordDao;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceMRESDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EserviceForgetPasswordSvc extends BaseAction{
    public EserviceForgetPasswordSvc(){
    }
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response){
    	UserMod form = null;
        
        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = getPageAction(mapping);

            form = getForm(actionForm);
            form.setCurrPageAction(pageAction);

            forwardPage = getForwardPage(form, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();

            forwardPage = form.getCurrPageAction();
            if ((forwardPage == null) || ("".equals(forwardPage))) {
                forwardPage = "initMRES";
            }
        }
        return mapping.findForward(forwardPage);
    }

    private String getForwardPage(UserMod form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = form.getCurrPageAction();
            if ("onload".equals(pageAction)){
                forwardPage = initForgetPassword(form, request, response);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return forwardPage;
    }
    
    private String initForgetPassword(UserMod form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String forwardPage = SUCCESS;
        try{
            form.setUserId(BLANK);
            form.setDbPasword(BLANK);
         //   form.setSentPassword(false);
        }catch(Exception ex){
            throw ex;   
        }
        return forwardPage;
    }

    
    private String forgetPassword(EserviceForgetPasswordUim form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EserviceForgetPasswordDao objDao = null;
    
        Map paramsMap = null;
        Map resultMap = null;
    
        String userId = null;
        String email = null;
        String errorMsg = null;
        String forwardPage = FAILURE;
        
        boolean sentPassword = false;
        try{
            userId = form.getUserId();
            email = form.getEmailAddress();
            Debug.logFramework("User Id = "+userId+"\nE-Mail = "+email);
            
            paramsMap = new HashMap();
            paramsMap.put(EserviceForgetPasswordDao.P_I_V.USR_ID, userId);
            paramsMap.put(EserviceForgetPasswordDao.P_I_V.EMAIL_ADR, email);
        
            objDao = getDao();
            resultMap = objDao.sendForgetPassword(paramsMap);
            if(resultMap != null && !resultMap.isEmpty()){
                if(resultMap.containsKey(EserviceForgetPasswordDao.P_O_V.ERR_CD)){
                    errorMsg = (String) resultMap.get(EserviceForgetPasswordDao.P_O_V.ERR_DESC);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
        }finally{
//            errorMsg = null;
            if(errorMsg == null || BLANK.equals(errorMsg)){
                forwardPage = SUCCESS;
                sentPassword = true;
            }
            form.setErrMsg(errorMsg);
            form.setSentPassword(sentPassword);
        }
        return forwardPage;
    }

    private UserMod getForm(ActionForm actionForm) throws Exception {
    	UserMod form = null;
        try {
            form = (UserMod) actionForm;
            if (form == null)
                form = new UserMod();
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

    private EserviceForgetPasswordDao getDao() throws Exception {
        EserviceForgetPasswordDao dao = null;
        try {
            dao = (EserviceForgetPasswordDao) getDao(EserviceForgetPasswordDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }

        return dao;
    }
}

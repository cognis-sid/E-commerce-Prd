package com.rclgroup.dolphin.rcl.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.GlobalConstants;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.ForgetPasswordThread;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.dao.LoginDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.InternalUserMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

public class EserviceAdminLogin extends BaseAction implements GlobalConstants {

	 
	private static final String LANDING = "landing";
	String forwardPage = null;
	private HttpServletRequest request;
	private FormatUtil formatUtil = null;
	private static final String LOGOUT = "logoutadm";
	private static final String FORGET = "forget";


	private String getForwardPage(ActionMapping mapping, ActionForm actionForm, InternalUserMod form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
		try {
			pageAction = form.getCurrPageAction();
			this.request = request;
			this.formatUtil = new FormatUtil(request, response);
			if (LANDING.equals(pageAction)) {
				forwardPage = login(request);
			} else if (LOGOUT.equals(pageAction)) {
				forwardPage = logout(form, request);
			}
			else if (FORGET.equals(pageAction)) {
					forwardPage = getInternalUserPassword(form, request);
			}else {
				forwardPage = getUser(form, request);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return forwardPage;
	}

	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String pageAction = null;
		String errorMsg = null;
		InternalUserMod form = null;
		try {
			pageAction = getPageAction(mapping);

			form = getForm(actionForm);
			form.setCurrPageAction(pageAction);
			form.setDbPasword("");
			forwardPage = getForwardPage(mapping, actionForm, form, request, response);
			if (FAILURE.equals(forwardPage)) {
				//form.setErrorMessage("User Does not exist");// this logic move to DAO
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
			// form.setErrMsg(errorMsg);

			forwardPage = FAILURE;
		}
		return mapping.findForward(forwardPage);

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

	private InternalUserMod getForm(ActionForm actionForm) throws Exception {
		InternalUserMod form = null;
		try {
			form = (InternalUserMod) actionForm;
			if (form == null) {
				form = new InternalUserMod();
			}
		} catch (Exception ex) {
			throw ex;
		}

		return form;
	}

	private String getUser(InternalUserMod form, HttpServletRequest request) {
		LoginDao dao = null;
		try {
			dao = (LoginDao) getDao(LoginDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}

		String userId = form.getLoginId();
		String pwd = form.getPassword();
		UserAccountBean userAcc = dao.getAdminUser(userId, pwd,form);
		request.getSession(false).setAttribute(USER_ACCOUNT_BEAN, userAcc);
		if (userAcc == null) {			
			forwardPage = FAILURE;
			form.setErrorMessage("USER_DO_NOT_EXIST");
		}else {
			form.setLoginStatus(true);
			 
		}
		
		return forwardPage;

	}
 
	public String login(HttpServletRequest request) throws Exception {
		System.out.println("[++++++++++++++++++++++++++++++++++++++ login +++++++++++++++++++++++++++++++]");
		String forwardPage = null;
		forwardPage = SUCCESS;
		return forwardPage;
	}
	
	private String logout(InternalUserMod form, HttpServletRequest request) {

		request.getSession().setAttribute(USER_ACCOUNT_BEAN, null);
		request.getSession(false).invalidate();

		return SUCCESS;

	}
	
	private String getInternalUserPassword(InternalUserMod form, HttpServletRequest request) {
		LoginDao dao = null;
		try {
			dao = (LoginDao) getDao(LoginDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}

		String userId = form.getLoginId();
		String email = form.getEmail();
		UserAccountBean userAcc = dao.getInternalUserPassword(userId, email);
		if (userAcc != null) {
			form.setDbPasword(userAcc.getPassword());

			ForgetPasswordThread thread=new ForgetPasswordThread(userAcc.getUserName(),userAcc.getPassword(),email,userId);
			thread.start();
	
		}
		if (userAcc != null)
			forwardPage = SUCCESS;
		else
			forwardPage = FAILURE;

		return forwardPage;

	}

}
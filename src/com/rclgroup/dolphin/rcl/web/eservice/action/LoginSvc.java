package com.rclgroup.dolphin.rcl.web.eservice.action;

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
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserAccountBeanNew;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

public class LoginSvc extends BaseAction implements GlobalConstants {

	private static final String FORGET = "forget";
	private static final String LOGOUT = "logout";
	private static final String LOGIN = "Login";
	String forwardPage = null;
	private HttpServletRequest request;
	private FormatUtil formatUtil = null;

	private String getForwardPage(ActionMapping mapping, ActionForm actionForm, UserMod form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
		try {
			pageAction = form.getCurrPageAction();
			this.request = request;
			this.formatUtil = new FormatUtil(request, response);
			if (FORGET.equals(pageAction)) {
				forwardPage = getPassword(form, request);
			} else if (LOGOUT.equals(pageAction)) {
				forwardPage = logout(form, request);
			} else if (LOGIN.equals(pageAction)) {
				forwardPage = login(request);
			} else {
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
		UserMod form = null;
		try {
			pageAction = getPageAction(mapping);

			form = getForm(actionForm);
			form.setCurrPageAction(pageAction);
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

	private UserMod getForm(ActionForm actionForm) throws Exception {
		UserMod form = null;
		try {
			form = (UserMod) actionForm;
			if (form == null) {
				form = new UserMod();
			}
		} catch (Exception ex) {
			throw ex;
		}

		return form;
	}

	private String getUser(UserMod form, HttpServletRequest request) {
		LoginDao dao = null;
		try {
			dao = (LoginDao) getDao(LoginDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}

		String userId = form.getUserId();
		String pwd = form.getPassword();
		UserAccountBean userAcc = dao.getUser(userId, pwd,form);
		request.getSession(false).setAttribute(USER_ACCOUNT_BEAN, userAcc);
		if (userAcc != null) {
			forwardPage = "Y".equals(((UserAccountBeanNew)userAcc).getWebBooking() ) ?     SUCCESS:"getRate";
			form.setLoginStatus(true);
		}else {
			forwardPage = FAILURE;
		}
		return forwardPage;

	}

	private String getPassword(UserMod form, HttpServletRequest request) {
		LoginDao dao = null;
		try {
			dao = (LoginDao) getDao(LoginDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}

		String userId = form.getUserId();
		String email = form.getEmail();
		UserAccountBean userAcc = dao.getPassword(userId, email);
		if (userAcc != null) {
			form.setDbPasword(userAcc.getPassword());

			ForgetPasswordThread thread=new ForgetPasswordThread(userAcc.getUserName(),userAcc.getPassword(),email,userId);
			thread.start();
			/*
			 * EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");
			 * mail.forgetPasswordMail(userAcc.getUserName(), userAcc.getPassword(),
			 * email,userId);
			 */

		}
		if (userAcc != null)
			forwardPage = SUCCESS;
		else
			forwardPage = FAILURE;

		return forwardPage;

	}

	private String logout(UserMod form, HttpServletRequest request) {

		request.getSession().setAttribute(USER_ACCOUNT_BEAN, null);
		request.getSession(false).invalidate();

		return SUCCESS;

	}

	public String login(HttpServletRequest request) throws Exception {
		System.out.println("[++++++++++++++++++++++++++++++++++++++ login +++++++++++++++++++++++++++++++]");
		String forwardPage = null;
		forwardPage = SUCCESS;
		return forwardPage;
	}

}

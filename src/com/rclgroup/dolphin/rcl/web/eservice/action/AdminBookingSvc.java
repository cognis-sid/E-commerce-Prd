package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.GlobalConstants;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.AdminBookingLogUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.LoginDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AdminBookingFileLogMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AdminBookingLogMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserAccountBeanNew;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;
 

public class AdminBookingSvc extends BaseAction implements GlobalConstants {

	private static final String LOAD_ADMIN = "loadAdmin";
	private static final String LOGOUT = "logout";
	private static final String LOGIN = "Login";
	private static final String FILE_LOG= "fileLog";
	
	String forwardPage = null;
	private HttpServletRequest request;
	private FormatUtil formatUtil = null;

	private String getForwardPage(ActionMapping mapping, ActionForm actionForm, AdminBookingLogUim form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
		try {
			pageAction = form.getCurrPageAction();
			this.request = request;
			this.formatUtil = new FormatUtil(request, response);
			if (LOAD_ADMIN.equals(pageAction)) {
				forwardPage = loadAdminPage(form, request);
				return forwardPage;
			}else if(FILE_LOG.equals(pageAction)) {
				AdminBookingLogDao dao = null;
				try {
					dao = (AdminBookingLogDao) getDao(AdminBookingLogDao.DAO_NAME);
				} catch (Exception ex) {
					throw ex;
				}
				List<AdminBookingFileLogMod> result =dao.getBookingFileLog(form);
				net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
				jsonObj = new net.sf.json.JSONObject();
				jsonObj.put("dataResult", result);
				 
				response.setContentType("application/json");
				jsonObj.write(response.getWriter());
			}
			else {
				AdminBookingLogDao dao = null;
				try {
					dao = (AdminBookingLogDao) getDao(AdminBookingLogDao.DAO_NAME);
				} catch (Exception ex) {
					throw ex;
				}

				List<AdminBookingLogMod> result = dao.getBookingLog(form);
				 
				net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
				jsonObj = new net.sf.json.JSONObject();
				jsonObj.put("dataResult", result);
				 
				response.setContentType("application/json");
				jsonObj.write(response.getWriter());
			}
		} catch (Exception ex) {
			throw ex;
		}
		return null;
	}

	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String pageAction = null;
		String errorMsg = null;
		AdminBookingLogUim form = null;
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

	private AdminBookingLogUim getForm(ActionForm actionForm) throws Exception {
		AdminBookingLogUim form = null;
		try {
			form = (AdminBookingLogUim) actionForm;
			if (form == null) {
				form = new AdminBookingLogUim();
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

	private String loadAdminPage(AdminBookingLogUim form, HttpServletRequest request) {
		 
			 
		 

		return SUCCESS;

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

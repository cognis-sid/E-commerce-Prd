package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.eservice.dao.InternalUserProfileDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.LoginDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.InternalUserMod;
import com.rclgroup.dolphin.rcl.web.util.WebUtils;

public class InternalUserProfileSvc extends BaseAction {

	String forwardPage = null;
	private HttpServletRequest request;
	private static final String UPDATEUSER = "updateUserProfile";
	private static final String RESETPASSWORD = "passwordReset";
	private static final String UPDATEPASSWORD = "updatePasswordReset";

	private String getForwardPage(ActionMapping mapping, ActionForm actionForm, InternalUserMod form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
		try {
			pageAction = form.getCurrPageAction();
			this.request = request;
			if (UPDATEUSER.equals(pageAction)) {
				forwardPage = updateUser(form, request);
			} else if (RESETPASSWORD.equals(pageAction)) {
				forwardPage = getUserPassword(form, request);
			} else if (UPDATEPASSWORD.equals(pageAction)) {
				forwardPage = updateUserPassword(form, request);
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
		InternalUserMod form = null;
		try {
			pageAction = getPageAction(mapping);

			form = getForm(actionForm);
			form.setCurrPageAction(pageAction);
			forwardPage = getForwardPage(mapping, actionForm, form, request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
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

	private String getUserPassword(InternalUserMod form, HttpServletRequest request2) {

		InternalUserProfileDao dao = null;
		dao = (InternalUserProfileDao) getDao(InternalUserProfileDao.DAO_NAME);
		String user = WebUtils.getUserNew(request).getUserId();
		InternalUserMod userMod = (InternalUserMod) dao.getUserForUserProfile(user);

		if (userMod != null) {
			forwardPage = SUCCESS;

			form.setErrorMessage("");
			form.setLoginId(userMod.getLoginId());

		} else
			forwardPage = FAILURE;

		return forwardPage;
	}

	private String updateUserPassword(InternalUserMod form, HttpServletRequest request2) {

		InternalUserProfileDao dao = null;
		LoginDao daoObj = null;
		// UserMod form = null;

		try {
			form = getForm(form);
			dao = (InternalUserProfileDao) getDao(InternalUserProfileDao.DAO_NAME);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			dao.updateUserForUserPassword(form);
			daoObj = (LoginDao) getDao(LoginDao.DAO_NAME);
			String userId = form.getLoginId();
			String pwd = form.getPassword();
			UserAccountBean userAcc = daoObj.getAdminUser(userId, pwd, form);
			request.getSession(false).setAttribute(USER_ACCOUNT_BEAN, null);
			request.getSession(false).setAttribute(USER_ACCOUNT_BEAN, userAcc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}

	private static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}

	private String getUser(InternalUserMod form, HttpServletRequest request) throws Exception {
		String forwardPage = null;
		InternalUserProfileDao dao = null;
		List<ContryMod> contryList = new ArrayList<>();

		List<String> contryList1 = null;
		// UserMod form = null;
		try {
			form = getForm(form);
			dao = (InternalUserProfileDao) getDao(InternalUserProfileDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}
		String user = WebUtils.getUserNew(request).getUserId();
		// UserAccountBeanNew user = WebUtils.getUserNew(request);
		InternalUserMod userMod = (InternalUserMod) dao.getUserForUserProfile(user);
		contryList = dao.getCountryCodeNameList();// dao.getCountryList(user);

		// form.setContryList(contryList);

		System.out.println(userMod.toString());

		if (userMod != null) {
			forwardPage = SUCCESS;

			form.setLoginId(userMod.getLoginId());
			form.setPassword(userMod.getPassword());
			form.setUserName(userMod.getUserName());
			form.setEmail(userMod.getEmail());
			contryList1 = new ArrayList<>();

			for (ContryMod s1 : contryList) {
				String codeName = s1.getContryName() + "-" + s1.getCode();
				contryList1.add(codeName);

			}
			for (int i = 0; i < userMod.getLocation().length; i++) {
				String loc = userMod.getLocation()[i];
				String locArray[] = loc.split("#");
				form.setLocation(locArray);
				for (int i1 = 0; i1 < form.getLocation().length; i1++) {
					String s = form.getLocation()[i1];

					if (contryList1.contains(s))
						contryList1.remove(s);

				}
			}

			contryList1.removeAll(contryList);
			request.setAttribute("contryList", contryList1);
		}
		return forwardPage;

	}

	private String updateUser(InternalUserMod form, HttpServletRequest request) throws Exception {
		InternalUserProfileDao dao = null;
		try {
			form = getForm(form);
			dao = (InternalUserProfileDao) getDao(InternalUserProfileDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}

		List<ContryMod> contryList = dao.getCountryCodeNameList();

		if (contryList.contains(form.getLocation())) {
			contryList.remove(form.getLocation());
		}

		try {
			dao.getUpdateUserForUserProfile(form);
			form.setErrorMessage("");
		} catch (Exception e) {
			form.setErrorMessage("Failed..");
			e.printStackTrace();
		}

		return forwardPage = getUser(form, request);

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

}

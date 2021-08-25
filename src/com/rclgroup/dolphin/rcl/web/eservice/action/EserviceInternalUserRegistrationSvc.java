/*------------------------------------------------------
EserviceInternalUserRegistrationSvc.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
---Author Joga 16/06/21*/

package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.ComboVO;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInternalUserRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInternalUserRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.RegistrationOrclDao;

public class EserviceInternalUserRegistrationSvc extends BaseAction {
	private final String COUNTRY_LIST = "countryList";

	private String getForwardPage(EserviceInternalUserRegistrationUim form, HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm) throws Exception {
		String pageAction = null;
		String forwardPage = null;

		try {
			pageAction = form.getCurrPageAction();

			if ("onload".equals(pageAction)) {
				forwardPage = initRegistration(form, request);
			} else if ("checkAvailableUserId".equals(pageAction)) {
				forwardPage = checkAvailableUserId(request, response);
			} else if ("registration".equals(pageAction)) {
				forwardPage = registration(form, request);
			} else {
				forwardPage = logout(form, request);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return forwardPage;
	}

	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) {
		EserviceInternalUserRegistrationUim form = null;

		String pageAction = null;
		String forwardPage = null;
		try {
			pageAction = getPageAction(mapping);

			form = getForm(actionForm, pageAction);
			form.setCurrPageAction(pageAction);

			forwardPage = getForwardPage(form, request, response, actionForm);
		} catch (Exception ex) {
			ex.printStackTrace();

			forwardPage = form.getPrevPageAction();
			if ((forwardPage == null) || ("".equals(forwardPage))) {
				forwardPage = "initRegistration";
			}
		}

		return mapping.findForward(forwardPage);
	}

	public String initRegistration(EserviceInternalUserRegistrationUim form, HttpServletRequest request)
			throws Exception {

		System.out.println("[EserviceInternalUserRegistrationSvc][initRegistration][Begin]");

		List<ComboVO> countryList = null;
		EserviceInternalUserRegistrationDao objDao = null;
		String userId = null;
		String errorDesc = null;
		String forwardPage = null;
		try {

			objDao = getDao();
			form.setUserLoginId(userId);
			form.setContryList(objDao.getCountryCodeNameList());
			forwardPage = SUCCESS;
		} catch (Exception ex) {
			errorDesc = ex.getMessage();
			throw ex;
		} finally {
			if (countryList != null) {
				form.setCountryList(countryList);
			}

			form.setErrMsg(errorDesc);
			request.setAttribute("userIdPassed", "false");
			request.setAttribute("userIdChecked", "false");
			request.getSession().setAttribute(COUNTRY_LIST, countryList);
			System.out.println("[EserviceInternalUserRegistrationSvc][initRegistration][End]");
		}

		return forwardPage;
	}

	public String checkAvailableUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EserviceInternalUserRegistrationDao dao = null;

		Map resultMap = null;
		PrintWriter out = null;

		String userIdPassed = "false";
		String userIdChecked = "false";
		String userId = null;
		String errorMsg = BLANK;
		String resultFlag = NO;
		try {
			userId = request.getParameter("userId");
			if (userId != null && !BLANK.equals(userId)) {
				dao = getDao();
				if (dao != null) {
					resultMap = dao.checkAvailableUserId(userId);
				}
			}
		} catch (IOException io) {
			errorMsg = io.getMessage();
		} finally {
			if (resultMap != null && !resultMap.isEmpty()) {
				resultFlag = (String) resultMap.get(EserviceInternalUserRegistrationDao.P_O_V.FLAG);
				if (resultFlag != null && !BLANK.equals(resultFlag)) {
					if (YES.equals(resultFlag)) {
						errorMsg = (String) resultMap.get(EserviceInternalUserRegistrationDao.P_O_V.ERR_DESC);
					} else {
						errorMsg = BLANK;
						userIdPassed = "true";
						userIdChecked = "true";
					}
				} else {
					errorMsg = (String) resultMap.get(EserviceInternalUserRegistrationDao.P_O_V.ERR_DESC);
				}
			} else {
				errorMsg = BLANK;
			}

			request.setAttribute("userIdPassed", userIdPassed);
			request.setAttribute("userIdChecked", userIdChecked);

			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");

			out = response.getWriter();
			out.print(errorMsg);
			System.out.println("Error Msg = " + errorMsg);
		}
		return null;
	}

	public String registration(EserviceInternalUserRegistrationUim form, HttpServletRequest request) throws Exception {
		System.out.println("[EserviceRegistrationSvc][registration][Begin]");

		EserviceInternalUserRegistrationDao dao = null;
		RegistrationOrclDao daoOrl = null;
		Map resultMap = null;
		String errCode = null;
		String errMsg = null;
		String forwardPage = null;
		boolean isOldPwdPass = true;

		try {
			dao = getDao();
			daoOrl = getDaoOrl();
			if (errMsg == null) {
				resultMap = insertRegistration(form, dao, daoOrl);
			} else {
				resultMap = new HashMap<String, String>();
				resultMap.put(EserviceInternalUserRegistrationDao.P_O_V.ERR_CD, "EXCEPTION");
				resultMap.put(EserviceInternalUserRegistrationDao.P_O_V.ERR_DESC, errMsg);
			}

			if (resultMap != null) {
				if (resultMap.containsKey(EserviceInternalUserRegistrationDao.P_O_V.ERR_CD)) {
					errCode = (String) resultMap.get(EserviceInternalUserRegistrationDao.P_O_V.ERR_CD);
					if (errCode != null && !BLANK.equals(errCode)) {
						errMsg = (String) resultMap.get(EserviceInternalUserRegistrationDao.P_O_V.ERR_DESC);
					}
				}
			} else {
				errMsg = "Process fail.";
			}
		} catch (Exception ex) {
			errMsg = ex.toString();
			ex.printStackTrace();
		} finally {
			if (errMsg != null && !BLANK.equals(errMsg)) {
				form.setSubmitSuccess("false");

				forwardPage = FAILURE;
			} else {
				form.setSubmitSuccess("true");

				forwardPage = SUCCESS;
			}
			form.setErrMsg(errMsg);
			if (form.getCountryList() == null || form.getCountryList().isEmpty() || form.getCountryList().size() == 1) {
				form.setCountryList((List<ComboVO>) request.getSession().getAttribute(COUNTRY_LIST));
			}

			System.out.println("[EserviceRegistrationSvc][registration][End]");
		}
		return forwardPage;
	}

	private Map insertRegistration(EserviceInternalUserRegistrationUim form, EserviceInternalUserRegistrationDao dao,
			RegistrationOrclDao daoOrl) throws Exception {

		System.out.println("[EserviceRegistrationSvc][insertRegistration][Begin]");

		Map resultMap = null;
		Map<String, String> mapParams = null;
		String passwordEncrypted = null;

		try {
			passwordEncrypted = EncryptDecryptUtil.convertStringToHex(form.getPassword());
			mapParams = new HashMap<String, String>();

			mapParams.put(EserviceInternalUserRegistrationDao.P_I_V.NAME, form.getName().trim());
			mapParams.put(EserviceInternalUserRegistrationDao.P_I_V.USR_ID, form.getUserLoginId().trim());
			mapParams.put(EserviceInternalUserRegistrationDao.P_I_V.PASSWORD, passwordEncrypted);
			mapParams.put(EserviceInternalUserRegistrationDao.P_I_V.EMAIL, form.getEmail());
			// mapParams.put(EserviceRegistrationDao.P_I_V.LOCATION , form.getLocation());

			resultMap = dao.insertRegistration(mapParams, form, daoOrl);
			form.setContryList(dao.getCountryCodeNameList());

		} catch (Exception ex) {
			throw ex;
		} finally {
			System.out.println("[EserviceRegistrationSvc][insertRegistration][End]");
		}
		return resultMap;
	}

	private EserviceInternalUserRegistrationUim getForm(ActionForm actionForm, String pageAction) throws Exception {
		EserviceInternalUserRegistrationUim form = null;
		try {
			form = (EserviceInternalUserRegistrationUim) actionForm;
			if (form == null) {
				form = new EserviceInternalUserRegistrationUim();
			} else if ("onload".equals(pageAction) || "manageAccount".equals(pageAction)) {
				form.resetForm();
			}
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

	private EserviceInternalUserRegistrationDao getDao() throws Exception {
		EserviceInternalUserRegistrationDao dao = null;
		try {
			dao = (EserviceInternalUserRegistrationDao) getDao(EserviceInternalUserRegistrationDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}
		return dao;
	}

	private RegistrationOrclDao getDaoOrl() throws Exception {
		RegistrationOrclDao dao = null;
		try {
			dao = (RegistrationOrclDao) getDao("RegistrationOrclDao");
		} catch (Exception ex) {
			throw ex;
		}
		return dao;
	}

	public String logout(EserviceInternalUserRegistrationUim form, HttpServletRequest request) {

		request.getSession().setAttribute(USER_ACCOUNT_BEAN, null);
		request.getSession(false).invalidate();

		return SUCCESS;

	}

}

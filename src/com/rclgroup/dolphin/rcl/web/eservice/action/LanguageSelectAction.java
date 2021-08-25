package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.action.BaseAction;

public class LanguageSelectAction extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String language = request.getParameter("language");
		System.out.println("============        LanguageSelectAction            =========");
		request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
		if ("cn".equalsIgnoreCase(language)) {
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.SIMPLIFIED_CHINESE);
		} else if ("th".equals(language)) {
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.TAIWAN);
		}

		return mapping.findForward(SUCCESS);
	}

}
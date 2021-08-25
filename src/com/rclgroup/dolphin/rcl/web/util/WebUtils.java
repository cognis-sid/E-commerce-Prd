package com.rclgroup.dolphin.rcl.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.niit.control.common.GlobalConstants;
import com.niit.control.web.UserAccountBean;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserAccountBeanNew;

public class WebUtils implements GlobalConstants{

	public static UserAccountBean getUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		 UserAccountBean account = (UserAccountBean) session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
		 return account;
	}
	
	public static UserAccountBeanNew getUserNew(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserAccountBeanNew account = (UserAccountBeanNew) session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
		 return account;
	}
}

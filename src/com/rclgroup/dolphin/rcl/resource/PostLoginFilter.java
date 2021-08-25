/*
  * @(#)PostLoginFilter.java
  *
  * Copyright 2009 by NIIT.,
  * All rights reserved.
  *
  * This software is the confidential and proprietary information
  * of NIIT Tech. Ltd ("Confidential Information").
  */

package com.rclgroup.dolphin.rcl.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.control.common.GlobalConstants;

/**
 * @version 1.0
 * @author NIIT
 */
public class PostLoginFilter implements Filter ,GlobalConstants  {
	private String appId;
	private List<String> loginURls=new ArrayList<>();

	/**
	 * @see javax.servlet.Filter#void ()
	 */
	public void destroy() {

	}

	/**
	 * @see javax.servlet.Filter#void (javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		loginURls.add("/servadmin00666");
		loginURls.add("/adminserv009");
		loginURls.add("/adminBookingLog");
		loginURls.add("/adminBookingFileSearch");
		loginURls.add("/adminBookingLogSearch");
		loginURls.add("/serv00111");
		loginURls.add("/serv00111loingInUser");
		loginURls.add("/sexn007");
		loginURls.add("/serv009");
		loginURls.add("/sexn007CheckAvailableUserId");
		loginURls.add("/sexn007CheckCustomerCode");		
		loginURls.add("/sexn007Registration");
		loginURls.add("/serv00666");
		loginURls.add("/serv00222");
		loginURls.add("/serv007OpenAcknowledge");		
		
		loginURls.add("/sexn333CreatePolPod");
		loginURls.add("/sexn333deletePolPod");
		loginURls.add("/sexn007CheckAvailableUserId");
		loginURls.add("/sexn007CheckCustomerCode");		
		loginURls.add("/sexn007Registration");
		loginURls.add("/logoutservAdm"); 
		// this hack
		loginURls.add("/search");
		loginURls.add("/serv0555");
		loginURls.add("/servAdminLogin");
		loginURls.add("/servAdmin");
		loginURls.add("/serv0031");
		loginURls.add("/serv0031create");
		loginURls.add("/serv0031chkuser");
		HttpServletRequest hreq = null;
		HttpServletResponse httpResponse = null;
		HttpSession session = null;

		hreq = (HttpServletRequest) req;
		//Locale.setDefault(Locale.ENGLISH); /* Get UAB from Session */
		/*if (!VAMPageConfigProperties.listOfPages.contains(req.getServletPath()) || req.getServletPath().indexOf(ch)) 
		{
			request.setAttribute("errorMessage", "UserDoesno exi");
			request.getRequestDispatcher("errorPage404.do").forward(request, response);
		}*/
		 String path =hreq.getPathInfo();
//		 boolean isNotLogin=path.indexOf("serv00444")==-1 || path.indexOf("serv00111")==-1;
		if(!loginURls.contains(path) ){
		if (hreq.getSession().getAttribute(USER_ACCOUNT_BEAN) == null) {		
			req.getRequestDispatcher("/do/serv00111").forward(req, resp);
			return ;
			
		}
		}
		chain.doFilter(req, resp);
	
		 

	}

	 
	/**
	 * Method init.
	 * 
	 * @param config
	 * @throws javax.servlet.ServletException
	 */
	public void init(FilterConfig config) throws ServletException {

	}
}

/*
 * Modification History
 *
 * 2005-07: Modified for Tops 2009-11: Moified for EZL
 *
 */

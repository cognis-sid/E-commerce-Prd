package com.rclgroup.dolphin.rcl.web.eservice.action;



	

	import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.action.BaseAction;

	public class WebSearchSrv extends BaseAction {

		public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			System.out.println("============        WebSearchSrv            =========");
			String forwardPage = null;
			
			

				forwardPage = SUCCESS;
			
			return mapping.findForward(forwardPage);

			
		}

	}

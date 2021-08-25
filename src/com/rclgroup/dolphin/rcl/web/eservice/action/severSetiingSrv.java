package com.rclgroup.dolphin.rcl.web.eservice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.resource.AccessControl;

public class severSetiingSrv extends BaseAction{
	
	private static final String LOAD       				= "onLoad";
	private static final String RESTART_SCHEDULAR       = "reStartSchedular";
	
	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
        String forwardPage = SUCCESS;
        
		pageAction = mapping.getParameter();
		if(LOAD.equals(pageAction)) {
			return mapping.findForward(forwardPage);
		}else if (RESTART_SCHEDULAR.equals(pageAction)) {
			AccessControl.reSetSchedular();
        } else{
        	AccessControl.loadStarting();
        } 
		
		return mapping.findForward(forwardPage);
	}
	
	
	

}

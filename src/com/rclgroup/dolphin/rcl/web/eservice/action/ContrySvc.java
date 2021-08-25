package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.TerminalMod;

public class ContrySvc extends BaseAction {

	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("============        ContrySvc            =========");

		
		
		EserviceNewWebBookingDao dao = null;
		try {
			dao = (EserviceNewWebBookingDao) getDao(EserviceNewWebBookingDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}

		List<ContryMod> result = dao.getContry();
		List<TerminalMod> resultTerminal = dao.getTeminal();
		System.out.println("Result Contry List         " + result.size());
		System.out.println("Result Terminal List         " + resultTerminal.size());
		net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
		jsonObj = new net.sf.json.JSONObject();
		jsonObj.put("dataResult", result);
		jsonObj.put("terminalResult", resultTerminal);
		response.setContentType("application/json");
		jsonObj.write(response.getWriter());
		//

		return null;
	}

}
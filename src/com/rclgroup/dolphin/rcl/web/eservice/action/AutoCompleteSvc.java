package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.GlobalConstants;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.AutoCompleteUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AutoCompleteVO;

public class AutoCompleteSvc extends BaseAction implements GlobalConstants {

	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forwardPage = FAILURE;
		String pageAction = null;
		
		AutoCompleteUim objForm=(AutoCompleteUim) actionForm;
		
		pageAction = getPageAction(mapping);
		
		if(pageAction.equals("aoutcomletion")) {
			forwardPage = getPassword(objForm,request,response);
		}
		
		return mapping.findForward(forwardPage);
	}

	private String getPassword(AutoCompleteUim objForm,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		EserviceNewWebBookingDao dao =(EserviceNewWebBookingDao) getDao(EserviceNewWebBookingDao.DAO_NAME);
		System.out.println("action "+ objForm.getAction());
		System.out.println("key "+ objForm.getKyePress());
		
		List<AutoCompleteVO> result =  dao.getPolList(objForm.getKyePress());
		System.out.println("Result Contry List         " + result.size());
		
		net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
		jsonObj = new net.sf.json.JSONObject();
		jsonObj.put("dataResult", result);

		response.setContentType("application/json");
		jsonObj.write(response.getWriter());
		
		return null;
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
	
	
}

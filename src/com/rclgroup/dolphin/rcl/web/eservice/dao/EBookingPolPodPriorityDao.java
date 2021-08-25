/*------------------------------------------------------
 EBookingPolPodPriorityDao.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2021
--------------------------------------------------------
Author -joga
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInquiryWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePolPodPriorityUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDaoImpl.CountruCombod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePolPodPriorityMod;

public abstract interface EBookingPolPodPriorityDao {
	
	public static final String DAO_NAME = "EBookingPolPodPriorityDao";
	 public static final String KEY_POL_POD_DATA         = "DATA";
	 public static final String KYE_POL_POD_ERROR_CODE  ="p_i_v_error";
	 
	public String insertPolPodPriority(EservicePolPodPriorityUim form)throws BusinessException, DataAccessException;

	public String updatePolPodPriority(EservicePolPodPriorityUim form) throws BusinessException, DataAccessException;
	
	public Map getAllPolPodPriority();
	
	public Map getAllPolPodPriority(EservicePolPodPriorityUim form);

	public void deletePolPod(EservicePolPodPriorityUim formObj);
	
	public EservicePolPodPriorityUim getPodPolPriority(EservicePolPodPriorityUim eservicePolPodPriorityUim);
	
	public Map getSearchData(String pol,String pod,String service);
	
		
	public List<ContryMod> getCountryCodeNameList();

}

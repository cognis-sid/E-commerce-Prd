package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import com.niit.control.web.UserAccountBean;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceSearchApiServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.InternalUserMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserAccountBeanNew;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

public interface LoginDao {

	public static final String DAO_NAME = "LoginDao";
	
	public static final String  URL_QUERY="SELECT PROPERTY FROM CONFIG_URL WHERE PROPERTY_PK=?";

	public UserAccountBean getUser(String userId, String pwd,UserMod userMod);

	public UserAccountBean getPassword(String userId, String email);

	public String getUrlWebServices();

	public Map getCheckPolPod(String pol, String pod);
	
	
	// this for Admin user login
	
	public UserAccountBean getAdminUser(String userId, String email,InternalUserMod form);
	
	public UserAccountBean getInternalUserPassword(String userId, String email);

}

package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import com.niit.control.common.ComboVO;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

public interface UserProfileDao {
	
	 public static final String UPDATE_PASSWORD	= "UPDATE esm_user_login SET last_login_date=NOW() ,pswd=? WHERE user_id =?  ";
	
	 public static final String GET_PASSWORD="select pswd from esm_user_login where user_id =?";
	 
	 public static final String DAO_NAME = "UserProfileDao";

     public UserMod getUserForUserProfile(String userId) ;
	
	 public String getUpdateUserForUserProfile(Map<String, String> mapParams, UserMod user, RegistrationOrclDao daoOrl, UserProfileDao dao);

	 public List<ComboVO> getCountryList(String user);

	 public String updateUserForUserPassword(UserMod form) throws Exception;
}

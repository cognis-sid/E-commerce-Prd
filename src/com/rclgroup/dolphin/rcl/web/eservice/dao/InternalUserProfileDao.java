package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;

import com.niit.control.common.ComboVO;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.InternalUserMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

public interface InternalUserProfileDao {
	
	 public static final String UPDATE_PASSWORD	= "UPDATE esm_user_login SET last_login_date=NOW() ,pswd=? WHERE user_id =?  ";
	
	 public static final String GET_PASSWORD="select pswd from esm_user_login where user_id =?";
	 
	 public static final String DAO_NAME = "InternalUserProfileDao";

     public InternalUserMod getUserForUserProfile(String userId) ;
	
	 public String getUpdateUserForUserProfile(InternalUserMod u);

	 public List<ComboVO> getCountryList(String user);

	 public String updateUserForUserPassword(InternalUserMod form) throws Exception;
	 public List<ContryMod> getCountryCodeNameList();
}

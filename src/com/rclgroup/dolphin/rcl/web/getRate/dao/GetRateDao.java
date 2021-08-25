package com.rclgroup.dolphin.rcl.web.getRate.dao;

import com.niit.control.web.UserAccountBean;
import com.rclgroup.dolphin.rcl.web.getRate.actionForm.GetRateUim;

public interface GetRateDao {

	public static final String DAO_NAME = "GetRateDao";

	public void saveData(GetRateUim getRateUim,UserAccountBean  userAcc);
	
	public String genrateQuatation(GetRateUim getRateUim,UserAccountBean  userAcc);

}

package com.rclgroup.dolphin.rcl.web.getRate.dao;

import java.util.Date;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.web.UserAccountBean;
import com.rclgroup.dolphin.rcl.web.getRate.actionForm.GetRateUim;

public class GetRateDaoImpl extends AncestorJdbcDao implements GetRateDao {

	public void saveData(GetRateUim rateUim,UserAccountBean  userAcc) {
		String sqlQuery = "insert into RATE_INQUIRY (POL_from, POD_to, CONTAINER_SIZE_20, CONTAINER_SIZE_40, CONTAINER_SIZE_45, USD_20, USD_40, USD_45, QUOTATION_NUMBER, QUOTATION_REFERENCE, RECORD_STATUS,RECORD_ADD_USER,RECORD_ADD_DATE,RECORD_CHANGE_USER,RECORD_CHANGE_DATE)"
				+ "values ( ?, ?, ?,?, ?,?,?, ?, ?, ?,?, ?, ?, ?,?)";

		getJdbcTemplate().update(sqlQuery,
				new Object[] { rateUim.getPol(), rateUim.getPod(),
						(rateUim.getContainerSize20GP() != 0) ? rateUim.getContainerSize20GP() : null,
						(rateUim.getContainerSize40GP() != 0) ? rateUim.getContainerSize40GP() : null,
						(rateUim.getContainerSize40HC() != 0) ? rateUim.getContainerSize40HC() : null,
						(rateUim.getUsd20GP() != null) ? rateUim.getUsd20GP() : null,
						(rateUim.getUsd40GP() != null) ? rateUim.getUsd40GP() : null,
						(rateUim.getUsd40HC() != null) ? rateUim.getUsd40HC() : null, rateUim.getQuotationNo(), rateUim.getQuotationRef(),
						"A", userAcc.getUserId(), new Date(), "", null });
		System.out.println("sqlQuery   " + sqlQuery);

	}
	
	@Override
	public String genrateQuatation(GetRateUim getRateUim, UserAccountBean userAcc) {
		 String MAX_RATE_INQUIRY="Select nextval('RATE_Quotation_SEQUENCE')";
		long number =getJdbcTemplate().queryForInt(MAX_RATE_INQUIRY);
		String genrateQuatation="RCL"+getRateUim.getPol().substring(2)+number;
		return genrateQuatation;
	}

}
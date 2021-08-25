package com.rclgroup.dolphin.rcl.web.eservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.AncestorJdbcDao;

public class EserviceRegistrationDaoImplOrcle extends AncestorJdbcDao{
	
	public  JdbcTemplate getDataSourceOrcl() {
		return getJdbcTemplate();
	}
	

}

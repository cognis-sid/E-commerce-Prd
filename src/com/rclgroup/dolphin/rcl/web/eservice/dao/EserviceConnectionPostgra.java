package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.niit.control.dao.AncestorJdbcDao;

public class EserviceConnectionPostgra extends AncestorJdbcDao{
	
	
	
	public  Connection getConnectionObj() throws SQLException{
	
	Connection con = getJdbcTemplate().getDataSource().getConnection();
	return con;
	}
}

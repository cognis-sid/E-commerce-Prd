package com.rclgroup.dolphin.rcl.web.eservice.action;

import org.springframework.dao.DataAccessException;

import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.resource.AccessControl;

public class EservicePropertyFatchOperation extends AncestorJdbcDao{

	private static String fileLocation="/ApplTop/ESV/ATTACHMENT";
	public static String ip ;
	public static String userId ;
	public static String password ;
	
	public static String bookingIn;
	public static String bookingInBackup;
	public static String bookingOut ;
	public static String bookingOutBackUp ;
	public static String bookingErrorOutBackUp;
	
	public static String shiipingIn;
	public static String shiipingInBackUp;
	public static String shiipingOut;
	public static String shiipingoutBackUp;
	public static String shippingErrorOutBackUp;
	
	public static String defaultaMailId;
	


 

	public static void getAllpropertyData() throws DataAccessException{
		
		String ip_query = "select property from CONFIG_URL where property_pk=3";
		String userId_query = "select property from CONFIG_URL where property_pk=4";
		String password_query = "select property from CONFIG_URL where property_pk=5";
		
		String bookingIn_query="select property from CONFIG_URL where property_pk=6";
		String bookingInBackup_query="select property from CONFIG_URL where property_pk=7";
		String bookingOut_query = "select property from CONFIG_URL where property_pk=8";
		String outBackUp_query = "select property from CONFIG_URL where property_pk=9";
		String errorOutBackUp_query = "select property from CONFIG_URL where property_pk=23";
		
		String shiipingIn_query = "select property from CONFIG_URL where property_pk=10";
		String shiipingInBackup_query = "select property from CONFIG_URL where property_pk=11";
		String shiipingOut_query = "select property from CONFIG_URL where property_pk=12";
		String shiipingoutBackUp_query = "select property from CONFIG_URL where property_pk=13";
		String shippingErrorOutBackUp_query = "select property from CONFIG_URL where property_pk=24";
		
		String default_mail_id="select property from CONFIG_URL where property_pk=15";
		
		String filelocationSQL = "select property from CONFIG_URL where property_pk=14";
		
		ip = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(ip_query,Object.class);
		userId = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(userId_query,Object.class);
		password = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(password_query,Object.class);
		
		bookingIn=(String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(bookingIn_query,Object.class);
	    bookingInBackup=(String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(bookingInBackup_query,Object.class);		
		bookingOut = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(bookingOut_query,Object.class);
		bookingOutBackUp = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(outBackUp_query,Object.class);
		bookingErrorOutBackUp = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(errorOutBackUp_query,Object.class);
		  
		shiipingIn=(String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(shiipingIn_query,Object.class);
		shiipingInBackUp=(String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(shiipingInBackup_query,Object.class);		
		shiipingOut = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(shiipingOut_query,Object.class);
		shiipingoutBackUp = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(shiipingoutBackUp_query,Object.class);
		shippingErrorOutBackUp = (String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(shippingErrorOutBackUp_query,Object.class); 
		
		defaultaMailId=(String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(default_mail_id,Object.class);
		
		fileLocation=(String) AccessControl.dbConnection.getJdbcTemplate().queryForObject(filelocationSQL,Object.class);

		System.out.println("ip "+ip);
		System.out.println("userId "+userId);
		System.out.println("password "+password);
		System.out.println("bookingIn "+bookingIn);
		System.out.println("bookingOut "+bookingOut);
		System.out.println("bookingOutBackUp "+bookingOutBackUp);
		System.out.println("bookingInBackup "+bookingInBackup);
		System.out.println("bookingErrorOutBackUp "+bookingErrorOutBackUp);
		System.out.println("shiipingIn "+shiipingIn);
		
	}

	public static String getFileLocation() {
		return fileLocation;
	}

}

package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.jdbc.core.RowMapper;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.web.UserAccountBean;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceSearchApiServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.InternalUserMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserAccountBeanNew;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;

public class LoginDaoImpl extends AncestorJdbcDao implements LoginDao {

	private Object List;
	
	
	public UserAccountBean getAdminUser(String userId, String pwd,InternalUserMod form ) {
		List<UserAccountBean> listOfUser  = null;
		try {
			String password=EncryptDecryptUtil.convertStringToHex(pwd);
		
		
		String sqlQuery = "select  login_id,user_name ,pswd,location from esm_admin_login where LOWER(login_id)=? and pswd=?";
				
		System.out.println("pwd "+pwd+" userId -->"+userId+"Login useer getAdminUser "+sqlQuery);
		 listOfUser = getJdbcTemplate().query(sqlQuery, new Object[] {userId.toLowerCase(),password}, new RowMapper() {
			
			@Override
			public UserAccountBeanNew mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				UserAccountBeanNew bean = new UserAccountBeanNew();
				bean.setUserId(rs.getString("login_id"));
				bean.setUserName(rs.getString("user_name"));
				bean.setPassword(rs.getString("pswd"));
				bean.setLocation(rs.getString("location"));
				bean.setDateFormat("12/12/2021");
				return bean;
			}
		});
		
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		if(CollectionUtils.isEmpty(listOfUser)) {
			return null;
		}
		
		return listOfUser.get(0);
	}
	
	public UserAccountBean getUser(String userId, String pwd,UserMod userMod) {
		
		try {
			String password=EncryptDecryptUtil.convertStringToHex(pwd);
		
		
		String sqlQuery = "select a.vgm, a.fsc_code,a.org_type, a.country, a.agent,a.line,a.trade,a.last_login_date, a.user_id,a.pswd, a.record_status,a.user_name,a.last_login_date,a.company_name,a.email_id1,a.phone,a.fax,c.date_rang_bkg,c.date_rang_esi,a.org_code,a.company_name,a.get_rates,a.web_booking "
				+ "from esm_user_login a ,SEALINER.ITP010 b,vasapps.date_config c"
				+ " where b.CUCUST = a.ORG_CODE "
						+ "and UPPER(a.user_id)='"+ userId.toUpperCase() + "' "
						+ "and  b.CURCST='A' "
						+ "and a.record_status='A' "
						+ "and UPPER(a.pswd)='"+password.toUpperCase()+"'";
		System.out.println("Login useer "+sqlQuery);
		List<UserAccountBean> user = getJdbcTemplate().query(sqlQuery, new Object[] {}, new UserMapper());
		
		if (user.size() > 0) {
			 if(user.get(0).getDateFormat()!=null && !user.get(0).getDateFormat().equals(""))  {
				 String lastUpdateQuery= "update  esm_user_login set last_login_date = now() where user_id='"
							+ userId + "'  and record_status='A'";
					getJdbcTemplate().update(lastUpdateQuery);
					System.out.println("Update LastLogin Date "+lastUpdateQuery);
					return user.get(0); 
			 }else {
				 return user.get(0); 
			 }
		}else {
			userMod.setErrorMessage("User Does not exist");	
			sqlQuery = "select count(*) from esm_user_login where UPPER(user_id)='"	+ userId.toUpperCase() + "'";
			System.out.println("Login useer "+sqlQuery);
			int count= getJdbcTemplate().queryForInt(sqlQuery);
			if(count==0) {			 
				userMod.setErrorMessage("USER_DO_NOT_EXIST");			 
			}else {
				sqlQuery = "select count(*) from esm_user_login  where UPPER(user_id)='"	+ userId.toUpperCase() + "'  and  record_status='A'";
				System.out.println("Login useer "+sqlQuery);
				count= getJdbcTemplate().queryForInt(sqlQuery);
				if(count==0) {			 
					userMod.setErrorMessage("USER_IS_NOT_APPROVE");			 
				}else {
					sqlQuery = "	SELECT COUNT(*)   FROM SEALINER.ITP010, SEALINER.SC_PRSN_LOG_INFO  " + 
							"					 WHERE CUCUST = ORG_CODE AND PRSN_LOG_ID =  '"+userId.toUpperCase()+"' " + 
							"					 AND CURCST='S' AND RCST='A'	";
					count= getJdbcTemplate().queryForInt(sqlQuery);
					if(count>0) {
						userMod.setErrorMessage("THIS_ACCOUNT_SUSPENDED");		
					}else {
						sqlQuery = "select pswd from esm_user_login  where UPPER(user_id)='"	+ userId.toUpperCase() + "'  and  record_status='A' " ;
						System.out.println("Login useer "+sqlQuery);
						String dbPassword= (String)getJdbcTemplate().queryForObject(sqlQuery,Object.class);
						if(!dbPassword.equalsIgnoreCase(password)) {			 
							userMod.setErrorMessage("WRONG_PASSWORD");			 
						}
					}
				}
				
			}
			
			
			return null;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	};
	
	public UserMod getUserForUserProfile(String userId) {
		String sqlQuery = "select user_id,pswd,user_name,company_name,email_id1,phone,city,state, country ,cmp_address1,cmp_address2 from esm_user_login where user_id='"
				+ userId + "' and record_status='A'";
		

		List<UserMod> user = getJdbcTemplate().query(sqlQuery, new Object[] {}, new UserProfileMapper());
		System.out.println("sqlQuery   "+sqlQuery);
		if (user.size() > 0) {
			return user.get(0);
		}
		else
			return null;
	};

	public class UserMapper extends JdbcRowMapper {

		public UserAccountBeanNew mapRow(ResultSet rs, int row) throws SQLException {
			UserAccountBeanNew obj = new UserAccountBeanNew();
			obj.setUserId(rs.getString("user_id"));
			obj.setPassword(rs.getString("pswd"));
			obj.setUserName(rs.getString("user_name"));
			obj.setCustomerName(rs.getString("user_name"));
			SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			if(null!=rs.getTimestamp("last_login_date")) {
			obj.setDateFormat(sm.format(rs.getTimestamp("last_login_date")));
			}
			obj.setCompanyName(rs.getString("company_name"));
			obj.setMailId(rs.getString("email_id1"));
			obj.setAgent(rs.getString("agent"));
			obj.setTrade(rs.getString("trade"));
			obj.setLine(rs.getString("line"));
			obj.setPhoneNumber(rs.getString("phone"));
			obj.setFaxNumber(rs.getString("fax"));
			obj.setDateConfigBooking(rs.getInt("date_rang_bkg"));
			obj.setDateConfigesi(rs.getInt("date_rang_esi"));
			obj.setOrgCode(rs.getString("org_code"));
			obj.setWebBooking(rs.getString("web_booking"));
			obj.setGetRate(rs.getString("get_rates"));
			obj.setCountryCode(rs.getString("country"));
			obj.setFscCode(rs.getString("fsc_code"));
			obj.setOrgType(rs.getString("org_type"));
			obj.setVgm(rs.getString("vgm"));
			return obj;
		}
	}

	public UserAccountBean getPassword(String userId, String email) {
		String sqlQuery = "select pswd,user_name  from esm_user_login where user_id=upper('" + userId + "') and email_id1='" + email + "' and record_status='A'";

		List<UserAccountBean> user = getJdbcTemplate().query(sqlQuery, new Object[] {}, new UserForgetMapper());

		if (user.size() > 0) {
			return user.get(0);
		}else {
			return null;
		}
	}

	public class UserForgetMapper extends JdbcRowMapper {

		public UserAccountBean mapRow(ResultSet rs, int row) throws SQLException {
			UserAccountBean obj = new UserAccountBean();

			try {
			obj.setPassword(EncryptDecryptUtil.convertHexToString(rs.getString("pswd")));
			obj.setUserName(rs.getString("user_name"));
			}catch (Exception e) {
					e.printStackTrace();
			}
			return obj;
		}

	}
	
	public class UserProfileMapper extends JdbcRowMapper {

		public UserMod mapRow(ResultSet rs, int row) throws SQLException {
			UserMod obj = new UserMod();
			obj.setUserId(rs.getString("user_id"));
			obj.setPassword(rs.getString("pswd"));
			obj.setFirstName(rs.getString("user_name"));
		//	obj.setLastName(rs.getString("user_name"));
		//	SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			obj.setCompanyName(rs.getString("company_name"));
			obj.setEmail(rs.getString("email_id1"));
			obj.setAddress1(rs.getString("cmp_address1"));
			obj.setAddress2(rs.getString("cmp_address2"));
			obj.setCity(rs.getString("city"));
			obj.setPhoneNo(rs.getString("phone"));
			obj.setState(rs.getString("state"));
			obj.setCountry(rs.getString("country"));
			return obj;
		}
	}

	
	
	@Override
	public String getUrlWebServices() {
		
		String url =(String) getJdbcTemplate().queryForObject(URL_QUERY,new Object[] {1} ,Object.class);
		
		return url;
	}
	
	@Override
	public Map getCheckPolPod(String pol,String pod) {
		
		String query_pol_pod="select count(*) from pol_pod_priority where pol='"+pol+"' and pod='"+pod+"'";
		int result =  getJdbcTemplate().queryForInt(query_pol_pod);
		if(result>0) {
			String query="select service,ts,effectivedate,expireddate,pot1 from pol_pod_priority where pol='"+pol+"' and pod='"+pod+"'";
			List<EserviceSearchApiServiceMod> list= getJdbcTemplate().query(query, new GetServiceTsRowMapper());
			 Map<String, EserviceSearchApiServiceMod> map=new HashMap<String, EserviceSearchApiServiceMod>();
			 for(EserviceSearchApiServiceMod lis:list) {
				 map.put(lis.getService(), lis);
			 }
			 return map;
		}else {
			return null; 
		}
	}
	
	class GetServiceTsRowMapper extends JdbcRowMapper {

		@Override
		public EserviceSearchApiServiceMod mapRow(ResultSet rs, int row) throws SQLException {
			EserviceSearchApiServiceMod obj=new EserviceSearchApiServiceMod(); 
			obj.setService(rs.getString("service"));
			obj.setTsValue(rs.getString("ts"));
			obj.setEffectivedate(rs.getString("effectivedate"));
			obj.setExpireddate(rs.getString("expireddate"));
			obj.setPot1(rs.getString("pot1"));
			return obj;
		}
	
	}
	
	public UserAccountBean getInternalUserPassword(String loginId, String email) {
		List<UserAccountBean> user=null;
		String sqlQuery = "select pswd,user_name  from esm_admin_login where login_id=upper('" + loginId + "') and email_id='" + email + "'";
		
		try {
		user = getJdbcTemplate().query(sqlQuery, new Object[] {}, new UserForgetMapper());
		}catch (Exception e) {
			e.printStackTrace();
	}
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	
	}

	@Override
	public UserMod getErrorType(String userId, String email,UserMod form) {
		 
		String checkStatusQuery = "select pswd,user_name,record_status  from esm_user_login where user_id=upper('" + userId + "') and email_id1='" + email + "'";
		
		List<UserMod> user=getJdbcTemplate().query(checkStatusQuery, new UserErrorData());
		
		if (user.size() > 0) {
			if( user.get(0).getStatus().equals("R")) {
				form.setMsg("You account has Rejected please contact to RCL local agency.");
			}else if(user.get(0).getStatus().equals("S")) {
				form.setMsg("You account has Suspended please contact to RCL local agency.");
			}else if(user.get(0).getStatus().equals("N")) {
				form.setMsg("You account has Cancel please contact to RCL local agency.");
			}else if(!user.get(0).getStatus().equals("") || user.get(0).getStatus()!= null) {
				form.setMsg("You account has not Approved please contact to RCL local agency.");
			}
			return form;
		}else {
			form.setMsg("User id and Mail id doesn't match");
			return form;
		}
	}
	
	public class UserErrorData extends JdbcRowMapper {

		public UserMod mapRow(ResultSet rs, int row) throws SQLException {
			UserMod obj = new UserMod();

			try {
			obj.setPassword(EncryptDecryptUtil.convertHexToString(rs.getString("pswd")));
			obj.setUserName(rs.getString("user_name"));
			obj.setStatus(rs.getString("record_status"));
			}catch (Exception e) {
					e.printStackTrace();
			}
			return obj;
		}

	}
	
}

package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.InternalUserMod;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_GET_COUNTRY_LIST;

public class InternalUserProfileDaoImpl extends AncestorJdbcDao implements InternalUserProfileDao {

	public InternalUserMod getUserForUserProfile(String userId) {
		String sqlQuery = "select login_id,user_name,pswd,location,email_id from esm_admin_login where login_id='"
				+ userId + "' ";

		List<InternalUserMod> user = getJdbcTemplate().query(sqlQuery, new Object[] {}, new InternalUserProfileMapper());
		System.out.println("sqlQuery   " + sqlQuery);
		if (user.size() > 0) {
			return user.get(0);
		} else
			return null;
	};

	public String getUpdateUserForUserProfile(InternalUserMod user) {

		try {
		String password = EncryptDecryptUtil.convertStringToHex(user.getPassword());
		String userID = user.getLoginId();// "DEV_TEAM";
		String userName = user.getUserName();
		String email = user.getEmail();
		String[] location = user.getLocation();
		
		String str=Arrays.toString(location);
		str = convertStringArrayToString(location, "#");
		
		String updateSql = "update esm_admin_login set user_name='" + userName + "', pswd='" + password + "', location='" + str + "' ,email_id='"+email+"' where login_id='"
				+ userID + "'";

		int i = getJdbcTemplate().update(updateSql, new Object[] {});
		System.out.println("sqlQuery   " + i);
		user.setMsg("success");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	};

	public class InternalUserProfileMapper extends JdbcRowMapper {

		public InternalUserMod mapRow(ResultSet rs, int row) throws SQLException {
			InternalUserMod obj = new InternalUserMod();
			try {
			obj.setLoginId(rs.getString("login_id"));
			obj.setPassword(EncryptDecryptUtil.convertHexToString(rs.getString("pswd")));
			obj.setUserName(rs.getString("user_name"));
			obj.setEmail(rs.getString("email_id"));
			String strArray[] = rs.getString("location").split("# ");
			obj.setLocation(strArray);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}
	}

	@Override
	public List<ComboVO> getCountryList(String user) {
		
		Map map=new HashMap();
		
		PRR_ESV_GET_COUNTRY_LIST proc=new PRR_ESV_GET_COUNTRY_LIST(getJdbcTemplate(),map);
		map=proc.executeDbProcedure();
		
		List<ComboVO> list =(List<ComboVO>) map.get("P_O_V_COUNTRY_DATA");
		
		return list;
	}
	
	@Override
	public List<ContryMod> getCountryCodeNameList() {
		
		String POL_POD_QUERY="select name AS COUNTRY_NAME,code AS COUNTRY_CODE from country_code order by  COUNTRY_NAME";
		
		List<ContryMod> lit= getJdbcTemplate().query(POL_POD_QUERY, new CountruCombod());
		
		return lit;
	}
	
	class CountruCombod implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg) throws SQLException {
			
			//ContryMod model =new ContryMod();
			
			ContryMod obj = new ContryMod();
			obj.setContryName(rs.getString("COUNTRY_NAME"));
			obj.setCode(rs.getString("COUNTRY_CODE"));
			
			return obj;
		}
		
		
		
	}

	@Override
	public String updateUserForUserPassword(InternalUserMod form) throws Exception {
		String password=null;
		
		String oldPassword = (String) getJdbcTemplate().queryForObject(GET_PASSWORD,new Object[] {form.getLoginId()}, Object.class);
		
		if(!EncryptDecryptUtil.convertHexToString(oldPassword).equals(form.getOldPassword())) {
			form.setErrorMessage("Old Password is incorrect");
			throw new Exception();
		}
		
		try {
			password = EncryptDecryptUtil.convertStringToHex(form.getPassword());
			getJdbcTemplate().update(UPDATE_PASSWORD,new Object[] {password,form.getLoginId()});
			form.setMsg("Successfuly Updated.");
			
		} catch (Exception e) {
			form.setErrorMessage("Faild.");
			e.printStackTrace();
		}
		
		
		
		
		return "Success" ;
	}
	
	private static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}

}

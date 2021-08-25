package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao.PCR_ESV_REGISTER;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao.P_I_V;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;
import com.rclgroup.dolphin.rcl.web.procedure.user.PRR_ESV_GET_COUNTRY_LIST;

public class UserProfileDaoImpl extends AncestorJdbcDao implements UserProfileDao {

	public UserMod getUserForUserProfile(String userId) {
		String sqlQuery = "select user_id,pswd,user_name,company_name,email_id1,phone,city,state, country ,cmp_address1, " + 
				"   COALESCE (cmp_address2, cmp_address2, ' ') as cmp_address2, " + 
				"	COALESCE (cmp_address3, cmp_address3, ' ') as cmp_address3, " + 
				"	COALESCE (cmp_address4, cmp_address4, ' ')as cmp_address4, " + 
				"	COALESCE (fax, fax, ' ') as fax,get_rates,web_booking,vgm  from esm_user_login where user_id='"
				+ userId + "' and record_status='A'";

		List<UserMod> user = getJdbcTemplate().query(sqlQuery, new Object[] {}, new UserProfileMapper());
		System.out.println("sqlQuery   " + sqlQuery);
		if (user.size() > 0) {
			return user.get(0);
		} else
			return null;
	};

	public String getUpdateUserForUserProfile(Map<String, String> paramMap, UserMod user, RegistrationOrclDao daoOrl, UserProfileDao dao) {

		String[][]                              arrParams               = null;
		JdbcStoredProcedure                     storeProcedure          = null;
		Map                                     resultMap               = null;
		
		String SFU_HACK_POST_GRE =(String) paramMap.get(P_I_V.SFU);
    	String SFU =(String) paramMap.get(P_I_V.SFU);
    	String SFU_TEMP ="";
		
		if(SFU!=null) {
    		if(SFU.contains("EBKG-E")){
    			SFU_TEMP=SFU_TEMP+ "EBKG-E,EDOC-E";
			}
    		if(SFU.contains("EVGM-G")) {
    			 if(!SFU.contains("EBKG-E")) {
    				 SFU_TEMP=SFU_TEMP+ "EBKG-E,EDOC-E";
    			 }
    		}
    	   if(SFU.contains("EVGM-E")) {
    		   if(SFU_TEMP.length()>1) {
    			   SFU_TEMP=SFU_TEMP+",EBKG-E";
    		   }else{
    			   SFU_TEMP=SFU_TEMP+"EBKG-E";
    		   }
    	   }	
    	}else {
    		SFU="EBKG-E,EDOC-E";
    	}
		
		try {
			
			arrParams = new String[][]{
                { P_I_V.USR_ID      , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.USR_ID)},
                { P_I_V.CUST_NAME   , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.CUST_NAME)},
                { P_I_V.EMAIL       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.EMAIL)},
                { P_I_V.CMP_NAME    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.CMP_NAME)},
                { P_I_V.ADDRESS1    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS1)},
                { P_I_V.ADDRESS2    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS2)},
                { P_I_V.ADDRESS3    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS3)},
                { P_I_V.ADDRESS4    , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.ADDRESS4)},
                { P_I_V.CITY        , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.CITY)},
                { P_I_V.STATE       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.STATE)},
                { P_I_V.COUNTRY     , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.COUNTRY)},
                { P_I_V.PHONENO     , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.PHONENO)},
                { P_I_V.FAXNO       , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.FAXNO)},
                //{ P_I_V.NEW_USR_ID, BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.NEW_USR_ID)},
                { P_I_V.NEW_PWD     , BLANK + ORACLE_VARCHAR, PARAM_IN, (String) paramMap.get(P_I_V.NEW_PWD)},
                { P_I_V.SFU         , BLANK + ORACLE_VARCHAR, PARAM_IN, SFU_TEMP}
            };

            storeProcedure = daoOrl.getStoreProcedure(PCR_ESV_REGISTER.PRR_ESV_MANAGE_ACCOUNT, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
            }
			
		String password = EncryptDecryptUtil.convertStringToHex(user.getPassword());
		String userID = user.getUserId();// "DEV_TEAM";
		String city = user.getCity();
		String userName = user.getFirstName().trim()+" "+user.getLastName().trim();
		String cumpany = user.getCompanyName();
		String email = user.getEmail();
		String state = user.getState();
		String county = user.getCountry();
		String add1 = user.getAddress1();
		String add2 = user.getAddress2();
		String add3 = user.getAddress3();
		String add4 = user.getAddress4();
		String faxNo = user.getFaxNo();
		String phone = user.getPhoneNo();
		String get_rates = "";
		String web_booking ="";
		String vgm ="";
		
		if(SFU.contains("EBKG-E")) {
			web_booking="Y";
        }
        if(SFU.contains("EVGM-G")) {
        	get_rates="Y";
        }
        
        if(SFU.contains("EVGM-E")) {
        	vgm="Y";
        }

		String updateSql = "update esm_user_login set city='" + city + "', pswd='" + password + "', phone='"
				+ phone + "'," + " country='" + county + "'  ,email_id1='" + email + "',company_name='" + cumpany
				+ "', state='" + state + "'  , cmp_address1='" + add1 + "', cmp_address2='" + add2 + "',cmp_address3='" + add3 + "',"
				+ "  cmp_address4='" + add4 + "',fax='" + faxNo + "', get_rates = '"+get_rates+"', web_booking='"+web_booking+"',vgm = '"+vgm+"'   where user_id='"
				+ userID + "'";

		int i = getJdbcTemplate().update(updateSql, new Object[] {});
		System.out.println("sqlQuery update esm_user_login  " + updateSql);
		user.setMsg("success");
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	};

	public class UserProfileMapper extends JdbcRowMapper {

		public UserMod mapRow(ResultSet rs, int row) throws SQLException {
			UserMod obj = new UserMod();
			try {
			obj.setUserId(rs.getString("user_id"));
			obj.setPassword(EncryptDecryptUtil.convertHexToString(rs.getString("pswd")));
			 
			String[] arr=checkSpace(rs.getString("user_name").split(" "));
			
			obj.setFirstName(arr[0]);
			obj.setLastName(arr[1]);
			
			obj.setCompanyName(rs.getString("company_name"));
			obj.setEmail(rs.getString("email_id1"));
			obj.setAddress1(rs.getString("cmp_address1"));
			obj.setAddress2(rs.getString("cmp_address2"));
			obj.setAddress3(rs.getString("cmp_address3"));
			obj.setAddress4(rs.getString("cmp_address4"));
			obj.setCity(rs.getString("city"));
			obj.setPhoneNo(rs.getString("phone"));
			obj.setFaxNo(rs.getString("fax"));
			obj.setState(rs.getString("state"));
			obj.setCountry(rs.getString("country"));
			obj.setGetRate(rs.getString("get_rates"));
			obj.setWebBooking(rs.getString("web_booking"));
			obj.setVgm(rs.getString("vgm"));
			}catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}

		private String[] checkSpace(String[] split) {
			String arr[] =new String[2];
			int count=0;
			for(String st:split) {
				
				if(!st.isEmpty()){
					arr[count]=st;
					count++;
				}
			}
			
			return arr;
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
	public String updateUserForUserPassword(UserMod form) throws Exception {
		String password=null;
		
		String oldPassword = (String) getJdbcTemplate().queryForObject(GET_PASSWORD,new Object[] {form.getUserId()}, Object.class);
		
		if(!EncryptDecryptUtil.convertHexToString(oldPassword).equals(form.getOldPassword())) {
			form.setErrorMessage("Old Password is incorrect");
			throw new Exception();
		}
		
		try {
			password = EncryptDecryptUtil.convertStringToHex(form.getPassword());
			getJdbcTemplate().update(UPDATE_PASSWORD,new Object[] {password,form.getUserId()});
			form.setMsg("Successfuly Updated.");
			
		} catch (Exception e) {
			form.setErrorMessage("Faild.");
			e.printStackTrace();
		}
		
		
		
		
		return "Success" ;
	}

}

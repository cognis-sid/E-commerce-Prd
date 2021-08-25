package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mozilla.javascript.ObjArray;
import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;

public class PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER {

	JdbcTemplate jdbcTemplate;
	Map amapParam ;
	
	public PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER(JdbcTemplate jdbcTemplate,Map amapParam) {
		this.jdbcTemplate=jdbcTemplate;
		this.amapParam=amapParam;
	}
	
	public Map executeDbProcedure() {
		String query;
		if((String)amapParam.get("POL")!=null && ""!=(String)amapParam.get("POL")  
				&& (String)amapParam.get("POD")!=null & ""!=(String)amapParam.get("POD")) {
			
		String orgCode="";	
		String orgCodeQuery="select org_code from esm_user_login where   user_id='"+(String)amapParam.get("USER_ID")+"'";
		if(amapParam.get("REPRESENEDCOMAPNYCHECK").equals("Y")) {
			orgCode=(String) amapParam.get("REPRESENEDCOMAPNY");
		}else {
			orgCode=(String) jdbcTemplate.queryForObject(orgCodeQuery, Object.class);
		}
		 query="SELECT  " + 
				"    DISTINCT h.qaquno   AS \"QUOTATION_NO\",  " + 
				"    COALESCE (h.eqtn_ref_no,h.qaquno)   AS \"DESC\"   " + 
				"FROM  " + 
				"    qtp0012   c,  " + 
				"    sealiner.qtp001  h,  " + 
				"    sealiner.sc_prsn_log_info  l  " + 
				"WHERE  " + 
				"     l.ORG_CODE  =  H.QAIQCD  AND" + 
				"        c.QAQUNO = h.QAQUNO  " + 
				"    AND l.ORG_CODE     IS NOT NULL  " + 
				"    AND c.qapol = '"+(String)amapParam.get("POL")+"'  " + 
				"    AND c.qapod = '"+(String)amapParam.get("POD")+"'  " + 
	// Need to re Visit Cognis
				"    AND TO_NUMBER(TO_CHAR(TO_DATE('"+(String)amapParam.get("ETDATE")+"', 'DD/MM/YYYY'), 'YYYYMMDD'),'9G999g9999') BETWEEN  h.qaefdt AND h.qaexdt  " + 
				"    AND l.org_code = '"+orgCode+"'  " + 
				"    AND h.qastat = 'C'";
		}else {
			query="SELECT  " + 
					"    DISTINCT h.qaquno   AS \"QUOTATION_NO\",  " + 
					"    COALESCE (h.eqtn_ref_no,h.qaquno)   AS \"DESC\"   " + 
					"FROM  " + 
					"    qtp0012   c,  " + 
					"    sealiner.qtp001  h,  " + 
					"    sealiner.sc_prsn_log_info  l  " + 
					"WHERE  " + 
					"     l.ORG_CODE  =  H.QAIQCD  " + 
					"       AND c.QAQUNO = h.QAQUNO  " + 
					"    AND l.ORG_CODE     IS NOT NULL  " + 
		// Need to re Visit Cognis"  
					"AND to_number(TO_CHAR(now(), 'YYYYMMDD'),'9G999g9999') BETWEEN  h.qaefdt AND h.qaexdt  " + 
					"    AND l.prsn_log_id = '"+(String)amapParam.get("USER_ID")+"'  " + 
					"    AND h.qastat = 'C'";
		}
	  Map map=new HashMap();
	  
	  System.out.println("PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER : "+query);
	  
	  List list=jdbcTemplate.query(query, new Object[] { }, new QuotationRowMappers());
	  
	  map.put("P_O_V_BLC_MAPPING_LIST",list); 
		
	  return map;
	}
	
	class QuotationRowMappers extends JdbcRowMapper{

        public Object mapRow(ResultSet rs, int row) throws SQLException{

            EserviceNewWebBookingMod objVo = new EserviceNewWebBookingMod();

            objVo.setQuotationNo(rs.getString("QUOTATION_NO"));

            objVo.setQuotationDesc(rs.getString("DESC"));

            return objVo;
        } 

    }
}

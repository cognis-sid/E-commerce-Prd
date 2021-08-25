package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_GET_ORIGIN_COUNTRY_COMBO extends AncestorJdbcDao{

	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	
	public PRE_GET_ORIGIN_COUNTRY_COMBO(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}

	public void executeDbProcedure() {
		
		if ("Y".equalsIgnoreCase((String) map.get("P_I_V_REP_FLAG"))
				&& !" ".equals((String) map.get("P_I_V_REP_CODE"))) {
			query1 = "SELECT  " + "              I30.SCCODE as \"CODE\",  " + "              I30.SCNAME as \"DESC\"  "
					+ "            FROM  "
					+ "              ITP030 I30 LEFT JOIN ITP063 I60 ON SUBSTR(I60.VVPCAL,1,2) = I30.SCCODE  "
					+ "            WHERE  " + "              I60.VVVERS = 99  "
					+ "              AND I60.VVLDDS IN ('L', 'D', 'B')  " + "              AND I30.SCRCST = 'A' and I30.SCCODE ='"+map.get("P_I_V_PORT_OF_LOADING").toString().substring(0,2)+"' "
					+ "              AND  " + "                I30.SCCODE IN (  " + "                SELECT  "
					+ "                  I40.PICNCD  " + "                FROM  " + "                  ITP040 I40  "
					+ "                WHERE  " + "                  I40.PICODE IN (  "
					+ "                    SELECT DISTINCT  " + "                      DTL.POL  "
					+ "                    FROM  "
					+ "                      ESV_CONTRACT_PARTY_PP_HDR HDR LEFT JOIN ESV_CONTRACT_PARTY_PP_DTL DTL ON DTL.FK_ESV_PP_HDR_SEQ = HDR.PK_ESV_PP_HDR_SEQ  "
					+ "                    WHERE  "
					+ "                      HDR.FK_CONTRACT_PARTY_CODE = '"+map.get("P_I_V_REP_CODE")+"'  "
					+ "                      AND (  "
					+ "                            now() BETWEEN DTL.EFF_DATE AND DTL.EXP_DATE  "
					+ "                            OR now() < DTL.EFF_DATE  "
					+ "                            OR now() = DTL.EFF_DATE  "
					+ "                            OR now() = DTL.EXP_DATE  " + "                          )  "
					+ "                      AND DTL.RECORD_STATUS = 'A'  "
					+ "                      AND HDR.RECORD_STATUS = 'A'  "
					+ "                      AND HDR.USER_ID       = '" + map.get("P_I_V_USER_ID") + "'"
					+ "                  )  " + "              )  " + "            GROUP BY  "
					+ "                I30.SCCODE,  " + "                I30.SCNAME  " + "            ORDER BY  "
					+ "              I30.SCNAME  ";
		} else {
			query1=" select pk_country_code AS  \"code\" ,country_name as  \"DESC\"  from cam_country where pk_country_code=(select fk_country_code from cam_point cp where pk_point_code='"+map.get("P_I_V_PORT_OF_LOADING")+"') limit 1";
		}
		
		System.out.println("PRE_GET_ORIGIN_COUNTRY_COMBO : "+query1);
		
		List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new ComboRowMapper());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR",null);
		
		
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
	
}

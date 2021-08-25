package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_GET_PORT_OF_LOADING extends AncestorJdbcDao{

	JdbcTemplate jdbcTemplate;
	Map map;
	String query1;
	public PRE_GET_PORT_OF_LOADING(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
	
		
		if ("Y".equalsIgnoreCase((String) map.get("P_I_V_REP_FLAG"))
				&& !" ".equals((String) map.get("P_I_V_REP_CODE"))) {
			query1 = " SELECT  " + "              I40.PICODE AS \"CODE\",  " + "              I40.PINAME AS \"DESC\"  "
					+ "          FROM  " + "              ITP040 I40,  " + "              ITP063 I63  "
					+ "          WHERE  " + "              I63.VVVERS = 99  "
					+ "              AND I63.VVFORL  IS NOT NULL  "
					+ "              AND I63.VVLDDS  IN ('L', 'D', 'B')  " + "              AND I40.PICNCD   = '"
					+ map.get("P_I_V_COUNTRY_CODE") + "'" + "      and I40.PICODE = '"+map.get("P_I_V_PORT_OF_LOADING")+"'        AND I63.VVPCAL   = I40.PICODE  "
					+ "              AND I40.PIRCST   = 'A'  " + "              AND I40.PICODE IN (  "
					+ "                SELECT DTL.POL  "
					+ "                  FROM VASAPPS.ESV_CONTRACT_PARTY_PP_HDR HDR  "
					+ "                        LEFT JOIN VASAPPS.ESV_CONTRACT_PARTY_PP_DTL DTL ON DTL.FK_ESV_PP_HDR_SEQ = HDR.PK_ESV_PP_HDR_SEQ  "
					+ "                 WHERE HDR.USER_ID            = '" + map.get("P_I_V_USER_ID") + "'"
					+ "                   AND FK_CONTRACT_PARTY_CODE ='" + map.get("P_I_V_REP_CODE") + "'"
					+ "                   AND DTL.RECORD_STATUS = 'A'  "
					+ "                   AND DTL.POL IS NOT NULL  " + "                   AND DTL.POD IS NOT NULL  "
					+ "                   AND (  "
					+ "                        now() BETWEEN DTL.EFF_DATE AND DTL.EXP_DATE  "
					+ "                        OR now() < DTL.EFF_DATE  "
					+ "                        OR now() = DTL.EFF_DATE  "
					+ "                        OR now() = DTL.EXP_DATE  " + "                       )  "
					+ "                   AND DTL.RECORD_STATUS = 'A'  "
					+ "                   AND HDR.RECORD_STATUS = 'A'  " + "              )  " + "          GROUP BY  "
					+ "              I40.PICODE, I40.PINAME  " + "          ORDER BY  " + "              PINAME  ";
		} else {
			query1="select code as \"code\" ,name as \"DESC\" from VRL_PORT where code='"+map.get("P_I_V_PORT_OF_LOADING")+"' ";
		}

		List<ComboVO> list=jdbcTemplate.query(query1, new Object[] {}, new ComboRowMapper());
		
		Map outPut=new HashMap();
		outPut.put("P_O_V_REF_CURSOR_DATA",list);
		outPut.put("P_O_V_ERROR",null);
		
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
		
	}


}

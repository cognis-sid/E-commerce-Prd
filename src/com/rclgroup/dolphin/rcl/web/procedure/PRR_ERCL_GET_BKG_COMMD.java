package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;

public class PRR_ERCL_GET_BKG_COMMD {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRR_ERCL_GET_BKG_COMMD(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		
		String V_SQL = "SELECT C.BWCMSQ,  " + 
				"                 C.COMMODITY_GROUP_CODE,  " + 
				"                 G.DESCRIPTION,  " + 
				"                 C.BWMTWT,  " + 
				"                 BGRMKS,  " + 
				" 				  C.BWMTMS,   " + 
				"                         C.SPECIAL_HANDLING ,    " + 
				"                         (CASE WHEN (C.SPECIAL_HANDLING <> 'N') THEN 'Y'   " + 
				"                              ELSE 'N' END) AS SPECIAL_FLAG "+
				"          FROM SEALINER.COMMODITY_GROUP G , SEALINER.BKP050 C  " + 
				"               LEFT OUTER JOIN BKP007  " + 
				"               ON C.BWCMSQ=BGSEQN  " + 
				"                  AND C.BWBKNO=BGBKNO  " + 
				"          WHERE C.COMMODITY_GROUP_CODE=G.COMMODITY_GROUP_CODE  " + 
				"          AND BWBKNO='"+map.get("P_I_V_BKG_NO") +"'" + 
				"          ORDER BY C.BWCMSQ";
			
		List<EserviceCommodityDetailsMod> selectList=jdbcTemplate.query(V_SQL, new Object[] {}, new TemplateCommodityRowMappers());
		
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		outPut.put("P_O_V_DTL_DATA", selectList);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
	  class TemplateCommodityRowMappers extends JdbcRowMapper{

          public EserviceCommodityDetailsMod mapRow(ResultSet rs, int row) throws SQLException{

              String grossWeight = null;

              //@05 BEGIN
              NumberFormat nf2digit = new DecimalFormat("#,###.00");
              //@05 END

              EserviceCommodityDetailsMod objVo = new EserviceCommodityDetailsMod();
              // eserviceNewWebBookingUim.setCommodityGroup(rs.getString("BWCMSQ"));
              objVo.setGroup(rs.getString("COMMODITY_GROUP_CODE"));
              objVo.setDescription(rs.getString("DESCRIPTION"));

              //@05 BEGIN
              grossWeight = rs.getDouble("BWMTWT")==0? "0.00":nf2digit.format(rs.getDouble("BWMTWT"));
              objVo.setGrossWeight(grossWeight);
              //@05 END
              objVo.setSeqNo(rs.getInt("BWCMSQ"));
              if(rs.getString("BGRMKS") == null) 
            	  objVo.setSpecialInstruction("");
              else
            	  objVo.setSpecialInstruction(rs.getString("BGRMKS"));
              objVo.setRecordStatus("SER");

              /*Begin @06*/
              objVo.setSpecialCargo(rs.getString("SPECIAL_FLAG"));
              objVo.setRateType(rs.getString("SPECIAL_HANDLING"));
              /*End @06*/

              return objVo;
          } // mapRow

      }
}

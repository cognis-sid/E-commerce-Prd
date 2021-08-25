package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceDGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceOOGCommoditiesUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim;

public class PRR_ESV_GET_BKG_RE_COMMD {
	 private JdbcTemplate jdbcTemplate;
	 private Map map ;
	 
	public PRR_ESV_GET_BKG_RE_COMMD(JdbcTemplate jdbcTemplate,Map map){
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;	
	}

	public void executeDbProcedure() {
		
		String V_SQL="SELECT REEFER_FROM,  " + 
				"                         VENTILATION,  " + 
				"                         REEFER_REMARKS,  " + 
				"                         HUMIDITY,  " + 
				"                         CONTROLLED_ATM,  " + 
				"                         NITROGEN,  " + 
				"                         OXYGEN,  " + 
				"                         CO2,  " + 
				"                         RFR_MODE,  " + 
				"                         PRE_COOLED  " + 
				"                  FROM SEALINER.BOOKING_RFR_COMM_DETAIL  " + 
				"                  WHERE COMMODITY_SQNO='"+map.get("P_I_V_COMMD_SEQ") +"'"+ 
				"                  AND BOOKING_NO='"+ map.get("P_I_V_BKG_NO")+"'";
		List<EserviceReferCommoditiesUim> list=new ArrayList<EserviceReferCommoditiesUim>();
		if(map.get("rateType").equals("RF")) {
			list=jdbcTemplate.query(V_SQL, new Object[] {}, new ReferCommodityRowMappers());
		}else if(map.get("rateType").equals("D1")) {
			 list=jdbcTemplate.query(V_SQL, new Object[] {}, new DGCommodityRowMappers());
		}else if(map.get("rateType").equals("O0")){
			 list=jdbcTemplate.query(V_SQL, new Object[] {}, new OOGCommodityRowMappers());
		}
		map.put("P_O_V_DTL_DATA", list);
	}
	class ReferCommodityRowMappers extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceReferCommoditiesUim uim = new EserviceReferCommoditiesUim();

			uim.setTemperature(rs.getString("REEFER_FROM"));
			uim.setVentilation(rs.getString("VENTILATION"));
			uim.setRemark(rs.getString("REEFER_REMARKS"));
			uim.setHumidity(rs.getString("HUMIDITY"));
			uim.setControlledAtmosphere(rs.getString("CONTROLLED_ATM"));
			uim.setNitrogen(rs.getString("NITROGEN"));
			uim.setOxygent(rs.getString("OXYGEN"));
			uim.setCo2(rs.getString("CO2"));
			uim.setRefMode(rs.getString("RFR_MODE"));
			uim.setPreCooled(rs.getString("PRE_COOLED"));

			return uim;
		}
	}
	class DGCommodityRowMappers extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceDGCommoditiesUim uim = new EserviceDGCommoditiesUim();

			uim.setFlashPoint(rs.getString("HZ_FLPT_FROM"));
			uim.setUnitMeasurement(rs.getString("HZ_BS"));
			uim.setUnNo(rs.getString("UN_NO"));
			uim.setVariant(rs.getString("UN_VARIANT"));
			uim.setImdgClass(rs.getString("IMO_CLASS"));
			uim.setPortClass(rs.getString("PORT_CLASS_CODE"));
			uim.setResidue(rs.getString("RESIDUE"));
			uim.setFumigration(rs.getString("FUMIGATION_YN"));

			uim.setUnNoDis(rs.getString("UN_NO"));
			uim.setVariantDis(rs.getString("UN_VARIANT"));
			uim.setImdgClassDis(rs.getString("IMO_CLASS"));

			return uim;
		}
	}
	class OOGCommodityRowMappers extends JdbcRowMapper {

		public Object mapRow(ResultSet rs, int row) throws SQLException {
			EserviceOOGCommoditiesUim uim = new EserviceOOGCommoditiesUim();

			uim.setTxtLength(rs.getString("OG_LENGTH"));
			uim.setTxtWidth(rs.getString("OG_WIDTH"));
			uim.setTxtHeight(rs.getString("OG_HEIGHT"));
			uim.setTxtDiameter(rs.getString("OG_DIAMETER"));

			return uim;
		}
	}
}

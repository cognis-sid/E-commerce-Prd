package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;

public class PRR_ERCL_GET_BKG_SIZE_TYPE {
	
	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRR_ERCL_GET_BKG_SIZE_TYPE(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	public void executeDbProcedure() {
		
		String  V_MTY_PICKUP_DT ;
		String  V_MTY_PICKUP_DEPOT ;
		String  V_MTY_PICKUP_DEPOT_NAME ;
		
		String quey1="SELECT DISTINCT POSITIONING_TERMINAL,  " + 
				"                          TO_CHAR(TO_DATE(cast(POSITIONING_DATE as varchar),'YYYYMMDD'),'DD/MM/YYYY') as date,  " + 
				"                          TQTRNM  " + 
				"          FROM SEALINER.BOOKING_SUPPLIER_DETAIL,SEALINER.ITP130  " + 
				"          WHERE POSITIONING_TERMINAL=TQTERM  " + 
				"                AND TQRCST = 'A'  " + 
				"                AND BOOKING_NO = '"+ map.get("P_I_V_BKG_NO")+"'";
		
		List list=jdbcTemplate.query(quey1,new Object[] {}, new PortDetlsRowMapper());
		
		
		
		if(list.size()>0) {
		V_MTY_PICKUP_DT=((List)list.get(0)).get(1).toString();
		V_MTY_PICKUP_DEPOT=((List)list.get(0)).get(0).toString();
		V_MTY_PICKUP_DEPOT_NAME=((List)list.get(0)).get(2).toString();
		}else {
			String PICKUP_DT_QUERY = "select "+
					"                          TO_CHAR(TO_DATE(cast(POSITIONING_DATE as varchar),'YYYYMMDD'),'DD/MM/YYYY') as date  " +
					"          FROM SEALINER.BOOKING_SUPPLIER_DETAIL  " +
					"                where BOOKING_NO = '"+ map.get("P_I_V_BKG_NO")+"' limit 1";
			V_MTY_PICKUP_DT=(String) jdbcTemplate.queryForObject(PICKUP_DT_QUERY, Object.class) ;
			V_MTY_PICKUP_DEPOT=null;
			V_MTY_PICKUP_DEPOT_NAME=null;
		}
		String query2="SELECT A.BCSIZE,  " + 
				"                         A.BCTYPE,  " + 
				"						  C.bictrn as CONTAINERNO,	"	+								
				"                         CASE WHEN A.SPECIAL_HANDLING='N' THEN 'Normal'  " + 
				"                              WHEN A.SPECIAL_HANDLING='D1' THEN 'DG'  " + 
				"                              WHEN A.SPECIAL_HANDLING='DA' THEN 'Door Ajar'  " + 
				"                              WHEN A.SPECIAL_HANDLING='OD' THEN 'Open Door'  " + 
				"                              WHEN A.SPECIAL_HANDLING='NR' THEN 'Non-Reefer'  " + 
				"                              WHEN A.SPECIAL_HANDLING='O0' THEN 'OOG'  " + 
				"                              ELSE '' END AS CARGO_TYPE,  " + 
				"                         A.BCFQTY,  " + 
				"                         A.BCEQTY,  " + 
				"                         A.EQP_SIZETYPE_SEQNO,  " + 
				"                         CASE WHEN A.POL_STAT='L' THEN 'LOCAL'  " + 
				"                              ELSE 'TS' END POL_STAT_DESC,  " + 
				"                         CASE WHEN A.POD_STAT='L' THEN 'LOCAL'  " + 
				"                              ELSE 'TS' END POD_STAT_DESC,  " + 
				"                         A.SPECIAL_HANDLING,  " + 
				"                         A.POL_STAT,  " + 
				"                         A.POD_STAT  " + 
				"                         ,'"+V_MTY_PICKUP_DEPOT+"'  AS PICKUP_DEPOT   " + 
				"                         ,'"+V_MTY_PICKUP_DT+"' AS PICKUP_DATE  " + 
				"                         ,'"+V_MTY_PICKUP_DEPOT_NAME+"' AS PICKUP_DEPOT_NAME,  " + 
				"                         B.WEIGHT,  " + 
				"                         B.WEIGHT_TYPE,  " + 
				"                         CASE WHEN B.WEIGHT_TYPE='GCW' THEN 'Gross Container Weight '  " + 
				"                              WHEN B.WEIGHT_TYPE='CW' THEN 'Cargo Weight Only '  " + 
				"                              ELSE '' END AS WEIGHT_TYPE_DESC  " + 
				"                  FROM SEALINER.BKP032 A LEFT OUTER JOIN  ESV_WB_SIZETYPE B  " + 
				"                              ON BCBKNO = PK_BOOKING_NO  " + 
				"                                 AND EQP_SIZETYPE_SEQNO = EQ_SIZE_TYPE_SEQ  " + 
				" 								left outer join BKG_EQUIPMENT C on C.BIBKNO = A.BCBKNO AND C.BICSZE=A.BCSIZE AND C.BICNTP=A.BCTYPE "+								
				"                              WHERE BCBKNO=  '"+map.get("P_I_V_BKG_NO")+"' " + 
				"                  ORDER BY EQP_SIZETYPE_SEQNO ";
		
		System.out.println("PRR_ERCL_GET_BKG_SIZE_TYPE -->"+query2);
		List<EserviceEquipmentDetailsMod> selectList=jdbcTemplate.query(query2, new Object[] {}, new TemplateSizeTypeRowMappers());
		
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		outPut.put("P_O_V_DTL_DATA", selectList);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}

	class PortDetlsRowMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			
			List lst=new ArrayList ();
			
			lst.add(rs.getString("POSITIONING_TERMINAL"));
			lst.add(rs.getString("date"));
			lst.add(rs.getString("TQTRNM"));
			return lst;
		}
		
	}
	class TemplateSizeTypeRowMappers extends JdbcRowMapper{

        public Object mapRow(ResultSet rs, int row) throws SQLException{
            //@05 BEGIN
            NumberFormat nf2digit = new DecimalFormat("#,###.00");
            //@05 END

            EserviceEquipmentDetailsMod objVo = new EserviceEquipmentDetailsMod();

            objVo.setSize(rs.getString("BCSIZE"));
            objVo.setType(rs.getString("BCTYPE"));
            objVo.setEqNumber(rs.getString("CONTAINERNO"));
            objVo.setTypeDesc(rs.getString("CARGO_TYPE"));
            objVo.setLaden(rs.getString("BCFQTY"));
            objVo.setMt(rs.getString("BCEQTY"));
            objVo.setEqSeqNo(rs.getInt("EQP_SIZETYPE_SEQNO"));
            objVo.setCargoType(rs.getString("SPECIAL_HANDLING"));
            objVo.setPolStatus(rs.getString("POL_STAT"));
            objVo.setPodStatus(rs.getString("POD_STAT"));
            objVo.setEmptyPickupDepot(rs.getString("PICKUP_DEPOT"));
            objVo.setEmptyPickupDate(rs.getString("PICKUP_DATE"));

            //@05 BEGIN
            objVo.setGrossContainerWeight(nf2digit.format(rs.getDouble("WEIGHT")));
            //@05 END
            objVo.setEqRecordStatus("SER");

            return objVo;
        } // mapRow


    }
}

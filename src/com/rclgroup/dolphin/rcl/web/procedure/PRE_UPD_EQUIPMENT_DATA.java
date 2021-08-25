package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRE_UPD_EQUIPMENT_DATA {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRE_UPD_EQUIPMENT_DATA(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		String P_I_V_EMPTY_PICKUP_DATE;
		if ((map.get("P_I_V_EMPTY_PICKUP_DATE") !=null) || (map.get("P_I_V_EMPTY_PICKUP_DATE").equals("")  )){
          String query1="SELECT  " + 
          		"                TO_NUMBER(TO_CHAR(TO_DATE('"+map.get("P_I_V_EMPTY_PICKUP_DATE")+"' , 'DD/MM/YYYY'), 'YYYYMMDD'))  " + 
          		"            FROM  " + 
          		"                DUAL";
          P_I_V_EMPTY_PICKUP_DATE=(String) jdbcTemplate.queryForObject(query1, String.class);
		}else {
			P_I_V_EMPTY_PICKUP_DATE="";	
		}          
		
		String update1="UPDATE SEALINER.BKP032  " + 
				"           SET BCSIZE            = '"+map.get("P_I_V_EQ_SIZE")+"',  " + 
				"               BCTYPE            = '"+map.get("P_I_V_EQ_TYPE")+"',  " + 
				"               SPECIAL_HANDLING  = '"+map.get("P_I_V_CARGO_TYPE")+"',  " +
				"               BCTEUS            = CASE WHEN '"+ map.get("P_I_V_EQ_SIZE")+"' = '20'  THEN NVL('"+map.get("P_I_V_QTY_LADEN")+"',0)+ NVL('"+map.get("P_I_V_QTY_MTY")+"',0)  " + 
				"                                        WHEN '"+ map.get("P_I_V_EQ_SIZE")+"' = '40' THEN 2*( NVL('"+map.get("P_I_V_QTY_LADEN")+"',0)+ NVL('"+map.get("P_I_V_QTY_MTY")+"',0))  " + 
				"                                        ELSE 2.25*(NVL('"+map.get("P_I_V_QTY_LADEN")+"',0)+ NVL('"+map.get("P_I_V_QTY_MTY")+"',0))END ," + 
				"               BCFQTY            = '"+map.get("P_I_V_QTY_LADEN")+"',  " + 
				"               BCDQTY            = DECODE('"+map.get("P_I_V_CARGO_TYPE")+"','D1','"+map.get("P_I_V_QTY_LADEN")+"',0),  " + 
				"               BCRQTY            = CASE WHEN '"+map.get("P_I_V_EQ_TYPE")+"' IN ('RE','RH') THEN '"+map.get("P_I_V_QTY_LADEN")+"'  " + 
				"                                        ELSE 0 END,  " + 
				"               BCOQTY            = DECODE('"+map.get("P_I_V_CARGO_TYPE")+"','O0','"+map.get("P_I_V_QTY_LADEN")+"',0),  " + 
				"               BCEQTY            = '"+map.get("P_I_V_QTY_MTY")+"'    ,  " + 
				"               BCCUSR            = '"+map.get("P_I_V_USER_ID")+"',  " + 
				"               BCCDAT            = to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),  " + 
				"               BCCTIM            = to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999'),  " + 
				"               POL_STAT          = '"+map.get("P_I_V_POL_STATUS")+"',  " + 
				"               POD_STAT          = '"+map.get("P_I_V_POD_STATUS")+"',  " + 
				"				SPECIAL_STORAGE   = '"+map.get("P_I_V_SPECIAL_CARGO")+"'  " +
				"    WHERE BCBKNO = '"+map.get("P_I_V_BOOKING_NO")+"'  " + 
				"    AND EQP_SIZETYPE_SEQNO = '"+map.get("P_I_V_SEQ")+"' ";
		
		jdbcTemplate.update(update1);
		
		String update2="UPDATE  SEALINER.BOOKING_SUPPLIER_DETAIL  " + 
				"            SET  EQ_SIZE                ='"+ map.get("P_I_V_EQ_SIZE")+"',  " + 
				"                 EQ_TYPE                = '"+map.get("P_I_V_EQ_TYPE")+"',  " + 
				"                 SPECIAL_HANDLING       = '"+map.get("P_I_V_CARGO_TYPE")+"' ,  " + 
				"                 SUPPLIER_LOCATION      = '"+map.get("P_I_V_POL")+"',  " + 
				"                 POSITIONING_TERMINAL   = '"+map.get("P_I_V_EMPTY_PICKUP_DEP")+"',  " + 
				"                 POSITIONING_DATE       = '"+P_I_V_EMPTY_PICKUP_DATE+"',  " + 
				"                 FULL_QTY               = '"+map.get("P_I_V_QTY_LADEN")+"',  " + 
				"                 EMPTY_QTY              = '"+map.get("P_I_V_QTY_MTY")+"',  " + 
				"                 SECUSR                 = '"+map.get("P_I_V_USER_ID")+"',  " + 
				"                 SECDAT                 = to_number(TO_CHAR(now(), 'YYYYMMDD'), '9G999g9999'),  " + 
				"                 RECORD_CHANGE_TIME      = to_number(TO_CHAR(now(), 'HH24MI'), '9G999g999')  " + 
				"    WHERE BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'  " + 
				"          AND EQP_SIZETYPE_SEQNO = '"+map.get("P_I_V_SEQ")+"'";
		
		jdbcTemplate.update(update2);
		
		 String update3="UPDATE VASAPPS.ESV_WB_SIZETYPE  " + 
			 		"            SET  EQ_SIZE                 = '"+map.get("P_I_V_EQ_SIZE")+"',  " + 
			 		"                 EQ_TYPE                 = '"+map.get("P_I_V_EQ_TYPE")+"',  " + 
			 		"                 CARGO_TYPE              = '"+map.get("P_I_V_CARGO_TYPE")+"',  " + 
			 		"                 LADEN_QTY               = '"+map.get("P_I_V_QTY_LADEN")+"',  " + 
			 		"                 MT_QTY                  = '"+map.get("P_I_V_QTY_MTY")+"',  " + 
			 		"                 WEIGHT                  = '"+map.get("P_I_V_GROSS_WEIGHT")+"',  " + 
			 		"                 WEIGHT_TYPE             = '"+map.get("P_I_V_WEIGHT_TYPE")+"',  " + 
			 		"                 POL_STAT                = '"+map.get("P_I_V_POL_STATUS")+"',  " + 
			 		"                 POD_STAT                = '"+map.get("P_I_V_POD_STATUS")+"',  " + 
			 		"                 RECORD_ADD_USER         = '"+map.get("P_I_V_USER_ID")+"',  " + 
			 		"                 RECORD_ADD_DATE         = SYSTIMESTAMP,  " + 
			 		"                 RECORD_CHANGE_USER      = '"+map.get("P_I_V_USER_ID")+"',  " + 
			 		"                 RECORD_CHANGE_DATE      = SYSTIMESTAMP  " + 
			 		"  " + 
			 		"     WHERE PK_BOOKING_NO = '"+map.get("P_I_V_BOOKING_NO")+"'  " + 
			 		"           AND EQ_SIZE_TYPE_SEQ = '"+map.get("P_I_V_SEQ")+"'";
		 jdbcTemplate.update(update3);
		 
		 String update4="UPDATE SEALINER.BKP001  " + 
		 		"           SET BAMWT1 = '"+map.get("P_I_V_SUM_GROSS_WEIGHT")+"'  " + 
		 		"    WHERE  BABKNO='"+map.get("P_I_V_BOOKING_NO")+"'";
		 
		 jdbcTemplate.update(update4);
		 
		Map outPut =new HashMap();
		outPut.put("P_O_V_ERROR", null);
		map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
	}
}

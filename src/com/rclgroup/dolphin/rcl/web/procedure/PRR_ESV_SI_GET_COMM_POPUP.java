package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityPopupMod;

public class PRR_ESV_SI_GET_COMM_POPUP {

	JdbcTemplate jdbcTemplate;
	Map map;

	public PRR_ESV_SI_GET_COMM_POPUP(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public void executeDbProcedure() {
		
		String 	 V_SQL             			="";
		String   V_ADD_CRIT					="";					   		// Additional criterias from the search
		String   V_SQL_COUNT                ="";					   		// For couting the total rows for paging
		String   V_AND_OPERAND				="";						   // For keeping AND Operand
		int   	 V_TOTAL_ROW				;							   // Place holder for total rows for paging
		String   V_SQL_ROWNUM				="";					   	   // For keeping dynamic rownum filter
		String   V_SQL_ROWNUM2				="";					   	   // For keeping dynamic rownum filter
		String   V_SORT_BY					="";					   	   // For keeping dynamic sorting columns
		String   V_ORDER_BY					="";	
		  
		V_AND_OPERAND=" AND ";
		
		V_SQL = "SELECT CG.DESCRIPTION as COMM_GRP_DESC "+
			   	 ", CG.COMMODITY_GROUP_CODE as COMM_GRP_CODE "+
			   	 ", CM.FCDESC as COMM_DESC "+
			   	 ", CM.FCCODE as COMM_CODE "+
		  "FROM ITP080 CM, Commodity_Group CG "+
		  "WHERE FCRCST = 'A' " +
			  "	AND CM.COMMODITY_GROUP_CODE = CG.COMMODITY_GROUP_CODE";
	
		
		 if (map.get("P_I_V_COMM_GROUP_CODE")!=null && !map.get("P_I_V_COMM_GROUP_CODE").equals("")){
		   if( !V_ADD_CRIT.equals("")) {
		   	  V_ADD_CRIT = V_ADD_CRIT + V_AND_OPERAND;
		 }
		   V_ADD_CRIT = V_ADD_CRIT + " CG.COMMODITY_GROUP_CODE = '"+map.get("P_I_V_COMM_GROUP_CODE")+"' ";
		 }
      
      if(map.get("P_I_V_COMM_CODE")!=null && !map.get("P_I_V_COMM_CODE").equals("")) { 
	   if(map.get("V_ADD_CRIT")!=null && !map.get("V_ADD_CRIT").equals("")) {
	   	  V_ADD_CRIT = V_ADD_CRIT + V_AND_OPERAND;
	   }
		  if(map.get("P_I_V_WILDCARD").equals("Y") ){
		   V_ADD_CRIT = V_ADD_CRIT + " CM.FCCODE like ('"+map.get("P_I_V_COMM_CODE")+"%"+"') ";
		  }else {
		   V_ADD_CRIT = V_ADD_CRIT + " CM.FCCODE = '"+map.get("P_I_V_COMM_CODE")+"' ";
		  }
      }
   
   
   if(map.get("P_I_V_COMM_DESC") !=null && !map.get("P_I_V_COMM_DESC").equals("")) {
	   if( V_ADD_CRIT != null && !V_ADD_CRIT.equals("")){
	   	  V_ADD_CRIT = V_ADD_CRIT + V_AND_OPERAND;
	   }
		if(map.get("P_I_V_WILDCARD").equals("Y")) {
			V_ADD_CRIT = V_ADD_CRIT + " UPPER(CM.FCDESC) LIKE (UPPER('%"+map.get("P_I_V_COMM_DESC")+"%"+"')) ";
		}else {
			V_ADD_CRIT = V_ADD_CRIT + " UPPER(CM.FCDESC) = UPPER('"+map.get("P_I_V_COMM_DESC")+"') ";
			}
   }


	if(map.get("P_I_V_RECORD_START")!=null && !map.get("P_I_V_RECORD_START").equals("") && map.get("P_I_V_RECORD_END")!=null && !map.get("P_I_V_RECORD_END").equals("")) {
	V_SQL_ROWNUM = "SELECT * FROM (SELECT /*+ FIRST_ROWS(n) */"+
		  			   	   " a.*, row_number() OVER () AS rnum FROM (";
	V_SQL_ROWNUM2 = " LIMIT  "+map.get("P_I_V_RECORD_END")+") B where rnum  >= "+map.get("P_I_V_RECORD_START");
	}


	if( !V_ADD_CRIT.equals("") ){

		V_SQL_COUNT = "SELECT COUNT(1) as TOTAL_ROW FROM ("+V_SQL+V_AND_OPERAND+V_ADD_CRIT+")";

		if( !V_SQL_ROWNUM.equals("") ) {

			V_SQL = V_SQL_ROWNUM + V_SQL +V_AND_OPERAND+V_ADD_CRIT+ ") a ";


			V_SQL = V_SQL + "   " + V_SQL_ROWNUM2;
		}else {

			V_SQL = V_SQL_ROWNUM + V_SQL+V_AND_OPERAND+V_ADD_CRIT+ ") a ";

		}
	}else {
		V_SQL_COUNT = "SELECT COUNT(1) as TOTAL_ROW FROM ("+ V_SQL + ")";

		if( !V_SQL_ROWNUM.equals("")) {
			V_SQL = V_SQL_ROWNUM + V_SQL + ") a "+
					"   ";
			V_SQL = V_SQL + V_SQL_ROWNUM2;
		}
	}
		

	V_TOTAL_ROW=jdbcTemplate.queryForInt(V_SQL_COUNT+" CN") ;
	map.put("P_O_V_TOTAL_ROW", V_TOTAL_ROW) ;

	if(map.get("P_I_V_SORT_BY")!=null && !map.get("P_I_V_SORT_BY").equals("")) {
	    V_SORT_BY = " ORDER BY "+map.get("P_I_V_SORT_BY");
	}else {
		 /*Default sorting columns */
		V_SORT_BY = " ORDER BY " + " COMM_GRP_DESC ";
	}

	if(map.get("P_I_V_ORDER_BY")!= null && !map.get("P_I_V_ORDER_BY").equals("")) {
	    V_ORDER_BY = " " + map.get("P_I_V_ORDER_BY");
	}else {
		 /*Default order by*/ 
		V_ORDER_BY = " ASC";
	}

	V_SQL = V_SQL + V_SORT_BY + V_ORDER_BY;
 

   List<EshippingCommodityPopupMod> list=jdbcTemplate.query(V_SQL, new EsiCommodityPopupRowMappers() );



		map.put("P_O_V_DTL_DATA", list);
		}
	public class EsiCommodityPopupRowMappers extends JdbcRowMapper {
        
        /**
         * 
         * This mothod for set data to booking data in each row.
         * 
         * @exception SQLException
         * @param rs List of commodity data
         * @param row Row of commodity data
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException {
            EshippingCommodityPopupMod obj = new EshippingCommodityPopupMod();
            obj.setCommGrpDesc(rs.getString("COMM_GRP_DESC"));
            obj.setCommGrpCode(rs.getString("COMM_GRP_CODE"));
            obj.setCommDesc(rs.getString("COMM_DESC"));
            obj.setCommCode(rs.getString("COMM_CODE"));
            return obj;
        }    
    }
}

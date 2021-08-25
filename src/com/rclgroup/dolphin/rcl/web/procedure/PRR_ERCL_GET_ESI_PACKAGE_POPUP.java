package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingPackageTypeListMod;

public class PRR_ERCL_GET_ESI_PACKAGE_POPUP {

	private JdbcTemplate jdbcTemplate;
	private Map map;

	public PRR_ERCL_GET_ESI_PACKAGE_POPUP(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	
	public void executeDbProcedure() {
		
		String 		V_SQL                       ="";
		String   	V_ADD_CRIT					="";					   		// Additional criterias from the search
		String   	V_SQL_COUNT                 ="";					   		// For couting the total rows for paging
		String   	V_AND_OPERAND				="";						   // For keeping AND Operand
		int  		V_TOTAL_ROW					=0 ;							   // Place holder for total rows for paging
		String  	V_SQL_ROWNUM				="";					   	   // For keeping dynamic rownum filter
		String   	V_SQL_ROWNUM2				="";					   	   // For keeping dynamic rownum filter
		String   	V_SORT_BY					="";					   	   // For keeping dynamic sorting columns
		String   	V_ORDER_BY					="";						   // For keeping dynamic order by ASC or DESC
		
		V_AND_OPERAND = " AND ";

  	    V_SQL = "SELECT PKDESC as PACKAGE_NAME "+
			  	 		 ", PKCODE as PACKAGE_CODE "+
				 " FROM ITP170 "+
				 " WHERE PKRCST = 'A' ";
		
  	  if(map.get("P_I_V_NAME") !=null && !map.get("P_I_V_NAME").equals("")) {
	   if(!V_ADD_CRIT.equals("")) {
	   	  V_ADD_CRIT = V_ADD_CRIT + V_AND_OPERAND;
	   };
	   V_ADD_CRIT = V_ADD_CRIT + " PACKAGE_NAME LIKE '%"+map.get("P_I_V_NAME")+"%' ";
  	  }
  	    
  	if(map.get("P_I_V_CODE") !=null  && !map.get("P_I_V_CODE").equals("")) {
	   if( !V_ADD_CRIT.equals("")) {
	   	  V_ADD_CRIT = V_ADD_CRIT + V_AND_OPERAND;
	   }
	   V_ADD_CRIT = V_ADD_CRIT +" PACKAGE_CODE LIKE '%"+map.get("P_I_V_CODE")+"%' ";
  	}  
  	  
  	/* ROW NUM PREPARATION */
	if(map.get("P_I_V_RECORD_START") !=null && map.get("P_I_V_RECORD_END") !=null) {
	   V_SQL_ROWNUM = "SELECT * FROM (SELECT /*+ FIRST_ROWS(n) */"+
		  			   	    "a.*, row_number() OVER () rnum FROM (";
	   V_SQL_ROWNUM2 = " LIMIT "+map.get("P_I_V_RECORD_END")+") B where rnum  >= "+map.get("P_I_V_RECORD_START");
	}
  	
  	
	if( !V_ADD_CRIT.equals("")) {
	   /* Total row count sql need no rownum filter required*/
		V_SQL_COUNT = "SELECT COUNT(1) as TOTAL_ROW FROM ("+ V_SQL+") CN"+
		  		   	  	" WHERE "+  V_ADD_CRIT;

	   	if(!V_SQL_ROWNUM.equals("")) {
		   V_SQL = V_SQL_ROWNUM + V_SQL + ") a"+
		  		   	 " WHERE " + V_ADD_CRIT;

		   /* Append rownum filter to only main dynamic sql.*/
		   V_SQL = V_SQL + " "  + V_SQL_ROWNUM2;
	   	}else{
		   V_SQL  = "SELECT * FROM (" + V_SQL + ") a"+
		  		   	 " WHERE "+ V_ADD_CRIT;
	   	}
	}else {
		/* Total row count sql need no rownum filter required*/
		V_SQL_COUNT = "SELECT COUNT(1) as TOTAL_ROW FROM ("+ V_SQL + ") CN";

	   	if( !V_SQL_ROWNUM.equals("")) {
		   V_SQL = V_SQL_ROWNUM + V_SQL + ") a"+
		  		   	"    ";

		   /* Append rownum filter to only main dynamic sql.*/
		   V_SQL = V_SQL + V_SQL_ROWNUM2;
	   	}
	}
	
	V_TOTAL_ROW=jdbcTemplate.queryForInt(V_SQL_COUNT ) ;
	map.put("P_O_V_TOTAL_ROW" , V_TOTAL_ROW);

	/* Default sorting columns */
	V_SORT_BY = " ORDER BY " + " PACKAGE_NAME ";

	/* Default order by */
	V_ORDER_BY = " ASC";

	V_SQL = V_SQL + V_SORT_BY + V_ORDER_BY;


		List<EshippingPackageTypeListMod> list=jdbcTemplate.query(V_SQL, new PackageKingTypeRowMapper());
		
		map.put("P_O_V_DTL_DATA", list);
		
	}
	
	  public class PackageKingTypeRowMapper extends JdbcRowMapper{

	        /**
	         * 
	         * This mothod for set data to package kind type in each row.
	         * 
	         * @exception SQLException
	         * @param rs List of package kind type
	         * @param row Row of package kind type
	         */
	        public Object mapRow(ResultSet rs, int row) throws SQLException{
	            EshippingPackageTypeListMod obj = new EshippingPackageTypeListMod();
	            obj.setPackageName(rs.getString(1));
	            obj.setPackageCode(rs.getString(2));
	            return obj;
	        }
	    }
}

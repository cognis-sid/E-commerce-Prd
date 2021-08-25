package com.rclgroup.dolphin.rcl.web.procedure;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class PRR_ESV_DG_VALIDATE {

	JdbcTemplate jdbcTemplate;
	Map map;
	
	public PRR_ESV_DG_VALIDATE(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	
	public void executeDbProcedure() {
		
		int V_COUNT=0;
		String V_COUNT_QUERY1="";
		String V_COUNT_QUERY2="";
		String P_O_V_ERR_DESC="";
		
		String P_I_V_UNNO_TEMP= "";
		String P_I_V_VARIANT_TEMP="";
		String P_I_V_IMDG_TEMP= "";
		String P_I_V_PORT_CLASS_TEMP ="";
		
		
		 if(map.get("P_I_V_UNNO").equals("") || map.get("P_I_V_UNNO") == null){
			 P_I_V_UNNO_TEMP="-";
		 }else {
			 P_I_V_UNNO_TEMP=(String) map.get("P_I_V_UNNO");
		 }
		 if(map.get("P_I_V_VARIANT").equals("") || map.get("P_I_V_VARIANT") == null){
			 P_I_V_VARIANT_TEMP="-";
		 }else {
			 P_I_V_VARIANT_TEMP=(String) map.get("P_I_V_VARIANT");
		 }
		 if(map.get("P_I_V_IMDG").equals("") || map.get("P_I_V_IMDG") == null){
			 P_I_V_IMDG_TEMP="-";
		 }else {
			 P_I_V_IMDG_TEMP=(String) map.get("P_I_V_IMDG");
		 }
		 if(map.get("P_I_V_PORT_CLASS").equals("") || map.get("P_I_V_PORT_CLASS") == null){
			 P_I_V_PORT_CLASS_TEMP="-";
		 }else {
			 P_I_V_PORT_CLASS_TEMP=(String) map.get("P_I_V_PORT_CLASS");
		 }
		
		 if( !P_I_V_UNNO_TEMP.equals("-") || !P_I_V_VARIANT_TEMP.equals("-") || !P_I_V_IMDG_TEMP.equals("-")) {
			 V_COUNT_QUERY1 ="SELECT COUNT(*)  "+
					 	"   FROM PORT_CLASS "+
					 	"   WHERE record_status='A' "+
					 	"  AND PORT_CLASS_TYPE = (SELECT PORT_CLASS_TYPE FROM PORT_CLASS_TYPE "+
                                    "  WHERE PORT_CODE = 'SGSIN' "+
                                    "  AND record_status = 'A') "+
                                    "  AND UNNO ='"+map.get("P_I_V_UNNO")+"'"+
                                    "  AND VARIANT ='"+ map.get("P_I_V_VARIANT")+"'"+
                                    "  AND IMDG_CLASS ='"+ map.get("P_I_V_IMDG") +"'";
			 V_COUNT=jdbcTemplate.queryForInt(V_COUNT_QUERY1);
         if( V_COUNT == 0 ){
        	map.put("P_O_V_ERR_DESC" ,"Please select the correct UNNO,VARIANT,IMDG.");
         }
		 }

      if( !P_I_V_PORT_CLASS_TEMP.equals("-") ) {
    	  V_COUNT_QUERY2="SELECT COUNT(*)  "+
    			  			" FROM PORT_CLASS "+
            "  WHERE record_status='A' "+
            "   AND PORT_CLASS_TYPE = (SELECT PORT_CLASS_TYPE FROM PORT_CLASS_TYPE "+
                                    "  WHERE PORT_CODE = 'SGSIN' "+
                                    "  AND record_status = 'A') "+
            "  AND PORT_CLASS_CODE = '"+map.get("P_I_V_PORT_CLASS")+"'";
    	  V_COUNT=jdbcTemplate.queryForInt(V_COUNT_QUERY2);
         if( V_COUNT == 0 ) {
        	 map.put("P_O_V_ERR_DESC" ,"Port Class is invalid.");
         }
      }
	}
	
}

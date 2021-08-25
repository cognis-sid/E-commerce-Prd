package com.rclgroup.dolphin.rcl.web.procedure;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.common.ComboVO;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.AncestorJdbcDao.ComboRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;

public class PRR_ESV_GET_EQUIP_TYPE extends AncestorJdbcDao{

	private JdbcTemplate jdbcTemplate;
	private Map map;
	private SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
	
	public PRR_ESV_GET_EQUIP_TYPE(JdbcTemplate jdbcTemplate,Map map) {
		this.jdbcTemplate=jdbcTemplate;
		this.map=map;
	}
	public void executeDbProcedure() {
	
	String	 V_SQL    				=null;
	String	 V_CONDITION    		=null;
		
	 V_CONDITION = "=" ;

    V_SQL = "select * from (select T.TRTYPE \"CODE\", T.TRTPNM \"DESC\"  "+
                             "  from ITP075 T "+
                             "  where T.TRRCST = 'A'  "+
                             "    AND T.trtype <> '**' "+
                             "    and T.TRBORW = 'B') EQ where 1=1 ";
    if(map.get("P_I_V_COL_NAME")!=null && !map.get("P_I_V_COL_NAME").equals("")){
    	String KEY_SEARCH="";
    	if(map.get("P_I_V_KEY_SEARCH")==null ) {
    		KEY_SEARCH="N";
    	}else {
    		KEY_SEARCH=	(String) map.get("P_I_V_KEY_SEARCH");
    	}
    	if( KEY_SEARCH.equals("N") ) {
    		if( map.get("P_I_V_WILD_CARD").equals("Y") ) {
    			V_CONDITION = "LIKE";
    		}

    		V_SQL = V_SQL + " AND " +  map.get("P_I_V_COL_NAME") + " " + V_CONDITION +
    				" (case  WHEN '"+V_CONDITION+"' = 'LIKE' then '"+map.get("P_I_V_COL_VAL")+"%' else '"+map.get("P_I_V_COL_VAL")+"' end )";
    	}else {
    		V_SQL = V_SQL + " and code like ('"+map.get("P_I_V_COL_VAL")+"%') or descr ('"+map.get("P_I_V_COL_VAL")+"%')";
    	}
    }

    if(map.get("P_I_V_SORT_BY")!=null && map.get("P_I_V_SORT_BY").equals("")){
    	V_SQL = V_SQL + " ORDER BY EQ "+ map.get("P_I_V_SORT_BY") + " " + map.get("P_I_V_ORDER_BY") ;
    }else {
    	V_SQL = V_SQL + " ORDER BY  \"DESC\" " + map.get("P_I_V_ORDER_BY") ;
    }

    List<ComboVO> list=jdbcTemplate.query(V_SQL, new Object[] {}, new ComboRowMapper());
    //map.put("P_O_V_DATA", list);
    
    Map outPut=new HashMap();
	outPut.put("P_O_V_REF_CURSOR_DATA",list);
	outPut.put("P_O_V_ERROR",null);
	
	map.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);

	}
	
	 
	
}

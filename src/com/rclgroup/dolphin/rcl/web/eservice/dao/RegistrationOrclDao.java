package com.rclgroup.dolphin.rcl.web.eservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

public class RegistrationOrclDao extends AncestorJdbcDao {

	public JdbcTemplate getDatasourceTemplate() {
		
		
		
		
		return getJdbcTemplate();
	}
	
	public JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam) {
        JdbcStoredProcedure storeProcedure = null;
        try{
            if(rowMapper != null){
                if(arrParam != null){
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
                }else{
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
                }
            }else{
                if(arrParam != null){
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
                }else{
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return storeProcedure;
    }
	
}

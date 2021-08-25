package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.dao.AncestorJdbcDao;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;

import com.rclgroup.dolphin.rcl.web.common.RrcStandardSQLErrorCodesTranslator;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EReportServerConfigMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingStructionPrintMod;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface EshippingInstructionPrintDao  {
       
                                                     
                                                     
            /**
             * @param quotationNo
             * @return
             * @throws DataAccessException
             */
        public Vector getListBLPrint(String session, String userName) throws DataAccessException;
        
     
            /**
             *  @param quotationNo
             * @param sessionId   
             * @return username
             * @throws DataAccessException
             */
        public String getSessionId(String service  , String vessel, String voyage,  String direction, 
                                                          String offCreateBL ,String bl,String cocsoc,String print,
                                                          String pol_sts,String dateFrom,String dateTo,String third,
                                                          String fsc,String userCode,String sessionid,String line,
                                                          String region,String agent,String fscCode
                                                         ) throws DataAccessException;
                                                         
                                                         
                                                         
            public EReportServerConfigMod getDefaultReportServerConfigMod();
            
            
            
            
            /**
             * @param blNumber
             * @return
             * @throws DataAccessException
             */
            public Vector getListBKGPrint(String blNumber) throws DataAccessException;
            
            
        }



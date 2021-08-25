package com.rclgroup.dolphin.rcl.web.common;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class RrcStandardSQLErrorCodesTranslator  extends SQLErrorCodeSQLExceptionTranslator {




    private String messages;
    private List errorMessageList;
    Throwable exceptionCause = null;
    
  
} 

 /*
  * @(#)AccessControl.java
  *
  * Copyright 2001 by NIIT,
  * All rights reserved.
  * 
  * This software is the confidential and proprietary information
  * of NIIT. ("Confidential Information").  
  */

 package com.rclgroup.dolphin.rcl.resource;

 import java.io.IOException;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.control.common.GlobalConstants;
import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.rcl.web.common.SchedulerJob;
import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;


 /**
  * @version     1.0
  * @author NIIT
  */
 public class AccessControl extends org.apache.struts.action.ActionServlet implements GlobalConstants  {

     
     public static final String QUERY_STR  = "?";
     public static final String EQUAL      = "=";
     public static final String MENU       = "MENU";
     public static final String DO         = "/do/";
     public static final String HOME       = "/serv00111";
     public static final String REPORT_URL = "/openReport";
     public static final String SCREEN_ID  = "/screenId";
     public static final String SECM002 = "SECM002";
     public static final String SECM004 = "SECM004";
     public static final String ENOTICE = "ENOTICE";
     public static final String REGISTRATION = "/serv007";
     public static final String REGISTRATION_NEW="/sexn007";
     public static final String LOGIN_NEW="/serv00111";
     
     public static EservicePropertyFatchOperation dbConnection;
     
     
     public static SchedulerJob job;
     
     /**
     * @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
     public void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
         doPost(req,resp);
     }

     /**
     * @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
     public void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
                  super.doPost(req, resp);   
               }


     /**
     * @see javax.servlet.GenericServlet#void ()
     */
     public void init() throws ServletException {

         super.init();

     }
     
     @Override
 	public void init(ServletConfig config) throws ServletException {
 		// TODO Auto-generated method stub
 		super.init(config);
 		loadStarting();
 		startSchedular();
 	}
     public static void loadStarting() {//call 
    	 dbConnection= (EservicePropertyFatchOperation) EZLBeanFactory.getBeanSpringJdbc("EservicePropertyFatchOperation");
    	 EservicePropertyFatchOperation.getAllpropertyData();
     }
     public static void startSchedular() {
    	Timer timer = new Timer();
    	job=new SchedulerJob(timer,(new Date()).toString());
       	timer.schedule(job,100, 1000*1*60);
     }
     public static void reSetSchedular() {
     	job.getTimer().cancel();
     	Timer timer = new Timer();
     	job=new SchedulerJob(timer,(new Date()).toString());
       	timer.schedule(job,100, 1000*1*60);
      }
 }
 /* Modification History
  *
  * 2005-07: Modified for Tops
  * 2009-11: Moified for EZL
  *
  */

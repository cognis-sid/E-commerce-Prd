/*------------------------------------------------------
EserviceAcknowledgementSvc.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
1   01/08/2014  Pratya  @01         Eservice phase 3.1
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.LoginDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceSearchApiServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.FtpConfig;

import net.sf.json.JSONObject;

public class EserviceSearchSvc extends BaseAction {

	private static final SimpleDateFormat dateFormatDDMMYY = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat converToYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	
    public EserviceSearchSvc() {
    }

    /**
     * 
     * Called from Action Servlet
     * 
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form, 
                                       HttpServletRequest request, 
                                       HttpServletResponse response) throws Exception {
    	
    		EserviceNewWebBookingUim objForm = null;
    		
    		FtpConfig ftfConfig = (FtpConfig) EZLBeanFactory.getBean("ftpConfig");
    		
            objForm = (EserviceNewWebBookingUim)form;
        
    	String pol=request.getParameter("pol");
    	String pod=request.getParameter("pod");
    	String shipmentEtd=request.getParameter("pol_etd_date");
    	//String shipmentEtd=convertDateInDDMMYY(request.getParameter("pol_etd_date"));
    	//String flagDirect="Y";
    	//String flag1ts="Y";
    	//String flag2ts="Y";
    	
    	
    	LoginDao dao = (LoginDao) getDao(LoginDao.DAO_NAME);
    	Map map=dao.getCheckPolPod(pol,pod);
    	if(map==null) {
    		 String output="{\"obj\":{ \"productcatalog\":[],\"msg\":{\"error\":\"Pol and Pod not matched Contact RCL Local Agency\"}}}";
    		 objForm.setAgent(output);
    	}else {
    		
		ObjectMapper mapper = new ObjectMapper();
		String newOut =mapper.writeValueAsString(map);
    	String obj = "{\"obj\":[";	
    	String url= dao.getUrlWebServices();
    	//String url= ftfConfig.getUrlForSeach();
    	
    	System.out.println("URL of Search++++++++++++SID+++++++++++++++++ "+url+"?id="+Math.random());
    	//String url="http://dummy.restapiexample.com/api/v1/create";
        String strAction = mapping.getParameter();
        if (ONLOAD.equals(strAction)) 
        {
        	 CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();	
        	 httpclient.start();
             final HttpPost post = new HttpPost(url+"?id="+Math.random());
             try {

					
					/*
					 * JSONObject json = new JSONObject(); json.put("pol", pol); json.put("pod",
					 * pod); json.put("shipmentEtd", shipmentEtd); json.put("flagDirect", "Y");
					 * json.put("flag1ts", "Y"); json.put("flag2ts", "Y");
					 */
					 

            	 
					/*
					 * System.out.println("json "+json.toString()); HttpEntity stringEntity = new
					 * StringEntity(json.toString(),ContentType.APPLICATION_JSON);
					 * post.setEntity(stringEntity);
					 */
            	 
					
					
					  List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					  nameValuePairs.add(new BasicNameValuePair("pol", pol));
					  nameValuePairs.add(new BasicNameValuePair("pod", pod));
					  nameValuePairs.add(new BasicNameValuePair("pol_etd_date", shipmentEtd));
					  nameValuePairs.add(new BasicNameValuePair("transhipment_service", "E"));
					  post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					 
					 
                 
                 Future<HttpResponse> future = httpclient.execute(post, null);
                 // and wait until a response is received
                 HttpResponse response1= null;
                 while( (response1 = future.get())!=null) {
                  // and wait until a response is received
                 
                  
                	 String output="{ \"productcatalog\":[]}";
                	 try {
                	 output = org.apache.http.util.EntityUtils.toString(response1.getEntity());
                	 output=	obj+output+","+newOut+"]}";
                	 if(output.equals("java.lang.NullPointerException")) {
                		 output="{ \"productcatalog\":[]}";
                		 output= obj+output+","+newOut+"]}";
                	 }
                	 }catch (Exception e) {
                	 e.printStackTrace();
                	 }
					

                 objForm.setAgent(output);
                 System.out.println(output);
                 break;
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    	}
        return mapping.findForward(SUCCESS);

    } //executeAction

    /**
     * This method called when screen loads
     * @param mapping
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public ActionForward onLoad(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception {
        EserviceNewWebBookingUim objForm = null;
        
        String bookingNo = null;
        String email = null;
        String customerName = null;
        try{
            objForm = (EserviceNewWebBookingUim)form;
            
            bookingNo = objForm.getBookingNo();
            if(bookingNo == null || BLANK.equals(bookingNo)){
                bookingNo = request.getParameter("bookingNo");    
            }
            email = objForm.getEmail();
            if(email == null || BLANK.equals(email)){
                email = request.getParameter("email");    
            }
            customerName = objForm.getCustomerName();
            if(customerName == null || BLANK.equals(customerName)){
                customerName = request.getParameter("customerName");    
            }
            objForm.setUserId(getEmpName(request));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return mapping.findForward(SUCCESS);

    } // end of onLoad method
    
    public static String convertDateInDDMMYY(String date) {

		if (date != null) {
			try { Date dates = dateFormatDDMMYY.parse(date); return
					converToYYYYMMDD.format(dates); 
			} catch (ParseException e) {

				// TODO Auto-generated catch block e.printStackTrace();
				System.out.println("date " + date); } } return null;

	}
}

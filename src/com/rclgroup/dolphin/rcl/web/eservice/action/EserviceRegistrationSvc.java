 /*------------------------------------------------------
 EshippingInstructionSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Yossawat Suntisukkasem 12/12/13
 - Change Log ----------------------------------------------------
##  DD/MM/YY    �User-      -TaskRef-       -ShortDescription-
    14/01/14    YOSSUN1     01              Add module for internal.
    07/10/14    Pratya      02              PD_CR_20140826_ESV [Contract Party for registeration]
03  03/06/15    Sarawut                   Check user role_cd can edit or read only
04  29/12/15    Watchakorn                Disabled by comment enotice for contract party.
05  20/12/2018  Thitipong   05                Add checkbox Non RA Account.
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
*/

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.ComboVO;
import com.niit.control.common.GlobalConstants;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.octo.captcha.service.CaptchaServiceException;
import com.rclgroup.dolphin.rcl.web.captcha.CaptchaServiceSingleton;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVConstants;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVUtil;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.common.RegistrationThread;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.RegistrationOrclDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserInfoMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PolPod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;
import com.rclgroup.dolphin.rcl.web.util.RutMessage;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class EserviceRegistrationSvc extends BaseAction {
    private final String COUNTRY_LIST = "countryList";
    private boolean TEST_MODE = false;

    /*Begin @02*/
    private final String ADD_CONTRACT_COMPANY           = "addContractPartyCompany";
    private final String UPD_CONTRACT_COMPANY           = "updContractPartyCompany";
    private final String DEL_CONTRACT_COMPANY           = "delContractPartyCompany";
    private final String CREATE_CRM_FOR_CONTRACT_PARTY  = "createCRMCustomerForContractParty";

    private FormatUtil formatUtil = null;
    /*End @02*/

    /*##03 Begin*/
    private final String ACTIVATE_REPRESENTED_COMPANY   = "activateRepresentedCompany";
    private final String FILTER_CONTRACT_PARTY          = "filterContractParty";
    /*##03 End*/

    private String getForwardPage(EserviceRegistrationUim form, HttpServletRequest request, HttpServletResponse response,ActionForm actionForm) throws Exception {
        String pageAction   = null;
        String forwardPage  = null;

        try {
            pageAction          = form.getCurrPageAction();
            this.formatUtil     = new FormatUtil(request, response);

            if ("onload".equals(pageAction)){
                forwardPage = initRegistration(form, request);
            }else if("checkAvailableUserId".equals(pageAction)){
                forwardPage = checkAvailableUserId(request, response);
            }else if("checkCustomerCode".equals(pageAction)){
                forwardPage = getCheckCustomerCode(form,request, response);
            }else if ("registration".equals(pageAction)){
                forwardPage = registration(form, request);
            }else if("createCRMCustomer".equals(pageAction)){
                forwardPage = createCRMCustomer(form, request);
            }else if("manageAccount".equals(pageAction)){
                forwardPage = manageAccount(form, request);
            }else if("generateCaptcha".equals(pageAction)){
                forwardPage = generateCaptcha(request, response);
            }else if("openAcknowledge".equals(pageAction)){
                forwardPage = SUCCESS;
            }else if ("rejectReason".equals(pageAction)){
                forwardPage = rejectReason(form, request);
            }else if (ADD_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_addContractPartyCompany(form, request);
            }else if (UPD_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_updContractCompany(form, request);
            }else if (DEL_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_delContractCompany(form, request);
            }else if(CREATE_CRM_FOR_CONTRACT_PARTY.equals(pageAction)){
                /*Begin @02*/
                forwardPage = this.createCRMCustomerForContractParty(form, request);
                /*End @02*/
                /*##03 Begin*/
            } else if(ACTIVATE_REPRESENTED_COMPANY.equals(pageAction)){
                forwardPage = this.activateRepresentedCompany(form, request);
            } else if(FILTER_CONTRACT_PARTY.equals(pageAction)){
                forwardPage = this.filterContractPartyCompany(form, request);
                /*##03 End*/
            }else if("Login".equals(pageAction)){
                forwardPage = login(request);
            }else if("openWebBooking".equals(pageAction)){
                    forwardPage = openWebBooking(request,response,form,actionForm);
            }else if("getPolpod".equals(pageAction)){
                forwardPage = getPolpod(request,response,form,actionForm);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return forwardPage;
    }

    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
        EserviceRegistrationUim form = null;

        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = getPageAction(mapping);

            form = getForm(actionForm, pageAction);
            form.setCurrPageAction(pageAction);

            forwardPage = getForwardPage(form, request, response,actionForm);
        } catch (Exception ex) {
            ex.printStackTrace();

            forwardPage = form.getPrevPageAction();
            if ((forwardPage == null) || ("".equals(forwardPage))) {
                forwardPage = "initRegistration";
            }
        }

        return mapping.findForward(forwardPage);
    }

    public String manageAccount(EserviceRegistrationUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceRegistrationSvc][manageAccount][Begin]");

        String errMsg        = null;
        String forwardPage   = null;

        try{
            form.setInternalUser(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES);
            forwardPage = initRegistration(form, request);

            forwardPage = SUCCESS;
        }catch (Exception ex){
            errMsg = ex.getMessage();
            throw ex;
        } finally {
            System.out.println("[EserviceRegistrationSvc][manageAccount][End]");
        }
        return forwardPage;
    }

    public String initRegistration(EserviceRegistrationUim form, HttpServletRequest request) throws Exception {

        System.out.println("[EserviceRegistrationSvc][initRegistration][Begin]");

        List<ComboVO>                                   countryList             = null;
        EserviceRegistrationDao                         objDao                  = null;
        EserviceRegistrationUserInfoMod                 userInfoMod             = null;
        List<EserviceRegistrationUserServiceMod>        userServiceModList      = null;
        Map<String, String>                             captchaKeyMap           = null;
        Map                                             resultMap               = null;
        //@01 BEGIN
        UserAccountBean                                 userAccountBean         = null;
        //@01 END
        String                                          userId                  = null;
        String                                          userMode                = null;
        String                                          fscCode                 = null;
        String                                          customerCode            = null;
        String                                          customerFscCode         = null;
        String                                          customerType            = null;
        String                                          registMode              = null;
        String                                          privateKey              = null;
        String                                          publicKey               = null;
        String                                          errorCRMDesc            = null;
        String                                          errorDesc               = null;
        String                                          forwardPage             = null;
        /*Begin @02*/
        List <EserviceContractPartyPortPairMod>         contractPartyList       = null;
        EserviceContractPartyPortPairMod                contractPartyMod        = null;
        String                                          userRegistId            = null;
        int                                             defaultRow              = 1;
        String                                          pkPortPairSeq           = null;
        String                                          portPairFlag            = null;
        String                                          fromMenu                = null;
        /*End @02*/
        String                                          roleCD                  = null;

        try {

            objDao              = getDao();
            userAccountBean     = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
            registMode          = request.getParameter("registMode");
            fromMenu          = request.getParameter("fromMenu");
            form.setErrMsg("");
            if("serv015".equals(fromMenu)){
                userId          = userAccountBean.getUserId();
                roleCD          = objDao.checkUserRoleCD(userId);
                form.setFromMenu(fromMenu);

                if ("EREG-M".equals(roleCD)){
                    request.setAttribute("userIdViewMode", "false");
                    request.setAttribute("authPage", "Auth");
                }else if ("EREG-E".equals(roleCD)){
                    request.setAttribute("userIdViewMode", "true");
                    request.setAttribute("authPage", "Auth");
                }else{
                    errorCRMDesc = roleCD;
                    request.setAttribute("userIdViewMode", "false");
                    request.setAttribute("authPage", "noAuth");
                    request.setAttribute("userId", userId);
                }
            }

            if(registMode != null && "R".equals(registMode)){
                userMode            = EserviceRegistrationDao.USER_MODE.EXTERNAL;
                userInfoMod         = new EserviceRegistrationUserInfoMod();
                /*Begin @02*/
                contractPartyList   = form.getContractPartyList();
                for(int i=0;i<defaultRow;i++){
                    contractPartyMod    = new EserviceContractPartyPortPairMod();
                    pkPortPairSeq       = String.valueOf(i);

                    contractPartyMod.setPkPortPairSeq(pkPortPairSeq);
                    contractPartyMod.setStatusFlag(EserviceRegistrationDao.ADD);
                    contractPartyList.add(contractPartyMod);
                    form.setMaxPkPortPairSeq(pkPortPairSeq);
                }
                /*End @02*/

            }else{
            	if(userAccountBean == null) {
            		userAccountBean = new UserAccountBean();
            	}
                userId          = userAccountBean.getUserId();
                form.setUserLoginId(userId);

               // fscCode         = getUserFsc(request);
                userMode        = form.getInternalUser();

                if(!EserviceRegistrationDao.USER_MODE.INTERNAL_MRES.equals(userMode)){
                    userId      = request.getParameter("userRegistId");
                    userMode    = EserviceRegistrationDao.USER_MODE.INTERNAL;

                    System.out.println("[EserviceRegistrationSvc][initRegistration] userId :: " + userId);
                }
                resultMap = objDao.findUserRegisteredInformation(userId, fscCode);

                if(resultMap != null && !resultMap.isEmpty()){
                    userInfoMod = (EserviceRegistrationUserInfoMod) resultMap.get(KEY_REF_CURSOR);
                }
                if(userInfoMod == null){
                    userInfoMod = new EserviceRegistrationUserInfoMod();
                }
//                System.out.println("form.getInternalUser() >>>>>>>>>>>>>>>>>>>>>>>>> "+form.getInternalUser());
//                System.out.println("userMode >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+userMode);
//                System.out.println("EserviceRegistrationDao.USER_MODE.INTERNAL_MRES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+EserviceRegistrationDao.USER_MODE.INTERNAL_MRES);
                /*Begin @02*/
                if(form.getInternalUser().equals(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES)){
                    userRegistId = userAccountBean.getUserId();
                }else{
                    userRegistId    = request.getParameter("userRegistId");
                    portPairFlag    = FormatUtil.nullToBlank(request.getParameter("portPairFlag"));

                    if(!portPairFlag.equals("")) form.setPortPairFlag(portPairFlag);
                }
                //this.lp_getContractPartyPortPair(form, userRegistId, userAccountBean.getUserId(), userInfoMod);
                /*End @02*/

                if(EserviceRegistrationDao.USER_MODE.INTERNAL.equals(userMode)){

                  /*  //If portPairFlag = Y pull data form self table
                    if(portPairFlag.equals("Y")){
                        resultMap = objDao.findCustomerInfoMPP(userRegistId, userInfoMod.getCountry(),"");
                    }else{
                        resultMap = objDao.findCustomerInfo(userInfoMod.getCmpName(), userInfoMod.getCountry());
                    }*/

//                    resultMap = objDao.findCustomerInfo(userInfoMod.getCmpName(), userInfoMod.getCountry());
                    if(resultMap != null && !resultMap.isEmpty()){
                        if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_CD) && !portPairFlag.equals("Y")){
                            errorCRMDesc    = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                        }
                        customerCode        = (String) resultMap.get(EserviceRegistrationDao.P_O_V.CUST_CODE);
                        customerFscCode     = (String) resultMap.get(EserviceRegistrationDao.P_O_V.FSC);
                        customerType        = (String) resultMap.get(EserviceRegistrationDao.P_O_V.CUST_TYPE);

                        form.setCustomerCode(customerCode);
                        form.setCustomerFscCode(customerFscCode);
                        form.setCustomerType(customerType);
                    }
                }
            }

           /* resultMap = objDao.findUserRegisteredService(userId, userMode);
            if(resultMap != null && !resultMap.isEmpty()){
                if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.LIST_SERVICE_DATA)){
                    userServiceModList = (List<EserviceRegistrationUserServiceMod>) resultMap.get(EserviceRegistrationDao.P_O_V.LIST_SERVICE_DATA);
                }else{
                    userServiceModList = new ArrayList<EserviceRegistrationUserServiceMod>();
                }
            }*/
            userServiceModList = new ArrayList<EserviceRegistrationUserServiceMod>();
            
            
            
            EserviceRegistrationUserServiceMod obj = new EserviceRegistrationUserServiceMod();
            obj.setModuleName("Verified Gross Mass");
            obj.setSfu("EVGM-E");
            obj.setChecked(false);
            userServiceModList.add(obj);
            
            EserviceRegistrationUserServiceMod obj1 = new EserviceRegistrationUserServiceMod();
            obj1.setModuleName("Rate Inquiry");
            obj1.setSfu("EVGM-G");
            obj1.setChecked(false);
            userServiceModList.add(obj1);
            
            EserviceRegistrationUserServiceMod obj2 = new EserviceRegistrationUserServiceMod();
            obj2.setModuleName("Web Booking");
            obj2.setSfu("EBKG-E,EDOC-E");
            obj2.setChecked(false);
            userServiceModList.add(obj2);
            
			/*
			 * EserviceRegistrationUserServiceMod obj3 = new
			 * EserviceRegistrationUserServiceMod();
			 * obj3.setModuleName("eShipping Instruction"); obj3.setSfu("EDOC-E");
			 * obj3.setChecked(false);
			 */
            //userServiceModList.add(obj3);  // asked to remove bt @TA
            form.setUserServiceModList(userServiceModList);
            countryList = ComboBoxESVUtil.getESVComboBox(null, objDao, ComboBoxESVConstants.COMBO_BOX_TYPE.COUNTRY);
            forwardPage = SUCCESS;
        } catch (Exception ex) {
            errorDesc   = ex.getMessage();
            throw ex;
        } finally {


            if(countryList != null){
                form.setCountryList(countryList);
            }
            if(captchaKeyMap != null && !captchaKeyMap.isEmpty()){
                privateKey  = captchaKeyMap.get(EserviceRegistrationDao.CAPTCHA_CONFIG.CD_PRIVATE_KEY);
                publicKey   = captchaKeyMap.get(EserviceRegistrationDao.CAPTCHA_CONFIG.CD_PUBLIC_KEY);
            }
            form.setReEmailAddress(userInfoMod.getEmail());
            form.setUserInfoMod(userInfoMod);
           
            form.setInternalUser(userMode);
            form.setErrMsg(errorDesc);
            form.setCrmErrorMsg(errorCRMDesc);
            form.setFscCode(fscCode);
            form.setPrevPageAction(null);
            request.setAttribute("userIdPassed", "false");
            request.setAttribute("userIdChecked", "false");
            request.getSession().setAttribute(COUNTRY_LIST, countryList);

            System.out.println("[EserviceRegistrationSvc][initRegistration][End]");
        }

        return forwardPage;
    }

    /*Begin @02*/
    private void lp_getContractPartyPortPair(EserviceRegistrationUim form, String userRegistId, String userId, EserviceRegistrationUserInfoMod userInfoMod){
        System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair][Begin]");

        EserviceRegistrationDao                         objDao                     = null;
        List <EserviceContractPartyPortPairMod>         contractPartyList          = null;
        EserviceContractPartyPortPairMod                mod                        = null;
        EserviceContractPartyPortPairMod                modRes                     = null;
        String                                          tempPkEsvPpHdrSeq          = null;
        Map                                             resultMap                  = null;
        String                                          errorCRMDesc               = null;
        String                                          customerCode               = null;
        String                                          customerFscCode            = null;
        String                                          customerType               = null;
        String                                          excludeExpireContractParty = null;

        try{
            objDao                     = this.getDao();
            mod                        = new EserviceContractPartyPortPairMod();
            excludeExpireContractParty = form.getExcludeExpireContractParty(); //change to filter on screen

            System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] userRegistId               :: " + userRegistId);
            System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] userId                     :: " + userId);
            System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] excludeExpireContractParty :: " + excludeExpireContractParty);

            mod.setFkUserId(userRegistId);
            mod.setUserId(userId);
            contractPartyList   = objDao.getContractPartyPortPair(mod, excludeExpireContractParty);

            if(contractPartyList != null){
                System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] contractPartyList.size()       :: " + contractPartyList.size());
            }
            if(contractPartyList!=null && contractPartyList.size() > 0){
                for(int i=0;i<contractPartyList.size();i++){
                    modRes = contractPartyList.get(i);

                    if(i==0){
                        tempPkEsvPpHdrSeq = modRes.getPkEsvPpHdrSeq();
                    }else{
                        if(Integer.parseInt(modRes.getPkEsvPpHdrSeq()) > Integer.parseInt(tempPkEsvPpHdrSeq)){
                            tempPkEsvPpHdrSeq = modRes.getPkEsvPpHdrSeq();
                        }
                    }
//                    System.out.println("modRes.getApproveFlag() >>>>>>>>>>>>>>>> "+modRes.getApproveFlag());
                    //If portPairFlag = Y pull data form self table
                    if(form.getPortPairFlag().equals("Y")){
                        if(modRes.getApproveFlag().equals("Y")){
                            resultMap = objDao.findCustomerInfoMPP(userRegistId, modRes.getContractPartyName(),"C");
                        }else{
                            resultMap = objDao.findCustomerInfo(modRes.getContractPartyName(), BLANK);
                        }
                    }else{
                        resultMap = objDao.findCustomerInfo(modRes.getContractPartyName(), BLANK);
                    }

//                    resultMap = objDao.findCustomerInfo(modRes.getContractPartyName(), BLANK);
                    if(resultMap != null && !resultMap.isEmpty()){
                        if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_CD) && !modRes.getApproveFlag().equals("Y")){
                            errorCRMDesc    = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                            System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] errorCRMDesc              :: " + errorCRMDesc);
                            modRes.setErrCrmDesc(errorCRMDesc);
                        }
                        customerCode        = (String) resultMap.get(EserviceRegistrationDao.P_O_V.CUST_CODE);
                        customerFscCode     = (String) resultMap.get(EserviceRegistrationDao.P_O_V.FSC);
                        customerType        = (String) resultMap.get(EserviceRegistrationDao.P_O_V.CUST_TYPE);

                        System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] customerCode              :: " + customerCode);
                        System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] customerFscCode           :: " + customerFscCode);
                        System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair] customerType              :: " + customerType);

                        modRes.setFkContractPartyCode(customerCode);
                        modRes.setContractPartyFscCode(customerFscCode);
                        modRes.setContractPartyType(customerType);

                    }
                }
                form.setRepresentedCompanyFlag("Y");
                form.setMaxPkPortPairSeq(tempPkEsvPpHdrSeq);
                form.setContractPartyList(contractPartyList);
            /* ##03 Begin */
            /*}else{
                if(form.getInternalUser()!=null && form.getInternalUser().equals(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES)){
                    contractPartyList   = form.getContractPartyList();
                    modRes    = new EserviceContractPartyPortPairMod();

                    modRes.setPkPortPairSeq("0");
                    modRes.setStatusFlag(EserviceRegistrationDao.ADD);
                    modRes.setRecStatus("New");
                    contractPartyList.add(modRes);
                    form.setMaxPkPortPairSeq("0");
                }*/
              /* ##03 End */
            }

        }catch(CustomDataAccessException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceRegistrationSvc][lp_getContractPartyPortPair][End]");
        }
    }
    /*End @02*/

    private String getCheckCustomerCode(EserviceRegistrationUim form,HttpServletRequest request, HttpServletResponse response) throws Exception {
    		request.getSession(true);
    		PrintWriter out = null;
    		EserviceRegistrationDao dao = null;
            String customerIdChecked = "false";
            String userId = null;
            String errorMsg = BLANK;
            String resultFlag = NO;
            
    		System.out.println("Customer code method clled..");
    		String customerCode=	request.getParameter("customerCode");
    		String emailId=	request.getParameter("emailId");
    		dao=getDao();
    		System.out.println("Customer Code "+customerCode);
    		System.out.println("Email Id "+emailId);
    		String results = dao.checkCustomerCodeAvailable(customerCode,emailId);
			
			
			  if(results.equals("mismatch") || results.equals("false")) {
			  form.setCustomerCode(""); }
			 
    		   
    		form.setErrMsg(results);
    		  
				
				  response.setContentType("text/html");
				  response.setHeader("Cache-Control","no-cache"); 
				  out = response.getWriter();
				  out.print(results);
    	
		return null;
	}
    
    public String checkAvailableUserId(HttpServletRequest request, HttpServletResponse response) throws Exception{
        EserviceRegistrationDao dao = null;

        Map resultMap = null;

        PrintWriter out = null;

        String userIdPassed = "false";
        String userIdChecked = "false";
        String userId = null;
        String errorMsg = BLANK;
        String resultFlag = NO;
        try{
            userId = request.getParameter("userId");
            if(userId != null && !BLANK.equals(userId)){
                dao = getDao();
                if(dao != null){
                    resultMap = dao.checkAvailableUserId(userId);
                }
            }
        } catch (IOException io) {
            errorMsg = io.getMessage();
        }finally{
            if(resultMap != null && !resultMap.isEmpty()){
                resultFlag = (String) resultMap.get(EserviceRegistrationDao.P_O_V.FLAG);
                if(resultFlag != null && !BLANK.equals(resultFlag)){
                    if(YES.equals(resultFlag)){
                        errorMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                    }else{
                        errorMsg = BLANK;
                        userIdPassed = "true";
                        userIdChecked = "true";
                    }
                }else{
                    errorMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                }
            }else{
                errorMsg = BLANK;
            }

            request.setAttribute("userIdPassed", userIdPassed);
            request.setAttribute("userIdChecked", userIdChecked);

            response.setContentType("text/html");
            response.setHeader("Cache-Control", "no-cache");

            out = response.getWriter();
            out.print(errorMsg);
            System.out.println("Error Msg = "+errorMsg);
        }
        return null;
    }

    /*Begin @02*/
    private String createCRMCustomerForContractParty(EserviceRegistrationUim form, HttpServletRequest request){
        System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty][Begin]");

        EserviceRegistrationDao             dao                     = null;
        Map<String, String>                 paramsMap               = null;
        Map                                 resultMap               = null;
        String                              crmCode                 = null;
        String                              errorMsg                = null;
        String                              contractPartyFscCode    = null;
        String                              contractPartyType       = null;
        String                              contractPartyName       = null;
        String                              msg                     = null;

        try{
            paramsMap               = new HashMap<String, String>();
            dao                     = getDao();
            contractPartyFscCode    = FormatUtil.nullToBlank(request.getParameter("contractPartyFscCode"));
            contractPartyType       = FormatUtil.nullToBlank(request.getParameter("contractPartyType"));
            contractPartyName       = FormatUtil.nullToBlank(request.getParameter("contractPartyName"));
            msg                     = "created from eService (RR screen).";

            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty] UserLoginId            :: " + form.getUserLoginId());
            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty] contractPartyFscCode   :: " + contractPartyFscCode);
            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty] contractPartyType      :: " + contractPartyType);
            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty] contractPartyName      :: " + contractPartyName);
            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty] msg                    :: " + msg);

            paramsMap.put(EserviceRegistrationDao.P_I_V.COMPANY_NAME, contractPartyName);
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS1    , msg);
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS2    , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS3    , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS4    , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.CITY        , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.STATE       , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.COUNTRY     , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.PHONENO     , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.FAXNO       , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.EMAIL       , BLANK);
            paramsMap.put(EserviceRegistrationDao.P_I_V.USR_ID      , form.getUserLoginId());
            paramsMap.put(EserviceRegistrationDao.P_I_V.FSC         , contractPartyFscCode);
            paramsMap.put(EserviceRegistrationDao.P_I_V.CUST_TYPE   , contractPartyType);

            if(dao != null){
                resultMap = dao.createCRMCustomer(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.CUST_CODE)){
                        crmCode = (String) resultMap.get(EserviceRegistrationDao.P_O_V.CUST_CODE);
                        if(crmCode != null && !BLANK.equals(crmCode)){
                            this.formatUtil.writeMSG("OK::" + crmCode);
                        }else{
                            if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_DESC)){
                                errorMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                            }else{
                                errorMsg = RutMessage.MSG004;
                            }
                        }
                    }else{
                        if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_DESC)){
                            errorMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                        }else{
                            errorMsg = RutMessage.MSG004;
                        }
                    }
                }else{
                    errorMsg = RutMessage.MSG004;
                }
            }

        }catch(Exception e){
            errorMsg = e.getMessage();
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty] errorMsg :: " + errorMsg);
            if(errorMsg!=null){
                this.formatUtil.writeMSG("ERROR::" + errorMsg);
            }
            System.out.println("[EserviceRegistrationSvc][createCRMCustomerForContractParty][End]");
        }
        return null;
    }
    /*End @02*/

    public String createCRMCustomer(EserviceRegistrationUim form, HttpServletRequest request) throws Exception{

        System.out.println("[EserviceRegistrationSvc][createCRMCustomer][Begin]");

        EserviceRegistrationDao             dao                 = null;
        Map<String, String>                 paramsMap           = null;
        Map                                 resultMap           = null;
        EserviceRegistrationUserInfoMod     userInfoMod         = null;
        String                              crmCode             = BLANK;
        String                              errorMsg            = null;
        String                              forwardPage         = FAILURE;

        try{
            userInfoMod = form.getUserInfoMod();
            paramsMap   = new HashMap<String, String>();
            dao         = getDao();

            paramsMap.put(EserviceRegistrationDao.P_I_V.COMPANY_NAME, userInfoMod.getCmpName());
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS1    , userInfoMod.getAddress1());
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS2    , userInfoMod.getAddress2());
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS3    , userInfoMod.getAddress3());
            paramsMap.put(EserviceRegistrationDao.P_I_V.ADDRESS4    , userInfoMod.getAddress4());
            paramsMap.put(EserviceRegistrationDao.P_I_V.CITY        , userInfoMod.getCity());
            paramsMap.put(EserviceRegistrationDao.P_I_V.STATE       , userInfoMod.getState());
            paramsMap.put(EserviceRegistrationDao.P_I_V.COUNTRY     , userInfoMod.getCountry());
            paramsMap.put(EserviceRegistrationDao.P_I_V.PHONENO     , userInfoMod.getPhoneNo());
            paramsMap.put(EserviceRegistrationDao.P_I_V.FAXNO       , userInfoMod.getFaxNo());
            paramsMap.put(EserviceRegistrationDao.P_I_V.EMAIL       , userInfoMod.getEmail());
            paramsMap.put(EserviceRegistrationDao.P_I_V.USR_ID      , form.getUserLoginId());
            paramsMap.put(EserviceRegistrationDao.P_I_V.FSC         , form.getCustomerFscCode());
            paramsMap.put(EserviceRegistrationDao.P_I_V.CUST_TYPE   , form.getCustomerType());

            if(dao != null){
                resultMap = dao.createCRMCustomer(paramsMap);
                if(resultMap != null && !resultMap.isEmpty()){
                    if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.CUST_CODE)){
                        crmCode = (String) resultMap.get(EserviceRegistrationDao.P_O_V.CUST_CODE);
                        if(crmCode != null && !BLANK.equals(crmCode)){
                            forwardPage = SUCCESS;
                        }else{
                            if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_DESC)){
                                errorMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                            }else{
                                errorMsg = RutMessage.MSG004;
                            }
                        }
                    }else{
                        if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_DESC)){
                            errorMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                        }else{
                            errorMsg = RutMessage.MSG004;
                        }
                    }
                }else{
                    errorMsg = RutMessage.MSG004;
                }
            }
        } catch (IOException io) {
            errorMsg = io.getMessage();
        }finally{
            form.setCustomerCode(crmCode);
            if(errorMsg != null && !BLANK.equals(errorMsg)){
                form.setCrmErrorMsg(errorMsg);
            }
            System.out.println("[EserviceRegistrationSvc][createCRMCustomer][End]");
        }
        return forwardPage;
    }

    public String registration(EserviceRegistrationUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceRegistrationSvc][registration][Begin]");

        EserviceRegistrationDao     dao                     = null;
        RegistrationOrclDao         daoOrl					= null;
        UserAccountBean             accountBean             = null;
        Map                         resultMap               = null;
        String                      oldPassword             = null;
//        String loginPassword = null;
        String                      userIdChecked           = null;
        String                      userIdPassed            = null;
        String                      userMode                = null;
        String                      errCode                 = null;
        String                      errMsg                  = null;
        String                      forwardPage             = null;
        boolean                     isOldPwdPass            = true;
        /*Begin @02*/
        String                      representedCompanyFlag  = null;
        String                      portPairFlag            = null;
        /*End @02*/
        
        String                      nonRaAccount            = null; // #05 ADD

        try {
            userMode    = form.getInternalUser();
            dao         = getDao();
            daoOrl		= getDaoOrl();
            form.setErrMsg("");
            /*Begin @02*/
            representedCompanyFlag  = request.getParameter("representedCompanyFlag");
            portPairFlag            = request.getParameter("portPairFlag");
            
            // #05 START
            nonRaAccount = FormatUtil.nullToBlank(request.getParameter("nonRaAccount"));
            if("".equalsIgnoreCase(nonRaAccount) || "false".equalsIgnoreCase(nonRaAccount) || nonRaAccount == null || "N".equalsIgnoreCase(nonRaAccount)){
                nonRaAccount = "N";
            } else {
                nonRaAccount = "Y";
            }
            form.setNonRaAccount(nonRaAccount);
            // #05 END
            //form.setCustomerCode(request.getParameter("customerCode"));
            form.setRepresentedCompanyFlag(representedCompanyFlag);
            form.setPortPairFlag(portPairFlag);
            /*End @02*/

            if(EserviceRegistrationDao.USER_MODE.INTERNAL.equals(userMode)||EserviceRegistrationDao.USER_MODE.EXTERNAL.equals(userMode)){
                userIdChecked = request.getParameter("userIdChecked");
                if(userIdChecked == null || BLANK.equals(userIdChecked)){
                    userIdChecked = "false";
                }
                userIdPassed = request.getParameter("userIdPassed");
                if(userIdPassed == null || BLANK.equals(userIdPassed)){
                    userIdPassed = "false";
                }
                request.setAttribute("userIdChecked", userIdChecked);
                request.setAttribute("userIdPassed", userIdPassed);

                //errMsg = validateCaptcha(request, form);P' Nim tel remove capcha 20140429 By Pound
                if (errMsg == null) {
                    resultMap = insertRegistration(form, dao,daoOrl);
                }else{
                    resultMap = new HashMap<String, String>();
                    resultMap.put(EserviceRegistrationDao.P_O_V.ERR_CD, "EXCEPTION");
                    resultMap.put(EserviceRegistrationDao.P_O_V.ERR_DESC, errMsg);
                }
            }else if(EserviceRegistrationDao.USER_MODE.INTERNAL.equals(userMode)){
                resultMap = updateRegistrationReview(form, dao);
            }else if(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES.equals(userMode)){
                accountBean = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
                if(form.getOldPassword() != null && !BLANK.equals(form.getOldPassword().trim())){
                    oldPassword = EncryptDecryptUtil.convertStringToHex(form.getOldPassword());
                    if(!accountBean.getPassword().equals(oldPassword)){
                        resultMap = new HashMap<String, String>();
                        resultMap.put(EserviceRegistrationDao.P_O_V.ERR_CD, "EXCEPTION");
                        resultMap.put(EserviceRegistrationDao.P_O_V.ERR_DESC, "Old password incorrect.");

                        isOldPwdPass = false;
                    }
                }
                if(isOldPwdPass){
                    resultMap = updateRegistration(form, dao);
                }
            }
//            resultMap = new HashMap();
            if(resultMap != null){
                if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_CD)){
                    errCode = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_CD);
                    if(errCode != null && !BLANK.equals(errCode)){
                        errMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                    }
                }
            }else{
                errMsg = "Process fail.";
            }
        } catch (Exception ex) {
            errMsg = "Process fail.";
            ex.printStackTrace();
        } finally {
            if(errMsg != null && !BLANK.equals(errMsg)){
                form.setSubmitSuccess("false");
                forwardPage = FAILURE;
            }else{
                form.setSubmitSuccess("true");
                sendingMailProcess(form,dao);
                forwardPage = SUCCESS;
            }
            form.setErrMsg(errMsg);
            if(form.getCountryList() == null || form.getCountryList().isEmpty() || form.getCountryList().size() == 1){
                form.setCountryList((List<ComboVO>) request.getSession().getAttribute(COUNTRY_LIST));
            }
            System.out.println("[EserviceRegistrationSvc][registration][End]");
        }
        return forwardPage;
    }

    private void sendingMailProcess(EserviceRegistrationUim form,EserviceRegistrationDao dao) {
    	System.out.println("sending Mail method callled ............ ");
    	  try {
	          	System.out.println("RegistrationThread class object create...");
	          	String allSFUCodeChecked   =  requestedEServices(form);
	          	dao.getPicMailId(form);
	          	String representedCompany="";
		          	if(form.getUserInfoMod().getCustomerCode()!= null 
		          			&& !form.getUserInfoMod().getCustomerCode().equals("")) {
		          		representedCompany=dao.getRrepresentedCompany(form.getUserInfoMod().getCustomerCode());
		          	}
	          	RegistrationThread th = new RegistrationThread(form,allSFUCodeChecked,representedCompany);
				th.start();
			}catch (Exception e) { 
				e.printStackTrace(); 
			}
	}

	public String rejectReason(EserviceRegistrationUim form, HttpServletRequest request) throws Exception {
        System.out.println("Begin EserviceRegistrationSvc.rejectReason");

        EserviceRegistrationDao             dao                     = null;
        Map                                 resultMap               = null;
        String                              userMode                = null;
        String                              errCode                 = null;
        String                              errMsg                  = null;
        String                              forwardPage             = null;
        EserviceRegistrationUserInfoMod     userInfoMod             = null;
        Map<String, String>                 mapParams               = null;
        String                              allSFUCodeChecked       = null;
        String                              rejectReason            = null;
        String                              nonRaAccount            = null; // #05 ADD

        try {

            userMode            = form.getInternalUser();
            dao                 = getDao();
            allSFUCodeChecked   = getAllSFUCodeChecked(form);
            userInfoMod         = form.getUserInfoMod();
            mapParams           = new HashMap<String, String>();
            rejectReason        = request.getParameter("rejectReason");
            
            // #05 START
            nonRaAccount = FormatUtil.nullToBlank(request.getParameter("nonRaAccount"));
            if("".equalsIgnoreCase(nonRaAccount) || "false".equalsIgnoreCase(nonRaAccount) || nonRaAccount == null || "N".equalsIgnoreCase(nonRaAccount)){
                nonRaAccount = "N";
            } else {
                nonRaAccount = "Y";
            }
            form.setNonRaAccount(nonRaAccount);
            // #05 END

            System.out.println("USR_ID :: " + userInfoMod.getUserId());
            System.out.println("SFU :: " + allSFUCodeChecked);
            System.out.println("ORG_CODE :: " + form.getCustomerCode());
            System.out.println("FSC :: " + form.getCustomerFscCode());
            System.out.println("EMAIL :: " + userInfoMod.getEmail());
            System.out.println("REJECT_REASON :: " + rejectReason);
            System.out.println("NON_RA_ACCOUNT :: " + nonRaAccount);    // #05 ADD

            mapParams.put(EserviceRegistrationDao.P_I_V.USR_ID, userInfoMod.getUserId());
            mapParams.put(EserviceRegistrationDao.P_I_V.SFU, allSFUCodeChecked);
            mapParams.put(EserviceRegistrationDao.P_I_V.ORG_CODE, form.getCustomerCode());
            mapParams.put(EserviceRegistrationDao.P_I_V.FSC, form.getCustomerFscCode());
            mapParams.put(EserviceRegistrationDao.P_I_V.EMAIL, userInfoMod.getEmail());
            mapParams.put(EserviceRegistrationDao.P_I_V.REJECT_REASON, rejectReason);
            mapParams.put(EserviceRegistrationDao.P_I_V.USR_LOGIN, form.getUserLoginId());
            
            mapParams.put(EserviceRegistrationDao.P_I_V.NON_RA, nonRaAccount); // #05 ADD

            resultMap = dao.updateRejectReason(mapParams);

            if(resultMap != null){
                if(resultMap.containsKey(EserviceRegistrationDao.P_O_V.ERR_CD)){
                    errCode = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_CD);
                    if(errCode != null && !BLANK.equals(errCode)){
                        errMsg = (String) resultMap.get(EserviceRegistrationDao.P_O_V.ERR_DESC);
                    }
                }
            }else{
                errMsg = "Process fail.";
            }
        } catch (Exception ex) {
            errMsg = ex.toString();
            ex.printStackTrace();
        } finally {
            if(errMsg != null && !BLANK.equals(errMsg)){
                form.setSubmitSuccess("false");

                forwardPage = FAILURE;
            }else{
                form.setSubmitSuccess("true");

                forwardPage = SUCCESS;
            }
            form.setErrMsg(errMsg);
            if(form.getCountryList() == null || form.getCountryList().isEmpty() || form.getCountryList().size() == 1){
                form.setCountryList((List<ComboVO>) request.getSession().getAttribute(COUNTRY_LIST));
            }
            System.out.println("End EserviceRegistrationSvc.rejectReason");
        }
        return forwardPage;
    }

    private Map insertRegistration(EserviceRegistrationUim form, EserviceRegistrationDao dao,RegistrationOrclDao daoOrl) throws Exception{

        System.out.println("[EserviceRegistrationSvc][insertRegistration][Begin]");

        EserviceRegistrationUserInfoMod userInfoMod             = null;
        Map                             resultMap               = null;
        Map<String, String>             mapParams               = null;
        String                          allSFUCodeChecked       = null;
        String                          passwordEncrypted       = null;

        try{
            allSFUCodeChecked   = getAllSFUCodeChecked(form);
            passwordEncrypted   = EncryptDecryptUtil.convertStringToHex(form.getPassword());
            userInfoMod         = form.getUserInfoMod();
            mapParams           = new HashMap<String, String>();

            mapParams.put(EserviceRegistrationDao.P_I_V.FIRST_NAME      , form.getFirstName().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.LAST_NAME       , form.getLastName().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.EMAIL           , userInfoMod.getEmail().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.USR_ID          , userInfoMod.getUserId().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.PASSWORD        , passwordEncrypted);					 //form.getPassword().trim());              
            mapParams.put(EserviceRegistrationDao.P_I_V.CMP_NAME        , userInfoMod.getCmpName().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CUST_CODE       , userInfoMod.getCustomerCode().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS1        , userInfoMod.getAddress1().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS2        , userInfoMod.getAddress2().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS3        , userInfoMod.getAddress3().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS4        , userInfoMod.getAddress4().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CITY            , userInfoMod.getCity().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.STATE           , userInfoMod.getState().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.COUNTRY         , userInfoMod.getCountry().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.PHONENO         , userInfoMod.getPhoneNo().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.FAXNO           , userInfoMod.getFaxNo().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.SFU             , allSFUCodeChecked);
            mapParams.put(EserviceRegistrationDao.P_I_V.P_ORG_CODE             , form.getCustomerCode());
            
            resultMap = dao.insertRegistration(mapParams, form ,daoOrl);
            
            
            
        }catch(Exception ex){
            throw ex;
        }finally{
            System.out.println("[EserviceRegistrationSvc][insertRegistration][End]");
        }
        return resultMap;
    }

    private Map updateRegistrationReview(EserviceRegistrationUim form, EserviceRegistrationDao dao) throws Exception{

        System.out.println("[EserviceRegistrationSvc][updateRegistrationReview][Begin]");

        EserviceRegistrationUserInfoMod         userInfoMod                     = null;
        Map                                     resultMap                       = null;
        Map<String, String>                     mapParams                       = null;
        String                                  allSFUCodeChecked               = null;
        /*Begin @01*/
        String                                  representedCompanyFlag          = null;
        String                                  portPairFlag                    = null;
        String                                  errorMsg                        = null;
        EserviceContractPartyPortPairMod        mod                             = null;
        List<EserviceContractPartyPortPairMod>  contractPartyList               = null;
        /*End @01*/

        try{
            allSFUCodeChecked           = getAllSFUCodeChecked(form);
            userInfoMod                 = form.getUserInfoMod();
            mapParams                   = new HashMap<String, String>();
            /*Begin @01*/
            representedCompanyFlag      = form.getRepresentedCompanyFlag();
            portPairFlag                = form.getPortPairFlag();
            /*End @01*/
            
            

            if(portPairFlag.equals("N")){
                mapParams.put(EserviceRegistrationDao.P_I_V.USR_ID      , userInfoMod.getUserId().trim());
                mapParams.put(EserviceRegistrationDao.P_I_V.SFU         , allSFUCodeChecked);
                mapParams.put(EserviceRegistrationDao.P_I_V.ORG_CODE    , form.getCustomerCode());
                mapParams.put(EserviceRegistrationDao.P_I_V.FSC         , form.getCustomerFscCode());
                mapParams.put(EserviceRegistrationDao.P_I_V.EMAIL       , userInfoMod.getEmail());
                mapParams.put(EserviceRegistrationDao.P_I_V.USR_LOGIN       , form.getUserLoginId());
                mapParams.put(EserviceRegistrationDao.P_I_V.NON_RA       , form.getNonRaAccount()); // #05 ADD

                resultMap = dao.updateRegistrationReview(mapParams, form);
            }else{
                if(representedCompanyFlag.equals("Y")){
                    //##04 Begin
                    // contractPartyList = form.getContractPartyList();
                    // if(contractPartyList!=null){
                    //     for(int i=0;i<contractPartyList.size();i++){
                    //         mod = contractPartyList.get(i);
                    //         if(mod.getRecStatus().equals("P")){
                    //             mod.setUserId(form.getUserLoginId());
                    //             mod.setRecStatus(EserviceRegistrationDao.ACTIVE);
                    //             mod.setFlagPortPair(EserviceRegistrationDao.USER_MODE.INTERNAL);
                    //
                    //             if(mod.getApproveFlag().equals("Y")){
                    //                 errorMsg = dao.updContractPartyPortPair(mod);
                    //             }else{
                    //                 errorMsg = dao.delContractPartyPortPair(mod);
                    //             }
                    //             if(errorMsg!=null) break;
                    //         }
                    //     }
                    // }
                    // mapParams.put(EserviceRegistrationDao.P_I_V.USR_ID      , userInfoMod.getUserId().trim());
                    // mapParams.put(EserviceRegistrationDao.P_I_V.EMAIL       , userInfoMod.getEmail().trim());
                    //
                    // resultMap = dao.sendEnoticeForContractPartyPortPair(mapParams);
                    //##04 End
                }
                System.out.println("[EserviceRegistrationSvc][updateRegistrationReview] errorMsg :: " + errorMsg);
                resultMap = new HashMap();
                if(errorMsg != null && !BLANK.equals(errorMsg)){
                    resultMap.put(EserviceRegistrationDao.P_O_V.ERR_CD  , errorMsg);
                    resultMap.put(EserviceRegistrationDao.P_O_V.ERR_DESC, errorMsg);
                }
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            System.out.println("[EserviceRegistrationSvc][updateRegistrationReview][End]");
        }
        return resultMap;
    }

    private Map updateRegistration(EserviceRegistrationUim form, EserviceRegistrationDao dao) throws Exception{

        System.out.println("[EserviceRegistrationSvc][updateRegistration][Begin]");

        EserviceRegistrationUserInfoMod     userInfoMod             = null;
        Map                                 resultMap               = null;
        Map<String, String>                 mapParams               = null;
        String                              allSFUCodeChecked       = null;
        String                              passwordEncrypted       = null;

        try{
            allSFUCodeChecked   = getAllSFUCodeChecked(form);
            passwordEncrypted   = EncryptDecryptUtil.convertStringToHex(form.getPassword());
            userInfoMod         = form.getUserInfoMod();
            mapParams           = new HashMap<String, String>();

            mapParams.put(EserviceRegistrationDao.P_I_V.USR_ID      , userInfoMod.getUserId().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CUST_NAME   , userInfoMod.getUserName().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.EMAIL       , userInfoMod.getEmail().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CMP_NAME    , userInfoMod.getCmpName().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS1    , userInfoMod.getAddress1().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS2    , userInfoMod.getAddress2().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS3    , userInfoMod.getAddress3().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS4    , userInfoMod.getAddress4().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CITY        , userInfoMod.getCity().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.STATE       , userInfoMod.getState().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.COUNTRY     , userInfoMod.getCountry().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.PHONENO     , userInfoMod.getPhoneNo().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.FAXNO       , userInfoMod.getFaxNo().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.NEW_PWD     , passwordEncrypted);
//            mapParams.put(EserviceRegistrationDao.P_I_V.SFU         , allSFUCodeChecked + ",NUT_ROLE,BASIS"); //For test only !!
            mapParams.put(EserviceRegistrationDao.P_I_V.SFU         , allSFUCodeChecked);

            resultMap = dao.updateRegistration(mapParams, form);
        }catch(Exception ex){
            throw ex;
        }finally{
            System.out.println("[EserviceRegistrationSvc][updateRegistration][End]");
        }
        return resultMap;
    }

    private String validateCaptcha(HttpServletRequest request, EserviceRegistrationUim form) throws Exception {
        Boolean isResponseCorrect =Boolean.FALSE;
       //remenber that we need an id to validate!
       String captchaId = null;
       //retrieve the response
       String response = null;
       String errorMsg = null;
        try{
            captchaId = request.getSession().getId();
            response = request.getParameter("captcha");
            isResponseCorrect = CaptchaServiceSingleton.getInstance().validateResponseForID(captchaId, response);
            if(isResponseCorrect != null && !isResponseCorrect.booleanValue()){
                errorMsg = "Characters not matched.";
            }
        }catch (CaptchaServiceException ex) {
            errorMsg = ex.getMessage();
        }
        return errorMsg;
    }

    private String getAllSFUCodeChecked(EserviceRegistrationUim form) throws Exception{
        List<EserviceRegistrationUserServiceMod> serviceList = null;
        EserviceRegistrationUserServiceMod serviceMod = null;

        String[] sfuIndexArr = null;

        String allSFUIndexChecked = null;
        String allSFUCodeChecked = null;

        int sfuIndexArrLength = 0;
        try{
            allSFUIndexChecked = form.getAllSFUChecked();
            if(allSFUIndexChecked != null && !BLANK.equals(allSFUIndexChecked)){
                sfuIndexArr = allSFUIndexChecked.split(",");
                if(sfuIndexArr != null && sfuIndexArr.length > 0){
                    sfuIndexArrLength = sfuIndexArr.length;

                    serviceList = form.getUserServiceModList();
                    if(serviceList != null && !serviceList.isEmpty()){
                        for(int countIndex=0; countIndex<sfuIndexArrLength; countIndex++){
                            serviceMod = serviceList.get(Integer.parseInt(sfuIndexArr[countIndex]));
                            if(allSFUCodeChecked == null){
                                allSFUCodeChecked = serviceMod.getSfu();
                            }else{
                                allSFUCodeChecked += ","+serviceMod.getSfu();
                            }
                        }
                    }
                }
            }
        }catch(Exception ex){
            throw ex;
        }
        return allSFUCodeChecked;
    }

    public String generateCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ByteArrayOutputStream jpegOutputStream = null;
        ServletOutputStream responseOutputStream = null;

        BufferedImage challenge = null;

        JPEGImageEncoder jpegEncoder = null;

        byte[] captchaChallengeAsJpeg = null;

        String errMsg = null;
        String captchaId = null;
        String forwardPage = FAILURE;
        try{
            // the output stream to render the captcha image as jpeg into
            jpegOutputStream = new ByteArrayOutputStream();
             // get the session id that will identify the generated captcha.
             //the same id must be used to validate the response, the session id is a good candidate!
            captchaId = request.getSession().getId();
             // call the ImageCaptchaService getChallenge method
            challenge = CaptchaServiceSingleton.getInstance().getImageChallengeForID(captchaId, request.getLocale());

            // a jpeg encoder
            jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
            jpegEncoder.encode(challenge);

            captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

            // flush it in the response
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            responseOutputStream = response.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();

//            forwardPage = SUCCESS;
        } catch (IllegalArgumentException ex) {
            errMsg = ex.getMessage();
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (CaptchaServiceException ex) {
            errMsg = ex.getMessage();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return forwardPage;
    }

    /*Begin @02*/
    private String lp_addContractPartyCompany(EserviceRegistrationUim form, HttpServletRequest request){
        System.out.println("[EserviceRegistrationSvc][lp_addContractPartyCompany][Begin]");

        List <EserviceContractPartyPortPairMod>         contractPartyList       = null;
        EserviceContractPartyPortPairMod                contractPartyMod        = null;
        String                                          maxPkPortPairSeq        = null;

        try{
            contractPartyList   = form.getContractPartyList();
            contractPartyMod    = new EserviceContractPartyPortPairMod();
            maxPkPortPairSeq    = FormatUtil.nullToBlank(request.getParameter("maxPkPortPairSeq"));

            System.out.println("[EserviceRegistrationSvc][lp_addContractPartyCompany] maxPkPortPairSeq :: " + maxPkPortPairSeq);

            contractPartyMod.setPkPortPairSeq(maxPkPortPairSeq);
            contractPartyMod.setStatusFlag(EserviceRegistrationDao.ADD);

            contractPartyList.add(contractPartyMod);
            form.setMaxPkPortPairSeq(maxPkPortPairSeq);

            if(form.getInternalUser()!=null && form.getInternalUser().equals(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES)){
                form.setRecStatus("New");
            }

            this.formatUtil.writeMSG("OK");
        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceRegistrationSvc][lp_addContractPartyCompany][End]");
        }

        return null;
    }
    /*End @02*/

     /*Begin @02*/
     private String lp_updContractCompany(EserviceRegistrationUim form, HttpServletRequest request){
         System.out.println("[EserviceRegistrationSvc][lp_updContractCompany][Begin]");

         List <EserviceContractPartyPortPairMod>         contractPartyList       = null;
         EserviceContractPartyPortPairMod                contractPartyMod        = null;
         String                                          pkPortPairSeq           = null;
         String                                          fkContractPartyCode     = null;
         String                                          contractPartyName       = null;
         String                                          approveFlag             = null;
         String                                          contractPartyFscCode    = null;
         String                                          contractPartyType       = null;

         try{
             contractPartyList      = form.getContractPartyList();
             contractPartyMod       = new EserviceContractPartyPortPairMod();
             pkPortPairSeq          = FormatUtil.nullToBlank(request.getParameter("pkPortPairSeq"));
             fkContractPartyCode    = FormatUtil.nullToBlank(request.getParameter("fkContractPartyCode"));
             contractPartyName      = FormatUtil.nullToBlank(request.getParameter("contractPartyName"));
             approveFlag            = FormatUtil.nullToBlank(request.getParameter("approveFlag"));
             contractPartyFscCode   = FormatUtil.nullToBlank(request.getParameter("contractPartyFscCode"));
             contractPartyType      = FormatUtil.nullToBlank(request.getParameter("contractPartyType"));

             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany] pkPortPairSeq         :: " + pkPortPairSeq);
             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany] fkContractPartyCode   :: " + fkContractPartyCode);
             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany] contractPartyName     :: " + contractPartyName);
             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany] approveFlag           :: " + approveFlag);
             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany] contractPartyFscCode  :: " + contractPartyFscCode);
             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany] contractPartyType     :: " + contractPartyType);

             for(int i=0;i<contractPartyList.size();i++){
                 contractPartyMod = contractPartyList.get(i);

                 if(contractPartyMod.getPkPortPairSeq().equals(pkPortPairSeq)){
                     contractPartyMod.setFkContractPartyCode(fkContractPartyCode);
                     contractPartyMod.setContractPartyName(contractPartyName);
                     contractPartyMod.setContractPartyNameDisabled(contractPartyName);
                     contractPartyMod.setApproveFlag(approveFlag);
                     contractPartyMod.setContractPartyFscCode(contractPartyFscCode);
                     contractPartyMod.setContractPartyType(contractPartyType);
                     if(!contractPartyMod.getStatusFlag().equals(EserviceRegistrationDao.ADD))contractPartyMod.setStatusFlag(EserviceRegistrationDao.UPD);

                     break;
                 }
             }

             this.formatUtil.writeMSG("OK");
         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceRegistrationSvc][lp_updContractCompany][End]");
         }

         return null;
     }
     /*End @02*/

     /*Begin @02*/
     private String lp_delContractCompany(EserviceRegistrationUim form, HttpServletRequest request){
         System.out.println("[EserviceRegistrationSvc][lp_delContractCompany][Begin]");

         List <EserviceContractPartyPortPairMod>         contractPartyList       = null;
         EserviceContractPartyPortPairMod                contractPartyMod        = null;
         String                                          pkPortPairSeq           = null;

         try{
             contractPartyList   = form.getContractPartyList();
             pkPortPairSeq       = FormatUtil.nullToBlank(request.getParameter("pkPortPairSeq"));

             System.out.println("[EserviceRegistrationSvc][lp_delContractCompany] pkPortPairSeq :: " + pkPortPairSeq);

             for(int i=0;i<contractPartyList.size();i++){
                 contractPartyMod = contractPartyList.get(i);

                 if(contractPartyMod.getPkPortPairSeq().equals(pkPortPairSeq)){
                     if(contractPartyMod.getStatusFlag().equals(EserviceRegistrationDao.ADD)){
                         contractPartyList.remove(i);
                     }else{
                         contractPartyMod.setStatusFlag(EserviceRegistrationDao.DEL);
                     }
                     break;
                 }
             }

             this.formatUtil.writeMSG("OK");
         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceRegistrationSvc][lp_delContractCompany][End]");
         }

         return null;
     }
     /*End @02*/

    private EserviceRegistrationUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EserviceRegistrationUim form = null;
        try {
            form = (EserviceRegistrationUim)actionForm;
            if (form == null){
                form = new EserviceRegistrationUim();
            }else if("onload".equals(pageAction) || "manageAccount".equals(pageAction)){
                form.resetForm();
            }
        } catch (Exception ex) {
            throw ex;
        }

        return form;
    }

    private String getPageAction(ActionMapping mapping) throws Exception {
        String pageAction = null;
        try {
            pageAction = mapping.getParameter();
        } catch (Exception ex) {
            pageAction = "";
        }

        return pageAction;
    }

    private EserviceRegistrationDao getDao() throws Exception {
        EserviceRegistrationDao dao = null;
        try {
            dao = (EserviceRegistrationDao)getDao(EserviceRegistrationDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }

    private RegistrationOrclDao getDaoOrl() throws Exception {
    	RegistrationOrclDao dao = null;
        try {
            dao = (RegistrationOrclDao)getDao("RegistrationOrclDao");
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }
    
    //##03 Begin
    /**
     * activateRepresentedCompany : This function activate Represented Company with password input by user.
     * @param form
     * @param request
     * @return password checking status
     */
    private String activateRepresentedCompany(EserviceRegistrationUim form, HttpServletRequest request) {
        System.out.println("[EserviceRegistrationSvc][activateRepresentedCompany][Begin]");

        
        String                                  responseMsg             = null;
        String                                  inputReactPwd           = null;
        String                                  inputPkEsvPpHdrSeq      = null;
        String                                  encryptedReactPwd       = null;
        String 									userId					= null;
        List <EserviceContractPartyPortPairMod> contractPartyList       = null;
        EserviceContractPartyPortPairMod        contractPartyMod        = null;
        EserviceRegistrationDao                 eserviceRegistrationDao = null;
        HttpSession session = request.getSession(true);
        UserAccountBean
        account=(UserAccountBean)session.getAttribute(GlobalConstants.
        		USER_ACCOUNT_BEAN); 
        try{
            inputPkEsvPpHdrSeq      = request.getParameter("pkEsvPpHdrSeq");
            inputReactPwd           = request.getParameter("reactPwd");
            userId					= account.get_userId();
            contractPartyList       = (List<EserviceContractPartyPortPairMod>) session.getAttribute("contractPartyList"); 
            eserviceRegistrationDao = this.getDao();

            System.out.println("[EserviceRegistrationSvc][activateRepresentedCompany] inputPkEsvPpHdrSeq  :: "+inputPkEsvPpHdrSeq);
            System.out.println("[EserviceRegistrationSvc][activateRepresentedCompany] inputReactPwd       :: "+inputReactPwd);

            for(int i = 0 ; i < contractPartyList.size() ; i++){
                contractPartyMod  = contractPartyList.get(i);
                if(inputPkEsvPpHdrSeq != null && inputPkEsvPpHdrSeq.equals(contractPartyMod.getPkEsvPpHdrSeq())){

                    System.out.println("[EserviceRegistrationSvc][activateRepresentedCompany] "+contractPartyMod.getPkEsvPpHdrSeq() +":"+contractPartyMod.getPwd());
                    if(inputReactPwd.equals(contractPartyMod.getPwd())){
                        contractPartyMod.setReactPwd(inputReactPwd);
                        contractPartyMod.setUserId(userId);

                        responseMsg = eserviceRegistrationDao.activateRepresentedCompany(contractPartyMod);
                        // responseMsg = "OK";
                    } else {
                        responseMsg = "MISMATCH";
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            responseMsg = e.getMessage();
        } finally {
            System.out.println("[EserviceRegistrationSvc][activateRepresentedCompany][End]");
        }
        System.out.println("responseMsg = "+responseMsg);
        this.formatUtil.writeMSG(responseMsg);

        return null;
    }
    //##03 End

    //##04 Begin
    public String filterContractPartyCompany(EserviceRegistrationUim form, HttpServletRequest request) throws Exception {
        System.out.println("[EserviceRegistrationSvc][filterContractPartyCompany][Begin]");

        String excludeExpire = null;
        String forwardPage   = null;

        try{
            // form.resetForm();
            // form.setInternalUser(EserviceRegistrationDao.USER_MODE.INTERNAL_MRES);
            excludeExpire = FormatUtil.nullToBlank(request.getParameter("excludeExpire"));

            System.out.println("[EserviceRegistrationSvc][filterContractPartyCompany] excludeExpire :: " + excludeExpire);

            if("".equals(excludeExpire)){
                excludeExpire = "N";
            }
            form.setExcludeExpireContractParty(excludeExpire);

            List<EserviceContractPartyPortPairMod> activeList = new ArrayList<EserviceContractPartyPortPairMod>();
            List<EserviceContractPartyPortPairMod> expiredList = new ArrayList<EserviceContractPartyPortPairMod>();

            for(EserviceContractPartyPortPairMod mod : form.getContractPartyList()){
                if(mod.getContractPartyStatus().equals("ACTIVE")){
                    activeList.add(mod);
                } else {
                    expiredList.add(mod);
                }
            }

            String responseJson = "";
            if("Y".equals(excludeExpire)){
                responseJson = parseRepresentedCompToJSON(activeList);
            } else if("N".equals(excludeExpire)){
                activeList.addAll(expiredList);
                responseJson = parseRepresentedCompToJSON(activeList);
            }

            this.formatUtil.writeMSG(responseJson);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally{
            System.out.println("[EserviceRegistrationSvc][filterContractPartyCompany][End]");
        }
        return forwardPage;
    }
    //##04 End

    private String parseRepresentedCompToJSON(List<EserviceContractPartyPortPairMod> eserviceContractPartyPortPairModList){
        String responseJson = "{\"status\":\"OK\"";
        responseJson += ",\"resultList\":[";

        String listJson = "";
        for(EserviceContractPartyPortPairMod mod : eserviceContractPartyPortPairModList){
            if(!"".equals(listJson)){
                listJson += ", ";
            }
            listJson += "{"
                      + "\"fkContractPartyCode\" : \"" + mod.getFkContractPartyCode() +"\""
                      + ", \"pkEsvPpHdrSeq\" : \"" + mod.getPkEsvPpHdrSeq() +"\""
                      + ", \"statusFlag\" : \"" + mod.getStatusFlag() +"\""
                      + ", \"recStatus\" : \"" + mod.getRecStatus() +"\""
                      + ", \"approveFlag\" : \"" + mod.getApproveFlag() +"\""
                      + ", \"contractPartyFscCode\" : \"" + mod.getContractPartyFscCode() +"\""
                      + ", \"contractPartyType\" : \"" + mod.getContractPartyType() +"\""
                      + ", \"contractPartyName\" : \"" + mod.getContractPartyName() +"\""
                      + ", \"contractPartyStatus\" : \"" + mod.getContractPartyStatus() +"\""
                      + ", \"reactPwd\" : \"" + mod.getReactPwd() +"\""
                      + ", \"isActivate\" : " + "".equals(mod.getReactPwd())
                      + "}";
        }
        responseJson += listJson;
        responseJson += "]}";
        return responseJson;
    }
    
    public String login(HttpServletRequest request) throws Exception {
		System.out.println("[++++++++++++++++++++++++++++++++++++++ login +++++++++++++++++++++++++++++++]");
		String forwardPage = null;
		// request.getSession().setAttribute( Globals.LOCALE_KEY, Locale.FRANCE);
		forwardPage = SUCCESS;
		return forwardPage;
	}  //

	public String openWebBooking(HttpServletRequest request,HttpServletResponse response,EserviceRegistrationUim form,ActionForm actionForm) throws Exception {
		System.out.println("[++++++++++++++++++++++++++++++++++++++ openWebBooking +++++++++++++++++++++++++++++++]");
		String forwardPage = null;
		EserviceRegistrationDao dao         = getDao();
		form.setContryList(dao.getCountryCodeNameList());  
		forwardPage = SUCCESS;
		return forwardPage;
	}
	public String getPolpod(HttpServletRequest request,HttpServletResponse response,EserviceRegistrationUim form,ActionForm actionForm) throws Exception {
		System.out.println("[++++++++++++++++++++++++++++++++++++++ openWebBooking +++++++++++++++++++++++++++++++]");
		String forwardPage = null;
		EserviceRegistrationUim formObj 	= (EserviceRegistrationUim) actionForm;
		EserviceRegistrationDao dao         = getDao();
		
		List<PolPod> code= dao.getCodeForPolPod(form);
		
		//formObj.setContryList(code);
		
		net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
		jsonObj = new net.sf.json.JSONObject();
		jsonObj.put("polPod", code);
		response.setContentType("application/json");
		jsonObj.write(response.getWriter());
		forwardPage = SUCCESS;
		return null;
	}
	
	public String requestedEServices(EserviceRegistrationUim form) {
		String sfuTemp = "";
		if(form.getAllSFUChecked()!=null || !form.getAllSFUChecked().equals("")) {
			String sfu[]= form.getAllSFUChecked().split(",");
			for(int i=0;i<sfu.length;i++) {
				if(sfu[i].equals("0")) {
					if(!sfuTemp.equals(""))  
					    sfuTemp=sfuTemp+"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: Verified Gross Mass";
					 else  
					    sfuTemp=sfuTemp+"Verified Gross Mass";
				}else if(sfu[i].equals("1")){
					if(!sfuTemp.equals(""))  
						sfuTemp=sfuTemp+"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : Rate Inquiry";
					 else  
						 sfuTemp=sfuTemp+"Rate Inquiry";
				}else if(sfu[i].equals("2")){
					if(!sfuTemp.equals(""))  
						 sfuTemp=sfuTemp+"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: Web Booking + eShipping Instruction";
					 else  
						 sfuTemp=sfuTemp+"Web Booking + eShipping Instruction";
				}
			}
		}else {
			sfuTemp="Verified Gross Mass";  // if null we add Verified Gross Mass
		}
		
		return sfuTemp;
	}
	
}

package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.ComboVO;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.LoginDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.RegistrationOrclDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.UserProfileDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserInfoMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.UserMod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;
import com.rclgroup.dolphin.rcl.web.util.WebUtils;

public class UserProfileSvc extends BaseAction {

	String forwardPage = null;
	private HttpServletRequest request;
	private FormatUtil formatUtil = null;
	private static final String UPDATEUSER = "updateUserProfile";
	private static final String RESETPASSWORD = "passwordReset";
	private static final String UPDATEPASSWORD="updatePasswordReset";
	
	private String getForwardPage(ActionMapping mapping, ActionForm actionForm, UserMod form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageAction = null;
		try {
			pageAction = form.getCurrPageAction();
			this.request = request;
			this.formatUtil = new FormatUtil(request, response);
			if (UPDATEUSER.equals(pageAction)) {
				forwardPage = updateUser(form, request);
			}else if(RESETPASSWORD.equals(pageAction)) {
				forwardPage = getUserPassword(form, request);
			}else if(UPDATEPASSWORD.equals(pageAction)) {
				forwardPage = updateUserPassword(form, request);
			} else {
				forwardPage = getUser(form, request);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return forwardPage;
	}

	public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String pageAction = null;
		String errorMsg = null;
		UserMod form = null;
		try {
			pageAction = getPageAction(mapping);

			form = getForm(actionForm);
			form.setCurrPageAction(pageAction);
			forwardPage = getForwardPage(mapping, actionForm, form, request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
			errorMsg = ex.getMessage();
			// form.setErrMsg(errorMsg);

			forwardPage = FAILURE;
		}

		return mapping.findForward(forwardPage);
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

	private String getUserPassword(UserMod form, HttpServletRequest request2) {

		UserProfileDao dao = null;
		dao = (UserProfileDao) getDao(UserProfileDao.DAO_NAME);
		String user =  WebUtils.getUserNew(request).getUserId();
		UserMod userMod = (UserMod) dao.getUserForUserProfile(user);

		if (userMod != null) {
			forwardPage = SUCCESS;
			
			form.setErrorMessage(""); 
			form.setUserId(userMod.getUserId());
			
		} else
			forwardPage = FAILURE;

		return forwardPage;
	}

	private String updateUserPassword(UserMod form, HttpServletRequest request2) {
		 
		String forwardPage = null;
		UserProfileDao dao = null;
		LoginDao daoObj = null;
		// UserMod form = null;
		 
			try {
				form = getForm(form);
				dao = (UserProfileDao) getDao(UserProfileDao.DAO_NAME);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				 dao.updateUserForUserPassword(form);
				 daoObj= (LoginDao) getDao(LoginDao.DAO_NAME);
				 String userId = form.getUserId();
				 String pwd = form.getPassword();
					UserAccountBean userAcc = daoObj.getUser(userId, pwd,form);
					request.getSession(false).setAttribute(USER_ACCOUNT_BEAN, null);
					request.getSession(false).setAttribute(USER_ACCOUNT_BEAN, userAcc);
				}catch (Exception e) {
					e.printStackTrace();
				}
		
		return SUCCESS;
	}
	
	private String getUser(UserMod form, HttpServletRequest request) throws Exception {
		String forwardPage 						 = null;
		UserProfileDao dao 						 = null;
		List<ComboVO>    countryList             = null;
		List<EserviceRegistrationUserServiceMod>        userServiceModList      = null;
		// UserMod form = null;
		try {
			form = getForm(form);
			dao = (UserProfileDao) getDao(UserProfileDao.DAO_NAME);
		} catch (Exception ex) {
			throw ex;
		}
		String user = WebUtils.getUserNew(request).getUserId();
		// UserAccountBeanNew user = WebUtils.getUserNew(request);
        
		UserMod userMod = (UserMod) dao.getUserForUserProfile(user);
		countryList = dao.getCountryList(user);
		request.setAttribute("countryList", countryList);
		System.out.println(userMod.toString());
		
		if (userMod != null) {
			forwardPage = SUCCESS;

			form.setUserId(userMod.getUserId());
			form.setPassword(userMod.getPassword());
			form.setFirstName(userMod.getFirstName());
			form.setLastName(userMod.getLastName());
			form.setCompanyName(userMod.getCompanyName());
			form.setEmail(userMod.getEmail());
			form.setAddress1(userMod.getAddress1());
			form.setAddress2(userMod.getAddress2());
			form.setAddress3(userMod.getAddress3());
			form.setAddress4(userMod.getAddress4());
			form.setCity(userMod.getCity());
			form.setPhoneNo(userMod.getPhoneNo());
			form.setFaxNo(userMod.getFaxNo());
			form.setState(userMod.getState());
			form.setCountry(userMod.getCountry());
			form.setUserServiceModList(getUserServiceDtls(userMod,userServiceModList));
			lp_getContractPartyPortPair(form, userMod.getUserId(),  userMod.getUserId(),request);
		} else
			forwardPage = FAILURE;
		return forwardPage;

	}

	private List<EserviceRegistrationUserServiceMod> getUserServiceDtls(UserMod form,
			List<EserviceRegistrationUserServiceMod>  userServiceModList) {
		 
		userServiceModList = new ArrayList<EserviceRegistrationUserServiceMod>();
		
		EserviceRegistrationUserServiceMod obj = new EserviceRegistrationUserServiceMod();
        obj.setModuleName("Verified Gross Mass");
        obj.setSfu("EVGM-E");
        if(form.getVgm() != null && !form.getVgm().equals("") && form.getVgm().equals("Y")) {
        	obj.setChecked(true);
        }else{
        	obj.setChecked(false);
        }
        userServiceModList.add(obj);
        
        EserviceRegistrationUserServiceMod obj1 = new EserviceRegistrationUserServiceMod();
        obj1.setModuleName("Rate Inquiry");
        obj1.setSfu("EVGM-G");
        if(form.getGetRate() != null && !form.getGetRate().equals("") && form.getGetRate().equals("Y")) {
        	obj1.setChecked(true);
        }else{
        	obj1.setChecked(false);
        }
        userServiceModList.add(obj1);
        
        EserviceRegistrationUserServiceMod obj2 = new EserviceRegistrationUserServiceMod();
        obj2.setModuleName("Web Booking");
        obj2.setSfu("EBKG-E,EDOC-E");
        if(form.getWebBooking() != null && !form.getWebBooking().equals("") && form.getWebBooking().equals("Y")) {
        	obj2.setChecked(true);
        }else{
        	obj2.setChecked(false);
        }
        userServiceModList.add(obj2);
        
		return userServiceModList;
	}

	private String updateUser(UserMod form, HttpServletRequest request) throws Exception {
		String 					    forwardPage 					= null;
		UserProfileDao 				dao 							= null;
		RegistrationOrclDao         daoOrl							= null;
		// UserMod form = null;
		try {
			form 		= getForm(form);
			dao 		= (UserProfileDao) getDao(UserProfileDao.DAO_NAME);
			daoOrl		= getDaoOrl();
			
			try {
				updateRegistration(form,dao,daoOrl);
				form.setErrorMessage("");
			}catch (Exception e) {
				form.setErrorMessage("Faild..");
				e.printStackTrace();
			}
		} catch (Exception ex) {
			throw ex;
		}
		String user = WebUtils.getUserNew(request).getUserId();
		
		
		
		 return	forwardPage = getUser(form, request);

	}
	
	private UserMod getForm(ActionForm actionForm) throws Exception {
		UserMod form = null;
		try {
			form = (UserMod) actionForm;
			if (form == null) {
				form = new UserMod();
			}
		} catch (Exception ex) {
			throw ex;
		}

		return form;
	}

	 /*Begin @02*/
    private void lp_getContractPartyPortPair(UserMod form,String userRegistId, String userId,HttpServletRequest request){
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
            objDao                     = (EserviceRegistrationDao)getDao(EserviceRegistrationDao.DAO_NAME);
            mod                        = new EserviceContractPartyPortPairMod();
           // excludeExpireContractParty = form.getExcludeExpireContractParty(); //change to filter on screen

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
                    if("Y".equals("Y")){
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
                request.getSession(false).setAttribute("contractPartyList", contractPartyList);
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
    
    private Map updateRegistration(UserMod form, UserProfileDao dao,RegistrationOrclDao daoOrl) throws Exception{

        System.out.println("[EserviceRegistrationSvc][updateRegistration][Begin]");

        //EserviceRegistrationUserInfoMod     userInfoMod             = null;
        Map                                 resultMap               = null;
        Map<String, String>                 mapParams               = null;
        String                              allSFUCodeChecked       = null;
        String                              passwordEncrypted       = null;

        try{
            allSFUCodeChecked   = getAllSFUCodeChecked(form);
            passwordEncrypted   = EncryptDecryptUtil.convertStringToHex(form.getPassword());
            //userInfoMod         = form.getUserInfoMod();
            mapParams           = new HashMap<String, String>();

            mapParams.put(EserviceRegistrationDao.P_I_V.USR_ID      , form.getUserId().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CUST_NAME   , form.getFirstName().trim()+" "+form.getLastName() );
            mapParams.put(EserviceRegistrationDao.P_I_V.EMAIL       , form.getEmail().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CMP_NAME    , form.getCompanyName().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS1    , form.getAddress1().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS2    , form.getAddress2().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS3    , form.getAddress3().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.ADDRESS4    , form.getAddress4().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.CITY        , form.getCity().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.STATE       , form.getState().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.COUNTRY     , form.getCountry().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.PHONENO     , form.getPhoneNo().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.FAXNO       , form.getFaxNo().trim());
            mapParams.put(EserviceRegistrationDao.P_I_V.NEW_PWD     , passwordEncrypted);
//            mapParams.put(EserviceRegistrationDao.P_I_V.SFU         , allSFUCodeChecked + ",NUT_ROLE,BASIS"); //For test only !!
            mapParams.put(EserviceRegistrationDao.P_I_V.SFU         , allSFUCodeChecked);

            dao.getUpdateUserForUserProfile(mapParams, form ,daoOrl,dao);
        }catch(Exception ex){
            throw ex;
        }finally{
            System.out.println("[EserviceRegistrationSvc][updateRegistration][End]");
        }
        return resultMap;
    }
    
    private String getAllSFUCodeChecked(UserMod form) throws Exception{
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
    /*End @02*/
    private RegistrationOrclDao getDaoOrl() throws Exception {
    	RegistrationOrclDao dao = null;
        try {
            dao = (RegistrationOrclDao)getDao("RegistrationOrclDao");
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }
}

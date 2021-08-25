 /*------------------------------------------------------
  EserviceInternalUserRegistrationUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author -Joga------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import java.util.List;

import com.niit.control.common.ComboVO;
import com.niit.control.web.actionform.BaseActionForm;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVUtil;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceInternalRegistrationUserServiceMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceInternalUserRegistrationUserInfoMod;

public class EserviceInternalUserRegistrationUim extends BaseActionForm{
    private String userLoginId;
    private String name;
    private String lastName;
    private String email;
    private String reEmailAddress;
    private String oldPassword;
    private String password;
    private String rePassword;

    private EserviceInternalUserRegistrationUserInfoMod userInfoMod;
    private List<EserviceInternalRegistrationUserServiceMod> userServiceModList;

    private String[] location;
    private String currPageAction;
    private String prevPageAction;
    private String errMsg;
    private List<ComboVO> countryList;

   

    private String internalUser;
    private String submitSuccess;
    private String allSFUChecked;
    private boolean isInternalUser;

   
    private List<ContryMod> contryList;
    
    private String polPod;
    private String id;
    
    

        
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }

    public String getOldPassword(){
        return oldPassword;
    }

   
    public void setUserInfoMod(EserviceInternalUserRegistrationUserInfoMod userInfoMod){
        this.userInfoMod = userInfoMod;
    }

    public EserviceInternalUserRegistrationUserInfoMod getUserInfoMod(){
        return userInfoMod;
    }

    public void setUserServiceModList(List<EserviceInternalRegistrationUserServiceMod> userServiceModList){
        this.userServiceModList = userServiceModList;
    }

    public List<EserviceInternalRegistrationUserServiceMod> getUserServiceModList(){
        return userServiceModList;
    }

    public List<ContryMod> getContryList() {
		return contryList;
	}

	public void setContryList(List<ContryMod> contryList) {
		this.contryList = contryList;
	}

	public void setSubmitSuccess(String submitSuccess){
        this.submitSuccess = submitSuccess;
    }

    public String getSubmitSuccess(){
        return submitSuccess;
    }

    public void setAllSFUChecked(String allSFUChecked){
        this.allSFUChecked = allSFUChecked;
    }

    public String getAllSFUChecked(){
        return allSFUChecked;
    }
   
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setReEmailAddress(String reEmailAddress){
        this.reEmailAddress = reEmailAddress;
    }

    public String getReEmailAddress(){
        return reEmailAddress;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setRePassword(String rePassword){
        this.rePassword = rePassword;
    }

    public String getRePassword(){
        return rePassword;
    }

   

   

    public String[] getLocation() {
		return location;
	}

	public void setLocation(String[] location) {
		this.location = location;
	}


    public void setCurrPageAction(String currPageAction){
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction(){
        return currPageAction;
    }

    public void setPrevPageAction(String prevPageAction){
        this.prevPageAction = prevPageAction;
    }

    public String getPrevPageAction(){
        return prevPageAction;
    }

    public void setErrMsg(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }

    public void setCountryList(List<ComboVO> countryList){
        this.countryList = countryList;
    }

    public List<ComboVO> getCountryList(){
        return countryList;
    }

    

    public void setInternalUser(String internalUser){
        this.internalUser = internalUser;
        if(!EserviceRegistrationDao.USER_MODE.INTERNAL.equals(internalUser)){
            setIsInternalUser(false);
        }else{
            setIsInternalUser(true);
        }
    }

    public String getInternalUser(){
        return internalUser;
    }

    public void setIsInternalUser(boolean isInternalUser){
        this.isInternalUser = isInternalUser;
    }

    public boolean getIsInternalUser(){
        return isInternalUser;
    }

    public void setUserLoginId(String userLoginId){
        this.userLoginId = userLoginId;
    }

    public String getUserLoginId(){
        return userLoginId;
    }

    
    // #03 END

    public String getPolPod() {
		return polPod;
	}

	public void setPolPod(String polPod) {
		this.polPod = polPod;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public abstract interface PAGE_ACTION{
        public static final String INIT_REGISTRATION = "initRegistration";
        public static final String REGISTRATION = "registration";
        public static final String CHECK_AVAILABILITY = "checkAvailibility";
        public static final String TERM_OF_USE = "termOfUse";
    }

    public abstract interface FORWARD_PAGE{
        public static final String SUCCESS = "success";
        public static final String FAIL = "fail";
    }

    public EserviceInternalUserRegistrationUim(){
        resetForm();
    }

    public void resetForm(){
        try{
            this.userLoginId                = null;
            this.name                  = null;
            this.lastName                   = null;
            this.email					= null;
            this.reEmailAddress             = null;
            this.oldPassword                = null;
            this.password                   = null;
            this.rePassword                 = null;
            this.userInfoMod                = new EserviceInternalUserRegistrationUserInfoMod();
            this.userServiceModList         = null;
            this.submitSuccess              = null;
            this.location                  = null;
            this.countryList                = ComboBoxESVUtil.getBlankComboList();
            this.currPageAction             = null;
            this.prevPageAction             = null;
            this.allSFUChecked              = null;
            this.internalUser               = EserviceRegistrationDao.USER_MODE.EXTERNAL;
            this.errMsg                     = null;
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

	@Override
	public String toString() {
		return String.format(
				"EserviceRegistrationUim [userLoginId=%s, firstName=%s, lastName=%s, email=%s, reEmailAddress=%s, oldPassword=%s, password=%s, rePassword=%s, userInfoMod=%s, userServiceModList=%s, wbChecked=%s, esiChecked=%s, blChecked=%s, currPageAction=%s, prevPageAction=%s, errMsg=%s, countryList=%s, customerCode=%s, customerName=%s, customerFscCode=%s, customerType=%s, fscCode=%s, controlFsc=%s, internalUser=%s, submitSuccess=%s, allSFUChecked=%s, isInternalUser=%s, rejectReason=%s, crmErrorMsg=%s, maxPkPortPairSeq=%s, representedCompanyFlag=%s, contractPartyList=%s, portPairFlag=%s, excludeExpireContractParty=%s, fromMenu=%s, nonRaAccount=%s]",
				userLoginId, name, lastName, reEmailAddress, oldPassword, password, email,rePassword, userInfoMod,
				userServiceModList, location, currPageAction, prevPageAction, errMsg,
				countryList,internalUser, submitSuccess, allSFUChecked, isInternalUser);
	}
    
}

 /*------------------------------------------------------
  EserviceRegistrationUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author -
 - Change Log -------------------------------------------
 ##     DD/MM/YY    �User-  -TaskRef-   -ShortDescription-
 01     07/10/14    Pratya  @01         PD_CR_20140826_ESV [Contract Party for registeration]
 02     08/01/16    Watchakorn          Add 'Exclude expire contract party'
 03     20/12/18    Thitipong           Add Non RA Account.
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import java.util.ArrayList;
import java.util.List;

import com.niit.control.common.ComboVO;
import com.niit.control.web.actionform.BaseActionForm;
import com.rclgroup.dolphin.rcl.web.common.ComboBoxESVUtil;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserInfoMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRegistrationUserServiceMod;

public class EserviceRegistrationUim extends BaseActionForm{
    private String userLoginId;
    private String firstName;
    private String lastName;
    private String reEmailAddress;
    private String toPicMail;
    private String ccPicMail;
    private String bccPicMail;
    private String oldPassword;
    private String password;
    private String rePassword;

    private EserviceRegistrationUserInfoMod userInfoMod;
    private List<EserviceRegistrationUserServiceMod> userServiceModList;

    private String wbChecked;
    private String esiChecked;
    private String blChecked;
    private String currPageAction;
    private String prevPageAction;
    private String errMsg;
    private List<ComboVO> countryList;

    private String customerCode;
    private String customerName;
    private String customerFscCode;
    private String customerType;
    private String fscCode;
    private String controlFsc;

    private String internalUser;
    private String submitSuccess;
    private String allSFUChecked;
    private boolean isInternalUser;

    private String rejectReason;

    private String crmErrorMsg;
    private List<ContryMod> contryList;
    
    private String polPod;
    private String id;
    
    

    /*Begin @01*/
    private String                                  maxPkPortPairSeq;
    private String                                  representedCompanyFlag;
    private List <EserviceContractPartyPortPairMod> contractPartyList;
    private String                                  portPairFlag;
    /*End @01*/

    //##02 Begin
    private String                                  excludeExpireContractParty;
    private String                                  fromMenu;
    //##02 End
    
    private String                                  nonRaAccount;    // #03 ADD
    
    
	public String getToPicMail() {
		return toPicMail;
	}

	public void setToPicMail(String toPicMail) {
		this.toPicMail = toPicMail;
	}

	public String getCcPicMail() {
		return ccPicMail;
	}

	public void setCcPicMail(String ccPicMail) {
		this.ccPicMail = ccPicMail;
	}

	public String getBccPicMail() {
		return bccPicMail;
	}

	public void setBccPicMail(String bccPicMail) {
		this.bccPicMail = bccPicMail;
	}

	public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }

    public String getOldPassword(){
        return oldPassword;
    }

    public void setControlFsc(String controlFsc){
        this.controlFsc = controlFsc;
    }

    public String getControlFsc(){
        return controlFsc;
    }

    public void setCustomerFscCode(String customerFscCode){
        this.customerFscCode = customerFscCode;
    }

    public String getCustomerFscCode(){
        return customerFscCode;
    }

    public void setUserInfoMod(EserviceRegistrationUserInfoMod userInfoMod){
        this.userInfoMod = userInfoMod;
    }

    public EserviceRegistrationUserInfoMod getUserInfoMod(){
        return userInfoMod;
    }

    public void setUserServiceModList(List<EserviceRegistrationUserServiceMod> userServiceModList){
        this.userServiceModList = userServiceModList;
    }

    public List<EserviceRegistrationUserServiceMod> getUserServiceModList(){
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
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
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

    public void setWbChecked(String wbChecked){
        this.wbChecked = wbChecked;
    }

    public String getWbChecked(){
        return wbChecked;
    }

    public void setEsiChecked(String esiChecked){
        this.esiChecked = esiChecked;
    }

    public String getEsiChecked(){
        return esiChecked;
    }

    public void setBlChecked(String blChecked){
        this.blChecked = blChecked;
    }

    public String getBlChecked(){
        return blChecked;
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

    public void setCustomerCode(String customerCode){
        this.customerCode = customerCode;
    }

    public String getCustomerCode(){
        return customerCode;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerType(String customerType){
        this.customerType = customerType;
    }

    public String getCustomerType(){
        return customerType;
    }

    public void setFscCode(String fscCode){
        this.fscCode = fscCode;
    }

    public String getFscCode(){
        return fscCode;
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

    public void setCrmErrorMsg(String crmErrorMsg){
        this.crmErrorMsg = crmErrorMsg;
    }

    public String getCrmErrorMsg(){
        return crmErrorMsg;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setContractPartyList(List<EserviceContractPartyPortPairMod> contractPartyList) {
        this.contractPartyList = contractPartyList;
    }

    public List<EserviceContractPartyPortPairMod> getContractPartyList() {
        return contractPartyList;
    }

    public void setRepresentedCompanyFlag(String representedCompanyFlag) {
        this.representedCompanyFlag = representedCompanyFlag;
    }

    public String getRepresentedCompanyFlag() {
        return representedCompanyFlag;
    }

    public void setMaxPkPortPairSeq(String maxPkPortPairSeq) {
        this.maxPkPortPairSeq = maxPkPortPairSeq;
    }

    public String getMaxPkPortPairSeq() {
        return maxPkPortPairSeq;
    }

    public void setPortPairFlag(String portPairFlag) {
        this.portPairFlag = portPairFlag;
    }

    public String getPortPairFlag() {
        return portPairFlag;
    }

    public void setExcludeExpireContractParty(String excludeExpireContractParty){
        this.excludeExpireContractParty = excludeExpireContractParty;
    }

    public String getExcludeExpireContractParty(){
        return excludeExpireContractParty;
    }

    public void setFromMenu(String fromMenu){
        this.fromMenu = fromMenu;
    }

    public String getFromMenu(){
        return fromMenu;
    }
    
    // #03 START
    public void setNonRaAccount(String nonRaAccount){
        this.nonRaAccount = nonRaAccount;
    }

    public String getNonRaAccount(){
        return nonRaAccount;
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

    public EserviceRegistrationUim(){
        resetForm();
    }

    public void resetForm(){
        try{
            this.userLoginId                = null;
            this.firstName                  = null;
            this.lastName                   = null;
            this.reEmailAddress             = null;
            this.oldPassword                = null;
            this.password                   = null;
            this.rePassword                 = null;
            this.userInfoMod                = new EserviceRegistrationUserInfoMod();
            this.userServiceModList         = null;
            this.submitSuccess              = null;
            this.wbChecked                  = null;
            this.esiChecked                 = null;
            this.blChecked                  = null;
            this.countryList                = ComboBoxESVUtil.getBlankComboList();
            this.currPageAction             = null;
            this.prevPageAction             = null;
            this.customerCode               = null;
            this.customerName               = null;
            this.customerFscCode            = null;
            this.customerType               = null;
            this.fscCode                    = null;
            this.controlFsc                 = null;
            this.allSFUChecked              = null;
            this.crmErrorMsg                = null;
            this.rejectReason               = null;
            this.internalUser               = EserviceRegistrationDao.USER_MODE.EXTERNAL;
            this.errMsg                     = null;
            /*Begin @01*/
            this.maxPkPortPairSeq           = "0";
            this.representedCompanyFlag     = "N";
            this.contractPartyList          = new ArrayList <EserviceContractPartyPortPairMod>();
            this.portPairFlag               = "N";
            /*End @01*/

            //##02 Begin
            this.excludeExpireContractParty = "Y";
            this.fromMenu                   = "";
            //##02 End
            
            this.nonRaAccount               = "N";// #03 ADD
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

	@Override
	public String toString() {
		return String.format(
				"EserviceRegistrationUim [userLoginId=%s, firstName=%s, lastName=%s, reEmailAddress=%s, oldPassword=%s, password=%s, rePassword=%s, userInfoMod=%s, userServiceModList=%s, wbChecked=%s, esiChecked=%s, blChecked=%s, currPageAction=%s, prevPageAction=%s, errMsg=%s, countryList=%s, customerCode=%s, customerName=%s, customerFscCode=%s, customerType=%s, fscCode=%s, controlFsc=%s, internalUser=%s, submitSuccess=%s, allSFUChecked=%s, isInternalUser=%s, rejectReason=%s, crmErrorMsg=%s, maxPkPortPairSeq=%s, representedCompanyFlag=%s, contractPartyList=%s, portPairFlag=%s, excludeExpireContractParty=%s, fromMenu=%s, nonRaAccount=%s]",
				userLoginId, firstName, lastName, reEmailAddress, oldPassword, password, rePassword, userInfoMod,
				userServiceModList, wbChecked, esiChecked, blChecked, currPageAction, prevPageAction, errMsg,
				countryList, customerCode, customerName, customerFscCode, customerType, fscCode, controlFsc,
				internalUser, submitSuccess, allSFUChecked, isInternalUser, rejectReason, crmErrorMsg, maxPkPortPairSeq,
				representedCompanyFlag, contractPartyList, portPairFlag, excludeExpireContractParty, fromMenu,
				nonRaAccount);
	}
    
}

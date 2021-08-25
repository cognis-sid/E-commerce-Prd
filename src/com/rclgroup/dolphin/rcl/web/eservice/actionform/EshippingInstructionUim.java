/*------------------------------------------------------
 EshippingInstructionUim.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Anurak Thanapradit 27/05/13
 - Change Log -------------------------------------------
 ## DD/MM/YY 	 –User- 	-TaskRef-  -ShortDescription-
 ## 31/07/2013    TANA     	 01     	add commodity in Equipment detail
 ## 01/08/2013    TANA     	 02     	add msg error
 ## 22/08/2013    YOSSUN1  	 03     	add commodity detail list
 ## 04/09/2013    YOSSUN1  	 04     	add type of list\
 ## 12/09/2013    YOSSUN1  	 05     	add variable for control commodity section.
 ## 13/09/2013    YOSSUN1  	 06     	add variable previous booking for roll back.
 ## 12/12/2013    YOSSUN1  	 07     	add esiStatusCode parameter.
 ## 17/01/2014    YOSSUN1  	 08     	add pageAction parameter
 ## 10/09/2014    PRATYA   	 09     	PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
 ## 18/10/2019	  Sarawut A. 10	  		Add fields vessel no, pol no, pod no for save method
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.common.ComboVO;
import com.niit.control.web.actionform.BaseActionForm;

import com.rclgroup.dolphin.rcl.web.common.ComboBoxESIUtil;
import com.rclgroup.dolphin.rcl.web.eservice.vo.BlRevenueMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingBookingListMod;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingContactDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingRoutingDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingShipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.RoutingDtldsVo;

import java.util.ArrayList;
import java.util.List;
//==============================================================================
//OLD VERSION
//==============================================================================
public class EshippingInstructionUim extends BaseActionForm{

    public static final String FORM_BUFF_ESHHIPING_INSTRUCTION = "eshippingInstructionUim";

    private String bookingNo;
    private String blNo;
    private String blNumber;
    private String blType;
    //    private String status;
    private String siSubmittedBy;
    private String contact;
    private String email;
    private String additionalEmail;
    private String telephone;
    private String fax;
    private String quotation;
    
    private String toPicMail="";
    private String ccPicMail="";
    private String bccPicMail="";
    
    private String port1="";
    private String port2="";
    private String port3="";

    private String shipperCode;
    private String shipperName;
    private String shipperAddress1;
    private String shipperAddress2;
    private String shipperAddress3;
    private String shipperAddress4;
    private String consigneeCode;
    private String consigneeName;
    private String consigneeAddress1;
    private String consigneeAddress2;
    private String consigneeAddress3;
    private String consigneeAddress4;
    private String notifyPartyCode;
    private String notifyPartyName;
    private String notifyPartyAddress1;
    private String notifyPartyAddress2;
    private String notifyPartyAddress3;
    private String notifyPartyAddress4;

    private String vessel;
    private String vesselNo;
    private String voyageNo;
    private String vesselEdi;
    
    private String vessel1;
    private String vesselNo1;
    private String voyage1;
    
    private String shippedOnBoardDate;
    private String placeDateOfIssue;
    private String pol;
    private String pod;
    private String polNo;
    private String podNo;
    private String fromTerminal;
    private String toTerminal;
    private String fromTerminalDes;
    private String toTerminalDes;
    private String podCountry;
    private String placeOfReceipt;
    private String placeOfDelivery;
    private String noOfOriginal;
    private String commodity;
    private String containerNo;
    private String containerNoToCargo;
//    private String marksAndNumbers;
//    private String description;
    private String remarks;
    private String cocSoc;

    private String textSeparate;
    private String flag;
    private String itemsDelete;
    private String mode;
    private Boolean notFound;
    private String choiceRad;
    private String fsc;
    private Boolean openAcknowledgement;
    private String flagItemsDelete;
    
    private String containerArrayJson;

    private List<EshippingCargoDescriptionMod> cargoDescriptionDetails;
    private String[] cargoDetails;
    private List<ComboVO> blTypeValues;
    private List<BlRevenueMod> revinue;
    private List<RoutingDtldsVo> routingDtls;

    private String errMsg;
    private Boolean saveDraftIsSuccess;
    private Boolean submitIsSuccess;
    private String fromPoup;
    private Boolean isDisabledSubmit;

    //--------------------------------- For e-Shipping Acknowledtment Poupup ---------------------------------
    private String emailAcknowledgment;
    private String vendorTelephone;
    private String vendorFax;
    private String vendorEmail;
    //@03 BEGIN
    private List<EshippingCommodityDetailsMod> commodityVoDataList;
    private List<EshippingCommodityDetailsMod> commodityVoDataDelList;
    //@03 END
    //@02 BEGIN
    private String esiErrMsg;
    //@02 END
    //@01 BEGIN
    private String strCommodityForMark;
    private String commoditySelectChkBox;
    //@01 END
    //@05 BEGIN
    private int intEsiStatus;
    private boolean btnCommodityAddDisp;
    private boolean btnCommodityDelDisp;
    private String prevBookingNo;
    //@05 END
    //@06 BEGIN
    private EshippingInstructionUim prevESIForm;
    private String priViewFlag="" ;
    //@06 END
    //@07 BEGIN
    private String esiStatusCode;
    private String esiStatusDesc;
    private String prevEsiStatusCode;
    private String prevEsiStatusDesc;
    //@07 END
    //    @08 BEGIN
    private String currPageAction;
    //    @08 END
    
    private String msgFieldChanged;
    
    /*Begin @09*/
    private String commodityRowIndex;
    private String comSeqNoTemp;
    /*End @09*/
    
    private String bookingPartyCompany;
    private String contractPartyCompany;
    
    private String customerName;
    private String customerCompany;
    private String volume;
    
    private String sailinDate;
    

    public EshippingInstructionUim(){
        this.textSeparate = "@@@";

        this.commodityVoDataList = new ArrayList<EshippingCommodityDetailsMod>();
        this.commodityVoDataDelList = new ArrayList<EshippingCommodityDetailsMod>();
        this.esiErrMsg = "";
        this.strCommodityForMark = "";
        //@05 BEGIN
        this.intEsiStatus = 0;
        this.btnCommodityAddDisp = false;
        this.btnCommodityDelDisp = false;
        this.blTypeValues = ComboBoxESIUtil.getBLTypeDDList();
        this.prevBookingNo = BLANK;
        //@05 END
        //@07 BEGIN
        this.esiStatusCode = null;
        this.esiStatusDesc = null;
        this.prevEsiStatusCode = BLANK;
        this.prevEsiStatusDesc = BLANK;
        //@07 END
        //        @08 BEGIN
        this.currPageAction = null;
        //        @08 END
        
        this.msgFieldChanged = "";
        
        /*Begin @09*/
        this.commodityRowIndex  = "0";
        this.comSeqNoTemp       = "0";
        /*End @09*/
    }
 
    
    
    public String getVessel1() {
		return vessel1;
	}



	public void setVessel1(String vessel1) {
		this.vessel1 = vessel1;
	}



	public String getVesselNo1() {
		return vesselNo1;
	}



	public void setVesselNo1(String vesselNo1) {
		this.vesselNo1 = vesselNo1;
	}



	public String getVoyage1() {
		return voyage1;
	}



	public void setVoyage1(String voyage1) {
		this.voyage1 = voyage1;
	}



public String getContainerArrayJson() {
		return containerArrayJson;
	}



	public void setContainerArrayJson(String containerArrayJson) {
		this.containerArrayJson = containerArrayJson;
	}



public List<RoutingDtldsVo> getRoutingDtls() {
		return routingDtls;
	}



	public void setRoutingDtls(List<RoutingDtldsVo> routingDtls) {
		this.routingDtls = routingDtls;
	}



public String getFromTerminalDes() {
		return fromTerminalDes;
	}



	public void setFromTerminalDes(String fromTerminalDes) {
		this.fromTerminalDes = fromTerminalDes;
	}



	public String getToTerminalDes() {
		return toTerminalDes;
	}



	public void setToTerminalDes(String toTerminalDes) {
		this.toTerminalDes = toTerminalDes;
	}



public String getPriViewFlag() {
		return priViewFlag;
	}

	public void setPriViewFlag(String priViewFlag) {
		this.priViewFlag = priViewFlag;
	}



private List tableData = new ArrayList();
    
    
    public String getVolume() {
	return volume;
}

    
    
public String getSailinDate() {
		return sailinDate;
	}



	public void setSailinDate(String sailinDate) {
		this.sailinDate = sailinDate;
	}



public void setVolume(String volume) {
	this.volume = volume;
}

	public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCustomerCompany() {
	return customerCompany;
}

public void setCustomerCompany(String customerCompany) {
	this.customerCompany = customerCompany;
}

	public String getBookingPartyCompany() {
	return bookingPartyCompany;
}



public void setBookingPartyCompany(String bookingPartyCompany) {
	this.bookingPartyCompany = bookingPartyCompany;
}



public String getContractPartyCompany() {
	return contractPartyCompany;
}



public void setContractPartyCompany(String contractPartyCompany) {
	this.contractPartyCompany = contractPartyCompany;
}



	public List getValues() {
        return this.tableData;
    }

    public void setValues(List aarlTableData) {
        this.tableData = aarlTableData;
    }

    public void setBookingNo(String bookingNo){
        this.bookingNo = bookingNo;
    }

    public String getBookingNo(){
        return bookingNo;
    }

    public void setBlNumber(String blNumber){
        this.blNumber = blNumber;
    }

    public String getBlNumber(){
        return blNumber;
    }

    public void setBlType(String blType){
        this.blType = blType;
    }

    public String getBlType(){
        return blType;
    }

    //    public void setStatus(String status) {
    //        this.status = status;
    //        setEsiStatus(status);
    //    }
    //
    //    public String getStatus() {
    //        return status;
    //    }

    public void setSiSubmittedBy(String siSubmittedBy){
        this.siSubmittedBy = siSubmittedBy;
    }

    public String getSiSubmittedBy(){
        return siSubmittedBy;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getContact(){
        return contact;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setFax(String fax){
        this.fax = fax;
    }

    public String getFax(){
        return fax;
    }

    public void setShipperName(String shipperName){
    		this.shipperName = shipperName;
    }

    public String getShipperName(){
        return shipperName;
    }

    public void setShipperAddress1(String shipperAddress1){
        this.shipperAddress1 = shipperAddress1;
    }

    public String getShipperAddress1(){
        return shipperAddress1;
    }

    public void setShipperAddress2(String shipperAddress2){
    		this.shipperAddress2 = shipperAddress2;
    }

    public String getShipperAddress2(){
        return shipperAddress2;
    }

    public void setShipperAddress3(String shipperAddress3){
    		this.shipperAddress3 = shipperAddress3;
    }

    public String getShipperAddress3(){
        return shipperAddress3;
    }

    public void setShipperAddress4(String shipperAddress4){
    		this.shipperAddress4 = shipperAddress4;
    }

    public String getShipperAddress4(){
        return shipperAddress4;
    }

    public void setConsigneeName(String consigneeName){
    		this.consigneeName = consigneeName;
    }

    public String getConsigneeName(){
        return consigneeName;
    }

    public void setConsigneeAddress1(String consigneeAddress1){
    		this.consigneeAddress1 = consigneeAddress1;
    }

    public String getConsigneeAddress1(){
        return consigneeAddress1;
    }

    public void setConsigneeAddress2(String consigneeAddress2){
    		this.consigneeAddress2 = consigneeAddress2;
    }

    public String getConsigneeAddress2(){
        return consigneeAddress2;
    }

    public void setConsigneeAddress3(String consigneeAddress3){
        	this.consigneeAddress3 = consigneeAddress3;
    }

    public String getConsigneeAddress3(){
        return consigneeAddress3;
    }

    public void setConsigneeAddress4(String consigneeAddress4){
    		this.consigneeAddress4 = consigneeAddress4;
    }

    public String getConsigneeAddress4(){
        return consigneeAddress4;
    }

    public void setNotifyPartyName(String notifyPartyName){
    		this.notifyPartyName = notifyPartyName;
    }

    public String getNotifyPartyName(){
        return notifyPartyName;
    }

    public void setNotifyPartyAddress1(String notifyPartyAddress1){
    		this.notifyPartyAddress1 = notifyPartyAddress1;
    }

    public String getNotifyPartyAddress1(){
        return notifyPartyAddress1;
    }

    public void setNotifyPartyAddress2(String notifyPartyAddress2){
    		this.notifyPartyAddress2 = notifyPartyAddress2;
    }

    public String getNotifyPartyAddress2(){
        return notifyPartyAddress2;
    }

    public void setNotifyPartyAddress3(String notifyPartyAddress3){
    		this.notifyPartyAddress3 = notifyPartyAddress3;
    }

    public String getNotifyPartyAddress3(){
        return notifyPartyAddress3;
    }

    public void setNotifyPartyAddress4(String notifyPartyAddress4){
    		this.notifyPartyAddress4 = notifyPartyAddress4;
    }

    public String getNotifyPartyAddress4(){
        return notifyPartyAddress4;
    }

    public void setVessel(String vessel){
        this.vessel = vessel;
    }

    public String getVessel(){
        return vessel;
    }

    public void setVoyageNo(String voyageNo){
        this.voyageNo = voyageNo;
    }

    public String getVoyageNo(){
        return voyageNo;
    }

    public void setShippedOnBoardDate(String shippedOnBoardDate){
        this.shippedOnBoardDate = shippedOnBoardDate;
    }

    public String getShippedOnBoardDate(){
        return shippedOnBoardDate;
    }

    public void setPlaceDateOfIssue(String placeDateOfIssue){
        this.placeDateOfIssue = placeDateOfIssue;
    }

    public String getPlaceDateOfIssue(){
        return placeDateOfIssue;
    }

    public void setPol(String pol){
        this.pol = pol;
    }

    public String getPol(){
        return pol;
    }

    public void setPod(String pod){
        this.pod = pod;
    }

    public String getPod(){
        return pod;
    }

    public void setPlaceOfReceipt(String placeOfReceipt){
        this.placeOfReceipt = placeOfReceipt;
    }

    public String getPlaceOfReceipt(){
        return placeOfReceipt;
    }

    public void setPlaceOfDelivery(String placeOfDelivery){
        this.placeOfDelivery = placeOfDelivery;
    }

    public String getPlaceOfDelivery(){
        return placeOfDelivery;
    }

    public void setTextSeparate(String textSeparate){
        this.textSeparate = textSeparate;
    }

    public String getTextSeparate(){
        return textSeparate;
    }

    public void setFlag(String flag){
        this.flag = flag;
    }

    public String getFlag(){
        return flag;
    }

    public void setItemsDelete(String itemsDelete){
        this.itemsDelete = itemsDelete;
    }

    public String getItemsDelete(){
        return itemsDelete;
    }

    public void setCargoDescriptionDetails(List<EshippingCargoDescriptionMod> cargoDescriptionDetails){
        this.cargoDescriptionDetails = cargoDescriptionDetails;
    }

    public List<EshippingCargoDescriptionMod> getCargoDescriptionDetails(){
        return cargoDescriptionDetails;
    }

    public void setCargoDetails(String[] cargoDetails){
        this.cargoDetails = cargoDetails;
    }

    public String[] getCargoDetails(){
        return cargoDetails;
    }

    public void setMode(String mode){
        this.mode = mode;
    }

    public String getMode(){
        return mode;
    }

    public void setNotFound(Boolean notFound){
        this.notFound = notFound;
    }

    public Boolean getNotFound(){
        return notFound;
    }

    public void setBlNo(String blNo){
        this.blNo = blNo;
    }

    public String getBlNo(){
        return blNo;
    }

    public void setNoOfOriginal(String noOfOriginal){
        this.noOfOriginal = noOfOriginal;
    }

    public String getNoOfOriginal(){
        return noOfOriginal;
    }

//    public void setDescription(String description){
//        this.description = description;
//    }
//
//    public String getDescription(){
//        return description;
//    }

    public void setBlTypeValues(List<ComboVO> blTypeValues){
        this.blTypeValues = blTypeValues;
    }

    public List<ComboVO> getBlTypeValues(){
        return blTypeValues;
    }

    public void setChoiceRad(String choiceRad){
        this.choiceRad = choiceRad;
    }

    public String getChoiceRad(){
        return choiceRad;
    }

//    public void setMarksAndNumbers(String marksAndNumbers){
//        this.marksAndNumbers = marksAndNumbers;
//    }
//
//    public String getMarksAndNumbers(){
//        return marksAndNumbers;
//    }

    public void setRemarks(String remarks){
    		this.remarks = remarks;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setAdditionalEmail(String additionalEmail){
        this.additionalEmail = additionalEmail;
    }

    public String getAdditionalEmail(){
        return additionalEmail;
    }

    public void setCommodity(String commodity){
        this.commodity = commodity;
    }

    public String getCommodity(){
        return commodity;
    }

    public void setContainerNo(String containerNo){
        this.containerNo = containerNo;
    }

    public String getContainerNo(){
        return containerNo;
    }

    public void setCocSoc(String cocSoc){
        this.cocSoc = cocSoc;
    }

    public String getCocSoc(){
        return cocSoc;
    }


    public void setErrMsg(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }

    public void setShipperCode(String shipperCode){
        this.shipperCode = shipperCode;
    }

    public String getShipperCode(){
        return shipperCode;
    }

    public void setConsigneeCode(String consigneeCode){
        this.consigneeCode = consigneeCode;
    }

    public String getConsigneeCode(){
        return consigneeCode;
    }

    public void setNotifyPartyCode(String notifyPartyCode){
        this.notifyPartyCode = notifyPartyCode;
    }

    public String getNotifyPartyCode(){
        return notifyPartyCode;
    }

    public void setOpenAcknowledgement(Boolean openAcknowledgement){
        this.openAcknowledgement = openAcknowledgement;
    }

    public Boolean getOpenAcknowledgement(){
        return openAcknowledgement;
    }

    public void setEmailAcknowledgment(String emailAcknowledgment){
        this.emailAcknowledgment = emailAcknowledgment;
    }

    public String getEmailAcknowledgment(){
        return emailAcknowledgment;
    }

    public void setVendorTelephone(String vendorTelephone){
        this.vendorTelephone = vendorTelephone;
    }

    public String getVendorTelephone(){
        return vendorTelephone;
    }

    public void setVendorFax(String vendorFax){
        this.vendorFax = vendorFax;
    }

    public String getVendorFax(){
        return vendorFax;
    }

    public void setVendorEmail(String vendorEmail){
        this.vendorEmail = vendorEmail;
    }

    public String getVendorEmail(){
        return vendorEmail;
    }

    public void setSaveDraftIsSuccess(Boolean saveDraftIsSuccess){
        this.saveDraftIsSuccess = saveDraftIsSuccess;
    }

    public Boolean getSaveDraftIsSuccess(){
        return saveDraftIsSuccess;
    }

    public void setSubmitIsSuccess(Boolean submitIsSuccess){
        this.submitIsSuccess = submitIsSuccess;
    }

    public Boolean getSubmitIsSuccess(){
        return submitIsSuccess;
    }

    public void setFsc(String fsc){
        this.fsc = fsc;
    }

    public String getFsc(){
        return fsc;
    }

    public void setContainerNoToCargo(String containerNoToCargo){
        this.containerNoToCargo = containerNoToCargo;
    }

    public String getContainerNoToCargo(){
        return containerNoToCargo;
    }

    public void setFlagItemsDelete(String flagItemsDelete){
        this.flagItemsDelete = flagItemsDelete;
    }

    public String getFlagItemsDelete(){
        return flagItemsDelete;
    }

    public void setFromPoup(String fromPoup){
        this.fromPoup = fromPoup;
    }

    public String getFromPoup(){
        return fromPoup;
    }

    public void setPodCountry(String podCountry){
        this.podCountry = podCountry;
    }

    public String getPodCountry(){
        return podCountry;
    }

    public void setIsDisabledSubmit(Boolean isDisabledSubmit){
        this.isDisabledSubmit = isDisabledSubmit;
    }

    public Boolean getIsDisabledSubmit(){
        return isDisabledSubmit;
    }

    public void setEsiErrMsg(String esiErrMsg){
        this.esiErrMsg = esiErrMsg;
    }

    public String getEsiErrMsg(){
        return esiErrMsg;
    }

    public void setStrCommodityForMark(String strCommodityForMark){
        this.strCommodityForMark = strCommodityForMark;
    }

    public String getStrCommodityForMark(){
        return strCommodityForMark;
    }
    //@03 BEGIN
    //@04 BEGIN

    public void setCommodityVoDataList(List<EshippingCommodityDetailsMod> commodityVoDataList){
        this.commodityVoDataList = commodityVoDataList;
    }

    public List<EshippingCommodityDetailsMod> getCommodityVoDataList(){
        return commodityVoDataList;
    }
    //@04 END 

    public EshippingCommodityDetailsMod getCommodityValue(int aintIndex){
        EshippingCommodityDetailsMod commodityMod = null;

        List<EshippingCommodityDetailsMod> commodityVoDataList = null;
        try{
            commodityVoDataList = getCommodityVoDataList();
            if(commodityVoDataList==null){
                setCommodityVoDataList(new ArrayList<EshippingCommodityDetailsMod>());

                commodityVoDataList = getCommodityVoDataList();
            }
            if(aintIndex>=commodityVoDataList.size()){
                for(int i = commodityVoDataList.size(); i<=aintIndex; i++){
                    //Create blank dto
                    EshippingCommodityDetailsMod eshippingCommodityDetailsMod = new EshippingCommodityDetailsMod();
                    //                eshippingCommodityDetailsMod.setIntCommGroupSeqNo(aintIndex + 1);
                    commodityVoDataList.add(eshippingCommodityDetailsMod);
                } //for loop ends
            } //if ends
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            commodityMod = commodityVoDataList.get(aintIndex);
        }
        return commodityMod;
    }
    //@03 END

    public void setCommoditySelectChkBox(String commoditySelectChkBox){
        this.commoditySelectChkBox = commoditySelectChkBox;
    }

    public String getCommoditySelectChkBox(){
        return commoditySelectChkBox;
    }

    //@05 BEGIN

    public void setIntEsiStatus(int intEsiStatus){
        this.intEsiStatus = intEsiStatus;
    }

    public int getIntEsiStatus(){
        return intEsiStatus;
    }

    public void setBtnCommodityAddDisp(boolean btnCommodityAddDisp){
        this.btnCommodityAddDisp = btnCommodityAddDisp;
    }

    public boolean isBtnCommodityAddDisp(){
        return btnCommodityAddDisp;
    }

    public void setBtnCommodityDelDisp(boolean btnCommodityDelDisp){
        this.btnCommodityDelDisp = btnCommodityDelDisp;
    }

    public boolean isBtnCommodityDelDisp(){
        return btnCommodityDelDisp;
    }

    public void setPrevBookingNo(String prevBookingNo){
        this.prevBookingNo = prevBookingNo;
    }

    public String getPrevBookingNo(){
        return prevBookingNo;
    }
    //@05 END

    public void setPrevESIForm(EshippingInstructionUim prevESIForm){
        this.prevESIForm = prevESIForm;
    }

    public EshippingInstructionUim getPrevESIForm(){
        return prevESIForm;
    }

    public void setCommodityVoDataDelList(List<EshippingCommodityDetailsMod> commodityVoDataDelList){
        this.commodityVoDataDelList = commodityVoDataDelList;
    }

    public List<EshippingCommodityDetailsMod> getCommodityVoDataDelList(){
        return commodityVoDataDelList;
    }
    //    @18 BEGIN

    public void setEsiStatusCode(String esiStatusCode){
        this.esiStatusCode = esiStatusCode;
    }

    public String getEsiStatusCode(){
        return esiStatusCode;
    }

    public void setEsiStatusDesc(String esiStatusDesc){
        this.esiStatusDesc = esiStatusDesc;
    }

    public String getEsiStatusDesc(){
        return esiStatusDesc;
    }

    public void setPrevEsiStatusCode(String prevEsiStatusCode){
        this.prevEsiStatusCode = prevEsiStatusCode;
    }

    public String getPrevEsiStatusCode(){
        return prevEsiStatusCode;
    }

    public void setPrevEsiStatusDesc(String prevEsiStatusDesc){
        this.prevEsiStatusDesc = prevEsiStatusDesc;
    }

    public String getPrevEsiStatusDesc(){
        return prevEsiStatusDesc;
    }
    //    @18 END
    //    @08 BEGIN
    public String getVesselNo() {
		return vesselNo;
	}

	public void setVesselNo(String vesselNo) {
		this.vesselNo = vesselNo;
	}

	public String getPolNo() {
		return polNo;
	}

	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}

	public String getPodNo() {
		return podNo;
	}

	public void setPodNo(String podNo) {
		this.podNo = podNo;
	}
    public void setCurrPageAction(String currPageAction){
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction(){
        return currPageAction;
    }
    //    @08 END
    
     public void setMsgFieldChanged(String msgFieldChanged) {
         this.msgFieldChanged = msgFieldChanged;
     }

     public String getMsgFieldChanged() {
         return msgFieldChanged;
     }

    public void rollBackForm(EshippingInstructionUim eSIFormSet, EshippingInstructionUim eSIFormGet){
        try{
            if(eSIFormSet!=null&&eSIFormGet!=null){
                eSIFormSet.setAdditionalEmail(eSIFormGet.getAdditionalEmail());
                eSIFormSet.setBlNo(eSIFormGet.getBlNo());
                eSIFormSet.setBlNumber(eSIFormGet.getBlNumber());
                eSIFormSet.setBlType(eSIFormGet.getBlType());
                eSIFormSet.setBlTypeValues(eSIFormGet.getBlTypeValues());
                eSIFormSet.setBookingInValues(eSIFormGet.getBookingInValues());
                eSIFormSet.setBookingNo(eSIFormGet.getBookingNo());
                eSIFormSet.setBookingOrder2OrdValues(eSIFormGet.getBookingOrder2OrdValues());
                eSIFormSet.setBookingOrderValues(eSIFormGet.getBookingOrderValues());
                eSIFormSet.setBtnCommodityAddDisp(eSIFormGet.isBtnCommodityAddDisp());
                eSIFormSet.setBtnCommodityDelDisp(eSIFormGet.isBtnCommodityDelDisp());
                eSIFormSet.setCargoDescriptionDetails(eSIFormGet.getCargoDescriptionDetails());
                eSIFormSet.setCargoDetails(eSIFormGet.getCargoDetails());
                eSIFormSet.setChargeBasisType(eSIFormGet.getChargeBasisType());
                eSIFormSet.setChargeBasisTypeValues(eSIFormGet.getChargeBasisTypeValues());
                eSIFormSet.setChoiceRad(eSIFormGet.getChoiceRad());
                eSIFormSet.setClrValues(eSIFormGet.getClrValues());
                eSIFormSet.setCocSoc(eSIFormGet.getCocSoc());
                eSIFormSet.setCommodity(eSIFormGet.getCommodity());
                eSIFormSet.setCommoditySelectChkBox(eSIFormGet.getCommoditySelectChkBox());
                eSIFormSet.setCommodityVoDataList(eSIFormGet.getCommodityVoDataList());
                eSIFormSet.setConsigneeAddress1(eSIFormGet.getConsigneeAddress1());
                eSIFormSet.setConsigneeAddress2(eSIFormGet.getConsigneeAddress2());
                eSIFormSet.setConsigneeAddress3(eSIFormGet.getConsigneeAddress3());
                eSIFormSet.setConsigneeAddress4(eSIFormGet.getConsigneeAddress4());
                eSIFormSet.setConsigneeCode(eSIFormGet.getConsigneeCode());
                eSIFormSet.setConsigneeName(eSIFormGet.getConsigneeName());
                eSIFormSet.setContact(eSIFormGet.getContact());
                eSIFormSet.setContainerNo(eSIFormGet.getContainerNo());
                eSIFormSet.setContainerNoToCargo(eSIFormGet.getContainerNoToCargo());
                eSIFormSet.setCurrency(eSIFormGet.getCurrency());
                eSIFormSet.setCurrencyValues(eSIFormGet.getCurrencyValues());
                eSIFormSet.setCurrPageNo(eSIFormGet.getCurrPageNo());
                eSIFormSet.setDamagedValues(eSIFormGet.getDamagedValues());
//                eSIFormSet.setDescription(eSIFormGet.getDescription());
                eSIFormSet.setDischargeListStatusValues(eSIFormGet.getDischargeListStatusValues());
                eSIFormSet.setDischargeStsOlValues(eSIFormGet.getDischargeStsOlValues());
                eSIFormSet.setDischargeStsValues(eSIFormGet.getDischargeStsValues());
                eSIFormSet.setDocStatus(eSIFormGet.getDocStatus());
                eSIFormSet.setDocStatusValues(eSIFormGet.getDocStatusValues());
                eSIFormSet.setDocType(eSIFormGet.getDocType());
                eSIFormSet.setDocTypeValues(eSIFormGet.getDocTypeValues());
                eSIFormSet.setEmail(eSIFormGet.getEmail());
                eSIFormSet.setEmailAcknowledgment(eSIFormGet.getEmailAcknowledgment());
                eSIFormSet.setErrMsg(eSIFormGet.getErrMsg());
                eSIFormSet.setEsiErrMsg(eSIFormGet.getEsiErrMsg());
                eSIFormSet.setFalseVal(eSIFormGet.isFalseVal());
                eSIFormSet.setFax(eSIFormGet.getFax());
                eSIFormSet.setFindIn(eSIFormGet.getFindIn());
                eSIFormSet.setFindInValues(eSIFormGet.getFindInValues());
                eSIFormSet.setFindVal(eSIFormGet.getFindVal());
                eSIFormSet.setFlag(eSIFormGet.getFlag());
                eSIFormSet.setFlagItemsDelete(eSIFormGet.getFlagItemsDelete());
                eSIFormSet.setFlashUnitValues(eSIFormGet.getFlashUnitValues());
                eSIFormSet.setFrmFwFrcCd(eSIFormGet.getFrmFwFrcCd());
                eSIFormSet.setFromPoup(eSIFormGet.getFromPoup());
                eSIFormSet.setFsc(eSIFormGet.getFsc());
                eSIFormSet.setFumigationOnlyValues(eSIFormGet.getFumigationOnlyValues());
                eSIFormSet.setIntEsiStatus(eSIFormGet.getIntEsiStatus());
                eSIFormSet.setIsDisabledSubmit(eSIFormGet.getIsDisabledSubmit());
                eSIFormSet.setItemsDelete(eSIFormGet.getItemsDelete());
                eSIFormSet.setJspParam(eSIFormGet.getJspParam());
                eSIFormSet.setLlBookingInValues(eSIFormGet.getLlBookingInValues());
                eSIFormSet.setLlBookingOrderValues(eSIFormGet.getLlBookingOrderValues());
                eSIFormSet.setLlRestowedInValues(eSIFormGet.getLlRestowedInValues());
                eSIFormSet.setLlRestowedOrderValues(eSIFormGet.getLlRestowedOrderValues());
                eSIFormSet.setLoadConditionValues(eSIFormGet.getLoadConditionValues());
                eSIFormSet.setLoadingStatusValue(eSIFormGet.getLoadingStatusValue());
                eSIFormSet.setLoadListStatusValues(eSIFormGet.getLoadListStatusValues());
                eSIFormSet.setLocalContStsValues(eSIFormGet.getLocalContStsValues());
                eSIFormSet.setLocType(eSIFormGet.getLocType());
                eSIFormSet.setLocTypeValues(eSIFormGet.getLocTypeValues());
//                eSIFormSet.setMarksAndNumbers(eSIFormGet.getMarksAndNumbers());
                eSIFormSet.setMidstreamValues(eSIFormGet.getMidstreamValues());
                eSIFormSet.setMode(eSIFormGet.getMode());
                eSIFormSet.setMultipartRequestHandler(eSIFormGet.getMultipartRequestHandler());
                eSIFormSet.setNoOfOriginal(eSIFormGet.getNoOfOriginal());
                eSIFormSet.setNotFound(eSIFormGet.getNotFound());
                eSIFormSet.setNotifyPartyAddress1(eSIFormGet.getNotifyPartyAddress1());
                eSIFormSet.setNotifyPartyAddress2(eSIFormGet.getNotifyPartyAddress2());
                eSIFormSet.setNotifyPartyAddress3(eSIFormGet.getNotifyPartyAddress3());
                eSIFormSet.setNotifyPartyAddress4(eSIFormGet.getNotifyPartyAddress4());
                eSIFormSet.setNotifyPartyCode(eSIFormGet.getNotifyPartyCode());
                eSIFormSet.setNotifyPartyName(eSIFormGet.getNotifyPartyName());
                eSIFormSet.setOneVal(eSIFormGet.getOneVal());
                eSIFormSet.setOpenAcknowledgement(eSIFormGet.getOpenAcknowledgement());
                eSIFormSet.setOverlandedInValues(eSIFormGet.getOverlandedInValues());
                eSIFormSet.setOverlandedOrderValues(eSIFormGet.getOverlandedOrderValues());
                eSIFormSet.setOvershippedInValues(eSIFormGet.getOvershippedInValues());
                eSIFormSet.setOvershippedLoadingData(eSIFormGet.getOvershippedLoadingData());
                eSIFormSet.setOvershippedOrdValue(eSIFormGet.getOvershippedOrdValue());
                eSIFormSet.setPageId(eSIFormGet.getPageId());
                eSIFormSet.setPlaceDateOfIssue(eSIFormGet.getPlaceDateOfIssue());
                eSIFormSet.setPlaceOfDelivery(eSIFormGet.getPlaceOfDelivery());
                eSIFormSet.setPlaceOfReceipt(eSIFormGet.getPlaceOfReceipt());
                eSIFormSet.setPod(eSIFormGet.getPod());
                eSIFormSet.setPodCountry(eSIFormGet.getPodCountry());
                eSIFormSet.setPodStatusValues(eSIFormGet.getPodStatusValues());
                eSIFormSet.setPol(eSIFormGet.getPol());
                eSIFormSet.setPrevBookingNo(eSIFormGet.getPrevBookingNo());
                eSIFormSet.setPrevESIForm(eSIFormGet.getPrevESIForm());
                eSIFormSet.setRadioGroup1(eSIFormGet.getRadioGroup1());
                eSIFormSet.setRecFound(eSIFormGet.isRecFound());
                eSIFormSet.setRecStatus(eSIFormGet.getRecStatus());
                eSIFormSet.setRecStatusValues(eSIFormGet.getRecStatusValues());
                eSIFormSet.setReeferTempUnitValues(eSIFormGet.getReeferTempUnitValues());
                eSIFormSet.setRefreshVisible(eSIFormGet.isRefreshVisible());
                eSIFormSet.setRemarks(eSIFormGet.getRemarks());
                eSIFormSet.setReqSesId(eSIFormGet.getReqSesId());
                eSIFormSet.setResidueValues(eSIFormGet.getResidueValues());
                eSIFormSet.setRestowedInValues(eSIFormGet.getRestowedInValues());
                eSIFormSet.setRestowedOrderValues(eSIFormGet.getRestowedOrderValues());
                eSIFormSet.setRestowStsValues(eSIFormGet.getRestowStsValues());
                eSIFormSet.setRole(eSIFormGet.getRole());
                eSIFormSet.setSaveDraftIsSuccess(eSIFormGet.getSaveDraftIsSuccess());
                eSIFormSet.setSaveVisible(eSIFormGet.isSaveVisible());
                eSIFormSet.setScreenId(eSIFormGet.getScreenId());
                eSIFormSet.setSearchCriteria(eSIFormGet.getSearchCriteria());
                eSIFormSet.setSearchParams(eSIFormGet.getSearchParams());
                eSIFormSet.setSearchPerformed(eSIFormGet.getSearchPerformed());
                eSIFormSet.setService(eSIFormGet.getService());
                eSIFormSet.setServiceValues(eSIFormGet.getServiceValues());
                eSIFormSet.setServlet(eSIFormGet.getServlet());
                eSIFormSet.setShippedOnBoardDate(eSIFormGet.getShippedOnBoardDate());
                eSIFormSet.setShipperAddress1(eSIFormGet.getShipperAddress1());
                eSIFormSet.setShipperAddress2(eSIFormGet.getShipperAddress2());
                eSIFormSet.setShipperAddress3(eSIFormGet.getShipperAddress3());
                eSIFormSet.setShipperAddress4(eSIFormGet.getShipperAddress4());
                eSIFormSet.setShipperCode(eSIFormGet.getShipperCode());
                eSIFormSet.setShipperName(eSIFormGet.getShipperName());
                eSIFormSet.setSiSubmittedBy(eSIFormGet.getSiSubmittedBy());
                eSIFormSet.setSortBy(eSIFormGet.getSortBy());
                eSIFormSet.setSortByValues(eSIFormGet.getSortByValues());
                eSIFormSet.setSortIn(eSIFormGet.getSortIn());
                eSIFormSet.setSortInValues(eSIFormGet.getSortInValues());
                eSIFormSet.setSpecialHandlingValues(eSIFormGet.getSpecialHandlingValues());
                //                eSIFormSet.setStatus(eSIFormGet.getStatus());
                eSIFormSet.setStrCommodityForMark(eSIFormGet.getStrCommodityForMark());
                eSIFormSet.setSubmitIsSuccess(eSIFormGet.getSubmitIsSuccess());
                eSIFormSet.setSwapConnectionValues(eSIFormGet.getSwapConnectionValues());
                eSIFormSet.setTelephone(eSIFormGet.getTelephone());
                eSIFormSet.setTextSeparate(eSIFormGet.getTextSeparate());
                eSIFormSet.setTightConnectionPODValues(eSIFormGet.getTightConnectionPODValues());
                eSIFormSet.setTrueVal(eSIFormGet.isTrueVal());
                eSIFormSet.setUom(eSIFormGet.getUom());
                eSIFormSet.seUomValues(eSIFormGet.getUomValues());
                eSIFormSet.setUserName(eSIFormGet.getUserName());
                eSIFormSet.setVendorEmail(eSIFormGet.getVendorEmail());
                eSIFormSet.setVendorFax(eSIFormGet.getVendorFax());
                eSIFormSet.setVendorTelephone(eSIFormGet.getVendorTelephone());
                eSIFormSet.setVessel(eSIFormGet.getVessel());
                eSIFormSet.setViewName(eSIFormGet.getViewName());
                eSIFormSet.setViewNameValues(eSIFormGet.getViewNameValues());
                eSIFormSet.setViewType(eSIFormGet.getViewType());
                eSIFormSet.setViewTypeValues(eSIFormGet.getViewTypeValues());
                eSIFormSet.setVoyageNo(eSIFormGet.getVoyageNo());
                eSIFormSet.setWildCard(eSIFormGet.getWildCard());
                eSIFormSet.setWildCardValues(eSIFormGet.getWildCardValues());
                eSIFormSet.setZeroVal(eSIFormGet.getZeroVal());
                eSIFormSet.setCommodityVoDataDelList(eSIFormGet.getCommodityVoDataDelList());
                //                @07 BEGIN
                eSIFormSet.setEsiStatusCode(eSIFormGet.getEsiStatusCode());
                eSIFormSet.setEsiStatusDesc(eSIFormGet.getEsiStatusDesc());
                eSIFormSet.setPrevEsiStatusCode(eSIFormGet.getPrevEsiStatusCode());
                eSIFormSet.setPrevEsiStatusDesc(eSIFormGet.getPrevEsiStatusDesc());
                //                @07 END
                //                @08 BEGIN
                eSIFormSet.setCurrPageAction(eSIFormGet.getCurrPageAction());
                //                @08 END
                
                eSIFormSet.setMsgFieldChanged(eSIFormGet.getMsgFieldChanged());
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void resetForm(){
        setBookingNo(BLANK);
        setBlNo(BLANK);
        setBlNumber(BLANK);
        setBlType("T");
        //        setStatus(BLANK);
        setSiSubmittedBy(BLANK);
        setContact(BLANK);
        setEmail(BLANK);
        setAdditionalEmail(BLANK);
        setTelephone(BLANK);
        setFax(BLANK);
        setShipperCode(BLANK);
        setShipperName(BLANK);
        setShipperAddress1(BLANK);
        setShipperAddress2(BLANK);
        setShipperAddress3(BLANK);
        setShipperAddress4(BLANK);
        setConsigneeCode(BLANK);
        setConsigneeName(BLANK);
        setConsigneeAddress1(BLANK);
        setConsigneeAddress2(BLANK);
        setConsigneeAddress3(BLANK);
        setConsigneeAddress4(BLANK);
        setNotifyPartyCode(BLANK);
        setNotifyPartyName(BLANK);
        setNotifyPartyAddress1(BLANK);
        setNotifyPartyAddress2(BLANK);
        setNotifyPartyAddress3(BLANK);
        setNotifyPartyAddress4(BLANK);
        setVessel(BLANK);
        setVoyageNo(BLANK);
        setShippedOnBoardDate(BLANK);
        setPlaceDateOfIssue(BLANK);
        setPol(BLANK);
        setPod(BLANK);
        setPodCountry(BLANK);
        setPlaceOfReceipt(BLANK);
        setPlaceOfDelivery(BLANK);
        setNoOfOriginal(BLANK);
        setCommodity(BLANK);
        setContainerNo(BLANK);
        setContainerNoToCargo(BLANK);
//        setMarksAndNumbers(BLANK);
//        setDescription(BLANK);
        setRemarks(BLANK);
        setCocSoc(BLANK);
        setTextSeparate("@@@");
        setFlag(BLANK);
        setItemsDelete(BLANK);
        setMode(BLANK);
        setNotFound(Boolean.FALSE);
        setChoiceRad("1");
        setFsc(BLANK);
        setOpenAcknowledgement(Boolean.FALSE);
        setFlagItemsDelete(BLANK);
        setCargoDescriptionDetails(new ArrayList<EshippingCargoDescriptionMod>());
        setCargoDetails(null);
        setBlTypeValues(ComboBoxESIUtil.getBLTypeDDList());

        setErrMsg(BLANK);
        setSaveDraftIsSuccess(null);
        setSubmitIsSuccess(null);
        setFromPoup(BLANK);
        setIsDisabledSubmit(Boolean.TRUE);
        //--------------------------------- For e-Shipping Acknowledtment Poupup ---------------------------------
        setEmailAcknowledgment(BLANK);
        setVendorTelephone(BLANK);
        setVendorFax(BLANK);
        setVendorEmail(BLANK);
        setCommodityVoDataList(new ArrayList<EshippingCommodityDetailsMod>());
        setCommodityVoDataDelList(new ArrayList<EshippingCommodityDetailsMod>());
        //        setEsiErrMsg(BLANK);
        setStrCommodityForMark(BLANK);
        setCommoditySelectChkBox(BLANK);
        setIntEsiStatus(0);
        setBtnCommodityAddDisp(false);
        setBtnCommodityDelDisp(false);
        setPrevBookingNo(BLANK);
        setPrevESIForm(this);
        //        @07 BEGIN
        setEsiStatusCode(BLANK);
        setEsiStatusDesc(BLANK);
        setPrevEsiStatusCode(BLANK);
        setPrevEsiStatusDesc(BLANK);
        //        @07 END
        //       @08 BEGIN
        setCurrPageAction(BLANK);
        //       @08 END
    }

    public void setCommodityRowIndex(String commodityRowIndex) {
        this.commodityRowIndex = commodityRowIndex;
    }

    public String getCommodityRowIndex() {
        return commodityRowIndex;
    }

    public void setComSeqNoTemp(String comSeqNoTemp) {
        this.comSeqNoTemp = comSeqNoTemp;
    }

    public String getComSeqNoTemp() {
        return comSeqNoTemp;
    }

	public List<BlRevenueMod> getRevinue() {
		return revinue;
	}

	public void setRevinue(List<BlRevenueMod> revinue) {
		this.revinue = revinue;
	}

	public String getFromTerminal() {
		return fromTerminal;
	}

	public void setFromTerminal(String fromTerminal) {
		this.fromTerminal = fromTerminal;
	}

	public String getToTerminal() {
		return toTerminal;
	}

	public void setToTerminal(String toTerminal) {
		this.toTerminal = toTerminal;
	}

	public String getVesselEdi() {
		return vesselEdi;
	}

	public void setVesselEdi(String vesselEdi) {
		this.vesselEdi = vesselEdi;
	}

	public String getQuotation() {
		return quotation;
	}

	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}



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



	public String getPort1() {
		return port1;
	}



	public void setPort1(String port1) {
		this.port1 = port1;
	}



	public String getPort2() {
		return port2;
	}



	public void setPort2(String port2) {
		this.port2 = port2;
	}



	public String getPort3() {
		return port3;
	}



	public void setPort3(String port3) {
		this.port3 = port3;
	}

	
    
}

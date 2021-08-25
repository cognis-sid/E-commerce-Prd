/*------------------------------------------------------
EserviceNewWebBookingUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -
- Change Log -------------------------------------------
##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
1   01/08/2014  Pratya  @01         Eservice phase 3.1
2   24/10/2014  Pratya  @02         PD_CR_20140826_ESV [Contract Party for registeration]
3   27/10/2014  Pratya  @03         PD_CR_20141003_ESV [COC_SOC in eBKG]
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.PicMailMod;

import java.util.ArrayList;
import java.util.List;

public class EserviceNewWebBookingUim extends PaginationForm {
	
    private String currPageAction;
    private String prevPageAction;
    private String errMsg;
    
    private String userId;
    private String userFsc;

    private String orgCode;
    
    private String toPicMail="";
    private String ccPicMail="";
    private String bccPicMail="";
    
    private String shipper_Name_comm="";
    private String commodity_Mail="";
    private String hs_Code="";
    private String condition_Of_Container="";
    
    private String porTemp="";
    
    /**
     * This List will hold the array of Transfer objects(VO).
     * Used by JSP in <logic:iterate> tag of Search Result
     */
    private List        equipmentVoDataList            = new ArrayList();
    private List        commodityVoDataList            = new ArrayList();

    // ------------------------------------normal text box
    private String bookingNo;
    private String bookingRef;
    private String status;
    private String editSatus;
    private String customerReference;
    private String companyName;
    private String mailVolume;
    private String email;
    private String telephone;
    private String fax="";
    private String contact;
    private String emptyPickupDate;
    private String shipmentDate;
    private String desiredArrivalDate;
    private String from;
    private String to;
    private String etd;
    private String eta;
//    private String service;
    private String vesselName;
    private String vessel;
    private String voyage;
    private String loadingTerminalName;
    private String DischargeTerminalName;
    private String laden;
    private String mt;
    private String grossContainerWeight;
    private String polStatus = "L";//change from LOCAL
    private String podStatus = "L";//change from LOCAL
    private String cargoDescription;
    private String commodityGroup;
    private String grossWeight;
    //    private String specialCargo;
    private String specialInstruction;
    private String templateName;
    private String quotationNumber;
    private String shipmentTerm;
    private String originCountry;
    private String originCountryName;
    private String destinationCountry;
    private String destinationCountryName;
    private String placeOfReceipt;
    private String portOfLoading;
    private String polName;
    private String portOfDischarge;
    private String podNmae;
    private String placeOfDelivery;
    private String emptyPickupDepot;
    private String type;
    private String size;
    private String cargoType;
    private String routingPreference;
    private String additionalMailRecipeints;
    private String commodityGroupDetail;
    private String templateFlag;
    private String template;
    private String line;
    private String trade;
    private String agent;
    private String customerName;
    private String customerCode;
    private String equipmentSeq;
    private String commoditySeq;
    private String commodityRowIndex;    
    
    private String fromTerminal;
    private String fromTerminalDes;
    private String toTerminal;
    private String toTerminalDes;
    
    private String toLocation;
    
    private String vesselEtd;
    //------------------------------------ flag variables
    private String socCocUserFlag;
    private String saveOperationFlag;

    // ------------------------------------check box variables
    private String rclArrangementChkBox;
    private String equipmentSelectChkBox;
    private String specialCargoChkBox;
    private String commoditySelectChkBox;
    /*Begin @02*/
    private String              representCompChkBox;
    /*End @02*/
    // ------------------------------------radio button variables

    private String commodityRadio;
    // ------------------------------------combo variables
    private List quotationNumberValues;
    private List shipmentTermValues;
    private List originCountryValues;
    private List destinationCountryValues;
    private List placeOfReceiptValues;
    private List portOfLoadingValues;
    private List portOfDischargeValues;
    private List placeOfDeliveryValues;
    private List emptyPickupDepotValues;
    private List typeValues;
    private List sizeValues;
    private List cargoTypeValues;
    private List templateValues;
    private List representCompValues;//@02
    private List cocSocValues;//@03
    private List carogoTypeValues;
    
    /*Begin @01*/
    private List                rateTypeValues;
    private List				specialCargoValues;
    private EserviceUploadUim   eserviceUploadUim;
    private String              uploadFlag;
    private String              rfTypeNormal;
    /*End @01*/
    
    /*Begin @02*/
    private String              representComp;
    private String 				representCompName;
    /*End @02*/

    // ------------------------------------ flag open acknowledgement popup after on submit
    private Boolean openAcknowledgement;

    // ------------------------------------gettter and setter method for the text box

    
    // add parameter POL and POD
    private List podList;
    private List polList;
    private String pod;
    private String pol;
    
    // add status POL and POD
    private List podStatusList;
    private List polStatusList;
    //add 5/06/2013
    private String sailingDate;
    
    private String newWebBookingErrMsg;
    
    private String backFlag;
    
    private String deleleEqSizeType;
    private String deleteCommod;
    
    private String posObjectEqSizeType;
    private String posObjectCommod;
    
    private String commoditySeqNoTmp;
    private String equipmentSeqNoTmp;
    
    
    //------------ for show in quotation info popup --------------------
     private String originCountryShow;
     private String destinationCountryShow;
     private String portOfLoadingShow;
     private String portOfDischargeShow;
     private String polShow;
     private String podShow;
     private String shipmentType;
     private String msgTooltip;
     private String representedCompanyCheckValidation=""; 
     
     private List<EserviceNewWebBookingUim> quatationRoutingList;
     
     private String confirmRemarks="";
    // ------------------------------------default constructor
    public EserviceNewWebBookingUim() {
        this.userId             = null;
        this.userFsc            = null;
        
        this.resetForm();
    }
    
    public void resetForm(){
        setBackVisible              (true);
        setRefreshVisible           (false);
        setSaveVisible              (true);

        //------------- temp default values
        setRclArrangementChkBox     ("on");
        setSize                     ("20");
        setType                     ("GP");
        setCargoType                ("N");
        setLaden                    ("0");
        setMt                       ("0");
        setShipmentTerm             ("CYCY");
        setEquipmentSeq             ("1");
        setCommoditySeq             ("1");
        setPol                      ("CY");
        setPod                      ("CY");
        
        this.bookingNo                      = BLANK;
        this.quotationNumber                = BLANK;
        this.template                       = BLANK;
        this.status                         = "Open";
        this.customerReference              = BLANK;
        this.email                          = BLANK;
        this.telephone                      = BLANK;
        this.fax                            = "";
        this.contact                        = BLANK;
        this.additionalMailRecipeints       = BLANK;
        this.originCountry                  = BLANK;
        this.destinationCountry             = BLANK;
        this.placeOfReceipt                 = BLANK;
        this.portOfLoading                  = BLANK;
        this.portOfDischarge                = BLANK;
        this.placeOfDelivery                = BLANK;
        this.emptyPickupDepot               = BLANK;
        this.emptyPickupDate                = BLANK;
        this.shipmentDate                   = BLANK;
        this.sailingDate                    = BLANK;
        this.desiredArrivalDate             = BLANK;
        this.routingPreference              = BLANK;
        this.cargoDescription               = "Shipper Name : \r\n" + 
        		"Commodity :\r\n" + 
        		"HS Code : \r\n" + 
        		"Condition of Container (if any):\r\n" + 
        		"";
        
        this.deleleEqSizeType               = BLANK;
        this.deleteCommod                   = BLANK;
        this.posObjectEqSizeType            = BLANK;
        this.posObjectCommod                = BLANK;
        this.commoditySeqNoTmp              = "0";
        this.equipmentSeqNoTmp              = "0";
        
        setNewWebBookingErrMsg              ("");
        
        setQuatationRoutingList             (new ArrayList<EserviceNewWebBookingUim>());
        
        /*Begin @01*/
        this.eserviceUploadUim              = null;
        this.uploadFlag                     = "N";
        this.templateName                   = "";
        this.rfTypeNormal                   = "";
        /*End @01*/
        
        /*Begin @02*/
        this.representComp                  = "";
        this.representCompChkBox            = "N";
        this.representCompName				= "";
        /*End @02*/
        
    }
    
	public String getPorTemp() {
		return porTemp;
	}

	public void setPorTemp(String porTemp) {
		this.porTemp = porTemp;
	}

	public String getConfirmRemarks() {
		return confirmRemarks;
	}

	public void setConfirmRemarks(String confirmRemarks) {
		this.confirmRemarks = confirmRemarks;
	}

	public String getShipper_Name_comm() {
		return shipper_Name_comm;
	}

	public void setShipper_Name_comm(String shipper_Name_comm) {
		this.shipper_Name_comm = shipper_Name_comm;
	}

	public String getCommodity_Mail() {
		return commodity_Mail;
	}

	public void setCommodity_Mail(String commodity_Mail) {
		this.commodity_Mail = commodity_Mail;
	}

	public String getHs_Code() {
		return hs_Code;
	}

	public void setHs_Code(String hs_Code) {
		this.hs_Code = hs_Code;
	}

	public String getCondition_Of_Container() {
		return condition_Of_Container;
	}

	public void setCondition_Of_Container(String condition_Of_Container) {
		this.condition_Of_Container = condition_Of_Container;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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

	public String getEditSatus() {
		return editSatus;
	}

	public void setEditSatus(String editSatus) {
		this.editSatus = editSatus;
	}

	public String getRepresentedCompanyCheckValidation() {
		return representedCompanyCheckValidation;
	}

	public void setRepresentedCompanyCheckValidation(String representedCompanyCheckValidation) {
		this.representedCompanyCheckValidation = representedCompanyCheckValidation;
	}

	public List getCarogoTypeValues() {
		return carogoTypeValues;
	}

	public void setCarogoTypeValues(List carogoTypeValues) {
		this.carogoTypeValues = carogoTypeValues;
	}

	public String getTemplateFlag() {
		return templateFlag;
	}

	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

	public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setEmptyPickupDepot(String emptyPickupDepot) {
        this.emptyPickupDepot = emptyPickupDepot;
    }

    public String getEmptyPickupDepot() {
        return emptyPickupDepot;
    }

    public void setEmptyPickupDate(String emptyPickupDate) {
        this.emptyPickupDate = emptyPickupDate;
    }

    public String getEmptyPickupDate() {
        return emptyPickupDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setDesiredArrivalDate(String desiredArrivalDate) {
        this.desiredArrivalDate = desiredArrivalDate;
    }

    public String getDesiredArrivalDate() {
        return desiredArrivalDate;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getEtd() {
        return etd;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getEta() {
        return eta;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setLoadingTerminalName(String loadingTerminalName) {
        this.loadingTerminalName = loadingTerminalName;
    }

    public String getLoadingTerminalName() {
        return loadingTerminalName;
    }

    public void setDischargeTerminalName(String dischargeTerminalName) {
        this.DischargeTerminalName = dischargeTerminalName;
    }

    public String getDischargeTerminalName() {
        return DischargeTerminalName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setLaden(String laden) {
        this.laden = laden;
    }

    public String getLaden() {
        return laden;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getMt() {
         return mt;
    }

    public void setGrossContainerWeight(String grossContainerWeight) {
        this.grossContainerWeight = grossContainerWeight;
    }

    public String getGrossContainerWeight() {
        return grossContainerWeight;
        
    }

    public void setPolStatus(String polStatus) {
        this.polStatus = polStatus;
    }

    public String getPolStatus() {
        return polStatus;
    }

    public void setPodStatus(String podStatus) {
        this.podStatus = podStatus;
    }

    public String getPodStatus() {
        return podStatus;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCommodityGroup(String commodityGroup) {
        this.commodityGroup = commodityGroup;
    }

    public String getCommodityGroup() {
        return commodityGroup;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    //    public void setSpecialCargo(String specialCargo) {
    //        this.specialCargo = specialCargo;
    //    }
    //
    //    public String getSpecialCargo() {
    //        return specialCargo;
    //    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public String getQuotationNumber() {
        return quotationNumber;
    }


    public void setQuotationNumberValues(List quotationNumberValues) {
        this.quotationNumberValues = quotationNumberValues;
    }

    public List getQuotationNumberValues() {
        return quotationNumberValues;
    }

    public void setShipmentTerm(String shipmentTerm) {
        this.shipmentTerm = shipmentTerm;
    }

    public String getShipmentTerm() {
        return shipmentTerm;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setPlaceOfReceipt(String placeOfReceipt) {
        this.placeOfReceipt = placeOfReceipt;
    }

    public String getPlaceOfReceipt() {
        return placeOfReceipt;
    }

    public void setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    public String getPortOfLoading() {
        return portOfLoading;
    }

    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    public void setShipmentTermValues(List shipmentTermValues) {
        this.shipmentTermValues = shipmentTermValues;
    }

    public List getShipmentTermValues() {
        return shipmentTermValues;
    }

    public void setOriginCountryValues(List originCountryValues) {
        this.originCountryValues = originCountryValues;
    }

    public List getOriginCountryValues() {
        return originCountryValues;
    }

    public void setDestinationCountryValues(List destinationCountryValues) {
        this.destinationCountryValues = destinationCountryValues;
    }

    public List getDestinationCountryValues() {
        return destinationCountryValues;
    }

    public void setPlaceOfReceiptValues(List placeOfReceiptValues) {
        this.placeOfReceiptValues = placeOfReceiptValues;
    }

    public List getPlaceOfReceiptValues() {
        return placeOfReceiptValues;
    }

    public void setPortOfLoadingValues(List portOfLoadingValues) {
        this.portOfLoadingValues = portOfLoadingValues;
    }

    public List getPortOfLoadingValues() {
        return portOfLoadingValues;
    }

    public void setPortOfDischargeValues(List portOfDischargeValues) {
        this.portOfDischargeValues = portOfDischargeValues;
    }

    public List getPortOfDischargeValues() {
        return portOfDischargeValues;
    }

    public void setPlaceOfDeliveryValues(List placeOfDeliveryValues) {
        this.placeOfDeliveryValues = placeOfDeliveryValues;
    }

    public List getPlaceOfDeliveryValues() {
        return placeOfDeliveryValues;
    }

    public void setEmptyPickupDepotValues(List emptyPickupDepotValues) {
        this.emptyPickupDepotValues = emptyPickupDepotValues;
    }

    public List getEmptyPickupDepotValues() {
        return emptyPickupDepotValues;
    }

    public void setTypeValues(List typeValues) {
        this.typeValues = typeValues;
    }

    public List getTypeValues() {
        return typeValues;
    }


    public void setCargoTypeValues(List cargoTypeValues) {
        this.cargoTypeValues = cargoTypeValues;
    }

    public List getCargoTypeValues() {
        return cargoTypeValues;
    }

    public void setRoutingPreference(String routingPreference) {
        this.routingPreference = routingPreference;
    }

    public String getRoutingPreference() {
        return routingPreference;
    }

    public void setAdditionalMailRecipeints(String additionalMailRecipeints) {
        this.additionalMailRecipeints = additionalMailRecipeints;
    }

    public String getAdditionalMailRecipeints() {
        return additionalMailRecipeints;
    }

    public void setRclArrangementChkBox(String rclArrangementChkBox) {
        this.rclArrangementChkBox = rclArrangementChkBox;
    }

    public String getRclArrangementChkBox() {
        return rclArrangementChkBox;
    }

    public void setEquipmentSelectChkBox(String equipmentSelectChkBox) {
        this.equipmentSelectChkBox = equipmentSelectChkBox;
    }

    public String getEquipmentSelectChkBox() {
        return equipmentSelectChkBox;
    }

    public void setSpecialCargoChkBox(String specialCargoChkBox) {
        this.specialCargoChkBox = specialCargoChkBox;
    }

    public String getSpecialCargoChkBox() {
        return specialCargoChkBox;
    }

    public void setCommoditySelectChkBox(String commoditySelectChkBox) {
        this.commoditySelectChkBox = commoditySelectChkBox;
    }

    public String getCommoditySelectChkBox() {
        return commoditySelectChkBox;
    }

    public void setCommodityRadio(String commodityRadio) {
        this.commodityRadio = commodityRadio;
    }

    public String getCommodityRadio() {
        return commodityRadio;
    }

    public void setCommodityGroupDetail(String commodityGroupDetail) {
        this.commodityGroupDetail = commodityGroupDetail;
    }

    public String getCommodityGroupDetail() {
        return commodityGroupDetail;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplateValues(List templateValues) {
        this.templateValues = templateValues;
    }

    public List getTemplateValues() {
        return templateValues;
    }

    public void setSocCocUserFlag(String socCocUserFlag) {
        this.socCocUserFlag = socCocUserFlag;
    }

    public String getSocCocUserFlag() {
        return socCocUserFlag;
    }


    public void setSizeValues(List sizeValues) {
        this.sizeValues = sizeValues;
    }

    public List getSizeValues() {
        return sizeValues;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setSaveOperationFlag(String saveOperationFlag) {
        this.saveOperationFlag = saveOperationFlag;
    }

    public String getSaveOperationFlag() {
        return saveOperationFlag;
    }

    public void setOpenAcknowledgement(Boolean openAcknowledgement) {
        this.openAcknowledgement = openAcknowledgement;
    }

    public Boolean getOpenAcknowledgement() {
        return openAcknowledgement;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getTrade() {
        return trade;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgent() {
        return agent;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }
    public void setEquipmentSeq(String equipmentSeq) {
        this.equipmentSeq = equipmentSeq;
    }

    public String getEquipmentSeq() {
        return equipmentSeq;
    }

    public void setCommoditySeq(String commoditySeq) {
        this.commoditySeq = commoditySeq;
    }

    public String getCommoditySeq() {
        return commoditySeq;
    }
    /**
     * This function is called by the Struts to fetch a particular Transfer
     * object in the List. If not present, then a new Transfer object is created.
     * 
     * @param aintIndex int - Index value of Table Data
     * @return EserviceEquipmentDetailsMod DTO at given index
     */
    public EserviceEquipmentDetailsMod getEquipmentValue(int aintIndex) {
        if (aintIndex > equipmentVoDataList.size() - 1) {
            for (int i = equipmentVoDataList.size(); i <= aintIndex; i++) {
                //Create blank dto
                EserviceEquipmentDetailsMod eserviceEquipmentDetailsMod= 
                    new EserviceEquipmentDetailsMod();
                eserviceEquipmentDetailsMod.setEqSeqNo(aintIndex + 1);
                equipmentVoDataList.add(eserviceEquipmentDetailsMod);
            } //for loop ends
        } //if ends
        return (EserviceEquipmentDetailsMod)equipmentVoDataList.get(aintIndex);
    }


    public EserviceCommodityDetailsMod getCommodityValue(int aintIndex) {
        if (aintIndex > commodityVoDataList.size() - 1) {
            for (int i = commodityVoDataList.size(); i <= aintIndex; i++) {
                //Create blank dto
                EserviceCommodityDetailsMod eserviceCommodityDetailsMod= 
                    new EserviceCommodityDetailsMod();
                eserviceCommodityDetailsMod.setSeqNo(aintIndex + 1);
                commodityVoDataList.add(eserviceCommodityDetailsMod);
            } //for loop ends
        } //if ends
        return (EserviceCommodityDetailsMod)commodityVoDataList.get(aintIndex);
    }

    // ------------------------------------end of accessor methods


    public void setPodList(List podList) {
        this.podList = podList;
    }

    public List getPodList() {
        return podList;
    }

    public void setPolList(List polList) {
        this.polList = polList;
    }

    public List getPolList() {
        return polList;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getPol() {
        return pol;
    }
    public void setEquipmentVoDataList(List equipmentVoDataList) {
        this.equipmentVoDataList = equipmentVoDataList;
    }

    public List getEquipmentVoDataList() {
        return equipmentVoDataList;
    }

    public void setCommodityVoDataList(List commodityVoDataList) {
        this.commodityVoDataList = commodityVoDataList;
    }

    public List getCommodityVoDataList() {
        return commodityVoDataList;
    }

    public void setCommodityRowIndex(String commodityRowIndex) {
        this.commodityRowIndex = commodityRowIndex;
    }

    public String getCommodityRowIndex() {
        return commodityRowIndex;
    }

    public void setPodStatusList(List podStatusList) {
        this.podStatusList = podStatusList;
    }

    public List getPodStatusList() {
        return podStatusList;
    }

    public void setPolStatusList(List polStatusList) {
        this.polStatusList = polStatusList;
    }

    public List getPolStatusList() {
        return polStatusList;
    }

    public void setSailingDate(String sailingDate) {
        this.sailingDate = sailingDate;
    }

    public String getSailingDate() {
        return sailingDate;
    }

    public void setNewWebBookingErrMsg(String newWebBookingErrMsg) {
        this.newWebBookingErrMsg = newWebBookingErrMsg;
    }

    public String getNewWebBookingErrMsg() {
        return newWebBookingErrMsg;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setOriginCountryShow(String originCountryShow) {
        this.originCountryShow = originCountryShow;
    }

    public String getOriginCountryShow() {
        return originCountryShow;
    }

    public void setDestinationCountryShow(String destinationCountryShow) {
        this.destinationCountryShow = destinationCountryShow;
    }

    public String getDestinationCountryShow() {
        return destinationCountryShow;
    }

    public void setPortOfLoadingShow(String portOfLoadingShow) {
        this.portOfLoadingShow = portOfLoadingShow;
    }

    public String getPortOfLoadingShow() {
        return portOfLoadingShow;
    }

    public void setPortOfDischargeShow(String portOfDischargeShow) {
        this.portOfDischargeShow = portOfDischargeShow;
    }

    public String getPortOfDischargeShow() {
        return portOfDischargeShow;
    }

    public void setPolShow(String polShow) {
        this.polShow = polShow;
    }

    public String getPolShow() {
        return polShow;
    }

    public void setPodShow(String podShow) {
        this.podShow = podShow;
    }

    public String getPodShow() {
        return podShow;
    }

    public void setMsgTooltip(String msgTooltip) {
        this.msgTooltip = msgTooltip;
    }

    public String getMsgTooltip() {
        return msgTooltip;
    }

    public void setBackFlag(String backFlag) {
        this.backFlag = backFlag;
    }

    public String getBackFlag() {
        return backFlag;
    }

    public void setQuatationRoutingList(List<EserviceNewWebBookingUim> quatationRoutingList) {
        this.quatationRoutingList = quatationRoutingList;
    }

    public List<EserviceNewWebBookingUim> getQuatationRoutingList() {
        if(quatationRoutingList == null){
            quatationRoutingList = new ArrayList<EserviceNewWebBookingUim>();
        }
        return quatationRoutingList;
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

    public void setUserFsc(String userFsc){
        this.userFsc = userFsc;
    }

    public String getUserFsc(){
        return userFsc;
    }

    public void setDeleleEqSizeType(String deleleEqSizeType) {
        this.deleleEqSizeType = deleleEqSizeType;
    }

    public String getDeleleEqSizeType() {
        return deleleEqSizeType;
    }

    public void setDeleteCommod(String deleteCommod) {
        this.deleteCommod = deleteCommod;
    }

    public String getDeleteCommod() {
        return deleteCommod;
    }

    public void setPosObjectEqSizeType(String posObjectEqSizeType) {
        this.posObjectEqSizeType = posObjectEqSizeType;
    }

    public String getPosObjectEqSizeType() {
        return posObjectEqSizeType;
    }

    public void setPosObjectCommod(String posObjectCommod) {
        this.posObjectCommod = posObjectCommod;
    }

    public String getPosObjectCommod() {
        return posObjectCommod;
    }

    public void setCommoditySeqNoTmp(String commoditySeqNoTmp) {
        this.commoditySeqNoTmp = commoditySeqNoTmp;
    }

    public String getCommoditySeqNoTmp() {
        return commoditySeqNoTmp;
    }

    public List getSpecialCargoValues() {
		return specialCargoValues;
	}

	public void setSpecialCargoValues(List specialCargoValues) {
		this.specialCargoValues = specialCargoValues;
	}

	public void setRateTypeValues(List rateTypeValues) {
        this.rateTypeValues = rateTypeValues;
    }

    public List getRateTypeValues() {
        return rateTypeValues;
    }

    public void setEquipmentSeqNoTmp(String equipmentSeqNoTmp) {
        this.equipmentSeqNoTmp = equipmentSeqNoTmp;
    }

    public String getEquipmentSeqNoTmp() {
        return equipmentSeqNoTmp;
    }

    public void setEserviceUploadUim(EserviceUploadUim eserviceUploadUim) {
        this.eserviceUploadUim = eserviceUploadUim;
    }

    public EserviceUploadUim getEserviceUploadUim() {
        return eserviceUploadUim;
    }

    public void setUploadFlag(String uploadFlag) {
        this.uploadFlag = uploadFlag;
    }

    public String getUploadFlag() {
        return uploadFlag;
    }

    public void setRfTypeNormal(String rfTypeNormal) {
        this.rfTypeNormal = rfTypeNormal;
    }

    public String getRfTypeNormal() {
        return rfTypeNormal;
    }

    public String getRepresentCompName() {
		return representCompName;
	}

	public void setRepresentCompName(String representCompName) {
		this.representCompName = representCompName;
	}
    public void setRepresentCompValues(List representCompValues) {
        this.representCompValues = representCompValues;
    }

    public List getRepresentCompValues() {
        return representCompValues;
    }

    public void setRepresentComp(String representComp) {
        this.representComp = representComp;
    }

    public String getRepresentComp() {
        return representComp;
    }

    public void setRepresentCompChkBox(String representCompChkBox) {
        this.representCompChkBox = representCompChkBox;
    }

    public String getRepresentCompChkBox() {
        return representCompChkBox;
    }

    public void setCocSocValues(List cocSocValues) {
        this.cocSocValues = cocSocValues;
    }

    public List getCocSocValues() {
        return cocSocValues;
    }

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
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
	
	public String getMailVolume() {
		return mailVolume;
	}

	public void setMailVolume(String mailVolume) {
		this.mailVolume = mailVolume;
	}

	public String getVesselEtd() {
		return vesselEtd;
	}

	public void setVesselEtd(String vesselEtd) {
		this.vesselEtd = vesselEtd;
	}
	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getOriginCountryName() {
		return originCountryName;
	}

	public void setOriginCountryName(String originCountryName) {
		this.originCountryName = originCountryName;
	}

	public String getDestinationCountryName() {
		return destinationCountryName;
	}

	public void setDestinationCountryName(String destinationCountryName) {
		this.destinationCountryName = destinationCountryName;
	}

	public String getPolName() {
		return polName;
	}

	public void setPolName(String polName) {
		this.polName = polName;
	}

	public String getPodNmae() {
		return podNmae;
	}

	public void setPodNmae(String podNmae) {
		this.podNmae = podNmae;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	@Override
	public String toString() {
		return "EserviceNewWebBookingUim [currPageAction=" + currPageAction + ", prevPageAction=" + prevPageAction
				+ ", errMsg=" + errMsg + ", userId=" + userId + ", userFsc=" + userFsc + ", equipmentVoDataList="
				+ equipmentVoDataList + ", commodityVoDataList=" + commodityVoDataList + ", bookingNo=" + bookingNo
				+ ", bookingRef=" + bookingRef + ", status=" + status + ", customerReference=" + customerReference
				+ ", email=" + email + ", telephone=" + telephone + ", fax=" + fax + ", contact=" + contact
				+ ", emptyPickupDate=" + emptyPickupDate + ", shipmentDate=" + shipmentDate + ", desiredArrivalDate="
				+ desiredArrivalDate + ", from=" + from + ", to=" + to + ", etd=" + etd + ", eta=" + eta
				+ ", vesselName=" + vesselName + ", vessel=" + vessel + ", voyage=" + voyage + ", loadingTerminalName="
				+ loadingTerminalName + ", DischargeTerminalName=" + DischargeTerminalName + ", laden=" + laden
				+ ", mt=" + mt + ", grossContainerWeight=" + grossContainerWeight + ", polStatus=" + polStatus
				+ ", podStatus=" + podStatus + ", cargoDescription=" + cargoDescription + ", commodityGroup="
				+ commodityGroup + ", grossWeight=" + grossWeight + ", specialInstruction=" + specialInstruction
				+ ", templateName=" + templateName + ", quotationNumber=" + quotationNumber + ", shipmentTerm="
				+ shipmentTerm + ", originCountry=" + originCountry + ", destinationCountry=" + destinationCountry
				+ ", placeOfReceipt=" + placeOfReceipt + ", portOfLoading=" + portOfLoading + ", portOfDischarge="
				+ portOfDischarge + ", placeOfDelivery=" + placeOfDelivery + ", emptyPickupDepot=" + emptyPickupDepot
				+ ", type=" + type + ", size=" + size + ", cargoType=" + cargoType + ", routingPreference="
				+ routingPreference + ", additionalMailRecipeints=" + additionalMailRecipeints
				+ ", commodityGroupDetail=" + commodityGroupDetail + ", template=" + template + ", line=" + line
				+ ", trade=" + trade + ", agent=" + agent + ", customerName=" + customerName + ", customerCode="
				+ customerCode + ", equipmentSeq=" + equipmentSeq + ", commoditySeq=" + commoditySeq
				+ ", commodityRowIndex=" + commodityRowIndex + ", fromTerminal=" + fromTerminal + ", toTerminal="
				+ toTerminal + ", toLocation=" + toLocation + ", vesselEtd=" + vesselEtd + ", socCocUserFlag="
				+ socCocUserFlag + ", saveOperationFlag=" + saveOperationFlag + ", rclArrangementChkBox="
				+ rclArrangementChkBox + ", equipmentSelectChkBox=" + equipmentSelectChkBox + ", specialCargoChkBox="
				+ specialCargoChkBox + ", commoditySelectChkBox=" + commoditySelectChkBox + ", representCompChkBox="
				+ representCompChkBox + ", commodityRadio=" + commodityRadio + ", quotationNumberValues="
				+ quotationNumberValues + ", shipmentTermValues=" + shipmentTermValues + ", originCountryValues="
				+ originCountryValues + ", destinationCountryValues=" + destinationCountryValues
				+ ", placeOfReceiptValues=" + placeOfReceiptValues + ", portOfLoadingValues=" + portOfLoadingValues
				+ ", portOfDischargeValues=" + portOfDischargeValues + ", placeOfDeliveryValues="
				+ placeOfDeliveryValues + ", emptyPickupDepotValues=" + emptyPickupDepotValues + ", typeValues="
				+ typeValues + ", sizeValues=" + sizeValues + ", cargoTypeValues=" + cargoTypeValues
				+ ", templateValues=" + templateValues + ", representCompValues=" + representCompValues
				+ ", cocSocValues=" + cocSocValues + ", rateTypeValues=" + rateTypeValues + ", eserviceUploadUim="
				+ eserviceUploadUim + ", uploadFlag=" + uploadFlag + ", rfTypeNormal=" + rfTypeNormal
				+ ", representComp=" + representComp + ", openAcknowledgement=" + openAcknowledgement + ", podList="
				+ podList + ", polList=" + polList + ", pod=" + pod + ", pol=" + pol + ", podStatusList="
				+ podStatusList + ", polStatusList=" + polStatusList + ", sailingDate=" + sailingDate
				+ ", newWebBookingErrMsg=" + newWebBookingErrMsg + ", backFlag=" + backFlag + ", deleleEqSizeType="
				+ deleleEqSizeType + ", deleteCommod=" + deleteCommod + ", posObjectEqSizeType=" + posObjectEqSizeType
				+ ", posObjectCommod=" + posObjectCommod + ", commoditySeqNoTmp=" + commoditySeqNoTmp
				+ ", equipmentSeqNoTmp=" + equipmentSeqNoTmp + ", originCountryShow=" + originCountryShow
				+ ", destinationCountryShow=" + destinationCountryShow + ", portOfLoadingShow=" + portOfLoadingShow
				+ ", portOfDischargeShow=" + portOfDischargeShow + ", polShow=" + polShow + ", podShow=" + podShow
				+ ", shipmentType=" + shipmentType + ", msgTooltip=" + msgTooltip + ", quatationRoutingList="
				+ quatationRoutingList + "]";
	}

	
    
} // EserviceNewWebBookingUim

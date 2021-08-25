/**
* function called when screen load
*/

/*
-------------------------------------------------------------------------------------------------------------
EshippingInstruction.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author anurak 01/01/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 31/07/2013     TANA              01              add commodity in equipment detail
## 31/07/2013     TANA              02              add Error msg
## 05/08/2013     TANA              03              change logic when call Acknowledgement popup
## 05/08/2013     TANA              04              change step tab Shipper Name/Address , Consignee Name/Address , Notify Party Name/Address
## 22/08/2013     YOSSUN1           05              add commodity detail.
## 23/09/2013     YOSSUN1           06              check duplicate containerNo
## 17/10/2013     YOSSUN1           07              renovate all showButton(status), enableEquipment() and
                                                    enablePackagesKind(containerNo, bookingNo) function.
## 18 01/11/2013 Teerakan           18              in  case All status  The Report Should be call ESH_BKG_PRI Report
## 05/11/2013    YOSSUN1            09              add Loading message bar.
## 11/12/2013    YOSSUN1            10              add check wild card by default.
## 12/12/2013    YOSSUN1            11              change esi status value.
## 26/12/2013    YOSSUN1            12              add clearMsg function and checl total container grossweight with commodity grossweight
## 03/01/2014    YOSSUN1            13              Add check container no for coc Soc
## 20/01/2014    YOSSUN1            14              Add Check Mandatory when containerNo not empty.
## 10/09/2014    PRATYA             15              PD_CR_20140820_ESV [Description and Mark_No for ecah commodity] and change method add, update, delete for Commodity Details
## 23/08/2019	 Sarawut A.			16				Add method validate data change
## 26/08/2019	 Sarawut A.	    	17				Add method clear ESI data
## 27/08/2019	 Sarawut A.			18				Copy method validate data change before save & submit
-------------------------------------------------------------------------------------------------------------
*/
var error_code                          = 0;
var FLAG_DELETE                         = "delete";
var FLAG_BOOKING                        = "booking";
var BOOOKING_POPUP                      = "bookingPopup";
var CUSTOMER_POPUP                      = "customerPopup";
var PACKAGE_KIND_POPUP                  = "packageKindPopup";
var TEXT_SEPARATE                       = "|";
var marksAndNumbersData                 = '';
var CLASS_NAME_BUTTON                   = 'm-btn blue smallest rnd icn-only';
var CLASS_NAME_DISABLED_BUTTON          = 'm-btn smallest rnd icn-only disabled';

var EQUIPMENT_OF_PACKAGE                = 0;
var EQUIPMENT_PACKAGE_KIND              = 1;
var EQUIPMENT_GROSS_WEIGHT              = 2;
var EQUIPMENT_GROSS_MEASUREMENT         = 3;

var COMMODITY_OF_PACKAGE                = 0;
var COMMODITY_GROSS_WEIGHT              = 1;
var COMMODITY_GROSS_MEASUREMENT         = 2;

//var templateBookinNotFound = "Booking No \"{0}\" Data not found.";
//---------------- Variables for keep original data ----------------
var blChoiceOneTmp;
var blChoiceTwoTmp;
var blChoiceThreeTmp;
var blTypeTmp;
var contactTmp;
var telephoneTmp;
var faxTmp;
var additionalEmailTmp;
var shipperNameTmp;
var shipperAddress1Tmp;
var shipperAddress2Tmp;
var shipperAddress3Tmp;
var shipperAddress4Tmp;
var consigneeNameTmp;
var consigneeAddress1Tmp;
var consigneeAddress2Tmp;
var consigneeAddress3Tmp;
var consigneeAddress4Tmp;
var notifyPartyNameTmp;
var notifyPartyAddress1Tmp;
var notifyPartyAddress2Tmp;
var notifyPartyAddress3Tmp;
var notifyPartyAddress4Tmp;
var placeDateOfIssueTmp;
var polTmp;
var podTmp;
var placeOfReceiptTmp;
var placeOfDeliveryTmp;
var noOfOriginalTmp;
var remarksTmp;
//var marksAndNumbersTmp;
//var descriptionTmp;
var containerNoTmp;
//var containerTypeTmp;
var carrierSealTmp;
var shipperSealTmp;
var ofPackagesTmp;
var packagesKindTmp;
var grossContainerWeightTmp;
//var ladenMtTmp;
var grossCargoMeasurementTmp;
var equipmentSize = undefined;
//@06 BEGIN
var prevContainerNo = null;
//@06 END

function showMsgFromServer(obj, msg, msgType)
{
    if(null!=obj)
    {
        if('true'==obj.value)
        {
            showBarMessageNew(msg, msgType);
		    window.scrollTo(500, 0);
        }
    }
}


//@14 BEGIN
//==============================================================================
//ONLOAD PART --- START ######################################################
//==============================================================================
function onLoad(){
	$("#shippingModifier").removeClass();
	$("#shippingModifier").addClass("nav-item active")	;
//    var bookingNo                       = document.getElementsByName("bookingNo");
//    var errorMsg                        = document.getElementsByName("esiErrMsg");
    var bookingNo                       = document.getElementById("bookingNo");
    var errorMsg                        = document.getElementById("esiErrMsg");

    var isOpenAcknowledgementPopup      = document.getElementById("openAcknowledgement");
    var choiceRad                       = document.getElementById('choiceRad');
    var esiStatus                       = document.getElementById("esiStatusCode");
    var emailAcknowledgment             = document.getElementById("emailAcknowledgment");
    var vendorTelephone                 = document.getElementById("vendorTelephone");
    var vendorFax                       = document.getElementById("vendorFax");
    var vendorEmail                     = document.getElementById("vendorEmail");
    var blNo                            = document.getElementById("blNo");
    var cocSoc                          = document.getElementById("cocSoc");

    var saveDraftIsSuccess              = document.getElementById("saveDraftIsSuccess");
    var submitIsSuccess                 = document.getElementById("submitIsSuccess");
    var notFound                        = document.getElementById("notFound");
    var contact                         = document.getElementById("contact");
	
    var acknowledgeUrl                  = OPEN_ACKNOWLEDGEMENT;
    //var currentURL                      = document.URL;

    try{
	
        /*if (currentURL.indexOf("esiStatusCode") > -1){
            var esiSplit = currentURL.split("esiStatusCode=");
            var esiCode = esiSplit[1].substring(0,1);

            if(IN_PROGRESS_MODE==esiCode){
                keepOriginalData();
                document.getElementById("msgFieldChanged").value="";
            }
        }else if (currentURL.indexOf("serv006SubmitEsi") > -1){
            isOpenAcknowledgementPopup = 'true';
        }*/
debugger;
        if(!isNullObj(esiStatus)){
            displayBLTypeFromCallback(esiStatus.value);

            showButton(esiStatus.value);
//            alert("esiStatus "+esiStatus.value);
//            alert("IN_PROGRESS_MODE "+IN_PROGRESS_MODE);
            if(IN_PROGRESS_MODE==esiStatus.value||NEW_MODE==esiStatus.value){
                keepOriginalData();
            }
        }else{
            showButton('');
        }
        showMaskOnNumberField();

        showCargoButton();

        setReadonlyCargoDesc();
		debugger;
		
        if(!isNullObj(isOpenAcknowledgementPopup)){
			debugger;	
            if(isOpenAcknowledgementPopup.value == 'true'){
                isOpenAcknowledgementPopup.value = 'false';

                acknowledgeUrl +=  '?emailAcknowledgment=' + emailAcknowledgment.value;
                acknowledgeUrl += '&vendorTelephone=' + vendorTelephone.value;
                acknowledgeUrl += '&vendorFax=' + vendorFax.value;
                acknowledgeUrl += '&vendorEmail=' + vendorEmail.value;
//              acknowledgeUrl += '&bookingNo=' + bookingNo[0].value;
                acknowledgeUrl += '&bookingNo=' + bookingNo.value;
                acknowledgeUrl += '&blNo=' + blNo.value;
                acknowledgeUrl += '&cocSoc=' + cocSoc.value;

                

				bookingUrl = OPEN_SHIPPINGINQUIRY+'?bookingNo='+bookingNo.value;
				bookingUrl += '&esiStatusCode=S'
            	bookingUrl += '&bookingType=NORMAL';
            	bookingUrl += '&mode=select';

			//	document.forms[0].action = bookingUrl;
            // 	document.forms[0].submit();
			//openHelpList(acknowledgeUrl, 920, 370);
				
				
		var popMsg = 'Thanks you, e-Shipping Instruction had been submitted successfully!  \n\n'
        +'The acknowledgement for the same will be sent shortly  to the email: '+ vendorEmail.value +' and requested list of recipient email addresses.  \n'     
        +'Billing of lading for this booking shall be created as per your e-Shipping Instruction. \n\n'
		+'The carrier will send draft Bill of lading for your verification as soon as possible. \n'+ 
        '\n  Note:  The carrier reserves its full rights, and at any given time without prior notice, change the arrangement listed or make alternate arrangment or decline a booking.'
       
          swal("Message",popMsg,"info").then(function(){					
          	document.forms[0].action = bookingUrl;
            document.forms[0].submit();
			});
            }else{
	       onLoadEquipmentDetails();

        /*Begin @15*/
        //onLoadCargoDescriptionPopup();
        onLoadCargoDescriptionPopup(0);
        /*End @15*/

//        if(!isNullObj(errorMsg[0]) && !isNullObj(errorMsg[0].value) && !isBlank(errorMsg[0].value))
	debugger;
        if(!isNullObj(errorMsg) && !isNullObj(errorMsg.value) && !isBlank(errorMsg.value)){
            //alert(errorMsg[0].value);
			debugger;
            showBarMessageNew(errorMsg.value, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            errorMsg.value = "";
        }else if(!isNullObj(saveDraftIsSuccess)){
//            keepOriginalData();
            showMsgFromServer(saveDraftIsSuccess, "SI saved successfully! Click on Submit SI to submit it to RCL Documentation Department.", 0);
            saveDraftIsSuccess.value = 'false';
        }else if(!isNullObj(submitIsSuccess)){
            showMsgFromServer(submitIsSuccess, "Submit SI saved successfully!", 0);
            submitIsSuccess.value = 'false';
        }
			}
        }else{

        onLoadEquipmentDetails();

        /*Begin @15*/
        //onLoadCargoDescriptionPopup();
        onLoadCargoDescriptionPopup(0);
        /*End @15*/

//        if(!isNullObj(errorMsg[0]) && !isNullObj(errorMsg[0].value) && !isBlank(errorMsg[0].value))
	debugger;
        if(!isNullObj(errorMsg) && !isNullObj(errorMsg.value) && !isBlank(errorMsg.value)){
            //alert(errorMsg[0].value);
			debugger;
            showBarMessageNew(errorMsg.value, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            errorMsg.value = "";
        }else if(!isNullObj(saveDraftIsSuccess)){
//            keepOriginalData();
            showMsgFromServer(saveDraftIsSuccess, "SI saved successfully! Click on Submit SI to submit it to RCL Documentation Department.", 0);
            saveDraftIsSuccess.value = 'false';
        }else if(!isNullObj(submitIsSuccess)){
            showMsgFromServer(submitIsSuccess, "Submit SI saved successfully!", 0);
            submitIsSuccess.value = 'false';
        }
	  }
    }catch(err){
        handleJavaScriptError('onLoad', err, error_code);
    }
}

function onLoadEquipmentDetails(){
    var containerNo = document.getElementsByName('containerNo');

    var containerNoLength = 0;
    try{
        error_code = 1;
        if(!isNullObj(containerNo[0]) && !isNullObj(containerNo.length)){
            error_code = 2;
            containerNoLength = containerNo.length;
            error_code = 3;
            for(var countIndex=0; countIndex<containerNoLength; countIndex++){
                onChangeContainerNo(countIndex);

//                summaryForCommodity(countIndex, EQUIPMENT_OF_PACKAGE);
//                summaryForCommodity(countIndex, EQUIPMENT_GROSS_WEIGHT);
//                summaryForCommodity(countIndex, EQUIPMENT_GROSS_MEASUREMENT);
            }
        }
    }catch(err){
        handleJavaScriptError('onLoadEquipmentDetails', err, error_code);
    }
}
//==============================================================================
//ONLOAD PART --- END ######################################################
//==============================================================================
//==============================================================================
//VALIDATE PART --- START ######################################################
//==============================================================================
function validate(){
    var errorMsg = null;
    var isPassed = false;
    try{
        error_code = 1;
        if(validateShipmentDetails()){
            error_code = 2;
            if(validateContactDetails()){
                error_code = 3;
                if(validateRoutingDetails()){
                    error_code = 4;
                    if(validateCommodityDetails()){
                        error_code = 5;
                        if(validateEquipmentDetails()){
                            error_code = 6;
                           isPassed = true;
                        }
                    }
                }
            }
        }
    }catch(err){
        handleJavaScriptError('validate', err, error_code);
    }
    return isPassed;
}

function validateShipmentDetails(){
    var bookingNo = document.getElementsByName('bookingNo');
    var contact = document.getElementsByName('contact');

    var errorMsg = null;
    var isPassed = false;
    try{
        if(isNullObj(bookingNo[0]) || isNullObj(bookingNo[0].value) || isBlank(bookingNo[0].value)){
            bookingNo[0].focus();

            errorMsg = 'Please select \"Booking No\".';
        }else if(isNullObj(contact[0]) || isNullObj(contact[0].value) || isBlank(contact[0].value)){
            contact[0].focus();
            errorMsg = 'Please input value \"Contact\".';
        }else{
            isPassed = true;
        }
    }catch(err){
        errorMsg = err.message;
    }finally{
        if(!isPassed){
            showBarMessageNew(errorMsg, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
        }
    }
    return isPassed;
}

function validateContactDetails(){
    var shipperName = document.getElementsByName('shipperName');
    var shipperAddress1 = document.getElementsByName('shipperAddress1');
    var consigneeName = document.getElementsByName('consigneeName');
    var consigneeAddress1 = document.getElementsByName('consigneeAddress1');
    var notifyPartyName = document.getElementsByName('notifyPartyName');
    var notifyPartyAddress1 = document.getElementsByName('notifyPartyAddress1');

    var errorMsg = null;
    var isPassed = false;
    try{
        error_code = 1;
        if(isNullObj(shipperName[0]) || isNullObj(shipperName[0].value) || isBlank(shipperName[0].value)){
            error_code = 2;
            shipperName[0].focus();

            errorMsg = 'Please select \"Shipper Name\".';
        }else if(isNullObj(shipperAddress1[0]) || isNullObj(shipperAddress1[0].value) || isBlank(shipperAddress1[0].value)){
            error_code = 3;
            shipperAddress1[0].focus();
            errorMsg = 'Please input value \"Shipper Address\".';
        }else if(isNullObj(consigneeName[0]) || isNullObj(consigneeName[0].value) || isBlank(consigneeName[0].value)){
            error_code = 4;
            consigneeName[0].focus();

            errorMsg = 'Please select \"Consignee Name\".';
        }else if(isNullObj(consigneeAddress1[0]) || isNullObj(consigneeAddress1[0].value) || isBlank(consigneeAddress1[0].value)){
            error_code = 5;
            shipperAddress1[0].focus();
            errorMsg = 'Please input value \"Consignee Address\".';
        }else if(isNullObj(notifyPartyName[0]) || isNullObj(notifyPartyName[0].value) || isBlank(notifyPartyName[0].value)){
            error_code = 6;
            shipperName[0].focus();

            errorMsg = 'Please select \"Notify Party Name\".';
        }else if(isNullObj(notifyPartyAddress1[0]) || isNullObj(notifyPartyAddress1[0].value) || isBlank(notifyPartyAddress1[0].value)){
            error_code = 7;
            notifyPartyAddress1[0].focus();

            errorMsg = 'Please input value \"Notify Party Address\".';
        }else{
            isPassed = true;
        }
        error_code = 8;
    }catch(err){
        errorMsg = err.message;
        handleJavaScriptError('validateContactDetails', err, error_code);
    }finally{
        if(!isPassed){
            showBarMessageNew(errorMsg, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
        }
    }
    return isPassed;
}

function validateRoutingDetails(){
    var portOfLoading = document.getElementsByName('pol');
    var portOfDischarge = document.getElementsByName('pod');
    var placeOfReceipt = document.getElementsByName('placeOfReceipt');
    var placeOfDelivery = document.getElementsByName('placeOfDelivery');

    var errorMsg = null;
    var isPassed = false;
    try{
        if(isNullObj(portOfLoading[0]) || isNullObj(portOfLoading[0].value) || isBlank(portOfLoading[0].value)){
            portOfLoading[0].focus();

            errorMsg = 'Please select \"Port of Loading(POL)\".';
        }else if(isNullObj(portOfDischarge[0]) || isNullObj(portOfDischarge[0].value) || isBlank(portOfDischarge[0].value)){
            portOfDischarge[0].focus();
            errorMsg = 'Please input value \"Port of Discharge(POD)\".';
        }else
        if(isNullObj(placeOfReceipt[0]) || isNullObj(placeOfReceipt[0].value) || isBlank(placeOfReceipt[0].value)){
            placeOfReceipt[0].focus();

            errorMsg = 'Please select \"Place of Receipt\".';
        }else if(isNullObj(placeOfDelivery[0]) || isNullObj(placeOfDelivery[0].value) || isBlank(placeOfDelivery[0].value)){
            placeOfDelivery[0].focus();

            errorMsg = 'Please input value \"Place of Delivery\".';
        }else{
            isPassed = true;
        }
    }catch(err){
        errorMsg = err.message;
    }finally{
        if(!isPassed){
            showBarMessageNew(errorMsg, MSG_ERROR_CODE);
			window.scrollTo(500, 0);	
        }
    }
    return isPassed;
}

/*Begin @15*/
function validateCommodityDetails(){
	debugger;
    var isPassed                    = true;
    var la_strCommGroup             = document.getElementsByName("strCommGroup");
	var la_strCommMeasurement		= document.getElementsByName("strCommMeasurement");
	var la_strCommWeight		= document.getElementsByName("strCommWeight");	
    try{
        for(var i=0;i<la_strCommGroup.length;i++){
            if(gp_trim(la_strCommGroup[i].value)==""){
                showBarMessageNew(ESR_SE0036, MSG_ERROR_CODE, new Array("HS Code"));
				window.scrollTo(500, 0);
                isPassed = false;
                break;
            }
debugger;
			if(checkCommMeasurement(la_strCommMeasurement[i].value)){
				showBarMessageNew("Please specify valid Gross Cargo Measurement in Commodity Details");
				window.scrollTo(500, 0);
                isPassed = false;
                break;
			}
			if(checkCommMeasurement(la_strCommWeight[i].value)){
				showBarMessageNew("Please specify valid Gross Weight in Commodity Details");
				window.scrollTo(500, 0);
                isPassed = false;
                break;
			}
        }
    }catch(err){
        handleJavaScriptError('validateCommodityDetails', err, error_code);
        isPassed = false;
    }

    return isPassed;
}
/*End @15*/

function validateEquipmentDetails(){
	debugger;
    var containerNo             = document.getElementsByName('containerNo');
    var ofPackages              = document.getElementsByName('ofPackages');
    var packagesKindCode        = document.getElementsByName('packagesKindCode');
    var packagesKindName        = document.getElementsByName('packagesKind');
    var grossContainerWeight    = document.getElementsByName('grossContainerWeight');
    var commodityWeight         = document.getElementsByName('strCommWeight');
	var lo_grossCargoMeasurement         = document.getElementsByName('grossCargoMeasurement');
	var lo_grossContainerWeight         = document.getElementsByName('grossContainerWeight');
    var containerLength         = 0;
    var containerNoVal          = null;
    var ofPackagesVal           = null;
    var packagesKindCodeVal     = null;
    var grossContainerWeightVal = null;
    var grossWeightValue		= null;
    var commodityWeightVal      = null;
    var totalCommodityWeight    = 0.00;
    var totalGrossWeight        = 0.00;
    var obj                     = null;
    var objVal                  = null;
    var head                    = null;
    var detail                  = null;
    var errorMsg                = null;
    var isPassed                = true;
	containerArray 				= [];
    try{
        error_code = 1;
        if(!isNullObj(commodityWeight)){
            for(var currRow=0, totalRow=commodityWeight.length; currRow<totalRow; currRow++){
                commodityWeightVal = commodityWeight[currRow].value;
                if(!isNullObj(commodityWeightVal) && !isBlank(commodityWeightVal)){
                    commodityWeightVal = commodityWeightVal.replace(',','');
                    totalCommodityWeight += parseFloat(commodityWeightVal);
                }
            }
        }
		if(totalCommodityWeight==0)
			{
				isPassed = false;
                showBarMessageNew('Commodity Weaight should not be Zero.');
				window.scrollTo(500, 0);
				return isPassed;
			}else{
				for(var grCount=0; grCount<grossContainerWeight.length; grCount++){
					grossWeightValue = grossContainerWeight[grCount].value;
	                if(!isNullObj(grossWeightValue) && !isBlank(grossWeightValue)){
	                    grossWeightValue = grossWeightValue.replace(',','');
	                    totalGrossWeight += parseFloat(grossWeightValue);
	                }
				}
				if(Math.floor(totalCommodityWeight)!=Math.floor(totalGrossWeight)){
					isPassed = false;
                	showBarMessageNew('Commodity Weight and Container Weight Should be same.');
					window.scrollTo(500, 0);
					return isPassed;
				}
			}
        error_code = 2;
		debugger;
        if(!isNullObj(containerNo) && !isNullObj(containerNo.length)){
            containerLength = containerNo.length;
            error_code = 3;
            if(containerLength > 0){
                error_code = 4;
                for(var countIndex=0; countIndex<containerLength; countIndex++){
                    if(!isBlank(containerNo[countIndex].value)){
                        if(validateContainerNoFormat(containerNo, countIndex)){
                            ofPackagesVal = ofPackages[countIndex].value;
                            packagesKindCodeVal = packagesKindCode[countIndex].value;
                            grossContainerWeightVal = grossContainerWeight[countIndex].value;
                            commodityWeightVal = null;
                            if(isNullObj(ofPackagesVal) || isBlank(ofPackagesVal) || ofPackagesVal == '0'){
                                errorMsg = 'Please specific equipment ofPackages at row '+(countIndex+1)+'.';
                                ofPackages[countIndex].focus();

                                isPassed = false;
                                break;
                            }else if(isNullObj(packagesKindCodeVal) || isBlank(packagesKindCodeVal) || 'null' == packagesKindCodeVal){
                                errorMsg = 'Please specific equipment Packages Kind at row '+(countIndex+1)+'.';
                                packagesKindName[countIndex].focus();

                                isPassed = false;
                                break;
                            }else if(isNullObj(grossContainerWeightVal) || isBlank(grossContainerWeightVal) || grossContainerWeightVal == '0.0000'){
                                errorMsg = 'Please specific equipment Gross Container Weight at row '+(countIndex+1)+'.';
                                grossContainerWeight[countIndex].focus();

                                isPassed = false;
                                break;
                            }
						containerArray.push(containerNo[countIndex].value);		
                        }else{
                            isPassed = false;
                            break;
                        }
                    }else{
						isPassed = false;
						showBarMessageNew('Container number should not be Blank.');
						window.scrollTo(500, 0);
						break;
					}
                    //@03 END
                }
				if(hasDuplicates(containerArray)){
					debugger;
					isPassed = false;
				}
                if(!isNullObj(errorMsg) && !isBlank(errorMsg)){
                    showBarMessageNew(errorMsg, MSG_ERROR_CODE);
					window.scrollTo(500, 0);
                }
            }else{
                isPassed = false;
                showBarMessageNew('Incorrect container number format.', MSG_ERROR_CODE);
				window.scrollTo(500, 0);
            }
debugger;
		if(!isNullObj(lo_grossCargoMeasurement) && !isNullObj(lo_grossCargoMeasurement.length)){
				for(var countIndex=0; countIndex<lo_grossCargoMeasurement.length; countIndex++){
					if(checkCommMeasurement(lo_grossCargoMeasurement[countIndex].value)){
						showBarMessageNew("Please specify valid Gross Cargo Measurement in Equipment Details");
						window.scrollTo(500, 0);
		                isPassed = false;
		                break;
					}
				}
			}
			
			if(!isNullObj(lo_grossContainerWeight) && !isNullObj(lo_grossContainerWeight.length)){
				for(var countIndex=0; countIndex<lo_grossContainerWeight.length; countIndex++){
					if(checkCommMeasurement(lo_grossContainerWeight[countIndex].value)){
						showBarMessageNew("Please specify valid Gross Weight in Equipment Details");
						window.scrollTo(500, 0);
		                isPassed = false;
		                break;
					}
				}
			}
			
        }else{
            showBarMessageNew('Not found container no.', MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            isPassed = false;
        }
    }catch(err){
        handleJavaScriptError('validateEquipmentDetails', err, error_code);
        isPassed = false;
    }
 
    return isPassed;
}

function validateContainerNoFormat(containerNo, countIndex){
    var containerNoVal = null;
    var head = null;
    var detail = null;
    var isPassed = false;
    var isError = false;
    try{
        if(!isNullObj(containerNo) && !isNullObj(containerNo.length)){
            containerNoVal = containerNo[countIndex].value;
//            alert('validateContainerNoFormat: containerNoVal = '+containerNoVal);
            if(!isBlank(containerNoVal)){
                error_code = 1;
                head = containerNoVal.substring(0,4);
                error_code = 2;
                detail = containerNoVal.substring(4);
                error_code = 3;
                if(!isError && (containerNoVal.length != 11)){
                    error_code = 31;
                    isError = true;
                }else if(!isError && !isNaN(head.substring(0,1))){
                    error_code = 32;
                    isError = true;
                }else if(!isError && !isNaN(head.substring(1,2))){
                    error_code = 33;
                    isError = true;
                }else if(!isError && !isNaN(head.substring(2,3))){
                    error_code = 34;
                    isError = true;
                }else if(!isError && !isNaN(head.substring(3,4))){
                    error_code = 35;
                    isError = true;
                }else if(!isError && isNaN(detail)){
                    error_code = 36;
                    isError = true;
                }
            }
        }
        error_code = 4;
        if(isError){
            errorMsg = "Please input valid container no. at row "+(countIndex+1);

            showBarMessageNew(errorMsg, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            containerNo[countIndex].focus();
        }else{
            isPassed = true;
        }
    }catch(err){
        handleJavaScriptError('validateContainerNoFormat', err, error_code);
    }
    return isPassed;
}
//==============================================================================
//VALIDATE PART --- END ########################################################
//==============================================================================
//==============================================================================
//EVENT PART --- START #########################################################
//==============================================================================
function onChangeContainerNo(containerNoIndex){
    var containerNo = document.getElementsByName('containerNo');
    var ofPackages = document.getElementsByName('ofPackages');
    var packagesKindName = document.getElementsByName('packagesKind');
    var grossContainerWeight = document.getElementsByName('grossContainerWeight');

    var containerNoVal = null;
    var requireClass = '';

    var isError = false;
    try{
        error_code = 1;

        if(!isNullObj(containerNo) && !isNullObj(containerNo.length)){
            if(!isNullObj(containerNo[containerNoIndex]) && !isBlank(containerNo[containerNoIndex].value)){
                if(validateContainerNoFormat(containerNo, containerNoIndex)){
                    isError = checkDuplicateContainerNo(containerNoIndex);
                }
            }else{
                isError = true;
            }
        }
        if(isError){
            containerNo[containerNoIndex].value = '';
        } 
    }catch(err){
        containerNo[containerNoIndex].value = '';
        requestClass = '';
        handleJavaScriptError('onChangeContainerNo', err, error_code);
    }finally{
        ofPackages = ofPackages[containerNoIndex];
        //ofPackages.className = requireClass;
        packagesKindName = packagesKindName[containerNoIndex];
        //packagesKindName.className = requireClass;
        grossContainerWeight = grossContainerWeight[containerNoIndex];
        //grossContainerWeight.className = requireClass;
    }
}

function onClickCopyEquipmentField(fieldName, fieldIndex){
    var containerNo = document.getElementsByName('containerNo');

    var fieldCode = null;
    var fieldDesc = null;
    var objAllCode = null;
    var objAllDesc = null;
    var objCopyCode = null;
    var objCopyDesc = null;

    var hasCopyDesc = false;
    var isCheckPackageKind = false;
    try{
        error_code = 1;
        clearMsg();
        error_code = 2;
        if(EQUIPMENT_PACKAGE_KIND == fieldName){
            error_code = 3;
            objAllCode = document.getElementsByName('packagesKindCode');
            objAllDesc = document.getElementsByName('packagesKind');

            hasCopyDesc = true;

            objCopyDesc = objAllDesc[fieldIndex].value;

            isCheckPackageKind = true;
        }else{
            error_code = 4;
            if(EQUIPMENT_OF_PACKAGE == fieldName){
                objAllCode = document.getElementsByName('ofPackages');
            }else if(EQUIPMENT_GROSS_WEIGHT == fieldName){
                objAllCode = document.getElementsByName('grossContainerWeight');
            }else if(EQUIPMENT_GROSS_MEASUREMENT == fieldName){
                objAllCode = document.getElementsByName('grossCargoMeasurement');
            }
        }
        error_code = 5;
        if(!isNullObj(objAllCode) && !isNullObj(objAllCode.length)){
            error_code = 6;
            objCopyCode = objAllCode[fieldIndex].value;
            for(var countIndex=0,length=objAllCode.length; countIndex<length; countIndex++){
                if(countIndex != fieldIndex){
                    if(!isNullObj(objAllCode[countIndex])){
                        objAllCode[countIndex].value = objCopyCode;
                    }
                    if(hasCopyDesc){
                        objAllDesc[countIndex].value = objCopyDesc;
                    }
                }
            }
            error_code = 7;
        }
    }catch(err){
        handleJavaScriptError('onClickCopyEquipmentField', err, error_code);
    }finally{
        onChangeEquipmentToCommodity(isCheckPackageKind);
    }
}

function onChangeEquipmentToCommodity(isCheckPackageKind){
    var commodity                       = document.getElementsByName('strCommCode');
    var commPackageKindCode             = document.getElementsByName('strCommPackageKindCode');
    var commPackageKindName             = document.getElementsByName('strCommPackageKindName');
    var commOfPackage                   = document.getElementsByName('strCommOfPackages');
    var commGrossWeight                 = document.getElementsByName('strCommWeight');
    var commGrossMeasurement            = document.getElementsByName('strCommMeasurement');

    var equipmentCommodity              = document.getElementsByName('commodity');
    var equipmentPackageKindCode        = document.getElementsByName('packagesKindCode');
    var equipmentPackageKindName        = document.getElementsByName('packagesKind');
    var equipmentOfPackage              = document.getElementsByName('ofPackages');
    var equipmentGrossWeight            = document.getElementsByName('grossContainerWeight');
    var equipmentGrossMeasurement       = document.getElementsByName('grossCargoMeasurement');

    var commoditySelected               = null;
    var equipmentCommoditySelected      = null;

    var commodityLength                 = 0;
    var equipmentCommodityLength        = 0;

    var packageKindCode                 = null;
    var packageKindName                 = null;
    var ofPackage                       = null;
    var grossWeight                     = null;
    var grossMeasurement                = null;

    var totalOfPackage                  = 0;
    var totalGrossWeight                = 0.0;
    var totalGrossMeasurement           = 0.0;
    var isDiffPackage                   = false;
    var isFirstRow                      = true;

    var regExp = new RegExp(",","g");
    try{
        error_code = 1;

        if(!isNullObj(commodity) && !isNullObj(commodity.length)){

            error_code = 2;
            commodityLength             = commodity.length;
            error_code = 3;
            equipmentCommodityLength    = equipmentCommodity.length;

            for(var countIndex=0; countIndex<commodityLength; countIndex++){
                isDiffPackage           = false;
                isFirstRow              = true;

                totalOfPackage          = 0;
                totalGrossWeight        = 0.0;
                totalGrossMeasurement   = 0.0;

                packageKindCode         = BLANK;
                packageKindName         = BLANK;

                commoditySelected       = commodity[countIndex].value;

                for(var countIndex2 = 0; countIndex2<equipmentCommodityLength; countIndex2++){
                    equipmentCommoditySelected = equipmentCommodity[countIndex2].value;
                    if(commoditySelected == equipmentCommoditySelected){
                        error_code = 4;
                        ofPackage = (equipmentOfPackage[countIndex2].value).replace(regExp, '');

                        error_code = 5;
                        totalOfPackage += parseInt(ofPackage);

                        error_code = 6;
                        grossWeight = (equipmentGrossWeight[countIndex2].value).replace(regExp, '');
                        error_code = 7;
                        totalGrossWeight += parseFloat(grossWeight);

                        error_code = 8;
                        grossMeasurement = (equipmentGrossMeasurement[countIndex2].value).replace(regExp, '');
                        error_code = 9;
                        totalGrossMeasurement += parseFloat(grossMeasurement);
                        error_code = 10;
                        if(isCheckPackageKind && !isNullObj(equipmentPackageKindCode[countIndex2].value) && !isBlank(equipmentPackageKindCode[countIndex2].value)){
                            if(isFirstRow){
                                error_code = 11;
                                packageKindCode = equipmentPackageKindCode[countIndex2].value;
                                packageKindName = equipmentPackageKindName[countIndex2].value;
                                isFirstRow      = false;
                            }else{
                                error_code = 12;
                                if(!isDiffPackage){
                                    if(!isNullObj(equipmentPackageKindCode[countIndex2].value) &&
                                        !isBlank(equipmentPackageKindCode[countIndex2].value)){
                                        error_code = 13;
                                        if(packageKindCode != equipmentPackageKindCode[countIndex2].value){
                                            error_code = 14;
                                            isDiffPackage = true;
                                        }
                                    }
                                }
                            }
                            //alert('Commodity = '+countIndex+' : Commodity Code = '+commoditySelected+
                            //'\nEq Commodity = '+countIndex2+' : Commodity Code = '+equipmentCommoditySelected+
                            //'\ncommoditySelected = '+commoditySelected+
                            //'\nequipmentCommoditySelected = '+equipmentCommoditySelected+
                            //'\nPrevious PackageKindCode = '+packageKindCode+
                            //'\nisDiffPackage = '+isDiffPackage);
                        }
                    }
                }
                error_code = 15;
                commOfPackage[countIndex].value = totalOfPackage;
                maskWithOutDecimal(commOfPackage[countIndex], 6, 2);
                error_code = 16;
                commGrossWeight[countIndex].value = totalGrossWeight.toFixed(3);
                putMask_NumberEX(commGrossWeight[countIndex], 15, 3);
                error_code = 17;
                commGrossMeasurement[countIndex].value = totalGrossMeasurement.toFixed(4);
                putMask_NumberEX(commGrossMeasurement[countIndex], 14, 4);
                error_code = 18;
                if(isCheckPackageKind){
                    if(isDiffPackage){
                        error_code = 19;
                        packageKindCode = 'PK';
                        packageKindName = 'Package';
                    }
                    error_code = 20;
                    commPackageKindCode[countIndex].value = packageKindCode;
                    error_code = 21;
                    commPackageKindName[countIndex].value = packageKindName;
                    error_code = 22;
                }
            }
        }
    }catch(err){
        handleJavaScriptError('onChangeEquipmentToCommodity', err, error_code);
    }
}

/*Begin @15*/
function addCommodity() {
    var lo_deleteCommBtn                    = document.getElementById("deleteCommTd");
    var lo_addCommBtn                       = document.getElementById("addCommBtn");
    var lo_commTable                        = document.getElementById("comm_result_dtl");
    var lo_commodityCode                    = document.getElementsByName('strCommCode');
    var lo_comSeqNoTemp                     = document.getElementById("comSeqNoTemp");
    var lv_maxSeq                           = parseInt(lo_comSeqNoTemp.value) + 1;
    var rowIndex                            = lo_commTable.rows.length;
    var newNodeTr 	                    = null;
    var newNodeTd1 			    = null;
    var newNodeTd2 			    = null;
    var newNodeTd3 			    = null;
    var newNodeTd4 			    = null;
    var newNodeTd5 			    = null;
    var newNodeTd6 			    = null;
    var newNodeTd7 			    = null;
    var newNodeTd8 			    = null;
    var newNodeTd9 			    = null;
    var newNodeTd10 			    = null;
    var namestrCommPackageKindCode          = "strCommPackageKindCode";
    var namestrCommPackageKindName          = "strCommPackageKindName";

    try{
        setCargoDetailsAllData();

        if(rowIndex > 1)lo_deleteCommBtn.style.display = "inline";

        //lo_commTable.childNodes[0].appendChild(newNodeTr);

        var postVal     = "newSeq=" + lv_maxSeq;
        $.ajax({
            type: "POST",
            url: ADD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessageNew(MSG_LOADING, 2),
            success: function(data){
                if(gp_trim(data)=="OK"){

                    newNodeTr       = lo_commTable.insertRow(rowIndex);
                    newNodeTd1      = newNodeTr.insertCell(0);
                    newNodeTd2      = newNodeTr.insertCell(1);
                    newNodeTd3      = newNodeTr.insertCell(2);
                    newNodeTd4      = newNodeTr.insertCell(3);
                    newNodeTd5      = newNodeTr.insertCell(4);
                    newNodeTd6      = newNodeTr.insertCell(5);
                    newNodeTd7      = newNodeTr.insertCell(6);
                    newNodeTd8      = newNodeTr.insertCell(7);
                    newNodeTd9      = newNodeTr.insertCell(8);
                    newNodeTd10     = newNodeTr.insertCell(9);

                    newNodeTr.style.height 	    = "25px";

                    //#
                    newNodeTd1.className        = 'tableColumnData';
                    newNodeTd1.innerHTML        = rowIndex;

                    //Commodity Group
                    newNodeTd2.className        = 'tableColumnData';
                    newNodeTd2.innerHTML        = '<input type="hidden" name="intCommGroupSeqNo"        value="0" />'
                                                + '<input type="hidden" name="strCommGroupCode"         value="" />'
                                                + '<input type="hidden" name="recordStatus"             value="ADD"  />'
                                                + '<input type="hidden" name="strCommPackageKindCode"   value="0" />'
                                                /*Begin @15*/
                                                + '<input type="hidden" name="marksAndNumbers"          value="" />'
                                                + '<input type="hidden" name="description"              value="" />'
                                                + '<input type="hidden" name="comBookingNo"             value="" />'
                                                + '<input type="hidden" name="strCommodityForMark"      value="" />'
                                                + '<input type="hidden" name="containerNoToCargo"       value="" />'
                                                + '<input type="hidden" name="comSeqNo"                 value="' + lv_maxSeq + '" />'
                                                /*End @15*/
                                                + '<input   type="text"'
                                                + '            style="width:75%"'
                                                + '            name="strCommGroup"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            readonly="readonly" />';

                    //HS Code
                    newNodeTd3.className        = 'tableColumnData';
                    newNodeTd3.innerHTML        = '<input   type="text"'
                                                + '            style="width:75%"'
                                                + '            name="strCommCode"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="must"'
                                                + '            readonly="readonly" /> '
                                                + '<a name="btnCommodityGroupLookup" class="m-btn smallest blue rnd smallericn-only" '
                                                + 'href="javascript:void(0)" onclick="openCommodityGroupLookup(this, 0, \'\');">'
                                                + ' <i class="icon-search icon-white"></i>';
                                                + '</a>';

                    //Commodity Description
                    newNodeTd4.className        = 'tableColumnData';
                    newNodeTd4.innerHTML        = '<input   type="text"'
                                                + '            style="width:75%"'
                                                + '            name="strCommDesc"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            readonly="readonly" />&nbsp;';

                    //# of Packages
                    newNodeTd5.className        = 'tableColumnData';
                    newNodeTd5.innerHTML        = '<input   type="text"'
                                                + '            name="strCommOfPackages"'
                                                + '            style="width:70%"'
                                                + '            value="0"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            readonly="readonly" />';

                    //Package Kind
                    newNodeTd6.className        = 'tableColumnData';
                    newNodeTd6.innerHTML        = '<input   type="text"'
                                                + '            style="width:66%"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            name="strCommPackageKindName" '
                                                + '            readonly="readonly" />&nbsp;'
                                                + '<a name="btnBrowseCommPackageKind" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" '
                                                + 'onclick="openPackageKind(this, \'strCommPackageKindCode\', \'strCommPackageKindName\' '
                                                + ', \'' + PACKAGE_KIND_TYPE_COMMODITY + '\');">'
                                                + '<i class="icon-search icon-white"></i>'
                                                + '</a>';

                    //Gross Weight
                    newNodeTd7.className        = 'tableColumnData';
                    newNodeTd7.innerHTML        = '<input   type="text"'
                                                + '            name="strCommWeight"'
                                                + '            style="width:66%"'
                                                + '            value="0.000"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            readonly="readonly" />';

                    //Gross Cargo Measurement (CBM)
                    newNodeTd8.className        = 'tableColumnData';
                    newNodeTd8.innerHTML        = '<input   type="text"'
                                                + '            name="strCommMeasurement"'
                                                + '            style="width:66%"'
                                                + '            value="0.0000"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            readonly="readonly" />';

                    //Marks/Desc
                    newNodeTd9.className        = 'tableColumnData';
                    newNodeTd9.innerHTML        = '<a name="btnCargoDetails" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" '
                                                + 'onclick="openCargoDescription(this)"><i class="icon-plus icon-white"></i></a>';

                    //Select
                    newNodeTd10.className        = 'tableColumnData';
                    newNodeTd10.innerHTML        = '<input type="checkbox" name="isSelected" style="border:0px; width:15px; height: 15px" />';

                    lo_comSeqNoTemp.value = lv_maxSeq;

                    showBarMessageNew(MSG_NORMAL, 2);
                }else{
                    showBarMessageNew(data, MSG_ERROR_CODE);
                }
            }
        });

    }catch(err){
        handleJavaScriptError('addCommodity', err, 0);
    }
}
/*End @15*/
function addCommodityNew() {
	debugger;
    var lo_deleteCommBtn                    = document.getElementById("deleteCommTd");
    var lo_addCommBtn                       = document.getElementById("addCommBtn");
    var lo_commTable                        = document.getElementById("comm_result_dtl");
    var lo_commodityCode                    = document.getElementsByName('strCommCode');
    var lo_comSeqNoTemp                     = document.getElementById("comSeqNoTemp");
    var lv_maxSeq                           = parseInt(lo_comSeqNoTemp.value) + 1;
    var rowIndex                            = lo_commTable.rows.length;
    var newNodeTr 	                    = null;
    var newNodeTd1 			    = null;
    var newNodeTd2 			    = null;
    var newNodeTd3 			    = null;
    var newNodeTd4 			    = null;
    var newNodeTd5 			    = null;
    var newNodeTd6 			    = null;
    var newNodeTd7 			    = null;
    var newNodeTd8 			    = null;
    var newNodeTd9 			    = null;
    var newNodeTd10 			    = null;
    var namestrCommPackageKindCode          = "strCommPackageKindCode";
    var namestrCommPackageKindName          = "strCommPackageKindName";

    try{
        setCargoDetailsAllData();

        // if(rowIndex > 1)lo_deleteCommBtn.style.display = "inline";

        //lo_commTable.childNodes[0].appendChild(newNodeTr);

        var postVal     = "newSeq=" + lv_maxSeq;
        $.ajax({
            type: "POST",
            url: ADD_COMMODITY_DATA,
            data: postVal,
            //beforeSend: showBarMessageNew(MSG_LOADING, 2),
            success: function(data){
                if(gp_trim(data)=="OK"){

                    newNodeTr       = lo_commTable.insertRow(rowIndex);
                    newNodeTd1      = newNodeTr.insertCell(0);
                    newNodeTd2      = newNodeTr.insertCell(1);
                    newNodeTd3      = newNodeTr.insertCell(2);
                    newNodeTd4      = newNodeTr.insertCell(3);
                    newNodeTd5      = newNodeTr.insertCell(4);
                    newNodeTd6      = newNodeTr.insertCell(5);
                    newNodeTd7      = newNodeTr.insertCell(6);
                    newNodeTd8      = newNodeTr.insertCell(7);
                    newNodeTd9      = newNodeTr.insertCell(8);
                    newNodeTd10     = newNodeTr.insertCell(9);

                    

                    //#
                    
                    newNodeTd1.innerHTML        = rowIndex+1;

                    //Commodity Group
                    
                    newNodeTd2.innerHTML        = '<input type="hidden" name="intCommGroupSeqNo"        value="0" />'
                                                + '<input type="hidden" name="strCommGroupCode"         value="" />'
                                                + '<input type="hidden" name="recordStatus"             value="ADD"  />'
                                                + '<input type="hidden" name="strCommPackageKindCode"   value="0" />'
                                                /*Begin @15*/
                                                + '<input type="hidden" name="marksAndNumbers"          value="" />'
                                                + '<input type="hidden" name="description"              value="" />'
                                                + '<input type="hidden" name="comBookingNo"             value="" />'
                                                + '<input type="hidden" name="strCommodityForMark"      value="" />'
                                                + '<input type="hidden" name="containerNoToCargo"       value="" />'
                                                + '<input type="hidden" name="comSeqNo"                 value="' + lv_maxSeq + '" />'
                                                /*End @15*/
                                                + '<input   type="text"'
                                                + '            class="form-control form-control-sm"'
                                                + '            name="strCommGroup"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            class="input-disabled"'
                                                + '            readonly="readonly" />';

                    //HS Code
                    newNodeTd3.innerHTML        = '<div class="input-group">'
												+ '<input type="text"'
                                                + '            class="form-control form-control-sm"'
                                                + '            name="strCommCode"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            readonly="readonly" /> '
                                                + '<div class="input-group-prepend cursor-pointer">'
												+ '<div class="input-group-text" name="btnCommodityGroupLookup"  '
                                                + 'href="javascript:void(0)" onclick="openCommodityGroupLookup(this, 0, \'\');">'
                                                + '<i class="fas fa-search" data-toggle="tooltip" data-placement="bottom" title="Search"></i></div>'
												+ '</div>'
												+ '</div>';

                    //Commodity Description
                    newNodeTd4.innerHTML        = '<input   type="text"'
                                                + '            class="form-control form-control-sm"'
                                                + '            name="strCommDesc"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            readonly="readonly" />';

                    //# of Packages
                    newNodeTd5.innerHTML        = '<input   type="text"'
                                                + '            name="strCommOfPackages"'
                                                + '            class="form-control form-control-sm"'
                                                + '            value="0"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            readonly="readonly" />';

                    //Package Kind
                    newNodeTd6.innerHTML        = '<div class="input-group">'
												+ '<input   type="text"'
												+ '            class="form-control form-control-sm"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            name="strCommPackageKindName" '
                                                + '            readonly="readonly"   />'
                                                + '<div class="input-group-prepend cursor-pointer">'
												+ '<div class="input-group-text" name="btnBrowseCommPackageKind"  href="javascript:void(0)" '
                                                + 'onclick="openPackageKind(this, \'strCommPackageKindCode\', \'strCommPackageKindName\' '
                                                + ', \'' + PACKAGE_KIND_TYPE_COMMODITY + '\');">'
                                                + '<i class="fas fa-search" data-toggle="tooltip" data-placement="bottom" title="Search"></i></div>'
												+ '</div>'
												+ '</div>';

                    //Gross Weight
                    newNodeTd7.innerHTML        = '<input   type="text"'
                                                + '            name="strCommWeight"'
                                                + '            class="form-control form-control-sm"'
                                                + '            value="0.000"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            readonly="readonly" />';

                    //Gross Cargo Measurement (CBM)
                    newNodeTd8.innerHTML        = '<input   type="text"'
                                                + '            name="strCommMeasurement"'
                                                + '            class="form-control form-control-sm"'
                                                + '            value="0.0000"'
                                                + '            onkeypress="return false;"'
                                                + '            onkeydown="return false;"'
                                                + '            readonly="readonly" />';

                    //Marks/Desc
					newNodeTd9.className        = 'text-center'
                    newNodeTd9.innerHTML        = '<td class=>'
												+ '<div class="btn btn-secondary btn-sm" name="btnCargoDetails"  href="javascript:void(0)" '
                                                + 'onclick="openCargoDescription(this)"><span class="fas fa-plus"></span></div>'
												+ '</td>';
                    //Select
                    newNodeTd10.innerHTML        = '<input type="checkbox" name="isSelected" class="form-control" style="height:20px !important;" />';

                    lo_comSeqNoTemp.value = lv_maxSeq;

                    //showBarMessageNew(MSG_NORMAL, 2);
                }else{
                    showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });

    }catch(err){
        handleJavaScriptError('addCommodity', err, 0);
    }
}


/*Begin @15*/
function deleteCommodity() {
    var lo_deleteCommBtn                    = document.getElementById("deleteCommTd");
    var lo_addCommBtn                       = document.getElementById("addCommBtn");
    var lo_commTable                        = document.getElementById("comm_result_dtl");
    var la_isSelected                       = document.getElementsByName("isSelected");
    var la_comSeqNo                         = document.getElementsByName("comSeqNo");
    var lv_request                          = "";
    var lv_num                              = 0;
    var lv_seqIndex                         = 0;
    var postVal                             = "";
    var la_tr			            = new Array();
    var rowIndex                            = 0;

    try{
        for(var i=0;i<la_isSelected.length;i++){
            if(la_isSelected[i].checked==true){
                lv_seqIndex = i + 1;
                if(lv_request==""){
                    lv_request = la_comSeqNo[lv_seqIndex].value;
                }else{
                    lv_request += "#" + la_comSeqNo[lv_seqIndex].value
                }
//                la_tr[lv_num]       = gp_rowTableObj(la_comSeqNo[lv_seqIndex]);
                la_tr[lv_num]       = la_comSeqNo[lv_seqIndex];
                lv_num++;
            }
        }

        if(lv_num == 0){
            alert("Please select at least one commodity row to delete.");
            return;
        }

        postVal     = "paramReq=" + lv_request;

        $.ajax({
            type: "POST",
            url: DEL_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessageNew(MSG_LOADING, 2),
            success: function(data){
                if(gp_trim(data)=="OK"){
                    for(var i=0;i<la_tr.length;i++){
//                        lo_commTable.childNodes[0].removeChild(la_tr[i]);
                        lo_commTable.deleteRow(gp_rowTableIndex(la_tr[i]));
                    }

                    for(var i=1;i<lo_commTable.rows.length;i++){
                        lo_commTable.rows[i].cells[0].innerHTML = (i);
                    }

                    rowIndex = lo_commTable.rows.length;
                    if(rowIndex < 3)lo_deleteCommBtn.style.display = "none";

                    setComboBoxCommodity();

                    showBarMessageNew(MSG_NORMAL, 2);
                }else{
                    showBarMessageNew(data, MSG_ERROR_CODE);
                }
            }
        });

    }catch(err){
        handleJavaScriptError('deleteCommodity', err, 0);
    }
}
/*End @15*/
function deleteCommodityNew() {
    var lo_deleteCommBtn                    = document.getElementById("deleteCommTd");
    var lo_addCommBtn                       = document.getElementById("addCommBtn");
    var lo_commTable                        = document.getElementById("comm_result_dtl");
    var la_isSelected                       = document.getElementsByName("isSelected");
    var la_comSeqNo                         = document.getElementsByName("comSeqNo");
    var lv_request                          = "";
    var lv_num                              = 0;
    var lv_seqIndex                         = 0;
    var postVal                             = "";
    var la_tr			            = new Array();
    var rowIndex                            = 0;
	var deleteArray = new Array();
    try{
        for(var i=0;i<la_isSelected.length;i++){
            if(la_isSelected[i].checked==true){
                lv_seqIndex = i + 1;
				deleteArray.push(lv_seqIndex);
                if(lv_request==""){
                    lv_request = la_comSeqNo[lv_seqIndex].value;
                }else{
                    lv_request += "#" + la_comSeqNo[lv_seqIndex].value
                }
//                la_tr[lv_num]       = gp_rowTableObj(la_comSeqNo[lv_seqIndex]);
                la_tr[lv_num]       = la_comSeqNo[lv_seqIndex];
                lv_num++;
            }
        }

        if(lv_num == 0){
            alert("Please select at least one commodity row to delete.");
            return;
        }

        postVal     = "paramReq=" + lv_request;

        $.ajax({
            type: "POST",
            url: DEL_COMMODITY_DATA,
            data: postVal,
           // beforeSend: showBarMessageNew(MSG_LOADING, 2),
            success: function(data){
                if(gp_trim(data)=="OK"){
                    for(var i=la_tr.length-1;i>=0;i--){
//                        lo_commTable.childNodes[0].removeChild(la_tr[i]);
                        lo_commTable.deleteRow(deleteArray[i]);
                    }

                    for(var i=1;i<lo_commTable.rows.length;i++){
                        lo_commTable.rows[i].cells[0].innerHTML = (i+1);
                    }

                    rowIndex = lo_commTable.rows.length;
                  //  if(rowIndex < 3)lo_deleteCommBtn.style.display = "none";

                    setComboBoxCommodity();

                  //  showBarMessageNew(MSG_NORMAL, 2);
                }else{
                    showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });

    }catch(err){
        handleJavaScriptError('deleteCommodity', err, 0);
    }
}

/*Begin @15*/
function updateCommodity(ao_element_current) {
	debugger;
    var lv_index                        = 0;
    var postVal                         = "";
    var lv_intCommGroupSeqNo            = null;
    var lv_strCommCode                  = null;
    var lv_strCommGroupCode             = null;
    var lv_strCommPackageKindCode       = null;
    var lv_marksAndNumbers              = null;
    var lv_description                  = null;
    var lv_comBookingNo                 = null;
    var lv_strCommodityForMark          = null;
    var lv_containerNoToCargo           = null;
    var lv_comSeqNo                     = null;
    var lv_strCommGroup                 = null;
    var lv_strCommDesc                  = null;
    var lv_strCommOfPackages            = null;
    var lv_strCommPackageKindName       = null;
    var lv_strCommWeight                = null;
    var lv_strCommMeasurement           = null;
    var lv_recordStatus                 = null;

    try{
        lv_index                        = gp_rowTableIndex(ao_element_current) - 1;
        lv_intCommGroupSeqNo            = document.getElementsByName("intCommGroupSeqNo")[lv_index].value;
        lv_strCommCode                  = document.getElementsByName("strCommCode")[lv_index].value;
        lv_strCommGroupCode             = document.getElementsByName("strCommGroupCode")[lv_index].value;
        lv_strCommPackageKindCode       = document.getElementsByName("strCommPackageKindCode")[lv_index].value;
        lv_marksAndNumbers              = document.getElementsByName("marksAndNumbers")[lv_index].value;
        lv_description                  = document.getElementsByName("description")[lv_index].value;
        lv_comBookingNo                 = document.getElementsByName("comBookingNo")[lv_index].value;
        lv_strCommodityForMark          = document.getElementsByName("strCommodityForMark")[lv_index].value;
        lv_containerNoToCargo           = document.getElementsByName("containerNoToCargo")[lv_index].value;
        lv_comSeqNo                     = document.getElementsByName("comSeqNo")[lv_index].value;
        lv_strCommGroup                 = document.getElementsByName("strCommGroup")[lv_index].value;
        lv_strCommDesc                  = encodeURIComponent(document.getElementsByName("strCommDesc")[lv_index].value);
        lv_strCommOfPackages            = document.getElementsByName("strCommOfPackages")[lv_index].value;
        lv_strCommPackageKindName       = document.getElementsByName("strCommPackageKindName")[lv_index].value;
        lv_strCommWeight                = document.getElementsByName("strCommWeight")[lv_index].value;
        lv_strCommMeasurement           = document.getElementsByName("strCommMeasurement")[lv_index].value;
        lv_recordStatus                 = document.getElementsByName("recordStatus")[lv_index].value;

        postVal     = "intCommGroupSeqNo="      + lv_intCommGroupSeqNo      + "&strCommCode="               + lv_strCommCode
                    + "&strCommGroupCode="      + lv_strCommGroupCode       + "&strCommPackageKindCode="    + lv_strCommPackageKindCode
                    + "&marksAndNumbers="       + lv_marksAndNumbers        + "&description="               + lv_description
                    + "&comBookingNo="          + lv_comBookingNo           + "&strCommodityForMark="       + lv_strCommodityForMark
                    + "&containerNoToCargo="    + lv_containerNoToCargo     + "&comSeqNo="                  + lv_comSeqNo
                    + "&strCommGroup="          + lv_strCommGroup           + "&strCommDesc="               + lv_strCommDesc
                    + "&strCommOfPackages="     + lv_strCommOfPackages      + "&strCommPackageKindName="    + lv_strCommPackageKindName
                    + "&strCommWeight="         + lv_strCommWeight          + "&strCommMeasurement="        + lv_strCommMeasurement
                    + "&recordStatus="          + lv_recordStatus;

        //alert(postVal);

        $.ajax({
            type: "POST",
            url: SET_COMMODITY_DATA,
            data: postVal,
            success: function(data){
                if(gp_trim(data).indexOf("OK") > -1){
                    //showBarMessageNew(MSG_NORMAL, 2);
                    setComboBoxCommodity();
                    if(lv_recordStatus!="ADD"){
                        document.getElementsByName("recordStatus")[lv_index].value = "UPD";
                    }

                }else{
                    showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });

    }catch(err){
        handleJavaScriptError('updateCommodity', err, 0);
    }

}
/*End @15*/

/*Begin @15*/
//function setComboBoxCommodity(){
//    var la_commodity                    = null;
//    var lo_option			= null;
//    var la_strCommCode                  = null;
//    var la_recordStatus                 = null;
//    var lv_cou                          = 1;
//
//    try{
//        la_commodity                    = document.getElementsByName("commodity");
//        la_strCommCode                  = document.getElementsByName("strCommCode");
//        la_recordStatus                 = document.getElementsByName("recordStatus");
//
//        for(var i=0;i<la_commodity.length;i++){
//
//            lv_cou = 1;
//            for(var j=0;j<la_strCommCode.length;j++){
//                if(la_strCommCode[j].value!=""){
//                    lo_option               = document.createElement("OPTION");
//                    lo_option.value	    = la_strCommCode[j].value;
//                    lo_option.text	    = "Commodity " + lv_cou;
//
//                    if(j==0)la_commodity[i].options.innerHTML = "";
//
//                    la_commodity[i].options.add(lo_option, la_commodity[i].options.length);
//
//                    lv_cou++;
//                }
//            }
//        }
//
//    }catch(err){
//        handleJavaScriptError('setComboBoxCommodity', err, 0);
//    }
//
//}

function setComboBoxCommodity(){
    var la_commodity                    = null;
    var lo_option			= null;
    var la_strCommCode                  = null;
    var la_recordStatus                 = null;
    var lv_cou                          = 1;

    try{
        la_commodity                    = document.getElementsByName("commodity");
        la_strCommCode                  = document.getElementsByName("strCommCode");
        la_recordStatus                 = document.getElementsByName("recordStatus");

        for(var i=0;i<la_commodity.length;i++){

            lv_cou = 1;
            for(var j=0;j<la_strCommCode.length;j++){
                if(la_strCommCode[j].value!=""){
                    lo_option               = document.createElement("OPTION");
                    lo_option.value	    = la_strCommCode[j].value;
                    lo_option.text	    = "Commodity " + lv_cou;

                    if(j==0)la_commodity[i].innerHTML = "";


                    try {
                        la_commodity[i].options.add(lo_option, la_commodity[i].options.length, null);// standards compliant; doesn't work in IE
                    }
                    catch(ex) {
                        la_commodity[i].options.add(lo_option, la_commodity[i].options.length); // IE only
                    }

//                    la_commodity[i].options.add(lo_option, la_commodity[i].options.length);

                    lv_cou++;
                }
            }
        }

    }catch(err){
        handleJavaScriptError('setComboBoxCommodity', err, 0);
    }

}
/*End @15*/
//==============================================================================
//EVENT PART --- END ###########################################################
//==============================================================================
//==============================================================================
//OBJECT CONTROL PART --- START ################################################
//==============================================================================
function showButton(status){
	debugger;
    var addDisabledBtnDisp                      = null;
    var addBtnDisp                              = null;
    var delDisabledBtnDisp                      = null;
    var delBtnDisp                              = null;
    var previewDisabledBtnDisp                  = null;
    var previewBtnDisp                          = null;
    var saveDisbledBtnDisp                      = null;
    var saveBtnDisp                             = null;
    var submitDisabledBtnDisp                   = null;
    var submitBtnDisp                           = null;
    var browseConsigneeNameBtnClassName         = null;
    var browseNotifyPartyNameBtnClassName       = null;

    var bookingNo                               = document.getElementsByName("bookingNo");
    var submitBtnObj                            = document.getElementById('submitBtn');

    try{
	
	
//        alert('status = '+status+' : bookingNo = '+bookingNo[0].value);
        error_code = 1;
        if(SUBMITTED_MODE == status || SUBMITTED_AFTER_MODE == status || isNullObj(bookingNo[0]) || isBlank(bookingNo[0].value)){
            addDisabledBtnDisp  = 'inline';
            addBtnDisp          = 'none';

            delDisabledBtnDisp  = 'inline';
            delBtnDisp          = 'none';
            //Set preview button
            error_code = 2;
            if(isBlank(bookingNo[0].value) || SUBMITTED_AFTER_MODE == status){
                error_code = 3;
                if(SUBMITTED_AFTER_MODE == status){
                    showButtonAfterSubmitClick();
                }
                error_code = 4;
                previewDisabledBtnDisp  = 'inline';
                previewBtnDisp          = 'none';
            }else{
                previewDisabledBtnDisp  = 'none';
                previewBtnDisp          = 'inline';
            }
            //Set save button
            saveDisabledBtnDisp         = 'inline';
            saveBtnDisp                 = 'none';
            //Set submit button
            submitDisabledBtnDisp       = 'inline';
            submitBtnDisp               = 'none';
            //Set class name
            browseConsigneeNameBtnClassName         = CLASS_NAME_DISABLED_BUTTON;
            browseNotifyPartyNameBtnClassName       = CLASS_NAME_DISABLED_BUTTON;
        }else{
            addDisabledBtnDisp          = 'none';
            addBtnDisp                  = 'inline';

            delDisabledBtnDisp          = 'none';
            delBtnDisp                  = 'inline';
            //Set save button
            saveDisabledBtnDisp         = 'none';
            saveBtnDisp                 = 'inline';
            error_code = 5;
            if( 'N' == status ){
                error_code = 6;
                //Set preview button
                previewDisabledBtnDisp  = 'inline';
                previewBtnDisp          = 'none';
                //Set submit button
                submitDisabledBtnDisp   = 'inline';
                submitBtnDisp           = 'none';
            }else{
                //Set preview button
                error_code = 7;
                previewDisabledBtnDisp  = 'inline';
                previewBtnDisp          = 'none';
                //Set submit button
                submitDisabledBtnDisp   = 'none';
                submitBtnDisp           = 'inline';
            }
            //Set class name
            browseConsigneeNameBtnClassName     = CLASS_NAME_BUTTON;
            browseNotifyPartyNameBtnClassName   = CLASS_NAME_BUTTON;
        }
        //Set all add button
        error_code = 8;
        document.getElementById("addDisabledBtn").style.display     = addDisabledBtnDisp;
        //document.getElementById("addBtn").style.display             = addBtnDisp;
        //Set all del button
        error_code = 9;
        document.getElementById("delDisabledBtn").style.display     = delDisabledBtnDisp;
        //document.getElementById("delBtn").style.display             = delBtnDisp;
        //Set all preview button
        error_code = 10;
        document.getElementById("previewDisabledBtn").style.display = "none";
        document.getElementById("previewBtn").style.display         = "none";
        //Set all save button
        error_code = 11;
        document.getElementById("saveDisabledBtn").style.display = saveDisabledBtnDisp;
        document.getElementById("saveBtn").style.display = saveBtnDisp;
        //Set all submit button
		if(status=='N'){
        error_code = 12;
        document.getElementById("submitDisabledBtn").style.display = submitDisabledBtnDisp;
		submitBtnObj.style.display = submitBtnDisp;	
		}else{
		document.getElementById("submitDisabledBtn").style.display = submitDisabledBtnDisp;
		submitBtnObj.style.display = submitBtnDisp;	
		}
		
        error_code = 13;
        /*if(submitBtnObj != null && submitBtnObj != undefined){
            submitBtnObj.style.display = submitBtnDisp;
        }*/
        //Set all class name
        //document.getElementById("btnBrowseConsigneeName").className = browseConsigneeNameBtnClassName;
        //document.getElementById("btnBrowseNotifyPartyName").className = browseNotifyPartyNameBtnClassName;
        error_code = 14;
        commodityDetailsControl(status);
        error_code = 15;
        equipmentDetailsControl(status);
        error_code = 16;
    }catch(err){
        handleJavaScriptError('showButton', err, error_code);
    }
}

function commodityDetailsControl(status){
    var disabled = false;
    var className = CLASS_NAME_BUTTON;

    var bookingNo = document.getElementsByName("bookingNo");
    var strCommGroup = document.getElementsByName('strCommGroup');
    var strCommDesc = document.getElementsByName('strCommDesc');
    var strCommWeight = document.getElementsByName('strCommWeight');
    //var btnCommLookup = document.getElementsByName('btnCommodityGroupLookup');
    //var btnCommPackageKind = document.getElementsByName('btnBrowseCommPackageKind');
    var strCommGroupLength = null;
    try{
        error_code = 1;
        if(!isNullObj(strCommGroup)){
            error_code = 2;
            strCommGroupLength = strCommGroup.length;
            error_code = 3;
            if(SUBMITTED_AFTER_MODE == status){
                disabled = true;
                className = CLASS_NAME_DISABLED_BUTTON;
            }else if(SUBMITTED_AFTER_MODE != status){
                if(!isNullObj(bookingNo) && !isNullObj(bookingNo[0])){
                    if(isBlank(bookingNo[0].value) || SUBMITTED_MODE == status){
                        disabled = true;
                        className = CLASS_NAME_DISABLED_BUTTON;
                    }
                }else{
                    disabled = true;
                    className = CLASS_NAME_DISABLED_BUTTON;
                }
            }
            error_code = 4;
            for(index=0; index<strCommGroupLength; index++){
                strCommGroup[index].readOnly = true;
                strCommDesc[index].readOnly = true;
                btnCommLookup[index].className = className;
                btnCommPackageKind[index].className = className;
                if(disabled){
                    btnCommLookup[index].onClick = '';
                    btnCommPackageKind[index].onClick = '';
                }
            }
        }
    }catch(err){
        handleJavaScriptError('commodityDetailsControl', err, error_code);
    }
}

function equipmentDetailsControl(status){
    var disabled = false;
    var className = CLASS_NAME_BUTTON;
    var containerNoLength = 0;

    var bookingNo = document.getElementsByName('bookingNo');
    var containerNo = document.getElementsByName('containerNo');
    var commodity = document.getElementsByName('commodity');
    var containerType = document.getElementsByName('containerType');
    var carrierSeal = document.getElementsByName('carrierSeal');
    var shipperSeal = document.getElementsByName('shipperSeal');
    var ofPackages = document.getElementsByName('ofPackages');
    var grossContainerWeight = document.getElementsByName('grossContainerWeight');
    var ladenMt = document.getElementsByName('ladenMt');
    var grossCargoMeasurement = document.getElementsByName('grossCargoMeasurement');
    var cbdelall = document.getElementsByName('cbdelall');
    //var cbdel = document.getElementsByName('cbdel');

    var packageKindBtn = document.getElementsByName('btnBrowsePackageKind');
    var ofPackageCopyBtn = document.getElementsByName('ofPackageCopyBtn');
    var packageKindCopyBtn = document.getElementsByName('packageKindCopyBtn');
    var grossWeightCopyBtn = document.getElementsByName('grossWeightCopyBtn');
    var grossMeasurementCopyBtn = document.getElementsByName('grossMeasurementCopyBtn');

    var nonPackageKindBtn = false;
    var copyButtonClass = CLASS_NAME_BUTTON;
    try{
        error_code = 1;
        if(!isNullObj(containerNo) && !isNullObj(containerNo.length)){
            error_code = 2;
            containerNoLength = containerNo.length;
            error_code = 3;
            if(SUBMITTED_AFTER_MODE == status){
                disabled = true;
                className = CLASS_NAME_DISABLED_BUTTON;
            }else if(SUBMITTED_AFTER_MODE != status){
                error_code = 4;
                if(SUBMITTED_MODE == status){
                    nonPackageKindBtn = true;
                    copyButtonClass = CLASS_NAME_DISABLED_BUTTON;
                }
                if(!isNullObj(bookingNo[0]) && !isNullObj(bookingNo[0].value)){
                    error_code = 5;
                    if(isBlank(bookingNo[0].value)){
                        error_code = 6;
                        disabled = true;
                        className = CLASS_NAME_DISABLED_BUTTON;
                    }
                }else{
                    error_code = 7;
                    disabled = true;
                    className = CLASS_NAME_DISABLED_BUTTON;
                }
            }
            error_code = 8;
            cbdelall[0].disabled = disabled;
            error_code = 9;
            for(var index=0; index<containerNoLength; index++){
                ++error_code;
                containerNo[index].disabled = disabled;
                ++error_code;
                containerType[index].disabled = disabled;
                ++error_code;
                carrierSeal[index].disabled = disabled;
                ++error_code;
                shipperSeal[index].disabled = disabled;
                ++error_code;
                ofPackages[index].disabled = disabled;
                ++error_code;
                grossContainerWeight[index].disabled = disabled;
                ++error_code;
                ladenMt[index].disabled = disabled;
                ++error_code;
                grossCargoMeasurement[index].disabled = disabled;
                ++error_code;
               // cbdel[index].disabled = disabled;
               // ++error_code;
//                Set Package Kind Search Btn
                if(!nonPackageKindBtn){
                    if(disabled){
                        packageKindBtn[index].onClick = '';
                    }
                   // packageKindBtn[index].className = className;
                }
//                Set Copy Btn
                ++error_code;
                if(containerNoLength == 1){
                    copyButtonClass = CLASS_NAME_DISABLED_BUTTON
                }
                if(index == 0){
                   // ofPackageCopyBtn[index].className = copyButtonClass;
                  //  packageKindCopyBtn[index].className = copyButtonClass;
                 //   grossWeightCopyBtn[index].className = copyButtonClass;
                 //   grossMeasurementCopyBtn[index].className = copyButtonClass;
                    ++error_code;
                    if(disabled || copyButtonClass == CLASS_NAME_DISABLED_BUTTON){
                        ++error_code;
                        ofPackageCopyBtn[index].onClick = '';
                        ++error_code;
                        packageKindCopyBtn[index].onClick = '';
                        ++error_code;
                        grossWeightCopyBtn[index].onClick = '';
                        ++error_code;
                        grossMeasurementCopyBtn[index].onClick = '';
                        ++error_code;
                    }else{
                        ++error_code;
                    }
                }
            }
        }
    }catch(err){
        handleJavaScriptError('equipmentDetailsControl', err, error_code);
    }
}

function summaryForCommodity(rowIndex, summaryType){
    var commodityObjSelected = null;
    var commodityObj = null;
    var commodityObjLength = null;
    var equipmentCommObjSelected = null;
    var equipmentCommObj = null;
    var equipmentCommObjLength = null;
    var summaryFromObj = null;
    var summaryFromObjLength = 0;
    var summaryFromObjVal = null;
    var summaryToObj = null;
    var summaryToObjLength = 0;
    var summaryToObjVal = null;
    var totalSummary = 0;
    var aintDigits = 0;
    var aintDecimals = 0;
    try{
//        GET Environment for equipment details
        error_code = 1;
        switch(summaryType){
            case COMMODITY_OF_PACKAGE:
                summaryFromObj = document.getElementsByName('ofPackages');
                summaryToObj = document.getElementsByName('strCommOfPackages');
                aintDigits = 6;
                aintDecimals = 2;
                break;
            case COMMODITY_GROSS_WEIGHT:
                summaryFromObj = document.getElementsByName('grossContainerWeight');
                summaryToObj = document.getElementsByName('strCommWeight');
                aintDigits = 15;
                aintDecimals = 3;
                break;
            case COMMODITY_GROSS_MEASUREMENT:
                summaryFromObj = document.getElementsByName('grossCargoMeasurement');
                summaryToObj = document.getElementsByName('strCommMeasurement');
                aintDigits = 14;
                aintDecimals = 4;
                break;
        }
        error_code = 2;
        if(!isNullObj(summaryFromObj) && !isNullObj(summaryFromObj.length)){
            summaryFromObjLength = summaryFromObj.length;
        }
        error_code = 3;
        equipmentCommObj = document.getElementsByName('commodity');
        if(!isNullObj(equipmentCommObj) && !isNullObj(equipmentCommObj.length)){
            equipmentCommObjLength = equipmentCommObj.length;
        }
        error_code = 4;
        if(equipmentCommObjLength == summaryFromObjLength){
            if(!isNullObj(equipmentCommObj[rowIndex]) && !isNullObj(equipmentCommObj[rowIndex].value) && !isBlank(equipmentCommObj[rowIndex].value)){
                equipmentCommObjSelected = equipmentCommObj[rowIndex].value;

                error_code = 5;
                for(var countIndex=0; countIndex<summaryFromObjLength; countIndex++){
                    if(equipmentCommObj[countIndex].value == equipmentCommObjSelected){
                        summaryFromObjVal = summaryFromObj[countIndex].value;
                        if(!isNullObj(summaryFromObjVal) && !isBlank(summaryFromObjVal)){
                            summaryFromObjVal = summaryFromObjVal.replace(',','');
                            totalSummary += parseInt(summaryFromObjVal);
                        }
                    }
                }
                error_code = 6;
                if(!isNullObj(summaryToObj) && !isNullObj(summaryToObj.length)){
                    summaryToObjLength = summaryToObj.length;
                }
                error_code = 7;
                commodityObj = document.getElementsByName('strCommCode');
                if(!isNullObj(commodityObj) && !isNullObj(commodityObj.length)){
                    commodityObjLength = commodityObj.length;
                }
                error_code = 8;
                if(summaryToObjLength == commodityObjLength){
                    error_code = 9;
                    for(var countIndex=0; countIndex<summaryToObjLength; countIndex++){
                        if(commodityObj[countIndex].value == equipmentCommObjSelected){
                            summaryToObj[countIndex].value = totalSummary;
                            if(summaryType == COMMODITY_OF_PACKAGE){
                                maskWithOutDecimal(summaryToObj[countIndex], aintDigits, aintDecimals);
                            }else{
                                putMask_NumberEX(summaryToObj[countIndex], aintDigits, aintDecimals);
                            }
                        }
                    }
                    error_code = 10;
                }
            }
        }
    }catch(err){
        handleJavaScriptError('summaryForCommodity', err, error_code);
    }
}
//==============================================================================
//OBJECT CONTROL PART --- END ##################################################
//==============================================================================
//@14 END
//@15 BEGIN
//==============================================================================
//OPEN POPUP PART --- START ####################################################
//==============================================================================
//function openPackageKind(obj, packageCodeDocNameForSet, packageNameDocNameForSet, packageType, rowForSet){
//    var url = BROWSE_PACKGAE_KIND_DATA;
//    try{
//        error_code = 1;
//        if(CLASS_NAME_DISABLED_BUTTON != obj.className){
//            error_code = 2;
////            document.forms[0].rowSelected.value = rowId;
//            url += '?packageCodeDocNameForSet='+packageCodeDocNameForSet;
//            url += '&packageNameDocNameForSet='+packageNameDocNameForSet;
//            url += '&packageType='+packageType;
//            url += '&rowForSet='+rowForSet;
////            alert(url);
//            error_code = 3;
//            openHelpList(url, 650, 400);
//            error_code = 4;
//        }
//    }catch(err){
//        handleJavaScriptError('openPackageKind', err, error_code);
//    }
//}

/*Begin @15*/
function openPackageKind(obj, packageCodeDocNameForSet, packageNameDocNameForSet, packageType){
	debugger;
    var url         = BROWSE_PACKGAE_KIND_DATA;
    var rowForSet   = 0;

    try{
        if(PACKAGE_KIND_TYPE_EQUIPMENT == packageType){
            rowForSet = gp_rowTableIndex(obj);
			if(rowForSet>2 ){
				
				var i=rowForSet-1;
				rowForSet=i*2;
				
			}
            var rowCount = rowForSet/2;
            var rowMinus = 2;
            for (var i=1; i<rowCount; i++){
                rowMinus = rowMinus +1;
            }
            //alert(rowCount+"=="+rowForSet+"=="+rowMinus);
            rowForSet = rowForSet - rowMinus;
        }else{
            rowForSet = gp_rowTableIndex(obj) - 1;
        }

        if(CLASS_NAME_DISABLED_BUTTON != obj.className){

            url += '?packageCodeDocNameForSet='     + packageCodeDocNameForSet;
            url += '&packageNameDocNameForSet='     + packageNameDocNameForSet;
            url += '&packageType='                  + packageType;
            url += '&rowForSet='                    + rowForSet;

            openHelpList(url, 900, 620);
        }
    }catch(err){
        handleJavaScriptError('openPackageKind', err, error_code);
    }
}
/*End @15*/

/*Begin @15*/
function openCommodityGroupLookup(ao_obj, mode, value) {
	debugger;
    var urlStr      = BROWSE_COMMODITY;
    var aintIndex   = gp_rowTableIndex(ao_obj) - 1;
    try{
        error_code = 1;
        urlStr += '?commodityRowIndex='+aintIndex;
        urlStr += '&commodityMode='+mode;
        urlStr += '&commodityValue='+value;
        error_code = 2;
        openHelpList(urlStr, 800, 600);
    }catch(err){
        handleJavaScriptError('openCommodityGroupLookup', err, error_code);
    }
}
/*End @15*/

/*function openCommodityGroupLookup(aintIndex, mode, value) {
    var urlStr = BROWSE_COMMODITY;
    try{
        error_code = 1;
        urlStr += '?commodityRowIndex='+aintIndex;
        urlStr += '&commodityMode='+mode;
        urlStr += '&commodityValue='+value;
        error_code = 2;
        openHelpList(urlStr, 800, 500);
    }catch(err){
        handleJavaScriptError('openCommodityGroupLookup', err, error_code);
    }
}*/
//==============================================================================
//OPEN POPUP PART --- END ######################################################
//==============================================================================
//==============================================================================
//SET VALUE PART --- END ######################################################
//==============================================================================
function setCommodityDetailsChanged(){
    var strCommGroup            = document.getElementsByName('strCommGroup');
    var strCommDesc             = document.getElementsByName('strCommDesc');
    var strCommOfPackage        = document.getElementsByName('strCommOfPackage');
    var strCommPackageKindCode  = document.getElementsByName('strCommPackageKindCode');
    var strCommPackageKindName  = document.getElementsByName('strCommPackageKindName');
    var strCommWeight           = document.getElementsByName('strCommWeight');
    var strCommMeasurement      = document.getElementsByName('strCommMeasurement');
    //@01 END
    try{
        error_code = 1;
        setValue(strCommGroup);
        error_code = 2;
        setValue(strCommDesc);
        error_code = 3;
        setValue(strCommOfPackage);
        error_code = 4;
        setValue(strCommPackageKindCode);
        error_code = 5;
        setValue(strCommPackageKindName);
        error_code = 6;
        setValue(strCommWeight);
        error_code = 7;
        setValue(strCommMeasurement);
        error_code = 8;
    }catch(err){
        handleJavaScriptError('setCommodityDetailsChanged', err, error_code);
    }
}

//function setCargoDetailsAllData()
//{
//    var containerNo                 = document.forms[0].containerNo;
//    var containerType               = document.forms[0].containerType;
//    var carrierSeal                 = document.forms[0].carrierSeal;
//    var shipperSeal                 = document.forms[0].shipperSeal;
//    var ofPackages                  = document.forms[0].ofPackages;
//    var packagesKind                = document.forms[0].packagesKind;
//    var grossContainerWeight        = document.forms[0].grossContainerWeight;
//    var ladenMt                     = document.forms[0].ladenMt;
//    var grossCargoMeasurement       = document.forms[0].grossCargoMeasurement;
//    var dbFlag                      = document.forms[0].dbFlag;
//    var statusFlag                  = document.forms[0].statusFlag;
//    var originalSeqNo               = document.forms[0].originalSeqNo;
//    var containerEqSize             = document.forms[0].containerEqSize;
//    var containerEqType             = document.forms[0].containerEqType;
//    var packagesKindCode            = document.forms[0].packagesKindCode;
//    var cntrSeq                     = document.forms[0].cntrSeq;
//    var seqNo                       = document.forms[0].seqNo;
//    var fkEquipmentDetail           = document.forms[0].fkEquipmentDetail;
//    var fkBookingSupplier           = document.forms[0].fkBookingSupplier;
//    var fkBookingSizeTypeDetail     = document.forms[0].fkBookingSizeTypeDetail;
//    //@01 BEGIN
//    var strCommodity                = document.forms[0].commodity;
//    //@01 END
//
//    setValue(containerNo);
//    setValue(containerType);
//    setValue(carrierSeal);
//    setValue(shipperSeal);
//    setValue(ofPackages);
//    setValue(packagesKind);
//    setValue(grossContainerWeight);
//    setValue(ladenMt);
//    setValue(grossCargoMeasurement);
//    setValue(dbFlag);
//    setValue(statusFlag);
//    setValue(originalSeqNo);
//    setValue(containerEqSize);
//    setValue(containerEqType);
//    setValue(packagesKindCode);
//    setValue(cntrSeq);
//    setValue(seqNo);
//    setValue(fkEquipmentDetail);
//    setValue(fkBookingSupplier);
//    setValue(fkBookingSizeTypeDetail);
//    //@01 BEGIN
//    setValue(strCommodity);
//    //@01 END
//    cutStartWithTextSeparate();
//}

function setCargoDetailsAllData(){
    var containerNo                 = null;
    var containerType               = null;
    var carrierSeal                 = null;
    var shipperSeal                 = null;
    var ofPackages                  = null;
    var packagesKind                = null;
    var grossContainerWeight        = null;
    var ladenMt                     = null;
    var grossCargoMeasurement       = null;
    var dbFlag                      = null;
    var statusFlag                  = null;
    var originalSeqNo               = null;
    var containerEqSize             = null;
    var containerEqType             = null;
    var packagesKindCode            = null;
    var cntrSeq                     = null;
    var seqNo                       = null;
    var fkEquipmentDetail           = null;
    var fkBookingSupplier           = null;
    var fkBookingSizeTypeDetail     = null;
    var strCommodity                = null;
    var cargoDetails                = null;
    var lo_textSeparate             = null;
    var lv_textSeparate             = null;
    var la_objName                  = new Array("containerNo", "containerType", "carrierSeal", "shipperSeal", "ofPackages", "packagesKind", "grossContainerWeight"
                                                , "ladenMt", "grossCargoMeasurement", "dbFlag", "statusFlag", "originalSeqNo", "containerEqSize", "containerEqType"
                                                , "packagesKindCode", "cntrSeq", "seqNo", "fkEquipmentDetail", "fkBookingSupplier", "fkBookingSizeTypeDetail"
                                                , "commodity");
    var la_obj                      = null;

    try{

        cargoDetails                = document.getElementsByName("cargoDetails");
        lo_textSeparate             = document.getElementById("textSeparate");
        lv_textSeparate             = lo_textSeparate.value;
        //alert(cargoDetails.length);
        for(var i=0;i<cargoDetails.length;i++){
            cargoDetails[i].value = "";
            //alert(la_objName.length);
            for(var j=0;j<la_objName.length;j++){
                //if(!isNullObj(document.getElementById("blNo"))){
                la_obj = eval('document.getElementsByName("' + la_objName[j] + '")');

                //alert(la_objName[j] + " :: " + la_obj[i].value);

                if(cargoDetails[i].value==""){
                    cargoDetails[i].value = la_obj[i].value==""?"null":la_obj[i].value;
                }else{
                    cargoDetails[i].value = cargoDetails[i].value + lv_textSeparate + (la_obj[i].value==""?"null":la_obj[i].value);
                }
            }

            //alert(cargoDetails[i].value);
        }

    }catch(e){
        handleJavaScriptError('setCargoDetailsAllData', e, 0);
    }
}
//==============================================================================
//SET VALUE PART --- END ######################################################
//==============================================================================
//@15 END

function setReadonlyCargoDesc()
{
    var esiStatus = document.forms[0].esiStatusCode;
    //if(null==esiStatus)
   // {
        //esiStatus = parent.opener.document.forms[0].esiStatusCode;
    //}
    var bookingNo = document.forms[0].bookingNo;
    if(null==bookingNo)
    {
        bookingNo = parent.opener.document.forms[0].bookingNo;
    }
    /*var marksAndNumbersInPopup = document.forms[0].marksAndNumbers;
    var descriptionInPopup = document.forms[0].description;
    if(undefined!=esiStatus && undefined!=marksAndNumbersInPopup
            && undefined!=descriptionInPopup && undefined!=bookingNo)
    {
        marksAndNumbersInPopup.readOnly = (SUBMITTED_MODE==esiStatus.value||''==bookingNo.value?"true":"");
        descriptionInPopup.readOnly = (SUBMITTED_MODE==esiStatus.value||''==bookingNo.value?"true":"");
    }*/
}

function showCargoButton()
{
    var esiStatus = document.getElementsByName('esiStatusCode')[0];

    if(esiStatus == null)
    {
        esiStatus = parent.opener.document.forms[0].esiStatusCode;
    }
    var bookingNo = document.getElementById("bookingNo");
    if(null==bookingNo)
    {
        bookingNo = parent.opener.document.forms[0].bookingNo;
    }

    if(undefined!=esiStatus && undefined != bookingNo)
    {
        var saveCargoDisabledBtn = document.getElementById("saveCargoDisabledBtn");
        var saveCargoBtn = document.getElementById("saveCargoBtn");
        var getEquipDetailDisabledBtn = document.getElementById("getEquipDetailDisabledBtn");
        var getEquipDetailBtn = document.getElementById("getEquipDetailBtn");
        if(SUBMITTED_MODE==esiStatus.value || ""==bookingNo.value)
        {
            if(undefined!=saveCargoDisabledBtn)
            {
                saveCargoDisabledBtn.style.display = '';
                getEquipDetailDisabledBtn.style.display = '';
            }
            if(undefined!=saveCargoBtn)
            {
                saveCargoBtn.style.display = 'none';
                getEquipDetailBtn.style.display = 'none';
            }
        }
        else
        {
            if(undefined!=saveCargoDisabledBtn)
            {
                saveCargoDisabledBtn.style.display = 'none';
                getEquipDetailDisabledBtn.style.display = 'none';
            }
            if(undefined!=saveCargoBtn)
            {
                saveCargoBtn.style.display = '';
                getEquipDetailBtn.style.display = '';
            }
        }
    }
}

function setMarkToNumberField(obj)
{
    if(null!=obj && ""!=obj.value)
    {
        if(undefined==obj.length)
        {
            maskWithOutDecimal(obj,6,2);
        }
        else
        {
            for(var i = 0; i < obj.length; i++)
            {
                maskWithOutDecimal(obj[i],6,2);
            }
        }
    }
}

function showMaskOnNumberField()
{
    var grossContainerWeight = document.forms[0].grossContainerWeight;
    var grossCargoMeasurement = document.forms[0].grossCargoMeasurement;
    var ofPackages = document.forms[0].ofPackages;

    setMarkToNumberFieldEX(grossContainerWeight,15,3);
    setMarkToNumberFieldEX(grossCargoMeasurement,14,4);
    setMarkToNumberField(ofPackages);
}

function setMarkToNumberFieldEX(obj, aintDigits, aintDecimals)
{

    if(null!=obj && ""!=obj.value)
    {
        if(undefined==obj.length)
        {
            putMask_NumberEX(obj, aintDigits, aintDecimals);
        }
        else
        {
            for(var i = 0; i < obj.length; i++)
            {
                putMask_NumberEX(obj[i], aintDigits, aintDecimals);
            }
        }
    }
}

function setValueToPopup()
{
    var blNumber;
    var commodity;
    var containerNoToCargo;
    var marks;
    var description;

    blNumber            = document.forms[0].blNumber.value;
    commodity           = document.forms[0].strCommodityForMark.value;
    containerNoToCargo  = document.forms[0].containerNoToCargo.value;
    la_marksAndNumbers  = document.getElementsByName("marksAndNumbers");
    la_description      = document.getElementsByName("description");
//    marks = escape(document.forms[0].marksAndNumbers.value);
//    description = escape(document.forms[0].description.value);
//    alert("blNumber : "+blNumber+" , commodity :"+commodity+" , containerNoToCargo : "+containerNoToCargo+" , marks : "+marks);

    return INPUT_CARGO_DESCRIPTION+"?blNumber="             + blNumber
                                    +"&containerNoToCargo=" + containerNoToCargo
                                    +"&commodity="          + commodity
                                    +"&marksAndNumbers="    + la_marksAndNumbers[0].value
                                    +"&description="        + la_description[0].value;
}

function openCargoDescription(ao_obj){
	debugger;
    var cargoDescriptionDiv = document.getElementById('cargoDescriptionDiv');
	var errorMsgDtl = document.getElementById('ErrorMsgLog');
    var styleDetails        = null;
    var lv_index            = gp_rowTableIndex(ao_obj) - 1;

    try{

        error_code = 1;
        cargoDescriptionDiv.style.display = 'block';
        error_code = 2;
        cargoDescriptionDiv.style.width = '720px';
        error_code = 3;
        cargoDescriptionDiv.style.height = '550px';
        error_code = 4;
        cargoDescriptionDiv.style.backgroundColor = '#ffffff';
        error_code = 5;
        cargoDescriptionDiv.style.position = 'fixed';
        error_code = 6;
        cargoDescriptionDiv.style.zIndex = '3';
        error_code = 7;
        cargoDescriptionDiv.style.top = '50%';
        error_code = 8;
        cargoDescriptionDiv.style.left = '50%';
        error_code = 9;
        cargoDescriptionDiv.style.marginTop = '-175px';
        error_code = 10;
        cargoDescriptionDiv.style.marginLeft = '-400px';
        error_code = 11;
        cargoDescriptionDiv.style.border = '1px solid #ccc';
        error_code = 12;
		errorMsgDtl.style.width = '720px';
        error_code = 13;
        onLoadCargoDescriptionPopup(lv_index);
    }catch(err){
        handleJavaScriptError('openCargoDescription', err, error_code);
    }
}
function closeCargoDescription(){
    var cargoDescriptionDiv = document.getElementById('cargoDescriptionDiv');
    try{
        error_code = 1;
        unloading();
        cargoDescriptionDiv.style.display = 'none';
    }catch(err){
        handleJavaScriptError('closeCargoDescription', err, error_code);
    }
}

function openDetails()
{
    url = setValueToPopup();
//    alert("url : "+url);
    openHelpList(url, 763, 430);
}

function openCustomerData(obj, fieldName, add1, add2, add3, add4)
{
    if(CLASS_NAME_DISABLED_BUTTON==obj.className)
    {
        return;
    }

    document.forms[0].fieldName.value = fieldName;
    document.forms[0].fieldAdd1.value = add1;
    document.forms[0].fieldAdd2.value = add2;
    document.forms[0].fieldAdd3.value = add3;
    document.forms[0].fieldAdd4.value = add4;
    var cocSoc = document.forms[0].cocSoc.value;
	var bookingno = document.forms[0].bookingNo.value;
    var podCountry = document.forms[0].podCountry.value;
    var url = BROWSE_CUSTOMER_DATA+"?cocSoc="+cocSoc+"&podCountry="+podCountry+"&defaultSearch=true&bookingNo="+bookingno;
    openHelpList(url, 700, 400);
}

function setValue(values)
{
    var val;
    var cargoDetails = document.forms[0].cargoDetails;
    var textSeparate = document.forms[0].textSeparate.value;
    if(undefined!=cargoDetails.value)
    {
        if(undefined!=values)
        {
            val = values.value;
            if(""==values.value) val = "null";
            cargoDetails.value += ((""!=cargoDetails.value)?textSeparate+val:val);
        }
        else
        {
            cargoDetails.value += textSeparate+"null";
        }
    }
    else
    {
        if(undefined!=values)
        {
            for(var i = 0; i < values.length; i++)
            {
                if((undefined==values[i].name && ""!=values[i].value) || (undefined!=values[i].name))
                {
                    if(undefined!==values.selectedIndex)
                    {
                        val = values.options[values.selectedIndex].value;
                        if(""==val) val = "null";
                    }
                    else
                    {
                        val = values[i].value;
                        if(""==values[i].value) val = "null";
                    }

                    if(undefined!=cargoDetails[i])
                    {
                        cargoDetails[i].value += (textSeparate+val);
                    }
                }
                else
                {
                    if(""==values[i].value) val = "null";
                    cargoDetails[i].value += (textSeparate+val);
                }
            }
        }
    }
}

function cutStartWithTextSeparate()
{
    var cargoDetails = document.forms[0].cargoDetails;
    var textSeparate = document.forms[0].textSeparate.value;
//    alert(textSeparate);
    var str;
    var strSub;
    if(undefined!=cargoDetails.value)
    {
        str = cargoDetails.value;
        strSub = str.substring(0,3);
        if(strSub==textSeparate)
        {
            cargoDetails.value = str.substring(str.indexOf(textSeparate)+textSeparate.length);
        }
    }
    else
    {
        for(var i = 0; i < cargoDetails.length; i++)
        {
            str = cargoDetails[i].value;
            strSub = str.substring(0,3);
            if(strSub==textSeparate)
            {
                cargoDetails[i].value = str.substring(str.indexOf(textSeparate)+textSeparate.length);
            }
        }
    }
}

function submitForm()
{
	debugger;
    setCargoDetailsAllData();
    var url = GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE;
//        @10 BEGIN
        loading();
//        @10 END
    document.forms[0].action = url;
    document.forms[0].submit();
}

function setContainerValue(obj, idx)
{
    if(''!=obj.value)
    {
        var str = (obj.value).split(TEXT_SEPARATE);
        document.forms[0].containerEqSize[idx].value = str[0];
        document.forms[0].containerEqType[idx].value = str[1];
    }
    else
    {
        document.forms[0].containerEqSize[idx].value = '';
        document.forms[0].containerEqType[idx].value = '';
    }
}

function checkDeleteItem()
{
    var checkboxSelected = 0;
    var cbdel = document.forms[0].cbdel;
    if(undefined!=cbdel.checked)
    {
        checkboxSelected += (cbdel.checked?1:0);
    }
    else
    {
        for(var i = 0; i < cbdel.length; i++)
        {
            checkboxSelected += (cbdel[i].checked?1:0);
        }
    }

    return (checkboxSelected>=1);
}

function addItem()
{
    document.forms[0].flag.value = '';
    submitForm();
}

function checkCanDeleteItem()
{
    var cbdel = document.forms[0].cbdel;
    if(undefined!=cbdel.checked && cbdel.checked)
    {
        return true;
    }
    else
    {
        var len = cbdel.length;
        var lenIsChecked = 0;
        for(var i = 0; i < cbdel.length; i++)
        {
            if(cbdel[i].checked)
            {
                lenIsChecked += 1;
            }
        }

        return (len==lenIsChecked);
    }
    return false;
}

function setItemsDelete()
{
    var itemsDelete = document.forms[0].itemsDelete;
    var flagItemsDelete = document.forms[0].flagItemsDelete;
    var cbdel = document.forms[0].cbdel;
    var statusFlag = document.forms[0].statusFlag;
    var originalSeqNo = document.forms[0].originalSeqNo;
    for(var i = 0; i < cbdel.length; i++)
    {
        if(cbdel[i].checked)
        {
            itemsDelete.value += (',1');
            flagItemsDelete.value += (','+originalSeqNo[i].value);
            statusFlag[i].value = 'D';
        }
        else
        {
            itemsDelete.value += (',0');
            flagItemsDelete.value += (',0');
        }
    }

    itemsDelete.value = (itemsDelete.value.substr(1,itemsDelete.value.length));
    flagItemsDelete.value = (flagItemsDelete.value.substr(1,flagItemsDelete.value.length));
}

function deleteItem()
{
    var selectedItem = checkDeleteItem();
    var cannotDeleteItem = checkCanDeleteItem();
    if(!selectedItem)
    {
        showBarMessageNew("Please select item.",1);
window.scrollTo(500, 0);
    }
    else if(cannotDeleteItem)
    {
        showBarMessageNew("1st row cannot be deleted. Must have at least one row.",1);
window.scrollTo(500, 0);
    }
    else
    {
        var con = confirm("Do you want to delete item(s) ?");
        if(con)
        {
            document.forms[0].flag.value = FLAG_DELETE;
            setItemsDelete();
            submitForm();
        }
    }
}

function selectAllData()
{
    var cbdelall = document.forms[0].cbdelall;
    var cbdel = document.forms[0].cbdel;
    if(undefined!=cbdel.checked)
    {
        cbdel.checked = cbdelall.checked;
    }
    else
    {
        for(var i = 0; i < cbdel.length; i++)
        {
            cbdel[i].checked = cbdelall.checked;
        }
    }
}

function openBookingNumber()
{
    var url = BROWSE_BOOKING_NUMBER;
    openHelpList(url, 980, 450);
}

function setAllDataForSearchBookingNumber()
{
    setCargoDetailsAllData();
    document.forms[0].flag.value = FLAG_BOOKING;
}

function openBookingNumberForShipping()
{
    setAllDataForSearchBookingNumber();
    openBookingNumber();
}

function getWebBookingDataOnBlur(obj)
{
    if(""!=obj.value)
    {
        changeUpper(obj);
        var params = "?bookingNo="+obj.value+"&mode=yourself";
        getWebBookingData(obj.form, params);
    }
}

function getWebBookingDataOnBlurForShipping(obj)
{
    setAllDataForSearchBookingNumber();
    getWebBookingDataOnBlur(obj);
}

function replaceCommaToBlank(val)
{
    if(null!=val)
    {
        return val.replace(",","");
    }
    return val;
}

function changeUpper(afield)
{
    afield.value = afield.value.toUpperCase();
}

function keepOriginalData()
{
    try{
    blChoiceOneTmp              = document.forms[0].choiceRad[0].checked;
    blChoiceTwoTmp              = document.forms[0].choiceRad[1].checked;
    blChoiceThreeTmp            = document.forms[0].choiceRad[2].checked;
    blTypeTmp                   = document.forms[0].blType.value;
    contactTmp                  = document.forms[0].contact.value;
    telephoneTmp                = document.forms[0].telephone.value;
    faxTmp                      = document.forms[0].fax.value;
    additionalEmailTmp          = document.forms[0].additionalEmail.value;
    shipperNameTmp              = document.forms[0].shipperName.value;
    shipperAddress1Tmp          = document.forms[0].shipperAddress1.value;
    shipperAddress2Tmp          = document.forms[0].shipperAddress2.value;
    shipperAddress3Tmp          = document.forms[0].shipperAddress3.value;
    shipperAddress4Tmp          = document.forms[0].shipperAddress4.value;
    consigneeNameTmp            = document.forms[0].consigneeName.value;
    consigneeAddress1Tmp        = document.forms[0].consigneeAddress1.value;
    consigneeAddress2Tmp        = document.forms[0].consigneeAddress2.value;
    consigneeAddress3Tmp        = document.forms[0].consigneeAddress3.value;
    consigneeAddress4Tmp        = document.forms[0].consigneeAddress4.value;
    notifyPartyNameTmp          = document.forms[0].notifyPartyName.value;
    notifyPartyAddress1Tmp      = document.forms[0].notifyPartyAddress1.value;
    notifyPartyAddress2Tmp      = document.forms[0].notifyPartyAddress2.value;
    notifyPartyAddress3Tmp      = document.forms[0].notifyPartyAddress3.value;
    notifyPartyAddress4Tmp      = document.forms[0].notifyPartyAddress4.value;
    placeDateOfIssueTmp         = document.forms[0].placeDateOfIssue.value;
    polTmp                      = document.forms[0].pol.value;
    podTmp                      = document.forms[0].pod.value;
    placeOfReceiptTmp           = document.forms[0].placeOfReceipt.value;
    placeOfDeliveryTmp          = document.forms[0].placeOfDelivery.value;
    noOfOriginalTmp             = document.forms[0].noOfOriginal.value;
    remarksTmp                  = document.forms[0].remarks.value;
//    marksAndNumbersTmp          = document.forms[0].marksAndNumbers.value;
//    descriptionTmp              = document.forms[0].description.value;

//    var containerNo = document.forms[0].containerNo;  comment 20/03/2015

    var containerNo = document.getElementsByName("containerNo");
    //alert("containerNo.length "+containerNo.length);
    if(undefined==containerNo.length)
    {
        containerNoTmp      = containerNo.value;
//        containerTypeTmp = document.forms[0].containerType.value;
        carrierSealTmp      = document.forms[0].carrierSeal.value;
        shipperSealTmp      = document.forms[0].shipperSeal.value;
        ofPackagesTmp       = document.forms[0].ofPackages.value;
        packagesKindTmp     = document.forms[0].packagesKind.value;

        setMarkToNumberFieldEX(document.forms[0].grossContainerWeight,15,3);
        setMarkToNumberFieldEX(document.forms[0].grossCargoMeasurement,14,4);

        grossContainerWeightTmp     = replaceCommaToBlank(document.forms[0].grossContainerWeight.value);
//        ladenMtTmp = document.forms[0].ladenMt.value;
        grossCargoMeasurementTmp    = replaceCommaToBlank(document.forms[0].grossCargoMeasurement.value);

        //alert("containerNoTmp >>>>>>> "+containerNoTmp);
    }
    else
    {
        containerNoTmp              = new Array();
//        containerTypeTmp = new Array();
        carrierSealTmp              = new Array();
        shipperSealTmp              = new Array();
        ofPackagesTmp               = new Array();
        packagesKindTmp             = new Array();
        grossContainerWeightTmp     = new Array();
//        ladenMtTmp = new Array();
        grossCargoMeasurementTmp    = new Array();
        equipmentSize               = containerNo.length;
        for(var i=0;i<equipmentSize;i++)
        {
            containerNoTmp[i] = containerNo[i].value;

//            containerTypeTmp[i] = document.forms[0].containerType[i].value;
            if (document.forms[0].carrierSeal[i]){
                carrierSealTmp[i] = document.forms[0].carrierSeal[i].value;
            }else{
                carrierSealTmp[i] = "";
            }

            if (document.forms[0].shipperSeal[i]){
                shipperSealTmp[i] = document.forms[0].shipperSeal[i].value;
            }else{
                shipperSealTmp[i] = "";
            }

            if (document.forms[0].ofPackages[i]){
                ofPackagesTmp[i] = document.forms[0].ofPackages[i].value;
            }else{
                ofPackagesTmp[i] = "0";
            }

            if (document.forms[0].packagesKind[i]){
                packagesKindTmp[i] = document.forms[0].packagesKind[i].value;
            }else{
                packagesKindTmp[i] = "";
            }

            if (document.forms[0].grossContainerWeight[i]){
                setMarkToNumberFieldEX(document.forms[0].grossContainerWeight[i],15,3);
                grossContainerWeightTmp[i] = replaceCommaToBlank(document.forms[0].grossContainerWeight[i].value);
            }else{
                grossContainerWeightTmp[i] = "";
            }

            if (document.forms[0].grossCargoMeasurement[i]){
                setMarkToNumberFieldEX(document.forms[0].grossCargoMeasurement[i],14,4);
                grossCargoMeasurementTmp[i] = replaceCommaToBlank(document.forms[0].grossCargoMeasurement[i].value);
            }else{
                grossCargoMeasurementTmp[i] = "";
            }

//            ladenMtTmp[i] = document.forms[0].ladenMt[i].value;

            //alert('grossCargoMeasurementTmp[i] = '+grossCargoMeasurementTmp[i]+'\ngrossContainerWeightTmp[i]='+grossContainerWeightTmp[i]);
        }
    }
    }catch(err){
        handleJavaScriptError('keepOriginalData', err, error_code);
    }
}

//function hasFieldHeaderChanged()
//{
//    var blChoiceOne = document.forms[0].choiceRad[0].checked;
//    var blChoiceTwo = document.forms[0].choiceRad[1].checked;
//    var blChoiceThree = document.forms[0].choiceRad[2].checked;
//    var blType = document.forms[0].blType.value;
//    var contact = document.forms[0].contact.value;
//    var telephone = document.forms[0].telephone.value;
//    var fax = document.forms[0].fax.value;
//    var additionalEmail = document.forms[0].additionalEmail.value;
//    var shipperName = document.forms[0].shipperName.value;
//    var shipperAddress1 = document.forms[0].shipperAddress1.value;
//    var shipperAddress2 = document.forms[0].shipperAddress2.value;
//    var shipperAddress3 = document.forms[0].shipperAddress3.value;
//    var shipperAddress4 = document.forms[0].shipperAddress4.value;
//    var consigneeName = document.forms[0].consigneeName.value;
//    var consigneeAddress1 = document.forms[0].consigneeAddress1.value;
//    var consigneeAddress2 = document.forms[0].consigneeAddress2.value;
//    var consigneeAddress3 = document.forms[0].consigneeAddress3.value;
//    var consigneeAddress4 = document.forms[0].consigneeAddress4.value;
//    var notifyPartyName = document.forms[0].notifyPartyName.value;
//    var notifyPartyAddress1 = document.forms[0].notifyPartyAddress1.value;
//    var notifyPartyAddress2 = document.forms[0].notifyPartyAddress2.value;
//    var notifyPartyAddress3 = document.forms[0].notifyPartyAddress3.value;
//    var notifyPartyAddress4 = document.forms[0].notifyPartyAddress4.value;
//    var placeDateOfIssue = document.forms[0].placeDateOfIssue.value;
//    var pol = document.forms[0].pol.value;
//    var pod = document.forms[0].pod.value;
//    var placeOfReceipt = document.forms[0].placeOfReceipt.value;
//    var placeOfDelivery = document.forms[0].placeOfDelivery.value;
//    var noOfOriginal = document.forms[0].noOfOriginal.value;
//    var remarks = document.forms[0].remarks.value;
////    var marksAndNumbers = document.forms[0].marksAndNumbers.value;
////    var description = document.forms[0].description.value;
//    var msgFieldChanged = '';
//
//    if(blChoiceOne!=blChoiceOneTmp || blChoiceTwo!=blChoiceTwoTmp || blChoiceThree!=blChoiceThreeTmp)
//    {
//        msgFieldChanged += '\"B/L Archetype\",';
//    }
//    if(blType!=blTypeTmp)
//    {
//        msgFieldChanged += '\"B/L Type\",';
//    }
//    if(contact!=contactTmp)
//    {
//        msgFieldChanged += '\"Contact Person\",';
//    }
//    if(telephone!=telephoneTmp)
//    {
//        msgFieldChanged += '\"Telephone\",';
//    }
//    if(fax!=faxTmp)
//    {
//        msgFieldChanged += '\"Fax\",';
//    }
//    if(additionalEmail!=additionalEmailTmp)
//    {
//        msgFieldChanged += '\"Additional Mail Recipients\",';
//    }
//    if(shipperName!=shipperNameTmp)
//    {
//        msgFieldChanged += '\"Shipper Name\",';
//    }
//    if(shipperAddress1!=shipperAddress1Tmp)
//    {
//        msgFieldChanged += '\"Shipper Address 1\",';
//    }
//    if(shipperAddress2!=shipperAddress2Tmp)
//    {
//        msgFieldChanged += '\"Shipper Address 2\",';
//    }
//    if(shipperAddress3!=shipperAddress3Tmp)
//    {
//        msgFieldChanged += '\"Shipper Address 3\",';
//    }
//    if(shipperAddress4!=shipperAddress4Tmp)
//    {
//        msgFieldChanged += '\"Shipper Address 4\",';
//    }
//    if(consigneeName!=consigneeNameTmp)
//    {
//        msgFieldChanged += '\"Consignee Name\",';
//    }
//    if(consigneeAddress1!=consigneeAddress1Tmp)
//    {
//        msgFieldChanged += '\"Consignee Address 1\",';
//    }
//    if(consigneeAddress2!=consigneeAddress2Tmp)
//    {
//        msgFieldChanged += '\"Consignee Address 2\",';
//    }
//    if(consigneeAddress3!=consigneeAddress3Tmp)
//    {
//        msgFieldChanged += '\"Consignee Address 3\",';
//    }
//    if(consigneeAddress4!=consigneeAddress4Tmp)
//    {
//        msgFieldChanged += '\"Consignee Address 4\",';
//    }
//    if(notifyPartyName!=notifyPartyNameTmp)
//    {
//        msgFieldChanged += '\"Notify Party Name\",';
//    }
//    if(notifyPartyAddress1!=notifyPartyAddress1Tmp)
//    {
//        msgFieldChanged += '\"Notify Party Address 1\",';
//    }
//    if(notifyPartyAddress2!=notifyPartyAddress2Tmp)
//    {
//        msgFieldChanged += '\"Notify Party Address 2\",';
//    }
//    if(notifyPartyAddress3!=notifyPartyAddress3Tmp)
//    {
//        msgFieldChanged += '\"Notify Party Address 3\",';
//    }
//    if(notifyPartyAddress4!=notifyPartyAddress4Tmp)
//    {
//        msgFieldChanged += '\"Notify Party Address 4\",';
//    }
//    if(placeDateOfIssue!=placeDateOfIssueTmp)
//    {
//        msgFieldChanged += '\"Place of Issue\",';
//    }
//    if(pol!=polTmp)
//    {
//        msgFieldChanged += '\"Port of Loading(POL)\",';
//    }
//    if(pod!=podTmp)
//    {
//        msgFieldChanged += '\"Port of Discharge(POD)\",';
//    }
//    if(placeOfReceipt!=placeOfReceiptTmp)
//    {
//        msgFieldChanged += '\"Place of Receipt\",';
//    }
//    if(placeOfDelivery!=placeOfDeliveryTmp)
//    {
//        msgFieldChanged += '\"Place of Delivery\",';
//    }
//    if(noOfOriginal!=noOfOriginalTmp)
//    {
//        msgFieldChanged += '\"No. of Original BL\",';
//    }
//    if(remarks!=remarksTmp)
//    {
//        msgFieldChanged += '\"Remarks\",';
//    }
////    if(marksAndNumbers!=marksAndNumbersTmp)
////    {
////        msgFieldChanged += '\"Marks & Numbers\",';
////    }
////    if(description!=descriptionTmp)
////    {
////        msgFieldChanged += '\"Description\",';
////    }
//
//    return msgFieldChanged;
//}

function hasFieldHeaderChanged(){
    var blChoiceOne             = null;
    var blChoiceTwo             = null
    var blChoiceThree           = null
    var blType                  = null
    var contact                 = null
    var telephone               = null
    var fax                     = null
    var additionalEmail         = null
    var shipperName             = null
    var shipperAddress1         = null
    var shipperAddress2         = null
    var shipperAddress3         = null
    var shipperAddress4         = null
    var consigneeName           = null
    var consigneeAddress1       = null
    var consigneeAddress2       = null
    var consigneeAddress3       = null
    var consigneeAddress4       = null
    var notifyPartyName         = null
    var notifyPartyAddress1     = null
    var notifyPartyAddress2     = null
    var notifyPartyAddress3     = null
    var notifyPartyAddress4     = null
    var placeDateOfIssue        = null
    var pol                     = null
    var pod                     = null
    var placeOfReceipt          = null
    var placeOfDelivery         = null
    var noOfOriginal            = null
    var remarks                 = null
    var msgFieldChanged         = '';

    try{
        blChoiceOne             = document.forms[0].choiceRad[0].checked;
        blChoiceTwo             = document.forms[0].choiceRad[1].checked;
        blChoiceThree           = document.forms[0].choiceRad[2].checked;
        blType                  = document.forms[0].blType.value;
        contact                 = document.forms[0].contact.value;
        telephone               = document.forms[0].telephone.value;
        fax                     = document.forms[0].fax.value;
        additionalEmail         = document.forms[0].additionalEmail.value;
        shipperName             = document.forms[0].shipperName.value;
        shipperAddress1         = document.forms[0].shipperAddress1.value;
        shipperAddress2         = document.forms[0].shipperAddress2.value;
        shipperAddress3         = document.forms[0].shipperAddress3.value;
        shipperAddress4         = document.forms[0].shipperAddress4.value;
        consigneeName           = document.forms[0].consigneeName.value;
        consigneeAddress1       = document.forms[0].consigneeAddress1.value;
        consigneeAddress2       = document.forms[0].consigneeAddress2.value;
        consigneeAddress3       = document.forms[0].consigneeAddress3.value;
        consigneeAddress4       = document.forms[0].consigneeAddress4.value;
        notifyPartyName         = document.forms[0].notifyPartyName.value;
        notifyPartyAddress1     = document.forms[0].notifyPartyAddress1.value;
        notifyPartyAddress2     = document.forms[0].notifyPartyAddress2.value;
        notifyPartyAddress3     = document.forms[0].notifyPartyAddress3.value;
        notifyPartyAddress4     = document.forms[0].notifyPartyAddress4.value;
        placeDateOfIssue        = document.forms[0].placeDateOfIssue.value;
        pol                     = document.forms[0].pol.value;
        pod                     = document.forms[0].pod.value;
        placeOfReceipt          = document.forms[0].placeOfReceipt.value;
        placeOfDelivery         = document.forms[0].placeOfDelivery.value;
        noOfOriginal            = document.forms[0].noOfOriginal.value;
        remarks                 = document.forms[0].remarks.value;

        if(blChoiceOne!=blChoiceOneTmp || blChoiceTwo!=blChoiceTwoTmp || blChoiceThree!=blChoiceThreeTmp) msgFieldChanged += '\"B/L Archetype\",';
        if(blType!=blTypeTmp)                           msgFieldChanged += '\"B/L Type\",';
        if(contact!=contactTmp)                         msgFieldChanged += '\"Contact Person\",';
        if(telephone!=telephoneTmp)                     msgFieldChanged += '\"Telephone\",';
        if(fax!=faxTmp)                                 msgFieldChanged += '\"Fax\",';
        if(additionalEmail!=additionalEmailTmp)         msgFieldChanged += '\"Additional Mail Recipients\",';
        if(shipperName!=shipperNameTmp)                 msgFieldChanged += '\"Shipper Name\",';
        if(shipperAddress1!=shipperAddress1Tmp)         msgFieldChanged += '\"Shipper Address 1\",';
        if(shipperAddress2!=shipperAddress2Tmp)         msgFieldChanged += '\"Shipper Address 2\",';
        if(shipperAddress3!=shipperAddress3Tmp)         msgFieldChanged += '\"Shipper Address 3\",';
        if(shipperAddress4!=shipperAddress4Tmp)         msgFieldChanged += '\"Shipper Address 4\",';
        if(consigneeName!=consigneeNameTmp)             msgFieldChanged += '\"Consignee Name\",';
        if(consigneeAddress1!=consigneeAddress1Tmp)     msgFieldChanged += '\"Consignee Address 1\",';
        if(consigneeAddress2!=consigneeAddress2Tmp)     msgFieldChanged += '\"Consignee Address 2\",';
        if(consigneeAddress3!=consigneeAddress3Tmp)     msgFieldChanged += '\"Consignee Address 3\",';
        if(consigneeAddress4!=consigneeAddress4Tmp)     msgFieldChanged += '\"Consignee Address 4\",';
        if(notifyPartyName!=notifyPartyNameTmp)         msgFieldChanged += '\"Notify Party Name\",';
        if(notifyPartyAddress1!=notifyPartyAddress1Tmp) msgFieldChanged += '\"Notify Party Address 1\",';
        if(notifyPartyAddress2!=notifyPartyAddress2Tmp) msgFieldChanged += '\"Notify Party Address 2\",';
        if(notifyPartyAddress3!=notifyPartyAddress3Tmp) msgFieldChanged += '\"Notify Party Address 3\",';
        if(notifyPartyAddress4!=notifyPartyAddress4Tmp) msgFieldChanged += '\"Notify Party Address 4\",';
        if(placeDateOfIssue!=placeDateOfIssueTmp)       msgFieldChanged += '\"Place of Issue\",';
        if(pol!=polTmp)                                 msgFieldChanged += '\"Port of Loading(POL)\",';
        if(pod!=podTmp)                                 msgFieldChanged += '\"Port of Discharge(POD)\",';
        if(placeOfReceipt!=placeOfReceiptTmp)           msgFieldChanged += '\"Place of Receipt\",';
        if(placeOfDelivery!=placeOfDeliveryTmp)         msgFieldChanged += '\"Place of Delivery\",';
        if(noOfOriginal!=noOfOriginalTmp)               msgFieldChanged += '\"No. of Original BL\",';
        if(remarks!=remarksTmp)                         msgFieldChanged += '\"Remarks\",';

    }catch(e){
        alert("hasFieldHeaderChanged :: " + e);
    }

    return msgFieldChanged;
}

function getEquipmentLineToShow(msg, idx)
{
    var templateEquipmentLine = '\"{0} at item {1}\",';
    var msgPrefix = templateEquipmentLine.replace("{0}",msg);
    return (null!=idx?msgPrefix.replace("{1}",(idx+1)):msgPrefix.replace("{1}","1"));
}

//function equipmentFieldChanged(containerNo, idx)
//{
//    var containerNoObj;
////    var containerType;
//    var carrierSeal;
//    var shipperSeal;
//    var ofPackages;
//    var packagesKind;
//    var grossContainerWeight;
////    var ladenMt;
//    var grossCargoMeasurement;
//    var msgFieldChanged = '';
//
//    var containerNoTmpObj;
//    var carrierSealTmpObj;
//    var shipperSealTmpObj;
//    var ofPackagesTmpObj;
//    var packagesKindTmpObj;
//    var grossContainerWeightTmpObj;
//    var grossCargoMeasurementTmpObj;
//
//    if(null==idx)
//    {
//        containerNoObj              = containerNo;
////        containerType = document.forms[0].containerType;
//        carrierSeal                 = document.forms[0].carrierSeal;
//        shipperSeal                 = document.forms[0].shipperSeal;
//        ofPackages                  = document.forms[0].ofPackages;
//        packagesKind                = document.forms[0].packagesKind;
//        grossContainerWeight        = document.forms[0].grossContainerWeight;
////        ladenMt = document.forms[0].ladenMt;
//        grossCargoMeasurement       = document.forms[0].grossCargoMeasurement;
//
//        containerNoTmpObj           = containerNoTmp;
//        carrierSealTmpObj           = carrierSealTmp;
//        shipperSealTmpObj           = shipperSealTmp;
//        ofPackagesTmpObj            = ofPackagesTmp;
//        packagesKindTmpObj          = packagesKindTmp;
//        grossContainerWeightTmpObj  = grossContainerWeightTmp;
//        grossCargoMeasurementTmpObj = grossCargoMeasurementTmp;
//
//
//        //alert('grossContainerWeightTmpObj = '+grossContainerWeightTmpObj+' : grossContainerWeight = '+replaceCommaToBlank(grossContainerWeight.value)+'\ngrossCargoMeasurementTmpObj = '+grossCargoMeasurementTmpObj+' : grossCargoMeasurement = '+replaceCommaToBlank(grossCargoMeasurement.value));
//    }
//    else
//    {
//        containerNoObj              = containerNo[idx];
////        containerType = document.forms[0].containerType[idx];
//        carrierSeal                 = document.forms[0].carrierSeal[idx];
//        shipperSeal                 = document.forms[0].shipperSeal[idx];
//        ofPackages                  = document.forms[0].ofPackages[idx];
//        packagesKind                = document.forms[0].packagesKind[idx];
//        grossContainerWeight        = document.forms[0].grossContainerWeight[idx];
////        ladenMt = document.forms[0].ladenMt[idx];
//        grossCargoMeasurement       = document.forms[0].grossCargoMeasurement[idx];
//
//        containerNoTmpObj           = containerNoTmp[idx];
////        containerTypeTmp = containerTypeTmp[idx];
//        carrierSealTmpObj           = carrierSealTmp[idx];
//        shipperSealTmpObj           = shipperSealTmp[idx];
//        ofPackagesTmpObj            = ofPackagesTmp[idx];
//        packagesKindTmpObj          = packagesKindTmp[idx];
//        grossContainerWeightTmpObj  = grossContainerWeightTmp[idx];
////        ladenMtTmp = ladenMtTmp[idx];
//        grossCargoMeasurementTmpObj = grossCargoMeasurementTmp[idx];
//
//        //alert('grossContainerWeightTmp['+idx+'] = '+grossContainerWeightTmpObj+' : grossContainerWeight = '+replaceCommaToBlank(grossContainerWeight.value)+'\ngrossCargoMeasurementTmp['+idx+'] = '+grossCargoMeasurementTmpObj+' : grossCargoMeasurement = '+replaceCommaToBlank(grossCargoMeasurement.value));
//    }
//
//    if(containerNoObj.value!=containerNoTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('Container No.', idx);
//    }
////    if(containerType.value!=containerTypeTmp)
////    {
////        msgFieldChanged += getEquipmentLineToShow('Container Type', idx);
////    }
//    if(carrierSeal.value!=carrierSealTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('Carrier Seal', idx);
//    }
//    if(shipperSeal.value!=shipperSealTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('Shipper Seal', idx);
//    }
//    if(replaceCommaToBlank(ofPackages.value)!=ofPackagesTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('# of Packages', idx);
//    }
//    if(packagesKind.value!=packagesKindTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('Package Kind', idx);
//    }
//    if(replaceCommaToBlank(grossContainerWeight.value)!=grossContainerWeightTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('Gross Cargo Weight (KG)', idx);
//    }
////    if(ladenMt.value!=ladenMtTmp)
////    {
////        msgFieldChanged += getEquipmentLineToShow('Laden / MT', idx);
////    }
//    if(replaceCommaToBlank(grossCargoMeasurement.value)!=grossCargoMeasurementTmpObj)
//    {
//        msgFieldChanged += getEquipmentLineToShow('Gross Cargo Measurement (CBM)', idx);
//    }
//
//    return msgFieldChanged;
//}

//function hasFieldEquipmentDetailChanged()
//{
//    var containerNo = document.forms[0].containerNo;
//    var msgFieldChanged = '';
//
//    if(undefined==containerNo.length)
//    {
//        return equipmentFieldChanged(containerNo, null);
//    }
//    else
//    {
//        for(var i=0;i<containerNo.length;i++)
//        {
//            msgFieldChanged += equipmentFieldChanged(containerNo, i);
//        }
//    }
//
//    return msgFieldChanged;
//}

function equipmentFieldChanged(containerNo, idx)
{
    var containerNoObj;
    var carrierSeal;
    var shipperSeal;
    var ofPackages;
    var packagesKind;
    var grossContainerWeight;
    var grossCargoMeasurement;
    var msgFieldChanged = '';

    var containerNoTmpObj;
    var carrierSealTmpObj;
    var shipperSealTmpObj;
    var ofPackagesTmpObj;
    var packagesKindTmpObj;
    var grossContainerWeightTmpObj;
    var grossCargoMeasurementTmpObj;

    try{

//    alert("idx "+idx);
        if(null==idx){
            containerNoObj              = containerNo;
            carrierSeal                 = document.forms[0].carrierSeal;
            shipperSeal                 = document.forms[0].shipperSeal;
            ofPackages                  = document.forms[0].ofPackages;
            packagesKind                = document.forms[0].packagesKind;
            grossContainerWeight        = document.forms[0].grossContainerWeight;
            grossCargoMeasurement       = document.forms[0].grossCargoMeasurement;

            containerNoTmpObj           = containerNoTmp;
            carrierSealTmpObj           = carrierSealTmp;
            shipperSealTmpObj           = shipperSealTmp;
            ofPackagesTmpObj            = ofPackagesTmp;
            packagesKindTmpObj          = packagesKindTmp;
            grossContainerWeightTmpObj  = grossContainerWeightTmp;
            grossCargoMeasurementTmpObj = grossCargoMeasurementTmp;

        }else{
            containerNoObj              = containerNo[idx];
            carrierSeal                 = document.forms[0].carrierSeal[idx];
            shipperSeal                 = document.forms[0].shipperSeal[idx];
            ofPackages                  = document.forms[0].ofPackages[idx];
            packagesKind                = document.forms[0].packagesKind[idx];
            grossContainerWeight        = document.forms[0].grossContainerWeight[idx];
            grossCargoMeasurement       = document.forms[0].grossCargoMeasurement[idx];

            containerNoTmpObj           = containerNoTmp[idx];
            carrierSealTmpObj           = carrierSealTmp[idx];
            shipperSealTmpObj           = shipperSealTmp[idx];
            ofPackagesTmpObj            = ofPackagesTmp[idx];
            packagesKindTmpObj          = packagesKindTmp[idx];
            grossContainerWeightTmpObj  = grossContainerWeightTmp[idx];
            grossCargoMeasurementTmpObj = grossCargoMeasurementTmp[idx];

        }
//        alert("containerNoObj "+containerNoObj);
//        alert("carrierSeal "+carrierSeal);
//        alert("shipperSeal "+shipperSeal);
//        alert("ofPackages "+ofPackages);
//        alert("packagesKind "+packagesKind);
//        alert("grossContainerWeight "+grossContainerWeight);
//        alert("grossCargoMeasurement "+grossCargoMeasurement);
//
        //alert(containerNoObj);
        if(!isNullObj(containerNoObj)){
            if(containerNoObj.value!=containerNoTmpObj)                                         msgFieldChanged += getEquipmentLineToShow('Container No.', idx);
        }
        //alert(carrierSeal);
        if(!isNullObj(carrierSeal)){
            if(carrierSeal.value!=carrierSealTmpObj)                                            msgFieldChanged += getEquipmentLineToShow('Carrier Seal', idx);
        }
        //alert(shipperSealTmpObj);
        if(!isNullObj(shipperSeal)){
            if(shipperSeal.value!=shipperSealTmpObj)                                            msgFieldChanged += getEquipmentLineToShow('Shipper Seal', idx);
        }
        //alert(ofPackages);
        if(!isNullObj(ofPackages)){
            if(replaceCommaToBlank(ofPackages.value)!=ofPackagesTmpObj)                         msgFieldChanged += getEquipmentLineToShow('# of Packages', idx);
        }
        //alert(packagesKindTmpObj);
        if(!isNullObj(packagesKind)){
            if(packagesKind.value!=packagesKindTmpObj)                                          msgFieldChanged += getEquipmentLineToShow('Package Kind', idx);
        }
        //alert(grossContainerWeight);
        if(!isNullObj(grossContainerWeight)){
            if(replaceCommaToBlank(grossContainerWeight.value)!=grossContainerWeightTmpObj)     msgFieldChanged += getEquipmentLineToShow('Gross Cargo Weight (KG)', idx);
        }
        //alert(grossCargoMeasurement);
        if(!isNullObj(grossCargoMeasurement)){
            if(replaceCommaToBlank(grossCargoMeasurement.value)!=grossCargoMeasurementTmpObj)   msgFieldChanged += getEquipmentLineToShow('Gross Cargo Measurement (CBM)', idx);
        }
    }catch(e){
        alert("equipmentFieldChanged :: " + e.message);
    }
//    alert("msgFieldChanged >> "+msgFieldChanged);
    return msgFieldChanged;
}

function hasFieldEquipmentDetailChanged(){
    var containerNo     = null;
    var msgFieldChanged = '';

    try{
        containerNo     = document.getElementsByName("containerNo");
        msgFieldChanged = '';
//        alert("containerNo "+containerNo);
        if(undefined==containerNo.length){
            return equipmentFieldChanged(containerNo, null);
        }
        else{
            for(var i=0;i<containerNo.length;i++){
                msgFieldChanged += equipmentFieldChanged(containerNo, i);
            }
        }

    }catch(e){
        alert("hasFieldEquipmentDetailChanged :: " + e);
    }

    return msgFieldChanged;
}

function submitBtns(){

	debugger;
	
	
  
    /*msgFieldChanged = msgHeaderFieldChanged+msgDetailFieldChanged;

    if(''!=msgFieldChanged)
    {
        msgFieldChanged = msgFieldChanged.substring(0, msgFieldChanged.length-1);
    }

    if(''!=msgFieldChanged)
    {
        showBarMessageNew((templateFieldChanged.replace("{0}", msgFieldChanged)), MSG_ERROR_CODE);
        return;
    }*/
   try{
	   	
	    var bookingNo = document.getElementById("bookingNo").value;
       //alert(bookingNo);
	   	if(bookingNo !=""){
	   		
	   		$.ajax({
	               type: "POST",
	               url: VALIDATE_DATA_CHANGE,
	               data: "bookingNo="+bookingNo,
	               success: function(data){
	            	    //alert(gp_trim(data));
		               	if (gp_trim(data) == "1"){
		               		var result = confirm("Due to booking details has been changed\nPlease click [OK] to cancel your eShipping instruction.");
		                       if (result == true) {
		                    	   loading();
			        	           document.forms[0].action = CLEAR_ESI_DATA;
			        	           document.forms[0].submit();
		                       }
		               	}else if (gp_trim(data) == "2"){
		               		showBarMessageNew("Booking Status is subject to CONFIRMED before create eSI.", 1);
							window.scrollTo(500, 0);
	        	            return;
		               	}else if(gp_trim(data) == "3"){
							showBarMessageNew("Booking Status is not Confirm.", 1);
							window.scrollTo(500, 0);
					    }else{
		               		var error_no = 0;
		        	        var templateFieldChanged = "Field(s) {0} has Changed, please Save before Submit SI.";error_no = 1;
		        	
		        	        /*var msgFieldChanged       = document.getElementById("msgFieldChanged").value;error_no = 2;
		        	        var msgHeaderFieldChanged = hasFieldHeaderChanged();error_no = 3;
		        	        var msgDetailFieldChanged = hasFieldEquipmentDetailChanged();error_no = 4;
		        	        if(msgFieldChanged==""){
		        	            msgFieldChanged = msgHeaderFieldChanged+msgDetailFieldChanged;
		        	            if(''!=msgFieldChanged)
		        	            {
		        	                msgFieldChanged = msgFieldChanged.substring(0, msgFieldChanged.length-1);
		        	            }
		        	            if(''!=msgFieldChanged)
		        	            {
		        	                document.getElementById("msgFieldChanged").value = msgFieldChanged;
		        	                showBarMessageNew((templateFieldChanged.replace("{0}", msgFieldChanged)), MSG_ERROR_CODE);
		        	                return;
		        	            }
		        	        }else{
		        	            showBarMessageNew((templateFieldChanged.replace("{0}", msgFieldChanged)), MSG_ERROR_CODE);
		        	            return;
		        	        }*/
		        	
		        	        if(validate()){
			
								debugger;
		                          	$.ajax({
						                type: "POST",
						                url: VALIDATE_DATA_CONATINER_NO,
						                data: "containerArrayJson="+containerArray.toString(),
								         success: function(Result){
											debugger;
											var erMsg="";
											var obj = JSON.parse(Result);
											for(x in obj.Result){
											    console.log(obj.Result[x]);
												if(obj.Result[x]=='NA'){
													if(erMsg=='')
														erMsg = erMsg+x ;
													else
														erMsg = erMsg+','+x;
												}
											}
											
											if(erMsg!=''){
												showBarMessageNew(erMsg+" : Invalid Container numbers.", 1);
												window.scrollTo(500, 0);
												return false;
											}else{
												setCargoDetailsAllData();
												
												showButton(SUBMITTED_AFTER_MODE);
												
												document.getElementById("previewDisabledBtn").style.display = 'none';
												document.getElementById("previewBtn").style.display = 'none';
												loading();
												document.forms[0].action = SUBMIT_ESI;
												document.forms[0].submit();
												}
											}
										});
		        	        }
		               	}
	               }
	           });
	       }	
    }catch(e){
        handleJavaScriptError('submitBtn', err, error_no);
    }
}

function saveDraftBtn(){
		
    try{
        error_code = 1;
        clearMsg();
        error_code = 2;
        //alert('saveDraftBtn');
        
        var bookingNo = document.getElementById("bookingNo").value;
        //alert(bookingNo);
    	if(bookingNo !=""){
    		
    		$.ajax({
                type: "POST",
                url: VALIDATE_DATA_CHANGE,
                data: "bookingNo="+bookingNo,
               // beforeSend: showBarMessageNew(MSG_LOADING, 2),
                success: function(data){
                	//alert(gp_trim(data));
                	if (gp_trim(data) == "1"){
                		var result = confirm("Due to booking details has been changed\nPlease click [OK] to refresh your eShipping instruction.");
                        if (result == true) {
                        	loading();
	        	            document.forms[0].action = CLEAR_ESI_DATA;
	        	            document.forms[0].submit();
                        }
                	}else if (gp_trim(data) == "2"){
	               		showBarMessageNew("Booking Status is subject to CONFIRMED before create eSI.", 1);
						window.scrollTo(500, 0);
                	}else if(gp_trim(data) == "3"){
						showBarMessageNew("Booking Status is not Confirm.", 1);
						window.scrollTo(500, 0);
					}else{
                		if(validate()){
							debugger;
                          	$.ajax({
				                type: "POST",
				                url: VALIDATE_DATA_CONATINER_NO,
				                data: "containerArrayJson="+containerArray.toString(),
						         success: function(Result){
									debugger;
									var erMsg="";
									var obj = JSON.parse(Result);
									for(x in obj.Result){
									    console.log(obj.Result[x]);
										if(obj.Result[x]=='NA'){
											if(erMsg=='')
												erMsg = erMsg+x ;
											else
												erMsg = erMsg+','+x;
										}
									}
									
									if(erMsg!=''){
										showBarMessageNew(erMsg+" : Invalid Container numbers.", 1);
										window.scrollTo(500, 0);
										return false;
									}else{
									        error_code = 3;
									        setCargoDetailsAllData();
									        error_code = 4;
									        showButton(SUBMITTED_AFTER_MODE);
									        error_code = 5;
									//      @10 BEGIN
									        loading();
									//      @10 END
									        error_code = 6;
									        document.forms[0].action = SAVE_AS_DRAFT;
									        document.forms[0].submit();
									        error_code = 7;
										}
									}
								});
                        }
                	}
                }
            });
        }			
        
    }catch(err){
        handleJavaScriptError('saveDraftBtn', err, error_code);
    }
}
//@07 BEGIN

function showButtonAfterSubmitClick(){
    var browseBookingNoBtn = document.getElementById('browseBookingNoBtn');
    browseBookingNoBtn.className = CLASS_NAME_DISABLED_BUTTON;
    browseBookingNoBtn.onClick = '';

    var deleteCommTd = document.getElementById("deleteCommTd");
    if(deleteCommTd != null && deleteCommTd != undefined){
        deleteCommTd.style.display = 'none';
    }

    var addCommBtn = document.getElementById("addCommBtn");
    if(addCommBtn != null && addCommBtn != undefined){
        addCommBtn.style.display = 'none';
    }

    /*Begin @15*/
    /*var btnCargoDetails = document.getElementById('btnCargoDetails');
    if(btnCargoDetails != null && btnCargoDetails != undefined){
        btnCargoDetails.className = CLASS_NAME_DISABLED_BUTTON;
    }*/
    var la_btnCargoDetails = document.getElementsByName('btnCargoDetails');
    for(var i=0;i<la_btnCargoDetails.length;i++){
        la_btnCargoDetails.className = CLASS_NAME_DISABLED_BUTTON;
    }
    /*End @15*/
}
//@07 END

function getWebBookingData(parentForm, params){
    try{
    	debugger;
        error_code = 1;
        var url = GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE;
        parentForm.action = url+params;
        error_code = 2;
        parentForm.submit();
    }catch(err){

          txt="JAVASCRIPT ERROR ON CALL DATA.\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }
}

function maskWithOutDecimal(aField, aintDigits, aintDecimals){
    try{
        error_code =0;
        putMask_Number(aField, aintDigits, aintDecimals)
        error_code =1;
        var val = aField.value
        error_code=2;
        var dotIndex=val.indexOf('.');
        error_code=3;
        aField.value = val.substring(0,dotIndex);

    }
    catch(err){
        handleJavaScriptError('maskWithOutDecimal', err,error_code);
    }
}

function putMask_NumberEX(aField, aintDigits, aintDecimals){
    try{
	debugger;
        error_code =0;
        var val = aField.value
        error_code =1;
        var dotIndex=val.indexOf('.');
        error_code=2;
        if(dotIndex > 0){
            var fullValue = val.substring(0,dotIndex);
            var decimalValue = val.substring(dotIndex+1);
            var cutDecimal = decimalValue.substring(0,aintDecimals);
            aField.value = fullValue+"."+cutDecimal;
        }


        error_code=3;

        putMask_Number(aField, aintDigits, aintDecimals)


    }
    catch(err){
        handleJavaScriptError('putMask_NumberEX', err,error_code);
    }
}

function displayBLType(blArcheTypeVal)
{
    var esiStatus = document.getElementsByName('esiStatusCode')[0].value;
    if(SUBMITTED_MODE != esiStatus)
    {
        document.getElementById('blType').disabled = (blArcheTypeVal>1);
    }
}

function displayBLTypeFromCallback(esiStatus)
{
	debugger;
    if(''!=esiStatus)
    {
        var choiceRad = document.getElementById('choiceRad');
        if(SUBMITTED_MODE==esiStatus)
        {
            document.getElementById('blType').disabled = true;
        }
        else
        {
            document.getElementById('blType').disabled = false;
        }
//        else if(!choiceRad.checked)
//        {
//            document.getElementById('blType').disabled = true;
//        }
    }
    else
    {
        document.getElementById('blType').disabled = false;
    }
}

    // teerakan add 18/06/2013 to eSI - Preview
    function getPDF(){
        var url = PRIVIEW_PDF_REPORT;
        var esiStatus = document.forms[0].esiStatusDesc.value;
         var blNumber = document.forms[0].blNumber.value;
//@18 Start
             var bookingNo = document.forms[0].bookingNo.value;
            openHelpList(url+"?blNumber="+bookingNo+"&esiStatus="+esiStatus,850,650);
//         if(SUBMITTED_MODE == esiStatus){
//                if(blNumber!=""){
//                  openHelpList(url+"?blNumber="+blNumber+"&esiStatus="+esiStatus,850,650);
//                  }else{
//                   showBarMessageNew("No record found",1);
//                  }
//
//        }else{
//             var bookingNo = document.forms[0].bookingNo.value;
//            openHelpList(url+"?blNumber="+bookingNo+"&esiStatus="+esiStatus,850,650);
//        }
//@18 End
  }
// End teerakan add 18/06/2013 to eSI - Preview


function gotoToSearchBookingEsi(obj)
{
    if(event.keyCode == 13 || event.keyCode == 9)
    {
    	
    	var bookingNo = document.getElementById("bookingNo").value;
        
    	if(bookingNo !=""){
    		$.ajax({
                type: "POST",
                url: VALIDATE_DATA_CHANGE,
                data: "bookingNo="+bookingNo,
                beforeSend: showBarMessageNew(MSG_LOADING, 2),
                success: function(data){
                	//alert(gp_trim(data));
                	if (gp_trim(data) == '1'){
                		var result = confirm("Due to booking details has been changed\nPlease click [OK] to refresh your eShipping instruction.");
                        if (result == true) {
                        	loading();
	        	            document.forms[0].action = CLEAR_ESI_DATA;
	        	            document.forms[0].submit();
                        }else{
                        	//showBarMessageNew("Ready", 0);
                        }
                	}else if (gp_trim(data) == "2"){
	               		showBarMessageNew("Booking Status is subject to CONFIRMED before create eSI.", 1);
window.scrollTo(500, 0);
                	}else{
                		loading();
    	            	getWebBookingDataOnBlurForShipping(obj);
                	}
                }
            });
        }    	
    }
}

function validateDataChange(){
	var bookingNo = document.getElementById("bookingNo").value;
    
	if(bookingNo !=""){
		$.ajax({
            type: "POST",
            url: VALIDATE_DATA_CHANGE,
            data: "bookingNo="+bookingNo,
            beforeSend: showBarMessageNew(MSG_LOADING, 2),
            success: function(data){
            	
            	if (gp_trim(data) == 1){
            		alert("true="+gp_trim(data));
            		return true;
            	}else{
            		alert("false="+gp_trim(data));
            		return false;
            	}
            }
        });
    }
}

function clearESIDataChange(bookingNo){
	alert(1);
	var url = CLEAR_ESI_DATA;
    parentForm.action = url+"?bookingNo="+bookingNo;
    parentForm.submit();
}

function LoadModalDiv() {
    var bcgDiv = document.getElementById("divBackground");
    bcgDiv.style.display = "block";
    if (bcgDiv != null) {
        if (document.body.clientHeight > document.body.scrollHeight) {
            bcgDiv.style.height = document.body.clientHeight + "px";
        }
        else {
            bcgDiv.style.height = document.body.scrollHeight + "px";
        }
        bcgDiv.style.width = "100%";
    }
}
function HideModalDiv() {
    var bcgDiv = document.getElementById("divBackground");
    bcgDiv.style.display = "none";
}

//@04 BEGIN
function changeField(obj)
{
//alert("1");
    var fieldValue = eval("document.getElementById(\'"+obj+"\')");
//    alert(fieldValue);
    if(event.keyCode == 9)
    {
//    alert("obj "+fieldValue);

//    document.getElementById("shipperAddress3").focus();
        fieldValue.focus();
    }
}
//@04 END
//@05 BEGIN
function extendDivSize(rowIndex, objDiv){
    switch(rowIndex)
        {
        case 0:
          objDiv.style.height = "30px";
          break;
        case 1:
          objDiv.style.height = "60px";
          break;
        case 2:
          objDiv.style.height = "90px";
          break;
        case 3:
          objDiv.style.height = "120px";
          break;
        case 4:
          objDiv.style.height = "150px";
          break;
        default:
          objDiv.style.height = "150px";
    }

}

//function openCommodityGroupLookup(aintIndex) {
//
//
//    var urlStr = BROWSE_COMMODITY+'?';
//    urlStr += 'commodityRowIndex='+aintIndex;
//    //urlStr += '&openMode=firstLoad';
//
//    setCargoDetailsAllData();
//
//        alert('openCommodityGroupLookup1');
//    openHelpList(urlStr, 800, 500);
//    return false;
//}

//function openCommodityGroupLookup(rowIndex) {
//    var url = COMMODITY_LOOKUP+'?commodityRowIndex=' +rowIndex ;
//    openHelpList(url, 800, 400);
//} // openCommodityGroupLookup

//function setCommodityLookupValues(commodityCode, commodityDesc, commodityGroupCode, commodityGroupDesc, commodityRowIndex) {
//    var params = "commodityCode="+commodityCode;
//    try{
//        params += "&commodityDesc="+commodityDesc;
//        params += "&commodityGroupCode="+commodityGroupCode;
//        params += "&commodityGroupDesc="+commodityGroupDesc;
//        params += "&commodityRowIndex="+commodityRowIndex;
////        @10 BEGIN
//        loading();
////        @10 END
//        document.forms[0].action = SET_COMMODITY_DATA+"?"+params;
//        document.forms[0].submit();
//
//    }catch(err){
//       // handleJavaScriptError('setCommodityLookupValues', err, error_code);
//    }
//} //setLookupValues
//@05 END

/*Begin @15*/
function setCommodityLookupValues(commodityCode, commodityDesc, commodityGroupCode, commodityGroupDesc, commodityRowIndex) {
debugger;    
var la_strCommCode          = null;
    var la_strCommDesc          = null;
    var la_strCommGroupCode     = null;
    var la_strCommGroup         = null;

    try{
        la_strCommCode              = document.getElementsByName("strCommCode");
        la_strCommDesc              = document.getElementsByName("strCommDesc");
        la_strCommGroupCode         = document.getElementsByName("strCommGroupCode");
        la_strCommGroup             = document.getElementsByName("strCommGroup");

        la_strCommCode[commodityRowIndex].value         = commodityCode;
        la_strCommDesc[commodityRowIndex].value         = commodityDesc;
        la_strCommGroupCode[commodityRowIndex].value    = commodityGroupCode;
        la_strCommGroup[commodityRowIndex].value        = commodityGroupDesc;

        updateCommodity(la_strCommCode[commodityRowIndex]);

    }catch(err){
        handleJavaScriptError('setCommodityLookupValues', err, error_code);
    }
}
/*End @15*/


//@06 BEGIN
function checkDuplicateContainerNo(rowChangedId){
    var allContainerNo = document.getElementsByName('containerNo');
    var currContainerNo;
    var containerNoChanged;
    var allContainerNoLength = 0;
    var errMsg = '';

    var isDuplicate = false;
    try{
        if(allContainerNo != null && allContainerNo != undefined){
            allContainerNoLength = allContainerNo.length;
            if(allContainerNoLength > 0){
                containerNoChanged = allContainerNo[rowChangedId];
                if(containerNoChanged != null && containerNoChanged.value != undefined && containerNoChanged.value != ''){
                    for(count = 0; count<allContainerNoLength; count++){
                        currContainerNo = allContainerNo[count].value;
                        if((count != rowChangedId) && (containerNoChanged.value == currContainerNo)){
                            errMsg = 'Same container numbers are found at row '+(rowChangedId+1)+' and '+(count+1)+'.';
                            //containerNoChanged.value = prevContainerNo;
                            containerNoChanged.value = '';
                            isDuplicate = true;

                            break;
                        }
                    }
                }
            }
        }
    }catch(err){
        handleJavaScriptError('checkDuplicateContainerNo', err, error_code);
        errorMsg = err.message;
        isDuplicate = true;
    }finally{
        if(isDuplicate){
            showBarMessageNew(errMsg,1);
window.scrollTo(500, 0);
        }else{
           // showBarMessageNew('Ready');
        }
    }
    return isDuplicate;
}
//@06 BEGIN
function editContainerNo(rowChangedId){
    var allContainerNo = document.getElementsByName('containerNo');
    var containerNoChanged;
    var allContainerNoLength = 0;
    try{
        if(allContainerNo != null && allContainerNo != undefined){
            allContainerNoLength = allContainerNo.length;
            if(allContainerNoLength > 0){
                containerNoChanged = allContainerNo[rowChangedId];
                if(containerNoChanged != null && containerNoChanged.value != undefined){
                    prevContainerNo = containerNoChanged.value;
                }else{
                    prevContainerNo = '';
                }
            }else{
                prevContainerNo = '';
            }
        }else{
            prevContainerNo = '';
        }
    }catch(err){
        prevContainerNo = '';
        showBarMessageNew(err.message,1);
window.scrollTo(500, 0);
    }
}
//@06 END
//function getActionUrl()
//{
//    if(BOOOKING_POPUP==document.forms[0].pageId.value)
//    {
//        return BROWSE_BOOKING_NUMBER;
//    }
//    else if(CUSTOMER_POPUP==document.forms[0].pageId.value)
//    {
//        var cocSoc = parent.opener.document.forms[0].cocSoc.value;
//        return BROWSE_CUSTOMER_DATA+"?cocSoc="+cocSoc+"&defaultSearch=false";
//    }
//    else if(PACKAGE_KIND_POPUP==document.forms[0].pageId.value)
//    {
//        return BROWSE_PACKGAE_KIND_DATA;
//    }
//}
//=============================================
// OLD VERSION
//=============================================
//@14 BEGIN
function validateCargoDetailsSave(objCheckSave){
    var obj = null;
    var msg = null;
    var errMsgTemplate = "Please input value \"{0}\" at item {1}";
    var containerNoMsg = "Container No.";
    var containerTypeMsg = "Container Type";
    var carrierSealMsg = "Carrier Seal";
    var shipperSealMsg = "Shipper Seal";
    var packagesKindMsg = "Package Kind";
    var ladenMtMsg = "Laden / MT";
//    @12 BEGIN
    var grossWeightMsg = "Cargo Gross Weight";
    var containerNo = document.getElementsByName('containerNo');
    var containerNoValue = null;
    var grossWeight = document.getElementsByName('grossContainerWeight');
    var grossWeightValue = null;
    var commodityWeight = document.getElementsByName('strCommWeight');
    var commodityWeightValue = null;

    var head = null;
    var detail = null;

    var totalCommodityWeight = 0.00;
    var totalGrossWeight = 0.00;
//    @12 END
//    @13 BEGIN
    var cocSoc = document.getElementsByName('cocSoc');
    var hasContainerNo = false;
//    @13 END
    //@03 BEGIN
    var isError = false;
    var strHasError = "no";
    //@03 END
    try{
//        @12 BEGIN
        if(commodityWeight != undefined){
            for(var currRow=0, totalRow=commodityWeight.length; currRow<totalRow; currRow++){
                commodityWeightValue = commodityWeight[currRow].value;
                if(commodityWeightValue != undefined && '' != commodityWeightValue){
                    commodityWeightValue = commodityWeightValue.replace(',','');
                    totalCommodityWeight += parseInt(commodityWeightValue);
                }
            }
        }
//        @12 END
        if(containerNo != undefined){
            for(var currRow=0, totalRow=containerNo.length; currRow<totalRow; currRow++){
                isError = false;
                strHasError = "no";
                for(var currCheckSaveRow=0, totalCheckSaveRow=objCheckSave.length; currCheckSaveRow<totalCheckSaveRow ; currCheckSaveRow++){
                    obj = objCheckSave[currCheckSaveRow];
                    if(obj[currRow].value == undefined || obj[currRow].value == ''){
                        obj[currRow].focus();
                        msg = eval(obj[currRow].name+"Msg");
                        return (errMsgTemplate.replace("{0}", msg)).replace("{1}", (currRow+1));
                    }
                }
                //@03 BEGIN
                containerNoValue = containerNo[currRow].value;
                if(containerNoValue != ''){
                    hasContainerNo = true;
                    head = containerNoValue.substring(0,4);
                    detail = containerNoValue.substring(4);
                    if(containerNoValue.length != 11){
                        isError = true;
                    }
                    if(!isNaN(head.substring(0,1))){
                        isError = true;
                    }
                    if(!isNaN(head.substring(1,2))){
                        isError = true;
                    }
                    if(!isNaN(head.substring(2,3))){
                        isError = true;
                    }
                    if(!isNaN(head.substring(3,4))){
                        isError = true;
                    }
                    if(isNaN(detail)){
                        isError = true;
                    }
                    if(isError){
                        containerNo[currRow].focus();
                        return "Please input valid container no. at row"+(currRow+1);
                    }
                }
                //@03 END
//                @12 BEGIN
                grossWeightValue = grossWeight[currRow].value;
                if(grossWeightValue != undefined && '' != grossWeightValue){
                    grossWeightValue = grossWeightValue.replace(',','');
                    totalGrossWeight += parseInt(grossWeightValue);
                }
//                @12 END
            }
//            @12 BEGIN
            if(totalCommodityWeight != totalGrossWeight){
                return 'Summary of Cargo Gross Weight of Equipment must equal Summary of Commodity Gross Weight.';
           }
//            @12 BEGIN
        }
//        @13 BEGIN
//        if(cocSoc != undefined && cocSoc[0].value != undefined && cocSoc[0].value == 'C' ){
//            if(!hasContainerNo){
//                return 'Please input valid container no. at least one.';
//            }
//        }
    }catch(err){
        handleJavaScriptError('validateCargoDetailsSave', err, error_code);
    }
}

function validateHeaderSave()
{
    var bookingNo = document.forms[0].bookingNo;
    var contact = document.forms[0].contact;
    var shipperName = document.forms[0].shipperName;
    var shipperAddress1 = document.forms[0].shipperAddress1;
    var consigneeName = document.forms[0].consigneeName;
    var consigneeAddress1 = document.forms[0].consigneeAddress1;
    var notifyPartyName = document.forms[0].notifyPartyName;
    var notifyPartyAddress1 = document.forms[0].notifyPartyAddress1;
    var pol = document.forms[0].pol;
    var pod = document.forms[0].pod;
    var placeOfReceipt = document.forms[0].placeOfReceipt;
    var placeOfDelivery = document.forms[0].placeOfDelivery;

    if(" "==consigneeName.value)
    {
        consigneeName.value = '';
    }
    if(" "==consigneeAddress1.value)
    {
        consigneeAddress1.value = '';
    }
    if(" "==notifyPartyName.value)
    {
        notifyPartyName.value = '';
    }
    if(" "==notifyPartyAddress1.value)
    {
        notifyPartyAddress1.value = '';
    }

    if(''==bookingNo.value)
    {
        bookingNo.focus();
        return "Please select \"Booking No\"";
    }
    else if(''==contact.value)
    {
        contact.focus();
        return "Please input value \"Contact\"";
    }
    else if(''==shipperName.value)
    {
        shipperName.focus();
        return "Please input value \"Shipper Name\"";
    }
    else if(''==shipperAddress1.value)
    {
        shipperAddress1.focus();
        return "Please input value \"Shipper Address\"";
    }
    else if(''==consigneeName.value)
    {
        consigneeName.focus();
        return "Please input value \"Consignee Name\"";
    }
    else if(''==consigneeAddress1.value)
    {
        consigneeAddress1.focus();
        return "Please input value \"Consignee Address\"";
    }
    else if(''==notifyPartyName.value)
    {
        notifyPartyName.focus();
        return "Please input value \"Notify Party Name\"";
    }
    else if(''==notifyPartyAddress1.value)
    {
        notifyPartyAddress1.focus();
        return "Please input value \"Notify Party Address\"";
    }
    else if(''==pol.value)
    {
        pol.focus();
        return "Please input value \"Port of Loading(POL)\"";
    }
    else if(''==pod.value)
    {
        pod.focus();
        return "Please input value \"Port of Discharge(POD)\"";
    }
    else if(''==placeOfReceipt.value)
    {
        placeOfReceipt.focus();
        return "Please input value \"Place of Receipt\"";
    }
    else if(''==placeOfDelivery.value)
    {
        placeOfDelivery.focus();
        return "Please input value \"Place of Delivery\"";
    }
}
function onLoad2(){
    var bookinNotFound = "Invalid Booking number.";
    //@02 BEGIN
    //alert('11');
    var errorMsg = document.getElementsByName("esiErrMsg");
    if(!isNullObj(errorMsg[0]) && !isNullObj(errorMsg[0].value) && !isBlank(errorMsg[0].value)){
        showBarMessageNew(errorMsg[0].value, MSG_ERROR_CODE);
window.scrollTo(500, 0);
        errorMsg[0].value = "";
    }
//        var errorMsg = document.forms[0].newWebBookingErrMsg;
//    alert('12');
    var notFound = document.getElementById("notFound");
    if(null!=notFound)
    {
        var bookingNo = document.getElementById("bookingNo").value;
        showMsgFromServer(notFound, bookinNotFound, MSG_ERROR_CODE);
    }
//    alert('13');
    var saveDraftIsSuccess = document.getElementById("saveDraftIsSuccess");
    if(null!=saveDraftIsSuccess)
    {
        showMsgFromServer(saveDraftIsSuccess, "SI saved successfully! Click on Submit SI to submit it to RCL Documentation Department.", 0);
        saveDraftIsSuccess.value = 'false';
    }
//    alert('14');
    var submitIsSuccess = document.getElementById("submitIsSuccess");
    if(null!=submitIsSuccess)
    {
        showMsgFromServer(submitIsSuccess, "Submit SI saved successfully!", 0);
        submitIsSuccess.value = 'false';
    }
//    alert('15');
    var choiceRad = document.getElementById('choiceRad');
    var esiStatus = document.getElementById("esiStatusCode");
    if(null != esiStatus)
    {
        displayBLTypeFromCallback(esiStatus.value);
//        alert('esiStatus4');
        showButton(esiStatus.value);
//        alert("esiStatus "+esiStatus.value);
        if(IN_PROGRESS_MODE==esiStatus.value)
        {
            //alert('esiStatus5');
            keepOriginalData();
        }
    }else{
        //alert('esiStatus ');
        showButton('');
    }
//    alert('Test1');
    showMaskOnNumberField();
    //alert('Test2');
    showCargoButton();
    //alert('Test3');
    setReadonlyCargoDesc();
//    alert('6');
    var isOpenAcknowledgementPopup =  document.getElementById("openAcknowledgement");

    if(isOpenAcknowledgementPopup != null && isOpenAcknowledgementPopup != undefined){

        if(isOpenAcknowledgementPopup.value == 'true')
        {

            isOpenAcknowledgementPopup.value = 'false';

            var emailAcknowledgment = document.getElementById("emailAcknowledgment").value;
            var vendorTelephone = document.getElementById("vendorTelephone").value;
            var vendorFax = document.getElementById("vendorFax").value;
            var vendorEmail = document.getElementById("vendorEmail").value;
            var bookingNo = document.getElementById("bookingNo").value;
            var blNo = document.getElementById("blNo").value;
            var cocSoc = document.getElementById("cocSoc").value;
            var url = OPEN_ACKNOWLEDGEMENT + '?emailAcknowledgment=' + emailAcknowledgment
                                        + '&vendorTelephone=' + vendorTelephone
                                        + '&vendorFax=' + vendorFax
                                        + '&vendorEmail=' + vendorEmail
                                        + '&bookingNo=' + bookingNo
                                        + '&blNo=' + blNo
                                        + '&cocSoc=' + cocSoc;

            openHelpList(url, 920, 370);
        }
    }
}


function enableEquipment(status){
    var bookingNo = document.getElementById("bookingNo");
    var form = document.forms[0];
    var containerNo = form.containerNo;
    var commodity = form.commodity;
    var disabled = false;

    if(bookingNo == null || bookingNo == undefined || bookingNo.value == ''){
        disabled = true;
    }
    //alert('Booking No = '+bookingNo);
    containerNo.disabled = disabled;
    form.containerType.disabled = disabled;
    form.carrierSeal.disabled = disabled;
    form.shipperSeal.disabled = disabled;
    form.ofPackages.disabled = disabled;
    form.grossContainerWeight.disabled = disabled;
    form.ladenMt.disabled = disabled;
    form.grossCargoMeasurement.disabled = disabled;
    form.cbdelall.disabled = disabled;
    form.cbdel.disabled = disabled;
    if(commodity != null && commodity != undefined){
        commodity.disabled = disabled;
    }
    enablePackagesKind(containerNo, bookingNo.value, status);
}
function enablePackagesKind(containerNo, bookingNo, status){
    var packageKindBtn = null;;
    var className = CLASS_NAME_BUTTON;

    if(SUBMITTED_MODE == status || '' == bookingNo || SUBMITTED_AFTER_MODE == status){
       className = CLASS_NAME_DISABLED_BUTTON;
    }
//    alert('Status = '+status);
    packageKindBtn = document.getElementsByName('btnBrowsePackageKind');
    if(packageKindBtn != null && packageKindBtn != undefined && packageKindBtn.length != undefined){
        for(var countIndex=0, size=packageKindBtn.length; countIndex<size; countIndex++){
            if(packageKindBtn[countIndex] != null && packageKindBtn[countIndex] != undefined){
                //packageKindBtn[countIndex].className = className;
                packageKindBtn[countIndex].onClick = '';
//                alert('round = '+countIndex+' \npackageKindBtn[countIndex].className = '+packageKindBtn[countIndex].className);
            }
        }
    }
//    if(containerNo == null || containerNo == undefined || containerNo.length == undefined){
//        packagesKindBtn = document.getElementsByName('btnBrowsePackageKind')[0];
//        if(packagesKindBtn != null && packagesKindBtn != undefined){
//            packagesKindBtn.className = className;
//        }
//    }else{
//        for(var countIndex=0, size=containerNo.length; countIndex<size; countIndex++){
//            packagesKindBtn = document.getElementById("btnBrowsePackageKind_"+countIndex);
//            if(packagesKindBtn != null && packagesKindBtn != undefined){
//                packagesKindBtn.className = className;
//            }
//        }
//    }
}
//@14 ENDserv013LookUpData
function bakeToShippingInqueryPage(){
	loading();
	var esiStatusCode=$("#esiStatusCode").val();
	bookingUrl = OPEN_SHIPPINGINQUIRY+'?bookingNo=';
				bookingUrl += '&esiStatusCode='+esiStatusCode;
            	bookingUrl += '&bookingType=NORMAL';
            	bookingUrl += '&mode=select';

				document.forms[0].action = bookingUrl;
            	document.forms[0].submit();
}


function hasDuplicates(array) {
		debugger;
		var jsobObj={};
			for(var i=0;i<array.length;i++){
				jsobObj[array[i]]=i;
			}
		var tempArray=[];
			for(var key in jsobObj){
				tempArray.push(key)
			}
		return tempArray.length !== array.length;
}
//function hasDuplicates(array) {
//	debugger;
//    return (new Set(array)).size !== array.length;
//}


function validateMultipleEmails(selectObject,type) {
	debugger;
	var id=selectObject.id
    // Get value on emails input as a string
    var emails = document.getElementById(id).value;;
    
    // Split string by comma into an array
    emails = emails.split(",");

    var valid = true;
    var regex = /^(([^<>()[\]\\.,;:\s@\"\']+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    var invalidEmails = [];
    
    for (var i = 0; i < emails.length; i++) {
        // Trim whitespaces from email address
        emails[i] = emails[i].trim();
        
        // Check email against our regex to determine if email is valid
        if( emails[i] == "" || ! regex.test(emails[i])){
            invalidEmails.push(emails[i]);
        }
    }
    
    // Output invalid emails
    
    if(invalidEmails != 0) {
		showBarMessageNew("Invalid "+type+": "+invalidEmails.join(', '));
		window.scrollTo(500, 0);
		return false; 
    }else{
		$("#alertId").hide();
		return true;
	}
}

function checkSpecialCharacter(selectObject,type)
{
	debugger
	var id=selectObject.id
	var data=document.getElementById(id).value;
	var iChars = "!`@#$%^&*()+=-[]\\\';,./{}|\":<>?~_";   
        for (var i = 0; i < data.length; i++)
        {      
            if (iChars.indexOf(data.charAt(i)) != -1)
            {    
			showBarMessageNew(type+" has special characters. \nThese are not allowed.");
			window.scrollTo(500, 0);
            return false; 
            } 
        }
		return true;
}

function maxlenghtTextAreaBooking(ao_obj, limitNum) {

    var limitField;
    
    try{
        /*alert(fieldName + " " + limitNum);
        limitField = eval("document.getElementById(" + fieldName + ")");
        alert(limitField);*/
        
        if (ao_obj.value.length > limitNum) {
            ao_obj.value = ao_obj.value.substring(0, limitNum);
        } 
    }catch(err){
        alert("maxlenghtTextArea :: " + err);
//          txt="JAVASCRIPT ERROR ON SAVE.\n";
//          txt+="description: " + err.message + "\n";
//          txt+=err+"";
//     //     txt+="point#: " + error_code + "\n";
//          txt+="Click OK to continue.";
//          alert(txt);
    }
}

function checkCommMeasurement(input){
	debugger;
			console.log(input);
			input = input.replace(',','');
			if(input=='NaN'){
				return true;
			}else if(isNaN(input) ){
				return true;
			}else{
				return false;
			}
		}
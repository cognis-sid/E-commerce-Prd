/**
* function called when screen load
*/

/*
-------------------------------------------------------------------------------------------------------------
EserviceNewWebBooking.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author vikas Verma 01/01/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-  lp_onChangeRateType       -ShortDescription-
## 3/07/2013      TANA              01                add check laden and mt both not equal 0
## 11/07/2013     TANA              02                change check template to template name in save template
## 15/07/2013     TANA              03                add count delete row for check delete
## 16/07/2013     TANA              04                delete check QTN on size and type
## 16/07/2013     TANA              05                add tooltip for Empty Pickup Depot Name
## 19/07/2013     Teerakan          06                add foucs and message  error after Gross Container Weight (KG) is blank  and check Cargo Availability Date
## 25/07/2013     TANA              07                add check Empty pickup date less than today
## 30/07/2013     TANA              08                add show and hide button submit and save and change step validate
## 31/07/2013     TANA              09                pass value from dropdown empty pickup depot to hidden field
## 02/08/2013     TANA              10                check duplicate size type and cargo type
## 16/09/2013     TANA              11                check date between sailing date and cargo date
## 16/09/2013     TANA              12                add function decimal for Gross weight
## 23/09/2013     YOSSUN1           13                add validation of desired available date
## 07/10/2013     YOSSUN1           14                add function for set quotation routing detail.
## 18/10/2013     YOSSUN1           15                add function assingValueSize, assingValueType.
                                                      renovat all addEquipment.
## 06/11/2013     YOSSUN1           16                Add message loading.
## 04/12/2013     YOSSUN1           17                Change message loading.
## 06/01/2014     YOSSUN1           18                Add control routing drop downlst.
## 15/01/2014     YOSSUN1           19                Add function.
## 04/08/2014     PRATHA1           20                E-service phase 3.1
## 04/08/2014     PRATHA1           21                Fix bugs E-service phase 3.1
## 24/10/2014     PRATHA1           22                PD_CR_20140826_ESV [Contract Party for registeration]
## 28/12/2015     Watchakorn        23                add validation, if have quotation must select one
-------------------------------------------------------------------------------------------------------------
*/
// ------------------------------ CONSTANTS DECLARATION START
var error_code = 0;
var saveOperationFlag   = "saveOperationFlag";
var msgQtn              = "Please choose quotation number";
var msgEmptyDepot       = "Please choose Empty Pickup Depot";
var msgQtnInfo;
var MODE_SAVE_DRAFT     = 'T';
var MODE_SAVE_BOOKING   = 'N';

var xmlhttp = new XMLHttpRequest();
//alert('EserviceNewWebBooking.js');


// ------------------------------ CONSTANTS DECLARATION END



function onLoad() {
	debugger;
	//alert('onLoad');
    var bookingNo                   = null;
    var bookingUrl                  = null;
    var openAcknowledgement         = null;
//    var objGrossWeight =  document.getElementById("grossWeight");
    var objTemplate                 = null
    var objTemplateName             = null;
    var objTable                    = null;
    var objDiv                      = null;
    var msgTooltip                  = null;
    var errorMsg                    = null;
    var rowIndex                    = 0;
    var lo_errMsg                   = document.getElementById("errMsg");
	var saveOperation				= document.getElementsByName("saveOperationFlag");
	var templateValue				= document.getElementsByName("template");
	var templateValue				= document.getElementsByName("submitBack");
	
    try{
		
//        Open acknolwedgement screen.
        error_code          = 3;
	    bookingNo = document.getElementsByName('bookingNo');
		templeteFlagCheck = document.getElementsByName('templateFlag');
        openAcknowledgement = document.getElementsByName('openAcknowledgement');
		editSatus=document.getElementsByName('editSatus');
        if((!isNullObj(openAcknowledgement[0]) && openAcknowledgement[0].value == 'true') || (bookingNo[0].value!="" && templeteFlagCheck[0].value=="" && (document.getElementsByName("status")[0].value!="Confirmed" || editSatus [0].value=="New")  )){
            loading();

            bookingNo = document.getElementsByName('bookingNo');
            if(!isNullObj(bookingNo[0])){
                bookingNoVal = isNullStrReturnDefault(bookingNo[0].value, BLANK);
            }

            openAcknowledgement[0].value = 'false';

            openAcknowledgementPopup(bookingNoVal);
			debugger;
	//		bookingUrl = GET_BOOKING_NUMBER+'?bookingNo='+bookingNoVal;
	//		if(editSatus [0].value=="New"){
   //         	bookingUrl += '&status=' ;
//			} 
  //          bookingUrl += '&bookingType=NORMAL';
  //          bookingUrl += '&mode=select';

   //         document.forms[0].action = bookingUrl;
   //         document.forms[0].submit();
        }else if(saveOperation[0].value=='T')
			{
			loading();	
			templateUrl = GET_TEMLATE;
        
            document.forms[0].action = templateUrl+'?status=T';
            document.forms[0].submit();

		}else{error_code = 1;
		debugger;
            objTemplate = document.getElementsByName("template");
            if (!isNullObj(objTemplate[0]) && ('' != objTemplate[0].value)){
                objTemplateName = document.getElementsByName("templateName");
                if(!isNullObj(objTemplateName[0])){
                    objTemplateName[0].disabled = true;
                }
            }
			
            error_code = 2;
    //        @18 BEGIN
            routingDDLControl();
    //        @18 END
            error_code = 4;
            generateResultTableDiv('search_result', 'result_dtl');
            error_code = 5;
            generateResultTableDiv('comm_search_result', 'comm_result_dtl');

            error_code = 6;
            checkedFirstItem();

            error_code = 7;

            displaySpecialIns();


    //        @19 BEGIN
    //        error_code = 8;
    //        getDataByQuotationNo(false);
    //        @19 END
            error_code = 9;
            errorMsg = document.getElementById("newWebBookingErrMsg");
            if(!isNullObj(errorMsg) && '' != errorMsg.value){
                showBarMessageNew(errorMsg.value, MSG_ERROR_CODE);
				window.scrollTo(500, 0);
                errorMsg.value = '';
            }
    //        Set tool tip
            error_code = 10;
            msgTooltip = document.getElementsByName('msgTooltip');
            if(!isNullObj(msgTooltip[0]) && !isBlank(msgTooltip[0].value)){
                msgQtnInfo = msgTooltip[0].value;
            }
    //        teerakan add 19/07/2013
            //@08 BEGIN
            bookingButtonControl(true);
            //@08 END

        }

        /*Begin @20*/
        if(lo_errMsg.value!=""){
            showBarMessageNew(lo_errMsg.value, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
        }
        /*End @20*/

        /*Begin @21*/
        lp_onChangeCargoType(null);
        /*End @21*/

        /*Begin @22*/
        lp_manageRepresentCompChkBox(1);
        /*End @22*/
if(document.getElementsByName("status")[0].value=="Confirmed"){
	check_typeOfBooking();
}
        
    }catch(err){
        handleJavaScriptError('onload', err, error_code);
    }
} // onload
function check_typeOfBooking(){
	document.getElementById("representComp").disabled=true;
	if(document.getElementById("representComp").value==""){
		document.getElementById("representCompChkBox").checked=false;
		document.getElementById("representCompChkBox").disabled=true;
	}else{
		document.getElementById("representCompChkBox").checked=true;
		document.getElementById("representCompChkBox").disabled=true;
	}
	document.getElementById("quotationNumber").disabled=true;
	document.getElementById("placeOfDelivery").disabled=true;
	document.getElementById("socCocUserFlag").disabled=true;
}
/*Begin @22*/
function lp_manageRepresentCompChkBox(av_val){
    var lo_representCompChkBox  			= null;
	var lo_representCompChkBoxValidation    = null;
    var lo_representComp        			= null;
    var lo_template            			    = null;


    try{
        lo_representCompChkBox  			= document.getElementById("representCompChkBox");
        lo_representComp        			= document.getElementById("representComp");
        lo_template             			= document.getElementById("template");
		lo_representCompChkBoxValidation    = document.getElementById("representedCompanyCheckValidation");

		if(lo_representCompChkBoxValidation.value=='CHECKED'){
			lo_representCompChkBox.checked=true;
		}

        if(lo_representCompChkBox.checked==true){
            lo_representComp.disabled   = false;
        }else{
            lo_representComp.value      = "";
            lo_representComp.disabled   = true;
        }

       // if(av_val==2 && lo_representComp.value == "" && lo_representCompChkBox.checked==false){
            //checkQuotationNo();
//            if(lo_template.value==""){
//                loading();
//                document.forms[0].action = ON_LOAD;
//                document.forms[0].submit();
//            }else{
//                onTemplateChange();
//            }
               // loading();
               // document.forms[0].action = ON_LOAD;
               // document.forms[0].submit();
       // }

    }catch(err){
        handleJavaScriptError('lp_manageRepresentCompChkBox', err, 0);
    }
}
/*End @22*/

//@18 BEGIN
function bookingButtonControl(showButton){
    var showButtonDisplay = null;
    var hideButtonDisplay = null;
    try{
        if(showButton){
            showButtonDisplay = 'inline';
            hideButtonDisplay = 'none';
        }else{
            showButtonDisplay = 'none';
            hideButtonDisplay = 'inline';
        }
    }catch(err){
        showButtonDisplay = 'inline';
        hideButtonDisplay = 'none';

        handleJavaScriptError('bookingButtonControl', err,error_code);
    }finally{
        document.getElementById('showButton').style.display = showButtonDisplay;
        document.getElementById('hideButton').style.display = hideButtonDisplay;
	}
}

function routingDDLControl(){
	//alert('routingDDLControl');
    var originCountry = document.getElementsByName('originCountry');
    var portOfLoading = document.getElementsByName('portOfLoading');
    var placeOfReceipt = document.getElementsByName('placeOfReceipt');
    var emptyPickupDepot = document.getElementsByName('emptyPickupDepot');

    var destinationCountry = document.getElementsByName('destinationCountry');
    var portOfDischarge = document.getElementsByName('portOfDischarge');
    var placeOfDelivery = document.getElementsByName('placeOfDelivery');

    var disablePlaceOfReceipt = false;
    var disablePortOfLoading = false;
    var disableEmptyPickupDepot = false;

    var disablePortOfDischarge = false;
    var disablePlaceOfDelivery = false;

    try{
        if(!isNullObj(originCountry[0]) && !isNullObj(originCountry[0].value)){
            //alert('originCountry = '+originCountry[0].value);
            if('' == originCountry[0].value){
                disablePortOfLoading = true;
                disablePlaceOfReceipt = true;
                disableEmptyPickupDepot = true;
            }
        }
        if(!isNullObj(destinationCountry[0]) && !isNullObj(destinationCountry[0].value)){
//            alert('destinationCountry = '+destinationCountry[0].value);
            if('' == destinationCountry[0].value){
                disablePortOfDischarge = true;
                disablePlaceOfDelivery = true;
            }
        }
        
    }catch(err){
        handleJavaScriptError('routingDDLControl', err, null);
    }finally{
        if(!isNullObj(portOfLoading[0])){
            portOfLoading[0].disabled = disablePortOfLoading;
        }
        if(!isNullObj(placeOfReceipt[0])){
            placeOfReceipt[0].disabled = disablePlaceOfReceipt;
        }
        if(!isNullObj(emptyPickupDepot[0])){
            emptyPickupDepot[0].disabled = disableEmptyPickupDepot;
        }
        if(!isNullObj(portOfDischarge[0])){
            portOfDischarge[0].disabled = disablePortOfDischarge;
        }
        if(!isNullObj(placeOfDelivery[0])){
            placeOfDelivery[0].disabled = disablePlaceOfDelivery;
        }
        
        //alert(originCountry[0].value);
        if(originCountry[0].value == 'TH'){
			if($("#portOfLoading").val()!="THLCH")
        		placeOfReceipt[0].disabled = true;
			else
				placeOfReceipt[0].disabled = false;
        }else{
        	placeOfReceipt[0].disabled = false;
		}
    }
}

function openAcknowledgementPopup(bookingNoVal) {

  debugger;
    var email = null;
    var customerName = null;

    var emailVal = BLANK;
    var customerNameVal = BLANK;
    var openAckUrl = OPEN_ACKNOWLEDGEMENT;
    try{
//      Reload booking data
        email = document.getElementsByName('email');
        if(!isNullObj(email[0])){
            emailVal = isNullStrReturnDefault(email[0].value, BLANK);
        }
        customerName = document.getElementsByName('customerName');
        if(!isNullObj(customerName[0])){
            customerNameVal = isNullStrReturnDefault(customerName[0].value, BLANK);
        }
//
//        Open Acknowledge popup
        openAckUrl += '?bookingNo='+bookingNoVal;
        openAckUrl += '&email='+emailVal;
        openAckUrl += '&customerName='+customerNameVal;

		var msgPopUp ='Thank you for your booking request!  \n\n  The acknowledgement for the same will be sent shortly to the email: '+emailVal+' and requested list of recipient email addresses.'+
		
		'\n Your booking is binding as soon as you receive the booking confirmation from us via email as soon as we can confirm space availability and any other details pertainting to this request.'+
		'\n Booking Ref	'+bookingNoVal+
		'\n Booked By	'+customerNameVal+' \n\n   Note: The carrier reserves its full rights, and at any given time without prior notice, change the arrangement listed or make alternate arrangment or decline a booking.';
		
		 var bookingUrl   = GET_BOOKING_NUMBER+'?bookingNo='+bookingNoVal;
		
			swal("Message",msgPopUp,"info").then(function(){
					
            bookingUrl = GET_BOOKING_NUMBER+'?bookingNo='+bookingNoVal;
			if(editSatus [0].value=="New"){
            	bookingUrl += '&status=' ;
			} 
            bookingUrl += '&bookingType=NORMAL';
            bookingUrl += '&mode=select';

            document.forms[0].action = bookingUrl;
            document.forms[0].submit();
			
				});
       
       
       // openHelpList(openAckUrl, 920, 370);
    }catch(err){
        handleJavaScriptError('openAcknowledgementPopup', err, error_code);
    }finally{
    }
}
function generateResultTableDiv(resultDivName, resultTableName){
    var objDiv = document.getElementById(resultDivName);
    var objTable = document.getElementById(resultTableName);
    var rowIndex = 0;
    try{
        if(!isNullObj(objDiv) && !isNullObj(objTable)){
            rowIndex = objTable.rows.length;

            extendDivSize(rowIndex, objDiv);
        }
    }catch(err){
        handleJavaScriptError('generateResultTableDiv', err, error_code);
    }
}
//@18 END

/**
* function called for validation before save operation
*/
function validation(){
    var originCountry               = null;
    var destinationCountry          = null;

    var emptyOriginCountry          = true;
    var emptyDestinationCountry     = true;

    var portOfLoading               = null;
    var portOfDischarge             = null;
	var portOfReceipt               = null;
    var shipmentDate                = null;
    var emptyPickupDate             = null;
    var sailingDate                 = null;
    var desiredArrivalDate          = null;
    var validSailingDate            = null;
    var validEmptyPickupDate        = null;
    var validDesireArrivalDate      = null;
    var cargoGroup                  = null;
    var commodityGroup              = null;
    var contact                     = null;
    var lo_representCompChkBox      = null;//@22
    var lo_representComp            = null;//@22
    var quotationNoList             = null;//##23

    try{
        /* validation start */
//        VALIDATE Contact
        error_code  = 1;
        contact     = document.getElementsByName("contact");
        if(isNullObj(contact[0]) || isNullObj(contact[0].value) || '' == contact[0].value){
            showBarMessageNew(ESR_SE0012, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }
//        VALIDATE Origin Country
        error_code = 2;
        originCountry = document.getElementsByName("originCountry");
        if(isNullObj(originCountry[0]) || isNullObj(originCountry[0].value) || '' == originCountry[0].value){
            showBarMessageNew(ESR_SE0001, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }else{
            emptyOriginCountry = false;
        }
//        VALIDATE Destination Country
        error_code = 3;
        destinationCountry = document.getElementsByName("destinationCountry");
        if(isNullObj(destinationCountry[0]) || isNullObj(destinationCountry[0].value) || '' == destinationCountry[0].value){
            showBarMessageNew(ESR_SE0002, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }else{
            emptyDestinationCountry = false;
        }
//        VALIDATE Origin and Destination country not to be same
        error_code = 4;
        if(!emptyOriginCountry && !emptyDestinationCountry){
            if(originCountry[0].value == destinationCountry[0].value){
                showBarMessageNew(ESR_SE0013, MSG_ERROR_CODE);
				window.scrollTo(500, 0);
                return false;
            }
        }
//        VALIDATE Port Of Loading
        error_code = 5;
        portOfLoading = document.getElementsByName("portOfLoading");
        if(isNullObj(portOfLoading[0]) || isNullObj(portOfLoading[0].value) || '' == portOfLoading[0].value){
            showBarMessageNew(ESR_SE0003, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }
//        VALIDATE Port Of Discharge
        error_code = 6;
        portOfDischarge = document.getElementsByName("portOfDischarge");
        if(isNullObj(portOfDischarge[0]) || isNullObj(portOfDischarge[0].value) || '' == portOfDischarge[0].value){
            showBarMessageNew(ESR_SE0004, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }
//        VALIDATE Shipment Date
 		portOfReceipt = document.getElementsByName("placeOfReceipt");
        if(isNullObj(portOfReceipt[0]) || isNullObj(portOfReceipt[0].value) || '' == portOfReceipt[0].value){
            showBarMessageNew("Place of Receipt is not selected.");
			window.scrollTo(500, 0);
            return false;
        }
        error_code = 7;
        shipmentDate = document.getElementsByName("shipmentDate");
        if(isNullObj(shipmentDate[0]) || isNullObj(shipmentDate[0].value) || '' == shipmentDate[0].value){
        	showBarMessageNew(ESR_SE0005, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }else{
//            VALIDATE Shipment Date with Today Date
            error_code = 8;
            if(!compareTodayDate(shipmentDate[0].value, ESR_SE0015)){
                return false;
            }
//            VALIDATE Sailing Date
            error_code = 9;
            sailingDate =  document.getElementsByName("sailingDate");
            if(!isNullObj(sailingDate[0]) && !isNullObj(sailingDate[0].value) && '' != sailingDate[0].value){
				
				if(typeof sailingDate[0].value.replaceAll === 'function'){
					var sailingDateTemp= sailingDate[0].value.replaceAll('-','/');
					var shipmentDateTemp= shipmentDate[0].value.replaceAll('-','/');
				}else{
					var sailingDateTemp= (sailingDate[0].value.replace('-','/')).replace('-','/');
					var shipmentDateTemp= (shipmentDate[0].value.replace('-','/')).replace('-','/');
				}
				
              
			    validSailingDate = compareDates(sailingDateTemp, shipmentDateTemp);
                if(validSailingDate < 0){
                	showBarMessageNew(ESR_SE0018, MSG_ERROR_CODE);
					window.scrollTo(500, 0);
                    return false;
                }
            }
//            VALIDATE Empty Pickup Date
            error_code = 10;
            emptyPickupDate = document.getElementsByName("emptyPickupDate");
			/*if(isNullObj(emptyPickupDate[0]) || isNullObj(emptyPickupDate[0].value) || '' == emptyPickupDate[0].value){
            showBarMessageNew("Empty Pickup Date Blank.", MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        	}*/
            if(!isNullObj(emptyPickupDate[0]) && !isNullObj(emptyPickupDate[0].value) && '' != emptyPickupDate[0].value){
				if(typeof emptyPickupDate[0].value.replaceAll === 'function'){
					var emptyPickupDateTemp= emptyPickupDate[0].value.replaceAll('-','/');
				}else{
					var emptyPickupDateTemp= (emptyPickupDate[0].value.replace('-','/')).replace('-','/');
				}
				
			    
				if(!compareTodayDate(emptyPickupDateTemp, ESR_SE0016)){
                    return false;
                }
				if(typeof shipmentDate[0].value.replaceAll === 'function'){
				var shipmentDateTemp= shipmentDate[0].value.replaceAll('-','/');	
				}else{
				var shipmentDateTemp= (shipmentDate[0].value.replace('-','/')).replace('-','/');
                }
				validEmptyPickupDate = compareDates(shipmentDateTemp, emptyPickupDateTemp);
                if(validEmptyPickupDate < 0){
                	showBarMessageNew(ESR_SE0014, MSG_ERROR_CODE);
					window.scrollTo(500, 0);
                    return false;
                }
				 
            }
//            VALIDATE Desired Arrival Date
            error_code = 11;
            desiredArrivalDate = document.getElementsByName('desiredArrivalDate');
            if(!isNullObj(desiredArrivalDate[0]) && !isNullObj(desiredArrivalDate[0].value) && '' != desiredArrivalDate[0].value){
				if(typeof desiredArrivalDate[0].value.replaceAll === 'function'){
				var desiredArrivalDateTemp= desiredArrivalDate[0].value.replaceAll('-','/');
				var shipmentDateTemp= shipmentDate[0].value.replaceAll('-','/');
				}else{
					var desiredArrivalDateTemp= (desiredArrivalDate[0].value.replace('-','/')).replace('-','/');
				var shipmentDateTemp= (shipmentDate[0].value.replace('-','/')).replace('-','/');
				}
				
				validDesireArrivalDate = compareDates(desiredArrivalDateTemp, shipmentDateTemp);
                if(validDesireArrivalDate < 1){
                	showBarMessageNew(ESR_SE0019, MSG_ERROR_CODE);
					window.scrollTo(500, 0);
                    return false;
                }
            }
        }

        /*Begin @22*/
        lo_representCompChkBox  = document.getElementById("representCompChkBox");
        lo_representComp        = document.getElementById("representComp");

        if(lo_representCompChkBox.checked==true && lo_representComp.value==""){
        	showBarMessageNew(ESR_SE0035, MSG_ERROR_CODE);
			window.scrollTo(500, 0);
            return false;
        }
        /*End @22*/

        /*Begin @23*/
        quotationNoList = $("select[name=quotationNumber] option");
        // console.log("quotation's size "+$(quotationNoList).size());
        if(lo_representCompChkBox.checked==true && lo_representComp.value != ''){
            if(quotationNoList.length > 1){ //include option's header
                var selectedQuotation = $("select[name=quotationNumber] option:selected").val();
                // console.log(selectedQuotation);
                if(selectedQuotation == ''){
                	showBarMessageNew(ESR_SE0037, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                    return false;
                }
            }
        }
        // return ;
        /*End @23*/

//        VALIDATE Size type
        error_code = 12;
        if(!sizeTypeValidation()){
            return false;
        }
//        VALIDATE Cargo Description
        error_code = 13;
        cargoDescription = document.getElementsByName("cargoDescription");
        if(isNullObj(cargoDescription[0]) || isNullObj(cargoDescription[0].value) || '' == cargoDescription[0].value){
        	showBarMessageNew(ESR_SE0010, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            return false;
        }
//        VALIDATE Commodity
        error_code = 14;
        if(!commodityValidation()){
            return false;
        }
		if(checkCargoTypeAndRatetype()){
			showBarMessageNew("Equipment and Commodity Details * At Rate Type field should be selected the same type in one booking.(OR system allow to update one rate type in one booking)");
			window.scrollTo(500, 0);
			return false;
		}
        /* validation end */
    }catch(err){
        handleJavaScriptError('validation', err,error_code);
        return false;
    }
    return true;
} // validation

function saveBooking(saveFlag){
	debugger;
    var saveOperationFlag       = document.getElementsByName('saveOperationFlag');
    var lo_uploadFlag           = document.getElementById("uploadFlag");//@20
    var lo_templateName         = null;
    var canSubmit               = false;
    var submitBookingFlag       = false;
    /*Begin @20*/
    var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
    var la_rateType             = document.getElementsByName("rateType");
    /*End @20*/
	debugger;
    try{
        if(validation()){
            saveOperationFlag[0].value = saveFlag;
            if(MODE_SAVE_DRAFT == saveFlag){
				debugger;
                lo_templateName = document.getElementById('templateName');
                if(isNullObj(lo_templateName) || isNullObj(lo_templateName.value) || '' == lo_templateName.value){
                	showBarMessageNew("Please provide template name to save as template.", MSG_ERROR_CODE);
					window.scrollTo(500, 0);
                    lo_templateName.focus();
                }else{
                    if(lo_uploadFlag.value=="Y"){
                        if(confirm(ESR_SE0026)){
                            canSubmit = true;
                        }
                    }else{
                        canSubmit = true;
                    }
                }
            }else{
                /*Begin @20*/
				debugger;
                for(var i=0;i<la_rateTypeFlag.length;i++){
                    if(la_rateTypeFlag[i].value=="Y"){
                        if(la_rateType[i].value=="D1" || la_rateType[i].value=="O0"){
                            submitBookingFlag = true;
                            break;
                        }
                    }
                }

             //    if(submitBookingFlag==true && lo_uploadFlag.value=="N"){
              //      if(confirm(ESR_SE0025)){
               //         canSubmit = true;
               //     }
            //    }else{
              //      canSubmit = true;
             //   } 
				canSubmit = true;
                /*End @20*/
//                canSubmit = true;
            }
        }
    }catch(err){
        handleJavaScriptError('saveBooking', err,error_code);
    }finally{
        if(canSubmit){
			debugger;
            bookingButtonControl(false);

            loading();

            document.forms[0].action = SAVE_BOOKING;
            document.forms[0].submit();
        }else{
            bookingButtonControl(true);
        }
    }
    return canSubmit;
}

function checkQuotationNo() {
    try{
//        @17 BEGIN
        loading();
//        @17 END
        document.forms[0].action = CHECK_QTN;
        document.forms[0].submit();
    }catch(err){
        handleJavaScriptError('checkQuotationNo', err,error_code);
    }

} // checkQuotationNo

function checkQuotationNoNew() {
    try{
//        @17 BEGIN
        loading();
//        @17 END
        document.forms[0].action = CHECK_QTN;
        document.forms[0].submit();
    }catch(err){
        handleJavaScriptError('checkQuotationNo', err,error_code);
    }

} 

function checkQTN(){
    var quotationNo = document.getElementById("quotationNumber");

    if(quotationNo != ""){
        checkQuotationNo();
    }
}

//@18 BEGIN
function getDataByQuotationNo() {
	debugger;
    var quotationNumber = null;
    var url = null;
    try{
        quotationNumber = document.getElementsByName("quotationNumber");
        if(!isNullObj(quotationNumber[0]) && '' != quotationNumber[0].value){
//            @17 BEGIN
            loading();
//            @17 END
            url = CHECK_QTN_SIZE+'?quotationNumber='+quotationNumber[0].value;
            //alert(url);
            xmlhttp.onreadystatechange=callbackToFieldQuotation;
            xmlhttp.open("GET", url, true);
//            xmlhttp.open("GET", url, false);
            xmlhttp.send(null);
        }
    }catch(err){
        unloading();
        handleJavaScriptError('getQuotationData', err,error_code);
    }

} // checkQuotationNo



function callbackToFieldQuotation(){
    var quotationNumber = null;
    var respTxt         = null;
    var respTxtInt      = 0;
    var url             = GET_DATA_BT_QTN;

    try{
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            respTxt = xmlhttp.responseText;
            //alert('respTxt = '+respTxt);
            if(respTxt != null && respTxt != undefined && respTxt != ''){
                respTxtInt = parseInt(respTxt);
                if(respTxtInt > 0){
                    if(respTxtInt > 1){
                        quotationNumber = document.getElementsByName("quotationNumber");
                        if(!isNullObj(quotationNumber[0]) && '' != quotationNumber[0].value){
                        //alert('quotationNumber = '+quotationNumber);
                            url += '?quotationNumber='+quotationNumber[0].value;
                            openHelpList(url, 980, 450);
                        }
                    }else if(respTxtInt == 1){
                        //alert('Response size = '+respTxtInt);
                        document.forms[0].action = GET_DATA_BT_QTN;
                        document.forms[0].submit();
                    }
                }else{
                    //alert('Response size is empty');
                }
            }
        } else {
            //alert("Error in AJAX");
        }
    } catch(err){
        unloading();
        handleJavaScriptError('callbackToFieldQuotation', err,error_code);
    }
}

/*Begin @22*/
function lp_changeRepComp(){
    lo_representCompChkBox  = null;
    lo_representComp        = null;

    try{
        lo_representCompChkBox  = document.getElementById("representCompChkBox");
        lo_representComp        = document.getElementById("representComp");


    } catch(err){
        handleJavaScriptError('lp_changeRepComp', err, 0);
    }
}
/*End @22*/

function onCountryChange(){
    try{
//        Disable all controls
//        disableOnSubmit();
//       @17 BEGIN
        error_code = 1;
        loading();
//       @17 END
        error_code = 2;
        document.forms[0].action = POPULATE_DEPENDENT_COMBOS;
        document.forms[0].submit();

    }catch(err){
        handleJavaScriptError('onCountryChange', err,error_code);
    }

} // onCountryChange

function onCountryChangeNew(){
    try{
//        Disable all controls
//        disableOnSubmit();
//       @17 BEGIN
        error_code = 1;
        loading();
//       @17 END
        error_code = 2;
        document.forms[0].action = POPULATE_DEPENDENT_COMBOS;
        document.forms[0].submit();

    }catch(err){
        handleJavaScriptError('onCountryChange', err,error_code);
    }

} 


function onTemplateChange(){
    try{
//       @17 BEGIN
        error_code = 1;
        loading();
//       @17 END
        error_code = 2;
        document.forms[0].action = GET_TEMPLATE_DATA;
        document.forms[0].submit();
    }catch(err){
        handleJavaScriptError("onTemplateChange", err, error_code);
    }

} // onTemplateChange

function onSave(){
    alert('work in progress ...');

} // onSave

function onBack(){
    alert('Back work in progress');
} // onBack

function compareTodayDate(fromDate,errorMsg){
    var currentDate = null;
    var day = 0;
    var month = 0;
    var year = 0;

    var dateCompare = null;
    var parts = null;
    var result = false;
    try{
        currentDate = new Date();
        day = currentDate.getDate();
        month = currentDate.getMonth() + 1;
        year = currentDate.getFullYear();
        parts = fromDate.split("/");

        dateCompare = new Date(month + "/" + day + "/" + year);
        fromDate = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
        if(fromDate.getTime()<dateCompare.getTime()){
        	showBarMessageNew(errorMsg, MSG_ERROR_CODE);
window.scrollTo(500, 0);
        }else{
            result = true;
        }
    }catch(err){
        handleJavaScriptError('compareTodayDate', err,error_code);
    }
    return result;
}

function getSchedule(){
    alert('work in progress ...');
} // getSchedule

function routingInfoButton(){
    //--------------------open tsi screen
    window.open('http://dolphin-cs.rclgroup.com/SealinerRCL/webbooking/webRoutingSetupAction.do?program=webPC&init=Y','Web_Booking');
    //window.open('http://www.google.com','Web_Booking');
} //routingInfoButton

/*Begin @20*/
function addEquipment(){
    var objDiv                          = document.getElementById("search_result");
    var lo_table                        = document.getElementById("result_dtl");
    var lo_equipmentSeqNoTmp            = document.getElementById("equipmentSeqNoTmp");
    var lv_maxSeq                       = parseInt(lo_equipmentSeqNoTmp.value) + 1;
    var rowIndex                        = lo_table.rows.length;
    var newNodeTr 	                = null;
    var newNodeTd1 			= null;
    var newNodeTd2 			= null;
    var newNodeTd3 			= null;
    var newNodeTd4 			= null;
    var newNodeTd5 			= null;
    var newNodeTd6 			= null;
    var newNodeTd7 			= null;
    var newNodeTd8 			= null;
    var newNodeTd9 			= null;
    var newNodeTd10 			= null;
    var socCocUserFlag                  = document.getElementById("socCocUserFlag").value;
    var putDisabled                     = "";
    var lv_optPOD                       = "";
//    var lv_typeCombo                    = "";
    var lv_sizeCombo                    = "";
    var lv_cargoTypeCombo               = "";
    var nodes                           = null;
    var la_type                         = document.getElementsByName("type");
    var la_size                         = document.getElementsByName("size");
    var la_cargoType                    = document.getElementsByName("cargoType");
    var lv_option                       = null;

    var postVal     = "newSeq=" + lv_maxSeq;
    $.ajax({
        async:false,
        type: "POST",
        url: ADD_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),//loading()
        success: function(data){
            //unloading();
            if(trim(data)=="OK"){
                newNodeTr       = lo_table.insertRow(rowIndex);
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

                for(var i=1;i<4;i++){
                    nodes                           = lo_table.rows[0].cells[i].childNodes;
                    loop1:for(var j=0;j<nodes.length;j++){
                        if(nodes[j].nodeName=="SELECT"){
                            //if(i==1) lv_typeCombo        = nodes[j].outerHTML;
                            if(i==2) lv_sizeCombo        = nodes[j].outerHTML;
                            if(i==3) lv_cargoTypeCombo   = nodes[j].outerHTML;
                            break loop1;
                        }
                    }
                }

                extendDivSize(rowIndex, objDiv);

                newNodeTr.id                = "row"+lv_maxSeq;
                newNodeTr.style.height 	    = "20px";

                // Seq
                newNodeTd1.style.width      = "3%";
                newNodeTd1.innerHTML        = rowIndex + 1;

                // Type
                newNodeTd2.style.width      = "18%";
                newNodeTd2.innerHTML        = '<input type="hidden" name="type" id="type' + lv_maxSeq + '" value="GP" />'
                                            + '<INPUT type="text" style="WIDTH: 180px" name="typeDesc" id="typeDesc1' + lv_maxSeq + '" class="must" value="GP - GENERAL PURPOSE CONTAINER" readOnly />&nbsp;'
                                            + '<A class="m-btn smallest blue rnd smallericn-only" onclick="openEquipTypeLookup(this);" href="javascript:void(0)" name="btnTypeLookup" >'
                                                + '<I class="icon-search icon-white"></I>'
                                            + '</A>';

                // Size
                newNodeTd3.style.width      = "5%";
                newNodeTd3.innerHTML        = lv_sizeCombo;

                // Cargo Type
                newNodeTd4.style.width      = "8%";
                newNodeTd4.innerHTML        = lv_cargoTypeCombo;

                // Laden
                newNodeTd5.style.width      = "7%";
                newNodeTd5.innerHTML        = '<input type="text" maxlength="4" name="laden" id="laden' + lv_maxSeq + '" value="0" class="must" ' +
                                                'onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);" style="width:70px" />';

                // MT
                newNodeTd6.style.width      = "7%";
                newNodeTd6.innerHTML        = '<input type="text" name="mt" id="mt' + lv_maxSeq + '" maxlength="4" value="0"  class="must" ' +
                                                'style="width:70px" onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);" />';

                // Gross Container Weight
                newNodeTd7.style.width      = "18%";
                newNodeTd7.innerHTML        = '<input type="text" name="grossContainerWeight" id="grossContainerWeight' + lv_maxSeq + '" maxlength="17" class="must" ' +
                                                'style="width:195px" onchange="putMask_NumberEX(this, 14, 2);updateSizeTypeRecStatus(this);" />';

                // POL Status Field
                if(socCocUserFlag != 'S') {
                    putDisabled = 'disabled';
                }
                newNodeTd8.style.width      = "13%";
                newNodeTd8.innerHTML        = '<select name="polStatus" id="polStatus' + lv_maxSeq + '" size="1" style="height: 20px;width:60px" '+putDisabled+' onchange="updateSizeTypeRecStatus(this);" > ' +
                                                '<option value="L">Local</option>' +
                                                '<option value="T">TS</option>' +
                                              '</select>';

                // POD Status Field
                if(socCocUserFlag != 'S') {
                    putDisabled = 'disabled';
                }else{
                    lv_optPOD = '<option value="T">TS</option>';
                }
                newNodeTd9.style.width      = "13%";
                newNodeTd9.innerHTML        = '<select name="podStatus" id="podStatus' + lv_maxSeq + '" size="1" style="height: 20px;width:60px" '+putDisabled+' onchange="updateSizeTypeRecStatus(this);" > ' +
                                                '<option value="L">Local</option>' +
                                                lv_optPOD +
                                              '</select>';

                // Equipment Select Check box
                newNodeTd10.style.width      = "8%";
                newNodeTd10.innerHTML        = '<input type="checkbox" name="equipmentSelectChkBox" id="equipmentSelectChkBox' + lv_maxSeq + '" value="Y" style="border:0px;width:20%" /> ' +
                                                '<input type="hidden" value="ADD" name="eqRecordStatus" id="eqRecordStatus' + lv_maxSeq + '" />' +
                                                '<input type="hidden" value="' + lv_maxSeq + '" name="eqSeqNo" id="eqSeqNo' + lv_maxSeq + '" />';

                //Begin Type add id and selected option
//                la_type[rowIndex].id        = "type" + lv_maxSeq;
//                lv_option                   = la_type[rowIndex].options;
//                lv_option[0].selected       = true;
                //End Type add id and selected option

                //Begin Size add id and selected option
                la_size[rowIndex].id        = "size" + lv_maxSeq;
                lv_option                   = la_size[rowIndex].options;
                lv_option[0].selected       = true;
                //End Size add id and selected option

                //Begin Cargo Type add id and selected option
                la_cargoType[rowIndex].id       = "cargoType" + lv_maxSeq;
                la_cargoType[rowIndex].value    = "N";
//                lv_option                   = la_cargoType[rowIndex].options;
//                lv_option[0].selected       = true;
                //End Cargo Type add id and selected option

                lo_equipmentSeqNoTmp.value  = lv_maxSeq;
                objDiv.scrollTop 	    = objDiv.scrollHeight;

                showBarMessage("Ready", 2);
            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });

}
/*End @20*/

function addEquipmentNew(){
	debugger;
	var objDiv                          = document.getElementById("search_result");
    var lo_table                        = document.getElementById("result_dtl");
    var lo_equipmentSeqNoTmp            = document.getElementById("equipmentSeqNoTmp");
    var lv_maxSeq                       = parseInt(lo_equipmentSeqNoTmp.value) + 1;
    var rowIndex                        = lo_table.rows.length;
    var newNodeTr 	                = null;
    var newNodeTd1 			= null;
    var newNodeTd2 			= null;
    var newNodeTd3 			= null;
    var newNodeTd4 			= null;
    var newNodeTd5 			= null;
    var newNodeTd6 			= null;
    var newNodeTd7 			= null;
    var newNodeTd8 			= null;
    var newNodeTd9 			= null;
    var newNodeTd10 			= null;
    var socCocUserFlag                  = document.getElementById("socCocUserFlag").value;
    var putDisabled                     = 'disabled';
    var lv_optPOD                       = "";
    var lv_type                    = "";
    var lv_sizeCombo                    = "";
    var lv_cargoTypeCombo               = "";
	var lv_spacleCargoCombo				= "";
    var nodes                           = null;
    var la_type                         = document.getElementsByName("type");
    var la_size                         = document.getElementsByName("size");
    var la_cargoType                    = document.getElementsByName("cargoType");

    var lv_option                       = null;
	//var la_special_cargo 				=document.getElementsByName("specialCargo");
    var postVal     = "newSeq=" + lv_maxSeq;
    $.ajax({
        async:false,
        type: "POST",
        url: ADD_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),//loading()
        success: function(data){
            //unloading();
            if(trim(data)=="OK"){
                newNodeTr       = lo_table.insertRow(rowIndex);
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
				//newNodeTd11     = newNodeTr.insertCell(10);
                for(var i=1;i<5;i++){
                    nodes                           = lo_table.rows[0].cells[i].childNodes;
                    loop1:for(var j=0;j<nodes.length;j++){
                        if(nodes[j].nodeName=="SELECT"){
                            if(i==1) lv_type        	 = nodes[j].outerHTML;
                            if(i==2) lv_sizeCombo        = nodes[j].outerHTML;
                            if(i==3) lv_cargoTypeCombo   = nodes[j].outerHTML;
							if(i==4) lv_spacleCargoCombo = nodes[j].outerHTML;
                            break loop1;
                        }
                    }
                }

                

                newNodeTr.id                = "row"+lv_maxSeq;

                // Seq
                
                newNodeTd1.innerHTML        = rowIndex + 1;

                // Type
                
                newNodeTd2.innerHTML        = lv_type;
                                           

                // Size
                newNodeTd3.innerHTML        = lv_sizeCombo;

                // Cargo Type
                newNodeTd4.innerHTML        = lv_cargoTypeCombo;

				//Spacial Cargo
				//newNodeTd4.innerHTML		= lv_spacleCargoCombo;

                // Laden
                newNodeTd5.innerHTML        = '<input type="text" maxlength="4" name="laden" id="laden' + lv_maxSeq + '" value="0" class="form-control form-control-sm" ' +
                                              ' onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatusNew(this,'+parseInt(lv_maxSeq-1)+');"  />';

                // MT
                newNodeTd6.innerHTML        = '<input type="text" name="mt" id="mt' + lv_maxSeq + '" maxlength="4" value="0"  disabled class="form-control form-control-sm" ' +
                                                ' onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatusNew(this,'+parseInt(lv_maxSeq-1)+');" />';

                // Gross Container Weight
                newNodeTd7.innerHTML        = '<input type="text" name="grossContainerWeight" id="grossContainerWeight' + lv_maxSeq + '" maxlength="17" class="form-control form-control-sm" ' +
                                                'onchange="putMask_NumberEX(this, 14, 2);updateSizeTypeRecStatusNew(this,'+parseInt(lv_maxSeq-1)+');calculateGrossWaiht(this,'+parseInt(lv_maxSeq-1)+')" />';

                // POL Status Field
                if(socCocUserFlag != 'S') {
                    putDisabled = 'disabled';
                }
                newNodeTd8.innerHTML        = '<select name="polStatus" class="form-control" id="polStatus' + lv_maxSeq + '" size="1"    onchange="updateSizeTypeRecStatusNew(this,'+parseInt(lv_maxSeq-1)+');" > ' +
                                                '<option value="L">Local</option>' +
                                                '<option value="T">TS</option>' +
                                              '</select>';

                // POD Status Field
                if(socCocUserFlag != 'S') {
                    putDisabled = 'disabled';
                }else{
                    lv_optPOD = '<option value="T">TS</option>';
                }
                newNodeTd9.innerHTML        = '<select name="podStatus" class="form-control" id="podStatus' + lv_maxSeq + '"    onchange="updateSizeTypeRecStatusNew(this,'+parseInt(lv_maxSeq-1)+');" > ' +
                                                '<option value="L">Local</option>' +
                                                lv_optPOD +
                                              '</select>';

                // Equipment Select Check box
                newNodeTd10.innerHTML        = '<div >'+
                								'<input type="checkbox" class="checkbox" style="width:20px; height:37px !important ;" name="equipmentSelectChkBox" id="equipmentSelectChkBox' + lv_maxSeq + '" value="Y"  /> ' +
                                                '</div>'+
                								'<input type="hidden" value="ADD" name="eqRecordStatus" id="eqRecordStatus' + lv_maxSeq + '" />' +
                                                '<input type="hidden" value="' + lv_maxSeq + '" name="eqSeqNo" id="eqSeqNo' + lv_maxSeq + '" />';

                //Begin Type add id and selected option
//                la_type[rowIndex].id        = "type" + lv_maxSeq;
//                lv_option                   = la_type[rowIndex].options;
//                lv_option[0].selected       = true;
                //End Type add id and selected option

                //Begin Size add id and selected option
                la_size[rowIndex].id        = "size" + lv_maxSeq;
                lv_option                   = la_size[rowIndex].options;
                lv_option[0].selected       = true;
                //End Size add id and selected option

                //Begin Cargo Type add id and selected option
                la_cargoType[rowIndex].id       = "cargoType" + lv_maxSeq;
                la_cargoType[rowIndex].value    = "N";
//                lv_option                   = la_cargoType[rowIndex].options;
//                lv_option[0].selected       = true;
                //End Cargo Type add id and selected option

                lo_equipmentSeqNoTmp.value  = lv_maxSeq;
                objDiv.scrollTop 	    = objDiv.scrollHeight;

                showBarMessage("Ready", 2);
            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });

	
}



/*Begin @20*/
function addCommodity() {
    var objDiv                          = document.getElementById("comm_search_result");
    var lo_table                        = document.getElementById("comm_result_dtl");
    var lo_commoditySeqNoTmp            = document.getElementById("commoditySeqNoTmp");
    var lv_maxSeq                       = parseInt(lo_commoditySeqNoTmp.value) + 1;
    var rowIndex                        = lo_table.rows.length;
    var newNodeTr 	                = null;
    var newNodeTd1 			= null;
    var newNodeTd2 			= null;
    var newNodeTd3 			= null;
    var newNodeTd4 			= null;
    var newNodeTd5 			= null;
    var newNodeTd6 			= null;
    var newNodeTd7 			= null;
    var newNodeTd8 			= null;
    var lv_rateTypeCombo                = "";
    var lv_btnRateTypeDetails           = "";
    var nodes                           = lo_table.rows[0].cells[6].childNodes;
    var la_btnRateTypeDetails           = document.getElementsByName("btnRateTypeDetails");

    try{
        var postVal     = "newSeq=" + lv_maxSeq;
        $.ajax({
            async:false,
            type: "POST",
            url: ADD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                try{
                    if(trim(data)=="OK"){
                        newNodeTr       = lo_table.insertRow(rowIndex);
                        newNodeTd1      = newNodeTr.insertCell(0);
                        newNodeTd2      = newNodeTr.insertCell(1);
                        newNodeTd3      = newNodeTr.insertCell(2);
                        newNodeTd4      = newNodeTr.insertCell(3);
                        newNodeTd5      = newNodeTr.insertCell(4);
                        newNodeTd6      = newNodeTr.insertCell(5);
                        newNodeTd7      = newNodeTr.insertCell(6);
                        newNodeTd8      = newNodeTr.insertCell(7);

                        for(var i=0;i<nodes.length;i++){
                            if(nodes[i].nodeName=="SELECT"){
                                lv_rateTypeCombo = nodes[i].outerHTML;
                            }

                            if(nodes[i].nodeName=="A"){
                                lv_btnRateTypeDetails = nodes[i].outerHTML;
                            }
                        }

                        extendDivSize(rowIndex, objDiv);

                        newNodeTr.id                = "row"+lv_maxSeq;
                        newNodeTr.style.height 	    = "25px";

                        // commodity radio
                        newNodeTd1.style.width      = "4%";
                        newNodeTd1.innerHTML = '<input type="radio" style="border:0px;width:95%" name="radCommodity" name="radCommodity'+lv_maxSeq+'" value="'+lv_maxSeq+'" onclick="displaySpecialIns()"/>';

                        // seq number
                        newNodeTd2.style.width      = "4%";
                        newNodeTd2.innerHTML        = rowIndex + 1;

                        // commodity group
                        newNodeTd3.style.width      = "15%";
                        newNodeTd3.innerHTML        = '<input type="hidden" name="posObjectCommod" id="posObjectCommod'+lv_maxSeq+'" value="'+lv_maxSeq+'" />' +
                                                      '<input type="hidden"  name="seqNo" value="'+lv_maxSeq+'" />' +
                                                      '<input type="text" maxlength="1" style="width:80%" class="must" name="group" id="group'+lv_maxSeq+'" value="" onblur="updateCommodityRecStatus(this);changeUpper(this);" readonly="true" />';

                        // commodity description
                        newNodeTd4.style.width      = "20%";
                        newNodeTd4.innerHTML        = '<input type="text" maxlength="1" style="width:80%" name="description" id="description'+lv_maxSeq+'" value="" onblur="changeUpper(this)" readonly="true" />&nbsp;' +
                                                      '<a name="btnCommodityGroupLookup" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick="openCommodityGroupLookup(this);"><i class="icon-search icon-white"></i></a>';

                        // weight
                        newNodeTd5.style.width      = "15%";
                        newNodeTd5.innerHTML        = '<input type="text" maxlength="17" style="width:80%" name="grossWeight" id="grossWeight'+lv_maxSeq+'" value="" onblur="updateCommodityRecStatus(this);putMask_NumberEX(this, 14, 2);" />';

                        // special cargo
                        newNodeTd6.style.width      = "13%";
                        newNodeTd6.innerHTML        = '<input type="checkbox" name="specialCargo" style="border:0px;width:10%;" id="specialCargo'+lv_maxSeq+'" value="Y" onclick="lp_onChangeRateType();displaySpecialIns();updateCommodityRecStatus(this);" />';

                        // select
                        newNodeTd7.style.width      = "16%";
                        newNodeTd7.innerHTML        = lv_rateTypeCombo + "&nbsp;" + lv_btnRateTypeDetails;

                        // select
                        newNodeTd8.style.width      = "13%";
                        newNodeTd8.innerHTML        = '<input type="checkbox" name="isSelected" id="isSelected'+lv_maxSeq+'" value="Y" style="border:0px;width:10%;" />' +
                                                      '<input type="hidden" value="ADD" name="recordStatus" id="recordStatus'+lv_maxSeq+'" />' +
                                                      '<input type="hidden" value="N" name="rateTypeFlag" id="rateTypeFlag'+lv_maxSeq+'" />';

                        la_btnRateTypeDetails[rowIndex].className = "m-btn smallest blue rnd smallericn-only";

                        checkedLastItem();
                        addSpecialInstruction(lv_maxSeq);

                        lo_commoditySeqNoTmp.value = lv_maxSeq;

                        showBarMessage("Ready", 2);
                    }else{
                    	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                    }
                }catch(e){
                    alert("in addCommodity :: " + e);
                }
            }
        });
    }catch(e){
        alert("addCommodity :: " + e);
    }

}

function addCommodityNew() {
	debugger;
	var lv_maxSeq_temp					= "";
    var objDiv                          = document.getElementById("comm_search_result");
    var lo_table                        = document.getElementById("comm_result_dtl");
    var lo_commoditySeqNoTmp            = document.getElementById("commoditySeqNoTmp");
		if(parseInt(lo_commoditySeqNoTmp.value)==0)
			lv_maxSeq_temp	= parseInt(lo_commoditySeqNoTmp.value) + 2;
		else
			lv_maxSeq_temp	= parseInt(lo_commoditySeqNoTmp.value) + 1;
    var lv_maxSeq                       = lv_maxSeq_temp;
    var rowIndex                        = lo_table.rows.length;
    var newNodeTr 	                = null;
    var newNodeTd1 			= null;
    var newNodeTd2 			= null;
    var newNodeTd3 			= null;
    var newNodeTd4 			= null;
    var newNodeTd5 			= null;
    var newNodeTd6 			= null;
    var newNodeTd7 			= null;
    var newNodeTd8 			= null;
    var lv_rateTypeCombo                = "";
    var lv_btnRateTypeDetails           = "";
	var lv_specialCargoCombo            = "";
    var nodes                           = lo_table.rows[0].cells[5].childNodes;
    var la_btnRateTypeDetails           = document.getElementsByName("btnRateTypeDetails");

    try{
        var postVal     = "newSeq=" + lv_maxSeq;
        $.ajax({
            async:false,
            type: "POST",
            url: ADD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                try{
                    if(trim(data)=="OK"){
                        newNodeTr       = lo_table.insertRow(rowIndex);
                        newNodeTd1      = newNodeTr.insertCell(0);
                        newNodeTd2      = newNodeTr.insertCell(1);
                        newNodeTd3      = newNodeTr.insertCell(2);
                        newNodeTd4      = newNodeTr.insertCell(3);
                        newNodeTd5      = newNodeTr.insertCell(4);
                        newNodeTd6      = newNodeTr.insertCell(5);
                        newNodeTd7      = newNodeTr.insertCell(6);
debugger;
                        for(var i=0;i<nodes.length;i++){
                            if(nodes[i].nodeName=="SELECT"){
                                lv_rateTypeCombo = nodes[i].outerHTML;
                            }

                            if(nodes[i].nodeName=="DIV"){
                                lv_btnRateTypeDetails = nodes[i].outerHTML;
                            }
                        }

                        /*extendDivSize(rowIndex, objDiv);*/

                        newNodeTr.id                = "row"+lv_maxSeq;

                        // commodity radio
                        newNodeTd1.innerHTML =   	'<div class="radio">'+
                        							'<input type="radio" class="form-control"  style="height: 20px !important;" name="radCommodity" id="radCommodity'+lv_maxSeq+'" value="'+lv_maxSeq+'" onclick="displaySpecialIns()"/>'+
                        							'</div>';

                        // seq number
                        newNodeTd2.innerHTML        = rowIndex + 1;

                        // commodity group
                        newNodeTd3.innerHTML        = '<input type="hidden" name="posObjectCommod" id="posObjectCommod'+lv_maxSeq+'" value="'+lv_maxSeq+'" />' +
                                                      '<input type="hidden"  name="seqNo" value="'+lv_maxSeq+'" />' +
                                                      '<input type="text" class="form-control"   maxlength="1" name="group" id="group'+lv_maxSeq+'" value="" onblur="updateCommodityRecStatusNew(this);changeUpper(this);" readonly="true" />';

                        // commodity description
                        newNodeTd4.innerHTML        = '<div class="input-group">'+
                        							  '<input type="text" maxlength="1" class="form-control"   name="description" id="description'+lv_maxSeq+'" value="" onblur="changeUpper(this)" readonly="true" />&nbsp;' +
                        							  '<div class="input-group-prepend cursor-pointer">'+
                        							  '<div name="btnCommodityGroupLookup" class="input-group-text" href="javascript:void(0)" onclick="openCommodityGroupLookupNew(this,'+parseInt(lv_maxSeq-1)+');">' +
                        							  '<i class="fas fa-search"></i></div>'+
                        							  '</div>'+
                        							  '</div>';

                        // weight
                        newNodeTd5.innerHTML        = '<input type="text" class="form-control" maxlength="17"  name="grossWeight" id="grossWeight'+lv_maxSeq+'" value="" onblur="updateCommodityRecStatusNew(this);putMask_NumberEX(this, 14, 2);" />';

                        // select
                        newNodeTd6.innerHTML        = '<td>'+ lv_rateTypeCombo + lv_btnRateTypeDetails+'</td>';

                        // select
                        newNodeTd7.innerHTML        = '<td>'+
													  '<div>'+
                        							  '<input type="checkbox" class="checkbox" style="width:20px; height:37px !important ;" name="isSelected" id="isSelected'+lv_maxSeq+'" value="Y"  />' +
                                                      '</div>'+
                        							  '<input type="hidden" value="ADD" name="recordStatus" id="recordStatus'+lv_maxSeq+'" />' +
                                                      '<input type="hidden" value="N" name="rateTypeFlag" id="rateTypeFlag'+lv_maxSeq+'" /> ' +
													  '</td>';  

                        /*la_btnRateTypeDetails[rowIndex].className = "m-btn smallest blue rnd smallericn-only";*/

                        checkedLastItem();
                        addSpecialInstructionNew(lv_maxSeq);

                        lo_commoditySeqNoTmp.value = lv_maxSeq;

                        showBarMessage("Ready", 2);
                    }else{
                    	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                    }
                }catch(e){
                    alert("in addCommodity :: " + e);
                }
            }
        });
    }catch(e){
        alert("addCommodity :: " + e);
    }

}



/*End @20*/

    /*Begin @20*/
    function lp_onChangeRateType(){
        var lo_element_current 	    = window.event.srcElement;
        var lv_index                = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
        var la_seqNo                = document.getElementsByName("seqNo");
        var la_btnRateTypeDetails   = document.getElementsByName("btnRateTypeDetails");
        var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
	    lv_index=lv_index-1;
        var postVal                 = "seqNo=" + la_seqNo[lv_index].value;

        $.ajax({
            async:false,
            type: "POST",
            url: CHANGE_RATE_TYPE,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                showBarMessage("Ready", 2);
                if(data=="OK"){
                    //la_btnRateTypeDetails[lv_index].className   = "m-btn smallest blue rnd smallericn-only";
                    la_rateTypeFlag[lv_index].value             = "N";
                    lp_rateTypeControl();
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });

    }

function lp_onChangeRateTypeNew(row){
         
        var lv_index                =  row;
        var la_seqNo                = document.getElementsByName("seqNo");
        var la_btnRateTypeDetails   = document.getElementsByName("btnRateTypeDetails");
        var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
	     
        var postVal                 = "seqNo=" + la_seqNo[lv_index].value;

        $.ajax({
            async:false,
            type: "POST",
            url: CHANGE_RATE_TYPE,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                showBarMessage("Ready", 2);
                if(data=="OK"){
                    //la_btnRateTypeDetails[lv_index].className   = "m-btn smallest blue rnd smallericn-only";
                    la_rateTypeFlag[lv_index].value             = "N";
                    lp_rateTypeControl();
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });

    }

function lp_onChangeRateType(ao_element_current){
		debugger;
        var lo_element_current 	    = window.event.srcElement;
        var lv_index                = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
        var la_seqNo                = document.getElementsByName("seqNo");
        var la_btnRateTypeDetails   = document.getElementsByName("btnRateTypeDetails");
        var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
lv_index=lv_index-1;       
 var postVal                 = "seqNo=" + la_seqNo[lv_index].value;


        $.ajax({
            async:false,
            type: "POST",
            url: CHANGE_RATE_TYPE,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                showBarMessage("Ready", 2);
                if(data=="OK"){
                    /*la_btnRateTypeDetails[lv_index].className   = "margin-left-zero styled-checkbox form-control";*/
                    la_rateTypeFlag[lv_index].value             = "N";
                    lp_rateTypeControl();
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });

    }



    function lp_rateTypeControl(){
        //var la_specialCargo         = document.getElementsByName("specialCargo");
        var la_rateType             = document.getElementsByName("rateType");
        var la_btnRateTypeDetails   = document.getElementsByName("btnRateTypeDetails");

        /*for(var i=0;i<la_specialCargo.length;i++){
            if(la_specialCargo[i].checked==false){
                la_rateType[i].value                    = "";
                la_rateType[i].disabled                 = true;
                la_btnRateTypeDetails[i].disabled       = true;

            }else{
                la_rateType[i].disabled             = false;

                if(la_rateType[i].value=="RF" || la_rateType[i].value=="D1" || la_rateType[i].value=="O0"){
                    la_btnRateTypeDetails[i].disabled   = false;
                }else{
                    la_btnRateTypeDetails[i].disabled   = true;
                }
            }
        }*/


    }
    /*End @20*/

/*Begin @20*/
function uploadAttachment(){
	debugger;
    var urlStr                  = "";
    var lo_uploadFlag           = document.getElementById("uploadFlag");

    if(lo_uploadFlag.value=="N"){
        urlStr = UPLOAD_ATTACHMENT;
    }else{
        urlStr = GET_UPLOAD_ATTACHMENT;
    }

    openScreenForNewWeb(urlStr, 'uploadAttach', 800, 400);
    return false;
}

function callBackUploadAttachment(av_uploadFlag){
    var lo_uploadFlag           = document.getElementById("uploadFlag");

    lo_uploadFlag.value = av_uploadFlag;
}

/*End @20*/

function openRateTypeLookUp() {
    var lo_element_current 	= window.event.srcElement;
    var rowIndex                = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
    var la_rateType             = document.getElementsByName("rateType");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
    var urlStr                  = "";

    if(la_rateType[rowIndex].value=="RF"){
        if(la_rateTypeFlag[rowIndex].value=="N"){
            urlStr   = REFER_COMMODITY + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }else{
            urlStr   = REFER_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }
    }else if(la_rateType[rowIndex].value=="D1"){
        if(la_rateTypeFlag[rowIndex].value=="N"){
            urlStr   = DG_COMMODITY + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }else{
            urlStr   = DG_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }
    }else if(la_rateType[rowIndex].value=="O0"){
        if(la_rateTypeFlag[rowIndex].value=="N"){
            urlStr   = OOG_COMMODITY + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }else{
            urlStr   = OOG_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }
    }else{
        return false;
    }

//    openHelpList(urlStr, 950, 750);
    openScreenForNewWeb(urlStr, 'RateTypeDetails', 950, 750);
    return false;
}


function openRateTypeLookUpNew() {
	debugger;
    var lo_element_current 	= window.event.srcElement;
    var rowIndex                = lo_element_current.parentNode.parentNode.parentNode.parentNode.parentNode.rowIndex;
    var la_rateType             = document.getElementsByName("rateType");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
    var urlStr                  = "";
rowIndex=rowIndex-1;
    if(la_rateType[rowIndex].value=="RF"){
        if(la_rateTypeFlag[rowIndex].value=="N"){
            urlStr   = REFER_COMMODITY + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }else{
            urlStr   = REFER_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }
    }else if(la_rateType[rowIndex].value=="D1"){
        if(la_rateTypeFlag[rowIndex].value=="N"){
            urlStr   = DG_COMMODITY + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }else{
            urlStr   = DG_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }
    }else if(la_rateType[rowIndex].value=="O0"){
        if(la_rateTypeFlag[rowIndex].value=="N"){
            urlStr   = OOG_COMMODITY + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }else{
            urlStr   = OOG_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex;
        }
    }else{
        return false;
    }

//    openHelpList(urlStr, 950, 750);
    openScreenForNewWeb(urlStr, 'RateTypeDetails', 950, 750);
    return false;
}

function openScreenForNewWeb(screen_url, winName, screenWidth, screenHeight){
    childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight + ',left=' + x + ',top=' + y + 'resizable=yes,scrollbars=yes,toolbar=yes,titlebar=yes');
    childWindow.focus();
}

function callBackRateTypeLookUp(av_seqNo, av_rowIndex) {
    //alert(av_seqNo + " " + av_rowIndex);
    var la_btnRateTypeDetails   = document.getElementsByName("btnRateTypeDetails");
    var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");

    la_btnRateTypeDetails[av_rowIndex].className    = "input-group-text btnColor";
    la_rateTypeFlag[av_rowIndex].value              = "Y";
}

function openCommodityGroupLookup(ao_obj) {
//    var lo_element_current 	= window.event.srcElement;
//    var aintIndex               = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
    var aintIndex               = ao_obj.parentNode.parentNode.rowIndex;
    var urlStr                  = COMMODITY_LOOKUP+'?commodityRowIndex=' +aintIndex;
    // window.open(urlStr,'serv004','height=600px','width=530px');
    openHelpList(urlStr, 900, 600);
    return false;
}

function openCommodityGroupLookupNew(ao_obj,obj_row) {
	var index=0;
	if(ao_obj.parentNode.parentNode.parentNode.parentNode.rowIndex>0){
		index=ao_obj.parentNode.parentNode.parentNode.parentNode.rowIndex-1;
	} 
//  var lo_element_current 	= window.event.srcElement;
//  var aintIndex               = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
 // var aintIndex               = ao_obj.parentNode.parentNode.childElementCount;
	var aintIndex               = index;
  var urlStr                  = COMMODITY_LOOKUP+'?commodityRowIndex=' +aintIndex;
  // window.open(urlStr,'serv004','height=600px','width=530px');
  openHelpList(urlStr, 800, 600);
  return false;
}

function setLookupValues(arowId, commodityGroup, commodityDesc) {
    try{
        la_group        = document.getElementsByName("group");
        la_description  = document.getElementsByName("description");

        la_group[arowId].value          = commodityGroup;
        la_description[arowId].value    = commodityDesc;

        updateCommodityRecStatus(la_group[arowId],arowId);

    }catch(err){
        handleJavaScriptError('setLookupValues', err, error_code);
    }
} //setLookupValues

function setLookupValuesNew(arowId, commodityGroup, commodityDesc) {
    try{
        la_group        = document.getElementsByName("group");
        la_description  = document.getElementsByName("description");

        la_group[arowId].value          = commodityGroup;
        la_description[arowId].value    = commodityDesc;

        updateCommodityRecStatusNew(la_group[arowId],arowId);

    }catch(err){
        handleJavaScriptError('setLookupValues', err, error_code);
    }
}

function checkRateTypeData(objectData){
	
	    var lo_element_current 	    = window.event.srcElement;
        var rowIndex                = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
        var la_rateType             = document.getElementsByName("rateType");
		var rate_type_button		= document.getElementsByName("btnRateTypeDetails");
	    rowIndex=rowIndex-1;

   if(la_rateType[rowIndex].value=="RF"){
         rate_type_button[rowIndex].style= "background-color:white";
    }else if(la_rateType[rowIndex].value=="D1"){
         rate_type_button[rowIndex].style= "background-color:white";
    }else if(la_rateType[rowIndex].value=="O0"){
         rate_type_button[rowIndex].style= "background-color:white";
    }else if(la_rateType[rowIndex].value=="N"){
         rate_type_button[rowIndex].style= "background-color:#ced4da";
    }else if(la_rateType[rowIndex].value=="NR"){
         rate_type_button[rowIndex].style= "background-color:#ced4da";
    }else if(la_rateType[rowIndex].value=="DA"){
         rate_type_button[rowIndex].style= "background-color:#ced4da";
    }else if(la_rateType[rowIndex].value=="OD"){
         rate_type_button[rowIndex].style= "background-color:#ced4da";
    }else{
        return false;
    }
	
}

function openEquipTypeLookup(ao_obj) {
    var aintIndex               = gp_rowTableIndex(ao_obj.parentNode);
   aintIndex=aintIndex-1;
 	var urlStr                  = GET_EQUIP_TYPE_LOOKUP_DATA+'?rowIndex=' +aintIndex + "&transaction=new";

    openHelpList(urlStr, 910, 450);

    return false;
}

function callBackEquipmentTypeLookUp(av_code, av_desc, av_rowIndex){

    var la_type             = document.getElementsByName("type");
    var la_typeDesc         = document.getElementsByName("typeDesc");
    var la_cargoType        = document.getElementsByName("cargoType");
    var lv_desc             = "";

    try{
        lv_desc                         = av_code + " - " + av_desc;
        la_type[av_rowIndex].value      = av_code;
        la_typeDesc[av_rowIndex].value  = lv_desc;

        if(av_code=="RE" || av_code=="RH"){
            la_cargoType[av_rowIndex].value      = "N";

            lp_onChangeCargoType(la_type[av_rowIndex]);
        }else{
            updateSizeTypeRecStatus(la_type[av_rowIndex]);
        }

    }
    catch(err){
        handleJavaScriptError('callBackEquipmentTypeLookUp', err, error_code);
    }
}

function uploadDocument() {
    alert('work in progress ...');
} // uploadDocument


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

//@12 BEGIN
function putMask_NumberEX(aField, aintDigits, aintDecimals){
    try{
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
//@12 END

/*Begin @20*/
function updateCommodityRecStatus(ao_element_current) {

    //var lo_element_current 	= window.event.srcElement;
    var lv_index                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
  //  var la_specialCargo         = document.getElementsByName("specialCargo");
	var la_specialCargo         = ""
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "N";

    try{
        if(la_specialCargo[lv_index].checked==true){
            lv_specialCargo = "Y";
        }
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
} // updateCommodityRecStatus
/*End @20*/
function updateCommodityRecStatus(ao_element_current,rowNo) {

    //var lo_element_current 	= window.event.srcElement;
    var lv_index                = rowNo;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
    //var la_specialCargo         = document.getElementsByName("specialCargo");
	var la_specialCargo         = "";
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "N";

    try{
        if(la_specialCargo[lv_index].checked==true){
            lv_specialCargo = "Y";
        }
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
}



function updateCommodityRecStatus(ao_element_current) {

    //var lo_element_current 	= window.event.srcElement;
    var lv_index                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
   // var la_specialCargo         = document.getElementsByName("specialCargo");
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "Y";

    try{
        if(la_specialCargo[lv_index].checked==true){
            lv_specialCargo = "Y";
        }
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
}

function updateCommodityRecStatusNew(ao_element_current,rowno) {
	debugger;
    //var lo_element_current 	= window.event.srcElement;
	var lv_index                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
  //var la_specialCargo         = document.getElementsByName("specialCargo");
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "Y";
	lv_index=lv_index-1;
    try{
        //if(la_specialCargo[lv_index].checked==true){
        //     lv_specialCargo = "Y";
        //}
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
}

function updateCommodityRecStatusNewRateType(ao_element_current,rowno) {
	debugger;
    //var lo_element_current 	= window.event.srcElement;
	var lv_index                = ao_element_current.parentNode.parentNode.parentNode.rowIndex;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
    //var la_specialCargo         = document.getElementsByName("specialCargo");
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "Y";
	lv_index=lv_index-1;
    try{
        /*if(la_specialCargo[lv_index].checked==true){
            lv_specialCargo = "Y";
        }*/
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value		  ;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
}

function updateCommodityRecStatusNewSpecialCargo(ao_element_current,rowno) {
	debugger;
    //var lo_element_current 	= window.event.srcElement;
	var lv_index                = ao_element_current.parentNode.parentNode.parentNode.rowIndex;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "Y";
	lv_index=lv_index-1;
    try{
       /* if(la_specialCargo[lv_index].checked==true){
            lv_specialCargo = "Y";
        }*/
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
}

function updateCommodityRecStatusNewFortextArea(ao_element_current,rowno) {
	debugger;
    //var lo_element_current 	= window.event.srcElement;
	var lv_index                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_radCommodity         = document.getElementsByName("radCommodity");
    var la_posObjectCommod      = document.getElementsByName("posObjectCommod");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_group                = document.getElementsByName("group");
    var la_description          = document.getElementsByName("description");
    var la_grossWeight          = document.getElementsByName("grossWeight");
   // var la_specialCargo         = document.getElementsByName("specialCargo");
    var la_specialInstruction   = document.getElementsByName("specialInstruction");
    var la_rateType             = document.getElementsByName("rateType");
    var postVal                 = "";
    var lv_specialCargo         = "Y";
	
    try{
       /* if(la_specialCargo[lv_index].checked==true){
            lv_specialCargo = "Y";
        }*/
        //alert(gp_sanitizeURLString(la_specialInstruction[lv_index].value));
        postVal     = "radCommodity="   + la_radCommodity[lv_index].value     + "&posObjectCommod="       + la_posObjectCommod[lv_index].value
                    + "&seqNo="         + la_seqNo[lv_index].value            + "&group="                 + la_group[lv_index].value
                    + "&description="   + la_description[lv_index].value      + "&grossWeight="           + la_grossWeight[lv_index].value
                    + "&specialCargo="  + lv_specialCargo                     + "&specialInstruction="    + gp_sanitizeURLString(la_specialInstruction[lv_index].value)
                    + "&rateType="      + la_rateType[lv_index].value;
        $.ajax({
            async:false,
            type: "POST",
            url: UPD_COMMODITY_DATA,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),
            success: function(data){
                if(trim(data)=="OK"){

                    showBarMessage("Ready", 2);
                }else{
                	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
                }
            }
        });
    }
    catch(err){
        alert("updateCommodityRecStatus :: " + err);
        handleJavaScriptError('updateCommodityRecStatus', err,error_code);
    }
}


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

/*Begin @20*/
function sizeTypeValidation(){
    var la_type                                 = document.getElementsByName("type");
    var la_size                                 = document.getElementsByName("size");
    var la_cargoType                            = document.getElementsByName("cargoType");
    var la_laden                                = document.getElementsByName("laden");
    var la_mt                                   = document.getElementsByName("mt");
    var la_grossContainerWeight                 = document.getElementsByName("grossContainerWeight");
    var la_polStatus                            = document.getElementsByName("polStatus");
    var la_podStatus                            = document.getElementsByName("podStatus");
    var la_eqSeqNo                              = document.getElementsByName("eqSeqNo");
    var lv_strSize                              = "";
    var lv_strType                              = "";
    var lv_strCargoType                         = "";
    var lv_strResult                            = "";
    var lv_strSupSize                           = "";
    var lv_strSupType                           = "";
    var lv_strSupCargoType                      = "";
    var lv_strSupResult                         = "";
    var strCountMsg                             = "";
    var isFirstNo                               = true;
    var lv_laden                                = "";
    var lv_mt                                   = "";
    var lv_grossContainerWeight                 = "";

    for(var i=0;i<la_eqSeqNo.length;i++){
        lv_strType         = la_type[i].value;
        lv_strSize         = la_size[i].value;
        lv_strCargoType    = la_cargoType[i].value;

        lv_strResult        = lv_strType + lv_strSize + lv_strCargoType;

        for(var j=(i+1);j<la_eqSeqNo.length;j++){
            lv_strSupType         = la_type[j].value;
            lv_strSupSize         = la_size[j].value;
            lv_strSupCargoType    = la_cargoType[j].value;

            lv_strSupResult       = lv_strSupType + lv_strSupSize + lv_strSupCargoType;

            if(lv_strResult == lv_strSupResult){
            	showBarMessageNew(ESR_SE0017+" "+(i+1)+"&"+(j+1), 1);
window.scrollTo(500, 0);
                return false;
            }

            if(lv_strCargoType=="O0"){
                lv_laden = la_laden[i].value==null || trimString(lv_laden) == BLANK ? "0" : la_laden[i].value;

                if(parseInt(lv_laden) > 1){
                	showBarMessageNew(ESR_SE0029, 1);
window.scrollTo(500, 0);
                    return false;
                }

                if(lv_strCargoType==lv_strSupCargoType){
                	showBarMessageNew(ESR_SE0030, 1);
window.scrollTo(500, 0);
                    return false;
                }
            }

        }

    }

    for(var i=0;i<la_eqSeqNo.length;i++){
        lv_laden                    = la_laden[i].value;
        lv_mt                       = la_mt[i].value;

        if ((lv_laden == null) || (trimString(lv_laden) == BLANK)){
            la_laden[i].value='0';
            la_laden[i].focus();
            return false;
        }

        if ((lv_mt == null) || (trimString(lv_mt) == BLANK)){
            la_mt[i].value='0';
            la_mt[i].focus();
            return false;
        }

        if(lv_laden == "0" && lv_mt == "0"){
            if(isFirstNo){
                strCountMsg = strCountMsg + "" + (i+1);
                isFirstNo   = false;
                la_laden[i].focus();
            }else{
                strCountMsg = strCountMsg + "," + (i+1);
                la_laden[i].focus();
            }

        }

    }

    if(strCountMsg != ""){
    	showBarMessageNew("Please indicate number of containers for either Laden or MT at row "+strCountMsg, 1);
window.scrollTo(500, 0);
        return false;
    }

    for(var i=0;i<la_eqSeqNo.length;i++){
        lv_grossContainerWeight     = la_grossContainerWeight[i].value;

        if(blankFieldError(lv_grossContainerWeight, ESR_SE0009+' ' + (i+1))){
            la_grossContainerWeight[i].focus();
            return false;
        }

    }

    for(var i=0;i<la_eqSeqNo.length;i++){
        lv_laden           = parseInt(la_laden[i].value);
        lv_strCargoType    = la_cargoType[i].value;

        if(lv_strCargoType=="O0" && lv_laden > 1){
        	showBarMessageNew(ESR_SE0029, 1);
window.scrollTo(500, 0);
            return false;
        }
    }

    return true;
}
/*End @20*/

/*Begin @20*/
function commodityValidation(){

    var la_group            = document.getElementsByName("group");
    var la_specialCargo     = "";
	//var la_specialCargo     = document.getElementsByName("specialCargo");
    var la_rateType         = document.getElementsByName("rateType");
    var la_cargoType        = document.getElementsByName("cargoType");
    var la_rateTypeFlag     = document.getElementsByName("rateTypeFlag");
    var la_type             = document.getElementsByName("type");
	var totalgrossContainerWeightobj= document.getElementsByName("grossContainerWeight");
	var totalgrossWeightobj= document.getElementsByName("grossWeight");
	var totalgrossContainerWeight =0;
	var totalgrossWeight =0;
    var lv_dg               = "D1";
    var lv_oog              = "O0";
    var lv_rf               = "RF";
    var lv_normal           = "N";
    var lv_cargoType        = "";
    var lv_rateType         = "";
    var lv_selectIndex      = null;
    var lv_option           = null;
    //var lv_chkREEFER        = true;
    //var lv_chkDG            = true;
    //var lv_chkOOG           = true;
    var lo_rfTypeNormal     = document.getElementById("rfTypeNormal");
    var la_rfTypeNormal     = lo_rfTypeNormal.value.split(",");
    var la_type             = document.getElementsByName("type");

    for(var i=0;i<la_group.length;i++){
        if(blankFieldError(la_group[i].value, ESR_SE0011)){
			showBarMessageNew(ESR_SE0011, ESR_SE0011);
			window.scrollTo(500, 0);
            return false;
        }
    }

    /*Begin check cargo type*/
    for(var i=0;i<la_cargoType.length;i++){
        if(la_cargoType[i].value!="N"){
            loop0:for(var j=0;j<la_rateType.length;j++){
                if(la_cargoType[i].value==la_rateType[j].value){
                    lv_cargoType = "";
                    break loop0;
                }else{
                    lv_selectIndex  = la_cargoType[i].selectedIndex;
                    lv_option       = la_cargoType[i].options;
                    lv_cargoType    = lv_option[lv_selectIndex].text;
                    lv_rateType     = lv_option[lv_selectIndex].text;
                }
            }
        }else{
            if(la_type[i].value=="RE" || la_type[i].value=="RH"){
                loop0:for(var j=0;j<la_rateType.length;j++){
                    if(la_rateType[j].value==lv_rf){
                        lv_cargoType = "";
                        break loop0;
                    }else{
                        lv_selectIndex  = la_cargoType[i].selectedIndex;
                        lv_option       = la_cargoType[i].options;
                        lv_cargoType    = "REEFER";
                        lv_rateType     = "REEFER";
                    }
                }
            }
        }
        if(lv_cargoType!="")break;
    }

    if(lv_cargoType!=""){
    	showBarMessageNew(ESR_SE0028_NEW, MSG_ERROR_CODE, new Array(lv_cargoType, lv_rateType));
		window.scrollTo(500, 0);
        return false;
    }
    /*End check cargo type*/

    /*Begin check rate type*/
    lv_rateType = "";
    loop1:for(var i=0;i<la_specialCargo.length;i++){
        if(la_specialCargo[i].checked==true && la_rateType[i].value!="N"){

            //REEFER case
            if(la_rateType[i].value==lv_rf){
                if(la_rateTypeFlag[i].value=="N"){
                	showBarMessageNew(ESR_SE0022, MSG_ERROR_CODE);
					window.scrollTo(500, 0);
                    return false;
                }

                loop4:for(var j=0;j<la_type.length;j++){
                    loop5:for(var k=0;k<la_rfTypeNormal.length;k++){
                        if(la_type[j].value==la_rfTypeNormal[k]){
                            lv_rateType = "";
                            break loop4;
                        }else{
                            lv_selectIndex  = la_rateType[i].selectedIndex;
                            lv_option       = la_rateType[i].options;
                            lv_rateType     = lv_option[lv_selectIndex].text;
                        }
                    }
                }
                if(lv_rateType!="")break loop1;
            }else{
                //DG case
                if(la_rateType[i].value==lv_dg){
                    if(la_rateTypeFlag[i].value=="N"){
                    	showBarMessageNew(ESR_SE0023, MSG_ERROR_CODE);
						window.scrollTo(500, 0);
                        return false;
                    }
                }

                //OOG case
                if(la_rateType[i].value==lv_oog){
                    if(la_rateTypeFlag[i].value=="N"){
                    	showBarMessageNew(ESR_SE0024, MSG_ERROR_CODE);
						window.scrollTo(500, 0);
                        return false;
                    }
                }

                loop2:for(var j=0;j<la_cargoType.length;j++){
                    if(la_rateType[i].value==la_cargoType[j].value){
                        lv_rateType = "";
                        break loop2;
                    }else{
                        lv_selectIndex  = la_rateType[i].selectedIndex;
                        lv_option       = la_rateType[i].options;
                        lv_rateType     = lv_option[lv_selectIndex].text;
                    }
                }
                if(lv_rateType!="")break loop1;
            }
        }
    }

    if(lv_rateType!=""){
    	showBarMessageNew(ESR_SE0021, MSG_ERROR_CODE, new Array(lv_rateType, lv_rateType));
		window.scrollTo(500, 0);
        return false;
    }

	for(var i=0;i<totalgrossContainerWeightobj.length;i++){
		totalgrossContainerWeight=totalgrossContainerWeight+Number(totalgrossContainerWeightobj[i].value.replace(',', ""));
	}
	for(var i=0;i<totalgrossWeightobj.length;i++){
		totalgrossWeight=totalgrossWeight+Number(totalgrossWeightobj[i].value.replace(',', ""));
	}
	if(totalgrossWeight!=totalgrossContainerWeight){
		showBarMessageNew("Total Gross cargo weight of Equipment and total Gross cargo weight of commodity details should be same.", MSG_ERROR_CODE);
		window.scrollTo(500, 0);
		return false;
	}
    /*End check rate type*/

    return true;
}
/*End @20*/

/*Begin @20*/
function deleteEquipmentNew() {
    var lo_table                    = document.getElementById("result_dtl");
    var la_equipmentSelectChkBox    = document.getElementsByName("equipmentSelectChkBox");
    var la_seqNo                    = document.getElementsByName("eqSeqNo");
    var lv_request                  = "";
    var lv_num                      = 0;
    var lv_seqIndex                 = 0;
    var postVal                     = "";
    //var la_tr			    = new Array();
    var la_rowIndex		    = new Array();
    var deleteIndex 		=new Array();
debugger;
    for(var i=0;i<la_equipmentSelectChkBox.length;i++){
        if(la_equipmentSelectChkBox[i].checked==true){
            lv_seqIndex = i + 1;
			deleteIndex.push(lv_seqIndex);
            if(lv_request==""){
                lv_request = la_seqNo[lv_seqIndex].value;
            }else{
                lv_request += "#" + la_seqNo[lv_seqIndex].value
            }
            //la_tr[lv_num] = la_seqNo[lv_seqIndex].parentNode.parentNode;
            la_rowIndex[lv_num] = la_equipmentSelectChkBox[i];
            lv_num++;
        }
    }

    if(lv_num == 0){
        alert("Please select at least one equipment row to delete.");
        return;
    }

    postVal     = "paramReq=" + lv_request;

    $.ajax({
        async:false,
        type: "POST",
        url: DEL_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                //alert("length :: " + la_rowIndex.length);
                for(var i=deleteIndex.length-1;i>=0;i--){
                    //alert(la_rowIndex[i]);
                    lo_table.deleteRow(deleteIndex[i]);
                    //lo_table.childNodes[0].removeChild(la_tr[i]);
                }
 					for(var i=0;i<lo_table.rows.length;i++){
                    lo_table.rows[i].cells[0].innerHTML = (i+1);
                }
           
            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });
}
/*End @20*/
function deleteEquipment() {
    var lo_table                    = document.getElementById("result_dtl");
    var la_equipmentSelectChkBox    = document.getElementsByName("equipmentSelectChkBox");
    var la_seqNo                    = document.getElementsByName("eqSeqNo");
    var lv_request                  = "";
    var lv_num                      = 0;
    var lv_seqIndex                 = 0;
    var postVal                     = "";
    //var la_tr			    = new Array();
    var la_rowIndex		    = new Array();

    for(var i=0;i<la_equipmentSelectChkBox.length;i++){
        if(la_equipmentSelectChkBox[i].checked==true){
            lv_seqIndex = i + 1;
            if(lv_request==""){
                lv_request = la_seqNo[lv_seqIndex].value;
            }else{
                lv_request += "#" + la_seqNo[lv_seqIndex].value
            }
            //la_tr[lv_num] = la_seqNo[lv_seqIndex].parentNode.parentNode;
            la_rowIndex[lv_num] = la_equipmentSelectChkBox[i];
            lv_num++;
        }
    }

    if(lv_num == 0){
        alert("Please select at least one equipment row to delete.");
        return;
    }

    postVal     = "paramReq=" + lv_request;

    $.ajax({
        async:false,
        type: "POST",
        url: DEL_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                //alert("length :: " + la_rowIndex.length);
                for(var i=0;i<la_rowIndex.length;i++){
                    //alert(la_rowIndex[i]);
                    lo_table.deleteRow(gp_rowTableIndex(la_rowIndex[i]));
                    //lo_table.childNodes[0].removeChild(la_tr[i]);
                }
                for(var i=0;i<lo_table.rows.length;i++){
                    lo_table.rows[i].cells[0].innerHTML = (i+1);
                }

                showBarMessage("Ready", 2);
            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });
}


/*Begin @20*/
function deleteCommodityNew() {
	debugger;
    var lo_table                    = document.getElementById("comm_result_dtl");
    var lo_tableSI                  = document.getElementById("tableSI");
    var la_isSelected               = document.getElementsByName("isSelected");
    var la_seqNo                    = document.getElementsByName("seqNo");
    var la_specialInstruction       = document.getElementsByName("specialInstruction");
    var lv_request                  = "";
    var lv_num                      = 0;
    var lv_seqIndex                 = 0;
    var postVal                     = "";
//    var la_tr			    = new Array();
//    var la_trSI			    = new Array();
    var la_rowIndex		    = new Array();
    var la_rowIndexSI		    = new Array();
	var deleteIndex 		=new Array();
debugger;	
    for(var i=0;i<la_isSelected.length;i++){
        if(la_isSelected[i].checked==true){
            lv_seqIndex = i + 1;
deleteIndex.push(lv_seqIndex);
            if(lv_request==""){
                lv_request = la_seqNo[lv_seqIndex].value;
            }else{
                lv_request += "#" + la_seqNo[lv_seqIndex].value
            }
//            la_tr[lv_num]       = la_seqNo[lv_seqIndex].parentNode.parentNode;
//            la_trSI[lv_num]     = la_specialInstruction[lv_seqIndex].parentNode.parentNode;
            la_rowIndex[lv_num]         = la_isSelected[i];
            la_rowIndexSI[lv_num]       = la_specialInstruction[lv_seqIndex];
            lv_num++;
        }
    }

    if(lv_num == 0){
        alert("Please select at least one commodity row to delete.");
        return;
    }

    postVal     = "paramReq=" + lv_request;

    $.ajax({
        async:false,
        type: "POST",
        url: DEL_COMMODITY_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                for(var i=deleteIndex.length-1;i>=0;i--){
//                    lo_table.childNodes[0].removeChild(la_tr[i]);
//                    lo_tableSI.childNodes[0].removeChild(la_trSI[i]);
                    lo_table.deleteRow(deleteIndex[i]);
                    lo_tableSI.deleteRow(deleteIndex[i]);
                }
                checkedLastItem();
                displaySpecialIns();
                for(var i=0;i<lo_table.rows.length;i++){
                    lo_table.rows[i].cells[1].innerHTML = (i+1);
                }

                showBarMessage("Ready", 2);
            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });

}
/*End @20*/
function deleteCommodity() {
    var lo_table                    = document.getElementById("comm_result_dtl");
    var lo_tableSI                  = document.getElementById("tableSI");
    var la_isSelected               = document.getElementsByName("isSelected");
    var la_seqNo                    = document.getElementsByName("seqNo");
    var la_specialInstruction       = document.getElementsByName("specialInstruction");
    var lv_request                  = "";
    var lv_num                      = 0;
    var lv_seqIndex                 = 0;
    var postVal                     = "";
//    var la_tr			    = new Array();
//    var la_trSI			    = new Array();
    var la_rowIndex		    = new Array();
    var la_rowIndexSI		    = new Array();

    for(var i=0;i<la_isSelected.length;i++){
        if(la_isSelected[i].checked==true){
            lv_seqIndex = i + 1;
            if(lv_request==""){
                lv_request = la_seqNo[lv_seqIndex].value;
            }else{
                lv_request += "#" + la_seqNo[lv_seqIndex].value
            }
//            la_tr[lv_num]       = la_seqNo[lv_seqIndex].parentNode.parentNode;
//            la_trSI[lv_num]     = la_specialInstruction[lv_seqIndex].parentNode.parentNode;
            la_rowIndex[lv_num]         = la_isSelected[i];
            la_rowIndexSI[lv_num]       = la_specialInstruction[lv_seqIndex];
            lv_num++;
        }
    }

    if(lv_num == 0){
        alert("Please select at least one commodity row to delete.");
        return;
    }

    postVal     = "paramReq=" + lv_request;

    $.ajax({
        async:false,
        type: "POST",
        url: DEL_COMMODITY_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                for(var i=0;i<la_rowIndex.length;i++){
//                    lo_table.childNodes[0].removeChild(la_tr[i]);
//                    lo_tableSI.childNodes[0].removeChild(la_trSI[i]);
                    lo_table.deleteRow(gp_rowTableIndex(la_rowIndex[i]));
                    lo_tableSI.deleteRow(gp_rowTableIndex(la_rowIndexSI[i]));
                }
                checkedLastItem();
                displaySpecialIns();
                for(var i=0;i<lo_table.rows.length;i++){
                    lo_table.rows[i].cells[1].innerHTML = (i+1);
                }

                showBarMessage("Ready", 2);
            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });

}

/*Begin @20*/
function displaySpecialIns(){
	debugger;
    var la_radCommodity                 = document.getElementsByName("radCommodity");
    var lo_table                        = document.getElementById("tableSI");
   // var la_specialCargo                 = document.getElementsByName("specialCargo");
 	var la_specialCargo                 = "";
    var la_specialInstruction           = document.getElementsByName("specialInstruction");
    var lv_radCommodity                 = 0;
    var lv_flagSp                       = false;
    var la_seqNo                        = document.getElementsByName("seqNo");
    var lv_seq                          = null;
    var postVal                         = "";
    var lv_code;

    for(var i=0;i<la_radCommodity.length;i++){
        if(la_radCommodity[i].checked==true){
            /*lv_radCommodity = la_radCommodity[i].value;
            break;*/
            lo_table.rows[i].style.display = "block";
        }else{
            lo_table.rows[i].style.display = "none";
        }
    }

    lp_rateTypeControl();

}
/*End @20*/

function checkedLastItem(){
	debugger;
    var la_radCommodity = document.getElementsByName("radCommodity");
    var lv_chk          = true;

    try{

        for(var i=0;i<la_radCommodity.length;i++){
            if(la_radCommodity[i].checked==true){
                lv_chk = false;
                break;
            }
        }

        if(lv_chk==true){
            la_radCommodity[0].checked = true;
        }

    }catch(e){
        alert("checkedLastItem :: " + e);
    }
}//checkedLastItem

function checkedFirstItem(){
    var rowObj = document.forms[0].radCommodity;

    if(undefined != rowObj.value){
        rowObj.checked = true;
    }else{
        rowObj[0].checked = true;
    }
}//checkedLastItem

/*Begin @20*/
function addSpecialInstruction(av_val){
    var lo_table                        = document.getElementById("tableSI");
    var rowIndex                        = lo_table.rows.length;
    var newNodeTr 	                = null;
    var newNodeTd1 			= null;

    try{
        newNodeTr               = lo_table.insertRow(rowIndex);
        newNodeTd1              = newNodeTr.insertCell(0);

        newNodeTr.valign        = "top";

        newNodeTd1.innerHTML    = '<textarea name="specialInstruction" id="specialInstruction'+av_val+'" cols="50" rows="5" onclick="maxlenghtTextArea(this, 400)" onblur="updateCommodityRecStatus(this);" onkeyup="maxlenghtTextArea(this, 400)" class="Combo"></textarea>';

        //newNodeTr.appendChild(newNodeTd1);

        displaySpecialIns();

    }catch(e){
        alert("addSpecialInstruction :: " + e);
    }
}
/*End @20*/
function addSpecialInstructionNew(av_val){
    var lo_table                        = document.getElementById("tableSI");
    var rowIndex                        = lo_table.rows.length;
    var newNodeTr 	                = null;
    var newNodeTd1 			= null;

    try{
        newNodeTr               = lo_table.insertRow(rowIndex);
        newNodeTd1              = newNodeTr.insertCell(0);

        newNodeTr.valign        = "top";

        newNodeTd1.innerHTML    = '<textarea  name="specialInstruction" id="specialInstruction'+av_val+'" cols="50" rows="5" onclick="maxlenghtTextArea(this, 400)" onblur="updateCommodityRecStatusNewFortextArea(this);" onkeyup="maxlenghtTextArea(this, 400)" class="form-control"></textarea>';

        //newNodeTr.appendChild(newNodeTd1);

        displaySpecialIns();

    }catch(e){
        alert("addSpecialInstruction :: " + e);
    }
}

function validateEmail() {

    var emails = document.forms[0].additionalMailRecipeints;

    var x = emails.value.split(',');
//    alert(x.length);
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(emails.value != ""){
        for(i = 0 ; i < x.length ; i++){
//        alert(":"+x[i]+":");
            if(!re.test(x[i])){
                alert("Please Enter a Valid Email");
                break;
            }
        }
    }
//    if(!re.test(emails.value)){
//        alert("Please Enter a Valid Email");
//    }
    return re.test(emails.value);
} // end validateEmail

//BEGIN validatePhoneNumber
/**
 * DHTML phone number validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */

// Declaring required variables
var digits = "0123456789";
// non-digit characters which are allowed in phone numbers
var phoneNumberDelimiters = "()- ";
// characters which are allowed in international phone numbers
// (a leading + is OK)
var validWorldPhoneChars = phoneNumberDelimiters + "+";
// Minimum no of digits in an international phone no.
var minDigitsInIPhoneNumber = 9;

function isInteger(s)
{   var i;
    for (i = 0; i < s.length; i++)
    {
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
function trim(s)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not a whitespace, append to returnString.
    for (i = 0; i < s.length; i++)
    {
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (c != " ") returnString += c;
    }
    return returnString;
}
function stripCharsInBag(s, bag)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
    {
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function checkInternationalPhone(strPhone){
    var bracket     = 3
    strPhone        = trim(strPhone)

    if(strPhone.indexOf("+")>1) return false
    if(strPhone.indexOf("-")!=-1)bracket=bracket+1
    if(strPhone.indexOf("(")!=-1 && strPhone.indexOf("(")>bracket)return false

    var brchr       = strPhone.indexOf("(")
    if(strPhone.indexOf("(")!=-1 && strPhone.charAt(brchr+2)!=")")return false
    if(strPhone.indexOf("(")==-1 && strPhone.indexOf(")")!=-1)return false
    s               = stripCharsInBag(strPhone,validWorldPhoneChars);

    return (isInteger(s) && s.length >= minDigitsInIPhoneNumber);
}

function validateForm(){
	var Phone=document.forms[0].telephone

	if ((Phone.value==null)||(Phone.value=="")){
		alert("Please Enter your Phone Number")
//		Phone.focus()
		return false
	}
	if (checkInternationalPhone(Phone.value)==false){
		alert("Please Enter a Valid Phone Number")
//		Phone.value=""
//		Phone.focus()
		return false
	}
	return true
 }
 //END validatePhoneNumber

/* * end of JavaScript * */

function showQuotationInfo(){
    var qtnInfo = document.getElementById("qtnInfo");
    var quotationNumber = null;
    try{
        qtnInfo.title = msgQtnInfo;
        quotationNumber = document.forms[0].quotationNumber;
        if(0==quotationNumber.selectedIndex)
        {
            qtnInfo.title = msgQtn;
        }
    }catch(err){
    }
}

//@05 BEGIN
function showEmptyPickDepotName(val){
    var emptyPickupDepot    = document.forms[0].selEmptyPickupDepot;

    emptyPickupDepot.title  = emptyPickupDepot.options[document.forms[0].selEmptyPickupDepot.selectedIndex].text;
}
//@05 END

//@09 BEGIN
function assignValue(){
    document.forms[0].emptyPickupDepot.value = document.forms[0].selEmptyPickupDepot.value;
}
function assignValueType(ao_element){
   var objSet = ao_element;
   if(objSet != null && objSet != undefined && objSet.value != ''){
        checkQuotationNo();
   }
}

function assignValueSize(ao_element){
   var objSet = ao_element;
   if(objSet != null && objSet != undefined && objSet.value != ''){
      //  checkQuotationNo();
   }
}

/*Begin @21*/
function lp_onChangeCargoType(ao_element_current){

    var la_cargoType    = null;
    var la_mt           = null;
    var lv_rowIndex     = 0;
    var lv_cargoType    = null;

    try{
        la_cargoType    = document.getElementsByName("cargoType");
        la_mt           = document.getElementsByName("mt");

        if(ao_element_current!=null){
            lv_rowIndex     = gp_rowTableIndex(ao_element_current);
            lv_cargoType    = la_cargoType[lv_rowIndex].value;

           /* if(lv_cargoType=="N"){
               // la_mt[lv_rowIndex].readOnly                 = false;
               //  la_mt[lv_rowIndex].className                = "must";
            }else{
                la_mt[lv_rowIndex].value                    = 0;
               // la_mt[lv_rowIndex].readOnly                 = true;
               // la_mt[lv_rowIndex].className                = "input-disabled";
            }*/

            updateSizeTypeRecStatus(ao_element_current);
        }else{
            for(var i=0;i<la_cargoType.length;i++){
                lv_rowIndex     = i;
                lv_cargoType    = la_cargoType[lv_rowIndex].value;

                /*if(lv_cargoType=="N"){
                   // la_mt[lv_rowIndex].readOnly                 = false;
                   // la_mt[lv_rowIndex].className                = "must";
                }else{
                   // la_mt[lv_rowIndex].readOnly                 = true;
                   // la_mt[lv_rowIndex].className                = "input-disabled";
                }*/
            }
        }

    }catch(err){
        handleJavaScriptError('lp_onChangeCargoType', err, error_code);
    }
}

/*End @21*/


/*Begin @20*/
function updateSizeTypeRecStatus(ao_element_current) {

//    var lo_element_current 	                = window.event.srcElement;
    var lv_index                                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_type                                 = document.getElementsByName("type");
   // var la_typeDesc                             = document.getElementsByName("typeDesc");
    var la_size                                 = document.getElementsByName("size");
    var la_cargoType                            = document.getElementsByName("cargoType");
	var la_cargoStorage                         = "";
	//var la_cargoStorage                         = document.getElementsByName("specialCargo");
    var la_laden                                = document.getElementsByName("laden");
    var la_mt                                   = document.getElementsByName("mt");
    var la_grossContainerWeight                 = document.getElementsByName("grossContainerWeight");
    var la_polStatus                            = document.getElementsByName("polStatus");
    var la_podStatus                            = document.getElementsByName("podStatus");
    var la_eqSeqNo                              = document.getElementsByName("eqSeqNo");
    var la_equipmentSelectChkBox                = document.getElementsByName("equipmentSelectChkBox");
    var lv_chk                                  = "N";
    var lv_name                                 = "";
    var postVal                                 = "";

    if(la_equipmentSelectChkBox[lv_index]!=null){
        lv_chk = la_equipmentSelectChkBox[lv_index].value;
    }

    lv_name = ao_element_current.name;

    postVal     = "type="               + la_type[lv_index].value               + "&size="                        + la_size[lv_index].value
                + "&cargoType="         + la_cargoType[lv_index].value          + "&laden="                       + la_laden[lv_index].value
                + "&mt="                + la_mt[lv_index].value                 + "&grossContainerWeight="        + la_grossContainerWeight[lv_index].value
                + "&polStatus="         + la_polStatus[lv_index].value          + "&podStatus="                   + la_podStatus[lv_index].value
                + "&eqSeqNo="           + la_eqSeqNo[lv_index].value            + "&equipmentSelectChkBox="       + lv_chk
                + "&typeDesc="          + la_type[lv_index].options[la_type[lv_index].selectedIndex].text				+ "&specialCargo="			  ;
//+ la_cargoStorage[lv_index].value;
    $.ajax({
        async:false,
        type: "POST",
        url: UPD_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                showBarMessage("Ready", 2);

                if(lv_name=="type"){
                    assignValueType(la_type[lv_index]);
                }

                if(lv_name=="size"){
                    assignValueSize(la_size[lv_index]);
                }

            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });
}
/*End @20*/

function calculateGrossWaiht(obj,row){
	
	var eqiptRows			= $("[name=grossContainerWeight]").length
	var grossContainerWeightObj = $("[name=grossContainerWeight]");
	var sumWaight 				= 0;
	
	for(var i=0;i<eqiptRows;i++){
		sumWaight=sumWaight+Number(grossContainerWeightObj[i].value.replace(',', ""));
	}
	var commodityRows			= $("[name=grossWeight]").length
	var grossContainerWeightCommodityObj = $("[name=grossWeight]");
	var avgWaight = sumWaight/commodityRows;
	for(var j=0;j<commodityRows;j++){
		grossContainerWeightCommodityObj[j].value=avgWaight;
		updateCommodityRecStatusNew(grossContainerWeightCommodityObj[j]);
		putMask_NumberEX(grossContainerWeightCommodityObj[j], 14, 2)
	}
}


function updateSizeTypeRecStatusNew(ao_element_current,row) {
debugger;
//    var lo_element_current 	                = window.event.srcElement;
    var lv_index                                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_type                                 = document.getElementsByName("type");
  //  var la_typeDesc                             = document.getElementsByName("typeDesc").text;
    var la_size                                 = document.getElementsByName("size");
    var la_cargoType                            = document.getElementsByName("cargoType");
	//var la_cargoStorage                         = document.getElementsByName("specialCargo");
	var la_cargoStorage                         = "";
    var la_laden                                = document.getElementsByName("laden");
    var la_mt                                   = document.getElementsByName("mt");
    var la_grossContainerWeight                 = document.getElementsByName("grossContainerWeight");
    var la_polStatus                            = document.getElementsByName("polStatus");
    var la_podStatus                            = document.getElementsByName("podStatus");
    var la_eqSeqNo                              = document.getElementsByName("eqSeqNo");
    var la_equipmentSelectChkBox                = document.getElementsByName("equipmentSelectChkBox");
    var lv_chk                                  = "N";
    var lv_name                                 = "";
    var postVal                                 = "";
	var lv_index=lv_index-1;
    if(la_equipmentSelectChkBox[lv_index]!=null){
        lv_chk = la_equipmentSelectChkBox[lv_index].value;
    }

    lv_name = ao_element_current.name;

    postVal     = "type="               + la_type[lv_index].value               + "&size="                        + la_size[lv_index].value
                + "&cargoType="         + la_cargoType[lv_index].value          + "&laden="                       + la_laden[lv_index].value
                + "&mt="                + la_mt[lv_index].value                 + "&grossContainerWeight="        + la_grossContainerWeight[lv_index].value
                + "&polStatus="         + la_polStatus[lv_index].value          + "&podStatus="                   + la_podStatus[lv_index].value
                + "&eqSeqNo="           + la_eqSeqNo[lv_index].value            + "&equipmentSelectChkBox="       + lv_chk
                + "&typeDesc="          + la_type[lv_index].options[la_type[lv_index].selectedIndex].text			            + "&specialCargo="		;//	  + la_cargoStorage[lv_index].value;
    $.ajax({
        async:false,
        type: "POST",
        url: UPD_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                showBarMessage("Ready", 2);

                if(lv_name=="type"){
                    //assignValueType(la_type[lv_index]);
                }

                if(lv_name=="size"){
                   // assignValueSize(la_size[lv_index]);
                }

            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });
}

function ChangeRateType(obj,row){
	 
	var lv_index  = obj.parentNode.parentNode.rowIndex;
	lv_index=lv_index-1;
	var selectedData=obj.value;
	$('[name=rateType]')[lv_index].value=selectedData;

	lp_onChangeRateTypeNew(lv_index);
	updateCommodityRecStatusNewRateType($('[name=rateType]')[lv_index],lv_index+1);
}

function updateSizeTypeRecStatusNewforTextArea(ao_element_current,row){
	debugger;
//    var lo_element_current 	                = window.event.srcElement;
    var lv_index                                = ao_element_current.parentNode.parentNode.rowIndex;
    var la_type                                 = document.getElementsByName("type");
   // var la_typeDesc                             = document.getElementsByName("typeDesc");
    var la_size                                 = document.getElementsByName("size");
    var la_cargoType                            = document.getElementsByName("cargoType");
	//var la_cargoStorage                         = document.getElementsByName("specialCargo");
    var la_cargoStorage                         = "";
	var la_laden                                = document.getElementsByName("laden");
    var la_mt                                   = document.getElementsByName("mt");
    var la_grossContainerWeight                 = document.getElementsByName("grossContainerWeight");
    var la_polStatus                            = document.getElementsByName("polStatus");
    var la_podStatus                            = document.getElementsByName("podStatus");
    var la_eqSeqNo                              = document.getElementsByName("eqSeqNo");
    var la_equipmentSelectChkBox                = document.getElementsByName("equipmentSelectChkBox");
    var lv_chk                                  = "N";
    var lv_name                                 = "";
    var postVal                                 = "";
	
    if(la_equipmentSelectChkBox[lv_index]!=null){
        lv_chk = la_equipmentSelectChkBox[lv_index].value;
    }

    lv_name = ao_element_current.name;

    postVal     = "type="               + la_type[lv_index].value               + "&size="                        + la_size[lv_index].value
                + "&cargoType="         + la_cargoType[lv_index].value          + "&laden="                       + la_laden[lv_index].value
                + "&mt="                + la_mt[lv_index].value                 + "&grossContainerWeight="        + la_grossContainerWeight[lv_index].value
                + "&polStatus="         + la_polStatus[lv_index].value          + "&podStatus="                   + la_podStatus[lv_index].value
                + "&eqSeqNo="           + la_eqSeqNo[lv_index].value            + "&equipmentSelectChkBox="       + lv_chk
                + "&typeDesc="          + la_type[lv_index].options[la_type[lv_index].selectedIndex].text				+ "&specialCargo="	;//		  	  + la_cargoStorage[lv_index].value;
    $.ajax({
        async:false,
        type: "POST",
        url: UPD_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                showBarMessage("Ready", 2);

                if(lv_name=="type"){
                    assignValueType(la_type[lv_index]);
                }

                if(lv_name=="size"){
                    assignValueSize(la_size[lv_index]);
                }

            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });
	
}

function updateSizeTypeRecStatusNewCheckBox(ao_element_current,row){
	debugger;
//  var lo_element_current 	                = window.event.srcElement;
    var lv_index                                = ao_element_current.parentNode.parentNode.parentNode.rowIndex;
    var la_type                                 = document.getElementsByName("type");
    //var la_typeDesc                             = document.getElementsByName("type");
    var la_size                                 = document.getElementsByName("size");
    var la_cargoType                            = document.getElementsByName("cargoType");
	//var la_cargoStorage                         = document.getElementsByName("specialCargo");
	var la_cargoStorage                         = "";
    var la_laden                                = document.getElementsByName("laden");
    var la_mt                                   = document.getElementsByName("mt");
    var la_grossContainerWeight                 = document.getElementsByName("grossContainerWeight");
    var la_polStatus                            = document.getElementsByName("polStatus");
    var la_podStatus                            = document.getElementsByName("podStatus");
    var la_eqSeqNo                              = document.getElementsByName("eqSeqNo");
    var la_equipmentSelectChkBox                = document.getElementsByName("equipmentSelectChkBox");
    var lv_chk                                  = "N";
    var lv_name                                 = "";
    var postVal                                 = "";
	
    if(la_equipmentSelectChkBox[lv_index]!=null){
        lv_chk = la_equipmentSelectChkBox[lv_index].value;
    }
lv_index=lv_index-1;
    lv_name = ao_element_current.name;

    postVal     = "type="               + la_type[lv_index].value               + "&size="                        + la_size[lv_index].value
                + "&cargoType="         + la_cargoType[lv_index].value          + "&laden="                       + la_laden[lv_index].value
                + "&mt="                + la_mt[lv_index].value                 + "&grossContainerWeight="        + la_grossContainerWeight[lv_index].value
                + "&polStatus="         + la_polStatus[lv_index].value          + "&podStatus="                   + la_podStatus[lv_index].value
                + "&eqSeqNo="           + la_eqSeqNo[lv_index].value            + "&equipmentSelectChkBox="       + lv_chk
                + "&typeDesc="          + la_type[lv_index].options[la_type[lv_index].selectedIndex].text				+ "&specialCargo="	;//		  + la_cargoStorage[lv_index].value;;
    $.ajax({
        async:false,
        type: "POST",
        url: UPD_SIZE_TYPE_DATA,
        data: postVal,
        beforeSend: showBarMessage("Loading...", 2),
        success: function(data){
            if(trim(data)=="OK"){
                showBarMessage("Ready", 2);

                if(lv_name=="type"){
                    assignValueType(la_type[lv_index]);
                }

                if(lv_name=="size"){
                    assignValueSize(la_size[lv_index]);
                }

            }else{
            	showBarMessageNew(data, MSG_ERROR_CODE);
window.scrollTo(500, 0);
            }
        }
    });
	
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
//@09 END

function setQuotationRoutingData(pol, pod, originCountry, destinationCountry,
    placeOfReceipt, portOfLoading, portOfDischarge, placeOfDelivery,
    shipmentType, socCocUserFlag){
    var url = SET_QUATATION_ROUTING_DATA+'?';

    url += 'pol='+pol;
    url += '&pod='+pod;
    url += '&originCountry='+originCountry;
    url += '&destinationCountry='+destinationCountry;
    url += '&placeOfReceipt='+placeOfReceipt;
    url += '&portOfLoading='+portOfLoading;
    url += '&portOfDischarge='+portOfDischarge;
    url += '&placeOfDelivery='+placeOfDelivery;
    url += '&shipmentType='+shipmentType;
    url += '&socCocUserFlag='+socCocUserFlag;

//    @16 BEGIN
    loading();
//    @16 END
    document.forms[0].action = url;
    //alert(document.forms[0].action);
    document.forms[0].submit();
}

function setQuotationRoutingDetail(){
	alert('setQuotationRoutingDetail');
    var polList                     = document.getElementsByName('pol');
    var podList                     = document.getElementsByName('pod');
    var originCountryList           = document.getElementsByName('originCountry');
    var destinationCountryList      = document.getElementsByName('destinationCountry');
    var socCocUserFlag              = document.getElementsByName('socCocUserFlag');
    var pol                         = document.getElementById('pol');
    var pod                         = document.getElementById('pod');

    listChecked(polList, pol);
    listChecked(podList, pod);
}

function listChecked(listObj, value){
    var currObjList = null;
    var foundData = false;
    if(listObj != null && listObj != undefined){
        if(listObj.length > 0){
            for(var count=0, size=listObj.length; count<size; count++){
                currObjList = listObj[count].value;
                if(value == currObjList){
                    listObj[count].selected = true;
                    foundData = true;
                    break;
                }
            }
            if(!foundData){
                listObj[0].selected = true;
            }
        }
    }
}

function bakeToInqueryPage(){
	loading();
	bookingUrl = ON_LOAD_INQUIRY;

            document.forms[0].action = bookingUrl;
            document.forms[0].submit();
}

function onPolPodStatus(){
	debugger;
	var cocSocVal=$("#socCocUserFlag").val();
	var podStatusObj=$('[name=podStatus]');
	for(var i=0;i<podStatusObj.length;i++){
		$('[name=podStatus]')[i].disabled=false;
		$('[name=polStatus]')[i].disabled=false;
	}
	if(cocSocVal=="C"){
  			document.getElementById("mandatorySymbolDepo").style.display ="block";
		    document.getElementById("mandatorySymbolDate").style.display ="block";
			document.getElementById("mandatoryWithOutSymbolDepo").style.display ="none";
			document.getElementById("mandatoryWithOutSymbolDate").style.display ="none";
	}else{
			document.getElementById("mandatorySymbolDepo").style.display ="none";
		    document.getElementById("mandatorySymbolDate").style.display ="none";
			document.getElementById("mandatoryWithOutSymbolDepo").style.display ="block";
			document.getElementById("mandatoryWithOutSymbolDate").style.display ="block";
	}
	
	
}

function checkCarogoWasightValidation(){
	
	return true ;
}

function getEmptyPickUpDepoData(obj){
	
	var url = ON_EMPTY_PICK_UP_DEPO_DATA;
	var por= $("#placeOfReceipt").val();
	
	 $.ajax({
        async:false,
        type: "POST",
        url: url,
        data: "porTemp=" + por,  
        beforeSend: showBarMessage("Loading...", 2),//loading()
        success: function(Result){ 
		debugger;
			var result1 = JSON.parse(Result);
					
	 		document.getElementById("emptyPickupDepot").options.length = 0;
			var ele=	document.getElementById("emptyPickupDepot");
			ele.innerHTML = ele.innerHTML + '<option value="">Select one</option>'	;
				for (var i = 0; i < result1.Result.length; i++) {
	           		 ele.innerHTML = ele.innerHTML +
	                '<option value="' + result1.Result[i].code + '">' + result1.Result[i].name + '</option>';
	        }
		} 
    });
	
}

function checkCargoTypeAndRatetype(){
	debugger;
	var cargoType="";
	var rateType="";
	
	var cargoTypeObj=document.getElementsByName('cargoType');
	var rateTypeObj=document.getElementsByName('rateType'); 
	 

	for(var j=0;j<cargoTypeObj.length-1;j++){
		var cargoTemp1 = cargoTypeObj[j].value;
		var cargoTemp2 = cargoTypeObj[j+1].value;
		if(cargoTemp1!=cargoTemp2){
			return true;
		}
	}
	cargoType=cargoTypeObj[0].value;
    
   for(var k=0;k<rateTypeObj.length-1;k++){
		var rateTemp1 = rateTypeObj[k].value;
		var rateTemp2 = rateTypeObj[k+1].value;
		if(rateTemp1!=rateTemp2){
			return true;
		}
	} 
	rateType=rateTypeObj[0].value;
    if(cargoType!=rateType){
        return true;
    }
} 


$(document).ready(function () {
	debugger;
	if(typeof  $("#comm_search_result .bg-light-blue th")[1].remove === 'function'){
	$("#comm_search_result .bg-light-blue th")[1].remove();
	}else{
	$("#comm_search_result .bg-light-blue th")[1].parentNode.removeChild($("#comm_search_result .bg-light-blue th")[1]);
	}
});

function checkNumeric(selectObject,type)
{
	var id=selectObject.id
	var tempvalue=document.getElementById(id).value;
	 
		if(isNaN(tempvalue))
		{
			document.getElementById(id).value="";
			showBarMessageNew(type+" should be Numeric");
			return false;
		}
	 
}

function checkSpecialCharacter(selectObject,type)
{
	debugger;
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

function validateMultipleEmails(selectObject) {
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
		showBarMessageNew("Invalid Additional emails: "+invalidEmails.join(', '));
		window.scrollTo(500, 0);
		return false; 
    }else{
		$("#alertId").hide();
		return true;
	}
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

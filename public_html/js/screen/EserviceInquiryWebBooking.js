/**
* function called when screen load
*/

/*
-------------------------------------------------------------------------------------------------------------
EserviceNewWebBooking.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author vikas Verma 02/05/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
01 28/08/2014   Pratya             01               Eservice phase 3.1
-------------------------------------------------------------------------------------------------------------
*/


var webbooking = 'webbooking';
var eshipping = 'eshipping';
var error_code = 0;

function onLoad() { 
	debugger; 
	if($("#loginDateCheck").val()==null || $("#loginDateCheck").val()==""){
    		  window.location.href="../do/sexn007usePassword";
    } 
	 
	$("#dashboardModifier").removeClass();
	$("#dashboardModifier").addClass("nav-item active")	;
	
	var statusValideter = document.getElementById("statusValidater").value;
	var statusErrorCode= document.getElementById("statusError").value;
	if(statusErrorCode!=null && statusErrorCode!=""){
		//showBarMessageNew(statusErrorCode);
		swal("Message", statusErrorCode , "info");
	}
    var notFound = document.getElementById("notFound");
    var firstCheckedCommodity = document.getElementById("firstCheckedCommodity");
    var bookingNo = null;
    try{ 
	if(statusValideter==""||statusValideter==null||statusValideter=='O'||statusValideter=='Open'){
		$("#pills-open-orders-tab").tab('show');		
	}else if(statusValideter=='C'||statusValideter=='Confirmed'){
		//document.getElementById("pills-completed-orders").style.display = "block";
		$("#pills-completed-orders-tab").tab('show');		
	}else if(statusValideter=='N'||statusValideter=='Cancelled'){
		$("#pills-cancelled-orders-tab").tab('show');
	}else if(statusValideter=='T'||statusValideter=='Template'){
		$("#pills-template-tab").tab('show');
	}
        error_code = 1;
        if(!isNullObj(notFound) && !isNullObj(notFound.value) && notFound.value == 'true'){
            bookingNo = document.getElementById("bookingNo").value;
            
            showBarMessage("Booking No \""+bookingNo+"\" Data not found.",1);
        }
        error_code = 2;
        if(!isNullObj(firstCheckedCommodity) && !isNullObj(firstCheckedCommodity.value) && !isBlank(firstCheckedCommodity.value)){
            showSpecialInstruction(firstCheckedCommodity.value);
        }
    
//        var page = document.getElementById("page"); 
//        if(null!=page && ''!=page.value)
//        {
//            var columnBLNo = document.getElementById("tdBLNo");
//            var columnBLStatus = document.getElementById("tdBLStatus");
//            var columnBLNoValue = document.getElementById("tdBLNoValue");
//            var columnBLStatusValue = document.getElementById("tdBLStatusValue");
//            
//            if(null!=columnBLNoValue)
//            {
//                if(webbooking == page.value)
//                {
//                    columnBLNo.style.display = 'none';
//                    columnBLStatus.style.display = 'none';
//                    columnBLNoValue.style.display = 'none';
//                    columnBLStatusValue.style.display = 'none';
//                }
//                else if(eshipping == page.value)
//                {
//                    columnBLNo.style.display = 'block';
//                    columnBLStatus.style.display = 'block';
//                    columnBLNoValue.style.display = 'block';
//                    columnBLStatusValue.style.display = 'block';
//                }
//            }
//        }
    }catch(err){
        handleJavaScriptError('onLoad', err, error_code);
    }
} 

function editBooking()
{
    alert('edit booking');
}

function openBookingNumber(){      
    var url = BROWSE_BOOKING_NUMBER;
    openHelpList(url, 900, 400);
}

function getWebBookingData(parentForm, params){
    try{  
    	debugger;
        error_code = 1;
        var url = GET_BOOKING_NUMBER_TO_WEBBOOKING_PAGE;
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
function getCompletedBooking()
{	
			loading();
	        document.getElementById("pills-completed-orders").style.display = "none";
	        bookingUrl = ON_LOAD+'?status=C';
        	
            document.forms[0].action = bookingUrl;
            document.forms[0].submit();
	
}
function getCancelledBooking()
{			
	loading();
			document.getElementById("pills-cancelled-orders").style.display = "none";
			bookingUrl = ON_LOAD+'?status=N';
        
            document.forms[0].action = bookingUrl;
            document.forms[0].submit();
	
}
function getOpenAndConfirmBooking()
{
	loading();
	 		document.getElementById("pills-open-orders").style.display = "none";
			bookingUrl = ON_LOAD+'?status=';
        
            document.forms[0].action = bookingUrl;
            document.forms[0].submit();
	
}

function getTemplete(){
	loading();
	templateUrl = GET_TEMLATE;
        
            document.forms[0].action = templateUrl+'?status=T';
            document.forms[0].submit();
	
}

function getMoreWebBookingData(rowNum, params){
		debugger;
		
   		loading();
    	var	MoreId="";
        var url = GET_BOOKING_NUMBER_TO_MORE_WEBBOOKING_PAGE;
		var statusValidater=document.getElementById("statusValidater").value;
		var bookingNo="";
		if(statusValidater=='Open' || statusValidater=='O' ||  statusValidater=='' || statusValidater== null){
			MoreId="MoreO_"+rowNum;
			if($('#'+MoreId).find('i')[0].parentElement.innerText=="Less "){
				loading(true);
				return false;
			}
			debugger;
			var idvalueBookingNo="bookingNoSendO"+rowNum;
			//bookingNoIDSec=document.getElementById(idvalueBookingNo).textContent.trim();
			bookingNoIDSec="-";
			if(bookingNoIDSec=="-"){
			var idvalue="bookingNoO"+rowNum;
        	bookingNoAns=document.getElementById(idvalue).textContent;
			bookingNo=document.getElementById(idvalue).textContent;	
			}else{
			bookingNoAns=bookingNoIDSec;
			var idvalue="bookingNoO"+rowNum;
        	bookingNo=document.getElementById(idvalue).textContent;
			}
			fromTerminal="fromTerminalO_"+bookingNo;
			toTerminal="toTerminalO_"+bookingNo;
//customer dtl

			shipper="shipperO_"+bookingNo;
			consignee="consigneeO_"+bookingNo;
			notify="notifyO_"+bookingNo;

//routing dtl
        
   			portofloading="portofloadingO_"+bookingNo;
			portofdischarge="portofdischargeO_"+bookingNo;
			vesselVoyage="vesselVoyageO_"+bookingNo;
			transhipport="transhipportO_"+bookingNo;
		
//Equipment & Commodity Details		
		
		containerNoSealNoMarksNo="containerNoSealNoMarksNoO_"+bookingNo;
		containersType="containersTypeO_"+bookingNo;
		descriptionofGoodsNetWeight="descriptionofGoodsNetWeightO_"+bookingNo;
		grossweightmeasurement="grossweightmeasurementO_"+bookingNo;
			
		}else if(statusValidater=='Confirmed' || statusValidater=='C'){
		
		MoreId="MoreC_"+rowNum;
		if($('#'+MoreId).find('i')[0].parentElement.innerText=="Less "){
			loading(true);
			return false;
		}
		
		var idvalue="bookingNoC"+rowNum;
        bookingNo=document.getElementById(idvalue).textContent;
		bookingNoAns=	document.getElementById(idvalue).textContent;
		fromTerminal="fromTerminalC_"+bookingNo;
		toTerminal="toTerminalC_"+bookingNo;	
			
//customer dtl

		shipper="shipperC_"+bookingNo;
		consignee="consigneeC_"+bookingNo;
		notify="notifyC_"+bookingNo;

//routing dtl
        
   		portofloading="portofloadingC_"+bookingNo;
		portofdischarge="portofdischargeC_"+bookingNo;
		vesselVoyage="vesselVoyageC_"+bookingNo;
		transhipport="transhipportC_"+bookingNo;
		
//Equipment & Commodity Details		
		
		containerNoSealNoMarksNo="containerNoSealNoMarksNoC_"+bookingNo;
		containersType="containersTypeC_"+bookingNo;
		descriptionofGoodsNetWeight="descriptionofGoodsNetWeightC_"+bookingNo;
		grossweightmeasurement="grossweightmeasurementC_"+bookingNo;

		}else if(statusValidater=='Cancelled' || statusValidater=='N'){
		
		MoreId="MoreN_"+rowNum;
		if($('#'+MoreId).find('i')[0].parentElement.innerText=="Less "){
			loading(true);
			return false;
		}
		
		var idvalue="bookingNoN"+rowNum;
        bookingNo=document.getElementById(idvalue).textContent;
bookingNoAns=document.getElementById(idvalue).textContent;
				
//customer dtl
		fromTerminal="fromTerminalL_"+bookingNo;
		toTerminal="toTerminalL_"+bookingNo;

		shipper="shipperL_"+bookingNo;
		consignee="consigneeL_"+bookingNo;
		notify="notifyL_"+bookingNo;

//routing dtl
        
   		portofloading="portofloadingL_"+bookingNo;
		portofdischarge="portofdischargeL_"+bookingNo;
		vesselVoyage="vesselVoyageL_"+bookingNo;
		transhipport="transhipportL_"+bookingNo;
		
//Equipment & Commodity Details		
		
		containerNoSealNoMarksNo="containerNoSealNoMarksNoL_"+bookingNo;
		containersType="containersTypeL_"+bookingNo;
		descriptionofGoodsNetWeight="descriptionofGoodsNetWeightL_"+bookingNo;
		grossweightmeasurement="grossweightmeasurementL_"+bookingNo;			
		}
		
		
$.ajax({
        method : "POST",
		async : true,
		url : GET_BOOKING_NUMBER_TO_MORE_WEBBOOKING_PAGE,
        data: {bookingNo:bookingNoAns},
		dataType:'text',
        success: function(result){
		 var obj = JSON.parse(result);
		count=0;
		contailerDtlNo="";
		containerDtlSize="";
		conatinerDtlWeight="";
		conatinerDtlMeasurment="";
		conatinerDtl3="";
		descriptionofGoodsNetWeightvalues="";
		vesselNameVoyageValues="";
		sizeType={};
		
		
			$("#"+fromTerminal).html('<div class="d-flex text-muted text-small" id="'+fromTerminal+'">'+obj.Result.fromTerminalDes+'</div>');
			$("#"+toTerminal).html('<div class="d-flex text-muted text-small" id="'+toTerminal+'">'+obj.Result.toTerminalDes+'</div>');
		
			
		if(obj.Result.customerDtls!=null ){

		var shipperDtl="";
		if(obj.Result.customerDtls.shipperName!=""){
			shipperDtl=shipperDtl+obj.Result.customerDtls.shipperName;
		}if(obj.Result.customerDtls.shipperAddress1!=""){
			shipperDtl=shipperDtl+'/'+obj.Result.customerDtls.shipperAddress1;
		}if(obj.Result.customerDtls.shipperAddress2!=""){
			shipperDtl=shipperDtl+' '+obj.Result.customerDtls.shipperAddress2;
		}if(obj.Result.customerDtls.shipperAddress3!=""){
			shipperDtl=shipperDtl+' '+obj.Result.customerDtls.shipperAddress3;
		}if(obj.Result.customerDtls.shipperAddress4!=""){
			shipperDtl=shipperDtl+' '+obj.Result.customerDtls.shipperAddress4;
		}
			$("#"+shipper).html('<div class="d-flex text-muted text-small" id="'+shipper+'">'+shipperDtl+'</div>');
		
		var consigneedtl="";
		if(obj.Result.customerDtls.consigneeName!=""){
			consigneedtl=consigneedtl+obj.Result.customerDtls.consigneeName;
		}if(obj.Result.customerDtls.consigneeAddress1!=""){
			consigneedtl=consigneedtl+'/'+obj.Result.customerDtls.consigneeAddress1;
		}if(obj.Result.customerDtls.consigneeAddress2!=""){
			consigneedtl=consigneedtl+' '+obj.Result.customerDtls.consigneeAddress2;
		}if(obj.Result.customerDtls.consigneeAddress3!=""){
			consigneedtl=consigneedtl+' '+obj.Result.customerDtls.consigneeAddress3;
		}if(obj.Result.customerDtls.consigneeAddress4!=""){
			consigneedtl=consigneedtl+' '+obj.Result.customerDtls.consigneeAddress4;
		}
		
		$("#"+consignee).html('<div class="d-flex text-muted text-small" id="'+consignee+'">'+consigneedtl+'</div>');
		
		var notifyparty="";
		if(obj.Result.customerDtls.notifyName!=""){
			notifyparty=notifyparty+obj.Result.customerDtls.notifyName;
		}if(obj.Result.customerDtls.notifyAddress1!=""){
			notifyparty=notifyparty+'/'+obj.Result.customerDtls.notifyAddress1;
		}if(obj.Result.customerDtls.notifyAddress2!=""){
			notifyparty=notifyparty+' '+obj.Result.customerDtls.notifyAddress2;
		}if(obj.Result.customerDtls.notifyAddress3!=""){
			notifyparty=notifyparty+' '+obj.Result.customerDtls.notifyAddress3;
		}if(obj.Result.customerDtls.notifyAddress4!=""){
			notifyparty=notifyparty+' '+obj.Result.customerDtls.notifyAddress4;
		}
		
		$("#"+notify).html('<div class="d-flex text-muted text-small" id="'+notify+'">'+notifyparty+'</div>');

		}
		//debugger;
		//if(statusValidater!='Open' && statusValidater!='O' &&  statusValidater!='' && statusValidater!= null){
		debugger;
			for(var i = 0; i < obj.Result.routingDtls.length; i++){
				if(i==0)
					vesselNameVoyageValues+=obj.Result.routingDtls[i].vesselName+"/"+obj.Result.routingDtls[i].voyage;
				else
					vesselNameVoyageValues+="<br>"+obj.Result.routingDtls[i].vesselName+"/"+obj.Result.routingDtls[i].voyage;
				
			}
		//}
			/*if(obj.Result.routingDetails.length>0){*/
			debugger;
			$("#"+portofloading).html('<div class="d-flex text-muted text-small" id="'+portofloading+'">'+obj.Result.portOfLoading+' '+obj.Result.pol+'</div>');
			$("#"+portofdischarge).html('<div class="d-flex text-muted text-small" id="'+portofdischarge+'">'+obj.Result.portOfDischarge+' '+obj.Result.pod+'</div>');
			$("#"+vesselVoyage).html('<div class="d-flex text-muted text-small" id="'+vesselVoyage+'">'+vesselNameVoyageValues+'</div>');
			$("#"+transhipport).html('<div class="d-flex text-muted text-small" id="'+transhipport+'">'+((obj.Result.port1==null || obj.Result.port1=="") ?"":obj.Result.port1+',')
						+''+((obj.Result.port2==null || obj.Result.port2=="") ?"":obj.Result.port2+',')+''+
								((obj.Result.port3==null || obj.Result.port3=="") ?"":obj.Result.port3)+'</div>');
		    /*}*/
		if(obj.Result.equipmentDetails.length>0){
			var objTemp = {};
		for(var i=0;i<obj.Result.equipmentDetails.length;i++){
			count++;
				if(i>0)
				{
				contailerDtlNo+="' / '";	
				}
				contailerDtlNo+=obj.Result.equipmentDetails[i].eqNumber;
				key=obj.Result.equipmentDetails[i].size +" "+ obj.Result.equipmentDetails[i].type;
				
				if (objTemp[key] == undefined) {
						objTemp[key] = obj.Result.equipmentDetails[i].laden;
					}
			}
		debugger
			for (var key  in objTemp) {
					if(conatinerDtl3=="")
					conatinerDtl3 += ""+objTemp[key] +" X "+ key+"<br>";
					else
						conatinerDtl3 += ""+objTemp[key] +" X "+ key+"<br>";
				}
			 
		}	
			
			for(var i=0;i<obj.Result.commodityDetails.length;i++){
				if(i>0){
					descriptionofGoodsNetWeightvalues=descriptionofGoodsNetWeightvalues+" , "+obj.Result.commodityDetails[i].description;
					conatinerDtlWeight= conatinerDtlWeight+','+obj.Result.commodityDetails[i].grossWeight;
					if(obj.Result.commodityDetails[i].measurement!="" && obj.Result.commodityDetails[i].measurement != null){
						conatinerDtlMeasurment=conatinerDtlMeasurment+','+obj.Result.commodityDetails[i].measurement;
					}
				}else{
					descriptionofGoodsNetWeightvalues=descriptionofGoodsNetWeightvalues+obj.Result.commodityDetails[i].description;
					conatinerDtlWeight= conatinerDtlWeight+obj.Result.commodityDetails[i].grossWeight;
					if(obj.Result.commodityDetails[i].measurement!="" && obj.Result.commodityDetails[i].measurement != null){	
						conatinerDtlMeasurment=conatinerDtlMeasurment+'/'+obj.Result.commodityDetails[i].measurement;
					}
				}
				
			}
			
			$("#"+containerNoSealNoMarksNo).html('<div class="d-flex text-muted text-small" id="'+containerNoSealNoMarksNo+'">'+contailerDtlNo+'</div>');
			$("#"+containersType).html('<div class="d-flex text-muted text-small" id="'+containersType+'">'+conatinerDtl3+'</div>');
			$("#"+descriptionofGoodsNetWeight).html('<div class="d-flex text-muted text-small" id="'+descriptionofGoodsNetWeight+'">'+descriptionofGoodsNetWeightvalues+'</div>');
			$("#"+grossweightmeasurement).html('<div class="d-flex text-muted text-small" id="'+grossweightmeasurement+'">'+conatinerDtlWeight+' / '+conatinerDtlMeasurment+'</div>');
		loading(true);	
		},error:function(error){
			loading(true);
			alert(error);
		}
    });
      
} 


function getWebBookingDataNew(){
    try{  
    	debugger;
		loading();
        error_code = 1;
        var bookingNo=document.getElementById("bookingNo").value;
        var bookingStatus=document.getElementById("statusValue").value;
        var bookingRef=document.getElementById("bookingRef").value;
		if(bookingNo=="" && bookingStatus == "" && bookingRef == ""){
			loading(true);
			swal("Please input Booking no. or booking Ref for search.");
			return false;
		}
        var params              = "?bookingNo="+bookingNo+"&bookingRef="+bookingRef;
        params += "&status="+bookingStatus;
        params += "&mode=select";
        	
        var url = BOOKING_SEARCH;
        document.forms[0].action= url+params;
        error_code = 2;
        document.forms[0].submit();
    }catch(err){

          txt="JAVASCRIPT ERROR ON CALL DATA.\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }    
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

function getActionUrl()
{
    return BROWSE_BOOKING_NUMBER;
}

function showSpecialInstruction(seq)
{
    var rowObj = document.getElementById("tableSI").getElementsByTagName("tr");
    for(var i = 0; i < rowObj.length; i++)
    {
        rowObj[i].style.display = (rowObj[i].id=="row_"+seq?"block":"none");
    }
}

function gotoToSearchBookingInquiry(obj)
{
    if(event.keyCode == 13 || event.keyCode == 9)
    {
        getWebBookingDataOnBlur(obj);
    }
}

function gotoNewBooking()
{
    var form = document.forms[0];
    var url = NEW_WEBBOOKING_PAGE+"?backFlag=true";
    form.action = url;
    form.submit();
}

/*Begin @01*/
function openRateTypeLookUpForInquiry() {
    var lo_element_current 	= window.event.srcElement;
    var rowIndex                = lo_element_current.parentNode.parentNode.parentNode.rowIndex;
    var la_rateType             = document.getElementsByName("rateType");
    var la_seqNo                = document.getElementsByName("seqNo");
    var la_rateTypeFlag         = document.getElementsByName("rateTypeFlag");
    var urlStr                  = "";

    if(la_rateType[rowIndex].value=="RF"){
        if(la_rateTypeFlag[rowIndex].value=="Y"){
            urlStr   = REFER_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex + "&disBtn=Y";
        }
    }else if(la_rateType[rowIndex].value=="D1"){
        if(la_rateTypeFlag[rowIndex].value=="Y"){
            urlStr   = DG_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex + "&disBtn=Y";
        }
    }else if(la_rateType[rowIndex].value=="O0"){
        if(la_rateTypeFlag[rowIndex].value=="Y"){
            urlStr   = OOG_COMMODITY_GET_DATA + "?seqNo=" + la_seqNo[rowIndex].value + "&rowIndex=" + rowIndex + "&disBtn=Y";
        }
    }else{
        return false;
    }
    
//    openHelpList(urlStr, 950, 750);
    openScreenForInquiry(urlStr, 'RateTypeDetails', 950, 750);
    return false;
}
/*End @01*/

/*Begin @01*/
function openScreenForInquiry(screen_url, winName, screenWidth, screenHeight){
    childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight + ',left=' + 0 + ',top=' + 0 + 'resizable=yes,scrollbars=yes,toolbar=yes,titlebar=yes');
    childWindow.focus();
}
/*End @01*/

/*Begin @01*/
function uploadAttachmentForInquiry(){
    var urlStr                  = "";
    
    urlStr = GET_UPLOAD_ATTACHMENT  + "?disBtn=Y";
    openScreenForInquiry(urlStr, 'uploadAttach', 800, 400);
    return false;
}
/*End @01*/
function onEshippingInstructionLoad(bookingNo){
	 debugger;
	 loading();
	var id="vessel_etd"+bookingNo;
    var date =$("#"+id).html()+"";
	var etdDate = new Date();
	etdDate.setDate(Number(date.split("/")[0]));
	etdDate.setMonth(Number(date.split("/")[1])-1);
	etdDate.setYear(Number(date.split("/")[2]));
	var configdate=Number(document.getElementById("dateConfigBooking").value);
	var resultDate = new Date();
	resultDate.setDate(resultDate.getDate() + configdate); 

	/*if(etdDate<=resultDate){
		//showBarMessageNew("Create-Shipping allwoed before 3 days of Deparcher date.");
		loading(true);
		swal("Message", sippingValidationMsg , "info");
		return false;
	}*/

        bookingNo=bookingNo;
   
	// "?bookingNo=BNGBC17025132&blNo= &esiStatusCode=I&esiStatusDesc=SUBMITTED&cocSoc=C&mode=select&fromPoup=1"
    var params   		= "?bookingNo="+bookingNo+"&flag=booking";
    params += "&mode=select";
    	
    var url = OPEN_E_SHIPPING_PAGE_BASED_ON_BOOKING_NO;
    document.forms[0].action= url+params;
    error_code = 2;
    document.forms[0].submit();
	
}
function onBookingEdit(bookingNo){
	debugger;
	loading(); 
	
	var id="vessel_etd"+bookingNo;
    var date =$("#"+id).html()+"";
	var etdDate = new Date();
	etdDate.setDate(Number(date.split("/")[0]));
	etdDate.setMonth(Number(date.split("/")[1])-1);
	etdDate.setYear(Number(date.split("/")[2]));
	var configdate=Number(document.getElementById("dateConfigBooking").value);
	var resultDate = new Date();
	resultDate.setDate(resultDate.getDate() + configdate); 

	if(etdDate<=resultDate){
		//showBarMessageNew("Edit-Booking allwoed before 3 days of Deparcher date.");
		loading(true);
		swal("Message", editValidationMsg , "info");
		return false;
	}
	
	var params   		= "?bookingNo="+bookingNo+"&";
    
	params += "&mode=select";
    	
    var url = ON_BOOKING_EDIT;

checkBookingContainerAvailable(params,url,bookingNo,"EDIT");
    

}

 
function onCancel(bookingNo){
	
	var id="vessel_etd"+bookingNo;
    var date =$("#"+id).html()+"";
	var etdDate = new Date();
	etdDate.setDate(Number(date.split("/")[0]));
	etdDate.setMonth(Number(date.split("/")[1])-1);
	etdDate.setYear(Number(date.split("/")[2]));
	var configdate=Number(document.getElementById("dateConfigBooking").value);
	var resultDate = new Date();
	resultDate.setDate(resultDate.getDate() + configdate); 

	if(etdDate<=resultDate){
		//showBarMessageNew("Cancel-Booking allwoed before 3 days of Deparcher date.");
		swal("Message", canelValidationMsg , "info");
		return false;
	}
	
swal({
title: "Are you sure want to Cancel?",
text: "",
icon: "warning",
buttons: true,
dangerMode: true,
})
.then(function(willDelete) {
if (willDelete) {
onCancelConfirm(bookingNo)
} else {

}
});

}


function onCancelConfirm(bookingNo){
	 
	debugger;
	loading();
	
    var params   		= "?bookingNo="+bookingNo;
	params += "&mode=select";
	var cancelBookingUrl = ON_CANCEL_BOOKING ;
    
	checkBookingContainerAvailable(params,cancelBookingUrl,bookingNo,"CANCEL");    	
}

function deleteTemplate(bookingNo,templateName){
	
	debugger;
	loading();
	var params   		= "?bookingNo="+bookingNo;
    
	params += "&templateName="+templateName;
	params += "&status=T";
	var cancelBookingUrl = ON_DELETE_TEMPLATE+params;
        	
            document.forms[0].action = cancelBookingUrl;
            document.forms[0].submit();
}


function onWebBooking(){
	
	loading();
		document.forms[0].action = ON_LOAD_SEARCH_API;
	    document.forms[0].submit();
	
	
}


function checkBookingContainerAvailable(params,url,bookingNo,type){
	debugger;
	$.ajax({
		method: "POST",
		async: true,
		url: CHECK_EDIT_CONTAINER,
		data: { bookingNo: bookingNo },
		dataType: 'text',
		success: function(result) {
		debugger;
			if (result == 'AVA') {
				loading(true);
				if(type=="CANCEL")
				swal("Equipment Attached! Booking can't Cancel.");
				else
				swal("Equipment Attached! Booking can't modify.");
			} else {
				document.forms[0].action= url+params;
    			error_code = 2;
    			document.forms[0].submit();	
			}

		}, error: function(error) {
			loading(true);
			alert(error);
		}
	});
}

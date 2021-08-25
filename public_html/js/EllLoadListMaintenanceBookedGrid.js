function addRowInFixedTable() {

	return false;
}

function getRecordToAddInGrid(rowIndex)
{
	return rowData;
}

function getStatusObject(rowIndex)
{
	return document.getElementById("bookingValue["+rowIndex+"].status");
}

function getSelectedObject(rowIndex)
{
	return document.getElementById("bookingValue["+rowIndex+"].selected");
}

function getFixedColumnsTableName()
{
	return "tableFixedColumns";
}

function getFixedColumnsDivId()
{
	return "fixedColumns_bodyDiv";
}

function getGridId()
{
	return "gridList";
}

function getSelectedRowDataDLO(aintRowIndex)
{   
    var mapRowData = getSelectedRowData(aintRowIndex);
    return mapRowData;
}

function highlightRow(aintRowIndex) 
{
    highlightradioTD("row"+aintRowIndex);
    setRowSelection(aintRowIndex);
}

function edit() 
{
	if(document.forms[0].radioGroup1 != null){
		if(document.forms[0].radioGroup1[0] != null){
			for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {
				if(document.forms[0].radioGroup1[i].checked) {
					getSelectedRowDataDLO(i);
				}
			}
		} else {
			getSelectedRowDataDLO(0);
		}
	}
}

function getSearchCriteria() 
{
    var larrSearchCriteria = ["srchBookingFind1","srchBookingIn1","srchBookingFind2","srchBookingIn2","srchBookingOrder1","srchBookingOrder1Ord","srchBookingOrder2","srchBookingOrder2Ord"];
    return larrSearchCriteria;
}

function getSelectedViewId(){
	return document.forms[0].bookedView.value;
	
}	

function validateHandInsCode1(astrHandInCode, hinsCodeNo, arow){
	
	if(astrHandInCode.value!=""){
		var response = validateHandInsCode(astrHandInCode);
	
		if(hinsCodeNo==1){
			if(response=="undefined" || response==null){
		        ERROR_FLAG_HIC1 = EZL_SE038;							
				showBarMessage(EZL_SE038,ERROR_MSG);
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc1').value = "";				
				return false;
			}else if(response =="N"){
		        ERROR_FLAG_HIC1 = EZL_SE038;										
				showBarMessage(EZL_SE038,ERROR_MSG);
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc1').value = "";
				return false;
			}else{
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc1').value = response;
		        ERROR_FLAG_HIC1 = 'success';				
				showBarMessage(ECM_GI0001);
			}	
		}	
		if(hinsCodeNo==2){
			if(response=="undefined" || response==null){
		        ERROR_FLAG_HIC2 = EZL_SE040;										
				showBarMessage(EZL_SE040,ERROR_MSG);
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc2').value = "";				
				return false;
			}else if(response =="N"){
		        ERROR_FLAG_HIC2 = EZL_SE040;													
				showBarMessage(EZL_SE040,ERROR_MSG);
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc2').value = "";				
				return false;
			}else{
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc2').value = response;
		        ERROR_FLAG_HIC2 = 'success';				
				showBarMessage(ECM_GI0001);
			}	
		}
		if(hinsCodeNo==3){
			if(response=="undefined" || response==null){
		        ERROR_FLAG_HIC3 = EZL_SE041;													
				showBarMessage(EZL_SE041,ERROR_MSG);
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc3').value = "";				
				return false;
			}else if(response =="N"){
		        ERROR_FLAG_HIC3 = EZL_SE041;																
				showBarMessage(EZL_SE041,ERROR_MSG);
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc3').value = "";				
				return false;
			}else{
				document.getElementById('bookingValue[' + arow + '].handlingInstDesc3').value = response;
		        ERROR_FLAG_HIC3 = 'success';				
				showBarMessage(ECM_GI0001);
			}	
		}
	}else{
	    if(hinsCodeNo==1){
			ERROR_FLAG_HIC1 = 'success';		
		} else if (hinsCodeNo==2){
			ERROR_FLAG_HIC2 = 'success';		
		} else if (hinsCodeNo==3){
			ERROR_FLAG_HIC3 = 'success';		
		}
		
		showBarMessage(ECM_GI0001);
		return false;
	}
	return false;	
}

function validateOperatorCode1(OprCode, arow){
	
    if(OprCode.value == "****") {
        ERROR_FLAG_CONT_OPR = EZL_SE039;
        showBarMessage(EZL_SE039,ERROR_MSG);
        return false;
    }
	var socCocFlag = document.getElementById('bookingValue[' + arow + '].socCoc').value;				
	
	if ((socCocFlag == "S") || (socCocFlag == "SOC")) {
		ERROR_FLAG_CONT_OPR = 'success';
		return false;
	}

	if(OprCode.value!=""){
		var response = validateOperatorCode(OprCode);
		if(response=="undefined" || response==null){
		    ERROR_FLAG_CONT_OPR = EZL_SE039;
			showBarMessage(EZL_SE039,ERROR_MSG);
			return false;
		}else if(response =="N"){
		    ERROR_FLAG_CONT_OPR = EZL_SE039;

			showBarMessage(EZL_SE039,ERROR_MSG);
			return false;
		}else{
			ERROR_FLAG_CONT_OPR = 'success';
			showBarMessage(ECM_GI0001);
			return false;
		}
	}else{
		
		ERROR_FLAG_CONT_OPR = 'success';		
		showBarMessage(ECM_GI0001);
		return false;
	}
	
	
	return false;
}

function validateOutSlotOperatorCode1(OprCode, arow){
	var socCocFlag = document.getElementById('bookingValue[' + arow + '].socCoc').value;				
	
	if ((socCocFlag == "S") || (socCocFlag == "SOC")) {
		ERROR_FLAG_OUT_SLOT_OPR = 'success';	
		return false;
	}

	if(OprCode.value!=""){
		var larrMessage = new Array();
		larrMessage[0]  = 1;	
		var response = validateOperatorCode(OprCode);
		if(response=="undefined" || response==null){
		    ERROR_FLAG_OUT_SLOT_OPR = EZL_SE044;		
			showBarMessage(EZL_SE044,ERROR_MSG);
			return false;
		}else if(response =="N"){
		    ERROR_FLAG_OUT_SLOT_OPR = EZL_SE044;		
			showBarMessage(EZL_SE044,ERROR_MSG);
			return false;
		}else{
		    ERROR_FLAG_OUT_SLOT_OPR = 'success';		
			showBarMessage(ECM_GI0001);
			return false;
		}
	}else{
		ERROR_FLAG_OUT_SLOT_OPR = 'success';		
		showBarMessage(ECM_GI0001);
		return false;
	}
	return false;
}

/*Called by master lookup screens to return selected values*/
function setLookupValues(aFormName, aRowId,strMasterId, arrResultData){

	if(arrResultData[0] == 'FAILURE'){
		return;
	}
	updateBookingStatusFlage(aRowId);
	if((strMasterId == 'OPERATOR') && (lookupId == 'C')){
		//Setting Container Operator value
		document.getElementById('bookingValue[' + aRowId + '].contOperator').value 
			=arrResultData[0];
		ERROR_FLAG_CONT_OPR = 'success';				
		showBarMessage(ECM_GI0001);
		return false;
	} else if((strMasterId == 'OPERATOR') && (lookupId == 'O')){
		//Setting Out Slot Operator value
		document.getElementById('bookingValue[' + aRowId + '].outSlotOperator').value
			=arrResultData[0];
		ERROR_FLAG_OUT_SLOT_OPR = 'success';				
		showBarMessage(ECM_GI0001);
		return false;			
	} else if((strMasterId == 'HIC') && (lookupId == 'HIC1')){
		document.getElementById('bookingValue[' + aRowId + '].handlingInstCode1').value
			=arrResultData[IDX_HICCD];	
		document.getElementById('bookingValue[' + aRowId + '].handlingInstDesc1').value
			=arrResultData[IDX_HISDS];
		ERROR_FLAG_HIC1 = 'success';				
		showBarMessage(ECM_GI0001);
		return false;			
	} 
	else if((strMasterId == 'HIC') && (lookupId == 'HIC2')){
		document.getElementById('bookingValue[' + aRowId + '].handlingInstCode2').value
			=arrResultData[IDX_HICCD];	
		document.getElementById('bookingValue[' + aRowId + '].handlingInstDesc2').value
			=arrResultData[IDX_HISDS];
		ERROR_FLAG_HIC2 = 'success';				
		showBarMessage(ECM_GI0001);
		return false;			
	} else if((strMasterId == 'HIC') && (lookupId == 'HIC3')){
		document.getElementById('bookingValue[' + aRowId + '].handlingInstCode3').value
			=arrResultData[IDX_HICCD];	
		document.getElementById('bookingValue[' + aRowId + '].handlingInstDesc3').value
			=arrResultData[IDX_HISDS];
		ERROR_FLAG_HIC3 = 'success';				
		showBarMessage(ECM_GI0001);
		return false;			
	} else if((strMasterId == 'PORT_CLASS')){
		document.getElementById('bookingValue[' + aRowId + '].imdgClass').value
			=arrResultData[IDX_IMDG];
		document.getElementById('bookingValue[' + aRowId + '].unNumber').value
			=arrResultData[IDX_UNNO];
		document.getElementById('bookingValue[' + aRowId + '].unNumberVariant').value
			=arrResultData[IDX_UNVAR];			
		document.getElementById('bookingValue[' + aRowId + '].portClass').value
			=arrResultData[IDX_PORT_CODE];			
		document.getElementById('bookingValue[' + aRowId + '].portClassType').value
			=arrResultData[IDX_PORT_TYPE];
		document.getElementById('bookingValue[' + aRowId + '].flashPoint').value
			=trimString(arrResultData[IDX_FLASH_POINT]);			
		document.getElementById('bookingValue[' + aRowId + '].flashUnit').value
			='C';			
		//ERROR_FLAG = 'success';				
		showBarMessage(ECM_GI0001);
		return false;			
	} 
	
	
}

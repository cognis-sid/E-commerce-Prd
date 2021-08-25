/**
* function called when screen load
*/
/*
-------------------------------------------------------------------------------------------------------------
EserviceBookingPopup.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Yossawat Suntisukkasem 15/01/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
var error_code = 0;

var parentObj = parent.opener;
var parentDoc = parentObj.document;
var parentForm = parentDoc.forms[0];

function getActionUrl(){
    return BROWSE_BOOKING_NUMBER;
}

function searchBtn(){
    var textFind = document.forms[0].tbxFind;
    var column = document.forms[0].columnValue;
    try{
    
        if((isNullObj(textFind) || isBlank(textFind.value)) && (isNullObj(column) || isBlank(column.value))){
            error_code = 1;
            loading();
            error_code = 2;
            document.forms[0].currPageNo.value= 1;
            error_code = 3;
            document.forms[0].action = BROWSE_BOOKING_NUMBER;
            error_code = 4;
            document.forms[0].submit();
        }else{
            if(isNullObj(textFind) || isBlank(textFind.value)){
                showBarMessage("Please input text find.",1);
                textFind.focus();
            }else if(isNullObj(column) || isBlank(column.value)){
                showBarMessage("Please select column.",1);
                column.focus();
            }else{
                error_code = 1;
                loading();
                error_code = 2;
                document.forms[0].currPageNo.value= 1;
                error_code = 3;
                document.forms[0].action = BROWSE_BOOKING_NUMBER;
                error_code = 4;
                document.forms[0].submit();
            }       
        }
        
    }catch(err){
        unloading();
        
        handleJavaScriptError('searchBtn', err, error_code);
    }
}

function resetBtn(){
    var textFind = document.forms[0].tbxFind;
    var column = document.forms[0].columnValue;
    var sortby = document.forms[0].sortByValue;
    var orderby = document.forms[0].orderValue;
    var wildcard = document.forms[0].chkBoxWildCard;
    var status = document.forms[0].statusValue;
    try{
        textFind.value = BLANK;
        column.selectedIndex = 0;
        sortby.selectedIndex = 0;
        orderby.selectedIndex = 0;
        status.selectedIndex = 0;
        wildcard.checked = false;
    }catch(err){
        handleJavaScriptError('resetBtn', err, MSG_ERROR_CODE);
    }
}

function callbackToField(bookingNo, blNo, statusCode, statusDesc, cocSoc, polNo, podNo){
    var messageTdParent = parentDoc.getElementById("msg");
    var params = "?bookingNo="+bookingNo;
    try{
        params += '&blNo='+blNo;
        params += '&esiStatusCode='+statusCode;
        params += '&esiStatusDesc='+statusDesc;
        params += '&cocSoc='+cocSoc;
        params += '&mode=select';
        params += '&fromPoup=1';
        
        error_code = 1;
        parentForm.bookingNo.value = bookingNo; 
        error_code = 2;
        parentForm.blNo.value = blNo; 
        error_code = 3;
        parentForm.esiStatusCode.value = statusCode;
        error_code = 4;
        parentForm.esiStatusDesc.value = statusDesc;
        error_code = 5;
        parentForm.cocSoc.value = cocSoc;
        error_code = 6;
        parentForm.polNo.value = polNo;
        error_code = 7;
        parentForm.podNo.value = podNo;
        error_code = 8;
        parentObj.getWebBookingData(parentForm ,params); 
    }catch(err){
        handleJavaScriptError('callbackToField', err, error_code);
    }finally{
        this.close();
        
        messageTdParent.innerHTML = MSG_LOADING;
        
        parentObj.loading();
    }
}

/**
* function called when screen load
*/
/*
-------------------------------------------------------------------------------------------------------------
EserviceCustomerPopup.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 12/12/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 07/10/2014    Pratya           01                PD_CR_20140826_ESV [Contract Party for registeration]
-------------------------------------------------------------------------------------------------------------
*/
var error_code = 0;

var parentObj = parent.opener;
var parentDoc = parentObj.document;
var parentForm = parentDoc.forms[0];

function getActionUrl(){
    return BROWSE_CUSTOMER_DATA;
}

function searchBtn(){
    var textFind 	= document.forms[0].tbxFind;
    var column 		= document.forms[0].columnValue;
    /*var cocSoc = parentForm.cocSoc;
    var cocSocVal = null;*/
    var url = BROWSE_CUSTOMER_DATA;
    try{
    
        if((textFind==null || textFind.value=='') && (column==null || column.value=='')){
            error_code = 1;
            loading();
            error_code = 2;
            document.forms[0].currPageNo.value= 1;
            error_code = 4;
            document.forms[0].action = url;
            error_code = 5;
            document.forms[0].submit();
        }else{
         if(textFind==null || textFind.value==''){
            showBarMessage("Please input text find.",1);
            textFind.focus();
        }else if(column==null || column.value==''){
            showBarMessage("Please select column.",1);
            column.focus();
        }else{
            error_code = 1;
            loading();
            error_code = 2;
            /*if(!isNullObj(cocSoc) && !isNullObj(cocSoc.value)){
                cocSocVal = cocSoc.value;
            }else{
                cocSocVal = BLANK;
            }
            url += '?cocSoc='+cocSocVal;
            url += '&defaultSearch=false';*/
            error_code = 3;
            document.forms[0].currPageNo.value= 1;
            error_code = 4;
            document.forms[0].action = url;
            error_code = 5;
            document.forms[0].submit();
        }      
        }
    }catch(err){
        unloading();
        
        handleJavaScriptError('searchBtn', err, error_code);
    }
}

function resetBtn(){
    var textFind    = document.forms[0].tbxFind;
    var column      = document.forms[0].columnValue;
    var sortby      = document.forms[0].sortByValue;
    var orderby     = document.forms[0].orderValue;
    var wildcard    = document.forms[0].chkBoxWildCard;
    try{
        textFind.value          = BLANK;
        column.selectedIndex    = 0;
        sortby.selectedIndex    = 0;
        orderby.selectedIndex   = 0;
        wildcard.checked        = false;
    }catch(err){
        handleJavaScriptError('resetBtn', err, MSG_ERROR_CODE);
    }
}

function callbackToField(customerCode, customerName, fscCode, customerType){
    
    var lo_rowIndex = null;
    try{
        lo_rowIndex = document.getElementById("rowIndex");
        if(lo_rowIndex.value==""){
            parentObj.setCustomerData(customerCode, customerName, fscCode, customerType);
        }else{
            parentObj.setCustomerDataForContractParty(customerCode, customerName, fscCode, customerType, lo_rowIndex.value);
        }
    }catch(err){
        handleJavaScriptError('callbackToField', err, MSG_ERROR_CODE);
    }
    this.close();
}

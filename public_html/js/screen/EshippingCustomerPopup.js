/**
* function called when screen load
*/
/*
-------------------------------------------------------------------------------------------------------------
EserviceBookingPopup.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Yossawat Suntisukkasem 17/01/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
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
    var textFind = document.forms[0].tbxFind;
    var column = document.forms[0].columnValue;
    var cocSoc = document.forms[0].cocSoc;
    var cocSocVal = null;
    var url = BROWSE_CUSTOMER_DATA;
    try{
        
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
            if(!isNullObj(cocSoc) && !isNullObj(cocSoc.value)){
                cocSocVal = cocSoc.value;
            }else{
                cocSocVal = BLANK;
            }
            url += '?cocSoc='+cocSocVal;
            url += '&defaultSearch=false';
            error_code = 3;
            document.forms[0].currPageNo.value= 1;
            error_code = 4;
            document.forms[0].action = url;
            error_code = 5;
            document.forms[0].submit();
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
    try{
        textFind.value = BLANK;
        column.selectedIndex = 0;
        sortby.selectedIndex = 0;
        orderby.selectedIndex = 0;
        wildcard.checked = false;
    }catch(err){
        handleJavaScriptError('resetBtn', err, MSG_ERROR_CODE);
    }
}

//function callbackToField(customerName, add1, add2, add3, add4, countryCode, customerCode){
//    var fieldName = parentForm.fieldName;
//    var fieldAdd1 = parentForm.fieldAdd1;
//    var fieldAdd2 = parentForm.fieldAdd2;
//    var fieldAdd3 = parentForm.fieldAdd3;
//    var fieldAdd4 = parentForm.fieldAdd4;
//    var fieldNameHidden = null;
//    var consigneeCode = parentForm.consigneeCode;
//    var notifyPartyCode = parentForm.notifyPartyCode;
//    try{
////        fieldName.value = (''!=customerName?customerName:'');
//        alert(parentForm.fieldName.value+'\ncustomerName = '+customerName+'\nadd1 = '+add1+
//        '\nadd2 = '+add2+'\nadd3 = '+add3+'\nadd4 = '+add4+'\ncountryCode = '+countryCode+'\ncustomerCode = '+customerCode);
//    
//        if(isNullObj(add1) || isBlank(add1)){
//            add1 = BLANK;
//        }
//        fieldAdd1.value = add1;
//        changeUpper(fieldAdd1);
//        
//        if(isNullObj(add2) || isBlank(add2)){
//            add1 = BLANK;
//        }
//        fieldAdd2.value = add2;
//        changeUpper(fieldAdd2);
//        
//        if(isNullObj(add3) || isBlank(add3)){
//            add3 = BLANK;
//        }
//        fieldAdd3.value = add3;
//        changeUpper(fieldAdd3);
//        
//        if(isNullObj(add4) || isBlank(add4)){
//            add4 = BLANK;
//        }
//        fieldAdd4.value = add4;
//        changeUpper(fieldAdd4);
//        
//        if('consigneeName' == fieldName.value){
//            consigneeCode.value = customerCode;
//        }else if('notifyPartyName' == fieldName.value){
//            notifyPartyCode.value = customerCode;
//        }
//    
//        fieldNameHidden = eval("parent.opener.document.forms[0]."+fieldName.value+'CountryCode');
//        fieldNameHidden.value = countryCode;
//        
//        
//        alert(parentForm.fieldName.value+'\ncustomerName = '+customerName+'\nadd1 = '+fieldAdd1.value+
//        '\nadd2 = '+fieldAdd2.value+'\nadd3 = '+fieldAdd3.value+'\nadd4 = '+fieldAdd4.value+
//        '\ncountryCode = '+countryCode+'\ncustomerCode = '+customerCode);
//    }catch(err){
//        handleJavaScriptError('callbackToField', err, MSG_ERROR_CODE);
//    }
//    this.close();
//}

function changeUpper(afield) {
    afield.value = afield.value.toUpperCase();
}
function callbackToField(customerName, add1, add2, add3, add4, countryCode, customerCode)
{

//alert("test");
    var fieldName = eval("parent.opener.document.forms[0].fieldName.value");
    var field = fieldName;
    fieldName = eval("parent.opener.document.forms[0]."+fieldName);
    fieldName.value = (''!=customerName?customerName:'');    

    var fieldAdd1 = eval("parent.opener.document.forms[0].fieldAdd1.value");
    fieldAdd1 = eval("parent.opener.document.forms[0]."+fieldAdd1);
    fieldAdd1.value = (''!=add1?add1:'');
    changeUpper(fieldAdd1);
    
    var fieldAdd2 = eval("parent.opener.document.forms[0].fieldAdd2.value");
    fieldAdd2 = eval("parent.opener.document.forms[0]."+fieldAdd2);
    fieldAdd2.value = (''!=add2?add2:'');
    changeUpper(fieldAdd2);
    
    var fieldAdd3 = eval("parent.opener.document.forms[0].fieldAdd3.value");
    fieldAdd3 = eval("parent.opener.document.forms[0]."+fieldAdd3);
    fieldAdd3.value = (''!=add3?add3:'');
    changeUpper(fieldAdd3);
    
    var fieldAdd4 = eval("parent.opener.document.forms[0].fieldAdd4.value");
    fieldAdd4 = eval("parent.opener.document.forms[0]."+fieldAdd4);
    fieldAdd4.value = (''!=add4?add4:'');
    changeUpper(fieldAdd4);

    var fieldNameHidden = eval("parent.opener.document.forms[0]."+fieldName.name+"CountryCode");
    fieldNameHidden = eval("parent.opener.document.forms[0]."+fieldNameHidden.name);
    fieldNameHidden.value = countryCode;
    if("consigneeName"==field)
    {
        var consigneeCode = eval("parent.opener.document.forms[0].consigneeCode");
        consigneeCode.value = customerCode;
    }
    else if("notifyPartyName"==field)
    {
        var notifyPartyCode = eval("parent.opener.document.forms[0].notifyPartyCode");
        notifyPartyCode.value = customerCode;
    }

    this.close();
}

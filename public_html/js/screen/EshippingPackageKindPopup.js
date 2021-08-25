/**
* function called when screen load
*/
/*
-------------------------------------------------------------------------------------------------------------
EshippingPackageKindPopup.js
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
    return BROWSE_PACKGAE_KIND_DATA;
}

function searchBtn(){
    var textFind = document.forms[0].tbxFind;
    var column = document.forms[0].columnValue;
    var url = BROWSE_PACKGAE_KIND_DATA;
    try{
        
        if((isNullObj(textFind) || isBlank(textFind.value)) && (isNullObj(column) || isBlank(column.value))){
            error_code = 1;
            loading();
            error_code = 2;
            document.forms[0].currPageNo.value= 1;
            error_code = 3;
            document.forms[0].action = url;
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
                document.forms[0].action = url;
                error_code = 4;
                document.forms[0].submit();
            } 
        }
        
        /*if(isNullObj(textFind.value) && isNullObj(tcolumn.value)){
            showBarMessage("Please choose criteria",1);
            textFind.focus();
        }else if(isNullObj(textFind) || isBlank(textFind.value)){
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
            document.forms[0].action = url;
            error_code = 4;
            document.forms[0].submit();
        }   */
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
    try{
        textFind.value = BLANK;
        column.selectedIndex = 0;
        sortby.selectedIndex = 0;
        orderby.selectedIndex = 0;
    }catch(err){
        handleJavaScriptError('resetBtn', err, MSG_ERROR_CODE);
    }
}

function callbackToField(packageCode, packageName){
    var packageCodeDocNameForSet    = document.getElementsByName('packageCodeDocNameForSet');
    var packageNameDocNameForSet    = document.getElementsByName('packageNameDocNameForSet');
    var packageType                 = document.getElementsByName('packageType');
    var rowForSet                   = document.getElementsByName('rowForSet');
    var packageKind                 = (packageCode+" - "+packageName);
//    var rowSelected = parentForm.rowSelected.value;
    var rowSelected                 = rowForSet[0].value;
    
    var packageCodeForSet           = null;
    var packageNameForSet           = null;
    var parentPackageCodeForSet     = null;
    var parentPackageNameForSet     = null;
    
    try{
        error_code = 1;
        packageCodeForSet                               = packageCodeDocNameForSet[0].value;
        error_code = 2;
        packageNameForSet                               = packageNameDocNameForSet[0].value;
//        alert('packageCodeForSet = '+packageCodeForSet+' : packageNameForSet = '+packageNameForSet+' : rowSelected = '+rowSelected);
        error_code = 3;
        parentPackageCodeForSet                         = parentDoc.getElementsByName(packageCodeForSet);
        error_code = 4;
        parentPackageCodeForSet[rowSelected].value      = packageCode;
        error_code = 5;
        parentPackageNameForSet                         = parentDoc.getElementsByName(packageNameForSet);
        error_code = 6;
        parentPackageNameForSet[rowSelected].value      = packageName;
        
        error_code = 7;
        if(PACKAGE_KIND_TYPE_EQUIPMENT == packageType[0].value){
            parentObj.onChangeEquipmentToCommodity(true);
        }
        error_code = 8;
    }catch(err){
        handleJavaScriptError('callbackToField', err, error_code);
    }
    this.close();
}

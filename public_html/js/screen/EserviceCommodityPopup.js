/**
* function called when screen load
*/

// ------------------------------ CONSTANTS DECLARATION START
var error_code;
var saveOperationFlag = "saveOperationFlag";

// ------------------------------ CONSTANTS DECLARATION END
function onLoad() {
    try{
        
        //-------------------------- enable or disable combos logic
        var originCountry =  document.getElementById("originCountry").value;
        var destinationCountry =  document.getElementById("destinationCountry").value;
    
        var objPortOfLoading = document.getElementById("portOfLoading");
        var objPlaceOfReceipt = document.getElementById("placeOfReceipt");
        var objPortOfDischarge = document.getElementById("portOfDischarge");
        var objPlaceOfDelivery = document.getElementById("placeOfDelivery");
        var objEmptyPickupDepot =  document.getElementById("emptyPickupDepot");
    
        //----------------------------for origin combo group
        if ((originCountry == '') || (originCountry == null)){
            objPortOfLoading.disabled='true';
            objPlaceOfReceipt.disabled='true';
            objEmptyPickupDepot.disabled='true';
        }
    
        //----------------------------for destinition combo group
        if ((destinationCountry== '') || (destinationCountry== null)){
            objPortOfDischarge.disabled='true';
            objPlaceOfDelivery .disabled='true';
        }
        
        var isOpenAcknowledgementPopup =  document.getElementById("openAcknowledgement");         
        
        if(isOpenAcknowledgementPopup.value == 'true')
        {
            var email = document.getElementById("email").value;
            var bookingNo = document.getElementById("bookingNo").value;
            var quotationNumber = document.getElementById("quotationNumber").value;
            var url;
            
            url = OPEN_ACKNOWLEDGEMENT+'?bookingNo='+bookingNo+'&email='+email+'&quotationNumber='+quotationNumber;

            openHelpList(url, 920, 370);

        }   
        
    }catch(err){

          txt="JAVASCRIPT ERROR.\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
//          alert(txt);
    }
    
} // onload

function submitBooking() {
    try{
    
        //------------------------- variable declaration
        var objSaveOperationFlag = document.getElementById(saveOperationFlag);

        //------------------------- validation
        if(!saveValidation()){
            return false;
        }

        //------------------------- set operation flag to 'N' for Normal Save
        objSaveOperationFlag.value = "N";

        //------------------------- submit the form
        document.forms[0].action = SAVE_BOOKING;
        document.forms[0].submit();
    }catch(err){

          txt="JAVASCRIPT ERROR ON SAVE.\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }

} // submitBooking



function updateRecordStatus(arow) {
    var lobjStatus = document.getElementById('value[' + arow + '].status');
    var lstrstatus = lobjStatus.value;
    if(lstrstatus == '') {
        lobjStatus.value = UPD;
    }
} // updateRecordStatus

function searchBtn(){
    try{
        error_code = 1;       
        var find = document.forms[0].find;
        error_code = 2;
        var column = document.forms[0].column;
        error_code = 3;
        
        if(''!=column.value && ''==find.value){
            error_code = 4;
            showBarMessage("Please input text find.",1);
            error_code = 5;
            find.focus();
        }
        else if(''==column.value && ''!=find.value){
            error_code = 6;
            showBarMessage("Please select column.",1);
            error_code = 7;
            column.focus();
        }
        else{
            error_code = 8;
            document.forms[0].currPageNo.value= 1;
            error_code = 9;
            document.forms[0].action = GET_LOOKUP_DATA;
            error_code = 10;
            document.forms[0].submit();
        }    
    }catch(err){

          txt="JAVASCRIPT ERROR .\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }
}

function callbackToField(commodityCode, commodityDesc, commodityRowIndex)
{   
    try{
        window.opener.setLookupValues(commodityRowIndex,commodityCode,commodityDesc);
        window.close();    

//        error_code = 1; 
//        var params = "?commodityGroup="+commodityCode+"&commodityGroupDetail="+commodityDesc+"&commodityRowIndex="+commodityRowIndex;
//        error_code = 2;
//        callParentScreen(eval("parent.opener.document.forms[0]") ,params);  
//        error_code = 3;
//        this.close();
    }catch(err){

          txt="JAVASCRIPT ERROR .\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }
    
} // callbackToField

function callbackToFieldNew(commodityCode, commodityDesc, commodityRowIndex)
{   
    try{
        window.opener.setLookupValuesNew(commodityRowIndex,commodityCode,commodityDesc);
        window.close();    

//        error_code = 1; 
//        var params = "?commodityGroup="+commodityCode+"&commodityGroupDetail="+commodityDesc+"&commodityRowIndex="+commodityRowIndex;
//        error_code = 2;
//        callParentScreen(eval("parent.opener.document.forms[0]") ,params);  
//        error_code = 3;
//        this.close();
    }catch(err){

          txt="JAVASCRIPT ERROR .\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }
    
}


function callParentScreen(parentForm, params){
    try{    
        error_code = 1;
        parentForm.action = NEW_WEB_BOOKING+params;
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


function getActionUrl()
{
    return GET_LOOKUP_DATA;
}
function resetBtn()
{
    var textfind = document.forms[0].find;
    var column = document.forms[0].column;
    var sortby = document.forms[0].sortBy;
    var orderby = document.forms[0].order;
    var wildcard = document.forms[0].chkBoxWildCard;
    
    textfind.value = '';
    column.selectedIndex = 0;
    sortby.selectedIndex = 0;
    orderby.selectedIndex = 0;
    wildcard.checked = false;
} //resetBtn

/* * end of JavaScript * */

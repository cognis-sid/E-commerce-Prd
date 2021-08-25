/**
* function called when screen load
*/

// ------------------------------ CONSTANTS DECLARATION START
var error_code;
var error_code = 0;

var parentObj = parent.opener;
var parentDoc = parentObj.document;
var parentForm = parentDoc.forms[0];

function getActionUrl(){
    return BROWSE_COMMODITY;
}

function searchBtn(){
    var commodityGroup  = document.forms[0].commodityGroup;
    var column          = document.forms[0].commodityDesc;
    try{
        error_code = 1;
        loading();
        error_code = 2;
        document.forms[0].currPageNo.value= 1;
        error_code = 3;
        document.forms[0].action = BROWSE_COMMODITY;
        error_code = 4;
        document.forms[0].submit();
    }catch(err){
        unloading();
        
        handleJavaScriptError('searchBtn', err, error_code);
    }
}

function resetBtn(){
    var lo_commodityGroup  = document.getElementById("commodityGroup");
    var lo_commodityCode   = document.getElementById("commodityCode");
    var lo_commodityDesc   = document.getElementById("commodityDesc");
    var lo_sortby          = document.getElementById("sortby");
    var lo_orderby         = document.getElementById("orderby");
    var lo_chkBoxWildCard  = document.getElementById("chkBoxWildCard");
    
    try{
        lo_commodityGroup.selectedIndex    = 0;
        lo_commodityCode.value             = BLANK;
        lo_commodityDesc.value             = BLANK;
        lo_sortby.selectedIndex            = 0;
        lo_orderby.selectedIndex           = 0;
        lo_chkBoxWildCard.checked          = false;
    }catch(err){
        handleJavaScriptError('resetBtn', err, MSG_ERROR_CODE);
    }
}

function callbackToField(commodityCode, commodityDesc, commodityGroupCode, commodityGroupDesc, commodityRowIndex){
    var messageTdParent = parentDoc.getElementById("msg");
    try{
        parentObj.setCommodityLookupValues(commodityCode, commodityDesc, commodityGroupCode, commodityGroupDesc, commodityRowIndex);
        
        this.close();
    }catch(err){
        handleJavaScriptError('callbackToField', err, error_code);
    }finally{
//        this.close();
//        
//        messageTdParent.innerHTML = MSG_LOADING;
//        
//        parentObj.loading();
    }
}
/* * end of JavaScript * */

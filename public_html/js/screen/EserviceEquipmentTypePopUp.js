
    var GV_HAULAGE     = "hualageLookUp";
    var GV_PORT        = "portLookUp";
    var GV_PLACE       = "placeLookUp";

function onLoad() {
    
} // onload

function searchBtn(){   
        var find    = document.getElementById("find");
        var column  = document.getElementById("column");
        var lv_url  = null;
        var lv_flag = "";
        
        if(''!=column.value && ''==find.value){
            showBarMessage("Please input text find.",1);
            find.focus();
        }
        else if(''==column.value && ''!=find.value){
            showBarMessage("Please select column.",1);
            column.focus();
        }
        else{
            lv_url = GET_EQUIP_TYPE_LOOKUP_DATA;
            
            document.forms[0].currPageNo.value= 1;
            document.forms[0].action = lv_url;
            document.forms[0].submit();
        }    
}

function callbackToField(av_code, av_desc){
    
    var rowIndex = document.getElementById("rowIndex");
    
    window.opener.callBackEquipmentTypeLookUp(av_code, av_desc, rowIndex.value);
    window.close(); 
    
}

function getActionUrl(){
    var lv_url  = null;
    
    lv_url = GET_EQUIP_TYPE_LOOKUP_DATA;
    
    return lv_url;
}
function resetBtn(){
    var textfind    = document.getElementById("find");
    var column      = document.getElementById("column");
    var sortby      = document.getElementById("sortBy");
    var orderby     = document.getElementById("order");
    var wildcard    = document.getElementById("chkBoxWildCard");
    
    textfind.value          = '';
    column.selectedIndex    = 0;
    sortby.selectedIndex    = 0;
    orderby.selectedIndex   = 0;
    wildcard.checked        = false;
} //resetBtn

/* * end of JavaScript * */

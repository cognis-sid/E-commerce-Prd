
    var GV_HAULAGE     = "hualageLookUp";
    var GV_PORT        = "portLookUp";
    var GV_PLACE       = "placeLookUp";

function onLoad() {
    $("#chkBoxWildCard").attr("checked","checked");
} // onload

function searchBtn(){
        var find    = document.getElementById("find");
        var column  = document.getElementById("column");
        var lo_flag = document.getElementById("flag");
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
            lv_flag = lo_flag.value;

            if(lv_flag==GV_HAULAGE) lv_url = GET_HAULAGE_LOOKUP_DATA;
            if(lv_flag==GV_PORT)    lv_url = GET_PORT_LOOKUP_DATA;
            if(lv_flag==GV_PLACE)   lv_url = GET_PLACE_LOOKUP_DATA;

            document.forms[0].currPageNo.value= 1;
            document.forms[0].action = lv_url;
            document.forms[0].submit();
        }
}

function callbackToField(av_code, av_desc){
    var lo_rowIndex = null;
    var lo_objName  = null;

    try{
        lo_rowIndex = document.getElementById("rowIndex");
        lo_objName  = document.getElementById("objName");

        if(lo_rowIndex.value==""){
            window.opener.callBackLookUp(av_code, av_desc, lo_objName.value);
        }else{
            window.opener.callBackLookUpWithRow(av_code, av_desc, lo_objName.value, lo_rowIndex.value);
        }
        window.close();
    }catch(err){
        handleJavaScriptError('callbackToField', err, 0);
    }

}

function getActionUrl(){
    var lo_flag = document.getElementById("flag");
    var lv_url  = null;
    var lv_flag = "";

    lv_flag = lo_flag.value;
    if(lv_flag==GV_HAULAGE) lv_url = GET_HAULAGE_LOOKUP_DATA;
    if(lv_flag==GV_PORT)    lv_url = GET_PORT_LOOKUP_DATA;
    if(lv_flag==GV_PLACE)   lv_url = GET_PLACE_LOOKUP_DATA;

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

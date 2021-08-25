
function onLoad() {
      $("#chkBoxWildCard").attr("checked","checked");
} // onload

function searchBtn(){
        var find    = document.getElementById("find");
        var column  = document.getElementById("column");

        if(''!=column.value && ''==find.value){
            showBarMessage("Please input text find.",1);
            find.focus();
        }
        else if(''==column.value && ''!=find.value){
            showBarMessage("Please select column.",1);
            column.focus();
        }
        else{
            document.forms[0].currPageNo.value  = 1;
            document.forms[0].action            = LOOKUP_DATA;
            document.forms[0].submit();
        }
}

function callbackToField(av_userId, av_userName, av_companyName, av_contractCompany){
    var lo_rowIndex = null;
    var lo_objName  = null;

    try{
        lo_rowIndex = document.getElementById("rowIndex");

        window.opener.callBackLookUpUserId(av_userId, av_userName, av_companyName, av_contractCompany, lo_rowIndex.value);
        window.close();
    }catch(err){
        handleJavaScriptError('callbackToField', err, 0);
    }

}

function getActionUrl(){
    return LOOKUP_DATA;
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

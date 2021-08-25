
function onLoad() {
    
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
            document.forms[0].currPageNo.value= 1;
            document.forms[0].action = GET_LOOKUP_DATA;
            document.forms[0].submit();
        }    
}

function callbackToField(av_portClassCode, av_unno, av_variant, av_imdgClass){   
    window.opener.callBackUNNOLookUp(av_portClassCode, av_unno, av_variant, av_imdgClass);
    window.close(); 
    
}

function getActionUrl()
{
    return GET_LOOKUP_DATA;
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

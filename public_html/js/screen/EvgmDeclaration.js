/**
* function called when screen load
*/

/*
-------------------------------------------------------------------------------------------------------------
EvgmDeclaration.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author Tanaphol 08/08/2016
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
function onLoad() {
//try{
    unloading();
//    }catch(Err){
//        alert(Err);
//    }

    var err_msg = document.getElementById("errMsg").value;
    
    if(err_msg != null && err_msg != ""){
        showBarMessage(err_msg, MSG_ERROR_CODE);
    }
}

function changeAction(){
    document.forms[0].action = CHANGE_ACTION;
    document.forms[0].submit();
}

function exportExcel(){
    document.forms[0].action = EXPORT_EXCEL;
    document.forms[0].submit();
}
function onUpload(){
    
    var data_file = document.getElementById("dataFile").value;
    if(data_file == ""){
        showBarMessage("Please Choose file to Upload.", MSG_ERROR_CODE);
    }else{
    
    
        document.forms[0].action = UPLOAD_EXCEL;
        document.forms[0].submit();
    }
}


function getActionUrl(){
    return GOTO_PAGING;
}

function gotoToSearchBooking()
{   
//    alert(event.keyCode);
    if(event.keyCode == 13 || event.keyCode == 9)
    {
//        @10 BEGIN
        loading();
//        pausePage1();
//        @10 END
//        getWebBookingDataOnBlurForShipping(obj);
        
        document.forms[0].action = FIND_BOOKING;
        document.forms[0].submit(); 
    }
}

function lp_delete(av_seq, ao_obj){
//alert("av_seq :"+av_seq);
    document.getElementById("delItem").value = (av_seq-2);
//    alert("document.getElementById(delItem).value :"+document.getElementById("delItem").value);
//    document.forms[0].action = DELETE;
//    document.forms[0].submit(); 
//    var postVal         = "seq=" + av_seq;
////        var lo_element      = ao_obj.parentNode.parentNode;
//    var lo_table        = document.getElementById("tableDetail");
//    var rowIndex = lo_table.rows.length;
//    alert(lo_table.rows.length);
    
//    if(rowIndex - 2 == 0){
//        showBarMessage("Container should have at least 1 .", MSG_ERROR_CODE);
//    
//    }else{
        document.forms[0].action = DELETE;
        document.forms[0].submit(); 
//    }
//    try{
//        $.ajax({
//            type: "POST",
//            url: DELETE,
//            data: postVal,
//            beforeSend: showBarMessage("Loading...", 2),//loading()
//            success: function(data){
//                try{
//                    showBarMessage("Ready", 2);
//                    if(data=="OK"){
//                        //lo_table.childNodes[0].removeChild(lo_element);
////                        lo_table.deleteRow(gp_rowTableIndex(ao_obj)); 
//                    }else{
//                        showBarMessage(data, MSG_ERROR_CODE);
//                    }
//                }catch(e){
//                    alert("in lp_delete :: " + e);
//                }
//            }
//        });
//    }catch(e){
//        alert("lp_delete :: " + e);
//    }
}

function submitVgm(){
//    var postVal         = "seq=1";
    var postVal = $("#frm").serialize();
//        var lo_element      = ao_obj.parentNode.parentNode;
//    var lo_table        = document.getElementById("tableData");
    try{
        $.ajax({
            type: "POST",
            url: VALIDATE,
            data: postVal,
            beforeSend: showBarMessage("Loading...", 2),//loading()
            success: function(data){
                try{
                    showBarMessage("Ready", 2);
                    if(data=="OK"){
                        //lo_table.childNodes[0].removeChild(lo_element);
//                        lo_table.deleteRow(gp_rowTableIndex(ao_obj)); 
                        document.forms[0].action = SAVE_VGM;
                        document.forms[0].submit();
                    }else{
                        showBarMessage(data, MSG_ERROR_CODE);
                    }
                }catch(e){
                    alert("in submitVgm :: " + e);
                }
            }
        });
    }catch(e){
        alert("lp_delete :: " + e);
    }
}
//function submitVgm(){
////    alert("1");
////    validateContainer();
//    
//    document.forms[0].action = SAVE_VGM;
////    document.forms[0].submit();
//}

function validateContainer(){
//    alert("2");
    var objTable = document.getElementById("tableDetail");
    var rowIndex = objTable.rows.length;
    
    for(i = 1 ; i < rowIndex ; i++){
        var container = document.getElementsByName('container');
        var vgm = document.getElementsByName('verGrossMass');
        
        var grossCargo = document.getElementsByName('grossCargo');
        var tareWeight = document.getElementsByName('tareWeight');
        
//        alert(tareWeight[i].value);
        
//        if(container[i].value == ""){
//            showBarMessage(EGM_SE0001, MSG_ERROR_CODE, new Array(i));
//            return false;
//        }
//        if(vgm[i].value == ""){
//            showBarMessage(EGM_SE0002, MSG_ERROR_CODE, new Array(i));
//            return false;
//        }
//        if(parseInt(grossCargo[i].value)){
//            showBarMessage(EGM_SE0003, MSG_ERROR_CODE, new Array(i));
//            return false;
//        }
        
        
    }
//    alert(objTable.rows.length);
}

function inputFloatAndDec(el,precision,checkValue){
    var ex = /^[0-9]+\.?[0-9]*$/;
    
    var pos = el.value.indexOf('.');
    var valueDec = "";
    
    var valueReplace = el.value;
    
    el.value = el.value.replace(",","");
//    alert(replaceVar);
    if(pos == 0){
            valueDec = 0+el.value;
    }else{
            valueDec = el.value;
    }

    if(checkValue){
        if(ex.test(valueDec)==false){
            el.value = "";
        }
    }else{
        if(ex.test(valueDec)==false){
            el.value = el.value.substring(0,el.value.length - 1);
        }
    }

    if(el.value.indexOf('.') != -1 ){
        if(checkValue){
            if(el.value.split('.')[1].length < precision){
                    return true;
            }else{
                if(el.value.split('.')[1].length == precision){
                    return true;
                }else{
                    el.value = el.value.substring(0,el.value.indexOf('.')+2);
                }
            }
        }else{
    
            if(el.value.split('.')[1].length < precision){
                return true;
            }else{
                if(el.value.split('.')[1].length == precision){
                         return true;
                }else{
                        el.value = el.value.substring(0,el.value.length - 1);
                }
            }
        }
    }
}

function numberWithCommas(x) {

    var parts = x.toString().split(".");
    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return parts.join(".");
}

function addComma(f1){
    f1.value = numberWithCommas(f1.value);
}

function getPDF(){

        var url = PRIVIEW_PDF_REPORT;

        openHelpList(url,850,650);
            
}

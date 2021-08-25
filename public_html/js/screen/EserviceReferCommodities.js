var MSG_NORMAL = 0;
var MSG_ERROR = 1;
var MSG_LOADING = 'Loading ...';

function onLoad(){
    lp_onClickControlledAtmosphere();
    lp_onBlursetFormat();
    lp_displayBtn();
}

function lp_displayBtn(){
    var lo_disBtn               = document.getElementById("disBtn");
    var lo_trSubmitBtn          = document.getElementById("trSubmitBtn");
    var la_idName               = new Array("temperature", "ventilation", "remark", "humidity", "controlledAtmosphere", "nitrogen", "oxygent", "co2", "refMode", "preCooled");
    var lo_element;
    
    if(lo_disBtn.value=="Y"){
        for(var i=0;i<la_idName.length;i++){
            lo_element              = eval('document.getElementById("' + la_idName[i] + '")');
            lo_element.disabled     = true;
        }
        
        lo_trSubmitBtn.style.display = "none";
    }
    
}

function lp_onClickControlledAtmosphere(){
    var lo_controlledAtmosphere = document.getElementById("controlledAtmosphere");
//    var la_idName               = new Array("nitrogen", "oxygent", "co2", "refMode", "preCooled");
    var la_idName               = new Array("nitrogen", "oxygent", "co2");
    var lv_disabled             = false;
    var lo_element;
    
    if(lo_controlledAtmosphere.checked==false){
        lv_disabled             = true;
    }
    
    for(var i=0;i<la_idName.length;i++){
        lo_element              = eval('document.getElementById("' + la_idName[i] + '")');
        lo_element.disabled     = lv_disabled;
        
//        if(lv_disabled==true){
//            if(la_idName[i]=="preCooled"){
//                lo_element.checked = false;
//            }else{
//                lo_element.value = "";
//            }
//        }
        
    }
    
}

function submitBtn(){
    
    var lo_seqNo        = document.getElementById("seqNo");
    var lo_rowIndex     = document.getElementById("rowIndex");
    var postVal         = $("#frm").serialize();
    var lo_temperature  = document.getElementById("temperature");
    
    if(gp_trim(lo_temperature.value)==""){
        showBarMessage(ESR_SE0022, MSG_ERROR_CODE);
        return;
    }
    
    /*if(!lp_onBlursetFormat()){
        return;
    }*/
    
    $.ajax({
        type: "POST",
        url: SUBMIT,
        data: postVal,
        beforeSend: loading(),//loading()
        success: function(data){
            unloading();
            if(data=="OK"){
                parent.opener.callBackRateTypeLookUp(lo_seqNo.value, lo_rowIndex.value);
                window.close();
            }else{
                showBarMessage(data, MSG_ERROR_CODE);
            }
        }
    });
}

function lp_onBlursetFormat(){
    var la_idName               = new Array("temperature", "ventilation", "humidity", "nitrogen", "oxygent", "co2");
    var lo_obj;
    var lv_returnFlag;
    
    for(var i=0;i<la_idName.length;i++){
        lo_obj = eval('document.getElementById("' + la_idName[i] + '")');
        
        if(la_idName[i]=="temperature"){
            lv_returnFlag = gp_number_format(lo_obj, 3, '.', ',');
        }else{
            lv_returnFlag = gp_number_format(lo_obj, 2, '.', ',');
        }
        
        if(lv_returnFlag==false){
            lo_obj.value = "";
            return false;
        }
        
    }
    showBarMessage("Ready", 2);
    return true;
}

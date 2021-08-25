    var MSG_NORMAL = 0;
    var MSG_ERROR = 1;
    var MSG_LOADING = 'Loading ...';
    
    function onLoad(){
        lp_onBlursetFormat();
        lp_displayBtn();
    }
    
    function lp_displayBtn(){
        var lo_disBtn               = document.getElementById("disBtn");
        var lo_trSubmitBtn          = document.getElementById("trSubmitBtn");
        var la_idName               = new Array("flashPoint", "unitMeasurement", "unNoDis", "unNoLookup", "variantDis", "imdgClassDis", "portClass", "residue", "fumigration");
        var lo_element;
        
        if(lo_disBtn.value=="Y"){
            for(var i=0;i<la_idName.length;i++){
                lo_element              = eval('document.getElementById("' + la_idName[i] + '")');
                lo_element.disabled     = true;
            }
            
            lo_trSubmitBtn.style.display = "none";
        }
        
    }
    
    function submitBtn(){
        
        var lo_seqNo        = document.getElementById("seqNo");
        var lo_rowIndex     = document.getElementById("rowIndex");
        var postVal         = $("#frm").serialize();
        
        showBarMessage("Ready", 2);
        if(!lp_validate()){
            return;
        }

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
    
    function resetBtn(){
        var la_idName               = new Array("flashPoint", "unitMeasurement", "unNo", "variant", "imdgClass", "unNoDis", "variantDis", "imdgClassDis", "portClass", "residue", "fumigration");
        var lo_obj;
        
        for(var i=0;i<la_idName.length;i++){
            lo_element              = eval('document.getElementById("' + la_idName[i] + '")');
            
            if(la_idName[i]=="residue" || la_idName[i]=="fumigration"){
                lo_element.checked = false;
            }else{
                lo_element.value        = "";
            }
        }
    }
    
    function openUNNOLookUp() {
        var urlStr                  = UNNO_LOOKUP;
        
        openHelpList(urlStr, 950, 750);
        return false;
    }
    
    function callBackUNNOLookUp(av_portClassCode, av_unno, av_variant, av_imdgClass) {
        var lo_portClass        = document.getElementById("portClass");
        var lo_unNo             = document.getElementById("unNo");
        var lo_variant          = document.getElementById("variant");
        var lo_imdgClass        = document.getElementById("imdgClass");
        var lo_unNoDis          = document.getElementById("unNoDis");
        var lo_variantDis       = document.getElementById("variantDis");
        var lo_imdgClassDis     = document.getElementById("imdgClassDis");
        
        lo_portClass.value      = av_portClassCode;
        lo_unNo.value           = av_unno;
        lo_variant.value        = av_variant;
        lo_imdgClass.value      = av_imdgClass;
        lo_unNoDis.value        = av_unno;
        lo_variantDis.value     = av_variant;
        lo_imdgClassDis.value   = av_imdgClass;
        
    }

    function lp_onBlursetFormat(){
        var la_idName               = new Array("flashPoint");
        var lo_obj;
        var lv_returnFlag;
        
        for(var i=0;i<la_idName.length;i++){
            lo_obj          = eval('document.getElementById("' + la_idName[i] + '")');
            lv_returnFlag   = gp_number_format(lo_obj, 3, '.', ',');
            
            if(lv_returnFlag==false){
                lo_obj.value = "";
                return false;
            }
            
        }
        showBarMessage("Ready", 2);
        return true;
    }
    
    function lp_validate(){
        var lo_unitMeasurement      = document.getElementById("unitMeasurement");
        var lo_flashPoint           = document.getElementById("flashPoint");
        var lo_unNo                 = document.getElementById("unNo");
        var lo_variant              = document.getElementById("variant");
        var lo_imdgClass            = document.getElementById("imdgClass");
        var lo_portClass            = document.getElementById("portClass");
        
        //Begin Check flashPoint
        if(gp_trim(lo_flashPoint.value)!="" && lo_unitMeasurement.value==""){
            showBarMessage(ESR_SE0027, MSG_ERROR_CODE);
            return false;
        }
        //End Check flashPoint
        
        //Begin Check unNo, variant, imdgClass and portClass is blank
        if((gp_trim(lo_unNo.value)=="" && gp_trim(lo_variant.value)=="" && gp_trim(lo_imdgClass.value)=="") && gp_trim(lo_portClass.value)==""){
            showBarMessage(ESR_SE0023, MSG_ERROR_CODE);
            return false;
        }
        //End Check unNo, variant, imdgClass and portClass is blank
        
        if(gp_trim(lo_portClass.value)!=""){
            if(!lp_validateDG()) return false;
        }
        
        return true;
        
    }
    
    function lp_validateDG(){
        var postVal         = $("#frm").serialize();
        var errMsg          = null;
        var lv_return       = true;
        
        $.ajax({
            type: "POST",
            url: VALIDIDATE_DG,
            data: postVal,
            beforeSend: null,
            success: function(data){
                if(data.indexOf("OK") > -1){
                    lv_return = true;
                }else{
                    errMsg = data.split("::");
                    showBarMessage(errMsg[1], MSG_ERROR_CODE);
                    lv_return =  false;
                }
            }
        });
        
        return lv_return;
    }

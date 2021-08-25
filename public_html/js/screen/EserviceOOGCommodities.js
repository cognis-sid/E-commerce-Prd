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
        var la_idName               = new Array("txtLength", "txtWidth", "txtHeight", "txtDiameter");
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
        //alert(postVal);
        
        if(!lp_validate()){
            showBarMessage(ESR_SE0024, MSG_ERROR_CODE);
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

    function lp_onBlursetFormat(){
        var la_idName               = new Array("txtLength", "txtWidth", "txtHeight", "txtDiameter");
        var lo_obj;
        var lv_returnFlag;
        
        for(var i=0;i<la_idName.length;i++){
            lo_obj          = eval('document.getElementById("' + la_idName[i] + '")');
            lv_returnFlag   = gp_number_format(lo_obj, 4, '.', ',');
            
            if(lv_returnFlag==false){
                lo_obj.value = "";
                return false;
            }
            
        }
        showBarMessage("Ready", 2);
        return true;
    }
    
    function lp_validate(){
        var la_idName               = new Array("txtLength", "txtWidth", "txtHeight");
        var lo_obj;
        
        for(var i=0;i<la_idName.length;i++){
            lo_obj          = eval('document.getElementById("' + la_idName[i] + '")');
            
            if(gp_trim(lo_obj.value)==""){
                return false;
            }
            
        }
        showBarMessage("Ready", 2);
        return true;
        
    }

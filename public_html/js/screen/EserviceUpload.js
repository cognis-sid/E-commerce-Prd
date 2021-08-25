    $( document ).ready(function() {
             $('input[type="file"]').ajaxfileupload({
                       'params': {'ac':'sss'},
                   'action': SEND_FILE_TO_TEMP,           
               'onComplete': function(response) {
                     gp_progressBarOff();
                     lp_uploadReturn(response);
                     
                   },
                   'onStart': function() {
                     showBarMessage("Loading...", 2);
                     gp_progressBarOn();
                   },
                   'submit_button' :  null//$('#btnSubmit')
              });
            
    });
    
    function onLoad(){
        lp_displayBtn();
    }
    
    function lp_displayBtn(){
        var lo_disBtn               = document.getElementById("disBtn");
        var lo_trSubmitBtn          = document.getElementById("trSubmitBtn");
        var la_idName               = new Array("dataFile");
        var lo_element;
        
        if(lo_disBtn.value=="Y"){
            for(var i=0;i<la_idName.length;i++){
                lo_element              = eval('document.getElementById("' + la_idName[i] + '")');
                lo_element.disabled     = true;
            }
            
            lo_trSubmitBtn.style.display = "none";
        }
        
    }
    
    function lp_uploadReturn(av_val){
        var code            = null;
        var data            = null;
        var fileName        = null;
        var seq             = null;
        var status          = null;
        var size            = null;
        var lo_table        = document.getElementById("tableData");
        var newNodeTr 	    = null;
        var newNodeTd1 	    = null;
        var newNodeTd2 	    = null;
        var newNodeTd3 	    = null;
        var lo_lstrCtxPath  = document.getElementById("lstrCtxPath");
        var rowIndex        = lo_table.rows.length;
        
        try{
            if(av_val!=null){
                showBarMessage("Ready", 2);
                if(av_val.indexOf("OK") > -1){
                    code        = av_val.split("::");
                    data        = code[1].split("||");
                    fileName    = data[0];
                    seq         = data[1];
                    status      = data[2];
                    size        = data[3];
                    
//                    lo_table.childNodes[0].appendChild(newNodeTr);//class="TdLeftDetailPopup" width="20%"  height="20px;"

                    newNodeTr       = lo_table.insertRow(rowIndex);
                    newNodeTd1      = newNodeTr.insertCell(0);
                    newNodeTd2      = newNodeTr.insertCell(1);
                    newNodeTd3      = newNodeTr.insertCell(2);
                    
                    // File Name
                    newNodeTd1.style.width      = "50%";
                    newNodeTd1.style.height     = "20px";
                    newNodeTd1.className        = "TdLeftDetailPopup";
                    newNodeTd1.innerHTML        = fileName;
                    
                    // File Size
                    newNodeTd2.style.width      = "30%";
                    newNodeTd2.style.height     = "20px";
                    newNodeTd2.className        = "TdLeftDetailPopup";
                    newNodeTd2.innerHTML        = size + '&nbsp;<span>KB</span>';
                    
                    // Delete
                    newNodeTd3.style.width      = "20%";
                    newNodeTd3.style.height     = "20px";
                    newNodeTd3.className        = "TdLeftDetailPopup";
                    newNodeTd3.innerHTML        = '<A href="#" onclick="lp_delete(' + seq + ', this)" >' +
                                                    '<IMG border="0" alt="Delete" src="' + lo_lstrCtxPath.value + '/images/btnClose.gif" width="16" height="16">' +
                                                  '</A> ' +
                                                  '<input type="hidden" name="seq" value="' + seq + '" /> ' +
                                                  '<input type="hidden" name="status" value="' + status + '" />';
                    
//                    newNodeTr.appendChild(newNodeTd1);
//                    newNodeTr.appendChild(newNodeTd2);    
//                    newNodeTr.appendChild(newNodeTd3);    
                    
                }else{
                    code = av_val.split("::");
                    showBarMessage(code[1], MSG_ERROR_CODE);
                }
            }
            document.getElementById("frm1").reset();
        }catch(e){
            alert("lp_uploadReturn :: " + e);
        }
        
    }
    
    function lp_delete(av_seq, ao_obj){
        var postVal         = "seq=" + av_seq;
//        var lo_element      = ao_obj.parentNode.parentNode;
        var lo_table        = document.getElementById("tableData");
        try{
            $.ajax({
                type: "POST",
                url: DELETE,
                data: postVal,
                beforeSend: showBarMessage("Loading...", 2),//loading()
                success: function(data){
                    try{
                        showBarMessage("Ready", 2);
                        if(data=="OK"){
                            //lo_table.childNodes[0].removeChild(lo_element);
                            lo_table.deleteRow(gp_rowTableIndex(ao_obj)); 
                        }else{
                            showBarMessage(data, MSG_ERROR_CODE);
                        }
                    }catch(e){
                        alert("in lp_delete :: " + e);
                    }
                }
            });
        }catch(e){
            alert("lp_delete :: " + e);
        }
    }
    
    function submitBtn(){
	if($('#tableData >tbody >tr').length>6){
		document.getElementById('ErrorMsgLog').style.display = 'block';
		return false;
	}else{
		document.getElementById('ErrorMsgLog').style.display = 'none';
	}
        var postVal         = $("#frm2").serialize();
        var code            = null;
        var inform          = null;
        
        try{
            $.ajax({
                async:false,
                type: "POST",
                url: SUBMIT,
                data: postVal,
                beforeSend: showBarMessage("Loading...", 2),//loading()
                success: function(data){
                    try{
                        showBarMessage("Ready", 2);
                        
                        code = data.split("::");
                        
                        if(code[0]=="OK"){
                            parent.opener.callBackUploadAttachment(code[1]);
                            window.close();
                        }else{
                            showBarMessage(code[1], MSG_ERROR_CODE);
                        }
                    }catch(e){
                        alert("in submitBtn :: " + e);
                    }
                }
            });
        }catch(e){
            alert("submitBtn :: " + e);
        }
    }
    
    function lp_viewPdf(ao_obj){
        alert(ao_obj.innerHTML);
        
        urlStr = VIEW_PDF + "?fileName=" + gp_sanitizeURLString(ao_obj.innerHTML);
        
        openScreenForNewWeb(urlStr, 'EservicePdfSvc', 950, 750);
        return false;
    }
    
//    function sanitizeURLString(av_val){
//        var la_symbol   = ["%" , "<" , ">" , "#" , "{" , "}" , "|" , "\\" , "^" , "~" , "[" , "]" , "`" , ";" , "/" , "?" , ":" , "@" , "=" , "&" , "$"];
//        var la_replace  = ["%25", "%3C", "%3E", "%23", "%7B", "%7D", "%7C", "%5C", "%5E", "%7E", "%5B", "%5D", "%60", "%3B", "%2F", "%3F", "%3A", "%40", "%3D", "%26", "%24"];
//        var lv_return   = null;
//        
//        lv_return = av_val;
//        
//        for(var i=0;i<la_symbol.length;i++){
//        
//            if(lv_return.indexOf(la_symbol[i]) > -1){
//                lv_return = lv_return.replace(la_symbol[i], la_replace[i]);
//            }
//        }
//        
//        return lv_return;
//    }
    
    function openScreenForNewWeb(screen_url, winName, screenWidth, screenHeight){
        childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight + ',left=' + 0 + ',top=' + 0 + 'resizable=yes,scrollbars=yes,toolbar=yes,titlebar=yes');
        childWindow.focus();
    }
    
//    function progressBarOn(){
//        scroll(0,0);
//        var outerPane = document.getElementById('FreezePane');
//        var processBar = document.getElementById('processBar');
//        if (outerPane) outerPane.className = 'FreezePaneOn';
//        if(processBar) processBar.className = 'processBarOn';
//    }
//    
//    function progressBarOff(){
//        scroll(0,0);
//        var outerPane = document.getElementById('FreezePane');
//        var processBar = document.getElementById('processBar');
//        if (outerPane) outerPane.className = 'FreezePaneOff';
//        if(processBar) processBar.className = 'processBarOff';
//    }

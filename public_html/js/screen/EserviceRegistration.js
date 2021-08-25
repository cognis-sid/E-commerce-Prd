/**
* function called when screen load
*/

/*
-------------------------------------------------------------------------------------------------------------
EserviceRegistration.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author -
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 07/10/2014     PRATYA          01                PD_CR_20140826_ESV [Contract Party for registeration]
## 08/12/2015     Watchakorn      02                Change solution for Represented Company Contract
## 08/01/2016     Watchakorn      03                Add function excludeExpireContractParty()
## 20/01/2016     Watchakorn      04                Add check readOnly before clear message.
## 20/12/2018     Thitipong       05                Add checkbox Non RA Account.
-------------------------------------------------------------------------------------------------------------
*/
var ANNOUNCE_TYPE_TERM_OF_USE           = 0;
var ANNOUNCE_TYPE_PRIVACY_POLICY        = 1;
var SERVICE_CODE_ESV                    = 'EBKG-E';
var SERVICE_CODE_ESI                    = 'EDOC-E';
var CLASS_NAME_BUTTON                   = 'm-btn smallest blue rnd smallericn-only';
var CLASS_NAME_DISABLED_BUTTON          = 'm-btn smallest blue rnd smallericn-only disabled';
var xmlhttp                             = new XMLHttpRequest();

function openPopup(strUrl,intWidth,intHeight) {
    var intWidthDefault     = 560;
    var intHeightDefault    = 430;
    if((intWidth == null)||(intHeight == null)){
         w=window.open(strUrl, 'HelpWindow', 'width='+intWidthDefault+', height='+intHeightDefault+', resizable=yes, scrollbars=yes, toolbar=no');
    }else{
        w=window.open(strUrl, 'HelpWindow', 'width='+intWidth+', height='+intHeight+', resizable=yes, scrollbars=auto, toolbar=no');
    }
    w.focus();
}

function onLoad(){
	debugger;
    var errorMsg                    = document.getElementsByName("errMsg");
    var submitSuccess               = document.getElementsByName('submitSuccess');
    var userId                      = document.getElementsByName('userInfoMod.userId')[0];
    var checkResultMessage          = document.getElementById('checkResultMessage');
    var userIdPassedObj             = document.getElementById('userIdPassed');
    var isInternalUser              = document.getElementsByName('isInternalUser');
    var internalUser                = document.getElementsByName('internalUser');
    var isClose                     = false;
    //var lo_representedCompanyFlag   = document.getElementById('representedCompanyFlag'); //##02
    var lo_portPairFlag             = document.getElementById('portPairFlag');
    var error_code                  = 0;

    try{
        if(!isNullObj(submitSuccess) && !isNullObj(submitSuccess[0]) && submitSuccess[0].value == 'true'){
            /*if(internalUser[0].value == 'RR'){
                document.forms[0].action = REGISTRATION_REQUEST;
                document.forms[0].submit();
            }else if(internalUser[0].value == 'R'){*/
                //loading();
               // window.location.href=LOGOUT_URL;
				//openHelpList(OPEN_ACKNOWLEDGE, 823, 300);
        		if($("#customerCode").val()==""){
				swal("Message",popMsg,"info")
						.then(function(){
							 window.location.href=LOGOUT_URL;
						});
        		}else{
					 swal("Message",popMsgNew,"info")
						.then(function(){
							 window.location.href=LOGOUT_URL;
						});
        		}
           /* }else if(internalUser[0].value == 'MA'){
                window.close();
            }*/
				 
        }else{
            error_code = 1;
            if(!isNullObj(errorMsg) && !isNullObj(errorMsg[0]) && !isBlank(errorMsg[0].value)){
                showBarMessageNew(errorMsg[0].value, MSG_ERROR_CODE);
                errorMsg[0].value = '';
            }
            error_code = 2;
            if(userIdPassedObj != null && userIdPassedObj.value == 'true'){
                userId.style.backgroundColor            = '#FFFFFF';
                checkResultMessage.style.color          = '#00c400';
                checkResultMessage.style.fontWeight     = 'bold';
                checkResultMessage.style.fontSize       = '11';
                checkResultMessage.innerHTML            = 'Available';
            }
            error_code = 3
            accountControl();
            error_code = 4;
            if(!isNullObj(isInternalUser) && !isNullObj(isInternalUser[0]) && !isNullObj(isInternalUser[0].value)){
                if(isInternalUser[0].value == 'true'){
                    customerControl();
                }
            }
            error_code = 5;
            companyControl();
            error_code = 6;
            serviceRequestControl();
        }
        /*Begin @01*/
//        lp_chkRepresentedCompanyFlag(); //##02
        if(lo_portPairFlag.value=="Y") lp_disabledTextBox();
        if(internalUser[0].value=="RR")lp_disabledTextBoxRR();
        /*End @01*/

        error_code = 7;
        //##02 BEGIN
        $("input[name=reactPwd]").attr('placeholder', 'PASSWORD');
        $("input[name=reactPwd]").attr('title', 'PASSWORD');
        //##02 end
    }catch(err){
        //alert("onLoad "+err);
        handleJavaScriptError('onLoad', err, error_code);
    }
}


//##02 Begin
function activateRepresentedCompany(obj,row){
    var pkEsvPpHdrSeq             = null;
    var vPwd                      = null;
    var rowIndex                  = null;
    var btnActiveContractCompany  = null;
    var txtReactPwd               = null;
    try{
        rowIndex          = row ;
        pkEsvPpHdrSeq     = document.getElementsByName("pkEsvPpHdrSeq")[rowIndex].value;
        btnActivate       = document.getElementsByName("btnActiveContractCompany")[rowIndex];
        txtReactPwd       = document.getElementsByName("reactPwd")[rowIndex];
		if(txtReactPwd.value=="" || txtReactPwd.value==null){
			showBarMessageNew("Password is not provided, please check", MSG_ERROR_CODE);
			return false;
		}
        var postVal = "pkEsvPpHdrSeq="+pkEsvPpHdrSeq+"&reactPwd="+txtReactPwd.value;
        $.ajax({
            type : "POST",
            url : ACTIVATE_REPRESENTED_COMPANY,
            data : postVal,
            beforeSend : loading(),
            success : function(data){
                try{
                    if(gp_trim(data) == "OK"){
	debugger;
                        $(txtReactPwd).attr("disabled","disabled");
                        $(btnActivate).attr("disabled","disabled");
                        $(btnActivate).attr("onClick", "void(0)");
                        showBarMessage("Ready", 2);
                    } else if(gp_trim(data) == "MISMATCH"){
                        txtReactPwd.focus();
                        showBarMessageNew("Password is invalid, please check", MSG_ERROR_CODE);
                    } else {
						loading(true);
                        handleJavaScriptError('activateRepresentedCompany', data, 0);
                    }
                } catch (err){
					loading(true);
                    handleJavaScriptError('activateRepresentedCompany', err, 0);
                }
                loading(true);
            }
        });
    } catch (err){
		loading(true);
        handleJavaScriptError('activateRepresentedCompany', err, 0);
    }
}
//##02 End

    /*Begin @01*/
    function lp_disabledTextBoxRR(){
        var la_name         = new Array( "approveFlag"          , "createCRMCustBtnForContractParty"    , "fkContractPartyCode"  , "btnBrowseCutsomerNameForContractParty"
                                       , "contractPartyFscCode" , "btnBrowseFSCForContractParty"        , "contractPartyType"    , "btnBrowseCutsomerTypeForContractParty");
        var la_element      = null;
        var la_recStatus    = document.getElementsByName("recStatus");

        try{
            for(var i=0;i<la_name.length;i++){
                la_element              = eval('document.getElementsByName("' + la_name[i] + '")');
                for(var j=0;j<la_element.length;j++){
                    if(la_recStatus[j].value!="P"){
//                        la_element[j].disabled     = true;
                        la_element[j].setAttribute("disabled","true");
                        la_element[j].onclick = function() {return false;};
                    }
                }
            }
        }catch(err){
            handleJavaScriptError('lp_disabledTextBoxRR', err, 0);
        }
    }
    /*End @01*/

    /*Begin @01*/
    function lp_disabledTextBox(){
        var la_idName   = new Array( "customerCode"         , "btnBrowseCutsomerName"   , "customerFscCode"         , "btnBrowseFSC"
                                   , "customerType"         , "userInfoMod.address1"    , "userInfoMod.address2"    , "userInfoMod.address3"
                                   , "userInfoMod.address4" , "userInfoMod.city"        , "userInfoMod.state"       , "userInfoMod.phoneNo"
                                   , "userInfoMod.faxNo"    , "userInfoMod.cmpName"     , "userInfoMod.userName"    , "userInfoMod.email"
                                   , "btnBrowseCutsomerType");
        var lo_element  = null;

        try{
            for(var i=0;i<la_idName.length;i++){
                lo_element              = eval('document.getElementById("' + la_idName[i] + '")');
//                lo_element.disabled     = true;
                lo_element.setAttribute("disabled","true");
                lo_element.onclick = function() {return false;};
            }
        }catch(err){
            handleJavaScriptError('lp_disabledTextBox', err, 0);
        }
    }
    /*End @01*/

    /*Begin @01*/
    function lp_addContractCompany(){

        var lo_contractPartyTab         = null;
        var lo_maxPkPortPairSeq         = null;
        var lo_contextPath              = null;
        var lo_contractPartyCompanyDiv  = null;
        var lo_internalUser             = null;
        var lv_maxSeq                   = 0;
        var lv_strNode2                 = "";
        var newNodeTr 	                = null;
        var newNodeTd1 			= null;
        var newNodeTd2 			= null;
        var newNodeTd3 			= null;
        var newNodeTd4 			= null;
        var rowIndex                    = 0;

        try{
            lo_contractPartyTab         = document.getElementById("contractPartyTab");
            lo_maxPkPortPairSeq         = document.getElementById("maxPkPortPairSeq");
            lo_contextPath              = document.getElementById("contextPath");
            lo_contractPartyCompanyDiv  = document.getElementById("contractPartyCompanyDiv");
            lv_maxSeq                   = parseInt(lo_maxPkPortPairSeq.value) + 1;
            lo_internalUser             = document.getElementById("internalUser");
            rowIndex                    = lo_contractPartyTab.rows.length;

//            lo_contractPartyTab.childNodes[0].appendChild(newNodeTr);

            var postVal     = "maxPkPortPairSeq=" + lv_maxSeq;
            $.ajax({
                type: "POST",
                url: ADD_CONTRACT_COMPANY,
                data: postVal,
                beforeSend: showBarMessage("Loading...", 2),
                success: function(data){
                    if(gp_trim(data)=="OK"){
                        newNodeTr       = lo_contractPartyTab.insertRow(rowIndex);

                        if(lo_internalUser.value=="R"){
//                            newNodeTr.appendChild(newNodeTd1);
//                            newNodeTr.appendChild(newNodeTd2);
//                            newNodeTr.appendChild(newNodeTd3);

                            newNodeTd1      = newNodeTr.insertCell(0);
                            newNodeTd2      = newNodeTr.insertCell(1);
                            newNodeTd3      = newNodeTr.insertCell(2);
                        }else{
                            newNodeTd1      = newNodeTr.insertCell(0);
                            newNodeTd2      = newNodeTr.insertCell(1);
                            newNodeTd3      = newNodeTr.insertCell(2);
                            newNodeTd4      = newNodeTr.insertCell(3);
                        }

                        newNodeTr.className                = "tr_sub_detail";

                        //Contract Company
                        newNodeTd1.style.width      = "15%";
                        newNodeTd1.style.height     = "30px";
                        newNodeTd1.innerHTML        = "Contract Company:";

                        //Contract Company name
                        newNodeTd2.style.width      = "60%";
                        newNodeTd2.style.height     = "30px";
                        newNodeTd2.align            = "left";
                        newNodeTd2.valign           = "middle";
                        lv_strNode2                 = '<input type="hidden" name="fkContractPartyCode" value="" />'
                                                    + '<input type="hidden" name="pkPortPairSeq" value="' + lv_maxSeq + '" />'
                                                    + '<input type="hidden" name="statusFlag" value="ADD" />'
                                                    + '<input type="hidden" name="approveFlag" value="N" />'
                                                    + '<input type="hidden" name="contractPartyFscCode" value="" />'
                                                    + '<input type="hidden" name="contractPartyType" value="" />'
                                                    + '<input type="text" name="contractPartyName" style="width:500px;" maxlength="45" value="" onblur="lp_updContractCompany(this);" />';

                        if(lo_internalUser.value=="R"){
                            lv_strNode2 = lv_strNode2 + '<input type="hidden" name="recStatus" value="" />'
                                                      + '<input type="hidden" name="recStatusDesc" value="" />'
                        }else{
                            lv_strNode2 = lv_strNode2 + '<input type="hidden" name="recStatus" value="P" />'
                        }
                        newNodeTd2.innerHTML        = lv_strNode2;

                        if(lo_internalUser.value=="R"){
                            newNodeTd3.style.width      = "20%";
                            newNodeTd3.style.height     = "30px";
                            newNodeTd3.align            = "center";
                            newNodeTd3.valign           = "middle";
                            newNodeTd3.style.position   = "relative";
                            newNodeTd3.innerHTML        = '<div style="position:absolute;top:1px;left:2px;">'
                                                            + '<A name="delBtn" class="" href="javascript:void(0)" onclick="lp_delContractCompany(this);" >'
                                                                + '<IMG border="0" alt="Delete" src="' + lo_contextPath.value + '/images/btnClose.gif" width="16" height="16">'
                                                            + '</A>';
                                                        + '</div>';
                        }else{
                            //Record status
                            newNodeTd3.style.width      = "10%";
                            newNodeTd3.style.height     = "30px";
                            newNodeTd3.align            = "center";
                            newNodeTd3.valign           = "middle";
                            newNodeTd3.style.position   = "relative";
                            newNodeTd3.innerHTML        = '<input type="text" style="TEXT-ALIGN:center;WIDTH:150px;" disabled value="New" name="recStatusDesc" />';

                            //Delete button
                            newNodeTd4.style.width      = "10%";
                            newNodeTd4.style.height     = "30px";
                            newNodeTd4.align            = "center";
                            newNodeTd4.valign           = "middle";
                            newNodeTd4.style.position   = "relative";
                            newNodeTd4.innerHTML        = '<div style="position:absolute;top:1px;left:2px;">'
                                                            + '<A name="delBtn" class="" href="javascript:void(0)" onclick="lp_delContractCompany(this);" >'
                                                                + '<IMG border="0" alt="Delete" src="' + lo_contextPath.value + '/images/btnClose.gif" width="16" height="16">'
                                                            + '</A>';
                                                        + '</div>';
                        }

                        lo_maxPkPortPairSeq.value = lv_maxSeq;

                        showBarMessage("Ready", 2);
                    }else{
                    	showBarMessageNew(data, MSG_ERROR_CODE);
                    }
                }
            });

        }catch(err){
            handleJavaScriptError('lp_addContractCompany', err, 0);
        }
    }
    /*End @01*/

    /*Begin @01*/
    function lp_updContractCompany(ao_obj){

        var lv_rowIndex                 = 0;
        var la_pkPortPairSeq            = null;
        var la_fkContractPartyCode      = null;
        var la_contractPartyName        = null;
        var la_approveFlag              = null;
        var la_contractPartyFscCode     = null;
        var la_contractPartyType        = null;
        var lv_approveFlag              = null;
        var lo_internalUser             = null;

        try{
//            lv_rowIndex                 = gp_rowTableIndex(ao_obj) - 1;
            la_pkPortPairSeq            = document.getElementsByName("pkPortPairSeq");
            la_fkContractPartyCode      = document.getElementsByName("fkContractPartyCode");
            la_contractPartyName        = document.getElementsByName("contractPartyName");
            la_approveFlag              = document.getElementsByName("approveFlag");
            la_contractPartyFscCode     = document.getElementsByName("contractPartyFscCode");
            la_contractPartyType        = document.getElementsByName("contractPartyType");
            lo_internalUser             = document.getElementById("internalUser");

            if(lo_internalUser.value == 'RR'){
                lv_rowIndex    = ao_obj;
                if(la_approveFlag[lv_rowIndex].checked==true){
                    lv_approveFlag = "Y";
                }else{
                    lv_approveFlag = "N";
                }
                customerControlForContractParty();
            }else if(lo_internalUser.value == 'R'){
                lv_rowIndex    = gp_rowTableIndex(ao_obj) - 1;
                lv_approveFlag = la_approveFlag[lv_rowIndex].value;
            }else{
                lv_rowIndex    = gp_rowTableIndex(ao_obj) - 1;
                lv_approveFlag = la_approveFlag[lv_rowIndex].value;
            }

            var postVal     = "pkPortPairSeq="          + la_pkPortPairSeq[lv_rowIndex].value
                            + "&fkContractPartyCode="   + la_fkContractPartyCode[lv_rowIndex].value
                            + "&contractPartyName="     + gp_sanitizeURLString(la_contractPartyName[lv_rowIndex].value)
                            + "&approveFlag="           + lv_approveFlag
                            + "&contractPartyFscCode="  + la_contractPartyFscCode[lv_rowIndex].value
                            + "&contractPartyType="     + la_contractPartyType[lv_rowIndex].value ;
            $.ajax({
                type: "POST",
                url: UPD_CONTRACT_COMPANY,
                data: postVal,
                beforeSend: showBarMessage("Loading...", 2),
                success: function(data){
                    if(gp_trim(data)=="OK"){

                        showBarMessage("Ready", 2);
                    }else{
                    	showBarMessageNew(data, MSG_ERROR_CODE);
                    }
                }
            });
        }catch(err){
            handleJavaScriptError('lp_updContractCompany', err, 0);
        }
    }
    /*End @01*/

    /*Begin @01*/
    function lp_delContractCompany(ao_obj){

        var lv_rowIndex                 = 0;
        var la_pkPortPairSeq            = null;
        var lo_contractPartyTab         = null;
        var lo_rowTr                    = 0;

        try{

            if(ao_obj.className=="delBtnDisabled") return;

            lv_rowIndex                 = gp_rowTableIndex(ao_obj) - 1;
            lo_rowTr                    = gp_rowTableObj(ao_obj);
            la_pkPortPairSeq            = document.getElementsByName("pkPortPairSeq");
            lo_contractPartyTab         = document.getElementById("contractPartyTab");

            var postVal     = "pkPortPairSeq=" + la_pkPortPairSeq[lv_rowIndex].value;
            $.ajax({
                type: "POST",
                url: DEL_CONTRACT_COMPANY,
                data: postVal,
                beforeSend: showBarMessage("Loading...", 2),
                success: function(data){
                    if(gp_trim(data)=="OK"){
//                        lo_contractPartyTab.childNodes[0].removeChild(lo_rowTr);
                        lo_contractPartyTab.deleteRow(gp_rowTableIndex(ao_obj));
                        showBarMessage("Ready", 2);
                    }else{
                    	showBarMessageNew(data, MSG_ERROR_CODE);
                    }
                }
            });
        }catch(err){
            handleJavaScriptError('lp_delContractCompany', err, 0);
        }
    }
    /*End @01*/

    /*Begin @01*/
    function lp_chkRepresentedCompanyFlag(){

        var lo_representedCompanyFlag   = null;
        var la_contractPartyName        = null;
        var la_delBtn                   = null;
        var lo_btnAddContractCompany    = null;
        var lo_internalUser             = null;
        var lo_mresTable                = null;
        var la_statusFlag               = null;

        try{
            lo_internalUser             = document.getElementById("internalUser");

            if(lo_internalUser!=null && lo_internalUser.value!=""){
                if(lo_internalUser.value == 'RR'){
                    lo_representedCompanyFlag   = document.getElementById("representedCompanyFlag");
                    if(lo_representedCompanyFlag.checked==true){
                        customerControlForContractParty();
                    }
                }else if(lo_internalUser.value == 'R'){
                    lo_representedCompanyFlag   = document.getElementById("representedCompanyFlag");
                    lo_btnAddContractCompany    = document.getElementById("btnAddContractCompany");
                    la_contractPartyName        = document.getElementsByName("contractPartyName");
                    la_delBtn                   = document.getElementsByName("delBtn");

                    if(lo_representedCompanyFlag != null && lo_representedCompanyFlag.checked==true){
                    	showBarMessageNew('Pls fill details in Contract Party company section.', MSG_ERROR_CODE);
                        lo_btnAddContractCompany.removeAttribute("disabled");
                        lo_btnAddContractCompany.onclick = function() {lp_addContractCompany();};
                    }else{
                        showBarMessage('Ready', 0);
                        lo_btnAddContractCompany.setAttribute("disabled","true");
                        lo_btnAddContractCompany.onclick = function() {return false;};
                    }

                    gp_refreshObj(lo_btnAddContractCompany);

                    for(var i=0;i<la_contractPartyName.length;i++){
                        if(lo_representedCompanyFlag != null && lo_representedCompanyFlag.checked==true){
//                            la_contractPartyName[i].disabled    = false;
                            la_contractPartyName[i].removeAttribute("disabled");
                            la_delBtn[i].className              = "";
                        }else{
//                            la_contractPartyName[i].disabled    = true;
                            la_contractPartyName[i].setAttribute("disabled","true");
                            la_delBtn[i].className              = "delBtnDisabled";
                        }
                    }
                }else{
                    lo_representedCompanyFlag   = document.getElementById("representedCompanyFlag");
                    lo_btnAddContractCompany    = document.getElementById("btnAddContractCompany");
                    lo_mresTable                = document.getElementById("mresTable");
                    la_statusFlag               = document.getElementsByName("statusFlag");
                    la_contractPartyName        = document.getElementsByName("contractPartyName");

                    if(lo_representedCompanyFlag != null && lo_representedCompanyFlag.checked==true){
//                        lo_btnAddContractCompany.disabled   = false;
                        lo_btnAddContractCompany.removeAttribute("disabled");
                        lo_mresTable.style.display          = "inline";

                        for(var i=0;i<la_contractPartyName.length;i++){
                            if(la_statusFlag[i].value=="ADD"){
//                                la_contractPartyName[i].disabled = false;
                                la_contractPartyName[i].removeAttribute("disabled");
                            }
                        }

                    }else{
//                        lo_btnAddContractCompany.disabled   = true;
                        lo_btnAddContractCompany.setAttribute("disabled","true");
                        lo_mresTable.style.display          = "none";
                    }
                }
            }else{
                alert("else");
            }

        }catch(err){
            handleJavaScriptError('lp_chkRepresentedCompanyFlag', err, 0);
        }
    }
    /*End @01*/

function accountControl(){
    var internalUser = document.getElementsByName('internalUser');
    var oldPassword = null;
    var pwdSpan = document.getElementById('pwdSpan');
    var repeatPwdSpan = document.getElementById('repeatPwdSpan');
    var oldPwdSpanDisplay = 'none';
    var pwdSpanDisplay = 'none';
    try{
        if(internalUser[0].value == 'R'){
            pwdSpan.style.display = 'inline';
            repeatPwdSpan.style.display = 'inline';
        }else if(internalUser[0].value == 'MA'){
            oldPassword = document.getElementsByName('oldPassword')[0];
            if(!isNullObj(oldPassword) && !isBlank(oldPassword.value)){
                pwdSpan.style.display = 'inline';
                repeatPwdSpan.style.display = 'inline';
            }else{
                pwdSpan.style.display = 'none';
                repeatPwdSpan.style.display = 'none';
            }
        }
    }catch(err){
        handleJavaScriptError('accountControl', err, '');
    }
}

function companyControl(){
	debugger;
    var internalUser = document.getElementsByName('internalUser');
    var txtCompanyName = document.getElementsByName('userInfoMod.cmpName')[0];
    var txtCity = document.getElementsByName('userInfoMod.city')[0];
    var txtCountry = document.getElementsByName('userInfoMod.country')[0];

    var isReadOnly = true;
    try{
       /* error_code = 1;
        if(internalUser[0].value == 'R'){*/
            isReadOnly = false;
        /*}*/
    }catch(err){
        handleJavaScriptError('companyControl', err, error_code);
    }finally{
        if (txtCompanyName != undefined){
            txtCompanyName.readOnly = isReadOnly;
        }
//        txtCity.readOnly = isReadOnly;
//        txtCountry.disabled = isReadOnly;
    }
}

function customerControl(){
    var customerCode                    = document.getElementsByName('customerCode');
    var customerFscCode                 = document.getElementsByName('customerFscCode');
    var customerType                    = document.getElementsByName('customerType');
    var createCRMCustBtn                = document.getElementById('createCRMCustBtn');
    var createCRMCustDisabledBtn        = document.getElementById('createCRMCustDisabledBtn');
    var btnBrowseCutsomerType           = document.getElementById('btnBrowseCutsomerType');
    var btnBrowseCutsomerTypeDisabled   = document.getElementById('btnBrowseCutsomerTypeDisabled');
//    var crmCustBtnDisplay               = 'none';
//    var crmCustDisabledBtnDisplay       = 'inline';
    var crmCustBtnDisplay               = 'hidden';
    var crmCustDisabledBtnDisplay       = 'visible';
    var readOnly                        = true;
    var btnClass                        = CLASS_NAME_DISABLED_BUTTON;

    try{
        error_code = 1;
        if(!isNullObj(customerCode[0]) && !isNullObj(customerCode[0].value)){
            error_code = 2;
            if(isBlank(customerCode[0].value)){
                error_code = 3;
                btnClass                    = CLASS_NAME_BUTTON;
                crmCustBtnDisplay           = 'visible';
                crmCustDisabledBtnDisplay   = 'hidden';
                readOnly                    = false;
            }
        }
        error_code = 10;
//        createCRMCustBtn.className = btnClass;
//        error_code = 11;
        customerFscCode[0].readOnly                     = true;
        error_code = 12;
        customerType[0].readOnly                        = true;
        error_code = 13;
//        createCRMCustBtn.style.display                  = crmCustBtnDisplay;
//        createCRMCustDisabledBtn.style.display          = crmCustDisabledBtnDisplay;
//        btnBrowseCutsomerType.style.display             = 'inline';
//        btnBrowseCutsomerTypeDisabled.style.display     = 'none';
        createCRMCustBtn.style.visibility                  = crmCustBtnDisplay;
        createCRMCustDisabledBtn.style.visibility          = crmCustDisabledBtnDisplay;
        btnBrowseCutsomerType.style.visibility             = 'visible';
        btnBrowseCutsomerTypeDisabled.style.visibility     = 'hidden';
    }catch(err){
        handleJavaScriptError('customerControl', err, error_code);
    }
}

/*Begin @01*/
function customerControlForContractParty(){
    var la_fkContractPartyCode                      = document.getElementsByName('fkContractPartyCode');
    var la_createCRMCustBtnForContractParty         = document.getElementsByName('createCRMCustBtnForContractParty');

    try{
        for(var i=0;i<la_fkContractPartyCode.length;i++){
            if(la_fkContractPartyCode[i].value==""){
                la_createCRMCustBtnForContractParty[i].disabled = false;
            }else{
                la_createCRMCustBtnForContractParty[i].disabled = true;
            }
        }
    }catch(err){
        handleJavaScriptError('customerControlForContractParty', err, 0);
    }
}
/*End @01*/

/*Begin @01*/
function openLookupForContractParty(prmFormName, prmRowId, prmMasterId, prmRowIndex){
    setErrorFlag();
    var screenWidth     = 800;
    var screenHeight    = 500;
    var x               = aw>800?(aw-screenWidth)/2:0;
    var y               = ah>600?(ah-screenHeight)/2:0;
    var winName         = prmFormName;
    var urlString       = '?prmFormName='+prmFormName+'&prmRowId='+prmRowId+'&prmMasterId='+prmMasterId+'&prmValues=' + "&prmRowIndex=" + prmRowIndex;
    var objWindow       = window.open(secm002Url+urlString,winName,'width='+screenWidth+',height=' + screenHeight + ',left=' + x + ',top=' + y + 'resizable=no,scrollbars=no,toolbar=no,titlebar=yes',false);

     try{
        /* start added for closing all child windows */
        V           = new Object();
        V.name      = winName;
        V.window    = objWindow;
        arrChilds[arrChilds.length] = V;
        /* end added for closing all child windows */

        objWindow.focus();
    }catch(err){
        handleJavaScriptError('openLookupForContractParty', err, 0);
    }
}
/*End @01*/

/*Begin @01*/
function setLookupValuesForContractParty(formName, pRowId, masterId, resultData, rowIndex){
    var fscCode = document.getElementsByName('contractPartyFscCode');

    try{
        if(!isNullObj(resultData) && resultData.length > 0){
            for(var countIndex=0, length=resultData.length; countIndex<length; countIndex++){
                fscCode[rowIndex].value = resultData[countIndex]; //Get Code from array 0.
                lp_updContractCompany(rowIndex);
                break;
            }
        }
    }catch(err){
        handleJavaScriptError('setLookupValuesForContractParty', err, error_code);
    }
}
/*End @01*/

function serviceRequestControl(){
    var sfuObj = document.getElementsByName('sfu');
    var sfuCode = document.getElementsByName('sfuCode');
    var serviceChecked = document.getElementsByName('checked');
    var sfuLength = 0;
    var esiIndex = -1;
    var isESVChecked = false;
    try{
        error_code = 1;
        if(!isNullObj(sfuObj) && !isNullObj(sfuObj.length)){
            error_code = 2;
            sfuLength = sfuObj.length;
            error_code = 3;
            for(var countIndex=0; countIndex<sfuLength; countIndex++){
                if(sfuCode[countIndex].value == SERVICE_CODE_ESI){
                    esiIndex = countIndex;
                }
                if(serviceChecked[countIndex].value == 'true'){
                    if(sfuCode[countIndex].value == SERVICE_CODE_ESV){
                        isESVChecked = true;
                    }
                    sfuObj[countIndex].checked = true;
                }else{
                    sfuObj[countIndex].checked = false;
                }
            }
            if(esiIndex >= 0){
                if(isESVChecked){
                    sfuObj[esiIndex].disabled = false;
                }else{
                    sfuObj[esiIndex].disabled = true;
                    sfuObj[esiIndex].checked = false;
                    serviceChecked[esiIndex].value = 'false';
                }
            }
        }
        error_code = 5;
    }catch(err){
        handleJavaScriptError('serviceRequestControl', err, error_code);
    }
}

function onServiceChecked(rowIndexChecked){
	debugger;
    var sfuObj = document.getElementsByName('sfu');
    var sfuCode = document.getElementsByName('sfuCode');
    var serviceChecked = document.getElementsByName('checked');
    try{
        if(!isNullObj(sfuObj) && (rowIndexChecked < sfuObj.length)){
//            alert('sfuObj checked = '+sfuObj[rowIndexChecked].checked+'\nsfuObj value = '+sfuObj[rowIndexChecked].value);
            if(sfuObj[rowIndexChecked].checked){
                serviceChecked[rowIndexChecked].value = 'true';
            }else{
                serviceChecked[rowIndexChecked].value = 'false';
            }

            serviceRequestControl();
        }
    }catch(err){
        handleJavaScriptError('serviceRequestControl', err, error_code);
    }
}

function clearUserIdParam(){
	debugger;
    var userId = document.getElementsByName('userInfoMod.userId')[0];
    userId.style.backgroundColor = '#FFFFFF';

    var checkResultMessage = document.getElementById('checkResultMessage');
    checkResultMessage.innerHTML = '';

    userIdPassed = "false";
    debugger;
    userIdChecked = "false";
}

function backHome(){
    loading();
    window.location = 'http://www.rclgroup.com';
}

function refreshCaptcha() {
    var url = GENERATE_CAPTCHA;
    var captchaKey = document.getElementById('captchaKey');
    try{
        error_code = 1;
        captchaKey.innerHTML = '<img src="'+GENERATE_CAPTCHA+'" style="width: 290px; height: 70px; border: 1px solid #000000; margin:10px"  />';
        error_code = 2;
    }catch(err){
        handleJavaScriptError('refreshCaptcha', err, error_code);
    }
}

function callbackToFieldCaptcha()
{
    var respTxt = null;
    var captchaKey = document.getElementById('captchaKey');
    try{
        error_code = 1;
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            error_code = 2;
            respTxt = xmlhttp.responseXML;
            alert("respTxt");
            error_code = 3;
//            captchaKey.innerHTML = '<img src="data:image/jpeg;base64,'+xmlhttp.responseText+'" style="width: 290px; height: 70px; border: 1px solid #000000; margin:10px"  />';
            captchaKey.innerHTML = '<img src="'+GENERATE_CAPTCHA+'" style="width: 290px; height: 70px; border: 1px solid #000000; margin:10px"  />';
            runPage1();
            error_code = 8;
            clearMsg();
            error_code = 9;
        }
        error_code = 10;
    }catch(err){
        handleJavaScriptError('callbackToFieldCaptcha', err, error_code);
        runPage1();
    }
}

function checkAvailableUserId() {
	debugger;
    var txtUserId = document.getElementsByName("userInfoMod.userId")[0];
    try{
        error_code = 1;
        if(validateUserId(txtUserId)){
            error_code = 2;
            // teerakan add 19/07/2013
            //loading();
            error_code = 3;
            var url = CHECK_AVAILABLE_USER_ID+'?userId='+gp_sanitizeURLString(gp_trim(txtUserId.value));
            error_code = 4;
            xmlhttp.onreadystatechange=callbackToFieldUserId;
            error_code = 5;
            xmlhttp.open("GET", url, true);
            error_code = 6;
            xmlhttp.send(null);
            error_code = 7;
        }
    }catch(err){
        unloading();
        handleJavaScriptError('checkAvaliableUserId', err, error_code);
    }

} // checkQuotationNo

function checkCustomerCode(obj) {

	debugger;
	console.log(obj);
	
	 
	var url = CHECK_CUSTOMER_CODE + "?customerCode=" + $("#inputcustomerCode").val()+"&emailId="+$("#userInfoMod_email").val();
	$.ajax({

		url: url,
		success: function(customerIdChecked) {
			debugger;
			 
			if (customerIdChecked == 'false') {
			    showBarMessageNew("Customer code not found ,Please contact your sales person to get the customer code.");	
				$("#inputcustomerCode").css({
					"border-color": "#ffb3b3"
				}).on('input', function() {
					$('#inputcustomerCode').css({ "border-color": "#ffffff" });
				});
				$("#inputcustomerCode").val("");
			} else if(customerIdChecked=="mismatch"){				
				showBarMessageNew("Please enter the correct domain name in email or Please contact your sales person for domain name ");	
				$("#inputcustomerCode").css({
					"border-color": "#ffb3b3"
				}).on('input', function() {
					$('#inputcustomerCode').css({ "border-color": "#ffffff" });
				});
				$("#inputcustomerCode").val("");
				
			}else {
					$("#inputcustomerCode").css({
					"border-color": "#green"
				});
				/*.on('change', function() {
					$('#inputcustomerCode').css({ "border-color": "green" });
				});
					*/
				showBarMessageNew("");
				$("#alertId").hide();
			}
		}, error: function(error) {
			alert('error');
		}

	});
}

function callbackToFieldUserId()
{
	debugger;
    var respTxt                 = null;
    var userId                  = document.getElementsByName('userInfoMod.userId')[0];
    var checkResultMessage      = document.getElementById('checkResultMessage');
    debugger;
    var userIdCheckedObj        = document.getElementById('userIdChecked');
    var userIdPassedObj         = document.getElementById('userIdPassed');
    try{
        error_code = 1;
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            error_code      = 2;
            userIdChecked   = "true";
            respTxt         = xmlhttp.responseText;
            error_code      = 3;
            if(respTxt != null && respTxt != undefined && respTxt != ''){
                error_code                      = 4;
                userId.style.backgroundColor    = '#ff7c7c';
                checkResultMessage.style.color  = '#FF0000';
                checkResultMessage.innerHTML    = respTxt;

                userIdPassed                    = "false";
            }else{
                error_code                          = 5;
                userId.style.backgroundColor        = '#FFFFFF';
                checkResultMessage.style.color      = '#00c400';
                checkResultMessage.style.fontWeight = 'bold';
                checkResultMessage.style.fontSize   = '11';
                checkResultMessage.innerHTML        = 'Available';
                userIdPassed                        = "true";
            }
            error_code = 6;
            userIdCheckedObj.value = userIdChecked;
            userIdPassedObj.value = userIdPassed;
            error_code = 7;
            runPage1();
            error_code = 8;
            clearMsg();
            error_code = 9;
        }
        error_code = 10;
    }catch(err){
        unloading();
        handleJavaScriptError('callbackToFieldUserId', err, error_code);
    }
}

function homeClicked(){
    window.close();

    var messageTdParent = parent.opener.document.getElementById("msg");
    messageTdParent.innerHTML = MSG_LOADING;

    parent.opener.location.href = 'http://www.rclgroup.com';
}

function openAnnouncement(contextPath, name, announceType){
    var title = null;
    var spec = null;
    var popupWidth = 'width=920';
    var popupHeight = 'height=620';
    var url = contextPath+'/pages/eservice/';
    switch(announceType){
        case ANNOUNCE_TYPE_TERM_OF_USE :
            url += 'EserviceRegistrationTermOfUse.jsp';
            //title = 'Term Of Use';
            //popupHeight += '470';
            break;
        case ANNOUNCE_TYPE_PRIVACY_POLICY :
            url += 'EserviceRegistrationPrivacyPolicy.jsp';
            //title = 'Privacy Policy';
            //popupHeight += '400';
            break;
    }
    //alert('url = '+url);
    spec = popupWidth+', '+popupHeight;
    //alert('url = '+url+'\ntitle='+title+'\nspec = '+spec);
    window.open(url, name, spec);
}

function openCustomerData(){
	debugger;
    var userIdObj       = document.getElementsByName('userInfoMod.userId');
//    var fscCodeObj = document.getElementsByName('customerFscCode');
    var controlFscObj   = document.getElementsByName('controlFsc');
    var fscCodeObj      = document.getElementsByName('fscCode');
    var countryObj      = document.getElementsByName('userInfoMod.country');
    var userId          = null;
    var fscCode         = null;
    var controlFsc      = null;
    var popup           = null;
    var country         = null;

    var url = BROWSE_CUSTOMER_DATA;
    try{
        error_code = 1;
        if(isNullObj(userIdObj) || isNullObj(userIdObj[0]) || isNullObj(userIdObj[0].value)){
            userId = BLANK;
        }else{
            userId = userIdObj[0].value;
        }
        error_code = 2;
        if(isNullObj(fscCodeObj) || isNullObj(fscCodeObj[0]) || isNullObj(fscCodeObj[0].value)){
            fscCode = BLANK;
        }else{
            fscCode = fscCodeObj[0].value;
        }
        error_code = 3;
        if(isNullObj(controlFscObj) || isNullObj(controlFscObj[0]) || isNullObj(controlFscObj[0].value)){
            controlFsc = 'N';
        }else{
            controlFsc = controlFscObj[0].value;
        }

        if(isNullObj(countryObj) || isNullObj(countryObj[0]) || isNullObj(countryObj[0].value)){
            country = BLANK;
        }else{
            country = countryObj[0].value;
        }

        error_code = 4;
        url += '?userId='+userId;
        url += '&fscCode='+fscCode;
        url += '&controlFsc='+controlFsc;
        url += '&country='+country;
        error_code = 5;
    //alert(screen.width+" "+screen.height);
//        popup = window.open(url, 'HelpWindow', 'width='+800+', height='+600+', resizable=yes, scrollbars=yes, toolbar=no');
        //openHelpList(url, screen.width, screen.height);
        var w = window.open(url, 'HelpWindow', 'width='+screen.width+', height='+screen.height+', resizable=no, scrollbars=no, toolbar=no');
        w.focus();
        error_code = 6;
    }catch(err){
        handleJavaScriptError('openCustomerData', err, error_code);
    }
}

/*Begin @01*/
function openCustomerDataForContractParty(av_rowIndex){
    var userIdObj               = document.getElementsByName('userInfoMod.userId');
    var fscCodeObj              = document.getElementsByName('contractPartyFscCode');
    var userId                  = null;
    var fscCode                 = null;
    var popup                   = null;
    var country                 = null;
    var url                     = BROWSE_CUSTOMER_DATA;

    try{
        error_code = 1;
        if(isNullObj(userIdObj) || isNullObj(userIdObj[0]) || isNullObj(userIdObj[0].value)){
            userId = BLANK;
        }else{
            userId = userIdObj[0].value;
        }

        fscCode = fscCodeObj[av_rowIndex].value;

        url += '?userId='       + userId;
        url += '&fscCode='      + fscCode;
        url += '&controlFsc=N';
        url += '&rowIndex='     + av_rowIndex;

        var w = window.open(url, 'HelpWindow', 'width='+screen.width+', height='+screen.height+', resizable=no, scrollbars=no, toolbar=no');
        w.focus();
        error_code = 6;
    }catch(err){
        handleJavaScriptError('openCustomerDataForContractParty', err, error_code);
    }
}
/*End @01*/

/*Begin @01*/
function setCustomerDataForContractParty(customerCode, customerName, fscCode, customerType, rowIndex){
    var la_fkContractPartyCode      = document.getElementsByName('fkContractPartyCode');
    var la_fscCodeObj               = document.getElementsByName('contractPartyFscCode');
    var la_contractPartyTypeObj     = document.getElementsByName('contractPartyType');

    try{

        la_fkContractPartyCode[rowIndex].value  = customerCode.toUpperCase();
        la_fscCodeObj[rowIndex].value           = fscCode.toUpperCase();
        la_contractPartyTypeObj[rowIndex].value = customerType.toUpperCase();

        lp_updContractCompany(rowIndex);


    }catch(err){
        handleJavaScriptError('setCustomerDataForContractParty', err, 0);
    }
}
/*End @01*/

/*Begin @01*/
function openCustomerTypeDataForContractParty(av_rowIndex){
    var url = BROWSE_CUSTOMER_TYPE_DATA + "?rowIndex=" + av_rowIndex;
    try{
        openHelpList(url, 1000, 410);
    }catch(err){
        handleJavaScriptError('openCustomerTypeDataForContractParty', err, 0);
    }
}
/*End @01*/

/*Begin @01*/
function setCustomerTypeDataForContractParty(customerType, description, organizationType, status, av_rowIndex){
    var la_contractPartyType = document.getElementsByName('contractPartyType');

    try{
        la_contractPartyType[av_rowIndex].value = customerType;
        lp_updContractCompany(av_rowIndex);
    }catch(err){
        handleJavaScriptError('setCustomerTypeDataForContractParty', err, 0);
    }
}
/*End @01*/

function setCustomerData(customerCode, customerName, customerFscCode, customerType){
    var isInternalUser      = document.getElementsByName('isInternalUser');
    var customerCodeObj     = document.getElementsByName('customerCode');
    var customerFscCodeObj  = document.getElementsByName('customerFscCode');
    var customerTypeObj     = document.getElementsByName('customerType');

    try{
        error_code = 1;
        if(isNullObj(customerCode) || isBlank(customerCode)){
            customerCodeObj[0].value = BLANK;
        }else{
            customerCodeObj[0].value = customerCode.toUpperCase();
        }
        error_code = 2;
        if(isNullObj(customerFscCode) || isBlank(customerFscCode)){
            customerFscCodeObj[0].value = BLANK;
        }else{
            customerFscCodeObj[0].value = customerFscCode.toUpperCase();
        }

        if(isNullObj(customerType) || isBlank(customerType)){
            customerFscCodeObj[0].value = BLANK;
        }else{
            customerTypeObj[0].value = customerType.toUpperCase();
        }

//        error_code = 3;
//        customerCodeObj[0].value = customerCode.toUpperCase();
//        customerFscCodeObj[0].value = customerFscCode.toUpperCase();
//        error_code = 4;
        if(!isNullObj(isInternalUser) && !isNullObj(isInternalUser[0]) && !isNullObj(isInternalUser[0].value)){
            if(isInternalUser[0].value == 'true'){
                customerControl();
            }
        }
        error_code = 5;
    }catch(err){
        handleJavaScriptError('setCustomerData', err, error_code);
    }
}
function openCustomerTypeData(){
    var url = BROWSE_CUSTOMER_TYPE_DATA;
    try{
        openHelpList(url, 1000, 410);
    }catch(err){
        handleJavaScriptError('openCustomerTypeData', err, error_code);
    }
}
function setCustomerTypeData(customerType, description, organizationType, status){
    var isInternalUser = document.getElementsByName('isInternalUser');
    var customerTypeObj = document.getElementsByName('customerType');
//    var customerFscCodeObj = document.getElementsByName('customerFscCode');
    try{
        error_code = 1;
        if(isNullObj(customerType) || isBlank(customerType)){
            customerType = BLANK;
        }
        error_code = 2;
        customerTypeObj[0].value = customerType;
        error_code = 3;
    }catch(err){
        handleJavaScriptError('setCustomerTypeData', err, error_code);
    }
}

function createCRMCustomer(){
    var fscCode = document.getElementsByName('customerFscCode');
    var customerType = document.getElementsByName('customerType');

    var url = CREATE_CRM_CUSTOMER;
    var errorMsg = null;
    try{
        error_code = 1;
        if(isNullObj(fscCode[0]) || isNullObj(fscCode[0].value) || isBlank(fscCode[0].value)){
            error_code = 2;
            errorMsg = 'Please specific fsc code.';
            fscCode[0].focus();
        }else if(isNullObj(customerType[0]) || isNullObj(customerType[0].value) || isBlank(customerType[0].value)){
            error_code = 3;
            errorMsg = 'Please specific customer type.';
            customerType[0].focus();
        }else{
            error_code = 4;
            loading();
            error_code = 5;
            document.forms[0].action = url;
            document.forms[0].submit();
        }
        error_code = 5;
    }catch(err){
        errorMsg = err.message;
        handleJavaScriptError('createCRMCustomer', err, error_code);
    }finally{
        if(!isNullObj(errorMsg) && !isBlank(errorMsg)){
        	showBarMessageNew(errorMsg, MSG_ERROR_CODE);
        }
    }
}

/*Begin @01*/
function createCRMCustomerForContractParty(av_rowIndex){
    var la_contractPartyFscCode     = document.getElementsByName('contractPartyFscCode');
    var la_contractPartyName        = document.getElementsByName('contractPartyName');
    var la_contractPartyType        = document.getElementsByName('contractPartyType');
    var la_fkContractPartyCode      = document.getElementsByName("fkContractPartyCode");
    var la_dataReturn               = null;

    try{

        if(gp_trim(la_contractPartyFscCode[av_rowIndex].value)==""){
        	showBarMessageNew(ESR_SE0031, MSG_ERROR_CODE, new Array((av_rowIndex + 1), 'fsc code'));
            return;
        }

        if(gp_trim(la_contractPartyType[av_rowIndex].value)==""){
        	showBarMessageNew(ESR_SE0031, MSG_ERROR_CODE, new Array((av_rowIndex + 1), 'customer type'));
            return;
        }

        var postVal     = "contractPartyFscCode="   + gp_trim(la_contractPartyFscCode[av_rowIndex].value)
                        + "&contractPartyType="     + gp_trim(la_contractPartyType[av_rowIndex].value)
                        + "&contractPartyName="     + gp_sanitizeURLString(la_contractPartyName[av_rowIndex].value);
        $.ajax({
            type: "POST",
            url: CREATE_CRM_FOR_CONTRACT_PARTY,
            data: postVal,
            beforeSend: loading(),
            success: function(data){
                unloading();
                la_dataReturn = data.split("::");

                if(gp_trim(la_dataReturn[0])=="OK"){
                    showBarMessage("Ready", 2);

                    la_fkContractPartyCode[av_rowIndex].value = la_dataReturn[1];
                    lp_updContractCompany(av_rowIndex);

                }else{
                	showBarMessageNew(la_dataReturn[1], MSG_ERROR_CODE);
                }
            }
        });

    }catch(err){
        unloading();
        handleJavaScriptError('createCRMCustomerForContractParty', err, error_code);
    }
    
    
   } 
    
    
 function updateUserProfile(){
		debugger;
		isPassed=true;
		var allSFUChecked               = document.getElementsByName('allSFUChecked');
		
        if(isPassed){
            allSFUChecked[0].value = getAllSFUChecked();
			if(allSFUChecked[0].value==null  || allSFUChecked[0].value==""){
				isPassed=false;
				showBarMessageNew('Please select service request at least one.');
				return false;
			}
			loading();
			companyDetail();
			document.forms[0].submit();
		}
		
	}

/*End @01*/

function submitBtn(){
	debugger;
    var internalUser                = document.getElementsByName('internalUser');
    var allSFUChecked               = document.getElementsByName('allSFUChecked');
    //var captchaText = document.getElementsByName('captchaText');//P' Nim tel remove capcha 20140429 By Pound
    var url                         = REGISTRATION;
    var isPassed                    = false;
    /*Begin @01*/
    // var lo_representedCompanyFlag   = document.getElementById("representedCompanyFlag");//##02
    var lo_portPairFlag             = document.getElementById('portPairFlag');
    var lv_flag                     = "N";
    /*End @01*/
    
    // #05 START
    var nonRaAccount                = "N"; 
    
    /*if(internalUser[0].value == 'RR'){
        if (document.getElementById("nonRaAccount").checked == true){
            nonRaAccount                = "Y";
        }
    }
    */
    // #05 END

    try{
        clearMsg();
        error_code = 1;
        if(!isNullObj(internalUser) && !isNullObj(internalUser[0]) && !isBlank(internalUser[0].value)){
            error_code = 2;
//            alert(internalUser[0].value);return;
            if(internalUser[0].value == 'RR'){
                error_code = 3;
                isPassed = validationInternalUserSubmit();
            }else{
                error_code = 4;
                isPassed = validationExternalUserSubmit();
            }
        }else{
            error_code = 5;
            isPassed = validationExternalUserSubmit();
        }
        error_code = 6;
        if(isPassed){
            loading();

            allSFUChecked[0].value = getAllSFUChecked();

            //Begin P' Nim tel remove capcha 20140429 By Pound
            /*if(internalUser[0].value == 'R'){
                url += '?captcha='+captchaText[0].value;
            }*/
            //End P' Nim tel remove capcha 20140429 By Pound

            /*Begin @01*/
            //##02 Begin
            /* if(lo_representedCompanyFlag.checked==true){
                lv_flag = "Y";
            }else{ */
            //##02 End
                lv_flag = "N";
            // } //##02
            /*End @01*/

//            if(lo_portPairFlag.value=="Y"){
            if(internalUser[0].value == 'RR'){
                // if(confirm('Do you want to REJECT/APPROVE the request Contract Party Company representative ?')){
            	document.forms[0].action = url + "?representedCompanyFlag=" + lv_flag + "&portPairFlag=" + lo_portPairFlag.value + "&nonRaAccount=" + nonRaAccount;  // #05 EDIT
                    document.forms[0].submit();
                // }else{
                //     unloading();
                // }
            }else{
            	document.forms[0].action = url + "?representedCompanyFlag=" + lv_flag + "&portPairFlag=" + lo_portPairFlag.value  + "&nonRaAccount=" + nonRaAccount;    // #05 EDIT
                document.forms[0].submit();
            }

//            document.forms[0].action = url + "?representedCompanyFlag=" + lv_flag + "&portPairFlag=" + lo_portPairFlag.value;
//            document.forms[0].submit();
        }
        error_code = 7;
    }catch(err){
        handleJavaScriptError('submitBtn', err, error_code);
        unloading();
    }
  }


function lp_upperCase(ao_val){
    ao_val.value =  ao_val.value.toUpperCase();
}

function getAllSFUChecked(){
    var sfu = document.getElementsByName('sfu');
    var allSFUChecked = null;
    var sfuLength = 0;
    try{
        error_code = 1;
        sfuLength = sfu.length;
        error_code = 2;
        for(var countIndex=0; countIndex<sfuLength; countIndex++){
            if(sfu[countIndex].checked){
                if(allSFUChecked == null){
                    allSFUChecked = countIndex;
                }else{
                    allSFUChecked += ','+countIndex;
                }
            }
        }
        error_code = 3;
    }catch(err){
        handleJavaScriptError('getAllSFUChecked', err, error_code);
    }
    return allSFUChecked;
}

function clearBtn(){
    var internalUser = document.getElementsByName('internalUser');
    try{
        error_code = 1;
        if(internalUser[0].value == 'RR'){
            error_code = 2;
            clearBtnInternalUser();
        }else{
            error_code = 3;
            clearBtnExternalUser();
        }
        error_code = 4;
    }catch(err){
        handleJavaScriptError('clearBtn', err, error_code);
    }
}

function rejectBtn(){
    var lo_rejectReason = document.getElementById("rejectReason");
    var url             = REJECTREASON;
    var allSFUChecked   = document.getElementsByName('allSFUChecked');

    try{
        error_code = 1;
        if(gp_trim(lo_rejectReason.value)==""){
        	showBarMessageNew("Please input Reject Reason",1);
            lo_rejectReason.focus();
        }else if(lo_rejectReason.value.length > 500){
        	showBarMessageNew("Reject Reason should not be over than 500 charecters",1);
            lo_rejectReason.focus();
        }else{
            loading();
            allSFUChecked[0].value      = getAllSFUChecked();
            document.forms[0].action    = url;

            document.forms[0].submit();
        }
        error_code = 2;
    }catch(err){
        handleJavaScriptError('rejectBtn', err, error_code);
        unloading();
    }
}

function imposeMaxLength(maxLen){
    var lo_element = window.event.srcElement;

  return (lo_element.value.length <= maxLen);
}

    /*Begin @01*/
    function clearBtnInternalUser(){
        var lo_customerCode                 = null;
        var lo_fscCode                      = null;
        var lo_customerType                 = null;
        // var lo_representedCompanyFlag       = null; //##02
        var lo_portPairFlag                 = null;
        var lo_internalUser                 = null;
        var la_fkContractPartyCode          = null;
        var la_contractPartyFscCode         = null;
        var la_contractPartyType            = null;

        try{

            lo_customerCode                 = document.getElementById('customerCode');
            lo_fscCode                      = document.getElementById('customerFscCode');
            lo_customerType                 = document.getElementById('customerType');
            // lo_representedCompanyFlag       = document.getElementById('representedCompanyFlag'); //##02
            lo_portPairFlag                 = document.getElementById('portPairFlag');
            lo_internalUser                 = document.getElementById("internalUser");
            la_fkContractPartyCode          = document.getElementsByName("fkContractPartyCode");
            la_contractPartyFscCode         = document.getElementsByName("contractPartyFscCode");
            la_contractPartyType            = document.getElementsByName("contractPartyType");

            if(lo_portPairFlag.value=="N"){
                lo_customerCode.value   = BLANK;
                lo_fscCode.value        = BLANK;
                lo_customerType.value   = BLANK;
                customerControl();
            }

            //##02 Begin
            /* if(lo_representedCompanyFlag.checked==true && lo_internalUser.value == "RR"){
                for(var i=0;i<la_fkContractPartyCode.length;i++){
                    la_fkContractPartyCode[i].value     = "";
                    la_contractPartyFscCode[i].value    = "";
                    la_contractPartyType[i].value       = "";
                }
                customerControlForContractParty();
            }*/
            //##02 End

        }catch(err){
            handleJavaScriptError('clearBtnInternalUser', err, error_code);
        }
    }
    /*End @01*/

/*function clearBtnInternalUser(){
    var customerCode = document.getElementsByName('customerCode');
    var fscCode = document.getElementsByName('customerFscCode');
    var customerType = document.getElementsByName('customerType');
    try{
        error_code = 1;
        customerCode[0].value = BLANK;
        error_code = 2;
        fscCode[0].value = BLANK;
        error_code = 3;
        customerType[0].value = BLANK;
        error_code = 4;
        customerControl();
        error_code = 5;
    }catch(err){
        handleJavaScriptError('clearBtnInternalUser', err, error_code);
    }
}*/

function setLookupValues(formName, pRowId, masterId,resultData){
    var fscCode = document.getElementsByName('customerFscCode');
    try{
        if(!isNullObj(fscCode) && !isNullObj(fscCode[0])){
            if(!isNullObj(resultData) && resultData.length > 0){
                for(var countIndex=0, length=resultData.length; countIndex<length; countIndex++){
                    fscCode[0].value = gp_trim(resultData[countIndex]); //Get Code from array 0.
                    break;
                }
            }
        }
    }catch(err){
        handleJavaScriptError('setLookupValues', err, error_code);
    }
}

function clearBtnExternalUser(){
	debugger;
    var txtFirstName = null;
    var txtLastName = null;
    var txtOldPassword = null;
    var txtUserName = null;

    var txtEmailAddress = document.getElementsByName('userInfoMod.email');
    var txtReEmailAddress = document.getElementsByName('reEmailAddress');
    var txtUserId = document.getElementsByName('userInfoMod.userId');
    var txtPassword = document.getElementsByName('password');
    var txtRePassword = document.getElementsByName('rePassword');
    var txtCompanyName = document.getElementsByName('userInfoMod.cmpName');
    var txtAddress1 = document.getElementsByName('userInfoMod.address1');
    var txtAddress2 = document.getElementsByName('userInfoMod.address2');
    var txtAddress3 = document.getElementsByName('userInfoMod.address3');
    var txtAddress4 = document.getElementsByName('userInfoMod.address4');
    var txtCity = document.getElementsByName('userInfoMod.city');
    var txtState = document.getElementsByName('userInfoMod.state');
    var txtCountry = document.getElementsByName('userInfoMod.country');
    var txtPhoneNo = document.getElementsByName('userInfoMod.phoneNo');
    var txtFaxNo = document.getElementsByName('userInfoMod.faxNo');
    var internalUser = document.getElementsByName('internalUser');
    var chkAccept = null
    try{
        if(internalUser[0].value == 'R'){
            txtFirstName = document.getElementsByName('firstName');
            txtLastName = document.getElementsByName('lastName');

            error_code = 1;
            txtFirstName[0].value = BLANK;
            error_code = 2;
            txtLastName[0].value = BLANK;
            error_code = 3;
            txtUserId[0].value = BLANK;
            error_code = 4;
            chkAccept = document.getElementsByName('chkAccept');
            chkAccept[0].checked = false;
        }else{
            error_code = 5;
            txtUserName = document.getElementsByName('userInfoMod.userName');
            error_code = 6;
            txtUserName[0].value = BLANK;
            error_code = 7;
            txtOldPassword = document.getElementsByName('oldPassword');
            error_code = 8;
            txtOldPassword[0].value = BLANK;
        }
        error_code = 9;
        txtEmailAddress[0].value = BLANK;
        error_code = 10;
        txtReEmailAddress[0].value = BLANK;
        error_code = 11;
        txtPassword[0].value = BLANK;
        error_code = 12;
        txtRePassword[0].value = BLANK;
        error_code = 13;

        //#04 Begin
        if(txtCompanyName[0].readOnly != true){
            txtCompanyName[0].value = BLANK;
        }
        //##04 End
        error_code = 14;
        txtAddress1[0].value = BLANK;
        error_code = 15;
        txtAddress2[0].value = BLANK;
        error_code = 16;
        txtAddress3[0].value = BLANK;
        error_code = 17;
        txtAddress4[0].value = BLANK;
        error_code = 18;
        txtCity[0].value = BLANK;
        error_code = 19;
        txtState[0].value = BLANK;
        error_code = 20;
        txtCountry[0].selectedIndex = 0;
        error_code = 21;
        txtPhoneNo[0].value = BLANK;
        error_code = 22;
        txtFaxNo[0].value = BLANK;
        error_code = 23;
        serviceRequestControl();
        error_code = 24;
    }catch(err){
        handleJavaScriptError('clearBtnExternalUser', err, error_code);
    }
}

function validationExternalUserSubmit(){
	debugger;
    var txtFirstName                = null;
    var txtLastName                 = null;
    var txtOldPassword              = null;
    var txtEmailAddress             = document.getElementsByName('userInfoMod.email')[0];
    var txtReEmailAddress           = document.getElementsByName('reEmailAddress')[0];
    var txtUserId                   = document.getElementsByName('userInfoMod.userId')[0];
    var txtPassword                 = document.getElementsByName('password')[0];
    var txtRePassword               = document.getElementsByName('rePassword')[0];
    var txtCompanyName              = document.getElementsByName('userInfoMod.cmpName')[0];
    var txtAddress1                 = document.getElementsByName('userInfoMod.address1')[0];
    var txtAddress2                 = document.getElementsByName('userInfoMod.address2')[0];
    var txtAddress3                 = document.getElementsByName('userInfoMod.address3')[0];
    var txtAddress4                 = document.getElementsByName('userInfoMod.address4')[0];
    var txtCity                     = document.getElementsByName('userInfoMod.city')[0];
    var txtState                    = document.getElementsByName('userInfoMod.state')[0];
    var txtCountry                  = document.getElementsByName('userInfoMod.country')[0];
    var txtPhoneNo                  = document.getElementsByName('userInfoMod.phoneNo')[0];
    var txtFaxNo                    = document.getElementsByName('userInfoMod.faxNo')[0];
    var sfu                         = document.getElementsByName('sfu');
    var internalUser                = document.getElementsByName('internalUser');
    var chkAccept                   = null;
    var isPass                      = true;
    var isValidatePassword          = false;
    /*Begin @01*/
    // var lo_representedCompanyFlag   = document.getElementById("representedCompanyFlag"); //##02
    var la_contractPartyName        = document.getElementsByName('contractPartyName');
    /*End @01*/

    try{
//        alert('validationExternalUserSubmit');
        if(internalUser[0].value == 'R'){
             txtFirstName = document.getElementsByName('firstName')[0];
            if(isPass && isNullObj(txtFirstName) || isBlank(txtFirstName.value)){
            	showBarMessageNew('Please specify the First Name.', MSG_ERROR_CODE);
                txtFirstName.focus();

                isPass = false;
            }
            txtLastName = document.getElementsByName('lastName')[0];
            if(isPass && (isNullObj(txtLastName) || isBlank(txtLastName.value))){
            	showBarMessageNew('Please specify the Last Name.', MSG_ERROR_CODE);
                //alert('Please specific Last Name.');
                txtLastName.focus();

                isPass = false;
            }
        }
        if(isPass && !validateEmail(txtEmailAddress, txtReEmailAddress)){
            isPass = false;
        }

        if(internalUser[0].value == 'R'){
            if(isPass && !validateUserId(txtUserId)){
                isPass = false;
            }

            if(isPass && (userIdChecked == 'false')){
            	showBarMessageNew('Please check available for this userId.', MSG_ERROR_CODE);
                txtUserId.focus();

                 isPass = false;
            }
            if(isPass && (userIdPassed == 'false')){
            	showBarMessageNew('User id not available, please change another user id.', MSG_ERROR_CODE);
                txtUserId.focus();

                isPass = false;
            }
            isValidatePassword = true;
        }else{
            txtOldPassword = document.getElementsByName('oldPassword')[0];
            if(isPass){
                if(!isNullObj(txtOldPassword.value) && !isBlank(txtOldPassword.value)){
                    if(!validatePassword(txtOldPassword.value, 'Old Password')){
                        isPass = false;
                    }else{
                        isValidatePassword = true;

                    }
                }
            }
        }
        if(isValidatePassword){
            if(isPass && !validatePassword(txtPassword.value, 'Password')){
                isPass = false;
            }
            if(isPass && !validatePassword(txtRePassword.value, 'Repeat Password')){
                isPass = false;
            }
            if(isPass && !comparePassword(txtPassword, txtRePassword)){
                isPass = false;
            }
        }
        if(isPass && (isNullObj(txtCompanyName) || isBlank(txtCompanyName.value))){
        	showBarMessageNew('Please specify Company Name.', MSG_ERROR_CODE);
            //alert('Please specific Company Name.');
            txtCompanyName.focus();

            isPass = false;
        }
        if(isPass && !validateAddress(txtAddress1, txtAddress2, txtAddress3, txtAddress4)){
            isPass = false;
        }
        if(isPass && (isNullObj(txtCity) || isBlank(txtCity.value))){
        	showBarMessageNew('Please specific City.', MSG_ERROR_CODE);
            //alert('Please specific City.');
            txtCity.focus();

            isPass = false;
        }
        if(isPass && (isNullObj(txtCountry) || isBlank(txtCountry.value))){
        	showBarMessageNew('Please specific Country.', MSG_ERROR_CODE);
            //alert('Please specific Country.');
            txtCountry.focus();
//
            isPass = false;
        }
        if(isPass && !validatePhoneNo(txtPhoneNo)){
//            showBarMessage('Please specific Phone Number.', MSG_ERROR_CODE);
            txtPhoneNo.focus();

            isPass = false;
        }
        if(isPass && !validateServiceRequest(sfu) ){
        	showBarMessageNew('Please select service request at least one.', MSG_ERROR_CODE);
            //alert('Please select service request at least one.');
            //chkServiceRequest[0].focus();

            isPass = false;
        }
        if(isPass && internalUser[0].value == 'R'){
            chkAccept = document.getElementsByName('chkAccept');
            if(!chkAccept[0].checked){
            	showBarMessageNew('Please indicate the acceptance of Terms of Use and Privacy Policy before proceeding.', MSG_ERROR_CODE);
                chkAccept[0].focus();

                isPass = false;
            }
        }

        /*Begin @01*/
        //##02 Begin
        /*
        if(lo_representedCompanyFlag.checked==true && isPass==true){
            if(la_contractPartyName.length > 0){
                for(var i=0;i<la_contractPartyName.length;i++){
                    if(gp_trim(la_contractPartyName[i].value)==""){
                        showBarMessage(ESR_SE0031, MSG_ERROR_CODE, new Array((i + 1), 'Contract Company'));
                        la_contractPartyName[i].focus();
                        isPass = false;
                        break;
                    }
                }
            }else{
                isPass = false;
                showBarMessage(ESR_SE0032, MSG_ERROR_CODE);
            }
        }*/
        //##02 End
        /*End @01*/

    }catch(err){
        handleJavaScriptError('validationExternalUserSubmit', err, error_code);
        isPass = false;
    }
    return isPass;
}

function validationInternalUserSubmit(){
	debugger;
    var txtCustomerCode             = document.getElementsByName('customerCode')[0];
    var sfu                         = document.getElementsByName('sfu');
    var isPass                      = true;
    /*Begin @01*/
    // var lo_representedCompanyFlag   = document.getElementById("representedCompanyFlag"); //##02
    var lo_portPairFlag             = document.getElementById('portPairFlag');
    var la_fkContractPartyCode      = document.getElementsByName('fkContractPartyCode');
    var la_contractPartyFscCode     = document.getElementsByName('contractPartyFscCode');
    var la_contractPartyType        = document.getElementsByName('contractPartyType');
    var la_approveFlag              = document.getElementsByName('approveFlag');
    /*End @01*/

    try{
        
    		
    	if(lo_portPairFlag.value=="N"){
           /* if(isNullObj(txtCustomerCode) || isBlank(txtCustomerCode.value)){
                showBarMessage('Please specify the Customer Code.', MSG_ERROR_CODE);
                txtCustomerCode.focus();
                return false;
            }
		*/
            if(isPass && !validateServiceRequest(sfu) ){
            	showBarMessageNew('Please select service request at least one.', MSG_ERROR_CODE);
                return false;
            }
        }

        /*Begin @01*/
        //##02 Begin
        /*
        if(lo_representedCompanyFlag.checked==true){
            for(var i=0;i<la_fkContractPartyCode.length;i++){
                if(la_approveFlag[i].checked==true){
                    if(gp_trim(la_fkContractPartyCode[i].value)==""){
                        showBarMessage(ESR_SE0031, MSG_ERROR_CODE, new Array((i + 1), 'CRM Code'));
                        return false;
                    }

                    if(gp_trim(la_contractPartyFscCode[i].value)==""){
                        showBarMessage(ESR_SE0031, MSG_ERROR_CODE, new Array((i + 1), 'FSC Code'));
                        return false;
                    }

                    if(gp_trim(la_contractPartyType[i].value)==""){
                        showBarMessage(ESR_SE0031, MSG_ERROR_CODE, new Array((i + 1), 'Customer Type'));
                        return false;
                    }
                }
            }
        }*/
        //##02 End
        /*End @01*/

    }catch(err){
        handleJavaScriptError('validateInternalUserSubmit', err, 0);
        return false;
    }
    return true;
}

function validateUserId(txtUserId){
    var isPass = true;
    try{
        error_code = 1;
        if(isNullObj(txtUserId) || isBlank(txtUserId.value)){
            error_code = 2;
            showBarMessageNew('Please enter User ID first.', MSG_ERROR_CODE);
            //alert('Please specific User Id.');

            isPass = false;
        }else{
            error_code = 3;
            //alert('txtUserId.length = '+txtUserId.value.length+'\ntxtUserId.value = '+txtUserId.value);
            if(txtUserId.value.length < 6){
                error_code = 4;
                showBarMessageNew('Please specifiy User Id which is 6 to 10 characters long.', MSG_ERROR_CODE);
                //alert('Please specific User Id.');

                isPass = false;
            }
        }
        error_code = 5;
    }catch(err){
        handleJavaScriptError('validateUserId', err, error_code);
        isPass = false;
    }finally{
        if(!isPass){
            txtUserId.focus();
        }
    }
    return isPass;
}

function validatePassword(txtPassword, passwordType){
  var digitFormat = /\D+/g;
    var charFormat = /\d+/g;
    var isMainInputBlank = false;
    var isWrongMainInputFormat = false;
    var isPassed = false;
    try{
        
    	{
            error_code = 3;
            //alert(txtPassword.value.length);
            if(txtPassword.length < 8){
                error_code = 4;
                showBarMessageNew('Please create an alphanumeric password with minimum 8 characters', MSG_ERROR_CODE);

                
            }else if(txtPassword.match(charFormat) == null || txtPassword.match(digitFormat) == null){
                error_code = 5;
                showBarMessageNew('Please create an alphanumeric password with minimum 8 characters', MSG_ERROR_CODE);

                 
            }else{
                isPassed = true;
            }
        }
        error_code = 6;
    }catch(err){
        //handleJavaScriptError('validatePassword', err, error_code);
    }
    return isPassed;
}

function comparePassword(txtPassword, txtRePassword){
    var isMatch = false;
    try{
        error_code = 1;
        if(txtPassword.value == txtRePassword.value){
            isMatch = true;
        }else{
            error_code = 2;
            showBarMessage('Password and Repeat Password not matched.', MSG_ERROR_CODE);
            //alert('Password and Repeat Password not matched.');
            txtPassword.focus();
        }
    }catch(err){
        handleJavaScriptError('comparePassword', err, error_code);
        isMatch = false;
    }
    return isMatch;
}

function validateServiceRequest(serviceCheckedObj){
    var isChecked = false;
    var serviceCheckedLength = 0;
    try{
        error_code = 1;
        if(!isNullObj(serviceCheckedObj) && !isNullObj(serviceCheckedObj.length)){
            error_code = 2;
            serviceCheckedLength = serviceCheckedObj.length;
            error_code = 3;
            for(var countIndex=0; countIndex<serviceCheckedLength; countIndex++){
                if(serviceCheckedObj[countIndex].checked){
                    isChecked = true;
                    break;
                }
            }
        }
        error_code = 4;
    }catch(err){
        isChecked = false;
        handleJavaScriptError('validateServiceRequest', err, error_code);
    }
    return isChecked;
}

function validatePhoneNo(phoneObj){
    var keyMobileFormat = /^0[89]{1}\d{8}/g;
    var keyPhoneFormat = /^0[23]{1}\d{7}/g;
    var isPass = false;
    try{
        error_code = 1;
        if(!isNullObj(phoneObj) && !isBlank(phoneObj.value)){
            error_code = 2;
            isPass = true;
//            if(phoneObj.value.length == 10){
//                error_code = 3;
//                isPass = keyMobileFormat.test(phoneObj.value);
//                error_code = 4;
//                if(!isPass){
//                    error_code = 5;
//                    showBarMessage('Wrong mobile number format.', MSG_ERROR_CODE);
//                    //alert('Wrong mobile number format.');
//                }
//            }else if(phoneObj.value.length == 9){
//                error_code = 6;
//                isPass = keyPhoneFormat.test(phoneObj.value);
//                error_code = 7;
//                if(!isPass){
//                    error_code = 8;
//                    showBarMessage('Wrong phone number format.', MSG_ERROR_CODE);
//                    //alert('Wrong phone number format.');
//                }
//            }else{
//                error_code = 9;
//                showBarMessage('The number must has 9 or 10 digits.', MSG_ERROR_CODE);
//                //alert('The number must has 9 or 10 digits.');
//            }
        }else{
            error_code = 10;
//            isPass = true;
            showBarMessage('Please specific Phone Number.', MSG_ERROR_CODE);
            //alert('Please specific Phone Number.');
        }
        error_code = 11;
    }catch(err){
        handleJavaScriptError('validatePhoneNo', err, error_code);
        isPass = false;
    }
    return isPass;
}

function validateFaxNo(faxObj){
    var keyFormat = /^0[23]{1}\d{7}/g;
    var isPass = false;
    try{
        error_code = 1;
        if(!isNullObj(faxObj) && !isBlank(faxObj.value)){
            error_code = 2;
            if(faxObj.value.length == 9){
                error_code = 3;
                isPass = keyFormat.test(faxObj.value);
                error_code = 4;
                if(!isPass){
                    error_code = 5;
                    showBarMessage('Wrong FAX number format.', MSG_ERROR_CODE);
                    //alert('Wrong FAX number format.');
                }
            }else{
                error_code = 6;
                showBarMessage('The number must has 9 digits.', MSG_ERROR_CODE);
                //alert('The number must has 9 digits.');
            }
        }else{
            error_code = 7;
            isPass = true;
//            showBarMessage('Please specific FAX Number.', MSG_ERROR_CODE);
            //alert('Please specific FAX Number.');
        }
        error_code = 8;
    }catch(err){
        handleJavaScriptError('validateFaxNo', err, error_code);
        isPass = false;
    }
    return isPass;
}

function validNumberKey(e){
    var keyFormat = /^\d/g;
    var charVal = String.fromCharCode(e.keyCode);

    return keyFormat.test(charVal);
}

function validAccountKey(e){
    var keyFormat = /^\w/;
    var charVal = String.fromCharCode(e.keyCode);

    return keyFormat.test(charVal);
}

function validateEmail(emailObj, reEmailObj){
    var emailPass = false;
    var reEmailPass = false;
    var emailEmpty = false;
    var reEmailEmpty = false;
    var isPass = true;
    try{
        error_code = 1;
        if(isPass){
            error_code = 2;
            if(isNullObj(emailObj) || isBlank(emailObj.value)){
                error_code = 3;
                showBarMessageNew('Please specify the email address.', MSG_ERROR_CODE);
                error_code = 4;
                emailObj.focus();
                error_code = 5;
                isPass = false;
            }else{
                error_code = 6;
                emailPass = validEmailFormat(emailObj);
                error_code = 7;
                if(!emailPass){
                    error_code = 8;
                    showBarMessageNew('Please provide a valid email address.', MSG_ERROR_CODE);
                    error_code = 9;
                    emailObj.focus();
                    error_code = 10;
                    isPass = false;
                }
            }
        }
        error_code = 11;
        if(isPass){
            error_code = 12;
            if(isNullObj(reEmailObj) || isBlank(reEmailObj.value)){
                error_code = 13;
                showBarMessageNew('Please repeat the email address.', MSG_ERROR_CODE);
                error_code = 14;
                reEmailObj.focus();
                error_code = 5;
                isPass = false;
            }else{
                error_code = 16;
                reEmailPass = validEmailFormat(reEmailObj);
                error_code = 17;
                if(!reEmailPass){
                    error_code = 18;
                    showBarMessageNew('Please provide a valid email address.', MSG_ERROR_CODE);
                    error_code = 19;
                    reEmailObj.focus();
                    error_code = 20;
                    isPass = false;
                }
            }
        }
        error_code = 21;
        if(isPass){
            error_code = 22;
            if(emailPass && reEmailPass){
                error_code = 23;
                if(emailObj.value == reEmailObj.value){
                    error_code = 24;
                    isPass = true;
                }else{
                    error_code = 25;
                    showBarMessageNew('Email addresses do not match.', MSG_ERROR_CODE);
                    error_code = 26;
                    reEmailObj.focus();
                    error_code = 27;
                    //alert('Email not equal.');
                    isPass = false;
                }
            }
        }
    }catch(err){
        handleJavaScriptError('validateEmail', err, error_code);
        isPass = false;
    }
    return isPass;
}

function validEmailFormat(emailObj){
    var emailFormat = /^.+@.+\..{2,3}$/;
    var emailFormat2 = /^.+@.+\..{2,3}\..{2,3}$/;

    var isPass = false;
    if(emailFormat.test(emailObj.value)){
        isPass = true;
    }else if(emailFormat2.test(emailObj.value)){
        isPass = true;
    }
    return isPass;
}

function validEmailKey(e, emailObj){
    var additionSign = '@';
    var keyFormat = /[A-Za-z0-9_-]/g;
    var charVal = null;
    var emailMatchingResult = null;
    var isPass = false;
    try{
        error_code = 1;
        charVal = String.fromCharCode(e.keyCode);
        error_code = 2;
        if(charVal == additionSign){
            error_code = 3;
            emailMatchingResult = emailObj.value.match(charVal);
            error_code = 4;
            if(emailMatchingResult != additionSign){
                error_code = 5;
                isPass = true;
            }
        }else{
            error_code = 6;
            if(keyFormat.test(charVal) || charVal == '.'){
                error_code = 7;
                isPass = true;
            }
        }
        error_code = 8;
    }catch(err){
        handleJavaScriptError('validEmailKey', err, error_code);
        isPass = false;
    }
    return isPass;
}

function validateAddress(txtAddress1, txtAddress2, txtAddress3, txtAddress4){
    var hasAddress = false;
    try{
        error_code = 1;
        if(!isNullObj(txtAddress1) && !isBlank(txtAddress1.value)){
            error_code = 2;
            hasAddress = true;
        }
        if(!hasAddress && !isNullObj(txtAddress2) && !isBlank(txtAddress2.value)){
            error_code = 3;
            hasAddress = true;
        }
        if(!hasAddress && !isNullObj(txtAddress3) && !isBlank(txtAddress3.value)){
            error_code = 4;
            hasAddress = true;
        }
        if(!hasAddress && !isNullObj(txtAddress4) && !isBlank(txtAddress4.value)){
            error_code = 5;
            hasAddress = true;
        }
        error_code = 6;
    }catch(err){
        handleJavaScriptError('isAddressNotBlank', err, error_code);
        hasAddress = false;
    }finally{
        error_code = 7;
        if(!hasAddress){
            error_code = 8;
            showBarMessage('Please specific Address.', MSG_ERROR_CODE);
            error_code = 9;
            //alert('Please specific Address.');
            txtAddress1.focus();
        }
        error_code = 10;
    }
    return hasAddress;
}

function clearMsg(){
    var crmErrorMsgSpan = document.getElementById('crmErrorMsgSpan');
    var crmErrorMsg = document.getElementsByName('crmErrorMsg');
    try{
        error_code = 1;
        if(!isNullObj(crmErrorMsgSpan)){
            error_code = 2;
            crmErrorMsgSpan.innerHTML = '';
        }
        if(!isNullObj(crmErrorMsg) && !isNullObj(crmErrorMsg[0]) && !isNullObj(crmErrorMsg[0].value)){
            error_code = 3;
            crmErrorMsg[0].value = '';
        }
        error_code = 4;
        showBarMessage('Ready', MSG_NORMAL_CODE);
        error_code = 5;
    }catch(err){
        handleJavaScriptError('clearMsg', err, error_code);
    }
}

/*Begin @01*/
function clearMsgForContractParty(av_val){
    var lo_objSpan          = null;
    var la_errCrmDesc       = document.getElementsByName('errCrmDesc');
    try{
        lo_objSpan = eval('document.getElementById("errCrmDescSpan' + av_val + '")');

        lo_objSpan.innerHTML            = "";
        la_errCrmDesc[av_val].value     = "";

    }catch(err){
        handleJavaScriptError('clearMsgForContractParty', err, error_code);
    }
}
/*End @01*/

function loadServiceDesctiption(objDiv, usageRemark) {
    objDiv.title = usageRemark;
}

function unloadServiceDesctiption(serviceName) {
    var objDiv = document.getElementById(serviceName);
    objDiv.style.display = 'none';
}

function changeUpper(afield) {
    afield.value = afield.value.toUpperCase();
}

function checkCustomerCodeKeyIn(e){
    //alert(e.keyCode);
    if(e.keyCode == 8 || e.keyCode == 46){
        return true;
    }else{
        return false;
    }
}


//##03 Begin
function excludeExpireChange(obj){
    var checkedValue = null;
    try{
        userId = $('input[name=userInfoMod.userId]').val();
        if($(obj).attr("checked")){
            checkedValue = "Y";
        } else {
            checkedValue = "N";
        }
        var postVal = "excludeExpire="+checkedValue;
        // postVal += "#represetedCompanyDetailsDiv";
        // location.href = FILTER_CONTRACT_PARTY + "?" + postVal;
        $.ajax({
            type : "POST",
            url : FILTER_CONTRACT_PARTY,
            data : postVal,
            beforeSend : showBarMessage("Loading...", MSG_NORMAL_CODE),
            success : function(data){
                // console.log(data);
                var jsonResult = jQuery.parseJSON(data);
                if(jsonResult.status != undefined && jsonResult.status == 'OK'){
                    displayRepresentedComp(jsonResult.resultList);
                }
                showBarMessage("Ready", MSG_NORMAL_CODE);
            }
        });
    } catch (err){
        handleJavaScriptError('excludeExpireContractParty', err, MSG_ERROR_CODE);
    }
}
//##03 End

function displayRepresentedComp(targetList){
    var tblRepresentComp            = null;
    var newNodeTr 	                = null;
    var newNodeTd1 			            = null;
    var newNodeTd2 			            = null;
    var newNodeTd3 			            = null;
    var newNodeTd4 			            = null;
    var newNodeTd5 			            = null;
    var rowIndex                    = 0;
    try{

      tblRepresentComp = document.getElementById("tblRepresentComp");

      while(tblRepresentComp.rows.length > 1){
          tblRepresentComp.deleteRow(1);
      }

      rowIndex = 1;

      $.each(targetList, function(i, item) {
          newNodeTr       = tblRepresentComp.insertRow(rowIndex);
          newNodeTd1      = newNodeTr.insertCell(0);
          newNodeTd2      = newNodeTr.insertCell(1);
          newNodeTd3      = newNodeTr.insertCell(2);
          newNodeTd4      = newNodeTr.insertCell(3);
          newNodeTd5      = newNodeTr.insertCell(4);

          newNodeTr.className = "tr_sub_detail";

          $(newNodeTd1).attr('style', 'text-align:center; vertical-align:middle');
          newNodeTd1.width      = "15%";
          newNodeTd1.height     = "30px";
          newNodeTd1.innerHTML  = '<input type="hidden" name="fkContractPartyCode" value="' + item.fkContractPartyCode + '"/>'
                                + '<input type="hidden" name="pkEsvPpHdrSeq" value="' + item.pkEsvPpHdrSeq + '"/>'
                                + '<input type="hidden" name="statusFlag" value="' + item.statusFlag + '"/>'
                                + '<input type="hidden" name="recStatus" value="' + item.recStatus + '"/>'
                                + '<input type="hidden" name="approveFlag" value="' + item.approveFlag + '"/>'
                                + '<input type="hidden" name="contractPartyFscCode" value="' + item.contractPartyFscCode + '"/>'
                                + '<input type="hidden" name="contractPartyType" value="' + item.contractPartyType + '"/>'
                                + 'Company Name:';

          $(newNodeTd2).attr('style', 'text-align:center; vertical-align:middle');
          newNodeTd2.width      = "54%";
          newNodeTd2.height     = "30px";
          newNodeTd2.innerHTML  = '<input type="text" name="contractPartyName" style="width:98%" disabled="true" value="' + item.contractPartyName + '"/>';

          $(newNodeTd3).attr('style', 'text-align:center; vertical-align:middle');
          newNodeTd3.width      = "13%";
          newNodeTd3.height     = "30px";
          newNodeTd3.innerHTML  = '<input type="text" name="contractPartyStatus" style="width:80px" disabled="true" value="' + item.contractPartyStatus + '"/>';

          $(newNodeTd4).attr('style', 'text-align:center; vertical-align:middle');
          newNodeTd4.width      = "13%";
          newNodeTd4.height     = "30px";
          if(item.isActivate){
            newNodeTd4.innerHTML  = '<input type="text" name="reactPwd" style="width:80px; text-align:left;" placeholder="PASSWORD" title="PASSWORD" value="' + item.reactPwd + '"/>'
          } else {
            newNodeTd4.innerHTML  = '<input type="text" name="reactPwd" style="width:80px; text-align:left;" placeholder="PASSWORD" title="PASSWORD" disabled="true" value="' + item.reactPwd + '"/>';
          }

          $(newNodeTd5).attr('style', 'text-align:center; vertical-align:middle');
          newNodeTd5.width      = "15%";
          newNodeTd5.height     = "30px";
          if(item.isActivate){
            newNodeTd5.innerHTML  = '<a class="m-btn mini blue rnd" name="btnActiveContractCompany" id="btnActiveContractCompany" href="javascript:void(0)" onClick="activateRepresentedCompany(this)">Activate</a>'
          } else {
            newNodeTd5.innerHTML  = '<a class="m-btn mini blue rnd" name="btnActiveContractCompany" id="btnActiveContractCompany" href="javascript:void(0)" onClick="javascript:void(0)" disabled="disabled">Activate</a>'
          }

          rowIndex++;
      });

    } catch (err){
        handleJavaScriptError('displayRepresentedComp', err, MSG_ERROR_CODE);
    }
}

$(document).ready(function(){
  $("#excludeExpireContractParty").change(function(){
    var theChkBox = $('input[name=excludeExpireContractParty]');
    excludeExpireChange(theChkBox);
  });
});


function checkNumeric(selectObject,type)
{
	var id=selectObject.id
	var tempvalue=document.getElementById(id).value;
	 
		if(isNaN(tempvalue))
		{
			document.getElementById(id).value="";
			showBarMessageNew(type+" should be Numeric");
			return false;
		}
	 
}

function validateMultipleEmails(selectObject) {
	debugger;
	var id=selectObject.id
    // Get value on emails input as a string
    var emails = document.getElementById(id).value;;
    
    // Split string by comma into an array
    emails = emails.split(",");
    if(emails.length>1){
	 	showBarMessageNew("Multipule E-Mail Address not Allowed.");
		return false;
	}	
    var valid = true;
    var regex = /^(([^<>()[\]\\.,;:\s@\"\']+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    var invalidEmails = [];
    
    for (var i = 0; i < emails.length; i++) {
        // Trim whitespaces from email address
        emails[i] = emails[i].trim();
        
        // Check email against our regex to determine if email is valid
        if( emails[i] == "" || ! regex.test(emails[i])){
            invalidEmails.push(emails[i]);
        }
    }
    
    // Output invalid emails
    
    if(invalidEmails != 0) {
		showBarMessageNew("Invalid Additional emails: "+invalidEmails.join(', '));
		window.scrollTo(500, 0);
		return false; 
    }else{
		$("#alertId").hide();
		return true;
	}
}

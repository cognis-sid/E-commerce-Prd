/*
	*1: Modified by vikas, when flash point is negative, screen is not accepting the 
            flash point, k'chatgmaol, 10.07.2012	
	*2: Issue Fixed by vikas, When Dishcarge status is ROB then cell location can not 
            be blank, k'chatgmaol, 01.03.2013
*/

var view;
var find1;
var in1;
var find2;
var in2;
var order1;
var order1Ord;
var order2;
var order2Ord;
var varChangeValIn1;
var varChangeValIn2;
var FORM_ID = 'fedl002';
var lookupId;
var ERROR_FLAG_SLOT_OPR = 'success';
var ERROR_FLAG_CONT_OPR = 'success';
var ERROR_FLAG_OUT_SLOT_OPR = 'success';
var ERROR_FLAG_HIC1 = 'success';
var ERROR_FLAG_HIC2 = 'success';
var ERROR_FLAG_HIC3 = 'success';
var ERROR_FLAG_SHPMNT_TERM = 'success';
var ERROR_FLAG_EQUIP_TYPE = 'success';
var ERROR_FLAG_PORT_CODE = 'success';
var ERROR_FLAG_PORT_TERMINAL = 'success';

/*Called by framework on-load of this JSP*/
function onLoad() {

    document.getElementById("hiddenComboDiv").style.display = 'none';

    //Get the value of current selected tab
    var currTab     = document.forms[0].currTabSelected.value;
    if(currTab != '4'){
        storeSearchCriteria();
        changeValIn1();
        changeValIn2();

        var readonly      = document.getElementById("readOnlyFlg").value;
        var divObjBooked  = document.getElementById("bookedtabbtn");
        var divObjOL      = document.getElementById("overlandedtabbtn");

        if(readonly == 'V'){
            divObjBooked.style.display = 'none';
            divObjOL.style.display     = 'none';
        }
    }

    if(currTab == '1'){
        document.getElementById("hidBookedView").value=
            document.getElementById("bookedView").value;

        document.getElementById("bookedFind1").value=
            document.getElementById("srchBookingFind1").value;

        document.getElementById("bookedIn1").value=
            document.getElementById("srchBookingIn1").value;

        document.getElementById("bookedFind2").value=
            document.getElementById("srchBookingFind2").value;

        document.getElementById("bookedIn2").value=
            document.getElementById("srchBookingIn2").value;

        document.getElementById("bookedOrder1").value=
            document.getElementById("srchBookingOrder1").value;

        document.getElementById("bookedOrder1Ord").value=
            document.getElementById("srchBookingOrder1Ord").value;

        document.getElementById("bookedOrder2").value=
            document.getElementById("srchBookingOrder2").value;

        document.getElementById("bookedOrder2Ord").value=
            document.getElementById("srchBookingOrder2Ord").value;

    } else if(currTab == '2'){
        document.getElementById("hidOverlandedView").value=
            document.getElementById("overlandedView").value;

        document.getElementById("overlandedFind1").value=
            document.getElementById("srchOverlandedFind1").value;

        document.getElementById("overlandedIn1").value=
            document.getElementById("srchOverlandedIn1").value;

        document.getElementById("overlandedFind2").value=
            document.getElementById("srchOverlandedFind2").value;

        document.getElementById("overlandedIn2").value=
            document.getElementById("srchOverlandedIn2").value;

        document.getElementById("overlandedOrder1").value=
            document.getElementById("srchOverlandedOrder1").value;

        document.getElementById("overlandedOrder1Ord").value=
            document.getElementById("srchOverlandedOrder1Ord").value;

        document.getElementById("overlandedOrder2").value=
            document.getElementById("srchOverlandedOrder2").value;

        document.getElementById("overlandedOrder2Ord").value=
            document.getElementById("srchOverlandedOrder2Ord").value;

    } else if(currTab == '3'){
        document.getElementById("hidRestowedView").value=
            document.getElementById("restowedView").value;

        document.getElementById("restowedFind1").value=
            document.getElementById("srchRestowedFind1").value;

        document.getElementById("restowedIn1").value=
            document.getElementById("srchRestowedIn1").value;

        document.getElementById("restowedFind2").value=
            document.getElementById("srchRestowedFind2").value;

        document.getElementById("restowedIn2").value=
            document.getElementById("srchRestowedIn2").value;

        document.getElementById("restowedOrder1").value=
            document.getElementById("srchRestowedOrder1").value;

        document.getElementById("restowedOrder1Ord").value=
            document.getElementById("srchRestowedOrder1Ord").value;

        document.getElementById("restowedOrder2").value=
            document.getElementById("srchRestowedOrder2").value;

        document.getElementById("restowedOrder2Ord").value=
            document.getElementById("srchRestowedOrder2Ord").value;

    }

}//end of onload function

//function to store search criteria
function storeSearchCriteria(){
    //Get the value of current selected tab
    var currTab     = document.forms[0].currTabSelected.value;
    if(currTab == '1'){
        view          = document.getElementById("bookedView").value;
        find1         = document.getElementById("srchBookingFind1").value;
        in1           = document.getElementById("srchBookingIn1").value;
        find2         = document.getElementById("srchBookingFind2").value;
        in2           = document.getElementById("srchBookingIn2").value;
        order1            = document.getElementById("srchBookingOrder1").value;
        order1Ord      = document.getElementById("srchBookingOrder1Ord").value;
        order2         = document.getElementById("srchBookingOrder2").value;
        order2Ord    = document.getElementById("srchBookingOrder2Ord").value;
    }else if(currTab == '2'){
        view          = document.getElementById("overlandedView").value;
        find1         = document.getElementById("srchOverlandedFind1").value;
        in1           = document.getElementById("srchOverlandedIn1").value;
        find2         = document.getElementById("srchOverlandedFind2").value;
        in2           = document.getElementById("srchOverlandedIn2").value;
        order1            = document.getElementById("srchOverlandedOrder1").value;
        order1Ord      = document.getElementById("srchOverlandedOrder1Ord").value;
        order2         = document.getElementById("srchOverlandedOrder2").value;
        order2Ord    = document.getElementById("srchOverlandedOrder2Ord").value;
    }else if(currTab == '3'){
        view          = document.getElementById("restowedView").value;
        find1         = document.getElementById("srchRestowedFind1").value;
        in1           = document.getElementById("srchRestowedIn1").value;
        find2         = document.getElementById("srchRestowedFind2").value;
        in2           = document.getElementById("srchRestowedIn2").value;
        order1            = document.getElementById("srchRestowedOrder1").value;
        order1Ord      = document.getElementById("srchRestowedOrder1Ord").value;
        order2         = document.getElementById("srchRestowedOrder2").value;
        order2Ord    = document.getElementById("srchRestowedOrder2Ord").value;
    }
}

//function to set search criteria
function resetSearchCriteria(){
    //Get the value of current selected tab
    var currTab     = document.forms[0].currTabSelected.value;
    if(currTab == '1'){
        document.getElementById("bookedView").value            = view;
        document.getElementById("srchBookingFind1").value      = find1;
        document.getElementById("srchBookingIn1").value        = in1;
        document.getElementById("srchBookingFind2").value      = find2;
        document.getElementById("srchBookingIn2").value        = in2;
        document.getElementById("srchBookingOrder1").value     = order1;
        document.getElementById("srchBookingOrder1Ord").value  = order1Ord;
        document.getElementById("srchBookingOrder2").value     = order2;
        document.getElementById("srchBookingOrder2Ord").value  = order2Ord;
    }else if(currTab == '2'){
        document.getElementById("overlandedView").value           = view;
        document.getElementById("srchOverlandedFind1").value      = find1;
        document.getElementById("srchOverlandedIn1").value        = in1;
        document.getElementById("srchOverlandedFind2").value      = find2;
        document.getElementById("srchOverlandedIn2").value        = in2;
        document.getElementById("srchOverlandedOrder1").value     = order1;
        document.getElementById("srchOverlandedOrder1Ord").value  = order1Ord;
        document.getElementById("srchOverlandedOrder2").value     = order2;
        document.getElementById("srchOverlandedOrder2Ord").value  = order2Ord;
    }else if(currTab == '3'){
        document.getElementById("restowedView").value           = view;
        document.getElementById("srchRestowedFind1").value      = find1;
        document.getElementById("srchRestowedIn1").value        = in1;
        document.getElementById("srchRestowedFind2").value      = find2;
        document.getElementById("srchRestowedIn2").value        = in2;
        document.getElementById("srchRestowedOrder1").value     = order1;
        document.getElementById("srchRestowedOrder1Ord").value  = order1Ord;
        document.getElementById("srchRestowedOrder2").value     = order2;
        document.getElementById("srchRestowedOrder2Ord").value  = order2Ord;
    }
    changeValIn1();
    changeValIn2();
    return false;
}

function onselectRow(radioObj){
    var rowid = 'row'+(parseInt(radioObj.value));
    highlightTD(rowid);
}//end of onselectRow function

//Function to highlight the selected row
function highlightTD(rowid) {

}//end of highlightTD function

//Function for setting hidden view value on change of view.
function setHiddenView(){
    //Get the value of current selected tab
    var currTab     = document.forms[0].currTabSelected.value;
    if(currTab == '1'){
        document.getElementById("hidBookedView").value=
                    document.getElementById("bookedView").value;
    }else if(currTab == '2'){
        document.getElementById("hidOverlandedView").value=
            document.getElementById("overlandedView").value;
    }else if(currTab == '3'){
        document.getElementById("hidRestowedView").value=
            document.getElementById("restowedView").value;
    }
}

//Function for enabling and disabling of search criteria fields
function changeValIn1(){
    //Get the value of current selected tab
    var currTab     = document.forms[0].currTabSelected.value;
    if(currTab == '1'){
        var in1ComboVal      = document.forms[0].srchBookingIn1.value;
        var lobjFind1        = document.forms[0].srchBookingFind1;
    }else if(currTab == '2'){
        var in1ComboVal      = document.forms[0].srchOverlandedIn1.value;
        var lobjFind1        = document.forms[0].srchOverlandedFind1;
    }else if(currTab == '3'){
        var in1ComboVal      = document.forms[0].srchRestowedIn1.value;
        var lobjFind1        = document.forms[0].srchRestowedFind1;
    }
   if(currTab != '4') {
   if( in1ComboVal == "BBCARGO"     ||
        in1ComboVal == "COCCUST"     ||
        in1ComboVal == "COCEMPTY"    ||
        in1ComboVal == "COCTRANS"    ||
        in1ComboVal == "DGCARGO"     ||
        in1ComboVal == "OOGCARGO"    ||
        in1ComboVal == "REEFERCARGO" ||
        in1ComboVal == "SOCALL"      ||
        in1ComboVal == "SOCDIRECT"   ||
        in1ComboVal == "SOCPARTNER"  ||
        in1ComboVal == "SOCTRANS"    ||
        in1ComboVal == "SPLHNDL"     ||
        in1ComboVal == "TIGHTCON"    ||
        in1ComboVal == "TRANSSHPD"   ||
        in1ComboVal == "WITHREM"     ||
        in1ComboVal == "WITHERR"
    ){
        lobjFind1.value = "";
        lobjFind1.disabled = true;
        lobjFind1.style.backgroundColor = "#EBEEEA";
        varChangeValIn1 = "Y";
    } else{
        lobjFind1.disabled = false;
        lobjFind1.style.background = 'white';
        lobjFind1.style.color      = 'black';
        varChangeValIn1 = "N";
    }
    }
    return false;
}//end of changeValIn1 function

//Function for enabling and disabling of search criteria fields
function changeValIn2(){

   //Get the value of current selected tab
    var currTab     = document.forms[0].currTabSelected.value;

    if(currTab == '1'){
        var in1ComboVal      = document.forms[0].srchBookingIn2.value;
        var lobjFind2        = document.forms[0].srchBookingFind2;
    }else if(currTab == '2'){
        var in1ComboVal      = document.forms[0].srchOverlandedIn2.value;
        var lobjFind2        = document.forms[0].srchOverlandedFind2;
    }else if(currTab == '3'){
        var in1ComboVal      = document.forms[0].srchRestowedIn2.value;
        var lobjFind2        = document.forms[0].srchRestowedFind2;
    }


    if(currTab != '4') {
    if( in1ComboVal == "BBCARGO"     ||
        in1ComboVal == "COCCUST"     ||
        in1ComboVal == "COCEMPTY"    ||
        in1ComboVal == "COCTRANS"    ||
        in1ComboVal == "DGCARGO"     ||
        in1ComboVal == "OOGCARGO"    ||
        in1ComboVal == "REEFERCARGO" ||
        in1ComboVal == "SOCALL"      ||
        in1ComboVal == "SOCDIRECT"   ||
        in1ComboVal == "SOCPARTNER"  ||
        in1ComboVal == "SOCTRANS"    ||
        in1ComboVal == "SPLHNDL"     ||
        in1ComboVal == "TIGHTCON"    ||
        in1ComboVal == "TRANSSHPD"   ||
        in1ComboVal == "WITHREM"     ||
        in1ComboVal == "WITHERR"
    ){
        lobjFind2.value = "";
        lobjFind2.disabled = true;
        lobjFind2.style.backgroundColor = "#EBEEEA";
        varChangeValIn2 = "Y";
    }else{

        lobjFind2.disabled = false;
        lobjFind2.style.background = 'white';
        lobjFind2.style.color      = 'black';
        varChangeValIn2 = "N";
    }
    }

    return false;
}//end of changeValIn2 function

// Function to onChangeDischargeListStatus
function onChangeDischargeListStatus(){
    document.forms[0].updFlag.value = 'Y';

}//end of onChangeDischargeListStatus function

// Function to save and find data on click of tab change
function getTabData(tabIndex){
    var currTab = document.forms[0].currTabSelected.value;
    document.getElementById("onTabChangeFlag").value="true";
    if(currTab != '4'){
        resetSearchCriteria();
    }
    if(currTab == '1'){
        if(document.forms[0].bookedTabFind.value=='true'){
        document.getElementById("hidBookedView").value=
            document.getElementById("bookedView").value;

        document.getElementById("bookedFind1").value=
            document.getElementById("srchBookingFind1").value;

        document.getElementById("bookedIn1").value=
            document.getElementById("srchBookingIn1").value;

        document.getElementById("bookedFind2").value=
            document.getElementById("srchBookingFind2").value;

        document.getElementById("bookedIn2").value=
            document.getElementById("srchBookingIn2").value;

        document.getElementById("bookedOrder1").value=
            document.getElementById("srchBookingOrder1").value;

        document.getElementById("bookedOrder1Ord").value=
            document.getElementById("srchBookingOrder1Ord").value;

        document.getElementById("bookedOrder2").value=
            document.getElementById("srchBookingOrder2").value;

        document.getElementById("bookedOrder2Ord").value=
            document.getElementById("srchBookingOrder2Ord").value;
        }
        if(!saveValidationBookingTab()){
            return false;
        }
    } else if(currTab == '2') {
        if(document.forms[0].overlandedTabFind.value=='true'){
            document.getElementById("hidOverlandedView").value=
                document.getElementById("overlandedView").value;

            document.getElementById("overlandedFind1").value=
                document.getElementById("srchOverlandedFind1").value;

            document.getElementById("overlandedIn1").value=
                document.getElementById("srchOverlandedIn1").value;

            document.getElementById("overlandedFind2").value=
                document.getElementById("srchOverlandedFind2").value;

            document.getElementById("overlandedIn2").value=
                document.getElementById("srchOverlandedIn2").value;

            document.getElementById("overlandedOrder1").value=
                document.getElementById("srchOverlandedOrder1").value;

            document.getElementById("overlandedOrder1Ord").value=
                document.getElementById("srchOverlandedOrder1Ord").value;

            document.getElementById("overlandedOrder2").value=
                document.getElementById("srchOverlandedOrder2").value;

            document.getElementById("overlandedOrder2Ord").value=
                document.getElementById("srchOverlandedOrder2Ord").value;
        }
        if(!saveValidationOverlandedTab()){
            return false;
        }
    } else if(currTab == '3'){
        if(document.forms[0].restowedTabFind.value=='true'){
            document.getElementById("hidRestowedView").value=
                document.getElementById("restowedView").value;

            document.getElementById("restowedFind1").value=
                document.getElementById("srchRestowedFind1").value;

            document.getElementById("restowedIn1").value=
                document.getElementById("srchRestowedIn1").value;

            document.getElementById("restowedFind2").value=
                document.getElementById("srchRestowedFind2").value;

            document.getElementById("restowedIn2").value=
                document.getElementById("srchRestowedIn2").value;

            document.getElementById("restowedOrder1").value=
                document.getElementById("srchRestowedOrder1").value;

            document.getElementById("restowedOrder1Ord").value=
                document.getElementById("srchRestowedOrder1Ord").value;

            document.getElementById("restowedOrder2").value=
                document.getElementById("srchRestowedOrder2").value;

            document.getElementById("restowedOrder2Ord").value=
                document.getElementById("srchRestowedOrder2Ord").value;
        }
        if(!saveValidationRestowed()){
            return false;
        }
    }
    document.forms[0].prevTabSelected.value = currTab;
    document.forms[0].currTabSelected.value = tabIndex;
    document.forms[0].action = TAB;

    document.forms[0].submit();
    return false;
}//end of getTabData function


//Function to perform the find operation
function onSearch(){

    //Get the current tab value
    var currTab      = document.forms[0].currTabSelected.value;

    if(currTab == '1'){
        var find1Val = document.forms[0].srchBookingFind1.value;
        var in1Val   = document.forms[0].srchBookingIn1.value;
        var find2Val = document.forms[0].srchBookingFind2.value;
        var in2Val   = document.forms[0].srchBookingIn2.value;

    }else if(currTab == '2'){
        var find1Val = document.forms[0].srchOverlandedFind1.value;
        var in1Val   = document.forms[0].srchOverlandedIn1.value;
        var find2Val = document.forms[0].srchOverlandedFind2.value;
        var in2Val   = document.forms[0].srchOverlandedIn2.value;

    }else if(currTab == '3'){
        var find1Val = document.forms[0].srchRestowedFind1.value;
        var in1Val   = document.forms[0].srchRestowedIn1.value;
        var find2Val = document.forms[0].srchRestowedFind2.value;
        var in2Val   = document.forms[0].srchRestowedIn2.value;


    }

    if(varChangeValIn1 != "Y") {
        //Show error message to the user if he has selected only find1Val and not In1Val.
        if(find1Val !="" && in1Val == ""){
            showBarMessage(EZL_SE015,ERROR_MSG);
            //alert("Select at least one value in 'IN1' search criteria");
            return false;
        }
        //Show error message to the user if he has selected only In1Val and not Find1Val.
        if(find1Val =="" && in1Val != ""){
            showBarMessage(EZL_SE016,ERROR_MSG);
            //alert("Please enter a value in Find1 field");
            return false;
        }
    }
    if(varChangeValIn2 != "Y") {
        //Show error message to the user if he has select only find2Val and not In2Val.
        if(find2Val !="" && in2Val == ""){
            showBarMessage(EZL_SE017,ERROR_MSG);
            //alert("Select at least one value in 'IN2' search criteria");
            return false;
        }
        //Show error message to the user if he has select only In2Val and not Find2Val.
        if(find2Val =="" && in2Val != ""){
            showBarMessage(EZL_SE018,ERROR_MSG);
            //alert("Please enter a value in Find2 field");
            return false;
        }
     }

    var intIndex  =  0;
    var lstrWarningFlag ='Y';
    if (currTab == '1'){
        while (intIndex < getGridControl().getTotalDataNumber()){
            status = document.getElementById('bookingValue[' + intIndex + '].status').value;
            /* Check if record is not updated then check next record. */
            if((status == 'UPD') || ( status == 'ADD')){
                //Ask to save data before search.
                if (showQuestion(ECM_GW0004,document.forms[0].btnFind)) {
                    // Call main save method of save changes.
                    onSave();
                    return false;
                }else{
                    lstrWarningFlag = 'N';
                }
                }
            if(lstrWarningFlag == 'N'){
                break;
            }
            intIndex = parseInt(intIndex)  + 1;
        }
    } else if (currTab == '2'){
        while (intIndex < getGridControl().getTotalDataNumber()){
            status = document.getElementById('overlandedValue[' + intIndex + '].status').value;
            /* Check if record is not updated then check next record. */
            if((status == 'UPD') || ( status == 'ADD')){
                //Ask to save data before search.
                if (showQuestion(ECM_GW0004,document.forms[0].btnFind)) {
                    // Call main save method of save changes.
                    onSave();
                    return false;
                }else{
                    lstrWarningFlag = 'N';
                }
                }
            if(lstrWarningFlag == 'N'){
                break;
            }
            intIndex = parseInt(intIndex)  + 1;
        }
        document.forms[0].overlandedSearFlag.value = 'true';

    } else if (currTab == '3'){
        while (intIndex < getGridControl().getTotalDataNumber()){
            status = document.getElementById('restowedValue[' + intIndex + '].status').value;
            /* Check if record is not updated then check next record. */
            if((status == 'UPD') || ( status == 'ADD')){
                //Ask to save data before search.
                if (showQuestion(ECM_GW0004,document.forms[0].btnFind)) {
                    // Call main save method of save changes.
                    onSave();
                    return false;
                } else{
                    lstrWarningFlag = 'N';
                }
                }
            if(lstrWarningFlag == 'N'){
                break;
            }
            intIndex = parseInt(intIndex)  + 1;
        }
        document.forms[0].restowSearFlag.value = 'true';
    }

    document.forms[0].currPageNo.value= 1;
    /* Disable all controls */
    disableOnSubmit();
    /* Reset Update Flag */
    document.forms[0].updFlag.value = 'N';


    document.forms[0].action = FIND;
    document.forms[0].submit();
    return false;
}//end of onSearch function

function onSave(){

    /* No Changes to save. */
    if(document.forms[0].updFlag.value != 'Y'){
        showBarMessage(ECM_GE0014, ERROR_MSG);
        return;
    }
    resetSearchCriteria();
    if(!saveValidation()){
        return;
    }
    var currTab   = document.forms[0].currTabSelected.value;
    var intIndex  = 0;

    if(currTab == '1'){
        while (intIndex < getGridControl().getTotalDataNumber()){
            status              = document.getElementById('bookingValue[' + intIndex + '].status').value;
            /* Check if record is not updated then check next record. */
            if((status == '') ||( status == null)){
                intIndex = parseInt(intIndex)  + 1;
                continue;
            }
            lobjResidue = document.getElementById('bookingValue[' + intIndex + '].residue');
            lobjResidue.disabled = false;
            intIndex = parseInt(intIndex)  + 1;
        }
    }else if(currTab == '2'){
        while (intIndex < getGridControl().getTotalDataNumber()){
            status              = document.getElementById('overlandedValue[' + intIndex + '].status').value;
            /* Check if record is not updated then check next record. */
            if((status == '') ||( status == null)){
                intIndex = parseInt(intIndex)  + 1;
                continue;
            }
            lobjResidue = document.getElementById('overlandedValue[' + intIndex + '].residue');
            lobjResidue.disabled = false;
            intIndex = parseInt(intIndex)  + 1;
        }
    }

    /* Reset Update Flag */
    document.forms[0].updFlag.value = 'N';
    document.forms[0].action = SAVE;
    document.forms[0].submit();
    return false;
}

function containerReplacement(){
    var terminal              = '';
    var bookingNo             = '';
    var oldContainerNo        = '';
    var oldShippersSeal       = '';
    var selectedIndex         = null;
    var etd                   = '';
    var etdTime               = '';
    var fullMT                = '';
    var flagSocCoc              = '';
    var hdrPort                  =  '';
    //If search not performed show error
    searchPerformed = document.getElementById("bookedTabFind").value;
    if(searchPerformed == "false") {
        showBarMessage(ECM_SE0007,ERROR_MSG);
        return false;
    }
    if(document.forms[0].radioGroup1 != null){
        if(getGridControl().getTotalDataNumber() == 1){
            if(document.forms[0].radioGroup1.checked==false){
                showBarMessage(ECM_GE0007,ERROR_MSG);
                return false;
            }else{
                selectedIndex = 0;
            }
        }else {
            for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {
                if(document.forms[0].radioGroup1[i].checked) {
                    selectedIndex = i;
                }
            }
        }
    }
    if(selectedIndex  == null ){
        showBarMessage(ECM_GE0007,ERROR_MSG);
        return false;
    }

    hdrPort         = document.getElementById("hdrPort").value;
    bookingNo       = document.getElementById('bookingValue[' + selectedIndex + '].bookingNo').value;
    oldContainerNo  = document.getElementById('bookingValue[' + selectedIndex + '].equipmentNo').value;
    oldShippersSeal = document.getElementById('bookingValue[' + selectedIndex + '].sealNo').value;
    bookedId        = document.getElementById('bookingValue[' + selectedIndex + '].bookedId').value;
    fullMT            = document.getElementById('bookingValue[' + selectedIndex + '].fullMT').value;
    flagSocCoc        = document.getElementById('bookingValue[' + selectedIndex + '].socCoc').value;
    terminal = document.getElementById("hdrTerminal").value;

    etd = document.getElementById('hdrEtd').value;
    etdTime = document.getElementById('hdrEtdTm').value;
    var url = CONT_REPLACEMENT + bookingNo+'&oldContainerNo='+oldContainerNo+'&terminal='+terminal+'&oldShippersSeal='+oldShippersSeal+'&bookedId='+bookedId+'&hdrEtd='+etd+'&hdrEtdTm='+etdTime+'&fullMT='+fullMT+'&flagSocCoc='+flagSocCoc+'&hdrPort='+hdrPort;
    openChildScreen64(url,FORM_ID);
    showBarMessage(ECM_GI0001);
    return false;

}

/*Called by framework for Pagination*/
function getActionUrl(){
    resetSearchCriteria();
    /* Set page change method of action to save data to temp.*/
    document.forms[0].action = PAGE_CHANGE;
    return PAGE_CHANGE;
}

/*Called by framework on reset or refresh for reloading the page*/
function onResetForm(){
    //Clear the Data Table
    /*clearDiv('fixedColumns_bodyDiv');
    document.forms[0].prevTabSelected.value= 0;
    document.forms[0].currTabSelected.value= 1;
    */
    getGridSearchCriteria();
    /*
    document.forms[0].action = REFRESH;
    document.forms[0].submit();
    */
    return false
}

function onRefresh(){
    resetSearchCriteria();
    onSearch();
    return false;
}

/*Called by Back Button of Header */
function onBack(){
    document.getElementById("currPageNo").value= 1;
    document.forms[0].action = BACK;
    document.forms[0].submit();
    return false;
}

function isSelected() {
    var table =  document.getElementById(arguments[0]);
    var numrows = table.rows.length;

    if(numrows <= 0) {
            return false;
    }

    var chk = 0;

    for(nrow=0;nrow<numrows;nrow++){
        var rowID=table.rows(nrow).id;
        var rowNum=rowID.substring(3);
        var str = arguments[1]+'[' + rowNum + '].selected';


        var obj = document.getElementById(str);
        if(obj == null) {
                break;
        }
        if(obj.checked) {
            chk=1;
             break;
        }
    }
    if(chk==1) {
            return true;
    } else {
            return false;
    }
}

// This function validates current tab data
function saveValidation(){
    // Validation check for booked tab.
    if(document.forms[0].currTabSelected.value == '1'){
        // This function called for booked tab table data validataion.
        return saveValidationBookingTab();
    }else if(document.forms[0].currTabSelected.value == '2'){
        // This function called for Overlanded tab table data validataion.
        return saveValidationOverlandedTab();
    }else if(document.forms[0].currTabSelected.value == '3'){
        // This function called for reestowed tab table data validataion.
        return saveValidationRestowed();
    }else if(document.forms[0].currTabSelected.value == '4'){
        return true;
    }
} // end of function

//Function to validate fields in booked tab
function saveValidationBookingTab(){

    var intIndex  = 0;
    var arrIndex  = new Array();
    var status ='';
    while (intIndex < getGridControl().getTotalDataNumber()){
        status              = document.getElementById('bookingValue[' + intIndex + '].status').value;
        /* Check if record is not updated then check next record. */
        if((status == '') ||( status == null)){
            intIndex = parseInt(intIndex)  + 1;
            continue;
        }

        equipmentNo     = document.getElementById('bookingValue[' + intIndex + '].equipmentNo').value;
        contOperator    = document.getElementById('bookingValue[' + intIndex + '].contOperator').value;
        dischargeStatus = document.getElementById('bookingValue[' + intIndex + '].dischargeSts').value;
        loadCondition   = document.getElementById('bookingValue[' + intIndex + '].loadCondition').value;
        stowPosition    = document.getElementById('bookingValue[' + intIndex + '].stowPosition').value;
        size            = document.getElementById('bookingValue[' + intIndex + '].size').value;
        vesselOwner     = document.getElementById('vesselOwner').value;
        weight          = document.getElementById('bookingValue[' + intIndex + '].weight').value;
        flashPoint      = document.getElementById('bookingValue[' + intIndex + '].flashPoint').value;
        overheight      = document.getElementById('bookingValue[' + intIndex + '].overheight').value;
        overwidthLeft   = document.getElementById('bookingValue[' + intIndex + '].overwidthLeft').value;
        overwidthRight  = document.getElementById('bookingValue[' + intIndex + '].overwidthRight').value;
        overlengthFront = document.getElementById('bookingValue[' + intIndex + '].overlengthFront').value;
        overlengthAfter = document.getElementById('bookingValue[' + intIndex + '].overlengthAfter').value;
        reeferTemp      = document.getElementById('bookingValue[' + intIndex + '].reeferTemp').value;
        /*
            Start added by vikas, 10.01.2012
        */
        var l_v_service     = document.getElementById("hdrService").value;
        /*
            End added by vikas, 10.01.2012
        */

        humidity = "";
        if(document.getElementById('bookingValue[' + intIndex + '].humidity') != null ){
            humidity        = document.getElementById('bookingValue[' + intIndex + '].humidity').value;
        }
        ventilation     = document.getElementById('bookingValue[' + intIndex + '].ventilation').value;
        strMloETADate     = document.getElementById('bookingValue[' + intIndex + '].mloETADate').value;
        strActivityDateTime = document.getElementById('bookingValue[' + intIndex + '].activityDate').value;

        arrIndex[0] = intIndex+1;

        /******************************* Mandatory validations Start *******************************/
        // When Discharge status is ROB or Discharge
            // then equipment no is mandatory.
        if ((dischargeStatus == 'RB') || (dischargeStatus == 'DI')){
                // Equipment# should be mandatory.
                if((equipmentNo == null) || (equipmentNo =='')) {
                    showBarMessage(EZL_SE029,ERROR_MSG, arrIndex);
                    return false;
                }

        }


        // Container operator should not be null;
        if((contOperator == null) || (contOperator =='')) {
            showBarMessage(EZL_SE001, ERROR_MSG, arrIndex);
            return false;
        }
        // Discharge status should not be null;
        if((dischargeStatus == null) || (dischargeStatus =='')) {
            showBarMessage(EZL_SE002,ERROR_MSG, arrIndex);
            return false;
        }
        // Load condition should not be null;
        if((loadCondition == null) || (loadCondition =='')) {
            showBarMessage(EZL_SE003,ERROR_MSG, arrIndex);
            return false;
        }

        /* Required for Master Validations*/
        lobjContOperator      = document.getElementById('bookingValue[' + intIndex + '].contOperator');
        lobjOutSlotOperator   = document.getElementById('bookingValue[' + intIndex + '].outSlotOperator');
        lobjHandlingInstCode1 = document.getElementById('bookingValue[' + intIndex + '].handlingInstCode1');
        lobjHandlingInstCode2 = document.getElementById('bookingValue[' + intIndex + '].handlingInstCode2');
        lobjHandlingInstCode3 = document.getElementById('bookingValue[' + intIndex + '].handlingInstCode3');

        validateOperatorCode1(lobjContOperator, intIndex);
        // validateOperatorCode1(lobjContOperator);

        //validateOutSlotOperatorCode1(lobjOutSlotOperator);
        validateHandInsCode1(lobjHandlingInstCode1, 1, intIndex);
        validateHandInsCode1(lobjHandlingInstCode2, 2, intIndex);
        validateHandInsCode1(lobjHandlingInstCode3, 3, intIndex);

        if(ERROR_FLAG_CONT_OPR != 'success'){
            showBarMessage(ERROR_FLAG_CONT_OPR,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_OUT_SLOT_OPR != 'success'){
            showBarMessage(ERROR_FLAG_OUT_SLOT_OPR,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_HIC1 != 'success'){
            showBarMessage(ERROR_FLAG_HIC1,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_HIC2 != 'success'){
            showBarMessage(ERROR_FLAG_HIC2,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_HIC3 != 'success'){
            showBarMessage(ERROR_FLAG_HIC3,ERROR_MSG);
            return false;
        }
        /******************************* Stowage position validations *******************************/
        if(
//            ((dischargeStatus=='DI')  ||(dischargeStatus=='ROB')) && /* *2 */
            ((dischargeStatus=='DI')  ||(dischargeStatus=='RB')) && /* *2 */
            ((l_v_service != 'AFS') && (l_v_service != 'DFS')) ){ // added by vikas, afs serve may have blank cell location, 10.01.2012

            if((stowPosition == null) || (stowPosition =='') || (stowPosition =='0000000')) {
                showBarMessage(EZL_SE011,ERROR_MSG, arrIndex);
                return false;
            }
        }

        if(stowPosition!=""){
            if(!checkOnlyNumber(stowPosition)) {
                    showBarMessage(EZL_SE043,ERROR_MSG, arrIndex);
                    return false;
            }
        }
        /* For Vessel Owner value : Owner (O) or Charter(C) or Slot Partner(S),
           check for stowage position format */
        if(stowPosition!=""){

            if(vesselOwner=="O" || vesselOwner=="S" || vesselOwner=="C"){
                /*Check length of Stow Position*/
                if(stowPosition.length <7){
                    showBarMessage(EZL_SE007,ERROR_MSG, arrIndex);
                    return false;
                }

                /*Check first three character of Stow Position*/
                stowPositionF3 = parseInt (stowPosition.substring (0,3), 10);
                // stowPositionF3 = eval (stowPosition.substring (0,3));
                // Check value is even or odd.
                if ((stowPositionF3%2) != 0){
                    // stowPosition is odd.
                    // when size is not equal to ‘20’, then show error
                    if((size !='')){
                        if (size != '20'){
                            showBarMessage(EZL_SE012,ERROR_MSG, arrIndex);
                            return false;
                        }
                    }
                }else{
                    if((size !='')){
                        // when size is equal to ‘40’ or ‘45’, then pass the validation
                        if ((size != '40') && (size != '45')) {
                            showBarMessage(EZL_SE012,ERROR_MSG, arrIndex);
                            return false;
                        }
                    }
                }

                /*Check last two character of Stow Position*/
                stowPositionL2 = parseInt (stowPosition.substring (6,7));
                // Check last two charavter is odd.
                if ((stowPositionL2%2) != 0){
                     showBarMessage(EZL_SE014,ERROR_MSG, arrIndex);
                     return false;
                }
            }
        }

        /******************************* Number Validation Start *******************************/
        if(weight!=""){
            if(!checkFloat(weight, 12,2)) {
                    /*Please enter a valid float*/
                    showBarMessage(EZL_SE019,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(flashPoint!=""){
            /* 
                *1 start
            */
            var firstChar = flashPoint.substring(0,1);
            if (firstChar == '-') {
                flashPoint = flashPoint.substring(1);
            }
            /* 
                *1 end
            */
            if(!checkFloat(flashPoint, 3, 3)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE020,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overheight!=""){
            if(!checkFloat(overheight, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE021,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overwidthLeft!=""){
            if(!checkFloat(overwidthLeft, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE022,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overwidthRight!=""){
            if(!checkFloat(overwidthRight, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE023,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overlengthFront!=""){
            if(!checkFloat(overlengthFront, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE024,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overlengthAfter!=""){
            if(!checkFloat(overlengthAfter, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE025,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(reeferTemp!=""){
            var reeferTemp_val;

            /* Check if negative value is entered */
            var index = reeferTemp.indexOf('-');
            if(index == '0') {
                /* negative value entered*/
                reeferTemp_val = reeferTemp.substring (1,reeferTemp.length - 1);

            }else{
                /* non negative value */
                reeferTemp_val = reeferTemp;
            }

            /* Check for flot value. */
            if(!checkFloat(reeferTemp_val, 3, 3)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE046,ERROR_MSG, arrIndex);
                     return false;
            }
        }
        if(humidity!=""){
            if(!checkFloat(humidity, 3, 2)) {
                showBarMessage(EZL_SE037,ERROR_MSG, arrIndex);
                return false;
            }
        }
        if(ventilation!=""){
            if(!checkFloat(ventilation, 3, 2)) {
                showBarMessage(EZL_SE056,ERROR_MSG, arrIndex);
                return false;
            }
        }
        /******************************* Number Validation End *******************************/
        if(strActivityDateTime!=""){
            /*
                Start added by vikas,
                In case of afs service when user change the
                stowage position, screen shows error msg
                invalid activity code
                on 09.01.2012
            */
            strActivityDateTime = trimString(strActivityDateTime);
            if(strActivityDateTime.length == 10) {
                strActivityDateTime = strActivityDateTime + " 00:00";
            }

            /*
                End added by vikas, 09.01.2012
            */

            if(!isValidDateTime(strActivityDateTime)) {
                    //Invalid Date Format
                    showBarMessage(EZL_SE013,ERROR_MSG, arrIndex);
                    return false;
            }
        }

        if(strMloETADate!=""){
            if(!isValidDateTime(strMloETADate)) {
                    //Invalid Date Format
                    showBarMessage(EZL_SE009,ERROR_MSG, arrIndex);
                    return false;
            }
        }

    intIndex = parseInt(intIndex)  + 1;
    }//end of loop

    return true;

} // end of function saveValidationBookingTab

//Function to validate fields in Overlanded tab
function saveValidationOverlandedTab() {

    var intIndex =  0;
    var arrIndex  = new Array();
    var status ='';
    while (intIndex < getGridControl().getTotalDataNumber()){
        status              = document.getElementById('overlandedValue[' + intIndex + '].status').value;
        /* Check the record is updated or not. */
        if((status == '') ||( status == null)){
            intIndex = parseInt(intIndex)  + 1;
            continue;
        }

        bookingNo           = document.getElementById('overlandedValue[' + intIndex + '].bookingNo').value;
        equipmentNo         = document.getElementById('overlandedValue[' + intIndex + '].equipmentNo').value;
        contOperator        = document.getElementById('overlandedValue[' + intIndex + '].contOperator').value;
        dischargeStatus     = document.getElementById('overlandedValue[' + intIndex + '].dischargeSts').value;
        loadCondition       = document.getElementById('overlandedValue[' + intIndex + '].loadCondition').value;
        socCoc              = document.getElementById('overlandedValue[' + intIndex + '].socCoc').value;
        fullMt              = document.getElementById('overlandedValue[' + intIndex + '].fullMT').value;
        bookingTyp          = document.getElementById('overlandedValue[' + intIndex + '].bookingType').value;
        stowPosition        = document.getElementById('overlandedValue[' + intIndex + '].stowPosition').value;
        size                = document.getElementById('overlandedValue[' + intIndex + '].size').value;
        dischargeListStatus = document.getElementById('dischargeListStatus').value;
        weight              = document.getElementById('overlandedValue[' + intIndex + '].weight').value;
        flashPoint          = document.getElementById('overlandedValue[' + intIndex + '].flashPoint').value;
        overheight          = document.getElementById('overlandedValue[' + intIndex + '].overheight').value;
        overwidthLeft       = document.getElementById('overlandedValue[' + intIndex + '].overwidthLeft').value;
        overwidthRight      = document.getElementById('overlandedValue[' + intIndex + '].overwidthRight').value;
        overlengthFront     = document.getElementById('overlandedValue[' + intIndex + '].overlengthFront').value;
        overlengthAfter     = document.getElementById('overlandedValue[' + intIndex + '].overlengthAfter').value;
        reeferTemp          = document.getElementById('overlandedValue[' + intIndex + '].reeferTemp').value;
        humidity            = document.getElementById('overlandedValue[' + intIndex + '].humidity').value;
        ventilation         = document.getElementById('overlandedValue[' + intIndex + '].ventilation').value;
        shipmentType        = document.getElementById('overlandedValue[' + intIndex + '].shipmentType').value;
        shipmentTerm        = document.getElementById('overlandedValue[' + intIndex + '].shipmentTerm').value;
        slotOperator        = document.getElementById('overlandedValue[' + intIndex + '].slotOperator').value;
        specialCargo        = document.getElementById('overlandedValue[' + intIndex + '].specialCargo').value;
        vesselOwner           = document.getElementById('vesselOwner').value;
        strMloETADate         = document.getElementById('overlandedValue[' + intIndex + '].mloETADate').value;
        strActivityDateTime = document.getElementById('overlandedValue[' + intIndex + '].activityDate').value;

        arrIndex[0] = intIndex+1;

        /* Check Equipment# is mandatory if the status is ADD */
        if(status == 'ADD'){
            if((equipmentNo == null) || (equipmentNo =='')) {
                showBarMessage(EZL_SE004,ERROR_MSG);
                return false;
            }
        }

        /*Required for Master Validations*/
        lobjEquipmentType     = document.getElementById('overlandedValue[' + intIndex + '].equipmentType');
        lobjShipmentTerm      = document.getElementById('overlandedValue[' + intIndex + '].shipmentTerm');
        lobjSlotOperator      = document.getElementById('overlandedValue[' + intIndex + '].slotOperator');
        lobjContOperator      = document.getElementById('overlandedValue[' + intIndex + '].contOperator');
        lobjOutSlotOperator   = document.getElementById('overlandedValue[' + intIndex + '].outSlotOperator');
        lobjPol               = document.getElementById('overlandedValue[' + intIndex + '].pol');
        lobjPolTerminal       = document.getElementById('overlandedValue[' + intIndex + '].polTerminal');
        lobjHandlingInstCode1 = document.getElementById('overlandedValue[' + intIndex + '].handlingInstCode1');
        lobjHandlingInstCode2 = document.getElementById('overlandedValue[' + intIndex + '].handlingInstCode2');
        lobjHandlingInstCode3 = document.getElementById('overlandedValue[' + intIndex + '].handlingInstCode3');

        /*Perform Master Validation */
        validateEquipmentType1(lobjEquipmentType);
        validateShipmentTerm1(lobjShipmentTerm);

        // validateSlotOperatorCode(lobjSlotOperator);
        validateSlotOperatorCode(lobjSlotOperator, intIndex);

        // validateOperatorCode1(lobjContOperator);
        validateOperatorCode1(lobjContOperator, intIndex);

        //validateOutSlotOperatorCode(lobjOutSlotOperator);
        validatePortCode1(lobjPol);
        validatePortTerminal1(lobjPolTerminal);
        validateHandInsCode1(lobjHandlingInstCode1, 1, intIndex);
        validateHandInsCode1(lobjHandlingInstCode2, 2, intIndex);
        validateHandInsCode1(lobjHandlingInstCode3, 3, intIndex);

        if(ERROR_FLAG_EQUIP_TYPE != 'success'){
            showBarMessage(ERROR_FLAG_EQUIP_TYPE,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_SHPMNT_TERM != 'success'){
            showBarMessage(ERROR_FLAG_SHPMNT_TERM,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_SLOT_OPR != 'success'){
            showBarMessage(ERROR_FLAG_SLOT_OPR,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_CONT_OPR != 'success'){
            showBarMessage(ERROR_FLAG_CONT_OPR,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_OUT_SLOT_OPR != 'success'){
            showBarMessage(ERROR_FLAG_OUT_SLOT_OPR,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_PORT_CODE != 'success'){
            showBarMessage(ERROR_FLAG_PORT_CODE,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_PORT_TERMINAL != 'success'){
            showBarMessage(ERROR_FLAG_PORT_TERMINAL,ERROR_MSG);
            return false;
        }
            if(ERROR_FLAG_HIC1 != 'success'){
            showBarMessage(ERROR_FLAG_HIC1,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_HIC2 != 'success'){
            showBarMessage(ERROR_FLAG_HIC2,ERROR_MSG);
            return false;
        }
        if(ERROR_FLAG_HIC3 != 'success'){
            showBarMessage(ERROR_FLAG_HIC3,ERROR_MSG);
            return false;
        }

         /******************************* Stowage position validations *******************************/
        if((dischargeStatus=='DC')||(dischargeStatus=='DR')) {
            if((stowPosition == null) || (stowPosition =='') || (stowPosition =='0000000')) {
                showBarMessage(EZL_SE011,ERROR_MSG, arrIndex);
                return false;
            }
        }
        if(stowPosition!=""){
            if(!checkOnlyNumber(stowPosition)) {
                    showBarMessage(EZL_SE043,ERROR_MSG, arrIndex);
                    return false;
            }
        }
        /* For Vessel Owner value : Owner (O) or Charter(C) or Slot Partner(S),
           check for stowage position format */
        if(stowPosition!=""){
            if(vesselOwner=="O" || vesselOwner=="S" || vesselOwner=="C"){
                /*Check length of Stow Position*/
                if(stowPosition.length <7){
                    showBarMessage(EZL_SE007,ERROR_MSG, arrIndex);
                    return false;
                }

                /*Check first three character of Stow Position*/
                stowPositionF3 = parseInt (stowPosition.substring (0,3), 10);
                // Check value is even or odd.
                if ((stowPositionF3%2) != 0){
                    // stowPosition is odd.
                    // when size is not equal to ‘20’, then show error
                    if((size !='')){
                    if (size != '20'){
                        showBarMessage(EZL_SE012, ERROR_MSG, arrIndex);
                        return false;
                        }
                    }
                    }else{
                    if((size !='')){
                        // when size is equal to ‘40’ or ‘45’, then pass the validation
                        if ((size != '40') && (size != '45')) {
                            showBarMessage(EZL_SE012,ERROR_MSG, arrIndex);
                            return false;
                        }
                    }
                }

                /*Check last two character of Stow Position*/
                stowPositionL2 = parseInt (stowPosition.substring (6,7));
                // Check last two charavter is odd.
                if ((stowPositionL2%2) != 0){
                     showBarMessage(EZL_SE014,ERROR_MSG, arrIndex);
                     return false;
                }
            }
        }

        /********** When discharge status is not Over Landed then check mandatory fields *********/

        if(dischargeStatus != 'OL') {

            if((bookingNo == null) || (bookingNo == '')) {
                 showBarMessage(EZL_SE055,ERROR_MSG, arrIndex);
                 return false;
            }

            if((loadCondition == null) || (loadCondition == '')) {
                 showBarMessage(EZL_SE026,ERROR_MSG, arrIndex);
                 return false;
            }

            if((shipmentTerm == null) || (shipmentTerm == '')){
                 showBarMessage(EZL_SE027,ERROR_MSG, arrIndex);
                 return false;
            }

            if((shipmentType == null) || (shipmentType == '')) {
                 showBarMessage(EZL_SE028,ERROR_MSG, arrIndex);
                 return false;
            }

            if((equipmentNo == null )|| (equipmentNo == '')){
                 showBarMessage(EZL_SE029,ERROR_MSG, arrIndex);
                 return false;
            }

            if((contOperator == null ) || (contOperator == '')){
                 showBarMessage(EZL_SE030,ERROR_MSG, arrIndex);
                 return false;
            }

            if((size == null ) ||(size == '')){
                 showBarMessage(EZL_SE031,ERROR_MSG, arrIndex);
                 return false;
            }


            if((bookingTyp == null )||(bookingTyp == '')){
                 showBarMessage(EZL_SE032,ERROR_MSG, arrIndex);
                 return false;
            }

            if((slotOperator == null ) || (slotOperator == '')){
                 showBarMessage(EZL_SE033,ERROR_MSG, arrIndex);
                 return false;
            }
/*
            if((specialCargo == null )||(specialCargo == '')){
                 showBarMessage(EZL_SE034,ERROR_MSG);
                 return false;
            }
*/
            if((socCoc == null )||(socCoc == '')){
                 showBarMessage(EZL_SE035,ERROR_MSG, arrIndex);
                 return false;
            }
        }

        /******************************* Mandatory Validation Ends *************************/
        /******************************* Number Validation Start ******************************/

        if(size!=""){
            if(!checkOnlyNumber(size)) {
                    showBarMessage(EZL_SE036,ERROR_MSG, arrIndex);
                    return false;
            }
        }
        if(weight!=""){
            if(!checkFloat(weight, 12,2)) {
                    /*Please enter a valid float*/
                    showBarMessage(EZL_SE019,ERROR_MSG, arrIndex);
                     return false;
            }
        }
        if(flashPoint!=""){
            /* 
                *1 start
            */
            var firstChar = flashPoint.substring(0,1);
            if (firstChar == '-') {
                flashPoint = flashPoint.substring(1);
            }
            /* 
                *1 end
            */
        
            if(!checkFloat(flashPoint, 3, 3)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE020,ERROR_MSG, arrIndex);
                     return false;
            }
        }
        if(overheight!=""){
            if(!checkFloat(overheight, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE021,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overwidthLeft!=""){
            if(!checkFloat(overwidthLeft, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE022,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overwidthRight!=""){
            if(!checkFloat(overwidthRight, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE023,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overlengthFront!=""){
            if(!checkFloat(overlengthFront, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE024,ERROR_MSG, arrIndex);
                     return false;
            }
        }

        if(overlengthAfter!=""){
            if(!checkFloat(overlengthAfter, 10, 4)) {
                    /* Please enter a valid float' */
                    showBarMessage(EZL_SE025,ERROR_MSG, arrIndex);
                     return false;
            }
        }

       if(reeferTemp!=""){
            var reeferTemp_val;

            /* Check if negative value is entered */
            var index = reeferTemp.indexOf('-');
            if(index == '0') {
                /* negative value entered*/
                reeferTemp_val = reeferTemp.substring (1,reeferTemp.length - 1);

            }else{
                /* non negative value */
                reeferTemp_val = reeferTemp;
            }

            /* Check for flot value. */
            if(!checkFloat(reeferTemp_val, 3, 3)) {
                /* Please enter a valid float' */
                showBarMessage(EZL_SE046,ERROR_MSG, arrIndex);
                return false;
            }
        }


        if(humidity!=""){
            if(!checkFloat(humidity, 3, 2)) {
                showBarMessage(EZL_SE037,ERROR_MSG, arrIndex);
                return false;
            }
        }
        if(ventilation!=""){
            if(!checkFloat(ventilation, 3, 2)) {
                showBarMessage(EZL_SE056,ERROR_MSG, arrIndex);
                return false;
            }
        }

        /***************************** Number Validation End *******************************/
        if(strActivityDateTime!=""){
            if(!isValidDateTime(strActivityDateTime)) {
                    //Invalid Date Format
                    showBarMessage(EZL_SE013,ERROR_MSG, arrIndex);
                    return false;
            }
        }

        if(strMloETADate!=""){
            if(!isValidDateTime(strMloETADate)) {
                    //Invalid Date Format
                    showBarMessage(EZL_SE009,ERROR_MSG, arrIndex);
                    return false;
            }
        }

    intIndex = parseInt(intIndex)  + 1;
    }// end of loop
    return true;
}// end of function.

//Function to validate fields in restowed tab
function saveValidationRestowed() {

    var intIndex  =  0;
    var arrIndex  = new Array();
    var status ='';
    while (intIndex < getGridControl().getTotalDataNumber()){

        status              = document.getElementById('restowedValue[' + intIndex + '].status').value;
        /* Check the record is updated or not. */
        if((status == '') ||( status == null)){
            intIndex = parseInt(intIndex)  + 1;
            continue;
        }
        equipmentNo     = document.getElementById('restowedValue[' + intIndex + '].equipmentNo').value;
        stowPosition    = document.getElementById('restowedValue[' + intIndex + '].stowPosition').value;
        restowSts       = document.getElementById('restowedValue[' + intIndex + '].restowSts').value;
        size            = document.getElementById('restowedValue[' + intIndex + '].size').value;
        vesselOwner     = document.getElementById('vesselOwner').value;
        weight          = document.getElementById('restowedValue[' + intIndex + '].weight').value;
        activityDateTime = document.getElementById('restowedValue[' + intIndex + '].activityDateTime').value;
        arrIndex[0] = intIndex+1;


        // Equipment # should not be null;
        if((equipmentNo == null) || (equipmentNo =='')) {
            showBarMessage(EZL_SE051,ERROR_MSG, arrIndex);
            return false;
        }

        // Stowage Position should not be null;
        if((stowPosition == null) || (stowPosition =='') || (stowPosition =='0000000')) {
            showBarMessage(EZL_SE011,ERROR_MSG, arrIndex);
            return false;
        }

        // Restow Status should not be null;
        if((restowSts == null) || (restowSts =='')) {
            showBarMessage(EZL_SE057,ERROR_MSG, arrIndex);
            return false;
        }


        if(stowPosition!=""){
            if(!checkOnlyNumber(stowPosition)) {
                showBarMessage(EZL_SE043,ERROR_MSG, arrIndex);
                return false;
            }
        }

        /* For Vessel Owner value : Owner (O) or Charter(C) or Slot Partner(S),
           check for stowage position format */
        if(vesselOwner=="O" || vesselOwner=="S" || vesselOwner=="C"){
            /*Check length of Stow Position*/
            if(stowPosition.length <7){
                showBarMessage(EZL_SE007,ERROR_MSG, arrIndex);
                return false;
            }

            /*Check first three character of Stow Position*/
            stowPositionF3 = parseInt (stowPosition.substring (0,3), 10);
            // Check value is even or odd.
            if ((stowPositionF3%2) != 0){
                // stowPosition is odd.
                // when size is not equal to ‘20’, then show error
                if((size !='')){
                if (size != '20'){
                    showBarMessage(EZL_SE012,ERROR_MSG, arrIndex);
                    return false;
                    }
                }
                }else{
                if((size !='')){
                    // when size is equal to ‘40’ or ‘45’, then pass the validation
                    if ((size != '40') && (size != '45')) {
                        showBarMessage(EZL_SE012,ERROR_MSG, arrIndex);
                        return false;
                    }
                }
            }

            /*Check last two character of Stow Position*/
            stowPositionL2 = parseInt (stowPosition.substring (6,7));
            // Check last two charavter is odd.
            if ((stowPositionL2%2) != 0){
                 showBarMessage(EZL_SE014,ERROR_MSG, arrIndex);
                 return false;
            }
        }
        if(weight!=""){
            if(!checkFloat(weight, 12,2)) {
                /*Please enter a valid float*/
                showBarMessage(EZL_SE019,ERROR_MSG, arrIndex);
                return false;
            }
        }

        if(activityDateTime!=""){
            if(!isValidDateTime(activityDateTime)) {
                    //Invalid Date Format
                    showBarMessage(EZL_SE013,ERROR_MSG, arrIndex);
                    return false;
            }
        }

        intIndex = parseInt(intIndex)  + 1;
    } // end of loop
    return true;
}// end of function saveValidationRestowed

//Function for left padding
function pad(number, length) {
    var str = '' + number;
    while (str.length < length && str.length > 0) {
        str = '0' + str;
    }

    if(str.length == 0){
     str = '';
    }
    return str;
}//end of function pad

//function to be called on change of stowage position
function onChangeStowagePosition(arow){
    //Get the current tab value
    var currTab      = document.forms[0].currTabSelected.value;
    if(currTab == '1'){
        //var vesselOwner =  document.getElementById('bookingValue[' + arow + '].vesselOwner').value;
        stowPosition    = document.getElementById('bookingValue[' + arow + '].stowPosition').value;
    }else if(currTab == '2'){
        //var vesselOwner =  document.getElementById('overlandedValue[' + arow + '].vesselOwner').value;
        stowPosition    = document.getElementById('overlandedValue[' + arow + '].stowPosition').value;
    }else if(currTab == '3'){
        //var vesselOwner =  document.getElementById('restowedValue[' + arow + '].vesselOwner').value;
        stowPosition    = document.getElementById('restowedValue[' + arow + '].stowPosition').value;
    }

    /* For Vessel Owner value : Owner (O) or Charter(C) or Slot Partner(S),
       check for stowage position format */
    var vesselOwner = "O";

    if(vesselOwner=="O" || vesselOwner=="S" || vesselOwner=="C"){
        stowPosition = trimString(stowPosition);
        if (stowPosition.length < 7) {
            stowPosition = pad(stowPosition,7);
        }
    }

    if(currTab == '1'){
        document.getElementById('bookingValue[' + arow + '].stowPosition').value = stowPosition;
    }else if(currTab == '2'){
        document.getElementById('overlandedValue[' + arow + '].stowPosition').value = stowPosition;
    }else if(currTab == '3'){
        document.getElementById('restowedValue[' + arow + '].stowPosition').value = stowPosition;
    }



}//end of onChangeStowagePosition function


//function to be called on change of socCoc in overlanded tab
function onChangeCocSoc(arow){
    //Get the current tab value
    var currTab      = document.forms[0].currTabSelected.value;
    if(currTab == '2'){
        socCoc       = document.getElementById('overlandedValue[' + arow + '].socCoc').value;
        lobjContOperator = document.getElementById('overlandedValue[' + arow + '].contOperator');

        if(socCoc == 'C'){
            lobjContOperator.value = "RCL";
            lobjContOperator.disabled = true;
            lobjContOperator.readOnly = true;
            lobjContOperator.style.backgroundColor = "#EBEEEA";
            //document.getElementById("btnContOperatorCodeLookup").disabled = true;
            var lstrBodyContent = lobjContOperator.outerHTML;
            lstrBodyContent = lstrBodyContent + '&nbsp;'+'<input type="button" value=". . ."  name="btnContOperatorCodeLookup" class="btnbutton" disabled="true"; onclick="openContainerOperatorLookup('+arow+')"/>';
            updateCellBodyContent(arow, 'contOperator', lstrBodyContent, false);
        }else{
            lobjContOperator.value = "";
            lobjContOperator.disabled = false;
            lobjContOperator.readOnly = false;
            lobjContOperator.style.background = 'white';
            lobjContOperator.style.color      = 'black';
            //document.getElementById("btnContOperatorCodeLookup").disabled = false;
            var lstrBodyContent = lobjContOperator.outerHTML;
            lstrBodyContent = lstrBodyContent + '&nbsp;'+'<input type="button" value=". . ."  name="btnContOperatorCodeLookup" class="btnbutton" onclick="openContainerOperatorLookup('+arow+')"/>';
            updateCellBodyContent(arow, 'contOperator', lstrBodyContent, false);

        }
    }

}

//function to be called on change of special handling
function onChangeSpecialHandling(arow){
    //Get the current tab value
    var currTab      = document.forms[0].currTabSelected.value;
    if(currTab == '2'){
        specialHandling  = document.getElementById('overlandedValue[' + arow + '].specialHandling').value;
        lobjResidue = document.getElementById('overlandedValue[' + arow + '].residue');
        if(specialHandling != 'D1'){
            lobjResidue.value = "";
            lobjResidue.disabled = true;
            lobjResidue.readOnly = true;
            lobjResidue.style.backgroundColor = "#EBEEEA";
            //updateCellBodyContent(arow, 'contOperator', lstrBodyContent, false);
        }else{
            lobjResidue.disabled = false;
            lobjResidue.readOnly = false;
            lobjResidue.style.background = 'white';
            lobjResidue.style.color      = 'black';
            //updateCellBodyContent(arow, 'contOperator', lstrBodyContent, false);
        }
    }
}

//function to be called on change of restow status in restowed tab
function onChangeRestowStatus(arow){
    //Get the current tab value
    var currTab      = document.forms[0].currTabSelected.value;
    if(currTab == '3'){
        restowSts    = document.getElementById('restowedValue[' + arow + '].restowSts').value;
        weight       = document.getElementById('restowedValue[' + arow + '].weight');

        if(restowSts != 'LC'){
            weight.value = '';
            weight.disabled = true;
            weight.readOnly = true;
            weight.style.backgroundColor = "#EBEEEA";
        }else{
            weight.value = "";
            weight.disabled = false;
            weight.readOnly = false;
            weight.style.background = 'white';
            weight.style.color      = 'black';
        }
    }

}

// function to set the booking record open status for update.
function updateBookingStatusFlage(arow){
//    Set the status flag to UPD (updated)
      document.getElementById('bookingValue[' + arow + '].status').value = 'UPD';
      document.forms[0].updFlag.value = 'Y';
} // end of function updateBookingStatusFlage

// function to set the overlaned record open status for update.
function updateOverlandedStatusFlage(arow, aintColumnId, aobjControl){

var lstrBodyContent;
var lstrControlName;

    if(aintColumnId!=null){
        lstrBodyContent = aobjControl.outerHTML;
        lstrControlName =  (aobjControl.name).substring(aobjControl.name.indexOf(".")+1);
        if((lstrControlName == "contOperator") && (document.getElementById('overlandedValue[' + arow + '].socCoc').value == 'C')){
            return false;
        }
        if(lstrControlName == "equipmentType"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnEquipmentTypeLookup").outerHTML;
            lstrBodyContent = lstrBodyContent + '&nbsp;'+'<input type="button" value=". . ."  name="btnEquipmentTypeLookup" class="btnbutton" onclick="openEquipmentTypeLookup('+arow+')"/>';
        } else if(lstrControlName == "slotOperator"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnSlotOperatorCodeLookup").outerHTML;
            lstrBodyContent = lstrBodyContent + '&nbsp;'+'<input type="button" value=". . ."  name="btnSlotOperatorCodeLookup" class="btnbutton" onclick="openSlotOperatorLookup('+arow+')"/>';
        } else if(lstrControlName == "contOperator"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnContOperatorCodeLookup").outerHTML;
            lstrBodyContent = lstrBodyContent + '&nbsp;'+'<input type="button" value=". . ."  name="btnContOperatorCodeLookup" class="btnbutton" onclick="openContainerOperatorLookup('+arow+')"/>';
        } else if(lstrControlName == "outSlotOperator"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnOutSlotOperatorCodeLookup").outerHTML;
            lstrBodyContent = lstrBodyContent +'&nbsp;'+'<input type="button" value=". . ."  name="btnOutSlotOperatorCodeLookup" class="btnbutton" onclick="openOutSlotOperatorLookup('+arow+')"/>';
        } else if(lstrControlName == "pol"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnPolLookup").outerHTML;
            lstrBodyContent = lstrBodyContent +'&nbsp;'+'<input type="button" value=". . ."  name="btnPolLookup" class="btnbutton" onclick="openPodLookup('+arow+')"/>';
        } else if(lstrControlName == "polTerminal"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnPolTerminalLookup").outerHTML;
            lstrBodyContent = lstrBodyContent +'&nbsp;'+'<input type="button" value=". . ."  name="btnPolTerminalLookup" class="btnbutton" onclick="openPodTerminalLookup('+arow+')"/>';
        } else if(lstrControlName == "handlingInstCode1"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnHandlingInsCode1Lookup").outerHTML;
            lstrBodyContent = lstrBodyContent +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup1('+arow+')"/>';
        } else if(lstrControlName == "handlingInstCode2"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnHandlingInsCode2Lookup").outerHTML;
            lstrBodyContent = lstrBodyContent +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup2('+arow+')"/>';
        } else if(lstrControlName == "handlingInstCode3"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnHandlingInsCode3Lookup").outerHTML;
            lstrBodyContent = lstrBodyContent+'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup3('+arow+')"/>';
        } else if(lstrControlName == "unNumber"){
            //lstrBodyContent = lstrBodyContent + "&nbsp;"+document.getElementById("btnUNNoLookup").outerHTML;
            lstrBodyContent = lstrBodyContent+'&nbsp;'+'<input type="button" value=". . ."  name="btnUNNoLookup" class="btnbutton" onclick="openUNNoLookup('+arow+',3)"/>';
        } else if(lstrControlName == "mloETADate"){

            lstrBodyContent = lstrBodyContent + "&nbsp;"
            +'<a href="#" name ="mloETADateCalendar" onClick="showCalendarWithTime(\'overlandedValue['+arow+'].mloETADate\', \'\', \'\', \'1\')"><img src="'+ctxPath1+'/images/btnCalendar.gif" alt="Calender" class="calender"></a>';
        } else if(lstrControlName == "activityDate"){

            lstrBodyContent = lstrBodyContent + "&nbsp;"
            +'<a href="#" name ="activityDateCalendar" onClick="showCalendarWithTime(\'overlandedValue['+arow+'].activityDate\', \'\', \'\', \'1\')"><img src="'+ctxPath1+'/images/btnCalendar.gif" alt="Calender" class="calender"></a>';
        }


        updateCellBodyContent(arow, aintColumnId, lstrBodyContent, false);
    }
    // Set the status flag to UPD (updated)
    if(document.getElementById('overlandedValue[' + arow + '].status').value != 'ADD'){
        document.getElementById('overlandedValue[' + arow + '].status').value = 'UPD';
    }

    if(lstrControlName != "mergeAction") {
        document.forms[0].updFlag.value = 'Y';
    }

} // end of function updateOverlandedStatusFlage

// function to set the restowe record open status for update.
function updateRestowedStatusFlage(arow, aintColumnId, aobjControl){

var lstrBodyContent;
var lstrControlName;

    if(aintColumnId!=null){
        lstrBodyContent = aobjControl.outerHTML;
        lstrControlName =  (aobjControl.name).substring(aobjControl.name.indexOf(".")+1);

        if(lstrControlName == "activityDateTime"){
            lstrBodyContent = lstrBodyContent + "&nbsp;"
            +'<a href="#" name ="activityDateCalendar" onClick="showCalendarWithTime(\'restowedValue['+arow+'].activityDateTime\', \'\', \'\', \'1\')"><img src="'+ctxPath1+'/images/btnCalendar.gif" alt="Calender" class="calender"></a>';
        }

        updateCellBodyContent(arow, aintColumnId, lstrBodyContent, false);
    }
    if(document.getElementById('restowedValue[' + arow + '].status').value != 'ADD'){
        //    Set the status flag to UPD (updated)
        document.getElementById('restowedValue[' + arow + '].status').value = 'UPD';
    }
    document.forms[0].updFlag.value = 'Y';

} // end of function updateRestowedStatusFlage


function getLastIndex(table,numRow){

    var rowID=table.rows(numRow-1).id;
    var rowNum=rowID.substring(3);
    var lastIndex=eval( parseInt(rowNum) + 1);

    return lastIndex;
}

function checkOnlyNumber(strFieldValue) {
    numFormat = /^([0-9]+)$/;
    if((strFieldValue.length > 0)&&(numFormat.test(strFieldValue))){
    }else{
        return false;
    }
    return true;
}

function checkFloat(strFieldValue,intBeforeDotDigitNumber,intAfterDotDigitNumber) {
    
    var re=new RegExp(",","g");
    if(strFieldValue!=null &strFieldValue.length>0){
    strFieldValue=strFieldValue.replace(re,"");
    }else{
    return false;
    }
    
    var strNumFormat = "(^([0-9]{1,"+intBeforeDotDigitNumber+"})$)|(^([0-9]{1,"+intBeforeDotDigitNumber+"}\\.[0-9]{1,"+intAfterDotDigitNumber+"})$)"; 

    numFormat = new RegExp(strNumFormat,"g");
    if((strFieldValue.length > 0)&&(numFormat.test(strFieldValue))){
    }else{
        return false;
    }
    return true;
}


function onSaveSett() {

    var strSearchCriteria = '';
    strSearchCriteria = setSearchCriteria();

    var currTab     = document.forms[0].currTabSelected.value;
    if(currTab == '1'){
        var screenName = '2';
        var viewId = document.getElementById("bookedView").value;
    }else if(currTab == '2'){
        var screenName = '3';
        var viewId = document.getElementById("overlandedView").value;
    }else if(currTab == '3'){
        var screenName = '4';
        var viewId = document.getElementById("restowedView").value;

    }

    var pageId = document.getElementById("pageId").value;

    getGridControl().updateServerModel();

    var urlStr = SAVESETTINGS +screenName+'&pageId='+pageId+'&searchCriteria='+strSearchCriteria+'&viewId='+viewId;

    document.forms[0].action = FIND;
    document.forms[0].submit();

    openChildWindow(urlStr,window,'500px','350px');

    onRefresh();

        //document.forms[0].action=SAVESETTINGS +screenName+'&pageId='+pageId+'&searchCriteria='+strSearchCriteria+'&viewId='+viewId;
    //document.forms[0].submit();

    return false;
}

function declareDischargeList(){

    var mode     = 'D';
    var listId   = document.forms[0].dischargeListId.value;
    var terminal = document.getElementById("hdrTerminal").value;

    var urlStr = DECLARELL+mode+'&listId='+listId+'&terminal='+terminal;
     openChildScreen64(urlStr,FORM_ID);

    return false;
}

function createArrivalBayplan(){
    var screenName      = '1';
    var pageId          = document.getElementById("pageId").value;
    var port            = document.getElementById("hdrPort").value;
    var terminal        = document.getElementById("hdrTerminal").value;
    var viewId='';
    var service         = document.getElementById("hdrService").value;
    var vessel          = document.getElementById("hdrVessel").value;
    var eta             = document.getElementById("hdrEtaDateTime").value;
    var voyage          = document.getElementById("hdrVoyage").value;
    var direction       = document.getElementById("hdrDirection").value;

    var urlStr = CREATEARVLBAYPLAN+screenName+'&pageId='+pageId+'&arrivalPort='+port+'&arrivalTerminal='+terminal+'&viewId='+viewId+'&service='+service+'&vessel='+vessel+'&eta='+eta+'&voyage='+voyage+'&direction='+direction+'&tmp='+terminal+'&lldlflag=D';
    // openChildWindow(urlStr,window,'1000px','500px');
    openChildScreen64(urlStr,FORM_ID);

    return false;
}

function excelUpload(){
        var screenParameter = 'D';
        var urlStr = EXCELUPLOAD +screenParameter;
            //set the action
       openChildScreen64(urlStr,FORM_ID);
}

function excelDownload(){

    var screenParameter = 'D';
    var currentTab         = document.forms[0].currTabSelected.value;
    if(currentTab == '1'){
        currentTab ='Booked';
    }else if(currentTab == '2'){
        currentTab ='Overlanded';
    }else if(currentTab == '3'){
        currentTab ='Restowed';
    }

    var find1Booked            = document.getElementById("bookedFind1").value;
    var in1Booked          = document.getElementById("bookedIn1").value;
    var find2Booked           = document.getElementById("bookedFind2").value;
    var in2Booked               = document.getElementById("bookedIn2").value;
    var order1Booked           = document.getElementById("bookedOrder1").value;
    var order1orderBooked      = document.getElementById("bookedOrder1Ord").value;
    var order2Booked           = document.getElementById("bookedOrder2").value;
    var order2orderBooked      = document.getElementById("bookedOrder2Ord").value;

    var find1OverLanded         = document.getElementById("overlandedFind1").value;
    var in1OverLanded           = document.getElementById("overlandedIn1").value;
    var find2OverLanded         = document.getElementById("overlandedFind2").value;
    var in2OverLanded           = document.getElementById("overlandedIn2").value;
    var order1OverLanded        = document.getElementById("overlandedOrder1").value;
    var order1orderOverLanded   = document.getElementById("overlandedOrder1Ord").value;
    var order2OverLanded        = document.getElementById("overlandedOrder2").value;
    var order2orderOverLanded   = document.getElementById("overlandedOrder2Ord").value;

    var find1Restowed           = document.getElementById("restowedFind1").value;
    var in1Restowed             = document.getElementById("restowedIn1").value;
    var find2Restowed           = document.getElementById("restowedFind2").value;
    var in2Restowed             = document.getElementById("restowedIn2").value;
    var order1Restowed          = document.getElementById("restowedOrder1").value;
    var order1orderRestowed     = document.getElementById("restowedOrder1Ord").value;
    var order2Restowed          = document.getElementById("restowedOrder2").value;
    var order2orderRestowed     = document.getElementById("restowedOrder2Ord").value;

    var dischargelistId = document.forms[0].dischargeListId.value;

    var urlStr = EXCELDOWNLOAD +screenParameter+'&currentTab='+currentTab+'&dischargelistId='+dischargelistId+'&find1Booked='+find1Booked+'&in1Booked='+in1Booked+'&find2Booked='+find2Booked+'&in2Booked='+in2Booked+'&order1Booked='+order1Booked+'&order1orderBooked='+order1orderBooked+'&order2Booked='+order2Booked+'&order2orderBooked='+order2orderBooked+'&find1OverLanded='+find1OverLanded+'&in1OverLanded='+in1OverLanded+'&find2OverLanded='+find2OverLanded+'&in2OverLanded='+in2OverLanded+'&order1OverLanded='+order1OverLanded+'&order1orderOverLanded='+order1orderOverLanded+'&order2OverLanded='+order2OverLanded+'&order2orderOverLanded='+order2orderOverLanded+'&find1Restowed='+find1Restowed+'&in1Restowed='+in1Restowed+'&find2Restowed='+find2Restowed+'&in2Restowed='+in2Restowed+'&order1Restowed='+order1Restowed+'&order1orderRestowed='+order1orderRestowed+'&order2Restowed='+order2Restowed+'&order2orderRestowed='+order2orderRestowed;
    openChildScreen64(urlStr,FORM_ID);
}

function bulkUpdate(tabFlagValue){
    /* tabFlagValue is '1' for Overlanded / Overshipped tab.
    tabFlagValue is '2' for Booked tab */
    
    var dischargeListId =  document.getElementById("dischargeListId").value;
    var fromAta     = document.getElementById("fromAta").value;
    var ataTime = document.getElementById("ataTime").value;
    var atdTime = document.getElementById("atdTime").value;
    /*
        Change by vikas, when service is 'AFS' and vessel is BARGE then sytem 
        does't have ata time. so set default time value to 12:00, 14.06.2012
    */
    var l_v_service     = document.getElementById("hdrService").value;
    var l_v_vessel      = document.getElementById("hdrVessel").value;   
 
    if ((l_v_service == 'AFS') && (l_v_vessel == 'BARGE')) {
        ataTime = '12:00';
        atdTime = '12:00';
    }
    /*
        Change by vikas, End , 14.06.2012
    */
    
    var urlStr = BULKUPDATE +'D'+'&tabFlag='+tabFlagValue
    +'&listId='+dischargeListId
    +'&fromAta='+fromAta
    +'&ataTime='+ataTime
    +'&atdTime='+atdTime;
    
    openChildWindow(urlStr,FORM_ID, '1100px', '700px');
    return false;
}

function automatch(){
    /* When Any Changes to save, then ask to save changes. */
    if(document.forms[0].updFlag.value == 'Y'){
        showBarMessage(ECM_GE0013, ERROR_MSG);
        return;
    }


    document.getElementById("matchingFlag").value = 'A';
    /* Disable all controls */
    disableOnSubmit();
    document.forms[0].action = MATCH;
    document.forms[0].submit();
    return false;

}

function matching(){
    var selectedIndex   = null;
    var hdrService      = '';
    var hdrVesselName   = '';

    searchPerformed = document.getElementById("overlandedTabFind").value;
    if(searchPerformed == "false") {
         showBarMessage(ECM_SE0007,ERROR_MSG);
         return false;
    }

    /* When Any Changes to save, then ask to save changes. */
    if(document.forms[0].updFlag.value == 'Y'){
        showBarMessage(ECM_GE0013, ERROR_MSG);
        return;
    }

    if(document.forms[0].radioGroup1 != null){
        if(getGridControl().getTotalDataNumber() == 1){
            if(document.forms[0].radioGroup1.checked==false){
                showBarMessage(ECM_GE0007,ERROR_MSG);
                return false;
            }else{
                selectedIndex = 0;
            }
        }else {
            for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {
                if(document.forms[0].radioGroup1[i].checked) {
                    selectedIndex = i;
                }
            }
        }
    }

    /* When no record is selected then show error. */
    if(selectedIndex  == null ){
        showBarMessage(ECM_GE0007,ERROR_MSG);
        return false;
    }

    /* Get selected Matching Container Id */
    document.getElementById("matchingContainerId").value =
        document.getElementById('overlandedValue[' + selectedIndex + '].overlandedContainerId').value ;

    /* Get selected Matching Container container sequence */
    document.getElementById("matchingContSeq").value =
        document.getElementById('overlandedValue[' + selectedIndex + '].mergeAction').value ;

    /* Get container equipment no# */
    document.getElementById("matchingEquipmentNo").value =
        document.getElementById('overlandedValue[' + selectedIndex + '].equipmentNo').value ;

    /* When merge Action field is null then show error */
    if(document.getElementById('overlandedValue[' + selectedIndex + '].mergeAction').value==""){
        showBarMessage(EZL_SE053,ERROR_MSG);
        return false;
    }
    /* When merge Action field is non numeric then show error */
    if(!checkOnlyNumber(document.getElementById('overlandedValue[' + selectedIndex + '].mergeAction').value)) {
        showBarMessage(EZL_SE036,ERROR_MSG);
        return false;
    }

    /* Set match flage to identify type of matching. */
    document.getElementById("matchingFlag").value = 'M';
    /* Disable all controls */
    disableOnSubmit();
    document.forms[0].action = MATCH;
    document.forms[0].submit();
    return false;

}

function openContainerOperatorLookup(rowId){
        lookupId = 'C'; //Container Operator
        openLookup(FORM_ID, rowId, 'OPERATOR', '');
}

function openOutSlotOperatorLookup(rowId){
        lookupId = 'O'; //Out Slot Operator
        openLookup(FORM_ID, rowId, 'OPERATOR', '');
}

function openSlotOperatorLookup(rowId){
        lookupId = 'S'; //Slot Operator
        openLookup(FORM_ID, rowId, 'OPERATOR', '');
}

function openHandlingInsCodeLookup1(rowId){
    lookupId = 'HIC1';
    openLookup(FORM_ID, rowId, 'HIC', '');
}

function openHandlingInsCodeLookup2(rowId){
    lookupId = 'HIC2';
    openLookup(FORM_ID, rowId, 'HIC', '');
}

function openHandlingInsCodeLookup3(rowId){
    lookupId = 'HIC3';
    openLookup(FORM_ID, rowId, 'HIC', '');
}

function openUNNoLookup(rowId){
    var portVal      = document.forms[0].port.value;
    var currentTab         = document.forms[0].currTabSelected.value;
    if(currentTab == '1'){
        var portClassVal = document.getElementById('bookingValue[' + rowId + '].portClass').value;
    }else if(currentTab == '2'){
        var portClassVal = document.getElementById('overlandedValue[' + rowId + '].portClass').value;
    }
    //openLookup(FORM_ID, rowId, 'PORT_CLASS', portClassVal+'~'+portVal);
    openLookup(FORM_ID, rowId, 'PORT_CLASS', portVal);
}

function openEquipmentTypeLookup(rowId){
    openLookup(FORM_ID, rowId, 'EQUIPMENT_TYPE', '');
}

function openPodLookup(rowId){
    openLookup(FORM_ID, rowId, 'PORT', '');
}

function openPodTerminalLookup(rowId){
    openLookup(FORM_ID, rowId, 'TERMINAL', '');
}

function openErrorMessage(arow){
 var ll_dl_flag  = 'D';
 var load_discharg_id = document.getElementById('dischargeListId').value;
 var ol_os_id  = document.getElementById('overlandedValue[' + arow + '].overlandedContainerId').value;

 /* pass ll_dl flag, ll_dl_id, os_ol_id*/
 var urlStr = ERRORMSG +ll_dl_flag+'&load_discharg_id='+load_discharg_id+'&ol_os_id='+ol_os_id;

 openChildScreen64(urlStr,FORM_ID);
 return false;
}


/*
    #1 Function implemented by vikas, to to open new edi error msg screen, as k'chatgamol, 15.03.2012
*/
function ediError(){
    /* Disable all controls */
//    disableOnSubmit();
    /* Reset Update Flag */
    document.forms[0].updFlag.value = 'N';

    document.forms[0].action = EDIERROR;
    document.forms[0].submit();
}

/*
    #1 End added by vikas, 15.03.2012
*/

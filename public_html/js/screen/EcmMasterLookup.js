/**
* function called when screen load
*/

/*
-------------------------------------------------------------------------------------------------------------
EcmMasterLookup.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author -
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 07/10/2014     PRATYA          01                PD_CR_20140826_ESV [Contract Party for registeration]
-------------------------------------------------------------------------------------------------------------
*/
var FORM_ID       = 'fecm002';
var currselrowid  = 'row0';
var lastFindVal   = '';
var lastFindIn    = '';
var lastWildCard  = '';
var lastSortBy    = '';
var lastSortIn    = '';
var lastRecStatus = '';
var lastOrderBy   = '';
var lastAscDesc   = '';


/*Called by framework on-load of this JSP*/
function onLoad() {    
    lastFindVal   = document.forms[0].findVal.value;
    lastFindIn    = document.forms[0].findIn.value;
    lastWildCard  = document.forms[0].wildCard.value;
    lastSortBy    = document.forms[0].sortBy.value;
    lastSortIn    = document.forms[0].sortIn.value;
    lastRecStatus = document.forms[0].recStatus.value;
    
    lastOrderBy = document.forms[0].orderBy.value;
    lastAscDesc = document.forms[0].ascDesc.value;
    
    
    //Focus on Module Combo Box
    document.forms[0].findVal.focus();        
}

function openHelp() {
    
    var strFileName = '1';
    var strUrl = "/RCLWebApp/help/ApplicationHelp.htm#"+strFileName;
    var objWindow = window.open(strUrl,"Help","width=900,height=600,status=no,resizable=no,top=150,left=150");
    objWindow.focus();
}

//Function to highlight the selected row
function highlightradioTD(rowid) {
    rowobj = document.all(rowid);
    oldrowobj = document.all(currselrowid);
    if (oldrowobj != null) oldrowobj.style.background = "#FFFFFF";
    if (rowobj != null) {
        currselrowid = rowid;
        rowobj.style.background = "#ADC3E7";
    }
}

/*Called by framework for Pagination*/
function getActionUrl(){     
    resetSearchCriteria();
    lstrUrl = BROWSE_FSC_LOOKUP;
    document.forms[0].action=lstrUrl;
    return lstrUrl;
}
 
/*To reset theoriginal search criteria before processing*/
function resetSearchCriteria() {
    document.forms[0].findVal.value   = lastFindVal;
    document.forms[0].findIn.value    = lastFindIn;
    document.forms[0].wildCard.value  = lastWildCard;
    document.forms[0].sortBy.value    = lastSortBy;
    document.forms[0].sortIn.value    = lastSortIn;
    document.forms[0].recStatus.value = lastRecStatus;   

    document.forms[0].orderBy.value   = lastOrderBy ;
    document.forms[0].ascDesc.value   = lastAscDesc ;        
}

/*Called by framework on reset or refresh for reloading the page*/
function onResetForm(){
    
    var hdnFormName  = document.forms[0].prmFormName.value;
    var hdnMasterId  = document.forms[0].prmMasterId.value;
    var hdnPrmValues = document.forms[0].prmValues.value;
    
    var urlString = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/secm002", pageContext)%>';
    
    document.forms[0].currPageNo.value= 1;
    document.forms[0].totRecord.value=0;
    
    document.forms[0].action=urlString;        
    document.forms[0].submit();        
    return false;
}

/*Called by Find Button*/
function onSearch() {

    
    var nameFindVal = document.forms[0].findVal.value;
    var nameFindIn = document.forms[0].findIn.value;
    
    //Show error message to the user if he has select only findVal and not find In.
    if(nameFindVal !="" && nameFindIn == ""){
        showBarMessage('Please specific find value.', ERROR_MSG);
        return false;
    }
    
    //Show error message to the user if he has select only findVal and not find In.
    if(nameFindVal =="" && nameFindIn != ""){
        showBarMessage('Please specific find in.', ERROR_MSG);
        return false;
    }
    
    //Clear the Data Table
//    clearDiv('search_result');
   
    
    //set the action
    document.forms[0].currPageNo.value = 1;
    document.forms[0].action = BROWSE_FSC_LOOKUP;
    
    document.forms[0].submit();
    return false;
}

/*Return the values to the parent window*/
 function returnValues(rowid){
    var resultData      = new Array();
    var formName        = document.forms[0].prmFormName.value;
    var pRowId          = document.forms[0].prmRowId.value;
    var masterId        = document.forms[0].prmMasterId.value;
    var totCell         = document.all(rowid).cells;
    /*Begin @01*/
    var lo_prmRowIndex  = document.getElementById("prmRowIndex");
    /*End @01*/
    
    for(var i=0; i<totCell.length-1; i++){      
        resultData[i] = totCell[i+1].firstChild == null ? " " : totCell[i+1].firstChild.data;
    }

    if(lo_prmRowIndex.value==""){
        window.opener.setLookupValues(formName, pRowId, masterId, resultData);
    }else{
        window.opener.setLookupValuesForContractParty(formName, pRowId, masterId, resultData, lo_prmRowIndex.value);
    }
    window.close();    
}

/*Sort the data */
function sortData(sortColumn){
    var strSearchPerformed = document.forms[0].searchPerformed.value ;    
    if(strSearchPerformed == "false") {
        
        showBarMessage(ECM_SE0001, ERROR_MSG);
        return false;
    }
    
    var pColId = document.forms[0].colNames.value.split("~");
    var pColName = document.forms[0].findInCode.value.split("~");

    document.forms[0].orderBy.value= pColName[sortColumn];
    if(document.forms[0].orderBy.value == 'undefined'){
       document.forms[0].orderBy.value = ''; 
    }

    if(document.forms[0].ascDesc.value == ''){
        document.forms[0].ascDesc.value = "ASC";
        document.forms[0].sortBy.value = pColName[sortColumn];
        document.forms[0].sortIn.value = "ASC";
    }
    else if(document.forms[0].ascDesc.value == "ASC"){
        document.forms[0].ascDesc.value = "DESC";
        document.forms[0].sortBy.value = pColName[sortColumn];
        document.forms[0].sortIn.value = "DESC";
    }
    else if(document.forms[0].ascDesc.value == "DESC"){
        document.forms[0].ascDesc.value = "ASC";
        document.forms[0].sortBy.value = pColName[sortColumn];
        document.forms[0].sortIn.value = "ASC";
    }
    
    document.forms[0].action=BROWSE_FSC_LOOKUP;
    document.forms[0].submit();
    return false;
}
    

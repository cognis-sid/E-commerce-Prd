
function onLoad() {
    
} // onload

function searchBtn(){   
        var lo_bookingDateFrom  = document.getElementById("bookingDateFrom");
        var lo_bookingDateTo    = document.getElementById("bookingDateTo");
        var lo_bookingNo        = document.getElementById("bookingNo");
        
        if(lo_bookingDateFrom.value=="" && lo_bookingDateTo.value!=""){
            showBarMessage("Please input text Booking Date From.",1);
            lo_bookingDateFrom.focus();
        }else if(lo_bookingDateFrom.value!="" && lo_bookingDateTo.value==""){
            showBarMessage("Please input text Booking Date To.",1);
            lo_bookingDateTo.focus();
        }else{
            document.forms[0].currPageNo.value  = 1;
            document.forms[0].action            = SEARCH_CRITERIA;
            document.forms[0].submit();
        }
}

function getActionUrl()
{
    return SEARCH_CRITERIA;
}

function resetBtn(){
    var lo_bookingNo        = document.getElementById("bookingNo");
    var lo_bookingDateFrom  = document.getElementById("bookingDateFrom");
    var lo_bookingDateTo    = document.getElementById("bookingDateTo");
    var lo_bookingDateBy    = document.getElementById("bookingDateBy");
    var lo_sortBy           = document.getElementById("sortBy");
    var lo_orderBy          = document.getElementById("orderBy");
    
    lo_bookingNo.value                  = "";
    lo_bookingDateFrom.value            = "";
    lo_bookingDateTo.value              = "";
    lo_bookingDateBy.value              = "";
    lo_sortBy.selectedIndex             = 0;
    lo_orderBy.selectedIndex            = 0;
} //resetBtn

function openCustomerData(){

    var url = BOOKED_BY;
    try{
        var w = window.open(url, 'HelpWindow', 'width='+screen.width+', height='+screen.height+', resizable=no, scrollbars=no, toolbar=no');
        w.focus();
    }catch(err){
        handleJavaScriptError('openCustomerData', err, error_code);
    }
}

function setCustomerData(customerCode, customerName, customerFscCode){
    var lo_bookingDateBy = document.getElementById('bookingDateBy');
    
    lo_bookingDateBy.value = customerCode;
}

function openBookingNumber(){      
    var url = BROWSE_BOOKING_NUMBER + "?pageFlag=P";
    openHelpList(url, 900, 400);
}

function getWebBookingData(av_bookingNo){
    var lo_bookingNo    = document.getElementById("bookingNo");
    
    lo_bookingNo.value = av_bookingNo;
} 

/* * end of JavaScript * */

/**
* function called when screen load
*/

// ------------------------------ CONSTANTS DECLARATION START
var error_code;
var saveOperationFlag = "saveOperationFlag";
// ------------------------------ CONSTANTS DECLARATION END
function onClose() {
    try{
        //-------------------------- enable or disable combos logic
            error_code=1;
        var bookingNo =  document.getElementById("bookingNo").value;
        var url;
        error_code=2;
        //--------------- booking type NORMAL becuase for template booking
        //--------------- we are not using this  screen.
        url = GET_BOOKING_NUMBER+'?bookingNo='+bookingNo+'&bookingType=NORMAL&mode=select';
        error_code=3;
        document.forms[0].action = url;
//        openHelpList(url, 920, 370);
//        window.open(url, 'HelpWindow', 'width=920, height=370, resizable=yes, scrollbars=yes, toolbar=no');
        
        
        error_code=4;
        window.opener.close();
        window.close();
//        openScreen(url,'serv003');
//        openScreen(url,'serv003');
//        document.forms[0].submit();
        error_code=5;
        //  window.close();
        error_code=6;
        
        

    }catch(err){

          txt="JAVASCRIPT ERROR.\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
            alert(txt);
    }

} // onClose

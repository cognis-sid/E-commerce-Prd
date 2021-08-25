/**
* function called when screen load
*/

// ------------------------------ CONSTANTS DECLARATION START
var error_code;

// ------------------------------ CONSTANTS DECLARATION END
function onClose() {
	debugger;
    try{
        //-------------------------- enable or disable combos logic
        error_code=1;
        
        var bookingNo;
        if(!isNullObj(document.getElementById("bookingNo"))){
            bookingNo = document.getElementById("bookingNo").value;
        }
        error_code=2;
        var blNo;
        if(!isNullObj(document.getElementById("blNo"))){
            blNo = document.getElementById("blNo").value;
        }
        error_code=3;
        var flag = 'booking';
        var esiStatus = 'SUBMITTED';
        error_code=4;
        var cocSoc;
        if(!isNullObj(document.getElementById("cocSoc"))){
            cocSoc = document.getElementById("cocSoc").value;
        }
        error_code=5;   
                
        var url;
        error_code=6;
        var params = "?bookingNo="+bookingNo+"&blNo="+blNo+"&cocSoc="+cocSoc+"&flag="+flag+"&esiStatus="+esiStatus+"&mode=select"; 
        error_code=7;
        url = GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE+params;
        error_code=8;
        
//        window.opener.close();
        window.close();
//        openScreen(url,'serv006');
        error_code=9;
    }catch(err){
        txt="JAVASCRIPT ERROR.\n";
        txt+="description: " + err.message + "\n";
        txt+=err+"";
        txt+="point#: " + error_code + "\n";
        txt+="Click OK to continue.";
        alert(txt);
    }

} // onClose

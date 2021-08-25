/**
* function called when screen load
*/
/*
-------------------------------------------------------------------------------------------------------------
EserviceUtil.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Yossawat Suntisukkasem 15/01/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
var MSG_LOADING = 'Loading ...';
var MSG_NORMAL = 'Ready';
var MSG_NORMAL_CODE = 0;
var MSG_ERROR_CODE = 1;

function clearMsg(){
    showBarMessage(MSG_NORMAL, MSG_NORMAL_CODE);
}

function loading(){
    showBarMessage(MSG_LOADING, MSG_NORMAL_CODE);
    
   // pausePage1();
}

function unloading(){
    //runPage1();
}

function isNullObj(obj){
    if(obj != null && obj != undefined){
        return false;
    }else{
        return true;
    }
}
function isNullStrReturnDefault(objVal, defaultVal){
    if(objVal == null || objVal == undefined){
        return defaultVal;
    }else{
        return objVal;
    }
}
function isBlank(objValue){
    if(objValue != null && objValue != undefined && objValue != ''){
        return false;
    }else{
        return true;
    }
}

function handleJavaScriptError(functionName, err, error_code){
        showBarMessage('javascript error ('+functionName+' : code '+error_code+') : '+err.message, MSG_ERROR_CODE);
//      txt = "JAVASCRIPT ERROR .\n";
//      txt += "In Method: "+ functionName+"\n";
//      txt += "description: " + err.message + "\n";
//      txt += err+"";
//      txt += "point#: " + error_code + "\n";
//      txt += "Click OK to continue.";
//      alert(txt);
}

function gp_number_format (av_obj, decimals, dec_point, thousands_sep) {
    
    var exponent    = "";
    var numberstr   = null;
    var eindex      = null;
    var temp        = null;
    var sign        = null;
    var integer     = null;
    var fractional  = null;
    var number      = av_obj.value.replace(/,/g,"");
    var msgVal      = "";

    if(gp_trim(number)==""){
        return true;
    }
    
    numberstr   = number.toString ();
    eindex      = numberstr.indexOf ("e");
    
    if (eindex > -1) {
        exponent = numberstr.substring (eindex);
        number = parseFloat (numberstr.substring (0, eindex));
    }
       
    if (decimals != null) {
        temp    = Math.pow (10, decimals);
        number  = Math.round (number * temp) / temp;
    }
    
    sign        = number < 0 ? "-" : "";
    integer     = (number > 0 ? Math.floor (number) : Math.abs (Math.ceil (number))).toString ();
    
    fractional  = number.toString ().substring (integer.length + sign.length);
    dec_point   = dec_point != null ? dec_point : ".";
    fractional  = decimals != null && decimals > 0 || fractional.length > 1 ? (dec_point + fractional.substring (1)) : "";
    
    if (decimals != null && decimals > 0) {
        for (i = fractional.length - 1, z = decimals; i < z; ++i) {
            fractional += "0";
        }
    }
    
    thousands_sep = (thousands_sep != dec_point || fractional.length == 0) ? thousands_sep : null;
    if (thousands_sep != null && thousands_sep != "") {
        for (i = integer.length - 3; i > 0; i -= 3){
            integer = integer.substring (0 , i) + thousands_sep + integer.substring (i);
        }
    }
    
    msgVal = sign + integer + fractional + exponent;
    if(msgVal.indexOf("NaN") > -1){
        return false;
    }
    
    av_obj.value = msgVal;
    return true;
    
    //av_obj.value = sign + integer + fractional + exponent;
    //return sign + integer + fractional + exponent;
}

function gp_trim(str) {
    return str.replace(/^\s+|\s+$/g,"");
}

function gp_objTrim(ao_obj){
    ao_obj.value = ao_obj.value.replace(/^\s+|\s+$/g,"");
}

function gp_validNumberKey(e){
//    var keyFormat = /^\d/g;
    var keyFormat = /[^\d\.]/g;
    var charVal = String.fromCharCode(e.keyCode);
    
    return !keyFormat.test(charVal);
}

function gp_validNumberKeyMinus(e){
//    var keyFormat = /^\d/g;
    var keyFormat = /[^\d\.\-]/g;
    var charVal = String.fromCharCode(e.keyCode);
    
    return !keyFormat.test(charVal);
}

function gp_clearMsg(ao_obj){
    ao_obj.value = "";
}

function gp_sanitizeURLString(av_val){
    var la_symbol   = ["%" , "<" , ">" , "#" , "{" , "}" , "|" , "\\" , "^" , "~" , "[" , "]" , "`" , ";" , "/" , "?" , ":" , "@" , "=" , "&" , "$"];
    var la_replace  = ["%25", "%3C", "%3E", "%23", "%7B", "%7D", "%7C", "%5C", "%5E", "%7E", "%5B", "%5D", "%60", "%3B", "%2F", "%3F", "%3A", "%40", "%3D", "%26", "%24"];
    var lv_return   = "";
    var lv_char		= null;

    loop1:for(var i=0;i<av_val.length;i++){
        lv_char = av_val.substr(i, 1);
        loop2:for(var j=0;j<la_symbol.length;j++){
            if(lv_char.indexOf(la_symbol[j]) > -1){
                lv_char = lv_char.split(la_symbol[j]).join(la_replace[j]);
                break loop2;
            }
        }
        lv_return = lv_return + lv_char;
    }
    
    return lv_return;
}

function gp_rowTableIndex(ao_obj){
    var lv_index            = 0;
    var lv_tagName          = "";
    var lo_obj              = ao_obj;
    
    lv_tagName  = lo_obj.tagName.toUpperCase();
    while (lv_tagName != "TR") {
        lo_obj      = lo_obj.parentNode;
        lv_tagName  = lo_obj.tagName.toUpperCase();
    }
    
    lv_index = lo_obj.rowIndex;
    
    return lv_index;
}

function gp_rowTableObj(ao_obj){
    var lv_index            = 0;
    var lv_tagName          = "";
    var lo_obj              = ao_obj;
    
    lv_tagName  = lo_obj.tagName.toUpperCase();
    while (lv_tagName != "TR") {
        lo_obj      = lo_obj.parentNode;
        lv_tagName  = lo_obj.tagName.toUpperCase();
    }
    
    return lo_obj;
}

//av_val ==> dd/MM/yyyy
function gp_toDate(av_val){
    var dateArray   = null;;
    var d           = null;
    
    try{
        dateArray   = av_val.split("/");
        d           = new Date(dateArray[2], dateArray[1], dateArray[0], 0, 0, 0, 0);
    }catch(e){
        d = null;
    }
    
    return d;
}

function gp_calendar(av_val){
    try{
    	 $(".dateForm").datepicker({ dateFormat: 'dd/mm/yy'});
    	 
         $(".dateFormMust").datepicker({ dateFormat: 'dd/mm/yy'});
        document.getElementById(av_val).focus();
    }catch(e){
        alert("gp_calendar :: " + e);
    }
}

function gp_checkDate(ao_obj){
    var allowBlank 	= true;
    var minYear 	= 2000;
    //var maxYear 	= (new Date()).getFullYear();
    var errorMsg 	= "";
    var field 		= gp_trim(ao_obj.value);

    // regular expression to match required date format
    re = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
	
    try{
	    if(field != '') {
			
	    	if(field.length==8){
	    		field 			= field.substring(0, 2) + "/" + field.substring(2, 4) + "/" + field.substring(4, 8);
	    		ao_obj.value 	= field;
	    	}
	    	
	      if(regs = field.match(re)) {
	        if(regs[1] < 1 || regs[1] > 31) {
	          errorMsg = "*Date should be in DD/MM/YYYY format.";
	        } else if(regs[2] < 1 || regs[2] > 12) {
	          errorMsg = "*Date should be in DD/MM/YYYY format.";
	        } else if(regs[3] < minYear) {
	          errorMsg = "*Date should be in DD/MM/YYYY format.";
	        }
	      } else {
	        errorMsg = "*Date should be in DD/MM/YYYY format.";
	      }
	    }

	    if(errorMsg != "") {
//	      alert(errorMsg);
              showBarMessage(errorMsg, 1);
	      ao_obj.value = "";
	      ao_obj.focus();
	      return false;
	    }else{
                showBarMessage("Ready", 2);
            }
    }catch(e){
    	alert("gp_checkDate :: " + e);
    	return false;
    }

    return true;
  }
  
    function gp_progressBarOn(){
        scroll(0,0);
        var outerPane = document.getElementById('FreezePane');
        var processBar = document.getElementById('processBar');
        if (outerPane) outerPane.className = 'FreezePaneOn';
        if(processBar) processBar.className = 'processBarOn';
    }
    
    function gp_progressBarOff(){
        scroll(0,0);
        var outerPane = document.getElementById('FreezePane');
        var processBar = document.getElementById('processBar');
        if (outerPane) outerPane.className = 'FreezePaneOff';
        if(processBar) processBar.className = 'processBarOff';
    }
    
    function gp_refreshObj(ao_obj){
        var lv_element = null;
        
        try{
            lv_element          = ao_obj.innerHTML;
            ao_obj.innerHTML    = lv_element;   
        }catch(e){
            alert("gp_refreshObj :: " + e);
        }
    }
  

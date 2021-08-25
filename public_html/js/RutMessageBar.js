function ietruebody() {
    return (document.compatMode && document.compatMode != "BackCompat") ? document.documentElement : document.body;
}

function JSFX_FloatTopDiv() {
    var startX = 3,startY = 25;
    var PX = 'px', d = document;
    function ml(id) {
        var el  = d.getElementById ? d.getElementById(id) : d.all ? d.all[id] : d.layers[id];
        if (d.layers) { el.style = el, PX = ''; }
        el.sP = function(x, y) {
                    this.style.left = x + PX; 
                    this.style.top = y + PX; 
                    //$(this).animate({left:x + PX},"slow");
                    //$(this).animate({top:y + PX},"slow");
                };
        el.x = startX;
        if (verticalpos == "fromtop")
            el.y = startY;
        else {
//            alert("innerHeight::" + window.innerHeight + " pageYOffset::" + window.pageYOffset + " scrollTop::" + ietruebody().scrollTop + " availHeight::" + screen.availHeight + " clientHeight::" + ietruebody().clientHeight);
            el.y = window.innerHeight ? window.pageYOffset + window.innerHeight : ietruebody().scrollTop + ietruebody().clientHeight;
            //alert(el.y);
            el.y -= startY;
        }
        return el;
    }
    window.stayTopLeft = function() {
        if (verticalpos == "fromtop") {
            var pY = window.innerHeight ? window.pageYOffset : ietruebody().scrollTop;
            ftlObj.y += (pY + startY - ftlObj.y) / 8;
        }
        else {
//            alert("innerHeight::" + window.innerHeight + " pageYOffset::" + window.pageYOffset + " scrollTop::" + ietruebody().scrollTop + " availHeight::" + screen.availHeight + " clientHeight::" + ietruebody().clientHeight);
            var pY = window.innerHeight ? window.pageYOffset + window.innerHeight : ietruebody().scrollTop + ietruebody().clientHeight;
            ftlObj.y += (pY - startY - ftlObj.y) / 8;
        }
        //alert(ftlObj.x+" "+ftlObj.y);
        ftlObj.sP(ftlObj.x, ftlObj.y);
        setTimeout("stayTopLeft()", 10);
    }
    ftlObj = ml("divStayTopLeft");
    stayTopLeft();
}

function showBarMessage(strMessage) {
	console.log(strMessage+"DDDDDDDDDDD");
	$("#alertId").show();
	$("#errorMsg").html(errorMsg);

	setErrorFlag();
    var objTd = document.getElementById("msg");
    if (objTd != null) {
        objTd.innerHTML = strMessage;
    }
}

function showBarMessage(strMessage, intErrCode) {
	setErrorFlag();
    var objTd = document.getElementById("msg");
    if (objTd != null) {
        if (intErrCode == '1') {
            objTd.innerHTML = "<Font color=red>" + strMessage + "</font>";
        } else {
            objTd.innerHTML = strMessage;
        }
    }
}

function showBarMessage(strMessage, intErrCode, arrMessage) {
	setErrorFlag();
	if(arrMessage != null && arrMessage.length > 0 ){
		counter = 0;
        while((insertPosition = strMessage.indexOf('{')) > -1){
		
            if(arrMessage[counter] == null ){
                arrMessage[counter] = "";
            }			
			strMessage = strMessage.replace('{' + counter + '}',arrMessage[counter]);

            counter++;
        }
    }

    var objTd = document.getElementById("msg");
    if (objTd != null) {
        if (intErrCode == '1') {
            objTd.innerHTML = "<Font color=red>" + strMessage + "</font>";
        } else {
            objTd.innerHTML = strMessage;
        }
    }
}

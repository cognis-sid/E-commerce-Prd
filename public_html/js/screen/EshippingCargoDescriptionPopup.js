/**
* function called when screen load
*/
/*
-------------------------------------------------------------------------------------------------------------
EshippingInstruction.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Yossawat Suntisukkasem 15/01/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 10/09/2014    PRATYA             01              PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
-------------------------------------------------------------------------------------------------------------
*/

var error_code = 0;

var parentObj = parent.opener;
var parentDoc = parentObj.document;
var parentForm = parentDoc.forms[0];

/*Begin @01*/
/*
function onLoadCargoDescriptionPopup(){
    var marksAndNumbersObj  = document.getElementsByName('marksAndNumbers');
    var descriptionObj      = document.getElementsByName('description');
    var txtMarksAndNumber   = document.getElementById('txtMarksAndNumbers');
    var txtDescription      = document.getElementById('txtDescription');
    var marksAndNumbers     = BLANK;
    var description         = BLANK;
    
    try{
        if(!isNullObj(marksAndNumbersObj) && !isNullObj(marksAndNumbersObj[0])){
            marksAndNumbers = marksAndNumbersObj[0].value;
        }
        if(!isNullObj(descriptionObj) && !isNullObj(descriptionObj[0])){
            description = descriptionObj[0].value;
        }
        txtMarksAndNumber.value = marksAndNumbers;
        txtDescription.value = description;
    }catch(err){
        handleJavaScriptError('onLoad', err, err_code);
    }
}
*/
function onLoadCargoDescriptionPopup(av_val){
    var marksAndNumbersObj              = document.getElementsByName('marksAndNumbers');
    var descriptionObj                  = document.getElementsByName('description');
    var la_comBookingNo                 = document.getElementsByName('comBookingNo');
    var la_strCommodityForMark          = document.getElementsByName('strCommodityForMark');
    var la_containerNoToCargo           = document.getElementsByName('containerNoToCargo');
    var txtMarksAndNumber               = document.getElementById('txtMarksAndNumbers');
    var txtDescription                  = document.getElementById('txtDescription');
    var marksAndNumbers                 = BLANK;
    var description                     = BLANK;
    var lo_commodityRowIndex            = document.getElementById("commodityRowIndex");
    var lo_posComBookingNo              = document.getElementById("posComBookingNo");
    var lo_posStrCommodityForMark       = document.getElementById("posStrCommodityForMark");
    var lo_posContainerNoToCargo        = document.getElementById("posContainerNoToCargo");
 	var commodityCodeHSCode		= document.getElementsByName('strCommCode');
    document.getElementById("commodityNo").value = commodityCodeHSCode[av_val].value;
	document.getElementById('ErrorMsgLog').style.display = 'none';
    
    try{
        if(!isNullObj(marksAndNumbersObj) && !isNullObj(marksAndNumbersObj[av_val])){
            marksAndNumbers = marksAndNumbersObj[av_val].value;
        }
        if(!isNullObj(descriptionObj) && !isNullObj(descriptionObj[av_val])){
            description = descriptionObj[av_val].value;
        }
        
        txtMarksAndNumber.value                 = marksAndNumbers;
        txtDescription.value                    = description;
        lo_commodityRowIndex.value              = av_val;
        
        if(!isNullObj(la_comBookingNo) && !isNullObj(la_comBookingNo[av_val])){
            lo_posComBookingNo.innerHTML            = la_comBookingNo[av_val].value;
        }
        
        if(!isNullObj(la_strCommodityForMark) && !isNullObj(la_strCommodityForMark[av_val])){
            lo_posStrCommodityForMark.innerHTML     = la_strCommodityForMark[av_val].value;
        }
        
        if(!isNullObj(la_containerNoToCargo) && !isNullObj(la_containerNoToCargo[av_val])){
            lo_posContainerNoToCargo.innerHTML      = la_containerNoToCargo[av_val].value;
        }
        
    }catch(err){
        handleJavaScriptError('onLoadCargoDescriptionPopup', err, error_code);
    }
}
/*End @01*/

function getEquipDetails(){
	debugger;
    var marksAndNumbersData = '';
    var containerNo             = document.getElementsByName('containerNo'); // for check single or multiple row(s)
    var carrierSeal             = document.getElementsByName('carrierSeal');
    var ofPackages              = document.getElementsByName('ofPackages');
    var packagesKindName        = document.getElementsByName('packagesKind');
    var grossContainerWeight    = document.getElementsByName('grossContainerWeight');
	var equipmentCommodityCode	= document.getElementsByName('commodity');
	var commodityCodeHSCode		= document.getElementsByName('commodityNo');
	var size					= document.getElementsByName('containerEqSize');
	var type					= document.getElementsByName('containerEqType');
    var lineBreak               = '';
    var rows                    = 0;
    
    try{
        if(!isNullObj(containerNo)){
            rows = containerNo.length;
            if(!isNullObj(rows)){
                for(var countIndex=0; countIndex<rows; countIndex++){
				  if(commodityCodeHSCode[0].value==equipmentCommodityCode[countIndex].value) {
                    if(rows != (countIndex+1)){
                        lineBreak = '\n';
                    }else{
                        lineBreak = '';
                    }
                    setEquipDetailsToPopup(
                        containerNo[countIndex], carrierSeal[countIndex], 
                        ofPackages[countIndex], packagesKindName[countIndex], 
                        grossContainerWeight[countIndex], lineBreak,size[countIndex],type[countIndex]);
				  }
                }   
            }
            
        }
    }catch(err){
        handleJavaScriptError('getEquipDetails', err, 0);
    }
}

function setEquipDetailsToPopup(containerNo, carrierSeal, ofPackages, packagesKindName, grossContainerWeight, lineBreak,size,type){
//    var marksAndNumbers = document.getElementsByName('marksAndNumbers');
debugger;
    var marksAndNumbers             = document.getElementById('txtMarksAndNumbers');
    var templateShowData            = "{0} / {1} / {2} / {3} / {4} / {5} / {6}";    
    var ofPackagesData              = '';
    var packagesKindData            = '';
    var grossContainerWeightData    = '';
    var dataTmp;
    
    try{
        if(!isNullObj(ofPackages.value) && ofPackages.value != '0'){
            ofPackagesData = ofPackages.value+' ';
        }
        if(!isNullObj(packagesKindName.value) && !isBlank(packagesKindName.value)){
            packagesKindData = packagesKindName.value+'(S)';
        }
        if(!isNullObj(grossContainerWeight.value) && grossContainerWeight.value != '0.00'){
            grossContainerWeightData = grossContainerWeight.value+' KG';
        }
        dataTmp = templateShowData.replace("{0}", containerNo.value);
        dataTmp = dataTmp.replace("{1}",carrierSeal.value);
		dataTmp = dataTmp.replace("{2}",size.value);
		dataTmp = dataTmp.replace("{3}",type.value);
        dataTmp = dataTmp.replace("{4}",ofPackagesData);
		dataTmp = dataTmp.replace("{5}",packagesKindData);
        dataTmp = dataTmp.replace("{6}",grossContainerWeightData);
        dataTmp += lineBreak;
    }catch(err){
        handleJavaScriptError('setEquipDetailsToPopup', err, error_code);
    }finally{
        if(!isNullObj(marksAndNumbers)){
            if(isBlank(marksAndNumbers.value)){
                marksAndNumbers.value = dataTmp;    
            }else{
                marksAndNumbers.value += dataTmp;
            }
        }
    }
}

function callbackFromCargoDesc(isSave){
	document.getElementById('ErrorMsgLog').style.display = 'none';
    var marksParent             = document.getElementsByName('marksAndNumbers');
    var descriptionParent       = document.getElementsByName('description');
    var marksAndNumber          = document.getElementById('txtMarksAndNumbers');
    var description             = document.getElementById('txtDescription');
    var lo_commodityRowIndex    = document.getElementById("commodityRowIndex");
    var lv_rowIndex             = lo_commodityRowIndex.value;
   
    try{        
        error_code = 1;
        if(isSave){
            if(validateTextArea()){
                error_code = 2;
                marksParent[lv_rowIndex].value          = marksAndNumber.value;
                error_code = 3;
                descriptionParent[lv_rowIndex].value    = description.value;
                error_code = 4;
                closeCargoDescription();
                error_code = 5;

            }
        }else{        
            error_code = 6;
            closeCargoDescription();
            error_code = 7;
        }
    }catch(err){
        handleJavaScriptError('callbackFromCargoDesc', err, error_code);
    }
}

function validateTextArea(){
	document.getElementById('ErrorMsgLog').style.display = 'none';
    var marksAndNumber          = document.getElementById('txtMarksAndNumbers');
    var description             = document.getElementById('txtDescription');
    var result                  = true
    
    if (marksAndNumber.value.indexOf("<") > -1 || marksAndNumber.value.indexOf(">") > -1 || description.value.indexOf("<") > -1 || description.value.indexOf(">") > -1) {
        var marks = marksAndNumber.value ;       
        //marksAndNumber.value = marks.replace(/>/gi,'').replace(/</gi,'');
        var desc = description.value;
        //description.value = desc.replace(/>/gi,'').replace(/</gi,'')
        //alert("Not allow for special charecter '>,<' and removed from Mark & Description");
		document.getElementById('ErrorMsgLog').style.display = 'block';
		result = false;
    }
    
    
    return result
}


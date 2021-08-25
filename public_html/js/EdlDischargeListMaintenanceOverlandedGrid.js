var ctxPath                = ctxPath1;
var comboData;

function addRowInFixedTable() {
	
	/* return if search not performed. */
	if(document.getElementById("overlandedSearFlag").value != 'true') {
		showBarMessage(ECM_SE0007,ERROR_MSG);
		return false;
	}
    document.forms[0].updFlag.value = 'Y';
    var table               = document.getElementById("tableFixedColumns");
    var totalRows           = table.rows.length;
    var rowIndex            = table.rows.length;

    var nameRadioGroup1  = "radioGroup1";
    var nameDelete       = "overlandedValue["+ rowIndex  +"].selected";    
    var nameStatus       = "overlandedValue[" +rowIndex  + "].status";  
    var nameBookingNo    = "overlandedValue[" + rowIndex + "].bookingNo";
    var nameEquipmentNo  = "overlandedValue[" + rowIndex + "].equipmentNo";
    var nameOverContId   = "overlandedValue[" + rowIndex + "].overlandedContainerId";   
    var nameRecChDate    = "overlandedValue[" + rowIndex + "].recordChangeDt";   
    var nameOverSeqNo    = "overlandedValue[" + rowIndex + "].overlandedSeqNo";   
     
    
    var row       = table.insertRow(totalRows);
    row.setAttribute("id", "row"+rowIndex);
    row.setAttribute("height", "20px");
    
    var cellRadio      = row.insertCell(0);
    cellRadio.setAttribute("width", "15%");
    cellRadio.className = "first_row center";
    cellRadio.innerHTML =  '<td>'
        + ' <input  type="radio" name='+nameRadioGroup1+' value=' + rowIndex + '  onclick="highlightRow(' + rowIndex + ')" class="check"/>'
        + ' <input type="hidden" name='+nameStatus+' value='+ ADD +'>'
        + ' <input type="hidden" name='+nameOverContId+' value="">'
        + ' <input type="hidden" name='+nameRecChDate+' value="">'
        + ' <input type="hidden" name='+nameOverSeqNo+' value="">'                                  
        +  '</td>';
        
    var cellDelete = row.insertCell(1);
    cellDelete.setAttribute("width", "15%");
    cellDelete.className = "first_row center";
    cellDelete.innerHTML = '<td><input type="checkbox" name =' + nameDelete + ' value="ON" class="check"></td>'; 
                                    
        
    var cellBookingNo = row.insertCell(2);
    cellBookingNo.setAttribute("width", "40%");
    cellBookingNo.innerHTML =   '<td>'
        + '<input type="text" name =' +nameBookingNo + '  style="width:98%" onblur="updateOverlandedStatusFlage(' + rowIndex + ')"  maxlength="17" />'
        +  '</td>';
    
    var cellEqupmentNo = row.insertCell(3);
    cellEqupmentNo.setAttribute("width", "30%");    
    cellEqupmentNo.innerHTML =   '<td>'
        + '<input type="text" name =' +nameEquipmentNo + '  style="width:98%" onblur="updateOverlandedStatusFlage(' + rowIndex + ')" maxlength="12" />'
        + '</td>';

    return false;
}

function getRecordToAddInGrid(rowIndex)
{
	/* return if search not performed. */
	if(document.getElementById("overlandedSearFlag").value != 'true') {
		showBarMessage(ECM_SE0007,ERROR_MSG);
		return false;
	}

	
    // Create Data for row to add
    var rowData = {};
    var nameSrlNo        = "overlandedValue[" + rowIndex + "].srlNo";
    var nameSocCoc       = "overlandedValue[" + rowIndex + "].socCoc";
    var nameBillNo       = "overlandedValue[" + rowIndex + "].billNo";
    var nameSize         = "overlandedValue[" + rowIndex + "].size ";
    var nameEquipmentType = "overlandedValue[" + rowIndex + "].equipmentType";
    var nameFullMT       = "overlandedValue[" + rowIndex + "].fullMT";
    var nameBookingType  = "overlandedValue[" + rowIndex + "].bookingType";

    var nameShipmentTerm = "overlandedValue[" + rowIndex + "].shipmentTerm";
    var nameShipmentType = "overlandedValue[" + rowIndex + "].shipmentType";
    var namePodStatus    = "overlandedValue[" + rowIndex + "].podStatus";
    var nameLocalContSts = "overlandedValue[" + rowIndex + "].localContSts";
    var nameMidstream    = "overlandedValue[" + rowIndex + "].midstream";
    var nameLoadCondition = "overlandedValue[" + rowIndex + "].loadCondition";
    var nameDischargeSts = "overlandedValue[" + rowIndex + "].dischargeSts";
    var nameStowPosition = "overlandedValue[" + rowIndex + "].stowPosition";
    var nameActivityDate = "overlandedValue[" + rowIndex + "].activityDate";
    var nameWeight       = "overlandedValue[" + rowIndex + "].weight";

    var nameDamaged      = "overlandedValue[" + rowIndex + "].damaged";
    var nameVoidSlot     = "overlandedValue[" + rowIndex + "].voidSlot";
    var nameSlotOperator = "overlandedValue[" + rowIndex + "].slotOperator";
    var nameContOperator = "overlandedValue[" + rowIndex + "].contOperator";
    var nameOutSlotOperator = "overlandedValue[" + rowIndex + "].outSlotOperator";
    var nameSpecialHandling = "overlandedValue[" + rowIndex + "].specialHandling";
    var nameSealNo       = "overlandedValue[" + rowIndex + "].sealNo";
    var namePol          = "overlandedValue[" + rowIndex + "].pol";
    var namePolTerminal  = "overlandedValue[" + rowIndex + "].polTerminal";
    var nameNextPOD1     = "overlandedValue[" + rowIndex + "].nextPOD1";

    var nameNextPOD2     = "overlandedValue[" + rowIndex + "].nextPOD2";
    var nameNextPOD3     = "overlandedValue[" + rowIndex + "].nextPOD3";
    var nameFinalPOD     = "overlandedValue[" + rowIndex + "].finalPOD";
    var nameFinalDest    = "overlandedValue[" + rowIndex + "].finalDest";
    var nameNextService  = "overlandedValue[" + rowIndex + "].nextService";
    var nameNextVessel   = "overlandedValue[" + rowIndex + "].nextVessel";
    var nameNextVoyage   = "overlandedValue[" + rowIndex + "].nextVoyage";
    var nameNextDirection = "overlandedValue[" + rowIndex + "].nextDirection";
    var nameConnectingMLOVessel = "overlandedValue[" + rowIndex + "].connectingMLOVessel";
    var nameConnectingMLOVoyage = "overlandedValue[" + rowIndex + "].connectingMLOVoyage";

    var nameMloETADate          = "overlandedValue[" + rowIndex + "].mloETADate";
    var nameConnectingMLOPOD1 = "overlandedValue[" + rowIndex + "].connectingMLOPOD1";
    var nameConnectingMLOPOD2 = "overlandedValue[" + rowIndex + "].connectingMLOPOD2";
    var nameConnectingMLOPOD3 = "overlandedValue[" + rowIndex + "].connectingMLOPOD3";
    var namePlaceOfDel           = "overlandedValue[" + rowIndex + "].placeOfDel";
    var nameHandlingInstCode1 = "overlandedValue[" + rowIndex + "].handlingInstCode1";
    var nameHandlingInstDesc1 = "overlandedValue[" + rowIndex + "].handlingInstDesc1";
    var nameHandlingInstCode2 = "overlandedValue[" + rowIndex + "].handlingInstCode2";
    var nameHandlingInstDesc2 = "overlandedValue[" + rowIndex + "].handlingInstDesc2";
    var nameHandlingInstCode3 = "overlandedValue[" + rowIndex + "].handlingInstCode3";

    var nameHandlingInstDesc3 = "overlandedValue[" + rowIndex + "].handlingInstDesc3";
    var nameContLoadRemark1 = "overlandedValue[" + rowIndex + "].contLoadRemark1";
    var nameContLoadRemark2 = "overlandedValue[" + rowIndex + "].contLoadRemark2";
    var nameSpecialCargo    = "overlandedValue[" + rowIndex + "].specialCargo";
    var nameImdgClass       = "overlandedValue[" + rowIndex + "].imdgClass";
    var nameUnNumber        = "overlandedValue[" + rowIndex + "].unNumber";
    var nameUnNumberVariant = "overlandedValue[" + rowIndex + "].unNumberVariant";
    var namePortClass       = "overlandedValue[" + rowIndex + "].portClass";
    var namePortClassType   = "overlandedValue[" + rowIndex + "].portClassType";
    var nameFlashUnit       = "overlandedValue[" + rowIndex + "].flashUnit";

    var nameFlashPoint      = "overlandedValue[" + rowIndex + "].flashPoint";
    var nameFumigationOnly  = "overlandedValue[" + rowIndex + "].fumigationOnly";
    var nameResidue         = "overlandedValue[" + rowIndex + "].residue";
    var nameOverheight      = "overlandedValue[" + rowIndex + "].overheight";
    var nameOverwidthLeft   = "overlandedValue[" + rowIndex + "].overwidthLeft";
    var nameOverlengthFront = "overlandedValue[" + rowIndex + "].overlengthFront";
    var nameOverwidthRight  = "overlandedValue[" + rowIndex + "].overwidthRight";
    var nameOverlengthAfter = "overlandedValue[" + rowIndex + "].overlengthAfter";
    var nameReeferTemp      = "overlandedValue[" + rowIndex + "].reeferTemp";
    var nameReeferTempUnit  = "overlandedValue[" + rowIndex + "].reeferTempUnit";
    var nameHumidity        = "overlandedValue[" + rowIndex + "].humidity";
    var nameMergeAction     = "overlandedValue[" + rowIndex + "].mergeAction";
    var nameVentilation     = "overlandedValue[" + rowIndex + "].ventilation";
    var nameError           = "overlandedValue[" + rowIndex + "].error";

    rowData ["billNo"]    = "<input type='text'   value=''    name='overlandedValue["+rowIndex+"].billNo'    maxlength='17' class='non_edit' readonly='true' style='width : 96%' onblur=\"javascript:updateOverlandedStatusFlage('"+rowIndex+"','billNo',this)\"        >";

    var sizeCell; 

    sizeCell  = '<select name = ' +nameSize + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'size\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].size);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].size[lintCtr].value;
       var lstrOpt= document.forms[0].size[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["size"] = sizeCell;

    var sizeCell =  '<input type="text" value="" name =' +nameEquipmentType + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'equipmentType\',this,false); validateEquipmentType1(this);" style="width:75%" maxlength="2" />'
                    +'&nbsp;'+'<input type="button" value=". . ."  name="btnEquipmentTypeLookup" class="btnbutton" onclick="openEquipmentTypeLookup('+rowIndex+')"/>';    
    
    rowData ["equipmentType"]    =sizeCell;

    var sizeCell  = '<select name = ' +nameFullMT + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'fullMT\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';

    var lobjCombo = eval(document.forms[0].fullMT);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].fullMT[lintCtr].value;
       var lstrOpt= document.forms[0].fullMT[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["fullMT"] = sizeCell;
    
    var sizeCell  = '<select name = ' +nameBookingType + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'bookingType\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';

    var lobjCombo = eval(document.forms[0].bookingType);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].bookingType[lintCtr].value;
       var lstrOpt= document.forms[0].bookingType[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["bookingType"] = sizeCell;
    
    var sizeCell  = '<select name = ' +nameSocCoc + ' onchange = "javascript:onChangeCocSoc('+rowIndex+');updateOverlandedStatusFlage('+rowIndex+',\'socCoc\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].socCoc);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].socCoc[lintCtr].value;
       var lstrOpt= document.forms[0].socCoc[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["socCoc"] = sizeCell;
    
    var sizeCell = "<input type='text'   value=''    name='overlandedValue["+rowIndex+"].shipmentTerm' maxlength='4' style='width : 96%' onblur=\"javascript:changeUpper(this);updateOverlandedStatusFlage('"+rowIndex+"','shipmentTerm',this);validateShipmentTerm1(this);\">";        
    rowData ["shipmentTerm"]    = sizeCell;
    
    var sizeCell = "<input type='text'   value=''    name='overlandedValue["+rowIndex+"].shipmentType'     maxlength ='3' style='width : 96%' onblur=\"javascript:updateOverlandedStatusFlage('"+rowIndex+"','shipmentType',this)\"        >";        
    rowData ["shipmentType"]    = sizeCell;

    var sizeCell  = '<select name = ' +namePodStatus + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'podStatus\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].podStatus);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].podStatus[lintCtr].value;
       var lstrOpt= document.forms[0].podStatus[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["podStatus"] = sizeCell;
    
    /*
    var sizeCell  = '<select name = ' +nameLocalContSts + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'localContSts\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].localContSts);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].localContSts[lintCtr].value;
       var lstrOpt= document.forms[0].localContSts[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    */
    var sizeCell =  '<input type="text" value="" name =' +nameLocalContSts + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'localContSts\',this);"  style="width:98%" maxlength="10" />';
    rowData ["localContSts"] = sizeCell;

    var sizeCell  = '<select name = ' +nameMidstream + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'midstream\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].midstream);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].midstream[lintCtr].value;
       var lstrOpt= document.forms[0].midstream[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["midstream"] = sizeCell;

    var sizeCell  = '<select name = ' +nameLoadCondition + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'loadCondition\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].loadCondition);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].loadCondition[lintCtr].value;
       var lstrOpt= document.forms[0].loadCondition[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["loadCondition"] = sizeCell;

    var sizeCell  = '<select name = ' +nameDischargeSts + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'dischargeSts\',this);" size="1" style="height=20px" style="width:98%"><option value="OL">Over Landed</option>';
    var lobjCombo = eval(document.forms[0].dischargeSts);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].dischargeSts[lintCtr].value;
       var lstrOpt= document.forms[0].dischargeSts[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["dischargeSts"] = sizeCell;
    
    var sizeCell =  '<input type="text" value="" name =' +nameStowPosition + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'stowPosition\',this);" onchange="onChangeStowagePosition('+rowIndex+');" style="width:98%" maxlength="7" />';
    rowData ["stowPosition"] = sizeCell;        

    var sizeCell = '<input type="text" name =' +nameActivityDate + '   onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'activityDate\',this);" maxlength=\'16\' style="width:70%"/>'
                +'&nbsp;'   +' <a href="#" onclick="showCalendarWithTime(\''+nameActivityDate+'\', \'\', \'\', \'1\')">'
                            +' <img src="'+ctxPath1+'/images/btnCalendar.gif" alt="Calender" class="calender">'       
    rowData ["activityDate"] = sizeCell;        

    var sizeCell =  '<input type="text" value="" name =' +nameWeight + ' onblur = "javascript:putMask_Number(this, 12, 2);updateOverlandedStatusFlage('+rowIndex+',\'weight\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\"maxlength="14" />';
    rowData ["weight"] = sizeCell;        
    
    
    var sizeCell  = '<select name = ' + nameDamaged + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'damaged\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].damaged);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].damaged[lintCtr].value;
       var lstrOpt= document.forms[0].damaged[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["damaged"] =   sizeCell;

    var sizeCell =  '<input type="text" value="" name =' +nameVoidSlot + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'voidSlot\',this);" style="width:98%" maxlength="6" class="non_edit" readonly="true" />';
    rowData ["voidSlot"] = sizeCell;        
    
//    var sizeCell =  '<input type="text" value="" name =' +nameSlotOperator + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'slotOperator\',this,false); validateSlotOperatorCode(this);" style="width:75%" maxlength="4" />'
    var sizeCell =  '<input type="text" value="" name =' +nameSlotOperator + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'slotOperator\',this,false); validateSlotOperatorCode(this, '+rowIndex+');" style="width:75%" maxlength="4" />'
                    +'&nbsp;'+'<input type="button" value=". . ."  name="btnSlotOperatorCodeLookup" class="btnbutton" onclick="openSlotOperatorLookup('+rowIndex+')"/>';
    rowData ["slotOperator"] = sizeCell;        

//     var sizeCell =  '<input type="text" value="" name =' +nameContOperator + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'contOperator\',this,false); validateOperatorCode1(this);" style="width:75%" maxlength="4" />'
    var sizeCell =  '<input type="text" value="" name =' +nameContOperator + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'contOperator\',this,false); validateOperatorCode1(this, '+rowIndex+');" style="width:75%" maxlength="4" />'
                    +'&nbsp;'+'<input type="button" value=". . ."  name="btnContOperatorCodeLookup" class="btnbutton" onclick="openContainerOperatorLookup('+rowIndex+')"/>';    
    
    rowData ["contOperator"] = sizeCell;        


    var sizeCell =  '<input type="text" value="" name =' +nameOutSlotOperator + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'outSlotOperator\',this,false);validateOutSlotOperatorCode(this, '+rowIndex+');" style="width:75%" maxlength="4" />'
                    +'&nbsp;'+'<input type="button" value=". . ."  name="btnOutSlotOperatorCodeLookup" class="btnbutton" onclick="openOutSlotOperatorLookup('+rowIndex+')"/>';
    rowData ["outSlotOperator"] = sizeCell;        
    
    var sizeCell  = '<select name = ' +nameSpecialHandling + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'specialHandling\',this); onChangeSpecialHandling('+rowIndex+')"  size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].specialHandling);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].specialHandling[lintCtr].value;
       var lstrOpt= document.forms[0].specialHandling[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["specialHandling"] =   sizeCell;
    
    
    
    var sizeCell =  '<input type="text" value="" name =' +nameSealNo + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'sealNo\',this);" style="width:98%" maxlength="20" />';
    rowData ["sealNo"] = sizeCell;        
    

    var sizeCell =  '<input type="text" value="" name =' +namePol + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'pol\',this,false); validatePortCode1(this);" style="width:75%" maxlength="5" />'
                    +'&nbsp;'+'<input type="button" value=". . ."  name="btnPolLookup" class="btnbutton" onclick="openPodLookup('+rowIndex+')"/>';

    rowData ["pol"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +namePolTerminal + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'polTerminal\',this);validatePortTerminal1(this);" style="width:75%" maxlength="5" />'
                    +'&nbsp;'+'<input type="button" value=". . ."  name="btnPolTerminalLookup" class="btnbutton" onclick="openPodTerminalLookup('+rowIndex+')"/>';        
    rowData ["polTerminal"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextPOD1 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'nextPOD1\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
    rowData ["nextPOD1"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextPOD2 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'nextPOD2\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
    rowData ["nextPOD2"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextPOD3 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'nextPOD3\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
    rowData ["nextPOD3"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameFinalPOD + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'finalPOD\',this);"  style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
    rowData ["finalPOD"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameFinalDest + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'finalDest\',this);"  style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
    rowData ["finalDest"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextService + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'nextService\',this);"  style="width:98%" maxlength="5" />';
    rowData ["nextService"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextVessel + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'nextVessel\',this);"  style="width:98%" maxlength="25" />';
    rowData ["nextVessel"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextVoyage + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'nextVoyage\',this);" style="width:98%" maxlength="10" />';
    rowData ["nextVoyage"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameNextDirection + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'nextDirection\',this);"  style="width:98%" maxlength="2" />';
    rowData ["nextDirection"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOVessel + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'connectingMLOVessel\',this);"  style="width:98%" maxlength="35" />';
    rowData ["connectingMLOVessel"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOVoyage + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'connectingMLOVoyage\',this);" style="width:98%" maxlength="10" />';
    rowData ["connectingMLOVoyage"] = sizeCell;        
    
    var sizeCell =      '<input type="text" name =' +nameMloETADate + '   onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'mloETADate\',this);" maxlength=\'16\' style="width:70%"/>'
                        +' <a href="#" onclick="showCalendarWithTime(\''+nameMloETADate+'\', \'\', \'\', \'1\')">'
                            +' <img src="'+ctxPath+'/images/btnCalendar.gif" alt="Calender" class="calender">'
    rowData ["mloETADate"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOPOD1 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'connectingMLOPOD1\',this);" style="width:98%" maxlength="5" />';
    rowData ["connectingMLOPOD1"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOPOD2 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'connectingMLOPOD2\',this);" style="width:98%" maxlength="5" />';
    rowData ["connectingMLOPOD2"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOPOD3 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'connectingMLOPOD3\',this);" style="width:98%" maxlength="5" />';
    rowData ["connectingMLOPOD3"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +namePlaceOfDel + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'placeOfDel\',this);" style="width:98%" maxlength="5" />';
    rowData ["placeOfDel"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstCode1 + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'handlingInstCode1\',this);validateHandInsCode1(this,1,('+rowIndex+'));" style="width:75%" maxlength="3" />'
                   +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup1('+rowIndex+')"/>';            
    rowData ["handlingInstCode1"] = sizeCell;        

    var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstDesc1 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'handlingInstDesc1\',this);" style="width:98%" maxlength="60" class="non_edit" readonly="true" />';
    rowData ["handlingInstDesc1"] = sizeCell;        

    var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstCode2 + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'handlingInstCode2\',this);validateHandInsCode1(this,2,('+rowIndex+'));" style="width:75%" maxlength="3" />'
                   +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup2('+rowIndex+')"/>';        
    rowData ["handlingInstCode2"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstDesc2 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'handlingInstDesc2\',this);" style="width:98%" maxlength="60" class="non_edit" readonly="true"  />';
    rowData ["handlingInstDesc2"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstCode3 + ' onblur = "javascript:changeUpper(this);updateOverlandedStatusFlage('+rowIndex+',\'handlingInstCode3\',this);validateHandInsCode1(this,3,('+rowIndex+'));" style="width:75%" maxlength="3" />'
                   +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup3('+rowIndex+')"/>';        
    rowData ["handlingInstCode3"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstDesc3 + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'handlingInstDesc3\',this);" style="width:98%" maxlength="60" class="non_edit" readonly="true" />';
    rowData ["handlingInstDesc3"] = sizeCell;        
    
    var sizeCell;
         sizeCell='<select name =' + nameContLoadRemark1 + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'contLoadRemark1\',this);" size="1" style="width:96%"><option value="">Select One...</option>';
      
        var lobjCombo = eval(document.forms[0].contLoadRemark1);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].contLoadRemark1[lintCtr].value;
           var lstrOpt= document.forms[0].contLoadRemark1[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell=sizeCell+'</select>';
        rowData ["contLoadRemark1"] = sizeCell;

        var sizeCell;
        sizeCell='<select name =' + nameContLoadRemark2 + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'contLoadRemark2\',this);" size="1" style="width:98%"><option value="">Select One...</option>';
        
        var lobjCombo = eval(document.forms[0].contLoadRemark2);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
            var lstrCellVal= document.forms[0].contLoadRemark2[lintCtr].value;
            var lstrOpt= document.forms[0].contLoadRemark2[lintCtr].text;
            sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell=sizeCell+'</select>';
        rowData ["contLoadRemark2"] = sizeCell;

    var sizeCell =  '<input type="text" value="" name =' +nameSpecialCargo + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'specialCargo\',this);" style="width:98%" maxlength="3" />';
    rowData ["specialCargo"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameImdgClass + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'imdgClass\',this);" style="width:98%" maxlength="4" />';
    rowData ["imdgClass"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameUnNumber + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'unNumber\',this);" style="width:75%" maxlength="6" />'
                   +'&nbsp;'+'<input type="button" value=". . ."  name="btnUNNoLookup" class="btnbutton" onclick="openUNNoLookup('+rowIndex+',3)"/>';                
    rowData ["unNumber"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameUnNumberVariant + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'unNumberVariant\',this);" style="width:98%" maxlength="1" />';
    rowData ["unNumberVariant"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +namePortClass + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'portClass\',this);" style="width:98%" maxlength="5" />';
    rowData ["portClass"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +namePortClassType + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'portClassType\',this);" style="width:98%" maxlength="5" />';
    rowData ["portClassType"] = sizeCell;        
    
    var sizeCell  = '<select name = ' +nameFlashUnit + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'flashUnit\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].flashUnit);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].flashUnit[lintCtr].value;
       var lstrOpt= document.forms[0].flashUnit[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["flashUnit"] =   sizeCell;
       
    
    var sizeCell =  '<input type="text" value="" name =' +nameFlashPoint + ' onblur = "javascript:putMask_Number(this, 3, 3);updateOverlandedStatusFlage('+rowIndex+',\'flashPoint\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="7" />';
    rowData ["flashPoint"] = sizeCell;        

    var sizeCell  = '<select name = ' +nameFumigationOnly + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'fumigationOnly\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].fumigationOnly);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].fumigationOnly[lintCtr].value;
       var lstrOpt= document.forms[0].fumigationOnly[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["fumigationOnly"] =   sizeCell;

    var sizeCell  = '<select name = ' +nameResidue + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'residue\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].residue);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].residue[lintCtr].value;
       var lstrOpt= document.forms[0].residue[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["residue"] =   sizeCell;


    var sizeCell =  '<input type="text" value="" name =' +nameOverheight + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOverlandedStatusFlage('+rowIndex+',\'overheight\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
    rowData ["overheight"] = sizeCell;        

    var sizeCell =  '<input type="text" value="" name =' +nameOverwidthLeft + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOverlandedStatusFlage('+rowIndex+',\'overwidthLeft\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
    rowData ["overwidthLeft"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameOverwidthRight + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOverlandedStatusFlage('+rowIndex+',\'overwidthRight\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
    rowData ["overwidthRight"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameOverlengthFront + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOverlandedStatusFlage('+rowIndex+',\'overlengthFront\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
    rowData ["overlengthFront"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameOverlengthAfter + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOverlandedStatusFlage('+rowIndex+',\'overlengthAfter\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
    rowData ["overlengthAfter"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameReeferTemp + ' onblur = "javascript:putMask_Number(this, 3, 3);updateOverlandedStatusFlage('+rowIndex+',\'reeferTemp\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="8" />';
    rowData ["reeferTemp"] = sizeCell;        

   
    var sizeCell  = '<select name = ' +nameReeferTempUnit + ' onchange = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'reeferTempUnit\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
    var lobjCombo = eval(document.forms[0].reeferTempUnit);
    for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
       var lstrCellVal= document.forms[0].reeferTempUnit[lintCtr].value;
       var lstrOpt= document.forms[0].reeferTempUnit[lintCtr].text;
       sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
    }
    sizeCell=sizeCell+'</select>';
    rowData ["reeferTempUnit"] =   sizeCell;

    var sizeCell =  '<input type="text" value="" name =' +nameHumidity + ' onblur = "javascript:putMask_Number(this, 3, 2);updateOverlandedStatusFlage('+rowIndex+',\'humidity\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="6" />';
    rowData ["humidity"] = sizeCell;        
    
    var sizeCell =  '<input type="text" value="" name =' +nameVentilation + ' onblur = "javascript:putMask_Number(this, 3, 2);updateOverlandedStatusFlage('+rowIndex+',\'ventilation\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="6" />';
    rowData ["ventilation"] = sizeCell;        

    var sizeCell =  '<input type="text" value="" name =' +nameMergeAction + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'mergeAction\',this);" style="width:98%" maxlength="5" />';
    rowData ["mergeAction"] = sizeCell;            
    
    //var sizeCell =  '<input type="text" value="" name =' +nameError + ' onblur = "javascript:updateOverlandedStatusFlage('+rowIndex+',\'error\',this);" style="width:98%" maxlength="1" class="non_edit" readonly="true" />';
    var sizeCell =    '<input type="button" value=". . ." name="btneErrorMessage" class="btnbutton" disabled = "true" />';        
    rowData ["error"] = sizeCell;        
    

    return rowData;
}

function getStatusObject(rowIndex)
{
    return document.getElementById("overlandedValue["+rowIndex+"].status");
}

function getSelectedObject(rowIndex)
{
    return document.getElementById("overlandedValue["+rowIndex+"].selected");
}

function getFixedColumnsTableName()
{
    return "tableFixedColumns";
}

function getFixedColumnsDivId()
{
    return "fixedColumns_bodyDiv";
}

function getGridId()
{
    return "gridList";
}

function getSelectedRowDataDLO(aintRowIndex)
{   
    var mapRowData = getSelectedRowData(aintRowIndex);
    return mapRowData;
}

function highlightRow(aintRowIndex) 
{
    highlightradioTD("row"+aintRowIndex);
    setRowSelection(aintRowIndex);
}


function getTempRecordStatusObject(rowIndex)
{
    return document.getElementById("overlandedValue["+rowIndex+"].tempRecordStatus");
}

function edit() 
{
    if(document.forms[0].radioGroup1 != null){
        if(document.forms[0].radioGroup1[0] != null){
            for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {
                if(document.forms[0].radioGroup1[i].checked) {
                    getSelectedRowDataDLO(i);
                }
            }
        } else {
            getSelectedRowDataDLO(0);
        }
    }
}

function getSearchCriteria() 
{
    var larrSearchCriteria = ["srchOverlandedFind1","srchOverlandedIn1","srchOverlandedFind2","srchOverlandedIn2","srchOverlandedOrder1","srchOverlandedOrder1Ord","srchOverlandedOrder2","srchOverlandedOrder2Ord"];
    return larrSearchCriteria;
}

function getSelectedViewId(){
    return document.forms[0].overlandedView.value;
    
}    

function validateHandInsCode1(astrHandInCode, hinsCodeNo, arow){
    
    if(astrHandInCode.value!=""){
        var response = validateHandInsCode(astrHandInCode);
    
        if(hinsCodeNo==1){
            if(response=="undefined" || response==null){
                ERROR_FLAG_HIC1 = EZL_SE038;            
                showBarMessage(EZL_SE038,ERROR_MSG);
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc1').value = "";                
                return false;
            }else if(response =="N"){
                ERROR_FLAG_HIC1 = EZL_SE038;            
                showBarMessage(EZL_SE038,ERROR_MSG);
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc1').value = "";
                return false;
            }else{
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc1').value = response;
                ERROR_FLAG_HIC1 = 'success';                    
                showBarMessage(ECM_GI0001);
            }    
        }    
        if(hinsCodeNo==2){
            if(response=="undefined" || response==null){
                ERROR_FLAG_HIC2 = EZL_SE040;
                showBarMessage(EZL_SE040,ERROR_MSG);
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc2').value = "";                
                return false;
            }else if(response =="N"){
                ERROR_FLAG_HIC2 = EZL_SE040;
                showBarMessage(EZL_SE040,ERROR_MSG);
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc2').value = "";                
                return false;
            }else{
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc2').value = response;
                ERROR_FLAG_HIC2 = 'success';                    
                showBarMessage(ECM_GI0001);
            }    
        }
        if(hinsCodeNo==3){
            if(response=="undefined" || response==null){
                ERROR_FLAG_HIC3 = EZL_SE041;
                showBarMessage(EZL_SE041,ERROR_MSG);
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc3').value = "";                
                return false;
            }else if(response =="N"){
                ERROR_FLAG_HIC3 = EZL_SE041;            
                showBarMessage(EZL_SE041,ERROR_MSG);
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc3').value = "";                
                return false;
            }else{
                document.getElementById('overlandedValue[' + arow + '].handlingInstDesc3').value = response;
                ERROR_FLAG_HIC3 = 'success';                    
                showBarMessage(ECM_GI0001);
            }    
        }
    }else{
        if(hinsCodeNo==1){
            ERROR_FLAG_HIC1 = 'success';        
        } else if (hinsCodeNo==2){
            ERROR_FLAG_HIC2 = 'success';        
        } else if (hinsCodeNo==3){
            ERROR_FLAG_HIC3 = 'success';        
        }    
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;    
}

function validateOperatorCode1(OprCode, arow){
    var socCocFlag = document.getElementById('overlandedValue[' + arow + '].socCoc').value;                
    if(OprCode.value == "****"){
        ERROR_FLAG_CONT_OPR = EZL_SE039;
        showBarMessage(EZL_SE039,ERROR_MSG);
        return false;
    }
    /* When SOC-COC flage is 'S' then no need to validated
       slot operator code. */
    if ((socCocFlag == "S") || (socCocFlag == "SOC")) {
        ERROR_FLAG_CONT_OPR = 'success';    
        return false;
    }
    if(OprCode.value!=""){
        var response = validateOperatorCode(OprCode);
        if(response=="undefined" || response==null){
            ERROR_FLAG_CONT_OPR = EZL_SE039;
            showBarMessage(EZL_SE039,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_CONT_OPR = EZL_SE039;
            showBarMessage(EZL_SE039,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_CONT_OPR = 'success';    
            showBarMessage("Ready");
            return false;
        }
    }else{
        ERROR_FLAG_CONT_OPR = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}

// function validateSlotOperatorCode(slotOprCode){
function validateSlotOperatorCode(slotOprCode, arow){
    var socCocFlag = document.getElementById('overlandedValue[' + arow + '].socCoc').value;                

    /* When SOC-COC flage is 'S' then no need to validated
       slot operator code. */
    if ((socCocFlag == "S") || (socCocFlag == "SOC")) {
        ERROR_FLAG_CONT_OPR = 'success';
        return false;
    }

    if(slotOprCode.value!=""){
        var response = validateOperatorCode(slotOprCode);
        if(response=="undefined" || response==null){
            ERROR_FLAG_SLOT_OPR = EZL_SE045;            
            showBarMessage(EZL_SE045,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_SLOT_OPR = EZL_SE045;            
            showBarMessage(EZL_SE045,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_SLOT_OPR = 'success';    
            showBarMessage(ECM_GI0001);
            return false;
        }
    }else{
        ERROR_FLAG_SLOT_OPR = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}

function validateOutSlotOperatorCode(OprCode, arow){
    var socCocFlag = document.getElementById('overlandedValue[' + arow + '].socCoc').value;                
	/* When SOC-COC flage is 'S' then no need to validated
       slot operator code. */
    if ((socCocFlag == "S") || (socCocFlag == "SOC")) {
        ERROR_FLAG_OUT_SLOT_OPR = 'success';
        return false;
    }

	
    if(OprCode.value!=""){
        var response = validateOperatorCode(OprCode);
        if(response=="undefined" || response==null){
            ERROR_FLAG_OUT_SLOT_OPR = EZL_SE044;            
            showBarMessage(EZL_SE044,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_OUT_SLOT_OPR = EZL_SE044;            
            showBarMessage(EZL_SE044,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_OUT_SLOT_OPR = 'success';    
            showBarMessage(ECM_GI0001);
            return false;
        }
    }else{
        ERROR_FLAG_OUT_SLOT_OPR = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}

function validateShipmentTerm1(shipmentTerm){
    if(shipmentTerm.value!=""){
        var response = validateShipmentTerm(shipmentTerm);
        if(response=="undefined" || response==null){
            ERROR_FLAG_SHPMNT_TERM = EZL_SE042;            
            showBarMessage(EZL_SE042,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_SHPMNT_TERM = EZL_SE042;            
            showBarMessage(EZL_SE042,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_SHPMNT_TERM = 'success';    
            showBarMessage(ECM_GI0001);
            return false;
        }
    }else{
        ERROR_FLAG_SHPMNT_TERM = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}
    
function validateEquipmentType1(equipType){
    if(equipType.value!=""){
        var response = validateEquipmentType(equipType);
        if(response=="undefined" || response==null){
            ERROR_FLAG_EQUIP_TYPE = EZL_SE048;            
            showBarMessage(EZL_SE048,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_EQUIP_TYPE = EZL_SE048;            
            showBarMessage(EZL_SE048,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_EQUIP_TYPE = 'success';    
            showBarMessage(ECM_GI0001);
            return false;
        }
    }else{
        ERROR_FLAG_EQUIP_TYPE = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}
        
function validatePortCode1(portCode){
    if(portCode.value!=""){
        var response = validatePortCode(portCode);
        if(response=="undefined" || response==null){
            ERROR_FLAG_PORT_CODE = EZL_SE049;            
            showBarMessage(EZL_SE049,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_PORT_CODE = EZL_SE049;            
            showBarMessage(EZL_SE049,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_PORT_CODE = 'success';    
            showBarMessage(ECM_GI0001);
            return false;
        }
    }else{
        ERROR_FLAG_PORT_CODE = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}
        
function validatePortTerminal1(portTerminal){
    if(portTerminal.value!=""){
        var response = validatePortTerminal(portTerminal);
        if(response=="undefined" || response==null){
            ERROR_FLAG_PORT_TERMINAL = EZL_SE050;            
            showBarMessage(EZL_SE050,ERROR_MSG);
            return false;
        }else if(response =="N"){
            ERROR_FLAG_PORT_TERMINAL = EZL_SE050;            
            showBarMessage(EZL_SE050,ERROR_MSG);
            return false;
        }else{
            ERROR_FLAG_PORT_TERMINAL = 'success';    
            showBarMessage(ECM_GI0001);
            return false;
        }
    }else{
        ERROR_FLAG_PORT_TERMINAL = 'success';        
        showBarMessage(ECM_GI0001);
        return false;
    }
    return false;
}

/*Called by master lookup screens to return selected values*/
function setLookupValues(aFormName, aRowId,strMasterId, arrResultData){
    var lobjControl;
    if(arrResultData[0] == 'FAILURE'){
        return;
    }
    if((strMasterId == 'OPERATOR') && (lookupId == 'C')){
        //Setting Container Operator value
        lobjControl = document.getElementById('overlandedValue[' + aRowId + '].contOperator');
        lobjControl.value = arrResultData[0];
        ERROR_FLAG_CONT_OPR = 'success';                
        updateOverlandedStatusFlage(aRowId, 'contOperator', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'OPERATOR') && (lookupId == 'O')){
        //Setting Out Slot Operator value
        lobjControl  = document.getElementById('overlandedValue[' + aRowId + '].outSlotOperator');
        lobjControl.value = arrResultData[0];
        ERROR_FLAG_OUT_SLOT_OPR = 'success';                
        updateOverlandedStatusFlage(aRowId, 'outSlotOperator', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'OPERATOR') && (lookupId == 'S')){
        //Setting Out Slot Operator value
        lobjControl = document.getElementById('overlandedValue[' + aRowId + '].slotOperator');
        lobjControl.value=arrResultData[0];
        ERROR_FLAG_SLOT_OPR = 'success';                
        updateOverlandedStatusFlage(aRowId, 'slotOperator', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'HIC') && (lookupId == 'HIC1')){
        lobjControl = document.getElementById('overlandedValue[' + aRowId + '].handlingInstCode1');
        lobjControl.value = arrResultData[IDX_HICCD];    
        document.getElementById('overlandedValue[' + aRowId + '].handlingInstDesc1').value
            =arrResultData[IDX_HISDS];
        ERROR_FLAG_HIC1 = 'success';                
        updateOverlandedStatusFlage(aRowId, 'handlingInstCode1', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'HIC') && (lookupId == 'HIC2')){
        lobjControl = document.getElementById('overlandedValue[' + aRowId + '].handlingInstCode2');
        lobjControl.value = arrResultData[IDX_HICCD];    
        document.getElementById('overlandedValue[' + aRowId + '].handlingInstDesc2').value
            =arrResultData[IDX_HISDS];
        ERROR_FLAG_HIC2 = 'success';                
        updateOverlandedStatusFlage(aRowId, 'handlingInstCode2', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'HIC') && (lookupId == 'HIC3')){
        lobjControl = document.getElementById('overlandedValue[' + aRowId + '].handlingInstCode3');
        lobjControl.value =arrResultData[IDX_HICCD];    
        document.getElementById('overlandedValue[' + aRowId + '].handlingInstDesc3').value
            =arrResultData[IDX_HISDS];
        ERROR_FLAG_HIC3 = 'success';                
        updateOverlandedStatusFlage(aRowId, 'handlingInstCode3', lobjControl);        
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'PORT_CLASS')){
        lobjControl        = document.getElementById('overlandedValue[' + aRowId + '].imdgClass');
        lobjControl.value  = arrResultData[IDX_IMDG];
        updateOverlandedStatusFlage(aRowId, 'imdgClass', lobjControl);                
        var lobjControl2   = document.getElementById('overlandedValue[' + aRowId + '].unNumber');
        lobjControl2.value = arrResultData[IDX_UNNO];
        updateOverlandedStatusFlage(aRowId, 'unNumber', lobjControl2);                
        var lobjControl3   = document.getElementById('overlandedValue[' + aRowId + '].unNumberVariant');
        lobjControl3.value = arrResultData[IDX_UNVAR];            
        updateOverlandedStatusFlage(aRowId, 'unNumberVariant', lobjControl3);                
        var lobjControl4   = document.getElementById('overlandedValue[' + aRowId + '].portClass');
        lobjControl4.value = arrResultData[IDX_PORT_CODE];            
        updateOverlandedStatusFlage(aRowId, 'portClass', lobjControl4);                        
        var lobjControl5   = document.getElementById('overlandedValue[' + aRowId + '].portClassType');
        lobjControl5.value = arrResultData[IDX_PORT_TYPE];
        updateOverlandedStatusFlage(aRowId, 'portClassType', lobjControl5);                
        var lobjControl6   = document.getElementById('overlandedValue[' + aRowId + '].flashPoint');
        lobjControl6.value = trimString(arrResultData[IDX_FLASH_POINT]);
        updateOverlandedStatusFlage(aRowId, 'flashPoint', lobjControl6);                
        var lobjControl7   = document.getElementById('overlandedValue[' + aRowId + '].flashUnit');
        lobjControl7.value = 'C';
        updateOverlandedStatusFlage(aRowId, 'flashUnit', lobjControl7);                
            
        //ERROR_FLAG = 'success';                
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'EQUIPMENT_TYPE')){
        lobjControl  = document.getElementById('overlandedValue[' + aRowId + '].equipmentType');
        lobjControl.value = arrResultData[0];    
        ERROR_FLAG_EQUIP_TYPE = 'success';                
        updateOverlandedStatusFlage(aRowId, 'equipmentType', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'PORT')){
        lobjControl = document.getElementById('overlandedValue[' + aRowId + '].pol');
        lobjControl.value = arrResultData[0];    
        ERROR_FLAG_PORT_CODE = 'success';                
        updateOverlandedStatusFlage(aRowId, 'pol', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    } else if((strMasterId == 'TERMINAL')){
        lobjControl       = document.getElementById('overlandedValue[' + aRowId + '].polTerminal');
        lobjControl.value = arrResultData[0];    
        ERROR_FLAG_PORT_TERMINAL = 'success';                
        updateOverlandedStatusFlage(aRowId, 'polTerminal', lobjControl);
        showBarMessage(ECM_GI0001);
        return false;            
    }
    return false;
}

    var ctxPath                = ctxPath1;
    var comboData;

    function addRowInFixedTable() {
		if(!(document.getElementById("overlandedSearFlag").value == 'true')) {
			showBarMessage(ECM_SE0007,ERROR_MSG);
			return false;
		}
		
        document.forms[0].updFlag.value = 'Y';
        var table               = document.getElementById("tableFixedColumns");
        var totalRows           = table.rows.length;
        var rowIndex            = table.rows.length;

        var nameRadioGroup1  = "radioGroup1";
        var nameDelete       = "overshippedValue["+ rowIndex  +"].selected";    
        var nameStatus       = "overshippedValue[" +rowIndex  + "].status";  
        var nameBookingNo    = "overshippedValue[" + rowIndex + "].bookingNo";
        var nameEquipmentNo  = "overshippedValue[" + rowIndex + "].equipmentNo";
        var nameOverContId   = "overshippedValue[" + rowIndex + "].overshippedContainerId";   
        var nameRecChDate    = "overshippedValue[" + rowIndex + "].recordChangeDt";   
        var nameOverSeqNo    = "overshippedValue[" + rowIndex + "].overshippedSeqNo";   
        
        
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
            + '<input type="text" name =' +nameBookingNo + '  style="width:98%" onblur="updateOvershippedStatusFlage(' + rowIndex + ')"  maxlength="17" />'
            +  '</td>';
        
        var cellEqupmentNo = row.insertCell(3);
        cellEqupmentNo.setAttribute("width", "30%");    
        cellEqupmentNo.innerHTML =   '<td>'
            + '<input type="text" name =' +nameEquipmentNo + '  style="width:98%" onblur="updateOvershippedStatusFlage(' + rowIndex + ')" maxlength="12" />'
            + '</td>';

        return false;
    }

    function getRecordToAddInGrid(rowIndex)
    {
		/* return if search not performed. */
		if(!(document.getElementById("overlandedSearFlag").value == 'true')) {
			showBarMessage(ECM_SE0007,ERROR_MSG);
			return false;
		}

		
        // Create Data for row to add
        var rowData = {};
        var nameSrlNo        = "overshippedValue[" + rowIndex + "].srlNo";
        var nameSocCoc       = "overshippedValue[" + rowIndex + "].socCoc";
        var nameBillNo       = "overshippedValue[" + rowIndex + "].billNo";
        var nameSize         = "overshippedValue[" + rowIndex + "].size ";
        var nameEquipmentType = "overshippedValue[" + rowIndex + "].equipmentType";
        var nameFullMT       = "overshippedValue[" + rowIndex + "].fullMT";
        var nameBookingType  = "overshippedValue[" + rowIndex + "].bookingType";

        var nameShipmentTerm = "overshippedValue[" + rowIndex + "].shipmentTerm";
        var nameShipmentType = "overshippedValue[" + rowIndex + "].shipmentType";
        var namePolStatus    = "overshippedValue[" + rowIndex + "].polStatus";
        var nameLocalContSts = "overshippedValue[" + rowIndex + "].localContSts";
        var nameMidstream    = "overshippedValue[" + rowIndex + "].midstream";
        var nameLoadCondition = "overshippedValue[" + rowIndex + "].loadCondition";
        var nameLoadingStatus = "overshippedValue[" + rowIndex + "].loadingStatus";
        var nameStowPosition = "overshippedValue[" + rowIndex + "].stowPosition";
        var nameActivityDate = "overshippedValue[" + rowIndex + "].activityDate";
        var nameWeight       = "overshippedValue[" + rowIndex + "].weight";

        var nameDamaged      = "overshippedValue[" + rowIndex + "].damaged";
        var nameVoidSlot     = "overshippedValue[" + rowIndex + "].voidSlot";
        var namePreAdvice    = "overshippedValue[" + rowIndex + "].preAdvice";
        var nameSlotOperator = "overshippedValue[" + rowIndex + "].slotOperator";
        var nameContOperator = "overshippedValue[" + rowIndex + "].contOperator";
        var nameOutSlotOperator = "overshippedValue[" + rowIndex + "].outSlotOperator";
        var nameSpecialHandling = "overshippedValue[" + rowIndex + "].specialHandling";
        var nameSealNo       = "overshippedValue[" + rowIndex + "].sealNo";
        var namePod          = "overshippedValue[" + rowIndex + "].pod";
        var namePodTerminal  = "overshippedValue[" + rowIndex + "].podTerminal";
        var nameNextPOD1     = "overshippedValue[" + rowIndex + "].nextPOD1";

        var nameNextPOD2     = "overshippedValue[" + rowIndex + "].nextPOD2";
        var nameNextPOD3     = "overshippedValue[" + rowIndex + "].nextPOD3";
        var nameFinalPOD     = "overshippedValue[" + rowIndex + "].finalPOD";
        var nameFinalDest    = "overshippedValue[" + rowIndex + "].finalDest";
        var nameNextService  = "overshippedValue[" + rowIndex + "].nextService";
        var nameNextVessel   = "overshippedValue[" + rowIndex + "].nextVessel";
        var nameNextVoyage   = "overshippedValue[" + rowIndex + "].nextVoyage";
        var nameNextDirection = "overshippedValue[" + rowIndex + "].nextDirection";
        var nameConnectingMLOVessel = "overshippedValue[" + rowIndex + "].connectingMLOVessel";
        var nameConnectingMLOVoyage = "overshippedValue[" + rowIndex + "].connectingMLOVoyage";
        var nameMloETADate          = "overshippedValue[" + rowIndex + "].mloETADate";
        var nameConnectingMLOPOD1 = "overshippedValue[" + rowIndex + "].connectingMLOPOD1";
        var nameConnectingMLOPOD2 = "overshippedValue[" + rowIndex + "].connectingMLOPOD2";
        var nameConnectingMLOPOD3 = "overshippedValue[" + rowIndex + "].connectingMLOPOD3";
        var namePlaceOfDel           = "overshippedValue[" + rowIndex + "].placeOfDel";
        var nameExMLOVessel = "overshippedValue[" + rowIndex + "].exMLOVessel";
        var nameExMLOVoyage = "overshippedValue[" + rowIndex + "].exMLOVoyage";
        var nameExMloETADate = "overshippedValue[" + rowIndex + "].exMloETADate";
        var nameHandlingInstCode1 = "overshippedValue[" + rowIndex + "].handlingInstCode1";
        var nameHandlingInstDesc1 = "overshippedValue[" + rowIndex + "].handlingInstDesc1";
        var nameHandlingInstCode2 = "overshippedValue[" + rowIndex + "].handlingInstCode2";
        var nameHandlingInstDesc2 = "overshippedValue[" + rowIndex + "].handlingInstDesc2";
        var nameHandlingInstCode3 = "overshippedValue[" + rowIndex + "].handlingInstCode3";

        var nameHandlingInstDesc3 = "overshippedValue[" + rowIndex + "].handlingInstDesc3";
        var nameContLoadRemark1 = "overshippedValue[" + rowIndex + "].contLoadRemark1";
        var nameContLoadRemark2 = "overshippedValue[" + rowIndex + "].contLoadRemark2";
        var nameSpecialCargo    = "overshippedValue[" + rowIndex + "].specialCargo";
        var nameImdgClass       = "overshippedValue[" + rowIndex + "].imdgClass";
        var nameUnNumber        = "overshippedValue[" + rowIndex + "].unNumber";
        var nameUnNumberVariant = "overshippedValue[" + rowIndex + "].unNumberVariant";
        var namePortClass       = "overshippedValue[" + rowIndex + "].portClass";
        var namePortClassType   = "overshippedValue[" + rowIndex + "].portClassType";
        var nameFlashUnit       = "overshippedValue[" + rowIndex + "].flashUnit";

        var nameFlashPoint      = "overshippedValue[" + rowIndex + "].flashPoint";
        var nameFumigationOnly  = "overshippedValue[" + rowIndex + "].fumigationOnly";
        var nameResidue         = "overshippedValue[" + rowIndex + "].residue";
        var nameOverheight      = "overshippedValue[" + rowIndex + "].overheight";
        var nameOverwidthLeft   = "overshippedValue[" + rowIndex + "].overwidthLeft";
        var nameOverlengthFront = "overshippedValue[" + rowIndex + "].overlengthFront";
        var nameOverwidthRight  = "overshippedValue[" + rowIndex + "].overwidthRight";
        var nameOverlengthAfter = "overshippedValue[" + rowIndex + "].overlengthAfter";
        var nameReeferTemp      = "overshippedValue[" + rowIndex + "].reeferTemp";
        var nameReeferTempUnit  = "overshippedValue[" + rowIndex + "].reeferTempUnit";
        var nameHumidity        = "overshippedValue[" + rowIndex + "].humidity";
        var nameMergeAction     = "overshippedValue[" + rowIndex + "].mergeAction";
        var nameVentilation     = "overshippedValue[" + rowIndex + "].ventilation";
        var nameError           = "overshippedValue[" + rowIndex + "].error";
        var nameBookingNoSource = "overshippedValue[" + rowIndex + "].bookingNoSource";
        

        rowData ["billNo"]    = "<input type='text'   value=''    name='overshippedValue["+rowIndex+"].billNo'    maxlength='17' class='non_edit' readonly='true' style='width : 96%' onblur=\"javascript:updateOvershippedStatusFlage('"+rowIndex+"','billNo',this)\">";
        
        rowData ["bookingNoSource"]    = "<input type='text'   value=''    name='overshippedValue["+rowIndex+"].bookingNoSource'    maxlength='15' class='non_edit' readonly='true' style='width : 96%' onblur=\"javascript:updateOvershippedStatusFlage('"+rowIndex+"','billNo',this)\">";

        var nameSize = "overshippedValue[" + rowIndex + "].size ";
        var sizeCell; 

        sizeCell  = '<select name = ' +nameSize + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'size\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].size);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].size[lintCtr].value;
           var lstrOpt= document.forms[0].size[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell=sizeCell+'</select>';
        rowData ["size"] = sizeCell;

        var sizeCell =  '<input type="text" value="" name =' +nameEquipmentType + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'equipmentType\',this,false); validateEquipmentType1(this);" style="width:75%" maxlength="2" />'
                        +'&nbsp;'+'<input type="button" value=". . ."  name="btnEquipmentTypeLookup" class="btnbutton" onclick="openEquipmentTypeLookup('+rowIndex+')"/>';    
        
        rowData ["equipmentType"]    =sizeCell;    
        
        var sizeCell  = '<select name = ' +nameFullMT + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'fullMT\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';

        var lobjCombo = eval(document.forms[0].fullMT);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].fullMT[lintCtr].value;
           var lstrOpt= document.forms[0].fullMT[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["fullMT"] = sizeCell;
        
        var sizeCell  = '<select name = ' +nameBookingType + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'bookingType\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';

        var lobjCombo = eval(document.forms[0].bookingType);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].bookingType[lintCtr].value;
           var lstrOpt= document.forms[0].bookingType[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';

        rowData ["bookingType"] = sizeCell;
        
        var sizeCell  = '<select name = ' +nameSocCoc + ' onchange = "javascript:onChangeCocSoc('+rowIndex+');updateOvershippedStatusFlage('+rowIndex+',\'socCoc\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].socCoc);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].socCoc[lintCtr].value;
           var lstrOpt= document.forms[0].socCoc[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
            sizeCell     = sizeCell + '</select>';

        rowData ["socCoc"] = sizeCell;
        
        var sizeCell = "<input type='text'   value=''    name='overshippedValue["+rowIndex+"].shipmentTerm' maxlength='4' style='width : 96%' onblur=\"javascript:updateOvershippedStatusFlage('"+rowIndex+"','shipmentTerm',this)\"    class = 'non_edit' readonly='true'    >";        
        rowData ["shipmentTerm"]    = sizeCell;
        
        var sizeCell = "<input type='text'   value=''    name='overshippedValue["+rowIndex+"].shipmentType'     maxlength ='3' style='width : 96%' onblur=\"javascript:updateOvershippedStatusFlage('"+rowIndex+"','shipmentType',this)\"    class = 'non_edit' readonly='true'    >";        
        rowData ["shipmentType"]    = sizeCell;

        var sizeCell  = '<select name = ' +namePolStatus + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'polStatus\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].podStatus);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].podStatus[lintCtr].value;
           var lstrOpt= document.forms[0].podStatus[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }

        sizeCell     = sizeCell + '</select>';
        rowData ["polStatus"] = sizeCell;
/*
        var sizeCell  = '<select name = ' +nameLocalContSts + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'localContSts\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].localContSts);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].localContSts[lintCtr].value;
           var lstrOpt= document.forms[0].localContSts[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["localContSts"] = sizeCell;

*/
		var sizeCell =  '<input type="text" value="" name =' +nameLocalContSts + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'localContSts\',this);" style="width:96%" maxlength="10" />';
	    rowData ["localContSts"] = sizeCell;

        var sizeCell  = '<select name = ' +nameMidstream + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'midstream\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].midstream);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].midstream[lintCtr].value;
           var lstrOpt= document.forms[0].midstream[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["midstream"] = sizeCell;

        var sizeCell  = '<select name = ' +nameLoadCondition + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'loadCondition\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].loadCondition);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].loadCondition[lintCtr].value;
           var lstrOpt= document.forms[0].loadCondition[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["loadCondition"] = sizeCell;

        var sizeCell  = '<select name = ' +nameLoadingStatus + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'loadingStatus\',this);" size="1" style="height=20px" style="width:98%"><option value="OS">Over Shipped</option>';
        var lobjCombo = eval(document.forms[0].overshippedLoading);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].overshippedLoading[lintCtr].value;
           var lstrOpt= document.forms[0].overshippedLoading[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["loadingStatus"] = sizeCell;
        
        
        var sizeCell =  '<input type="text" value="" name =' +nameStowPosition + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'stowPosition\',this);" onchange="onChangeStowagePosition('+rowIndex+');" style="width:98%" maxlength="7" />';
        rowData ["stowPosition"] = sizeCell;        

        var sizeCell = '<input type="text" name =' +nameActivityDate + '   onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'activityDate\',this);" maxlength=\'16\' style="width:70%"/>'
                       +'&nbsp;'+' <a href="#" onclick="showCalendarWithTime(\''+nameActivityDate+'\', \'\', \'\', \'1\')">'
                                +' <img src="'+ctxPath1+'/images/btnCalendar.gif" alt="Calender" class="calender">'       
        rowData ["activityDate"] = sizeCell;    

        var sizeCell =  '<input type="text" value="" name =' +nameWeight + ' onblur = "javascript:putMask_Number(this, 12, 2);updateOvershippedStatusFlage('+rowIndex+',\'weight\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\"maxlength="14" />';
        rowData ["weight"] = sizeCell;        
        
        
        var sizeCell  = '<select name = ' + nameDamaged + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'damaged\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].damaged);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].damaged[lintCtr].value;
           var lstrOpt= document.forms[0].damaged[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["damaged"] =   sizeCell;

        var sizeCell =  '<input type="text" value="" name =' +nameVoidSlot + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'voidSlot\',this);" style="width:98%" maxlength="6"  />';
        rowData ["voidSlot"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +namePreAdvice + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'preAdvice\',this);" style="width:98%" maxlength="6" class="non_edit" readonly="true"  />';
        rowData ["preAdvice"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameSlotOperator + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'slotOperator\',this); validateSlotOperatorCode(this, '+rowIndex+');" style="width:75%" maxlength="4" />'
                        +'&nbsp;'+'<input type="button" value=". . ."  name="btnSlotOperatorCodeLookup" class="btnbutton" onclick="openSlotOperatorLookup('+rowIndex+')"/>';
        rowData ["slotOperator"] = sizeCell;        

        var sizeCell =  '<input type="text" value="" name =' +nameContOperator + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'contOperator\',this,false); validateOperatorCode1(this, '+rowIndex+');" style="width:75%" maxlength="4" />'
                        +'&nbsp;'+'<input type="button" value=". . ."  name="btnContOperatorCodeLookup" class="btnbutton" onclick="openContainerOperatorLookup('+rowIndex+')"/>';    
        
        rowData ["contOperator"] = sizeCell;        


        var sizeCell =  '<input type="text" value="" name =' +nameOutSlotOperator + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'outSlotOperator\',this,false); validateOutSlotOperatorCode(this, '+rowIndex+');" style="width:75%" maxlength="4" />'
                        +'&nbsp;'+'<input type="button" value=". . ."  name="btnOutSlotOperatorCodeLookup" class="btnbutton" onclick="openOutSlotOperatorLookup('+rowIndex+')"/>';
        rowData ["outSlotOperator"] = sizeCell;        
        
        var sizeCell  = '<select name = ' +nameSpecialHandling + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'specialHandling\',this); onChangeSpecialHandling('+rowIndex+')"  size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].specialHandling);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].specialHandling[lintCtr].value;
           var lstrOpt= document.forms[0].specialHandling[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["specialHandling"] =   sizeCell;
        
        
        
        var sizeCell =  '<input type="text" value="" name =' +nameSealNo + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'sealNo\',this);" style="width:98%" maxlength="20" />';
        rowData ["sealNo"] = sizeCell;        
        

        var sizeCell =  '<input type="text" value="" name =' +namePod + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'pod\',this,false); validatePortCode1(this);" style="width:75%" maxlength="5" />'
                        +'&nbsp;'+'<input type="button" value=". . ."  name="btnPolLookup" class="btnbutton" onclick="openPodLookup('+rowIndex+')"/>';

        rowData ["pod"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +namePodTerminal + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'podTerminal\',this);validatePortTerminal1(this);" style="width:75%" maxlength="5" />'
                        +'&nbsp;'+'<input type="button" value=". . ."  name="btnPolTerminalLookup" class="btnbutton" onclick="openPodTerminalLookup('+rowIndex+')"/>';        
        rowData ["podTerminal"] = sizeCell;    
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextPOD1 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextPOD1\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["nextPOD1"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextPOD2 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextPOD2\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["nextPOD2"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextPOD3 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextPOD3\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["nextPOD3"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameFinalPOD + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'finalPOD\',this);"  style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["finalPOD"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameFinalDest + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'finalDest\',this);"  style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["finalDest"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextService + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextService\',this);"  style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["nextService"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextVessel + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextVessel\',this);"  style="width:98%" maxlength="25" class="non_edit" readonly="true" />';
        rowData ["nextVessel"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextVoyage + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextVoyage\',this);" style="width:98%" maxlength="10" class="non_edit" readonly="true" />';
        rowData ["nextVoyage"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameNextDirection + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'nextDirection\',this);"  style="width:98%" maxlength="2" class="non_edit" readonly="true" />';
        rowData ["nextDirection"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOVessel + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'connectingMLOVessel\',this);"  style="width:98%" maxlength="35" />';
        rowData ["connectingMLOVessel"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOVoyage + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'connectingMLOVoyage\',this);" style="width:98%" maxlength="10" />';
        rowData ["connectingMLOVoyage"] = sizeCell;        
        
        var sizeCell =      '<input type="text" name =' +nameMloETADate + '   onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'mloETADate\',this);" maxlength=\'16\' style="width:70%"/>'
                            +' <a href="#" onclick="showCalendarWithTime(\''+nameMloETADate+'\', \'\', \'\', \'1\')">'
                                +' <img src="'+ctxPath+'/images/btnCalendar.gif" alt="Calender" class="calender">'
        rowData ["mloETADate"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOPOD1 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'connectingMLOPOD1\',this);" style="width:98%" maxlength="5" />';
        rowData ["connectingMLOPOD1"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOPOD2 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'connectingMLOPOD2\',this);" style="width:98%" maxlength="5" />';
        rowData ["connectingMLOPOD2"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameConnectingMLOPOD3 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'connectingMLOPOD3\',this);" style="width:98%" maxlength="5" />';
        rowData ["connectingMLOPOD3"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +namePlaceOfDel + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'placeOfDel\',this);" style="width:98%" maxlength="5" class="non_edit" readonly="true" />';
        rowData ["placeOfDel"] = sizeCell;        
        
        
        var sizeCell =  '<input type="text" value="" name =' +nameExMLOVessel + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'exMLOVessel\',this);"  style="width:98%" maxlength="35" />';
        rowData ["exMLOVessel"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameExMLOVoyage + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'exMLOVoyage\',this);" style="width:98%" maxlength="10" />';
        rowData ["exMLOVoyage"] = sizeCell;        
        
        var sizeCell =      '<input type="text" name =' +nameExMloETADate + '   onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'exMloETADate\',this);" maxlength=\'16\'  style="width:60%"/>'
                            +' <a href="#" onclick="showCalendarWithTime(\''+nameExMloETADate+'\', \'\', \'\', \'1\')">'
                                +' <img src="'+ctxPath+'/images/btnCalendar.gif" alt="Calender" class="calender">'
        rowData ["exMloETADate"] = sizeCell;            
        
        
        var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstCode1 + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'handlingInstCode1\',this);validateHandInsCode1(this,1,('+rowIndex+'));" style="width:75%" maxlength="3" />'
                       +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup1('+rowIndex+')"/>';            
        rowData ["handlingInstCode1"] = sizeCell;        

        var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstDesc1 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'handlingInstDesc1\',this);" style="width:98%" maxlength="60" class="non_edit" readonly="true" />';
        rowData ["handlingInstDesc1"] = sizeCell;        

        var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstCode2 + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'handlingInstCode2\',this);validateHandInsCode1(this,2,('+rowIndex+'));" style="width:75%" maxlength="3" />'
                       +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup2('+rowIndex+')"/>';            
        rowData ["handlingInstCode2"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstDesc2 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'handlingInstDesc2\',this);" style="width:98%" maxlength="60" class="non_edit" readonly="true"  />';
        rowData ["handlingInstDesc2"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstCode3 + ' onblur = "javascript:changeUpper(this);updateOvershippedStatusFlage('+rowIndex+',\'handlingInstCode3\',this);validateHandInsCode1(this,3,('+rowIndex+'));" style="width:75%" maxlength="3" />'
                       +'&nbsp;'+'<input type="button" value=". . ."  name="btnHandlingInsCodeLookup" class="btnbutton" onclick="openHandlingInsCodeLookup3('+rowIndex+')"/>';            
        rowData ["handlingInstCode3"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameHandlingInstDesc3 + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'handlingInstDesc3\',this);" style="width:98%" maxlength="60" class="non_edit" readonly="true" />';
        rowData ["handlingInstDesc3"] = sizeCell;        
        
        var sizeCell;
             sizeCell='<select name =' + nameContLoadRemark1 + ' size="1" style="width:96%"><option value="">Select One...</option>';
          
            var lobjCombo = eval(document.forms[0].contLoadRemark1);
            for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
               var lstrCellVal= document.forms[0].contLoadRemark1[lintCtr].value;
               var lstrOpt= document.forms[0].contLoadRemark1[lintCtr].text;
               sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
            }
            sizeCell=sizeCell+'</select>';
            rowData ["contLoadRemark1"] = sizeCell;

            var sizeCell;
            sizeCell='<select name =' + nameContLoadRemark2 + ' size="1" style="width:98%"><option value="">Select One...</option>';
            
            var lobjCombo = eval(document.forms[0].contLoadRemark2);
            for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
                var lstrCellVal= document.forms[0].contLoadRemark2[lintCtr].value;
                var lstrOpt= document.forms[0].contLoadRemark2[lintCtr].text;
                sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
            }
            sizeCell=sizeCell+'</select>';
            rowData ["contLoadRemark2"] = sizeCell;

        var sizeCell =  '<input type="text" value="" name =' +nameSpecialCargo + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'specialCargo\',this);" style="width:98%" maxlength="3" class="non_edit" readonly="true" />';
        rowData ["specialCargo"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameImdgClass + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'imdgClass\',this);" style="width:98%" maxlength="4" />';
        rowData ["imdgClass"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameUnNumber + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'unNumber\',this);" style="width:75%" maxlength="6" />'
                       +'&nbsp;'+'<input type="button" value=". . ."  name="btnUNNoLookup" class="btnbutton" onclick="openUNNoLookup('+rowIndex+',3)"/>';            
        rowData ["unNumber"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameUnNumberVariant + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'unNumberVariant\',this);" style="width:98%" maxlength="1" />';
        rowData ["unNumberVariant"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +namePortClass + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'portClass\',this);" style="width:98%" maxlength="5" />';
        rowData ["portClass"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +namePortClassType + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'portClassType\',this);" style="width:98%" maxlength="5" />';
        rowData ["portClassType"] = sizeCell;        
        
        var sizeCell  = '<select name = ' +nameFlashUnit + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'flashUnit\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].flashUnit);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].flashUnit[lintCtr].value;
           var lstrOpt= document.forms[0].flashUnit[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["flashUnit"] =   sizeCell;
           
        
        var sizeCell =  '<input type="text" value="" name =' +nameFlashPoint + ' onblur = "javascript:putMask_Number(this, 3, 3);updateOvershippedStatusFlage('+rowIndex+',\'flashPoint\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="7" />';
        rowData ["flashPoint"] = sizeCell;        

        var sizeCell  = '<select name = ' +nameFumigationOnly + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'fumigationOnly\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].fumigationOnly);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].fumigationOnly[lintCtr].value;
           var lstrOpt= document.forms[0].fumigationOnly[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["fumigationOnly"] =   sizeCell;

        var sizeCell  = '<select name = ' +nameResidue + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'residue\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].residue);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].residue[lintCtr].value;
           var lstrOpt= document.forms[0].residue[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["residue"] =   sizeCell;


        var sizeCell =  '<input type="text" value="" name =' +nameOverheight + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOvershippedStatusFlage('+rowIndex+',\'overheight\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
        rowData ["overheight"] = sizeCell;        

        var sizeCell =  '<input type="text" value="" name =' +nameOverwidthLeft + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOvershippedStatusFlage('+rowIndex+',\'overwidthLeft\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
        rowData ["overwidthLeft"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameOverwidthRight + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOvershippedStatusFlage('+rowIndex+',\'overwidthRight\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
        rowData ["overwidthRight"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameOverlengthFront + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOvershippedStatusFlage('+rowIndex+',\'overlengthFront\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
        rowData ["overlengthFront"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameOverlengthAfter + ' onblur = "javascript:putMask_Number(this, 10, 4);updateOvershippedStatusFlage('+rowIndex+',\'overlengthAfter\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="15" />';
        rowData ["overlengthAfter"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameReeferTemp + ' onblur = "javascript:putMask_Number(this, 3, 3);updateOvershippedStatusFlage('+rowIndex+',\'reeferTemp\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="8" />';
        rowData ["reeferTemp"] = sizeCell;        
        
        var sizeCell  = '<select name = ' +nameReeferTempUnit + ' onchange = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'reeferTempUnit\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
        var lobjCombo = eval(document.forms[0].reeferTempUnit);
        for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
           var lstrCellVal= document.forms[0].reeferTempUnit[lintCtr].value;
           var lstrOpt= document.forms[0].reeferTempUnit[lintCtr].text;
           sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
        }
        sizeCell     = sizeCell + '</select>';
        rowData ["reeferTempUnit"] =   sizeCell;

            
        
        var sizeCell =  '<input type="text" value="" name =' +nameHumidity + ' onblur = "javascript:putMask_Number(this, 3, 2);updateOvershippedStatusFlage('+rowIndex+',\'humidity\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="6" />';
        rowData ["humidity"] = sizeCell;        
        
        var sizeCell =  '<input type="text" value="" name =' +nameVentilation + ' onblur = "javascript:putMask_Number(this, 3, 2);updateOvershippedStatusFlage('+rowIndex+',\'ventilation\',this);" style="width:98%" onclick=\"javascript:hideMask_Number(this);\" maxlength="6" />';
        rowData ["ventilation"] = sizeCell;        

        var sizeCell =  '<input type="text" value="" name =' +nameMergeAction + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'mergeAction\',this);" style="width:98%" maxlength="5" />';
        rowData ["mergeAction"] = sizeCell;            
        
        //var sizeCell =  '<input type="text" value="" name =' +nameError + ' onblur = "javascript:updateOvershippedStatusFlage('+rowIndex+',\'error\',this);" style="width:98%" maxlength="1" class="non_edit" readonly="true" />';
        var sizeCell =    '<input type="button" value=". . ." name="btneErrorMessage" class="btnbutton" disabled = "true" />';        
        rowData ["error"] = sizeCell;        
        

        return rowData;
    }

    function getStatusObject(rowIndex)
    {
        return document.getElementById("overshippedValue["+rowIndex+"].status");
    }

    function getSelectedObject(rowIndex)
    {
        return document.getElementById("overshippedValue["+rowIndex+"].selected");
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
        return document.getElementById("overshippedValue["+rowIndex+"].tempRecordStatus");
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
        var larrSearchCriteria = ["srchOvershippedFind1","srchOvershippedIn1","srchOvershippedFind2","srchOvershippedIn2","srchOvershippedOrder1","srchOvershippedOrder1Ord","srchOvershippedOrder2","srchOvershippedOrder2Ord"];
        return larrSearchCriteria;
    }

    function getSelectedViewId(){
        return document.forms[0].overshippedView.value;
        
    }    

    function validateHandInsCode1(astrHandInCode, hinsCodeNo, arow){
        
        if(astrHandInCode.value!=""){
            var response = validateHandInsCode(astrHandInCode);
        
            if(hinsCodeNo==1){
                if(response=="undefined" || response==null){
                    ERROR_FLAG_HIC1 = EZL_SE038;            
                    showBarMessage(EZL_SE038,ERROR_MSG);
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc1').value = "";                
                    return false;
                }else if(response =="N"){
                    ERROR_FLAG_HIC1 = EZL_SE038;            
                    showBarMessage(EZL_SE038,ERROR_MSG);
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc1').value = "";
                    return false;
                }else{
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc1').value = response;
                    ERROR_FLAG_HIC1 = 'success';                    
                    showBarMessage(ECM_GI0001);
                }    
            }    
            if(hinsCodeNo==2){
                if(response=="undefined" || response==null){
                    ERROR_FLAG_HIC2 = EZL_SE040;
                    showBarMessage(EZL_SE040,ERROR_MSG);
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc2').value = "";                
                    return false;
                }else if(response =="N"){
                    ERROR_FLAG_HIC2 = EZL_SE040;
                    showBarMessage(EZL_SE040,ERROR_MSG);
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc2').value = "";                
                    return false;
                }else{
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc2').value = response;
                    ERROR_FLAG_HIC2 = 'success';                    
                    showBarMessage(ECM_GI0001);
                }    
            }
            if(hinsCodeNo==3){
                if(response=="undefined" || response==null){
                    ERROR_FLAG_HIC3 = EZL_SE041;
                    showBarMessage(EZL_SE041,ERROR_MSG);
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc3').value = "";                
                    return false;
                }else if(response =="N"){
                    ERROR_FLAG_HIC3 = EZL_SE041;            
                    showBarMessage(EZL_SE041,ERROR_MSG);
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc3').value = "";                
                    return false;
                }else{
                    document.getElementById('overshippedValue[' + arow + '].handlingInstDesc3').value = response;
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
        var socCocFlag = document.getElementById('overshippedValue[' + arow + '].socCoc').value;                
        if(OprCode.value == "****"){
            ERROR_FLAG_CONT_OPR = EZL_SE039;
            showBarMessage(EZL_SE039,ERROR_MSG);
            return false;
        }        
        
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

    function validateSlotOperatorCode(slotOprCode, arow){
        var socCocFlag = document.getElementById('overshippedValue[' + arow + '].socCoc').value;                
        if ((socCocFlag == "S") || (socCocFlag == "SOC")) {
			ERROR_FLAG_SLOT_OPR = 'success';	
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
        var socCocFlag = document.getElementById('overshippedValue[' + arow + '].socCoc').value;                
		
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
            lobjControl = document.getElementById('overshippedValue[' + aRowId + '].contOperator');
            lobjControl.value = arrResultData[0];
            ERROR_FLAG_CONT_OPR = 'success';                
            updateOvershippedStatusFlage(aRowId, 'contOperator', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;
        } else if((strMasterId == 'OPERATOR') && (lookupId == 'O')){
            //Setting Out Slot Operator value
            lobjControl  = document.getElementById('overshippedValue[' + aRowId + '].outSlotOperator');
            lobjControl.value = arrResultData[0];
            ERROR_FLAG_OUT_SLOT_OPR = 'success';                
            updateOvershippedStatusFlage(aRowId, 'outSlotOperator', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'OPERATOR') && (lookupId == 'S')){
            //Setting Out Slot Operator value
            lobjControl = document.getElementById('overshippedValue[' + aRowId + '].slotOperator');
            lobjControl.value=arrResultData[0];
            ERROR_FLAG_SLOT_OPR = 'success';                
            updateOvershippedStatusFlage(aRowId, 'slotOperator', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'HIC') && (lookupId == 'HIC1')){
            lobjControl = document.getElementById('overshippedValue[' + aRowId + '].handlingInstCode1');
            lobjControl.value = arrResultData[IDX_HICCD];    
            document.getElementById('overshippedValue[' + aRowId + '].handlingInstDesc1').value
                =arrResultData[IDX_HISDS];
            ERROR_FLAG_HIC1 = 'success';                
            updateOvershippedStatusFlage(aRowId, 'handlingInstCode1', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'HIC') && (lookupId == 'HIC2')){
            lobjControl = document.getElementById('overshippedValue[' + aRowId + '].handlingInstCode2');
            lobjControl.value = arrResultData[IDX_HICCD];    
            document.getElementById('overshippedValue[' + aRowId + '].handlingInstDesc2').value
                =arrResultData[IDX_HISDS];
            ERROR_FLAG_HIC2 = 'success';                
            updateOvershippedStatusFlage(aRowId, 'handlingInstCode2', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'HIC') && (lookupId == 'HIC3')){
            lobjControl = document.getElementById('overshippedValue[' + aRowId + '].handlingInstCode3');
            lobjControl.value =arrResultData[IDX_HICCD];    
            document.getElementById('overshippedValue[' + aRowId + '].handlingInstDesc3').value
                =arrResultData[IDX_HISDS];
            ERROR_FLAG_HIC3 = 'success';                
            updateOvershippedStatusFlage(aRowId, 'handlingInstCode3', lobjControl);        
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'PORT_CLASS')){
            lobjControl        = document.getElementById('overshippedValue[' + aRowId + '].imdgClass');
            lobjControl.value  = arrResultData[IDX_IMDG];
            updateOvershippedStatusFlage(aRowId, 'imdgClass', lobjControl);                
            var lobjControl2   = document.getElementById('overshippedValue[' + aRowId + '].unNumber');
            lobjControl2.value = arrResultData[IDX_UNNO];
            updateOvershippedStatusFlage(aRowId, 'unNumber', lobjControl2);                
            var lobjControl3   = document.getElementById('overshippedValue[' + aRowId + '].unNumberVariant');
            lobjControl3.value = arrResultData[IDX_UNVAR];            
            updateOvershippedStatusFlage(aRowId, 'unNumberVariant', lobjControl3);                
            var lobjControl4   = document.getElementById('overshippedValue[' + aRowId + '].portClass');
            lobjControl4.value = arrResultData[IDX_PORT_CODE];            
            updateOvershippedStatusFlage(aRowId, 'portClass', lobjControl4);                        
            var lobjControl5   = document.getElementById('overshippedValue[' + aRowId + '].portClassType');
            lobjControl5.value = arrResultData[IDX_PORT_TYPE];
            updateOvershippedStatusFlage(aRowId, 'portClassType', lobjControl5);
            var lobjControl6   = document.getElementById('overshippedValue[' + aRowId + '].flashPoint');
            lobjControl6.value = trimString(arrResultData[IDX_FLASH_POINT]);
            updateOvershippedStatusFlage(aRowId, 'flashPoint', lobjControl6);                
            var lobjControl7   = document.getElementById('overshippedValue[' + aRowId + '].flashUnit');
            lobjControl7.value = 'C';
            updateOvershippedStatusFlage(aRowId, 'flashUnit', lobjControl7);                
            
            //ERROR_FLAG = 'success';                
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'EQUIPMENT_TYPE')){
            lobjControl  = document.getElementById('overshippedValue[' + aRowId + '].equipmentType');
            lobjControl.value = arrResultData[0];    
            ERROR_FLAG_EQUIP_TYPE = 'success';                
            updateOvershippedStatusFlage(aRowId, 'equipmentType', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'PORT')){
            lobjControl = document.getElementById('overshippedValue[' + aRowId + '].pod');
            lobjControl.value = arrResultData[0];    
            ERROR_FLAG_PORT_CODE = 'success';                
            updateOvershippedStatusFlage(aRowId, 'pod', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        } else if((strMasterId == 'TERMINAL')){
            lobjControl       = document.getElementById('overshippedValue[' + aRowId + '].podTerminal');
            lobjControl.value = arrResultData[0];    
            ERROR_FLAG_PORT_TERMINAL = 'success';                
            updateOvershippedStatusFlage(aRowId, 'podTerminal', lobjControl);
            showBarMessage(ECM_GI0001);
            return false;            
        }
        return false;
    }

function addRowInFixedTable() {
	/* return if search not performed. */
	
	if(!(document.getElementById("restowSearFlag").value == 'true')) {
		showBarMessage(ECM_SE0007,ERROR_MSG);
		return false;
	}
    document.forms[0].updFlag.value = 'Y';
	var table     = document.getElementById("tableFixedColumns");
	var totalRows = table.rows.length;
	var rowIndex  = table.rows.length;
	
	var nameBookingNo 		= "restowedValue["+rowIndex+"].bookingNo";
	var nameEquipmentNo 	= "restowedValue["+rowIndex+"].equipmentNo";
	var nameDelete          = "restowedValue["+rowIndex+"].selected";        	
	var nameStatus          = "restowedValue["+rowIndex+"].status";    
	var nameRestowedId      = "restowedValue["+rowIndex+"].restowedId";    
	var nameRecordChangeDt  = "restowedValue["+rowIndex+"].recordChangeDt";    
	var nameRestowedSeqNo   = "restowedValue["+rowIndex+"].restowedSeqNo";  	
	
	var row       = table.insertRow(totalRows);
	row.setAttribute("id", "row"+rowIndex);
	row.setAttribute("height", "20px");
	
	var cellDelete = row.insertCell(0);
	cellDelete.setAttribute("width", "20%");	
	cellDelete.className = "first_row center";
	cellDelete.innerHTML = '<td><input type="checkbox" name =' + nameDelete + ' value="ON" class="check">'
                           + '<input type="hidden" name='+nameStatus+' value='+ ADD +'>'
                           + '<input type="hidden" name='+nameRestowedId+' value="">'
                           + '<input type="hidden" name='+nameRecordChangeDt+' value="">'
                           + '<input type="hidden" name='+nameRestowedSeqNo+' value="">' 	
						   + '</td>';  	
	
	var cellBookingNo = row.insertCell(1);
	cellBookingNo.setAttribute("width", "40%");		
	cellBookingNo.innerHTML =   '<td>'
		+ '<input type="text" name =' +nameBookingNo + '  style="width:96%" maxlength="17" class="non_edit" readonly="true" />'
		+  '</td>';
	
	var cellEqupmentNo = row.insertCell(2);
	cellEqupmentNo.setAttribute("width", "40%");		
	cellEqupmentNo.innerHTML =   '<td>'
		+ '<input type="text" name =' +nameEquipmentNo + '  style="width:96%" maxlength="12" />'
		+ '</td>';
	
	return false;
}

function getRecordToAddInGrid(rowIndex)
{
	/* return if search not performed. */
	if(!(document.getElementById("restowSearFlag").value == 'true')) {
		showBarMessage(ECM_SE0007,ERROR_MSG);
		return false;
	}

	var nameSize 			= "restowedValue["+rowIndex+"].size";
	var nameEquipmentType 	= "restowedValue["+rowIndex+"].equipmentType";
	var nameSocCoc 			= "restowedValue["+rowIndex+"].socCoc";
	var nameShipmentTerm 	= "restowedValue["+rowIndex+"].shipmentTerm";
	var nameShipmentType 	= "restowedValue["+rowIndex+"].shipmentType";
	var nameMidstream  		= "restowedValue["+rowIndex+"].midstream ";
	var nameLoadCondition  	= "restowedValue["+rowIndex+"].loadCondition";
	var nameRestowSts 		= "restowedValue["+rowIndex+"].restowSts";
	var nameStowPosition 	= "restowedValue["+rowIndex+"].stowPosition";
	var nameActivityDate    = "restowedValue[" + rowIndex + "].activityDateTime";		
	var nameWeight 			= "restowedValue["+rowIndex+"].weight";
	var nameDamaged 		= "restowedValue["+rowIndex+"].damaged";
	var nameVoidSlot 		= "restowedValue["+rowIndex+"].voidSlot";
	var nameSlotOperator 	= "restowedValue["+rowIndex+"].slotOperator";
	var nameContOperator 	= "restowedValue["+rowIndex+"].contOperator";
	var nameSpecialHandle 	= "restowedValue["+rowIndex+"].specialHandle";
	var nameSealNo 			= "restowedValue["+rowIndex+"].sealNo";
	var nameSpecialCargo 	= "restowedValue["+rowIndex+"].specialCargo";
	var nameRemarks 		= "restowedValue["+rowIndex+"].remarks";

	// Create Data for row to add
	var rowData = {};

		rowData ["size"]    = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].size'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','size',this)\"  maxlength='2' class='non_edit' readonly='true' style='width : 96%' 		>";
		rowData ["equipmentType"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].equipmentType'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','equipmentType',this)\"  maxlength='2' class='non_edit' readonly='true' style='width : 96%' 		>";
		rowData ["socCoc"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].socCoc'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','socCoc',this)\"  maxlength='3' class='non_edit' readonly='true' style='width : 96%' 		>";
		rowData ["shipmentTerm"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].shipmentTerm'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','shipmentTerm',this)\"  maxlength='4' class='non_edit' readonly='true' style='width : 96%' 		>";
		rowData ["shipmentType"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].shipmentType'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','shipmentType',this)\"  maxlength='3' class='non_edit' readonly='true' style='width : 96%' 		>";

		sizeCell  = '<select name = ' +nameMidstream + ' onchange = "javascript:updateRestowedStatusFlage('+rowIndex+',\'midstream\',this);" size="1" style="height=20px" style="width:96%"><option value="">Select One...</option>';
		var lobjCombo = eval(document.forms[0].midstream);
                for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
                   var lstrCellVal= document.forms[0].midstream[lintCtr].value;
                   var lstrOpt= document.forms[0].midstream[lintCtr].text;
                   sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
                }
		rowData ["midstream"] = sizeCell;		
		
		sizeCell  = '<select name = ' +nameLoadCondition + ' onchange = "javascript:updateRestowedStatusFlage('+rowIndex+',\'loadCondition\',this);"  size="1" style="height=20px" style="width:96%"><option value="">Select One...</option>';
		var lobjCombo = eval(document.forms[0].loadCondition);
                for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
                   var lstrCellVal= document.forms[0].loadCondition[lintCtr].value;
                   var lstrOpt= document.forms[0].loadCondition[lintCtr].text;
                   sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
                }
                sizeCell=sizeCell+'</select>';
		rowData ["loadCondition"] = sizeCell;

		sizeCell  = '<select name = ' +nameRestowSts + ' onchange = "javascript:updateRestowedStatusFlage('+rowIndex+',\'restowSts\',this);onChangeRestowStatus('+rowIndex+');" size="1" class="must" style="height=20px" style="width:96%"><option value="">Select One...</option>';
		var lobjCombo = eval(document.forms[0].restowSts);
		for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
		   var lstrCellVal= document.forms[0].restowSts[lintCtr].value;
		   var lstrOpt= document.forms[0].restowSts[lintCtr].text;
		   sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
		}
		sizeCell=sizeCell+'</select>';
		rowData ["restowSts"] = sizeCell;		
		
		rowData ["stowPosition"]  =  "<input type='text'   value=''    name='restowedValue["+rowIndex+"].stowPosition'  onblur=\"onChangeStowagePosition('"+ rowIndex +"');javascript:updateRestowedStatusFlage('"+rowIndex+"','stowPosition',this)\"  maxlength='7' style='width : 96%' 	>"


	   var sizeCell = '<input type="text" name =' +nameActivityDate + '   onblur = "javascript:updateRestowedStatusFlage('+rowIndex+',\'activityDateTime\',this);" maxlength=\'16\'  style="width:70%"/>'
						+' <a href="#" onclick="showCalendarWithTime(\''+nameActivityDate+'\', \'\', \'\', \'1\')">'
                            +' <img src="'+ctxPath1+'/images/btnCalendar.gif" alt="Calender" class="calender">'	   
	   rowData ["activityDateTime"] = sizeCell;
	   
		rowData ["weight"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].weight'  onblur=\"javascript:putMask_Number(this, 12, 2);updateRestowedStatusFlage('"+rowIndex+"','weight',this)\"  class='non_edit' readonly='true' maxlength='15' style='width : 96%' onclick=\"javascript:hideMask_Number(this);\">";
		
		var sizeCell  = '<select name = ' + nameDamaged + ' onchange = "javascript:updateRestowedStatusFlage('+rowIndex+',\'damaged\',this);" size="1" style="height=20px" style="width:98%"><option value="">Select One...</option>';
		var lobjCombo = eval(document.forms[0].damaged);
		for(lintCtr=1;lintCtr<lobjCombo.length;lintCtr++) {
		   var lstrCellVal= document.forms[0].damaged[lintCtr].value;
		   var lstrOpt= document.forms[0].damaged[lintCtr].text;
		   sizeCell = sizeCell +'<option value="'+lstrCellVal+'">'+lstrOpt+'</option>';
		}
		sizeCell=sizeCell+'</select>';
			rowData ["damaged"] =   sizeCell;		
		
		rowData ["voidSlot"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].voidSlot'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','voidSlot',this)\"  class='non_edit' readonly='true' maxlength='6' style='width : 96%' 	>";
		
		rowData ["slotOperator"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].slotOperator'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','slotOperator',this)\" class='non_edit' readonly='true' maxlength='4' style='width : 96%' 	>";
		
		rowData ["contOperator"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].contOperator'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','contOperator',this)\" class='non_edit' readonly='true' maxlength='4' style='width : 96%' 	>";
		
		rowData ["specialHandle"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].specialHandle'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','specialHandle',this)\" class='non_edit' readonly='true' maxlength='3' style='width : 96%' 	>";
		
		rowData ["sealNo"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].sealNo'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','sealNo',this)\" maxlength='20' style='width : 96%' 	>";
		
		rowData ["specialCargo"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].specialCargo'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','specialCargo',this)\" class='non_edit' readonly='true' maxlength='3' style='width : 96%' 	>";
		
		rowData ["remarks"] = "<input type='text'   value=''    name='restowedValue["+rowIndex+"].remarks'  onblur=\"javascript:updateRestowedStatusFlage('"+rowIndex+"','remarks',this)\" maxlength='2000' style='width : 96%' 	>";

	return rowData;
}

function getStatusObject(rowIndex)
{
	return document.getElementById("restowedValue["+rowIndex+"].status");
}

function getSelectedObject(rowIndex)
{
	return document.getElementById("restowedValue["+rowIndex+"].selected");
}

function getTempRecordStatusObject(rowIndex)
{
	return document.getElementById("restowedValue["+rowIndex+"].tempRecordStatus");
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
    var larrSearchCriteria = ["srchRestowedFind1","srchRestowedIn1","srchRestowedFind2","srchRestowedIn2","srchRestowedOrder1","srchRestowedOrder1Ord","srchRestowedOrder2","srchRestowedOrder2Ord"];
    return larrSearchCriteria;
}
function getSelectedViewId(){
	return document.forms[0].restowedView.value;
	
}	

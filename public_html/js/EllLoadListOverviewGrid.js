function addRowInFixedTable() {

	var table     = document.getElementById("tableFixedColumns");
	var totalRows = table.rows.length;
	var rowIndex  = table.rows.length;
	
	var row       = table.insertRow(totalRows);
	row.setAttribute("id", "row"+rowIndex);
	row.setAttribute("height", "25px");
	
	var cell1         = row.insertCell(0);
	cell1.innerHTML   = "<td><input type='hidden' value='ADD' name='employeeVOValue["+rowIndex+"].status' ></td>";
	
	var cell2       = row.insertCell(1);
	cell2.innerHTML = "<td><input type='checkbox' value='' name='employeeVOValue["+rowIndex+"].selected' ></td>";

	var cell3       = row.insertCell(2);
	cell3.innerHTML = "<td><input type='text' value='' name='employeeVOValue["+rowIndex+"].id' ></td>";
	
	return false;
}

function getRecordToAddInGrid(rowIndex)
{
	// Create Data for row to add
	var rowData = {};

	rowData ["name"]      = "<input type='text'   value=''    name='employeeVOValue["+rowIndex+"].name'    style='width : 100%' onblur=\"javascript:updateCellBodyContent('"+rowIndex+"','name',this,false)\"		>";
	rowData ["dept"]      = "<input type='text'   value=''    name='employeeVOValue["+rowIndex+"].dept'    style='width : 100%' onblur=\"javascript:updateCellBodyContent('"+rowIndex+"','dept',this,false)\"		>";
	rowData ["project"]   = "<input type='text'   value=''    name='employeeVOValue["+rowIndex+"].project' style='width : 100%' onblur=\"javascript:updateCellBodyContent('"+rowIndex+"','project',this,false)\"	>";

	return rowData;
}

function getStatusObject(rowIndex)
{
	return document.getElementById("employeeVOValue["+rowIndex+"].status");
}

function getSelectedObject(rowIndex)
{
	return document.getElementById("employeeVOValue["+rowIndex+"].selected");
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
   var flag = document.getElementById('value[' + aintRowIndex + '].flag').value;
    var viewBtn  =	document.getElementById("viewDiv");
    var editBtn  = document.getElementById("editDiv");
    if(flag=="V") {
        viewBtn.style.display = '';
        editBtn.style.display = 'none';
    } else if(flag == "E") {
        viewBtn.style.display = 'none';
        editBtn.style.display = '';
    }
    

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
    
    var larrSearchCriteria = ["serviceGroup","serviceCd","port","terminal","fsc","vessel","outVoyage","fromEta","toEta","fromAta","toAta","loadlistStatus","sortBy","sortIn"];
    return larrSearchCriteria;
}

function getDefaultPositionControlId() 
{
    
var larrDefaultPositionControlId = [	
                                        "serviceGroup"			,
                                        "serviceCd"				,
                                        "vessel"				,
                                        "outVoyage"				,
                                        "direction"				,
                                        "sequence"				,
                                        "port"					,
                                        "terminal"				,
                                        "bargeName"				,
                                        "bargeVoyage"			,
                                        "fromEta"				,
                                        "toEta"					,
                                        "fromAta"				,
                                        "toAta"					,
                                        "loadlistStatus"	,
                                        "bookedNo"				,
                                        "loadedNo"			,
                                        "robNo"					,
                                        "overld"				,
                                        "shortld"				,
                                        "issues"
					];
    return larrDefaultPositionControlId;
}
function getSelectedViewId() 
{
    var viewId = document.getElementById("view").value ;
    return viewId;
}

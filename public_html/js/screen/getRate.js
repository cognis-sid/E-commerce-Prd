var g_currency;
var g_markupRate=5;
//var user_id="CONGIS01"
//var user_id="DEV_TEAM"
var containerSizeCreated=1;
var g_routingListResponse;
var g_dndResponse;
var g_getRate;
var isDNDLoaded=false;
var g_MaxRate;
var g_GroupingData={
		"20":[],
		"40":[],
		"45":[]
};
// This to conver any currency to USD

function calculateMarkupRate(rate){
	//chargeAmount
	
	var rateL=rate["rate"];
	var finalRate=rateL;//+(rateL*g_markupRate/100);
	var currencyRate=g_currency[rate["guidelineCurrency"]];
	if(currencyRate){
		finalRate=finalRate/currencyRate;
		//finalRate= finalRate.toFixed(2);
	}	
	return finalRate;
}

function addContainer(){
	containerSizeCreated++;
	if(containerSizeCreated==3){
		 
		swal("Message", addedmaxContainer_Message , "info");
		return ;
	}
	var containerHTML='<div class="form-row">'+
       ' <div class="form-group col-md-6">'+
			   ' <label for="inputContainerSize">'+containerSize_Message+' <span class="mandatory">*</span></label>'+
			    '<select id="inputContainerSize'+containerSizeCreated+'" name="containerSize" class="form-control">'+
			      
			      '<option value="20 GP">'+Get_Rate_GP_Message+'</option>'+
			      
			     ' <option value="40 HC">'+Get_Rate_HC_Message+'</option>'+
			    '</select>'+
			  '</div>'+
			  '<div class="form-group col-md-6">'+
			   ' <label for="inputExpectedVolume">'+expectedVolume_Message+' <span class="mandatory">&nbsp;</span></label>'+
			    '<input type="number" maxlength=3 onkeypress="return onKeyPressNumber(event)" class="form-control" name="expectedVolume" id="inputExpectedVolume'+containerSizeCreated+'"'+
			     ' placeholder="Enter the Volume">'+
			  '</div>'+
	  '</div>';
	//containerSizeCreated++;
	$("#containerSizeDiv").append(containerHTML);
}

function onKeyPressNumber(evt){
	 var charCode = (evt.which) ? evt.which : evt.keyCode;
     if (charCode != 46 && charCode > 31 
       && (charCode < 48 || charCode > 57))
        return false;

     return true
}

function getContainer(){
	var containerDtl=[]
	for(var i=1;i<=containerSizeCreated;i++){
		var equipmentType=$("#inputContainerSize"+i).val();
		 		 		
		containerDtl.push({equipmentSize:equipmentType.split(" ")[0],"equipmentType":equipmentType.split(" ")[1]});		
	}
	return containerDtl;
}

// This is used to get Routing and call the DND
function showMoreDetail(id){
	 $("#freeDays1").toggle();
	var pod =document.getElementsByName("pod")[0].value;
	var pol =document.getElementsByName("pol")[0].value;
	// this is getting routing 
	var playload={
			  "userId": user_id,
			  "sessionId": tokenNumber,
			  "limitRow": 1,
			  "pol": document.getElementsByName("pol")[0].value,			   
			  "pod": document.getElementsByName("pod")[0].value,	
			  "fromTerminal":"",
			  "toTerminal":"",	
			  "shipmentEtd": fomatDateYYMMDD($("#loadingFrom").val()),
			  "flag1ts": "Y"
			}
	//payload of dnd
	
	var containerDtl=getContainer();
	 
	var dndPayload={
			"userData": {
				"userToken": tokenNumber,
				"userId": user_id,
				"line": line,
			    "trade": trade,
			    "agent": agent,
			    "fscCode": fscCode,
			    "country": countryCode
				},
				"expiryDate": ($("#loadingTo").val()),
				"pod":  document.getElementsByName("pod")[0].value,				
				"del":  document.getElementsByName("pod")[0].value,
				"por": document.getElementsByName("pol")[0].value,
				"pol": document.getElementsByName("pol")[0].value,							
				"socCoc": "C",
				"effectiveDate": ($("#loadingFrom").val()),
				"equipmentDtl":  containerDtl,
				"shipmentEtd":($("#loadingFrom").val())					 
				};
	if(isDNDLoaded==false){
		loading(false);	
		$.ajax({
			method: "POST",
			url: '/DCSWebService/rclws/getPlc',
			data: JSON.stringify(playload),
			contentType: "application/json;",
			traditional: true,
			dataType: 'json',
			success: function (routingListResponse) {
				loading(true);	
				if(routingListResponse.item.routingList.length){
					
					var row = routingListResponse.item.routingList[0];
					debugger;
					var etd=moment(row.etd,'DD/MM/YYYY').toDate()
					var toDateCheck=moment($("#loadingTo").val(),'DD/MM/YYYY').toDate()
					if(toDateCheck<etd){
						swal("Message", there_no_vessel_contact_agency_msg, "info");
						return;
					}
					
					dndPayload["routing"]=routingListResponse.item.routingList;
					
					g_routingListResponse=routingListResponse;
					for(var i=0;i<routingListResponse.item.routingList.length;i++){
						var routingTabs=routingListResponse.item.routingList[i];
						routingTabs["fromLoc"]=routingTabs["fromLocation"];
						routingTabs["toLoc"]=routingTabs["toLocation"];
						 
					}

					getDND(dndPayload);
					
				}else{
					swal("Message", no_routing_found_msg +""+pol+""+ to +""+ pod , "info");
				}
				
			},
			error: function (error, textStatus, jqXHR) {
				errorMessage();
			}
		});
		
	}
	$("#moreDetail"+id).toggle();
}

function formatDateYYMMDD(date){
	var newDateArray= date.split("/");
	return newDateArray[2]+newDateArray[1]+newDateArray[0];	
}

function getMasterFreeDays(data){
	
	if(data.length==0){
		return "NA";
	}else{
		return data[0]["masterFreeDays"];
	}
}

function getDND(payLoad,id){
	loading(false);	
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/dndPath',
		data: JSON.stringify(payLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (routingListResponse) {
			loading(true);	
			debugger;
			if(routingListResponse.resultStatus=="F"){
				swal("Message",routingListResponse.resultMessage, "error");
				$("#submitContainer").hide()
				return 
			}
			isDNDLoaded=true;
			$("#submitContainer").show()
			 var dndResponse=routingListResponse.resultContent;
			 g_dndResponse=routingListResponse;
			var freeDaysHTML='    <div class="row">'+
            ' <!-- loop start -->'+                
           '     <div class="col-md-12">'+
            '      <p><strong>'+freeDaysPerContainer_Message+'</strong></p>'+
             '     <table class="table table-sm borderless">'+
              '      <tbody>';
			if(dndResponse.exportDemurrageDetails && dndResponse.exportDemurrageDetails["pointPort"] ){
			freeDaysHTML+=   '       <tr>'+
                '        <td scope="row" width="100px;">'+
                 '         '+dndResponse.exportDemurrageDetails["pointPort"]+
                  '      </td>'+
                   '     <td  width="200px;">'+exportDemurrage_Message+' </td>'+
                    '    <td> '+getMasterFreeDays(dndResponse.charges_M)+' </td>'+
                     '<td></td><td></td> </tr>';
			}
			if(dndResponse.exportDetentionDetails && dndResponse.exportDetentionDetails["pointPort"]){
				freeDaysHTML+=   '       <tr>'+
	                '        <td scope="row" width="100px;">'+
	                 '         '+dndResponse.exportDetentionDetails["pointPort"]+
	                  '      </td>'+
	                   '     <td width="200px;" >'+exportDetention_Message+'</td>'+
	                    '    <td> '+getMasterFreeDays(dndResponse.charges_D)+' </td>'+
	                     '<td></td><td></td> </tr>';
				} 
			
			if(dndResponse.importDemurrageDetails && dndResponse.importDemurrageDetails["pointPort"]){
				freeDaysHTML+=   '       <tr>'+
	                '        <td scope="row" width="100px;">'+
	                 '         '+dndResponse.importDemurrageDetails["pointPort"]+
	                  '      </td>'+
	                   '     <td  width="200px;">'+importDemurrage_Message+' </td>'+
	                    '    <td> '+getMasterFreeDays(dndResponse.charges_E )+' </td>'+
	                     '<td></td><td></td> </tr>';
				} 
			
			if(dndResponse.importDetentionDetails && dndResponse.importDetentionDetails["pointPort"]){
				freeDaysHTML+=   '       <tr>'+
	                '        <td scope="row" width="100px;">'+
	                 '         '+dndResponse.importDetentionDetails["pointPort"]+
	                  '      </td>'+
	                   '     <td  width="200px;">	'+importDetention_Message+'</td>'+
	                    '    <td> '+getMasterFreeDays(dndResponse.charges_I )+' </td>'+
	                     '<td></td><td></td> </tr>';
				} 
			freeDaysHTML+=' </tbody>'+
                 ' </table>'+
               ' </div>'+

              '</div>';
             $("#freeDays1").html(freeDaysHTML);
             
             
			//http://localhost:8080/DCSWebService/rclws/dndPath
			
		},
		error: function (error, textStatus, jqXHR) {
			errorMessage();
		}
	});
}

function genrateQuatationRef(){
	var pol=document.getElementsByName("pol")[0].value;	
	var playLoad={"pol":pol}
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/saveService/genrateQuatationRef',
		data: JSON.stringify(playLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (response) {
			loading(true);	
			$("#quotationRef").val(response.eQtnRefNo);
			SaveRate(response.eQtnRefNo);
		},		
		error: function (error, textStatus, jqXHR) {
			errorMessage();
		}
	});
	
}
function SaveRate(eQtnRefNo){	
	var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	var pod=document.getElementsByName("pod")[0].value;
	var pol=document.getElementsByName("pol")[0].value;
	var shipmentTerm=document.getElementsByName("shipmentTerm")[0].value;
	var cargoType= $("#inputCargoType").val();
	var d= new Date();
	
	var containerDtlSave=[]
	for(var i=1;i<=containerSizeCreated;i++){
		var equipmentType=$("#inputContainerSize"+i).val();
		var fullQty=1;
		var teus=1;
		if($("#inputExpectedVolume"+i).val()!=""){
			fullQty=$("#inputExpectedVolume"+i).val();
			
		}
		teus=fullQty;
		if(equipmentType.split(" ")[0]==40){
			teus=teus*2
		}
		containerDtlSave.push({"containerSeqNo":i,"size":equipmentType.split(" ")[0],"type":equipmentType.split(" ")[1],"fullQty":fullQty,"teus":teus});		
	}
	for(var i=0;i<g_routingListResponse.item.routingList.length;i++){
		var routingTabs=g_routingListResponse.item.routingList[i];
		routingTabs["fromLoc"]=routingTabs["fromLocation"];
		routingTabs["toLoc"]=routingTabs["toLocation"];
		routingTabs["voyageSeqNo"]=i+1;
		 
	}
	var routingTabs =g_routingListResponse.item.routingList
	
	var currentDate=  new Date();
	var getMonths=(currentDate.getMonth()+1).toString().length==1?"0"+(currentDate.getMonth()+1):(currentDate.getMonth()+1);
	var currentDateString = currentDate.getFullYear()+""+getMonths+""+( (currentDate.getDate().toString().length)==1?"0"+currentDate.getDate():currentDate.getDate());
	currentDate.setDate(currentDate.getDate()+30);
	var getMonths=(currentDate.getMonth()+1).toString().length==1?"0"+(currentDate.getMonth()+1):(currentDate.getMonth()+1);
	var follDate = currentDate.getFullYear()+""+getMonths+""+( (currentDate.getDate().toString().length)==1?"0"+currentDate.getDate():currentDate.getDate());
	
	var currentDate=  new Date();	
	currentDate.setDate(currentDate.getDate()+1);
	var getMonths=(currentDate.getMonth()+1).toString().length==1?"0"+(currentDate.getMonth()+1):(currentDate.getMonth()+1);
	var repDate=currentDate.getFullYear()+""+getMonths+""+( (currentDate.getDate().toString().length)==1?"0"+currentDate.getDate():currentDate.getDate());
	debugger;
	for(var i=0;i<g_getRate.resultContent.length;i++){
		var obj= g_getRate.resultContent[i];
	 if(obj["freightOrSurchageFlag"]=="F" ){
		  obj["rate"]=""+(getOceanFreight(obj["equipmentSize"]+" "+obj["equipmentType"]))+"";
	  }
	}
	var playLoad ={
			 "userData": {
				    "userToken": tokenNumber,
				    "userId": user_id,
				    "line": line,
				    "trade": trade,
				    "agent": agent,
				    "fscCode": fscCode,
				    "country": countryCode
				  },
		  maintenanceTab:{			  
			  "quotationHeader": {			      
			      "qtdBy": user_id,	
			      userToken:tokenNumber,
			      "contactPartyCode": orgCode,
			      "contactPartyName": companyName,
			      "ref": eQtnRefNo,
			      "custContact": orgCode,
			      "opCode": "",
			      "custType": "S",
			      "inqDateTime": "",
			      "effDate": currentDateString,
			      "expDate": expiryDate,
			      "repDate": repDate,
			      "follDate": expiryDate,			       
			      "qtnType": "CIF",
			      "rateExpDate": expiryDate,
			      "eQtnRefNo":eQtnRefNo
			  },
			  "shipmentCorridor": [
				  {		       
		        "shipmentType": "FCL",
		        "weight": "0.00",
		        "measurement": "0.0000",
		        "teu": "",
		        "rorArea": "0.0000",
		        "term": shipmentTerm,
		        "socCoc": "C",
		        "pm": "M",
		        "shipDate": currentDateString,		        
		        "por": pol,
		        "pol": pol,
		        "pod": pod,
		        "del": pod		        
		        }
		    ]
	},	
	
	containerAndCommodityTab:{
		container:containerDtlSave,
		 
	},
	routingTab:routingTabs,
	chargeTab:g_getRate.resultContent,
	"detentionDemurrageTab":
				{ 
					  
				}			  
	};
	
	if(g_dndResponse.resultContent.additionalFreeDays_M.length){
		playLoad.detentionDemurrageTab["additionalFreeDays_M"]=g_dndResponse.resultContent.additionalFreeDays_M;
	}
	
	if(g_dndResponse.resultContent.charges_M.length){
		playLoad.detentionDemurrageTab["charges_M"]=g_dndResponse.resultContent.charges_M;
	}
	
	if(g_dndResponse.resultContent.charges_I.length){
		playLoad.detentionDemurrageTab["charges_I"]=g_dndResponse.resultContent.charges_I;
	}
	
	if(g_dndResponse.resultContent.additionalFreeDays_I.length){
		playLoad.detentionDemurrageTab["additionalFreeDays_I"]=g_dndResponse.resultContent.additionalFreeDays_I;
	}
	
	if(g_dndResponse.resultContent.charges_E.length){
		playLoad.detentionDemurrageTab["charges_E"]=g_dndResponse.resultContent.charges_E;
	}
	if(g_dndResponse.resultContent.additionalFreeDays_E.length){
		playLoad.detentionDemurrageTab["additionalFreeDays_E"]=g_dndResponse.resultContent.additionalFreeDays_E;
	}
	
	if(g_dndResponse.resultContent.charges_D.length){
		playLoad.detentionDemurrageTab["charges_D"]=g_dndResponse.resultContent.charges_D;
	}
	
	if(g_dndResponse.resultContent.additionalFreeDays_D.length){
		playLoad.detentionDemurrageTab["additionalFreeDays_D"]=g_dndResponse.resultContent.additionalFreeDays_D;
	}
	
	
	if(g_routingListResponse.item.routingList.length==2){
		playLoad.maintenanceTab.shipmentCorridor[0].pot1=g_routingListResponse.item.routingList[0].toLoc;
	}
	
	
	if(g_dndResponse.resultContent.importDemurrageDetails && g_dndResponse.resultContent.importDemurrageDetails["modeOfTransport"]){
		playLoad.detentionDemurrageTab["importDemurrageDetails"]=g_dndResponse.resultContent.importDemurrageDetails;
		playLoad.detentionDemurrageTab["importDemurrageDetails"]["action"]="i";
	}	
	
	if(g_dndResponse.resultContent.importDetentionDetails && g_dndResponse.resultContent.importDetentionDetails["area"] ){
		playLoad.detentionDemurrageTab["importDetentionDetails"]=g_dndResponse.resultContent.importDetentionDetails;
		playLoad.detentionDemurrageTab["importDetentionDetails"]["action"]="i";
	}
	
	if(g_dndResponse.resultContent.exportDetentionDetails && g_dndResponse.resultContent.exportDetentionDetails["area"]){
		playLoad.detentionDemurrageTab["exportDetentionDetails"]=g_dndResponse.resultContent.exportDetentionDetails;
		playLoad.detentionDemurrageTab["exportDetentionDetails"]["action"]="i";
	}
	
	
	if(g_dndResponse.resultContent.exportDemurrageDetails && g_dndResponse.resultContent.exportDemurrageDetails["area"] ){
		playLoad.detentionDemurrageTab["exportDemurrageDetails"]=g_dndResponse.resultContent.exportDemurrageDetails;
		playLoad.detentionDemurrageTab["exportDemurrageDetails"]["action"]="i";
	}
	
		
	loading(false);	
	
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/saveService',
		data: JSON.stringify(playLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (response) {
			loading(true);	
			var msg=response["quotationNo"]?"Quotation No "+response["quotationNo"]:"";
			
			if(response["quotationNo"])
				$("#quotationNo").val(response["quotationNo"]);
			if(response["resultStatus"]=="S" || response["resultStatus"]=="W"){
				swal("Message", "Process Successfully." , "info");
				sendMail();
			}else{
				swal("Message", contact_local_agency_msg , "error");
			}
		},		
		error: function (error, textStatus, jqXHR) {
			errorMessage();
		}
	});
}

function fomatDateYYMMDD(date){
	return date.substring(10,6)+date.substring(3,5)+date.substring(0,2);
}
var g_freightOrSurchargeCodes={}
function getFreightOrSurchargeCodes(arrays){
	loading(false);	
	var pod=document.getElementsByName("pod")[0].value;
	var pol=document.getElementsByName("pol")[0].value;
	var shipmentTerm=document.getElementsByName("shipmentTerm")[0].value;
	var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	var rateHeaders=[];
	var allreadyAddedContainer={};
	for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){         	  
    	 var container =$("#inputContainerSize"+contIndex).val();	
    	 
    	 if(allreadyAddedContainer[container]){
    		 swal("Message", duplicate_container_msg +""+container , "info");
    		 return;
    	 }
    	 if(parseInt($("#inputExpectedVolume"+contIndex).val())==0){
    		 swal("Message", container_of_msg +""+container+""+ expected_volume_zero_msg, "info");
    		 return;
    	 }
    	 allreadyAddedContainer[container]=container;
    	 
    	 rateHeaders.push({
				"pod":pod,
				"pol":pol,
				"containerSize":container.split(" ")[0],
				"eqType":container.split(" ")[1],
				"shipmentTerm":shipmentTerm,
				"effectiveDate":effectiveDate,
				"expiryDate":expiryDate,
				"maxRate":maxRateHeader[container].maxRate
		});
	}	 
    var payLoad= {"rateHeaders":rateHeaders}
    	
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/commonService/getFreightOrSurchargeCodes',
		data: JSON.stringify(payLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (surchargeCodesResponse) {
			//g_MaxRate
			loading(true);
			g_freightOrSurchargeCodes=surchargeCodesResponse.freightOrSurchargeCodes;
			
			for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){         	  
	          	 var container =$("#inputContainerSize"+contIndex).val();
	          	 if(!maxRateHeader[container]){
	          		$("#searchResult").html("");
	          		swal("Message", there_no_schedule_contact_agency_msg , "info");
	          		 return ;
	          	 }
			}
			draSearch(g_getRate);
			showMoreDetail();
			$("#freeDays1").toggle();
			
		},		
		error: function (error, textStatus, jqXHR) {
			errorMessage();
		}
	});
	
}

function getOceanFreight(containerSize){	
	  var data = g_getRate.resultContent;	 
	 var sumOfRate=0;
	 var isOcenRateFound=false;
	 for(var i=0;i<data.length;i++){
		 if(data[i]["freightOrSurchageFlag"]!="F"){
			 if(g_freightOrSurchargeCodes[containerSize].indexOf(data[i]["freightOrSurchargeCode"])!=-1){
				 
				 //console.log(data[i]["shortDescription"]+"  "+data[i]["freightOrSurchargeCode"]+" code",parseFloat(calculateMarkupRate(data[i])));
				 if(data[i]["equipmentSize"]==0 || (data[i]["equipmentSize"] ==containerSize.split(" ")[0] && data[i]["equipmentType"] ==containerSize.split(" ")[1]  )){
					 sumOfRate+=parseFloat(calculateMarkupRate(data[i])); 
				 }
			 }			 
		 }else{
			 isOcenRateFound=true;
		 }
	 }
	
	//var ocenFlight = maxRateHeader[containerSize].maxRate - sumOfRate;
	var ocenFlight = maxRateHeader[containerSize].maxRate ;
	if(ocenFlight<0){
		 $("#searchResult").html("");
		swal("Message", contact_local_agency_msg , "error");
		return ;
	}
	ocenFlight=ocenFlight+(ocenFlight*g_markupRate/100);
	 
	 if(isOcenRateFound==false){
			var row =g_getRate.resultContent[0];
			row["equipmentSize"]=containerSize.split(" ")[0];
			row["equipmentType"]=containerSize.split(" ")[1];
			if(containerSize.split(" ")[0]=="20"){
				row["freightOrSurchargeCode"]="001F1";
				row["shortDescription"]= "O/F CYCY FCL20";			
			}else{
				row["freightOrSurchargeCode"]="001F2";
				row["shortDescription"]= "O/F CYCY FCL40";	
			}
			row[ "flagMandatoryRPB"]="N";
			row["freightOrSurchageFlag"]= "F";
			row["rate"]=getRoundOf(ocenFlight);
			row["currency"] ="USD";
			row["guidelineCurrency"] ="USD";
			row["seqNo"]=Math.round(Math.random()*100000)
			g_getRate.resultContent.push(row)
	 }
	return maxRateHeader[containerSize].maxRate;	
}

var maxRateHeader={"20":0,
				"40":0,
				"45":0};

function getRateHeaderModel(){
	
	var pod=document.getElementsByName("pod")[0].value;
	var pol=document.getElementsByName("pol")[0].value;
	var shipmentTerm=document.getElementsByName("shipmentTerm")[0].value;
	var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	var rateHeaders=[];
	var allreadyAddedContainer={};
	for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){         	  
    	 var container =$("#inputContainerSize"+contIndex).val();	
    	 
    	 if(allreadyAddedContainer[container]){
    		 swal("Message", duplicate_container_same_size_msg +""+container , "info");
    		 return;
    	 }
    	 if(parseInt($("#inputExpectedVolume"+contIndex).val())==0){
    		  swal("Message", container_of_msg +""+container+""+ expected_volume_zero_msg, "info");
    		 return;
    	 }
    	 allreadyAddedContainer[container]=container;
    	 
    	 rateHeaders.push({
				"pod":pod,
				"pol":pol,
				"containerSize":container.split(" ")[0],
				"eqType":container.split(" ")[1],
				"shipmentTerm":shipmentTerm,
				"effectiveDate":effectiveDate,
				"expiryDate":expiryDate
		});
    	 
    	var payLoad= {"rateHeaders":rateHeaders}
	}
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/commonService/getMaxRate',
		data: JSON.stringify(payLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (maxRateHeaderResponse) {
			//g_MaxRate
			maxRateHeader =maxRateHeaderResponse;
			for(var key in maxRateHeaderResponse){
				g_markupRate =maxRateHeaderResponse[key].markupRate;			
				if(!maxRateHeaderResponse[key].maxRate){
					swal("Message", there_no_rate_found_msg +" "+key+" ,"+ contact_local_agency_msg, "info");
					return;
				}
			}
			onGetRate();
		},		
		error: function (error, textStatus, jqXHR) {
			errorMessage();
		}
	});
}




function getPerDayLimit(){
	
	var pod=document.getElementsByName("pod")[0].value;
	var pol=document.getElementsByName("pol")[0].value;
	  
	 var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	 
	if(pol==""){
		swal("Message", enter_Port_Landing_msg , "info");
		return ;
	}
	if(pod==""){
		swal("Message", enter_Port_Discharge_msg , "info");
		return ;
	}
	
	if(effectiveDate==""){
		swal("Message", expected_Loading_Period_From_msg , "info");
		return ;
	}
	if(expiryDate==""){
		swal("Message", expected_Loading_Period_To_msg , "info");
		return ;
	}
	
	var payLoad= {"userId":user_id_login}
		
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/commonService/getPerdayLimit',
		data: JSON.stringify(payLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (perDayLimitResponse) {
			loading(true);
			 if(perDayLimitResponse.hasLimit==false){
				 swal("Message", limit_rate_inquiry_contact_admin_msg , "info");
				 $("#searchResult").html("");
				 return ;
			 }
			 getRateHeaderModel();
		},		
		error: function (error, textStatus, jqXHR) {
				
			errorMessage();
		}
	});
}


function validatePolPod(){
	
	var pod=document.getElementsByName("pod")[0].value;
	var pol=document.getElementsByName("pol")[0].value;
	  
	 var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	 
	if(pol==""){
		swal("Message", enter_Port_Landing_msg , "info");
		return ;
	}
	if(pod==""){
		swal("Message", enter_Port_Discharge_msg , "info");
		return ;
	}
	
	if(effectiveDate==""){
		swal("Message", expected_Loading_Period_From_msg , "info");
		return ;
	}
	if(expiryDate==""){
		swal("Message", expected_Loading_Period_To_msg , "info");
		return ;
	}
	
	var payLoad= {"userId":user_id_login,"pod":pod,"pol":pol,"effectiveDate":effectiveDate,"expiryDate":expiryDate}
		
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/commonService/validatePolPod',
		data: JSON.stringify(payLoad),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (perDayLimitResponse) {
			loading(true);
			 if(perDayLimitResponse.sucess==false){
				 swal("Message", "please contact our local agency" , "info");
				 $("#searchResult").html("");
				 return ;
			 }
			 getPerDayLimit();
		},		
		error: function (error, textStatus, jqXHR) {
				
			errorMessage();
		}
	});
}


function errorMessage(){
	loading(true);
	swal("Message", contact_local_agency_msg , "error");
}

function onGetRate(){		
		isDNDLoaded=false;	
		var pod=document.getElementsByName("pod")[0].value;
		var pol=document.getElementsByName("pol")[0].value;
		var shipmentTerm=document.getElementsByName("shipmentTerm")[0].value;
		var cargoType= $("#inputCargoType").val();
		var containerSize=document.getElementsByName("containerSize")[0].value;
		var expectedVolume=document.getElementsByName("expectedVolume")[0].value;
		var commodity=document.getElementsByName("commodity")[0].value;
		var expectedLoadingPeriodFrom=$("#loadingFrom").val(); 	 
		var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
		var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
		debugger;
		var expectedVolume=0;
		       
		
		g_GroupingData={};
		
		loading(false);	
		var containerDtl=[]
		for(var i=1;i<=containerSizeCreated;i++){
			var equipmentType=$("#inputContainerSize"+i).val()
			
			if($("#inputExpectedVolume"+i).val()!=""){
				expectedVolume+=parseInt($("#inputExpectedVolume"+i).val());
			}
			containerDtl.push({equipmentSize:equipmentType.split(" ")[0],"equipmentType":equipmentType.split(" ")[1]});
			
		} 
		
		var playload ={
		     
		    "quotationData": {
		        "userData": {
		            "userToken": tokenNumber,
		            "userId": user_id,
		            "line": line,
		            "trade": trade,
		            "agent":agent,
		            "fscCode": fscCode,
		            "country": countryCode
		        },
		        "qtnData": {
		            "quotationNo": "R070016",
		            pod:pod,
					del:pod,
					pol:pol,
					por:pol,
					shipmentTerm:shipmentTerm,
					cargoType:cargoType,
					containerSize:containerSize,
					expectedVolume:expectedVolume,
					commodity:commodity,
					expectedLoadingPeriodFrom:expectedLoadingPeriodFrom,	
					"effectiveDate":effectiveDate,
					"expiryDate":expiryDate,
					"routing":[
			            {
			               "fromLoc":pol,               
			               "fromTerminal":pol,
			               "toTerminal":pod,                
			               "toLoc":pod,
			               "eta":effectiveDate,
			               "etd":expiryDate,                
			            }
			         ],
					"containerDtl":containerDtl     
					
		        }
		    }
		}
		


		playload=JSON.stringify(playload)
	     
		$.ajax({
        method : "POST",
		async : true,
		url : "/DCSWebService/rclws/getRateDtls",
		 data:playload,         
		 contentType: "application/json;",
		traditional: true,
		dataType: 'json',
        success: function(resultDataOut){
			loading(true);	
		  
		 if(resultDataOut.resultCode==401){
			 swal("Message", resultDataOut.resultContent , "info");
			 return;
		 }
		 if(resultDataOut.resultContent.length==0){
			 swal("Message", no_record_found_msg , "info");
			 return;
		 }
		 g_getRate=resultDataOut;
		 
		 // getting all nodes
		 g_GroupingData={"20 GP":[],
					"40 GP":[],
					"40 HC":[]
			};
		 var data = resultDataOut.resultContent;
		 var freightOrSurchargeCodes=[]
		 for(var i=0;i<data.length;i++){
			 var row=data[i];
			 if(row["freightOrSurchageFlag"]!="F" ){				 
				 freightOrSurchargeCodes.push("'"+(parseInt(row["freightOrSurchargeCode"])).toString()+"'");		
				if(g_GroupingData[getGroupingOfContainer(row)]){ 
					g_GroupingData[getGroupingOfContainer(row)].push(row);
				}else{
					// Note need to check for 20 40 
					g_GroupingData["20 GP"].push(row);
					g_GroupingData["40 GP"].push(row);
					g_GroupingData["40 HC"].push(row);
				}
			 }
		 }
		 getFreightOrSurchargeCodes(freightOrSurchargeCodes.join(","));
		 
		 //Getting all the 
		},error:function(error){
			errorMessage();
		}
    });

}

function getGroupingOfContainer(row){
	return row["equipmentSize"] +" "+row["equipmentType"];
}



function sendMail(action){
	 
	 
	 var pdf=$("#pdfOutPut").html();	 
	  $("#payload").val(pdf.replace("display:none;",""));
	  $("#freeDays").val($("#freeDays1").html()); 	
	  $("#portOfDeparture").val(G_LIST_OF_COUNTRY($("#pod").val()))
	  $("#portOfLoading").val(G_LIST_OF_COUNTRY($("#pol").val()))
	  $("#numberOfContainer").val(containerSizeCreated);
	  
	  var currentDate=  new Date();
	  var getMonths=(currentDate.getMonth()+1).toString().length==1?"0"+(currentDate.getMonth()+1):(currentDate.getMonth()+1);
	  var currentDateString = currentDate.getDate()+"/"+getMonths+"/"+currentDate.getFullYear();
	  $("#currentDate").val(currentDateString);
	  
	 for(var container in maxRateHeader){
		 $("#containerSize"+getUIniqueId(container)).val(container);
		 $("#usd"+getUIniqueId(container)).val($("#dry"+getUIniqueId(container)).html().split(" USD"));
	 }
	 
	 $("#pdfDownlaod").submit();
    
}
 
function getSearchCerteria(){
	
	var pod=document.getElementsByName("pod")[0].value;
	var pol=document.getElementsByName("pol")[0].value;
	var shipmentTerm=document.getElementsByName("shipmentTerm")[0].value;
	var cargoType= $("#inputCargoType").val();
	 
	var expectedVolume=0;
	var commodity=document.getElementsByName("commodity")[0].value;
	var expectedLoadingPeriodFrom=$("#loadingFrom").val(); 	 
	var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	 for(var i=1;i<=containerSizeCreated;i++){
	 		
			if($("#inputExpectedVolume"+i).val()!=""){
				expectedVolume+=parseInt($("#inputExpectedVolume"+i).val());
			}		 		
	 }
	 return {
		 	"pod":pod,"pol":pol,"shipmentTerm":shipmentTerm,"cargoType":cargoType,"expectedVolume":expectedVolume,
		 	"commodity":commodity,"loadingFrom":loadingFrom,"loadingTo":loadingTo,
		 	
	 };
}
function draSearch(resultDataOut){
	var pod=document.getElementsByName("pod")[0].text;
	var pol=document.getElementsByName("pol")[0].value;
	var shipmentTerm=document.getElementsByName("shipmentTerm")[0].value;
	var cargoType= $("#inputCargoType").val();
	var containerSize=document.getElementsByName("containerSize")[0].value;
	var expectedVolume=0;
	var commodity=document.getElementsByName("commodity")[0].value;
	var expectedLoadingPeriodFrom=$("#loadingFrom").val(); 	 
	var effectiveDate= fomatDateYYMMDD($("#loadingFrom").val());	 
	var expiryDate= fomatDateYYMMDD($("#loadingTo").val());
	var moreDetail=1
	 var outputHTML ="";
	 var data = resultDataOut.resultContent;
	 var totalAll={
			 	"20 GP":0,
			 	"40 GP":0,
			 	"40 HC":0
	 }
	 
	 // Getting the total valule 
	 
	 for(var i=1;i<=containerSizeCreated;i++){
			 		
		if($("#inputExpectedVolume"+i).val()!=""){
			expectedVolume+=parseInt($("#inputExpectedVolume"+i).val());
		}		 		
	 }
	 
	var row= data[0];
	var EFFECTIVE_DATE = $("#loadingFrom").val();
	var EXPIRY_DATE =$("#loadingTo").val();
	var ocenFlight=0;
	if(expectedVolume==0){
		expectedVolume="";
	}
	
	
		 outputHTML +='<div>'+
           '<div class="card2 js-result-loading-div" style="margin-top: 200px;">'+
       '<h2 class="text-muted text-center">Your results will appear here</h2>'+
       '<div class="d-flex">'+
        ' <img src="imgs/result_illustration.svg" class="rounded mx-auto d-block"'+
         '  alt="Responsive image" width="20%">'+
       '</div>'+
     '</div>'+
    ' <div class="card2 show js-result-div">'+
     '  <div>'+
     '    '+
     	'<h5 class="card-title rate_header">'+
      '   <strong >'+regionalContainerLines_Message+'</strong>'+
      ' </h5>'+
      ' '+
      '  <span style="margin-top: -20px;" class="float-right" onclick="sendMail();"><i ></i></span>'+
      ' </div>'+
      ' <hr />'+
      ' <div class="order-summary">'+
       '  <div class="row">'+
       '    <div class="col-12">'+
        '     <h5><strong>'+rclRateInquiry_Message+'</strong></h5>'+
         '  </div>'+
         '</div>'+
         '<div class="row">'+
          ' <div class="col-12">'+
           '  <div class="card">'+
            '   <div class="card-body">'+
             '    <div class="row" style="line-height: 1.9;">'+
              '     <div class="col-md-3">'+
                '     <div class="d-flex">'+
               '        <strong>'+from_Message+'</strong> &nbsp;&nbsp;<span class="text-muted">(Port Of'+
				'	Loading)</span>'+
                '     </div>'+
                 '    <div class="d-flex">'+G_LIST_OF_COUNTRY($("#pol").val())+'</div>'+
                  '   <div class="d-flex">'+
                   '    <strong>'+shipmentTerm_Message+'</strong>'+
                    ' </div>'+
                     '<div class="d-flex">'+shipmentTerm+'</div>'+
                    ' <div class="d-flex">'+
                     '  <strong>'+expectedLoadingPeriod_Message+'</strong>'+
                     '</div>'+
                    ' <div class="d-flex">'+EFFECTIVE_DATE+' -  '+EXPIRY_DATE+' </div>'+
                   '</div>'+
                   '<div class="col-md-3">'+
                   '  <div class="d-flex">'+
                    '   <strong>To</strong> &nbsp;&nbsp;<span class="text-muted">('+Port_of_Discharge_Message+')</span>'+
                     '</div>'+
                     '<div class="d-flex">'+G_LIST_OF_COUNTRY($("#pod").val())+'</div>'+
                     '<div class="d-flex">'+
                      ' <strong>'+Cargo_Type_Message+'</strong>'+
                     '</div>'+
                    ' <div class="d-flex">'+cargoType+'</div>'+
                  ' </div>'+
                  ' <div class="col-md-3">'+
                  '<div class="d-flex">   <strong>&nbsp;</strong></div>'+
                  '<div class="d-flex">   <strong>&nbsp;</strong></div>'+
                   '  <div class="d-flex">'+
                    '   <strong>'+expectedVolume_Message+'</strong>'+
                     '</div>'+
                    ' <div class="d-flex">'+expectedVolume+'</div>'+
                  ' </div>'+
                   '<div class="col-md-3">'+
                   '<div class="d-flex">   <strong>&nbsp;</strong></div>'+
                   '<div class="d-flex">   <strong>&nbsp;</strong></div>'+
                    ' <div class="d-flex">'+
                     '  <strong>'+commodity_Message+'</strong>'+
                    ' </div>'+
                    ' <div class="d-flex">'+$("#inputCommodity").val()+'</div>'+
                  ' </div>'+
                ' </div>'+
              ' </div>'+
            ' </div>'+
           '</div>'+
         '</div>'+

         '<div class="row mt-3">'+
          ' <div class="col-12">'+
           '  <div class="card">'+
            '   <div class="card-body">'+
             '    <div class="row">'+
              '     <div class="col-md-2">'+
              '       <div style="float:left;width: 300px;">'+
               '      <div class="d-flex">'+
                '       <strong>'+totalPrice_Message+' (Freight + Surcharge)</strong>'+
                 '    </div>'+
                     
                  '    <div class="d-flex">'+
                   '    <span  style="color:blue;" onclick="showMoreDetail('+moreDetail+')">'+clickForPriceBreakDown__Message+'</span>'+
                    '  </div>'+
                    ' </div>'+
                  ' </div>'+
                  '<div class="col-md-10">'+
                  ' <div class="col-md-12" id="pdfOutPut">'+
                   '  <div class="row" >'+
                    ' <!--  This div in loop -->';
		 
                     for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){ 
                   	  //land
                   	 var container =$("#inputContainerSize"+contIndex).val();
                   	 outputHTML+='  <div class="col-md-'+getColumWidthOfContainer()+'">'+
                      '   <div class="text-center">'+
                       '    <strong>'+container+' '+dry_Message+' </strong> <br>'+
                        '   <span style="font-weight: 600;" id="dry'+getUIniqueId(container)+'">'+0+" "+'USD'+'<span>'+
                         '</div>'+
                       '</div>';
                        
                   }
                   
                   	outputHTML+='</div>'+             
                     
                     '<hr />'+
                      '<div id="moreDetail'+moreDetail+'" style="display:none;">'+
                       '  <div class="row">'+
                        '  <!--  This div in loop Breakdown -->';
                   	for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){ 
                   		outputHTML+=    '  <div class="col-md-'+getColumWidthOfContainer()+' searchPadding">'+
                          '   <div class="text-center">'+
                           '    <strong><u>'+priceBreakDown_Message+'</u></strong>'+
                            ' </div>'+
                           '</div>';
                   	}    
                     	outputHTML+=    ' </div>';
                   	 
                   	// for(var index=0;index<data.length;index++){
                     	
                   	 var container =$("#inputContainerSize"+contIndex).val();
                   	outputHTML+= ' <div class="row">';
                   	outputHTML+=    '<!--  This will in loop -->';
                   	var freight=""; 
                    for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){ 
                    	
                   	 var container =$("#inputContainerSize"+contIndex).val();
                   	freight+=   ' <div class="col-md-'+getColumWidthOfContainer()+' searchPadding">'+
                           '  <table class="table table-sm borderless">'+
                            '   <tbody>'+
                             '    <tr>'+
                              '     <th scope="row" colspan="'+getColumWidthOfContainer()+'">'+
                               '      '+Freight_Charges_Message
                                '   </th>'+
                                 '</tr>';
                   	
                   	 
                   			freight+= ' <tr>'+
                                 '  <td >Ocean Freight</td>'+
                                  ' <td width="20%" align="right">'+container.split(" ")[0]+'\'x'+1+'</td>'+
                                   '<td width="20%" align="right">'+formatNumber(getOceanFreight(container))+'</td>'+
                                  ' <td width="50px" align="right">'+formatCurrency("USD")+' </td>'+
                                ' </tr>';
                   	    
                        
                     freight+= ' </tbody>'+
                            ' </table>'+
                          ' </div>';
                     totalAll[container]=0;
                    }
                    
                    freight+=' </div>';
                    
                         outputHTML+=freight;
                         var localCharges="";
                         localCharges+='<div class="row ">';
                         for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){ 
                        	 var container =$("#inputContainerSize"+contIndex).val();
                          
                        	 localCharges+= ' <div class="col-md-'+getColumWidthOfContainer()+' searchPadding">'+
                           '  <table class="table table-sm borderless">'+
                            '   <tbody>'+
                             '    <tr>'+
                              '     <th scope="row" colspan="'+getColumWidthOfContainer()+'">'+
                               '      Origin- Local Charges'+
                                '   </th>'+
                                ' </tr>';
                           	debugger;
                           	
                          for(var index=0;index<g_GroupingData[container].length;index++){ 
                        	  var obj=g_GroupingData[container][index];
                        	  // this to update Ocean Freigh becuase we are re-calucaton
                        	 
                         	 
                             	 if(obj["freightOrSurchageFlag"]=="S" && obj["orgDestTs"]=="O" ){	
                             		
                             		totalAll[container]+=parseFloat(calculateMarkupRate(obj));
                             		console.log(getFullDescription(obj)+" " +formatCurrency(obj["guidelineCurrency"])+" "+obj["rate"]+" " +parseFloat(calculateMarkupRate(obj))+" total "+totalAll[container]);
                             	 localCharges+=   ' <tr>'+
				                                 '  <td  >'+getFullDescription(obj)+'</td>'+
				                                 ' <td width="20%" align="right">'+(obj["equipmentSize"]==0?"Per B/L":obj["equipmentSize"]+'\'x'+1)+'</td>';
                             	 
                             	 
                    				localCharges+=  '<td width="20%" align="right">'+formatNumber(obj["rate"])+'</td>';
                    			
                             	
                             	localCharges+=   ' <td width="50px" align="right">'+formatCurrency(obj["guidelineCurrency"])+'</td>'+
				                               ' </tr>';
                             	 }
                          }
                                  
                          localCharges+=   ' </tbody>'+
                            ' </table>'+
                          ' </div>';
                            
                       
                        }
                         localCharges+= ' </div>';
                      outputHTML+=localCharges;
                      var destination=""
                        
                      destination+= '<div class="row ">';
                      for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){ 
                    	  var container =$("#inputContainerSize"+contIndex).val();
                      destination+=   ' <div class="col-md-'+getColumWidthOfContainer()+' searchPadding">'+
                           '  <table class="table table-sm borderless">'+
                            '   <tbody>'+
                             '    <tr>'+
                              '     <th scope="row" colspan="'+getColumWidthOfContainer()+'">'+
                               '      Destination- Local Charges'+
                                '   </th>'+
                                ' </tr>';
                        for(var index=0;index<g_GroupingData[container].length;index++){ 
                       	 
                       	 var obj=g_GroupingData[container][index];
                       	 
                       	 if(obj["freightOrSurchageFlag"]=="S" && obj["orgDestTs"]=="D" ){
                       				totalAll[container]+=parseFloat(calculateMarkupRate(obj));
                       				console.log(getFullDescription(obj)+" " +formatCurrency(obj["guidelineCurrency"])+" "+obj["rate"]+" " +parseFloat(calculateMarkupRate(obj))+" total "+totalAll[container]);
                            				
                    			destination+= ' <tr>'+
                                  '  <td >'+getFullDescription(obj)+'</td>'+
                                  ' <td width="20%" align="right">'+(obj["equipmentSize"]==0?"Per B/L":obj["equipmentSize"]+'\'x'+1)+'</td>';                    			 
                    				destination+=  '<td width="20%" align="right">'+formatNumber(obj["rate"])+'</td>';                    			
                    			destination+=' <td width="50px" align="right">'+formatCurrency(obj["guidelineCurrency"])+'</td>'+
                                 ' </tr>';
                    			
                    		}
                        }
                                 
                        destination+=   ' </tbody>'+
                            ' </table>'+
                           '</div>';
						}    
                        destination+= '</div>';
                              
                           outputHTML+=destination;      
                           outputHTML+= ' </div>'+
                  ' </div>'+
               '  </div>'+
               '</div>'+
             '</div>'+
           '</div>'+
        
         '<div class="row mt-3">'+
          ' <div class="col-12">'+
           '  <div class="card">'+
            '   <div class="card-body" id="freeDays'+moreDetail+'" style="display:none;">'+
              
              ' </div>'+
            ' </div>'+
          ' </div>'+
         '</div>'+
         '</div>'+
         ' </div>'+
         '<div class="row mt-3" id="submitContainer">'+
          ' <div class="col-12">'+
           '  <div class="card">'+
            '   <div class="card-body">'+
             '    <div class="row">'+
              '     <div class="col-md-12">'+
               '      <div class="float-right">'+
                '       <button type="button" class="btn btn-danger">'+cancel_Message+' </button>'+
                 '      <button type="button" class="btn btn-primary"  onclick="genrateQuatationRef();">'+getQuatation_Message+'</button>'+
                  '   </div>'+
                   '</div>'+
                ' </div>'+
               '</div>'+
             '</div>'+
          ' </div>'+
        ' </div>'+
       '</div>'+
	'	<div>'+
 '</div>';
  moreDetail++;
 
  
  debugger;
	$("#searchResult").html(outputHTML);
	 for(var contIndex=1;contIndex<=containerSizeCreated;contIndex++ ){
   	  
		 var container =$("#inputContainerSize"+contIndex).val();
		 	 console.log(" ocen ",getOceanFreight(container)+" "+ parseFloat(totalAll[container]))
       	 	$("#dry"+getUIniqueId(container)).html(formatNumber(getRoundOf(  parseFloat(getOceanFreight(container))+parseFloat(totalAll[container])) )+" USD");
	 }
}

function getUIniqueId(container){
	return container.split(" ")[0]+container.split(" ")[1]
}

function getColumWidthOfContainer(){
	
	return (12/containerSizeCreated);
}

function G_LIST_OF_COUNTRY(code){
	 
	//console.log(code)
	return G_LIST_OF_COUNTRY_NOT_USER[code]+" , " +getCountryByCodeJson[code.substring(0,2)];
}


function formatNumber(row,key) {
	  return   row.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,');
}

function formatCurrency(currency) {
	  return  currency;
}

function getRoundOf(val){
	return Math.round(val)
}

function getFullDescription(obj){
		
	return ALL_SURCHARE[obj["freightOrSurchargeCode"]]?ALL_SURCHARE[obj["freightOrSurchargeCode"]]:obj["shortDescription"];
}
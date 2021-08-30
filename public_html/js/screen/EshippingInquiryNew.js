

function onLoad() {

	debugger;
	if ($("#loginDateCheck").val() == null || $("#loginDateCheck").val() == "") {
		window.location.href = "../do/sexn007usePassword";
	}


	$("#shippingModifier").removeClass();
	$("#shippingModifier").addClass("nav-item active");

	debugger;
	var statusValideter = document.getElementById("statusValidater").value;
	var statusErrorCode = document.getElementById("errorMsg").value;


	if (statusValideter == "" || statusValideter == null || statusValideter == 'N' || statusValideter == "New") {
		$("#pills-open-orders-tab").tab('show');
	} else if (statusValideter == 'E' || statusValideter == "Entry") {
		$("#pills-entry-orders-tab").tab('show');
	} else if (statusValideter == 'S' || statusValideter == "Submit" || statusValideter == "C" || statusValideter == "Confirmed") {
		$("#pills-submited-orders-tab").tab('show');
	}

}

function getEntryStatus() {
	debugger;
	loading();
	document.getElementById("pills-open-orders").style.display = "none";
	bookingUrl = ON_LOAD + '?esiStatusCode=E&bookingNo=';

	document.forms[0].action = bookingUrl;
	document.forms[0].submit();

}
function getSubmitedStatus() {
	debugger;
	loading();
	document.getElementById("pills-submited-orders").style.display = "none";
	bookingUrl = ON_LOAD + '?esiStatusCode=S&bookingNo=';

	document.forms[0].action = bookingUrl;
	document.forms[0].submit();

}
function getNewStatus() {
	debugger;
	loading();
	document.getElementById("pills-open-orders").style.display = "none";
	bookingUrl = ON_LOAD + '?esiStatusCode=&bookingNo=';

	document.forms[0].action = bookingUrl;
	document.forms[0].submit();

}

function getSearchBookingData() {
	debugger;
	loading();
	document.getElementById("pills-open-orders").style.display = "none";
	var bookingNo = document.getElementById("BKGNoSearch").value;
	var esiStatus = document.getElementById("esiStatusSearch").value;
	var blNo = document.getElementById("searchBlBtn").value;
	bookingUrl = ON_LOAD_BOOKING + '?esiStatusCode=' + esiStatus + "&bookingNo=" + bookingNo + '&blNo=' + blNo;

	document.forms[0].action = bookingUrl;
	document.forms[0].submit();

}



function getMoreShippingData(rowNum) {

	debugger;
	var MoreId = "";
	loading();
	var url = GET_BOOKING_NUMBER_TO_MORE_WEBBOOKING_PAGE;
	var idvalue = "bookingNo" + rowNum;
	bookingNo = document.getElementById(idvalue).textContent;
	esiStatusCode = document.getElementById("statusValidater").value;

	if (esiStatusCode == '' || esiStatusCode == null || esiStatusCode == 'New' || esiStatusCode == 'N') {
		//header dtl

		MoreId = "MoreN_" + rowNum;
		if ($('#' + MoreId).find('i')[0].parentElement.innerText == "Less ") {
			loading(true);
			return false;
		}

		fromTerminal = "fromTerminalO_" + bookingNo;
		toTerminal = "toTerminalO_" + bookingNo;
		//customer dtl

		shipper = "shipperO_" + bookingNo;
		consignee = "consigneeO_" + bookingNo;
		notify = "notifyO_" + bookingNo;

		//routing dtl

		portofloading = "portofloadingO_" + bookingNo;
		portofdischarge = "portofdischargeO_" + bookingNo;
		vesselVoyage = "vesselVoyageO_" + bookingNo;
		transhipport = "transhipportO_" + bookingNo;

		//Equipment & Commodity Details		

		containerNoSealNoMarksNo = "containerNoSealNoMarksNoO_" + bookingNo;
		containersType = "containersTypeO_" + bookingNo;
		descriptionofGoodsNetWeight = "descriptionofGoodsNetWeightO_" + bookingNo;
		grossweightmeasurement = "grossweightmeasurementO_" + bookingNo;
	} else if (esiStatusCode == 'E' || esiStatusCode == 'Entry') {
		//header dtl

		MoreId = "MoreE_" + rowNum;
		if ($('#' + MoreId).find('i')[0].parentElement.innerText == "Less ") {
			loading(true);
			return false;
		}

		fromTerminal = "fromTerminalE_" + bookingNo;
		toTerminal = "toTerminalE_" + bookingNo;
		//customer dtl

		shipper = "shipperE_" + bookingNo;
		consignee = "consigneeE_" + bookingNo;
		notify = "notifyE_" + bookingNo;

		//routing dtl

		portofloading = "portofloadingE_" + bookingNo;
		portofdischarge = "portofdischargeE_" + bookingNo;
		vesselVoyage = "vesselVoyageE_" + bookingNo;
		transhipport = "transhipportE_" + bookingNo;

		//Equipment & Commodity Details		

		containerNoSealNoMarksNo = "containerNoSealNoMarksNoE_" + bookingNo;
		containersType = "containersTypeE_" + bookingNo;
		descriptionofGoodsNetWeight = "descriptionofGoodsNetWeightE_" + bookingNo;
		grossweightmeasurement = "grossweightmeasurementE_" + bookingNo;
	} else if (esiStatusCode == 'S' || esiStatusCode == 'Submit' || esiStatusCode == 'C' || esiStatusCode == 'Confirmed' || esiStatusCode == 'Confirm') {
		//header dtl

		MoreId = "MoreS_" + rowNum;
		if ($('#' + MoreId).find('i')[0].parentElement.innerText == "Less ") {
			loading(true);
			return false;
		}

		fromTerminal = "fromTerminalS_" + bookingNo;
		toTerminal = "toTerminalS_" + bookingNo;
		//customer dtl

		shipper = "shipperS_" + bookingNo;
		consignee = "consigneeS_" + bookingNo;
		notify = "notifyS_" + bookingNo;

		//routing dtl

		portofloading = "portofloadingS_" + bookingNo;
		portofdischarge = "portofdischargeS_" + bookingNo;
		vesselVoyage = "vesselVoyageS_" + bookingNo;
		transhipport = "transhipportS_" + bookingNo;

		//Equipment & Commodity Details		

		containerNoSealNoMarksNo = "containerNoSealNoMarksNoS_" + bookingNo;
		containersType = "containersTypeS_" + bookingNo;
		descriptionofGoodsNetWeight = "descriptionofGoodsNetWeightS_" + bookingNo;
		grossweightmeasurement = "grossweightmeasurementS_" + bookingNo;

		rateCharege = "rateCharegeS_" + bookingNo;
	}
	$.ajax({
		method: "POST",
		async: true,
		url: GET_BOOKING_NUMBER_TO_MORE_WEBBOOKING_PAGE,
		data: { bookingNo: bookingNo, esiStatusCode: esiStatusCode },
		dataType: 'text',
		success: function(result) {
			var obj = JSON.parse(result);

			count = 0;
			contailerDtlNo = "";
			containerDtlSize = "";
			conatinerDtlWeight = "";
			conatinerDtlMeasurment = "";
			conatinerDtl3 = "";
			descriptionofGoodsNetWeightvalue = "";
			vesselNameVoyageValues="";
			
			
			sizeType = {};

			$("#" + fromTerminal).html('<div class="d-flex text-muted text-small" id="' + fromTerminal + '">' + obj.Result.fromTerminalDes + '</div>');
			$("#" + toTerminal).html('<div class="d-flex text-muted text-small" id="' + toTerminal + '">' + obj.Result.toTerminalDes + '</div>');

			var shipperDtl = "";
			if (obj.Result.shipperName != "") {
				shipperDtl = shipperDtl + obj.Result.shipperName;
			} if (obj.Result.shipperAddress1 != "") {
				shipperDtl = shipperDtl + '/' + obj.Result.shipperAddress1;
			} if (obj.Result.shipperAddress2 != "") {
				shipperDtl = shipperDtl + ' ' + obj.Result.shipperAddress2;
			} if (obj.Result.shipperAddress3 != "") {
				shipperDtl = shipperDtl + ' ' + obj.Result.shipperAddress3;
			} if (obj.Result.shipperAddress4 != "") {
				shipperDtl = shipperDtl + ' ' + obj.Result.shipperAddress4;
			}
			$("#" + shipper).html('<div class="d-flex text-muted text-small" id="' + shipper + '">' + shipperDtl + '</div>');

			var consigneedtl = "";
			if (obj.Result.consigneeName != "") {
				consigneedtl = consigneedtl + obj.Result.consigneeName;
			} if (obj.Result.consigneeAddress1 != "") {
				consigneedtl = consigneedtl + '/' + obj.Result.consigneeAddress1;
			} if (obj.Result.consigneeAddress2 != "") {
				consigneedtl = consigneedtl + ' ' + obj.Result.consigneeAddress2;
			} if (obj.Result.consigneeAddress3 != "") {
				consigneedtl = consigneedtl + ' ' + obj.Result.consigneeAddress3;
			} if (obj.Result.consigneeAddress4 != "") {
				consigneedtl = consigneedtl + ' ' + obj.Result.consigneeAddress4;
			}

			$("#" + consignee).html('<div class="d-flex text-muted text-small" id="' + consignee + '">' + consigneedtl + '</div>');

			var notifyparty = "";
			if (obj.Result.notifyPartyName != "") {
				notifyparty = notifyparty + obj.Result.notifyPartyName;
			} if (obj.Result.notifyPartyAddress1 != "") {
				notifyparty = notifyparty + '/' + obj.Result.notifyPartyAddress1;
			} if (obj.Result.notifyPartyAddress2 != "") {
				notifyparty = notifyparty + ' ' + obj.Result.notifyPartyAddress2;
			} if (obj.Result.notifyPartyAddress3 != "") {
				notifyparty = notifyparty + ' ' + obj.Result.notifyPartyAddress3;
			} if (obj.Result.notifyPartyAddress4 != "") {
				notifyparty = notifyparty + ' ' + obj.Result.notifyPartyAddress4;
			}
			$("#" + notify).html('<div class="d-flex text-muted text-small" id="' + notify + '">' + notifyparty + '</div>');
			debugger;
			for(var i = 0; i < obj.Result.routingDtls.length; i++){
				if(i==0)
					vesselNameVoyageValues+=obj.Result.routingDtls[i].vesselName+"/"+obj.Result.routingDtls[i].voyage;
				else
					vesselNameVoyageValues+="<br>"+obj.Result.routingDtls[i].vesselName+"/"+obj.Result.routingDtls[i].voyage;
				
			}

			$("#" + portofloading).html('<div class="d-flex text-muted text-small" id="' + portofloading + '">' + obj.Result.pol + '</div>');
			$("#" + portofdischarge).html('<div class="d-flex text-muted text-small" id="' + portofdischarge + '">' + obj.Result.pod + '</div>');
			$("#" + vesselVoyage).html('<div class="d-flex text-muted text-small" id="' + vesselVoyage + '">' + vesselNameVoyageValues + '</div>');
			$("#" + transhipport).html('<div class="d-flex text-muted text-small" id="' + 'need to check' + '">' + ((obj.Result.port1 == null || obj.Result.port1 == "") ? "" : obj.Result.port1 + ',')
				+ '' + ((obj.Result.port2 == null || obj.Result.port2 == "") ? "" : obj.Result.port2 + ',') + '' +
				((obj.Result.port3 == null || obj.Result.port3 == "") ? "" : obj.Result.port3) + '</div>');
			debugger;
			if (obj.Result.cargoDescriptionDetails.length > 0) {
				var objTemp = {};
				for (var i = 0; i < obj.Result.cargoDescriptionDetails.length; i++) {
					count++;
					if (i > 0) {
						contailerDtlNo += "' / '";
					}
					contailerDtlNo += obj.Result.cargoDescriptionDetails[i].containerNo;
					if (obj.Result.cargoDescriptionDetails[i].carrierSeal != "" && obj.Result.cargoDescriptionDetails[i].carrierSeal != null) {
						contailerDtlNo = contailerDtlNo + '/' + obj.Result.cargoDescriptionDetails[i].carrierSeal;
					}
					key = obj.Result.cargoDescriptionDetails[i].containerEqSize + " " + obj.Result.cargoDescriptionDetails[i].containerEqType;
					if (objTemp[key] == undefined) {
						objTemp[key] = 1;
					} else {
						objTemp[key] = (objTemp[key]) + 1;
					}
				}
				for (var key in objTemp) {
					if (conatinerDtl3 == "")
						conatinerDtl3 += "" + objTemp[key] + " X " + key + "<br>";
					else
						conatinerDtl3 += "" + objTemp[key] + " X " + key + "<br>";
				}
			}


			for (var i = 0; i < obj.Result.commodityVoDataList.length; i++) {

				descriptionofGoodsNetWeightvalue = obj.Result.commodityVoDataList[i].strCommDesc;


				if (i > 0) {
					conatinerDtlWeight = conatinerDtlWeight + "\n," + obj.Result.commodityVoDataList[i].strCommWeight;
					if (obj.Result.commodityVoDataList[i].strCommMeasurement != "" && obj.Result.commodityVoDataList[i].strCommMeasurement != null) {
						conatinerDtlMeasurment = conatinerDtlMeasurment + "," + obj.Result.commodityVoDataList[i].strCommMeasurement;
					}
				} else {
					conatinerDtlWeight = conatinerDtlWeight + obj.Result.commodityVoDataList[i].strCommWeight;
					if (obj.Result.commodityVoDataList[i].strCommMeasurement != "" && obj.Result.commodityVoDataList[i].strCommMeasurement != null) {
						conatinerDtlMeasurment = conatinerDtlMeasurment + obj.Result.commodityVoDataList[i].strCommMeasurement;
					}
				}

			}

			$("#" + containerNoSealNoMarksNo).html('<div class="d-flex text-muted text-small" id="' + containerNoSealNoMarksNo + '">' + contailerDtlNo + '</div>');
			$("#" + containersType).html('<div class="d-flex text-muted text-small" id="' + containersType + '">' + conatinerDtl3 + '</div>');
			$("#" + descriptionofGoodsNetWeight).html('<div class="d-flex text-muted text-small" id="' + descriptionofGoodsNetWeight + '">' + descriptionofGoodsNetWeightvalue + '</div>');
			$("#" + grossweightmeasurement).html('<div class="d-flex text-muted text-small" id="' + grossweightmeasurement + '">' + conatinerDtlWeight + ' / ' + conatinerDtlMeasurment + '</div>');
			var row = "";
			for (var k = 0; k < obj.Result.revinue.length; k++) {
				row += '<tr>' +
					'<td>' + obj.Result.revinue[k].chargeCode + '</td>' +
					'<td>' + obj.Result.revinue[k].descreiptionCharegCode + '<td>' +
					'<td>' + obj.Result.revinue[k].currency + '</td>' +
					'<td>' + obj.Result.revinue[k].rate + '</td>' +
					'<td>' + obj.Result.revinue[k].basis + '</td>' +
					'<td>' + obj.Result.revinue[k].amount + '</td>' +
					'</tr>';

			}
			debugger;
			if (obj.Result.revinue.length > 0) {
				$("#" + rateCharege).html("").html(row);
				var count = 0;
				for (var i = 1; i <= obj.Result.revinue.length; i++) {
					if (i == 1) {
						count = 1 * 2;
						if (typeof $("#paymentTable tbody td")[count].remove === 'function') {
							$("#paymentTable tbody td")[count].remove();
						} else {
							$("#paymentTable tbody td")[count].parentNode.removeChild($("#paymentTable tbody td")[count]);
						}

					} else {
						count = count + 6;
						if (typeof $("#paymentTable tbody td")[count].remove === 'function') {
							$("#paymentTable tbody td")[count].remove();
						} else {
							$("#paymentTable tbody td")[count].parentNode.removeChild($("#paymentTable tbody td")[count]);
						}
					}
				}
			}
			loading(true);
		}, error: function(error) {
			loading(true);
			alert(error);
		}
	});

}

function onEshippingInstructionLoad(bookingNo) {
	debugger;
	loading();
	//var id = "vesselETAO_" + bookingNo;
	//var date = $("#" + id + ' strong').html() + "";
	//var etdDate = new Date();
	//etdDate.setDate(Number(date.split("/")[0]));
	//etdDate.setMonth(Number(date.split("/")[1]) - 1);
	//etdDate.setYear(Number(date.split("/")[2]));
	//var resultDate = new Date();
	//var configdate = Number(document.getElementById("dateConfigesi").value);
	//resultDate.setDate(resultDate.getDate() + configdate);
	/*if(etdDate<=resultDate){
		//showBarMessageNew("Create-Shipping allwoed before 3 days of Deparcher date.");
		loading(true);
		swal("Message", sippingValidationMsg , "info");
		return false;
	}*/
	var url = SHIPPING_INSTRUTION;
	esiStatusCode = document.getElementById("statusValidater").value;
	if(esiStatusCode=="N" || esiStatusCode=="" || esiStatusCode=="New"){
		checkRateTypeValidation(bookingNo, esiStatusCode,url);
	}else if(esiStatusCode=="E"){
		checkSiEditFlag(bookingNo, esiStatusCode,url);
	}else{
		document.forms[0].action = url + '?esiStatusCode=' + esiStatusCode + '&bookingNo=' + bookingNo + '&flag=booking&mode=select';
		document.forms[0].submit();
	}
	
}

function checkSiEditFlag(bookingNo, esiStatusCode,url) {
	debugger;
	//var checkResult="";
	$.ajax({
		method: "POST",
		async: true,
		url: CHECK_SI_EDIT_FLAG,
		data: { bookingNo: bookingNo },
		dataType: 'text',
		success: function(result) {
		debugger;
			if (result == 'R') {
				loading(true);
				swal({
					title: "Booking information has been changed.Click Ok to Remove old SI Data ",
					text: "",
					icon: "warning",
					buttons: true,
					dangerMode: true,
				})
					.then(function(willDelete) {
						if (willDelete) {
							onCancelConfirm(bookingNo)
						} else {

						}
					});
			} else {
				document.forms[0].action = url + '?esiStatusCode=' + esiStatusCode + '&bookingNo=' + bookingNo + '&flag=booking&mode=select';
				document.forms[0].submit();
			}

		}, error: function(error) {
			loading(true);
			alert(error);
		}
	});
}

function checkRateTypeValidation(bookingNo, esiStatusCode,url) {
	debugger;
	//var checkResult="";
	$.ajax({
		method: "POST",
		async: true,
		url: CHECK_BOOKING_RATETYPE_CHECK,
		data: { bookingNo: bookingNo },
		dataType: 'text',
		success: function(result) {
		debugger;
			if (result == 'D1') {
					loading(true);
				var msg=	'DG shipment, eService does not allow to create SI.  \n  Please send SI to local agency for manually create draft B/L';
					swal(msg);
			} else {
				document.forms[0].action = url + '?esiStatusCode=' + esiStatusCode + '&bookingNo=' + bookingNo + '&flag=booking&mode=select';
				document.forms[0].submit();
			}

		}, error: function(error) {
			loading(true);
			alert(error);
		}
	});
}

function onBookingdtl(row) {

	alert("booking dtl");


}
function getPDF() {
	var url = PRIVIEW_PDF_REPORT;
	var esiStatus = document.forms[0].esiStatusDesc.value;
	var blNumber = document.forms[0].blNumber.value;
	//@18 Start
	var bookingNo = document.forms[0].bookingNo.value;
	openHelpList(url + "?blNumber=" + bookingNo + "&esiStatus=" + esiStatus, 850, 650);
	//         if(SUBMITTED_MODE == esiStatus){
	//                if(blNumber!=""){
	//                  openHelpList(url+"?blNumber="+blNumber+"&esiStatus="+esiStatus,850,650);
	//                  }else{
	//                   showBarMessage("No record found",1);
	//                  }
	//
	//        }else{
	//             var bookingNo = document.forms[0].bookingNo.value;
	//            openHelpList(url+"?blNumber="+bookingNo+"&esiStatus="+esiStatus,850,650);
	//        }
	//@18 End
}

function onBookingEdit(bookingNo) {
	debugger;
	loading();

	var configdate = Number(document.getElementById("dateConfigesi").value);

	var id = "vesselETAO_" + bookingNo;
	var date = $("#" + id + ' strong').html() + "";
	var etdDate = new Date();
	etdDate.setDate(Number(date.split("/")[0]));
	etdDate.setMonth(Number(date.split("/")[1]) - 1);
	etdDate.setYear(Number(date.split("/")[2]));

	var resultDate = new Date();
	resultDate.setDate(resultDate.getDate() + configdate);

	if (etdDate <= resultDate) {
		//showBarMessageNew("Edit-Booking allwoed before 3 days of Deparcher date.");
		loading(true);
		swal("Message", editValidationMsg, "info");
		return false;
	}


	var params = "?bookingNo=" + bookingNo + "&";

	params += "&mode=select";

	var url = ON_BOOKING_EDIT;
	
	checkBookingContainerAvailable(params,url,bookingNo,"EDIT")

}
function checkBookingContainerAvailable(params,url,bookingNo,type){
debugger;
	$.ajax({
		method: "POST",
		async: true,
		url: CHECK_EDIT_CONTAINER,
		data: { bookingNo: bookingNo },
		dataType: 'text',
		success: function(result) {
		debugger;
			if (result == 'AVA') {
				loading(true);
				if(type=="CANCEL")
				swal("Equipment Attached! Booking can't Cancel.");
				else
				swal("Equipment Attached! Booking can't modify.");
			} else {
				document.forms[0].action= url+params;
    			error_code = 2;
    			document.forms[0].submit();	
			}

		}, error: function(error) {
			loading(true);
			alert(error);
		}
	});
}
function onCancel(bookingNo) {
	
	debugger;
	
	 
	var configdate = Number(document.getElementById("dateConfigesi").value);

	var id = "vesselETAO_" + bookingNo;
	var date = $("#" + id + ' strong').html() + "";
	var etdDate = new Date();
	etdDate.setDate(Number(date.split("/")[0]));
	etdDate.setMonth(Number(date.split("/")[1]) - 1);
	etdDate.setYear(Number(date.split("/")[2]));

	var resultDate = new Date();
	resultDate.setDate(resultDate.getDate() + configdate);

	if (etdDate <= resultDate) {
		//showBarMessageNew("Edit-Booking allwoed before 3 days of Deparcher date.");
		swal("Message", canelValidationMsg, "info");
		return false;
	}
	
	
	swal({
		title: "Are you sure want to Cancel?",
		text: "",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then(function(willDelete) {
			if (willDelete) {
				//onCancelConfirm(bookingNo)
				onCancelConfirmationSi(bookingNo);
			} else {

			}
		});

}

function onCancelConfirmationSi(bookingNo){
    
	loading();

	var params   		= "?bookingNo="+bookingNo;
	params += "&mode=select";
	var cancelBookingUrl = ON_CANCEL_BOOKING_SI ;
    
	checkBookingContainerAvailable(params,cancelBookingUrl,bookingNo,"CANCEL");    	
}

function onCancelConfirm(bookingNo) {

	debugger;
	loading();

	var configdate = Number(document.getElementById("dateConfigesi").value);

	var id = "vesselETAO_" + bookingNo;
	var date = $("#" + id + ' strong').html() + "";
	var etdDate = new Date();
	etdDate.setDate(Number(date.split("/")[0]));
	etdDate.setMonth(Number(date.split("/")[1]) - 1);
	etdDate.setYear(Number(date.split("/")[2]));

	var resultDate = new Date();
	resultDate.setDate(resultDate.getDate() + configdate);

	/*if (etdDate <= resultDate) {
		//showBarMessageNew("Edit-Booking allwoed before 3 days of Deparcher date.");
		loading(true);
		swal("Message", canelValidationMsg, "info");
		return false;
	}*/

	cancelBookingUrl = ON_CANCEL_BOOKING + '?bookingNo=' + bookingNo;

	document.forms[0].action = cancelBookingUrl;
	document.forms[0].submit();

}
function generatePdf(bookingNo, blNum) {
	document.forms[0].action = ON_GENERATE_PDF + "?bookingNo=" + bookingNo + "&blNo=" + blNum + "&priViewFlag=Y";
	document.forms[0].submit();
}


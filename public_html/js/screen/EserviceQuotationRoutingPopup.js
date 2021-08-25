$(function(){
	$(window).bind("beforeunload",function(event){
		var msg="xx";
		$(window).bind("unload",function(event){
			event.stopImmediatePropagation();
			window.opener.unloading();
		});
		return msg;
	});
});

function callbackToFieldQuotationRouting(rowSelected){
    var url = SET_QUATATION_ROUTING_DATA;
    var parentForm = eval("parent.opener.document.forms[0]");
    try{    
        error_code = 1;
        
        parentForm.action = url+'?rowSelected='+rowSelected;
        error_code = 2;
        parentForm.submit();
    }catch(err){

          txt="JAVASCRIPT ERROR ON CALL DATA.\n";
          txt+="description: " + err.message + "\n";
          txt+=err+"";
          txt+="point#: " + error_code + "\n";
          txt+="Click OK to continue.";
          alert(txt);
    }    
    this.close();
}

function callBack(pol, pod, originCountry, destinationCountry, 
    placeOfReceipt, portOfLoading, portOfDischarge, placeOfDelivery,
    shipmentType, socCocUserFlag){
    
    //alert('1.pol = '+pol+'\n2.pod = '+pod+'\n3.originCountry = '+originCountry+
    //'\n4.destinationCountry = '+destinationCountry+'\n5.placeOfReceipt = '+placeOfReceipt+
    //'\n6.portOfLoading = '+portOfLoading+'\n7.portOfDischarge = '+portOfDischarge+
    //'\n8.placeOfDelivery = '+placeOfDelivery+'\n9.shipmentType = '+shipmentType+
    //'\n10.socCocUserFlag = '+socCocUserFlag);
    
    window.close();
    
    window.opener.setQuotationRoutingData(pol, pod, originCountry, destinationCountry, 
    placeOfReceipt, portOfLoading, portOfDischarge, placeOfDelivery, shipmentType, socCocUserFlag);
    //window.opener.setQuotationRoutingDetail(pol, pod, originCountry, destinationCountry, 
    //placeOfReceipt, portOfLoading, portOfDischarge, placeOfDelivery);
}

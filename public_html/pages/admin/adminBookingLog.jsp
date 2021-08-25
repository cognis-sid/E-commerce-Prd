<%@page import="java.util.Date"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
<title>Booking Admin Log | Regional Container Lines</title>
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<!-- add screen specific JavaScript file -->
<script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

<script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script src="<%=lstrCtxPath%>/js/libraries/bootstrap-datetimepicker.js?id=1"></script>
 
    <script language="JavaScript">
        var ON_LOAD                    					 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn010", pageContext)%>';
        var GET_BOOKING_NUMBER_TO_MORE_WEBBOOKING_PAGE   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn010GetmoreData", pageContext)%>';
        var SHIPPING_INSTRUTION                    		 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006GetData", pageContext)%>';
        var PRIVIEW_PDF_REPORT                           = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006PreviewPDFReport", pageContext)%>';
        var ON_BOOKING_EDIT                         	 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001Edit", pageContext) %>';
    	var ON_CANCEL_BOOKING							 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn012", pageContext) %>';
    	var ON_LOAD_BOOKING							     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn010SearchBtn", pageContext) %>';
    	var ON_GENERATE_PDF							     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006pdfgenerater", pageContext) %>';
    	var CHECK_SI_EDIT_FLAG							 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn012siEditBooking", pageContext) %>';
    	var CHECK_EDIT_CONTAINER				         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn012EditBookingContainerBooking", pageContext) %>';
    	var ON_CANCEL_BOOKING_SI 						= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002Cancel", pageContext) %>';
    </script>
    
     
    
</head>

<body >
	 
  <!-- Start Of Nav Bar -->
  <jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
   

   <div class="rcl-content">
    <nav aria-label="breadcrumb" class="mt-2">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="">
        <h4>Booking log</h4>
        
        </a>
        
        </li>
         
      </ol>
    </nav>
    <!-- Start Of Page -->
    <div class="content-container content-height">
	<div class="pt-3">
	<form id="searchData">
	<table>
		<tr>
			<td>
				<label for="portOfLoad" class="header_title">Booking ref no &nbsp;:&nbsp;</label>
			</td>
			<td width="18%">
				<input type="text"  style="width:100%;"  aria-describedby="emailHelp"
              placeholder="Booking ref no"  id="bookingRef" name="bookingRef">
			</td>
			<td>
				 <label for="portOfDischarge" class="header_title">BL No:</label>
			</td>
			<td width="18%">
				 <input type="text"  style="width:100%;"  aria-describedby="emailHelp"
              placeholder="BL No" id="bLNo" name="bLNo">
			</td>
			
			<td>
				 <label for="portOfDischarge" class="header_title">Booking No:</label>
			</td>
			<td width="18%">
				 <input type="text" style="width:100%;" aria-describedby="emailHelp"
              placeholder="Booking no" id="bookingNo" name="bookingNo">
			</td>
			
			<td>
				<label for="portOfDischarge" class="header_title">Submit date:</label>
			</td>
			<td width="18%">
				   
				 
							
							<div class="form-row">
						<div class="col">
							 
							<div class="input-icons">
								<i class="fas fa-calendar-alt icon"></i> <input type="text"
									id="submitDate" name="submitDate" class=" input-field  date-picker"   >
							</div>
						</div>
						</div>
			</td>
			
			<td>
				<label for="portOfDischarge" class="header_title">Confirm date:</label>
			</td>
			<td width="18%">
				  
				  
				  <div class="form-row">
						<div class="col">
							 
							<div class="input-icons">
								<i class="fas fa-calendar-alt icon"></i> <input placeholder="End date" type="text"
									 id="confirmDate" name="confirmDate"  class=" input-field  date-picker"   >
							</div>
						</div>
						</div>
			</td>
			
		</tr>
		<tr>
		
		
			
			<td>
				<label for="portOfDischarge" class="header_title">Cancel date:</label>
			</td>
			<td width="18%">
				 <div class="form-row">
						<div class="col">
							 
							<div class="input-icons">
								
								<i class="fas fa-calendar-alt icon"></i> <input placeholder="Cancel date" type="text"
									 id="cancelDate" name="cancelDate"  class=" input-field  date-picker"   >
							</div>
						</div>
				</div>	 
			</td>
			<td>
				 <label for="portOfDischarge" class="header_title">Status:</label>
			</td>
			<td width="18%">
				 <select id="errorType">
				 	<option>All</option>
				 	<option>Booking Creation</option>
				 	<option>Booking Creation Error</option>
				 	<option>Booking Submit</option>
				 	<option>Booking Submit XML Error</option>
				 	<option>Booking Cancel XML Error</option>
				 	<option>Booking Confirmed</option>
				 	<option>Booking Edit</option>
				 	<option>Booking Cancel</option>
				 	<option>Booking Cancel Error</option>
				 	<option>Booking Confirmed Error</option>
				 	<option>Booking Edit Error</option>
				 	<option>Save Booking Error</option>
				 	
				 	<option>Booking Update</option>
				 	<option>SI Submit</option>
				 	<option>SI Submit Error</option>
				 	<option>SI Submit XML Error</option>
				 	<option>SI Confirmed</option>
				 	<option>SI Canceled</option>
				 	<option>SI Confirmed Erro</option>
				 	<option>SI Canceled Error</option>
				 	<option>SI Save</option>
				 	<option>SI Save Error</option>
				 	
				 	
				 	 
				 </select>
			</td>
			
			<td>
				 
			</td>
			<td width="18%">
				  
				  
				  
			</td>
			<td>
			 
			</td>
			<td width="18%">
				   
				 <div class="col" style="padding-top:30px;">
		   
             <button type="button" class="btn btn-light-blue btn-block" onclick="searchLog()">Search</button>
          </div>
							
			</td>
			<td>
			 
			</td>
			<td width="18%">
				  
		  <div class="col" style="padding-top:30px;">
            <input type="reset" class="btn btn-light-blue btn-block" value="Reset" onclick="resetData()">
          </div>
			</td>
		</tr>
	</table>
	</form>
	 
      </div>
	  
	  
      <div  >
        <div class="">
           
           
          <div class="right-row mt-3 ml-1 mr-1 row-booking-wrapper">
            
             
            
             <table id="table_id" class="display" style="width:100%">
     
</table>
				

          </div>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
  
   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document" style="min-width: 800px">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Reason of Fail</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group" id="message">
             Description/Reason for fail
          </div>
            
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
         
      </div>
    </div>
  </div>
</div>



 <div class="modal fade" id="fileModal" tabindex="-1" role="dialog" aria-labelledby="fileModal" aria-hidden="true">
  <div class="modal-dialog" role="document" style="min-width: 900px">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabel">List OF File</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
           
           <div class="form-group" id="files">
             
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
         
      </div>
    </div>
  </div>
</div>
<%
    String lstrCtxPath1     = request.getContextPath();
    
	%>
 <link rel="stylesheet" type="text/css" href="<%=lstrCtxPath1%>/css/jquery.dataTables.css">
  <script type="text/javascript" charset="utf8" src="<%=lstrCtxPath1%>/js/jquery.dataTables.js"></script>
<style>
	table.dataTable thead {
		background-color:#004b8e;
		color:white;
	}
	.form-group{
		margin-left:15px;
	}
	.header_title{
		font-weight:500;
		margin-right:10px;
		margin-left:10px;
		margin-top:5px;
	}
	
	.thead {
    background-color: #004b8e;
    color: white;
    padding-left: 15px;
}
  </style>
  
  
</body>
<script>
  
  var dataResponse=[];
function searchLog(){
		debugger;
		$('#table_id').dataTable().fnClearTable()
 // alert("getContry()");
  var data="&bookingNo="+$("#bookingNo").val()+"&bLNo="+$("#bLNo").val()+"&bookingRef="+$("#bookingRef").val()+"&submitDate="+$("#submitDate").val()+"&confirmDate="+$("#confirmDate").val();
  data+="&cancelDate="+$("#cancelDate").val()+"&errorType="+$("#errorType").val();
var result1 = {};
  var url="<%=lstrCtxPath1%>/do/adminBookingLogSearch?"+data;
  loading(false)
  $.ajax({
		method: "POST",		
		async: true,
		cache: false,
		url: url,
		data: JSON.stringify(data),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		
		success: function (data) {
			debugger;
			loading(true);
			dataResponse=data.dataResult;
			if(data.dataResult.length){
				$('#table_id').dataTable().fnAddData(data.dataResult);
			}else{
				swal("Message", "No Record Found" , "info");
			}
		},
		error: function (error, textStatus, jqXHR) {
			loading(true)
		alert("Error");
		},
	});

}
 

  
  $('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus')
})

  
  $(document).ready( function () {
	  
	 
	   $('#table_id').DataTable({	  								
	  								"data" : [],
	  								"columns" : [
	  										{
	  											"data" : "index",
	  											title : "Seq",
	  											 
	  										},
	  										{
	  											"data" : "bookingRef",
	  											title : "Booking ref no",
	  											className : "center"
	  										},
	  										{
	  											"data" : "bookingNo",
	  											title : "Booking no",
	  											className : "center"
	  											 
	  										},
	  										{
	  											"data" : "bLNo",
	  											title : "BL No",
	  											className : "center" 
	  										},
	  										{
	  											"data" : "bookingSubmitDate",
	  											title : "Booking Submit date"
	  										},
	  										{
	  											"data" : "bookingConfirmDate",
	  											title : "Booking Confirm  date"
	  										},
	  										{
	  											"data" : "shippingSubmitDate",
	  											title : "SI Submit date" 
	  										},
	  										{
	  											"data" : "shippingConfirmDate",
	  											title : "SI  Confirm  date" 
	  										},
	  										{
	  											"data" : "recordAddUser",
	  											title : "Created By"
	  										},
	  										{
	  											"data" : "updatedDate",
	  											title : "Updated Date"
	  										},
	  										{
	  											"data" : "Error",
	  											title : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",
	  											className : "center",
	  											render: function ( data, type, row ) {
	  												if(row.errorLog && row.errorLog!=""){
	  									            return '<button type="button" class="btn btn-primary" data-toggle="modal" onclick=\'showDialog("", '+row.index+')\' data-whatever="@mdo">' + row.type + '</button>';
	  												}else{
	  													return "<div style='text-align: left;margin-left: 25px;'>"+row.type+"</div>";
	  												}
	  											}
	  										},
	  										{
	  											"data" : null,
	  											title : "&nbsp;&nbsp;&nbsp;&nbsp;Files&nbsp;&nbsp;&nbsp;&nbsp;",
	  											render: function ( data, type, row ) {
	  												 
	  									            return '<button type="button" class="btn btn-primary" data-toggle="modal" onclick=\'showFileDialog("", '+row.id+')\' data-whatever="@mdo">View Files </button>';
	  												
	  									        }
	  										}]
	  							});
    var etdDate = new Date();
    $('#submitDate').datetimepicker({
	       format: 'DD/MM/YYYY',
			 
			
			
	   });
    
    $('#confirmDate').datetimepicker({
	       format: 'DD/MM/YYYY',
			 
			 
	     });
    $('#cancelDate').datetimepicker({
	       format: 'DD/MM/YYYY',
			 
			 
	     });
    
    
    $("#table_id_filter").show();
	     
} );

    $(document).ready(function () {
    	$.fn.dataTableExt.sErrMode = 'throw';
    	
    	
      $('.date-picker').datetimepicker({
        format: 'ddd DD/MM',
      });
    });
    
    function showDialog(response,id){
     
    	
    	 $('#exampleModal').modal('show');
    	 if(dataResponse[id-1].errorLog==""){
    		$("#message").html("No Error Happen") ;
    	 }else{
    		 $("#message").html(dataResponse[id-1].errorLog) ;
    	 }
    	
    }
    
    function showFileDialog(response,id){
    	//alert(id)
    	loading(false)
    	var data="&id="+id;
    	var url="<%=lstrCtxPath1%>/do/adminBookingFileSearch?"+data;
    	debugger;
    	$.ajax({
    		method: "POST",		
    		async: true,
    		cache: false,
    		url: url,
    		data: JSON.stringify(data),
    		contentType: "application/json;",
    		traditional: true,
    		dataType: 'json',
    		success: function (data) {
    			debugger;
    			loading(true)
    			var res="<table width='100%' border='1' >"
    			console.log(data);
    			if(data.dataResult){
    				res+="<tr>"
					 res+="<td width='50%' style='font-weight: 700;font-size: 14px;' class='thead'>FileName</td>";
					 res+="<td  width='30%' style='font-weight: 700;font-size: 14px;' class='thead'>Type Of File</td>";
					 res+="<td  width='20%' style='font-weight: 700;font-size: 14px;' class='thead'>Created Date</td>";
					 res+="</tr>"
    				for(var i=0;i<data.dataResult.length;i++){
    					var obj=data.dataResult[i];
    					 res+="<tr style='font-weight: 500;font-size: 12px;'>"
    					 res+="<td style='padding-left: 10px;word-break: break-all;'>"+obj.fileName+"</td>";
    					 res+="<td style='padding-left: 10px;'> "+obj.typeOfFile+"</td>";
    					 res+="<td style='padding-left: 10px;'> "+obj.recordAddUser+"</td>";
    					 res+="</tr>"
    					 
    				}
    			}
    			 res+="</table>"
    			 
    			$('#files').html(res);
    			 $('#fileModal').modal('show');
    		},
    		error: function (error, textStatus, jqXHR) {
    		alert("Error");
    		loading(true)
    		},
    	});
    	
    	 
    	  
    	
    }
    function resetData(){
    	$("#bookingNo").val("")
    	$("#bLNo").val("");
		$("#bookingRef").val("");
		$("#submitDate").val("");
		$("#confirmDate").val("");
    	$("#cancelDate").val("")  ;
    	$("#errorType").val("All")  ;
    	
		
    }
  </script>
</html>

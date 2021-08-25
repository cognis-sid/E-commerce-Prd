<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<style> 
	.btn-danger {
	margin-left: 50%;
	margin-top: 10%;
    color: #fff;
   background-color: #004b8e;
   border-color: #004b8e;
 
  
   text-align: right;
 }</style>
 <!-- Top empty row. Do not delete-->
 <body bgcolor="#C0C0C0">
<div class="container">
	<div class="form-content top-empty-row">
		<div class="row">
			<div class="col-xs-12"></div>
		</div>
	</div>
</div>
<div class="container">
	<div class="form-content">
		<!-- Page heading -->
		<div class="row">
			<div class="col-xs-12">
				<h3 class="page-heading">Access Denied</h3>
			</div>
			<hr style="width: 100%; text-align: left; margin-left: 0">
			
		</div>
		<div class="row">
			<div class="col-xs-12"><font color="red">
			<%
			  String access = (String)request.getAttribute("access");
			  
			  
			   if(access == "access"){%>
			      
  
  
				You do not have authorization to WRITE this page. Please
				contact this application Administrator to get the privilege.</font>
				<% 
				} else{%>
				You do not have authorization to access this page.
				<%}%>
			</div>
		</div>	
		<div class="row">
		<button type="button" class="btn btn-danger" onclick="history.back()"><i class="fas fa-times"></i>&nbsp;<bean:message key="web_booking_edit.Back"/>
		</button>
	</div>
</div>
</div>
<!-- Bottom Empty Row. Do not delete-->
<div class="container">
	<div class="form-content bottom-empty-row" style="min-height: 30px;">
		<div class="row">
			<div class="col-xs-12"></div>
		</div>
	</div>
</div>
</body>

<%@page import="java.util.Date"%>
<%
    String lstrCtxPath     = request.getContextPath();
    Date d=new Date();
	%>
<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/libraries/bootstrap.css?id=<%=d%>" />
<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/custom-chart.css?id=<%=d%>" />
<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/libraries/bootstrap-datetimepicker.css?id=<%=d%>" />
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/site.css?id=<%=d%>" />
<link rel="stylesheet" type="text/css" 	href="<%=lstrCtxPath%>/css/loader.css">

<link href="<%=lstrCtxPath%>/font-awesome/css/all.css" rel="stylesheet">

<script src="<%=lstrCtxPath%>/js/libraries/jquery-3.5.1.js"></script>
<script src="<%=lstrCtxPath%>/js/libraries/bootstrap.js"></script>
<script src="<%=lstrCtxPath%>/js/libraries/popper.js"></script>
<script src="<%=lstrCtxPath%>/js/libraries/parsley.js"></script>
<script src="<%=lstrCtxPath%>/js/common/jquery.validate.js"> </script>

<link rel="stylesheet" href="<%=lstrCtxPath%>/js/sweetalert/sweetalert.css">
<script src="<%=lstrCtxPath%>/js/sweetalert/sweetalert.js"></script>

<link rel="stylesheet" href="<%=lstrCtxPath%>/css/select2.min.css">
<script src="<%=lstrCtxPath%>/js/select2.min.js"></script>

<script type="text/javascript" src="<%=lstrCtxPath%>/js/RutString.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js"></script>
<script src="<%=lstrCtxPath%>/js/libraries/jquery.blockUI.js"> </script>
<script src="<%=lstrCtxPath%>/js/common/common.js"></script>
 
 <script src="<%=lstrCtxPath%>/js/libraries/moment.min.js"></script>
<script src="<%=lstrCtxPath%>/js/libraries/bootstrap-datetimepicker.js"></script>


<script src="<%=lstrCtxPath%>/js/custom-chart.js"></script>

<%-- <script src="<%=lstrCtxPath%>/js/booking-details.js"></script> --%>

<script src="<%=lstrCtxPath%>/js/libraries/bootstrap-autocomplete.min.js"></script> 



<link rel="stylesheet" href="<%=lstrCtxPath%>/help/css/silver-theme/jquery-ui-1.8.12.custom.css">
<script src="<%=lstrCtxPath%>/js/jquery-ui.js"></script> 

<style>
label.error {
	color: red;
	font-style: italic;
}

span.mandatory {
	color: red;
	font-style: italic;
}
</style>




  <style>
  
  

input.parsley-error,
select.parsley-error,
textarea.parsley-error {
  color: #B94A48;
  background-color: #F2DEDE;
  border: 1px solid #EED3D7;
}

.parsley-errors-list {
  margin: 2px 0 3px;
  padding: 0;
  list-style-type: none;
  font-size: 1.em;
  line-height: 0.9em;
  opacity: 0;
  color: #B94A48;

  transition: all .3s ease-in;
  -o-transition: all .3s ease-in;
  -moz-transition: all .3s ease-in;
  -webkit-transition: all .3s ease-in;
}

.parsley-errors-list.filled {
  opacity: 1;
}


.breadcrumb {
     
    padding: 2px 10px;
    margin-bottom: 2px;
    
}

.card-title {
    margin-bottom: 0px;
}

.h5  {
    margin-bottom: 2px;
   line-height: .5;
}




body{
	font-size: 12px !important;
}

.esi-inquiry .nav-link {
     
     
    font-size: 12px !important;
    
}

.btn {
    
    font-size: 12px !important;
 	height: 35px !important;
         
}
.left-menu label {
    font-size: 12px !important;
}

.left-menu input {
    font-size: 12px !important;
  height: 35px !important;
}
 
  </style>
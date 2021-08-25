<%--
-------------------------------------------------------------------------------------------------------------
EvgmDeclarationScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Tanaphol 08/08/2016
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>

<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Booking Inquiry | Regional Container Lines</title>
<!-- add screen specific JavaScript file -->
<link type="text/css" href="<%=lstrCtxPath%>/css/registration/common.css" rel="stylesheet">
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

<script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EvgmDeclaration.js?id=1" ></script>

<!-- add javascript file for this screen -->

  <script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
 
<style type="text/css">
.btnSamll {
  height: 30px !important;
  border-radius: 4px !important;
}

.btnColor{
	color:green;
}
</style>
<script type="text/javascript" language="JavaScript">
    var ON_LOAD = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001", pageContext)%>';
    var CHANGE_ACTION = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001change", pageContext)%>';
    var EXPORT_EXCEL = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001export", pageContext)%>';
    var UPLOAD_EXCEL = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001upload", pageContext)%>';
    var FIND_BOOKING = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001find", pageContext)%>';
    var GOTO_PAGING = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001paging", pageContext)%>';
    var DELETE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001del", pageContext)%>';
    var SAVE_VGM = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001save", pageContext)%>';
    var VALIDATE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001validate", pageContext)%>';
    var PRIVIEW_PDF_REPORT = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svgm001PreviewPDFReport", pageContext)%>';
</script>
<jsp:useBean id="evgmDeclarationUim" class="com.rclgroup.dolphin.rcl.web.eservice.actionform.EvgmDeclarationUim" scope="session"/>
</head>
<body onload="onLoad();">	
<!-- hidden field start-->
	<html:form method="POST" action="/svgm001" enctype="multipart/form-data" styleId="frm" >
    <html:hidden name="fevgm001" property="errMsg" styleId="errMsg"/>
    <html:hidden name="fevgm001" property="delItem" styleId="delItem" />
<!-- hidden field end -->	

<!-- Start Of Nav Bar -->
  <jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  <!-- End Of Nav Bar -->
     <nav aria-label="breadcrumb" class="mt-2" >
      <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page"><bean:message key="eVgm_Instructions.Create_by"/></li>
      </ol>
    </nav>
    <!-- Start Of Page -->
                 <div class="d-flex flex-md-row px-3 mt-4 mb-4 flex-column-reverse">
                      <div class="col-md-2 border-right">
                        <hr style="width:100%;text-align:left;margin-left:0"> 
                        <div class="card1 mt-5">
                          <ul id="progressbar" class="text-center">
                            <li class="active step0"></li>
                           </ul>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu progressbar-menu-active" style="width:55%;text-align:left;margin-left:10">
                              <strong style="width:25%;text-align:left;margin-left:10"><bean:message key="eVgm_Instructions.VGM"/></strong></a>
                          </h5>
                        </div>
                      </div>
                      <div class="col-md-9 mb-4" style="min-height: 700px;">
                        <jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>
						<logic:notEmpty name="fevgm001" property="errMsg">
								<b><font color="#ff0011">&nbsp; <bean:write name="fevgm001" property="errMsg" /></font></b>
						</logic:notEmpty>
						<hr style="width:100%;text-align:left;margin-left:0"> 
						
                       <div class="card2 first-screen show ml-2">
                          <h5 class="card-title">
                            <strong><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp; <bean:message key="eVgm_Instructions.Create_by"/> </strong>
					     </h5>
                        <hr style="width:100%;text-align:left;margin-left:0"> 
						  <div class="form-row">
								<div class="form-group col-md-4">
								  <div class="input-group">
									 <html:radio name="fevgm001" property="selectAction" value="1" onclick="changeAction()"></html:radio>&nbsp;
									<label> <bean:message key="eVgm_Instructions.manual_input"/></label>
								  </div> 
								 </div>
								<div class="form-group col-md-4">
									<logic:equal value="I" name="fevgm001" property="orgType">
											<html:radio name="fevgm001" property="selectAction" value="2" disabled="true"></html:radio>
											<bean:message key="eVgm_Instructions.excel_upload"/>(<a href="#" onclick="exportExcel();"><IMG border="0" alt="Export Template" src="<%=lstrCtxPath%>/images/IconExcel.jpg" width="16" height="16"> <bean:message key="eVgm_Instructions.excel_template"/></a>) 
									</logic:equal>

									 <logic:notEqual value="I" name="fevgm001" property="orgType">
												<html:radio name="fevgm001" property="selectAction" value="2"  onclick="changeAction()"></html:radio>
											<bean:message key="eVgm_Instructions.excel_upload"/>(<a href="#" onclick="exportExcel();"><IMG border="0" alt="Export Template" src="<%=lstrCtxPath%>/images/IconExcel.jpg" width="16" height="16"> <bean:message key="eVgm_Instructions.excel_template"/></a>) 
									  </logic:notEqual>
								</div>
							</div>                
							<hr style="width:100%;text-align:left;margin-left:0"> 


					<logic:equal value="1" name="fevgm001" property="selectAction">
							<div class="card2 first-screen show ml-2">
							  <h5 class="card-title">
								<strong>&nbsp; <bean:message key="eVgm_Instructions.party"/> </strong>
							</h5>
							                           
							<hr style="width:100%;text-align:left;margin-left:0"> 

								<div class="form-row">
									  <div class="form-group col-md-4">
									  <label><bean:message key="web_booking.Booking_Number" /> <span class="font_require">*</span> </label>
									   <html:text name="fevgm001" property="bookingNo" styleId="bookingNo" maxlength='17' style="width:80%" styleClass="form-control" onkeydown="gotoToSearchBooking();" />
									  </div>
									  <div class="form-group col-md-4"> <label><bean:message key="eVgm_Instructions.voyage"/> </label><br>
									  	
									  	<html:text name="fevgm001" property="displayVesslVoy" styleId="displayVesslVoy"  style="width:80%" styleClass="form-control" readonly="true"/>
									  
										   </div>
									  <div class="form-group col-md-4">
										  <label><bean:message key="eVgm_Instructions.shippername"/> </label>
										  <logic:notEmpty name="fevgm001" property="hdrSeq">
											<html:text name="fevgm001" property="shipperName" readonly="true" styleId="shipperName"  style="width:80%" styleClass="form-control" />
										  </logic:notEmpty>
										  <logic:empty name="fevgm001" property="hdrSeq">
												<html:text name="fevgm001" property="shipperName" styleId="shipperName"  style="width:80%" styleClass="form-control" />
										  </logic:empty>
									 </div>
							  </div>
				               <hr style="width:100%;text-align:left;margin-left:0"> 

							  <div class="form-row">
								 <div class="form-group  col-md-4">
									 <label><bean:message key="eVgm_Instructions.repname"/></label><br>
										<html:hidden name="fevgm001" property="respresentName" styleId="respresentName"/>
										<html:text name="fevgm001" property="respresentName" styleId="respresentName"  style="width:80%" styleClass="form-control" readonly="true"/>
									</div>
								<div class="form-group  col-md-4">
								  <label><bean:message key="eVgm_Instructions.authorize"/></label>
								  <logic:notEmpty name="fevgm001" property="hdrSeq">
										<html:text name="fevgm001" property="authorizePerson" styleId="authorizePerson" style="width:80%" styleClass="form-control" readonly="true" />
									</logic:notEmpty>
									<logic:empty name="fevgm001" property="hdrSeq">
										<html:text name="fevgm001" property="authorizePerson" styleId="authorizePerson"  style="width:80%" styleClass="form-control" />
									</logic:empty>
								</div>
								<div class="form-group  col-md-4">
								  <label><bean:message key="eVgm_Instructions.submit_date"/></label><br>
									<html:hidden name="fevgm001" property="submissionDate" styleId="submissionDate"/>
									<html:text name="fevgm001" property="submissionDate" styleId="submissionDate"  style="width:80%" styleClass="form-control" readonly="true"/>
									</div>
						     </div>
		                   <hr style="width:100%;text-align:left;margin-left:0"> 

						</div>
							 <logic:notEmpty name="fevgm001" property="vgmDetailList">
							  	  <h5 class="card-title text-primary"><bean:message key="eVgm_Instructions.details"/></h5>
									  <logic:notEmpty name="fevgm001" property="errMsg">
										<b><font color="#FF0000">&nbsp; <bean:write name="fevgm001" property="errMsg" /></font></b>
									</logic:notEmpty>
									  <div class="row card-secondary-content">
										<div class="col-md-12">
										  <div>
											<table class="table table-bordered  text-muted">
											  <thead>
												 <tr>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.seq"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.container"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.weight"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.verified_mass"/><span class="font_require">*</span></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.cargo_mass"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.tare"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.status"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.delete"/></th>
												</tr>
												  <%
													int currPage = evgmDeclarationUim.getCurrPageNo();
													int runNo = ((currPage * 10)-10) +1;
												  %>
											  </thead>
											  <tbody>
												<tr>
												 <logic:iterate id="list" name="fevgm001" property="displayDetailList" indexId="index" type='com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationDetailMod'>
													<tr>
														<logic:notEqual value="S" name="list" property="vgmStatus">
														<td class="tableColumnData" width="3%"><%=(runNo++)%></td>
														<td class="tableColumnData" width="17%">
															<html:text name="list" property="container" styleClass="form-control" styleId='<%="container"+index%>' readonly="true" > </html:text>
														</td>
														<td class="tableColumnData" width="10%">
															<html:select name="list" property="weightMethod" styleClass="form-control" styleId='<%= "weightMethod"+index%>' size="1" style="width:100px; " >
																	<html:optionsCollection name="fevgm001" value="code" label="name" property="methodList"/>
															</html:select>
														</td>
														<td class="tableColumnData" width="15%" style="text-align:right;"> 
															<html:text name="list" property="verGrossMass" styleClass="form-control" styleId='<%= "verGrossMass" + index %>'  onkeyup="inputFloatAndDec(this,2,false);" onblur="inputFloatAndDec(this,2,true);addComma(this);" onclick="this.select();" style="text-align:right;"> </html:text>
														</td>
														<td class="tableColumnData" width="15%" style="text-align:right;">
															<html:text name="list" property="grossCargo" styleClass="form-control" styleId='<%= "grossCargo" + index %>' onkeyup="inputFloatAndDec(this,2,false);" onblur="inputFloatAndDec(this,2,true);addComma(this);" onclick="this.select();" style="text-align:right;"> </html:text>
														</td>
														<td class="tableColumnData" width="15%" style="text-align:right;">
															<html:text name="list"  property="tareWeight" styleClass="form-control" styleId='<%= "tareWeight" + index %>' onkeyup="inputFloatAndDec(this,2,false);" onblur="inputFloatAndDec(this,2,true);addComma(this);" onclick="this.select();" style="text-align: right;"> </html:text>
														</td>
														<td class="tableColumnData" width="15%">
															<bean:write name="list" property="vgmStatusDesc"/>
															<html:hidden name="list" property="vgmStatus" styleClass="form-control" styleId='<%= "vgmStatus" + index %>'> </html:hidden>
														</td>
														<td class="tableColumnData" width="10%">
															
															<A href='javascript:void(0)' onclick='lp_delete(<%=(runNo)%>, this)' >
																<IMG border="0" alt="Delete" src="<%=lstrCtxPath%>/images/btnClose.gif" width="16" height="16">
															</A>
														   <%-- <html:checkbox name="list" property="selDelete" styleId='<%= "selDelete" + index %>' value="Y" style="border:0px;width:15px;height:15px;" onclick="lp_manageRepresentCompChkBox(2);" />&nbsp; --%>
														</td>
														</logic:notEqual>
														<logic:equal value="S" name="list" property="vgmStatus">
														<td class="tableColumnData" width="3%"><%=(runNo++)%></td>
														<td class="tableColumnData" width="17%">
															<html:text name="list" property="container" styleClass="form-control" styleId='<%="container"+index%>' readonly="true" > </html:text>
														</td>
														<td class="tableColumnData" width="10%">
															<html:hidden name="list" property="weightMethod" styleClass="form-control" styleId='<%= "weightMethod" + index %>'  > </html:hidden>
															<html:select name="list" property="weightMethod" styleClass="form-control" styleId='<%= "weightMethod"+index%>' size="1" disabled="true" style="width:100px; ">
																	<html:optionsCollection name="fevgm001" styleClass="form-control" value="code" label="name" property="methodList"/>
															</html:select>
														</td>
														<td class="tableColumnData" width="15%" style="text-align:right;">
															<html:text name="list" property="verGrossMass" styleClass="form-control" styleId='<%= "verGrossMass" + index %>'   readonly="true" style="text-align:right;"> </html:text>
														</td>
														<td class="tableColumnData" width="15%" style="text-align:right;">
															<html:text name="list" property="grossCargo" styleClass="form-control" styleId='<%= "grossCargo" + index %>'  readonly="true" style="text-align:right;"> </html:text>
														</td>
														<td class="tableColumnData" width="15%" style="text-align:right;">
															<html:text name="list"  property="tareWeight" styleClass="form-control" styleId='<%= "tareWeight" + index %>'  readonly="true" style="text-align:right;"> </html:text>
														</td>
														<td class="tableColumnData" width="15%">
															<bean:write name="list" property="vgmStatusDesc"/>
															<html:hidden name="list" property="vgmStatus" styleClass="form-control" styleId='<%= "vgmStatus" + index %>'  > </html:hidden>
														</td>
														<td class="tableColumnData" width="10%">
															
														</td>
														</logic:equal>
													</tr>
												</logic:iterate>
												</tr>
											  </tbody>
											</table>
										  </div>
										</div>
									  </div>
									</logic:notEmpty>
					</logic:equal>
					<logic:equal value="2" name="fevgm001" property="selectAction">
						<div class="card2 first-screen show ml-2">
							  <h5 class="card-title">
								<strong>&nbsp; <bean:message key="eVgm_Instructions.fileupload"/></strong>
							  </h5>
						    <hr style="width:100%;text-align:left;margin-left:0"> 
						</div>
						<div class="form-row">
							 <div class="form-group col-md-4">
								<label><bean:message key="eVgm_Instructions.fileupload"/></label>
								<html:file name="fevgm001" property="dataFile" styleId="dataFile" value="" />&nbsp; &nbsp;<INPUT TYPE="button" VALUE="Upload" NAME="btnUpload" CLASS="event_btnbutton" onClick='onUpload()'/>
							 </div>
						</div>
						<logic:notEmpty name="fevgm001" property="errorList">
							<br>
							<br>
							<br>
							<div class="card2 first-screen show ml-2">
								  <h5 class="card-title">
									<strong>&nbsp;<bean:message key="eVgm_Instructions.upload_error"/> </strong>
								  </h5>
							 <hr style="width:100%;text-align:left;margin-left:0"> 
							</div>
							 <div class="table-responsive">
											<table class="table table-bordered  text-muted">
											  <thead>
												<tr>
												  <th scope="col"><bean:message key="eVgm_Instructions.seq"/></th>
												  <th scope="col"><bean:message key="eVgm_Instructions.container"/></th>
												  <th scope="col"><bean:message key="eVgm_Instructions.description"/></th>
												</tr>
											  </thead>
											   <tbody>
												<tr>
											   <logic:iterate id="list" name="fevgm001" property="errorList" indexId="index"
													type='com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationErrorMod'>
														<tr>
															<td class="tableColumnData" width="10%"><%=(index+1)%></td>
															<td class="tableColumnData" width="10%"><bean:write name="list" property="container"/></td>
															<td class="tableColumnData" width="80%"><bean:write name="list" property="errorDesc"/></td>
														</tr>
												</logic:iterate>
												</tr>
												</tbody>
												</table>
								</div>
						</logic:notEmpty>
						 <logic:empty name="fevgm001" property="errorList">
							<logic:notEmpty name="fevgm001" property="vgmDetailList">
							   <div class="card2 first-screen show ml-2">
								  <h5 class="card-title">
									<strong>&nbsp; <bean:message key="eVgm_Instructions.party"/> </strong>
								  </h5>
								  <hr style="width:100%;text-align:left;margin-left:0"> 
								  <div class="form-row">
									  <div class="form-group col-md-4">
									  <label><bean:message key="web_booking.Booking_Number" /><span class="font_require">*</span> </label><br>
										<html:hidden name="fevgm001" property="bookingNo" styleClass="form-control" styleId="bookingNo"/>
										<bean:write name="fevgm001" property="bookingNo" />
									  </div>
									  <div class="form-group col-md-4"> <label><bean:message key="eVgm_Instructions.voyage"/></label><br>
										  <bean:write name="fevgm001" property="displayVesslVoy" />
									   </div>
									  <div class="form-group col-md-4">
										  <label><bean:message key="eVgm_Instructions.shippername"/> </label><br>
											<html:hidden name="fevgm001" property="shipperName" styleClass="form-control" styleId="shipperName"/>
											<bean:write name="fevgm001" property="shipperName" />
									   </div>
							      </div>
							 <hr style="width:100%;text-align:left;margin-left:0"> 
							  <div class="form-row">
								 <div class="form-group  col-md-4">
									 <label><bean:message key="eVgm_Instructions.repname"/></label><br>
										<html:hidden name="fevgm001" property="respresentName" styleClass="form-control" styleId="respresentName"/>
										<bean:write name="fevgm001" property="respresentName" />
								</div>
								<div class="form-group  col-md-4">
								  <label> <bean:message key="eVgm_Instructions.authorize"/></label><br>
										<html:hidden name="fevgm001" property="authorizePerson"  styleClass="form-control" styleId="authorizePerson"/>
										<bean:write name="fevgm001" property="authorizePerson" />
								</div>
								<div class="form-group  col-md-4">
								  <label><bean:message key="eVgm_Instructions.submit_date"/></label><br>
										<html:hidden name="fevgm001" property="submissionDate" styleClass="form-control" styleId="submissionDate"/>
										<bean:write name="fevgm001" property="submissionDate" />
								</div>
						     </div>
                           <hr style="width:100%;text-align:left;margin-left:0"> 
						</div>
						<br>
						<div class="row pt-1">
								<div class="col-8">
								  <div class="card">
									<div class="card-body">
									  <h5 class="card-title text-primary"><bean:message key="eVgm_Instructions.details"/></h5>
									  <div class="row card-secondary-content">
										<div class="col-md-12">
										  <div>
											<table class="table table-bordered  text-muted">
											  <thead>
												 <tr style="height:100px;">
												   <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.seq"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.container"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.weight"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.verified_mass"/><span class="font_require">*</span></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.cargo_mass"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.tare"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.status"/></th>
												  <th scope="col" style="vertical-align:top"><bean:message key="eVgm_Instructions.delete"/></th>
												</tr>
												  <%
													int currPage = evgmDeclarationUim.getCurrPageNo();
													int runNo = ((currPage * 10)-10) +1;
												  %>
											  </thead>
											  <tbody>
												<tr>
												<logic:iterate id="list" name="fevgm001" property="displayDetailList" indexId="index" type='com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationDetailMod'>
													<tr>
														<td class="tableColumnData" width="3%"><%=(runNo++)%></td>
														<td class="tableColumnData" width="17%">
															<bean:write name="list" property="container"/>
															<html:hidden name="list" property="container" styleClass="form-control" styleId='<%="container"+index%>' > </html:hidden>
														</td>
														<td class="tableColumnData" width="10%">
															<bean:write name="list" property="weightMethod"/>
															<html:hidden name="list" property="weightMethod" styleClass="form-control" styleId='<%="weightMethod"+index%>' > </html:hidden>
														</td>
														<td class="tableColumnData" width="15%">
															<bean:write name="list" property="verGrossMass"/>
															<html:hidden name="list" property="verGrossMass" styleClass="form-control" styleId='<%= "verGrossMass" + index %>'> </html:hidden>
														</td>
														<td class="tableColumnData" width="15%">
															<bean:write name="list" property="grossCargo"/>
															<html:hidden name="list" property="grossCargo" styleClass="form-control" styleId='<%= "grossCargo" + index %>'> </html:hidden>
														</td>
														<td class="tableColumnData" width="15%">
															<bean:write name="list" property="tareWeight"/>
															<html:hidden name="list"  property="tareWeight" styleClass="form-control" styleId='<%= "tareWeight" + index %>'> </html:hidden>
														</td>
														<td class="tableColumnData" width="15%">
															<bean:write name="list" property="vgmStatusDesc"/>
															<html:hidden name="list" property="vgmStatus" styleClass="form-control" styleId='<%= "vgmStatus" + index %>'> </html:hidden>
														</td>
														<td class="tableColumnData" width="10%">
														</td>
													</tr>
												</logic:iterate>
												</tr>
											  </tbody>
											</table>
										  </div>
										</div>

									  </div>
									</div>
								  </div>
								</div>
							   </div>
							</logic:notEmpty>
						</logic:empty>
					</logic:equal>
					<jsp:include page="../common/tiles/pagination.jsp">
						<jsp:param name="formName" value="fevgm001" />
					</jsp:include>
    <br>
    <br>
  </div>

<logic:notEmpty name="fevgm001" property="vgmDetailList">
    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
            <td align="right">
            <logic:equal value="1" name="fevgm001" property="selectAction">
                <logic:notEmpty name="fevgm001" property="hdrSeq">
                    <a class="m-btn sm blue rnd"
                        href="javascript:void(0)" onClick="return getPDF()">
                            <bean:message key="eVgm_Instructions.preview"/>
                        <i class="m-icon-swapdown m-icon-white"></i>
                    </a>
                </logic:notEmpty>
            </logic:equal>
            <logic:empty name="fevgm001" property="errorList">
            <logic:notEqual value="Y" name="fevgm001" property="allSuccess">
            <logic:notEqual value="I" name="fevgm001" property="orgType">
                <a class="m-btn sm green rnd"
                    href="javascript:void(0)" onClick="return submitVgm();">
                        <bean:message key="eVgm_Instructions.submit_vgm"/>
                    <i class="m-icon-swapright m-icon-white"></i>
                </a>
            </logic:notEqual>
            <logic:equal value="I" name="fevgm001" property="orgType">
                <a class="m-btn sm green rnd"
                    href="javascript:void(0)">
                        <bean:message key="eVgm_Instructions.submit_vgm"/>
                    <i class="m-icon-swapright m-icon-white"></i>
                </a>
            </logic:equal>
            </logic:notEqual>
            </logic:empty>
            </td>
        </tr>
    </table>
    </logic:notEmpty>
  <!-- End of Page --></div></div>

 </html:form>
</body>
</html>
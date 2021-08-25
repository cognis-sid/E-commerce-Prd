<%@page import="java.util.Date"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.niit.control.common.GlobalConstants"%>
<%@ page import="com.niit.control.web.action.BaseAction"%>
<%@ page import="com.niit.control.web.UserAccountBean"%>
<%@ page import="com.niit.control.common.StringUtil"%>
<%@ page import="com.niit.control.common.ComboVO"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="java.io.ByteArrayOutputStream"%>
<%@ page import="com.octo.captcha.service.CaptchaServiceException"%>
<%@ page errorPage="/pages/common/error/noWriteAccess.jsp" %>

<%@ page
	import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim"%>
<%@ page
	import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! String s1="sid" ; %>
<%
  String contextPath = request.getContextPath();
  
  
  String authPage = (String) request.getAttribute("authPage");
  if(authPage == null){
      authPage = "Auth";
  }
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>RCL Group</title>
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<script type="text/javascript" language="JavaScript"
	src="<%=contextPath%>/js/common/EserviceUtil.js?id=<%=new Date()%>"></script>
<script type="text/javascript"
	src="<%=contextPath%>/js/screen/EserviceRegistration.js?id=<%=new Date()%>"></script>
<script src="<%=contextPath%>/js/libraries/bootstrap-datetimepicker.js"></script>
<style>
.font_require {
	color: #ff0000;
	font-weight: bold;
}
</style>
<script type="text/javascript">
      (function(i, s, o, g, r, a, m) {
      	i['GoogleAnalyticsObject'] = r;
      	i[r] = i[r] || function() {
      		(i[r].q = i[r].q || []).push(arguments)
      	}, i[r].l = 1 * new Date();
      	a = s.createElement(o),
      		m = s.getElementsByTagName(o)[0];
      	a.async = 1;
      	a.src = g;
      	m.parentNode.insertBefore(a, m)
      })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
      ga('create', 'UA-39255240-1', 'rclgroup.com');
      ga('send', 'pageview');
    </script>
<script type="text/javascript">
     
     var CREATE_POL_POD   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333CreatePolPod", pageContext)%>';
     var ON_DELETE_POL_POD	= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333deletePolPod", pageContext)%>';
     var ON_POL_POD_EDIT   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333editPolPod", pageContext)%>';
     var ON_UPDATE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333updatePolPod", pageContext)%>';
     var GOTO_PAGING = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333paging", pageContext)%>';
	 var EXPORT_EXCEL = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333export", pageContext)%>';
	 var DOWNLOAD_EXCEL = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333exportdownload", pageContext)%>';
	 var POLPOD_SEARCH	= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333Search", pageContext)%>';
	 var CHANGE_ACTION = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333change", pageContext)%>';
	 var UPLOAD_EXCEL = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333upload", pageContext)%>'
		 
				</script>
<jsp:useBean id="esrvicePolPodPriorityUim"
	class="com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePolPodPriorityUim"
	scope="session" />

</head>
<body onload="onLoad();">

	<form action="/sexn333" method="POST" enctype="multipart/form-data" style="frm" >
		<html:hidden name="feserv333" property="errorMessage"
			styleId="errorMessage" />
		<!-- hidden field end -->

		<!-- Start Of Nav Bar -->
		<jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
		<!-- End Of Nav Bar -->
		<nav aria-label="breadcrumb" class="mt-2">
			<ol class="breadcrumb">
				<li class="breadcrumb-item active" aria-current="page"><bean:message
						key="eVgm_Instructions.Create_by" /></li>
			</ol>
		</nav>
		<!-- Start Of Page -->
		<div class="d-flex flex-md-row px-3 mt-4 mb-4 flex-column-reverse">
			<div class="col-md-2 border-right">
				<hr style="width: 100%; text-align: left; margin-left: 0">
				<div class="card1 mt-5">
					<ul id="progressbar" class="text-center">
						<li class="active step0"></li>
					</ul>
					<h5 class="mb-5">
						<a href="#" class="progressbar-menu progressbar-menu-active"
							style="width: 55%; text-align: left; margin-left: 10"> <strong
							style="width: 25%; text-align: left; margin-left: 10">Booking
								Priority</strong></a>
					</h5>
				</div>
			</div>
			<div class="col-md-9 mb-4" style="min-height: 700px;">
				<jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>

				<logic:notEmpty name="feserv333" property="errorMessage">
					<b><font color="#ff0011">&nbsp; <bean:write
								name="feserv333" property="errorMessage" /></font></b>
				</logic:notEmpty>
				<hr style="width: 100%; text-align: left; margin-left: 0">

				<div class="card2 first-screen show ml-2">
					<h5 class="card-title">
						<strong><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;
							Priority Details </strong>
					</h5>
					<hr style="width: 100%; text-align: left; margin-left: 0">
									
									
				<div class="form-row">
						<div class="form-group col-md-4">
							<div class="input-group">
								<html:radio name="feserv333" property="selectAction" value="1"
									onclick="changeAction()"></html:radio>
								&nbsp; <label> <bean:message
										key="eVgm_Instructions.manual_input" /></label>
							</div>
						</div>
						<div class="form-group col-md-4">
						
								<html:radio name="feserv333" property="selectAction" value="2"
									onclick="changeAction()"></html:radio>
								<bean:message key="eVgm_Instructions.excel_upload" />(<a
									href="#" onclick="exportExcel();"><IMG border="0"
									alt="Export Template"
									src="<%=contextPath%>/images/IconExcel.jpg" width="16"
									height="16"> Excel Template</a>) 
									
												  
						</div>
						
						<div class="form-group col-md-4">
								<c:if test="${requestScope.search!= null}">
						
										
									(<a
									href="#" onclick="downloadExcel();"><IMG border="0"
									alt="Export Template"
									src="<%=contextPath%>/images/IconExcel.jpg" width="16"
									height="16"> (Download POL</a>) 
									
								</c:if>
									  
						</div>
						
					</div>
					
					<hr style="width: 100%; text-align: left; margin-left: 0">
					
					<logic:equal value="1" name="feserv333" property="selectAction">
					
					<div class="form-row">
						<div class="form-group col-md-4"></div>
					</div>

					<div class="card2 first-screen show ml-2">
						<div class="form-row">
							<div class="form-group col-md-4">

								<label for="pol"><bean:message
										key="web_booking.Port_of_Loading_POL" /><span
									class="font_require">*</span></label>
								<div class="input-icons">

									<logic:notEmpty name="feserv333" property="pol">
									
									<c:if test="${requestScope.edit!= null}">
									 <input type="text" class="form-control input-field" name="pol" maxlength='10'
											disabled="disabled" value='<bean:write name="feserv333" property="pol" />'> 
									</c:if>

									<c:if test="${requestScope.edit== null}">
											<select class="form-control input-field  js-example-tags"
												name="pol" id="pol">
													<c:forEach var="countryCode" items="${feserv333.contryList}">

													<c:if test="${countryCode.code == feserv333.pol}">
														<option selected="selected" value="${countryCode.code}">${countryCode.contryName}-${countryCode.code}</option>
													</c:if>

													<c:if test="${countryCode.code != feserv333.pol}">
														<option value="${countryCode.code}">${countryCode.contryName}-${countryCode.code}</option>
													</c:if>

												</c:forEach>
											</select>
									</c:if>
									</logic:notEmpty>


										<logic:empty name="feserv333" property="pol">

											<select class="form-control input-field js-example-tags"
												name="pol" id="pol">
												<option selected="selected"
													value="<bean:write name="feserv333" property="pol" />"><bean:message
														key="search.Select_Pol" /></option>
												<c:forEach var="listValue" items="${feserv333.contryList}">
													<option value="${listValue.code}">${listValue.contryName}
														- ${listValue.code}</option>
												</c:forEach>
											</select>


										</logic:empty>



									</div>
							</div>

							<div class="form-group col-md-4">

								<label for="pod"><bean:message
										key="web_booking.Port_of_Discharge_POD" /><span
									class="font_require">*</span></label>
								<div class="input-icons">
									<logic:notEmpty name="feserv333" property="pod">
									
									<c:if test="${requestScope.edit!= null}">
									
										  <input type="text" class="form-control input-field" name="pod" maxlength='10'
											 disabled="disabled" value='<bean:write name="feserv333" property="pod"/>'>
									</c:if>	 
								
					  			<c:if test="${requestScope.edit== null}">
					  				<select class="form-control input-field  js-example-tags" name="pod" id="pod" >
										
										
										
									<c:forEach var="countryCode" items="${feserv333.contryList}">
									
									 <c:if test="${countryCode.code == feserv333.pod}">
										<option selected="selected" value="${countryCode.code}">${countryCode.contryName}-${countryCode.code}</option>
									</c:if>
									
									<c:if test="${countryCode.code != feserv333.pod}">
										<option  value="${countryCode.code}">${countryCode.contryName}-${countryCode.code}</option>
									</c:if>	
									
									</c:forEach>
					  			</select> 
					  			
										</c:if>	
									</logic:notEmpty>
									
								
									
									<logic:empty name="feserv333" property="pod">
									
										<%-- <input type="text" class="form-control input-field" name="pod"
											maxlength='10' id="pod"
											placeholder='<bean:message key="web_Booking_priority.pod"/>'> --%>
											
											 <select class="form-control input-field  js-example-tags" name="pod" id="pod" >
										<option selected="selected" value=""><bean:message key="search.Select_Pod" /></option>
									<c:forEach var="countryCode" items="${feserv333.contryList}">
										<option value="${countryCode.code}">${countryCode.contryName} - ${countryCode.code}</option>
									</c:forEach>
					  			</select> 
					  			
									</logic:empty>
								</div>
								
								
							</div>

							<div class="form-group  col-md-4">



								<label for="pot1"><bean:message
										key="web_booking.Port_of_Discharge_POT" /></label>
								<div class="input-icons">

									<logic:notEmpty name="feserv333" property="pot1">
										
										
										 <input type="text" class="form-control input-field" name="pot1" id="pot1" maxlength='10' value='<bean:write name="feserv333" property="pot1" />'  onblur="changeUpper(this)">

									</logic:notEmpty>
									<logic:empty name="feserv333" property="pot1">
										<input type="text" class="form-control input-field" name="pot1" id="pot1"  maxlength='10' placeholder='<bean:message key="web_Booking_priority.pot1"/>' onblur="changeUpper(this)" >

									</logic:empty>
								</div>
							</div>



						</div>

						<hr style="width: 100%; text-align: left; margin-left: 0">
					</div>
					<div class="form-row">


						<div class="form-group col-md-4">


							<label for="service"><bean:message
									key="web_booking_edit.Service" /><span class="font_require">*</span></label>
							<div class="input-icons">

								<logic:notEmpty name="feserv333" property="service">
								
										<input type="text" class="form-control input-field"
										name="service"
										 disabled="disabled" id="service" maxlength='10' value='<bean:write name="feserv333" property="service" />' onblur="changeUpper(this)">
								</logic:notEmpty>
								<logic:empty name="feserv333" property="service">
									<input type="text" class="form-control input-field" maxlength='10'
										name="service" maxlength='10' id="service"
										placeholder='<bean:message key="web_Booking_inquiry.service" />' onblur="changeUpper(this)">
								</logic:empty>
							</div>

						</div>


						<div class="form-group  col-md-4">

							<label for="vessel"><bean:message
									key="web_booking.Vessel" /></label>
							<div class="input-icons">

								<logic:notEmpty name="feserv333" property="vessel">
									<input type="text" class="form-control input-field"
										name="vessel" maxlength='10'
										value='<bean:write name="feserv333" property="vessel" />'>
								</logic:notEmpty>
								<logic:empty name="feserv333" property="vessel">
									<input type="text" class="form-control input-field"
										name="vessel" maxlength='10' id="vessel"
										placeholder='<bean:message key="web_booking.enter.Vessel" />'>
								</logic:empty>
							</div>


						</div>
						<div class="form-group  col-md-4">

							<label for="voyage"><bean:message
									key="web_booking.Voyage" /></label>
							<div class="input-icons">

								<logic:notEmpty name="feserv333" property="voyage">
									<input type="text" class="form-control input-field"
										name="voyage" maxlength='10'
										value='<bean:write name="feserv333" property="voyage" />'>
								</logic:notEmpty>
								<logic:empty name="feserv333" property="voyage">
									<input type="text" class="form-control input-field"
										name="voyage" maxlength='10' id="voyage"
										placeholder='<bean:message key="web_booking.enter.voyage" />'>
								</logic:empty>
							</div>
						</div>


						<hr style="width: 100%; text-align: left; margin-left: 0">

					</div>



					<div class="form-row">
						<%-- <div class="form-group  col-md-4">
								
									 <label for="bookingRef"><bean:message key="web_booking.BSA"/></label>
							          <div class="input-icons">
							            
							            <logic:notEmpty name="feserv333" property="bsa">
							            	<input type="text" class="form-control input-field" name="bsa" value= '<bean:write name="feserv333" property="bsa" />'>
										</logic:notEmpty>
									    <logic:empty name="feserv333" property="bsa">
											<input type="text" class="form-control input-field" name="bsa" maxlength='10' id="bsa" placeholder='<bean:message key="web_booking.enter.bsa" />'>
										</logic:empty>
									    </div>
								</div> --%>

						<div class="form-group  col-md-4">

							<label for="effdate"><bean:message
									key="Port.Effective_Date" /><span
									class="font_require">*</span></label>
							<div class="input-icons">

								<logic:notEmpty name="feserv333" property="effDate">

									<i class="fas fa-calendar-alt icon"></i>
									<input type="text"
										class="form-control  input-field date-picker"
										 disabled="disabled" value="${feserv333.effDate}" id="effDate" name="effDate">
								</logic:notEmpty>
								<logic:empty name="feserv333" property="effDate">


									<i class="fas fa-calendar-alt icon"></i>
									<input type="text"
										class="form-control  input-field date-picker" id="effDate"
										value="${feserv333.effDate}" name="effDate">
								</logic:empty>

							</div>


						</div>
						<div class="form-group  col-md-4">

							<label for="expdate"><bean:message
									key="Port.Expire_Date" /><span
									class="font_require">*</span></label>
							<div class="input-icons">

								<logic:notEmpty name="feserv333" property="expDate">

									<i class="fas fa-calendar-alt icon"></i>
									<input type="text"
										class="form-control  input-field date-picker" id="expDate"
										disabled="disabled" value="${feserv333.expDate}" required="required"
										name="expDate">

								</logic:notEmpty>
								<logic:empty name="feserv333" property="expDate">
									<i class="fas fa-calendar-alt icon"></i>
									<input type="text"
										class="form-control  input-field date-picker" id="expDate"
										value="${feserv333.expDate}" required="required"
										name="expDate">

								</logic:empty>
							</div>

						</div>



						<hr style="width: 100%; text-align: left; margin-left: 0">

						<div class="form-group  col-md-5">

							<%-- <div class="input-icons">
						            
						            <logic:notEmpty name="feserv333" property="ts">
						            	<input type="text" class="form-control input-field" name="ts" value= '<bean:write name="feserv333" property="ts" />'>
									</logic:notEmpty>
								    <logic:empty name="feserv333" property="ts">
										<input type="text" class="form-control input-field" name="ts" maxlength='10' id="ts" placeholder='<bean:message key="web_Booking_priority.enter.ts" />'>
									</logic:empty>
								    </div> --%>
						</div>
						<div class="form-group  col-md-4">
							<div class="float-center">
								<c:if test="${requestScope.edit.equals('edit')}">
									<button type="button" class="btn btn-primary next-button"
										onclick="updatepolpod()">
										<bean:message key="search.Submit" />
									</button>
									 <button type="button" class="btn btn-danger" onclick="onCancel()"><i class="fas fa-times"></i>&nbsp;<bean:message key="Shipping_Inquiry.cancel"/>
                    				</button>
								</c:if>

								<c:if test="${requestScope.edit== null}">
									<button type="button" class="btn btn-primary next-button"
										onclick="insertpolpod()">
										<bean:message key="search.Submit" />
									</button>
									 <button type="button" class="btn btn-primary next-button"
										onclick="getPolPodData()">
										<bean:message key="web_Booking_inquiry.Search" />
									</button> 

								</c:if>
								
								<button type="button" class="btn btn-primary next-button"
										onclick="getDefaultData()">
										Refresh
									</button> 
									
							</div>
						</div>


						<hr style="width: 100%; text-align: left; margin-left: 0">
					</div>
					<div>

						<div
							class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
							<div class="row card-secondary-content">
								<div class="col-md-12">
									<div>
										<table class="table table-bordered  text-muted">

											<logic:empty name="feserv333" property="errorMessage">

												<thead>
													<c:if test="${requestScope.listpolpod.size()>0}">

														<tr>
														<th scope="col" style="vertical-align: top"><bean:message
															key="eVgm_Instructions.seq" /></th>
															<th  scope="col" style="vertical-align: top"><bean:message
																	key="web_Booking_inquiry.pol" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_Booking_inquiry.pod" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_Booking_inquiry.pot" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_booking_edit.Service" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_booking.Vessel" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_booking.Voyage" /></th>
															<%-- <th scope="col" style="vertical-align: top"><bean:message
																	key="web_booking.BSA" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_Booking_priority.ts" /></th> --%>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="Port.Effective_Date" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="Port.Expire_Date" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="Shipping_Inquiry.edit" /></th>
															<th scope="col" style="vertical-align: top"><bean:message
																	key="web_Booking_inquiry.Action" /></th>
														</tr>

													
													</c:if>
												</thead>
												<tbody>
												<%
															int currPage = esrvicePolPodPriorityUim.getCurrPageNo();
														int runNo = ((currPage * 10) - 10) + 1;
														%>
		
		
												
													<c:if test="${requestScope.listpolpod.size()==0}">
														<div
															style="font-size: 20px; text-align: center; padding-top: 150px;">
															<strong>There is No data available.</strong>
														</div>
													</c:if>
													<c:forEach var="polpodList"
														items="${requestScope.listpolpod }"
														varStatus="loopCounter">
														
														<tr>
														   <td class="tableColumnData" width="3%"><%=(runNo++)%></td>
															<td class="tableColumnData">${polpodList.pol }</td>
															<td class="tableColumnData">${polpodList.pod }</td>
															<td class="tableColumnData">${polpodList.pot1 }</td>
															<td class="tableColumnData">${polpodList.service }</td>
															<td class="tableColumnData">${polpodList.vessel }</td>
															<td class="tableColumnData">${polpodList.voyage }</td>
															<%-- <td class="tableColumnData">${polpodList.bsa }</td>
															<td class="tableColumnData">${polpodList.ts }</td> --%>
															<td class="tableColumnData">${polpodList.effDate }</td>
															<td class="tableColumnData">${polpodList.expDate }</td>

															<td>
																<div class="btn-group float-right" role="group"
																	aria-label="Basic example">
																	<input type="hidden" class="form-control input-field"
																		name="pol" value="${polpodList.pol }">
																	<button type="button"
																		class="btn btn-outline-danger mr-2"
																		onclick="onpolpodEdit('${polpodList.pol }','${polpodList.pod }', '${polpodList.service }', '${polpodList.effDate}', '${polpodList.expDate}')">
																		<i class="fas fa-pen-square"></i>&nbsp;
																	</button>
																</div>
															</td>

															<td>
																<div class="btn-group float-right" role="group"
																	aria-label="Basic example">
																	<button type="button"
																		class="btn btn-outline-danger mr-2"
																		onclick="deletePolPod('${polpodList.pol }','${polpodList.pod }','${polpodList.service }', '${polpodList.effDate}', '${polpodList.expDate}')">
																		<i class="fas fa-trash"></i>
																	</button>
																</div>
															</td>

														</tr>
													</c:forEach>
												</tbody>
											</logic:empty>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					</logic:equal>
					
					<logic:equal value="2" name="feserv333" property="selectAction">
						<div class="card2 first-screen show ml-2">
							<h5 class="card-title">
								<strong>&nbsp; <bean:message
										key="eVgm_Instructions.fileupload" /></strong>
							</h5>
							<hr style="width: 100%; text-align: left; margin-left: 0">
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label><bean:message key="eVgm_Instructions.fileupload" /></label>
								<html:file name="feserv333" property="dataFile"
									styleId="dataFile" value="" />
								&nbsp; &nbsp;<INPUT TYPE="button" VALUE="Upload"
									NAME="btnUpload" CLASS="event_btnbutton" onClick='onUpload()' />
							</div>
						</div>
						
						<logic:notEmpty name="feserv333" property="errorList">
							<br>
							<br>
							<br>
							<div class="card2 first-screen show ml-2">
								<h5 class="card-title">
									<strong>&nbsp;<bean:message
											key="eVgm_Instructions.upload_error" />
									</strong>
								</h5>
								<hr style="width: 100%; text-align: left; margin-left: 0">
							</div>
							<div class="table-responsive">
								<table class="table table-bordered  text-muted">
									<thead>
										<tr>
											<th scope="col"><bean:message
													key="eVgm_Instructions.seq" /></th>
											<th scope="col"><bean:message
													key="eVgm_Instructions.description" /></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<logic:iterate id="list" name="feserv333" property="errorList"
												indexId="index"
												type='com.rclgroup.dolphin.rcl.web.eservice.vo.EBookingPriorityErrorMod'>
												<tr>
													<td class="tableColumnData" width="10%"><%=(index + 1)%></td>
													
													<td class="tableColumnData" width="80%"><bean:write
															name="list" property="errorDesc" /></td>
												</tr>
											</logic:iterate>
										</tr>
									</tbody>
								</table>
							</div>
						</logic:notEmpty>
					</logic:equal>
					<div class="clearfix"></div>


				</div>
				<div class="clearfix"></div>
			</div>
			<!-- End of Page -->
		</div>
	</form>
	<script>

	  $(document).ready(function () {
		    	debugger;
		     	/* $(".js-example-tags").select2({
			        tags: true
			      }); */
				 var  status='<bean:write name="feserv333" property="submitStatus"/>'
			 	 var effDate = new Date();
				 var configdate=Number(document.getElementById("effDate").value);
			 	if(status=='true'){
			 		effDate.setDate(effDate.getDate());
				}
			 	else{
			 		effDate.setDate(effDate.getDate()+configdate); 
				}
			
			  $('#effDate').datetimepicker({
		        format: 'DD/MM/YYYY',
				defaultDate: effDate,
				minDate : 	effDate,
		      }).on('dp.change', function (e) {
		        console.log(e.date);
		     
				});
	  
			 var expDate=new Date();
			 expDate.setDate(expDate.getDate());
			  
			  $('#expDate').datetimepicker({
		        format: 'DD/MM/YYYY',
				defaultDate : expDate,
				minDate : expDate,
		      });
		     // $('#expDate').data("DateTimePicker").date(expDate);
		
		 if(status=='true'){
			 swal('<bean:message key="ECM.GI0003"/>', 'Save Successful', "info");
		   		   }
	   		   
		      
			});
		
function insertpolpod(){
	debugger;
    var startDate = document.getElementById("effDate").value;
    var endDate = document.getElementById("expDate").value; 
	var pol = document.getElementById('pol').value;
    var pod = document.getElementById('pod').value;
    var pot = document.getElementById('pot1').value;
    var service = document.getElementById('service').value;
    var minLength = 5;

    var effdate = new Date();
    effdate= startDate;

    var exdate = new Date();
    exdate= endDate;

    if ((exdate <= effdate)) {
		swal('<bean:message key="logIn.Error"/>', 'Expire date should be greater than Effective date', "error");
        
    }
    else if(pot.length!= "" && pot.length < minLength){
		swal('<bean:message key="logIn.Error"/>', 'minimum 5 characters required for Port Of Transhipment', "error");
	}else{
   
    var url = CREATE_POL_POD;
    var errorMsg = null;
    try{
            loading();
            document.forms[0].action = url;
            document.forms[0].submit();
     } catch(errorMsg){
    	
      }    
    }
   
}

function updatepolpod(){
	debugger;
	var pot = document.getElementById('pot1').value;
	var minLength = 5;
	if(pot.length!= "" && pot.length < minLength){
		swal('<bean:message key="logIn.Error"/>', 'minimum 5 characters required for Port Of Transhipment', "error");
  	}else{
    var url = ON_UPDATE;
    var errorMsg = null;
    try{
        loading();
        document.forms[0].action = url;
        document.forms[0].submit();
      } catch(errorMsg){
    	 
      }    
	}
}

function isNullObj(obj){
    if(obj != null && obj != undefined){
        return false;
    }else{
        return true;
    }
}

function isBlank(objValue){
    if(objValue != null && objValue != undefined && objValue != ''){
        return false;
    }else{
        return true;
    }
}

function deletePolPod(pol,pod,service,effDate,expDate){
	debugger;
	var params   		= "?pol="+pol;
    params += "&pod="+pod;
    params +="&service="+service;
    params += "&effDate="+effDate;
	params += "&expDate="+expDate;
	var cancelBookingUrl = ON_DELETE_POL_POD+params;

	
	var result = confirm("Are You sure to delete?");
	if (result) {
	loading();
    document.forms[0].action = cancelBookingUrl;
    document.forms[0].submit();
	}
}



function onpolpodEdit(pol,pod,service,effDate,expDate) {
	debugger;
	loading();
	var params = "?pol=" + pol;
	params += "&pod="+pod;
	params += "&service="+service;
	params += "&effDate="+effDate;
	params += "&expDate="+expDate;
	
	var url = ON_POL_POD_EDIT;
	//alert(url+params)
	document.forms[0].action = url+params;
	document.forms[0].submit();

}


function exportExcel(){
	//alert(EXPORT_EXCEL);
    document.forms[0].action = EXPORT_EXCEL;
    document.forms[0].submit();
}


function downloadExcel(){
	 document.forms[0].action = DOWNLOAD_EXCEL;
    document.forms[0].submit();
}



function onUpload(){
    
    var data_file = document.getElementById("dataFile").value;
    if(data_file == ""){
        showBarMessage("Please Choose file to Upload.", MSG_ERROR_CODE);
    }else{
    
    
        document.forms[0].action = UPLOAD_EXCEL;
        document.forms[0].submit();
    }
}

function getPolPodData(){
    try{  
    	debugger;
		loading();
        var url = POLPOD_SEARCH;
        document.forms[0].action= url;
         document.forms[0].submit();
    }catch(err){
          txt+="Click OK to continue.";
          alert(txt);
    }    
} 

function changeAction(){
	 var url = CHANGE_ACTION;
	//alert(url)
    document.forms[0].action =url ;
    document.forms[0].submit();
}

function onCancel(){
	 var serverUrl = "<%=contextPath%>"+"/do/sexn333";
     document.forms[0].action = serverUrl;
     document.forms[0].submit();

	}

function getDefaultData(){
	 var serverUrl = "<%=contextPath%>"+"/do/sexn333";
     document.forms[0].action = serverUrl;
     document.forms[0].submit();
}

function changeUpper(afield)
{
    afield.value = afield.value.toUpperCase();
}


</script>
</body>
</html>
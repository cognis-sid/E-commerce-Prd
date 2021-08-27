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
<title>Booking Inquiry | Regional Container Lines</title>
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<!-- add screen specific JavaScript file -->
<script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

<script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>

<!-- add javascript file for this screen -->
<script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingInquiryNew.js?<%=new Date() %>" ></script>

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
    	var CHECK_BOOKING_RATETYPE_CHECK				 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn012BookingRateTypeCheck", pageContext) %>';
    	var CHECK_EDIT_CONTAINER				         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn012EditBookingContainerBooking", pageContext) %>';
    	var ON_CANCEL_BOOKING_SI 						 = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002Cancel", pageContext) %>';
    </script>
    
    <script language="JavaScript">
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-39255240-1', 'rclgroup.com');
      ga('send', 'pageview');
    </script>
    
</head>

<body onload="onLoad();">
		<form method="POST" action="/sexn010">
  <!-- Start Of Nav Bar -->
  <jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  <!-- End Of Nav Bar -->
  	 <input type="hidden" name="loginDateCheck" id="loginDateCheck"  value="${sessionScope.sUserAccountBean.dateFormat}"/>
     <input type="hidden" name="statusValidater" id="statusValidater" value="${feserv06.esiStatusCode }"/>	
  	 <input type="hidden" name="errorMsg" id="errorMsg" value="${requestScope.listShippingError }"/>	
     <input type="hidden" name="dateConfigesi" id="dateConfigesi" value="${sessionScope.sUserAccountBean.dateConfigesi }"/>
   
  <div class="rcl-content">
    <nav aria-label="breadcrumb" class="mt-2">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="dashboard.html"><bean:message key="Shipping_Inquiry.home"/></a></li>
        <li class="breadcrumb-item"><a href="web-booking.html"><bean:message key="Shipping_Inquiry.webBooking"/></a></li>
        <li class="breadcrumb-item active" aria-current="page"><bean:message key="Shipping_Inquiry.shippingInquiry"/></li>
      </ol>
    </nav>
    <!-- Start Of Page -->
    <div class="content-container content-height ">
      <div class="left-menu pt-3">
        <div class="form-group">
          <label for="bookingNumber"><bean:message key="Shipping_Inquiry.bookingNumber"/></label>
          <div class="input-icons">
            <i class="fas fa-list-ol icon"></i>
            <input type="text" id="BKGNoSearch" class="form-control input-field" id="bookingNumber" aria-describedby="emailHelp"
              placeholder='<bean:message key="Shipping_Inquiry.Enter_Booking_Number"/>'>
          </div>
        </div>
        <div class="form-group">
          <label for="blNumber"><bean:message key="Shipping_Inquiry.blNumber"/></label>
          <div class="input-icons">
            <i class="fas fa-list-ol icon"></i>
            <input type="text" class="form-control input-field" id="searchBlBtn" aria-describedby=""
              placeholder='<bean:message key="Shipping_Inquiry.Enter_BL_Number"/>'>
          </div>
        </div>
        <%-- <div class="form-group">
          <label for="customerRef"><bean:message key="Shipping_Inquiry.customerRef"/></label>
          <div class="input-icons">
            <i class="fas fa-list-ol icon"></i>
            <input type="text" class="form-control input-field" id="customerRef" aria-describedby="emailHelp"
              placeholder="Enter Customer Ref">
          </div>
        </div> --%>
        <div class="form-group">
          <label for="orderStatus"><bean:message key="Shipping_Inquiry.eSIStatus"/></label>
          <select class="form-control" id="esiStatusSearch">
            <option  selected value=''><bean:message key="Shipping_Inquiry.choose"/></option>
            <option  value='N'><bean:message key="Shipping_Inquiry.new"/></option>
            <option value='E'><bean:message key="Shipping_Inquiry.inProgress"/></option>
            <option value='S'><bean:message key="Shipping_Inquiry.submitted"/></option>
            <option value='C'><bean:message key="Shipping_Inquiry.confirm"/></option>
          </select>
        </div>

        <button type="button" onclick="getSearchBookingData()" class="btn btn-light-blue btn-block"><bean:message key="Shipping_Inquiry.search"/></button>
      </div>
      <div class="right-menu">
        <div class="">
        <jsp:include page="../../pages/common/cognis/alertInfo.jsp"></jsp:include>  
         <!--  <div class="row right-row  ml-1 mr-1"> -->
            <%-- <div class="col-md-1 border-right d-flex align-items-center">
              <h5><strong><bean:message key="Shipping_Inquiry.sortBy"/></strong></h5>
            </div> --%>

            <%-- <div class="col-md-1 border-right cursor-pointer active">
              <h5><strong><bean:message key="Shipping_Inquiry.duration"/></strong></h5>
               <h6><bean:message key="Shipping_Inquiry.long"/> &#8594;<bean:message key="Shipping_Inquiry.short"/> </h6>
            </div> --%>
            <%-- <div class="col-md-1 border-right cursor-pointer">
               <h5><strong><bean:message key="Shipping_Inquiry.etd"/></strong></h5>
              <h6><bean:message key="Shipping_Inquiry.low"/> &#8594; <bean:message key="Shipping_Inquiry.high"/></h6>
            </div> --%>
            <%-- <div class="col-md-1 border-right cursor-pointer">
              <h5><strong><bean:message key="Shipping_Inquiry.eta"/></strong></h5>
              <h6><bean:message key="Shipping_Inquiry.low"/> &#8594; <bean:message key="Shipping_Inquiry.high"/></h6>
            </div> --%>
           <%--  <div class="col-md-1 cursor-pointer">
             <h5><strong><bean:message key="Shipping_Inquiry.bookings"/></strong></h5>
              <h6><bean:message key="Shipping_Inquiry.a"/> &#8594; <bean:message key="Shipping_Inquiry.z"/></h6>
            </div> --%>
            <%-- <div class="col-md-7">
              <div class="dropdown show  float-right pt-3">
                <a class="dropdown-toggle" href="#" role="button" id="moreSortOptionDropdown" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false">
                  <bean:message key="Shipping_Inquiry.more"/>
                </a>
                <div class="dropdown-menu  dropdown-menu-right" aria-labelledby="moreSortOptionDropdown">
                  <a class="dropdown-item" href="#">Sort 1</a>
                  <a class="dropdown-item" href="#">Sort 2</a>
                  <a class="dropdown-item" href="#">Sort 3</a>
                </div>
              </div>
            </div> --%>
         <!--  </div> -->
          <div class="row right-row mt-3 ml-1 mr-1 p-0">
            <div class="col-12  p-0">
              <ul class="nav nav-pills nav-justified esi-inquiry"  id="pills-tab" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="pills-open-orders-tab" onclick="getNewStatus()" data-toggle="pill" href="#pills-open-orders"
                    role="tab" aria-controls="pills-open-orders" aria-selected="true"><i
                      class="fas fa-envelope-open"></i> &nbsp;
                    <bean:message key="Shipping_Inquiry.newShipping"/></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="pills-entry-orders-tab" onclick="getEntryStatus()" data-toggle="pill" href="#pills-entry-orders"
                    role="tab" aria-controls="pills-entry-orders" aria-selected="false"><i
                      class="fas fa-check-circle"></i>
                    &nbsp;<bean:message key="Shipping_Inquiry.inProgressShipping"/></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="pills-submited-orders-tab" onclick="getSubmitedStatus()" data-toggle="pill" href="#pills-submited-orders"
                    role="tab" aria-controls="pills-submited-orders" aria-selected="false"><i
                      class="fas fa-trash-alt"></i>
                    &nbsp;<bean:message key="Shipping_Inquiry.submittedShipping"/></a>
                </li>
              </ul>
            </div>
          </div>
          <div class="tab-content" id="pills-tabContent">
            <!-- Open Orders tab starts here -->
            <div class="tab-pane fade show active" id="pills-open-orders" role="tabpanel"
              aria-labelledby="pills-open-orders-tab">
              <!-- You ROW Starts here, to repeat just copy and paste the same div again and again -->
              <c:if test="${requestScope.listShipping.size()==0}" >
              				<div style="font-size:20px; text-align:center;padding-top:150px;"><strong><bean:message key="Shipping_Inquiry.There_is_no_New_Booking"/></strong></div>
              			</c:if>
              <c:forEach var = "bookingList" items="${requestScope.listShipping }"  varStatus="loopCounter">
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row">
                  <div class="col-11">
                   <%-- <h6><strong><bean:message key="Shipping_Inquiry.ref"/></strong> <span class="text-muted"><bean:message key="Shipping_Inquiry.fcl"/></span></h6> --%>
                  </div>
                  <div class="col-1">
                    <a data-toggle="collapse" href="#orderSummaryNew${bookingList.bookingNo}" role="button" onclick="getMoreShippingData(${loopCounter.count})" aria-expanded="false"
                      aria-controls="orderSummaryNew${bookingList.bookingNo}" id="MoreN_${loopCounter.count}">
                      <bean:message key="Shipping_Inquiry.more"/> <i class="fa fa-angle-up" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="row distance-details">
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                     <bean:message key="Shipping_Inquiry.estDepartureDate"/>
                    </div>
                    <div id="estDepartureDate${bookingList.bookingNo}"><strong>${bookingList.sailingDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                     <bean:message key="Shipping_Inquiry.estArrivalDate"/>
                    </div>
                    <div ><strong>${bookingList.desiredArrivalDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                      <bean:message key="Shipping_Inquiry.bookingRef"/>
                    </div>
                    <div id="bookingNo${loopCounter.count }"><strong>${bookingList.bookingNo }</strong></div>
                  </div>
                  <div class="col-md-6 border-left  d-flex justify-content-end">
                    <div class="btn-group" role="group" aria-label="Basic example">
                      <button type="button" class="btn btn-success  mr-2"  disabled><i class="fas fa-file"></i>&nbsp;
                        <bean:message key="Shipping_Inquiry.preview"/></button>
                      <a   class="btn btn-secondary mr-2" onclick="onEshippingInstructionLoad('${bookingList.bookingNo }')" style="color:white;"><i
                          class="fas fa-train"></i>&nbsp;
                         <bean:message key="Shipping_Inquiry.shipping"/></a>
                      <%-- <c:choose>
						<c:when test="${bookingList.countContaine == 0}"> --%>
							<%-- <button type="button" class="btn btn-info mr-2"
								onclick="onBookingEdit('${bookingList.bookingNo }')">
								<i class="fas fa-pen-square"></i>&nbsp;
								<bean:message key="Shipping_Inquiry.edit" />
							</button> --%>
						<%-- </c:when>
						<c:otherwise >
							<button type="button" class="btn btn-info mr-2">
								<i class="fas fa-pen-square"></i>&nbsp;
								<bean:message key="Shipping_Inquiry.edit" />
							</button>
						</c:otherwise>
					</c:choose>	 --%>
                     <button type="button" class="btn btn-danger" onclick="onCancel('${bookingList.bookingNo }')"><i class="fas fa-times"></i>&nbsp; <bean:message key="Shipping_Inquiry.cancel"/>
                     </button>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSummaryNew${bookingList.bookingNo}">
                  <div class="row text-muted">
                    <div class="col-md-4">
                      <div class="d-flex text-small">
                         <bean:message key="Shipping_Inquiry.pol"/> 
                      </div>
                      <div class="d-flex text-small" id="fromO_${bookingList.bookingNo }">
                      <strong>${bookingList.portOfLoadingDes}</strong>
                      </div>
                    </div>
                    <div class="col-md-4  border-left">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.pod"/>
                      </div>
                      <div class="d-flex text-small" id="toO_${bookingList.bookingNo }">
                      <strong>${bookingList.portOfDischargeDess}</strong>
                      </div>
                    </div>
                    <div class="col-md-4  border-left">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.vesselEta"/>
                      </div>
                      <div class="d-flex text-small" id="vesselETAO_${bookingList.bookingNo }">
                      <strong>${bookingList.vesseletd}</strong>
                      </div>
                    </div>
                  </div>
                  <hr />
                  <div class="row text-muted">
                    <div class="col-md-6">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.from"/>
                      </div>
                      <div class="d-flex text-small"  id="fromTerminalO_${bookingList.bookingNo }">
                      </div>
                    </div>
                    <div class="col-md-6 border-left">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.to"/>
                      </div>
                      <div class="d-flex text-small" id="toTerminalO_${bookingList.bookingNo }">
                      </div>
                    </div>
                  </div>
                </div>
                <!-- <div class="row bg-light pt-2 pb-0">
                  <div class="col-12 pl-0 pr-0">
                    
                  </div>
                </div> -->
                <div class="row bg-light pt-2 pb-0">
                  <div class="col-12 pl-0 pr-0">
                   <div class="md-stepper-horizontal pt-0 pb-0 green">
                   <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='R' || bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">${bookingList.resivedDate }</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/>  </div>
                        <div class="md-step-optional">${bookingList.loadedDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/>  </div>
                        <div class="md-step-optional">${bookingList.onBoardDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSummaryNew${bookingList.bookingNo}">
                  <div class="row">
                    <div class="col-12">
                      <h5><strong><bean:message key="Shipping_Inquiry.orderSummary"/><span class="text-muted"></span></strong></h5>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.customerDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.shipper"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="shipperO_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.consignee"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="consigneeO_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.notifyParty"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="notifyO_${bookingList.bookingNo}">
                              </div>
                            </div>
                            
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row pt-3">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.routingSchedule"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.PORT_OF_LOADING"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofloadingO_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.PORT_OF_DISCHARGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofdischargeO_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.VESSEL_VOYAGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="vesselVoyageO_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.TRANSHIP_PORT"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="transhipportO_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row pt-3">
                     <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.EquipmentCommodityDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12">
                              <div class="table-responsive">
                                <table class="table table-bordered  text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.ContainerSealMarks"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.NoOfContainersType"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.DescriptionGoodsWeight"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.GrossWeightMeasurement"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td id="containerNoSealNoMarksNoO_${bookingList.bookingNo }"></td>
                                      <td id="containersTypeO_${bookingList.bookingNo }"></td>
                                      <td id="descriptionofGoodsNetWeightO_${bookingList.bookingNo }"></td>
                                      <td id="grossweightmeasurementO_${bookingList.bookingNo }"></td>
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
                  <div class="row pt-3">
                <%--     <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.PaymentDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12 text-muted">
                              <div class="table-responsive">
                                <table class="table table-bordered text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.ChargeCode"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.ChargeCodeDescription"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Currency"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Rate"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Basis"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Amount"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <th scope="row">40000</th>
                                      <td>D/O FEE (PER B/L), P</td>
                                      <td>IRR</td>
                                      <td>3,200,000.00</td>
                                      <td>Lumpsum</td>
                                      <td>3,200,000.00</td>
                                    </tr>
                                    <tr>
                                      <th scope="row">40000</th>
                                      <td>D/O FEE (PER B/L), P</td>
                                      <td>IRR</td>
                                      <td>3,200,000.00</td>
                                      <td>Lumpsum</td>
                                      <td>3,200,000.00</td>
                                    </tr>
                                  </tbody>
                                </table>
                              </div>
                            </div>

                          </div>
                        </div>
                      </div>
                    </div> --%>
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>
            <!-- Open Orders tab closes here -->
            <div class="tab-pane fade" id="pills-entry-orders" role="tabpanel"
              aria-labelledby="pills-entry-orders-tab">
              <!-- Incase you want to repeat Entry Orders repeat this tab -->
              <c:if test="${requestScope.listShipping.size()==0}" >
              				<div style="font-size:20px; text-align:center;padding-top:150px;"><strong><bean:message key="Shipping_Inquiry.There_is_no_Entry_Booking"/></strong></div>
              </c:if>
              <c:forEach var = "bookingList" items="${requestScope.listShipping }"  varStatus="loopCounter">
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row">
                  <div class="col-11">
                    <%-- <h6><strong><bean:message key="Shipping_Inquiry.ref"/></strong> <span class="text-muted"><bean:message key="Shipping_Inquiry.fcl"/></span></h6> --%>
                  </div>
                  <div class="col-1">
                    <a data-toggle="collapse" href="#orderEntry${bookingList.bookingNo}" role="button" onclick="getMoreShippingData(${loopCounter.count})" aria-expanded="false"
                      aria-controls="orderEntry${bookingList.bookingNo}" id="MoreE_${loopCounter.count}">
                       <bean:message key="Shipping_Inquiry.more"/> <i class="fa fa-angle-up" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="row distance-details">
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                      <bean:message key="Shipping_Inquiry.estDepartureDate"/>
                    </div>
                    <div><strong>${bookingList.sailingDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                    <bean:message key="Shipping_Inquiry.estArrivalDate"/>
                    </div>
                    <div ><strong>${bookingList.desiredArrivalDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                       <bean:message key="Shipping_Inquiry.bookingRef"/> 
                    </div>
                    <div id="bookingNo${loopCounter.count }"><strong>${bookingList.bookingNo }</strong></div>
                  </div>
                  <div class="col-md-6 border-left  d-flex justify-content-end">
                    <div class="btn-group" role="group" aria-label="Basic example">
                      <button type="button" class="btn btn-success  mr-2"  onclick="return generatePdf('${bookingList.bookingNo }',' ')" ><i class="fas fa-file"></i>&nbsp;
                        <bean:message key="Shipping_Inquiry.preview"/> </button>
                      <a class="btn btn-secondary mr-2" onclick="onEshippingInstructionLoad('${bookingList.bookingNo }')" style="color:white;"><i
                          class="fas fa-train"></i>&nbsp;
                        <bean:message key="Shipping_Inquiry.shipping"/></a>
                      <%-- <c:choose>
						<c:when test="${bookingList.countContaine == 0}">
							<button type="button" class="btn btn-info mr-2"
								onclick="onBookingEdit('${bookingList.bookingNo }')">
								<i class="fas fa-pen-square"></i>&nbsp;
								<bean:message key="" />
							</button>
						</c:when>
						<c:otherwise >
							<button type="button" class="btn btn-info mr-2">
								<i class="fas fa-pen-square"></i>&nbsp;
								<bean:message key="Shipping_Inquiry.edit" />
							</button>
						</c:otherwise>
					</c:choose> --%>	
                    <button type="button" class="btn btn-danger" onclick="onCancel('${bookingList.bookingNo }')"><i class="fas fa-times"></i>&nbsp;<bean:message key="Shipping_Inquiry.cancel"/>
                    </button>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderEntry${bookingList.bookingNo}">
                  <div class="row text-muted">
                    <div class="col-md-4">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.pol"/>
                      </div>
                      <div class="d-flex text-small" id="fromE_${bookingList.bookingNo }">
                      <strong>${bookingList.portOfLoadingDes}</strong>
                      </div>
                    </div>
                    <div class="col-md-4  border-left">
                      <div class="d-flex text-small">
                       <bean:message key="Shipping_Inquiry.pod"/>
                      </div>
                       <div class="d-flex text-small" id="toE_${bookingList.bookingNo }">
                       <strong>${bookingList.portOfDischargeDess}</strong>
                      </div>
                    </div>
                    <div class="col-md-4  border-left">
                      <div class="d-flex text-small">
                       <bean:message key="Shipping_Inquiry.vesselEta"/> 
                      </div>
                      <div class="d-flex text-small" id="vesselETAE_${bookingList.bookingNo }">
                      <strong>${bookingList.vesseletd}</strong>
                      </div>
                    </div>
                  </div>
                  <hr />
                  <div class="row text-muted">
                    <div class="col-md-6">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.from"/>
                      </div>
                      <div class="d-flex text-small"  id="fromTerminalE_${bookingList.bookingNo }">
                      </div>
                    </div>
                    <div class="col-md-6 border-left">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.to"/>
                      </div>
                      <div class="d-flex text-small" id="toTerminalE_${bookingList.bookingNo }">
                      </div>
                    </div>
                  </div>
                </div>
				<div class="row bg-light pt-2 pb-0">
                  <div class="col-12 pl-0 pr-0">
                   <div class="md-stepper-horizontal pt-0 pb-0 green">
                   <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='R' || bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">${bookingList.resivedDate }</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/>  </div>
                        <div class="md-step-optional">${bookingList.loadedDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/>  </div>
                        <div class="md-step-optional">${bookingList.onBoardDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderEntry${bookingList.bookingNo}">
                  <div class="row">
                    <div class="col-12">
                      <h5><strong><bean:message key="Shipping_Inquiry.orderSummary"/><span class="text-muted"></span> </strong></h5>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.customerDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.shipper"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="shipperE_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.consignee"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="consigneeE_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.notifyParty"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="notifyE_${bookingList.bookingNo}">
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row pt-3">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.routingSchedule"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.PORT_OF_LOADING"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofloadingE_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.PORT_OF_DISCHARGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofdischargeE_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.VESSEL_VOYAGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="vesselVoyageE_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                               <strong><bean:message key="Shipping_Inquiry.TRANSHIP_PORT"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="transhipportE_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row pt-3">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.EquipmentCommodityDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12">
                              <div class="table-responsive">
                                <table class="table table-bordered  text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.ContainerSealMarks"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.NoOfContainersType"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.DescriptionGoodsWeight"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.GrossWeightMeasurement"/></th>

                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td id="containerNoSealNoMarksNoE_${bookingList.bookingNo }"></td>
                                      <td id="containersTypeE_${bookingList.bookingNo }"></td>
                                      <td id="descriptionofGoodsNetWeightE_${bookingList.bookingNo }"></td>
                                      <td id="grossweightmeasurementE_${bookingList.bookingNo }"></td>
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
                  <div class="row pt-3">
                   <%--  <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.PaymentDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12 text-muted">
                              <div class="table-responsive">
                                <table class="table table-bordered text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.ChargeCode"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.ChargeCodeDescription"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Currency"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Rate"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Basis"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.Amount"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <th scope="row">40000</th>
                                      <td>D/O FEE (PER B/L), P</td>
                                      <td>IRR</td>
                                      <td>3,200,000.00</td>
                                      <td>Lumpsum</td>
                                      <td>3,200,000.00</td>
                                    </tr>
                                    <tr>
                                      <th scope="row">40000</th>
                                      <td>D/O FEE (PER B/L), P</td>
                                      <td>IRR</td>
                                      <td>3,200,000.00</td>
                                      <td>Lumpsum</td>
                                      <td>3,200,000.00</td>
                                    </tr>
                                  </tbody>
                                </table>
                              </div>
                            </div>

                          </div>
                        </div>
                      </div>
                    </div> --%>
                  </div>
                </div>
              </div>
              </c:forEach>
              <!-- Incase you want to repeat Completed Orders repeat this tab -->
            </div>
            <div class="tab-pane fade" id="pills-submited-orders" role="tabpanel"
              aria-labelledby="pills-submited-orders-tab">
              <!-- Incase you want to repeat Cancelled Orders repeat this tab -->
              <c:if test="${requestScope.listShipping.size()==0}" >
              				<div style="font-size:20px; text-align:center;padding-top:150px;"><strong><bean:message key="Shipping_Inquiry.There_is_no_Submit_Confirm_Booking"/></strong></div>
              </c:if>
               <c:forEach var = "bookingList" items="${requestScope.listShipping }"  varStatus="loopCounter">
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row">
                  <div class="col-11">
                    <%-- <h6><strong><bean:message key="Shipping_Inquiry.ref"/></strong> <span class="text-muted"><bean:message key="Shipping_Inquiry.fcl"/></span></h6> --%>
                  </div>
                  <div class="col-1">
                    <a data-toggle="collapse" href="#orderSubmited${bookingList.bookingNo}" role="button" onclick="getMoreShippingData(${loopCounter.count})" aria-expanded="false"
                      aria-controls="orderSubmited${bookingList.bookingNo}" id="MoreS_${loopCounter.count}">
                       <bean:message key="Shipping_Inquiry.more"/> <i class="fa fa-angle-up" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="row distance-details">
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                      <bean:message key="Shipping_Inquiry.estDepartureDate"/>
                    </div>
                    <div><strong>${bookingList.sailingDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                     <bean:message key="Shipping_Inquiry.estArrivalDate"/>
                    </div>
                    <div ><strong>${bookingList.desiredArrivalDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                    <bean:message key="Shipping_Inquiry.bookingRef"/> 
                    </div>
                    <div id="bookingNo${loopCounter.count }"><strong>${bookingList.bookingNo }</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                    <bean:message key="Shipping_Inquiry.blNumber"/> 
                    </div>
                    <div id="bookingNo${loopCounter.count }"><strong>${bookingList.blNumber }</strong></div>
                  </div>
                  
                  <div class="col-md-4 border-left text-danger d-flex justify-content-center">
                 <div style="width:100%;margin-top:10px;height:60px"> 
                    <div class="md-stepper-horizontal pt-0 pb-0 green" style="width:50px;height:50px;float:left;margin-top:-35px;margin-left:100px;background-color:transparent;">
                   <c:choose>
                    <c:when  test="${bookingList.shippingSplStatus == 'C'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"> <bean:message key="Shipping_Inquiry.confirm"/> </div>
                        <div class="md-step-optional">${bookingList.confirmDate }</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"> <bean:message key="Shipping_Inquiry.submitted"/> </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                    </div>
                    <button type="button" class="btn btn-success  mr-2" style="float:right" onclick="return generatePdf('${bookingList.bookingNo }','${bookingList.blNumber }')"><i class="fas fa-file"></i>&nbsp;
                        <bean:message key="Shipping_Inquiry.preview"/></button>
                  </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSubmited${bookingList.bookingNo}">
                  <div class="row text-muted">
                    <div class="col-md-4">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.pol"/>
                      </div>
                      <div class="d-flex text-small" id="fromS_${bookingList.bookingNo }">
                      <strong>${bookingList.portOfLoadingDes}</strong>
                      </div>
                    </div>
                    <div class="col-md-4  border-left">
                      <div class="d-flex text-small">
                         <bean:message key="Shipping_Inquiry.pod"/>
                      </div>
                       <div class="d-flex text-small" id="toS_${bookingList.bookingNo }">
                       <strong>${bookingList.portOfDischargeDess}</strong>
                      </div>
                    </div>
                    <div class="col-md-4  border-left">
                      <div class="d-flex text-small">
                         <bean:message key="Shipping_Inquiry.vesselEta"/> 
                      </div>
                      <div class="d-flex text-small" id="vesselETAE_${bookingList.bookingNo }">
                      <strong>${bookingList.vesseletd}</strong>
                      </div>
                    </div>
                  </div>
                  <hr />
                  <div class="row text-muted">
                    <div class="col-md-6">
                      <div class="d-flex text-small">
                        <bean:message key="Shipping_Inquiry.from"/>
                      </div>
                      <div class="d-flex text-small"  id="fromTerminalS_${bookingList.bookingNo }">
                      </div>
                    </div>
                    <div class="col-md-6 border-left">
                      <div class="d-flex text-small">
                       <bean:message key="Shipping_Inquiry.to"/>
                      </div>
                      <div class="d-flex text-small" id="toTerminalS_${bookingList.bookingNo }">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row bg-light pt-2 pb-0">
                  <div class="col-12 pl-0 pr-0">
                   <div class="md-stepper-horizontal pt-0 pb-0 green">
                   <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='R' || bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">${bookingList.resivedDate }</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/>  </div>
                        <div class="md-step-optional">${bookingList.loadedDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/>  </div>
                        <div class="md-step-optional">${bookingList.onBoardDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/></div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSubmited${bookingList.bookingNo}">
                  <div class="row">
                    <div class="col-12">
                      <h5><strong><bean:message key="Shipping_Inquiry.orderSummary"/><span class="text-muted"></span> </strong></h5>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.customerDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.shipper"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="shipperS_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.consignee"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="consigneeS_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.notifyParty"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="notifyS_${bookingList.bookingNo}">
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row pt-3">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.routingSchedule"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="Shipping_Inquiry.PORT_OF_LOADING"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofloadingS_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                 <strong><bean:message key="Shipping_Inquiry.PORT_OF_DISCHARGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofdischargeS_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                               <strong><bean:message key="Shipping_Inquiry.VESSEL_VOYAGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="vesselVoyageS_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                            <strong><bean:message key="Shipping_Inquiry.TRANSHIP_PORT"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="transhipportS_${bookingList.bookingNo}"> 
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row pt-3">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.EquipmentCommodityDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12">
                              <div class="table-responsive">
                                <table class="table table-bordered  text-muted">
                                  <thead>
                                    <tr>
                                     <th scope="col"><bean:message key="Shipping_Inquiry.ContainerSealMarks"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.NoOfContainersType"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.DescriptionGoodsWeight"/></th>
                                      <th scope="col"><bean:message key="Shipping_Inquiry.GrossWeightMeasurement"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td id="containerNoSealNoMarksNoS_${bookingList.bookingNo }"></td>
                                      <td id="containersTypeS_${bookingList.bookingNo }"></td>
                                      <td id="descriptionofGoodsNetWeightS_${bookingList.bookingNo }"></td>
                                      <td id="grossweightmeasurementS_${bookingList.bookingNo }"></td>
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
                  <div class="row pt-3">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="Shipping_Inquiry.PaymentDetails"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12 text-muted">
                              <div class="table-responsive">
                                <table class="table table-bordered text-muted" id="paymentTable">
                                  <thead>
                                    <tr>
                                      <th ><bean:message key="Shipping_Inquiry.ChargeCode"/></th>
                                      <th ><bean:message key="Shipping_Inquiry.ChargeCodeDescription"/></th>
                                      <th ><bean:message key="Shipping_Inquiry.Currency"/></th>
                                      <th ><bean:message key="Shipping_Inquiry.Rate"/></th>
                                      <th ><bean:message key="Shipping_Inquiry.Basis"/></th>
                                      <th ><bean:message key="Shipping_Inquiry.Amount"/></th>
                                    </tr>
                                  </thead>
                                  <tbody id="rateCharegeS_${bookingList.bookingNo }">
                                  </tbody>
                                </table>
                              </div>
                            </div>

                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>

          </div>

        </div>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>

  <!-- End of Page -->

  <!-- Footer Starts here -->
   
  <!-- Footer Ends here -->
  <!-- Start Of script Section -->
   
  <!-- End Of Script Section -->
  <script>
    $(document).ready(function () {
      $('[data-toggle="tooltip"]').tooltip();


      $('.order-summary').on('hide.bs.collapse', function () {
        console.log("hide.bs.collapse", $(this));
        var id = $(this).attr('id');
        $('a[href="#' + id + '"]').html('More <i class="fa fa-angle-down" aria-hidden="true"></i>');
      });
      $('.order-summary').on('show.bs.collapse', function () {
        var id = $(this).attr('id');
        $('a[href="#' + id + '"]').html('Less <i class="fa fa-angle-up" aria-hidden="true"></i>');
      });
    });
  </script>
</body>

</html>

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
<!-- add screen specific JavaScript file -->
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

<script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>

<!-- add javascript file for this screen -->
<script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceInquiryWebBooking.js?id=<%=new Date() %>" ></script>

    <script language="JavaScript">
    var BROWSE_BOOKING_NUMBER                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002BrowseBookingNumber", pageContext)%>';
        var GET_BOOKING_NUMBER_TO_WEBBOOKING_PAGE   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002GetData", pageContext)%>';
        var NEW_WEBBOOKING_PAGE                     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001", pageContext)%>';
        var ON_LOAD                     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002", pageContext)%>';
        /*Begin @01*/
        var REFER_COMMODITY_GET_DATA                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv019getData", pageContext)%>';
        var DG_COMMODITY_GET_DATA                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv020getData", pageContext)%>';
        var OOG_COMMODITY_GET_DATA                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv021getData", pageContext)%>';
        var GET_UPLOAD_ATTACHMENT                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023getData", pageContext)%>';
        /*End @01*/
        
        var OPEN_E_SHIPPING_PAGE_BASED_ON_BOOKING_NO   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006GetData", pageContext)%>';
        var GET_BOOKING_NUMBER_TO_MORE_WEBBOOKING_PAGE   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002MoreGetData", pageContext)%>';
        
        var ON_BOOKING_EDIT                         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001Edit", pageContext) %>';
   
        var ON_CANCEL_BOOKING 						= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002Cancel", pageContext) %>';
        var GET_TEMLATE							 	= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002Temlate", pageContext)%>';				
        var BOOKING_SEARCH							 	= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002Search", pageContext)%>';
        var ON_DELETE_TEMPLATE							 	= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002deleteTemlate", pageContext)%>';
        var ON_LOAD_SEARCH_API 						= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv00444", pageContext)%>';
        var CHECK_EDIT_CONTAINER				    = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn012EditBookingContainerBooking", pageContext) %>';
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
<form method="POST" action="/sexn002">

	<!-- Start Of Nav Bar -->
	
  			<jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  
  <!-- End Of Nav Bar -->
   <input type="hidden" name="notFound" value="${feserv03.notFound }"/>
   <input type="hidden" name="firstCheckedCommodity"  value="${feserv03.firstCheckedCommodity }"/>
   <input type="hidden" name="statusValidater" id="statusValidater" value="${feserv03.status }"/>	
   <input type="hidden" name="statusError" id="statusError" value="${requestScope.listBookingError }"/>
   <input type="hidden" name="loginDateCheck" id="loginDateCheck"  value="${sessionScope.sUserAccountBean.dateFormat}"/>
   <input type="hidden" name="dateConfigBooking" id="dateConfigBooking" value="${sessionScope.sUserAccountBean.dateConfigBooking }"/>
   
   <div class="rcl-content" >
    <nav aria-label="breadcrumb" class="mt-2">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="dashboard.html"><bean:message key="web_Booking_inquiry.Home"/></a></li>
        <li class="breadcrumb-item"><a href="web-booking.html"><bean:message key="web_Booking_inquiry.Web_Booking"/></a></li>
        <li class="breadcrumb-item active" aria-current="page"><bean:message key="web_Booking_inquiry.Booking_Inquiry"/></li>
      </ol>
    </nav>
    <!-- Start Of Page -->
    <div class="content-container content-height">
      <div class="left-menu pt-3">
        <div class="form-group">
          <label for="bookingRef"><bean:message key="web_Booking_inquiry.Booking_Number"/></label>
          <div class="input-icons">
            <i class="fas fa-list-ol icon"></i>
            <input type="text" class="form-control input-field" name="bookingNo" maxlength='17' id="bookingNo" 
                              placeholder='<bean:message key="web_Booking_inquiry.Enter_Booking"/>'  onkeydown="gotoToSearchBookingInquiry(this)">
          </div>
        </div>
        <div class="form-group">
          <label for="bookingRef"><bean:message key="web_Booking_inquiry.Booking_Ref"/></label>
          <div class="input-icons">
            <i class="fas fa-list-ol icon"></i>
            <input type="text" class="form-control input-field" id="bookingRef" aria-describedby=""
              placeholder='<bean:message key="web_Booking_inquiry.Enter_Booking_Ref"/>' id="bookingRef" >
          </div>
        </div>
        <div class="form-group">
          <label for="orderStatus"><bean:message key="web_Booking_inquiry.Order_Status"/></label>
			       
			      <select ID="statusValue" name="statusValue" size="1" class="form-control">
									<c:forEach var="statusListValue" items="${requestScope.statusList}">
										<c:choose>
											<c:when test="${statusListValue.code == ''}">
												<option selected="selected" value="${statusListValue.code}">${statusListValue.name}</option>
											</c:when>   
											<c:otherwise>
												<option  value="${statusListValue.code}">${statusListValue.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
				  </select>   
			          
        </div>

      <button type="button" class="btn btn-light-blue btn-block" onclick="getWebBookingDataNew()"><bean:message key="web_Booking_inquiry.Search"/></button>
      </div>
      <div class="right-menu">
        <div class="">
        <jsp:include page="../../pages/common/cognis/alertInfo.jsp"></jsp:include> 
		<div class="row right-row">
            <%-- <div class="col-md-1 border-right d-flex align-items-center">
              <h5><strong><bean:message key="web_Booking_inquiry.sortBy"/></strong></h5>
            </div> --%>

            <%-- <div class="col-md-1 border-right cursor-pointer active">
              <h5><strong><bean:message key="web_Booking_inquiry.duration"/></strong></h5>
              <h6><bean:message key="web_Booking_inquiry.long"/> &#8594; <bean:message key="web_Booking_inquiry.short"/></h6>
            </div> --%>
            <%-- <div class="col-md-1 border-right cursor-pointer">
              <h5><strong><bean:message key="web_Booking_inquiry.etd"/></strong></h5>
              <h6><bean:message key="web_Booking_inquiry.low"/> &#8594; <bean:message key="web_Booking_inquiry.high"/></h6>
            </div> --%>
            <%-- <div class="col-md-1 border-right cursor-pointer">
              <h5><strong><bean:message key="web_Booking_inquiry.eta"/></strong></h5>
              <h6>  <bean:message key="web_Booking_inquiry.low"/> &#8594; <bean:message key="web_Booking_inquiry.high"/></h6>
            </div> --%>
           <%--  <div class="col-md-1 cursor-pointer">
              <h5><strong><bean:message key="web_Booking_inquiry.bookings"/></strong></h5>
              <h6><bean:message key="web_Booking_inquiry.a"/> &#8594; <bean:message key="web_Booking_inquiry.z"/></h6>
            </div> --%>
             <div class="col-md-12">
              <div class="float-right">
                <a class="btn btn-primary" id="BookinhNow${loopCounter.count}" onclick="onWebBooking();"  style="color:white;" ><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;
                        <bean:message key="search.newbook"/></a>&nbsp;&nbsp;
                <%-- <a class="dropdown-toggle" href="#" role="button" id="moreSortOptionDropdown" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false">
                  <bean:message key="web_Booking_inquiry.more"/>
                </a>
                <div class="dropdown-menu  dropdown-menu-right" aria-labelledby="moreSortOptionDropdown">
                  <a class="dropdown-item" href="#">Sort 1</a>
                  <a class="dropdown-item" href="#">Sort 2</a>
                  <a class="dropdown-item" href="#">Sort 3</a>
                </div> --%>
              </div>
            </div> 
          </div>
          <div class="row right-row mt-3 ml-1 mr-1 p-0">
            <div class="col-12  p-0">
              <ul class="nav nav-pills nav-justified esi-inquiry" id="pills-tab" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="pills-open-orders-tab" onclick="getOpenAndConfirmBooking();" data-toggle="pill" href="#pills-open-orders"
                    role="tab" aria-controls="pills-open-orders" aria-selected="true"><i
                      class="fas fa-envelope-open"></i> &nbsp;<bean:message key="web_Booking_inquiry.Open_Orders"/>
                    </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="pills-completed-orders-tab" onclick="getCompletedBooking();" data-toggle="pill" href="#pills-completed-orders"
                    role="tab" aria-controls="pills-completed-orders" aria-selected="false"><i
                      class="fas fa-check-circle"></i>
                    &nbsp;<bean:message key="web_Booking_inquiry.Confirm_Orders"/></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="pills-cancelled-orders-tab" onclick="getCancelledBooking();" data-toggle="pill" href="#pills-cancelled-orders"
                    role="tab" aria-controls="pills-cancelled-orders" aria-selected="false"><i
                      class="fas fa-trash-alt"></i>
                    &nbsp;<bean:message key="web_Booking_inquiry.Cancelled_Orders"/></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="pills-template-tab" onclick="getTemplete();" data-toggle="pill" href="#pills-template" role="tab"
                    aria-controls="pills-template" aria-selected="false"><i class="fas fa-bookmark"></i>
                    &nbsp;<bean:message key="web_Booking_inquiry.Templates"/></a>
                </li>
              </ul>
            </div>
          </div>
          <div class="tab-content" id="pills-tabContent">
            <!-- Open Orders tab starts here -->
           
            <div class="tab-pane fade show active" id="pills-open-orders"  role="tabpanel" 
              aria-labelledby="pills-open-orders-tab">
              <!-- You ROW Starts here, to repeat just copy and paste the same div again and again -->
              <c:if test="${requestScope.listBooking.size()==0}" >
              <div style="font-size:20px; text-align:center;padding-top:150px;"><strong><bean:message key="web_Booking_inquiry.There_is"/></strong></div>
              </c:if>
              <c:forEach var = "bookingList" items="${requestScope.listBooking}"  varStatus="loopCounter"> 
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row">
                  <div class="col-11">
                    <%-- <h6><strong><bean:message key="web_Booking_inquiry.Ref_1"/></strong> <span class="text-muted"><bean:message key="web_Booking_inquiry.(FCL)"/></span></h6> --%>
                  </div>
                  <div class="col-1">
                    <a data-toggle="collapse" href="#orderSummary${bookingList.bookingReferenceNo}" role="button"  onclick="getMoreWebBookingData(${loopCounter.count})" aria-expanded="false"
                      aria-controls="orderSummary${bookingList.bookingReferenceNo}" id="MoreO_${loopCounter.count}"><bean:message key="web_Booking_inquiry.More"/>
                       <i class="fa fa-angle-up" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="row distance-details">
                  <div class="col-md-8">
                    <div class="row">
                      <div class="col-md border-left">
                        <div class="d-flex text-muted">
                      <bean:message key="web_Booking_inquiry.EST_Departure_Date"/>
                    		</div>
                    	<div><strong>${bookingList.sailingDate}</strong></div>
                  	</div>
                  	<div class="col-md border-left">
                        <div class="d-flex text-muted">
                      		<bean:message key="web_Booking_inquiry.EST_Arrival_Date"/>
                    	</div>
                    	<div><strong>${bookingList.desiredArrivalDate}</strong></div>
                  	</div>
                  	<div class="col-md border-left">
                        <div class="d-flex text-muted">
                     	 	<bean:message key="web_Booking_inquiry.Booking_Ref"/>
                    	</div>
                    	<div id="bookingNoO${loopCounter.count }"><strong>${bookingList.bookingReferenceNo }</strong></div>
                  	</div>
                   <div class="col-md border-left">
                        <div class="d-flex text-muted">
                      		<bean:message key="web_Booking_inquiry.Booking_Number"/>
                    	</div>
                    	<div id="bookingNoSendO${loopCounter.count }"><strong> ${bookingList.bookingNo } </strong></div>
                  </div>
               </div>
           </div>
                  <div class="col-md-4 border-left  d-flex justify-content-end">
                    <div class="btn-group" role="group" aria-label="Basic example">
                     <%--  <a class="btn btn-secondary mr-1" id="shippingInstruction${loopCounter.count}"   style="color:white;" disabled><i class="fas fa-train"></i>&nbsp;
                        <bean:message key="web_Booking_inquiry.Shipping"/></a> --%>
                     <%--  <button type="button" class="btn btn-info mr-1"   disabled><i class="fas fa-pen-square"></i>&nbsp; 
                        <bean:message key="web_Booking_inquiry.Edit_Booking"/></button> --%>
                      <%-- <button type="button" class="btn btn-success mr-1"><i class="fas fa-copy"></i>&nbsp; 
                        <bean:message key="web_Booking_inquiry.Copy_Booking"/></button> --%>
                     <%--  <button type="button" class="btn btn-danger" disabled><i class="fas fa-times" ></i>&nbsp; <bean:message key="web_Booking_inquiry.cancel"/></button> --%>
                    </div>
                  </div>
                  
            </div>
                
               <div class="order-summary">
                  <div class="row text-muted">
                    <div class="col-md-3">
                      <div class="d-flex text-small">
                         <bean:message key="web_Booking_inquiry.pol"/>
                      </div>
                      <div class="d-flex text-small">
                          ${bookingList.polNameDes }  
                      </div>
                    </div>
                    <div class="col-md-3  border-left">
                      <div class="d-flex text-small">
                        <bean:message key="web_Booking_inquiry.pod"/>
                      </div>
                      <div class="d-flex text-small">
                       	 ${bookingList.podNameDes }
                      </div>
                    </div>
                    <div class="col-md-3  border-left">
                      <div class="d-flex text-small">
                         <bean:message key="web_Booking_inquiry.vesselETD"/>
                      </div>
                      <div class="d-flex text-small">
                       	 ${bookingList.vesselEtd}
                      </div>
                    </div>
                    <div class="col-md-3  border-left">
                      <div class="d-flex text-small">
                         Represented Company
                      </div>
                      <div class="d-flex text-small">
                       	 ${bookingList.repCompName}
                      </div>
                    </div>
                  </div>
                  <div class="text-muted collapse" id="orderSummary${bookingList.bookingReferenceNo}">
                    <hr />
                    <div class="row">
                      <div class="col-md-6">
                        <div class="d-flex text-small">
                         <bean:message key="web_Booking_inquiry.formTerminal"/> 
                        </div>
                        <div class="d-flex text-small" id="fromTerminalO_${bookingList.bookingReferenceNo }">
                          	
                        </div>
                      </div>
                      <div class="col-md-6 border-left">
                        <div class="d-flex text-small">
                         <bean:message key="web_Booking_inquiry.toTerminal"/>  
                        </div>
                        <div class="d-flex text-small" id="toTerminalO_${bookingList.bookingReferenceNo }">
                          	
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row bg-light pt-2 pb-0">
                  <div class="col-12 pl-0 pr-0">
                    <div class="md-stepper-horizontal pt-0 pb-0 green">
                   <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag == 'C' || bookingList.bookingSplFlag =='R' || bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title">  <bean:message key="web_Booking_inquiry.Confirm"/> </div>
                        <div class="md-step-optional"></div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title">  <bean:message key="web_Booking_inquiry.Confirm"/> </div>
                        <div class="md-step-optional">  </div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                     <c:when  test="${ bookingList.bookingSplFlag =='R' || bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'} ">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:when >
                      <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:otherwise>
                      </c:choose>
                      <c:choose>
                      <c:when  test="${ bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B'} ">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"> <bean:message key="web_Booking_inquiry.loaded"/> </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:when >
                      <c:otherwise >
                      <div class="md-step ">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/>  </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:otherwise>
                      </c:choose>
                      <c:choose>
                      <c:when test="${bookingList.bookingSplFlag =='B'} ">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>4</span></div>
                        <div class="md-step-title"> <bean:message key="web_Booking_inquiry.onBoard"/> </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:when>
                      <c:otherwise >
                      <div class="md-step">
                        <div class="md-step-circle"><span>4</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/> </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:otherwise>
                      </c:choose>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSummary${bookingList.bookingReferenceNo}">
                  <div class="row">
                    <div class="col-12">
                      <h5><strong><bean:message key="web_Booking_inquiry.ORDER_SUMMARY"/><span class="text-muted"></span> </strong></h5>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Customer_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.SHIPPER"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="shipperO_${bookingList.bookingReferenceNo}" >
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.CONSIGNEE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="consigneeO_${bookingList.bookingReferenceNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.NOTIFY_PARTY"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="notifyO_${bookingList.bookingReferenceNo}">
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
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Routing_&_Schedule_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.PORT_OF_LOADING"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofloadingO_${bookingList.bookingReferenceNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.PORT_OF_DISCHARGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofdischargeO_${bookingList.bookingReferenceNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.VESSEL_/_VOYAGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="vesselVoyageO_${bookingList.bookingReferenceNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.TRANSHIP_PORT"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="transhipportO_${bookingList.bookingReferenceNo}">
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
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Equipment_&_Commodity_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12">
                              <div class="table-responsive">
                                <table class="table table-bordered  text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Container_No._Seal_No._/_Marks_&_No."/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.No._of_Containers_Type"/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Description_of_Goods_Net_Weight"/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Gross_Weight_Measurement"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td id="containerNoSealNoMarksNoO_${bookingList.bookingReferenceNo }"></td>
                                      <td id="containersTypeO_${bookingList.bookingReferenceNo }"></td>
                                      <td id="descriptionofGoodsNetWeightO_${bookingList.bookingReferenceNo }"></td>
                                      <td id="grossweightmeasurementO_${bookingList.bookingReferenceNo }"></td>
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
                    
                  </div>
                </div>
              </div>
			</c:forEach>
            </div>
          
            <!-- Open Orders tab closes here -->
            <div class="tab-pane fade" id="pills-completed-orders" role="tabpanel" 
              aria-labelledby="pills-completed-orders-tab">

              <!-- Incase you want to repeat Completed Orders repeat this tab -->
              <c:if test="${requestScope.listBooking.size()==0}" >
              <div style="font-size:20px; text-align:center;padding-top:150px;"><strong><bean:message key="web_Booking_inquiry.There_is_confirm_booking"/></strong></div>
              </c:if>
              <c:forEach var = "bookingList" items="${requestScope.listBooking }"  varStatus="loopCounter">
	             <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row">
                  <div class="col-11">
                    <%-- <h6><strong><bean:message key="web_Booking_inquiry.Ref_Completed_Order"/></strong> <span class="text-muted"><bean:message key="web_Booking_inquiry.(FCL)"/></span></h6> --%>
                  </div>
                  <div class="col-1">
                    <a data-toggle="collapse" href="#orderSummaryCompleted${bookingList.bookingNo}" onclick="getMoreWebBookingData(${loopCounter.count})" role="button" aria-expanded="false"
                      aria-controls="orderSummaryCompleted${bookingList.bookingNo}" id="MoreC_${loopCounter.count}">
                       <bean:message key="web_Booking_inquiry.More"/> <i class="fa fa-angle-up" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="row distance-details">
                  <div class="col-md-8">
                    <div class="row">
                      <div class="col-md border-left">
                        <div class="d-flex text-muted">
                      <bean:message key="web_Booking_inquiry.EST_Departure_Date"/>
                    		</div>
                    	<div id="estDepartureDate${bookingList.bookingNo}"><strong>${bookingList.sailingDate}</strong></div>
                  	</div>
                  	<div class="col-md border-left">
                        <div class="d-flex text-muted">
                      		<bean:message key="web_Booking_inquiry.EST_Arrival_Date"/>
                    	</div>
                    	<div><strong>${bookingList.desiredArrivalDate}</strong></div>
                  	</div>
                  	<div class="col-md border-left">
                        <div class="d-flex text-muted">
                     	 	<bean:message key="web_Booking_inquiry.Booking_Ref"/>
                    	</div>
                    	<div id="bookingRefC${loopCounter.count }"><strong>${bookingList.bookingReferenceNo }</strong></div>
                  	</div>
                   <div class="col-md border-left">
                        <div class="d-flex text-muted">
                      		<bean:message key="web_Booking_inquiry.Booking_Number"/>
                    	</div>
                    	<div id="bookingNoC${loopCounter.count }"><strong>${bookingList.bookingNo }</strong></div>
                  </div>
               </div>
           </div>
                  <div class="col-md-4 border-left  d-flex justify-content-end">
                    <div class="btn-group" role="group" aria-label="Basic example">
                      <a class="btn btn-secondary mr-1" id="shippingInstruction${loopCounter.count}"   style="color:white;" onclick="onEshippingInstructionLoad('${bookingList.bookingNo }')"><i class="fas fa-train"></i>&nbsp;
                        <bean:message key="web_Booking_inquiry.Shipping"/></a>
					<%-- <c:choose>
						<c:when test="${bookingList.countContaine == 0}"> --%>
							<%-- <button type="button" class="btn btn-info mr-1"
								onclick="onBookingEdit('${bookingList.bookingNo }')">
								<i class="fas fa-pen-square"></i>&nbsp;
								<bean:message key="web_Booking_inquiry.Edit_Booking" />
							</button> --%>
						<%-- </c:when>
						<c:otherwise >
							<button type="button" class="btn btn-info mr-1">
								<i class="fas fa-pen-square"></i>&nbsp;
								<bean:message key="web_Booking_inquiry.Edit_Booking" />
							</button>
						</c:otherwise>
					</c:choose> --%>
						<%-- <button type="button" class="btn btn-success mr-1"><i class="fas fa-copy"></i>&nbsp; 
                        <bean:message key="web_Booking_inquiry.Copy_Booking"/></button> --%>
                   <button type="button" class="btn btn-danger" onclick="onCancel('${bookingList.bookingNo }')"><i class="fas fa-times"  ></i>&nbsp; <bean:message key="web_Booking_inquiry.cancel"/></button>
                    </div>
                  </div>
                  
            </div>
                
               <div class="order-summary">
                  <div class="row text-muted">
                    <div class="col-md-3">
                      <div class="d-flex text-small">
                         <bean:message key="web_Booking_inquiry.pol"/>
                      </div>
                      <div class="d-flex text-small">
                           ${bookingList.polNameDes }  
                      </div>
                    </div>
                    <div class="col-md-3  border-left">
                      <div class="d-flex text-small">
                        <bean:message key="web_Booking_inquiry.pod"/>
                      </div>
                      <div class="d-flex text-small">
                       	 ${bookingList.podNameDes }
                      </div>
                    </div>
                    <div class="col-md-3  border-left">
                      <div class="d-flex text-small">
                         <bean:message key="web_Booking_inquiry.vesselETD"/>
                      </div>
                      <div class="d-flex text-small" id="vessel_etd${bookingList.bookingNo}">
                       	${bookingList.vesselEtd}
                      </div>
                    </div>
                    <div class="col-md-3  border-left">
                      <div class="d-flex text-small">
                         Represented Company
                      </div>
                      <div class="d-flex text-small">
                       	 ${bookingList.repCompName}
                      </div>
                    </div>
                  </div>
                  <div class="text-muted collapse" id="orderSummaryCompleted${bookingList.bookingNo}">
                    <hr />
                    <div class="row">
                      <div class="col-md-6">
                        <div class="d-flex text-small">
                          From Terminal
                        </div>
                        <div class="d-flex text-small" id="fromTerminalC_${bookingList.bookingNo }">
                          	
                        </div>
                      </div>
                      <div class="col-md-6 border-left">
                        <div class="d-flex text-small">
                          To Terminal
                        </div>
                        <div class="d-flex text-small" id="toTerminalC_${bookingList.bookingNo }">
                          	
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row bg-light pt-2 pb-0">
                  <div class="col-12 pl-0 pr-0">
                    <div class="md-stepper-horizontal pt-0 pb-0 green">
                   <c:choose>
                    <c:when  test="${bookingList.bookingSplFlag == 'C' || bookingList.bookingSplFlag =='R' || bookingList.bookingSplFlag =='L' || bookingList.bookingSplFlag =='B' }">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title">  <bean:message key="web_Booking_inquiry.Confirm"/> </div>
                        <div class="md-step-optional">${bookingList.confirmDate }</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:when >
                     <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>1</span></div>
                        <div class="md-step-title">  <bean:message key="web_Booking_inquiry.Confirm"/> </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                     </c:otherwise>
                     </c:choose>
                     <c:choose>
                     <c:when  test="${bookingList.bookingSplFlag == 'R' || bookingList.bookingSplFlag == 'L' || bookingList.bookingSplFlag == 'B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">${bookingList.resivedDate }</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:when >
                      <c:otherwise>
                      <div class="md-step ">
                        <div class="md-step-circle"><span>2</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.received"/>  </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:otherwise>
                      </c:choose>
                      <c:choose>
                      <c:when  test="${bookingList.bookingSplFlag == 'L' || bookingList.bookingSplFlag == 'B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"> <bean:message key="web_Booking_inquiry.loaded"/> </div>
                        <div class="md-step-optional">${bookingList.loadedDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:when >
                      <c:otherwise >
                      <div class="md-step ">
                        <div class="md-step-circle"><span>3</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.loaded"/>  </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:otherwise>
                      </c:choose>
                      <c:choose>
                      <c:when test="${bookingList.bookingSplFlag == 'B'}">
                      <div class="md-step active done">
                        <div class="md-step-circle"><span>4</span></div>
                        <div class="md-step-title"> <bean:message key="web_Booking_inquiry.onBoard"/> </div>
                        <div class="md-step-optional">${bookingList.onBoardDate}</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:when>
                      <c:otherwise >
                      <div class="md-step">
                        <div class="md-step-circle"><span>4</span></div>
                        <div class="md-step-title"><bean:message key="web_Booking_inquiry.onBoard"/> </div>
                        <div class="md-step-optional">-</div>
                        <div class="md-step-bar-left"></div>
                        <div class="md-step-bar-right"></div>
                      </div>
                      </c:otherwise>
                      </c:choose>
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSummaryCompleted${bookingList.bookingNo}">
                  <div class="row">
                    <div class="col-12">
                      <h5><strong><bean:message key="web_Booking_inquiry.ORDER_SUMMARY"/><span class="text-muted"></span> </strong></h5>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Customer_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.SHIPPER"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="shipperC_${bookingList.bookingNo}" >
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.CONSIGNEE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="consigneeC_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.NOTIFY_PARTY"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="notifyC_${bookingList.bookingNo}">
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
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Routing_&_Schedule_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.PORT_OF_LOADING"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofloadingC_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.PORT_OF_DISCHARGE"/></strong>
                              </div>
                               <div class="d-flex text-muted text-small" id="portofdischargeC_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.VESSEL_/_VOYAGE"/></strong>
                              </div>
                             <div class="d-flex text-muted text-small" id="vesselVoyageC_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.TRANSHIP_PORT"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="transhipportC_${bookingList.bookingNo}">
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
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Equipment_&_Commodity_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12">
                              <div class="table-responsive">
                                <table class="table table-bordered  text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Container_No._Seal_No._/_Marks_&_No."/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.No._of_Containers_Type"/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Description_of_Goods_Net_Weight"/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Gross_Weight_Measurement"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td id="containerNoSealNoMarksNoC_${bookingList.bookingNo }"></td>
                                      <td id="containersTypeC_${bookingList.bookingNo }"></td>
                                      <td id="descriptionofGoodsNetWeightC_${bookingList.bookingNo }"></td>
                                      <td id="grossweightmeasurementC_${bookingList.bookingNo }"></td>
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
                    
                  </div>
                </div>
              </div>
              </c:forEach>
              <!-- Incase you want to repeat Completed Orders repeat this tab -->
             
            </div>
            <div class="tab-pane fade" id="pills-cancelled-orders" role="tabpanel"
              aria-labelledby="pills-cancelled-orders-tab">
              <!-- Incase you want to repeat Cancelled Orders repeat this tab -->
              <c:if test="${requestScope.listBooking.size()==0}" >
              <div style="font-size:20px; text-align:center;padding-top:150px;"><strong><bean:message key="web_Booking_inquiry.There_is_cancel_booking"/></strong></div>
              </c:if>
              <c:forEach var = "bookingList" items="${requestScope.listBooking }"  varStatus="loopCounter">
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row">
                  <div class="col-11">
                    <%-- <h6><strong><bean:message key="web_Booking_inquiry.Ref_Completed_Order"/></strong> <span class="text-muted"><bean:message key="web_Booking_inquiry.(FCL)"/></span></h6> --%>
                  </div>
                  <div class="col-1">
                    <a data-toggle="collapse" href="#orderSummaryCancelled${bookingList.bookingNo}" onclick="getMoreWebBookingData(${loopCounter.count})" role="button" aria-expanded="false"
                      aria-controls="orderSummaryCancelled${bookingList.bookingNo}"  id="MoreN_${loopCounter.count}">
                      <bean:message key="web_Booking_inquiry.More"/> <i class="fa fa-angle-up" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="row distance-details">
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                      <bean:message key="web_Booking_inquiry.EST_Departure_Date"/>
                    </div>
					<div><strong>${bookingList.sailingDate}</strong></div>
                  </div>
                  <div class="col-md-2 border-left">
                    <div class="d-flex text-muted">
                      <bean:message key="web_Booking_inquiry.EST_Arrival_Date"/>
                    </div>
                    <div><strong>${bookingList.desiredArrivalDate}</strong></div>
                  </div>
                  <div class="col-md border-left">
                        <div class="d-flex text-muted">
                     	 	<bean:message key="web_Booking_inquiry.Booking_Ref"/>
                    	</div>
                    	<div><strong>${bookingList.bookingReferenceNo }</strong></div>
                  	</div>
                   <div class="col-md border-left">
                        <div class="d-flex text-muted">
                      		<bean:message key="web_Booking_inquiry.Booking_Number"/>
                    	</div>
                    	<div id="bookingNoN${loopCounter.count }"><strong>${bookingList.bookingNo }</strong></div>
                  </div>
                  <div class="col-md-4 border-left text-danger d-flex justify-content-center">
                    <i class="fas fa-trash fa-2x"></i>
                  </div>
                </div>
                <div class="row">
                  <div class="col-12">
                    <div class="alert alert-danger" role="alert">
                      Order Cancelled on ${bookingList.confirmDate }.
                    </div>
                  </div>
                </div>
                <div class="collapse order-summary" id="orderSummaryCancelled${bookingList.bookingNo}">
                  <div class="row">
                    <div class="col-12">
                      <h5><strong><bean:message key="web_Booking_inquiry.ORDER_SUMMARY"/><span class="text-muted"></span> </strong></h5>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-12">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Customer_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.SHIPPER"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="shipperL_${bookingList.bookingNo}" >
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.CONSIGNEE"/></strong>
                              </div>
                               <div class="d-flex text-muted text-small" id="consigneeL_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.NOTIFY_PARTY"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="notifyL_${bookingList.bookingNo}">
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
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Routing_&_Schedule_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.PORT_OF_LOADING"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofloadingL_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.PORT_OF_DISCHARGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="portofdischargeL_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.VESSEL_/_VOYAGE"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="vesselVoyageL_${bookingList.bookingNo}">
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="d-flex text-muted">
                                <strong><bean:message key="web_Booking_inquiry.TRANSHIP_PORT"/></strong>
                              </div>
                              <div class="d-flex text-muted text-small" id="transhipportL_${bookingList.bookingNo}">
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
                          <h5 class="card-title text-primary"><bean:message key="web_Booking_inquiry.Equipment_&_Commodity_Details"/></h5>
                          <div class="row card-secondary-content">
                            <div class="col-md-12">
                              <div class="table-responsive">
                                <table class="table table-bordered  text-muted">
                                  <thead>
                                    <tr>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Container_No._Seal_No._/_Marks_&_No."/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.No._of_Containers_Type"/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Description_of_Goods_Net_Weight"/></th>
                                      <th scope="col"><bean:message key="web_Booking_inquiry.Gross_Weight_Measurement"/></th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td id="containerNoSealNoMarksNoL_${bookingList.bookingNo }"></td>
                                      <td id="containersTypeL_${bookingList.bookingNo }"></td>
                                      <td id="descriptionofGoodsNetWeightL_${bookingList.bookingNo }"></td>
                                      <td id="grossweightmeasurementL_${bookingList.bookingNo }"></td>
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
                    
                  </div>
                </div>
              </div>
            </c:forEach>
            </div>
            <div class="tab-pane fade" id="pills-template" role="tabpanel" aria-labelledby="pills-template-tab">
              <!-- Incase you want to repeat Template Orders repeat this tab -->
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                <div class="row pt-3">
                  <div class="col-12">
                    <div class="table-responsive">
                      <table class="table table-bordered  text-muted">
                        <thead>
                          <tr>
                            <th scope="col" style="color:black"><bean:message key="web_Booking_inquiry.Name"/></th>
                            <th scope="col" style="color:black"><bean:message key="web_Booking_inquiry.Booking_Ref"/></th>
                            <th scope="col" style="color:black"><bean:message key="web_Booking_inquiry.From"/></th>
                            <th scope="col" style="color:black"><bean:message key="web_Booking_inquiry.To"/></th>
                            <th scope="col" style="color:black"><bean:message key="web_Booking_inquiry.Action"/></th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:if test="${requestScope.listTemplate.size()==0}" >
              				<div style="font-size:20px; text-align:center;padding-top:150px;"><strong>There is No Template available.</strong></div>
              			</c:if>
                         <c:forEach var = "templateList" items="${requestScope.listTemplate }"  varStatus="loopCounter"> 
                          <tr>
                            <td style="color:black">${templateList.templateName }</td>
                            <td style="color:black">${templateList.bookingReferenceNo }</td>
                            <td style="color:black">${templateList.portOfLoading }</td>
                            <td style="color:black">${templateList.portOfDischarge }</td>
                            <td>
                              <div class="btn-group float-right" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-outline-danger mr-2" onclick="deleteTemplate('${templateList.bookingReferenceNo }','${templateList.templateName }')">
                                  <i class="fas fa-trash"></i>
                                </button>
                              </div>
                            </td>
                          </tr>
                           </c:forEach> 
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
       <div class="clearfix"></div>
    </div>
  </div>
  <!-- Footer Starts here -->
  
  <!-- Footer Ends here -->
  <!-- End of Page -->
    </form>
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
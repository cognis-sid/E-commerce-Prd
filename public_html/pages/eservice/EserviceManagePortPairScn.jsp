<%--
-------------------------------------------------------------------------------------------------------------
EservicePreviewUploadedDocScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 09/12/2015     Watchakorn      01                Change solution for Represented Company Contract
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceManagePortPairDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
    <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include> 
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>

    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceManagePortPair.js?id="<%=new Date() %> ></script>


    <script language="JavaScript">
        var ADD_CONTRACT_COMPANY                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029add", pageContext)%>';
        var UPD_CONTRACT_COMPANY                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029upd", pageContext)%>';
        var DEL_CONTRACT_COMPANY                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029del", pageContext)%>';
        var SAVE_CONTRACT_COMPANY                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029save", pageContext)%>';
        var FIND_CONTRACT_COMPANY                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029find", pageContext)%>';
        var PORT_LOOKUP                            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv027portLookUpOnload", pageContext)%>';
        var USERID_LOOKUP_DATA                     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv030lookUp", pageContext)%>';

        <!-- ##01 Begin -->
        var ADD_PORT_PAIR                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029addPortPair", pageContext)%>';
        var UPD_PORT_PAIR                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029updPortPair", pageContext)%>';
        var DEL_PORT_PAIR                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029delPortPair", pageContext)%>';
        var FIND_PORT_PAIR                         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029findPortPair", pageContext)%>';
        var GENERATE_UNIQUE_PASSWORD               = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029genUniqPwd", pageContext)%>';
        var SUSPEND_CONTRACT_COMPANY               = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029suspendCon", pageContext)%>';
        var SUSPEND_PORT_PAIR                      = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029suspendPortPair", pageContext)%>';
        var FIND_USER_DETAIL                       = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv029findUserDetail", pageContext)%>';

        var SELECTED_PK_ESV_PP_HDR_SEQ             = '${feserv29.selectedPkEsvPpHdrSeq}'
        <!-- ##01 End -->

        var ADD                                    = '<%=EserviceManagePortPairDao.ADD%>';
        var UPD                                    = '<%=EserviceManagePortPairDao.UPD%>';
        var DEL                                    = '<%=EserviceManagePortPairDao.DEL%>';


    </script>

</head>

<body>
		
		
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/jquery-ui-1.8.10.custom.css"/>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/jquery-ui-1.8.10.offset.datepicker.min.js"></script>
		
    <html:form method="POST" styleId="frm" action="/serv029">
    
    	<jsp:include page="../common/cognis/header.jsp"></jsp:include>
    
        <html:hidden name="feserv29" property="userLoginId" styleId="userLoginId"/>
        <html:hidden name="feserv29" property="maxPkEsvPpDtlSeq" styleId="maxPkEsvPpDtlSeq"/>
        <html:hidden name="feserv29" property="maxPkEsvPpHdrSeq" styleId="maxPkEsvPpHdrSeq"/>
        <html:hidden name="feserv29" property="customerName" styleId="customerName"/>
        <input type="hidden" id="contextPath" name="contextPath" value="<%=lstrCtxPath%>" />
    <div class="rcl-content" >    
    
        <div class="breadcrumb">
        <h5 class="card-title"><strong><bean:message key="Port.Manage_PP_Search"/></strong></h5>
        </div> 
    
      
        <div class="row d-flex justify-content-center" style="margin:5px;">
          <div class="col-12">
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr style="height:30px;">
                <td width="7%"><bean:message key="Port.Find"/></td>
                <td width="15%">
                    <html:text name="feserv29" property="find" styleId="find" onblur="changeUpper(this)" />
                </td>
                <td width="7%"><bean:message key="Port.In"/></td>
                <td width="15%">
                    <html:select name="feserv29" property="column" styleId="column" size="1">
                        <html:optionsCollection name="feserv29" value="code" label="name" property="columnList"/>
                    </html:select>
                </td>
                <td style="padding-top:3px;" colspan="5">
                    <html:checkbox name="feserv29" property="chkBoxWildCard" styleId="chkBoxWildCard" value="Y" style="float:left;border:0px;width:10%"/><bean:message key="Port.Wild_Card"/>
                    <html:checkbox name="feserv29" property="chkBoxExcludeExpiredPortPair" styleId="chkBoxExcludeExpiredPortPair" value="Y" style="border:0px;width:10%" /><bean:message key="Port.Excluded_Expire_PP"/>
                </td>
            </tr>
            <tr style="height:30px;">
                <td><bean:message key="Port.POL"/></td>
                <td>
                    <html:text name="feserv29" property="POL" styleId="POL" readonly="true" />
                    <a name="btnPOL" id="btnPOL" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick="openPortLookUp('POL');">
                        <i class="icon-search icon-white"></i>
                    </a>
                </td>
                <td><bean:message key="Port.POD"/></td>
                <td>
                    <html:text name="feserv29" property="POD" styleId="POD" readonly="true" />
                    <a name="btnPOD" id="btnPOD" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick="openPortLookUp('POD');">
                        <i class="icon-search icon-white"></i>
                    </a>
                </td>
                <td><bean:message key="Port.Sort_by"/></td>
                <td>
                    <html:select name="feserv29" property="sortBy" styleId="sortBy" size="1">
                        <html:optionsCollection name="feserv29" value="code" label="name" property="sortByList"/>
                    </html:select>

                </td>
                <td><bean:message key="Port.Order_by"/></td>
                <td>
                    <html:select name="feserv29" property="order" styleId="order" size="1">
                        <html:optionsCollection name="feserv29" value="code" label="name" property="orderList"/>
                    </html:select>
                </td>
                <td valign="top" style="padding-left:7px;padding-top:1px;" align="right" colspan="4">
                    <a id="btnSearch" name="btnSearch" class="btn btn-primary"
                        href="#" onClick="searchBtn();">&nbsp;<bean:message key="Port.Search"/>
                    </a>
                    <a id="btnReset" name="btnReset" class="btn btn-danger js-cancel-search"
                        href="#" onClick="resetBtn();">&nbsp;<bean:message key="Port.Reset"/>
                    </a>
                </td>
            </tr>
        </table>
        <br>
        <%-- ##01 Begin --%>
        
        <div  class="">
        	<hr>
            <h5 class="card-title"><strong><bean:message key="Port.Manage_Pp_User_Details"/></strong></h5>
            <hr>
        </div>
             
        <table border="0" width="100%" cellspacing="0" class="TablePopup" id="tblUserDetails">
            <tr>
                <td class="tableHeadingBlue"><bean:message key="Port.Select"/>&nbsp;</td>
                <td class="tableHeadingBlue" style="width:25%"><bean:message key="Port.User_Id"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></td>
                <td class="tableHeadingBlue" style="width:20%"><bean:message key="Port.User_Name"/></td>
                <td class="tableHeadingBlue" style="width:15%"><bean:message key="Port.Company_Name"/></td>
                <td class="tableHeadingBlue" style="width:10%"><bean:message key="Port.Password"/></td>
                <td class="tableHeadingBlue" style="width:10%">&nbsp;</td>
                <td class="tableHeadingBlue"><bean:message key="Port.Del"/></td>
            </tr>
            <tbody>
                <logic:greaterThan value="0" name="feserv29" property="totRecord" >
                    <logic:iterate name='feserv29' property='userContractPartyList' indexId='ctr' id='rowdata'
                        type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod'>
                        <logic:notEqual value="DEL" name="rowdata" property="statusFlag">
                            <tr>
                                <td class="TdLeftDetailPopup" height="30px;" style="text-align:center">
                                    <html:hidden name="rowdata" property="pkEsvPpHdrSeq" />
                                    <html:hidden name="rowdata" property="statusFlag" />
                                    <html:hidden name="rowdata" property="contractCompany" />
                                    <input type="radio" name="optRowdata" id="optRowdata<%=rowdata.getFkUserId()%>"
                                        onclick="findPortPairByUser(this);" style="width:15px;border:none" value="${rowdata.pkEsvPpHdrSeq}"
                                        <logic:equal name="rowdata" property="pkEsvPpHdrSeq" value="${feserv29.selectedPkEsvPpHdrSeq}">
                                           <bean:message key="Port.Checked"/>
                                        </logic:equal>
                                    />
                                </td>
                                <td class="TdLeftDetailPopup"  height="30px;">
                                    <logic:notEqual value="ADD" name="rowdata" property="statusFlag">
                                      <html:text  name="rowdata"
                                                  property="fkUserId"
                                                  styleClass="must"
                                                  readonly="true"
                                                  style="width:100px;" />
                                    </logic:notEqual>
                                    <logic:equal value="ADD" name="rowdata" property="statusFlag">
                                      <html:text  name="rowdata"
                                                  property="fkUserId"
                                                  styleClass="must"
                                                  onchange="findUserDetail(this)"
                                                  style="width:100px;" />
                                    </logic:equal>
                                    <%/*<a name="btnFkUserId" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" disabled="true">
                                        <i class="icon-search icon-white"></i>
                                    </a>*/%>
                                </td>
                                <td class="TdLeftDetailPopup" height="30px;">
                                    <html:text  name="rowdata"
                                                property="userName"
                                                onkeypress="return false;"
                                                onkeydown="return false;"
                                                styleClass="input-disabled"
                                                readonly="true"
                                                style="width:98%;"
                                                 />
                                </td>
                                <td class="TdLeftDetailPopup" height="30px;">
                                    <html:text  name="rowdata"
                                                property="contractPartyName"
                                                styleClass="input-disabled"
                                                onkeypress="return false;"
                                                onkeydown="return false;"
                                                readonly="true"
                                                style="width:98%;"
                                                />
                                </td>
                                <td class="TdLeftDetailPopup" height="30px">
                                    <html:text
                                        name="rowdata"
                                        property="pwd"
                                        styleClass="input-disabled"
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleId="pwd${ctr}"
                                        readonly="true"/>
                                </td>
                                <td class="TdLeftDetailPopup" height="30px">
                                    <a class="m-btn mini blue rnd" href="javascript:void(0)" style="vertical-align:auto" name="btnGenPwd"
                                        <logic:equal value="" name="rowdata" property="statusFlag">
                                            disabled="disabled"
                                        </logic:equal>
                                        <logic:equal value="" name="rowdata" property="fkUserId">
                                            disabled="disabled"
                                        </logic:equal>
                                        <logic:equal value="ADD" name="rowdata" property="statusFlag">
                                            onClick="generateUniquePassword(this);"
                                        </logic:equal>
                                        >
                                      <bean:message key="Port.Generate_Unique_Pass"/> 
                                    </a>
                                </td>
                                <td valign="middle" class="TdLeftDetailPopup" style="text-align:center">
                                    <logic:notEqual value="ADD" name="rowdata" property="statusFlag">
                                        <input type="checkbox" name="chkPkEsvPpHdrSeq" id="chkPkEsvPpHdrSeq" value="${rowdata.pkEsvPpHdrSeq}" style="width:23px;border:none"/>
                                    </logic:notEqual>
                                    <logic:equal value="ADD" name="rowdata" property="statusFlag">
                                        <a name="delBtn" class="" href="javascript:void(0)" onClick="lp_delContractCompany(this);" >
                                            <img border="0" alt="Delete" src="<%=lstrCtxPath%>/images/btnClose.gif" style="width:16px; height:16px">
                                        </a>
                                    </logic:equal>
                                </td>
                            </tr>
                        </logic:notEqual>
                    </logic:iterate>
                </logic:greaterThan>
                <logic:equal  value="0" name="feserv29" property="totRecord" >
                    <tr>
                        <td class="TdCentertDetailPopup" height="20px;" colspan="7" >
                           <bean:message key="Port.Record_not_found"/>
                        </td>
                    </tr>
                </logic:equal>
                <tr>
                    <td width="100%"  height="20px;" align="right" colspan="7" >
                      &nbsp;
                    </td>
                </tr>
                <tr>
                    <td width="100%"  height="20px;" align="right" colspan="7" >
                        <a class="btn btn-primary" href="javascript:void(0)" onClick="return lp_addContractCompany();" id="addUserBtn">
                          <bean:message key="Port.Add"/>
                        </a>
                        <a class="btn btn-primary" href="javascript:void(0)" onClick="return save();" id="saveBtn">
                            <bean:message key="Port.Save"/> 
                        </a>
                        <a class="btn btn-primary" href="javascript:void(0)" onClick="suspendContractParty();">
                            <bean:message key="Port.Delete"/>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
        <br/>
        
         
        <div>
        <hr>
           <h5 class="card-title"><strong><bean:message key="Port.Manage_PP_PP"/></strong></h5>
           <hr>
        </div> 
        <table border="0" width="100%" cellspacing="0" class="TablePopup" id="tblPortPairs">
            <thead>
              <tr>
                  <th class="tableHeadingBlue"><bean:message key="Port.Seq"/>&nbsp;</td>
                  <th class="tableHeadingBlue" style="width:20%"><bean:message key="Port.Port_Loading"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></td>
                  <th class="tableHeadingBlue" style="width:20%"><bean:message key="Port.Port_Discharge"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></td>
                  <th class="tableHeadingBlue"><bean:message key="Port.Effective_Date"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></td>
                  <th class="tableHeadingBlue"><bean:message key="Port.Expire_Date"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></td>
                  <th class="tableHeadingBlue"><bean:message key="Port.Del"/></td>
              </tr>
            </thead>
            <tbody>
                <logic:greaterThan value="0" name="feserv29" property="totPortpairRecord" >
                    <logic:iterate name='feserv29' property='portpairContractPartyList' indexId='ctr' id='rowdata'
                        type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod'>
                        <tr>
                            <td class="TdLeftDetailPopup" style="text-align:center">
                                <html:hidden name="rowdata" property="pkEsvPpDtlSeq" />
                                <html:hidden name="rowdata" property="portPairStatusFlag" />
                                <html:hidden name="rowdata" property="fkPOL" />
                                <html:hidden name="rowdata" property="fkPOD" />
                                ${ctr+1}
                            </td>
                            <td class="TdLeftDetailPopup">
                                <html:text  name="rowdata"
                                            property="POLDesc"
                                            styleClass="must"
                                            onkeypress="return false;"
                                            onkeydown="return false;"
                                            readonly="true"
                                            style="width:90%;" />
                                <a name="btnFkPOL" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick="openPortLookUpForTable(this, 'POLDesc');">
                                    <i class="icon-search icon-white"></i>
                                </a>
                            </td>
                            <td class="TdLeftDetailPopup">
                                <html:text  name="rowdata"
                                            property="PODDesc"
                                            styleClass="must"
                                            onkeypress="return false;"
                                            onkeydown="return false;"
                                            readonly="true"
                                            style="width:90%;" />
                                <a name="btnFkPOD" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick="openPortLookUpForTable(this, 'PODDesc');">
                                    <i class="icon-search icon-white"></i>
                                </a>
                            </td>
                            <td class="TdLeftDetailPopup">
                                <logic:equal value="" name="rowdata" property="portPairStatusFlag">
                                  <html:text
                                      name="rowdata"
                                      property="effDate"
                                      styleId="effDate${ctr}"
                                      style="width:100px"
                                      maxlength='10'
                                      styleClass="input-disabled"
                                      readonly="true"
                                      onblur=""/>
                                </logic:equal>
                                <logic:notEqual value="" name="rowdata" property="portPairStatusFlag">
                                  <html:text
                                    name="rowdata"
                                    property="effDate"
                                    styleId="effDate${ctr}"
                                    style="width:100px"
                                    maxlength='10'
                                    styleClass="dateFormMust"
                                    readonly="true"
                                    onchange="updPortPair(this)"
                                    onblur="gp_checkDate(this);updPortPair(this);"/>
                                </logic:notEqual>

                                <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only"
                                  <logic:notEqual value="" name="rowdata" property="portPairStatusFlag">
                                    onClick="gp_calendar('effDate<%=ctr%>')"
                                  </logic:notEqual>
                                  <logic:equal value="" name="rowdata" property="portPairStatusFlag">
                                    disabled="true"
                                  </logic:equal>
                                  >
                                    <i class="icon-calendar icon-white"></i>
                                </a>
                            </td>
                            <td class="TdLeftDetailPopup">
                                <html:text
                                    name="rowdata"
                                    property="expDate"
                                    styleId="expDate${ctr}"
                                    style="width:100px"
                                    maxlength='10'
                                    onblur="gp_checkDate(this);updPortPair(this);"
                                    onchange="updPortPair(this)"
                                    styleClass="dateFormMust"/>

                                <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('expDate<%=ctr%>')">
                                    <i class="icon-calendar icon-white"></i>
                                </a>
                            </td>
                            <td valign="middle" class="TdLeftDetailPopup" style="text-align:center">
                                <logic:notEqual value="" name="rowdata" property="portPairStatusFlag">
                                  <A name="delBtn" class="" href="javascript:void(0)" onClick="delPortPair(this);" >
                                    <IMG border="0" alt="Delete" src="<%=lstrCtxPath%>/images/btnClose.gif" width="16px" height="16px">
                                  </A>
                                </logic:notEqual>
                                <logic:equal value="" name="rowdata" property="portPairStatusFlag">
                                    <input type="checkbox" name="chkPkEsvPpDtlSeq" value="${rowdata.pkEsvPpDtlSeq}" style="width:23px;border:none"/>
                                </logic:equal>
                            </td>
                        </tr>
                    </logic:iterate>
                </logic:greaterThan>
                <logic:equal  value="0" name="feserv29" property="totPortpairRecord" >
                    <tr>
                        <td class="TdCentertDetailPopup" height="20px;" colspan="6" >
                          <bean:message key="Port.Record_not_found"/>
                        </td>
                    </tr>
                </logic:equal>
                <tr>
                    <td width="100%"  height="20px;" align="right" colspan="6" >
                      &nbsp;
                    </td>
                </tr>
                <tr>
                    <td width="100%"  height="20px;" align="right" colspan="6" >
                        <a class="btn btn-primary" id="btnAddPortPair" href="javascript:void(0)" onClick="javascript:addPortPair()" style="margin-right:20px;">
                            <bean:message key="Port.Add"/>  
                        </a>
                        <a class="btn btn-primary" id="btnDelPortPair" href="javascript:void(0)" onClick="suspendPortPair()">
                           <bean:message key="Port.Delete"/>   
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
       </div>
      </div>
      
      </div>
      
    </html:form>
    
     
  <!-- Footer Ends here -->

  <!-- Footer Ends here -->
  <!-- End of Page -->
    </form>
  <!-- Start Of script Section -->
  
    
    
		
    <style>
   
    input:not([type="radio"]), select {
    height: 20px !important;
    border-radius: 4px !important;
    width: 80%;
}

.m-btn.smallericn-only {
    min-width: 20px;
    min-height: 20px;
}
.m-btn [class^="icon-"] {
    display: inline-block;
    width: 14px;
    height: 14px;
    margin-top: 0px;
    line-height: 14px;
    vertical-align: top;
    
    background-repeat: no-repeat;
}

.rnd{
	height: 20px;
}

.tableHeadingBlue {
    FONT-SIZE: 12PX;
    FONT-FAMILY: Arial Unicode MS, Verdana, Geneva, Helvetica, sans-serif;
    COLOR: black;
    FONT-WEIGHT: BOLD;
    TEXT-ALIGN: LEFT;
    VERTICAL-ALIGN: TOP;
    BACKGROUND: #cde6f7;
    padding: 5px;
}

.top-nav {
   position:relative;
   height: 0px;
}

    </style>
    <script>
    function unloading(){
    	loading(true);
    }
    
    $(document).ready(function(){
    	
    	 $(".dateForm").datepicker();
    	 
         $(".dateFormMust").datepicker();
         
    	 
       
    	  $('.dateFormMust').datetimepicker({
    	        format: 'DD/MM/YYYY',
    		
    			
    	      });
    	  debugger;
    	     var error =   '${feserv29.erroMessage}';
    	     if(error != "NO"){
    	    	 swal("Message", error, "warning")
    	     }
    	
          
            $(".dateForm").on("focus",function(){
                $(this).datepicker({ changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', inline: true });
            });
            $(".dateFormMust").on("focus",function(){
                $(this).datepicker({ changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', inline: true });
            });
    });     
    </script>
    
    <script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/common/EserviceUtil.js?id=<%=new Date()%>"></script>  
</body>
</html>

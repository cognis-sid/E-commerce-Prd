<!DOCTYPE html>
<html>

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/niit-html.tld" prefix="niit" %>
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page errorPage="/pages/common/error/error.jsp" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@ page import="com.niit.control.common.GlobalConstants" %>

<%		
    // TO be removed once Login Page is made
    String lstrUser = null;
    String path = null;
     String lstrCtxPath = request.getContextPath();

%>
<head>
<base target= "_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><tiles:getAsString name="title"/></title>
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/NTL.css"/>
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/RCL.css"/>
<%-- <link rel="stylesheet" href="<%=lstrCtxPath%>/css/EZL.css"/> --%>
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/MyStyle.css" type="text/css" />
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/BGround.css" type="text/css" />
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/m-styles.min.css"/>
<!--meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/--> 
<style type="text/css">
     div.search_result{height:100px;}
     table.table_results tbody{height:100px;}
</style>
<!--[if IE]>
    <style type="text/css">
        div.search_result {
            position: relative;
            height: 100px;
            width: 100%;
            overflow-y: scroll;
            overflow-x: hidden;
        }
        table.table_results{width:99%}
       
        table.table_results thead tr {
            position: absolute;width:100%;
            top: expression(this.offsetParent.scrollTop);
        }
        table.table_results tbody {
            height: auto;
        }
        /*table.table_results tbody tr td.first_row {
            padding-top: 24px;}*/}
         table.header{width:99%; }             
    </style>
<![endif]-->        
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/front_messages.js">
    var contextPath4Date = "<%=request.getContextPath()%>";
</script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/validate.js"></script>	
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutMessageBar.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/tab.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutDate.js"></script>    
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/jquery.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js"></script> 
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/common/EserviceUtil.js"></script>  
<script type="text/javascript" language="JavaScript">
    var appCtxPath = '<%=lstrCtxPath%>';
    var svcm001Url = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svcm001", pageContext)%>';
    var svcm002Url = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svcm002", pageContext)%>';
    var svut001Url = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/svut001", pageContext)%>';
    var reportUrl  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/openReport", pageContext)%>';
    var secm002Url = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/secm002", pageContext)%>'; 

    var aw = screen.availWidth;
    var ah = screen.availHeight;    
    
    var globalobj;
    var currselrowid='row0';
    var size1 = 0;
    var index = -1;
	
    function onLoad(){}
	
    /*---------------------------------------------------------------------------------------------------*/
    //Function to highlight the selected row
    function highlightradioTD(rowid) {
        rowobj = document.all(rowid);
        oldrowobj = document.all(currselrowid);
        if (oldrowobj != null) oldrowobj.style.background = "#FFFFFF";
        if (rowobj != null) {
            currselrowid = rowid;
            rowobj.style.background = "#ADC3E7";
        }
    }
	//Function to highlight the selected multi-row
    function highlightradioTDMultiRow(rowid) {
        rowobj = document.all(rowid);
        oldrowobj = document.all(currselrowid);
        if (oldrowobj != null) {
			for(var i = 0; i < oldrowobj.length; i++) {
				oldrowobj[i].style.background = "#FFFFFF";
			}
		}
        if (rowobj != null) {
            currselrowid = rowid;
			for(var i = 0; i < rowobj.length; i++) {
				rowobj[i].style.background = "#ADC3E7";
			}
        }
    }
    function selRow(radioObj) {
        var rowid = 'row'+radioObj.value;
        highlightradioTD(rowid);
    }
	function selMultiRow(radioObj) {
        var rowid = 'row'+radioObj.value;
        highlightradioTDMultiRow(rowid);
    }
    function getCurrRowId(){
        return currselrowid;
    }
    function getCurrRowNo(){
        return currselrowid.substring(3);
    }
</script>  
</head>
<body onload='javascript:onLoad()' onunload="javascript:doCloseAllChilds()" style="margin-top: 0px; margin-left: 0px">
    <div id="container">
        <table border="0" width="100%"  cellspacing="0" cellpadding="0">
        
        <tr>
            <td>
            <tiles:insert attribute='body'/>
            </td>
        </tr>
        <tr>
            <td><tiles:insert attribute="footer"/></td>
        </tr>			
    </table>
    </div>
    <form name="reportForm" method="post" action='<%=com.niit.control.web.JSPUtils.getActionMappingURL("/openReport",pageContext)%>' target="_new" >
        <input type="hidden" name="module" value="" />
        <input type="hidden" name="screen" value="" />
        <input type="hidden" name="report" value="" />
        <input type="hidden" name="desformat" value="" />
        <input type="hidden" name="reportDetails" value="" />
        <input type="hidden" name="hidden_run_parameters" value="" />
    </form>
</body>
</html>

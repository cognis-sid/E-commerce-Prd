<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="com.niit.control.common.GlobalConstants,com.niit.control.web.action.BaseAction,com.niit.control.web.*" %>

<!--style href>
a {
    text-decoration: none
  }
</style-->

<tiles:useAttribute id='lstrProgID'         name='progId' />
<tiles:useAttribute id='lstrFormBeanID'     name='formId' />
<tiles:useAttribute id='lstrScrTitle'       name='title' />
<tiles:useAttribute id='lstrScreenHeading'  name='screenHeading' />
<tiles:useAttribute id='lstrScreenVersion'  name='screenVersion' />

<bean:define id="hasBack" name="<%=lstrFormBeanID.toString()%>" property="backVisible" type="java.lang.Boolean"/>
<bean:define id="hasRefresh" name="<%=lstrFormBeanID.toString()%>" property="refreshVisible" type="java.lang.Boolean"/>
<bean:define id="hasSave" name="<%=lstrFormBeanID.toString()%>" property="saveVisible" type="java.lang.Boolean"/>

<%
System.out.println("-------hasBack-----------"+hasBack);
String lstrCtxPath = request.getContextPath();
UserAccountBean account=(UserAccountBean)session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);

response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0); // prevent caching at the proxy server

System.out.println("-------hasBack-----------"+hasBack);
%>
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/jquery-ui-1.8.10.custom.css"/>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/jquery-ui-1.8.10.offset.datepicker.min.js"></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/please_wait.js" ></script>
<script type="text/javascript" language="JavaScript">
var fscAccessLevels = '<%=account.getFscAccessLevels()%>';
var allVals = fscAccessLevels.split("/");

$(document).ready(function(){
    try{
        debugger;
        var str = document.forms[0].action;
        var count=str.split("/").length;
        console.log(count);
        var res = str.split("/");
        if(res[Number(count)-1]!="sexn001" && res[Number(count)-1]!="sexn006" && res[Number(count)-1]!="sexn002" && res[Number(count)-1]!="sexn010" && res[Number(count)-1]!="serv029" && res[Number(count)-1]!="svgm001")
        {
        $(".dateForm").on("focus",function(){
            $(this).datepicker({ changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', inline: true });
        });
        $(".dateFormMust").on("focus",function(){
            $(this).datepicker({ changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', inline: true });
        });
        }
    }catch(e){
        debugger;
        alert("header :: " + e);
    }

//    try{
//        var $sidebar   = $("#divStayTopLeft"),
//            $window    = $(window),
//            offset     = $sidebar.offset(),
//            topPadding = $("#divStayTopLeft").height();
//
//        $(window).scroll(function() {
//            try{
//                $sidebar.stop().animate({
//                    marginTop: $(window).scrollTop() - offset.top - topPadding + $(window).height()
//                }, 400);
//            }catch(e){
//                alert("in divStayTopLeft :: " + e);
//            }
//        });
//    }catch(e){
//        alert("divStayTopLeft :: " + e);
//    }

});

function getLine(){
	return allVals[0];
}
function getTrade(){
	return allVals[1];
}
function getAgent(){
	return allVals[2];
}
</script>
  
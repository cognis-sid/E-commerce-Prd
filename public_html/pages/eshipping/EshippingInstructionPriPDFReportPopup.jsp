<%@page import="java.util.Date"%>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim"%>
<%@ page import="java.util.Vector"%>
<%		
    String lstrCtxPath = request.getContextPath();
%>
<html>
  <head>
   <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
    
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingInstruction.js?id=<%=new Date() %>" ></script>    
  
  
  <script language="JavaScript">
  function onLoad() 
{   
    var errMsg = document.getElementById("errMsg");
    if(null!=errMsg)
    {
        if(''!=errMsg.value)
        {
         
            showBarMessage(errMsg.value,1);
        }
    }
}
 </script>
  
  <jsp:useBean id="eshippingInstructionPrintReportUim" class="com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim" scope="session"/>

    <title>EshippingInstructionPriPDFReportPopup</title>
        <meta http-equiv="Content-Type" content="text/html; charset=x-windows-874"/>
        <link rel="stylesheet" type="text/css" href="<%=lstrCtxPath%>/css/sealiner.css">
  </head>
  <body  onLoad="onLoad();">
  <%
      String strError = eshippingInstructionPrintReportUim.getErrMsg()==null?"":eshippingInstructionPrintReportUim.getErrMsg();
  %>
<form  method="POST" action= "/serv006PreviwPDFReport">
<input type="hidden" name="pageAction" value="">
<input type="hidden" name="reportFormat" value="">
<input type="hidden" name="errMsg" id="errMsg" value="<%=strError%>">
<%

if("".equals(strError)){

%>

<iframe src="<jsp:getProperty name="eshippingInstructionPrintReportUim" property="reportUrl"/>" width="100%" height="600px"  frameborder="0" name="fraReport"></iframe>
<%//Begin:Footer Section%>

<%//End: Footer Section%>
<% }else{ %>
<!-- 
<h1> <%=strError%>.</h1>
-->

<%}%>

</form>
  </body>
</html>

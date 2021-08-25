<%-- <%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%
    String lstrCtxPath     = request.getContextPath();
%> --%>
<head>
<title></title>
<script type="text/javascript">
function closeRegistration(){
    window.close();
    
    window.opener.unloading();
    window.opener.close();
}
</script>
</head>
<body>
    <div style="padding-left:10px;padding-right:10px">
        <div class="popupHeader">Thank you for your interest in RCL eServices!</div> 
        <br /><br />
        <div>We received your registration request and it had been forwarded to our RCL person in charge for review.</div>        
        <br /><br />
        <div>You will get the confirmation shortly with login information by email once your account is activated after the review.</div>        
        <br />
        <br /><br /><br />
        <div align="center" style="padding-right:10px;">
            <a class="m-btn sm blue rnd" 
                href="#" onclick="closeRegistration();">OK <i class="icon-remove icon-white"></i>
            </a> 
        </div>
    </div>    
</body>

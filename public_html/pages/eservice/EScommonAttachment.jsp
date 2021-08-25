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
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
    
    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EScommonAttachment.js" ></script>
    <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
</head>

<body>

    <div class="TableLeftSubColor">
        <h2>File</h2>
    </div>
    <div class="TableLeftSubColor">
        <h2>Upload Files</h2>
    </div>
    </br>
    </br>
</body>


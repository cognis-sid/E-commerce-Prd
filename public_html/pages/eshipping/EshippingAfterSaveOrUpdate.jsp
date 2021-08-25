<%
    String urlAfterSave = com.niit.control.web.JSPUtils.getActionMappingURL("/serv006AfterSave", pageContext);
    response.sendRedirect(urlAfterSave+"?openAcknowledgement=true");
%>

<B><FONT ALIGN="CENTER">Welcome to maintain E-Notice service.</FONT><B><BR><BR>

<% 
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String mstrStatus = (String) request.getParameter("deamonStatus");
        
	String status = null;
        
	if("true".equals(mstrStatus)) {
            status = "Running";
	} else if("false".equals(mstrStatus)){
            status = "Stopped";
	} else {
            status = "";
        }
        
	out.println("Current E-Notice Service Status :: " + status);
%>

<HEAD>
    
    <SCRIPT language="JavaScript">
		
		function onLoad() {
		
		}
		
        function startMailService()
        { 
             document.forms[0].SERVICE_TYPE.value = "START";
             
             var urlString = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/secm010", pageContext)%>';
             document.forms[0].action=urlString;        
             document.forms[0].submit(); 
             return false;
        }

        function stopMailService()
        {
            document.forms[0].SERVICE_TYPE.value = "STOP";        
            var urlString = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/secm010", pageContext)%>';
            document.forms[0].action=urlString;        
            document.forms[0].submit(); 
            return false;    
        }
		
        function inquireStatus()
        {
            document.forms[0].SERVICE_TYPE.value = "INQUIRY";        
            var urlString = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/secm010", pageContext)%>';
            document.forms[0].action=urlString;        
            document.forms[0].submit(); 
            return;
        }
        
    </SCRIPT>
</HEAD>

<BODY>
    <form METHOD="POST" ACTION="/secm010">

        <input type="hidden" name="PAGE_URL" value="/do/secm010">    
        <input type="hidden" name="SERVICE_TYPE" value="">

         <div class="buttons_box">		
                <input type="button" name="Start" class="event_btnbutton" value="Start" onclick="startMailService()">
		<input type="button" name="Stop" class="event_btnbutton" value="Stop" onclick="stopMailService()">
		<input type="button" name="Inquire Status" value="Inquire Status" class="event_btnbutton" onclick="inquireStatus()">
        </div>   
    </form> 
</BODY>

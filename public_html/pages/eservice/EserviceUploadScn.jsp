<%--
-------------------------------------------------------------------------------------------------------------
EserviceUpload.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 26/05/15      Sarawut         -                 Change CSS fupload browse button for support chrome
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
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EservicePortClassDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
    <script language="Javascript" src="<%=lstrCtxPath%>/js/jquery-1.6.1.min.js"></script>
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
    <script type="text/javascript" src="<%=lstrCtxPath%>/js/jquery.AjaxFileUpload.js" ></script>
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceUpload.js" ></script>
    
    <script type="text/javascript">
        var SUBMIT                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023onSubmit", pageContext)%>';
        var SEND_FILE_TO_TEMP       = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023sendFileToTemp", pageContext)%>';
        var DELETE                  = '../do/serv023onDelete';
        
        var VIEW_PDF                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv024", pageContext)%>';
    </script>
    
    <style type="text/css">
        /* for show browse button on right side */
        fupload {width: 320px; height: 30px; margin: 0; border: 1px solid #777;
          float: left; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; }
        input[type="file"].fupload::-webkit-file-upload-button {
          float: right; position: relative; top: -1px; right: -1px;}
    </style>

</head>

<body onload="onLoad();">    
    <html:form method="POST" styleId="frm1" action="/serv023">
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
        
            <tr>
                <td width="100%">
                    <html:file name="feserv23" property="dataFile" styleId="dataFile" value="" style="width:400px;border-style: solid;height:20px" styleClass="fupload" /><br/>
                    <br>
                    <font color="gray" size="2px"><b>The file must be in PDF format with a maximum size of 2 MB.</b></font>
                </td>
            </tr>
        </table>
    </html:form>
        <br>
    <html:form method="POST" styleId="frm2" action="/serv023">
        <html:hidden name="feserv23" property="errMsg" styleId="errMsg" />
        <html:hidden name="feserv23" property="maxSeq" styleId="maxSeq" />
        <html:hidden name="feserv23" property="totalSize" styleId="totalSize" />
        <html:hidden name="feserv23" property="disBtn" styleId="disBtn" />
        <input type="hidden" name="lstrCtxPath" id="lstrCtxPath" value="<%=lstrCtxPath%>" />
        
        <div align="center" id="FreezePane" class="FreezePaneOff">
            <div id="processBar" class="processBarOff">
                <center>
                    <br/>
                    Please wait...<br/>
                    <img id="imgProgress" valign="center" src="<%=lstrCtxPath%>/images/loadingAnimation.gif" alt="" />
                
                </center>
            </div>
        </div>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <tr>
                <td class="TdLeftHeaderPopup" width="50%"><p style="font-size:13px">File Name</p></td>
                <td class="TdLeftHeaderPopup" width="30%"><p style="font-size:13px">File Size</p></td>
                <td class="TdLeftHeaderPopup" width="20%"><p style="font-size:13px">Delete</p></td>
            </tr>
        </table>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup" id="tableData" >
            <logic:iterate name='feserv23' property='list' indexId='ctr' id='rowdata'
                type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod'>
                    <logic:notEqual name="rowdata"  property="status" value="DEL">
                    <tr>
                        <td class="TdLeftDetailPopup" width="50%"  height="20px;">
                            <logic:equal name="rowdata"  property="status" value="ADD">
                                <bean:write name="rowdata" property="fileName"/>
                            </logic:equal>
                            <logic:notEqual name="rowdata"  property="status" value="ADD">
                                <A href='<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv024", pageContext)%>?pdfName=<bean:write name="rowdata" property="fileName"/>&fileName=<bean:write name="rowdata" property="newFileName"/>' target="_blank" >
                                    <bean:write name="rowdata" property="fileName"/>
                                </A>
                            </logic:notEqual>
                        </td>
                        <td class="TdLeftDetailPopup" width="30%"  height="20px;">
                            <bean:write name="rowdata" property="sizeDisplay"/>&nbsp;
                            <span>KB</span>
                        </td>
                        <td class="TdLeftDetailPopup" width="20%"  height="20px;">
                            <logic:equal name="feserv23" property="disBtn" value="N">
                                <A href='javascript:void(0)' onclick='lp_delete(<bean:write name="rowdata" property="seq"/>, this)' >
                                    <IMG border="0" alt="Delete" src="<%=lstrCtxPath%>/images/btnClose.gif" width="16" height="16">
                                </A>
                            </logic:equal>
                            <logic:equal name="feserv23" property="disBtn" value="Y">
                                <A href='javascript:void(0)' onclick='' >
                                    <IMG border="0" alt="Delete" src="<%=lstrCtxPath%>/images/btnClose.gif" width="16" height="16">
                                </A>
                            </logic:equal>
                            <html:hidden name="rowdata" property="seq" />
                            <html:hidden name="rowdata" property="status" />
                        </td>
                    </tr>
                    </logic:notEqual>
                </logic:iterate>
        </table>
        <table border="0" width="100%" cellspacing="0" class="TablePopup" id="trSubmitBtn" >
            <tr>
                <td align=left width="100%"  height="30px;">
                    <a class="m-btn mini blue rnd" href="javascript:void(0)" onClick="submitBtn();">
                        <strong>Save</strong>
                    </a>
                </td>
            </tr>
        </table>
    </html:form>
    <div id="ErrorMsgLog" style="width: 100%;height: 30px;background-color: #FFE3D1;display: none; ">
	<strong style="position: absolute;font:14px; color: #853D0C; padding-left: 10px;padding-top: 10px;">Error!</strong><p style="position: absolute;font:14px; color: #853D0C; padding-left: 50px;">Maximum file upload capacity is 6</p>
	</div>
</body>

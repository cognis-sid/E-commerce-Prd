package _pages._ecm;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EcmAddViewRecipientScn extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _EcmAddViewRecipientScn page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      		
          String lstrCtxPath = request.getContextPath();
      
      out.write(__oracle_jsp_text[5]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[6]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm008save", pageContext));
      out.write(__oracle_jsp_text[7]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/secm008");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[8]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("fecm008");
              __jsp_taghandler_2.setProperty("recieverOrgId");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[9]);
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_3=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setId("rowdata");
              __jsp_taghandler_3.setIndexId("ctr");
              __jsp_taghandler_3.setName("fecm008");
              __jsp_taghandler_3.setProperty("values");
              __jsp_taghandler_3.setType("com.rclgroup.dolphin.ezl.web.ecm.vo.EcmAddViewRecipientMod");
              com.rclgroup.dolphin.ezl.web.ecm.vo.EcmAddViewRecipientMod rowdata = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                do {
                  rowdata = (com.rclgroup.dolphin.ezl.web.ecm.vo.EcmAddViewRecipientMod) pageContext.findAttribute("rowdata");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[11]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_4=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleClass size");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_4.setName("fecm008");
                    __jsp_taghandler_4.setOnchange(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_4.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].type"));
                    __jsp_taghandler_4.setStyle("width:80%;height:20px;");
                    __jsp_taghandler_4.setStyleClass("must");
                    __jsp_taghandler_4.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[12]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_5=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                          __jsp_taghandler_5.setLabel("name");
                          __jsp_taghandler_5.setName("fecm008");
                          __jsp_taghandler_5.setProperty("typeValues");
                          __jsp_taghandler_5.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,4);
                        }
                        out.write(__oracle_jsp_text[13]);
                      } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[14]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_6=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_6.setMaxlength("50");
                    __jsp_taghandler_6.setName("fecm008");
                    __jsp_taghandler_6.setOnblur(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_6.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].emailId"));
                    __jsp_taghandler_6.setStyle("width:90%");
                    __jsp_taghandler_6.setStyleClass("must");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[15]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_7=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleClass size");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_7.setName("fecm008");
                    __jsp_taghandler_7.setOnchange(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_7.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].recordStatus"));
                    __jsp_taghandler_7.setStyle("width:90%;height:20px;");
                    __jsp_taghandler_7.setStyleClass("must");
                    __jsp_taghandler_7.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[16]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_8=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                          __jsp_taghandler_8.setLabel("name");
                          __jsp_taghandler_8.setName("fecm008");
                          __jsp_taghandler_8.setProperty("recStatusValues");
                          __jsp_taghandler_8.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                          if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,4);
                        }
                        out.write(__oracle_jsp_text[17]);
                      } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_9.setName("fecm008");
                    __jsp_taghandler_9.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].status"));
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[19]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_10.setName("fecm008");
                    __jsp_taghandler_10.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].updTime"));
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[20]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_11.setName("fecm008");
                    __jsp_taghandler_11.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].recipientId"));
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[21]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[22]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[23]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[24][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<HTML xmlns=\"http://www.w3.org/1999/xhtml\">\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n\r\n\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n<HEAD>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n\r\n    <LINK REL=\"stylesheet\" HREF=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "/css/EZL.css\"/>\r\n    <!--meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\"/--> \r\n    <STYLE TYPE=\"text/css\">\r\n         div.search_result{height:100px;}\r\n         table.table_results tbody{height:100px;}\r\n    </STYLE>\r\n    <!--[if IE]>\r\n        <style type=\"text/css\">\r\n            div.search_result {\r\n                position: relative;\r\n                height: 180px;\r\n                width: 100%;\r\n                overflow-y: scroll;\r\n                overflow-x: hidden;\r\n            }\r\n            table.table_results{width:99%}\r\n           \r\n            table.table_results thead tr {\r\n                position: absolute;width:100%;\r\n                top: expression(this.offsetParent.scrollTop);\r\n            }\r\n            table.table_results tbody {\r\n                height: auto;\r\n            }\r\n            /*table.table_results tbody tr td.first_row {\r\n                padding-top: 24px;}*/}\r\n             table.header{width:99%; }             \r\n        </style>\r\n    <![endif]-->   \r\n    \r\n\r\n<SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\">\r\n    var FORM_ID       = 'fecm008';\r\n    var currselrowid  = 'row0';\r\n    \r\n    \r\n    /*Called by framework on-load of this JSP*/\r\n    function onLoad() {    \r\n    \r\n    }\r\n    \r\n    function openHelp() {\r\n        \r\n        var strFileName = '1';\r\n        var strUrl = \"/RCLWebApp/help/ApplicationHelp.htm#\"+strFileName;\r\n        var objWindow = window.open(strUrl,\"Help\",\"width=900,height=600,status=no,resizable=no,top=150,left=150\");\r\n        objWindow.focus();\r\n    }\r\n    \r\n    \r\n   \r\n     \r\n    /*To reset theoriginal search criteria before processing*/\r\n    function resetSearchCriteria() {\r\n        \r\n    }\r\n\t\r\n    function  addRow() {\r\n\t\tvar table     = document.getElementById(\"result_dtl\");\r\n\t\tvar totalRows = table.rows.length;\r\n\t\tvar rowIndex  = table.rows.length;\r\n\t\t\r\n\t\tvar type     = \"value[\"+rowIndex+\"].type\";\r\n\t\t\r\n\t\t//var nameSelect  = \"value[\"+ rowIndex  +\"].selected\";\t\r\n\t\t\r\n\t        \r\n\t\tvar statusValue = \"value[\"+rowIndex+\"].recordStatus\";\r\n\t\tvar row       = table.insertRow(totalRows);\r\n\t\trow.setAttribute(\"id\", \"row\"+rowIndex);\r\n\t\trow.setAttribute(\"height\", \"20px\");\r\n\t\t\r\n\t\tvar typeCell  = '<td><select name = ' +type + ' style=\"width:80%;height:20px\" size=\"1\" class=\"must\" >';\r\n\t\ttypeCell=  typeCell + '<option value=\"\">Select One...</option>'\r\n                            + '<option value=\"To\">To</option>'\r\n\t\t\t\t\t\t\t+ '<option value=\"Cc\">Cc</option>'\r\n\t\t\t\t\t\t\t+ '<option value=\"Bcc\">Bcc</option>';\r\n\t\ttypeCell = typeCell + '</select></td>';\r\n\t\tvar cell1 = row.insertCell(0);\r\n\t\tcell1.setAttribute(\"width\", \"20%\");\r\n\t\t//cell1.className = \"center\";\r\n\t\tcell1.innerHTML = typeCell;\r\n\t\t\r\n\t\tvar cell2 = row.insertCell(1);\r\n\t\tcell2.setAttribute(\"width\", \"60%\");\r\n\t\t//cell2.className = \"center\";\r\n\t\tcell2.innerHTML = \"<TD >\"+\r\n\t\t\t\t\t\t\t\t\"<input type='text' maxlength='50' value='' style='width:90%' class='must'  name='value[\"+rowIndex+\"].emailId' >\"+\r\n\t\t\t\t\t\t\t\t\"<input type='hidden' value='' name='value[\"+rowIndex+\"].recipientId' >\"+\r\n\t                        \"<input type='hidden' value='' name='value[\"+rowIndex+\"].updTime' >\"+\r\n\t\t\t\t\t\t\t\"<input type='hidden' value='ADD' name='value[\"+rowIndex+\"].status' >\"+\r\n\t\t\t\t\t\t\t\"</TD>\";\r\n\t\t\t\t\t\t\t\r\n\t\t\tvar statusCell  = '<td ><select name = ' +statusValue + ' size=\"1\" style=\"width:90%;height:20px\" class=\"must\" >';\r\n\t\tstatusCell=  statusCell + '<option value=\"A\">Active </option>'\r\n\t\t\t\t\t\t\t    + '<option value=\"S\">Suspended</option>';\r\n\t\tstatusCell = statusCell + '</select></td>';\r\n\t\tvar cell3 = row.insertCell(2);\r\n\t\t//cell2.setAttribute(\"width\", \"25%\");\r\n\t\t//cell3.className = \"center\";\r\n\t\tcell3.innerHTML = statusCell;\r\n\t\t\r\n\t\t\r\n\t\treturn false;\r\n\t\t\r\n\t}\r\n    \r\n\tfunction updateRecordStatus(arow) {\r\n\t\tvar lobjStatus = document.getElementById('value[' + arow + '].status');\r\n      var lstrstatus = lobjStatus.value;\r\n\t  if(lstrstatus == '') {\r\n             lobjStatus.value = UPD;\r\n             //Set status to upd\r\n           \r\n          }\r\n\t}\r\n\tfunction onSave() {\r\n\t\t\r\n\t\tvar ctr =0;\r\n\t\tvar table     = document.getElementById(\"result_dtl\");\r\n\t\tvar totalRows = table.rows.length;\r\n\t\tvar rowIndex  = table.rows.length;\r\n\t\t\r\n\t\tfor(ctr = 0 ; ctr<totalRows ;ctr++) {\r\n\t\t\r\n\t\t\tvar value = document.getElementById('value[' + ctr + '].type').value;\r\n\t\t\t\tif(value == '' || value.length == 0){\r\n\t\t\t\t\t   showBarMessage(ECM_SE0021,ERROR_MSG);\r\n\t\t\t\t\tdocument.getElementById('value[' + ctr + '].type').focus();\r\n\t\t\t\t\t\r\n\t\t\t\t\treturn ;\r\n\t\t\t\t}\r\n\t\t\tvar value = document.getElementById('value[' + ctr + '].emailId').value;\r\n\t\t\t\tif(value == '' || value.length == 0){\r\n\t\t\t\t\t\r\n                    showBarMessage(ECM_SE0022,ERROR_MSG);\r\n\t\t\t\t\tdocument.getElementById('value[' + ctr + '].emailId').focus();\r\n\t\t\t\t\treturn ;\r\n\t\t\t\t}\t\r\n\t\t\t\tvar obj = document.getElementById('value[' + ctr + '].emailId');\r\n\t\t\t\tif(!isValidEmailId(obj,'','')) {\r\n\t\t\t\tshowBarMessage(ECM_SE0026,ERROR_MSG);\r\n\t\t\t\tdocument.getElementById('value[' + ctr + '].emailId').focus();\r\n\t\t\t\t\treturn;\r\n\t\t\t\t}\r\n\t\t}\r\n        /* Disable all controls */\r\n        disableOnSubmit();  \r\n\t\tdocument.forms[0].action='".toCharArray();
    __oracle_jsp_text[7] = 
    "';\r\n        \r\n        document.forms[0].submit();\r\n        return false;\r\n\t}\r\n</SCRIPT>\r\n</HEAD>\r\n<BODY onload='javascript:onLoad()' onunload=\"javascript:doCloseAllChilds()\">\r\n<base target=\"_self\">\r\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n\r\n    ".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n    <div class=\"text_header\"><h2>Add/View Recipient</h2></div>\r\n    \r\n    <TABLE ID=\"result_hdr\" class=\"header\" BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" HEIGHT=\"80%\">\r\n            <THEAD>\r\n                <TR>\r\n                    <TH STYLE=\"WIDTH:20%\">Type</TH>\r\n                    <TH STYLE=\"WIDTH:60%\">Email ID </TH>\r\n                    <TH STYLE=\"WIDTH:20%\">Status</TH>\r\n                </TR>            \r\n            </THEAD>\r\n        </TABLE>\r\n\t\t\r\n\t\t<DIV ID=\"search_result\" CLASS=\"search_result\" STYLE=\"HEIGHT:300px\">\r\n        \r\n        <TABLE ID=\"result_dtl\" CLASS=\"table_results\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n      \r\n            <TBODY>\r\n            \r\n                ".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n                    <TR >\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<TD width=\"20%\" >\r\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\r\n\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t\t<TD width=\"60%\">\r\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t\t<TD  width=\"20%\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n\t\t\t\t\t\t</TD>\r\n                    </TR>\r\n                ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                \r\n            </TBODY>\r\n        </TABLE>\r\n        </DIV>\r\n        \r\n  <div class=\"buttons_box\">\r\n       <input type=\"button\" value=\"Add\" name=\"btnEdit\" class=\"event_btnbutton\" onclick='return addRow()'/>\r\n       <input type=\"button\" value=\"Save\" name=\"btnSave\" class=\"event_btnbutton\" onclick='return onSave()'/>\r\n    </div>\r\n <br>\r\n \r\n  \r\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n</BODY>\r\n</HTML>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

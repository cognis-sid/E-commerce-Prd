package _pages._ell;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.niit.control.common.GlobalConstants;
import com.niit.control.web.action.BaseAction;
import com.niit.control.web.UserAccountBean;
import com.niit.control.common.StringUtil;


public class _EllLoadListOverviewScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EllLoadListOverviewScn page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      
          boolean[] arrAuthFlags = BaseAction.getAuthFlags(request, "SELL001");
          boolean blnReadFlag     = arrAuthFlags[GlobalConstants.IDX_READ_FLAG];
          boolean blnNewFlag      = arrAuthFlags[GlobalConstants.IDX_NEW_FLAG];
          boolean blnEditFlag     = arrAuthFlags[GlobalConstants.IDX_EDIT_FLAG];
          boolean blnDelFlag      = arrAuthFlags[GlobalConstants.IDX_DEL_FLAG];
          String lstrCtxPath = request.getContextPath();
      
      out.write(__oracle_jsp_text[8]);
              
          String  strUserFsc  = null;
          UserAccountBean account = (UserAccountBean) session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
          strUserFsc = account.getUserFsc();
      
      out.write(__oracle_jsp_text[9]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[10]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sell001search", pageContext));
      out.write(__oracle_jsp_text[11]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sell001", pageContext));
      out.write(__oracle_jsp_text[12]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sell001search", pageContext));
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm004", pageContext));
      out.write(__oracle_jsp_text[14]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sell001search", pageContext));
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm011", pageContext));
      out.write(__oracle_jsp_text[16]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sell002", pageContext));
      out.write(__oracle_jsp_text[17]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/sell001");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[18]);
            out.write(__oracle_jsp_text[19]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("fell001");
              __jsp_taghandler_2.setProperty("searchPerformed");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[20]);
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("fell001");
              __jsp_taghandler_3.setProperty("selLoadListId");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[22]);
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("fell001");
              __jsp_taghandler_4.setProperty("selServiceCode");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[24]);
            out.write(__oracle_jsp_text[25]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("fell001");
              __jsp_taghandler_5.setProperty("selVesselCode");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[26]);
            out.write(__oracle_jsp_text[27]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("fell001");
              __jsp_taghandler_6.setProperty("selDirection");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[28]);
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("fell001");
              __jsp_taghandler_7.setProperty("selVoyageCode");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[30]);
            out.write(__oracle_jsp_text[31]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_8=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setName("fell001");
              __jsp_taghandler_8.setProperty("selPortSequenceNo");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[32]);
            out.write(__oracle_jsp_text[33]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setName("fell001");
              __jsp_taghandler_9.setProperty("selPortId");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[34]);
            out.write(__oracle_jsp_text[35]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("fell001");
              __jsp_taghandler_10.setProperty("selTerminalCode");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[36]);
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setName("fell001");
              __jsp_taghandler_11.setProperty("selBargeNo");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[38]);
            out.write(__oracle_jsp_text[39]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_12=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("fell001");
              __jsp_taghandler_12.setProperty("selETA");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[40]);
            out.write(__oracle_jsp_text[41]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_13=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("fell001");
              __jsp_taghandler_13.setProperty("selETD");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[42]);
            out.write(__oracle_jsp_text[43]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_14=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setName("fell001");
              __jsp_taghandler_14.setProperty("loadListCount");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[44]);
            out.write(__oracle_jsp_text[45]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_15=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setMaxlength("3");
              __jsp_taghandler_15.setName("fell001");
              __jsp_taghandler_15.setOnblur("changeUpper(this)");
              __jsp_taghandler_15.setProperty("serviceGroup");
              __jsp_taghandler_15.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[46]);
            out.write(__oracle_jsp_text[47]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_16=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setMaxlength("5");
              __jsp_taghandler_16.setName("fell001");
              __jsp_taghandler_16.setOnblur("changeUpper(this);");
              __jsp_taghandler_16.setProperty("serviceCd");
              __jsp_taghandler_16.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[48]);
            out.write(__oracle_jsp_text[49]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_17=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setMaxlength("5");
              __jsp_taghandler_17.setName("fell001");
              __jsp_taghandler_17.setOnblur("changeUpper(this);");
              __jsp_taghandler_17.setProperty("port");
              __jsp_taghandler_17.setStyle("width:75%");
              __jsp_taghandler_17.setStyleClass("must");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[50]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_18=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly styleClass value");
              __jsp_taghandler_18.setParent(__jsp_taghandler_1);
              __jsp_taghandler_18.setMaxlength("3");
              __jsp_taghandler_18.setName("fell001");
              __jsp_taghandler_18.setOnblur("changeUpper(this)");
              __jsp_taghandler_18.setProperty("fsc");
              __jsp_taghandler_18.setReadonly(true);
              __jsp_taghandler_18.setStyleClass("non_edit");
              __jsp_taghandler_18.setValue(OracleJspRuntime.toStr( strUserFsc));
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[51]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_19=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_19.setParent(__jsp_taghandler_1);
              __jsp_taghandler_19.setMaxlength("5");
              __jsp_taghandler_19.setName("fell001");
              __jsp_taghandler_19.setOnblur("changeUpper(this)");
              __jsp_taghandler_19.setProperty("vessel");
              __jsp_taghandler_19.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[52]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_20=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setMaxlength("10");
              __jsp_taghandler_20.setName("fell001");
              __jsp_taghandler_20.setOnblur("changeUpper(this)");
              __jsp_taghandler_20.setProperty("outVoyage");
              __jsp_taghandler_20.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[53]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_21=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setMaxlength("5");
              __jsp_taghandler_21.setName("fell001");
              __jsp_taghandler_21.setOnblur("changeUpper(this);");
              __jsp_taghandler_21.setProperty("terminal");
              __jsp_taghandler_21.setStyle("width:75%");
              __jsp_taghandler_21.setStyleClass("must");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[54]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_22=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setMaxlength("10");
              __jsp_taghandler_22.setName("fell001");
              __jsp_taghandler_22.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_22.setOnclick("this.select();");
              __jsp_taghandler_22.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_22.setProperty("fromEta");
              __jsp_taghandler_22.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[55]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[56]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_23=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setMaxlength("10");
              __jsp_taghandler_23.setName("fell001");
              __jsp_taghandler_23.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_23.setOnclick("this.select();");
              __jsp_taghandler_23.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_23.setProperty("toEta");
              __jsp_taghandler_23.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[57]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[58]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_24=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setMaxlength("10");
              __jsp_taghandler_24.setName("fell001");
              __jsp_taghandler_24.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_24.setOnclick("this.select();");
              __jsp_taghandler_24.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_24.setProperty("fromAta");
              __jsp_taghandler_24.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[59]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[60]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_25=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setMaxlength("10");
              __jsp_taghandler_25.setName("fell001");
              __jsp_taghandler_25.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_25.setOnclick("this.select();");
              __jsp_taghandler_25.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_25.setProperty("toAta");
              __jsp_taghandler_25.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[61]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[62]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_26=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style size");
              __jsp_taghandler_26.setParent(__jsp_taghandler_1);
              __jsp_taghandler_26.setName("fell001");
              __jsp_taghandler_26.setProperty("sortBy");
              __jsp_taghandler_26.setStyle("width:90%");
              __jsp_taghandler_26.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_26,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[63]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_27=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_27.setParent(__jsp_taghandler_26);
                    __jsp_taghandler_27.setLabel("name");
                    __jsp_taghandler_27.setName("fell001");
                    __jsp_taghandler_27.setProperty("sortByValues");
                    __jsp_taghandler_27.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                    if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,3);
                  }
                  out.write(__oracle_jsp_text[64]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[65]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_28=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setName("fell001");
              __jsp_taghandler_28.setProperty("sortIn");
              __jsp_taghandler_28.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_28,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[66]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_29=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_28);
                    __jsp_taghandler_29.setLabel("name");
                    __jsp_taghandler_29.setName("fell001");
                    __jsp_taghandler_29.setProperty("sortInValues");
                    __jsp_taghandler_29.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[67]);
                } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[68]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_30=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style styleClass size");
              __jsp_taghandler_30.setParent(__jsp_taghandler_1);
              __jsp_taghandler_30.setName("fell001");
              __jsp_taghandler_30.setProperty("loadlistStatus");
              __jsp_taghandler_30.setStyle("height:20px");
              __jsp_taghandler_30.setStyleClass("must");
              __jsp_taghandler_30.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_30,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[69]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_31=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_31.setParent(__jsp_taghandler_30);
                    __jsp_taghandler_31.setLabel("name");
                    __jsp_taghandler_31.setName("fell001");
                    __jsp_taghandler_31.setProperty("loadListStatusValues");
                    __jsp_taghandler_31.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
                    if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,3);
                  }
                  out.write(__oracle_jsp_text[70]);
                } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
            }
            out.write(__oracle_jsp_text[71]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_32=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style size");
              __jsp_taghandler_32.setParent(__jsp_taghandler_1);
              __jsp_taghandler_32.setName("fell001");
              __jsp_taghandler_32.setOnchange("changeViewCombo()");
              __jsp_taghandler_32.setProperty("view");
              __jsp_taghandler_32.setStyle("height:25px");
              __jsp_taghandler_32.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_32,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[72]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_33=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_33.setParent(__jsp_taghandler_32);
                    __jsp_taghandler_33.setLabel("name");
                    __jsp_taghandler_33.setName("fell001");
                    __jsp_taghandler_33.setProperty("viewListValues");
                    __jsp_taghandler_33.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
                    if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,3);
                  }
                  out.write(__oracle_jsp_text[73]);
                } while (__jsp_taghandler_32.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,2);
            }
            out.write(__oracle_jsp_text[74]);
            out.write(__oracle_jsp_text[75]);
            out.write(__oracle_jsp_text[76]);
            out.write(__oracle_jsp_text[77]);
            out.write(__oracle_jsp_text[78]);
            {
              String __url=OracleJspRuntime.toStr("../ell/EllLoadListOverviewGrid.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[79]);
            out.write(__oracle_jsp_text[80]);
            out.write(__oracle_jsp_text[81]);
            out.write(__oracle_jsp_text[82]);
            out.write(__oracle_jsp_text[83]);
            out.write(__oracle_jsp_text[84]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("fell001") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[85]);
            out.write(__oracle_jsp_text[86]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[87]);

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
  private static final char __oracle_jsp_text[][]=new char[88][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n<script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "/js/riaGridCommon.js\"></script>    \r\n<SCRIPT language=\"javascript\" type=\"text/javascript\">    \r\n    \r\n    var PROG_ID           = 'SELL001';\r\n    var FORM_ID           = 'fell001';\r\n    \r\n    var lastServiceGroup   = '';\r\n    var lastServiceCd    = '';\r\n    var lastPort         = '';\r\n    var lastTerminal     = '';\r\n    var lastFsc          = '';\r\n    var lastVessel       = '';\r\n    var lastOutVoyage     = '';\r\n    var lastFromEta      = '';\r\n    var lastToEta        = '';\r\n    var lastFromAta      = '';\r\n    var lastToAta        = '';\r\n    var lastStatus       = '';\r\n    var lastSortBy       = '';\r\n    var lastSortIn       = '';\r\n    var lastView         = '';\r\n    var searchPerformed  = \"false\";\r\n    var defaultFromEta   = '';\r\n    var defaultToEta     = '';\r\n    \r\n    \r\n    /*Called by framework on-load of this JSP*/\r\n    function onLoad() {  \r\n        \r\n        searchPerformed = document.getElementById(\"searchPerformed\").value;\r\n        \r\n        lastServiceGroup  = document.forms[0].serviceGroup.value;\r\n        lastServiceCd     = document.forms[0].serviceCd.value;\r\n        lastPort          = document.forms[0].port.value;\r\n        lastTerminal      = document.forms[0].terminal.value;\r\n        lastFsc           = document.forms[0].fsc.value;\r\n        lastVessel        = document.forms[0].vessel.value;\r\n        lastOutVoyage     = document.forms[0].outVoyage.value;\r\n        lastFromEta       = document.forms[0].fromEta.value;\r\n        lastToEta         = document.forms[0].toEta.value;\r\n        lastFromAta       = document.forms[0].fromAta.value;\r\n        lastToAta         = document.forms[0].toAta.value;\r\n        lastStatus        = document.forms[0].loadlistStatus.value;\r\n        lastSortBy        = document.forms[0].sortBy.value;\r\n        lastSortIn        = document.forms[0].sortIn.value;\r\n        lastView          = document.forms[0].view.value;\r\n        \r\n        if(searchPerformed == \"false\") {\r\n            defaultFromEta = document.forms[0].fromEta.value;\r\n            defaultToEta   = document.forms[0].toEta.value;\r\n        }\r\n        \r\n        /*Check the value of load list counter for radio button selected*/\r\n        if(document.forms[0].radioGroup1 != null){\r\n            if(document.forms[0].radioGroup1[0] != null){\r\n                for( i = 0; i < document.forms[0].radioGroup1.length; i++ )\r\n                {\r\n                    if(document.forms[0].radioGroup1[i].value == document.forms[0].loadListCount.value) {\r\n                  document.forms[0].radioGroup1[i].checked = 'true'; \r\n                    }\r\n                }\r\n            } else {\r\n                if(document.forms[0].radioGroup1.value == document.forms[0].loadListCount.value) {\r\n                    document.forms[0].radioGroup1.checked = 'true';\r\n                }\r\n            }\r\n        }\r\n        \r\n        //highlight the radio button acc to load list counter\r\n        \r\n        document.forms[0].serviceGroup.focus();\r\n        \r\n    }\r\n    \r\n    /*Called by framework for Pagination*/\r\n    function getActionUrl(){        \r\n        resetSearchCriteria();\r\n        //Set the load list counter to 0\r\n        document.forms[0].loadListCount.value= \"0\";\r\n        lstrUrl = '".toCharArray();
    __oracle_jsp_text[11] = 
    "';\r\n        document.forms[0].action=lstrUrl;\r\n        return lstrUrl;\r\n    }\r\n    \r\n    function openServiceGroupLookup(){\r\n            var rowId = FORM_ID;\r\n            openLookup(FORM_ID, rowId, MASTER_ID_SERVICE_GRP, '');\r\n    }\r\n    \r\n    function openServiceLookup(){\r\n            \r\n            var rowId = FORM_ID;\r\n            openLookup(FORM_ID, rowId, MASTER_ID_SERVICE, '');\r\n    }\r\n    \r\n    function openPortLookup(){\r\n            var rowId = FORM_ID;\r\n            openLookup(FORM_ID, rowId, MASTER_ID_PORT, '');\r\n    }\r\n    \r\n    function openTerminalLookup(){\r\n            var rowId = FORM_ID;\r\n            openLookup(FORM_ID, rowId, MASTER_ID_TERMINAL, '');\r\n    }\r\n    \r\n    \r\n    function openVesselLookup(){\r\n            var rowId = FORM_ID;            \r\n            openLookup(FORM_ID, rowId, MASTER_ID_VESSEL, '');\r\n    }\r\n\r\n    function openOutVoyageLookup(){\r\n            var rowId = FORM_ID;            \r\n            openLookup(FORM_ID, rowId, MASTER_ID_OUT_VOYAGE, '');\r\n    }\r\n\r\n    /*Called by master lookup screens to return selected values*/\r\n    function setLookupValues(aFormName, aRowId,strMasterId, arrResultData){\r\n    \r\n    \r\n        if(arrResultData[0] == FAILURE){\r\n            return;\r\n        }\r\n                        \r\n        if(strMasterId == MASTER_ID_SERVICE_GRP\r\n            || (strMasterId == MASTER_ID_SERVICE) \r\n            || (strMasterId == MASTER_ID_VESSEL)\r\n            || (strMasterId == MASTER_ID_OUT_VOYAGE)){\r\n            document.forms[0].serviceGroup.value=arrResultData[IDX_SRV_GRP_CD];\r\n            document.forms[0].serviceCd.value=arrResultData[IDX_SRV_CD];\r\n            document.forms[0].port.value=arrResultData[IDX_PRT_CD];\r\n            document.forms[0].terminal.value=arrResultData[IDX_TRM_CD];\r\n            document.forms[0].vessel.value=arrResultData[IDX_VSL_CD];\r\n            document.forms[0].outVoyage.value=arrResultData[IDX_OUT_VOY_CD];\r\n                \r\n        }  else if(strMasterId == MASTER_ID_PORT){            \r\n            //set Port       \r\n            document.forms[0].port.value=arrResultData[IDX_PORT_CD];\r\n        } else if(strMasterId == MASTER_ID_TERMINAL){\r\n            //set Terminal\r\n            document.forms[0].terminal.value=arrResultData[IDX_TRML_CD];\r\n        }  \r\n    }\r\n\r\n    \r\n    /*Called by framework on reset or refresh for reloading the page*/\r\n    function onResetForm(){\r\n        document.forms[0].currPageNo.value= 1;\r\n        document.forms[0].totRecord.value=0;\r\n        \r\n        //Set the DischargeList counter to 0\r\n        document.forms[0].loadListCount.value= \"0\";\r\n        //Setting the default values for controls\r\n        getGridSearchCriteria();\r\n        /*\r\n        document.forms[0].serviceGroup.value = \"\";\r\n        document.forms[0].serviceCd.value   = \"\";\r\n        document.forms[0].port.value        = \"\";\r\n        document.forms[0].terminal.value    = \"\";\r\n        document.forms[0].fsc.value         = \"\";\r\n        document.forms[0].vessel.value      = \"\";\r\n        document.forms[0].outVoyage.value    = \"\";\r\n        document.forms[0].fromEta.value     = defaultFromEta;\r\n        document.forms[0].toEta.value       = defaultToEta;\r\n        document.forms[0].fromAta.value     = \"\";\r\n        document.forms[0].toAta.value       = \"\";\r\n        document.forms[0].loadlistStatus.value   = lastStatus;\r\n        document.forms[0].sortBy.value      = lastSortBy;\r\n        document.forms[0].sortIn.value      = lastSortIn;\r\n        document.forms[0].view.value        = lastView;\r\n        \r\n        document.forms[0].action='".toCharArray();
    __oracle_jsp_text[12] = 
    "';        \r\n        document.forms[0].submit();        \r\n        */\r\n        return false;\r\n    }\r\n        \r\n    /*Called by Find Button*/\r\n    function onSearch() {\r\n       \r\n        //Clear the Data Table\r\n        //clearDiv('search_result');\r\n        clearDiv('fixedColumns_bodyDiv');\r\n        var strFromEta = document.forms[0].fromEta.value;\r\n        var strToEta = document.forms[0].toEta.value;\r\n        var strFromAta = document.forms[0].fromAta.value;\r\n        var strToAta = document.forms[0].toAta.value;\r\n       \r\n        if(!mandatoryCheckNoSpaces(document.forms[0].port)) {\r\n            showBarMessage(ELL_SE0001, ERROR_MSG);\r\n            document.forms[0].port.focus();\r\n            return false;\r\n        }\r\n        \r\n        //Check if Terminal is entered or not\r\n        if(!mandatoryCheckNoSpaces(document.forms[0].terminal)) {\r\n            showBarMessage(ELL_SE0002, ERROR_MSG);\r\n            document.forms[0].terminal.focus();\r\n            return false;\r\n        }\r\n        \r\n       if((!mandatoryCheckNoSpaces(document.forms[0].fromEta))\r\n            && (!mandatoryCheckNoSpaces(document.forms[0].toEta))\r\n            && (!mandatoryCheckNoSpaces(document.forms[0].fromAta))\r\n            &&  (!mandatoryCheckNoSpaces(document.forms[0].toAta)))  {\r\n            \r\n                showBarMessage(ELL_SE0017, ERROR_MSG);\r\n                document.forms[0].fromEta.focus();\r\n                return false;\r\n        } \r\n\r\n        if(((mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (!mandatoryCheckNoSpaces(document.forms[0].toEta)))\r\n            || (!mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (mandatoryCheckNoSpaces(document.forms[0].toEta))){\r\n                \r\n                if((!mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (mandatoryCheckNoSpaces(document.forms[0].toEta))) {\r\n                    showBarMessage(ELL_SE0008, ERROR_MSG);\r\n                    document.forms[0].fromEta.focus();\r\n                    return false;    \r\n               \r\n                } else if((mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (!mandatoryCheckNoSpaces(document.forms[0].toEta))) {\r\n                        showBarMessage(ELL_SE0009, ERROR_MSG);\r\n                        document.forms[0].toEta.focus();\r\n                        return false; \r\n                } else {\r\n                    if(!isValidDate(strFromEta)){\r\n                        showBarMessage(ELL_SE0010, ERROR_MSG);\r\n                        document.forms[0].fromEta.focus();\r\n                        return false;    \r\n                    }\r\n                    if(!isValidDate(strToEta)){\r\n                        showBarMessage(ELL_SE0011, ERROR_MSG);\r\n                        document.forms[0].toEta.focus();\r\n                        return false;    \r\n                    }\r\n                    //comapare both the dates\r\n                    if(strFromEta != \"\" && strToEta != \"\"){\r\n                        if(compareDate(strFromEta,strToEta,'1')){\r\n                            //Load List From Eta Date cannot be greater than To Eta Date\r\n                            showBarMessage(ELL_SE0014,ERROR_MSG);\r\n                            document.forms[0].fromEta.focus();\r\n                            return false;\r\n                        }\r\n                    }\r\n                \r\n                }\r\n        } \r\n    if(((mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (!mandatoryCheckNoSpaces(document.forms[0].toAta)))\r\n            || (!mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (mandatoryCheckNoSpaces(document.forms[0].toAta))) {\r\n                \r\n                if((!mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (mandatoryCheckNoSpaces(document.forms[0].toAta))) {\r\n                    showBarMessage(ELL_SE0005, ERROR_MSG);\r\n                    document.forms[0].fromAta.focus();\r\n                    return false;    \r\n               \r\n                } else if((mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (!mandatoryCheckNoSpaces(document.forms[0].toAta))) {\r\n                    showBarMessage(ELL_SE0006, ERROR_MSG);\r\n                    document.forms[0].toAta.focus();\r\n                    return false; \r\n                } else {\r\n                    if(!isValidDate(strFromAta)){\r\n                        showBarMessage(ELL_SE0012, ERROR_MSG);\r\n                        document.forms[0].fromAta.focus();\r\n                        return false;    \r\n                    }\r\n                    if(!isValidDate(strToAta)){\r\n                        showBarMessage(ELL_SE0013, ERROR_MSG);\r\n                        document.forms[0].toAta.focus();\r\n                        return false;    \r\n                    }\r\n                    //comapare both the dates\r\n                    if(strFromAta != \"\" && strToAta != \"\"){\r\n                        if(compareDate(strFromAta,strToAta,'1')){\r\n                            //Load List From Eta Date cannot be greater than To Eta Date\r\n                            showBarMessage(ELL_SE0015,ERROR_MSG);\r\n                            document.forms[0].fromAta.focus();\r\n                            return false;\r\n                        }\r\n                    }\r\n                \r\n                }\r\n        } \r\n        \r\n        \r\n        //Set search Performed to true\r\n        searchPerformed = \"true\";\r\n        //Set the LoadList counter to 0\r\n        document.forms[0].loadListCount.value= \"0\";\r\n        //set the action\r\n        document.forms[0].currPageNo.value= 1;\r\n        document.forms[0].action='".toCharArray();
    __oracle_jsp_text[13] = 
    "';\r\n        /* Disable all controls */\r\n        disableOnSubmit();\r\n        document.forms[0].submit();\r\n        return false;\r\n    }\r\n\r\n    \r\n    \r\n   function onSaveSett() {\r\n        var strSearchCriteria    = ''; \r\n       strSearchCriteria        = setSearchCriteria(); \r\n       var screenName           = '6';\r\n       var winName              = 'secm004';\r\n       \r\n       var pageId = document.getElementById(\"pageId\").value;\r\n       var viewId = document.getElementById(\"view\").value;\r\n       var urlStr = '".toCharArray();
    __oracle_jsp_text[14] = 
    "?screenName='+screenName+'&pageId='+pageId+'&searchCriteria='+strSearchCriteria+'&viewId='+viewId;\r\n       \r\n       getGridControl().updateServerModel();\r\n                    \r\n        document.forms[0].action='".toCharArray();
    __oracle_jsp_text[15] = 
    "';\r\n        document.forms[0].submit();\r\n    \r\n        //var responseMap= SweetDevRia.ComHelper.syncCallIAction (\"com.niit.control.common.ria.grid.common.ValidateMasterData\", {\"key\":\"UPDATED_GRID\",\"codeVal2\":pageId},null);\r\n        openChildWindow(urlStr,window,'500px','350px');\r\n            \r\n        onRefresh();\r\n        \r\n       return false;\r\n    }\r\n     \r\n    //--richa\r\n    /*Called by Refresh Button*/\r\n    function onRefresh() {\r\n         getGridSearchCriteria();\r\n         deleteGridRows();\r\n        document.forms[0].fsc.value = lastFsc;\r\n         onSearch();\r\n    }\r\n    \r\n    \r\n    \r\n    /*To reset theoriginal search criteria before processing*/\r\n    function resetSearchCriteria() {\r\n          document.forms[0].serviceGroup.value = lastServiceGroup;\r\n          document.forms[0].serviceCd.value  = lastServiceCd;\r\n          document.forms[0].port.value       = lastPort;\r\n          document.forms[0].terminal.value   = lastTerminal;\r\n          document.forms[0].fsc.value        = lastFsc;\r\n          document.forms[0].vessel.value     = lastVessel;\r\n          document.forms[0].outVoyage.value   = lastOutVoyage;\r\n          document.forms[0].fromEta.value    = lastFromEta;\r\n          document.forms[0].toEta.value      = lastToEta;\r\n          document.forms[0].fromAta.value    = lastFromAta;\r\n          document.forms[0].toAta.value      = lastToAta;\r\n          document.forms[0].loadlistStatus.value  = lastStatus;\r\n          document.forms[0].sortBy.value     = lastSortBy;\r\n          document.forms[0].sortIn.value     = lastSortIn;\r\n          document.forms[0].view.value       = lastView;\r\n    }\r\n    \r\n    function setRowData(){\r\n        var selRowNo = getCurrRowNo();\r\n        \r\n        document.forms[0].selLoadListId.value  = document.getElementById('value[' + selRowNo + '].loadListId').value;\r\n        document.forms[0].selServiceCode.value  = document.getElementById('value[' + selRowNo + '].serviceCd').value;\r\n        document.forms[0].selVesselCode.value = document.getElementById('value[' + selRowNo + '].vessel').value;\r\n        document.forms[0].selDirection.value  = document.getElementById('value[' + selRowNo + '].direction').value;\r\n        document.forms[0].selVoyageCode.value  = document.getElementById('value[' + selRowNo + '].outVoyage').value;\r\n        document.forms[0].selPortSequenceNo.value = document.getElementById('value[' + selRowNo + '].sequence').value;\r\n        document.forms[0].selPortId.value = document.getElementById('value[' + selRowNo + '].port').value;\r\n        document.forms[0].selTerminalCode.value = document.getElementById('value[' + selRowNo + '].terminal').value;\r\n        document.forms[0].selBargeNo.value = document.getElementById('value[' + selRowNo + '].bargeName').value;\r\n        document.forms[0].selETA.value = document.getElementById('value[' + selRowNo + '].fromEta').value;\r\n        document.forms[0].selETD.value = document.getElementById('value[' + selRowNo + '].toEta').value;\r\n        \r\n        //document.forms[0].selContractId.value  = document.getElementById('value[' + selRowNo + '].rowId').value;\r\n        //document.forms[0].selContractFsc.value = document.getElementById('value[' + selRowNo + '].fsc').value;\r\n    }\r\n    \r\n    function getSelRecStatus(){\r\n            var selRowNo = getCurrRowNo();\r\n            var recStatus = document.getElementById('value[' + selRowNo + '].loadlistStatus').value;\r\n            if (recStatus == ''){\r\n                    recStatus = REC_STATUS_SUSPEND;\r\n            }\r\n            return recStatus;\r\n    }\r\n    \r\n    /*Called by Create Arrival Bay Plan Button*/\r\n    function openCreateArrivalBayPlan() {\r\n        resetSearchCriteria();\r\n        var selectedIndex       = '';\r\n        var port                = '';\r\n        var terminal            = '';\r\n        var service             = '';\r\n        var vessel              = '';\r\n        var eta                 = '';\r\n        var voyage              = '';\r\n        var direction           = '';\r\n        var screenName          = '6';\r\n        var pageId              = '';\r\n        var viewId              = '';\r\n        var hdrEtaTm            = '';\r\n        var hdrEtdTm            = '';\r\n        var hdrEtaDateTime      = '';\r\n        var hdrEtdDateTime      = '';\r\n        var hdrEta              = '';\r\n        \r\n        \r\n        \r\n        \r\n        //If search not performed show error\r\n        searchPerformed = document.getElementById(\"searchPerformed\").value;\r\n                if(searchPerformed == \"false\") {\r\n                 showBarMessage(ECM_SE0007,ERROR_MSG);\r\n                 return false;\r\n                }\r\n                \r\n                if(document.forms[0].radioGroup1 != null){\r\n                    if(document.forms[0].radioGroup1[0] != null){\r\n                        for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {\r\n                            if(document.forms[0].radioGroup1[i].checked) {\r\n                                    selectedIndex = i;\r\n                            }\r\n                        }\r\n                    } else {\r\n            selectedIndex = 0;\r\n                    }\r\n                }\r\n                \r\n                //Call RiaGridCommon getSelectedRowData function to get the values of selected record in an array\r\n                rowData             =    getSelectedRowData(selectedIndex);\r\n                service = rowData[\"serviceCd\"];\r\n                port    = rowData[\"port\"];\r\n                terminal = rowData[\"terminal\"];\r\n                vessel = rowData[\"vessel\"];\r\n                voyage  = rowData[\"outVoyage\"];\r\n                direction = rowData[\"direction\"];\r\n                pageId  = document.getElementById(\"pageId\").value;\r\n                viewId  = document.getElementById(\"view\").value;\r\n                hdrEta            = rowData[\"toEta\"];\r\n                hdrEtaTm = document.getElementById('value[' + selectedIndex + '].etdTime').value;\r\n                hdrEtaDateTime = hdrEta;\r\n                hdrPortSeq          = rowData[\"sequence\"];                \r\n                \r\n                var urlStr = '".toCharArray();
    __oracle_jsp_text[16] = 
    "?screenName='+screenName+'&pageId='+pageId+'&arrivalPort='+port+'&arrivalTerminal='+terminal+'&viewId='+viewId+'&service='+service+'&vessel='+vessel+'&eta='+hdrEtaDateTime+'&voyage='+voyage+'&direction='+direction+'&portSeq='+hdrPortSeq+'&lldlflag=L';\r\n                \r\n                //openChildWindow(urlStr,window,'1000px','500px');\r\n                                openChildScreen64(urlStr,FORM_ID);\r\n                return false;\r\n    }\r\n    \r\n    function callLoadListMaintenance() {\r\n            resetSearchCriteria();\r\n        var rowData             = {};\r\n        var selectedIndex       = '';\r\n        var hdrService          = '';\r\n        var hdrVesselName       = '';\r\n        var hdrDirection        = '';\r\n        var hdrVoyage           = '';\r\n        var hdrPortSeq          = '';\r\n        var hdrPort             = '';\r\n        var hdrTerminal         = '';\r\n        var hdrBargeNameVoyage  = '';\r\n        var hdrEta              = '';\r\n        var hdrEtd              = '';\r\n        var loadlistStatus       = '';\r\n        var readOnlyFlg         = '';\r\n        var loadListId     = '';\r\n                var flag                = '';\r\n                var hdrEtaTm            = '';\r\n                var hdrEtdTm            = '';\r\n                var hdrEtaDateTime      = '';\r\n                var hdrEtdDateTime      = '';\r\n        var etaTmFlag            = 'N';\r\n        var etdTmFlag            = 'N';\r\n\r\n        \r\n                //If search not performed show error\r\n        searchPerformed = document.getElementById(\"searchPerformed\").value;\r\n                if(searchPerformed == \"false\") {\r\n                 showBarMessage(ECM_SE0007,ERROR_MSG);\r\n                 return false;\r\n                }\r\n        if(document.forms[0].radioGroup1 != null){\r\n                    if(document.forms[0].radioGroup1[0] != null){\r\n                        for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {\r\n                            if(document.forms[0].radioGroup1[i].checked) {\r\n                                    selectedIndex = i;\r\n                            }\r\n                        }\r\n                    } else {\r\n            selectedIndex = 0;\r\n                    }\r\n                }\r\n        flag = document.getElementById('value[' + selectedIndex + '].flag').value;\r\n        hdrEtaTm = document.getElementById('value[' + selectedIndex + '].etaTime').value;\r\n        hdrEtdTm = document.getElementById('value[' + selectedIndex + '].etdTime').value;\r\n\r\n        /* when Eta time and Etd time is null then pass 0000 to LL_MAINTENANCE screen. */\r\n        if ((hdrEtaTm == null) || (hdrEtaTm.length == 0)) {\r\n            etaTmFlag = 'Y';\r\n            hdrEtaTm = '0000';\r\n        }\r\n\r\n        if ((hdrEtdTm == null) || (hdrEtdTm.length == 0)) {\r\n            etdTmFlag = 'Y';\r\n            hdrEtdTm = '0000';\r\n        }\r\n\r\n        \r\n        //Call RiaGridCommon getSelectedRowData function to get the values of selected record in an array\r\n        rowData             =    getSelectedRowData(selectedIndex);\r\n        \r\n        hdrService          = rowData[\"serviceCd\"];\r\n        hdrVessel           = rowData[\"vessel\"];\r\n        hdrDirection        = rowData[\"direction\"];\r\n        hdrVoyage           = rowData[\"outVoyage\"];\r\n        hdrPortSeq          = rowData[\"sequence\"];\r\n        hdrPort             = rowData[\"port\"];\r\n        hdrTerminal         = rowData[\"terminal\"];\r\n        hdrBargeNameVoyage  = rowData[\"bargeName\"];\r\n        hdrEta                = rowData[\"fromEta\"];\r\n        hdrEtd              = rowData[\"toEta\"];\r\n        loadlistStatus         = lastStatus;\r\n        readOnlyFlg            = flag ;\r\n        loadListId             = document.getElementById('value[' + selectedIndex + '].loadListId').value;\r\n        var fromAta            = rowData[\"fromAta\"].substring(0, 10);\r\n        \r\n        var index1 = hdrEta.indexOf(\":\");\r\n        var index2 = hdrEtd.indexOf(\":\");\r\n        var index3 = hdrEta.indexOf(\" \");\r\n        var index4 = hdrEtd.indexOf(\" \");\r\n        \r\n        hdrEtaDateTime =  hdrEta;  \r\n        hdrEtdDateTime = hdrEtd;\r\n\r\n        if (etdTmFlag == 'N') {\r\n            hdrEta = hdrEta.substring(0,index3);\r\n        }\r\n        \r\n        if (etaTmFlag == 'N') {\r\n            hdrEtd = hdrEtd.substring(0,index4);\r\n        }\r\n\r\n        \r\n        var urlStr = '".toCharArray();
    __oracle_jsp_text[17] = 
    "?hdrService='+hdrService+'&hdrVessel='+hdrVessel+'&hdrDirection='+hdrDirection+'&hdrVoyage='+hdrVoyage+'&hdrPortSeq='+hdrPortSeq+'&hdrTerminal='+hdrTerminal+'&hdrBargeNameVoyage='+hdrBargeNameVoyage+'&hdrEta='+hdrEta+'&hdrEtd='+hdrEtd+'&loadListStatus='+loadlistStatus+'&readOnlyFlg='+readOnlyFlg+'&loadListId='+loadListId+'&hdrPort='+hdrPort+'&hdrEtaTm='+hdrEtaTm+'&hdrEtdTm='+hdrEtdTm+'&hdrEtaDateTime='+hdrEtaDateTime+'&hdrEtdDateTime='+hdrEtdDateTime+'&fromAta='+fromAta;\r\n                document.forms[0].action= urlStr;\r\n                document.forms[0].submit();\r\n                return false;\r\n    }\r\n    \r\n    function changeViewCombo()\r\n    {\r\n    \r\n        getGridSearchCriteria();\r\n        document.forms[0].fsc.value  = lastFsc;\r\n        \r\n    }\r\n    \r\n</SCRIPT>\r\n\r\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n        \r\n    ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n    <div class=\"text_header\"><h2>Search</h2></div>\r\n    <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n      <tr>\r\n        <td>Service Group</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n            <input type=\"button\" value=\". . .\" name=\"btnServiceGroupLookup\" class=\"btnbutton\" onclick='return openServiceGroupLookup()'/>\r\n        </td>\r\n        <td>Service</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n            <input type=\"button\" value=\". . .\" name=\"btnServiceLookup\" class=\"btnbutton\" onclick='return openServiceLookup()'/>\r\n        </td>\r\n        <td>Port</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[49] = 
    "           \r\n            ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n            <input type=\"button\" value=\". . .\" name=\"btnPortLookup\" class=\"btnbutton\" onclick='return openPortLookup()'/>\r\n        </td>\r\n        <td>FSC</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n            \r\n        </td>\r\n                \r\n      </tr>  \r\n      <tr>\r\n        \r\n        <td>Vessel</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n            <input type=\"button\" value=\". . .\" name=\"btnVesselLookup\" class=\"btnbutton\" onclick='return openVesselLookup()'/>\r\n        </td>\r\n        <td>Out Voyage</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n            <input type=\"button\" value=\". . .\" name=\"btnInVoyagelLookup\" class=\"btnbutton\" onclick='return openOutVoyageLookup()'/>\r\n        </td>\r\n        <td>Terminal</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n            <input type=\"button\" value=\". . .\" name=\"btnTerminalLookup\" class=\"btnbutton\" onclick='return openTerminalLookup()'/>\r\n            \r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td width=\"8%\">From ETA</td>\r\n        <td class=\"whitebg\" width=\"16%\">\r\n            ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n            <a href=\"#\" onClick=\"showCalendar('forms[0].fromEta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[56] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n        </td>\r\n        <td width=\"7%\">To ETA</td>\r\n        <td class=\"whitebg\" width=\"15%\">\r\n            ".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n            <a href=\"#\" onClick=\"showCalendar('forms[0].toEta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[58] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n        </td>\r\n        <td width=\"6%\">From ATA</td>\r\n        <td class=\"whitebg\" width=\"15%\">\r\n            ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n            <a href=\"#\" onClick=\"showCalendar('forms[0].fromAta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[60] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n        </td>\r\n        <td width=\"4%\">To ATA</td>\r\n        <td class=\"whitebg\" width=\"15%\">\r\n            ".toCharArray();
    __oracle_jsp_text[61] = 
    "\r\n            <a href=\"#\" onClick=\"showCalendar('forms[0].toAta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n        </td>\r\n      </tr>  \r\n      <tr height=\"25px\">\r\n        \r\n        <td >In</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n        </td>\r\n        <td>Sort Order</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[66] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n        </td>\r\n        <td>Status</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n         </td>\r\n        <td>View</td>\r\n        <td class=\"whitebg\">\r\n            ".toCharArray();
    __oracle_jsp_text[72] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[73] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[74] = 
    "  \r\n        </td>\r\n      </tr>\r\n    </table>\r\n    ".toCharArray();
    __oracle_jsp_text[75] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n    <div class=\"buttons_box\">\r\n        <input type=\"button\" value=\"Create Arrival Bay Plan\" name=\"btnCreateBayPlan\" class=\"event_btnbutton\" onclick='return openCreateArrivalBayPlan()'/>\r\n        <input type=\"button\" value=\"Save Sett.\" name=\"btnSaveSett\" class=\"event_btnbutton\" onclick='return onSaveSett()'/>\r\n        <input type=\"button\" value=\"Refresh\" name=\"btnRefresh\" class=\"event_btnbutton\" onclick='return onRefresh()'/>\r\n        <input type=\"button\" value=\"Reset\" name=\"btnReset\" class=\"event_btnbutton\" onclick='return onResetForm()'/>\r\n        <input type=\"button\" value=\"Find\" name=\"btnFind\" class=\"event_btnbutton\" onclick='return onSearch()'/>\r\n    </div>\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[77] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n    \r\n    <div class=\"text_header\"><h2>Search Result</h2></div>      \r\n         ".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n   \r\n      </div>\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[80] = 
    "  \r\n      \r\n    ".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n    \r\n    <div class=\"buttons_box\">\r\n        <div id=\"editDiv\">\r\n        <input type=\"button\" value=\"Edit\" name=\"btnEdit\" class=\"event_btnbutton\" onclick='return callLoadListMaintenance()'/>\r\n        </div>\r\n    </div>\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[86] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[87] = 
    "\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

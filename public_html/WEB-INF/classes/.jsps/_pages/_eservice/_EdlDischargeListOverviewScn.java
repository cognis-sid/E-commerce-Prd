package _pages._eservice;

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


public class _EdlDischargeListOverviewScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EdlDischargeListOverviewScn page = this;
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
      
          boolean[] arrAuthFlags = BaseAction.getAuthFlags(request, "SEDL001");
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
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sedl001search", pageContext));
      out.write(__oracle_jsp_text[11]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sedl001", pageContext));
      out.write(__oracle_jsp_text[12]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sedl001search", pageContext));
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm004", pageContext));
      out.write(__oracle_jsp_text[14]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sedl001search", pageContext));
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm011", pageContext));
      out.write(__oracle_jsp_text[16]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/sedl002", pageContext));
      out.write(__oracle_jsp_text[17]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/sedl001");
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
              __jsp_taghandler_2.setName("fedl001");
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
              __jsp_taghandler_3.setName("fedl001");
              __jsp_taghandler_3.setProperty("selDischargeListId");
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
              __jsp_taghandler_4.setName("fedl001");
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
              __jsp_taghandler_5.setName("fedl001");
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
              __jsp_taghandler_6.setName("fedl001");
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
              __jsp_taghandler_7.setName("fedl001");
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
              __jsp_taghandler_8.setName("fedl001");
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
              __jsp_taghandler_9.setName("fedl001");
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
              __jsp_taghandler_10.setName("fedl001");
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
              __jsp_taghandler_11.setName("fedl001");
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
              __jsp_taghandler_12.setName("fedl001");
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
              __jsp_taghandler_13.setName("fedl001");
              __jsp_taghandler_13.setProperty("selETD");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[42]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_14=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setName("fedl001");
              __jsp_taghandler_14.setProperty("selATA");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[43]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_15=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setName("fedl001");
              __jsp_taghandler_15.setProperty("selATD");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[44]);
            out.write(__oracle_jsp_text[45]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_16=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setName("fedl001");
              __jsp_taghandler_16.setProperty("dischargeListCount");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[46]);
            out.write(__oracle_jsp_text[47]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_17=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setMaxlength("3");
              __jsp_taghandler_17.setName("fedl001");
              __jsp_taghandler_17.setOnblur("changeUpper(this)");
              __jsp_taghandler_17.setProperty("serviceGroup");
              __jsp_taghandler_17.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[48]);
            out.write(__oracle_jsp_text[49]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_18=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_18.setParent(__jsp_taghandler_1);
              __jsp_taghandler_18.setMaxlength("5");
              __jsp_taghandler_18.setName("fedl001");
              __jsp_taghandler_18.setOnblur("changeUpper(this);");
              __jsp_taghandler_18.setProperty("serviceCd");
              __jsp_taghandler_18.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[50]);
            out.write(__oracle_jsp_text[51]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_19=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
              __jsp_taghandler_19.setParent(__jsp_taghandler_1);
              __jsp_taghandler_19.setMaxlength("5");
              __jsp_taghandler_19.setName("fedl001");
              __jsp_taghandler_19.setOnblur("changeUpper(this);");
              __jsp_taghandler_19.setProperty("port");
              __jsp_taghandler_19.setStyle("width:75%");
              __jsp_taghandler_19.setStyleClass("must");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[52]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_20=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly styleClass value");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setMaxlength("3");
              __jsp_taghandler_20.setName("fedl001");
              __jsp_taghandler_20.setOnblur("changeUpper(this)");
              __jsp_taghandler_20.setProperty("fsc");
              __jsp_taghandler_20.setReadonly(true);
              __jsp_taghandler_20.setStyleClass("non_edit");
              __jsp_taghandler_20.setValue(OracleJspRuntime.toStr( strUserFsc));
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[53]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_21=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setMaxlength("5");
              __jsp_taghandler_21.setName("fedl001");
              __jsp_taghandler_21.setOnblur("changeUpper(this)");
              __jsp_taghandler_21.setProperty("vessel");
              __jsp_taghandler_21.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[54]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_22=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setMaxlength("10");
              __jsp_taghandler_22.setName("fedl001");
              __jsp_taghandler_22.setOnblur("changeUpper(this)");
              __jsp_taghandler_22.setProperty("inVoyage");
              __jsp_taghandler_22.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[55]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_23=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setMaxlength("5");
              __jsp_taghandler_23.setName("fedl001");
              __jsp_taghandler_23.setOnblur("changeUpper(this);");
              __jsp_taghandler_23.setProperty("terminal");
              __jsp_taghandler_23.setStyle("width:75%");
              __jsp_taghandler_23.setStyleClass("must");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[56]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_24=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setMaxlength("10");
              __jsp_taghandler_24.setName("fedl001");
              __jsp_taghandler_24.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_24.setOnclick("this.select();");
              __jsp_taghandler_24.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_24.setProperty("fromEta");
              __jsp_taghandler_24.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[57]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[58]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_25=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setMaxlength("10");
              __jsp_taghandler_25.setName("fedl001");
              __jsp_taghandler_25.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_25.setOnclick("this.select();");
              __jsp_taghandler_25.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_25.setProperty("toEta");
              __jsp_taghandler_25.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[59]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[60]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_26=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_26.setParent(__jsp_taghandler_1);
              __jsp_taghandler_26.setMaxlength("10");
              __jsp_taghandler_26.setName("fedl001");
              __jsp_taghandler_26.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_26.setOnclick("this.select();");
              __jsp_taghandler_26.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_26.setProperty("fromAta");
              __jsp_taghandler_26.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[61]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[62]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_27=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeypress property style");
              __jsp_taghandler_27.setParent(__jsp_taghandler_1);
              __jsp_taghandler_27.setMaxlength("10");
              __jsp_taghandler_27.setName("fedl001");
              __jsp_taghandler_27.setOnblur("dateFormat(this,this.value,event,true,1,document.all('msg'));");
              __jsp_taghandler_27.setOnclick("this.select();");
              __jsp_taghandler_27.setOnkeypress("dateFormat(this,this.value,event,false,1,document.all('msg'));");
              __jsp_taghandler_27.setProperty("toAta");
              __jsp_taghandler_27.setStyle("width:75%");
              __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
              if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,2);
            }
            out.write(__oracle_jsp_text[63]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[64]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_28=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setName("fedl001");
              __jsp_taghandler_28.setProperty("sortBy");
              __jsp_taghandler_28.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_28,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[65]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_29=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_28);
                    __jsp_taghandler_29.setLabel("name");
                    __jsp_taghandler_29.setName("fedl001");
                    __jsp_taghandler_29.setProperty("sortByValues");
                    __jsp_taghandler_29.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[66]);
                } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[67]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_30=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_30.setParent(__jsp_taghandler_1);
              __jsp_taghandler_30.setName("fedl001");
              __jsp_taghandler_30.setProperty("sortIn");
              __jsp_taghandler_30.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_30,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[68]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_31=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_31.setParent(__jsp_taghandler_30);
                    __jsp_taghandler_31.setLabel("name");
                    __jsp_taghandler_31.setName("fedl001");
                    __jsp_taghandler_31.setProperty("sortInValues");
                    __jsp_taghandler_31.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
                    if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,3);
                  }
                  out.write(__oracle_jsp_text[69]);
                } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
            }
            out.write(__oracle_jsp_text[70]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_32=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style styleClass size");
              __jsp_taghandler_32.setParent(__jsp_taghandler_1);
              __jsp_taghandler_32.setName("fedl001");
              __jsp_taghandler_32.setProperty("dischargelistStatus");
              __jsp_taghandler_32.setStyle("height:20px");
              __jsp_taghandler_32.setStyleClass("must");
              __jsp_taghandler_32.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_32,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[71]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_33=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_33.setParent(__jsp_taghandler_32);
                    __jsp_taghandler_33.setLabel("name");
                    __jsp_taghandler_33.setName("fedl001");
                    __jsp_taghandler_33.setProperty("dischargeListStatusValues");
                    __jsp_taghandler_33.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
                    if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,3);
                  }
                  out.write(__oracle_jsp_text[72]);
                } while (__jsp_taghandler_32.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,2);
            }
            out.write(__oracle_jsp_text[73]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_34=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property size");
              __jsp_taghandler_34.setParent(__jsp_taghandler_1);
              __jsp_taghandler_34.setName("fedl001");
              __jsp_taghandler_34.setOnchange("changeViewCombo()");
              __jsp_taghandler_34.setProperty("view");
              __jsp_taghandler_34.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_34,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[74]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_35=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_35.setParent(__jsp_taghandler_34);
                    __jsp_taghandler_35.setLabel("name");
                    __jsp_taghandler_35.setName("fedl001");
                    __jsp_taghandler_35.setProperty("viewListValues");
                    __jsp_taghandler_35.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
                    if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,3);
                  }
                  out.write(__oracle_jsp_text[75]);
                } while (__jsp_taghandler_34.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,2);
            }
            out.write(__oracle_jsp_text[76]);
            out.write(__oracle_jsp_text[77]);
            out.write(__oracle_jsp_text[78]);
            out.write(__oracle_jsp_text[79]);
            out.write(__oracle_jsp_text[80]);
            {
              String __url=OracleJspRuntime.toStr("../edl/EdlDischargeListOverviewGrid.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[81]);
            out.write(__oracle_jsp_text[82]);
            out.write(__oracle_jsp_text[83]);
            out.write(__oracle_jsp_text[84]);
            out.write(__oracle_jsp_text[85]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("fedl001") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[86]);
            out.write(__oracle_jsp_text[87]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[88]);

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
  private static final char __oracle_jsp_text[][]=new char[89][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "/js/riaGridCommon.js\"></script>\n<SCRIPT language=\"javascript\" type=\"text/javascript\">\n\n    var PROG_ID           = 'SEDL001';\n    var FORM_ID           = 'fedl001';\n\n    var lastServiceGroup   = '';\n    var lastServiceCd      = '';\n    var lastPort           = '';\n    var lastTerminal       = '';\n    var lastFsc            = '';\n    var lastVessel         = '';\n    var lastInVoyage       = '';\n    var lastFromEta        = '';\n    var lastToEta          = '';\n    var lastFromAta        = '';\n    var lastToAta          = '';\n    var lastStatus         = '';\n    var lastSortBy         = '';\n    var lastSortIn         = '';\n    var lastView           = '';\n    var searchPerformed    = \"\";\n    var defaultFromETA     = '';\n    var defaultToETA       = '';\n\n    /*Called by framework on-load of this JSP*/\n    function onLoad() {\n\n    searchPerformed   = document.getElementById(\"searchPerformed\").value;\n        lastServiceGroup  = document.forms[0].serviceGroup.value;\n        lastServiceCd     = document.forms[0].serviceCd.value;\n        lastPort          = document.forms[0].port.value;\n        lastTerminal      = document.forms[0].terminal.value;\n        lastFsc           = document.forms[0].fsc.value;\n        lastVessel        = document.forms[0].vessel.value;\n        lastInVoyage      = document.forms[0].inVoyage.value;\n        lastFromEta       = document.forms[0].fromEta.value;\n        lastToEta         = document.forms[0].toEta.value;\n        lastFromAta       = document.forms[0].fromAta.value;\n        lastToAta         = document.forms[0].toAta.value;\n        lastStatus        = document.forms[0].dischargelistStatus.value;\n        lastSortBy        = document.forms[0].sortBy.value;\n        lastSortIn        = document.forms[0].sortIn.value;\n        lastView          = document.forms[0].view.value;\n\n        if(searchPerformed == \"false\") {\n            defaultFromETA = document.forms[0].fromEta.value;\n            defaultToETA   = document.forms[0].toAta.value;\n        }\n\n        /*Check the value of contact counter for radio button selected*/\n        if(document.forms[0].radioGroup1 != null){\n            if(document.forms[0].radioGroup1[0] != null){\n                for( i = 0; i < document.forms[0].radioGroup1.length; i++ )\n                {\n                    if(document.forms[0].radioGroup1[i].value == document.forms[0].dischargeListCount.value) {\n                  document.forms[0].radioGroup1[i].checked = 'true';\n                    }\n                }\n            } else {\n                if(document.forms[0].radioGroup1.value == document.forms[0].dischargeListCount.value) {\n                    document.forms[0].radioGroup1.checked = 'true';\n                }\n            }\n        }\n\n        document.forms[0].serviceGroup.focus();\n    }\n\n    /*Called by framework for Pagination*/\n    function getActionUrl(){\n        resetSearchCriteria();\n        //Set the Discharge counter to 0\n        document.forms[0].dischargeListCount.value= \"0\";\n        lstrUrl = '".toCharArray();
    __oracle_jsp_text[11] = 
    "';\n        document.forms[0].action=lstrUrl;\n        return lstrUrl;\n    }\n\n    function openServiceGroupLookup(){\n            var rowId = FORM_ID;\n            openLookup(FORM_ID, rowId, MASTER_ID_SERVICE_GRP, '');\n    }\n\n    function openServiceLookup(){\n            var rowId = FORM_ID;\n            openLookup(FORM_ID, rowId, MASTER_ID_SERVICE, '');\n    }\n\n    function openPortLookup(){\n            var rowId = FORM_ID;\n            openLookup(FORM_ID, rowId, MASTER_ID_PORT, '');\n    }\n\n    function openTerminalLookup(){\n            var rowId = FORM_ID;\n            openLookup(FORM_ID, rowId, MASTER_ID_TERMINAL, '');\n    }\n\n\n\n    function openVesselLookup(){\n            var rowId = FORM_ID;\n            openLookup(FORM_ID, rowId, MASTER_ID_VESSEL, '');\n    }\n\n    function openInVoyageLookup(){\n            var rowId = FORM_ID;\n            openLookup(FORM_ID, rowId, MASTER_ID_IN_VOYAGE, '');\n    }\n\n    /*Called by master lookup screens to return selected values*/\n    function setLookupValues(aFormName, aRowId,strMasterId, arrResultData){\n\n        if(arrResultData[0] == FAILURE){\n            return;\n        }\n\n        if((strMasterId == MASTER_ID_SERVICE_GRP)\n            || (strMasterId == MASTER_ID_SERVICE)\n            || (strMasterId == MASTER_ID_VESSEL)\n            || (strMasterId == MASTER_ID_IN_VOYAGE)){\n                //Setting Service Group,Service Code, Port, Terminal, Vessel and InVoyage\n                document.forms[0].serviceGroup.value=arrResultData[IDX_SRV_GRP_CD];\n                document.forms[0].serviceCd.value=arrResultData[IDX_SRV_CD];\n                document.forms[0].port.value=arrResultData[IDX_PRT_CD];\n                document.forms[0].terminal.value=arrResultData[IDX_TRM_CD];\n                document.forms[0].vessel.value=arrResultData[IDX_VSL_CD];\n                document.forms[0].inVoyage.value=arrResultData[IDX_IN_VOY_CD];\n        }  else if(strMasterId == MASTER_ID_PORT){\n                //set Port\n                document.forms[0].port.value=arrResultData[IDX_VND_CD];\n        } else if(strMasterId == MASTER_ID_FSC){\n                //set fsc code\n                document.forms[0].fsc.value=arrResultData[IDX_FSC_CD];\n        } else if(strMasterId == MASTER_ID_TERMINAL){\n                //set Terminal\n                document.forms[0].terminal.value=arrResultData[IDX_VND_CD];\n        }\n    }\n\n    /*Called by framework on reset or refresh for reloading the page*/\n    function onResetForm(){\n        document.forms[0].currPageNo.value= 1;\n        document.forms[0].totRecord.value=0;\n\n        //Set the DischargeList counter to 0\n        document.forms[0].dischargeListCount.value= \"0\";\n        //Setting the default values for controls\n        getGridSearchCriteria();\n        /*\n        document.forms[0].serviceGroup.value = \"\";\n        document.forms[0].serviceCd.value   = \"\";\n        document.forms[0].port.value        = \"\";\n        document.forms[0].terminal.value    = \"\";\n        document.forms[0].vessel.value      = \"\";\n        document.forms[0].inVoyage.value    = \"\";\n        document.forms[0].fromEta.value     = defaultFromETA;\n        document.forms[0].toEta.value       = defaultToETA;\n        document.forms[0].fromAta.value     = \"\";\n        document.forms[0].toAta.value       = \"\";\n        document.forms[0].dischargelistStatus.value   = lastStatus;\n        document.forms[0].sortBy.value      = lastSortBy;\n        document.forms[0].sortIn.value      = lastSortIn;\n        document.forms[0].view.value        = lastView;\n\n        */\n        //document.forms[0].action='".toCharArray();
    __oracle_jsp_text[12] = 
    "';\n        //document.forms[0].submit();\n        return false;\n    }\n\n    /*Called by Find Button*/\n    function onSearch() {\n        //Clear the Data Table\n        clearDiv('fixedColumns_bodyDiv');\n        //Check if Port is entered or not\n\n         var  strFromEta = document.forms[0].fromEta.value;\n         var  strToEta   = document.forms[0].toEta.value;\n\n        if(!mandatoryCheckNoSpaces(document.forms[0].port)) {\n            showBarMessage(ELL_SE0001, ERROR_MSG);\n            document.forms[0].port.focus();\n            return false;\n        }\n\n        //Check if Terminal is entered or not\n        if(!mandatoryCheckNoSpaces(document.forms[0].terminal)) {\n            showBarMessage(ELL_SE0002, ERROR_MSG);\n            document.forms[0].terminal.focus();\n            return false;\n        }\n\n       if((!mandatoryCheckNoSpaces(document.forms[0].fromEta))\n            && (!mandatoryCheckNoSpaces(document.forms[0].toEta))\n            && (!mandatoryCheckNoSpaces(document.forms[0].fromAta))\n            &&  (!mandatoryCheckNoSpaces(document.forms[0].toAta)))  {\n\n                showBarMessage(ELL_SE0017, ERROR_MSG);\n                document.forms[0].fromEta.focus();\n                return false;\n        }\n\n        if(((mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (!mandatoryCheckNoSpaces(document.forms[0].toEta)))\n            || (!mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (mandatoryCheckNoSpaces(document.forms[0].toEta))){\n\n                if((!mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (mandatoryCheckNoSpaces(document.forms[0].toEta))) {\n                    showBarMessage(ELL_SE0008, ERROR_MSG);\n                    document.forms[0].fromEta.focus();\n                    return false;\n\n                } else if((mandatoryCheckNoSpaces(document.forms[0].fromEta)) && (!mandatoryCheckNoSpaces(document.forms[0].toEta))) {\n                        showBarMessage(ELL_SE0009, ERROR_MSG);\n                        document.forms[0].toEta.focus();\n                        return false;\n                } else {\n                    if(!isValidDate(strFromEta)){\n                        showBarMessage(ELL_SE0010, ERROR_MSG);\n                        document.forms[0].fromEta.focus();\n                        return false;\n                    }\n                    if(!isValidDate(strToEta)){\n                        showBarMessage(ELL_SE0011, ERROR_MSG);\n                        document.forms[0].toEta.focus();\n                        return false;\n                    }\n                    //comapare both the dates\n                    if(strFromEta != \"\" && strToEta != \"\"){\n                        if(compareDate(strFromEta,strToEta,'1')){\n                            //Load List From Eta Date cannot be greater than To Eta Date\n                            showBarMessage(ELL_SE0014,ERROR_MSG);\n                            document.forms[0].fromEta.focus();\n                            return false;\n                        }\n                    }\n\n                }\n        }\n    if(((mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (!mandatoryCheckNoSpaces(document.forms[0].toAta)))\n            || (!mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (mandatoryCheckNoSpaces(document.forms[0].toAta))) {\n\n                if((!mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (mandatoryCheckNoSpaces(document.forms[0].toAta))) {\n                    showBarMessage(ELL_SE0005, ERROR_MSG);\n                    document.forms[0].fromAta.focus();\n                    return false;\n\n                } else if((mandatoryCheckNoSpaces(document.forms[0].fromAta)) && (!mandatoryCheckNoSpaces(document.forms[0].toAta))) {\n                    showBarMessage(ELL_SE0006, ERROR_MSG);\n                    document.forms[0].toAta.focus();\n                    return false;\n                } else {\n                    if(!isValidDate(strFromAta)){\n                        showBarMessage(ELL_SE0012, ERROR_MSG);\n                        document.forms[0].fromAta.focus();\n                        return false;\n                    }\n                    if(!isValidDate(strToAta)){\n                        showBarMessage(ELL_SE0013, ERROR_MSG);\n                        document.forms[0].toAta.focus();\n                        return false;\n                    }\n                    //comapare both the dates\n                    if(strFromAta != \"\" && strToAta != \"\"){\n                        if(compareDate(strFromAta,strToAta,'1')){\n                            //Load List From Eta Date cannot be greater than To Eta Date\n                            showBarMessage(ELL_SE0015,ERROR_MSG);\n                            document.forms[0].fromAta.focus();\n                            return false;\n                        }\n                    }\n\n                }\n        }\n\n\n        //Set the DischargeList counter to 0\n        document.forms[0].dischargeListCount.value= \"0\";\n        //set the action\n        document.getElementById(\"currPageNo\").value= 1;\n        document.forms[0].action='".toCharArray();
    __oracle_jsp_text[13] = 
    "';\n        /* Disable all controls */\n        disableOnSubmit();\n        document.forms[0].submit();\n        return false;\n    }\n\n    function onSaveSett() {\n\n           var strSearchCriteria    = '';\n           strSearchCriteria        = setSearchCriteria();\n           var screenName           = '1';\n           var winName              = 'secm004';\n\n           var pageId = document.getElementById(\"pageId\").value;\n           var viewId = document.getElementById(\"view\").value;\n           var urlStr = '".toCharArray();
    __oracle_jsp_text[14] = 
    "?screenName='+screenName+'&pageId='+pageId+'&searchCriteria='+strSearchCriteria+'&viewId='+viewId;\n\n           getGridControl().updateServerModel();\n\n           document.forms[0].action='".toCharArray();
    __oracle_jsp_text[15] = 
    "';\n           document.forms[0].submit();\n\n           //var responseMap= SweetDevRia.ComHelper.syncCallIAction (\"com.niit.control.common.ria.grid.common.ValidateMasterData\", {\"key\":\"UPDATED_GRID\",\"codeVal2\":pageId},null);\n           openChildWindow(urlStr,window,'500px','350px');\n\n           onRefresh();\n           return false;\n    }\n\n    //--richa\n    /*Called by Refresh Button*/\n    function onRefresh() {\n         getGridSearchCriteria();\n        deleteGridRows();\n        document.forms[0].fsc.value = lastFsc;\n         onSearch();\n    }\n    /*\n    function deleteGridRows() {\n\n            var objGrid = getGridControl();\n            for(i=0; i<mintTotalRows; i++){\n                if(objGrid.data[i][0] != null){\n                    deleteRowFromRiaGrid(objGrid,\"row\"+i);\n                }\n            }\n        }\n\n        */\n    /*Called by Back Button of Header */\n    function onBack(){\n        //Not Applicable for this screen\n    }\n\n    /*To reset theoriginal search criteria before processing*/\n    function resetSearchCriteria() {\n          document.forms[0].serviceGroup.value = lastServiceGroup;\n          document.forms[0].serviceCd.value  = lastServiceCd;\n          document.forms[0].port.value       = lastPort;\n          document.forms[0].terminal.value   = lastTerminal;\n          document.forms[0].fsc.value        = lastFsc;\n          document.forms[0].vessel.value     = lastVessel;\n          document.forms[0].inVoyage.value   = lastInVoyage;\n          document.forms[0].fromEta.value    = lastFromEta;\n          document.forms[0].toEta.value      = lastToEta;\n          document.forms[0].fromAta.value    = lastFromAta;\n          document.forms[0].toAta.value      = lastToAta;\n          document.forms[0].dischargelistStatus.value  = lastStatus;\n          document.forms[0].sortBy.value     = lastSortBy;\n          document.forms[0].sortIn.value     = lastSortIn;\n          document.forms[0].view.value       = lastView;\n    }\n\n\n\n    function setRowData(){\n        var selRowNo = getCurrRowNo();\n\n        document.forms[0].selDischargeListId.value  = document.getElementById('value[' + selRowNo + '].dischargeListId').value;\n        document.forms[0].selServiceCode.value  = document.getElementById('value[' + selRowNo + '].serviceCd').value;\n        document.forms[0].selVesselCode.value = document.getElementById('value[' + selRowNo + '].vessel').value;\n        document.forms[0].selDirection.value  = document.getElementById('value[' + selRowNo + '].direction').value;\n        document.forms[0].selVoyageCode.value  = document.getElementById('value[' + selRowNo + '].inVoyage').value;\n        document.forms[0].selPortSequenceNo.value = document.getElementById('value[' + selRowNo + '].sequence').value;\n        document.forms[0].selPortId.value = document.getElementById('value[' + selRowNo + '].port').value;\n        document.forms[0].selTerminalCode.value = document.getElementById('value[' + selRowNo + '].terminal').value;\n        document.forms[0].selBargeNo.value = document.getElementById('value[' + selRowNo + '].bargeName').value;\n        document.forms[0].selETA.value = document.getElementById('value[' + selRowNo + '].fromEta').value;\n        document.forms[0].selETD.value = document.getElementById('value[' + selRowNo + '].toEta').value;\n        document.forms[0].selATA.value = document.getElementById('value[' + selRowNo + '].ataTime').value;\n        document.forms[0].selATD.value = document.getElementById('value[' + selRowNo + '].atdTime').value;\n\n    }\n\n    function getSelRecStatus(){\n            var selRowNo = getCurrRowNo();\n            var recStatus = document.getElementById('value[' + selRowNo + '].dischargelistStatus').value;\n            if (recStatus == ''){\n                    recStatus = REC_STATUS_SUSPEND;\n            }\n            return recStatus;\n    }\n\n    /*Called by Create Arrival Bay Plan Button*/\n    function openCreateArrivalBayPlan() {\n        resetSearchCriteria();\n        var selectedIndex       = '';\n        var port                = '';\n        var terminal            = '';\n        var service             = '';\n        var vessel              = '';\n        var eta                 = '';\n        var voyage              = '';\n        var direction           = '';\n        var screenName          = '1';\n        var pageId              = '';\n        var viewId              = '';\n        var hdrEtaTm            = '';\n        var hdrEtdTm            = '';\n        var hdrEtaDateTime      = '';\n        var hdrEtdDateTime      = '';\n        var hdrEta              = '';\n\n\n\n\n        //If search not performed show error\n        searchPerformed = document.getElementById(\"searchPerformed\").value;\n                if(searchPerformed == \"false\") {\n                 showBarMessage(ECM_SE0007,ERROR_MSG);\n                 return false;\n                }\n\n                if(document.forms[0].radioGroup1 != null){\n                    if(document.forms[0].radioGroup1[0] != null){\n                        for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {\n                            if(document.forms[0].radioGroup1[i].checked) {\n                                    selectedIndex = i;\n                            }\n                        }\n                    } else {\n            selectedIndex = 0;\n                    }\n                }\n\n                //Call RiaGridCommon getSelectedRowData function to get the values of selected record in an array\n                rowData             =    getSelectedRowData(selectedIndex);\n                service = rowData[\"serviceCd\"];\n                port    = rowData[\"port\"];\n                terminal = rowData[\"terminal\"];\n                vessel = rowData[\"vessel\"];\n                voyage  = rowData[\"inVoyage\"];\n                direction = rowData[\"direction\"];\n                pageId  = document.getElementById(\"pageId\").value;\n                viewId  = document.getElementById(\"view\").value;\n                hdrEta            = rowData[\"fromEta\"];\n                hdrEtaTm = document.getElementById('value[' + selectedIndex + '].etaTime').value;\n                hdrEtdTm = document.getElementById('value[' + selectedIndex + '].etdTime').value;\n                    hdrEtaDateTime = hdrEta ;\n\n\n                var urlStr = '".toCharArray();
    __oracle_jsp_text[16] = 
    "?screenName='+screenName+'&pageId='+pageId+'&arrivalPort='+port+'&arrivalTerminal='+terminal+'&viewId='+viewId+'&service='+service+'&vessel='+vessel+'&eta='+hdrEtaDateTime+'&voyage='+voyage+'&direction='+direction+'&lldlflag=D';\n                \n               // openChildWindow(urlStr,window,'1000px','500px');\n                openChildScreen64(urlStr,FORM_ID);\n\n                return false;\n\n\n    }\n\n    function callDischargeListMaintenance() {\n        resetSearchCriteria();\n        var rowData             = {};\n        var selectedIndex       = '';\n        var hdrService          = '';\n        var hdrVesselName       = '';\n        var hdrDirection        = '';\n        var hdrVoyage           = '';\n        var hdrPortSeq          = '';\n        var hdrPort             = '';\n        var hdrTerminal         = '';\n        var hdrBargeNameVoyage  = '';\n        var hdrEta              = '';\n        var hdrEtd              = '';\n        var dischargeListStatus = '';\n        var readOnlyFlg         = '';\n        var dischargeListId     = '';\n        var flag                = '';\n        var hdrEtaTm            = '';\n        var hdrEtdTm            = '';\n        var hdrEtaDateTime      = '';\n        var hdrEtdDateTime      = '';\n        var etaTmFlag            = 'N';\n        var etdTmFlag            = 'N';\n        var ataTime            = '';\n        var atdTimd            = '';\n        var fromAta             = ''; // #1\n        //If search not performed show error\n        searchPerformed = document.getElementById(\"searchPerformed\").value;\n        if(searchPerformed == \"false\") {\n            showBarMessage(ECM_SE0007,ERROR_MSG);\n            return false;\n        }\n\n        if(document.forms[0].radioGroup1 != null){\n            if(document.forms[0].radioGroup1[0] != null){\n                for( i = 0; i < document.forms[0].radioGroup1.length; i++ ) {\n                    if(document.forms[0].radioGroup1[i].checked) {\n                        selectedIndex = i;\n                    }\n                }\n            } else {\n                selectedIndex = 0;\n            }\n        }\n\n        flag = document.getElementById('value[' + selectedIndex + '].flag').value;\n        hdrEtaTm = document.getElementById('value[' + selectedIndex + '].etaTime').value;\n        hdrEtdTm = document.getElementById('value[' + selectedIndex + '].etdTime').value;\n                \n        \n        /* when Eta time and Etd time is null then pass 0000 to DL_MAINTENANCE screen. */\n        if ((hdrEtaTm == null) || (hdrEtaTm.length == 0)) {\n            etaTmFlag = 'Y';\n            hdrEtaTm = '0000';\n        }\n\n        if ((hdrEtdTm == null) || (hdrEtdTm.length == 0)) {\n            etdTmFlag = 'Y';\n            hdrEtdTm = '0000';\n        }\n\n        //Call RiaGridCommon getSelectedRowData function to get the values of selected record in an array\n        rowData             =    getSelectedRowData(selectedIndex);\n\n        hdrService          = rowData[\"serviceCd\"];\n        hdrVessel           = rowData[\"vessel\"];\n        hdrDirection        = rowData[\"direction\"];\n        hdrVoyage           = rowData[\"inVoyage\"];\n        hdrPortSeq          = rowData[\"sequence\"];\n        hdrPort             = rowData[\"port\"];\n        hdrTerminal         = rowData[\"terminal\"];\n        hdrBargeNameVoyage  = rowData[\"bargeName\"];\n        hdrEta              = rowData[\"fromEta\"];\n        hdrEtd              = rowData[\"toEta\"];\n        ataTime             = rowData[\"fromAta\"];\n        atdTime             = rowData[\"toAta\"];\n        fromAta             = ataTime; // #1\n        \n        dischargeListStatus = lastStatus;\n        readOnlyFlg         = flag ;\n        dischargeListId     = document.getElementById('value[' + selectedIndex + '].dischargeListId').value;\n\n        var index1 = hdrEta.indexOf(\":\");\n        var index2 = hdrEtd.indexOf(\":\");\n        var index3 = hdrEta.indexOf(\" \");\n        var index4 = hdrEtd.indexOf(\" \");\n        var index5 = ataTime.indexOf(\" \"); // #1\n        \n        ataTime = ataTime.substring(ataTime.indexOf(\" \") ) ;\n        atdTime = atdTime.substring(atdTime.indexOf(\" \") ) ;\n        fromAta = fromAta.substring(0,index5); // #1\n        \n        hdrEtaDateTime =  hdrEta;\n        hdrEtdDateTime = hdrEtd;\n        \n        if (etdTmFlag == 'N') {\n            hdrEta = hdrEta.substring(0,index3);\n        }\n        \n        if (etaTmFlag == 'N') {\n            hdrEtd = hdrEtd.substring(0,index4);\n        }\n//        var fromAta = document.forms[0].fromEta.value; #1\n        var urlStr = '".toCharArray();
    __oracle_jsp_text[17] = 
    "?hdrService='+hdrService\n            +'&hdrVessel='+hdrVessel\n            +'&hdrDirection='+hdrDirection+'&hdrVoyage='+hdrVoyage\n            +'&hdrPortSeq='+hdrPortSeq+'&hdrTerminal='+hdrTerminal\n            +'&hdrBargeNameVoyage='+hdrBargeNameVoyage+'&hdrEta='+hdrEta\n            +'&hdrEtd='+hdrEtd+'&dischargeListStatus='+dischargeListStatus\n            +'&readOnlyFlg='+readOnlyFlg+'&dischargeListId='+dischargeListId\n            +'&hdrPort='+hdrPort+'&hdrEtaTm='+hdrEtaTm+'&hdrEtdTm='+hdrEtdTm\n            +'&hdrEtaDateTime='+hdrEtaDateTime\n            +'&hdrEtdDateTime='+hdrEtdDateTime+'&fromAta='+fromAta\n            +'&ataTime='+ataTime+'&atdTime='+atdTime;\n            \n        document.forms[0].action= urlStr;\n        document.forms[0].submit();\n\n        return false;\n    }\n\n    function changeViewCombo()\n    {\n\n        getGridSearchCriteria();\n        document.forms[0].fsc.value  = lastFsc;\n\n    }\n\n</SCRIPT>\n\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\n    ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\n    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[31] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[32] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[34] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[35] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[36] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[37] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[38] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[40] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[41] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[42] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[43] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\n\n    ".toCharArray();
    __oracle_jsp_text[45] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\n    ".toCharArray();
    __oracle_jsp_text[47] = 
    "\n    <div class=\"text_header\"><h2>Search</h2></div>\n    <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td>Service Group</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[48] = 
    "\n            <input type=\"button\" value=\". . .\" name=\"btnServiceGroupLookup\" class=\"btnbutton\" onclick='return openServiceGroupLookup()'/>\n        </td>\n        <td>Service</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[49] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[50] = 
    "\n            <input type=\"button\" value=\". . .\" name=\"btnServiceLookup\" class=\"btnbutton\" onclick='return openServiceLookup()'/>\n        </td>\n        <td>Port</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[51] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[52] = 
    "\n            <input type=\"button\" value=\". . .\" name=\"btnPortLookup\" class=\"btnbutton\" onclick='return openPortLookup()'/>\n        </td>\n        <td>FSC</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[53] = 
    "\n        </td>\n\n      </tr>\n      <tr>\n\n        <td>Vessel</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[54] = 
    "\n            <input type=\"button\" value=\". . .\" name=\"btnVesselLookup\" class=\"btnbutton\" onclick='return openVesselLookup()'/>\n        </td>\n        <td>In Voyage</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[55] = 
    "\n            <input type=\"button\" value=\". . .\" name=\"btnInVoyagelLookup\" class=\"btnbutton\" onclick='return openInVoyageLookup()'/>\n        </td>\n        <td>Terminal</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[56] = 
    "\n            <input type=\"button\" value=\". . .\" name=\"btnTerminalLookup\" class=\"btnbutton\" onclick='return openTerminalLookup()'/>\n\n        </td>\n      </tr>\n      <tr>\n        <td width=\"8%\">From ETA</td>\n        <td class=\"whitebg\" width=\"16%\">\n            ".toCharArray();
    __oracle_jsp_text[57] = 
    "\n            <a href=\"#\" onClick=\"showCalendar('forms[0].fromEta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[58] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\n        </td>\n        <td width=\"6%\">To ETA</td>\n        <td class=\"whitebg\" width=\"15%\">\n            ".toCharArray();
    __oracle_jsp_text[59] = 
    "\n            <a href=\"#\" onClick=\"showCalendar('forms[0].toEta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[60] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\n        </td>\n        <td width=\"6%\">From ATA</td>\n        <td class=\"whitebg\" width=\"15%\">\n            ".toCharArray();
    __oracle_jsp_text[61] = 
    "\n            <a href=\"#\" onClick=\"showCalendar('forms[0].fromAta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\n        </td>\n        <td width=\"4%\">To ATA</td>\n        <td class=\"whitebg\" width=\"15%\">\n            ".toCharArray();
    __oracle_jsp_text[63] = 
    "\n            <a href=\"#\" onClick=\"showCalendar('forms[0].toAta', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[64] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\n        </td>\n      </tr>\n      <tr>\n\n        <td>In</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[65] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[66] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[67] = 
    "\n        </td>\n        <td>Sort Order</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[68] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[69] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[70] = 
    "\n        </td>\n        <td>Status</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[71] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[72] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[73] = 
    "\n         </td>\n        <td>View</td>\n        <td class=\"whitebg\">\n            ".toCharArray();
    __oracle_jsp_text[74] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[75] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[76] = 
    "\n        </td>\n      </tr>\n    </table>\n    ".toCharArray();
    __oracle_jsp_text[77] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[78] = 
    "\n    <div class=\"buttons_box\">\n\n        <input type=\"button\" value=\"Create Arrival Bay Plan\" name=\"btnCreateArrivalBayPlan\" class=\"event_btnbutton\" onclick='return openCreateArrivalBayPlan()'/>\n        <input type=\"button\" value=\"Save Sett.\" name=\"btnSaveSett\" class=\"event_btnbutton\" onclick='return onSaveSett()'/>\n        <input type=\"button\" value=\"Refresh\" name=\"btnRefresh\" class=\"event_btnbutton\" onclick='return onRefresh()'/>\n        <input type=\"button\" value=\"Reset\" name=\"btnReset\" class=\"event_btnbutton\" onclick='return onResetForm()'/>\n        <input type=\"button\" value=\"Find\" name=\"btnFind\" class=\"event_btnbutton\" onclick='return onSearch()'/>\n    </div>\n\n\n    ".toCharArray();
    __oracle_jsp_text[79] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\n    <div class=\"text_header\"><h2>Search Result</h2></div>\n\n    ".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\n\n    ".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\n    ".toCharArray();
    __oracle_jsp_text[83] = 
    "\n    <div class=\"buttons_box\">\n            <div id=\"editDiv\">\n                <input type=\"button\" value=\"Edit\" name=\"btnEdit\" class=\"event_btnbutton\" onclick='return callDischargeListMaintenance()'/>\n            </div>\n        </div>\n\n\n    ".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\n    ".toCharArray();
    __oracle_jsp_text[85] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[86] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[87] = 
    "\n".toCharArray();
    __oracle_jsp_text[88] = 
    "\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

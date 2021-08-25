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


public class _EserviceNewWebBooking extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceNewWebBooking page = this;
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
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[8]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[9]);
      out.print(com.niit.control.web. JSPUtils.getActionMappingURL("/serv001ChangeCountryCode", pageContext));
      out.write(__oracle_jsp_text[10]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SaveBooking", pageContext));
      out.write(__oracle_jsp_text[11]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv003", pageContext));
      out.write(__oracle_jsp_text[12]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv004", pageContext));
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SaveTemplate", pageContext));
      out.write(__oracle_jsp_text[14]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001GetTemplateData", pageContext));
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001delSizeType", pageContext));
      out.write(__oracle_jsp_text[16]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001delCommodity", pageContext));
      out.write(__oracle_jsp_text[17]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001CheckQuotation", pageContext));
      out.write(__oracle_jsp_text[18]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001GetDefaultByQuotationNo", pageContext));
      out.write(__oracle_jsp_text[19]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext));
      out.write(__oracle_jsp_text[20]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001CheckQuotationSize", pageContext));
      out.write(__oracle_jsp_text[21]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SetQuotationRoutingData", pageContext));
      out.write(__oracle_jsp_text[22]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001addCommodity", pageContext));
      out.write(__oracle_jsp_text[23]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001updateCommodity", pageContext));
      out.write(__oracle_jsp_text[24]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv019", pageContext));
      out.write(__oracle_jsp_text[25]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv019getData", pageContext));
      out.write(__oracle_jsp_text[26]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv020", pageContext));
      out.write(__oracle_jsp_text[27]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv020getData", pageContext));
      out.write(__oracle_jsp_text[28]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv021", pageContext));
      out.write(__oracle_jsp_text[29]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv021getData", pageContext));
      out.write(__oracle_jsp_text[30]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001changeRateType", pageContext));
      out.write(__oracle_jsp_text[31]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001addSizeType", pageContext));
      out.write(__oracle_jsp_text[32]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001updateSizeType", pageContext));
      out.write(__oracle_jsp_text[33]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv023", pageContext));
      out.write(__oracle_jsp_text[34]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv023getData", pageContext));
      out.write(__oracle_jsp_text[35]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv028equipTypeLookUp", pageContext));
      out.write(__oracle_jsp_text[36]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001ChangeRepComp", pageContext));
      out.write(__oracle_jsp_text[37]);
      out.print(com.niit.control.web. JSPUtils.getActionMappingURL("/serv001", pageContext));
      out.write(__oracle_jsp_text[38]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv001");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[39]);
            out.write(__oracle_jsp_text[40]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv01");
              __jsp_taghandler_2.setProperty("bookingNo");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[41]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv01");
              __jsp_taghandler_3.setProperty("status");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[42]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("feserv01");
              __jsp_taghandler_4.setProperty("email");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[43]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("feserv01");
              __jsp_taghandler_5.setProperty("saveOperationFlag");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[44]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("feserv01");
              __jsp_taghandler_6.setProperty("openAcknowledgement");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[45]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("feserv01");
              __jsp_taghandler_7.setProperty("customerCode");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[46]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_8=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setName("feserv01");
              __jsp_taghandler_8.setProperty("customerName");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[47]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setName("feserv01");
              __jsp_taghandler_9.setProperty("equipmentSeq");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[48]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("feserv01");
              __jsp_taghandler_10.setProperty("commoditySeq");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[49]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setName("feserv01");
              __jsp_taghandler_11.setProperty("commodityRowIndex");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[50]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_12=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("feserv01");
              __jsp_taghandler_12.setProperty("line");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[51]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_13=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("feserv01");
              __jsp_taghandler_13.setProperty("trade");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[52]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_14=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setName("feserv01");
              __jsp_taghandler_14.setProperty("agent");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[53]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_15=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setName("feserv01");
              __jsp_taghandler_15.setProperty("commodityGroup");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[54]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_16=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setName("feserv01");
              __jsp_taghandler_16.setProperty("commodityGroupDetail");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[55]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_17=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setName("feserv01");
              __jsp_taghandler_17.setProperty("newWebBookingErrMsg");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[56]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_18=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_18.setParent(__jsp_taghandler_1);
              __jsp_taghandler_18.setName("feserv01");
              __jsp_taghandler_18.setProperty("msgTooltip");
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[57]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_19=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_19.setParent(__jsp_taghandler_1);
              __jsp_taghandler_19.setName("feserv01");
              __jsp_taghandler_19.setProperty("deleleEqSizeType");
              __jsp_taghandler_19.setStyleId("deleleEqSizeType");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[58]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_20=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setName("feserv01");
              __jsp_taghandler_20.setProperty("deleteCommod");
              __jsp_taghandler_20.setStyleId("deleteCommod");
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[59]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_21=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setName("feserv01");
              __jsp_taghandler_21.setProperty("commoditySeqNoTmp");
              __jsp_taghandler_21.setStyleId("commoditySeqNoTmp");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[60]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_22=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setName("feserv01");
              __jsp_taghandler_22.setProperty("equipmentSeqNoTmp");
              __jsp_taghandler_22.setStyleId("equipmentSeqNoTmp");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[61]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_23=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setName("feserv01");
              __jsp_taghandler_23.setProperty("uploadFlag");
              __jsp_taghandler_23.setStyleId("uploadFlag");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[62]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_24=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setName("feserv01");
              __jsp_taghandler_24.setProperty("errMsg");
              __jsp_taghandler_24.setStyleId("errMsg");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[63]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_25=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setName("feserv01");
              __jsp_taghandler_25.setProperty("rfTypeNormal");
              __jsp_taghandler_25.setStyleId("rfTypeNormal");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[64]);
            out.write(__oracle_jsp_text[65]);
            out.write(__oracle_jsp_text[66]);
            out.write(__oracle_jsp_text[67]);
            out.write(__oracle_jsp_text[68]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_26=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property styleId size");
              __jsp_taghandler_26.setParent(__jsp_taghandler_1);
              __jsp_taghandler_26.setName("feserv01");
              __jsp_taghandler_26.setOnchange("onTemplateChange()");
              __jsp_taghandler_26.setProperty("template");
              __jsp_taghandler_26.setStyleId("template");
              __jsp_taghandler_26.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_26,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[69]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_27=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_27.setParent(__jsp_taghandler_26);
                    __jsp_taghandler_27.setLabel("name");
                    __jsp_taghandler_27.setName("feserv01");
                    __jsp_taghandler_27.setProperty("templateValues");
                    __jsp_taghandler_27.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                    if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,3);
                  }
                  out.write(__oracle_jsp_text[70]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[71]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_28=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name onclick property style styleId value");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setName("feserv01");
              __jsp_taghandler_28.setOnclick("lp_manageRepresentCompChkBox(2);");
              __jsp_taghandler_28.setProperty("representCompChkBox");
              __jsp_taghandler_28.setStyle("border:0px;width:15px;height:15px;");
              __jsp_taghandler_28.setStyleId("representCompChkBox");
              __jsp_taghandler_28.setValue("Y");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[72]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_29=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property styleId size");
              __jsp_taghandler_29.setParent(__jsp_taghandler_1);
              __jsp_taghandler_29.setName("feserv01");
              __jsp_taghandler_29.setOnchange("checkQuotationNo();");
              __jsp_taghandler_29.setProperty("representComp");
              __jsp_taghandler_29.setStyleId("representComp");
              __jsp_taghandler_29.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_29,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[73]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_30=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_30.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_30.setLabel("name");
                    __jsp_taghandler_30.setName("feserv01");
                    __jsp_taghandler_30.setProperty("representCompValues");
                    __jsp_taghandler_30.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                    if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,3);
                  }
                  out.write(__oracle_jsp_text[74]);
                } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,2);
            }
            out.write(__oracle_jsp_text[75]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_31=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property styleId size");
              __jsp_taghandler_31.setParent(__jsp_taghandler_1);
              __jsp_taghandler_31.setName("feserv01");
              __jsp_taghandler_31.setOnchange("checkQuotationNo();");
              __jsp_taghandler_31.setProperty("socCocUserFlag");
              __jsp_taghandler_31.setStyleId("socCocUserFlag");
              __jsp_taghandler_31.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_31,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[76]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_32=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_32.setParent(__jsp_taghandler_31);
                    __jsp_taghandler_32.setLabel("name");
                    __jsp_taghandler_32.setName("feserv01");
                    __jsp_taghandler_32.setProperty("cocSocValues");
                    __jsp_taghandler_32.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
                    if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,3);
                  }
                  out.write(__oracle_jsp_text[77]);
                } while (__jsp_taghandler_31.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,2);
            }
            out.write(__oracle_jsp_text[78]);
            out.write(__oracle_jsp_text[79]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_33=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_33.setParent(__jsp_taghandler_1);
              __jsp_taghandler_33.setName("feserv01");
              __jsp_taghandler_33.setProperty("status");
              __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
              if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,2);
            }
            out.write(__oracle_jsp_text[80]);
            out.write(__oracle_jsp_text[81]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_34=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_34.setParent(__jsp_taghandler_1);
              __jsp_taghandler_34.setName("feserv01");
              __jsp_taghandler_34.setProperty("bookingNo");
              __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
              if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,2);
            }
            out.write(__oracle_jsp_text[82]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_35=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property size");
              __jsp_taghandler_35.setParent(__jsp_taghandler_1);
              __jsp_taghandler_35.setName("feserv01");
              __jsp_taghandler_35.setOnchange("getDataByQuotationNo();");
              __jsp_taghandler_35.setProperty("quotationNumber");
              __jsp_taghandler_35.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_35,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[83]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_36=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_36.setParent(__jsp_taghandler_35);
                    __jsp_taghandler_36.setLabel("name");
                    __jsp_taghandler_36.setName("feserv01");
                    __jsp_taghandler_36.setProperty("quotationNumberValues");
                    __jsp_taghandler_36.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
                    if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,3);
                  }
                  out.write(__oracle_jsp_text[84]);
                } while (__jsp_taghandler_35.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,2);
            }
            out.write(__oracle_jsp_text[85]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_37=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_37.setParent(__jsp_taghandler_1);
              __jsp_taghandler_37.setName("feserv01");
              __jsp_taghandler_37.setProperty("pol");
              __jsp_taghandler_37.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_37,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[86]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_38=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_38.setParent(__jsp_taghandler_37);
                    __jsp_taghandler_38.setLabel("name");
                    __jsp_taghandler_38.setName("feserv01");
                    __jsp_taghandler_38.setProperty("polList");
                    __jsp_taghandler_38.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
                    if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,3);
                  }
                  out.write(__oracle_jsp_text[87]);
                } while (__jsp_taghandler_37.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,2);
            }
            out.write(__oracle_jsp_text[88]);
            out.write(__oracle_jsp_text[89]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_39=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_39.setParent(__jsp_taghandler_1);
              __jsp_taghandler_39.setName("feserv01");
              __jsp_taghandler_39.setProperty("pod");
              __jsp_taghandler_39.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_39,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[90]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_40=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_40.setParent(__jsp_taghandler_39);
                    __jsp_taghandler_40.setLabel("name");
                    __jsp_taghandler_40.setName("feserv01");
                    __jsp_taghandler_40.setProperty("podList");
                    __jsp_taghandler_40.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
                    if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,3);
                  }
                  out.write(__oracle_jsp_text[91]);
                } while (__jsp_taghandler_39.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,2);
            }
            out.write(__oracle_jsp_text[92]);
            out.write(__oracle_jsp_text[93]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_41=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property");
              __jsp_taghandler_41.setParent(__jsp_taghandler_1);
              __jsp_taghandler_41.setMaxlength("17");
              __jsp_taghandler_41.setName("feserv01");
              __jsp_taghandler_41.setOnblur("changeUpper(this)");
              __jsp_taghandler_41.setProperty("customerReference");
              __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
              if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,2);
            }
            out.write(__oracle_jsp_text[94]);
            out.write(__oracle_jsp_text[95]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_42=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_42.setParent(__jsp_taghandler_1);
              __jsp_taghandler_42.setName("feserv01");
              __jsp_taghandler_42.setProperty("email");
              __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
              if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,2);
            }
            out.write(__oracle_jsp_text[96]);
            //<html:text name="feserv01" property="email" onblur="validateEmail();" />
            out.write(__oracle_jsp_text[97]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_43=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property");
              __jsp_taghandler_43.setParent(__jsp_taghandler_1);
              __jsp_taghandler_43.setMaxlength("17");
              __jsp_taghandler_43.setName("feserv01");
              __jsp_taghandler_43.setOnblur("changeUpper(this);validateForm();");
              __jsp_taghandler_43.setProperty("telephone");
              __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
              if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,2);
            }
            out.write(__oracle_jsp_text[98]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_44=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property");
              __jsp_taghandler_44.setParent(__jsp_taghandler_1);
              __jsp_taghandler_44.setMaxlength("17");
              __jsp_taghandler_44.setName("feserv01");
              __jsp_taghandler_44.setOnblur("changeUpper(this)");
              __jsp_taghandler_44.setProperty("fax");
              __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
              if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,2);
            }
            out.write(__oracle_jsp_text[99]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_45=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
              __jsp_taghandler_45.setParent(__jsp_taghandler_1);
              __jsp_taghandler_45.setMaxlength("25");
              __jsp_taghandler_45.setName("feserv01");
              __jsp_taghandler_45.setOnblur("changeUpper(this)");
              __jsp_taghandler_45.setProperty("contact");
              __jsp_taghandler_45.setStyle("width:80%");
              __jsp_taghandler_45.setStyleClass("must");
              __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
              if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,2);
            }
            out.write(__oracle_jsp_text[100]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_46=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_46.setParent(__jsp_taghandler_1);
              __jsp_taghandler_46.setMaxlength("500");
              __jsp_taghandler_46.setName("feserv01");
              __jsp_taghandler_46.setOnblur("validateEmail();");
              __jsp_taghandler_46.setProperty("additionalMailRecipeints");
              __jsp_taghandler_46.setStyle("width:45%");
              __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
              if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,2);
            }
            out.write(__oracle_jsp_text[101]);
            out.write(__oracle_jsp_text[102]);
            out.write(__oracle_jsp_text[103]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_47=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleClass styleId size");
              __jsp_taghandler_47.setParent(__jsp_taghandler_1);
              __jsp_taghandler_47.setName("feserv01");
              __jsp_taghandler_47.setOnchange("onCountryChange()");
              __jsp_taghandler_47.setProperty("originCountry");
              __jsp_taghandler_47.setStyle("height:20px");
              __jsp_taghandler_47.setStyleClass("must");
              __jsp_taghandler_47.setStyleId("originCountry");
              __jsp_taghandler_47.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_47,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[104]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_48=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_48.setParent(__jsp_taghandler_47);
                    __jsp_taghandler_48.setLabel("name");
                    __jsp_taghandler_48.setName("feserv01");
                    __jsp_taghandler_48.setProperty("originCountryValues");
                    __jsp_taghandler_48.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
                    if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,3);
                  }
                  out.write(__oracle_jsp_text[105]);
                } while (__jsp_taghandler_47.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,2);
            }
            out.write(__oracle_jsp_text[106]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_49=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleClass styleId size");
              __jsp_taghandler_49.setParent(__jsp_taghandler_1);
              __jsp_taghandler_49.setName("feserv01");
              __jsp_taghandler_49.setOnchange("onCountryChange()");
              __jsp_taghandler_49.setProperty("destinationCountry");
              __jsp_taghandler_49.setStyle("height:20px");
              __jsp_taghandler_49.setStyleClass("must");
              __jsp_taghandler_49.setStyleId("destinationCountry");
              __jsp_taghandler_49.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_49,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[107]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_50=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_50.setParent(__jsp_taghandler_49);
                    __jsp_taghandler_50.setLabel("name");
                    __jsp_taghandler_50.setName("feserv01");
                    __jsp_taghandler_50.setProperty("destinationCountryValues");
                    __jsp_taghandler_50.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
                    if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,3);
                  }
                  out.write(__oracle_jsp_text[108]);
                } while (__jsp_taghandler_49.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,2);
            }
            out.write(__oracle_jsp_text[109]);
            out.write(__oracle_jsp_text[110]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_51=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property styleId size");
              __jsp_taghandler_51.setParent(__jsp_taghandler_1);
              __jsp_taghandler_51.setName("feserv01");
              __jsp_taghandler_51.setOnchange("checkQuotationNo();");
              __jsp_taghandler_51.setProperty("placeOfReceipt");
              __jsp_taghandler_51.setStyleId("placeOfReceipt");
              __jsp_taghandler_51.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_51,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[111]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_52=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_52.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_52.setLabel("name");
                    __jsp_taghandler_52.setName("feserv01");
                    __jsp_taghandler_52.setProperty("placeOfReceiptValues");
                    __jsp_taghandler_52.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
                    if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,3);
                  }
                  out.write(__oracle_jsp_text[112]);
                } while (__jsp_taghandler_51.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,2);
            }
            out.write(__oracle_jsp_text[113]);
            out.write(__oracle_jsp_text[114]);
            out.write(__oracle_jsp_text[115]);
            out.write(__oracle_jsp_text[116]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_53=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property styleId size");
              __jsp_taghandler_53.setParent(__jsp_taghandler_1);
              __jsp_taghandler_53.setName("feserv01");
              __jsp_taghandler_53.setOnchange("checkQuotationNo();");
              __jsp_taghandler_53.setProperty("portOfLoading");
              __jsp_taghandler_53.setStyleId("portOfLoading");
              __jsp_taghandler_53.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_53,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[117]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_54=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_54.setParent(__jsp_taghandler_53);
                    __jsp_taghandler_54.setLabel("name");
                    __jsp_taghandler_54.setName("feserv01");
                    __jsp_taghandler_54.setProperty("portOfLoadingValues");
                    __jsp_taghandler_54.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
                    if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,3);
                  }
                  out.write(__oracle_jsp_text[118]);
                } while (__jsp_taghandler_53.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,2);
            }
            out.write(__oracle_jsp_text[119]);
            out.write(__oracle_jsp_text[120]);
            out.write(__oracle_jsp_text[121]);
            out.write(__oracle_jsp_text[122]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_55=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property styleId size");
              __jsp_taghandler_55.setParent(__jsp_taghandler_1);
              __jsp_taghandler_55.setName("feserv01");
              __jsp_taghandler_55.setOnchange("checkQuotationNo();");
              __jsp_taghandler_55.setProperty("portOfDischarge");
              __jsp_taghandler_55.setStyleId("portOfDischarge");
              __jsp_taghandler_55.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_55,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[123]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_56=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_56.setParent(__jsp_taghandler_55);
                    __jsp_taghandler_56.setLabel("name");
                    __jsp_taghandler_56.setName("feserv01");
                    __jsp_taghandler_56.setProperty("portOfDischargeValues");
                    __jsp_taghandler_56.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_56.doStartTag();
                    if (__jsp_taghandler_56.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_56,3);
                  }
                  out.write(__oracle_jsp_text[124]);
                } while (__jsp_taghandler_55.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,2);
            }
            out.write(__oracle_jsp_text[125]);
            out.write(__oracle_jsp_text[126]);
            out.write(__oracle_jsp_text[127]);
            out.write(__oracle_jsp_text[128]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_57=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property size");
              __jsp_taghandler_57.setParent(__jsp_taghandler_1);
              __jsp_taghandler_57.setName("feserv01");
              __jsp_taghandler_57.setOnchange("checkQuotationNo();");
              __jsp_taghandler_57.setProperty("placeOfDelivery");
              __jsp_taghandler_57.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_57.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_57,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[129]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_58=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_58.setParent(__jsp_taghandler_57);
                    __jsp_taghandler_58.setLabel("name");
                    __jsp_taghandler_58.setName("feserv01");
                    __jsp_taghandler_58.setProperty("placeOfDeliveryValues");
                    __jsp_taghandler_58.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_58.doStartTag();
                    if (__jsp_taghandler_58.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_58,3);
                  }
                  out.write(__oracle_jsp_text[130]);
                } while (__jsp_taghandler_57.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_57.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_57,2);
            }
            out.write(__oracle_jsp_text[131]);
            out.write(__oracle_jsp_text[132]);
            out.write(__oracle_jsp_text[133]);
            out.write(__oracle_jsp_text[134]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_59=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property size");
              __jsp_taghandler_59.setParent(__jsp_taghandler_1);
              __jsp_taghandler_59.setName("feserv01");
              __jsp_taghandler_59.setOnchange("checkQuotationNo();");
              __jsp_taghandler_59.setProperty("emptyPickupDepot");
              __jsp_taghandler_59.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_59.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_59,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[135]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_60=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_60.setParent(__jsp_taghandler_59);
                    __jsp_taghandler_60.setLabel("name");
                    __jsp_taghandler_60.setName("feserv01");
                    __jsp_taghandler_60.setProperty("emptyPickupDepotValues");
                    __jsp_taghandler_60.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_60.doStartTag();
                    if (__jsp_taghandler_60.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_60,3);
                  }
                  out.write(__oracle_jsp_text[136]);
                } while (__jsp_taghandler_59.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_59.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_59,2);
            }
            out.write(__oracle_jsp_text[137]);
            out.write(__oracle_jsp_text[138]);
            out.write(__oracle_jsp_text[139]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_61=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
              __jsp_taghandler_61.setParent(__jsp_taghandler_1);
              __jsp_taghandler_61.setMaxlength("10");
              __jsp_taghandler_61.setName("feserv01");
              __jsp_taghandler_61.setOnblur("gp_checkDate(this);");
              __jsp_taghandler_61.setProperty("emptyPickupDate");
              __jsp_taghandler_61.setStyle("width:49%");
              __jsp_taghandler_61.setStyleClass("dateForm");
              __jsp_taghandler_61.setStyleId("emptyPickupDate");
              __jsp_tag_starteval=__jsp_taghandler_61.doStartTag();
              if (__jsp_taghandler_61.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_61,2);
            }
            out.write(__oracle_jsp_text[140]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_62=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
              __jsp_taghandler_62.setParent(__jsp_taghandler_1);
              __jsp_taghandler_62.setMaxlength("10");
              __jsp_taghandler_62.setName("feserv01");
              __jsp_taghandler_62.setOnblur("gp_checkDate(this);");
              __jsp_taghandler_62.setProperty("shipmentDate");
              __jsp_taghandler_62.setStyle("width:53%");
              __jsp_taghandler_62.setStyleClass("dateFormMust");
              __jsp_taghandler_62.setStyleId("shipmentDate");
              __jsp_tag_starteval=__jsp_taghandler_62.doStartTag();
              if (__jsp_taghandler_62.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_62,2);
            }
            out.write(__oracle_jsp_text[141]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_63=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
              __jsp_taghandler_63.setParent(__jsp_taghandler_1);
              __jsp_taghandler_63.setMaxlength("10");
              __jsp_taghandler_63.setName("feserv01");
              __jsp_taghandler_63.setOnblur("gp_checkDate(this);");
              __jsp_taghandler_63.setProperty("sailingDate");
              __jsp_taghandler_63.setStyle("width:53%");
              __jsp_taghandler_63.setStyleClass("dateForm");
              __jsp_taghandler_63.setStyleId("sailingDate");
              __jsp_tag_starteval=__jsp_taghandler_63.doStartTag();
              if (__jsp_taghandler_63.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_63,2);
            }
            out.write(__oracle_jsp_text[142]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_64=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
              __jsp_taghandler_64.setParent(__jsp_taghandler_1);
              __jsp_taghandler_64.setMaxlength("10");
              __jsp_taghandler_64.setName("feserv01");
              __jsp_taghandler_64.setOnblur("gp_checkDate(this);");
              __jsp_taghandler_64.setProperty("desiredArrivalDate");
              __jsp_taghandler_64.setStyle("width:53%");
              __jsp_taghandler_64.setStyleClass("dateForm");
              __jsp_taghandler_64.setStyleId("desiredArrivalDate");
              __jsp_tag_starteval=__jsp_taghandler_64.doStartTag();
              if (__jsp_taghandler_64.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_64,2);
            }
            out.write(__oracle_jsp_text[143]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_65=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag disabled name property style");
              __jsp_taghandler_65.setParent(__jsp_taghandler_1);
              __jsp_taghandler_65.setDisabled(true);
              __jsp_taghandler_65.setName("feserv01");
              __jsp_taghandler_65.setProperty("rclArrangementChkBox");
              __jsp_taghandler_65.setStyle("border:0px;width:10%");
              __jsp_tag_starteval=__jsp_taghandler_65.doStartTag();
              if (__jsp_taghandler_65.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_65,2);
            }
            out.write(__oracle_jsp_text[144]);
            out.write(__oracle_jsp_text[145]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_66=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onclick onkeyup property rows styleClass");
              __jsp_taghandler_66.setParent(__jsp_taghandler_1);
              __jsp_taghandler_66.setCols("50");
              __jsp_taghandler_66.setName("feserv01");
              __jsp_taghandler_66.setOnclick("maxlenghtTextArea('routingPreference', 500)");
              __jsp_taghandler_66.setOnkeyup("maxlenghtTextArea('routingPreference', 500)");
              __jsp_taghandler_66.setProperty("routingPreference");
              __jsp_taghandler_66.setRows("5");
              __jsp_taghandler_66.setStyleClass("Combo");
              __jsp_tag_starteval=__jsp_taghandler_66.doStartTag();
              if (__jsp_taghandler_66.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_66,2);
            }
            out.write(__oracle_jsp_text[146]);
            out.write(__oracle_jsp_text[147]);
            out.write(__oracle_jsp_text[148]);
              int count = 1;  
            out.write(__oracle_jsp_text[149]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_67=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_67.setParent(__jsp_taghandler_1);
              __jsp_taghandler_67.setId("rowdata");
              __jsp_taghandler_67.setIndexId("ctr");
              __jsp_taghandler_67.setName("feserv01");
              __jsp_taghandler_67.setProperty("equipmentVoDataList");
              __jsp_taghandler_67.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod");
              com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod rowdata = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_67.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_67,__jsp_tag_starteval,out);
                do {
                  rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod) pageContext.findAttribute("rowdata");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[150]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_68=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_68.setParent(__jsp_taghandler_67);
                    __jsp_taghandler_68.setName("rowdata");
                    __jsp_taghandler_68.setProperty("eqRecordStatus");
                    __jsp_taghandler_68.setValue("DEL");
                    __jsp_tag_starteval=__jsp_taghandler_68.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[151]);
                        out.print(count);
                        out.write(__oracle_jsp_text[152]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_69=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_69.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_69.setName("rowdata");
                          __jsp_taghandler_69.setProperty("type");
                          __jsp_taghandler_69.setStyleId(OracleJspRuntime.toStr( "type" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_69.doStartTag();
                          if (__jsp_taghandler_69.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_69,4);
                        }
                        out.write(__oracle_jsp_text[153]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_70=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly style styleClass styleId");
                          __jsp_taghandler_70.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_70.setName("rowdata");
                          __jsp_taghandler_70.setProperty("typeDesc");
                          __jsp_taghandler_70.setReadonly(true);
                          __jsp_taghandler_70.setStyle("width:180px");
                          __jsp_taghandler_70.setStyleClass("must");
                          __jsp_taghandler_70.setStyleId(OracleJspRuntime.toStr( "typeDesc" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_70.doStartTag();
                          if (__jsp_taghandler_70.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_70,4);
                        }
                        out.write(__oracle_jsp_text[154]);
                        {
                          org.apache.struts.taglib.html.SelectTag __jsp_taghandler_71=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleId size");
                          __jsp_taghandler_71.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_71.setName("rowdata");
                          __jsp_taghandler_71.setOnchange("updateSizeTypeRecStatus(this);");
                          __jsp_taghandler_71.setProperty("size");
                          __jsp_taghandler_71.setStyle("width:60px");
                          __jsp_taghandler_71.setStyleId(OracleJspRuntime.toStr( "size" + ctr));
                          __jsp_taghandler_71.setSize("1");
                          __jsp_tag_starteval=__jsp_taghandler_71.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_71,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[155]);
                              {
                                org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_72=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                __jsp_taghandler_72.setParent(__jsp_taghandler_71);
                                __jsp_taghandler_72.setLabel("name");
                                __jsp_taghandler_72.setName("feserv01");
                                __jsp_taghandler_72.setProperty("sizeValues");
                                __jsp_taghandler_72.setValue("code");
                                __jsp_tag_starteval=__jsp_taghandler_72.doStartTag();
                                if (__jsp_taghandler_72.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_72,5);
                              }
                              out.write(__oracle_jsp_text[156]);
                            } while (__jsp_taghandler_71.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_71.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_71,4);
                        }
                        out.write(__oracle_jsp_text[157]);
                        {
                          org.apache.struts.taglib.html.SelectTag __jsp_taghandler_73=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleId size");
                          __jsp_taghandler_73.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_73.setName("rowdata");
                          __jsp_taghandler_73.setOnchange("lp_onChangeCargoType(this);");
                          __jsp_taghandler_73.setProperty("cargoType");
                          __jsp_taghandler_73.setStyle("width:80px");
                          __jsp_taghandler_73.setStyleId(OracleJspRuntime.toStr( "cargoType" + ctr));
                          __jsp_taghandler_73.setSize("1");
                          __jsp_tag_starteval=__jsp_taghandler_73.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_73,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[158]);
                              {
                                org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_74=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                __jsp_taghandler_74.setParent(__jsp_taghandler_73);
                                __jsp_taghandler_74.setLabel("name");
                                __jsp_taghandler_74.setName("feserv01");
                                __jsp_taghandler_74.setProperty("cargoTypeValues");
                                __jsp_taghandler_74.setValue("code");
                                __jsp_tag_starteval=__jsp_taghandler_74.doStartTag();
                                if (__jsp_taghandler_74.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_74,5);
                              }
                              out.write(__oracle_jsp_text[159]);
                            } while (__jsp_taghandler_73.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_73.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_73,4);
                        }
                        out.write(__oracle_jsp_text[160]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_75=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
                          __jsp_taghandler_75.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_75.setMaxlength("4");
                          __jsp_taghandler_75.setName("rowdata");
                          __jsp_taghandler_75.setOnblur("maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);");
                          __jsp_taghandler_75.setProperty("laden");
                          __jsp_taghandler_75.setStyle("width:70px");
                          __jsp_taghandler_75.setStyleClass("must");
                          __jsp_taghandler_75.setStyleId(OracleJspRuntime.toStr( "laden" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_75.doStartTag();
                          if (__jsp_taghandler_75.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_75,4);
                        }
                        out.write(__oracle_jsp_text[161]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_76=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_76.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_76.setName("rowdata");
                          __jsp_taghandler_76.setProperty("cargoType");
                          __jsp_taghandler_76.setValue("N");
                          __jsp_tag_starteval=__jsp_taghandler_76.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[162]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_77=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
                                __jsp_taghandler_77.setParent(__jsp_taghandler_76);
                                __jsp_taghandler_77.setMaxlength("4");
                                __jsp_taghandler_77.setName("rowdata");
                                __jsp_taghandler_77.setOnblur("maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);");
                                __jsp_taghandler_77.setProperty("mt");
                                __jsp_taghandler_77.setStyle("width:70px");
                                __jsp_taghandler_77.setStyleClass("must");
                                __jsp_taghandler_77.setStyleId(OracleJspRuntime.toStr( "mt" + ctr));
                                __jsp_tag_starteval=__jsp_taghandler_77.doStartTag();
                                if (__jsp_taghandler_77.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_77,5);
                              }
                              out.write(__oracle_jsp_text[163]);
                            } while (__jsp_taghandler_76.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_76.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_76,4);
                        }
                        out.write(__oracle_jsp_text[164]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_78=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                          __jsp_taghandler_78.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_78.setName("rowdata");
                          __jsp_taghandler_78.setProperty("cargoType");
                          __jsp_taghandler_78.setValue("N");
                          __jsp_tag_starteval=__jsp_taghandler_78.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[165]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_79=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
                                __jsp_taghandler_79.setParent(__jsp_taghandler_78);
                                __jsp_taghandler_79.setMaxlength("4");
                                __jsp_taghandler_79.setName("rowdata");
                                __jsp_taghandler_79.setOnblur("maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);");
                                __jsp_taghandler_79.setProperty("mt");
                                __jsp_taghandler_79.setReadonly(true);
                                __jsp_taghandler_79.setStyle("width:70px");
                                __jsp_taghandler_79.setStyleClass("must");
                                __jsp_taghandler_79.setStyleId(OracleJspRuntime.toStr( "mt" + ctr));
                                __jsp_tag_starteval=__jsp_taghandler_79.doStartTag();
                                if (__jsp_taghandler_79.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_79,5);
                              }
                              out.write(__oracle_jsp_text[166]);
                            } while (__jsp_taghandler_78.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_78.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_78,4);
                        }
                        out.write(__oracle_jsp_text[167]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_80=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style styleClass styleId");
                          __jsp_taghandler_80.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_80.setMaxlength("17");
                          __jsp_taghandler_80.setName("rowdata");
                          __jsp_taghandler_80.setOnblur("putMask_NumberEX(this, 14, 2);updateSizeTypeRecStatus(this);");
                          __jsp_taghandler_80.setOnclick("hideMask_Number(this);");
                          __jsp_taghandler_80.setProperty("grossContainerWeight");
                          __jsp_taghandler_80.setStyle("width:195px");
                          __jsp_taghandler_80.setStyleClass("must");
                          __jsp_taghandler_80.setStyleId(OracleJspRuntime.toStr( "grossContainerWeight" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_80.doStartTag();
                          if (__jsp_taghandler_80.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_80,4);
                        }
                        out.write(__oracle_jsp_text[168]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_81=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_81.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_81.setName("feserv01");
                          __jsp_taghandler_81.setProperty("socCocUserFlag");
                          __jsp_taghandler_81.setValue("S");
                          __jsp_tag_starteval=__jsp_taghandler_81.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[169]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_82=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style styleId size");
                                __jsp_taghandler_82.setParent(__jsp_taghandler_81);
                                __jsp_taghandler_82.setName("rowdata");
                                __jsp_taghandler_82.setOnblur("updateSizeTypeRecStatus(this);");
                                __jsp_taghandler_82.setProperty("polStatus");
                                __jsp_taghandler_82.setStyle("height=20px;width:60px");
                                __jsp_taghandler_82.setStyleId(OracleJspRuntime.toStr( "polStatus" + ctr));
                                __jsp_taghandler_82.setSize("1");
                                __jsp_tag_starteval=__jsp_taghandler_82.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_82,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[170]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_83=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_83.setParent(__jsp_taghandler_82);
                                      __jsp_taghandler_83.setLabel("name");
                                      __jsp_taghandler_83.setName("feserv01");
                                      __jsp_taghandler_83.setProperty("polStatusList");
                                      __jsp_taghandler_83.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_83.doStartTag();
                                      if (__jsp_taghandler_83.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_83,6);
                                    }
                                    out.write(__oracle_jsp_text[171]);
                                  } while (__jsp_taghandler_82.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_82.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_82,5);
                              }
                              out.write(__oracle_jsp_text[172]);
                            } while (__jsp_taghandler_81.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_81.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_81,4);
                        }
                        out.write(__oracle_jsp_text[173]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_84=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_84.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_84.setName("feserv01");
                          __jsp_taghandler_84.setProperty("socCocUserFlag");
                          __jsp_taghandler_84.setValue("C");
                          __jsp_tag_starteval=__jsp_taghandler_84.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[174]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_85=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag disabled name onblur property style styleId size");
                                __jsp_taghandler_85.setParent(__jsp_taghandler_84);
                                __jsp_taghandler_85.setDisabled(true);
                                __jsp_taghandler_85.setName("rowdata");
                                __jsp_taghandler_85.setOnblur("updateSizeTypeRecStatus(this);");
                                __jsp_taghandler_85.setProperty("polStatus");
                                __jsp_taghandler_85.setStyle("height=20px;width:60px");
                                __jsp_taghandler_85.setStyleId(OracleJspRuntime.toStr( "polStatus" + ctr));
                                __jsp_taghandler_85.setSize("1");
                                __jsp_tag_starteval=__jsp_taghandler_85.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_85,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[175]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_86=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_86.setParent(__jsp_taghandler_85);
                                      __jsp_taghandler_86.setLabel("name");
                                      __jsp_taghandler_86.setName("feserv01");
                                      __jsp_taghandler_86.setProperty("polStatusList");
                                      __jsp_taghandler_86.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_86.doStartTag();
                                      if (__jsp_taghandler_86.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_86,6);
                                    }
                                    out.write(__oracle_jsp_text[176]);
                                  } while (__jsp_taghandler_85.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_85.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_85,5);
                              }
                              out.write(__oracle_jsp_text[177]);
                            } while (__jsp_taghandler_84.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_84.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_84,4);
                        }
                        out.write(__oracle_jsp_text[178]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_87=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_87.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_87.setName("feserv01");
                          __jsp_taghandler_87.setProperty("socCocUserFlag");
                          __jsp_taghandler_87.setValue("S");
                          __jsp_tag_starteval=__jsp_taghandler_87.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[179]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_88=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style styleId size");
                                __jsp_taghandler_88.setParent(__jsp_taghandler_87);
                                __jsp_taghandler_88.setName("rowdata");
                                __jsp_taghandler_88.setOnblur("updateSizeTypeRecStatus(this);");
                                __jsp_taghandler_88.setProperty("podStatus");
                                __jsp_taghandler_88.setStyle("height=20px;width:60px");
                                __jsp_taghandler_88.setStyleId(OracleJspRuntime.toStr( "podStatus" + ctr));
                                __jsp_taghandler_88.setSize("1");
                                __jsp_tag_starteval=__jsp_taghandler_88.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_88,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[180]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_89=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_89.setParent(__jsp_taghandler_88);
                                      __jsp_taghandler_89.setLabel("name");
                                      __jsp_taghandler_89.setName("feserv01");
                                      __jsp_taghandler_89.setProperty("podStatusList");
                                      __jsp_taghandler_89.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_89.doStartTag();
                                      if (__jsp_taghandler_89.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_89,6);
                                    }
                                    out.write(__oracle_jsp_text[181]);
                                  } while (__jsp_taghandler_88.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_88.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_88,5);
                              }
                              out.write(__oracle_jsp_text[182]);
                            } while (__jsp_taghandler_87.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_87.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_87,4);
                        }
                        out.write(__oracle_jsp_text[183]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_90=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_90.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_90.setName("feserv01");
                          __jsp_taghandler_90.setProperty("socCocUserFlag");
                          __jsp_taghandler_90.setValue("C");
                          __jsp_tag_starteval=__jsp_taghandler_90.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[184]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_91=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag disabled name onblur property style styleId size");
                                __jsp_taghandler_91.setParent(__jsp_taghandler_90);
                                __jsp_taghandler_91.setDisabled(true);
                                __jsp_taghandler_91.setName("rowdata");
                                __jsp_taghandler_91.setOnblur("updateSizeTypeRecStatus(this);");
                                __jsp_taghandler_91.setProperty("podStatus");
                                __jsp_taghandler_91.setStyle("height=20px;width:60px");
                                __jsp_taghandler_91.setStyleId(OracleJspRuntime.toStr( "podStatus" + ctr));
                                __jsp_taghandler_91.setSize("1");
                                __jsp_tag_starteval=__jsp_taghandler_91.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_91,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[185]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_92=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_92.setParent(__jsp_taghandler_91);
                                      __jsp_taghandler_92.setLabel("name");
                                      __jsp_taghandler_92.setName("feserv01");
                                      __jsp_taghandler_92.setProperty("podStatusList");
                                      __jsp_taghandler_92.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_92.doStartTag();
                                      if (__jsp_taghandler_92.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_92,6);
                                    }
                                    out.write(__oracle_jsp_text[186]);
                                  } while (__jsp_taghandler_91.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_91.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_91,5);
                              }
                              out.write(__oracle_jsp_text[187]);
                            } while (__jsp_taghandler_90.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_90.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_90,4);
                        }
                        out.write(__oracle_jsp_text[188]);
                        
                                                if(count == 1){
                                              
                        out.write(__oracle_jsp_text[189]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_93=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_93.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_93.setName("rowdata");
                          __jsp_taghandler_93.setProperty("eqRecordStatus");
                          __jsp_taghandler_93.setStyleId(OracleJspRuntime.toStr( "eqRecordStatus" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_93.doStartTag();
                          if (__jsp_taghandler_93.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_93,4);
                        }
                        out.write(__oracle_jsp_text[190]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_94=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_94.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_94.setName("rowdata");
                          __jsp_taghandler_94.setProperty("eqSeqNo");
                          __jsp_taghandler_94.setStyleId(OracleJspRuntime.toStr( "eqSeqNo" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_94.doStartTag();
                          if (__jsp_taghandler_94.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_94,4);
                        }
                        out.write(__oracle_jsp_text[191]);
                        }else{
                        out.write(__oracle_jsp_text[192]);
                        {
                          org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_95=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style styleId value");
                          __jsp_taghandler_95.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_95.setName("rowdata");
                          __jsp_taghandler_95.setProperty("equipmentSelectChkBox");
                          __jsp_taghandler_95.setStyle("border:0px;width:20%");
                          __jsp_taghandler_95.setStyleId(OracleJspRuntime.toStr( "equipmentSelectChkBox" + ctr));
                          __jsp_taghandler_95.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_95.doStartTag();
                          if (__jsp_taghandler_95.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_95,4);
                        }
                        out.write(__oracle_jsp_text[193]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_96=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_96.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_96.setName("rowdata");
                          __jsp_taghandler_96.setProperty("eqRecordStatus");
                          __jsp_taghandler_96.setStyleId(OracleJspRuntime.toStr( "eqRecordStatus" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_96.doStartTag();
                          if (__jsp_taghandler_96.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_96,4);
                        }
                        out.write(__oracle_jsp_text[194]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_97=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_97.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_97.setName("rowdata");
                          __jsp_taghandler_97.setProperty("eqSeqNo");
                          __jsp_taghandler_97.setStyleId(OracleJspRuntime.toStr( "eqSeqNo" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_97.doStartTag();
                          if (__jsp_taghandler_97.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_97,4);
                        }
                        out.write(__oracle_jsp_text[195]);
                        }
                                                count++;
                                             
                        out.write(__oracle_jsp_text[196]);
                      } while (__jsp_taghandler_68.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_68.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_68,3);
                  }
                  out.write(__oracle_jsp_text[197]);
                } while (__jsp_taghandler_67.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_67.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_67,2);
            }
            out.write(__oracle_jsp_text[198]);
            out.write(__oracle_jsp_text[199]);
            out.write(__oracle_jsp_text[200]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_98=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onclick onkeyup property rows styleClass");
              __jsp_taghandler_98.setParent(__jsp_taghandler_1);
              __jsp_taghandler_98.setCols("50");
              __jsp_taghandler_98.setName("feserv01");
              __jsp_taghandler_98.setOnclick("maxlenghtTextArea('cargoDescription', 500)");
              __jsp_taghandler_98.setOnkeyup("maxlenghtTextArea('cargoDescription', 500)");
              __jsp_taghandler_98.setProperty("cargoDescription");
              __jsp_taghandler_98.setRows("5");
              __jsp_taghandler_98.setStyleClass("ComboMust");
              __jsp_tag_starteval=__jsp_taghandler_98.doStartTag();
              if (__jsp_taghandler_98.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_98,2);
            }
            out.write(__oracle_jsp_text[201]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_99=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onblur onclick onkeyup property rows styleClass");
              __jsp_taghandler_99.setParent(__jsp_taghandler_1);
              __jsp_taghandler_99.setCols("50");
              __jsp_taghandler_99.setName("feserv01");
              __jsp_taghandler_99.setOnblur("updateSizeTypeRecStatus(this);");
              __jsp_taghandler_99.setOnclick("maxlenghtTextArea('cargoDescription', 500)");
              __jsp_taghandler_99.setOnkeyup("maxlenghtTextArea('cargoDescription', 500)");
              __jsp_taghandler_99.setProperty("cargoDescription");
              __jsp_taghandler_99.setRows("5");
              __jsp_taghandler_99.setStyleClass("ComboMust");
              __jsp_tag_starteval=__jsp_taghandler_99.doStartTag();
              if (__jsp_taghandler_99.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_99,2);
            }
            out.write(__oracle_jsp_text[202]);
            out.write(__oracle_jsp_text[203]);
            out.write(__oracle_jsp_text[204]);
            
                        int countCommo = 0;            
                        //COMMODITY_SELECT
                    
            out.write(__oracle_jsp_text[205]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_100=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_100.setParent(__jsp_taghandler_1);
              __jsp_taghandler_100.setId("rowdata");
              __jsp_taghandler_100.setIndexId("ctr");
              __jsp_taghandler_100.setName("feserv01");
              __jsp_taghandler_100.setProperty("commodityVoDataList");
              __jsp_taghandler_100.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod");
              com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod rowdata = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_100.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_100,__jsp_tag_starteval,out);
                do {
                  rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod) pageContext.findAttribute("rowdata");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[206]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_101=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_101.setParent(__jsp_taghandler_100);
                    __jsp_taghandler_101.setName("rowdata");
                    __jsp_taghandler_101.setProperty("recordStatus");
                    __jsp_taghandler_101.setValue("DEL");
                    __jsp_tag_starteval=__jsp_taghandler_101.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[207]);
                        {
                          org.apache.struts.taglib.html.RadioTag __jsp_taghandler_102=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property style styleId value");
                          __jsp_taghandler_102.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_102.setName("rowdata");
                          __jsp_taghandler_102.setOnclick("displaySpecialIns()");
                          __jsp_taghandler_102.setProperty("radCommodity");
                          __jsp_taghandler_102.setStyle("border:0px;width:100%");
                          __jsp_taghandler_102.setStyleId(OracleJspRuntime.toStr( "radCommodity" + ctr));
                          __jsp_taghandler_102.setValue(OracleJspRuntime.toStr( ctr));
                          __jsp_tag_starteval=__jsp_taghandler_102.doStartTag();
                          if (__jsp_taghandler_102.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_102,4);
                        }
                        out.write(__oracle_jsp_text[208]);
                        out.print(countCommo+1);
                        out.write(__oracle_jsp_text[209]);
                        out.print(ctr);
                        out.write(__oracle_jsp_text[210]);
                        out.print(ctr);
                        out.write(__oracle_jsp_text[211]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_103=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_103.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_103.setName("rowdata");
                          __jsp_taghandler_103.setProperty("seqNo");
                          __jsp_taghandler_103.setStyleId(OracleJspRuntime.toStr( "seqNo" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_103.doStartTag();
                          if (__jsp_taghandler_103.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_103,4);
                        }
                        out.write(__oracle_jsp_text[212]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_104=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
                          __jsp_taghandler_104.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_104.setMaxlength("1");
                          __jsp_taghandler_104.setName("rowdata");
                          __jsp_taghandler_104.setOnblur("updateCommodityRecStatus(this);changeUpper(this);");
                          __jsp_taghandler_104.setProperty("group");
                          __jsp_taghandler_104.setReadonly(true);
                          __jsp_taghandler_104.setStyle("width:80%");
                          __jsp_taghandler_104.setStyleClass("must");
                          __jsp_taghandler_104.setStyleId(OracleJspRuntime.toStr( "group" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_104.doStartTag();
                          if (__jsp_taghandler_104.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_104,4);
                        }
                        out.write(__oracle_jsp_text[213]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_105=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
                          __jsp_taghandler_105.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_105.setMaxlength("1");
                          __jsp_taghandler_105.setName("rowdata");
                          __jsp_taghandler_105.setOnblur("changeUpper(this)");
                          __jsp_taghandler_105.setProperty("description");
                          __jsp_taghandler_105.setReadonly(true);
                          __jsp_taghandler_105.setStyle("width:80%");
                          __jsp_taghandler_105.setStyleId(OracleJspRuntime.toStr( "description" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_105.doStartTag();
                          if (__jsp_taghandler_105.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_105,4);
                        }
                        out.write(__oracle_jsp_text[214]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_106=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style styleId");
                          __jsp_taghandler_106.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_106.setMaxlength("17");
                          __jsp_taghandler_106.setName("rowdata");
                          __jsp_taghandler_106.setOnblur("updateCommodityRecStatus(this);putMask_NumberEX(this, 14, 2);");
                          __jsp_taghandler_106.setOnclick("hideMask_Number(this);");
                          __jsp_taghandler_106.setProperty("grossWeight");
                          __jsp_taghandler_106.setStyle("width:80%");
                          __jsp_taghandler_106.setStyleId(OracleJspRuntime.toStr( "grossWeight" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_106.doStartTag();
                          if (__jsp_taghandler_106.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_106,4);
                        }
                        out.write(__oracle_jsp_text[215]);
                        {
                          org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_107=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name onclick property style styleId value");
                          __jsp_taghandler_107.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_107.setName("rowdata");
                          __jsp_taghandler_107.setOnclick("lp_onChangeRateType();displaySpecialIns();updateCommodityRecStatus(this);");
                          __jsp_taghandler_107.setProperty("specialCargo");
                          __jsp_taghandler_107.setStyle("border:0px;width:10%;");
                          __jsp_taghandler_107.setStyleId(OracleJspRuntime.toStr( "specialCargo" + ctr));
                          __jsp_taghandler_107.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_107.doStartTag();
                          if (__jsp_taghandler_107.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_107,4);
                        }
                        out.write(__oracle_jsp_text[216]);
                        {
                          org.apache.struts.taglib.html.SelectTag __jsp_taghandler_108=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property size");
                          __jsp_taghandler_108.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_108.setName("rowdata");
                          __jsp_taghandler_108.setOnchange("lp_onChangeRateType();updateCommodityRecStatus(this);");
                          __jsp_taghandler_108.setProperty("rateType");
                          __jsp_taghandler_108.setSize("1");
                          __jsp_tag_starteval=__jsp_taghandler_108.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_108,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[217]);
                              {
                                org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_109=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                __jsp_taghandler_109.setParent(__jsp_taghandler_108);
                                __jsp_taghandler_109.setLabel("name");
                                __jsp_taghandler_109.setName("feserv01");
                                __jsp_taghandler_109.setProperty("rateTypeValues");
                                __jsp_taghandler_109.setValue("code");
                                __jsp_tag_starteval=__jsp_taghandler_109.doStartTag();
                                if (__jsp_taghandler_109.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_109,5);
                              }
                              out.write(__oracle_jsp_text[218]);
                            } while (__jsp_taghandler_108.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_108.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_108,4);
                        }
                        out.write(__oracle_jsp_text[219]);
                        out.print(rowdata.getRateTypeClassName());
                        out.write(__oracle_jsp_text[220]);
                        
                                                if(countCommo == 0){
                                              
                        out.write(__oracle_jsp_text[221]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_110=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_110.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_110.setName("rowdata");
                          __jsp_taghandler_110.setProperty("recordStatus");
                          __jsp_taghandler_110.setStyleId(OracleJspRuntime.toStr( "recordStatus" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_110.doStartTag();
                          if (__jsp_taghandler_110.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_110,4);
                        }
                        out.write(__oracle_jsp_text[222]);
                        }else{
                        out.write(__oracle_jsp_text[223]);
                        {
                          org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_111=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style styleId value");
                          __jsp_taghandler_111.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_111.setName("rowdata");
                          __jsp_taghandler_111.setProperty("isSelected");
                          __jsp_taghandler_111.setStyle("border:0px;width:10%;");
                          __jsp_taghandler_111.setStyleId(OracleJspRuntime.toStr( "isSelected" + ctr));
                          __jsp_taghandler_111.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_111.doStartTag();
                          if (__jsp_taghandler_111.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_111,4);
                        }
                        out.write(__oracle_jsp_text[224]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_112=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_112.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_112.setName("rowdata");
                          __jsp_taghandler_112.setProperty("recordStatus");
                          __jsp_taghandler_112.setStyleId(OracleJspRuntime.toStr( "recordStatus" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_112.doStartTag();
                          if (__jsp_taghandler_112.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_112,4);
                        }
                        out.write(__oracle_jsp_text[225]);
                        }
                                                countCommo++;
                                             
                        out.write(__oracle_jsp_text[226]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_113=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_113.setParent(__jsp_taghandler_101);
                          __jsp_taghandler_113.setName("rowdata");
                          __jsp_taghandler_113.setProperty("rateTypeFlag");
                          __jsp_taghandler_113.setStyleId(OracleJspRuntime.toStr( "rateTypeFlag" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_113.doStartTag();
                          if (__jsp_taghandler_113.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_113,4);
                        }
                        out.write(__oracle_jsp_text[227]);
                      } while (__jsp_taghandler_101.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_101.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_101,3);
                  }
                  out.write(__oracle_jsp_text[228]);
                } while (__jsp_taghandler_100.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_100.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_100,2);
            }
            out.write(__oracle_jsp_text[229]);
            out.write(__oracle_jsp_text[230]);
            out.write(__oracle_jsp_text[231]);
            out.write(__oracle_jsp_text[232]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_114=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onclick onkeyup property rows styleClass");
              __jsp_taghandler_114.setParent(__jsp_taghandler_1);
              __jsp_taghandler_114.setCols("50");
              __jsp_taghandler_114.setName("feserv01");
              __jsp_taghandler_114.setOnclick("maxlenghtTextArea('specialInstruction', 400)");
              __jsp_taghandler_114.setOnkeyup("maxlenghtTextArea('specialInstruction', 400)");
              __jsp_taghandler_114.setProperty("specialInstruction");
              __jsp_taghandler_114.setRows("5");
              __jsp_taghandler_114.setStyleClass("Combo");
              __jsp_tag_starteval=__jsp_taghandler_114.doStartTag();
              if (__jsp_taghandler_114.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_114,2);
            }
            out.write(__oracle_jsp_text[233]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_115=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_115.setParent(__jsp_taghandler_1);
              __jsp_taghandler_115.setId("rowdata");
              __jsp_taghandler_115.setIndexId("ctr");
              __jsp_taghandler_115.setName("feserv01");
              __jsp_taghandler_115.setProperty("commodityVoDataList");
              __jsp_taghandler_115.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod");
              com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod rowdata = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_115.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_115,__jsp_tag_starteval,out);
                do {
                  rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod) pageContext.findAttribute("rowdata");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[234]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_116=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_116.setParent(__jsp_taghandler_115);
                    __jsp_taghandler_116.setName("rowdata");
                    __jsp_taghandler_116.setProperty("recordStatus");
                    __jsp_taghandler_116.setValue("DEL");
                    __jsp_tag_starteval=__jsp_taghandler_116.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[235]);
                        {
                          org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_117=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onblur onclick onkeyup property rows styleClass styleId");
                          __jsp_taghandler_117.setParent(__jsp_taghandler_116);
                          __jsp_taghandler_117.setCols("50");
                          __jsp_taghandler_117.setName("rowdata");
                          __jsp_taghandler_117.setOnblur("updateCommodityRecStatus(this);");
                          __jsp_taghandler_117.setOnclick("maxlenghtTextArea(this, 400)");
                          __jsp_taghandler_117.setOnkeyup("maxlenghtTextArea(this, 400)");
                          __jsp_taghandler_117.setProperty("specialInstruction");
                          __jsp_taghandler_117.setRows("5");
                          __jsp_taghandler_117.setStyleClass("Combo");
                          __jsp_taghandler_117.setStyleId(OracleJspRuntime.toStr( "specialInstruction" + ctr));
                          __jsp_tag_starteval=__jsp_taghandler_117.doStartTag();
                          if (__jsp_taghandler_117.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_117,4);
                        }
                        out.write(__oracle_jsp_text[236]);
                      } while (__jsp_taghandler_116.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_116.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_116,3);
                  }
                  out.write(__oracle_jsp_text[237]);
                } while (__jsp_taghandler_115.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_115.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_115,2);
            }
            out.write(__oracle_jsp_text[238]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_118=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleId");
              __jsp_taghandler_118.setParent(__jsp_taghandler_1);
              __jsp_taghandler_118.setMaxlength("17");
              __jsp_taghandler_118.setName("feserv01");
              __jsp_taghandler_118.setOnblur("changeUpper(this)");
              __jsp_taghandler_118.setProperty("templateName");
              __jsp_taghandler_118.setStyle("width:90%");
              __jsp_taghandler_118.setStyleId("templatename");
              __jsp_tag_starteval=__jsp_taghandler_118.doStartTag();
              if (__jsp_taghandler_118.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_118,2);
            }
            out.write(__oracle_jsp_text[239]);
            out.write(__oracle_jsp_text[240]);
            out.write(__oracle_jsp_text[241]);
            out.write(__oracle_jsp_text[242]);
            out.write(__oracle_jsp_text[243]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_119=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style");
              __jsp_taghandler_119.setParent(__jsp_taghandler_1);
              __jsp_taghandler_119.setName("feserv01");
              __jsp_taghandler_119.setProperty("rclArrangementChkBox");
              __jsp_taghandler_119.setStyle("border:0px;width:10%");
              __jsp_tag_starteval=__jsp_taghandler_119.doStartTag();
              if (__jsp_taghandler_119.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_119,2);
            }
            out.write(__oracle_jsp_text[244]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[245]);

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
  private static final char __oracle_jsp_text[][]=new char[246][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n".toCharArray();
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
    "\r\n\r\n<head>\r\n<style type=\"text/css\">\r\n/*\r\nselect.center_pull {\r\n    background:#eeeeee none repeat scroll 0 0;\r\n    border:1px solid #7E7E7E;\r\n    color:#333333;\r\n    font-size:12px;\r\n    margin-bottom:4px;\r\n    margin-right:4px;\r\n    margin-top:4px;\r\n    width:145px;\r\n}\r\n*/\r\n</style>\r\n<script type=\"text/javascript\">\r\n  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\r\n  ga('create', 'UA-39255240-1', 'rclgroup.com');\r\n  ga('send', 'pageview');\r\n</script>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "/js/screen/EserviceNewWebBooking.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n    var POPULATE_DEPENDENT_COMBOS\r\n        = '".toCharArray();
    __oracle_jsp_text[10] = 
    "';\r\n    var SAVE_BOOKING\r\n        = '".toCharArray();
    __oracle_jsp_text[11] = 
    "';\r\n    var OPEN_ACKNOWLEDGEMENT\r\n        = '".toCharArray();
    __oracle_jsp_text[12] = 
    "';\r\n    var COMMODITY_LOOKUP\r\n        = '".toCharArray();
    __oracle_jsp_text[13] = 
    "';\r\n    var SAVE_TEMPLATE\r\n        = '".toCharArray();
    __oracle_jsp_text[14] = 
    "';\r\n    var GET_TEMPLATE_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[15] = 
    "';\r\n    var DEL_SIZE_TYPE_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\r\n    var DEL_COMMODITY_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[17] = 
    "';\r\n    var CHECK_QTN\r\n        = '".toCharArray();
    __oracle_jsp_text[18] = 
    "';\r\n        //@03 BEGIN\r\n    var GET_DATA_BT_QTN\r\n        = '".toCharArray();
    __oracle_jsp_text[19] = 
    "';\r\n        //@03 END\r\n        \r\n    var GET_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[20] = 
    "';\r\n    var CHECK_QTN_SIZE\r\n        = '".toCharArray();
    __oracle_jsp_text[21] = 
    "';\r\n    var SET_QUATATION_ROUTING_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[22] = 
    "';\r\n    \r\n    var ADD_COMMODITY_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[23] = 
    "';\r\n    \r\n    var UPD_COMMODITY_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[24] = 
    "';\r\n    \r\n    var REFER_COMMODITY\r\n        = '".toCharArray();
    __oracle_jsp_text[25] = 
    "';\r\n    \r\n    var REFER_COMMODITY_GET_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[26] = 
    "';\r\n    \r\n    var DG_COMMODITY\r\n        = '".toCharArray();
    __oracle_jsp_text[27] = 
    "';\r\n    \r\n    var DG_COMMODITY_GET_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[28] = 
    "';\r\n        \r\n    var OOG_COMMODITY\r\n        = '".toCharArray();
    __oracle_jsp_text[29] = 
    "';\r\n    \r\n    var OOG_COMMODITY_GET_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[30] = 
    "';\r\n    \r\n    var CHANGE_RATE_TYPE\r\n        = '".toCharArray();
    __oracle_jsp_text[31] = 
    "';\r\n\r\n    var ADD_SIZE_TYPE_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[32] = 
    "';  \r\n    \r\n    var UPD_SIZE_TYPE_DATA\r\n        = '".toCharArray();
    __oracle_jsp_text[33] = 
    "';   \r\n    \r\n    var UPLOAD_ATTACHMENT\r\n        = '".toCharArray();
    __oracle_jsp_text[34] = 
    "'; \r\n    \r\n    var GET_UPLOAD_ATTACHMENT\r\n        = '".toCharArray();
    __oracle_jsp_text[35] = 
    "';\r\n    \r\n    var GET_EQUIP_TYPE_LOOKUP_DATA     \r\n        = '".toCharArray();
    __oracle_jsp_text[36] = 
    "';   \r\n    \r\n    /*Begin @11*/    \r\n    var CHANGE_REP_COMP     \r\n        = '".toCharArray();
    __oracle_jsp_text[37] = 
    "';\r\n    /*End @11*/\r\n    \r\n    var ON_LOAD\r\n        = '".toCharArray();
    __oracle_jsp_text[38] = 
    "';\r\n    \r\n</script>\r\n</head>\r\n<body>\r\n    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n        <!--Begin @10 -->\r\n        ".toCharArray();
    __oracle_jsp_text[58] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[60] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[61] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[62] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n        <!--End @10 -->\r\n        \r\n        ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[66] = 
    "\r\n       ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n       <div id=\"divBackground\" style=\"position: absolute; top: 0px; left: 0px; background-color: black;\r\n        z-index: 100; opacity: 0.8; filter: alpha(opacity=60); -moz-opacity: 0.8; overflow: hidden;\r\n        display: none\">\r\n        </div> \r\n        \r\n        \r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Booking Details </h2>\r\n        </div>\r\n\r\n        ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n        \r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td class=\"lableBackground\">\r\n                    Template\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n                </td>\r\n                <!--Begin @11 -->\r\n                <td class=\"whitebg\" colspan=\"3\" align=\"left\">\r\n                    ".toCharArray();
    __oracle_jsp_text[72] = 
    "&nbsp;\r\n                    Represented Company :\r\n                    ".toCharArray();
    __oracle_jsp_text[73] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[74] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[75] = 
    "\r\n                </td>\r\n                <!--End @11 -->\r\n                <!--Begin @12 -->\r\n                <td width=\"4%\" class=\"lableBackground\">\r\n                    COC/SOC\r\n                </td>\r\n                <td width=\"15%\" class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[77] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n                </td>\r\n                <!--End @12 -->\r\n                <td width=\"4%\" class=\"lableBackground\">\r\n                    Status\r\n                </td>\r\n                <td width=\"15%\" class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[80] = 
    "\r\n                    </font>\r\n                </td>\r\n\r\n            </tr>\r\n            <tr>\r\n                <td class=\"lableBackground\">\r\n                    Booking Number\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td width=\"8%\" class=\"lableBackground\">\r\n                    Quotation Number\r\n                </td>\r\n                <td width=\"4%\" class=\"lableBackground\">&nbsp;</td>\r\n                <td width=\"22%\" class=\"whitebg\">\r\n                <!-- @03 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n                    <a id=\"qtnInfo\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onmouseover=\"showQuotationInfo()\">\r\n                        <i class=\"icon-info-sign icon-white\"></i>\r\n                    </a>                    \r\n                </td>\r\n\r\n                <!-- split shipment term to POL and POD -->\r\n                <td width=\"10%\" class=\"lableBackground\">\r\n                    POL Term\r\n                </td>\r\n                <td width=\"10%\" class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[86] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[87] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[88] = 
    "\r\n                </td>\r\n                <td width=\"10%\" class=\"lableBackground\">\r\n                    POD Term\r\n                </td>\r\n                <td width=\"10%\" class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[89] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[90] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[91] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[92] = 
    "\r\n                </td>\r\n                <!-- end -->\r\n              ".toCharArray();
    __oracle_jsp_text[93] = 
    "\r\n            </tr>\r\n            <tr>\r\n                <td class=\"lableBackground\">\r\n                    Customer Reference\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[94] = 
    "\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Email\r\n                </td>\r\n                <td class=\"lableBackground\" >&nbsp;</td>\r\n                <td class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[95] = 
    "\r\n                    <font class=\"displayText\">\r\n                       ".toCharArray();
    __oracle_jsp_text[96] = 
    " \r\n                         ".toCharArray();
    __oracle_jsp_text[97] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Telephone\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[98] = 
    "\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Fax\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[99] = 
    "\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td width=\"9%\" class=\"lableBackground\">\r\n                    Contact Person\r\n                </td>\r\n                <td class=\"whitebg\" width=\"17%\">\r\n                <!-- @06 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[100] = 
    "\r\n                <!-- @06 END -->\r\n                </td>\r\n                <td colspan=\"2\" class=\"lableBackground\">\r\n                    Additional Mail Recipients\r\n                </td>\r\n                <td colspan=\"5\" >\r\n                    ".toCharArray();
    __oracle_jsp_text[101] = 
    "\r\n                    &nbsp;&nbsp;(please key in multiple mail addresses separated by comma)\r\n                </td>\r\n            </tr>\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[102] = 
    "\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Routing Details</h2>\r\n        </div>\r\n\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Origin Country                    </span>                </td>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Destination Country                    </span>                </td>\r\n                <td width=\"13%\" class=\"tableHeadingBlue\" >\r\n                    <span class=\"m0l0iout\">\r\n                        Place of Receipt                    </span>                </td>\r\n                <td width=\"12%\" class=\"tableHeadingBlue\" >\r\n                    <span class=\"m0l0iout\">\r\n                        &nbsp;                  </span>                </td>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Port of Loading POL                    </span>                </td>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Port of Discharge POD                    </span>                </td>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Place of Delivery                    </span>                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Empty Pickup Depot\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Empty Pickup Date\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        <!--Shipment Date -->Cargo Availability Date                   </span>                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        <!--Shipment Date -->Expected Sailing Date                  </span>                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Desired Arrival Date                    </span>                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Routing                    </span>                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">                    </span>                </td>\r\n            </tr>\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[103] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[104] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[105] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[106] = 
    "\r\n                </td>\r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[107] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[108] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[109] = 
    "                </td>\r\n                <td class=\"tableColumnData\" width=\"13%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[110] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[111] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[112] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[113] = 
    "\r\n                    <!-- @05 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[114] = 
    "\r\n                    <!-- @05 END -->\r\n                    ".toCharArray();
    __oracle_jsp_text[115] = 
    "\r\n                    </td>\r\n                <td class=\"tableColumnData\" width=\"12%\">\r\n                    &nbsp; </td>\r\n                \r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[116] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[117] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[118] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[119] = 
    "\r\n                    <!-- @05 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[120] = 
    "\r\n                    <!-- @05 END -->\r\n                    ".toCharArray();
    __oracle_jsp_text[121] = 
    "\r\n                </td>\r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[122] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[123] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[124] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[125] = 
    "\r\n                    <!-- @05 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[126] = 
    "\r\n                    <!-- @05 END -->\r\n                    ".toCharArray();
    __oracle_jsp_text[127] = 
    "\r\n                </td>\r\n                \r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[128] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[129] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[130] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[131] = 
    "\r\n                    <!-- @05 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[132] = 
    "\r\n                    <!-- @05 END -->\r\n                    ".toCharArray();
    __oracle_jsp_text[133] = 
    "\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"tableColumnData\" id=\"tol\"  width=\"15%\"  >\r\n                    ".toCharArray();
    __oracle_jsp_text[134] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[135] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[136] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[137] = 
    "\r\n                    <!-- @05 BEGIN -->\r\n                    ".toCharArray();
    __oracle_jsp_text[138] = 
    "\r\n                    <!-- @05 END -->\r\n                    ".toCharArray();
    __oracle_jsp_text[139] = 
    "\r\n                    </td>\r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[140] = 
    "\r\n\r\n                    <a href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onClick=\"gp_calendar('emptyPickupDate')\">\r\n                        <i class=\"icon-calendar icon-white\"></i></a>\r\n                </td>\r\n                <td class=\"tableColumnData\" width=\"13%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[141] = 
    "\r\n\r\n                    <a href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onClick=\"gp_calendar('shipmentDate')\">\r\n                        <i class=\"icon-calendar icon-white\"></i></a>\r\n                </td>\r\n                <td class=\"tableColumnData\" width=\"12%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[142] = 
    "\r\n\r\n                    <a href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onClick=\"gp_calendar('sailingDate')\">\r\n                        <i class=\"icon-calendar icon-white\"></i></a>\r\n                </td>\r\n                <td class=\"tableColumnData\" width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[143] = 
    "\r\n\r\n                    <a href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onClick=\"gp_calendar('desiredArrivalDate')\">\r\n                        <i class=\"icon-calendar icon-white\"></i></a>\r\n                </td>\r\n                <td colspan=\"2\" class=\"tableColumnData\" width=\"15%\">\r\n                   <!-- <div class=\"spotlight-action\">class=\"m-btn mini blue rnd\" -->\r\n                        <a class=\"m-btn mini blue rnd\"\r\n                            href=\"javascript:void(0)\"\r\n                            id=\"btnRoutingInfo\"\r\n                            onclick=\"return routingInfoButton()\"><i class=\"icon-search icon-white\"></i>&nbsp;View Schedule </a>\r\n                            <!-- change name \"Routing Info\" to \"View Schedule\" 29/05/2013-->\r\n                            \r\n                    <!-- </div> -->\r\n               <!-- </td> -->\r\n                \r\n               <!-- <td class=\"tableColumnData\"> style=\"float:left;border:0px;width:10%\"  -->\r\n                    ".toCharArray();
    __oracle_jsp_text[144] = 
    "\r\n                    (<span style=\"color: #ff0000\">as per RCL arrangement</span>)                </td>\r\n            </tr>\r\n            <tr>\r\n                <td colspan=\"6\">&nbsp;</td>\r\n                <!-- td>&nbsp;</td>\r\n                <td>&nbsp;</td>\r\n                <td>&nbsp;</td>\r\n                <td>&nbsp;</td>\r\n                <td>&nbsp;</td -->\r\n            </tr>\r\n            <tr>\r\n                <td colspan=\"6\">&nbsp;</td>\r\n            </tr>\r\n        </table>\r\n\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"99%\" class=\"tableHeadingSecondRow2Blue\"><span class=\"tableHeaderLeftAlign\">Routing Preference (5 Lines Maximum) </span></td>\r\n            </tr>\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[145] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n\r\n        <table width =\"50%\" border=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td rowspan=\"4\" width=\"50%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[146] = 
    "\r\n                </td>\r\n                <td>&nbsp;</td>\r\n            </tr>\r\n            <tr>\r\n                <td>&nbsp;</td>\r\n            </tr>\r\n            <tr>\r\n                <td>&nbsp;</td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <div class=\"ReportData4\">  \r\n                        <i>(please state routing preference if any.)</i>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n    </table>\r\n        ".toCharArray();
    __oracle_jsp_text[147] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n\r\n        <div class=\"TableLeftSubColorNoBorder\">\r\n            <h2>Equipment Details</h2>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"3%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">#</span></td>\r\n                <td width=\"18%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Type</span></td>\r\n                <td width=\"5%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Size</span></td>\r\n                <td width=\"8%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Cargo Type </span></td>\r\n                <td width=\"7%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Laden</span></td>\r\n                <td width=\"7%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Empty</span></td>\r\n                <td width=\"18%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Cargo + Container Wt. (KG)</span></td>\r\n                <td width=\"13%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">POL Status </span></td>\r\n                <td width=\"13%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">POD Status </span></td>\r\n                <td width=\"8%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Select</span></td>\r\n            </tr>\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[148] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <div id=\"search_result\" class=\"search_result\" style=\"height:30px;overflow:auto;\">\r\n            <table id=\"result_dtl\" class=\"table_results\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        ".toCharArray();
    __oracle_jsp_text[149] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[150] = 
    "        \r\n            ".toCharArray();
    __oracle_jsp_text[151] = 
    "\r\n                <tr>\r\n                    <td width=\"3%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[152] = 
    "\r\n                    </td>\r\n                    <!-- @04 BEGIN -->\r\n                  <td width=\"18%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[153] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[154] = 
    "\r\n                        <a name=\"btnTypeLookup\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\"\r\n                            onclick='openEquipTypeLookup(this);'>\r\n                            <i class=\"icon-search icon-white\"></i>\r\n                        </a> \r\n                  </td>\r\n                    <td width=\"5%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[155] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[156] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[157] = 
    "\r\n                  </td>\r\n                  <!-- @04 END -->\r\n                    <td width=\"8%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[158] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[159] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[160] = 
    "\r\n                  </td>\r\n                  <td width=\"7%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[161] = 
    "\r\n                  </td>\r\n                  <td width=\"7%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[162] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[163] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[164] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[165] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[166] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[167] = 
    "\r\n                  </td>\r\n                  <td width=\"18%\">\r\n                  <!-- @08 BEGIN putMask_NumberEX(this, 15, 3)-->\r\n                        ".toCharArray();
    __oracle_jsp_text[168] = 
    "\r\n                  <!-- @08 END -->\r\n                  </td>\r\n                  <td width=\"13%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[169] = 
    "\r\n                            <!-- change to drop down 28/05/2013-->     \r\n                            ".toCharArray();
    __oracle_jsp_text[170] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[171] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[172] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[173] = 
    "\r\n                        <!-- add drop down 28/05/2013-->\r\n                        ".toCharArray();
    __oracle_jsp_text[174] = 
    "\r\n                        \r\n                              \r\n                            ".toCharArray();
    __oracle_jsp_text[175] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[176] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[177] = 
    "\r\n                            \r\n                              \r\n                        ".toCharArray();
    __oracle_jsp_text[178] = 
    "\r\n                  </td>\r\n                  <td width=\"13%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[179] = 
    "\r\n                            <!-- change to drop down 28/05/2013-->     \r\n                            ".toCharArray();
    __oracle_jsp_text[180] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[181] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[182] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[183] = 
    "\r\n                        <!-- add drop down 28/05/2013-->\r\n                        ".toCharArray();
    __oracle_jsp_text[184] = 
    "\r\n                          \r\n                            ".toCharArray();
    __oracle_jsp_text[185] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[186] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[187] = 
    "\r\n                           \r\n                        ".toCharArray();
    __oracle_jsp_text[188] = 
    "\r\n                  </td>\r\n                  <td width=\"8%\">\r\n                      ".toCharArray();
    __oracle_jsp_text[189] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[190] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[191] = 
    "    \r\n                        &nbsp;\r\n                     \r\n                     ".toCharArray();
    __oracle_jsp_text[192] = 
    "\r\n                         ".toCharArray();
    __oracle_jsp_text[193] = 
    "\r\n                         ".toCharArray();
    __oracle_jsp_text[194] = 
    "\r\n                         ".toCharArray();
    __oracle_jsp_text[195] = 
    "    \r\n                     ".toCharArray();
    __oracle_jsp_text[196] = 
    "\r\n                  </td>\r\n                </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[197] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[198] = 
    "\r\n            </table>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td colspan=\"5\" >&nbsp;</td>\r\n                <td colspan=\"2\" align=\"right\">\r\n                    <div class=\"spotlight-action\">\r\n                    <!-- @02 BEGIN -->\r\n                        <a class=\"m-btn mini blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return addEquipment()\">\r\n                                <i class=\"icon-plus icon-white\"></i>&nbsp;Add Equipment\r\n                        </a>\r\n                        <a class=\"m-btn mini red rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return deleteEquipment()\">\r\n                                <i class=\"icon-trash icon-white\"></i>&nbsp;Delete Equipment\r\n                        </a>\r\n                        <!-- @02 END -->\r\n                    </div>\r\n                    &nbsp;\r\n                    &nbsp;\r\n                    &nbsp;\r\n                </td>\r\n                <!-- <td>&nbsp;3</td> -->\r\n            </tr>\r\n        </table>\r\n\r\n        ".toCharArray();
    __oracle_jsp_text[199] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <div class=\"TableLeftSubColorNoBorder\">\r\n            <h2>Cargo Description</h2>\r\n        </div>\r\n        ".toCharArray();
    __oracle_jsp_text[200] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n<!--\r\n        <div>\r\n            ".toCharArray();
    __oracle_jsp_text[201] = 
    "\r\n        </div>\r\n-->\r\n\r\n        <table width =\"50%\" border=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td rowspan=\"4\" width=\"100%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[202] = 
    "\r\n\r\n                </td>\r\n            </tr>\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[203] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n\r\n        <div class=\"TableLeftSubColorNoBorder\">\r\n            <h2>Commodity Details</h2>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"4%\" class=\"tableHeadingBlue\">&nbsp;</td>\r\n                <td width=\"4%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">#</span></td>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Commodity Group</span></td>\r\n                <td width=\"20%\" class=\"tableHeadingBlue\">&nbsp;</td>\r\n                <td width=\"15%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Gross Weight </span></td>\r\n                <td width=\"13%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Special Cargo </span></td>\r\n                <!--Begin @10 -->\r\n                <td width=\"16%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Rate Type </span></td>\r\n                <!--End @10 -->\r\n                <td width=\"13%\" class=\"tableHeadingBlue\"><span class=\"m0l1iover\">Select</span></td>\r\n            </tr>\r\n        </table>\r\n\r\n        ".toCharArray();
    __oracle_jsp_text[204] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n\r\n        <div id=\"comm_search_result\" class=\"search_result\" style=\"height:30px\">\r\n            <table id=\"comm_result_dtl\" class=\"table_results\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        ".toCharArray();
    __oracle_jsp_text[205] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[206] = 
    "            \r\n            ".toCharArray();
    __oracle_jsp_text[207] = 
    "\r\n                <tr>\r\n                    <td width=\"4%\" class=\"tableColumnData\">\r\n                        ".toCharArray();
    __oracle_jsp_text[208] = 
    "\r\n                    </td>\r\n                    <td width=\"4%\" class=\"tableColumnData\" align=\"center\">\r\n                        ".toCharArray();
    __oracle_jsp_text[209] = 
    "                               \r\n                    </td>\r\n                    <td width=\"15%\" class=\"tableColumnData\">                        \r\n                        <input type=\"hidden\" name=\"posObjectCommod\" id='posObjectCommod".toCharArray();
    __oracle_jsp_text[210] = 
    "' value=\"".toCharArray();
    __oracle_jsp_text[211] = 
    "\" />\r\n                        ".toCharArray();
    __oracle_jsp_text[212] = 
    " \r\n                        \r\n                        ".toCharArray();
    __oracle_jsp_text[213] = 
    "\r\n                    </td>\r\n                    <td width=\"20%\" class=\"tableColumnData\" style=\"white-space: nowrap;\">\r\n                        ".toCharArray();
    __oracle_jsp_text[214] = 
    "\r\n                        <a name=\"btnCommodityGroupLookup\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\"\r\n                            onclick='openCommodityGroupLookup(this);'>\r\n                            <i class=\"icon-search icon-white\"></i>\r\n                        </a>  \r\n                    </td>\r\n                    <!-- @08 BEGIN putMask_NumberEX(this, 15, 3)-->\r\n                    <td width=\"15%\" class=\"tableColumnData\">\r\n                        ".toCharArray();
    __oracle_jsp_text[215] = 
    "\r\n                    </td>\r\n                    <!-- @08 END -->\r\n                    <td width=\"13%\" class=\"tableColumnData\">\r\n                        ".toCharArray();
    __oracle_jsp_text[216] = 
    "\r\n                    </td>\r\n                    <!--Begin @10 -->\r\n                    <td width=\"16%\" class=\"tableColumnData\" style=\"white-space: nowrap;\">\r\n                        ".toCharArray();
    __oracle_jsp_text[217] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[218] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[219] = 
    "\r\n                        <a class=\"".toCharArray();
    __oracle_jsp_text[220] = 
    "\" href=\"javascript:void(0)\" name=\"btnRateTypeDetails\"  onClick=\"openRateTypeLookUp();\">\r\n                            <i class=\"icon-plus icon-white\"></i>\r\n                        </a>\r\n                    </td>\r\n                    <!--End @10 -->\r\n                    <td width=\"13%\" class=\"tableColumnData\">\r\n                        ".toCharArray();
    __oracle_jsp_text[221] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[222] = 
    "                  \r\n                        &nbsp;                     \r\n                     ".toCharArray();
    __oracle_jsp_text[223] = 
    "\r\n                         ".toCharArray();
    __oracle_jsp_text[224] = 
    "\r\n                         ".toCharArray();
    __oracle_jsp_text[225] = 
    "\r\n                     ".toCharArray();
    __oracle_jsp_text[226] = 
    "\r\n                     ".toCharArray();
    __oracle_jsp_text[227] = 
    "\r\n                    </td>\r\n                </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[228] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[229] = 
    "\r\n            </table>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td colspan=\"5\" >&nbsp;</td>\r\n                <td colspan=\"2\" align=\"right\">\r\n                    <div class=\"spotlight-action\">\r\n                    <!-- @02 BEGIN -->\r\n                        <a class=\"m-btn mini blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return addCommodity()\">\r\n                                <i class=\"icon-plus icon-white\"></i>&nbsp;Add Commodity\r\n                        </a>\r\n                        <a class=\"m-btn mini red rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return deleteCommodity()\">\r\n                                <i class=\"icon-trash icon-white\"></i>&nbsp;Delete Commodity\r\n                        </a>\r\n                    <!-- @02 END -->\r\n                    </div>\r\n                    &nbsp;\r\n                    &nbsp;\r\n                    &nbsp;\r\n                </td>\r\n                <!-- <td>&nbsp;3</td> -->\r\n            </tr>\r\n        </table>\r\n\r\n\r\n        ".toCharArray();
    __oracle_jsp_text[230] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[231] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        \r\n        <div class=\"TableLeftSubColorNoBorder\">\r\n            <h2>Special Instruction (5 Lines Maximum)</h2>\r\n        </div>\r\n        ".toCharArray();
    __oracle_jsp_text[232] = 
    "\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n<!--\r\n        <div>\r\n            ".toCharArray();
    __oracle_jsp_text[233] = 
    "\r\n        </div>\r\n        -->\r\n        <table width =\"100%\" border=\"0\" class=\"table_search\" id=\"tableSI\" style=\"height: 96px;\">       \r\n            ".toCharArray();
    __oracle_jsp_text[234] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[235] = 
    "\r\n                    <tr>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[236] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    ".toCharArray();
    __oracle_jsp_text[237] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[238] = 
    " \r\n        </table>\r\n\r\n        <br/>\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td width=\"40%\" colspan=\"2\">&nbsp;</td>\r\n                <td width=\"25%\" align=\"right\">Enter/Edit Template name</td>\r\n                <td  width=\"35%\" class=\"whitebg\" align=\"center\">\r\n                    ".toCharArray();
    __oracle_jsp_text[239] = 
    "\r\n                </td>\r\n                \r\n                <!-- <td width=\"25%\">&nbsp;</td> -->\r\n            </tr>\r\n            <tr>\r\n                <td>&nbsp;</td>\r\n                <td>&nbsp;</td>\r\n                <td  colspan=\"3\" align=\"right\">\r\n                    ".toCharArray();
    __oracle_jsp_text[240] = 
    "\r\n                    <div class=\"spotlight-action\" id=\"showButton\" style=\"display:inline;\">\r\n                        <a class=\"m-btn sm blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return uploadAttachment();\">\r\n                                Upload Document\r\n                            <i class=\"m-icon-swapup m-icon-white\"></i>\r\n                        </a>\r\n                        <a class=\"m-btn sm blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return saveBooking(MODE_SAVE_DRAFT);\">\r\n                                Save as template\r\n                            <i class=\"m-icon-swapdown m-icon-white\"></i>\r\n                        </a>\r\n                        <a class=\"m-btn sm green rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return saveBooking(MODE_SAVE_BOOKING);\">\r\n                                Submit Booking\r\n                            <i class=\"m-icon-swapright m-icon-white\"></i>\r\n                        </a>\r\n                    </div>\r\n                    <div class=\"spotlight-action\" id=\"hideButton\" style=\"display:none;\">\r\n                        <a class=\"m-btn sm blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return uploadAttachment();\">\r\n                                Upload Document\r\n                            <i class=\"m-icon-swapup m-icon-white\"></i>\r\n                        </a>\r\n                        <a class=\"m-btn sm rnd disabled\"\r\n                            href=\"javascript:void(0)\" >\r\n                                Save as template\r\n                            <i class=\"m-icon-swapdown m-icon-white\"></i>\r\n                        </a>\r\n                        <a class=\"m-btn sm rnd disabled\"\r\n                            href=\"javascript:void(0)\" >\r\n                                Submit Booking \r\n                            <i class=\"m-icon-swapright m-icon-white\"></i>\r\n                        </a>\r\n                    </div>\r\n                    ".toCharArray();
    __oracle_jsp_text[241] = 
    "\r\n                    &nbsp;\r\n                    &nbsp;\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n              <td colspan=\"2\">&nbsp;</td>\r\n              <td  colspan=\"3\" align=\"center\">\r\n                ".toCharArray();
    __oracle_jsp_text[242] = 
    "\r\n            </td>\r\n            </tr>\r\n            <tr>\r\n              <td colspan=\"2\">&nbsp;</td>\r\n              <td  colspan=\"3\" align=\"center\">\r\n                ".toCharArray();
    __oracle_jsp_text[243] = 
    "\r\n            </td>\r\n            </tr>\r\n            <!-- @01 add checkbox for submit ESI -->\r\n            <tr>\r\n                <td width=\"40%\" colspan=\"2\">&nbsp;</td>\r\n                <td width=\"25%\" align=\"right\"></td>\r\n                <td  width=\"35%\" class=\"whitebg\" align=\"right\">\r\n                Will submit eShipping Instruction. &nbsp;\r\n                    ".toCharArray();
    __oracle_jsp_text[244] = 
    "\r\n                </td>\r\n                \r\n                <!-- <td width=\"25%\">&nbsp;</td> -->\r\n            </tr>\r\n            \r\n            <!-- @01 END -->\r\n            \r\n        </table>\r\n\r\n    ".toCharArray();
    __oracle_jsp_text[245] = 
    "\r\n    <br>\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

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
import java.util.List;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao;


public class _EserviceInquiryWebBooking extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceInquiryWebBooking page = this;
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
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[10]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[11]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[12]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext));
      out.write(__oracle_jsp_text[14]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext));
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001", pageContext));
      out.write(__oracle_jsp_text[16]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv019getData", pageContext));
      out.write(__oracle_jsp_text[17]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv020getData", pageContext));
      out.write(__oracle_jsp_text[18]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv021getData", pageContext));
      out.write(__oracle_jsp_text[19]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv023getData", pageContext));
      out.write(__oracle_jsp_text[20]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv002");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv03");
              __jsp_taghandler_2.setProperty("notFound");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[22]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv03");
              __jsp_taghandler_3.setProperty("firstCheckedCommodity");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_4=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeydown property style");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setMaxlength("17");
              __jsp_taghandler_4.setName("feserv03");
              __jsp_taghandler_4.setOnkeydown("gotoToSearchBookingInquiry(this)");
              __jsp_taghandler_4.setProperty("bookingNo");
              __jsp_taghandler_4.setStyle("width:118px");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[24]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_5=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("feserv03");
              __jsp_taghandler_5.setProperty("quotationNumber");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[25]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_6=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag disabled name property style styleId value");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setDisabled(true);
              __jsp_taghandler_6.setName("feserv03");
              __jsp_taghandler_6.setProperty("representCompChkBox");
              __jsp_taghandler_6.setStyle("border:0px;width:15px;height:15px;");
              __jsp_taghandler_6.setStyleId("representCompChkBox");
              __jsp_taghandler_6.setValue("Y");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_7=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag disabled name property style styleClass");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setDisabled(true);
              __jsp_taghandler_7.setName("feserv03");
              __jsp_taghandler_7.setProperty("representComp");
              __jsp_taghandler_7.setStyle("width:300px;");
              __jsp_taghandler_7.setStyleClass("input-disabled");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[27]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_8=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setName("feserv03");
              __jsp_taghandler_8.setProperty("shipmentTerm");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[28]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_9=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag disabled name property style styleClass");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setDisabled(true);
              __jsp_taghandler_9.setName("feserv03");
              __jsp_taghandler_9.setProperty("socCocUserFlag");
              __jsp_taghandler_9.setStyle("width:200px;");
              __jsp_taghandler_9.setStyleClass("input-disabled");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_10=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("feserv03");
              __jsp_taghandler_10.setProperty("status");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[30]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_11=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setName("feserv03");
              __jsp_taghandler_11.setProperty("customerReference");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[31]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_12=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("feserv03");
              __jsp_taghandler_12.setProperty("email");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[32]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_13=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("feserv03");
              __jsp_taghandler_13.setProperty("telephone");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[33]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_14=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setName("feserv03");
              __jsp_taghandler_14.setProperty("fax");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[34]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setName("feserv03");
              __jsp_taghandler_15.setProperty("contact");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[35]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setName("feserv03");
              __jsp_taghandler_16.setProperty("additionalMailRecipeints");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[36]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_17=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setName("feserv03");
              __jsp_taghandler_17.setProperty("originCountry");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_18=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_18.setParent(__jsp_taghandler_1);
              __jsp_taghandler_18.setName("feserv03");
              __jsp_taghandler_18.setProperty("destinationCountry");
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[38]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_19=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_19.setParent(__jsp_taghandler_1);
              __jsp_taghandler_19.setName("feserv03");
              __jsp_taghandler_19.setProperty("placeOfReceipt");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[39]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_20=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setName("feserv03");
              __jsp_taghandler_20.setProperty("portOfLoading");
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[40]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_21=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setName("feserv03");
              __jsp_taghandler_21.setProperty("portOfDischarge");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[41]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_22=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setName("feserv03");
              __jsp_taghandler_22.setProperty("placeOfDelivery");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[42]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_23=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setName("feserv03");
              __jsp_taghandler_23.setProperty("emptyPickupDepot");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[43]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_24=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setName("feserv03");
              __jsp_taghandler_24.setProperty("emptyPickupDate");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[44]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_25=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setName("feserv03");
              __jsp_taghandler_25.setProperty("shipmentDate");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[45]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_26=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_26.setParent(__jsp_taghandler_1);
              __jsp_taghandler_26.setName("feserv03");
              __jsp_taghandler_26.setProperty("sailingDate");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[46]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_27=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_27.setParent(__jsp_taghandler_1);
              __jsp_taghandler_27.setName("feserv03");
              __jsp_taghandler_27.setProperty("desiredArrivalDate");
              __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
              if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,2);
            }
            out.write(__oracle_jsp_text[47]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_28=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag disabled name property style");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setDisabled(true);
              __jsp_taghandler_28.setName("feserv03");
              __jsp_taghandler_28.setProperty("rclArrangementChkBox");
              __jsp_taghandler_28.setStyle("float:left;border:0px;width:10%");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[48]);
            
                            List rList = (List)request.getAttribute("routingList");
                            if(null!=rList && !rList.isEmpty())
                            {
                                int i = 1;
                        
            out.write(__oracle_jsp_text[49]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_29=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name");
              __jsp_taghandler_29.setParent(__jsp_taghandler_1);
              __jsp_taghandler_29.setId("routing");
              __jsp_taghandler_29.setName("routingList");
              java.lang.Object routing = null;
              __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_29,__jsp_tag_starteval,out);
                do {
                  routing = (java.lang.Object) pageContext.findAttribute("routing");
                  out.write(__oracle_jsp_text[50]);
                  out.print(i);
                  out.write(__oracle_jsp_text[51]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_30=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_30.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_30.setName("routing");
                    __jsp_taghandler_30.setProperty("from");
                    __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                    if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,3);
                  }
                  out.write(__oracle_jsp_text[52]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_31=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_31.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_31.setName("routing");
                    __jsp_taghandler_31.setProperty("to");
                    __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
                    if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,3);
                  }
                  out.write(__oracle_jsp_text[53]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_32=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_32.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_32.setName("routing");
                    __jsp_taghandler_32.setProperty("etd");
                    __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
                    if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,3);
                  }
                  out.write(__oracle_jsp_text[54]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_33=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_33.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_33.setName("routing");
                    __jsp_taghandler_33.setProperty("eta");
                    __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
                    if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,3);
                  }
                  out.write(__oracle_jsp_text[55]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_34=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_34.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_34.setName("routing");
                    __jsp_taghandler_34.setProperty("service");
                    __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
                    if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,3);
                  }
                  out.write(__oracle_jsp_text[56]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_35=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_35.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_35.setName("routing");
                    __jsp_taghandler_35.setProperty("vessel");
                    __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
                    if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,3);
                  }
                  out.write(__oracle_jsp_text[57]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_36=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_36.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_36.setName("routing");
                    __jsp_taghandler_36.setProperty("voyage");
                    __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
                    if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,3);
                  }
                  out.write(__oracle_jsp_text[58]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_37=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_37.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_37.setName("routing");
                    __jsp_taghandler_37.setProperty("transitTime");
                    __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
                    if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,3);
                  }
                  out.write(__oracle_jsp_text[59]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_38=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_38.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_38.setName("routing");
                    __jsp_taghandler_38.setProperty("loadingTerminalName");
                    __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
                    if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,3);
                  }
                  out.write(__oracle_jsp_text[60]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_39=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_39.setParent(__jsp_taghandler_29);
                    __jsp_taghandler_39.setName("routing");
                    __jsp_taghandler_39.setProperty("dischargingTerminalName");
                    __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
                    if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,3);
                  }
                  out.write(__oracle_jsp_text[61]);
                   i++;
                  out.write(__oracle_jsp_text[62]);
                } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,2);
            }
            out.write(__oracle_jsp_text[63]);
            
                            }
                            else
                            {
                        
            out.write(__oracle_jsp_text[64]);
            
                            }
                        
            out.write(__oracle_jsp_text[65]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_40=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name property readonly rows styleClass");
              __jsp_taghandler_40.setParent(__jsp_taghandler_1);
              __jsp_taghandler_40.setCols("50");
              __jsp_taghandler_40.setName("feserv03");
              __jsp_taghandler_40.setProperty("routingPreference");
              __jsp_taghandler_40.setReadonly(true);
              __jsp_taghandler_40.setRows("5");
              __jsp_taghandler_40.setStyleClass("Combo");
              __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
              if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,2);
            }
            out.write(__oracle_jsp_text[66]);
            
                            List eList = (List)request.getAttribute("equipmentList");
                            if(null!=eList && !eList.isEmpty())
                            {
                                int i = 1;
                        
            out.write(__oracle_jsp_text[67]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_41=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name");
              __jsp_taghandler_41.setParent(__jsp_taghandler_1);
              __jsp_taghandler_41.setId("equipment");
              __jsp_taghandler_41.setName("equipmentList");
              java.lang.Object equipment = null;
              __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_41,__jsp_tag_starteval,out);
                do {
                  equipment = (java.lang.Object) pageContext.findAttribute("equipment");
                  out.write(__oracle_jsp_text[68]);
                  out.print(i);
                  out.write(__oracle_jsp_text[69]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_42=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_42.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_42.setName("equipment");
                    __jsp_taghandler_42.setProperty("type");
                    __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
                    if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,3);
                  }
                  out.write(__oracle_jsp_text[70]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_43=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_43.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_43.setName("equipment");
                    __jsp_taghandler_43.setProperty("size");
                    __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
                    if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,3);
                  }
                  out.write(__oracle_jsp_text[71]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_44=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_44.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_44.setName("equipment");
                    __jsp_taghandler_44.setProperty("cargoType");
                    __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
                    if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,3);
                  }
                  out.write(__oracle_jsp_text[72]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_45=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_45.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_45.setName("equipment");
                    __jsp_taghandler_45.setProperty("laden");
                    __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
                    if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,3);
                  }
                  out.write(__oracle_jsp_text[73]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_46=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_46.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_46.setName("equipment");
                    __jsp_taghandler_46.setProperty("mt");
                    __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
                    if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,3);
                  }
                  out.write(__oracle_jsp_text[74]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_47=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_47.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_47.setName("equipment");
                    __jsp_taghandler_47.setProperty("grossContainerWeight");
                    __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
                    if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,3);
                  }
                  out.write(__oracle_jsp_text[75]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_48=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_48.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_48.setName("equipment");
                    __jsp_taghandler_48.setProperty("polStatus");
                    __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
                    if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,3);
                  }
                  out.write(__oracle_jsp_text[76]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_49=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_49.setParent(__jsp_taghandler_41);
                    __jsp_taghandler_49.setName("equipment");
                    __jsp_taghandler_49.setProperty("podStatus");
                    __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
                    if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,3);
                  }
                  out.write(__oracle_jsp_text[77]);
                  i++;
                  out.write(__oracle_jsp_text[78]);
                } while (__jsp_taghandler_41.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,2);
            }
            out.write(__oracle_jsp_text[79]);
            
                            }
                            else
                            {
                        
            out.write(__oracle_jsp_text[80]);
            
                            }
                        
            out.write(__oracle_jsp_text[81]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_50=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name property readonly rows styleClass");
              __jsp_taghandler_50.setParent(__jsp_taghandler_1);
              __jsp_taghandler_50.setCols("50");
              __jsp_taghandler_50.setName("feserv03");
              __jsp_taghandler_50.setProperty("cargoDescription");
              __jsp_taghandler_50.setReadonly(true);
              __jsp_taghandler_50.setRows("5");
              __jsp_taghandler_50.setStyleClass("Combo");
              __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
              if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,2);
            }
            out.write(__oracle_jsp_text[82]);
            
                            List cList = (List)request.getAttribute("commodityList");
                            if(null!=cList && !cList.isEmpty())
                            {
                                int i = 1;
                        
            out.write(__oracle_jsp_text[83]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_51=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
              __jsp_taghandler_51.setParent(__jsp_taghandler_1);
              __jsp_taghandler_51.setId("commodity");
              __jsp_taghandler_51.setName("commodityList");
              __jsp_taghandler_51.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod");
              com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod commodity = null;
              __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_51,__jsp_tag_starteval,out);
                do {
                  commodity = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod) pageContext.findAttribute("commodity");
                  out.write(__oracle_jsp_text[84]);
                  {
                    org.apache.struts.taglib.html.RadioTag __jsp_taghandler_52=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property style value");
                    __jsp_taghandler_52.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_52.setName("commodity");
                    __jsp_taghandler_52.setOnclick("showSpecialInstruction(this.value)");
                    __jsp_taghandler_52.setProperty("radCommodity");
                    __jsp_taghandler_52.setStyle("border:0px;width:50%");
                    __jsp_taghandler_52.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${commodity.seqNo}",java.lang.String.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
                    if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,3);
                  }
                  out.write(__oracle_jsp_text[85]);
                  out.print(i);
                  out.write(__oracle_jsp_text[86]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_53=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_53.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_53.setName("commodity");
                    __jsp_taghandler_53.setProperty("group");
                    __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
                    if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,3);
                  }
                  out.write(__oracle_jsp_text[87]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_54=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_54.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_54.setName("commodity");
                    __jsp_taghandler_54.setProperty("description");
                    __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
                    if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,3);
                  }
                  out.write(__oracle_jsp_text[88]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_55=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_55.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_55.setName("commodity");
                    __jsp_taghandler_55.setProperty("grossWeight");
                    __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
                    if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,3);
                  }
                  out.write(__oracle_jsp_text[89]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_56=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_56.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_56.setName("commodity");
                    __jsp_taghandler_56.setProperty("specialCargo");
                    __jsp_tag_starteval=__jsp_taghandler_56.doStartTag();
                    if (__jsp_taghandler_56.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_56,3);
                  }
                  out.write(__oracle_jsp_text[90]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_57=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_57.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_57.setName("commodity");
                    __jsp_taghandler_57.setProperty("rateTypeDesc");
                    __jsp_tag_starteval=__jsp_taghandler_57.doStartTag();
                    if (__jsp_taghandler_57.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_57,3);
                  }
                  out.write(__oracle_jsp_text[91]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_58=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_58.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_58.setName("commodity");
                    __jsp_taghandler_58.setProperty("seqNo");
                    __jsp_tag_starteval=__jsp_taghandler_58.doStartTag();
                    if (__jsp_taghandler_58.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_58,3);
                  }
                  out.write(__oracle_jsp_text[92]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_59=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_59.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_59.setName("commodity");
                    __jsp_taghandler_59.setProperty("rateType");
                    __jsp_tag_starteval=__jsp_taghandler_59.doStartTag();
                    if (__jsp_taghandler_59.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_59,3);
                  }
                  out.write(__oracle_jsp_text[93]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_60=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_60.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_60.setName("commodity");
                    __jsp_taghandler_60.setProperty("rateTypeFlag");
                    __jsp_tag_starteval=__jsp_taghandler_60.doStartTag();
                    if (__jsp_taghandler_60.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_60,3);
                  }
                  out.write(__oracle_jsp_text[94]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_61=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_61.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_61.setName("commodity");
                    __jsp_taghandler_61.setProperty("rateTypeDisabled");
                    __jsp_taghandler_61.setValue("false");
                    __jsp_tag_starteval=__jsp_taghandler_61.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[95]);
                        out.print(commodity.getRateTypeClassName());
                        out.write(__oracle_jsp_text[96]);
                      } while (__jsp_taghandler_61.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_61.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_61,3);
                  }
                  out.write(__oracle_jsp_text[97]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_62=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_62.setParent(__jsp_taghandler_51);
                    __jsp_taghandler_62.setName("commodity");
                    __jsp_taghandler_62.setProperty("rateTypeDisabled");
                    __jsp_taghandler_62.setValue("true");
                    __jsp_tag_starteval=__jsp_taghandler_62.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[98]);
                        out.print(commodity.getRateTypeClassName());
                        out.write(__oracle_jsp_text[99]);
                      } while (__jsp_taghandler_62.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_62.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_62,3);
                  }
                  out.write(__oracle_jsp_text[100]);
                  i++;
                  out.write(__oracle_jsp_text[101]);
                } while (__jsp_taghandler_51.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,2);
            }
            out.write(__oracle_jsp_text[102]);
            
                            }
                            else
                            {
                        
            out.write(__oracle_jsp_text[103]);
            
                            }
                        
            out.write(__oracle_jsp_text[104]);
            
                            if(null!=cList)
                            {
                        
            out.write(__oracle_jsp_text[105]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_63=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name");
              __jsp_taghandler_63.setParent(__jsp_taghandler_1);
              __jsp_taghandler_63.setId("commodity");
              __jsp_taghandler_63.setName("commodityList");
              java.lang.Object commodity = null;
              __jsp_tag_starteval=__jsp_taghandler_63.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_63,__jsp_tag_starteval,out);
                do {
                  commodity = (java.lang.Object) pageContext.findAttribute("commodity");
                  out.write(__oracle_jsp_text[106]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${commodity.seqNo}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[107]);
                  {
                    org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_64=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name property readonly rows styleClass");
                    __jsp_taghandler_64.setParent(__jsp_taghandler_63);
                    __jsp_taghandler_64.setCols("50");
                    __jsp_taghandler_64.setName("commodity");
                    __jsp_taghandler_64.setProperty("specialInstruction");
                    __jsp_taghandler_64.setReadonly(true);
                    __jsp_taghandler_64.setRows("5");
                    __jsp_taghandler_64.setStyleClass("Combo");
                    __jsp_tag_starteval=__jsp_taghandler_64.doStartTag();
                    if (__jsp_taghandler_64.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_64,3);
                  }
                  out.write(__oracle_jsp_text[108]);
                } while (__jsp_taghandler_63.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_63.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_63,2);
            }
            out.write(__oracle_jsp_text[109]);
            
                            }
                        
            out.write(__oracle_jsp_text[110]);
             
                            Boolean isDisabled = (Boolean)request.getAttribute("disabledEdit");
                        
            out.write(__oracle_jsp_text[111]);
            out.print((null!=isDisabled && !isDisabled)?"m-btn sm green rnd":"m-btn sm rnd disabled");
            out.write(__oracle_jsp_text[112]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[113]);

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
  private static final char __oracle_jsp_text[][]=new char[114][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n\r\n<head>\r\n    <!-- add screen specific JavaScript file -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/js/common/Constants.js\" ></script>\r\n\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/js/RutHelp.js\" ></script>\r\n    \r\n    <!-- add javascript file for this screen -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/js/screen/EserviceInquiryWebBooking.js\" ></script>\r\n    \r\n    <script language=\"JavaScript\">\r\n        var BROWSE_BOOKING_NUMBER                   = '".toCharArray();
    __oracle_jsp_text[14] = 
    "';\r\n        var GET_BOOKING_NUMBER_TO_WEBBOOKING_PAGE   = '".toCharArray();
    __oracle_jsp_text[15] = 
    "';\r\n        var NEW_WEBBOOKING_PAGE                     = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\r\n        \r\n        /*Begin @01*/\r\n        var REFER_COMMODITY_GET_DATA                = '".toCharArray();
    __oracle_jsp_text[17] = 
    "';\r\n        var DG_COMMODITY_GET_DATA                   = '".toCharArray();
    __oracle_jsp_text[18] = 
    "';\r\n        var OOG_COMMODITY_GET_DATA                  = '".toCharArray();
    __oracle_jsp_text[19] = 
    "';\r\n        var GET_UPLOAD_ATTACHMENT                   = '".toCharArray();
    __oracle_jsp_text[20] = 
    "';\r\n        /*End @01*/\r\n        \r\n    </script>\r\n    \r\n    <script language=\"JavaScript\">\r\n      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\r\n      ga('create', 'UA-39255240-1', 'rclgroup.com');\r\n      ga('send', 'pageview');\r\n    </script>\r\n</head>\r\n\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Booking Details </h2>\r\n        </div>\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <colgroup>\r\n                <col width=\"12%\">\r\n                <col width=\"16%\">\r\n                <col width=\"14%\">\r\n                <col width=\"14%\">\r\n                <col width=\"10%\">\r\n                <col width=\"12%\">\r\n                <col width=\"8%\">\r\n                <col width=\"14%\">\r\n            </colgroup>\r\n            <tr>\r\n                <td class=\"lableBackground\">\r\n                    Booking Number\r\n                </td>\r\n                <td class=\"whitebg\" style=\"padding-left:4px;padding-top:1px;\">\r\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                    <a id=\"btnBrowseBookingNo\" name=\"btnBrowseBookingNo\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"#\"\r\n                        onclick='openBookingNumber()'>\r\n                        <i class=\"icon-search icon-white\"></i>\r\n                    </a>\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Quotation Number\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                    </font>\r\n                </td>\r\n                <!--Begin @02 -->\r\n                <td colspan=\"4\" class=\"whitebg\">\r\n                    ".toCharArray();
    __oracle_jsp_text[26] = 
    "&nbsp;\r\n                    Represented Company\r\n                    ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                </td>\r\n                <!--End @02 -->\r\n            </tr>\r\n            <tr>\r\n                <td class=\"lableBackground\">\r\n                    Shipment Term\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                    </font>\r\n                </td>\r\n                <!--Begin @03 -->\r\n                <td class=\"lableBackground\">\r\n                    COC/SOC\r\n                </td>\r\n                <td class=\"whitebg\" colspan=\"2\">\r\n                    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n                </td>\r\n                <!--End @03 -->\r\n                <td class=\"lableBackground\">\r\n                    Status\r\n                </td>\r\n                <td class=\"whitebg\" colspan=\"2\" >\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                    </font>    \r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"lableBackground\" height=\"18px\">\r\n                    Customer Reference\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Email\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Telephone\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Fax\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                    </font>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"lableBackground\">\r\n                    Contact\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"lableBackground\">\r\n                    Additional Mail Recipients\r\n                </td>\r\n                <td colspan=\"5\" >\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n                    </font>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Routing Details</h2>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"14%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Original Country\r\n                    </span>\r\n                </td>\r\n                <td width=\"14%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Destination Country\r\n                    </span>\r\n                </td>\r\n                <td width=\"28%\" class=\"tableHeadingBlue\" colspan=\"2\">\r\n                    <span class=\"m0l0iout\">\r\n                        Place of Receipt\r\n                    </span>\r\n                </td>\r\n                <td width=\"13%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Port of Loading POL\r\n                    </span>\r\n                </td>\r\n                <td width=\"13%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Port of Discharge POD\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Place of Delivery\r\n                    </span>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Empty Pickup Depot\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Empty Pickup Date\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Cargo Availability Date\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Expected Sailing Date\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\" colspan=\"3\">\r\n                    <span class=\"m0l0iout\">\r\n                        Desired Arriaval Date\r\n                    </span>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n         \r\n         <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n           \r\n<DIV CLASS=\"search_result\" STYLE=\"HEIGHT:38px\">\r\n    <TABLE CLASS=\"table_results\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n        <TBODY>   \r\n            <tr height=\"12px\">\r\n                <td width=\"13%\" class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td width=\"13%\" class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td width=\"13%\" class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td width=\"13%\">&nbsp;</td>\r\n                <td width=\"12%\" class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td width=\"12%\" class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td width=\"16%\" class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                    </font>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n                    </font>    \r\n                </td>\r\n                <td class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"tableColumnData\">\r\n                    <font class=\"displayText\">\r\n                        ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td>&nbsp;</td>\r\n                <td class=\"tableColumnData\">\r\n                    ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n                    (as per RCL arrangement)\r\n                </td>\r\n            </tr>\r\n        </TBODY>\r\n    </TABLE>\r\n</DIV>\r\n         <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"3%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Leg\r\n                    </span>\r\n                </td>\r\n                <td width=\"24%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        From\r\n                    </span>\r\n                </td>\r\n                <td width=\"25%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        To\r\n                    </span>\r\n                </td>\r\n                <td width=\"6%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        ETD\r\n                    </span>\r\n                </td>\r\n                <td width=\"6%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        ETA\r\n                    </span>\r\n                </td>\r\n                <td width=\"6%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Service\r\n                    </span>\r\n                </td>\r\n                <td width=\"10%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Vessel\r\n                    </span>\r\n                </td>\r\n                <td width=\"10%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Voyage\r\n                    </span>\r\n                </td>\r\n                <td width=\"10%\" class=\"tableHeadingBlue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Transit Time\r\n                    </span>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        #\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\">\r\n                    <span class=\"m0l0iout\">\r\n                        Loading Terminal Name\r\n                    </span>\r\n                </td>\r\n                <td class=\"tableHeadingSecondRow2Blue\" colspan=\"7\">\r\n                    <span class=\"m0l0iout\">\r\n                        Discharging Terminal Name\r\n                    </span>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <DIV ID=\"comm_search_result\" CLASS=\"search_result\" STYLE=\"HEIGHT:76px\">\r\n            <TABLE CLASS=\"table_results\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n                <TBODY>\r\n            ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n\r\n                        ".toCharArray();
    __oracle_jsp_text[50] = 
    "                \r\n                            <tr>\r\n                                <td class=\"tableColumnData\" width=\"3%\" rowspan=\"2\" align=\"center\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[51] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"24%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"25%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[53] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"6%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[54] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"6%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[55] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"6%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[56] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"10%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[57] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"10%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[58] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" width=\"10%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[59] = 
    "</font></td>\r\n                            </tr>\r\n                            <tr>\r\n                                <td class=\"tableColumnData\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[60] = 
    "</font></td>\r\n                                <td class=\"tableColumnData\" colspan=\"7\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[61] = 
    "</font></td>\r\n                            </tr>\r\n                            ".toCharArray();
    __oracle_jsp_text[62] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n                    <tr>\r\n                        <td class=\"tableColumnData\" width=\"3%\" rowspan=\"2\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"24%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"25%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"6%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"6%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"6%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"10%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"10%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"10%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"tableColumnData\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" colspan=\"7\">&nbsp;</td>\r\n                    </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n                </TBODY>\r\n            </TABLE>\r\n        </DIV>            \r\n            <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"99%\" class=\"tableHeadingSecondRow2Blue\"><span class=\"tableHeaderLeftAlign\">Routing Preference (5 Lines Maximum) </span></td>\r\n            </tr>\r\n        </table>\r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        \r\n        <TABLE ID=\"comm_result_dtl\" BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n            <TBODY>\r\n                <tr height=\"12px\">\r\n                    <td>\r\n                        ".toCharArray();
    __oracle_jsp_text[66] = 
    "\r\n                    </td>\r\n                </tr>\r\n            </TBODY>\r\n         </table>\r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        \r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Equipment Details</h2>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"4%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">#</span></td>\r\n                <td width=\"6%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Type</span></td>\r\n                <td width=\"6%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Size</span></td>\r\n                <td width=\"8%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Cargo Type </span></td>\r\n                <td width=\"9%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Laden</span></td>\r\n                <td width=\"11%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Empty</span></td>\r\n                <td width=\"18%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Gross Container Weight (KG)</span></td>\r\n                <td width=\"19%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">POL Status </span></td>\r\n                <td width=\"19%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">POD Status </span></td>\r\n            </tr>\r\n        </table>\r\n        \r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>            \r\n        <DIV ID=\"comm_search_result\" CLASS=\"search_result\" STYLE=\"HEIGHT:76px\">\r\n            <TABLE ID=\"comm_result_dtl\" CLASS=\"table_results\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n                <TBODY>\r\n            ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n                <tr>\r\n                    <td class=\"tableColumnData\" width=\"4%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[69] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"6%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[70] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"6%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[71] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"8%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[72] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"9%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[73] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"11%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[74] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"18%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[75] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"19%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[76] = 
    "</font></td>\r\n                    <td class=\"tableColumnData\" width=\"19%\"><font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[77] = 
    "</font></td>\r\n                </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[80] = 
    "\r\n                    <tr>\r\n                        <td class=\"tableColumnData\" width=\"4%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"6%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"6%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"8%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"9%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"11%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"18%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"19%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"19%\">&nbsp;</td>\r\n                    </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n                </TBODY>\r\n            </TABLE>\r\n        </DIV>            \r\n            <!-- for line spacing -->\r\n            <table style=\"margin:0; padding:0;\" border=\"0\">\r\n                <tr><td></td></tr>\r\n            </table>\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Cargo Description</h2>\r\n        </div>\r\n        \r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <TABLE ID=\"comm_result_dtl\" BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n            <TBODY>\r\n                <tr>\r\n                    <td height=\"12px\">\r\n                        ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n                    </td>\r\n                </tr>\r\n            </TBODY>\r\n        </table>\r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        \r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Commodity Details</h2>\r\n        </div>\r\n        <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n            <tr>\r\n                <td width=\"4%\"  class=\"tableHeadingBlue\">&nbsp;</td>\r\n                <td width=\"4%\"  class=\"tableHeadingBlue\"><span class=\"m0l0iout\">#</span></td>\r\n                <td width=\"20%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Commodity Group</span></td>\r\n                <td width=\"18%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Gross Weight(KGS) </span></td>\r\n                <td width=\"10%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Special Cargo </span></td>\r\n                <td width=\"8%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Rate Type </span></td>\r\n                <td width=\"10%\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">&nbsp;</span></td>\r\n            </tr>\r\n        </table>\r\n        <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <DIV ID=\"comm_search_result\" CLASS=\"search_result\" STYLE=\"HEIGHT:76px\">\r\n            <TABLE ID=\"comm_result_dtl\" CLASS=\"table_results\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n                <TBODY>\r\n            ".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n                <tr>                    \r\n                    <td class=\"tableColumnData\" width=\"4%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n                    </td>\r\n                    <td class=\"tableColumnData\" width=\"4%\">\r\n                        <font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[86] = 
    "</font>\r\n                    </td>\r\n                    <td class=\"tableColumnData\" width=\"20%\">\r\n                        <font class=\"displayText\">\r\n                            ".toCharArray();
    __oracle_jsp_text[87] = 
    "&nbsp;-&nbsp;".toCharArray();
    __oracle_jsp_text[88] = 
    "\r\n                        </font>\r\n                    </td>\r\n                    <td class=\"tableColumnData\" width=\"18%\">\r\n                        <font class=\"displayText\">\r\n                            ".toCharArray();
    __oracle_jsp_text[89] = 
    "\r\n                        </font>\r\n                    </td>\r\n                    <td class=\"tableColumnData\" width=\"10%\">\r\n                        <font class=\"displayText\">\r\n                            ".toCharArray();
    __oracle_jsp_text[90] = 
    "\r\n                        </font>\r\n                    </td>\r\n                    <td class=\"tableColumnData\" width=\"8%\">\r\n                        <font class=\"displayText\">\r\n                            ".toCharArray();
    __oracle_jsp_text[91] = 
    "\r\n                        </font>\r\n                    </td>\r\n                    <td class=\"tableColumnData\" width=\"10%\">\r\n                        ".toCharArray();
    __oracle_jsp_text[92] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[93] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[94] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[95] = 
    "\r\n                            <a class=\"".toCharArray();
    __oracle_jsp_text[96] = 
    "\" href=\"javascript:void(0)\" name=\"btnRateTypeDetails\"  onClick=\"openRateTypeLookUpForInquiry();\">\r\n                                <i class=\"icon-plus icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[97] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[98] = 
    "\r\n                            <a class=\"".toCharArray();
    __oracle_jsp_text[99] = 
    "\" disabled href=\"javascript:void(0)\" name=\"btnRateTypeDetails\"  onClick=\"openRateTypeLookUpForInquiry();\">\r\n                                <i class=\"icon-plus icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[100] = 
    "\r\n                    </td>\r\n                </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[101] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[102] = 
    "                    \r\n            ".toCharArray();
    __oracle_jsp_text[103] = 
    "\r\n                    <tr>                    \r\n                        <td class=\"tableColumnData\" colspan=\"2\" width=\"8%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"20%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\" width=\"18%\">&nbsp;</td>\r\n                        <td class=\"tableColumnData\">&nbsp;</td>\r\n                    </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[104] = 
    "\r\n                </TBODY>\r\n            </TABLE>\r\n        </DIV>\r\n        \r\n         <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Special Instruction (5 Lines Maximum)</h2>\r\n        </div>\r\n          <!-- for line spacing -->\r\n        <table style=\"margin:0; padding:0;\" border=\"0\">\r\n            <tr><td></td></tr>\r\n        </table>\r\n        <TABLE ID=\"tableSI\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\">\r\n            <TBODY>\r\n            ".toCharArray();
    __oracle_jsp_text[105] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[106] = 
    "     \r\n                <tr id=\"row_".toCharArray();
    __oracle_jsp_text[107] = 
    "\" style=\"display: none;\">\r\n                    <td class=\"tableColumnData\">\r\n                        ".toCharArray();
    __oracle_jsp_text[108] = 
    "\r\n                    </td>\r\n                </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[109] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[110] = 
    "\r\n                </TBODY>\r\n            </TABLE>\r\n        <br>\r\n        <div align=\"right\">\r\n            ".toCharArray();
    __oracle_jsp_text[111] = 
    "\r\n            <a class=\"m-btn sm blue rnd\"\r\n                href=\"javascript:void(0)\" onClick=\"return uploadAttachmentForInquiry();\">\r\n                    View Upload Document\r\n                <i class=\"m-icon-swapup m-icon-white\"></i>\r\n            </a>\r\n            <a class=\"m-btn sm green rnd\" \r\n                href=\"javascript:void(0)\" onclick=\"gotoNewBooking()\">New Web Booking&nbsp;<i class=\"m-icon-swapleft m-icon-white\"></i>\r\n            </a> \r\n            <!--a class=\"".toCharArray();
    __oracle_jsp_text[112] = 
    "\" \r\n                href=\"#\" onclick=\"editBooking()\">Edit Booking <i class=\"m-icon-swapright m-icon-white\"></i>\r\n            </a--> \r\n        </div>\r\n    ".toCharArray();
    __oracle_jsp_text[113] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

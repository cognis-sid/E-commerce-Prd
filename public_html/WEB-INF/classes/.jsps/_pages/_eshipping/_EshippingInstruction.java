package _pages._eshipping;

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
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;
import com.niit.control.common.ComboVO;


public class _EshippingInstruction extends com.orionserver.http.OrionHttpJspPage {


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
    _EshippingInstruction page = this;
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
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);
      
       String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[13]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[14]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006InputCargoDescription", pageContext));
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006GetData", pageContext));
      out.write(__oracle_jsp_text[16]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseCustomerData", pageContext));
      out.write(__oracle_jsp_text[17]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv010", pageContext));
      out.write(__oracle_jsp_text[18]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseBookingNumber", pageContext));
      out.write(__oracle_jsp_text[19]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv012", pageContext));
      out.write(__oracle_jsp_text[20]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowsePackageKindData", pageContext));
      out.write(__oracle_jsp_text[21]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv011", pageContext));
      out.write(__oracle_jsp_text[22]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006PreviewPDFReport", pageContext));
      out.write(__oracle_jsp_text[23]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SaveAsDraft", pageContext));
      out.write(__oracle_jsp_text[24]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SubmitEsi", pageContext));
      out.write(__oracle_jsp_text[25]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006Acknowledgement", pageContext));
      out.write(__oracle_jsp_text[26]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv013", pageContext));
      out.write(__oracle_jsp_text[27]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseCommodity", pageContext));
      out.write(__oracle_jsp_text[28]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SetCommodityData", pageContext));
      out.write(__oracle_jsp_text[29]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006delCommodity", pageContext));
      out.write(__oracle_jsp_text[30]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006addCommodity", pageContext));
      out.write(__oracle_jsp_text[31]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006checkDuplicateContainerNo", pageContext));
      out.write(__oracle_jsp_text[32]);
      out.print(EshippingInstructionDao.ESI_STATUS.NEW);
      out.write(__oracle_jsp_text[33]);
      out.print(EshippingInstructionDao.ESI_STATUS.IN_PROGRESS);
      out.write(__oracle_jsp_text[34]);
      out.print(EshippingInstructionDao.ESI_STATUS.SUBMITTED);
      out.write(__oracle_jsp_text[35]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[36]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv006");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv06");
              __jsp_taghandler_2.setProperty("notFound");
              __jsp_taghandler_2.setStyleId("notFound");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[38]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv06");
              __jsp_taghandler_3.setProperty("saveDraftIsSuccess");
              __jsp_taghandler_3.setStyleId("saveDraftIsSuccess");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[39]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("feserv06");
              __jsp_taghandler_4.setProperty("submitIsSuccess");
              __jsp_taghandler_4.setStyleId("submitIsSuccess");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[40]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag property styleId");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setProperty("textSeparate");
              __jsp_taghandler_5.setStyleId("textSeparate");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[41]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag property styleId");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setProperty("flag");
              __jsp_taghandler_6.setStyleId("flag");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[42]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag property styleId");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setProperty("itemsDelete");
              __jsp_taghandler_7.setStyleId("itemsDelete");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[43]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_8=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag property styleId");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setProperty("flagItemsDelete");
              __jsp_taghandler_8.setStyleId("flagItemsDelete");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[44]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setName("feserv06");
              __jsp_taghandler_9.setProperty("blNo");
              __jsp_taghandler_9.setStyleId("blNo");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[45]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("feserv06");
              __jsp_taghandler_10.setProperty("cocSoc");
              __jsp_taghandler_10.setStyleId("cocSoc");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[46]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setName("feserv06");
              __jsp_taghandler_11.setProperty("shipperCode");
              __jsp_taghandler_11.setStyleId("shipperCode");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[47]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_12=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("feserv06");
              __jsp_taghandler_12.setProperty("consigneeCode");
              __jsp_taghandler_12.setStyleId("consigneeCode");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[48]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_13=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("feserv06");
              __jsp_taghandler_13.setProperty("notifyPartyCode");
              __jsp_taghandler_13.setStyleId("notifyPartyCode");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[49]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_14=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setName("feserv06");
              __jsp_taghandler_14.setProperty("fsc");
              __jsp_taghandler_14.setStyleId("fsc");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[50]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_15=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setName("feserv06");
              __jsp_taghandler_15.setProperty("openAcknowledgement");
              __jsp_taghandler_15.setStyleId("openAcknowledgement");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[51]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_16=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setName("feserv06");
              __jsp_taghandler_16.setProperty("emailAcknowledgment");
              __jsp_taghandler_16.setStyleId("emailAcknowledgment");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[52]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_17=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setName("feserv06");
              __jsp_taghandler_17.setProperty("vendorTelephone");
              __jsp_taghandler_17.setStyleId("vendorTelephone");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[53]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_18=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_18.setParent(__jsp_taghandler_1);
              __jsp_taghandler_18.setName("feserv06");
              __jsp_taghandler_18.setProperty("vendorFax");
              __jsp_taghandler_18.setStyleId("vendorFax");
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[54]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_19=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_19.setParent(__jsp_taghandler_1);
              __jsp_taghandler_19.setName("feserv06");
              __jsp_taghandler_19.setProperty("vendorEmail");
              __jsp_taghandler_19.setStyleId("vendorEmail");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[55]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_20=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setName("feserv06");
              __jsp_taghandler_20.setProperty("podCountry");
              __jsp_taghandler_20.setStyleId("podCountry");
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[56]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_21=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setName("feserv06");
              __jsp_taghandler_21.setProperty("isDisabledSubmit");
              __jsp_taghandler_21.setStyleId("isDisabledSubmit");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[57]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_22=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setName("feserv06");
              __jsp_taghandler_22.setProperty("esiErrMsg");
              __jsp_taghandler_22.setStyleId("esiErrMsg");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[58]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_23=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setName("feserv06");
              __jsp_taghandler_23.setProperty("prevBookingNo");
              __jsp_taghandler_23.setStyleId("prevBookingNo");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[59]);
            out.write(__oracle_jsp_text[60]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_24=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setName("feserv06");
              __jsp_taghandler_24.setProperty("esiStatusCode");
              __jsp_taghandler_24.setStyleId("esiStatusCode");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[61]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_25=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setName("feserv06");
              __jsp_taghandler_25.setProperty("esiStatusDesc");
              __jsp_taghandler_25.setStyleId("esiStatusDesc");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[62]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_26=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_26.setParent(__jsp_taghandler_1);
              __jsp_taghandler_26.setName("feserv06");
              __jsp_taghandler_26.setProperty("prevEsiStatusCode");
              __jsp_taghandler_26.setStyleId("prevEsiStatusCode");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[63]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_27=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_27.setParent(__jsp_taghandler_1);
              __jsp_taghandler_27.setName("feserv06");
              __jsp_taghandler_27.setProperty("prevEsiStatusDesc");
              __jsp_taghandler_27.setStyleId("prevEsiStatusDesc");
              __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
              if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,2);
            }
            out.write(__oracle_jsp_text[64]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_28=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setName("feserv06");
              __jsp_taghandler_28.setProperty("comSeqNoTemp");
              __jsp_taghandler_28.setStyleId("comSeqNoTemp");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[65]);
            out.write(__oracle_jsp_text[66]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_29=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_29.setParent(__jsp_taghandler_1);
              __jsp_taghandler_29.setName("feserv06");
              __jsp_taghandler_29.setProperty("msgFieldChanged");
              __jsp_taghandler_29.setStyleId("msgFieldChanged");
              __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
              if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,2);
            }
            out.write(__oracle_jsp_text[67]);
            out.write(__oracle_jsp_text[68]);
            
                    EshippingInstructionUim obj = (EshippingInstructionUim) request.getSession().getAttribute(EshippingInstructionUim.FORM_BUFF_ESHHIPING_INSTRUCTION);
                    String isReadonly = "false";
                    String esiStatusCode = null;
                    if(null!=obj)
                    {
                        esiStatusCode = obj.getEsiStatusCode();
                        isReadonly = (EshippingInstructionDao.ESI_STATUS.SUBMITTED.equals(esiStatusCode)? "true":"false");
                    }
                
            out.write(__oracle_jsp_text[69]);
            {
              org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_30=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id value");
              __jsp_taghandler_30.setParent(__jsp_taghandler_1);
              __jsp_taghandler_30.setId("isReadOnly");
              __jsp_taghandler_30.setValue(OracleJspRuntime.toStr( isReadonly));
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
            }
            java.lang.String isReadOnly = null;
            isReadOnly = (java.lang.String) pageContext.findAttribute("isReadOnly");
            out.write(__oracle_jsp_text[70]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_31=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property style styleId value");
              __jsp_taghandler_31.setParent(__jsp_taghandler_1);
              __jsp_taghandler_31.setName("feserv06");
              __jsp_taghandler_31.setProperty("choiceRad");
              __jsp_taghandler_31.setStyle("float:left;border:0px;width:8%");
              __jsp_taghandler_31.setStyleId("choiceRad");
              __jsp_taghandler_31.setValue("1");
              __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
              if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,2);
            }
            out.write(__oracle_jsp_text[71]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_32=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag disabled name property style styleId value");
              __jsp_taghandler_32.setParent(__jsp_taghandler_1);
              __jsp_taghandler_32.setDisabled(true);
              __jsp_taghandler_32.setName("feserv06");
              __jsp_taghandler_32.setProperty("choiceRad");
              __jsp_taghandler_32.setStyle("float:left;border:0px;width:8%");
              __jsp_taghandler_32.setStyleId("choiceRad");
              __jsp_taghandler_32.setValue("2");
              __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
              if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,2);
            }
            out.write(__oracle_jsp_text[72]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_33=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag disabled name property style styleId value");
              __jsp_taghandler_33.setParent(__jsp_taghandler_1);
              __jsp_taghandler_33.setDisabled(true);
              __jsp_taghandler_33.setName("feserv06");
              __jsp_taghandler_33.setProperty("choiceRad");
              __jsp_taghandler_33.setStyle("float:left;border:0px;width:8%");
              __jsp_taghandler_33.setStyleId("choiceRad");
              __jsp_taghandler_33.setValue("3");
              __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
              if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,2);
            }
            out.write(__oracle_jsp_text[73]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_34=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property styleId size");
              __jsp_taghandler_34.setParent(__jsp_taghandler_1);
              __jsp_taghandler_34.setName("feserv06");
              __jsp_taghandler_34.setProperty("blType");
              __jsp_taghandler_34.setStyleId("blType");
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
                    __jsp_taghandler_35.setName("feserv06");
                    __jsp_taghandler_35.setProperty("blTypeValues");
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
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_36=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeydown property style styleClass styleId");
              __jsp_taghandler_36.setParent(__jsp_taghandler_1);
              __jsp_taghandler_36.setMaxlength("17");
              __jsp_taghandler_36.setName("feserv06");
              __jsp_taghandler_36.setOnkeydown("gotoToSearchBookingEsi(this)");
              __jsp_taghandler_36.setProperty("bookingNo");
              __jsp_taghandler_36.setStyle("width:66%");
              __jsp_taghandler_36.setStyleClass("must");
              __jsp_taghandler_36.setStyleId("bookingNo");
              __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
              if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,2);
            }
            out.write(__oracle_jsp_text[77]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_37=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_37.setParent(__jsp_taghandler_1);
              __jsp_taghandler_37.setName("feserv06");
              __jsp_taghandler_37.setProperty("blNumber");
              __jsp_taghandler_37.setStyleId("blNumber");
              __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
              if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,2);
            }
            out.write(__oracle_jsp_text[78]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_38=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_38.setParent(__jsp_taghandler_1);
              __jsp_taghandler_38.setName("feserv06");
              __jsp_taghandler_38.setProperty("blNumber");
              __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
              if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,2);
            }
            out.write(__oracle_jsp_text[79]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_39=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_39.setParent(__jsp_taghandler_1);
              __jsp_taghandler_39.setName("feserv06");
              __jsp_taghandler_39.setProperty("esiStatusDesc");
              __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
              if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,2);
            }
            out.write(__oracle_jsp_text[80]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_40=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_40.setParent(__jsp_taghandler_1);
              __jsp_taghandler_40.setName("feserv06");
              __jsp_taghandler_40.setProperty("siSubmittedBy");
              __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
              if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,2);
            }
            out.write(__oracle_jsp_text[81]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_41=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_41.setParent(__jsp_taghandler_1);
              __jsp_taghandler_41.setName("feserv06");
              __jsp_taghandler_41.setProperty("siSubmittedBy");
              __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
              if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,2);
            }
            out.write(__oracle_jsp_text[82]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_42=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
              __jsp_taghandler_42.setParent(__jsp_taghandler_1);
              __jsp_taghandler_42.setMaxlength("25");
              __jsp_taghandler_42.setName("feserv06");
              __jsp_taghandler_42.setOnblur("changeUpper(this)");
              __jsp_taghandler_42.setProperty("contact");
              __jsp_taghandler_42.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_42.setStyle("width: 95%");
              __jsp_taghandler_42.setStyleClass("must");
              __jsp_taghandler_42.setStyleId("contact");
              __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
              if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,2);
            }
            out.write(__oracle_jsp_text[83]);
            out.write(__oracle_jsp_text[84]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_43=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property style styleId");
              __jsp_taghandler_43.setParent(__jsp_taghandler_1);
              __jsp_taghandler_43.setName("feserv06");
              __jsp_taghandler_43.setProperty("email");
              __jsp_taghandler_43.setStyle("width: 95%");
              __jsp_taghandler_43.setStyleId("email");
              __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
              if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,2);
            }
            out.write(__oracle_jsp_text[85]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_44=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
              __jsp_taghandler_44.setParent(__jsp_taghandler_1);
              __jsp_taghandler_44.setMaxlength("17");
              __jsp_taghandler_44.setName("feserv06");
              __jsp_taghandler_44.setOnblur("changeUpper(this)");
              __jsp_taghandler_44.setProperty("telephone");
              __jsp_taghandler_44.setReadonly(OracleJspRuntime.toBoolean(  (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.String.class, __ojsp_varRes, null)+">"));
              __jsp_taghandler_44.setStyle("width: 95%");
              __jsp_taghandler_44.setStyleId("telephone");
              __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
              if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,2);
            }
            out.write(__oracle_jsp_text[86]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_45=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
              __jsp_taghandler_45.setParent(__jsp_taghandler_1);
              __jsp_taghandler_45.setMaxlength("17");
              __jsp_taghandler_45.setName("feserv06");
              __jsp_taghandler_45.setOnblur("changeUpper(this)");
              __jsp_taghandler_45.setProperty("fax");
              __jsp_taghandler_45.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_45.setStyle("width: 95%");
              __jsp_taghandler_45.setStyleId("fax");
              __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
              if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,2);
            }
            out.write(__oracle_jsp_text[87]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_46=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
              __jsp_taghandler_46.setParent(__jsp_taghandler_1);
              __jsp_taghandler_46.setMaxlength("250");
              __jsp_taghandler_46.setName("feserv06");
              __jsp_taghandler_46.setOnblur("changeUpper(this)");
              __jsp_taghandler_46.setProperty("additionalEmail");
              __jsp_taghandler_46.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_46.setStyle("width: 95%");
              __jsp_taghandler_46.setStyleId("additionalEmail");
              __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
              if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,2);
            }
            out.write(__oracle_jsp_text[88]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_47=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleClass styleId");
              __jsp_taghandler_47.setParent(__jsp_taghandler_1);
              __jsp_taghandler_47.setMaxlength("45");
              __jsp_taghandler_47.setName("feserv06");
              __jsp_taghandler_47.setOnblur("changeUpper(this)");
              __jsp_taghandler_47.setOnkeydown("changeField('btnBrowseNotifyPartyName');");
              __jsp_taghandler_47.setProperty("shipperName");
              __jsp_taghandler_47.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_47.setStyle("width: 80%");
              __jsp_taghandler_47.setStyleClass("must");
              __jsp_taghandler_47.setStyleId("shipperName");
              __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
              if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,2);
            }
            out.write(__oracle_jsp_text[89]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_48=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleClass styleId");
              __jsp_taghandler_48.setParent(__jsp_taghandler_1);
              __jsp_taghandler_48.setMaxlength("45");
              __jsp_taghandler_48.setName("feserv06");
              __jsp_taghandler_48.setOnblur("changeUpper(this)");
              __jsp_taghandler_48.setOnkeydown("changeField('shipperAddress1');");
              __jsp_taghandler_48.setProperty("consigneeName");
              __jsp_taghandler_48.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_48.setStyle("width: 80%");
              __jsp_taghandler_48.setStyleClass("must");
              __jsp_taghandler_48.setStyleId("consigneeName");
              __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
              if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,2);
            }
            out.write(__oracle_jsp_text[90]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_49=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleClass styleId");
              __jsp_taghandler_49.setParent(__jsp_taghandler_1);
              __jsp_taghandler_49.setMaxlength("45");
              __jsp_taghandler_49.setName("feserv06");
              __jsp_taghandler_49.setOnblur("changeUpper(this)");
              __jsp_taghandler_49.setOnkeydown("changeField('consigneeAddress1');");
              __jsp_taghandler_49.setProperty("notifyPartyName");
              __jsp_taghandler_49.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_49.setStyle("width: 80%");
              __jsp_taghandler_49.setStyleClass("must");
              __jsp_taghandler_49.setStyleId("notifyPartyName");
              __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
              if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,2);
            }
            out.write(__oracle_jsp_text[91]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_50=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleClass styleId");
              __jsp_taghandler_50.setParent(__jsp_taghandler_1);
              __jsp_taghandler_50.setMaxlength("35");
              __jsp_taghandler_50.setName("feserv06");
              __jsp_taghandler_50.setOnblur("changeUpper(this)");
              __jsp_taghandler_50.setOnkeydown("changeField('notifyPartyAddress1');");
              __jsp_taghandler_50.setProperty("shipperAddress1");
              __jsp_taghandler_50.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_50.setStyle("width: 80%");
              __jsp_taghandler_50.setStyleClass("must");
              __jsp_taghandler_50.setStyleId("shipperAddress1");
              __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
              if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,2);
            }
            out.write(__oracle_jsp_text[92]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_51=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleClass styleId");
              __jsp_taghandler_51.setParent(__jsp_taghandler_1);
              __jsp_taghandler_51.setMaxlength("35");
              __jsp_taghandler_51.setName("feserv06");
              __jsp_taghandler_51.setOnblur("changeUpper(this)");
              __jsp_taghandler_51.setOnkeydown("changeField('shipperAddress2');");
              __jsp_taghandler_51.setProperty("consigneeAddress1");
              __jsp_taghandler_51.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_51.setStyle("width: 80%");
              __jsp_taghandler_51.setStyleClass("must");
              __jsp_taghandler_51.setStyleId("consigneeAddress1");
              __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
              if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,2);
            }
            out.write(__oracle_jsp_text[93]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_52=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleClass styleId");
              __jsp_taghandler_52.setParent(__jsp_taghandler_1);
              __jsp_taghandler_52.setMaxlength("35");
              __jsp_taghandler_52.setName("feserv06");
              __jsp_taghandler_52.setOnblur("changeUpper(this)");
              __jsp_taghandler_52.setOnkeydown("changeField('consigneeAddress2');");
              __jsp_taghandler_52.setProperty("notifyPartyAddress1");
              __jsp_taghandler_52.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_52.setStyle("width: 80%");
              __jsp_taghandler_52.setStyleClass("must");
              __jsp_taghandler_52.setStyleId("notifyPartyAddress1");
              __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
              if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,2);
            }
            out.write(__oracle_jsp_text[94]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_53=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_53.setParent(__jsp_taghandler_1);
              __jsp_taghandler_53.setMaxlength("35");
              __jsp_taghandler_53.setName("feserv06");
              __jsp_taghandler_53.setOnblur("changeUpper(this)");
              __jsp_taghandler_53.setOnkeydown("changeField('notifyPartyAddress2');");
              __jsp_taghandler_53.setProperty("shipperAddress2");
              __jsp_taghandler_53.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_53.setStyle("width: 80%");
              __jsp_taghandler_53.setStyleId("shipperAddress2");
              __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
              if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,2);
            }
            out.write(__oracle_jsp_text[95]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_54=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_54.setParent(__jsp_taghandler_1);
              __jsp_taghandler_54.setMaxlength("35");
              __jsp_taghandler_54.setName("feserv06");
              __jsp_taghandler_54.setOnblur("changeUpper(this)");
              __jsp_taghandler_54.setOnkeydown("changeField('shipperAddress3');");
              __jsp_taghandler_54.setProperty("consigneeAddress2");
              __jsp_taghandler_54.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_54.setStyle("width: 80%");
              __jsp_taghandler_54.setStyleId("consigneeAddress2");
              __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
              if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,2);
            }
            out.write(__oracle_jsp_text[96]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_55=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_55.setParent(__jsp_taghandler_1);
              __jsp_taghandler_55.setMaxlength("35");
              __jsp_taghandler_55.setName("feserv06");
              __jsp_taghandler_55.setOnblur("changeUpper(this)");
              __jsp_taghandler_55.setOnkeydown("changeField('consigneeAddress3');");
              __jsp_taghandler_55.setProperty("notifyPartyAddress2");
              __jsp_taghandler_55.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_55.setStyle("width: 80%");
              __jsp_taghandler_55.setStyleId("notifyPartyAddress2");
              __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
              if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,2);
            }
            out.write(__oracle_jsp_text[97]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_56=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_56.setParent(__jsp_taghandler_1);
              __jsp_taghandler_56.setMaxlength("35");
              __jsp_taghandler_56.setName("feserv06");
              __jsp_taghandler_56.setOnblur("changeUpper(this)");
              __jsp_taghandler_56.setOnkeydown("changeField('notifyPartyAddress3');");
              __jsp_taghandler_56.setProperty("shipperAddress3");
              __jsp_taghandler_56.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_56.setStyle("width: 80%");
              __jsp_taghandler_56.setStyleId("shipperAddress3");
              __jsp_tag_starteval=__jsp_taghandler_56.doStartTag();
              if (__jsp_taghandler_56.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_56,2);
            }
            out.write(__oracle_jsp_text[98]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_57=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_57.setParent(__jsp_taghandler_1);
              __jsp_taghandler_57.setMaxlength("35");
              __jsp_taghandler_57.setName("feserv06");
              __jsp_taghandler_57.setOnblur("changeUpper(this)");
              __jsp_taghandler_57.setOnkeydown("changeField('shipperAddress4');");
              __jsp_taghandler_57.setProperty("consigneeAddress3");
              __jsp_taghandler_57.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_57.setStyle("width: 80%");
              __jsp_taghandler_57.setStyleId("consigneeAddress3");
              __jsp_tag_starteval=__jsp_taghandler_57.doStartTag();
              if (__jsp_taghandler_57.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_57,2);
            }
            out.write(__oracle_jsp_text[99]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_58=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_58.setParent(__jsp_taghandler_1);
              __jsp_taghandler_58.setMaxlength("35");
              __jsp_taghandler_58.setName("feserv06");
              __jsp_taghandler_58.setOnblur("changeUpper(this)");
              __jsp_taghandler_58.setOnkeydown("changeField('consigneeAddress4');");
              __jsp_taghandler_58.setProperty("notifyPartyAddress3");
              __jsp_taghandler_58.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_58.setStyle("width: 80%");
              __jsp_taghandler_58.setStyleId("notifyPartyAddress3");
              __jsp_tag_starteval=__jsp_taghandler_58.doStartTag();
              if (__jsp_taghandler_58.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_58,2);
            }
            out.write(__oracle_jsp_text[100]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_59=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_59.setParent(__jsp_taghandler_1);
              __jsp_taghandler_59.setMaxlength("35");
              __jsp_taghandler_59.setName("feserv06");
              __jsp_taghandler_59.setOnblur("changeUpper(this)");
              __jsp_taghandler_59.setOnkeydown("changeField('shipperName');");
              __jsp_taghandler_59.setProperty("shipperAddress4");
              __jsp_taghandler_59.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_59.setStyle("width: 80%");
              __jsp_taghandler_59.setStyleId("shipperAddress4");
              __jsp_tag_starteval=__jsp_taghandler_59.doStartTag();
              if (__jsp_taghandler_59.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_59,2);
            }
            out.write(__oracle_jsp_text[101]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_60=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeydown property readonly style styleId");
              __jsp_taghandler_60.setParent(__jsp_taghandler_1);
              __jsp_taghandler_60.setMaxlength("35");
              __jsp_taghandler_60.setName("feserv06");
              __jsp_taghandler_60.setOnblur("changeUpper(this)");
              __jsp_taghandler_60.setOnkeydown("changeField('btnBrowseConsigneeName');");
              __jsp_taghandler_60.setProperty("consigneeAddress4");
              __jsp_taghandler_60.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_60.setStyle("width: 80%");
              __jsp_taghandler_60.setStyleId("consigneeAddress4");
              __jsp_tag_starteval=__jsp_taghandler_60.doStartTag();
              if (__jsp_taghandler_60.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_60,2);
            }
            out.write(__oracle_jsp_text[102]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_61=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
              __jsp_taghandler_61.setParent(__jsp_taghandler_1);
              __jsp_taghandler_61.setMaxlength("35");
              __jsp_taghandler_61.setName("feserv06");
              __jsp_taghandler_61.setOnblur("changeUpper(this)");
              __jsp_taghandler_61.setProperty("notifyPartyAddress4");
              __jsp_taghandler_61.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_61.setStyle("width: 80%");
              __jsp_taghandler_61.setStyleId("notifyPartyAddress4");
              __jsp_tag_starteval=__jsp_taghandler_61.doStartTag();
              if (__jsp_taghandler_61.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_61,2);
            }
            out.write(__oracle_jsp_text[103]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_62=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_62.setParent(__jsp_taghandler_1);
              __jsp_taghandler_62.setName("feserv06");
              __jsp_taghandler_62.setProperty("vessel");
              __jsp_taghandler_62.setStyleId("vessel");
              __jsp_tag_starteval=__jsp_taghandler_62.doStartTag();
              if (__jsp_taghandler_62.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_62,2);
            }
            out.write(__oracle_jsp_text[104]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_63=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_63.setParent(__jsp_taghandler_1);
              __jsp_taghandler_63.setName("feserv06");
              __jsp_taghandler_63.setProperty("vessel");
              __jsp_tag_starteval=__jsp_taghandler_63.doStartTag();
              if (__jsp_taghandler_63.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_63,2);
            }
            out.write(__oracle_jsp_text[105]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_64=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_64.setParent(__jsp_taghandler_1);
              __jsp_taghandler_64.setName("feserv06");
              __jsp_taghandler_64.setProperty("voyageNo");
              __jsp_taghandler_64.setStyleId("voyageNo");
              __jsp_tag_starteval=__jsp_taghandler_64.doStartTag();
              if (__jsp_taghandler_64.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_64,2);
            }
            out.write(__oracle_jsp_text[106]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_65=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_65.setParent(__jsp_taghandler_1);
              __jsp_taghandler_65.setName("feserv06");
              __jsp_taghandler_65.setProperty("voyageNo");
              __jsp_tag_starteval=__jsp_taghandler_65.doStartTag();
              if (__jsp_taghandler_65.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_65,2);
            }
            out.write(__oracle_jsp_text[107]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_66=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_66.setParent(__jsp_taghandler_1);
              __jsp_taghandler_66.setName("feserv06");
              __jsp_taghandler_66.setProperty("shippedOnBoardDate");
              __jsp_taghandler_66.setStyleId("shippedOnBoardDate");
              __jsp_tag_starteval=__jsp_taghandler_66.doStartTag();
              if (__jsp_taghandler_66.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_66,2);
            }
            out.write(__oracle_jsp_text[108]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_67=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_67.setParent(__jsp_taghandler_1);
              __jsp_taghandler_67.setName("feserv06");
              __jsp_taghandler_67.setProperty("shippedOnBoardDate");
              __jsp_tag_starteval=__jsp_taghandler_67.doStartTag();
              if (__jsp_taghandler_67.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_67,2);
            }
            out.write(__oracle_jsp_text[109]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_68=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
              __jsp_taghandler_68.setParent(__jsp_taghandler_1);
              __jsp_taghandler_68.setMaxlength("50");
              __jsp_taghandler_68.setName("feserv06");
              __jsp_taghandler_68.setOnblur("changeUpper(this)");
              __jsp_taghandler_68.setProperty("placeDateOfIssue");
              __jsp_taghandler_68.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_68.setStyle("width: 95%");
              __jsp_taghandler_68.setStyleId("placeDateOfIssue");
              __jsp_tag_starteval=__jsp_taghandler_68.doStartTag();
              if (__jsp_taghandler_68.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_68,2);
            }
            out.write(__oracle_jsp_text[110]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_69=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
              __jsp_taghandler_69.setParent(__jsp_taghandler_1);
              __jsp_taghandler_69.setMaxlength("50");
              __jsp_taghandler_69.setName("feserv06");
              __jsp_taghandler_69.setOnblur("changeUpper(this)");
              __jsp_taghandler_69.setProperty("pol");
              __jsp_taghandler_69.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_69.setStyle("width:95%");
              __jsp_taghandler_69.setStyleClass("must");
              __jsp_taghandler_69.setStyleId("pol");
              __jsp_tag_starteval=__jsp_taghandler_69.doStartTag();
              if (__jsp_taghandler_69.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_69,2);
            }
            out.write(__oracle_jsp_text[111]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_70=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
              __jsp_taghandler_70.setParent(__jsp_taghandler_1);
              __jsp_taghandler_70.setMaxlength("50");
              __jsp_taghandler_70.setName("feserv06");
              __jsp_taghandler_70.setOnblur("changeUpper(this)");
              __jsp_taghandler_70.setProperty("pod");
              __jsp_taghandler_70.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_70.setStyle("width:95%");
              __jsp_taghandler_70.setStyleClass("must");
              __jsp_taghandler_70.setStyleId("pod");
              __jsp_tag_starteval=__jsp_taghandler_70.doStartTag();
              if (__jsp_taghandler_70.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_70,2);
            }
            out.write(__oracle_jsp_text[112]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_71=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
              __jsp_taghandler_71.setParent(__jsp_taghandler_1);
              __jsp_taghandler_71.setMaxlength("50");
              __jsp_taghandler_71.setName("feserv06");
              __jsp_taghandler_71.setOnblur("changeUpper(this)");
              __jsp_taghandler_71.setProperty("placeOfReceipt");
              __jsp_taghandler_71.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_71.setStyle("width:95%");
              __jsp_taghandler_71.setStyleClass("must");
              __jsp_taghandler_71.setStyleId("placeOfReceipt");
              __jsp_tag_starteval=__jsp_taghandler_71.doStartTag();
              if (__jsp_taghandler_71.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_71,2);
            }
            out.write(__oracle_jsp_text[113]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_72=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass styleId");
              __jsp_taghandler_72.setParent(__jsp_taghandler_1);
              __jsp_taghandler_72.setMaxlength("50");
              __jsp_taghandler_72.setName("feserv06");
              __jsp_taghandler_72.setOnblur("changeUpper(this)");
              __jsp_taghandler_72.setProperty("placeOfDelivery");
              __jsp_taghandler_72.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_72.setStyle("width:95%");
              __jsp_taghandler_72.setStyleClass("must");
              __jsp_taghandler_72.setStyleId("placeOfDelivery");
              __jsp_tag_starteval=__jsp_taghandler_72.doStartTag();
              if (__jsp_taghandler_72.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_72,2);
            }
            out.write(__oracle_jsp_text[114]);
            out.write(__oracle_jsp_text[115]);
            out.write(__oracle_jsp_text[116]);
            out.write(__oracle_jsp_text[117]);
            out.write(__oracle_jsp_text[118]);
            
                                        int countCommo = 0;
                                        
                                        //COMMODITY_SELECT
                                    
            out.write(__oracle_jsp_text[119]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_73=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_73.setParent(__jsp_taghandler_1);
              __jsp_taghandler_73.setId("commodityValue");
              __jsp_taghandler_73.setIndexId("ctr");
              __jsp_taghandler_73.setName("feserv06");
              __jsp_taghandler_73.setProperty("commodityVoDataList");
              __jsp_taghandler_73.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod");
              com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod commodityValue = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_73.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_73,__jsp_tag_starteval,out);
                do {
                  commodityValue = (com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod) pageContext.findAttribute("commodityValue");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[120]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_74=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_74.setParent(__jsp_taghandler_73);
                    __jsp_taghandler_74.setName("commodityValue");
                    __jsp_taghandler_74.setProperty("recordStatus");
                    __jsp_taghandler_74.setValue("DEL");
                    __jsp_tag_starteval=__jsp_taghandler_74.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[121]);
                         if(EshippingInstructionDao.ESI_STATUS.NEW.equals(esiStatusCode) || EshippingInstructionDao.ESI_STATUS.IN_PROGRESS.equals(esiStatusCode)) { 
                        out.write(__oracle_jsp_text[122]);
                        out.print(countCommo+1);
                        out.write(__oracle_jsp_text[123]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_75=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_75.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_75.setName("commodityValue");
                          __jsp_taghandler_75.setProperty("intCommGroupSeqNo");
                          __jsp_taghandler_75.setStyleId("intCommGroupSeqNo");
                          __jsp_tag_starteval=__jsp_taghandler_75.doStartTag();
                          if (__jsp_taghandler_75.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_75,4);
                        }
                        out.write(__oracle_jsp_text[124]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_76=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_76.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_76.setName("commodityValue");
                          __jsp_taghandler_76.setProperty("strCommGroupCode");
                          __jsp_taghandler_76.setStyleId("strCommGroupCode");
                          __jsp_tag_starteval=__jsp_taghandler_76.doStartTag();
                          if (__jsp_taghandler_76.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_76,4);
                        }
                        out.write(__oracle_jsp_text[125]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_77=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_77.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_77.setName("commodityValue");
                          __jsp_taghandler_77.setProperty("recordStatus");
                          __jsp_taghandler_77.setStyleId("recordStatus");
                          __jsp_tag_starteval=__jsp_taghandler_77.doStartTag();
                          if (__jsp_taghandler_77.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_77,4);
                        }
                        out.write(__oracle_jsp_text[126]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_78=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_78.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_78.setName("commodityValue");
                          __jsp_taghandler_78.setProperty("strCommPackageKindCode");
                          __jsp_taghandler_78.setStyleId("strCommPackageKindCode");
                          __jsp_tag_starteval=__jsp_taghandler_78.doStartTag();
                          if (__jsp_taghandler_78.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_78,4);
                        }
                        out.write(__oracle_jsp_text[127]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_79=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_79.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_79.setName("commodityValue");
                          __jsp_taghandler_79.setProperty("marksAndNumbers");
                          __jsp_taghandler_79.setStyleId("marksAndNumbers");
                          __jsp_tag_starteval=__jsp_taghandler_79.doStartTag();
                          if (__jsp_taghandler_79.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_79,4);
                        }
                        out.write(__oracle_jsp_text[128]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_80=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_80.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_80.setName("commodityValue");
                          __jsp_taghandler_80.setProperty("description");
                          __jsp_taghandler_80.setStyleId("description");
                          __jsp_tag_starteval=__jsp_taghandler_80.doStartTag();
                          if (__jsp_taghandler_80.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_80,4);
                        }
                        out.write(__oracle_jsp_text[129]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_81=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_81.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_81.setName("commodityValue");
                          __jsp_taghandler_81.setProperty("comBookingNo");
                          __jsp_taghandler_81.setStyleId("comBookingNo");
                          __jsp_tag_starteval=__jsp_taghandler_81.doStartTag();
                          if (__jsp_taghandler_81.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_81,4);
                        }
                        out.write(__oracle_jsp_text[130]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_82=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_82.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_82.setName("commodityValue");
                          __jsp_taghandler_82.setProperty("strCommodityForMark");
                          __jsp_taghandler_82.setStyleId("strCommodityForMark");
                          __jsp_tag_starteval=__jsp_taghandler_82.doStartTag();
                          if (__jsp_taghandler_82.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_82,4);
                        }
                        out.write(__oracle_jsp_text[131]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_83=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_83.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_83.setName("commodityValue");
                          __jsp_taghandler_83.setProperty("containerNoToCargo");
                          __jsp_taghandler_83.setStyleId("containerNoToCargo");
                          __jsp_tag_starteval=__jsp_taghandler_83.doStartTag();
                          if (__jsp_taghandler_83.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_83,4);
                        }
                        out.write(__oracle_jsp_text[132]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_84=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                          __jsp_taghandler_84.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_84.setName("commodityValue");
                          __jsp_taghandler_84.setProperty("comSeqNo");
                          __jsp_taghandler_84.setStyleId("comSeqNo");
                          __jsp_tag_starteval=__jsp_taghandler_84.doStartTag();
                          if (__jsp_taghandler_84.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_84,4);
                        }
                        out.write(__oracle_jsp_text[133]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_85=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property style styleClass");
                          __jsp_taghandler_85.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_85.setName("commodityValue");
                          __jsp_taghandler_85.setOnkeydown("return false;");
                          __jsp_taghandler_85.setOnkeypress("return false;");
                          __jsp_taghandler_85.setProperty("strCommGroup");
                          __jsp_taghandler_85.setStyle("width: 75%");
                          __jsp_taghandler_85.setStyleClass("input-disabled");
                          __jsp_tag_starteval=__jsp_taghandler_85.doStartTag();
                          if (__jsp_taghandler_85.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_85,4);
                        }
                        out.write(__oracle_jsp_text[134]);
                        out.write(__oracle_jsp_text[135]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_86=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property style styleClass styleId");
                          __jsp_taghandler_86.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_86.setName("commodityValue");
                          __jsp_taghandler_86.setOnkeydown("return false;");
                          __jsp_taghandler_86.setOnkeypress("return false;");
                          __jsp_taghandler_86.setProperty("strCommCode");
                          __jsp_taghandler_86.setStyle("width: 75%");
                          __jsp_taghandler_86.setStyleClass("must");
                          __jsp_taghandler_86.setStyleId("strCommCode");
                          __jsp_tag_starteval=__jsp_taghandler_86.doStartTag();
                          if (__jsp_taghandler_86.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_86,4);
                        }
                        out.write(__oracle_jsp_text[136]);
                        out.write(__oracle_jsp_text[137]);
                         if(obj.getBookingNo() != null && !"".equals(obj.getBookingNo())){ 
                        out.write(__oracle_jsp_text[138]);
                         } 
                        out.write(__oracle_jsp_text[139]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_87=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property style styleClass styleId");
                          __jsp_taghandler_87.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_87.setName("commodityValue");
                          __jsp_taghandler_87.setOnkeydown("return false;");
                          __jsp_taghandler_87.setOnkeypress("return false;");
                          __jsp_taghandler_87.setProperty("strCommDesc");
                          __jsp_taghandler_87.setStyle("width: 75%");
                          __jsp_taghandler_87.setStyleClass("input-disabled");
                          __jsp_taghandler_87.setStyleId("strCommDesc");
                          __jsp_tag_starteval=__jsp_taghandler_87.doStartTag();
                          if (__jsp_taghandler_87.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_87,4);
                        }
                        out.write(__oracle_jsp_text[140]);
                        out.write(__oracle_jsp_text[141]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_88=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_88.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_88.setMaxlength("6");
                          __jsp_taghandler_88.setName("commodityValue");
                          __jsp_taghandler_88.setOnkeydown("return false;");
                          __jsp_taghandler_88.setOnkeypress("return false;");
                          __jsp_taghandler_88.setProperty("strCommOfPackages");
                          __jsp_taghandler_88.setReadonly(true);
                          __jsp_taghandler_88.setStyle("width: 70%");
                          __jsp_taghandler_88.setStyleClass("input-disabled");
                          __jsp_taghandler_88.setStyleId("strCommOfPackages");
                          __jsp_tag_starteval=__jsp_taghandler_88.doStartTag();
                          if (__jsp_taghandler_88.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_88,4);
                        }
                        out.write(__oracle_jsp_text[142]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_89=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_89.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_89.setName("commodityValue");
                          __jsp_taghandler_89.setOnkeydown("return false;");
                          __jsp_taghandler_89.setOnkeypress("return false;");
                          __jsp_taghandler_89.setProperty("strCommPackageKindName");
                          __jsp_taghandler_89.setReadonly(true);
                          __jsp_taghandler_89.setStyle("width: 66%;");
                          __jsp_taghandler_89.setStyleClass("input-disabled");
                          __jsp_taghandler_89.setStyleId("strCommPackageKindName");
                          __jsp_tag_starteval=__jsp_taghandler_89.doStartTag();
                          if (__jsp_taghandler_89.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_89,4);
                        }
                        out.write(__oracle_jsp_text[143]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_90=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_90.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_90.setName("commodityValue");
                          __jsp_taghandler_90.setOnkeydown("return false;");
                          __jsp_taghandler_90.setOnkeypress("return false;");
                          __jsp_taghandler_90.setProperty("strCommWeight");
                          __jsp_taghandler_90.setReadonly(true);
                          __jsp_taghandler_90.setStyle("width: 66%");
                          __jsp_taghandler_90.setStyleClass("input-disabled");
                          __jsp_taghandler_90.setStyleId("strCommWeight");
                          __jsp_tag_starteval=__jsp_taghandler_90.doStartTag();
                          if (__jsp_taghandler_90.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_90,4);
                        }
                        out.write(__oracle_jsp_text[144]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_91=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_91.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_91.setMaxlength("19");
                          __jsp_taghandler_91.setName("commodityValue");
                          __jsp_taghandler_91.setOnkeydown("return false;");
                          __jsp_taghandler_91.setOnkeypress("return false;");
                          __jsp_taghandler_91.setProperty("strCommMeasurement");
                          __jsp_taghandler_91.setReadonly(true);
                          __jsp_taghandler_91.setStyle("width: 66%");
                          __jsp_taghandler_91.setStyleClass("input-disabled");
                          __jsp_taghandler_91.setStyleId("strCommMeasurement");
                          __jsp_tag_starteval=__jsp_taghandler_91.doStartTag();
                          if (__jsp_taghandler_91.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_91,4);
                        }
                        out.write(__oracle_jsp_text[145]);
                         if(countCommo > 0){ 
                        out.write(__oracle_jsp_text[146]);
                        {
                          org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_92=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style styleId value");
                          __jsp_taghandler_92.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_92.setName("commodityValue");
                          __jsp_taghandler_92.setProperty("isSelected");
                          __jsp_taghandler_92.setStyle("border:0px; width:15px; height: 15px");
                          __jsp_taghandler_92.setStyleId("isSelected");
                          __jsp_taghandler_92.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_92.doStartTag();
                          if (__jsp_taghandler_92.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_92,4);
                        }
                        out.write(__oracle_jsp_text[147]);
                         } 
                        out.write(__oracle_jsp_text[148]);
                          ++countCommo;   
                        out.write(__oracle_jsp_text[149]);
                         }else{   
                        out.write(__oracle_jsp_text[150]);
                        out.print(countCommo+1);
                        out.write(__oracle_jsp_text[151]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_93=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_93.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_93.setName("commodityValue");
                          __jsp_taghandler_93.setOnkeydown("return false;");
                          __jsp_taghandler_93.setOnkeypress("return false;");
                          __jsp_taghandler_93.setProperty("strCommGroup");
                          __jsp_taghandler_93.setReadonly(true);
                          __jsp_taghandler_93.setStyle("width: 75%");
                          __jsp_taghandler_93.setStyleClass("input-disabled");
                          __jsp_taghandler_93.setStyleId("strCommGroup");
                          __jsp_tag_starteval=__jsp_taghandler_93.doStartTag();
                          if (__jsp_taghandler_93.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_93,4);
                        }
                        out.write(__oracle_jsp_text[152]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_94=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property style styleClass styleId");
                          __jsp_taghandler_94.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_94.setName("commodityValue");
                          __jsp_taghandler_94.setOnkeydown("return false;");
                          __jsp_taghandler_94.setOnkeypress("return false;");
                          __jsp_taghandler_94.setProperty("strCommCode");
                          __jsp_taghandler_94.setStyle("width: 75%");
                          __jsp_taghandler_94.setStyleClass("must");
                          __jsp_taghandler_94.setStyleId("strCommCode");
                          __jsp_tag_starteval=__jsp_taghandler_94.doStartTag();
                          if (__jsp_taghandler_94.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_94,4);
                        }
                        out.write(__oracle_jsp_text[153]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_95=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_95.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_95.setName("commodityValue");
                          __jsp_taghandler_95.setOnkeydown("return false;");
                          __jsp_taghandler_95.setOnkeypress("return false;");
                          __jsp_taghandler_95.setProperty("strCommDesc");
                          __jsp_taghandler_95.setReadonly(true);
                          __jsp_taghandler_95.setStyle("width: 75%");
                          __jsp_taghandler_95.setStyleClass("input-disabled");
                          __jsp_taghandler_95.setStyleId("strCommDesc");
                          __jsp_tag_starteval=__jsp_taghandler_95.doStartTag();
                          if (__jsp_taghandler_95.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_95,4);
                        }
                        out.write(__oracle_jsp_text[154]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_96=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_96.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_96.setMaxlength("6");
                          __jsp_taghandler_96.setName("commodityValue");
                          __jsp_taghandler_96.setOnblur("maskWithOutDecimal(this, 6, 2)");
                          __jsp_taghandler_96.setOnclick("hideMask_Number(this);");
                          __jsp_taghandler_96.setOnkeydown("return false;");
                          __jsp_taghandler_96.setOnkeypress("return false;");
                          __jsp_taghandler_96.setProperty("strCommOfPackages");
                          __jsp_taghandler_96.setReadonly(true);
                          __jsp_taghandler_96.setStyle("width: 70%");
                          __jsp_taghandler_96.setStyleClass("must");
                          __jsp_taghandler_96.setStyleId("strCommOfPackages");
                          __jsp_tag_starteval=__jsp_taghandler_96.doStartTag();
                          if (__jsp_taghandler_96.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_96,4);
                        }
                        out.write(__oracle_jsp_text[155]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_97=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_97.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_97.setName("commodityValue");
                          __jsp_taghandler_97.setOnkeydown("return false;");
                          __jsp_taghandler_97.setOnkeypress("return false;");
                          __jsp_taghandler_97.setProperty("strCommPackageKindName");
                          __jsp_taghandler_97.setReadonly(true);
                          __jsp_taghandler_97.setStyle("width: 66%");
                          __jsp_taghandler_97.setStyleClass("input-disabled");
                          __jsp_taghandler_97.setStyleId("strCommPackageKindName");
                          __jsp_tag_starteval=__jsp_taghandler_97.doStartTag();
                          if (__jsp_taghandler_97.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_97,4);
                        }
                        out.write(__oracle_jsp_text[156]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_98=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_98.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_98.setName("commodityValue");
                          __jsp_taghandler_98.setOnkeydown("return false;");
                          __jsp_taghandler_98.setOnkeypress("return false;");
                          __jsp_taghandler_98.setProperty("strCommWeight");
                          __jsp_taghandler_98.setReadonly(true);
                          __jsp_taghandler_98.setStyle("width: 66%");
                          __jsp_taghandler_98.setStyleClass("input-disabled");
                          __jsp_taghandler_98.setStyleId("strCommWeight");
                          __jsp_tag_starteval=__jsp_taghandler_98.doStartTag();
                          if (__jsp_taghandler_98.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_98,4);
                        }
                        out.write(__oracle_jsp_text[157]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_99=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick onkeydown onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_99.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_99.setMaxlength("19");
                          __jsp_taghandler_99.setName("commodityValue");
                          __jsp_taghandler_99.setOnblur("putMask_NumberEX(this, 14, 4)");
                          __jsp_taghandler_99.setOnclick("hideMask_Number(this);");
                          __jsp_taghandler_99.setOnkeydown("return false;");
                          __jsp_taghandler_99.setOnkeypress("return false;");
                          __jsp_taghandler_99.setProperty("strCommMeasurement");
                          __jsp_taghandler_99.setReadonly(true);
                          __jsp_taghandler_99.setStyle("width: 66%");
                          __jsp_taghandler_99.setStyleClass("input-disabled");
                          __jsp_taghandler_99.setStyleId("strCommMeasurement");
                          __jsp_tag_starteval=__jsp_taghandler_99.doStartTag();
                          if (__jsp_taghandler_99.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_99,4);
                        }
                        out.write(__oracle_jsp_text[158]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_100=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_100.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_100.setName("feserv06");
                          __jsp_taghandler_100.setProperty("esiStatusCode");
                          __jsp_taghandler_100.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                          __jsp_tag_starteval=__jsp_taghandler_100.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[159]);
                            } while (__jsp_taghandler_100.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_100.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_100,4);
                        }
                        out.write(__oracle_jsp_text[160]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_101=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                          __jsp_taghandler_101.setParent(__jsp_taghandler_74);
                          __jsp_taghandler_101.setName("feserv06");
                          __jsp_taghandler_101.setProperty("esiStatusCode");
                          __jsp_taghandler_101.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                          __jsp_tag_starteval=__jsp_taghandler_101.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[161]);
                            } while (__jsp_taghandler_101.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_101.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_101,4);
                        }
                        out.write(__oracle_jsp_text[162]);
                          countCommo++;   
                        out.write(__oracle_jsp_text[163]);
                         } 
                        out.write(__oracle_jsp_text[164]);
                      } while (__jsp_taghandler_74.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_74.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_74,3);
                  }
                  out.write(__oracle_jsp_text[165]);
                } while (__jsp_taghandler_73.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_73.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_73,2);
            }
            out.write(__oracle_jsp_text[166]);
            out.write(__oracle_jsp_text[167]);
            {
              org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_102=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
              __jsp_taghandler_102.setParent(__jsp_taghandler_1);
              __jsp_taghandler_102.setName("feserv06");
              __jsp_taghandler_102.setProperty("commodityVoDataList");
              __jsp_tag_starteval=__jsp_taghandler_102.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[168]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_103=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_103.setParent(__jsp_taghandler_102);
                    __jsp_taghandler_103.setName("feserv06");
                    __jsp_taghandler_103.setProperty("esiStatusCode");
                    __jsp_taghandler_103.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                    __jsp_tag_starteval=__jsp_taghandler_103.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[169]);
                        {
                          org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_104=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                          __jsp_taghandler_104.setParent(__jsp_taghandler_103);
                          __jsp_taghandler_104.setName("feserv06");
                          __jsp_taghandler_104.setProperty("bookingNo");
                          __jsp_tag_starteval=__jsp_taghandler_104.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[170]);
                              
                                                          String deleteCommBtnDisp = null;
                                                          String columnWidth = null;
                                                          if(obj.getCommodityVoDataList() != null && obj.getCommodityVoDataList().size() > 1){
                                                              deleteCommBtnDisp = "inline";
                                                          }else{
                                                              deleteCommBtnDisp = "none";
                                                          }
                                                      
                              out.write(__oracle_jsp_text[171]);
                              out.print(deleteCommBtnDisp);
                              out.write(__oracle_jsp_text[172]);
                            } while (__jsp_taghandler_104.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_104.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_104,4);
                        }
                        out.write(__oracle_jsp_text[173]);
                      } while (__jsp_taghandler_103.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_103.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_103,3);
                  }
                  out.write(__oracle_jsp_text[174]);
                } while (__jsp_taghandler_102.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_102.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_102,2);
            }
            out.write(__oracle_jsp_text[175]);
            {
              org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_105=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name scope");
              __jsp_taghandler_105.setParent(__jsp_taghandler_1);
              __jsp_taghandler_105.setName("eshippingInstructionUim");
              __jsp_taghandler_105.setScope("session");
              __jsp_tag_starteval=__jsp_taghandler_105.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[176]);
                  {
                    org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_106=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name scope type");
                    __jsp_taghandler_106.setParent(__jsp_taghandler_105);
                    __jsp_taghandler_106.setId("objFormSession");
                    __jsp_taghandler_106.setName("eshippingInstructionUim");
                    __jsp_taghandler_106.setScope("session");
                    __jsp_taghandler_106.setType("com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim");
                    __jsp_tag_starteval=__jsp_taghandler_106.doStartTag();
                    if (__jsp_taghandler_106.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_106,3);
                  }
                  com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim objFormSession = null;
                  objFormSession = (com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim) pageContext.findAttribute("objFormSession");
                  out.write(__oracle_jsp_text[177]);
                  {
                    org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_107=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                    __jsp_taghandler_107.setParent(__jsp_taghandler_105);
                    __jsp_taghandler_107.setName("objFormSession");
                    __jsp_taghandler_107.setProperty("cargoDescriptionDetails");
                    __jsp_tag_starteval=__jsp_taghandler_107.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[178]);
                        {
                          org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_108=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property type");
                          __jsp_taghandler_108.setParent(__jsp_taghandler_107);
                          __jsp_taghandler_108.setId("cargoDescriptionDetailsList");
                          __jsp_taghandler_108.setName("objFormSession");
                          __jsp_taghandler_108.setProperty("cargoDescriptionDetails");
                          __jsp_taghandler_108.setType("java.util.List");
                          __jsp_tag_starteval=__jsp_taghandler_108.doStartTag();
                          if (__jsp_taghandler_108.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_108,4);
                        }
                        java.util.List cargoDescriptionDetailsList = null;
                        cargoDescriptionDetailsList = (java.util.List) pageContext.findAttribute("cargoDescriptionDetailsList");
                        out.write(__oracle_jsp_text[179]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_109=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name");
                          __jsp_taghandler_109.setParent(__jsp_taghandler_107);
                          __jsp_taghandler_109.setId("cargoDetails");
                          __jsp_taghandler_109.setIndexId("rowCargoDetailsId");
                          __jsp_taghandler_109.setName("cargoDescriptionDetailsList");
                          java.lang.Object cargoDetails = null;
                          java.lang.Integer rowCargoDetailsId = null;
                          __jsp_tag_starteval=__jsp_taghandler_109.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_109,__jsp_tag_starteval,out);
                            do {
                              cargoDetails = (java.lang.Object) pageContext.findAttribute("cargoDetails");
                              rowCargoDetailsId = (java.lang.Integer) pageContext.findAttribute("rowCargoDetailsId");
                              out.write(__oracle_jsp_text[180]);
                              {
                                org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_110=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property");
                                __jsp_taghandler_110.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_110.setId("seqNo");
                                __jsp_taghandler_110.setName("cargoDetails");
                                __jsp_taghandler_110.setProperty("seqNo");
                                __jsp_tag_starteval=__jsp_taghandler_110.doStartTag();
                                if (__jsp_taghandler_110.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_110,5);
                              }
                              java.lang.Object seqNo = null;
                              seqNo = (java.lang.Object) pageContext.findAttribute("seqNo");
                              out.write(__oracle_jsp_text[181]);
                              out.print(((rowCargoDetailsId+1)%2==0)?"rowEvenColor":"rowOddColor");
                              out.write(__oracle_jsp_text[182]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_111=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name");
                                __jsp_taghandler_111.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_111.setName("seqNo");
                                __jsp_tag_starteval=__jsp_taghandler_111.doStartTag();
                                if (__jsp_taghandler_111.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_111,5);
                              }
                              out.write(__oracle_jsp_text[183]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_112=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name");
                                __jsp_taghandler_112.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_112.setName("seqNo");
                                __jsp_tag_starteval=__jsp_taghandler_112.doStartTag();
                                if (__jsp_taghandler_112.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_112,5);
                              }
                              out.write(__oracle_jsp_text[184]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_113=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_113.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_113.setName("cargoDetails");
                                __jsp_taghandler_113.setProperty("cntrSeq");
                                __jsp_tag_starteval=__jsp_taghandler_113.doStartTag();
                                if (__jsp_taghandler_113.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_113,5);
                              }
                              out.write(__oracle_jsp_text[185]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_114=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_114.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_114.setName("cargoDetails");
                                __jsp_taghandler_114.setProperty("dbFlag");
                                __jsp_tag_starteval=__jsp_taghandler_114.doStartTag();
                                if (__jsp_taghandler_114.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_114,5);
                              }
                              out.write(__oracle_jsp_text[186]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_115=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_115.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_115.setName("cargoDetails");
                                __jsp_taghandler_115.setProperty("statusFlag");
                                __jsp_tag_starteval=__jsp_taghandler_115.doStartTag();
                                if (__jsp_taghandler_115.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_115,5);
                              }
                              out.write(__oracle_jsp_text[187]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_116=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_116.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_116.setName("cargoDetails");
                                __jsp_taghandler_116.setProperty("originalSeqNo");
                                __jsp_tag_starteval=__jsp_taghandler_116.doStartTag();
                                if (__jsp_taghandler_116.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_116,5);
                              }
                              out.write(__oracle_jsp_text[188]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_117=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_117.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_117.setName("cargoDetails");
                                __jsp_taghandler_117.setProperty("fkEquipmentDetail");
                                __jsp_tag_starteval=__jsp_taghandler_117.doStartTag();
                                if (__jsp_taghandler_117.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_117,5);
                              }
                              out.write(__oracle_jsp_text[189]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_118=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_118.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_118.setName("cargoDetails");
                                __jsp_taghandler_118.setProperty("fkBookingSupplier");
                                __jsp_tag_starteval=__jsp_taghandler_118.doStartTag();
                                if (__jsp_taghandler_118.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_118,5);
                              }
                              out.write(__oracle_jsp_text[190]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_119=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_119.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_119.setName("cargoDetails");
                                __jsp_taghandler_119.setProperty("fkBookingSizeTypeDetail");
                                __jsp_tag_starteval=__jsp_taghandler_119.doStartTag();
                                if (__jsp_taghandler_119.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_119,5);
                              }
                              out.write(__oracle_jsp_text[191]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_120=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_120.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_120.setName("cargoDetails");
                                __jsp_taghandler_120.setProperty("containerNo");
                                __jsp_tag_starteval=__jsp_taghandler_120.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[192]);
                                    {
                                      org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_121=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                                      __jsp_taghandler_121.setParent(__jsp_taghandler_120);
                                      __jsp_taghandler_121.setName("isReadOnly");
                                      __jsp_taghandler_121.setValue("false");
                                      __jsp_tag_starteval=__jsp_taghandler_121.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[193]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_122=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onfocus property readonly style styleId");
                                            __jsp_taghandler_122.setParent(__jsp_taghandler_121);
                                            __jsp_taghandler_122.setMaxlength("11");
                                            __jsp_taghandler_122.setName("cargoDetails");
                                            __jsp_taghandler_122.setOnblur("changeUpper(this);");
                                            __jsp_taghandler_122.setOnchange((java.lang.String) ("onChangeContainerNo("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_122.setOnfocus((java.lang.String) ("editContainerNo("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_122.setProperty("containerNo");
                                            __jsp_taghandler_122.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                            __jsp_taghandler_122.setStyle("width: 81%");
                                            __jsp_taghandler_122.setStyleId("containerNo");
                                            __jsp_tag_starteval=__jsp_taghandler_122.doStartTag();
                                            if (__jsp_taghandler_122.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_122,7);
                                          }
                                          out.write(__oracle_jsp_text[194]);
                                        } while (__jsp_taghandler_121.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_121.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_121,6);
                                    }
                                    out.write(__oracle_jsp_text[195]);
                                    {
                                      org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_123=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                                      __jsp_taghandler_123.setParent(__jsp_taghandler_120);
                                      __jsp_taghandler_123.setName("isReadOnly");
                                      __jsp_taghandler_123.setValue("false");
                                      __jsp_tag_starteval=__jsp_taghandler_123.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[196]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_124=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleId");
                                            __jsp_taghandler_124.setParent(__jsp_taghandler_123);
                                            __jsp_taghandler_124.setMaxlength("11");
                                            __jsp_taghandler_124.setName("cargoDetails");
                                            __jsp_taghandler_124.setProperty("containerNo");
                                            __jsp_taghandler_124.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                            __jsp_taghandler_124.setStyle("width: 81%");
                                            __jsp_taghandler_124.setStyleId("containerNo");
                                            __jsp_tag_starteval=__jsp_taghandler_124.doStartTag();
                                            if (__jsp_taghandler_124.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_124,7);
                                          }
                                          out.write(__oracle_jsp_text[197]);
                                        } while (__jsp_taghandler_123.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_123.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_123,6);
                                    }
                                    out.write(__oracle_jsp_text[198]);
                                  } while (__jsp_taghandler_120.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_120.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_120,5);
                              }
                              out.write(__oracle_jsp_text[199]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_125=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_125.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_125.setName("cargoDetails");
                                __jsp_taghandler_125.setProperty("containerNo");
                                __jsp_tag_starteval=__jsp_taghandler_125.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[200]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_126=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onfocus property readonly style styleId value");
                                      __jsp_taghandler_126.setParent(__jsp_taghandler_125);
                                      __jsp_taghandler_126.setMaxlength("11");
                                      __jsp_taghandler_126.setName("cargoDetails");
                                      __jsp_taghandler_126.setOnblur("changeUpper(this);");
                                      __jsp_taghandler_126.setOnchange((java.lang.String) ("onChangeContainerNo("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                      __jsp_taghandler_126.setOnfocus((java.lang.String) ("editContainerNo("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                      __jsp_taghandler_126.setProperty("containerNo");
                                      __jsp_taghandler_126.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_126.setStyle("width: 81%");
                                      __jsp_taghandler_126.setStyleId("containerNo");
                                      __jsp_taghandler_126.setValue("");
                                      __jsp_tag_starteval=__jsp_taghandler_126.doStartTag();
                                      if (__jsp_taghandler_126.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_126,6);
                                    }
                                    out.write(__oracle_jsp_text[201]);
                                  } while (__jsp_taghandler_125.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_125.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_125,5);
                              }
                              out.write(__oracle_jsp_text[202]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_127=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_127.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_127.setName("cargoDetails");
                                __jsp_taghandler_127.setProperty("containerEqSize");
                                __jsp_tag_starteval=__jsp_taghandler_127.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[203]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_128=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_128.setParent(__jsp_taghandler_127);
                                      __jsp_taghandler_128.setName("cargoDetails");
                                      __jsp_taghandler_128.setProperty("containerEqSize");
                                      __jsp_tag_starteval=__jsp_taghandler_128.doStartTag();
                                      if (__jsp_taghandler_128.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_128,6);
                                    }
                                    out.write(__oracle_jsp_text[204]);
                                  } while (__jsp_taghandler_127.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_127.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_127,5);
                              }
                              out.write(__oracle_jsp_text[205]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_129=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_129.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_129.setName("cargoDetails");
                                __jsp_taghandler_129.setProperty("containerEqSize");
                                __jsp_tag_starteval=__jsp_taghandler_129.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[206]);
                                  } while (__jsp_taghandler_129.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_129.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_129,5);
                              }
                              out.write(__oracle_jsp_text[207]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_130=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_130.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_130.setName("cargoDetails");
                                __jsp_taghandler_130.setProperty("containerEqType");
                                __jsp_tag_starteval=__jsp_taghandler_130.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[208]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_131=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_131.setParent(__jsp_taghandler_130);
                                      __jsp_taghandler_131.setName("cargoDetails");
                                      __jsp_taghandler_131.setProperty("containerEqType");
                                      __jsp_tag_starteval=__jsp_taghandler_131.doStartTag();
                                      if (__jsp_taghandler_131.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_131,6);
                                    }
                                    out.write(__oracle_jsp_text[209]);
                                  } while (__jsp_taghandler_130.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_130.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_130,5);
                              }
                              out.write(__oracle_jsp_text[210]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_132=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_132.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_132.setName("cargoDetails");
                                __jsp_taghandler_132.setProperty("containerEqSize");
                                __jsp_tag_starteval=__jsp_taghandler_132.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[211]);
                                  } while (__jsp_taghandler_132.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_132.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_132,5);
                              }
                              out.write(__oracle_jsp_text[212]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_133=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_133.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_133.setName("cargoDetails");
                                __jsp_taghandler_133.setProperty("dbFlag");
                                __jsp_taghandler_133.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_133.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[213]);
                                    {
                                      org.apache.struts.taglib.html.SelectTag __jsp_taghandler_134=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleId");
                                      __jsp_taghandler_134.setParent(__jsp_taghandler_133);
                                      __jsp_taghandler_134.setName("cargoDetails");
                                      __jsp_taghandler_134.setOnchange("setContainerValue(this, '<%=seqNo%>')");
                                      __jsp_taghandler_134.setProperty("containerType");
                                      __jsp_taghandler_134.setStyle("width: 90%; height:20px;");
                                      __jsp_taghandler_134.setStyleId("containerType");
                                      __jsp_tag_starteval=__jsp_taghandler_134.doStartTag();
                                      if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                      {
                                        out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_134,__jsp_tag_starteval,out);
                                        do {
                                          out.write(__oracle_jsp_text[214]);
                                          {
                                            org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_135=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                            __jsp_taghandler_135.setParent(__jsp_taghandler_134);
                                            __jsp_taghandler_135.setLabel("name");
                                            __jsp_taghandler_135.setName("cargoDetails");
                                            __jsp_taghandler_135.setProperty("containerTypeValues");
                                            __jsp_taghandler_135.setValue("code");
                                            __jsp_tag_starteval=__jsp_taghandler_135.doStartTag();
                                            if (__jsp_taghandler_135.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_135,7);
                                          }
                                          out.write(__oracle_jsp_text[215]);
                                        } while (__jsp_taghandler_134.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                        out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                      }
                                      if (__jsp_taghandler_134.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_134,6);
                                    }
                                    out.write(__oracle_jsp_text[216]);
                                  } while (__jsp_taghandler_133.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_133.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_133,5);
                              }
                              out.write(__oracle_jsp_text[217]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_136=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_136.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_136.setName("cargoDetails");
                                __jsp_taghandler_136.setProperty("dbFlag");
                                __jsp_taghandler_136.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_136.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[218]);
                                    {
                                      org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_137=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                      __jsp_taghandler_137.setParent(__jsp_taghandler_136);
                                      __jsp_taghandler_137.setName("cargoDetails");
                                      __jsp_taghandler_137.setProperty("containerType");
                                      __jsp_tag_starteval=__jsp_taghandler_137.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[219]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_138=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_138.setParent(__jsp_taghandler_137);
                                            __jsp_taghandler_138.setName("cargoDetails");
                                            __jsp_taghandler_138.setProperty("containerType");
                                            __jsp_tag_starteval=__jsp_taghandler_138.doStartTag();
                                            if (__jsp_taghandler_138.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_138,7);
                                          }
                                          out.write(__oracle_jsp_text[220]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_139=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_139.setParent(__jsp_taghandler_137);
                                            __jsp_taghandler_139.setName("cargoDetails");
                                            __jsp_taghandler_139.setProperty("containerType");
                                            __jsp_tag_starteval=__jsp_taghandler_139.doStartTag();
                                            if (__jsp_taghandler_139.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_139,7);
                                          }
                                          out.write(__oracle_jsp_text[221]);
                                        } while (__jsp_taghandler_137.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_137.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_137,6);
                                    }
                                    out.write(__oracle_jsp_text[222]);
                                    {
                                      org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_140=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                      __jsp_taghandler_140.setParent(__jsp_taghandler_136);
                                      __jsp_taghandler_140.setName("cargoDetails");
                                      __jsp_taghandler_140.setProperty("containerType");
                                      __jsp_tag_starteval=__jsp_taghandler_140.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[223]);
                                        } while (__jsp_taghandler_140.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_140.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_140,6);
                                    }
                                    out.write(__oracle_jsp_text[224]);
                                  } while (__jsp_taghandler_136.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_136.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_136,5);
                              }
                              out.write(__oracle_jsp_text[225]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_141=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_141.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_141.setName("cargoDetails");
                                __jsp_taghandler_141.setProperty("carrierSeal");
                                __jsp_tag_starteval=__jsp_taghandler_141.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[226]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_142=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
                                      __jsp_taghandler_142.setParent(__jsp_taghandler_141);
                                      __jsp_taghandler_142.setMaxlength("12");
                                      __jsp_taghandler_142.setName("cargoDetails");
                                      __jsp_taghandler_142.setOnblur("changeUpper(this)");
                                      __jsp_taghandler_142.setProperty("carrierSeal");
                                      __jsp_taghandler_142.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_142.setStyle("width: 70%");
                                      __jsp_taghandler_142.setStyleId("carrierSeal");
                                      __jsp_tag_starteval=__jsp_taghandler_142.doStartTag();
                                      if (__jsp_taghandler_142.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_142,6);
                                    }
                                    out.write(__oracle_jsp_text[227]);
                                  } while (__jsp_taghandler_141.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_141.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_141,5);
                              }
                              out.write(__oracle_jsp_text[228]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_143=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_143.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_143.setName("cargoDetails");
                                __jsp_taghandler_143.setProperty("carrierSeal");
                                __jsp_tag_starteval=__jsp_taghandler_143.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[229]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_144=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId value");
                                      __jsp_taghandler_144.setParent(__jsp_taghandler_143);
                                      __jsp_taghandler_144.setMaxlength("12");
                                      __jsp_taghandler_144.setName("cargoDetails");
                                      __jsp_taghandler_144.setOnblur("changeUpper(this)");
                                      __jsp_taghandler_144.setProperty("carrierSeal");
                                      __jsp_taghandler_144.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_144.setStyle("width:70%");
                                      __jsp_taghandler_144.setStyleId("carrierSeal");
                                      __jsp_taghandler_144.setValue("");
                                      __jsp_tag_starteval=__jsp_taghandler_144.doStartTag();
                                      if (__jsp_taghandler_144.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_144,6);
                                    }
                                    out.write(__oracle_jsp_text[230]);
                                  } while (__jsp_taghandler_143.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_143.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_143,5);
                              }
                              out.write(__oracle_jsp_text[231]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_145=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_145.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_145.setName("cargoDetails");
                                __jsp_taghandler_145.setProperty("shipperSeal");
                                __jsp_tag_starteval=__jsp_taghandler_145.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[232]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_146=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
                                      __jsp_taghandler_146.setParent(__jsp_taghandler_145);
                                      __jsp_taghandler_146.setMaxlength("12");
                                      __jsp_taghandler_146.setName("cargoDetails");
                                      __jsp_taghandler_146.setOnblur("changeUpper(this)");
                                      __jsp_taghandler_146.setProperty("shipperSeal");
                                      __jsp_taghandler_146.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_146.setStyle("width:70%");
                                      __jsp_taghandler_146.setStyleId("shipperSeal");
                                      __jsp_tag_starteval=__jsp_taghandler_146.doStartTag();
                                      if (__jsp_taghandler_146.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_146,6);
                                    }
                                    out.write(__oracle_jsp_text[233]);
                                  } while (__jsp_taghandler_145.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_145.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_145,5);
                              }
                              out.write(__oracle_jsp_text[234]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_147=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_147.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_147.setName("cargoDetails");
                                __jsp_taghandler_147.setProperty("shipperSeal");
                                __jsp_tag_starteval=__jsp_taghandler_147.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[235]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_148=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId value");
                                      __jsp_taghandler_148.setParent(__jsp_taghandler_147);
                                      __jsp_taghandler_148.setMaxlength("12");
                                      __jsp_taghandler_148.setName("cargoDetails");
                                      __jsp_taghandler_148.setOnblur("changeUpper(this)");
                                      __jsp_taghandler_148.setProperty("shipperSeal");
                                      __jsp_taghandler_148.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_148.setStyle("width:70%");
                                      __jsp_taghandler_148.setStyleId("shipperSeal");
                                      __jsp_taghandler_148.setValue("");
                                      __jsp_tag_starteval=__jsp_taghandler_148.doStartTag();
                                      if (__jsp_taghandler_148.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_148,6);
                                    }
                                    out.write(__oracle_jsp_text[236]);
                                  } while (__jsp_taghandler_147.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_147.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_147,5);
                              }
                              out.write(__oracle_jsp_text[237]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_149=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_149.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_149.setName("cargoDetails");
                                __jsp_taghandler_149.setProperty("containerNo");
                                __jsp_tag_starteval=__jsp_taghandler_149.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[238]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_150=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onclick property readonly style styleClass styleId");
                                      __jsp_taghandler_150.setParent(__jsp_taghandler_149);
                                      __jsp_taghandler_150.setMaxlength("6");
                                      __jsp_taghandler_150.setName("cargoDetails");
                                      __jsp_taghandler_150.setOnblur("maskWithOutDecimal(this, 6, 2)");
                                      __jsp_taghandler_150.setOnchange("onChangeEquipmentToCommodity(false);");
                                      __jsp_taghandler_150.setOnclick("hideMask_Number(this);");
                                      __jsp_taghandler_150.setProperty("ofPackages");
                                      __jsp_taghandler_150.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_150.setStyle("width: 42%");
                                      __jsp_taghandler_150.setStyleClass("must");
                                      __jsp_taghandler_150.setStyleId("ofPackages");
                                      __jsp_tag_starteval=__jsp_taghandler_150.doStartTag();
                                      if (__jsp_taghandler_150.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_150,6);
                                    }
                                    out.write(__oracle_jsp_text[239]);
                                  } while (__jsp_taghandler_149.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_149.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_149,5);
                              }
                              out.write(__oracle_jsp_text[240]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_151=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_151.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_151.setName("cargoDetails");
                                __jsp_taghandler_151.setProperty("containerNo");
                                __jsp_tag_starteval=__jsp_taghandler_151.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[241]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_152=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onclick property readonly style styleId");
                                      __jsp_taghandler_152.setParent(__jsp_taghandler_151);
                                      __jsp_taghandler_152.setMaxlength("6");
                                      __jsp_taghandler_152.setName("cargoDetails");
                                      __jsp_taghandler_152.setOnblur("maskWithOutDecimal(this, 6, 2)");
                                      __jsp_taghandler_152.setOnchange("onChangeEquipmentToCommodity(false);");
                                      __jsp_taghandler_152.setOnclick("hideMask_Number(this);");
                                      __jsp_taghandler_152.setProperty("ofPackages");
                                      __jsp_taghandler_152.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_152.setStyle("width: 42%");
                                      __jsp_taghandler_152.setStyleId("ofPackages");
                                      __jsp_tag_starteval=__jsp_taghandler_152.doStartTag();
                                      if (__jsp_taghandler_152.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_152,6);
                                    }
                                    out.write(__oracle_jsp_text[242]);
                                  } while (__jsp_taghandler_151.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_151.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_151,5);
                              }
                              out.write(__oracle_jsp_text[243]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_153=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                                __jsp_taghandler_153.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_153.setName("rowCargoDetailsId");
                                __jsp_taghandler_153.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_153.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[244]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[245]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[246]);
                                  } while (__jsp_taghandler_153.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_153.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_153,5);
                              }
                              out.write(__oracle_jsp_text[247]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_154=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_154.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_154.setName("cargoDetails");
                                __jsp_taghandler_154.setProperty("packagesKindCode");
                                __jsp_tag_starteval=__jsp_taghandler_154.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[248]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_155=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_155.setParent(__jsp_taghandler_154);
                                      __jsp_taghandler_155.setName("cargoDetails");
                                      __jsp_taghandler_155.setProperty("packagesKindCode");
                                      __jsp_tag_starteval=__jsp_taghandler_155.doStartTag();
                                      if (__jsp_taghandler_155.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_155,6);
                                    }
                                    out.write(__oracle_jsp_text[249]);
                                  } while (__jsp_taghandler_154.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_154.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_154,5);
                              }
                              out.write(__oracle_jsp_text[250]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_156=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_156.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_156.setName("cargoDetails");
                                __jsp_taghandler_156.setProperty("packagesKindCode");
                                __jsp_tag_starteval=__jsp_taghandler_156.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[251]);
                                  } while (__jsp_taghandler_156.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_156.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_156,5);
                              }
                              out.write(__oracle_jsp_text[252]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_157=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_157.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_157.setName("objFormSession");
                                __jsp_taghandler_157.setProperty("esiStatusCode");
                                __jsp_taghandler_157.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                                __jsp_tag_starteval=__jsp_taghandler_157.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[253]);
                                    {
                                      org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_158=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                      __jsp_taghandler_158.setParent(__jsp_taghandler_157);
                                      __jsp_taghandler_158.setName("cargoDetails");
                                      __jsp_taghandler_158.setProperty("containerNo");
                                      __jsp_tag_starteval=__jsp_taghandler_158.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[254]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_159=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly style styleClass styleId");
                                            __jsp_taghandler_159.setParent(__jsp_taghandler_158);
                                            __jsp_taghandler_159.setName("cargoDetails");
                                            __jsp_taghandler_159.setProperty("packagesKind");
                                            __jsp_taghandler_159.setReadonly(true);
                                            __jsp_taghandler_159.setStyle("width: 54%");
                                            __jsp_taghandler_159.setStyleClass("must");
                                            __jsp_taghandler_159.setStyleId("packagesKind");
                                            __jsp_tag_starteval=__jsp_taghandler_159.doStartTag();
                                            if (__jsp_taghandler_159.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_159,7);
                                          }
                                          out.write(__oracle_jsp_text[255]);
                                        } while (__jsp_taghandler_158.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_158.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_158,6);
                                    }
                                    out.write(__oracle_jsp_text[256]);
                                    {
                                      org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_160=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                      __jsp_taghandler_160.setParent(__jsp_taghandler_157);
                                      __jsp_taghandler_160.setName("cargoDetails");
                                      __jsp_taghandler_160.setProperty("containerNo");
                                      __jsp_tag_starteval=__jsp_taghandler_160.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[257]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_161=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly style styleId");
                                            __jsp_taghandler_161.setParent(__jsp_taghandler_160);
                                            __jsp_taghandler_161.setName("cargoDetails");
                                            __jsp_taghandler_161.setProperty("packagesKind");
                                            __jsp_taghandler_161.setReadonly(true);
                                            __jsp_taghandler_161.setStyle("width: 54%");
                                            __jsp_taghandler_161.setStyleId("packagesKind");
                                            __jsp_tag_starteval=__jsp_taghandler_161.doStartTag();
                                            if (__jsp_taghandler_161.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_161,7);
                                          }
                                          out.write(__oracle_jsp_text[258]);
                                        } while (__jsp_taghandler_160.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_160.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_160,6);
                                    }
                                    out.write(__oracle_jsp_text[259]);
                                  } while (__jsp_taghandler_157.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_157.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_157,5);
                              }
                              out.write(__oracle_jsp_text[260]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_162=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_162.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_162.setName("objFormSession");
                                __jsp_taghandler_162.setProperty("esiStatusCode");
                                __jsp_taghandler_162.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                                __jsp_tag_starteval=__jsp_taghandler_162.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[261]);
                                    {
                                      org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_163=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                      __jsp_taghandler_163.setParent(__jsp_taghandler_162);
                                      __jsp_taghandler_163.setName("cargoDetails");
                                      __jsp_taghandler_163.setProperty("packagesKind");
                                      __jsp_tag_starteval=__jsp_taghandler_163.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[262]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_164=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_164.setParent(__jsp_taghandler_163);
                                            __jsp_taghandler_164.setName("cargoDetails");
                                            __jsp_taghandler_164.setProperty("packagesKind");
                                            __jsp_tag_starteval=__jsp_taghandler_164.doStartTag();
                                            if (__jsp_taghandler_164.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_164,7);
                                          }
                                          out.write(__oracle_jsp_text[263]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_165=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_165.setParent(__jsp_taghandler_163);
                                            __jsp_taghandler_165.setName("cargoDetails");
                                            __jsp_taghandler_165.setProperty("packagesKind");
                                            __jsp_tag_starteval=__jsp_taghandler_165.doStartTag();
                                            if (__jsp_taghandler_165.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_165,7);
                                          }
                                          out.write(__oracle_jsp_text[264]);
                                        } while (__jsp_taghandler_163.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_163.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_163,6);
                                    }
                                    out.write(__oracle_jsp_text[265]);
                                    {
                                      org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_166=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                      __jsp_taghandler_166.setParent(__jsp_taghandler_162);
                                      __jsp_taghandler_166.setName("cargoDetails");
                                      __jsp_taghandler_166.setProperty("packagesKind");
                                      __jsp_tag_starteval=__jsp_taghandler_166.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[266]);
                                        } while (__jsp_taghandler_166.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_166.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_166,6);
                                    }
                                    out.write(__oracle_jsp_text[267]);
                                  } while (__jsp_taghandler_162.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_162.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_162,5);
                              }
                              out.write(__oracle_jsp_text[268]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_167=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_167.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_167.setName("cargoDetails");
                                __jsp_taghandler_167.setProperty("packagesKind");
                                __jsp_tag_starteval=__jsp_taghandler_167.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[269]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_168=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_168.setParent(__jsp_taghandler_167);
                                      __jsp_taghandler_168.setName("cargoDetails");
                                      __jsp_taghandler_168.setProperty("packagesKind");
                                      __jsp_tag_starteval=__jsp_taghandler_168.doStartTag();
                                      if (__jsp_taghandler_168.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_168,6);
                                    }
                                    out.write(__oracle_jsp_text[270]);
                                  } while (__jsp_taghandler_167.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_167.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_167,5);
                              }
                              out.write(__oracle_jsp_text[271]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_169=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_169.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_169.setName("cargoDetails");
                                __jsp_taghandler_169.setProperty("packagesKind");
                                __jsp_tag_starteval=__jsp_taghandler_169.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[272]);
                                  } while (__jsp_taghandler_169.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_169.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_169,5);
                              }
                              out.write(__oracle_jsp_text[273]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_170=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                                __jsp_taghandler_170.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_170.setName("rowCargoDetailsId");
                                __jsp_taghandler_170.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_170.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[274]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[275]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[276]);
                                  } while (__jsp_taghandler_170.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_170.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_170,5);
                              }
                              out.write(__oracle_jsp_text[277]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_171=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_171.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_171.setName("cargoDetails");
                                __jsp_taghandler_171.setProperty("containerNo");
                                __jsp_tag_starteval=__jsp_taghandler_171.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[278]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_172=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onclick property readonly style styleClass styleId");
                                      __jsp_taghandler_172.setParent(__jsp_taghandler_171);
                                      __jsp_taghandler_172.setMaxlength("19");
                                      __jsp_taghandler_172.setName("cargoDetails");
                                      __jsp_taghandler_172.setOnblur("putMask_NumberEX(this, 15, 3)");
                                      __jsp_taghandler_172.setOnchange("putMask_NumberEX(this, 15, 3);onChangeEquipmentToCommodity(false);");
                                      __jsp_taghandler_172.setOnclick("hideMask_Number(this);");
                                      __jsp_taghandler_172.setProperty("grossContainerWeight");
                                      __jsp_taghandler_172.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_172.setStyle("width: 57%");
                                      __jsp_taghandler_172.setStyleClass("must");
                                      __jsp_taghandler_172.setStyleId("grossContainerWeight");
                                      __jsp_tag_starteval=__jsp_taghandler_172.doStartTag();
                                      if (__jsp_taghandler_172.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_172,6);
                                    }
                                    out.write(__oracle_jsp_text[279]);
                                  } while (__jsp_taghandler_171.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_171.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_171,5);
                              }
                              out.write(__oracle_jsp_text[280]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_173=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_173.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_173.setName("cargoDetails");
                                __jsp_taghandler_173.setProperty("containerNo");
                                __jsp_tag_starteval=__jsp_taghandler_173.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[281]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_174=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onclick property readonly style styleId");
                                      __jsp_taghandler_174.setParent(__jsp_taghandler_173);
                                      __jsp_taghandler_174.setMaxlength("19");
                                      __jsp_taghandler_174.setName("cargoDetails");
                                      __jsp_taghandler_174.setOnblur("putMask_NumberEX(this, 15, 3)");
                                      __jsp_taghandler_174.setOnchange("putMask_NumberEX(this, 15, 3);onChangeEquipmentToCommodity(false);");
                                      __jsp_taghandler_174.setOnclick("hideMask_Number(this);");
                                      __jsp_taghandler_174.setProperty("grossContainerWeight");
                                      __jsp_taghandler_174.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_174.setStyle("width: 57%");
                                      __jsp_taghandler_174.setStyleId("grossContainerWeight");
                                      __jsp_tag_starteval=__jsp_taghandler_174.doStartTag();
                                      if (__jsp_taghandler_174.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_174,6);
                                    }
                                    out.write(__oracle_jsp_text[282]);
                                  } while (__jsp_taghandler_173.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_173.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_173,5);
                              }
                              out.write(__oracle_jsp_text[283]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_175=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                                __jsp_taghandler_175.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_175.setName("rowCargoDetailsId");
                                __jsp_taghandler_175.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_175.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[284]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[285]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[286]);
                                  } while (__jsp_taghandler_175.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_175.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_175,5);
                              }
                              out.write(__oracle_jsp_text[287]);
                              out.print(((rowCargoDetailsId+1)%2==0)?"rowEvenColor":"rowOddColor");
                              out.write(__oracle_jsp_text[288]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_176=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_176.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_176.setName("objFormSession");
                                __jsp_taghandler_176.setProperty("esiStatusCode");
                                __jsp_taghandler_176.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                                __jsp_tag_starteval=__jsp_taghandler_176.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[289]);
                                    {
                                      org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_177=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                      __jsp_taghandler_177.setParent(__jsp_taghandler_176);
                                      __jsp_taghandler_177.setName("cargoDetails");
                                      __jsp_taghandler_177.setProperty("commodityValues");
                                      __jsp_tag_starteval=__jsp_taghandler_177.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[290]);
                                          {
                                            org.apache.struts.taglib.html.SelectTag __jsp_taghandler_178=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleId");
                                            __jsp_taghandler_178.setParent(__jsp_taghandler_177);
                                            __jsp_taghandler_178.setName("cargoDetails");
                                            __jsp_taghandler_178.setOnchange("onChangeEquipmentToCommodity(true);");
                                            __jsp_taghandler_178.setProperty("commodity");
                                            __jsp_taghandler_178.setStyle("width: 81%;height:20px;");
                                            __jsp_taghandler_178.setStyleId("commodity");
                                            __jsp_tag_starteval=__jsp_taghandler_178.doStartTag();
                                            if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                            {
                                              out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_178,__jsp_tag_starteval,out);
                                              do {
                                                out.write(__oracle_jsp_text[291]);
                                                {
                                                  org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_179=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property");
                                                  __jsp_taghandler_179.setParent(__jsp_taghandler_178);
                                                  __jsp_taghandler_179.setId("commodityValue");
                                                  __jsp_taghandler_179.setName("cargoDetails");
                                                  __jsp_taghandler_179.setProperty("commodityValues");
                                                  java.lang.Object commodityValue = null;
                                                  __jsp_tag_starteval=__jsp_taghandler_179.doStartTag();
                                                  if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                                  {
                                                    out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_179,__jsp_tag_starteval,out);
                                                    do {
                                                      commodityValue = (java.lang.Object) pageContext.findAttribute("commodityValue");
                                                      out.write(__oracle_jsp_text[292]);
                                                      {
                                                        org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_180=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                                        __jsp_taghandler_180.setParent(__jsp_taghandler_179);
                                                        __jsp_taghandler_180.setName("commodityValue");
                                                        __jsp_taghandler_180.setProperty("code");
                                                        __jsp_taghandler_180.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${cargoDetails.commodity}",java.lang.String.class, __ojsp_varRes,null));
                                                        __jsp_tag_starteval=__jsp_taghandler_180.doStartTag();
                                                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                        {
                                                          do {
                                                            out.write(__oracle_jsp_text[293]);
                                                            {
                                                              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_181=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                                              __jsp_taghandler_181.setParent(__jsp_taghandler_180);
                                                              __jsp_taghandler_181.setName("commodityValue");
                                                              __jsp_taghandler_181.setProperty("code");
                                                              __jsp_tag_starteval=__jsp_taghandler_181.doStartTag();
                                                              if (__jsp_taghandler_181.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                return;
                                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_181,10);
                                                            }
                                                            out.write(__oracle_jsp_text[294]);
                                                            {
                                                              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_182=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                                              __jsp_taghandler_182.setParent(__jsp_taghandler_180);
                                                              __jsp_taghandler_182.setName("commodityValue");
                                                              __jsp_taghandler_182.setProperty("name");
                                                              __jsp_tag_starteval=__jsp_taghandler_182.doStartTag();
                                                              if (__jsp_taghandler_182.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                return;
                                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_182,10);
                                                            }
                                                            out.write(__oracle_jsp_text[295]);
                                                          } while (__jsp_taghandler_180.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                        }
                                                        if (__jsp_taghandler_180.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_180,9);
                                                      }
                                                      out.write(__oracle_jsp_text[296]);
                                                      {
                                                        org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_183=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                                        __jsp_taghandler_183.setParent(__jsp_taghandler_179);
                                                        __jsp_taghandler_183.setName("commodityValue");
                                                        __jsp_taghandler_183.setProperty("code");
                                                        __jsp_taghandler_183.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${cargoDetails.commodity}",java.lang.String.class, __ojsp_varRes,null));
                                                        __jsp_tag_starteval=__jsp_taghandler_183.doStartTag();
                                                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                        {
                                                          do {
                                                            out.write(__oracle_jsp_text[297]);
                                                            {
                                                              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_184=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                                              __jsp_taghandler_184.setParent(__jsp_taghandler_183);
                                                              __jsp_taghandler_184.setName("commodityValue");
                                                              __jsp_taghandler_184.setProperty("code");
                                                              __jsp_tag_starteval=__jsp_taghandler_184.doStartTag();
                                                              if (__jsp_taghandler_184.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                return;
                                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_184,10);
                                                            }
                                                            out.write(__oracle_jsp_text[298]);
                                                            {
                                                              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_185=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                                              __jsp_taghandler_185.setParent(__jsp_taghandler_183);
                                                              __jsp_taghandler_185.setName("commodityValue");
                                                              __jsp_taghandler_185.setProperty("name");
                                                              __jsp_tag_starteval=__jsp_taghandler_185.doStartTag();
                                                              if (__jsp_taghandler_185.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                return;
                                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_185,10);
                                                            }
                                                            out.write(__oracle_jsp_text[299]);
                                                          } while (__jsp_taghandler_183.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                        }
                                                        if (__jsp_taghandler_183.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_183,9);
                                                      }
                                                      out.write(__oracle_jsp_text[300]);
                                                    } while (__jsp_taghandler_179.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                    out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                                  }
                                                  if (__jsp_taghandler_179.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_179,8);
                                                }
                                                out.write(__oracle_jsp_text[301]);
                                              } while (__jsp_taghandler_178.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                              out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                            }
                                            if (__jsp_taghandler_178.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_178,7);
                                          }
                                          out.write(__oracle_jsp_text[302]);
                                        } while (__jsp_taghandler_177.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_177.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_177,6);
                                    }
                                    out.write(__oracle_jsp_text[303]);
                                  } while (__jsp_taghandler_176.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_176.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_176,5);
                              }
                              out.write(__oracle_jsp_text[304]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_186=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_186.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_186.setName("objFormSession");
                                __jsp_taghandler_186.setProperty("esiStatusCode");
                                __jsp_taghandler_186.setValue(OracleJspRuntime.toStr( EshippingInstructionDao.ESI_STATUS.SUBMITTED));
                                __jsp_tag_starteval=__jsp_taghandler_186.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[305]);
                                    {
                                      org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_187=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                      __jsp_taghandler_187.setParent(__jsp_taghandler_186);
                                      __jsp_taghandler_187.setName("cargoDetails");
                                      __jsp_taghandler_187.setProperty("commodity");
                                      __jsp_tag_starteval=__jsp_taghandler_187.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[306]);
                                          {
                                            org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_188=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                            __jsp_taghandler_188.setParent(__jsp_taghandler_187);
                                            __jsp_taghandler_188.setName("cargoDetails");
                                            __jsp_taghandler_188.setProperty("commodity");
                                            __jsp_taghandler_188.setValue("");
                                            __jsp_tag_starteval=__jsp_taghandler_188.doStartTag();
                                            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                            {
                                              do {
                                                out.write(__oracle_jsp_text[307]);
                                                {
                                                  org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_189=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                                  __jsp_taghandler_189.setParent(__jsp_taghandler_188);
                                                  __jsp_taghandler_189.setName("cargoDetails");
                                                  __jsp_taghandler_189.setProperty("commodity");
                                                  __jsp_taghandler_189.setValue("0");
                                                  __jsp_tag_starteval=__jsp_taghandler_189.doStartTag();
                                                  if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                  {
                                                    do {
                                                      out.write(__oracle_jsp_text[308]);
                                                      {
                                                        org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_190=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                                        __jsp_taghandler_190.setParent(__jsp_taghandler_189);
                                                        __jsp_taghandler_190.setName("cargoDetails");
                                                        __jsp_taghandler_190.setProperty("strCommodityName");
                                                        __jsp_tag_starteval=__jsp_taghandler_190.doStartTag();
                                                        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                                        {
                                                          do {
                                                            out.write(__oracle_jsp_text[309]);
                                                            {
                                                              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_191=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                                              __jsp_taghandler_191.setParent(__jsp_taghandler_190);
                                                              __jsp_taghandler_191.setName("cargoDetails");
                                                              __jsp_taghandler_191.setProperty("strCommodityName");
                                                              __jsp_tag_starteval=__jsp_taghandler_191.doStartTag();
                                                              if (__jsp_taghandler_191.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                                return;
                                                              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_191,10);
                                                            }
                                                            out.write(__oracle_jsp_text[310]);
                                                          } while (__jsp_taghandler_190.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                        }
                                                        if (__jsp_taghandler_190.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                          return;
                                                        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_190,9);
                                                      }
                                                      out.write(__oracle_jsp_text[311]);
                                                    } while (__jsp_taghandler_189.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                                  }
                                                  if (__jsp_taghandler_189.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                                    return;
                                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_189,8);
                                                }
                                                out.write(__oracle_jsp_text[312]);
                                              } while (__jsp_taghandler_188.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                            }
                                            if (__jsp_taghandler_188.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_188,7);
                                          }
                                          out.write(__oracle_jsp_text[313]);
                                        } while (__jsp_taghandler_187.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_187.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_187,6);
                                    }
                                    out.write(__oracle_jsp_text[314]);
                                  } while (__jsp_taghandler_186.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_186.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_186,5);
                              }
                              out.write(__oracle_jsp_text[315]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_192=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_192.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_192.setName("objFormSession");
                                __jsp_taghandler_192.setProperty("esiStatusCode");
                                __jsp_taghandler_192.setValue("");
                                __jsp_tag_starteval=__jsp_taghandler_192.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[316]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_193=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                                      __jsp_taghandler_193.setParent(__jsp_taghandler_192);
                                      __jsp_taghandler_193.setName("cargoDetails");
                                      __jsp_taghandler_193.setProperty("commodity");
                                      __jsp_taghandler_193.setStyleId("commodity");
                                      __jsp_tag_starteval=__jsp_taghandler_193.doStartTag();
                                      if (__jsp_taghandler_193.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_193,6);
                                    }
                                    out.write(__oracle_jsp_text[317]);
                                  } while (__jsp_taghandler_192.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_192.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_192,5);
                              }
                              out.write(__oracle_jsp_text[318]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_194=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_194.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_194.setName("cargoDetails");
                                __jsp_taghandler_194.setProperty("dbFlag");
                                __jsp_taghandler_194.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_194.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[319]);
                                    {
                                      org.apache.struts.taglib.html.SelectTag __jsp_taghandler_195=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag disabled name property style styleId");
                                      __jsp_taghandler_195.setParent(__jsp_taghandler_194);
                                      __jsp_taghandler_195.setDisabled(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_195.setName("cargoDetails");
                                      __jsp_taghandler_195.setProperty("ladenMt");
                                      __jsp_taghandler_195.setStyle("width: 90%; height:20px;");
                                      __jsp_taghandler_195.setStyleId("ladenMt");
                                      __jsp_tag_starteval=__jsp_taghandler_195.doStartTag();
                                      if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                      {
                                        out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_195,__jsp_tag_starteval,out);
                                        do {
                                          out.write(__oracle_jsp_text[320]);
                                          {
                                            org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_196=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                            __jsp_taghandler_196.setParent(__jsp_taghandler_195);
                                            __jsp_taghandler_196.setLabel("name");
                                            __jsp_taghandler_196.setName("cargoDetails");
                                            __jsp_taghandler_196.setProperty("ladenMtValues");
                                            __jsp_taghandler_196.setValue("code");
                                            __jsp_tag_starteval=__jsp_taghandler_196.doStartTag();
                                            if (__jsp_taghandler_196.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_196,7);
                                          }
                                          out.write(__oracle_jsp_text[321]);
                                        } while (__jsp_taghandler_195.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                        out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                      }
                                      if (__jsp_taghandler_195.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_195,6);
                                    }
                                    out.write(__oracle_jsp_text[322]);
                                  } while (__jsp_taghandler_194.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_194.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_194,5);
                              }
                              out.write(__oracle_jsp_text[323]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_197=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_197.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_197.setName("cargoDetails");
                                __jsp_taghandler_197.setProperty("dbFlag");
                                __jsp_taghandler_197.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_197.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[324]);
                                    {
                                      org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_198=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                      __jsp_taghandler_198.setParent(__jsp_taghandler_197);
                                      __jsp_taghandler_198.setName("cargoDetails");
                                      __jsp_taghandler_198.setProperty("ladenMt");
                                      __jsp_tag_starteval=__jsp_taghandler_198.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[325]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_199=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_199.setParent(__jsp_taghandler_198);
                                            __jsp_taghandler_199.setName("cargoDetails");
                                            __jsp_taghandler_199.setProperty("ladenMt");
                                            __jsp_tag_starteval=__jsp_taghandler_199.doStartTag();
                                            if (__jsp_taghandler_199.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_199,7);
                                          }
                                          out.write(__oracle_jsp_text[326]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_200=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_200.setParent(__jsp_taghandler_198);
                                            __jsp_taghandler_200.setName("cargoDetails");
                                            __jsp_taghandler_200.setProperty("ladenMt");
                                            __jsp_tag_starteval=__jsp_taghandler_200.doStartTag();
                                            if (__jsp_taghandler_200.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_200,7);
                                          }
                                          out.write(__oracle_jsp_text[327]);
                                        } while (__jsp_taghandler_198.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_198.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_198,6);
                                    }
                                    out.write(__oracle_jsp_text[328]);
                                    {
                                      org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_201=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                      __jsp_taghandler_201.setParent(__jsp_taghandler_197);
                                      __jsp_taghandler_201.setName("cargoDetails");
                                      __jsp_taghandler_201.setProperty("ladenMt");
                                      __jsp_tag_starteval=__jsp_taghandler_201.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[329]);
                                        } while (__jsp_taghandler_201.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_201.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_201,6);
                                    }
                                    out.write(__oracle_jsp_text[330]);
                                  } while (__jsp_taghandler_197.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_197.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_197,5);
                              }
                              out.write(__oracle_jsp_text[331]);
                              {
                                org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_202=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                                __jsp_taghandler_202.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_202.setName("cargoDetails");
                                __jsp_taghandler_202.setProperty("grossCargoMeasurement");
                                __jsp_tag_starteval=__jsp_taghandler_202.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[332]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_203=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onclick property readonly style styleId");
                                      __jsp_taghandler_203.setParent(__jsp_taghandler_202);
                                      __jsp_taghandler_203.setMaxlength("19");
                                      __jsp_taghandler_203.setName("cargoDetails");
                                      __jsp_taghandler_203.setOnblur("putMask_NumberEX(this, 14, 4)");
                                      __jsp_taghandler_203.setOnchange("onChangeEquipmentToCommodity(false);");
                                      __jsp_taghandler_203.setOnclick("hideMask_Number(this);");
                                      __jsp_taghandler_203.setProperty("grossCargoMeasurement");
                                      __jsp_taghandler_203.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_203.setStyle("width:57%");
                                      __jsp_taghandler_203.setStyleId("grossCargoMeasurement");
                                      __jsp_tag_starteval=__jsp_taghandler_203.doStartTag();
                                      if (__jsp_taghandler_203.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_203,6);
                                    }
                                    out.write(__oracle_jsp_text[333]);
                                  } while (__jsp_taghandler_202.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_202.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_202,5);
                              }
                              out.write(__oracle_jsp_text[334]);
                              {
                                org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_204=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                                __jsp_taghandler_204.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_204.setName("cargoDetails");
                                __jsp_taghandler_204.setProperty("grossCargoMeasurement");
                                __jsp_tag_starteval=__jsp_taghandler_204.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[335]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_205=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange onclick property readonly style styleId value");
                                      __jsp_taghandler_205.setParent(__jsp_taghandler_204);
                                      __jsp_taghandler_205.setMaxlength("19");
                                      __jsp_taghandler_205.setName("cargoDetails");
                                      __jsp_taghandler_205.setOnblur("putMask_NumberEX(this, 14, 4)");
                                      __jsp_taghandler_205.setOnchange("onChangeEquipmentToCommodity(false);");
                                      __jsp_taghandler_205.setOnclick("hideMask_Number(this);");
                                      __jsp_taghandler_205.setProperty("grossCargoMeasurement");
                                      __jsp_taghandler_205.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
                                      __jsp_taghandler_205.setStyle("width:57%");
                                      __jsp_taghandler_205.setStyleId("grossCargoMeasurement");
                                      __jsp_taghandler_205.setValue("");
                                      __jsp_tag_starteval=__jsp_taghandler_205.doStartTag();
                                      if (__jsp_taghandler_205.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_205,6);
                                    }
                                    out.write(__oracle_jsp_text[336]);
                                  } while (__jsp_taghandler_204.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_204.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_204,5);
                              }
                              out.write(__oracle_jsp_text[337]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_206=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                                __jsp_taghandler_206.setParent(__jsp_taghandler_109);
                                __jsp_taghandler_206.setName("rowCargoDetailsId");
                                __jsp_taghandler_206.setValue("0");
                                __jsp_tag_starteval=__jsp_taghandler_206.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[338]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[339]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCargoDetailsId}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[340]);
                                  } while (__jsp_taghandler_206.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_206.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_206,5);
                              }
                              out.write(__oracle_jsp_text[341]);
                            } while (__jsp_taghandler_109.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_109.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_109,4);
                        }
                        out.write(__oracle_jsp_text[342]);
                      } while (__jsp_taghandler_107.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_107.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_107,3);
                  }
                  out.write(__oracle_jsp_text[343]);
                } while (__jsp_taghandler_105.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_105.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_105,2);
            }
            out.write(__oracle_jsp_text[344]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_207=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleId");
              __jsp_taghandler_207.setParent(__jsp_taghandler_1);
              __jsp_taghandler_207.setMaxlength("2");
              __jsp_taghandler_207.setName("feserv06");
              __jsp_taghandler_207.setOnblur("maskWithOutDecimal(this, 2, 2)");
              __jsp_taghandler_207.setProperty("noOfOriginal");
              __jsp_taghandler_207.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_207.setStyle("width:30%; height:17px;");
              __jsp_taghandler_207.setStyleId("noOfOriginal");
              __jsp_tag_starteval=__jsp_taghandler_207.doStartTag();
              if (__jsp_taghandler_207.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_207,2);
            }
            out.write(__oracle_jsp_text[345]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_208=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name property readonly rows styleId");
              __jsp_taghandler_208.setParent(__jsp_taghandler_1);
              __jsp_taghandler_208.setCols("85");
              __jsp_taghandler_208.setName("feserv06");
              __jsp_taghandler_208.setProperty("remarks");
              __jsp_taghandler_208.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isReadOnly}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_taghandler_208.setRows("7");
              __jsp_taghandler_208.setStyleId("remarks");
              __jsp_tag_starteval=__jsp_taghandler_208.doStartTag();
              if (__jsp_taghandler_208.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_208,2);
            }
            out.write(__oracle_jsp_text[346]);
            out.write(__oracle_jsp_text[347]);
            out.write(__oracle_jsp_text[348]);
            {
              org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_209=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name scope");
              __jsp_taghandler_209.setParent(__jsp_taghandler_1);
              __jsp_taghandler_209.setName("btnSubmitEsiDisp");
              __jsp_taghandler_209.setScope("request");
              __jsp_tag_starteval=__jsp_taghandler_209.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[349]);
                } while (__jsp_taghandler_209.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_209.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_209,2);
            }
            out.write(__oracle_jsp_text[350]);
            out.write(__oracle_jsp_text[351]);
            {
              String __url=OracleJspRuntime.toStr("../eshipping/EshippingCargoDescriptionPopup.jsp");
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[352]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[353]);

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
  private static final char __oracle_jsp_text[][]=new char[354][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n<head>\r\n<script type=\"text/javascript\">\r\n  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\r\n  ga('create', 'UA-39255240-1', 'rclgroup.com');\r\n  ga('send', 'pageview');\r\n</script>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/js/screen/EshippingInstruction.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n    var INPUT_CARGO_DESCRIPTION                     = '".toCharArray();
    __oracle_jsp_text[15] = 
    "';\r\n    var GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE        = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\r\n//    var BROWSE_CUSTOMER_DATA = '".toCharArray();
    __oracle_jsp_text[17] = 
    "';\r\n    var BROWSE_CUSTOMER_DATA                        = '".toCharArray();
    __oracle_jsp_text[18] = 
    "';\r\n//    var BROWSE_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[19] = 
    "';\r\n    var BROWSE_BOOKING_NUMBER                       = '".toCharArray();
    __oracle_jsp_text[20] = 
    "';\r\n//    var BROWSE_PACKGAE_KIND_DATA = '".toCharArray();
    __oracle_jsp_text[21] = 
    "';\r\n    var BROWSE_PACKGAE_KIND_DATA                    = '".toCharArray();
    __oracle_jsp_text[22] = 
    "';\r\n    var PRIVIEW_PDF_REPORT                          = '".toCharArray();
    __oracle_jsp_text[23] = 
    "';\r\n    var SAVE_AS_DRAFT                               = '".toCharArray();
    __oracle_jsp_text[24] = 
    "';\r\n    var SUBMIT_ESI                                  = '".toCharArray();
    __oracle_jsp_text[25] = 
    "';\r\n    var OPEN_ACKNOWLEDGEMENT                        = '".toCharArray();
    __oracle_jsp_text[26] = 
    "';\r\n    //##02 BEGIN\r\n    var BROWSE_COMMODITY                            = '".toCharArray();
    __oracle_jsp_text[27] = 
    "';\r\n//    var BROWSE_COMMODITY = '".toCharArray();
    __oracle_jsp_text[28] = 
    "';\r\n    var SET_COMMODITY_DATA                          = '".toCharArray();
    __oracle_jsp_text[29] = 
    "';\r\n    var DEL_COMMODITY_DATA                          = '".toCharArray();
    __oracle_jsp_text[30] = 
    "';\r\n    var ADD_COMMODITY_DATA                          = '".toCharArray();
    __oracle_jsp_text[31] = 
    "';\r\n    //##02 END\r\n    //##03 BEGIN\r\n    var CHECK_DUPLICATE_CONTAINER_NO                = '".toCharArray();
    __oracle_jsp_text[32] = 
    "';\r\n    //##03 END        \r\n    //@04 BEGIN\r\n    var NEW_MODE                                    = '".toCharArray();
    __oracle_jsp_text[33] = 
    "';\r\n    var IN_PROGRESS_MODE                            = '".toCharArray();
    __oracle_jsp_text[34] = 
    "';\r\n    var SUBMITTED_MODE                              = '".toCharArray();
    __oracle_jsp_text[35] = 
    "';\r\n//    var NEW_MODE = \"NEW\";\r\n//    var IN_PROGRESS_MODE = \"IN PROGRESS\";\r\n//    var SUBMITTED_MODE = \"ESI SUBMITTED\";\r\n    var SUBMITTED_AFTER_MODE                        = \"SUBMITTED_AFTER_MODE\";\r\n    //@04 END\r\n\r\n    var contextPath                                 = '".toCharArray();
    __oracle_jsp_text[36] = 
    "';\r\n</script>     \r\n</head>\r\n\r\n<body>    \r\n".toCharArray();
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
    "\r\n    ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n    <input type=\"hidden\" name=\"itemNo\" id=\"itemNo\"/>\r\n    <input type=\"hidden\" name=\"fieldName\" id=\"fieldName\"/>\r\n    <input type=\"hidden\" name=\"fieldAdd1\" id=\"fieldAdd1\"/>\r\n    <input type=\"hidden\" name=\"fieldAdd2\" id=\"fieldAdd2\"/>\r\n    <input type=\"hidden\" name=\"fieldAdd3\" id=\"fieldAdd3\"/>\r\n    <input type=\"hidden\" name=\"fieldAdd4\" id=\"fieldAdd4\"/>\r\n    <input type=\"hidden\" name=\"rowSelected\" id=\"rowSelected\"/>\r\n    <input type=\"hidden\" name=\"shipperNameCountryCode\" id=\"shipperNameCountryCode\"/>\r\n    <input type=\"hidden\" name=\"consigneeNameCountryCode\" id=\"consigneeNameCountryCode\"/>\r\n    <input type=\"hidden\" name=\"notifyPartyNameCountryCode\" id=\"notifyPartyNameCountryCode\"/>\r\n    ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[58] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[60] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[61] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[62] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[66] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n    \r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 1024px\">\r\n    <tr>\r\n        <td width=\"100%\" style=\"min-width: 1024px\">\r\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                <div class=\"TableLeftSubColor2\" style=\"width: 100%; min-width: 1024px\">\r\n                    <h2>B/L Type Details </h2>\r\n                </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                        <td width=\"15%\" style=\"min-width: 150px\" class=\"lableBackground\" height=\"18px\">\r\n                            One Booking One BL\r\n                        </td>\r\n                        <td width=\"18%\" style=\"min-width: 191px\" class=\"whitebg\" valign=\"middle\">\r\n                            ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n                        </td>\r\n                        <td width=\"15%\" style=\"min-width: 150px\" class=\"lableBackground\">\r\n                            One Booking Many BLs\r\n                        </td>\r\n                        <td width=\"18%\" style=\"min-width: 191px\" class=\"whitebg\" valign=\"middle\">\r\n                            ".toCharArray();
    __oracle_jsp_text[72] = 
    "\r\n                        </td>\r\n                        <td width=\"15%\" style=\"min-width: 150px\" class=\"lableBackground\">\r\n                            Many Bookings One B/L\r\n                        </td>\r\n                        <td width=\"19%\" style=\"min-width: 192px\" class=\"whitebg\" valign=\"middle\">\r\n                            ".toCharArray();
    __oracle_jsp_text[73] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"lableBackground\" height=\"18px\">\r\n                            B/L Type\r\n                        </td>\r\n                        <td class=\"whitebg\" colspan=\"5\">\r\n                            ".toCharArray();
    __oracle_jsp_text[74] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[75] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            <table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                <div class=\"TableLeftSubColor2\" style=\"width: 100%; min-width: 1024px\">\r\n                    <h2>Shipment Details </h2>\r\n                </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 1024px\">\r\n                    <tr>\r\n                        <td width=\"15%\" style=\"min-width: 150px\" class=\"lableBackground\">\r\n                            Booking Number\r\n                        </td>\r\n                        <td width=\"18%\" class=\"whitebg\" style=\"padding-top:1px;padding-left:4px; min-width: 150px\" valign=\"top\">\r\n                            ".toCharArray();
    __oracle_jsp_text[77] = 
    "\r\n                            <a id=\"browseBookingNoBtn\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\"\r\n                                onclick=\"openBookingNumberForShipping()\">\r\n                                <i class=\"icon-search icon-white\"></i>\r\n                            </a>                    \r\n                        </td>\r\n                        <td width=\"15%\" style=\"min-width: 150px\" class=\"lableBackground\">\r\n                            B/L Number\r\n                        </td>\r\n                        <td width=\"18%\" style=\"min-width: 191px\" class=\"whitebg\">\r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n                            </font>\r\n                        </td>\r\n                        <td width=\"15%\" style=\"min-width: 150px\" class=\"lableBackground\">\r\n                            eSI Status\r\n                        </td>\r\n                        <td width=\"19%\" style=\"min-width: 192px\" class=\"whitebg\">\r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[80] = 
    "\r\n                            </font>    \r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"lableBackground\" height=\"18px\">\r\n                            SI Submitted By\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n                            </font>\r\n                        </td>\r\n                        <td class=\"lableBackground\">\r\n                            Contact Person\r\n                        </td>\r\n                        <td class=\"whitebg\" style=\"padding-left:4px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n                        </td>\r\n                        <td class=\"lableBackground\">\r\n                            Email\r\n                        </td>\r\n                        <td class=\"whitebg\" style=\"padding-left:4px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"lableBackground\" height=\"18px\">\r\n                            Telephone\r\n                        </td>\r\n                        <td class=\"whitebg\" style=\"padding-left:4px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[86] = 
    "\r\n                        </td>\r\n                        <td class=\"lableBackground\">\r\n                            Fax\r\n                        </td>\r\n                        <td style=\"padding-left:4px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[87] = 
    "\r\n                        </td>\r\n                        <td class=\"lableBackground\">\r\n                            Additional Mail Recipients\r\n                        </td>\r\n                        <td class=\"whitebg\" style=\"padding-left:4px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[88] = 
    "\r\n                        </td>\r\n                    </tr>   \r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            <table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                    <div class=\"TableLeftSubColor2\" style=\"width: 100%; min-width: 1024px\">\r\n                        <h2>Contact Details </h2>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n                    <tr>\r\n                        <td width=\"33%\" style=\"min-width: 341px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Shipper Name/Address</span></td>\r\n                        <td width=\"33%\" style=\"min-width: 341px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Consignee Name/Address</span></td>\r\n                        <td width=\"34%\" style=\"min-width: 342px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Notify Party Name/Address</span></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[89] = 
    "\r\n                            <!--input type=\"button\" value=\". . .\" id=\"btnBrowseShipperName\" name=\"btnBrowseShipperName\" class=\"event_btnbutton\" onclick=\"openCustomerData('shipperName', 'shipperAddress1', 'shipperAddress2', 'shipperAddress3', 'shipperAddress4' );\"/-->\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[90] = 
    "\r\n                            <a id=\"btnBrowseConsigneeName\" href=\"javascript:void(0)\"\r\n                                onclick=\"openCustomerData(this,'consigneeName', 'consigneeAddress1', 'consigneeAddress2', 'consigneeAddress3', 'consigneeAddress4');\"><i class=\"icon-search icon-white\"></i></a>\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[91] = 
    "\r\n                            <a id=\"btnBrowseNotifyPartyName\" href=\"javascript:void(0)\"\r\n                                onclick=\"openCustomerData(this,'notifyPartyName', 'notifyPartyAddress1', 'notifyPartyAddress2', 'notifyPartyAddress3', 'notifyPartyAddress4');\"><i class=\"icon-search icon-white\"></i></a>\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[92] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[93] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[94] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[95] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[96] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[97] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[98] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[99] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[100] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[101] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[102] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[103] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <!-- for line spacing -->\r\n                    <tr style=\"height: 2px\"><td></td></tr>\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            <table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                    <div class=\"TableLeftSubColor2\" style=\"width: 100%; min-width: 1024px\">\r\n                        <h2>Routing Details </h2>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n                    <tr>\r\n                        <td width=\"25%\" style=\"min-width: 256px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Vessel</span></td>\r\n                        <td width=\"25%\" style=\"min-width: 256px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Voyage No.</span></td>\r\n                        <td width=\"25%\" style=\"min-width: 256px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Shipped on Board Date</span></td>\r\n                        <td width=\"25%\" style=\"min-width: 256px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Place of Issue</span></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\" height=\"20px\">\r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[104] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[105] = 
    "\r\n                            </font>\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[106] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[107] = 
    "\r\n                            </font>\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[108] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[109] = 
    "\r\n                            </font>\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[110] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <!-- for line spacing -->\r\n                    <tr style=\"height: 2px\"><td></td></tr>\r\n                    <tr>\r\n                        <td class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Port of Loading(POL)</span></td>\r\n                        <td class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Port of Discharge(POD)</span></td>\r\n                        <td class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Place of Receipt</span></td>\r\n                        <td class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Place of Delivery</span></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\" height=\"20px\">\r\n                            ".toCharArray();
    __oracle_jsp_text[111] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">                    \r\n                            ".toCharArray();
    __oracle_jsp_text[112] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[113] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            ".toCharArray();
    __oracle_jsp_text[114] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <!-- for line spacing -->\r\n                    <tr style=\"height: 2px\"><td></td></tr>\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                    ".toCharArray();
    __oracle_jsp_text[115] = 
    "\r\n                    <div class=\"TableLeftSubColorNoBorder\" style=\"width: 100%; min-width: 1024px\">\r\n                        <h2>Commodity Details</h2>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                ".toCharArray();
    __oracle_jsp_text[116] = 
    "\r\n                    <table id=\"comm_result_dtl\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\r\n                    style=\"table-layout:fixed; min-width: 1024px\">\r\n                    ".toCharArray();
    __oracle_jsp_text[117] = 
    "\r\n                    <tr>\r\n                        <td width=\"3%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">#</span></td>\r\n                        <td width=\"11%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Commodity Group</span></td>\r\n                        <td width=\"11%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">HS Code</span></td>\r\n                        <td width=\"16%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Commodity Description</span></td>\r\n                        <td width=\"8%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\"># of Packages</span></td>  \r\n                        <td width=\"13%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Package Kind</span></td>\r\n                        <td width=\"10%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Gross Weight</span></td>\r\n                        <td width=\"15%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Gross Cargo Measurement (CBM)</span></td>\r\n                        <!--Begin @07 -->\r\n                        <td width=\"7%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Marks/Desc</span></td>\r\n                        <!--End @07 -->\r\n                        <td width=\"6%\" style=\"border: none;\" class=\"tableHeadingBlue\"><span class=\"m0l0iout\">Select</span></td>\r\n                    </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[118] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[119] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[120] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[121] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[122] = 
    "\r\n                    <tr style=\"height: 25px\">\r\n                        <td class=\"tableColumnData\" align=\"center\">\r\n                            ".toCharArray();
    __oracle_jsp_text[123] = 
    "\r\n                         </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[124] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[125] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[126] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[127] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[128] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[129] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[130] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[131] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[132] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[133] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[134] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[135] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[136] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[137] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[138] = 
    "\r\n                            <a name=\"btnCommodityGroupLookup\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\"\r\n                                onclick=\"openCommodityGroupLookup(this, '0', '');\" >\r\n                                <i class=\"icon-search icon-white\"></i>\r\n                            </a>  \r\n                            ".toCharArray();
    __oracle_jsp_text[139] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[140] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[141] = 
    "\r\n                            \r\n                            \r\n                        </td>   \r\n                        <td class=\"tableColumnData\">                        \r\n                            ".toCharArray();
    __oracle_jsp_text[142] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[143] = 
    "\r\n                            <a name=\"btnBrowseCommPackageKind\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\"\r\n                            onclick=\"openPackageKind(this, 'strCommPackageKindCode', 'strCommPackageKindName', PACKAGE_KIND_TYPE_COMMODITY)\"><i class=\"icon-search icon-white\"></i></a>\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[144] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[145] = 
    "\r\n                        </td>\r\n                        <!--Begin @07 -->\r\n                        <td class=\"tableColumnData\" valign=\"middle\" align=\"center\">\r\n                            <a name=\"btnCargoDetails\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\" \r\n                            onclick=\"openCargoDescription(this)\"><i class=\"icon-plus icon-white\"></i></a>\r\n                        </td>\r\n                        <!--End @07 -->\r\n                        <td class=\"tableColumnData\" align=\"center\">\r\n                        ".toCharArray();
    __oracle_jsp_text[146] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[147] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[148] = 
    "&nbsp;\r\n                         ".toCharArray();
    __oracle_jsp_text[149] = 
    "\r\n                        </td>\r\n                    </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[150] = 
    "\r\n                    <tr style=\"height: 25px\">\r\n                        <td class=\"tableColumnData\" align=\"center\">\r\n                            ".toCharArray();
    __oracle_jsp_text[151] = 
    "\r\n                         </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[152] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[153] = 
    "\r\n                            <a name=\"btnCommodityGroupLookup\" class=\"m-btn smallest rnd icn-only disabled\" href=\"javascript:void(0)\">\r\n                                <i class=\"icon-search icon-white\"></i>\r\n                            </a>\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[154] = 
    "\r\n                            \r\n                            \r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[155] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[156] = 
    "\r\n                            <a name=\"btnBrowseCommPackageKind\" class=\"m-btn smallest rnd icn-only disabled\" href=\"javascript:void(0)\">\r\n                                <i class=\"icon-search icon-white\"></i>\r\n                            </a>\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[157] = 
    "\r\n                        </td>\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[158] = 
    "\r\n                        </td>\r\n                        <!--Begin @07 -->\r\n                        <td class=\"tableColumnData\">\r\n                            ".toCharArray();
    __oracle_jsp_text[159] = 
    "\r\n                                <a name=\"btnCargoDetails\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\" \r\n                                    onclick=\"openCargoDescription(this)\"><i class=\"icon-plus icon-white\"></i>\r\n                                </a>\r\n                            ".toCharArray();
    __oracle_jsp_text[160] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[161] = 
    "\r\n                                <a name=\"btnCargoDetails\" class=\"m-btn smallest rnd icn-only disabled\" href=\"javascript:void(0)\">\r\n                                    <i class=\"icon-plus icon-white\"></i>\r\n                                </a>\r\n                            ".toCharArray();
    __oracle_jsp_text[162] = 
    "\r\n                        </td>\r\n                        <!--End @07 -->\r\n                        <td class=\"tableColumnData\">\r\n                            &nbsp;\r\n                        </td>\r\n                    </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[163] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[164] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[165] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[166] = 
    "\r\n                    </table>\r\n                ".toCharArray();
    __oracle_jsp_text[167] = 
    "\r\n                </td>\r\n            </tr>\r\n        ".toCharArray();
    __oracle_jsp_text[168] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[169] = 
    "\r\n            <tr>\r\n                <td align=\"right\">\r\n                    <div class=\"spotlight-action\">\r\n                    <!-- @02 BEGIN -->\r\n                        ".toCharArray();
    __oracle_jsp_text[170] = 
    "\r\n                        \r\n                        <table border=\"0\" cellspacing=\"2\" cellpadding=\"0\">\r\n                        <tr>\r\n                            <td align=\"right\">\r\n                                <a class=\"m-btn mini blue rnd\" id=\"addCommBtn\"\r\n                                    href=\"javascript:void(0)\" onClick=\"return addCommodity();\">\r\n                                        <i class=\"icon-plus icon-white\"></i>&nbsp;Add Commodity\r\n                                </a>\r\n                            </td>\r\n                        ".toCharArray();
    __oracle_jsp_text[171] = 
    "\r\n                            <td id=\"deleteCommTd\" align=\"right\" style=\"display: ".toCharArray();
    __oracle_jsp_text[172] = 
    "\">\r\n                                <a class=\"m-btn mini red rnd\" id=\"deleteCommBtn\"\r\n                                href=\"javascript:void(0)\" onClick=\"return deleteCommodity()\">  \r\n                                    <i class=\"icon-trash icon-white\"></i>&nbsp;Delete Commodity\r\n                                </a>\r\n                            </td>\r\n                        </tr>\r\n                        </table>\r\n                        ".toCharArray();
    __oracle_jsp_text[173] = 
    "\r\n                        \r\n                    <!-- @02 END -->\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[174] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[175] = 
    "\r\n            <tr><td style=\"height: 20px\">&nbsp;</td></tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                    <div class=\"TableLeftSubColor2\" style=\"width: 100%; min-width: 1024px\">\r\n                        <h2>Equipment Details </h2>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n                    <tr>\r\n                        <td width=\"3%\" style=\"min-width: 30px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">#</span></td>\r\n                        <td width=\"12%\" style=\"min-width: 124px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Container No.</span></td>\r\n                        <td width=\"14%\" style=\"min-width: 150px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Container Type</span></td>\r\n                        <td width=\"10%\" style=\"min-width: 100px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Carrier Seal</span></td>\r\n                        <td width=\"10%\" style=\"min-width: 100px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Shipper Seal</span></td>\r\n                        <td width=\"12%\" style=\"min-width: 120px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\"># of Packages</span></td>  \r\n                        <td width=\"21%\" style=\"min-width: 220px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Package Kind</span></td>\r\n                        <td width=\"14%\" style=\"min-width: 140px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Gross Cargo Weight (KG)</span></td>\r\n                        <td width=\"4%\" style=\"min-width: 40px\" class=\"TableHeadingRow2\" align=\"center\">\r\n                            <div style=\"display:none\">\r\n                                <input type=\"checkbox\" name=\"cbdelall\" style=\"float:left;border:0px;width:100%\" onclick=\"selectAllData()\"/>\r\n                            </div>\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"TableHeadingRow3\" ></td>\r\n                        <td class=\"TableHeadingRow3\" ><span class=\"m0l0iout\">Commodity</span></td>\r\n                        <td class=\"TableHeadingRow3\" colspan=\"5\"><span class=\"m0l0iout\">Laden / MT</span></td>\r\n                        <td class=\"TableHeadingRow3\" colspan=\"2\"><span class=\"m0l0iout\">Gross Cargo Measurement (CBM)</span></td>\r\n                    </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[176] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[177] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[178] = 
    " \r\n                    ".toCharArray();
    __oracle_jsp_text[179] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[180] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[181] = 
    "\r\n                    <tr class=\"".toCharArray();
    __oracle_jsp_text[182] = 
    "\">\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[183] = 
    "\r\n                            <input type=\"hidden\" name=\"seqNo\" id=\"seqNo\" value=\"".toCharArray();
    __oracle_jsp_text[184] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"cntrSeq\" id=\"cntrSeq\" value=\"".toCharArray();
    __oracle_jsp_text[185] = 
    "\"/>\r\n                        </td>   \r\n                        <td>\r\n                            <input type=\"hidden\" name=\"dbFlag\" id=\"dbFlag\" value=\"".toCharArray();
    __oracle_jsp_text[186] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"statusFlag\" id=\"statusFlag\" value=\"".toCharArray();
    __oracle_jsp_text[187] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"originalSeqNo\" id=\"originalSeqNo\" value=\"".toCharArray();
    __oracle_jsp_text[188] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"fkEquipmentDetail\" id=\"fkEquipmentDetail\" value=\"".toCharArray();
    __oracle_jsp_text[189] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"fkBookingSupplier\" id=\"fkBookingSupplier\" value=\"".toCharArray();
    __oracle_jsp_text[190] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"fkBookingSizeTypeDetail\" id=\"fkBookingSizeTypeDetail\" value=\"".toCharArray();
    __oracle_jsp_text[191] = 
    "\"/>\r\n                            <input type=\"hidden\" name=\"cargoDetails\" id=\"cargoDetails\" value=\"\" style=\"width:408px\"/>\r\n                            ".toCharArray();
    __oracle_jsp_text[192] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[193] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[194] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[195] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[196] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[197] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[198] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[199] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[200] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[201] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[202] = 
    "\r\n                        </td>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[203] = 
    "\r\n                                <input type=\"hidden\" name=\"containerEqSize\" id=\"containerEqSize\" value=\"".toCharArray();
    __oracle_jsp_text[204] = 
    "\" />\r\n                            ".toCharArray();
    __oracle_jsp_text[205] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[206] = 
    "\r\n                                <input type=\"hidden\" name=\"containerEqSize\" id=\"containerEqSize\" value=\"\" />\r\n                            ".toCharArray();
    __oracle_jsp_text[207] = 
    "\r\n                             ".toCharArray();
    __oracle_jsp_text[208] = 
    "\r\n                               <input type=\"hidden\" name=\"containerEqType\" id=\"containerEqType\" value=\"".toCharArray();
    __oracle_jsp_text[209] = 
    "\" />\r\n                            ".toCharArray();
    __oracle_jsp_text[210] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[211] = 
    "\r\n                               <input type=\"hidden\" name=\"containerEqType\" id=\"containerEqType\" value=\"\" />\r\n                            ".toCharArray();
    __oracle_jsp_text[212] = 
    "\r\n                            \r\n                            ".toCharArray();
    __oracle_jsp_text[213] = 
    "                                    \r\n                                ".toCharArray();
    __oracle_jsp_text[214] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[215] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[216] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[217] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[218] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[219] = 
    "\r\n                                    <input type=\"hidden\" name=\"containerType\" id=\"containerType\" value=\"".toCharArray();
    __oracle_jsp_text[220] = 
    "\" />\r\n                                \r\n                                    <font class=\"displayText\">".toCharArray();
    __oracle_jsp_text[221] = 
    "</font>\r\n                                ".toCharArray();
    __oracle_jsp_text[222] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[223] = 
    "\r\n                                    <input type=\"hidden\" name=\"containerType\" id=\"containerType\" value=\"\" />\r\n                                ".toCharArray();
    __oracle_jsp_text[224] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[225] = 
    "                                   \r\n                        </td>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[226] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[227] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[228] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[229] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[230] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[231] = 
    "\r\n                        </td>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[232] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[233] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[234] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[235] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[236] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[237] = 
    "\r\n                        </td>\r\n                        <td>\r\n                        ".toCharArray();
    __oracle_jsp_text[238] = 
    "                              \r\n                            ".toCharArray();
    __oracle_jsp_text[239] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[240] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[241] = 
    "                                   \r\n                            ".toCharArray();
    __oracle_jsp_text[242] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[243] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[244] = 
    "\r\n                            <a id=\"ofPackageCopyBtn".toCharArray();
    __oracle_jsp_text[245] = 
    "\" name=\"ofPackageCopyBtn\" class=\"m-btn mini blue rnd\" \r\n                            style=\"visiblity: visible; vertical-align: top;  height: 15px\" \r\n                            href=\"javascript: void(0)\" onClick=\"onClickCopyEquipmentField(EQUIPMENT_OF_PACKAGE, ".toCharArray();
    __oracle_jsp_text[246] = 
    ");\">\r\n                                Copy<i class=\"m-icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[247] = 
    "\r\n                        </td>\r\n                        <td style=\"padding-top:1px;\" valign=\"top\">\r\n                        ".toCharArray();
    __oracle_jsp_text[248] = 
    "\r\n                            <input type=\"hidden\" name=\"packagesKindCode\" id=\"packagesKindCode\" value=\"".toCharArray();
    __oracle_jsp_text[249] = 
    "\"/>\r\n                        ".toCharArray();
    __oracle_jsp_text[250] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[251] = 
    "\r\n                            <input type=\"hidden\" name=\"packagesKindCode\" id=\"packagesKindCode\" value=\"\"/>\r\n                        ".toCharArray();
    __oracle_jsp_text[252] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[253] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[254] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[255] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[256] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[257] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[258] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[259] = 
    "\r\n                            <a name=\"btnBrowsePackageKind\" href=\"javascript:void(0)\" \r\n                                onclick=\"openPackageKind(this, 'packagesKindCode', 'packagesKind', PACKAGE_KIND_TYPE_EQUIPMENT)\"><i class=\"icon-search icon-white\"></i></a>\r\n                    ".toCharArray();
    __oracle_jsp_text[260] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[261] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[262] = 
    "\r\n                            <input type=\"hidden\" name=\"packagesKind\" id=\"packagesKind\" value=\"".toCharArray();
    __oracle_jsp_text[263] = 
    "\"/>\r\n                            \r\n                            <font class=\"displayText\">\r\n                                ".toCharArray();
    __oracle_jsp_text[264] = 
    "\r\n                            </font>\r\n                        ".toCharArray();
    __oracle_jsp_text[265] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[266] = 
    "\r\n                            <input type=\"hidden\" name=\"packagesKind\" id=\"packagesKind\" value=\"\"/>\r\n                        ".toCharArray();
    __oracle_jsp_text[267] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[268] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[269] = 
    "\r\n                            <input type=\"hidden\" name=\"packagesKindName\" id=\"packagesKindName\" value=\"".toCharArray();
    __oracle_jsp_text[270] = 
    "\"/>\r\n                        ".toCharArray();
    __oracle_jsp_text[271] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[272] = 
    "\r\n                            <input type=\"hidden\" name=\"packagesKindName\" id=\"packagesKindName\" value=\"\"/>\r\n                        ".toCharArray();
    __oracle_jsp_text[273] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[274] = 
    "\r\n                            <a id=\"packageKindCopyBtn".toCharArray();
    __oracle_jsp_text[275] = 
    "\" name=\"packageKindCopyBtn\" class=\"m-btn mini blue rnd\" \r\n                            style=\"visiblity: visible; vertical-align: top;  height: 15px\" \r\n                            href=\"javascript: void(0)\" onClick=\"onClickCopyEquipmentField(EQUIPMENT_PACKAGE_KIND, ".toCharArray();
    __oracle_jsp_text[276] = 
    ");\">\r\n                                Copy<i class=\"m-icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[277] = 
    "\r\n                        </td>\r\n                        <td>        \r\n                        ".toCharArray();
    __oracle_jsp_text[278] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[279] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[280] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[281] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[282] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[283] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[284] = 
    "\r\n                            <a id=\"grossWeightCopyBtn".toCharArray();
    __oracle_jsp_text[285] = 
    "\" name=\"grossWeightCopyBtn\" class=\"m-btn mini blue rnd\" \r\n                            style=\"visiblity: visible; vertical-align: top;  height: 15px\" \r\n                            href=\"javascript: void(0)\" onClick=\"onClickCopyEquipmentField(EQUIPMENT_GROSS_WEIGHT, ".toCharArray();
    __oracle_jsp_text[286] = 
    ");\">\r\n                                Copy<i class=\"m-icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[287] = 
    "\r\n                        </td>\r\n                        <td align=\"center\">\r\n                        <div style=\"display:none\">\r\n                            <input type=\"checkbox\" name=\"cbdel\" id=\"cbdel\" style=\"float:left;border:0px;width:100%\"/>\r\n                        </div>\r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"".toCharArray();
    __oracle_jsp_text[288] = 
    "\">\r\n                        <td>&nbsp;</td>\r\n                        <td align=\"left\" >\r\n                    ".toCharArray();
    __oracle_jsp_text[289] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[290] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[291] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[292] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[293] = 
    "\r\n                                    <option value=\"".toCharArray();
    __oracle_jsp_text[294] = 
    "\" \r\n                                    label=\"".toCharArray();
    __oracle_jsp_text[295] = 
    "\" selected=\"selected\" />\r\n                                ".toCharArray();
    __oracle_jsp_text[296] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[297] = 
    "\r\n                                    <option value=\"".toCharArray();
    __oracle_jsp_text[298] = 
    "\" \r\n                                    label=\"".toCharArray();
    __oracle_jsp_text[299] = 
    "\" />\r\n                                ".toCharArray();
    __oracle_jsp_text[300] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[301] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[302] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[303] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[304] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[305] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[306] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[307] = 
    "                                        \r\n                                ".toCharArray();
    __oracle_jsp_text[308] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[309] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[310] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[311] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[312] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[313] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[314] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[315] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[316] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[317] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[318] = 
    "\r\n                        </td>   \r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[319] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[320] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[321] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[322] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[323] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[324] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[325] = 
    "\r\n                                    <input type=\"hidden\" name=\"ladenMt\" id=\"ladenMt\" value=\"".toCharArray();
    __oracle_jsp_text[326] = 
    "\" />                                        \r\n                                    <font class=\"displayText\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[327] = 
    "\r\n                                    </font>\r\n                                ".toCharArray();
    __oracle_jsp_text[328] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[329] = 
    "\r\n                                    <input type=\"hidden\" name=\"ladenMt\" id=\"ladenMt\" value=\"\" />    \r\n                                ".toCharArray();
    __oracle_jsp_text[330] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[331] = 
    "\r\n                        </td>                                \r\n                        <td colspan=\"4\">&nbsp;</td>\r\n                        <td style=\"padding-bottom:2px\">\r\n                            ".toCharArray();
    __oracle_jsp_text[332] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[333] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[334] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[335] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[336] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[337] = 
    "\r\n                            \r\n                        ".toCharArray();
    __oracle_jsp_text[338] = 
    "\r\n                            <a id=\"grossMeasurementCopyBtn".toCharArray();
    __oracle_jsp_text[339] = 
    "\" name=\"grossMeasurementCopyBtn\" class=\"m-btn mini blue rnd\" \r\n                            style=\"visiblity: visible; vertical-align: top;  height: 15px\" \r\n                            href=\"javascript: void(0)\" onClick=\"onClickCopyEquipmentField(EQUIPMENT_GROSS_MEASUREMENT, ".toCharArray();
    __oracle_jsp_text[340] = 
    ");\">\r\n                                Copy<i class=\"m-icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[341] = 
    "\r\n                        </td>\r\n                        <td>&nbsp;</td>\r\n                    </tr>\r\n                        ".toCharArray();
    __oracle_jsp_text[342] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[343] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[344] = 
    "\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td align=\"right\">\r\n                    <div align=\"right\" class=\"spotlight-action\" style=\"display:none;padding-top:5px;padding-bottom:13px;\">\r\n                        <a id=\"addDisabledBtn\" class=\"m-btn mini rnd disabled\" style=\"display:none\"\r\n                            href=\"javascript:void(0)\">\r\n                                <i class=\"icon-plus icon-white\"></i>&nbsp;Add Equipment\r\n                        </a>\r\n                        <a id=\"addBtn\" class=\"m-btn mini blue rnd\" style=\"display:''\"\r\n                            href=\"javascript:void(0)\" onClick=\"return addItem()\">\r\n                                <i class=\"icon-plus icon-white\"></i>&nbsp;Add Equipment\r\n                        </a>\r\n                        \r\n                        <a id=\"delDisabledBtn\" class=\"m-btn mini rnd disabled\" style=\"display:none\"\r\n                            href=\"javascript:void(0)\">\r\n                                <i class=\"icon-trash icon-white\"></i>&nbsp;Delete Equipment\r\n                        </a>\r\n                        <a id=\"delBtn\" class=\"m-btn mini red rnd\" style=\"display:''\"\r\n                            href=\"javascript:void(0)\" onClick=\"return deleteItem()\">\r\n                                <i class=\"icon-trash icon-white\"></i>&nbsp;Delete Equipment\r\n                        </a>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n            <tr>\r\n                <td style=\"width: 100%; min-width: 1024px\">\r\n                    <div class=\"TableLeftSubColor2\" style=\"width: 100%; min-width: 1024px\">\r\n                        <h2>Cargo Descriptions / Marks & No. & Printing Details </h2>\r\n                    </div>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"min-width: 1024px\">\r\n                    <tr>\r\n                        <td width=\"12%\" style=\"min-width: 120px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">No. of Original BL</span></td>\r\n                        <td width=\"88%\" style=\"min-width: 824px\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Remarks</span></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td class=\"whitebg\" style=\"padding-top:1px;\" valign=\"top\" align=\"center\">\r\n                            ".toCharArray();
    __oracle_jsp_text[345] = 
    "\r\n                        </td>\r\n                        <td class=\"whitebg\">\r\n                            <!-- @05 BEGIN -->\r\n                            ".toCharArray();
    __oracle_jsp_text[346] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[347] = 
    "\r\n                            <!-- @05 END -->\r\n                        </td>\r\n                    </tr>\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            <tr><td style=\"height:20px\"></td></tr>\r\n            <tr>\r\n                <td align=\"right\">\r\n                    ".toCharArray();
    __oracle_jsp_text[348] = 
    "\r\n                        <a id=\"previewDisabledBtn\" class=\"m-btn sm rnd disabled\"\r\n                            href=\"javascript:void(0)\">Preview Draft SI <i class=\"m-icon-swapup m-icon-white\"></i>\r\n                        </a> \r\n                        <a id=\"previewBtn\" class=\"m-btn sm blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"return getPDF()\">Preview Draft SI <i class=\"m-icon-swapup m-icon-white\"></i>\r\n                        </a>\r\n                        \r\n                        <a id=\"saveDisabledBtn\" class=\"m-btn sm rnd disabled\"\r\n                            href=\"javascript:void(0)\">Save\r\n                        </a> \r\n                        <a id=\"saveBtn\" class=\"m-btn sm blue rnd\"\r\n                            href=\"javascript:void(0)\" onClick=\"clearMsg(); saveDraftBtn()\">Save\r\n                        </a>\r\n                        \r\n                        <a id=\"submitDisabledBtn\" class=\"m-btn sm rnd disabled\"\r\n                            href=\"javascript:void(0)\">Submit SI <i class=\"m-icon-swapright m-icon-white\"></i>\r\n                        </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[349] = 
    "\r\n                            <a id=\"submitBtn\" class=\"m-btn sm green rnd\" style=\"visiblity: visible\"\r\n                            href=\"javascript:void(0)\" onClick=\"clearMsg(); submitBtn();\" >Submit SI <i class=\"m-icon-swapright m-icon-white\"></i>\r\n                            </a>\r\n                        ".toCharArray();
    __oracle_jsp_text[350] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[351] = 
    "\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    </table>\r\n    <div id=\"cargoDescriptionDiv\" style=\"display: none;\" >\r\n        ".toCharArray();
    __oracle_jsp_text[352] = 
    "\r\n    </div>\r\n".toCharArray();
    __oracle_jsp_text[353] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

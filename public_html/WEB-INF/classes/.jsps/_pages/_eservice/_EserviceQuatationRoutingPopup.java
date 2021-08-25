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
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;


public class _EserviceQuatationRoutingPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceQuatationRoutingPopup page = this;
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
          List<EserviceNewWebBookingUim> eServiceQuatationRoutingList = (List<EserviceNewWebBookingUim>) session.getAttribute("eServiceQuatationRoutingList");
          if(eServiceQuatationRoutingList != null && !eServiceQuatationRoutingList.isEmpty()){
              System.out.println("eServiceQuatationRoutingList.size = "+eServiceQuatationRoutingList.size());
          }else{
              System.out.println("Empty");
          }
      
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts.taglib.html.HtmlTag __jsp_taghandler_1=(org.apache.struts.taglib.html.HtmlTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HtmlTag.class,"org.apache.struts.taglib.html.HtmlTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[11]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[12]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[13]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[14]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SetQuotationRoutingData", pageContext));
            out.write(__oracle_jsp_text[15]);
            {
              org.apache.struts.taglib.html.FormTag __jsp_taghandler_2=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setAction("/serv001");
              __jsp_taghandler_2.setMethod("POST");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[16]);
                  out.write(__oracle_jsp_text[17]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_3=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name scope");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setName("quotationNumber");
                    __jsp_taghandler_3.setScope("request");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name scope");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setName("eServiceQuatationRoutingList");
                    __jsp_taghandler_4.setScope("session");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[19]);
                        out.write(__oracle_jsp_text[20]);
                        {
                          org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_5=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name scope");
                          __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                          __jsp_taghandler_5.setId("quatationRoutingList");
                          __jsp_taghandler_5.setName("eServiceQuatationRoutingList");
                          __jsp_taghandler_5.setScope("session");
                          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,4);
                        }
                        java.lang.Object quatationRoutingList = null;
                        quatationRoutingList = (java.lang.Object) pageContext.findAttribute("quatationRoutingList");
                        out.write(__oracle_jsp_text[21]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name type");
                          __jsp_taghandler_6.setParent(__jsp_taghandler_4);
                          __jsp_taghandler_6.setId("eserviceNewWebBookingUim");
                          __jsp_taghandler_6.setIndexId("rowIndex");
                          __jsp_taghandler_6.setName("quatationRoutingList");
                          __jsp_taghandler_6.setType("com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim");
                          com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim eserviceNewWebBookingUim = null;
                          java.lang.Integer rowIndex = null;
                          __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_6,__jsp_tag_starteval,out);
                            do {
                              eserviceNewWebBookingUim = (com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim) pageContext.findAttribute("eserviceNewWebBookingUim");
                              rowIndex = (java.lang.Integer) pageContext.findAttribute("rowIndex");
                              out.write(__oracle_jsp_text[22]);
                              {
                                org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_7=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id value");
                                __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_7.setId("newRowIndex");
                                __jsp_taghandler_7.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowIndex+1}",java.lang.String.class, __ojsp_varRes,null));
                                __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                                if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,5);
                              }
                              java.lang.String newRowIndex = null;
                              newRowIndex = (java.lang.String) pageContext.findAttribute("newRowIndex");
                              out.write(__oracle_jsp_text[23]);
                              out.write(__oracle_jsp_text[24]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.pol}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[25]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.pod}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[26]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.originCountry}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[27]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.destinationCountry}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[28]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.placeOfReceipt}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[29]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.portOfLoading}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[30]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.portOfDischarge}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[31]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.placeOfDelivery}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[32]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.shipmentType}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[33]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${eserviceNewWebBookingUim.socCocUserFlag}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[34]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_8=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name");
                                __jsp_taghandler_8.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_8.setName("newRowIndex");
                                __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                                if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,5);
                              }
                              out.write(__oracle_jsp_text[35]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_9=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name");
                                __jsp_taghandler_9.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_9.setName("newRowIndex");
                                __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                                if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,5);
                              }
                              out.write(__oracle_jsp_text[36]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_10=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_10.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_10.setName("eserviceNewWebBookingUim");
                                __jsp_taghandler_10.setProperty("originCountry");
                                __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                                if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,5);
                              }
                              out.write(__oracle_jsp_text[37]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_11=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_11.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_11.setName("eserviceNewWebBookingUim");
                                __jsp_taghandler_11.setProperty("destinationCountry");
                                __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                                if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,5);
                              }
                              out.write(__oracle_jsp_text[38]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_12=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_12.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_12.setName("eserviceNewWebBookingUim");
                                __jsp_taghandler_12.setProperty("placeOfReceipt");
                                __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                                if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,5);
                              }
                              out.write(__oracle_jsp_text[39]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_13=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_13.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_13.setName("eserviceNewWebBookingUim");
                                __jsp_taghandler_13.setProperty("portOfLoading");
                                __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                                if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,5);
                              }
                              out.write(__oracle_jsp_text[40]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_14=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_14.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_14.setName("eserviceNewWebBookingUim");
                                __jsp_taghandler_14.setProperty("portOfDischarge");
                                __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                                if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,5);
                              }
                              out.write(__oracle_jsp_text[41]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_15.setParent(__jsp_taghandler_6);
                                __jsp_taghandler_15.setName("eserviceNewWebBookingUim");
                                __jsp_taghandler_15.setProperty("placeOfDelivery");
                                __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                                if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,5);
                              }
                              out.write(__oracle_jsp_text[42]);
                            } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,4);
                        }
                        out.write(__oracle_jsp_text[43]);
                      } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[44]);
                  {
                    org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_16=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name scope");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_16.setName("eServiceQuatationRoutingList");
                    __jsp_taghandler_16.setScope("session");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[45]);
                      } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[46]);
                  {
                    String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
                    __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv01") } );
                    // Include 
                    pageContext.include( __url,false);
                    if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
                  }

                  out.write(__oracle_jsp_text[47]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[48]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[49]);

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
  private static final char __oracle_jsp_text[][]=new char[50][];
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
    "\r\n<head>\r\n    <!-- add screen specific JavaScript file -->\r\n    <script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/js/common/Constants.js\" ></script>\r\n    <script  type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/js/RutHelp.js\" ></script>\r\n    <!-- add javascript file for this screen -->\r\n    <script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/js/screen/EserviceQuotationRoutingPopup.js\" ></script>\r\n    <script type=\"text/javascript\" language=\"JavaScript\">\r\n        var SET_QUATATION_ROUTING_DATA\r\n            = '".toCharArray();
    __oracle_jsp_text[15] = 
    "';\r\n    </script>\r\n</head>\r\n\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n    <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr style=\"height: 20px\">\r\n            <td>\r\n                <table width=\"300\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                <tr style=\"height: 25px\">\r\n                    <td width=\"150\">\r\n                        <font class=\"table_search\" style=\"font-size: 14px\">\r\n                        Quotation Number\r\n                        </font>\r\n                    </td>\r\n                    <td width=\"150\" class=\"whitebg\">\r\n                        ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n                        <font class=\"displayText\" style=\"font-size: 14px\">\r\n                            ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n                        </font>\r\n                    </td>\r\n                </tr>\r\n                </table>\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td>       \r\n                <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n                <tr>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"10%\">#</td>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"15%\">Original Country</td>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"15%\">Destination Country</td>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"15%\">Place of Reciept </td>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"15%\">Port of Loading</td>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"15%\">Port of Discharge</td>\r\n                    <td class=\"TdLeftHeaderPopup\" width=\"15%\">Place of Delivery</td>\r\n                </tr>\r\n                </table>\r\n                \r\n                <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n        ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                <tr ondblclick=\"callBack(\r\n                '".toCharArray();
    __oracle_jsp_text[25] = 
    "', '".toCharArray();
    __oracle_jsp_text[26] = 
    "', \r\n                '".toCharArray();
    __oracle_jsp_text[27] = 
    "', '".toCharArray();
    __oracle_jsp_text[28] = 
    "',\r\n                '".toCharArray();
    __oracle_jsp_text[29] = 
    "', '".toCharArray();
    __oracle_jsp_text[30] = 
    "', \r\n                '".toCharArray();
    __oracle_jsp_text[31] = 
    "', '".toCharArray();
    __oracle_jsp_text[32] = 
    "',\r\n                '".toCharArray();
    __oracle_jsp_text[33] = 
    "', '".toCharArray();
    __oracle_jsp_text[34] = 
    "');\" \r\n                onclick=\"highlightradioTD('".toCharArray();
    __oracle_jsp_text[35] = 
    "');\" \r\n                style=\"cursor:hand; height: 20px\">\r\n                    <td width=\"10%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n                    </td>\r\n                    <td width=\"15%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n                    </td>\r\n                    <td width=\"15%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                    </td>\r\n                    <td width=\"15%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                    </td>\r\n                    <td width=\"15%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                    </td>\r\n                    <td width=\"15%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                    </td>\r\n                    <td width=\"15%\" class=\"TdLeftDetailPopup\" style=\"color: #000000\">\r\n                        ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                    </td>\r\n                </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n            <tr style=\"height: 20px\">    \r\n                <td colspan=\"7\" align=\"center\">\r\n                    <span  style=\"color: #000000\">No record found.</span>\r\n                </td>\r\n            </tr>\r\n        ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n                </table>\r\n            </td>\r\n        </tr>\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n</body>\r\n".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

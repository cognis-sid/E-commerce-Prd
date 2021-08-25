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


public class _EserviceBookingNumberPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceBookingNumberPopup page = this;
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
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[9]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[10]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[11]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext));
      out.write(__oracle_jsp_text[12]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext));
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv002");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[14]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv02");
              __jsp_taghandler_2.setProperty("page");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[15]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv02");
              __jsp_taghandler_3.setProperty("pageFlag");
              __jsp_taghandler_3.setStyleId("pageFlag");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_4=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur property");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("feserv02");
              __jsp_taghandler_4.setOnblur("changeUpper(this)");
              __jsp_taghandler_4.setProperty("tbxFind");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_5=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("feserv02");
              __jsp_taghandler_5.setProperty("columnValue");
              __jsp_taghandler_5.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_6=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_6.setLabel("name");
                    __jsp_taghandler_6.setName("feserv02");
                    __jsp_taghandler_6.setProperty("columnList");
                    __jsp_taghandler_6.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[19]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_7=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("feserv02");
              __jsp_taghandler_7.setProperty("statusValue");
              __jsp_taghandler_7.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[21]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_8=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                    __jsp_taghandler_8.setLabel("name");
                    __jsp_taghandler_8.setName("feserv02");
                    __jsp_taghandler_8.setProperty("statusList");
                    __jsp_taghandler_8.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_9=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setName("feserv02");
              __jsp_taghandler_9.setProperty("sortByValue");
              __jsp_taghandler_9.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_9,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[24]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_10=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_9);
                    __jsp_taghandler_10.setLabel("name");
                    __jsp_taghandler_10.setName("feserv02");
                    __jsp_taghandler_10.setProperty("sortByList");
                    __jsp_taghandler_10.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_11=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setName("feserv02");
              __jsp_taghandler_11.setProperty("orderValue");
              __jsp_taghandler_11.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_11,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[27]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_12=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_12.setLabel("name");
                    __jsp_taghandler_12.setName("feserv02");
                    __jsp_taghandler_12.setProperty("orderList");
                    __jsp_taghandler_12.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_13=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("feserv02");
              __jsp_taghandler_13.setProperty("chkBoxWildCard");
              __jsp_taghandler_13.setStyle("float:left;border:0px;width:5%");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[30]);
            out.print(EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_DATE);
            out.write(__oracle_jsp_text[31]);
            out.print(EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_NO);
            out.write(__oracle_jsp_text[32]);
            out.print(EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_TYPE);
            out.write(__oracle_jsp_text[33]);
            out.print(EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_POL);
            out.write(__oracle_jsp_text[34]);
            out.print(EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_POD);
            out.write(__oracle_jsp_text[35]);
            out.print(EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_STATUS);
            out.write(__oracle_jsp_text[36]);
            
                            List list = (List)request.getAttribute("listBooking");     
                            if(!list.isEmpty()){
                                int x = 0;
                        
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_14=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setId("listBookingId");
              __jsp_taghandler_14.setName("listBooking");
              java.lang.Object listBookingId = null;
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_14,__jsp_tag_starteval,out);
                do {
                  listBookingId = (java.lang.Object) pageContext.findAttribute("listBookingId");
                  out.write(__oracle_jsp_text[38]);
                  out.print(x);
                  out.write(__oracle_jsp_text[39]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_15.setName("listBookingId");
                    __jsp_taghandler_15.setProperty("bookingNo");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[40]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_16.setName("listBookingId");
                    __jsp_taghandler_16.setProperty("bookingType");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[41]);
                  out.print(x);
                  out.write(__oracle_jsp_text[42]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_17=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_17.setName("listBookingId");
                    __jsp_taghandler_17.setProperty("bookingDate");
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[43]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_18=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_18.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_18.setName("listBookingId");
                    __jsp_taghandler_18.setProperty("bookingNo");
                    __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                    if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                  }
                  out.write(__oracle_jsp_text[44]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_19=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_19.setName("listBookingId");
                    __jsp_taghandler_19.setProperty("bookingType");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
                  }
                  out.write(__oracle_jsp_text[45]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_20=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_20.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_20.setName("listBookingId");
                    __jsp_taghandler_20.setProperty("pol");
                    __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                    if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,3);
                  }
                  out.write(__oracle_jsp_text[46]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_21=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_21.setName("listBookingId");
                    __jsp_taghandler_21.setProperty("pod");
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,3);
                  }
                  out.write(__oracle_jsp_text[47]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_22=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_22.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_22.setName("listBookingId");
                    __jsp_taghandler_22.setProperty("status");
                    __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                    if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,3);
                  }
                  out.write(__oracle_jsp_text[48]);
                   x++; 
                  out.write(__oracle_jsp_text[49]);
                } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[50]);
            } else {
            out.write(__oracle_jsp_text[51]);
            }
            out.write(__oracle_jsp_text[52]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv02") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[53]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[54]);

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
  private static final char __oracle_jsp_text[][]=new char[55][];
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
    "\r\n\r\n<head>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "/js/RutHelp.js\" ></script>\r\n<!-- add javascript file for this screen -->\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/js/screen/EserviceBookingNumberPopup.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n    var BROWSE_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[12] = 
    "';   \r\n    var GET_BOOKING_NUMBER_TO_WEBBOOKING_PAGE = '".toCharArray();
    __oracle_jsp_text[13] = 
    "';\r\n</script>\r\n</head>\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[14] = 
    "         \r\n        ".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td width=\"6%\">Find</td>\r\n                <td width=\"23%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n                </td>\r\n                <td width=\"7%\">Column</td>\r\n                <td width=\"23%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n                </td>\r\n                <td width=\"6%\" style=\"padding-left:6px\">Status</td>\r\n                <td width=\"18%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                </td>\r\n                <td valign=\"top\" style=\"padding-top:1px\">\r\n                    <a id=\"btnSearch\" name=\"btnSearch\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"searchBtn()\">&nbsp;Search\r\n                    </a>\r\n                    <a id=\"btnReset\" name=\"btnReset\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"resetBtn()\">&nbsp;Reset\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>Sort by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                </td>\r\n                <td>Order by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n                <td colspan=\"3\" style=\"padding-left:4px;padding-top:3px\">\r\n                    ".toCharArray();
    __oracle_jsp_text[30] = 
    "Wild Card\r\n                </td>\r\n            </tr>\r\n        </table><br>\r\n        <table class=\"TablePopup\">\r\n            <tr>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"16%\">".toCharArray();
    __oracle_jsp_text[31] = 
    "</td>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"16%\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</td>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"16%\">".toCharArray();
    __oracle_jsp_text[33] = 
    "</td>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"16%\">".toCharArray();
    __oracle_jsp_text[34] = 
    "</td>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"16%\">".toCharArray();
    __oracle_jsp_text[35] = 
    "</td>\r\n                <td class=\"TdLeftHeaderPopup\">".toCharArray();
    __oracle_jsp_text[36] = 
    "</td>\r\n            </tr>\r\n        </table>\r\n        <table class=\"TablePopup\">\r\n            ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                <tr id=\"row".toCharArray();
    __oracle_jsp_text[39] = 
    "\" ondblclick=\"callbackToField('".toCharArray();
    __oracle_jsp_text[40] = 
    "', '".toCharArray();
    __oracle_jsp_text[41] = 
    "')\" onclick=\"highlightRadioTD('row".toCharArray();
    __oracle_jsp_text[42] = 
    "')\" style=\"cursor:hand;\">\r\n                    <td class=\"TdLeftDetailPopup\" width=\"16%\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[43] = 
    "</td>\r\n                    <td class=\"TdLeftDetailPopup\" width=\"16%\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[44] = 
    "</td>\r\n                    <td class=\"TdLeftDetailPopup\" width=\"16%\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[45] = 
    "</td>\r\n                    <td class=\"TdLeftDetailPopup\" width=\"16%\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[46] = 
    "</td>\r\n                    <td class=\"TdLeftDetailPopup\" width=\"16%\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[47] = 
    "</td>\r\n                    <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[48] = 
    "</td>\r\n                </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n                <tr style=\"height: 20px\">    \r\n                    <td colspan=\"8\" align=\"center\">No record found.</td>\r\n                </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

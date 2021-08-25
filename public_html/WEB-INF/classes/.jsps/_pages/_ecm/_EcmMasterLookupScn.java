package _pages._ecm;

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
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustomerPopupDao;


public class _EcmMasterLookupScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EcmMasterLookupScn page = this;
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
      {
        org.apache.struts.taglib.html.HtmlTag __jsp_taghandler_1=(org.apache.struts.taglib.html.HtmlTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HtmlTag.class,"org.apache.struts.taglib.html.HtmlTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[11]);
            {
              org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_2=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("fecm002");
              __jsp_taghandler_2.setProperty("screenTitle");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[12]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[13]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[14]);
            out.print(request.getContextPath());
            out.write(__oracle_jsp_text[15]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm002search", pageContext));
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.FormTag __jsp_taghandler_3=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setAction("/secm002");
              __jsp_taghandler_3.setMethod("POST");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[17]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_4.setName("fecm002");
                    __jsp_taghandler_4.setProperty("prmFormName");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_5.setName("fecm002");
                    __jsp_taghandler_5.setProperty("prmRowId");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[19]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_6.setName("fecm002");
                    __jsp_taghandler_6.setProperty("prmMasterId");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[20]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_7.setName("fecm002");
                    __jsp_taghandler_7.setProperty("prmValues");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[21]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_8=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_8.setName("fecm002");
                    __jsp_taghandler_8.setProperty("screenTitle");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_9.setName("fecm002");
                    __jsp_taghandler_9.setProperty("sectionTitle");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[23]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_10.setName("fecm002");
                    __jsp_taghandler_10.setProperty("findInCode");
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[24]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_11.setName("fecm002");
                    __jsp_taghandler_11.setProperty("findInDesc");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_12=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_12.setName("fecm002");
                    __jsp_taghandler_12.setProperty("sortByCode");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[26]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_13=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_13.setName("fecm002");
                    __jsp_taghandler_13.setProperty("sortByDesc");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[27]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_14=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_14.setName("fecm002");
                    __jsp_taghandler_14.setProperty("colNames");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_15=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_15.setName("fecm002");
                    __jsp_taghandler_15.setProperty("noOfColumn");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[29]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_16=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_16.setName("fecm002");
                    __jsp_taghandler_16.setProperty("preCriteria");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[30]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_17=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_17.setName("fecm002");
                    __jsp_taghandler_17.setProperty("orderBy");
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[31]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_18=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_18.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_18.setName("fecm002");
                    __jsp_taghandler_18.setProperty("ascDesc");
                    __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                    if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                  }
                  out.write(__oracle_jsp_text[32]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_19=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_19.setName("fecm002");
                    __jsp_taghandler_19.setProperty("searchPerformed");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
                  }
                  out.write(__oracle_jsp_text[33]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_20=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_20.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_20.setName("fecm002");
                    __jsp_taghandler_20.setProperty("prmRowIndex");
                    __jsp_taghandler_20.setStyleId("prmRowIndex");
                    __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                    if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,3);
                  }
                  out.write(__oracle_jsp_text[34]);
                  {
                    org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_21=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_21.setId("totalNoOfColumn");
                    __jsp_taghandler_21.setName("fecm002");
                    __jsp_taghandler_21.setProperty("noOfColumn");
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,3);
                  }
                  java.lang.Object totalNoOfColumn = null;
                  totalNoOfColumn = (java.lang.Object) pageContext.findAttribute("totalNoOfColumn");
                  out.write(__oracle_jsp_text[35]);
                  
                          int totColumn = Integer.parseInt(totalNoOfColumn.toString())  ;
                          int colWidth = totColumn-2;
                      
                  out.write(__oracle_jsp_text[36]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_22=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property");
                    __jsp_taghandler_22.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_22.setMaxlength("15");
                    __jsp_taghandler_22.setName("fecm002");
                    __jsp_taghandler_22.setProperty("findVal");
                    __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                    if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,3);
                  }
                  out.write(__oracle_jsp_text[37]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_23=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
                    __jsp_taghandler_23.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_23.setName("fecm002");
                    __jsp_taghandler_23.setProperty("findIn");
                    __jsp_taghandler_23.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_23,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[38]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_24=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_24.setParent(__jsp_taghandler_23);
                          __jsp_taghandler_24.setLabel("name");
                          __jsp_taghandler_24.setName("fecm002");
                          __jsp_taghandler_24.setProperty("findInValues");
                          __jsp_taghandler_24.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                          if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,4);
                        }
                        out.write(__oracle_jsp_text[39]);
                      } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,3);
                  }
                  out.write(__oracle_jsp_text[40]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_25=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
                    __jsp_taghandler_25.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_25.setName("fecm002");
                    __jsp_taghandler_25.setProperty("sortBy");
                    __jsp_taghandler_25.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_25,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[41]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_26=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_26.setParent(__jsp_taghandler_25);
                          __jsp_taghandler_26.setLabel("name");
                          __jsp_taghandler_26.setName("fecm002");
                          __jsp_taghandler_26.setProperty("sortByValues");
                          __jsp_taghandler_26.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                          if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,4);
                        }
                        out.write(__oracle_jsp_text[42]);
                      } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,3);
                  }
                  out.write(__oracle_jsp_text[43]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_27=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
                    __jsp_taghandler_27.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_27.setName("fecm002");
                    __jsp_taghandler_27.setProperty("sortIn");
                    __jsp_taghandler_27.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_27,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[44]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_28=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_28.setParent(__jsp_taghandler_27);
                          __jsp_taghandler_28.setLabel("name");
                          __jsp_taghandler_28.setName("fecm002");
                          __jsp_taghandler_28.setProperty("sortInValues");
                          __jsp_taghandler_28.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                          if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,4);
                        }
                        out.write(__oracle_jsp_text[45]);
                      } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,3);
                  }
                  out.write(__oracle_jsp_text[46]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_29=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_29.setName("fecm002");
                    __jsp_taghandler_29.setProperty("recStatus");
                    __jsp_taghandler_29.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_29,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[47]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_30=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_30.setParent(__jsp_taghandler_29);
                          __jsp_taghandler_30.setLabel("name");
                          __jsp_taghandler_30.setName("fecm002");
                          __jsp_taghandler_30.setProperty("recStatusValues");
                          __jsp_taghandler_30.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                          if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,4);
                        }
                        out.write(__oracle_jsp_text[48]);
                      } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[49]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_31=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
                    __jsp_taghandler_31.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_31.setName("fecm002");
                    __jsp_taghandler_31.setProperty("wildCard");
                    __jsp_taghandler_31.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_31,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[50]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_32=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_32.setParent(__jsp_taghandler_31);
                          __jsp_taghandler_32.setLabel("name");
                          __jsp_taghandler_32.setName("fecm002");
                          __jsp_taghandler_32.setProperty("wildCardValues");
                          __jsp_taghandler_32.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
                          if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,4);
                        }
                        out.write(__oracle_jsp_text[51]);
                      } while (__jsp_taghandler_31.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,3);
                  }
                  out.write(__oracle_jsp_text[52]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_33=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
                    __jsp_taghandler_33.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_33.setId("rowdata");
                    __jsp_taghandler_33.setIndexId("ctr");
                    __jsp_taghandler_33.setName("fecm002");
                    __jsp_taghandler_33.setProperty("columnHeader");
                    __jsp_taghandler_33.setType("java.lang.String");
                    java.lang.String rowdata = null;
                    java.lang.Integer ctr = null;
                    __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_33,__jsp_tag_starteval,out);
                      do {
                        rowdata = (java.lang.String) pageContext.findAttribute("rowdata");
                        ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                        out.write(__oracle_jsp_text[53]);
                              if(ctr == 0){       
                        out.write(__oracle_jsp_text[54]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[55]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_34=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_34.setParent(__jsp_taghandler_33);
                          __jsp_taghandler_34.setName("fecm002");
                          __jsp_taghandler_34.setProperty(OracleJspRuntime.toStr( "colName["+ctr+"]"));
                          __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
                          if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,4);
                        }
                        out.write(__oracle_jsp_text[56]);
                              }else if(ctr == 1){     
                        out.write(__oracle_jsp_text[57]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[58]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_35=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_35.setParent(__jsp_taghandler_33);
                          __jsp_taghandler_35.setName("fecm002");
                          __jsp_taghandler_35.setProperty(OracleJspRuntime.toStr( "colName["+ctr+"]"));
                          __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
                          if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,4);
                        }
                        out.write(__oracle_jsp_text[59]);
                              }else if(ctr != colWidth+1){        
                        out.write(__oracle_jsp_text[60]);
                        out.print((65/colWidth)+"%");
                        out.write(__oracle_jsp_text[61]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[62]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_36=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_36.setParent(__jsp_taghandler_33);
                          __jsp_taghandler_36.setName("fecm002");
                          __jsp_taghandler_36.setProperty(OracleJspRuntime.toStr( "colName["+ctr+"]"));
                          __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
                          if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,4);
                        }
                        out.write(__oracle_jsp_text[63]);
                              }else{      
                        out.write(__oracle_jsp_text[64]);
                        out.write(__oracle_jsp_text[65]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[66]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_37=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_37.setParent(__jsp_taghandler_33);
                          __jsp_taghandler_37.setName("fecm002");
                          __jsp_taghandler_37.setProperty(OracleJspRuntime.toStr( "colName["+ctr+"]"));
                          __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
                          if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,4);
                        }
                        out.write(__oracle_jsp_text[67]);
                              }       
                        out.write(__oracle_jsp_text[68]);
                      } while (__jsp_taghandler_33.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,3);
                  }
                  out.write(__oracle_jsp_text[69]);
                  {
                    org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_38=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                    __jsp_taghandler_38.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_38.setName("fecm002");
                    __jsp_taghandler_38.setProperty("values");
                    __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[70]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_39=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
                          __jsp_taghandler_39.setParent(__jsp_taghandler_38);
                          __jsp_taghandler_39.setId("rowdata");
                          __jsp_taghandler_39.setIndexId("ctr");
                          __jsp_taghandler_39.setName("fecm002");
                          __jsp_taghandler_39.setProperty("values");
                          __jsp_taghandler_39.setType("com.rclgroup.dolphin.ezl.web.ecm.vo.EcmMasterLookupMod");
                          com.rclgroup.dolphin.ezl.web.ecm.vo.EcmMasterLookupMod rowdata = null;
                          java.lang.Integer ctr = null;
                          __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_39,__jsp_tag_starteval,out);
                            do {
                              rowdata = (com.rclgroup.dolphin.ezl.web.ecm.vo.EcmMasterLookupMod) pageContext.findAttribute("rowdata");
                              ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                              out.write(__oracle_jsp_text[71]);
                              out.write(__oracle_jsp_text[72]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[73]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[74]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_40=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_40.setParent(__jsp_taghandler_39);
                                __jsp_taghandler_40.setName("fecm002");
                                __jsp_taghandler_40.setProperty(OracleJspRuntime.toStr( "value["+ctr+"].srlNo"));
                                __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
                                if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,5);
                              }
                              out.write(__oracle_jsp_text[75]);
                               for (int i=1; i<=totColumn;i++){
                                      if(i == 1){ 
                              
                              out.write(__oracle_jsp_text[76]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_41=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_41.setParent(__jsp_taghandler_39);
                                __jsp_taghandler_41.setName("fecm002");
                                __jsp_taghandler_41.setProperty(OracleJspRuntime.toStr( "value["+ctr+"].col1"));
                                __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
                                if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,5);
                              }
                              out.write(__oracle_jsp_text[77]);
                                    }else if(i == 2){   
                              out.write(__oracle_jsp_text[78]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_42=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_42.setParent(__jsp_taghandler_39);
                                __jsp_taghandler_42.setName("fecm002");
                                __jsp_taghandler_42.setProperty(OracleJspRuntime.toStr( "value["+ctr+"].col2"));
                                __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
                                if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,5);
                              }
                              out.write(__oracle_jsp_text[79]);
                                    }else if(i != totColumn) {      
                              out.write(__oracle_jsp_text[80]);
                              out.print((65/colWidth)+"%");
                              out.write(__oracle_jsp_text[81]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_43=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_43.setParent(__jsp_taghandler_39);
                                __jsp_taghandler_43.setName("fecm002");
                                __jsp_taghandler_43.setProperty(OracleJspRuntime.toStr( "value["+ctr+"].col"+i));
                                __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
                                if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,5);
                              }
                              out.write(__oracle_jsp_text[82]);
                                    } else { 
                              out.write(__oracle_jsp_text[83]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_44=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_44.setParent(__jsp_taghandler_39);
                                __jsp_taghandler_44.setName("fecm002");
                                __jsp_taghandler_44.setProperty(OracleJspRuntime.toStr( "value["+ctr+"].col"+i));
                                __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
                                if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,5);
                              }
                              out.write(__oracle_jsp_text[84]);
                                    } 
                                  }
                              
                              out.write(__oracle_jsp_text[85]);
                            } while (__jsp_taghandler_39.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,4);
                        }
                        out.write(__oracle_jsp_text[86]);
                      } while (__jsp_taghandler_38.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,3);
                  }
                  out.write(__oracle_jsp_text[87]);
                  {
                    org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_45=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
                    __jsp_taghandler_45.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_45.setName("fecm002");
                    __jsp_taghandler_45.setProperty("values");
                    __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[88]);
                      } while (__jsp_taghandler_45.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,3);
                  }
                  out.write(__oracle_jsp_text[89]);
                  {
                    String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
                    __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("fecm002") } );
                    // Include 
                    pageContext.include( __url,false);
                    if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
                  }

                  out.write(__oracle_jsp_text[90]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[91]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[92]);

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
  private static final char __oracle_jsp_text[][]=new char[93][];
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
    "\r\n<head> \r\n<title> ".toCharArray();
    __oracle_jsp_text[12] = 
    "</title>\r\n<script type=\"text/javaScript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/js/RutHelp.js\" ></script>\r\n<script type=\"text/javaScript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/js/screen/EcmMasterLookup.js\" ></script>\r\n<script type=\"text/javaScript\" language=\"JavaScript\">\r\n    var contextPath4Date    = \"".toCharArray();
    __oracle_jsp_text[15] = 
    "\";\r\n    var BROWSE_FSC_LOOKUP   = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\r\n    \r\n    function onLoad() {    \r\n        lastFindVal     = document.forms[0].findVal.value;\r\n        lastFindIn      = document.forms[0].findIn.value;\r\n        lastWildCard    = document.forms[0].wildCard.value;\r\n        lastSortBy      = document.forms[0].sortBy.value;\r\n        lastSortIn      = document.forms[0].sortIn.value;\r\n        lastRecStatus   = document.forms[0].recStatus.value;\r\n        \r\n        lastOrderBy     = document.forms[0].orderBy.value;\r\n        lastAscDesc     = document.forms[0].ascDesc.value;\r\n        \r\n        \r\n        //Focus on Module Combo Box\r\n        document.forms[0].findVal.focus();        \r\n    }\r\n    \r\n    function openHelp() {\r\n        \r\n        var strFileName = '1';\r\n        var strUrl = \"/RCLWebApp/help/ApplicationHelp.htm#\"+strFileName;\r\n        var objWindow = window.open(strUrl,\"Help\",\"width=900,height=600,status=no,resizable=no,top=150,left=150\");\r\n        objWindow.focus();\r\n    }\r\n</script>\r\n</head>\r\n<body>    \r\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[23] = 
    "   \r\n    ".toCharArray();
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
    "\r\n    <input type=\"hidden\" name=\"pageId\" value=\"customerPopup\"/>\r\n    <!--Begin @01 -->\r\n    ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n    <!--End @01 -->\r\n    ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n    <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr>\r\n            <td width=\"10%\">Find</td>\r\n            <td width=\"30%\">\r\n                ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n            </td>\r\n            <td width=\"10%\">In</td>\r\n            <td width=\"25%\">\r\n                ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n            </td>\r\n            <td valign=\"top\" style=\"padding-top:1px;padding-left:9px;\">\r\n                <a id=\"btnSearch\" name=\"btnSearch\" class=\"m-btn mini blue rnd\" href=\"#\" onClick=\"onSearch()\">\r\n                    Search\r\n                </a>\r\n                <a id=\"btnReset\" name=\"btnReset\" class=\"m-btn mini blue rnd\" href=\"#\" onClick=\"onResetForm()\">\r\n                    Reset\r\n                </a>\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td>Sort by</td>\r\n            <td>\r\n               ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                   ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n            </td>\r\n            <td>In</td>\r\n            <td colspan=\"2\">\r\n                ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td>Status</td>\r\n            <td class=\"whitebg\">\r\n                ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n            </td>   \r\n            <td>Wild Card</td>\r\n            <td colspan=\"2\">\r\n                ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n            </td>\r\n        </tr>\r\n    </table><br />\r\n    <table class=\"TablePopup\">\r\n        <tr>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"5%\">Seq#</td>\r\n        ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n            <td class=\"TdLeftHeaderPopup\" width=\"10%\" id=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\">\r\n                ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n            <td class=\"TdLeftHeaderPopup\" width=\"20%\" id=\"".toCharArray();
    __oracle_jsp_text[58] = 
    "\">\r\n                ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[60] = 
    "\r\n            <td class=\"TdLeftHeaderPopup\" width=\"".toCharArray();
    __oracle_jsp_text[61] = 
    "\" id=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\">\r\n                ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n            <td class=\"TdLeftHeaderPopup\" id=\"".toCharArray();
    __oracle_jsp_text[66] = 
    "\" onclick=\"sortData(this.id)\">\r\n                ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[68] = 
    "                            \r\n            ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n        </tr>  \r\n    </table>\r\n    <table class=\"TablePopup\">\r\n    ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[72] = 
    "\r\n        <tr id=\"row".toCharArray();
    __oracle_jsp_text[73] = 
    "\"  onclick=\"highlightradioTD('row".toCharArray();
    __oracle_jsp_text[74] = 
    "')\" ondblclick=\"returnValues(this.id)\">\r\n            <td class=\"TdLeftDetailPopup\" width=\"5%\" >\r\n                ".toCharArray();
    __oracle_jsp_text[75] = 
    "</td>\r\n".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n            <td class=\"TdLeftDetailPopup\" width=\"10%\" >\r\n                ".toCharArray();
    __oracle_jsp_text[77] = 
    "</td>\r\n".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n            <td class=\"TdLeftDetailPopup\" width=\"20%\"  >\r\n                ".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[80] = 
    "\r\n            <td class=\"TdLeftDetailPopup\" width='".toCharArray();
    __oracle_jsp_text[81] = 
    "'  >\r\n                ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n            <td class=\"TdLeftDetailPopup\">\r\n                ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n            </td>\r\n".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n                                    \r\n        </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[86] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[87] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[88] = 
    "\r\n        <tr style=\"height: 20px\">    \r\n            <td align=\"center\">No record found.</td>\r\n        </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[89] = 
    "\r\n    </table>\r\n    ".toCharArray();
    __oracle_jsp_text[90] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[91] = 
    "\r\n</body>\r\n".toCharArray();
    __oracle_jsp_text[92] = 
    "\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

package _pages._ell;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.ideo.sweetdevria.taglib.alert.AlertTag;
import com.ideo.sweetdevria.taglib.grid.common.BaseColumnHeaderTag;
import com.ideo.sweetdevria.taglib.frame.FrameTag;
import com.niit.control.common.GlobalConstants;
import com.niit.control.web.action.BaseAction;
import com.niit.control.common.ria.grid.common.GridConstants;
import com.niit.control.common.ria.grid.common.PersistGridData;


public class _EllLoadListMaintenanceBookedTabGrid__new extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html;charset=UTF-8");
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
    _EllLoadListMaintenanceBookedTabGrid__new page = this;
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
       String lstrContextPath = request.getContextPath(); 
      out.write(__oracle_jsp_text[12]);
      {
        com.ideo.sweetdevria.taglib.resourcesImport.ResourcesImportTag __jsp_taghandler_1=(com.ideo.sweetdevria.taglib.resourcesImport.ResourcesImportTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.resourcesImport.ResourcesImportTag.class,"com.ideo.sweetdevria.taglib.resourcesImport.ResourcesImportTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[13]);
      out.print(lstrContextPath);
      out.write(__oracle_jsp_text[14]);
      out.print(lstrContextPath);
      out.write(__oracle_jsp_text[15]);
      out.print(lstrContextPath);
      out.write(__oracle_jsp_text[16]);
      out.print(GridConstants.GRID_ID);
      out.write(__oracle_jsp_text[17]);
      {
        org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property value");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setName("fell002");
        __jsp_taghandler_2.setProperty("pageId");
        __jsp_taghandler_2.setValue(OracleJspRuntime.toStr( com.ideo.sweetdevria.page.Page.getPageId(request)));
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[18]);
      {
        com.ideo.sweetdevria.taglib.grid.grid.GridTag __jsp_taghandler_3=(com.ideo.sweetdevria.taglib.grid.grid.GridTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridTag id height heightHeader heightRow resizable width persistanceClassName frameDisplayed showPropertyButton");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setId(OracleJspRuntime.toStr( GridConstants.GRID_ID));
        __jsp_taghandler_3.setHeight("287px");
        __jsp_taghandler_3.setHeightHeader("32");
        __jsp_taghandler_3.setHeightRow("31");
        __jsp_taghandler_3.setResizable(false);
        __jsp_taghandler_3.setWidth("100%");
        __jsp_taghandler_3.setPersistanceClassName("com.niit.control.common.ria.grid.common.PersistGridData");
        __jsp_taghandler_3.setFrameDisplayed(false);
        __jsp_taghandler_3.setShowPropertyButton(false);
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[19]);
            {
              com.ideo.sweetdevria.taglib.grid.grid.GridHeaderTag __jsp_taghandler_4=(com.ideo.sweetdevria.taglib.grid.grid.GridHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridHeaderTag");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[20]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_5=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_5.setLabel("BL #");
                    __jsp_taghandler_5.setWidth("50px");
                    __jsp_taghandler_5.setId("billNo");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[21]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_6=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_6.setLabel("Booking No. Source");
                    __jsp_taghandler_6.setWidth("50px");
                    __jsp_taghandler_6.setId("equipmentNoSource");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_7=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_7.setLabel("Size");
                    __jsp_taghandler_7.setWidth("50px");
                    __jsp_taghandler_7.setId("size");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[23]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_8=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_8.setLabel("Equipment Type");
                    __jsp_taghandler_8.setWidth("50px");
                    __jsp_taghandler_8.setId("equipmentType");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[24]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_9=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_9.setLabel("Full/MT");
                    __jsp_taghandler_9.setWidth("50px");
                    __jsp_taghandler_9.setId("fullMT");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_10=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_10.setLabel("Booking Type");
                    __jsp_taghandler_10.setWidth("50px");
                    __jsp_taghandler_10.setId("bookingType");
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[26]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_11=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_11.setLabel("SOC/COC");
                    __jsp_taghandler_11.setWidth("50px");
                    __jsp_taghandler_11.setId("socCoc");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[27]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_12=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_12.setLabel("Shipment Term");
                    __jsp_taghandler_12.setWidth("50px");
                    __jsp_taghandler_12.setId("shipmentTerm");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_13=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_13.setLabel("Shipment Type");
                    __jsp_taghandler_13.setWidth("50px");
                    __jsp_taghandler_13.setId("shipmentType");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[29]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_14=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_14.setLabel("POL Status");
                    __jsp_taghandler_14.setWidth("50px");
                    __jsp_taghandler_14.setId("polStatus");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[30]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_15=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_15.setLabel("Local Container Status");
                    __jsp_taghandler_15.setWidth("50px");
                    __jsp_taghandler_15.setId("localContSts");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[31]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_16=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_16.setLabel("Midstream");
                    __jsp_taghandler_16.setWidth("50px");
                    __jsp_taghandler_16.setId("midstream");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[32]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_17=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_17.setLabel("Load Condition");
                    __jsp_taghandler_17.setWidth("50px");
                    __jsp_taghandler_17.setId("loadCondition");
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[33]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_18=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_18.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_18.setLabel("Loading Status");
                    __jsp_taghandler_18.setWidth("50px");
                    __jsp_taghandler_18.setId("loadingStatus");
                    __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                    if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                  }
                  out.write(__oracle_jsp_text[34]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_19=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_19.setLabel("Stow Position");
                    __jsp_taghandler_19.setWidth("50px");
                    __jsp_taghandler_19.setId("stowPosition");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
                  }
                  out.write(__oracle_jsp_text[35]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_20=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_20.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_20.setLabel("Activity Date");
                    __jsp_taghandler_20.setWidth("50px");
                    __jsp_taghandler_20.setId("activityDate");
                    __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                    if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,3);
                  }
                  out.write(__oracle_jsp_text[36]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_21=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_21.setLabel("Weight");
                    __jsp_taghandler_21.setWidth("50px");
                    __jsp_taghandler_21.setId("weight");
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,3);
                  }
                  out.write(__oracle_jsp_text[37]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_22=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_22.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_22.setLabel("Damaged");
                    __jsp_taghandler_22.setWidth("50px");
                    __jsp_taghandler_22.setId("damaged");
                    __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                    if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,3);
                  }
                  out.write(__oracle_jsp_text[38]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_23=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_23.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_23.setLabel("Crane Description");
                    __jsp_taghandler_23.setWidth("50px");
                    __jsp_taghandler_23.setId("craneDescription");
                    __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                    if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,3);
                  }
                  out.write(__oracle_jsp_text[39]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_24=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_24.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_24.setLabel("Void Slot");
                    __jsp_taghandler_24.setWidth("50px");
                    __jsp_taghandler_24.setId("voidSlot");
                    __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                    if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,3);
                  }
                  out.write(__oracle_jsp_text[40]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_25=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_25.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_25.setLabel("Preadvice");
                    __jsp_taghandler_25.setWidth("50px");
                    __jsp_taghandler_25.setId("preAdvice");
                    __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                    if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,3);
                  }
                  out.write(__oracle_jsp_text[41]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_26=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_26.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_26.setLabel("Slot Operator");
                    __jsp_taghandler_26.setWidth("50px");
                    __jsp_taghandler_26.setId("slotOperator");
                    __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                    if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,3);
                  }
                  out.write(__oracle_jsp_text[42]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_27=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_27.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_27.setLabel("Container Operator");
                    __jsp_taghandler_27.setWidth("50px");
                    __jsp_taghandler_27.setId("contOperator");
                    __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                    if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,3);
                  }
                  out.write(__oracle_jsp_text[43]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_28=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_28.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_28.setLabel("Out Slot Operator");
                    __jsp_taghandler_28.setWidth("50px");
                    __jsp_taghandler_28.setId("outSlotOperator");
                    __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                    if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,3);
                  }
                  out.write(__oracle_jsp_text[44]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_29=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_29.setLabel("Special Handling");
                    __jsp_taghandler_29.setWidth("50px");
                    __jsp_taghandler_29.setId("specialHandling");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[45]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_30=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_30.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_30.setLabel("Seal No.");
                    __jsp_taghandler_30.setWidth("50px");
                    __jsp_taghandler_30.setId("sealNo");
                    __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                    if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,3);
                  }
                  out.write(__oracle_jsp_text[46]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_31=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_31.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_31.setLabel("POD");
                    __jsp_taghandler_31.setWidth("50px");
                    __jsp_taghandler_31.setId("pod");
                    __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
                    if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,3);
                  }
                  out.write(__oracle_jsp_text[47]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_32=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_32.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_32.setLabel("POD Terminal");
                    __jsp_taghandler_32.setWidth("50px");
                    __jsp_taghandler_32.setId("podTerminal");
                    __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
                    if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,3);
                  }
                  out.write(__oracle_jsp_text[48]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_33=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_33.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_33.setLabel("Next POD1");
                    __jsp_taghandler_33.setWidth("50px");
                    __jsp_taghandler_33.setId("nextPOD1");
                    __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
                    if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,3);
                  }
                  out.write(__oracle_jsp_text[49]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_34=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_34.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_34.setLabel("Next POD2");
                    __jsp_taghandler_34.setWidth("50px");
                    __jsp_taghandler_34.setId("nextPOD2");
                    __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
                    if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,3);
                  }
                  out.write(__oracle_jsp_text[50]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_35=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_35.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_35.setLabel("Next POD3");
                    __jsp_taghandler_35.setWidth("50px");
                    __jsp_taghandler_35.setId("nextPOD3");
                    __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
                    if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,3);
                  }
                  out.write(__oracle_jsp_text[51]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_36=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_36.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_36.setLabel("Final POD");
                    __jsp_taghandler_36.setWidth("50px");
                    __jsp_taghandler_36.setId("finalPOD");
                    __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
                    if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,3);
                  }
                  out.write(__oracle_jsp_text[52]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_37=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_37.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_37.setLabel("Final Destination");
                    __jsp_taghandler_37.setWidth("50px");
                    __jsp_taghandler_37.setId("finalDest");
                    __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
                    if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,3);
                  }
                  out.write(__oracle_jsp_text[53]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_38=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_38.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_38.setLabel("Next Service");
                    __jsp_taghandler_38.setWidth("50px");
                    __jsp_taghandler_38.setId("nextService");
                    __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
                    if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,3);
                  }
                  out.write(__oracle_jsp_text[54]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_39=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_39.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_39.setLabel("Next Vessel");
                    __jsp_taghandler_39.setWidth("50px");
                    __jsp_taghandler_39.setId("nextVessel");
                    __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
                    if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,3);
                  }
                  out.write(__oracle_jsp_text[55]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_40=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_40.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_40.setLabel("Next Voyage");
                    __jsp_taghandler_40.setWidth("50px");
                    __jsp_taghandler_40.setId("nextVoyage");
                    __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
                    if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,3);
                  }
                  out.write(__oracle_jsp_text[56]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_41=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_41.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_41.setLabel("Next Direction");
                    __jsp_taghandler_41.setWidth("50px");
                    __jsp_taghandler_41.setId("nextDirection");
                    __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
                    if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,3);
                  }
                  out.write(__oracle_jsp_text[57]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_42=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_42.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_42.setLabel("Connecting MLO Vessel");
                    __jsp_taghandler_42.setWidth("50px");
                    __jsp_taghandler_42.setId("connectingMLOVessel");
                    __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
                    if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,3);
                  }
                  out.write(__oracle_jsp_text[58]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_43=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_43.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_43.setLabel("Connecting MLO Voyage");
                    __jsp_taghandler_43.setWidth("50px");
                    __jsp_taghandler_43.setId("connectingMLOVoyage");
                    __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
                    if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,3);
                  }
                  out.write(__oracle_jsp_text[59]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_44=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_44.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_44.setLabel("MLO ETA Date");
                    __jsp_taghandler_44.setWidth("50px");
                    __jsp_taghandler_44.setId("mloETADate");
                    __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
                    if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,3);
                  }
                  out.write(__oracle_jsp_text[60]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_45=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_45.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_45.setLabel("Connecting MLO POD1");
                    __jsp_taghandler_45.setWidth("50px");
                    __jsp_taghandler_45.setId("connectingMLOPOD1");
                    __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
                    if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,3);
                  }
                  out.write(__oracle_jsp_text[61]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_46=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_46.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_46.setLabel("Connecting MLO POD2");
                    __jsp_taghandler_46.setWidth("50px");
                    __jsp_taghandler_46.setId("connectingMLOPOD2");
                    __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
                    if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,3);
                  }
                  out.write(__oracle_jsp_text[62]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_47=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_47.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_47.setLabel("Connecting MLO POD3");
                    __jsp_taghandler_47.setWidth("50px");
                    __jsp_taghandler_47.setId("connectingMLOPOD3");
                    __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
                    if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,3);
                  }
                  out.write(__oracle_jsp_text[63]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_48=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_48.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_48.setLabel("Place Of Delivery");
                    __jsp_taghandler_48.setWidth("50px");
                    __jsp_taghandler_48.setId("placeOfDel");
                    __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
                    if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,3);
                  }
                  out.write(__oracle_jsp_text[64]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_49=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_49.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_49.setLabel("Ex MLO Vessel");
                    __jsp_taghandler_49.setWidth("50px");
                    __jsp_taghandler_49.setId("exMLOVessel");
                    __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
                    if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,3);
                  }
                  out.write(__oracle_jsp_text[65]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_50=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_50.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_50.setLabel("Ex MLO Voyage");
                    __jsp_taghandler_50.setWidth("50px");
                    __jsp_taghandler_50.setId("exMLOVoyage");
                    __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
                    if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,3);
                  }
                  out.write(__oracle_jsp_text[66]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_51=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_51.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_51.setLabel("Ex MLO Vessel ETA");
                    __jsp_taghandler_51.setWidth("50px");
                    __jsp_taghandler_51.setId("exMloETADate");
                    __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
                    if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,3);
                  }
                  out.write(__oracle_jsp_text[67]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_52=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_52.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_52.setLabel("Handling Instruction 1 Code");
                    __jsp_taghandler_52.setWidth("50px");
                    __jsp_taghandler_52.setId("handlingInstCode1");
                    __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
                    if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,3);
                  }
                  out.write(__oracle_jsp_text[68]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_53=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_53.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_53.setLabel("Handling Instruction 1 Description");
                    __jsp_taghandler_53.setWidth("50px");
                    __jsp_taghandler_53.setId("handlingInstDesc1");
                    __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
                    if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,3);
                  }
                  out.write(__oracle_jsp_text[69]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_54=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_54.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_54.setLabel("Handling Instruction 2 Code");
                    __jsp_taghandler_54.setWidth("50px");
                    __jsp_taghandler_54.setId("handlingInstCode2");
                    __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
                    if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,3);
                  }
                  out.write(__oracle_jsp_text[70]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_55=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_55.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_55.setLabel("Handling Instruction 2 Description");
                    __jsp_taghandler_55.setWidth("50px");
                    __jsp_taghandler_55.setId("handlingInstDesc2");
                    __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
                    if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,3);
                  }
                  out.write(__oracle_jsp_text[71]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_56=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_56.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_56.setLabel("Handling Instruction 3 Code");
                    __jsp_taghandler_56.setWidth("50px");
                    __jsp_taghandler_56.setId("handlingInstCode3");
                    __jsp_tag_starteval=__jsp_taghandler_56.doStartTag();
                    if (__jsp_taghandler_56.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_56,3);
                  }
                  out.write(__oracle_jsp_text[72]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_57=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_57.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_57.setLabel("Handling Instruction 3 Description");
                    __jsp_taghandler_57.setWidth("50px");
                    __jsp_taghandler_57.setId("handlingInstDesc3");
                    __jsp_tag_starteval=__jsp_taghandler_57.doStartTag();
                    if (__jsp_taghandler_57.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_57,3);
                  }
                  out.write(__oracle_jsp_text[73]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_58=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_58.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_58.setLabel("Container Loading Remark 1");
                    __jsp_taghandler_58.setWidth("50px");
                    __jsp_taghandler_58.setId("contLoadRemark1");
                    __jsp_tag_starteval=__jsp_taghandler_58.doStartTag();
                    if (__jsp_taghandler_58.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_58,3);
                  }
                  out.write(__oracle_jsp_text[74]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_59=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_59.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_59.setLabel("Container Loading Remark 2");
                    __jsp_taghandler_59.setWidth("50px");
                    __jsp_taghandler_59.setId("contLoadRemark2");
                    __jsp_tag_starteval=__jsp_taghandler_59.doStartTag();
                    if (__jsp_taghandler_59.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_59,3);
                  }
                  out.write(__oracle_jsp_text[75]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_60=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_60.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_60.setLabel("Special Cargo");
                    __jsp_taghandler_60.setWidth("50px");
                    __jsp_taghandler_60.setId("specialCargo");
                    __jsp_tag_starteval=__jsp_taghandler_60.doStartTag();
                    if (__jsp_taghandler_60.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_60,3);
                  }
                  out.write(__oracle_jsp_text[76]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_61=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_61.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_61.setLabel("Tight Connection @ POD1");
                    __jsp_taghandler_61.setWidth("50px");
                    __jsp_taghandler_61.setId("tightConnectionPOD1");
                    __jsp_tag_starteval=__jsp_taghandler_61.doStartTag();
                    if (__jsp_taghandler_61.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_61,3);
                  }
                  out.write(__oracle_jsp_text[77]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_62=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_62.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_62.setLabel("Tight Connection @ POD2");
                    __jsp_taghandler_62.setWidth("50px");
                    __jsp_taghandler_62.setId("tightConnectionPOD2");
                    __jsp_tag_starteval=__jsp_taghandler_62.doStartTag();
                    if (__jsp_taghandler_62.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_62,3);
                  }
                  out.write(__oracle_jsp_text[78]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_63=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_63.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_63.setLabel("Tight Connection @ POD3");
                    __jsp_taghandler_63.setWidth("50px");
                    __jsp_taghandler_63.setId("tightConnectionPOD3");
                    __jsp_tag_starteval=__jsp_taghandler_63.doStartTag();
                    if (__jsp_taghandler_63.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_63,3);
                  }
                  out.write(__oracle_jsp_text[79]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_64=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_64.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_64.setLabel("IMDG Class");
                    __jsp_taghandler_64.setWidth("50px");
                    __jsp_taghandler_64.setId("imdgClass");
                    __jsp_tag_starteval=__jsp_taghandler_64.doStartTag();
                    if (__jsp_taghandler_64.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_64,3);
                  }
                  out.write(__oracle_jsp_text[80]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_65=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_65.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_65.setLabel("UN Number");
                    __jsp_taghandler_65.setWidth("50px");
                    __jsp_taghandler_65.setId("unNumber");
                    __jsp_tag_starteval=__jsp_taghandler_65.doStartTag();
                    if (__jsp_taghandler_65.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_65,3);
                  }
                  out.write(__oracle_jsp_text[81]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_66=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_66.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_66.setLabel("UN Number Variant");
                    __jsp_taghandler_66.setWidth("50px");
                    __jsp_taghandler_66.setId("unNumberVariant");
                    __jsp_tag_starteval=__jsp_taghandler_66.doStartTag();
                    if (__jsp_taghandler_66.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_66,3);
                  }
                  out.write(__oracle_jsp_text[82]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_67=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_67.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_67.setLabel("Port Class");
                    __jsp_taghandler_67.setWidth("50px");
                    __jsp_taghandler_67.setId("portClass");
                    __jsp_tag_starteval=__jsp_taghandler_67.doStartTag();
                    if (__jsp_taghandler_67.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_67,3);
                  }
                  out.write(__oracle_jsp_text[83]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_68=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_68.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_68.setLabel("Port Class Type");
                    __jsp_taghandler_68.setWidth("50px");
                    __jsp_taghandler_68.setId("portClassType");
                    __jsp_tag_starteval=__jsp_taghandler_68.doStartTag();
                    if (__jsp_taghandler_68.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_68,3);
                  }
                  out.write(__oracle_jsp_text[84]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_69=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_69.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_69.setLabel("Flash Unit");
                    __jsp_taghandler_69.setWidth("50px");
                    __jsp_taghandler_69.setId("flashUnit");
                    __jsp_tag_starteval=__jsp_taghandler_69.doStartTag();
                    if (__jsp_taghandler_69.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_69,3);
                  }
                  out.write(__oracle_jsp_text[85]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_70=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_70.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_70.setLabel("Flash Point");
                    __jsp_taghandler_70.setWidth("50px");
                    __jsp_taghandler_70.setId("flashPoint");
                    __jsp_tag_starteval=__jsp_taghandler_70.doStartTag();
                    if (__jsp_taghandler_70.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_70,3);
                  }
                  out.write(__oracle_jsp_text[86]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_71=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_71.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_71.setLabel("Fumigation Only");
                    __jsp_taghandler_71.setWidth("50px");
                    __jsp_taghandler_71.setId("fumigationOnly");
                    __jsp_tag_starteval=__jsp_taghandler_71.doStartTag();
                    if (__jsp_taghandler_71.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_71,3);
                  }
                  out.write(__oracle_jsp_text[87]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_72=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_72.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_72.setLabel("Residue");
                    __jsp_taghandler_72.setWidth("50px");
                    __jsp_taghandler_72.setId("residue");
                    __jsp_tag_starteval=__jsp_taghandler_72.doStartTag();
                    if (__jsp_taghandler_72.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_72,3);
                  }
                  out.write(__oracle_jsp_text[88]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_73=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_73.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_73.setLabel("Overheight");
                    __jsp_taghandler_73.setWidth("50px");
                    __jsp_taghandler_73.setId("overheight");
                    __jsp_tag_starteval=__jsp_taghandler_73.doStartTag();
                    if (__jsp_taghandler_73.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_73,3);
                  }
                  out.write(__oracle_jsp_text[89]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_74=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_74.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_74.setLabel("Overwidth Left");
                    __jsp_taghandler_74.setWidth("50px");
                    __jsp_taghandler_74.setId("overwidthLeft");
                    __jsp_tag_starteval=__jsp_taghandler_74.doStartTag();
                    if (__jsp_taghandler_74.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_74,3);
                  }
                  out.write(__oracle_jsp_text[90]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_75=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_75.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_75.setLabel("Overwidth Right");
                    __jsp_taghandler_75.setWidth("50px");
                    __jsp_taghandler_75.setId("overwidthRight");
                    __jsp_tag_starteval=__jsp_taghandler_75.doStartTag();
                    if (__jsp_taghandler_75.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_75,3);
                  }
                  out.write(__oracle_jsp_text[91]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_76=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_76.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_76.setLabel("Overlength Front");
                    __jsp_taghandler_76.setWidth("50px");
                    __jsp_taghandler_76.setId("overlengthFront");
                    __jsp_tag_starteval=__jsp_taghandler_76.doStartTag();
                    if (__jsp_taghandler_76.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_76,3);
                  }
                  out.write(__oracle_jsp_text[92]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_77=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_77.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_77.setLabel("Overlength After");
                    __jsp_taghandler_77.setWidth("50px");
                    __jsp_taghandler_77.setId("overlengthAfter");
                    __jsp_tag_starteval=__jsp_taghandler_77.doStartTag();
                    if (__jsp_taghandler_77.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_77,3);
                  }
                  out.write(__oracle_jsp_text[93]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_78=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_78.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_78.setLabel("Reefer Temperature");
                    __jsp_taghandler_78.setWidth("50px");
                    __jsp_taghandler_78.setId("reeferTemp");
                    __jsp_tag_starteval=__jsp_taghandler_78.doStartTag();
                    if (__jsp_taghandler_78.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_78,3);
                  }
                  out.write(__oracle_jsp_text[94]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_79=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_79.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_79.setLabel("Reefer Temperature Unit");
                    __jsp_taghandler_79.setWidth("50px");
                    __jsp_taghandler_79.setId("reeferTempUnit");
                    __jsp_tag_starteval=__jsp_taghandler_79.doStartTag();
                    if (__jsp_taghandler_79.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_79,3);
                  }
                  out.write(__oracle_jsp_text[95]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_80=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_80.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_80.setLabel("Humidity");
                    __jsp_taghandler_80.setWidth("50px");
                    __jsp_taghandler_80.setId("humidity");
                    __jsp_tag_starteval=__jsp_taghandler_80.doStartTag();
                    if (__jsp_taghandler_80.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_80,3);
                  }
                  out.write(__oracle_jsp_text[96]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_81=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_81.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_81.setLabel("Ventilation");
                    __jsp_taghandler_81.setWidth("50px");
                    __jsp_taghandler_81.setId("ventilation");
                    __jsp_tag_starteval=__jsp_taghandler_81.doStartTag();
                    if (__jsp_taghandler_81.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_81,3);
                  }
                  out.write(__oracle_jsp_text[97]);
                  {
                    com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag __jsp_taghandler_82=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnHeaderTag label width id");
                    __jsp_taghandler_82.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_82.setLabel("Remarks");
                    __jsp_taghandler_82.setWidth("50px");
                    __jsp_taghandler_82.setId("remarks");
                    __jsp_tag_starteval=__jsp_taghandler_82.doStartTag();
                    if (__jsp_taghandler_82.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_82,3);
                  }
                  out.write(__oracle_jsp_text[98]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[99]);
            {
              com.ideo.sweetdevria.taglib.grid.grid.GridBodyIteratorTag __jsp_taghandler_83=(com.ideo.sweetdevria.taglib.grid.grid.GridBodyIteratorTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridBodyIteratorTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridBodyIteratorTag collection var rowPerPage rowCountVar");
              __jsp_taghandler_83.setParent(__jsp_taghandler_3);
              __jsp_taghandler_83.setCollection((java.util.Collection)oracle.jsp.runtime.OracleJspRuntime.evaluate("${KEY_SCREEN_GRID_DATA}",java.util.Collection.class, __ojsp_varRes,null));
              __jsp_taghandler_83.setVar("col");
              __jsp_taghandler_83.setRowPerPage(1000);
              __jsp_taghandler_83.setRowCountVar("rowCount");
              __jsp_tag_starteval=__jsp_taghandler_83.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[100]);
                  {
                    com.ideo.sweetdevria.taglib.grid.common.GridRowTag __jsp_taghandler_84=(com.ideo.sweetdevria.taglib.grid.common.GridRowTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.common.GridRowTag.class,"com.ideo.sweetdevria.taglib.grid.common.GridRowTag id");
                    __jsp_taghandler_84.setParent(__jsp_taghandler_83);
                    __jsp_taghandler_84.setId((java.lang.String) ("row"+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)));
                    __jsp_tag_starteval=__jsp_taghandler_84.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[101]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_85=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_85.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_85.setId("billNo");
                          __jsp_tag_starteval=__jsp_taghandler_85.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_85,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[102]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_86=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_86.setParent(__jsp_taghandler_85);
                                __jsp_taghandler_86.setMaxlength("17");
                                __jsp_taghandler_86.setName("fell002");
                                __jsp_taghandler_86.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].billNo"));
                                __jsp_taghandler_86.setReadonly(true);
                                __jsp_taghandler_86.setStyle("width:96%");
                                __jsp_taghandler_86.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_86.doStartTag();
                                if (__jsp_taghandler_86.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_86,5);
                              }
                              out.write(__oracle_jsp_text[103]);
                            } while (__jsp_taghandler_85.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_85.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_85,4);
                        }
                        out.write(__oracle_jsp_text[104]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_87=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_87.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_87.setId("equipmentNoSource");
                          __jsp_tag_starteval=__jsp_taghandler_87.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_87,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[105]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_88=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_88.setParent(__jsp_taghandler_87);
                                __jsp_taghandler_88.setMaxlength("15");
                                __jsp_taghandler_88.setName("fell002");
                                __jsp_taghandler_88.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].equipmentNoSource"));
                                __jsp_taghandler_88.setReadonly(true);
                                __jsp_taghandler_88.setStyle("width:96%");
                                __jsp_taghandler_88.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_88.doStartTag();
                                if (__jsp_taghandler_88.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_88,5);
                              }
                              out.write(__oracle_jsp_text[106]);
                            } while (__jsp_taghandler_87.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_87.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_87,4);
                        }
                        out.write(__oracle_jsp_text[107]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_89=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_89.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_89.setId("size");
                          __jsp_tag_starteval=__jsp_taghandler_89.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_89,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_90=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_90.setParent(__jsp_taghandler_89);
                                __jsp_taghandler_90.setMaxlength("2");
                                __jsp_taghandler_90.setName("fell002");
                                __jsp_taghandler_90.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].size"));
                                __jsp_taghandler_90.setReadonly(true);
                                __jsp_taghandler_90.setStyle("width:96%");
                                __jsp_taghandler_90.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_90.doStartTag();
                                if (__jsp_taghandler_90.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_90,5);
                              }
                            } while (__jsp_taghandler_89.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_89.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_89,4);
                        }
                        out.write(__oracle_jsp_text[108]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_91=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_91.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_91.setId("equipmentType");
                          __jsp_tag_starteval=__jsp_taghandler_91.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_91,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_92=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_92.setParent(__jsp_taghandler_91);
                                __jsp_taghandler_92.setMaxlength("2");
                                __jsp_taghandler_92.setName("fell002");
                                __jsp_taghandler_92.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].equipmentType"));
                                __jsp_taghandler_92.setReadonly(true);
                                __jsp_taghandler_92.setStyle("width:96%");
                                __jsp_taghandler_92.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_92.doStartTag();
                                if (__jsp_taghandler_92.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_92,5);
                              }
                            } while (__jsp_taghandler_91.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_91.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_91,4);
                        }
                        out.write(__oracle_jsp_text[109]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_93=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_93.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_93.setId("fullMT");
                          __jsp_tag_starteval=__jsp_taghandler_93.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_93,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_94=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_94.setParent(__jsp_taghandler_93);
                                __jsp_taghandler_94.setMaxlength("1");
                                __jsp_taghandler_94.setName("fell002");
                                __jsp_taghandler_94.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].fullMT"));
                                __jsp_taghandler_94.setReadonly(true);
                                __jsp_taghandler_94.setStyle("width:96%");
                                __jsp_taghandler_94.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_94.doStartTag();
                                if (__jsp_taghandler_94.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_94,5);
                              }
                            } while (__jsp_taghandler_93.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_93.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_93,4);
                        }
                        out.write(__oracle_jsp_text[110]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_95=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_95.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_95.setId("bookingType");
                          __jsp_tag_starteval=__jsp_taghandler_95.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_95,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_96=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_96.setParent(__jsp_taghandler_95);
                                __jsp_taghandler_96.setMaxlength("2");
                                __jsp_taghandler_96.setName("fell002");
                                __jsp_taghandler_96.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].bookingType"));
                                __jsp_taghandler_96.setReadonly(true);
                                __jsp_taghandler_96.setStyle("width:96%");
                                __jsp_taghandler_96.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_96.doStartTag();
                                if (__jsp_taghandler_96.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_96,5);
                              }
                            } while (__jsp_taghandler_95.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_95.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_95,4);
                        }
                        out.write(__oracle_jsp_text[111]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_97=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_97.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_97.setId("socCoc");
                          __jsp_tag_starteval=__jsp_taghandler_97.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_97,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_98=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_98.setParent(__jsp_taghandler_97);
                                __jsp_taghandler_98.setMaxlength("1");
                                __jsp_taghandler_98.setName("fell002");
                                __jsp_taghandler_98.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].socCoc"));
                                __jsp_taghandler_98.setReadonly(true);
                                __jsp_taghandler_98.setStyle("width:96%");
                                __jsp_taghandler_98.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_98.doStartTag();
                                if (__jsp_taghandler_98.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_98,5);
                              }
                            } while (__jsp_taghandler_97.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_97.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_97,4);
                        }
                        out.write(__oracle_jsp_text[112]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_99=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_99.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_99.setId("shipmentTerm");
                          __jsp_tag_starteval=__jsp_taghandler_99.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_99,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_100=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_100.setParent(__jsp_taghandler_99);
                                __jsp_taghandler_100.setMaxlength("4");
                                __jsp_taghandler_100.setName("fell002");
                                __jsp_taghandler_100.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].shipmentTerm"));
                                __jsp_taghandler_100.setReadonly(true);
                                __jsp_taghandler_100.setStyle("width:96%");
                                __jsp_taghandler_100.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_100.doStartTag();
                                if (__jsp_taghandler_100.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_100,5);
                              }
                            } while (__jsp_taghandler_99.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_99.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_99,4);
                        }
                        out.write(__oracle_jsp_text[113]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_101=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_101.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_101.setId("shipmentType");
                          __jsp_tag_starteval=__jsp_taghandler_101.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_101,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_102=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_102.setParent(__jsp_taghandler_101);
                                __jsp_taghandler_102.setMaxlength("3");
                                __jsp_taghandler_102.setName("fell002");
                                __jsp_taghandler_102.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].shipmentType"));
                                __jsp_taghandler_102.setReadonly(true);
                                __jsp_taghandler_102.setStyle("width:96%");
                                __jsp_taghandler_102.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_102.doStartTag();
                                if (__jsp_taghandler_102.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_102,5);
                              }
                            } while (__jsp_taghandler_101.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_101.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_101,4);
                        }
                        out.write(__oracle_jsp_text[114]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_103=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_103.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_103.setId("polStatus");
                          __jsp_tag_starteval=__jsp_taghandler_103.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_103,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[115]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_104=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_104.setParent(__jsp_taghandler_103);
                                __jsp_taghandler_104.setName("fell002");
                                __jsp_taghandler_104.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_104.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].polStatus"));
                                __jsp_taghandler_104.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_104.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_104,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[116]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_105=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_105.setParent(__jsp_taghandler_104);
                                      __jsp_taghandler_105.setLabel("name");
                                      __jsp_taghandler_105.setName("fell002");
                                      __jsp_taghandler_105.setProperty("podStatusValues");
                                      __jsp_taghandler_105.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_105.doStartTag();
                                      if (__jsp_taghandler_105.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_105,6);
                                    }
                                    out.write(__oracle_jsp_text[117]);
                                  } while (__jsp_taghandler_104.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_104.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_104,5);
                              }
                              out.write(__oracle_jsp_text[118]);
                            } while (__jsp_taghandler_103.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_103.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_103,4);
                        }
                        out.write(__oracle_jsp_text[119]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_106=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_106.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_106.setId("localContSts");
                          __jsp_tag_starteval=__jsp_taghandler_106.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_106,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[120]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_107=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_107.setParent(__jsp_taghandler_106);
                                __jsp_taghandler_107.setMaxlength("10");
                                __jsp_taghandler_107.setName("fell002");
                                __jsp_taghandler_107.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_107.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].localContSts"));
                                __jsp_taghandler_107.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_107.doStartTag();
                                if (__jsp_taghandler_107.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_107,5);
                              }
                              out.write(__oracle_jsp_text[121]);
                              out.write(__oracle_jsp_text[122]);
                            } while (__jsp_taghandler_106.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_106.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_106,4);
                        }
                        out.write(__oracle_jsp_text[123]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_108=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_108.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_108.setId("midstream");
                          __jsp_tag_starteval=__jsp_taghandler_108.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_108,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[124]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_109=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_109.setParent(__jsp_taghandler_108);
                                __jsp_taghandler_109.setName("fell002");
                                __jsp_taghandler_109.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_109.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].midstream"));
                                __jsp_taghandler_109.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_109.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_109,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[125]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_110=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_110.setParent(__jsp_taghandler_109);
                                      __jsp_taghandler_110.setLabel("name");
                                      __jsp_taghandler_110.setName("fell002");
                                      __jsp_taghandler_110.setProperty("midstreamValues");
                                      __jsp_taghandler_110.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_110.doStartTag();
                                      if (__jsp_taghandler_110.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_110,6);
                                    }
                                    out.write(__oracle_jsp_text[126]);
                                  } while (__jsp_taghandler_109.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_109.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_109,5);
                              }
                              out.write(__oracle_jsp_text[127]);
                            } while (__jsp_taghandler_108.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_108.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_108,4);
                        }
                        out.write(__oracle_jsp_text[128]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_111=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_111.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_111.setId("loadCondition");
                          __jsp_tag_starteval=__jsp_taghandler_111.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_111,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[129]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_112=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style styleClass");
                                __jsp_taghandler_112.setParent(__jsp_taghandler_111);
                                __jsp_taghandler_112.setName("fell002");
                                __jsp_taghandler_112.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_112.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].loadCondition"));
                                __jsp_taghandler_112.setStyle("width:96%;height:20px");
                                __jsp_taghandler_112.setStyleClass("must");
                                __jsp_tag_starteval=__jsp_taghandler_112.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_112,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[130]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_113=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_113.setParent(__jsp_taghandler_112);
                                      __jsp_taghandler_113.setLabel("name");
                                      __jsp_taghandler_113.setName("fell002");
                                      __jsp_taghandler_113.setProperty("loadConditionValues");
                                      __jsp_taghandler_113.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_113.doStartTag();
                                      if (__jsp_taghandler_113.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_113,6);
                                    }
                                    out.write(__oracle_jsp_text[131]);
                                  } while (__jsp_taghandler_112.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_112.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_112,5);
                              }
                              out.write(__oracle_jsp_text[132]);
                            } while (__jsp_taghandler_111.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_111.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_111,4);
                        }
                        out.write(__oracle_jsp_text[133]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_114=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_114.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_114.setId("loadingStatus");
                          __jsp_tag_starteval=__jsp_taghandler_114.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_114,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[134]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_115=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style styleClass");
                                __jsp_taghandler_115.setParent(__jsp_taghandler_114);
                                __jsp_taghandler_115.setName("fell002");
                                __jsp_taghandler_115.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_115.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].loadingStatus"));
                                __jsp_taghandler_115.setStyle("width:96%;height:20px");
                                __jsp_taghandler_115.setStyleClass("must");
                                __jsp_tag_starteval=__jsp_taghandler_115.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_115,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[135]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_116=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_116.setParent(__jsp_taghandler_115);
                                      __jsp_taghandler_116.setLabel("name");
                                      __jsp_taghandler_116.setName("fell002");
                                      __jsp_taghandler_116.setProperty("loadingStatusValue");
                                      __jsp_taghandler_116.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_116.doStartTag();
                                      if (__jsp_taghandler_116.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_116,6);
                                    }
                                    out.write(__oracle_jsp_text[136]);
                                    out.write(__oracle_jsp_text[137]);
                                  } while (__jsp_taghandler_115.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_115.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_115,5);
                              }
                              out.write(__oracle_jsp_text[138]);
                            } while (__jsp_taghandler_114.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_114.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_114,4);
                        }
                        out.write(__oracle_jsp_text[139]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_117=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_117.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_117.setId("stowPosition");
                          __jsp_tag_starteval=__jsp_taghandler_117.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_117,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_118=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onchange property style");
                                __jsp_taghandler_118.setParent(__jsp_taghandler_117);
                                __jsp_taghandler_118.setMaxlength("7");
                                __jsp_taghandler_118.setName("fell002");
                                __jsp_taghandler_118.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_118.setOnchange((java.lang.String) ("onChangeStowagePosition("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_118.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].stowPosition"));
                                __jsp_taghandler_118.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_118.doStartTag();
                                if (__jsp_taghandler_118.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_118,5);
                              }
                            } while (__jsp_taghandler_117.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_117.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_117,4);
                        }
                        out.write(__oracle_jsp_text[140]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_119=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_119.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_119.setId("activityDate");
                          __jsp_tag_starteval=__jsp_taghandler_119.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_119,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[141]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_120=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_120.setParent(__jsp_taghandler_119);
                                __jsp_taghandler_120.setMaxlength("16");
                                __jsp_taghandler_120.setName("fell002");
                                __jsp_taghandler_120.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_120.setOnclick("this.select();");
                                __jsp_taghandler_120.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].activityDate"));
                                __jsp_taghandler_120.setStyle("width:60%");
                                __jsp_tag_starteval=__jsp_taghandler_120.doStartTag();
                                if (__jsp_taghandler_120.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_120,5);
                              }
                              out.write(__oracle_jsp_text[142]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[143]);
                              out.print(lstrContextPath);
                              out.write(__oracle_jsp_text[144]);
                            } while (__jsp_taghandler_119.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_119.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_119,4);
                        }
                        out.write(__oracle_jsp_text[145]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_121=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_121.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_121.setId("weight");
                          __jsp_tag_starteval=__jsp_taghandler_121.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_121,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_122=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_122.setParent(__jsp_taghandler_121);
                                __jsp_taghandler_122.setMaxlength("15");
                                __jsp_taghandler_122.setName("fell002");
                                __jsp_taghandler_122.setOnblur((java.lang.String) ("putMask_Number(this, 12, 2);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_122.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_122.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].weight"));
                                __jsp_taghandler_122.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_122.doStartTag();
                                if (__jsp_taghandler_122.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_122,5);
                              }
                            } while (__jsp_taghandler_121.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_121.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_121,4);
                        }
                        out.write(__oracle_jsp_text[146]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_123=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_123.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_123.setId("damaged");
                          __jsp_tag_starteval=__jsp_taghandler_123.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_123,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[147]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_124=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_124.setParent(__jsp_taghandler_123);
                                __jsp_taghandler_124.setName("fell002");
                                __jsp_taghandler_124.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_124.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].damaged"));
                                __jsp_taghandler_124.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_124.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_124,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[148]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_125=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_125.setParent(__jsp_taghandler_124);
                                      __jsp_taghandler_125.setLabel("name");
                                      __jsp_taghandler_125.setName("fell002");
                                      __jsp_taghandler_125.setProperty("damagedValues");
                                      __jsp_taghandler_125.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_125.doStartTag();
                                      if (__jsp_taghandler_125.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_125,6);
                                    }
                                    out.write(__oracle_jsp_text[149]);
                                  } while (__jsp_taghandler_124.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_124.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_124,5);
                              }
                              out.write(__oracle_jsp_text[150]);
                            } while (__jsp_taghandler_123.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_123.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_123,4);
                        }
                        out.write(__oracle_jsp_text[151]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_126=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_126.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_126.setId("voidSlot");
                          __jsp_tag_starteval=__jsp_taghandler_126.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_126,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_127=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_127.setParent(__jsp_taghandler_126);
                                __jsp_taghandler_127.setMaxlength("6");
                                __jsp_taghandler_127.setName("fell002");
                                __jsp_taghandler_127.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].voidSlot"));
                                __jsp_taghandler_127.setReadonly(true);
                                __jsp_taghandler_127.setStyle("width:96%");
                                __jsp_taghandler_127.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_127.doStartTag();
                                if (__jsp_taghandler_127.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_127,5);
                              }
                            } while (__jsp_taghandler_126.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_126.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_126,4);
                        }
                        out.write(__oracle_jsp_text[152]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_128=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_128.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_128.setId("preAdvice");
                          __jsp_tag_starteval=__jsp_taghandler_128.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_128,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_129=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_129.setParent(__jsp_taghandler_128);
                                __jsp_taghandler_129.setMaxlength("3");
                                __jsp_taghandler_129.setName("fell002");
                                __jsp_taghandler_129.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].preAdvice"));
                                __jsp_taghandler_129.setReadonly(true);
                                __jsp_taghandler_129.setStyle("width:96%");
                                __jsp_taghandler_129.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_129.doStartTag();
                                if (__jsp_taghandler_129.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_129,5);
                              }
                            } while (__jsp_taghandler_128.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_128.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_128,4);
                        }
                        out.write(__oracle_jsp_text[153]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_130=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_130.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_130.setId("slotOperator");
                          __jsp_tag_starteval=__jsp_taghandler_130.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_130,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_131=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_131.setParent(__jsp_taghandler_130);
                                __jsp_taghandler_131.setMaxlength("4");
                                __jsp_taghandler_131.setName("fell002");
                                __jsp_taghandler_131.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].slotOperator"));
                                __jsp_taghandler_131.setReadonly(true);
                                __jsp_taghandler_131.setStyle("width:96%");
                                __jsp_taghandler_131.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_131.doStartTag();
                                if (__jsp_taghandler_131.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_131,5);
                              }
                            } while (__jsp_taghandler_130.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_130.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_130,4);
                        }
                        out.write(__oracle_jsp_text[154]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_132=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_132.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_132.setName("fell002");
                          __jsp_taghandler_132.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].socCoc"));
                          __jsp_taghandler_132.setValue("COC");
                          __jsp_tag_starteval=__jsp_taghandler_132.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[155]);
                              {
                                com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_133=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                                __jsp_taghandler_133.setParent(__jsp_taghandler_132);
                                __jsp_taghandler_133.setId("contOperator");
                                __jsp_tag_starteval=__jsp_taghandler_133.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_133,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[156]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_134=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass value");
                                      __jsp_taghandler_134.setParent(__jsp_taghandler_133);
                                      __jsp_taghandler_134.setMaxlength("4");
                                      __jsp_taghandler_134.setName("fell002");
                                      __jsp_taghandler_134.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].contOperator"));
                                      __jsp_taghandler_134.setReadonly(true);
                                      __jsp_taghandler_134.setStyle("width:96%");
                                      __jsp_taghandler_134.setStyleClass("non_edit");
                                      __jsp_taghandler_134.setValue("RCL");
                                      __jsp_tag_starteval=__jsp_taghandler_134.doStartTag();
                                      if (__jsp_taghandler_134.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_134,6);
                                    }
                                    out.write(__oracle_jsp_text[157]);
                                  } while (__jsp_taghandler_133.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_133.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_133,5);
                              }
                              out.write(__oracle_jsp_text[158]);
                            } while (__jsp_taghandler_132.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_132.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_132,4);
                        }
                        out.write(__oracle_jsp_text[159]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_135=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                          __jsp_taghandler_135.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_135.setName("fell002");
                          __jsp_taghandler_135.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].socCoc"));
                          __jsp_taghandler_135.setValue("COC");
                          __jsp_tag_starteval=__jsp_taghandler_135.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[160]);
                              {
                                com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_136=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                                __jsp_taghandler_136.setParent(__jsp_taghandler_135);
                                __jsp_taghandler_136.setId("contOperator");
                                __jsp_tag_starteval=__jsp_taghandler_136.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_136,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[161]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_137=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
                                      __jsp_taghandler_137.setParent(__jsp_taghandler_136);
                                      __jsp_taghandler_137.setMaxlength("4");
                                      __jsp_taghandler_137.setName("fell002");
                                      __jsp_taghandler_137.setOnblur((java.lang.String) ("changeUpper(this); updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"); validateOperatorCode1(this, "+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                      __jsp_taghandler_137.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].contOperator"));
                                      __jsp_taghandler_137.setStyle("width:75%");
                                      __jsp_taghandler_137.setStyleClass("must");
                                      __jsp_tag_starteval=__jsp_taghandler_137.doStartTag();
                                      if (__jsp_taghandler_137.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_137,6);
                                    }
                                    out.write(__oracle_jsp_text[162]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[163]);
                                  } while (__jsp_taghandler_136.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_136.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_136,5);
                              }
                              out.write(__oracle_jsp_text[164]);
                            } while (__jsp_taghandler_135.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_135.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_135,4);
                        }
                        out.write(__oracle_jsp_text[165]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_138=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_138.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_138.setId("outSlotOperator");
                          __jsp_tag_starteval=__jsp_taghandler_138.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_138,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[166]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_139=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_139.setParent(__jsp_taghandler_138);
                                __jsp_taghandler_139.setMaxlength("4");
                                __jsp_taghandler_139.setName("fell002");
                                __jsp_taghandler_139.setOnblur((java.lang.String) ("changeUpper(this); updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"); validateOutSlotOperatorCode1(this, "+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_139.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].outSlotOperator"));
                                __jsp_taghandler_139.setStyle("width:75%");
                                __jsp_tag_starteval=__jsp_taghandler_139.doStartTag();
                                if (__jsp_taghandler_139.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_139,5);
                              }
                              out.write(__oracle_jsp_text[167]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[168]);
                            } while (__jsp_taghandler_138.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_138.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_138,4);
                        }
                        out.write(__oracle_jsp_text[169]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_140=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_140.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_140.setId("specialHandling");
                          __jsp_tag_starteval=__jsp_taghandler_140.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_140,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_141=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_141.setParent(__jsp_taghandler_140);
                                __jsp_taghandler_141.setMaxlength("3");
                                __jsp_taghandler_141.setName("fell002");
                                __jsp_taghandler_141.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                __jsp_taghandler_141.setReadonly(true);
                                __jsp_taghandler_141.setStyle("width:96%");
                                __jsp_taghandler_141.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_141.doStartTag();
                                if (__jsp_taghandler_141.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_141,5);
                              }
                            } while (__jsp_taghandler_140.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_140.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_140,4);
                        }
                        out.write(__oracle_jsp_text[170]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_142=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_142.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_142.setId("sealNo");
                          __jsp_tag_starteval=__jsp_taghandler_142.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_142,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_143=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_143.setParent(__jsp_taghandler_142);
                                __jsp_taghandler_143.setMaxlength("20");
                                __jsp_taghandler_143.setName("fell002");
                                __jsp_taghandler_143.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_143.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].sealNo"));
                                __jsp_taghandler_143.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_143.doStartTag();
                                if (__jsp_taghandler_143.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_143,5);
                              }
                            } while (__jsp_taghandler_142.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_142.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_142,4);
                        }
                        out.write(__oracle_jsp_text[171]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_144=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_144.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_144.setId("pod");
                          __jsp_tag_starteval=__jsp_taghandler_144.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_144,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_145=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_145.setParent(__jsp_taghandler_144);
                                __jsp_taghandler_145.setMaxlength("5");
                                __jsp_taghandler_145.setName("fell002");
                                __jsp_taghandler_145.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].pod"));
                                __jsp_taghandler_145.setReadonly(true);
                                __jsp_taghandler_145.setStyle("width:96%");
                                __jsp_taghandler_145.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_145.doStartTag();
                                if (__jsp_taghandler_145.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_145,5);
                              }
                            } while (__jsp_taghandler_144.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_144.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_144,4);
                        }
                        out.write(__oracle_jsp_text[172]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_146=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_146.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_146.setId("podTerminal");
                          __jsp_tag_starteval=__jsp_taghandler_146.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_146,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_147=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_147.setParent(__jsp_taghandler_146);
                                __jsp_taghandler_147.setMaxlength("5");
                                __jsp_taghandler_147.setName("fell002");
                                __jsp_taghandler_147.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].podTerminal"));
                                __jsp_taghandler_147.setReadonly(true);
                                __jsp_taghandler_147.setStyle("width:96%");
                                __jsp_taghandler_147.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_147.doStartTag();
                                if (__jsp_taghandler_147.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_147,5);
                              }
                            } while (__jsp_taghandler_146.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_146.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_146,4);
                        }
                        out.write(__oracle_jsp_text[173]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_148=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_148.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_148.setId("nextPOD1");
                          __jsp_tag_starteval=__jsp_taghandler_148.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_148,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_149=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_149.setParent(__jsp_taghandler_148);
                                __jsp_taghandler_149.setMaxlength("5");
                                __jsp_taghandler_149.setName("fell002");
                                __jsp_taghandler_149.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextPOD1"));
                                __jsp_taghandler_149.setReadonly(true);
                                __jsp_taghandler_149.setStyle("width:96%");
                                __jsp_taghandler_149.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_149.doStartTag();
                                if (__jsp_taghandler_149.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_149,5);
                              }
                            } while (__jsp_taghandler_148.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_148.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_148,4);
                        }
                        out.write(__oracle_jsp_text[174]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_150=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_150.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_150.setId("nextPOD2");
                          __jsp_tag_starteval=__jsp_taghandler_150.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_150,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_151=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_151.setParent(__jsp_taghandler_150);
                                __jsp_taghandler_151.setMaxlength("5");
                                __jsp_taghandler_151.setName("fell002");
                                __jsp_taghandler_151.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextPOD2"));
                                __jsp_taghandler_151.setReadonly(true);
                                __jsp_taghandler_151.setStyle("width:96%");
                                __jsp_taghandler_151.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_151.doStartTag();
                                if (__jsp_taghandler_151.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_151,5);
                              }
                            } while (__jsp_taghandler_150.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_150.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_150,4);
                        }
                        out.write(__oracle_jsp_text[175]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_152=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_152.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_152.setId("nextPOD3");
                          __jsp_tag_starteval=__jsp_taghandler_152.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_152,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_153=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_153.setParent(__jsp_taghandler_152);
                                __jsp_taghandler_153.setMaxlength("5");
                                __jsp_taghandler_153.setName("fell002");
                                __jsp_taghandler_153.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextPOD3"));
                                __jsp_taghandler_153.setReadonly(true);
                                __jsp_taghandler_153.setStyle("width:96%");
                                __jsp_taghandler_153.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_153.doStartTag();
                                if (__jsp_taghandler_153.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_153,5);
                              }
                            } while (__jsp_taghandler_152.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_152.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_152,4);
                        }
                        out.write(__oracle_jsp_text[176]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_154=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_154.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_154.setId("finalPOD");
                          __jsp_tag_starteval=__jsp_taghandler_154.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_154,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_155=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_155.setParent(__jsp_taghandler_154);
                                __jsp_taghandler_155.setMaxlength("5");
                                __jsp_taghandler_155.setName("fell002");
                                __jsp_taghandler_155.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].finalPOD"));
                                __jsp_taghandler_155.setReadonly(true);
                                __jsp_taghandler_155.setStyle("width:96%");
                                __jsp_taghandler_155.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_155.doStartTag();
                                if (__jsp_taghandler_155.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_155,5);
                              }
                            } while (__jsp_taghandler_154.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_154.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_154,4);
                        }
                        out.write(__oracle_jsp_text[177]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_156=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_156.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_156.setId("finalDest");
                          __jsp_tag_starteval=__jsp_taghandler_156.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_156,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_157=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_157.setParent(__jsp_taghandler_156);
                                __jsp_taghandler_157.setMaxlength("5");
                                __jsp_taghandler_157.setName("fell002");
                                __jsp_taghandler_157.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].finalDest"));
                                __jsp_taghandler_157.setReadonly(true);
                                __jsp_taghandler_157.setStyle("width:96%");
                                __jsp_taghandler_157.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_157.doStartTag();
                                if (__jsp_taghandler_157.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_157,5);
                              }
                            } while (__jsp_taghandler_156.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_156.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_156,4);
                        }
                        out.write(__oracle_jsp_text[178]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_158=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_158.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_158.setId("nextService");
                          __jsp_tag_starteval=__jsp_taghandler_158.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_158,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_159=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_159.setParent(__jsp_taghandler_158);
                                __jsp_taghandler_159.setMaxlength("5");
                                __jsp_taghandler_159.setName("fell002");
                                __jsp_taghandler_159.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextService"));
                                __jsp_taghandler_159.setReadonly(true);
                                __jsp_taghandler_159.setStyle("width:96%");
                                __jsp_taghandler_159.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_159.doStartTag();
                                if (__jsp_taghandler_159.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_159,5);
                              }
                            } while (__jsp_taghandler_158.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_158.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_158,4);
                        }
                        out.write(__oracle_jsp_text[179]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_160=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_160.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_160.setId("nextVessel");
                          __jsp_tag_starteval=__jsp_taghandler_160.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_160,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_161=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_161.setParent(__jsp_taghandler_160);
                                __jsp_taghandler_161.setMaxlength("25");
                                __jsp_taghandler_161.setName("fell002");
                                __jsp_taghandler_161.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextVessel"));
                                __jsp_taghandler_161.setReadonly(true);
                                __jsp_taghandler_161.setStyle("width:96%");
                                __jsp_taghandler_161.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_161.doStartTag();
                                if (__jsp_taghandler_161.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_161,5);
                              }
                            } while (__jsp_taghandler_160.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_160.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_160,4);
                        }
                        out.write(__oracle_jsp_text[180]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_162=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_162.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_162.setId("nextVoyage");
                          __jsp_tag_starteval=__jsp_taghandler_162.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_162,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_163=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_163.setParent(__jsp_taghandler_162);
                                __jsp_taghandler_163.setMaxlength("10");
                                __jsp_taghandler_163.setName("fell002");
                                __jsp_taghandler_163.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextVoyage"));
                                __jsp_taghandler_163.setReadonly(true);
                                __jsp_taghandler_163.setStyle("width:96%");
                                __jsp_taghandler_163.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_163.doStartTag();
                                if (__jsp_taghandler_163.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_163,5);
                              }
                            } while (__jsp_taghandler_162.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_162.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_162,4);
                        }
                        out.write(__oracle_jsp_text[181]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_164=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_164.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_164.setId("nextDirection");
                          __jsp_tag_starteval=__jsp_taghandler_164.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_164,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_165=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_165.setParent(__jsp_taghandler_164);
                                __jsp_taghandler_165.setMaxlength("2");
                                __jsp_taghandler_165.setName("fell002");
                                __jsp_taghandler_165.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].nextDirection"));
                                __jsp_taghandler_165.setReadonly(true);
                                __jsp_taghandler_165.setStyle("width:96%");
                                __jsp_taghandler_165.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_165.doStartTag();
                                if (__jsp_taghandler_165.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_165,5);
                              }
                            } while (__jsp_taghandler_164.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_164.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_164,4);
                        }
                        out.write(__oracle_jsp_text[182]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_166=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_166.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_166.setId("connectingMLOVessel");
                          __jsp_tag_starteval=__jsp_taghandler_166.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_166,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_167=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_167.setParent(__jsp_taghandler_166);
                                __jsp_taghandler_167.setMaxlength("35");
                                __jsp_taghandler_167.setName("fell002");
                                __jsp_taghandler_167.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_167.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].connectingMLOVessel"));
                                __jsp_taghandler_167.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_167.doStartTag();
                                if (__jsp_taghandler_167.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_167,5);
                              }
                            } while (__jsp_taghandler_166.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_166.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_166,4);
                        }
                        out.write(__oracle_jsp_text[183]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_168=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_168.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_168.setId("connectingMLOVoyage");
                          __jsp_tag_starteval=__jsp_taghandler_168.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_168,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_169=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_169.setParent(__jsp_taghandler_168);
                                __jsp_taghandler_169.setMaxlength("10");
                                __jsp_taghandler_169.setName("fell002");
                                __jsp_taghandler_169.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_169.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].connectingMLOVoyage"));
                                __jsp_taghandler_169.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_169.doStartTag();
                                if (__jsp_taghandler_169.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_169,5);
                              }
                            } while (__jsp_taghandler_168.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_168.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_168,4);
                        }
                        out.write(__oracle_jsp_text[184]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_170=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_170.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_170.setId("mloETADate");
                          __jsp_tag_starteval=__jsp_taghandler_170.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_170,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[185]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[186]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[187]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_171=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_171.setParent(__jsp_taghandler_170);
                                __jsp_taghandler_171.setMaxlength("16");
                                __jsp_taghandler_171.setName("fell002");
                                __jsp_taghandler_171.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_171.setOnclick("this.select();");
                                __jsp_taghandler_171.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].mloETADate"));
                                __jsp_taghandler_171.setStyle("width:60%");
                                __jsp_tag_starteval=__jsp_taghandler_171.doStartTag();
                                if (__jsp_taghandler_171.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_171,5);
                              }
                              out.write(__oracle_jsp_text[188]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[189]);
                              out.print(lstrContextPath);
                              out.write(__oracle_jsp_text[190]);
                            } while (__jsp_taghandler_170.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_170.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_170,4);
                        }
                        out.write(__oracle_jsp_text[191]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_172=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_172.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_172.setId("connectingMLOPOD1");
                          __jsp_tag_starteval=__jsp_taghandler_172.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_172,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_173=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_173.setParent(__jsp_taghandler_172);
                                __jsp_taghandler_173.setMaxlength("5");
                                __jsp_taghandler_173.setName("fell002");
                                __jsp_taghandler_173.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_173.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].connectingMLOPOD1"));
                                __jsp_taghandler_173.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_173.doStartTag();
                                if (__jsp_taghandler_173.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_173,5);
                              }
                            } while (__jsp_taghandler_172.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_172.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_172,4);
                        }
                        out.write(__oracle_jsp_text[192]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_174=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_174.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_174.setId("connectingMLOPOD2");
                          __jsp_tag_starteval=__jsp_taghandler_174.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_174,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_175=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_175.setParent(__jsp_taghandler_174);
                                __jsp_taghandler_175.setMaxlength("5");
                                __jsp_taghandler_175.setName("fell002");
                                __jsp_taghandler_175.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_175.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].connectingMLOPOD2"));
                                __jsp_taghandler_175.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_175.doStartTag();
                                if (__jsp_taghandler_175.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_175,5);
                              }
                            } while (__jsp_taghandler_174.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_174.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_174,4);
                        }
                        out.write(__oracle_jsp_text[193]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_176=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_176.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_176.setId("connectingMLOPOD3");
                          __jsp_tag_starteval=__jsp_taghandler_176.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_176,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_177=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_177.setParent(__jsp_taghandler_176);
                                __jsp_taghandler_177.setMaxlength("5");
                                __jsp_taghandler_177.setName("fell002");
                                __jsp_taghandler_177.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_177.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].connectingMLOPOD3"));
                                __jsp_taghandler_177.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_177.doStartTag();
                                if (__jsp_taghandler_177.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_177,5);
                              }
                            } while (__jsp_taghandler_176.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_176.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_176,4);
                        }
                        out.write(__oracle_jsp_text[194]);
                        out.write(__oracle_jsp_text[195]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_178=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_178.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_178.setId("placeOfDel");
                          __jsp_tag_starteval=__jsp_taghandler_178.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_178,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[196]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_179=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_179.setParent(__jsp_taghandler_178);
                                __jsp_taghandler_179.setName("fell002");
                                __jsp_taghandler_179.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].socCoc"));
                                __jsp_taghandler_179.setValue("SOC");
                                __jsp_tag_starteval=__jsp_taghandler_179.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[197]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_180=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                      __jsp_taghandler_180.setParent(__jsp_taghandler_179);
                                      __jsp_taghandler_180.setMaxlength("5");
                                      __jsp_taghandler_180.setName("fell002");
                                      __jsp_taghandler_180.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                      __jsp_taghandler_180.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].placeOfDel"));
                                      __jsp_taghandler_180.setStyle("width:96%");
                                      __jsp_tag_starteval=__jsp_taghandler_180.doStartTag();
                                      if (__jsp_taghandler_180.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_180,6);
                                    }
                                    out.write(__oracle_jsp_text[198]);
                                  } while (__jsp_taghandler_179.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_179.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_179,5);
                              }
                              out.write(__oracle_jsp_text[199]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_181=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_181.setParent(__jsp_taghandler_178);
                                __jsp_taghandler_181.setName("fell002");
                                __jsp_taghandler_181.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].socCoc"));
                                __jsp_taghandler_181.setValue("SOC");
                                __jsp_tag_starteval=__jsp_taghandler_181.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[200]);
                                    {
                                      org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_182=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                      __jsp_taghandler_182.setParent(__jsp_taghandler_181);
                                      __jsp_taghandler_182.setName("fell002");
                                      __jsp_taghandler_182.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].fullMT"));
                                      __jsp_taghandler_182.setValue("Empty");
                                      __jsp_tag_starteval=__jsp_taghandler_182.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[201]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_183=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                            __jsp_taghandler_183.setParent(__jsp_taghandler_182);
                                            __jsp_taghandler_183.setMaxlength("5");
                                            __jsp_taghandler_183.setName("fell002");
                                            __jsp_taghandler_183.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                            __jsp_taghandler_183.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].placeOfDel"));
                                            __jsp_taghandler_183.setStyle("width:96%");
                                            __jsp_tag_starteval=__jsp_taghandler_183.doStartTag();
                                            if (__jsp_taghandler_183.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_183,7);
                                          }
                                          out.write(__oracle_jsp_text[202]);
                                        } while (__jsp_taghandler_182.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_182.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_182,6);
                                    }
                                    out.write(__oracle_jsp_text[203]);
                                    {
                                      org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_184=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                      __jsp_taghandler_184.setParent(__jsp_taghandler_181);
                                      __jsp_taghandler_184.setName("fell002");
                                      __jsp_taghandler_184.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].fullMT"));
                                      __jsp_taghandler_184.setValue("Empty");
                                      __jsp_tag_starteval=__jsp_taghandler_184.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[204]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_185=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                            __jsp_taghandler_185.setParent(__jsp_taghandler_184);
                                            __jsp_taghandler_185.setMaxlength("5");
                                            __jsp_taghandler_185.setName("fell002");
                                            __jsp_taghandler_185.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].placeOfDel"));
                                            __jsp_taghandler_185.setReadonly(true);
                                            __jsp_taghandler_185.setStyle("width:96%");
                                            __jsp_taghandler_185.setStyleClass("non_edit");
                                            __jsp_tag_starteval=__jsp_taghandler_185.doStartTag();
                                            if (__jsp_taghandler_185.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_185,7);
                                          }
                                          out.write(__oracle_jsp_text[205]);
                                        } while (__jsp_taghandler_184.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_184.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_184,6);
                                    }
                                    out.write(__oracle_jsp_text[206]);
                                  } while (__jsp_taghandler_181.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_181.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_181,5);
                              }
                              out.write(__oracle_jsp_text[207]);
                            } while (__jsp_taghandler_178.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_178.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_178,4);
                        }
                        out.write(__oracle_jsp_text[208]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_186=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_186.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_186.setId("exMLOVessel");
                          __jsp_tag_starteval=__jsp_taghandler_186.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_186,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_187=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_187.setParent(__jsp_taghandler_186);
                                __jsp_taghandler_187.setMaxlength("5");
                                __jsp_taghandler_187.setName("fell002");
                                __jsp_taghandler_187.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_187.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].exMLOVessel"));
                                __jsp_taghandler_187.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_187.doStartTag();
                                if (__jsp_taghandler_187.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_187,5);
                              }
                            } while (__jsp_taghandler_186.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_186.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_186,4);
                        }
                        out.write(__oracle_jsp_text[209]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_188=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_188.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_188.setId("exMLOVoyage");
                          __jsp_tag_starteval=__jsp_taghandler_188.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_188,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_189=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_189.setParent(__jsp_taghandler_188);
                                __jsp_taghandler_189.setMaxlength("20");
                                __jsp_taghandler_189.setName("fell002");
                                __jsp_taghandler_189.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_189.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].exMLOVoyage"));
                                __jsp_taghandler_189.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_189.doStartTag();
                                if (__jsp_taghandler_189.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_189,5);
                              }
                            } while (__jsp_taghandler_188.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_188.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_188,4);
                        }
                        out.write(__oracle_jsp_text[210]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_190=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_190.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_190.setId("exMloETADate");
                          __jsp_tag_starteval=__jsp_taghandler_190.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_190,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[211]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_191=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_191.setParent(__jsp_taghandler_190);
                                __jsp_taghandler_191.setMaxlength("16");
                                __jsp_taghandler_191.setName("fell002");
                                __jsp_taghandler_191.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_191.setOnclick("this.select();");
                                __jsp_taghandler_191.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].exMloETADate"));
                                __jsp_taghandler_191.setStyle("width:60%");
                                __jsp_tag_starteval=__jsp_taghandler_191.doStartTag();
                                if (__jsp_taghandler_191.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_191,5);
                              }
                              out.write(__oracle_jsp_text[212]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[213]);
                              out.print(lstrContextPath);
                              out.write(__oracle_jsp_text[214]);
                            } while (__jsp_taghandler_190.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_190.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_190,4);
                        }
                        out.write(__oracle_jsp_text[215]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_192=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_192.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_192.setId("handlingInstCode1");
                          __jsp_tag_starteval=__jsp_taghandler_192.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_192,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[216]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_193=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_193.setParent(__jsp_taghandler_192);
                                __jsp_taghandler_193.setMaxlength("3");
                                __jsp_taghandler_193.setName("fell002");
                                __jsp_taghandler_193.setOnblur((java.lang.String) ("changeUpper(this); updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"); validateHandInsCode1(this,1,("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"));"));
                                __jsp_taghandler_193.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].handlingInstCode1"));
                                __jsp_taghandler_193.setStyle("width:75%");
                                __jsp_tag_starteval=__jsp_taghandler_193.doStartTag();
                                if (__jsp_taghandler_193.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_193,5);
                              }
                              out.write(__oracle_jsp_text[217]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[218]);
                            } while (__jsp_taghandler_192.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_192.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_192,4);
                        }
                        out.write(__oracle_jsp_text[219]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_194=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_194.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_194.setId("handlingInstDesc1");
                          __jsp_tag_starteval=__jsp_taghandler_194.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_194,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_195=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_195.setParent(__jsp_taghandler_194);
                                __jsp_taghandler_195.setMaxlength("60");
                                __jsp_taghandler_195.setName("fell002");
                                __jsp_taghandler_195.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].handlingInstDesc1"));
                                __jsp_taghandler_195.setReadonly(true);
                                __jsp_taghandler_195.setStyle("width:96%");
                                __jsp_taghandler_195.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_195.doStartTag();
                                if (__jsp_taghandler_195.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_195,5);
                              }
                            } while (__jsp_taghandler_194.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_194.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_194,4);
                        }
                        out.write(__oracle_jsp_text[220]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_196=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_196.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_196.setId("handlingInstCode2");
                          __jsp_tag_starteval=__jsp_taghandler_196.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_196,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[221]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_197=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_197.setParent(__jsp_taghandler_196);
                                __jsp_taghandler_197.setMaxlength("3");
                                __jsp_taghandler_197.setName("fell002");
                                __jsp_taghandler_197.setOnblur((java.lang.String) ("changeUpper(this); updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"); validateHandInsCode1(this,2,("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"));"));
                                __jsp_taghandler_197.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].handlingInstCode2"));
                                __jsp_taghandler_197.setStyle("width:75%");
                                __jsp_tag_starteval=__jsp_taghandler_197.doStartTag();
                                if (__jsp_taghandler_197.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_197,5);
                              }
                              out.write(__oracle_jsp_text[222]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[223]);
                            } while (__jsp_taghandler_196.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_196.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_196,4);
                        }
                        out.write(__oracle_jsp_text[224]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_198=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_198.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_198.setId("handlingInstDesc2");
                          __jsp_tag_starteval=__jsp_taghandler_198.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_198,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_199=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_199.setParent(__jsp_taghandler_198);
                                __jsp_taghandler_199.setMaxlength("60");
                                __jsp_taghandler_199.setName("fell002");
                                __jsp_taghandler_199.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].handlingInstDesc2"));
                                __jsp_taghandler_199.setReadonly(true);
                                __jsp_taghandler_199.setStyle("width:96%");
                                __jsp_taghandler_199.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_199.doStartTag();
                                if (__jsp_taghandler_199.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_199,5);
                              }
                            } while (__jsp_taghandler_198.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_198.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_198,4);
                        }
                        out.write(__oracle_jsp_text[225]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_200=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_200.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_200.setId("handlingInstCode3");
                          __jsp_tag_starteval=__jsp_taghandler_200.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_200,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[226]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_201=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_201.setParent(__jsp_taghandler_200);
                                __jsp_taghandler_201.setMaxlength("3");
                                __jsp_taghandler_201.setName("fell002");
                                __jsp_taghandler_201.setOnblur((java.lang.String) ("changeUpper(this); updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"); validateHandInsCode1(this,3,("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"));"));
                                __jsp_taghandler_201.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].handlingInstCode3"));
                                __jsp_taghandler_201.setStyle("width:75%");
                                __jsp_tag_starteval=__jsp_taghandler_201.doStartTag();
                                if (__jsp_taghandler_201.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_201,5);
                              }
                              out.write(__oracle_jsp_text[227]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[228]);
                            } while (__jsp_taghandler_200.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_200.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_200,4);
                        }
                        out.write(__oracle_jsp_text[229]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_202=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_202.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_202.setId("handlingInstDesc3");
                          __jsp_tag_starteval=__jsp_taghandler_202.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_202,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_203=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_203.setParent(__jsp_taghandler_202);
                                __jsp_taghandler_203.setMaxlength("60");
                                __jsp_taghandler_203.setName("fell002");
                                __jsp_taghandler_203.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].handlingInstDesc3"));
                                __jsp_taghandler_203.setReadonly(true);
                                __jsp_taghandler_203.setStyle("width:96%");
                                __jsp_taghandler_203.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_203.doStartTag();
                                if (__jsp_taghandler_203.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_203,5);
                              }
                            } while (__jsp_taghandler_202.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_202.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_202,4);
                        }
                        out.write(__oracle_jsp_text[230]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_204=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_204.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_204.setId("contLoadRemark1");
                          __jsp_tag_starteval=__jsp_taghandler_204.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_204,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[231]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_205=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_205.setParent(__jsp_taghandler_204);
                                __jsp_taghandler_205.setMaxlength("3");
                                __jsp_taghandler_205.setName("fell002");
                                __jsp_taghandler_205.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_205.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].contLoadRemark1"));
                                __jsp_taghandler_205.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_205.doStartTag();
                                if (__jsp_taghandler_205.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_205,5);
                              }
                              out.write(__oracle_jsp_text[232]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_206=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_206.setParent(__jsp_taghandler_204);
                                __jsp_taghandler_206.setName("fell002");
                                __jsp_taghandler_206.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_206.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].contLoadRemark1"));
                                __jsp_taghandler_206.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_206.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_206,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[233]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_207=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_207.setParent(__jsp_taghandler_206);
                                      __jsp_taghandler_207.setLabel("name");
                                      __jsp_taghandler_207.setName("fell002");
                                      __jsp_taghandler_207.setProperty("clrValues");
                                      __jsp_taghandler_207.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_207.doStartTag();
                                      if (__jsp_taghandler_207.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_207,6);
                                    }
                                    out.write(__oracle_jsp_text[234]);
                                  } while (__jsp_taghandler_206.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_206.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_206,5);
                              }
                              out.write(__oracle_jsp_text[235]);
                            } while (__jsp_taghandler_204.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_204.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_204,4);
                        }
                        out.write(__oracle_jsp_text[236]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_208=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_208.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_208.setId("contLoadRemark2");
                          __jsp_tag_starteval=__jsp_taghandler_208.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_208,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[237]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_209=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_209.setParent(__jsp_taghandler_208);
                                __jsp_taghandler_209.setMaxlength("3");
                                __jsp_taghandler_209.setName("fell002");
                                __jsp_taghandler_209.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_209.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].contLoadRemark2"));
                                __jsp_taghandler_209.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_209.doStartTag();
                                if (__jsp_taghandler_209.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_209,5);
                              }
                              out.write(__oracle_jsp_text[238]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_210=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_210.setParent(__jsp_taghandler_208);
                                __jsp_taghandler_210.setName("fell002");
                                __jsp_taghandler_210.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_210.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].contLoadRemark2"));
                                __jsp_taghandler_210.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_210.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_210,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[239]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_211=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_211.setParent(__jsp_taghandler_210);
                                      __jsp_taghandler_211.setLabel("name");
                                      __jsp_taghandler_211.setName("fell002");
                                      __jsp_taghandler_211.setProperty("clrValues");
                                      __jsp_taghandler_211.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_211.doStartTag();
                                      if (__jsp_taghandler_211.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_211,6);
                                    }
                                    out.write(__oracle_jsp_text[240]);
                                  } while (__jsp_taghandler_210.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_210.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_210,5);
                              }
                              out.write(__oracle_jsp_text[241]);
                            } while (__jsp_taghandler_208.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_208.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_208,4);
                        }
                        out.write(__oracle_jsp_text[242]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_212=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_212.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_212.setId("specialCargo");
                          __jsp_tag_starteval=__jsp_taghandler_212.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_212,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_213=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                                __jsp_taghandler_213.setParent(__jsp_taghandler_212);
                                __jsp_taghandler_213.setMaxlength("3");
                                __jsp_taghandler_213.setName("fell002");
                                __jsp_taghandler_213.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialCargo"));
                                __jsp_taghandler_213.setReadonly(true);
                                __jsp_taghandler_213.setStyle("width:96%");
                                __jsp_taghandler_213.setStyleClass("non_edit");
                                __jsp_tag_starteval=__jsp_taghandler_213.doStartTag();
                                if (__jsp_taghandler_213.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_213,5);
                              }
                            } while (__jsp_taghandler_212.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_212.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_212,4);
                        }
                        out.write(__oracle_jsp_text[243]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_214=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_214.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_214.setId("tightConnectionPOD1");
                          __jsp_tag_starteval=__jsp_taghandler_214.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_214,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[244]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_215=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_215.setParent(__jsp_taghandler_214);
                                __jsp_taghandler_215.setName("fell002");
                                __jsp_taghandler_215.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_215.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].tightConnectionPOD1"));
                                __jsp_taghandler_215.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_215.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_215,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[245]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_216=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_216.setParent(__jsp_taghandler_215);
                                      __jsp_taghandler_216.setLabel("name");
                                      __jsp_taghandler_216.setName("fell002");
                                      __jsp_taghandler_216.setProperty("tightConnectionPODValues");
                                      __jsp_taghandler_216.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_216.doStartTag();
                                      if (__jsp_taghandler_216.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_216,6);
                                    }
                                    out.write(__oracle_jsp_text[246]);
                                  } while (__jsp_taghandler_215.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_215.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_215,5);
                              }
                              out.write(__oracle_jsp_text[247]);
                            } while (__jsp_taghandler_214.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_214.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_214,4);
                        }
                        out.write(__oracle_jsp_text[248]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_217=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_217.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_217.setId("tightConnectionPOD2");
                          __jsp_tag_starteval=__jsp_taghandler_217.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_217,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[249]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_218=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_218.setParent(__jsp_taghandler_217);
                                __jsp_taghandler_218.setName("fell002");
                                __jsp_taghandler_218.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_218.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].tightConnectionPOD2"));
                                __jsp_taghandler_218.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_218.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_218,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[250]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_219=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_219.setParent(__jsp_taghandler_218);
                                      __jsp_taghandler_219.setLabel("name");
                                      __jsp_taghandler_219.setName("fell002");
                                      __jsp_taghandler_219.setProperty("tightConnectionPODValues");
                                      __jsp_taghandler_219.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_219.doStartTag();
                                      if (__jsp_taghandler_219.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_219,6);
                                    }
                                    out.write(__oracle_jsp_text[251]);
                                  } while (__jsp_taghandler_218.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_218.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_218,5);
                              }
                              out.write(__oracle_jsp_text[252]);
                            } while (__jsp_taghandler_217.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_217.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_217,4);
                        }
                        out.write(__oracle_jsp_text[253]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_220=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_220.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_220.setId("tightConnectionPOD3");
                          __jsp_tag_starteval=__jsp_taghandler_220.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_220,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[254]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_221=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_221.setParent(__jsp_taghandler_220);
                                __jsp_taghandler_221.setName("fell002");
                                __jsp_taghandler_221.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_221.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].tightConnectionPOD3"));
                                __jsp_taghandler_221.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_221.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_221,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[255]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_222=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_222.setParent(__jsp_taghandler_221);
                                      __jsp_taghandler_222.setLabel("name");
                                      __jsp_taghandler_222.setName("fell002");
                                      __jsp_taghandler_222.setProperty("tightConnectionPODValues");
                                      __jsp_taghandler_222.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_222.doStartTag();
                                      if (__jsp_taghandler_222.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_222,6);
                                    }
                                    out.write(__oracle_jsp_text[256]);
                                  } while (__jsp_taghandler_221.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_221.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_221,5);
                              }
                              out.write(__oracle_jsp_text[257]);
                            } while (__jsp_taghandler_220.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_220.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_220,4);
                        }
                        out.write(__oracle_jsp_text[258]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_223=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_223.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_223.setId("imdgClass");
                          __jsp_tag_starteval=__jsp_taghandler_223.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_223,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_224=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_224.setParent(__jsp_taghandler_223);
                                __jsp_taghandler_224.setMaxlength("4");
                                __jsp_taghandler_224.setName("fell002");
                                __jsp_taghandler_224.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_224.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].imdgClass"));
                                __jsp_taghandler_224.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_224.doStartTag();
                                if (__jsp_taghandler_224.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_224,5);
                              }
                            } while (__jsp_taghandler_223.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_223.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_223,4);
                        }
                        out.write(__oracle_jsp_text[259]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_225=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_225.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_225.setId("unNumber");
                          __jsp_tag_starteval=__jsp_taghandler_225.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_225,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[260]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_226=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_226.setParent(__jsp_taghandler_225);
                                __jsp_taghandler_226.setMaxlength("6");
                                __jsp_taghandler_226.setName("fell002");
                                __jsp_taghandler_226.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_226.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].unNumber"));
                                __jsp_taghandler_226.setStyle("width:75%");
                                __jsp_tag_starteval=__jsp_taghandler_226.doStartTag();
                                if (__jsp_taghandler_226.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_226,5);
                              }
                              out.write(__oracle_jsp_text[261]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[262]);
                            } while (__jsp_taghandler_225.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_225.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_225,4);
                        }
                        out.write(__oracle_jsp_text[263]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_227=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_227.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_227.setId("unNumberVariant");
                          __jsp_tag_starteval=__jsp_taghandler_227.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_227,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_228=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_228.setParent(__jsp_taghandler_227);
                                __jsp_taghandler_228.setMaxlength("1");
                                __jsp_taghandler_228.setName("fell002");
                                __jsp_taghandler_228.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_228.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].unNumberVariant"));
                                __jsp_taghandler_228.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_228.doStartTag();
                                if (__jsp_taghandler_228.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_228,5);
                              }
                            } while (__jsp_taghandler_227.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_227.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_227,4);
                        }
                        out.write(__oracle_jsp_text[264]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_229=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_229.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_229.setId("portClass");
                          __jsp_tag_starteval=__jsp_taghandler_229.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_229,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_230=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_230.setParent(__jsp_taghandler_229);
                                __jsp_taghandler_230.setMaxlength("5");
                                __jsp_taghandler_230.setName("fell002");
                                __jsp_taghandler_230.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_230.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].portClass"));
                                __jsp_taghandler_230.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_230.doStartTag();
                                if (__jsp_taghandler_230.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_230,5);
                              }
                            } while (__jsp_taghandler_229.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_229.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_229,4);
                        }
                        out.write(__oracle_jsp_text[265]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_231=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_231.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_231.setId("portClassType");
                          __jsp_tag_starteval=__jsp_taghandler_231.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_231,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_232=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_232.setParent(__jsp_taghandler_231);
                                __jsp_taghandler_232.setMaxlength("5");
                                __jsp_taghandler_232.setName("fell002");
                                __jsp_taghandler_232.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_232.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].portClassType"));
                                __jsp_taghandler_232.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_232.doStartTag();
                                if (__jsp_taghandler_232.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_232,5);
                              }
                            } while (__jsp_taghandler_231.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_231.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_231,4);
                        }
                        out.write(__oracle_jsp_text[266]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_233=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_233.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_233.setId("flashUnit");
                          __jsp_tag_starteval=__jsp_taghandler_233.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_233,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[267]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_234=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_234.setParent(__jsp_taghandler_233);
                                __jsp_taghandler_234.setName("fell002");
                                __jsp_taghandler_234.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_234.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].flashUnit"));
                                __jsp_taghandler_234.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_234.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_234,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[268]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_235=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_235.setParent(__jsp_taghandler_234);
                                      __jsp_taghandler_235.setLabel("name");
                                      __jsp_taghandler_235.setName("fell002");
                                      __jsp_taghandler_235.setProperty("reeferTempUnitValues");
                                      __jsp_taghandler_235.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_235.doStartTag();
                                      if (__jsp_taghandler_235.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_235,6);
                                    }
                                    out.write(__oracle_jsp_text[269]);
                                  } while (__jsp_taghandler_234.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_234.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_234,5);
                              }
                              out.write(__oracle_jsp_text[270]);
                            } while (__jsp_taghandler_233.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_233.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_233,4);
                        }
                        out.write(__oracle_jsp_text[271]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_236=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_236.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_236.setId("flashPoint");
                          __jsp_tag_starteval=__jsp_taghandler_236.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_236,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_237=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_237.setParent(__jsp_taghandler_236);
                                __jsp_taghandler_237.setMaxlength("7");
                                __jsp_taghandler_237.setName("fell002");
                                __jsp_taghandler_237.setOnblur((java.lang.String) ("putMask_Number(this, 3, 3);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_237.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_237.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].flashPoint"));
                                __jsp_taghandler_237.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_237.doStartTag();
                                if (__jsp_taghandler_237.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_237,5);
                              }
                            } while (__jsp_taghandler_236.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_236.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_236,4);
                        }
                        out.write(__oracle_jsp_text[272]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_238=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_238.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_238.setId("fumigationOnly");
                          __jsp_tag_starteval=__jsp_taghandler_238.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_238,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[273]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_239=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_239.setParent(__jsp_taghandler_238);
                                __jsp_taghandler_239.setName("fell002");
                                __jsp_taghandler_239.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_239.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].fumigationOnly"));
                                __jsp_taghandler_239.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_239.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_239,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[274]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_240=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_240.setParent(__jsp_taghandler_239);
                                      __jsp_taghandler_240.setLabel("name");
                                      __jsp_taghandler_240.setName("fell002");
                                      __jsp_taghandler_240.setProperty("fumigationOnlyValues");
                                      __jsp_taghandler_240.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_240.doStartTag();
                                      if (__jsp_taghandler_240.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_240,6);
                                    }
                                    out.write(__oracle_jsp_text[275]);
                                  } while (__jsp_taghandler_239.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_239.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_239,5);
                              }
                              out.write(__oracle_jsp_text[276]);
                            } while (__jsp_taghandler_238.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_238.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_238,4);
                        }
                        out.write(__oracle_jsp_text[277]);
                        out.write(__oracle_jsp_text[278]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_241=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_241.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_241.setId("residue");
                          __jsp_tag_starteval=__jsp_taghandler_241.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_241,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[279]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_242=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_242.setParent(__jsp_taghandler_241);
                                __jsp_taghandler_242.setName("fell002");
                                __jsp_taghandler_242.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                __jsp_taghandler_242.setValue("DG");
                                __jsp_tag_starteval=__jsp_taghandler_242.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[280]);
                                    {
                                      org.apache.struts.taglib.html.SelectTag __jsp_taghandler_243=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag disabled name property style");
                                      __jsp_taghandler_243.setParent(__jsp_taghandler_242);
                                      __jsp_taghandler_243.setDisabled(true);
                                      __jsp_taghandler_243.setName("fell002");
                                      __jsp_taghandler_243.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].residue"));
                                      __jsp_taghandler_243.setStyle("width:98%");
                                      __jsp_tag_starteval=__jsp_taghandler_243.doStartTag();
                                      if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                      {
                                        out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_243,__jsp_tag_starteval,out);
                                        do {
                                          out.write(__oracle_jsp_text[281]);
                                          {
                                            org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_244=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                            __jsp_taghandler_244.setParent(__jsp_taghandler_243);
                                            __jsp_taghandler_244.setLabel("name");
                                            __jsp_taghandler_244.setName("fell002");
                                            __jsp_taghandler_244.setProperty("residueValues");
                                            __jsp_taghandler_244.setValue("code");
                                            __jsp_tag_starteval=__jsp_taghandler_244.doStartTag();
                                            if (__jsp_taghandler_244.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_244,7);
                                          }
                                          out.write(__oracle_jsp_text[282]);
                                        } while (__jsp_taghandler_243.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                        out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                      }
                                      if (__jsp_taghandler_243.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_243,6);
                                    }
                                    out.write(__oracle_jsp_text[283]);
                                  } while (__jsp_taghandler_242.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_242.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_242,5);
                              }
                              out.write(__oracle_jsp_text[284]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_245=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_245.setParent(__jsp_taghandler_241);
                                __jsp_taghandler_245.setName("fell002");
                                __jsp_taghandler_245.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                __jsp_taghandler_245.setValue("DG");
                                __jsp_tag_starteval=__jsp_taghandler_245.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[285]);
                                    {
                                      org.apache.struts.taglib.html.SelectTag __jsp_taghandler_246=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                      __jsp_taghandler_246.setParent(__jsp_taghandler_245);
                                      __jsp_taghandler_246.setName("fell002");
                                      __jsp_taghandler_246.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+",'residue',this)"));
                                      __jsp_taghandler_246.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].residue"));
                                      __jsp_taghandler_246.setStyle("width:98%");
                                      __jsp_tag_starteval=__jsp_taghandler_246.doStartTag();
                                      if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                      {
                                        out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_246,__jsp_tag_starteval,out);
                                        do {
                                          out.write(__oracle_jsp_text[286]);
                                          {
                                            org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_247=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                            __jsp_taghandler_247.setParent(__jsp_taghandler_246);
                                            __jsp_taghandler_247.setLabel("name");
                                            __jsp_taghandler_247.setName("fell002");
                                            __jsp_taghandler_247.setProperty("residueValues");
                                            __jsp_taghandler_247.setValue("code");
                                            __jsp_tag_starteval=__jsp_taghandler_247.doStartTag();
                                            if (__jsp_taghandler_247.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_247,7);
                                          }
                                          out.write(__oracle_jsp_text[287]);
                                        } while (__jsp_taghandler_246.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                        out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                      }
                                      if (__jsp_taghandler_246.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_246,6);
                                    }
                                    out.write(__oracle_jsp_text[288]);
                                  } while (__jsp_taghandler_245.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_245.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_245,5);
                              }
                              out.write(__oracle_jsp_text[289]);
                            } while (__jsp_taghandler_241.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_241.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_241,4);
                        }
                        out.write(__oracle_jsp_text[290]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_248=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_248.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_248.setId("overheight");
                          __jsp_tag_starteval=__jsp_taghandler_248.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_248,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_249=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_249.setParent(__jsp_taghandler_248);
                                __jsp_taghandler_249.setMaxlength("15");
                                __jsp_taghandler_249.setName("fell002");
                                __jsp_taghandler_249.setOnblur((java.lang.String) ("putMask_Number(this, 10, 4);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_249.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_249.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].overheight"));
                                __jsp_taghandler_249.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_249.doStartTag();
                                if (__jsp_taghandler_249.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_249,5);
                              }
                            } while (__jsp_taghandler_248.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_248.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_248,4);
                        }
                        out.write(__oracle_jsp_text[291]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_250=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_250.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_250.setId("overwidthLeft");
                          __jsp_tag_starteval=__jsp_taghandler_250.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_250,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_251=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_251.setParent(__jsp_taghandler_250);
                                __jsp_taghandler_251.setMaxlength("15");
                                __jsp_taghandler_251.setName("fell002");
                                __jsp_taghandler_251.setOnblur((java.lang.String) ("putMask_Number(this, 10, 4);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_251.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_251.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].overwidthLeft"));
                                __jsp_taghandler_251.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_251.doStartTag();
                                if (__jsp_taghandler_251.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_251,5);
                              }
                            } while (__jsp_taghandler_250.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_250.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_250,4);
                        }
                        out.write(__oracle_jsp_text[292]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_252=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_252.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_252.setId("overwidthRight");
                          __jsp_tag_starteval=__jsp_taghandler_252.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_252,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_253=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_253.setParent(__jsp_taghandler_252);
                                __jsp_taghandler_253.setMaxlength("15");
                                __jsp_taghandler_253.setName("fell002");
                                __jsp_taghandler_253.setOnblur((java.lang.String) ("putMask_Number(this, 10, 4);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_253.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_253.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].overwidthRight"));
                                __jsp_taghandler_253.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_253.doStartTag();
                                if (__jsp_taghandler_253.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_253,5);
                              }
                            } while (__jsp_taghandler_252.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_252.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_252,4);
                        }
                        out.write(__oracle_jsp_text[293]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_254=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_254.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_254.setId("overlengthFront");
                          __jsp_tag_starteval=__jsp_taghandler_254.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_254,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_255=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_255.setParent(__jsp_taghandler_254);
                                __jsp_taghandler_255.setMaxlength("15");
                                __jsp_taghandler_255.setName("fell002");
                                __jsp_taghandler_255.setOnblur((java.lang.String) ("putMask_Number(this, 10, 4);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_255.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_255.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].overlengthFront"));
                                __jsp_taghandler_255.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_255.doStartTag();
                                if (__jsp_taghandler_255.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_255,5);
                              }
                            } while (__jsp_taghandler_254.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_254.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_254,4);
                        }
                        out.write(__oracle_jsp_text[294]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_256=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_256.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_256.setId("overlengthAfter");
                          __jsp_tag_starteval=__jsp_taghandler_256.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_256,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_257=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_257.setParent(__jsp_taghandler_256);
                                __jsp_taghandler_257.setMaxlength("15");
                                __jsp_taghandler_257.setName("fell002");
                                __jsp_taghandler_257.setOnblur((java.lang.String) ("putMask_Number(this, 10, 4);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_257.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_257.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].overlengthAfter"));
                                __jsp_taghandler_257.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_257.doStartTag();
                                if (__jsp_taghandler_257.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_257,5);
                              }
                            } while (__jsp_taghandler_256.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_256.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_256,4);
                        }
                        out.write(__oracle_jsp_text[295]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_258=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_258.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_258.setId("reeferTemp");
                          __jsp_tag_starteval=__jsp_taghandler_258.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_258,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_259=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                __jsp_taghandler_259.setParent(__jsp_taghandler_258);
                                __jsp_taghandler_259.setMaxlength("8");
                                __jsp_taghandler_259.setName("fell002");
                                __jsp_taghandler_259.setOnblur((java.lang.String) ("putMask_Number(this, 3, 3);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                __jsp_taghandler_259.setOnclick("hideMask_Number(this);");
                                __jsp_taghandler_259.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].reeferTemp"));
                                __jsp_taghandler_259.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_259.doStartTag();
                                if (__jsp_taghandler_259.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_259,5);
                              }
                            } while (__jsp_taghandler_258.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_258.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_258,4);
                        }
                        out.write(__oracle_jsp_text[296]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_260=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_260.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_260.setId("reeferTempUnit");
                          __jsp_tag_starteval=__jsp_taghandler_260.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_260,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[297]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_261=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_261.setParent(__jsp_taghandler_260);
                                __jsp_taghandler_261.setName("fell002");
                                __jsp_taghandler_261.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_261.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].reeferTempUnit"));
                                __jsp_taghandler_261.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_261.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_261,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[298]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_262=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_262.setParent(__jsp_taghandler_261);
                                      __jsp_taghandler_262.setLabel("name");
                                      __jsp_taghandler_262.setName("fell002");
                                      __jsp_taghandler_262.setProperty("reeferTempUnitValues");
                                      __jsp_taghandler_262.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_262.doStartTag();
                                      if (__jsp_taghandler_262.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_262,6);
                                    }
                                    out.write(__oracle_jsp_text[299]);
                                  } while (__jsp_taghandler_261.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_261.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_261,5);
                              }
                              out.write(__oracle_jsp_text[300]);
                            } while (__jsp_taghandler_260.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_260.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_260,4);
                        }
                        out.write(__oracle_jsp_text[301]);
                        out.write(__oracle_jsp_text[302]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_263=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_263.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_263.setId("humidity");
                          __jsp_tag_starteval=__jsp_taghandler_263.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_263,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[303]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_264=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_264.setParent(__jsp_taghandler_263);
                                __jsp_taghandler_264.setName("fell002");
                                __jsp_taghandler_264.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].reeferFlag"));
                                __jsp_taghandler_264.setValue("N");
                                __jsp_tag_starteval=__jsp_taghandler_264.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[304]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_265=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass value");
                                      __jsp_taghandler_265.setParent(__jsp_taghandler_264);
                                      __jsp_taghandler_265.setMaxlength("5");
                                      __jsp_taghandler_265.setName("fell002");
                                      __jsp_taghandler_265.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].humidity"));
                                      __jsp_taghandler_265.setReadonly(true);
                                      __jsp_taghandler_265.setStyle("width:96%");
                                      __jsp_taghandler_265.setStyleClass("non_edit");
                                      __jsp_taghandler_265.setValue("");
                                      __jsp_tag_starteval=__jsp_taghandler_265.doStartTag();
                                      if (__jsp_taghandler_265.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_265,6);
                                    }
                                    out.write(__oracle_jsp_text[305]);
                                  } while (__jsp_taghandler_264.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_264.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_264,5);
                              }
                              out.write(__oracle_jsp_text[306]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_266=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_266.setParent(__jsp_taghandler_263);
                                __jsp_taghandler_266.setName("fell002");
                                __jsp_taghandler_266.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].reeferFlag"));
                                __jsp_taghandler_266.setValue("N");
                                __jsp_tag_starteval=__jsp_taghandler_266.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[307]);
                                    {
                                      org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_267=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                      __jsp_taghandler_267.setParent(__jsp_taghandler_266);
                                      __jsp_taghandler_267.setName("fell002");
                                      __jsp_taghandler_267.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                      __jsp_taghandler_267.setValue("Non Reefer");
                                      __jsp_tag_starteval=__jsp_taghandler_267.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[308]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_268=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass value");
                                            __jsp_taghandler_268.setParent(__jsp_taghandler_267);
                                            __jsp_taghandler_268.setMaxlength("5");
                                            __jsp_taghandler_268.setName("fell002");
                                            __jsp_taghandler_268.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].humidity"));
                                            __jsp_taghandler_268.setReadonly(true);
                                            __jsp_taghandler_268.setStyle("width:96%");
                                            __jsp_taghandler_268.setStyleClass("non_edit");
                                            __jsp_taghandler_268.setValue("");
                                            __jsp_tag_starteval=__jsp_taghandler_268.doStartTag();
                                            if (__jsp_taghandler_268.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_268,7);
                                          }
                                          out.write(__oracle_jsp_text[309]);
                                        } while (__jsp_taghandler_267.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_267.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_267,6);
                                    }
                                    out.write(__oracle_jsp_text[310]);
                                    {
                                      org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_269=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                      __jsp_taghandler_269.setParent(__jsp_taghandler_266);
                                      __jsp_taghandler_269.setName("fell002");
                                      __jsp_taghandler_269.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                      __jsp_taghandler_269.setValue("Non Reefer");
                                      __jsp_tag_starteval=__jsp_taghandler_269.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[311]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_270=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                            __jsp_taghandler_270.setParent(__jsp_taghandler_269);
                                            __jsp_taghandler_270.setMaxlength("6");
                                            __jsp_taghandler_270.setName("fell002");
                                            __jsp_taghandler_270.setOnblur((java.lang.String) ("putMask_Number(this, 3, 2);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_270.setOnclick("hideMask_Number(this);");
                                            __jsp_taghandler_270.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].humidity"));
                                            __jsp_taghandler_270.setStyle("width:96%");
                                            __jsp_tag_starteval=__jsp_taghandler_270.doStartTag();
                                            if (__jsp_taghandler_270.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_270,7);
                                          }
                                          out.write(__oracle_jsp_text[312]);
                                        } while (__jsp_taghandler_269.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_269.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_269,6);
                                    }
                                    out.write(__oracle_jsp_text[313]);
                                  } while (__jsp_taghandler_266.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_266.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_266,5);
                              }
                              out.write(__oracle_jsp_text[314]);
                            } while (__jsp_taghandler_263.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_263.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_263,4);
                        }
                        out.write(__oracle_jsp_text[315]);
                        out.write(__oracle_jsp_text[316]);
                        out.write(__oracle_jsp_text[317]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_271=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_271.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_271.setId("ventilation");
                          __jsp_tag_starteval=__jsp_taghandler_271.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_271,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[318]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_272=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_272.setParent(__jsp_taghandler_271);
                                __jsp_taghandler_272.setName("fell002");
                                __jsp_taghandler_272.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].reeferFlag"));
                                __jsp_taghandler_272.setValue("N");
                                __jsp_tag_starteval=__jsp_taghandler_272.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[319]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_273=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass value");
                                      __jsp_taghandler_273.setParent(__jsp_taghandler_272);
                                      __jsp_taghandler_273.setMaxlength("5");
                                      __jsp_taghandler_273.setName("fell002");
                                      __jsp_taghandler_273.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].ventilation"));
                                      __jsp_taghandler_273.setReadonly(true);
                                      __jsp_taghandler_273.setStyle("width:96%");
                                      __jsp_taghandler_273.setStyleClass("non_edit");
                                      __jsp_taghandler_273.setValue("");
                                      __jsp_tag_starteval=__jsp_taghandler_273.doStartTag();
                                      if (__jsp_taghandler_273.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_273,6);
                                    }
                                    out.write(__oracle_jsp_text[320]);
                                  } while (__jsp_taghandler_272.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_272.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_272,5);
                              }
                              out.write(__oracle_jsp_text[321]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_274=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_274.setParent(__jsp_taghandler_271);
                                __jsp_taghandler_274.setName("fell002");
                                __jsp_taghandler_274.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].reeferFlag"));
                                __jsp_taghandler_274.setValue("N");
                                __jsp_tag_starteval=__jsp_taghandler_274.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[322]);
                                    {
                                      org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_275=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                      __jsp_taghandler_275.setParent(__jsp_taghandler_274);
                                      __jsp_taghandler_275.setName("fell002");
                                      __jsp_taghandler_275.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                      __jsp_taghandler_275.setValue("Non Reefer");
                                      __jsp_tag_starteval=__jsp_taghandler_275.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[323]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_276=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass value");
                                            __jsp_taghandler_276.setParent(__jsp_taghandler_275);
                                            __jsp_taghandler_276.setMaxlength("5");
                                            __jsp_taghandler_276.setName("fell002");
                                            __jsp_taghandler_276.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].ventilation"));
                                            __jsp_taghandler_276.setReadonly(true);
                                            __jsp_taghandler_276.setStyle("width:96%");
                                            __jsp_taghandler_276.setStyleClass("non_edit");
                                            __jsp_taghandler_276.setValue("");
                                            __jsp_tag_starteval=__jsp_taghandler_276.doStartTag();
                                            if (__jsp_taghandler_276.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_276,7);
                                          }
                                          out.write(__oracle_jsp_text[324]);
                                        } while (__jsp_taghandler_275.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_275.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_275,6);
                                    }
                                    out.write(__oracle_jsp_text[325]);
                                    {
                                      org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_277=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                      __jsp_taghandler_277.setParent(__jsp_taghandler_274);
                                      __jsp_taghandler_277.setName("fell002");
                                      __jsp_taghandler_277.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].specialHandling"));
                                      __jsp_taghandler_277.setValue("Non Reefer");
                                      __jsp_tag_starteval=__jsp_taghandler_277.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[326]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_278=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onclick property style");
                                            __jsp_taghandler_278.setParent(__jsp_taghandler_277);
                                            __jsp_taghandler_278.setMaxlength("6");
                                            __jsp_taghandler_278.setName("fell002");
                                            __jsp_taghandler_278.setOnblur((java.lang.String) ("putMask_Number(this, 3, 2);updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_278.setOnclick("hideMask_Number(this);");
                                            __jsp_taghandler_278.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].ventilation"));
                                            __jsp_taghandler_278.setStyle("width:96%");
                                            __jsp_tag_starteval=__jsp_taghandler_278.doStartTag();
                                            if (__jsp_taghandler_278.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_278,7);
                                          }
                                          out.write(__oracle_jsp_text[327]);
                                        } while (__jsp_taghandler_277.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_277.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_277,6);
                                    }
                                    out.write(__oracle_jsp_text[328]);
                                  } while (__jsp_taghandler_274.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_274.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_274,5);
                              }
                              out.write(__oracle_jsp_text[329]);
                            } while (__jsp_taghandler_271.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_271.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_271,4);
                        }
                        out.write(__oracle_jsp_text[330]);
                        out.write(__oracle_jsp_text[331]);
                        out.write(__oracle_jsp_text[332]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_279=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_279.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_279.setId("remarks");
                          __jsp_tag_starteval=__jsp_taghandler_279.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_279,__jsp_tag_starteval,out);
                            do {
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_280=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                __jsp_taghandler_280.setParent(__jsp_taghandler_279);
                                __jsp_taghandler_280.setMaxlength("2000");
                                __jsp_taghandler_280.setName("fell002");
                                __jsp_taghandler_280.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+")"));
                                __jsp_taghandler_280.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].remarks"));
                                __jsp_taghandler_280.setStyle("width:96%");
                                __jsp_tag_starteval=__jsp_taghandler_280.doStartTag();
                                if (__jsp_taghandler_280.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_280,5);
                              }
                            } while (__jsp_taghandler_279.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_279.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_279,4);
                        }
                        out.write(__oracle_jsp_text[333]);
                        {
                          com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag __jsp_taghandler_281=(com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag)OracleJspRuntime.getTagHandler(pageContext,com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag.class,"com.ideo.sweetdevria.taglib.grid.grid.GridColumnTag id");
                          __jsp_taghandler_281.setParent(__jsp_taghandler_84);
                          __jsp_taghandler_281.setId("craneDescription");
                          __jsp_tag_starteval=__jsp_taghandler_281.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_281,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[334]);
                              {
                                org.apache.struts.taglib.html.SelectTag __jsp_taghandler_282=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onblur property style");
                                __jsp_taghandler_282.setParent(__jsp_taghandler_281);
                                __jsp_taghandler_282.setName("fell002");
                                __jsp_taghandler_282.setOnblur((java.lang.String) ("updateBookingStatusFlage("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+",'residue',this)"));
                                __jsp_taghandler_282.setProperty((java.lang.String) ("bookingValue["+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowCount}",java.lang.String.class, __ojsp_varRes, null)+"].residue"));
                                __jsp_taghandler_282.setStyle("width:98%");
                                __jsp_tag_starteval=__jsp_taghandler_282.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_282,__jsp_tag_starteval,out);
                                  do {
                                    out.write(__oracle_jsp_text[335]);
                                    {
                                      org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_283=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                                      __jsp_taghandler_283.setParent(__jsp_taghandler_282);
                                      __jsp_taghandler_283.setLabel("name");
                                      __jsp_taghandler_283.setName("fell002");
                                      __jsp_taghandler_283.setProperty("residueValues");
                                      __jsp_taghandler_283.setValue("code");
                                      __jsp_tag_starteval=__jsp_taghandler_283.doStartTag();
                                      if (__jsp_taghandler_283.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_283,6);
                                    }
                                    out.write(__oracle_jsp_text[336]);
                                  } while (__jsp_taghandler_282.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_282.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_282,5);
                              }
                              out.write(__oracle_jsp_text[337]);
                            } while (__jsp_taghandler_281.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_281.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_281,4);
                        }
                        out.write(__oracle_jsp_text[338]);
                      } while (__jsp_taghandler_84.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_84.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_84,3);
                  }
                  out.write(__oracle_jsp_text[339]);
                } while (__jsp_taghandler_83.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_83.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_83,2);
            }
            out.write(__oracle_jsp_text[340]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[341]);
      {
        org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_284=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
        __jsp_taghandler_284.setParent(null);
        __jsp_taghandler_284.setName("fell002");
        __jsp_taghandler_284.setProperty("vesselOwner");
        __jsp_tag_starteval=__jsp_taghandler_284.doStartTag();
        if (__jsp_taghandler_284.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_284,1);
      }
      out.write(__oracle_jsp_text[342]);
      {
        org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_285=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
        __jsp_taghandler_285.setParent(null);
        __jsp_taghandler_285.setId("rowdata");
        __jsp_taghandler_285.setIndexId("ctr");
        __jsp_taghandler_285.setName("fell002");
        __jsp_taghandler_285.setProperty("marlBookedDtlTable");
        __jsp_taghandler_285.setType("com.rclgroup.dolphin.ezl.web.ell.vo.EllLoadListBookingMod");
        com.rclgroup.dolphin.ezl.web.ell.vo.EllLoadListBookingMod rowdata = null;
        java.lang.Integer ctr = null;
        __jsp_tag_starteval=__jsp_taghandler_285.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_285,__jsp_tag_starteval,out);
          do {
            rowdata = (com.rclgroup.dolphin.ezl.web.ell.vo.EllLoadListBookingMod) pageContext.findAttribute("rowdata");
            ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
            out.write(__oracle_jsp_text[343]);
            out.print( "row" + ctr );
            out.write(__oracle_jsp_text[344]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_286=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
              __jsp_taghandler_286.setParent(__jsp_taghandler_285);
              __jsp_taghandler_286.setName("fell002");
              __jsp_taghandler_286.setOnclick(OracleJspRuntime.toStr( "highlightRow("+ctr+")"));
              __jsp_taghandler_286.setProperty("radioGroup1");
              __jsp_taghandler_286.setStyleClass("check");
              __jsp_taghandler_286.setValue(OracleJspRuntime.toStr( ctr));
              __jsp_tag_starteval=__jsp_taghandler_286.doStartTag();
              if (__jsp_taghandler_286.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_286,2);
            }
            out.write(__oracle_jsp_text[345]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_287=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
              __jsp_taghandler_287.setParent(__jsp_taghandler_285);
              __jsp_taghandler_287.setMaxlength("5");
              __jsp_taghandler_287.setName("fell002");
              __jsp_taghandler_287.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].contSeq"));
              __jsp_taghandler_287.setReadonly(true);
              __jsp_taghandler_287.setStyle("width:96%");
              __jsp_taghandler_287.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_287.doStartTag();
              if (__jsp_taghandler_287.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_287,2);
            }
            out.write(__oracle_jsp_text[346]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_288=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
              __jsp_taghandler_288.setParent(__jsp_taghandler_285);
              __jsp_taghandler_288.setMaxlength("17");
              __jsp_taghandler_288.setName("fell002");
              __jsp_taghandler_288.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].bookingNo"));
              __jsp_taghandler_288.setReadonly(true);
              __jsp_taghandler_288.setStyle("width:96%");
              __jsp_taghandler_288.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_288.doStartTag();
              if (__jsp_taghandler_288.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_288,2);
            }
            out.write(__oracle_jsp_text[347]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_289=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_289.setParent(__jsp_taghandler_285);
              __jsp_taghandler_289.setName("fell002");
              __jsp_taghandler_289.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].bookedId"));
              __jsp_tag_starteval=__jsp_taghandler_289.doStartTag();
              if (__jsp_taghandler_289.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_289,2);
            }
            out.write(__oracle_jsp_text[348]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_290=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_290.setParent(__jsp_taghandler_285);
              __jsp_taghandler_290.setName("fell002");
              __jsp_taghandler_290.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].recordChangeDt"));
              __jsp_tag_starteval=__jsp_taghandler_290.doStartTag();
              if (__jsp_taghandler_290.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_290,2);
            }
            out.write(__oracle_jsp_text[349]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_291=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_291.setParent(__jsp_taghandler_285);
              __jsp_taghandler_291.setName("fell002");
              __jsp_taghandler_291.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].status"));
              __jsp_tag_starteval=__jsp_taghandler_291.doStartTag();
              if (__jsp_taghandler_291.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_291,2);
            }
            out.write(__oracle_jsp_text[350]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_292=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_292.setParent(__jsp_taghandler_285);
              __jsp_taghandler_292.setName("fell002");
              __jsp_taghandler_292.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].bookedSeqNo"));
              __jsp_tag_starteval=__jsp_taghandler_292.doStartTag();
              if (__jsp_taghandler_292.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_292,2);
            }
            out.write(__oracle_jsp_text[351]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_293=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_293.setParent(__jsp_taghandler_285);
              __jsp_taghandler_293.setName("fell002");
              __jsp_taghandler_293.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].reeferFlag"));
              __jsp_tag_starteval=__jsp_taghandler_293.doStartTag();
              if (__jsp_taghandler_293.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_293,2);
            }
            out.write(__oracle_jsp_text[352]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_294=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_294.setParent(__jsp_taghandler_285);
              __jsp_taghandler_294.setName("fell002");
              __jsp_taghandler_294.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].socCoc"));
              __jsp_taghandler_294.setValue("SOC");
              __jsp_tag_starteval=__jsp_taghandler_294.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[353]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_295=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                    __jsp_taghandler_295.setParent(__jsp_taghandler_294);
                    __jsp_taghandler_295.setMaxlength("12");
                    __jsp_taghandler_295.setName("fell002");
                    __jsp_taghandler_295.setOnblur(OracleJspRuntime.toStr( "updateBookingStatusFlage(" + ctr + ")"));
                    __jsp_taghandler_295.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].equipmentNo"));
                    __jsp_taghandler_295.setStyle("width:96%");
                    __jsp_tag_starteval=__jsp_taghandler_295.doStartTag();
                    if (__jsp_taghandler_295.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_295,3);
                  }
                  out.write(__oracle_jsp_text[354]);
                } while (__jsp_taghandler_294.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_294.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_294,2);
            }
            out.write(__oracle_jsp_text[355]);
            {
              org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_296=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
              __jsp_taghandler_296.setParent(__jsp_taghandler_285);
              __jsp_taghandler_296.setName("fell002");
              __jsp_taghandler_296.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].socCoc"));
              __jsp_taghandler_296.setValue("SOC");
              __jsp_tag_starteval=__jsp_taghandler_296.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[356]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_297=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_297.setParent(__jsp_taghandler_296);
                    __jsp_taghandler_297.setName("fell002");
                    __jsp_taghandler_297.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].fullMT"));
                    __jsp_taghandler_297.setValue("Empty");
                    __jsp_tag_starteval=__jsp_taghandler_297.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[357]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_298=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                          __jsp_taghandler_298.setParent(__jsp_taghandler_297);
                          __jsp_taghandler_298.setMaxlength("12");
                          __jsp_taghandler_298.setName("fell002");
                          __jsp_taghandler_298.setOnblur(OracleJspRuntime.toStr( "updateBookingStatusFlage(" + ctr + ")"));
                          __jsp_taghandler_298.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].equipmentNo"));
                          __jsp_taghandler_298.setStyle("width:96%");
                          __jsp_tag_starteval=__jsp_taghandler_298.doStartTag();
                          if (__jsp_taghandler_298.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_298,4);
                        }
                        out.write(__oracle_jsp_text[358]);
                      } while (__jsp_taghandler_297.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_297.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_297,3);
                  }
                  out.write(__oracle_jsp_text[359]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_299=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_299.setParent(__jsp_taghandler_296);
                    __jsp_taghandler_299.setName("fell002");
                    __jsp_taghandler_299.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].fullMT"));
                    __jsp_taghandler_299.setValue("Empty");
                    __jsp_tag_starteval=__jsp_taghandler_299.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[360]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_300=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly style styleClass");
                          __jsp_taghandler_300.setParent(__jsp_taghandler_299);
                          __jsp_taghandler_300.setMaxlength("12");
                          __jsp_taghandler_300.setName("fell002");
                          __jsp_taghandler_300.setProperty(OracleJspRuntime.toStr( "bookingValue[" + ctr + "].equipmentNo"));
                          __jsp_taghandler_300.setReadonly(true);
                          __jsp_taghandler_300.setStyle("width:96%");
                          __jsp_taghandler_300.setStyleClass("non_edit");
                          __jsp_tag_starteval=__jsp_taghandler_300.doStartTag();
                          if (__jsp_taghandler_300.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_300,4);
                        }
                        out.write(__oracle_jsp_text[361]);
                      } while (__jsp_taghandler_299.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_299.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_299,3);
                  }
                  out.write(__oracle_jsp_text[362]);
                } while (__jsp_taghandler_296.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_296.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_296,2);
            }
            out.write(__oracle_jsp_text[363]);
          } while (__jsp_taghandler_285.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_285.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_285,1);
      }
      out.write(__oracle_jsp_text[364]);
      out.write(__oracle_jsp_text[365]);

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
  private static final char __oracle_jsp_text[][]=new char[366][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    " \r\n\r\n<!-- #1: Added new field crane description, 23.03.2012-->\r\n\r\n<!-- Link Custom CSS -->\r\n<!-- Rajeev: Move to file where all CSS Files are added-->\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/css/customizeRiaGrid.css\"></link>\r\n\r\n<!-- Link Common Grid JS -->\r\n<!-- Rajeev: Move to file where all CSS Files are added-->    \r\n<script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "/js/riaGridCommon.js\"></script>\r\n\r\n<!-- Link Screen Specific JS -->\r\n<script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "/js/EllLoadListMaintenanceBookedGrid.js\"></script>\r\n\r\n<script language=\"JavaScript\">\r\n    function initialize() \r\n    {      \r\n        mobjGrid            = SweetDevRia.$('".toCharArray();
    __oracle_jsp_text[17] = 
    "');\r\n        mintTotalRows       = mobjGrid.totalDataNumber;\r\n        mobjFixedTable      = 'tableFixedColumns';\r\n        return false;\r\n    }\r\n</script>\r\n\r\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n\r\n<!-- Rajeev : Change Table Height as per screen requirement -->\r\n<!-- table id=\"GridContainer\" border=\"0\" cellspacing=0 cellpadding=0 height=\"100%\" width=\"960PX\" -->\r\n<div style='height:320px'>\r\n<table id=\"GridContainer\" border=\"0\" cellspacing=0 cellpadding=0 height=\"100%\" width=\"100%\">\r\n\r\n    <!-- Rajeev : Change TR height as per screen requirement -->\r\n    <!-- Row to Store Fixed Table Header and Dynamic Grid -->\r\n    <tr height=\"20px\" valign=\"TOP\">\r\n            \r\n            <!-- Start Store Fixed Table Header -->\r\n            <td width=\"35%\">\r\n                <div style='height:30px'>\r\n                    <table class=\"header\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n                        <thead>\r\n                            <tr>\r\n                                <th width=\"13%\">Select</th>\r\n                                <th width=\"17%\">Container Sequence</th>\r\n                                <th width=\"40%\">Booking #</th>\r\n                                <th width=\"30%\">Equipment #</th>                                \r\n\r\n                            </tr>\r\n                        </thead>\r\n                    </table>\r\n                </div>\r\n            </td>\r\n\r\n            <!-- Start to Add Grid Component -->\r\n            <td width=\"65%\" rowspan=\"2\">\r\n                <div style='height:290px'>\r\n                                        \r\n                    ".toCharArray();
    __oracle_jsp_text[19] = 
    " \r\n                    ".toCharArray();
    __oracle_jsp_text[20] = 
    "    \r\n                                                        ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[39] = 
    " <!-- #1-->\r\n                                                        ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[58] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[60] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[61] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[62] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[66] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[67] = 
    "                                                        \r\n                                                        ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[72] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[73] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[74] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[75] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[77] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[80] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[86] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[87] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[88] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[89] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[90] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[91] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[92] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[93] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[94] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[95] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[96] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[97] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[98] = 
    "\r\n                                                        \r\n                                        ".toCharArray();
    __oracle_jsp_text[99] = 
    "\r\n                        \r\n                                        ".toCharArray();
    __oracle_jsp_text[100] = 
    " \r\n                                        ".toCharArray();
    __oracle_jsp_text[101] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[102] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[103] = 
    "        \r\n                                                ".toCharArray();
    __oracle_jsp_text[104] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[105] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[106] = 
    "        \r\n                                                ".toCharArray();
    __oracle_jsp_text[107] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[108] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[109] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[110] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[111] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[112] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[113] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[114] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[115] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[116] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[117] = 
    "                                                    \r\n                                                    ".toCharArray();
    __oracle_jsp_text[118] = 
    "                                                                    \r\n                                                    ".toCharArray();
    __oracle_jsp_text[119] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[120] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[122] = 
    "                \r\n                                                ".toCharArray();
    __oracle_jsp_text[123] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[124] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[125] = 
    "\r\n                                                          ".toCharArray();
    __oracle_jsp_text[126] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[127] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[128] = 
    "                                                \r\n                                                ".toCharArray();
    __oracle_jsp_text[129] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[130] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[131] = 
    "                                                        \r\n                                                        ".toCharArray();
    __oracle_jsp_text[132] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[133] = 
    "                                                \r\n                                                ".toCharArray();
    __oracle_jsp_text[134] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[135] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[136] = 
    "                                                                                                                        \r\n                                                                                            \r\n                                                                                ".toCharArray();
    __oracle_jsp_text[137] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[138] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[139] = 
    "                \r\n                                                ".toCharArray();
    __oracle_jsp_text[140] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[141] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[142] = 
    " \r\n                                                    <a href=\"#\" onClick=\"showCalendarWithTime('bookingValue[".toCharArray();
    __oracle_jsp_text[143] = 
    "].activityDate', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[144] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n\r\n                                                ".toCharArray();
    __oracle_jsp_text[145] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[146] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[147] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[148] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[149] = 
    "                                                                \r\n                                                                ".toCharArray();
    __oracle_jsp_text[150] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[151] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[152] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[153] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[154] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[155] = 
    "                \r\n                                                    ".toCharArray();
    __oracle_jsp_text[156] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[157] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[158] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[159] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[160] = 
    "                \r\n                                                    ".toCharArray();
    __oracle_jsp_text[161] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[162] = 
    "                \r\n                                                        <input type=\"button\" value=\". . .\" name=\"btnOperatorCodeLookup\" class=\"btnbutton\" onclick='return openContainerOperatorLookup(".toCharArray();
    __oracle_jsp_text[163] = 
    ")'/>\r\n                                                    ".toCharArray();
    __oracle_jsp_text[164] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[165] = 
    "                \r\n                                                \r\n                                                ".toCharArray();
    __oracle_jsp_text[166] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[167] = 
    "\r\n                                                        <input type=\"button\" value=\". . .\" name=\"btnOperatorCodeLookup\" class=\"btnbutton\" onclick='return openOutSlotOperatorLookup(".toCharArray();
    __oracle_jsp_text[168] = 
    ")'/>                                                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[169] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[170] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[171] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[172] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[173] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[174] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[175] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[176] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[177] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[178] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[179] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[180] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[181] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[182] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[183] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[184] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[185] = 
    "\r\n                                                    <!--html:text name=\"fell002\" property=\"bookingValue[".toCharArray();
    __oracle_jsp_text[186] = 
    "].mloETADate\" onblur=\"updateBookingStatusFlage(".toCharArray();
    __oracle_jsp_text[187] = 
    ")\" style=\"width:60%\" maxlength=\"10\" onkeypress=\"dateFormat(this,this.value,event,false,1,document.all('msg'));\" onclick=\"this.select();\"/-->                \r\n                                                    ".toCharArray();
    __oracle_jsp_text[188] = 
    " \r\n                                                    <a href=\"#\" onClick=\"showCalendarWithTime('bookingValue[".toCharArray();
    __oracle_jsp_text[189] = 
    "].mloETADate', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[190] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n                                                ".toCharArray();
    __oracle_jsp_text[191] = 
    "    \r\n                                                 \r\n                                                ".toCharArray();
    __oracle_jsp_text[192] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[193] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[194] = 
    "    \r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                                ".toCharArray();
    __oracle_jsp_text[195] = 
    "    \r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[198] = 
    "        \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "        \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "        \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                                ".toCharArray();
    __oracle_jsp_text[209] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[210] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[211] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[212] = 
    "                \r\n                                                    <a href=\"#\" onClick=\"showCalendarWithTime('bookingValue[".toCharArray();
    __oracle_jsp_text[213] = 
    "].exMloETADate', '', '', '1')\"><img src=\"".toCharArray();
    __oracle_jsp_text[214] = 
    "/images/btnCalendar.gif\" alt=\"Calender\" class=\"calender\"></a>\r\n                                                ".toCharArray();
    __oracle_jsp_text[215] = 
    "                                                    \r\n                                                \r\n                                                ".toCharArray();
    __oracle_jsp_text[216] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[217] = 
    "\r\n                                                    <input type=\"button\" value=\". . .\" name=\"btnHandlingInsCodeLookup\" class=\"btnbutton\" onclick='return openHandlingInsCodeLookup1((".toCharArray();
    __oracle_jsp_text[218] = 
    "))'/>\r\n                                                ".toCharArray();
    __oracle_jsp_text[219] = 
    "                                                        \r\n                                                ".toCharArray();
    __oracle_jsp_text[220] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[221] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[222] = 
    "\r\n                                                    <input type=\"button\" value=\". . .\" name=\"btnHandlingInsCodeLookup\" class=\"btnbutton\" onclick='return openHandlingInsCodeLookup2(".toCharArray();
    __oracle_jsp_text[223] = 
    ")'/>\r\n                                                ".toCharArray();
    __oracle_jsp_text[224] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[225] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[226] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[227] = 
    "\r\n                                                    <input type=\"button\" value=\". . .\" name=\"btnHandlingInsCodeLookup\" class=\"btnbutton\" onclick='return openHandlingInsCodeLookup3(".toCharArray();
    __oracle_jsp_text[228] = 
    ")'/>\r\n                                                ".toCharArray();
    __oracle_jsp_text[229] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[230] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[231] = 
    "\r\n                                                   <!-- ".toCharArray();
    __oracle_jsp_text[232] = 
    "-->\r\n                                                    ".toCharArray();
    __oracle_jsp_text[233] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[234] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[235] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[236] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[237] = 
    "\r\n                                                    <!-- ".toCharArray();
    __oracle_jsp_text[238] = 
    " -->\r\n                                                    ".toCharArray();
    __oracle_jsp_text[239] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[240] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[241] = 
    " \r\n                                                ".toCharArray();
    __oracle_jsp_text[242] = 
    "\r\n\r\n                                                ".toCharArray();
    __oracle_jsp_text[243] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[244] = 
    "\r\n\r\n                                                                ".toCharArray();
    __oracle_jsp_text[245] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[246] = 
    "                                                                            \r\n                                                                ".toCharArray();
    __oracle_jsp_text[247] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[248] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[249] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[250] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[251] = 
    "                                                                                                                                                            \r\n                                                                ".toCharArray();
    __oracle_jsp_text[252] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[253] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[254] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[255] = 
    "\r\n                                                         ".toCharArray();
    __oracle_jsp_text[256] = 
    "                                                                            \r\n                                                    ".toCharArray();
    __oracle_jsp_text[257] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[258] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[259] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[260] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[261] = 
    "\r\n                                                    <input type=\"button\" value=\". . .\" name=\"btnUNNoLookup\" class=\"btnbutton\" onclick='return openUNNoLookup(".toCharArray();
    __oracle_jsp_text[262] = 
    ")'/>\r\n                                                ".toCharArray();
    __oracle_jsp_text[263] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[264] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[265] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[266] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[267] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[268] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[269] = 
    "                                                    \r\n                                                    ".toCharArray();
    __oracle_jsp_text[270] = 
    "                       \r\n                                                ".toCharArray();
    __oracle_jsp_text[271] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[272] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[273] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[274] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[275] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[276] = 
    "       \r\n                                                ".toCharArray();
    __oracle_jsp_text[277] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[278] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[279] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[280] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[281] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[282] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[283] = 
    "                \r\n                                                    ".toCharArray();
    __oracle_jsp_text[284] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[285] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[286] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[287] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[288] = 
    "                \r\n                                                    ".toCharArray();
    __oracle_jsp_text[289] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[290] = 
    "  \r\n                                                ".toCharArray();
    __oracle_jsp_text[291] = 
    "                    \r\n                                                ".toCharArray();
    __oracle_jsp_text[292] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[293] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[294] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[295] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[296] = 
    "    \r\n                                                ".toCharArray();
    __oracle_jsp_text[297] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[298] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[299] = 
    "                                                    \r\n                                                    ".toCharArray();
    __oracle_jsp_text[300] = 
    "                                       \r\n                                                \r\n                                                ".toCharArray();
    __oracle_jsp_text[301] = 
    "    \r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[302] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[303] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[304] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[305] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[306] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[307] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[308] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[309] = 
    "    \r\n                                                        ".toCharArray();
    __oracle_jsp_text[310] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[311] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[312] = 
    "    \r\n                                                        ".toCharArray();
    __oracle_jsp_text[313] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[314] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[315] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[316] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[317] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[318] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[319] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[320] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[321] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[322] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[323] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[324] = 
    "    \r\n\t\t\t                                            ".toCharArray();
    __oracle_jsp_text[325] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[326] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[327] = 
    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                                        ".toCharArray();
    __oracle_jsp_text[328] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[329] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[330] = 
    "                                                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[331] = 
    "\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[332] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[333] = 
    "\r\n                              \r\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- #1 Changes start -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                                ".toCharArray();
    __oracle_jsp_text[334] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[335] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[336] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[337] = 
    "                \r\n                                                ".toCharArray();
    __oracle_jsp_text[338] = 
    "    \r\n                                                <!-- #1 Changes end -->\r\n\r\n  ".toCharArray();
    __oracle_jsp_text[339] = 
    "    \r\n                        ".toCharArray();
    __oracle_jsp_text[340] = 
    " \r\n                                          \r\n                    ".toCharArray();
    __oracle_jsp_text[341] = 
    "    \r\n                        \r\n                                        \r\n                </div>    \r\n            </td>\r\n        \r\n    </tr>        \r\n    ".toCharArray();
    __oracle_jsp_text[342] = 
    "\r\n    <!-- Row to Store Fixed Table Body -->\r\n    <tr height=\"270px\" valign=\"top\">\r\n\r\n            <!-- Start Store Fixed Table Header -->\r\n            <td >\r\n                <div id=\"fixedColumns_bodyDiv\" CLASS='clsNoScroll'  style='height:270px;'>\r\n                    <table id=\"tableFixedColumns\" class=\"table_results\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                        <tbody>\r\n                            ".toCharArray();
    __oracle_jsp_text[343] = 
    "\r\n                                <tr id='".toCharArray();
    __oracle_jsp_text[344] = 
    "' height=\"27px\">\r\n                                    <td width=\"12%\" class=\"center\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[345] = 
    "\r\n                                    </td>\r\n                                    <td width=\"18%\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[346] = 
    "\r\n                                    </td>    \r\n                                    <td width=\"40%\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[347] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[348] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[349] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[350] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[351] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[352] = 
    "\r\n                                        \r\n                                    </td>    \r\n                                    ".toCharArray();
    __oracle_jsp_text[353] = 
    "\r\n                                        <td width=\"30%\">\r\n                                            ".toCharArray();
    __oracle_jsp_text[354] = 
    "\r\n                                        </td>\r\n                                    ".toCharArray();
    __oracle_jsp_text[355] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[356] = 
    "     \r\n                                        ".toCharArray();
    __oracle_jsp_text[357] = 
    "\r\n                                            <td width=\"30%\">\r\n                                                ".toCharArray();
    __oracle_jsp_text[358] = 
    "\r\n                                            </td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[359] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[360] = 
    "\r\n                                            <td width=\"30%\">\r\n                                                ".toCharArray();
    __oracle_jsp_text[361] = 
    "\r\n                                            </td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[362] = 
    "                      \r\n                                    ".toCharArray();
    __oracle_jsp_text[363] = 
    " \r\n                                                                        \r\n                                </tr>    \r\n                            ".toCharArray();
    __oracle_jsp_text[364] = 
    "     \r\n                        </tbody>  \r\n                    </table>\r\n                </div>\r\n            </td>\r\n    </tr>\r\n\r\n</table> \r\n</div>\r\n".toCharArray();
    __oracle_jsp_text[365] = 
    "\r\n\r\n    <script language=\"JavaScript\">\r\n        initialize();\r\n    //    highlightRow(0);\r\n    </script>        \r\n\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

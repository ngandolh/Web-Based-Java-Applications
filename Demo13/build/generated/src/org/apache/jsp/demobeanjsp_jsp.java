package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demobeanjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      model.Student stu01 = null;
      synchronized (session) {
        stu01 = (model.Student) _jspx_page_context.getAttribute("stu01", PageContext.SESSION_SCOPE);
        if (stu01 == null){
          stu01 = new model.Student();
          _jspx_page_context.setAttribute("stu01", stu01, PageContext.SESSION_SCOPE);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("stu01"), "firstName", "MR.", null, null, false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("stu01"), "lastName", "NAM", null, null, false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("stu01"), "age", "10", null, null, false);
          out.write("\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("        <p>Student First Name:</p>\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Student)_jspx_page_context.findAttribute("stu01")).getFirstName())));
      out.write("\n");
      out.write("        <p>Student Last Name:</p>\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Student)_jspx_page_context.findAttribute("stu01")).getLastName())));
      out.write("\n");
      out.write("        <p>Student Age:</p>\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Student)_jspx_page_context.findAttribute("stu01")).getAge())));
      out.write("\n");
      out.write("\n");
      out.write("        <a href=\"testbeanscope.jsp\">Test bean Scope</a>\n");
      out.write("        \n");
      out.write("        <h1>Demo Bean</h1>\n");
      out.write("        ");
      java.util.Date mydate = null;
      synchronized (_jspx_page_context) {
        mydate = (java.util.Date) _jspx_page_context.getAttribute("mydate", PageContext.PAGE_SCOPE);
        if (mydate == null){
          mydate = new java.util.Date();
          _jspx_page_context.setAttribute("mydate", mydate, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <p>The date/time is ");
      out.print( mydate);
      out.write("</p>\n");
      out.write("\n");
      out.write("        ");
      java.util.Date mydate2 = null;
      synchronized (_jspx_page_context) {
        mydate2 = (java.util.Date) _jspx_page_context.getAttribute("mydate2", PageContext.PAGE_SCOPE);
        if (mydate2 == null){
          mydate2 = new java.util.Date();
          _jspx_page_context.setAttribute("mydate2", mydate2, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <p> The date/time thể hiện số 2 của Date Object </p>\n");
      out.write("        ");
      out.print(mydate2.toString());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

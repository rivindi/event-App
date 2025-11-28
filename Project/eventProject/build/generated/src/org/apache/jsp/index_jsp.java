package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("\t<title></title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"navi.css\">\n");
      out.write("    <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<input type=\"checkbox\" id=\"check\">\n");
      out.write("    <label for=\"check\">\n");
      out.write("      <i class=\"fas fa-bars\" id=\"btn\"></i>\n");
      out.write("      <i class=\"fas fa-times-circle\" id=\"cancel\"></i>\n");
      out.write("    </label>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("      <header>Category</header>\n");
      out.write("      <ul>\n");
      out.write("          <li><a href=\"Home.jsp\"><i class=\"fas fa-home\"></i>Home</a></li>\n");
      out.write("        <li><a href=\"#\"><i class=\"fas fa-users\"></i>Profile</a></li>\n");
      out.write("        <li><a href=\"Event.jsp\"><i class=\"fas fa-calendar-week\"></i>Events</a></li>\n");
      out.write("        <li><a href=\"#\"><i class=\"fas fa-address-card\"></i>About</a></li>\n");
      out.write("        <li><a href=\"#\"><i class=\"fas fa-phone\"></i>Contact</a></li>\n");
      out.write("      </ul>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <section></section>\n");
      out.write("</body>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.ProductDAO;
import dto.Product;
import java.util.ArrayList;
import java.util.ArrayList;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product Page</title>\n");
      out.write("        <link href=\"./css/product.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div></div>\n");
      out.write("                <h1 class=\"title\">Welcome to Grocery Store!</h1>\n");
      out.write("                <div class=\"logout\">\n");
      out.write("                    <a href=\"MainServlet?btAction=logout\">Log out</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"content-1\">\n");
      out.write("                    <form action=\"MainServlet\" class=\"form\">\n");
      out.write("                        <div class=\"select\">\n");
      out.write("                            <h3>Choose book</h3> \n");
      out.write("                            <select name=\"cboProduct\">\n");
      out.write("                                <option>Canned Beer</option>\n");
      out.write("                                <option>Newspaper</option>\n");
      out.write("                                <option>Cleaner</option>\n");
      out.write("                                <option>Salt</option>\n");
      out.write("                                <option>Bottled water</option>\n");
      out.write("                                <option>Ice cream</option>\n");
      out.write("                            </select><br/>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" value=\"Add To Cart\" name=\"btAction\" class=\"button\">Add To Cart</button>\n");
      out.write("                        <button type=\"submit\" value=\"ViewCart\" name=\"btAction\" class=\"button\">View Cart</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"content-2\">\n");
      out.write("                    ");

                        ArrayList<Product> list = new ArrayList<>();
                        list = ProductDAO.getProducts();
                    
      out.write("\n");
      out.write("                    <table class=\"table\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Product ID</th>\n");
      out.write("                                <th>Title</th>\n");
      out.write("                                <th>Quantity</th>\n");
      out.write("                                <th>Price</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                if (list != null && !list.isEmpty()) {
                                    for (Product product : list) {
                            
      out.write("\n");
      out.write("                        <form action='MainServlet'>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print( product.getProductId());
      out.write("</td>                    \n");
      out.write("                                <td>");
      out.print( product.getTitle());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( product.getQuantity());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( product.getPrice());
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </form>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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

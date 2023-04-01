package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.RegistrationDTO;

/**
 *
 * @author user
 */
public class ShowSearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowSearchController</title>");
            out.println("<link rel='stytesheet' href='mycss.css' type='text/css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Search Result</h1>");

            String searchValue = request.getParameter("txtSearchValue");

            String urlComeBackSearch = "search.html";

            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");  //vì getAttribute dc object nên phải ép kiểu về List

            if (result != null) {
                out.println("<table border=1 width=100% style='text-align:center;'>");

                // thead
                out.println("<thead style='background-color:#e1f5eb;'>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>Username</th>");
                out.println("<th>Password</th>");
                out.println("<th>Lastname</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");

                //tbody
                out.println("<tbody>");
                int count = 0;
                for (RegistrationDTO dto : result) {
                    String urlRewriting = "MainServlet?btAction=Delete&pk=" + dto.getUsername() + "&lastSearchValue=" + request.getParameter("txtSearchValue");
                    out.println("<form action='MainController'>\n");
                    out.println("<tr>");

                    out.println("<td>" + ++count + ".</td>");
                    out.println("<td>" + dto.getUsername() + "<input type='hidden' name='txtUsername' value='" + dto.getUsername() + "'/>" + "</td>");
                    out.println("<td>" + "<input type='text' name='txtPassword' value='" + dto.getPassword() + "' style='text-align:center; ' />\n" + "</td>");
                    out.println("<td>" + "<input type='text' name='txtLastname' value='" + dto.getLastname() + "' style='text-align:center; ' />\n" + "</td>");

                    if (dto.isRole() == true) {
                        out.println("<td>" + "<input type='checkbox' name='chkrole' value='admin' checked/>" + "</td>");
                    } else {
                        out.println("<td>" + "<input type='checkbox' name='chkrole' value='admin'/>" + "</td>");
                    }

                    out.println("<td>" + " <a href='" + urlRewriting + "' style='color:red; text-decoration:none; cursor:pointer'>Delete</a>" + "</td>");
                    out.println("<td>" + "<input type='hidden' name='lastSearchValue' value='" + request.getParameter("txtSearchValue") + "'/>" + "<button type='submit' name='btAction' value ='Update' style='background-color: green; color: white; cursor:pointer'/>Update</button>" + "</td>");

                    out.println("</tr>");
                    out.println("</form>");
                }
                out.println("</tbody>");

                out.println("</table>");
            } else {
                out.println("<h2 style='color:red'>No record is matched.</h2>");
            }

            out.println("<a href='" + urlComeBackSearch + "' style='color:#9f3a2b; text-decoration:none; top: 30px;'>Come back to screen Search Page</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

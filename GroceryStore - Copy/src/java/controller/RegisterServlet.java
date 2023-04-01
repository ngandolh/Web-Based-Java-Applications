package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegistrationDAO;

/**
 *
 * @author user
 */
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String lastname = request.getParameter("txtLastname");

            try {
                RegistrationDAO dao = new RegistrationDAO();
                if (dao.registerAccount(username, password, lastname, "false")) {
                    out.println("<h1 style='color: green;'>Sign Up successfully!</h1>");
                    out.println("<h3>Username: " + username + "</h3>");
                    out.println("<h3>Password: " + password + "</h3>");
                    out.println("<h3>Lastname: " + lastname + "</h3>");
                } else {
                    out.println("<h1 style='color: red;'>Sign Up Failed! This username has existed!</h1>");
                    out.println("<a href=\"./register.html\">Click here to try again?</a><p>OR</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                out.println("<a href=\"./login.html\" style=\"background: black; color: #fff; text-decoration: none; padding: 10px 20px; border-radius:10px\">Click here to back to Login Page</a>");
            }
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

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegistrationDAO;
import dto.RegistrationDTO;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

    private final String INVALIDPAGE = "invalid.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String url = INVALIDPAGE;

            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            
            RegistrationDTO acc = null;
            boolean result = RegistrationDAO.checkLogin(username, password);

            if (result) {
                Cookie cookie = new Cookie(username, password);
                cookie.setMaxAge(60 * 5);  //set time cho cookie tồn tại (giây)
                response.addCookie(cookie); //Đính kèm cookie vào HTTP response header
            }

            try {
                acc = RegistrationDAO.getAccounts(username, password);
                if (acc != null) {
                    if (acc.isRole() == true) {  //nếu là admin
                        response.sendRedirect("search.jsp");
                    } else {  //user
                        HttpSession session = request.getSession(true);
                        if (session != null) {
                            session.setAttribute("username", acc.getUsername());
                            session.setAttribute("lastname", acc.getLastname());
                            response.sendRedirect("product.jsp");
                        }
                    }
                } else {
                    response.sendRedirect(url);  //phương thức chuyển hướng các phản ứng đến tài nguyên khác.
                }
            } catch (Exception e) {
                e.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

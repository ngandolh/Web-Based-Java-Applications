package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class MainServlet extends HttpServlet {

    private final String NULLCONTROLLER = "NullServlet";
    private final String LOGINCONTROLLER = "LoginServlet";
    private final String REGISTERCONTROLLER = "RegisterServlet";
    private final String SEARCHCONTROLLER = "SearchServlet";
    private final String DELETECONTROLLER = "DeleteServlet";
    private final String UPDATECONTROLLER = "UpdateServlet";
    private final String ADDPRODUCTCONTROLLER = "AddProductServlet";
    private final String REMOVEPRODUCTCONTROLLER = "RemoveProductServlet";
    private final String VIEWCARTCONTROLLER = "viewCart.jsp";
    private final String LOGOUTSERVLET = "LogOutServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String url = "";
            String button = request.getParameter("btAction");

            try {
                if (button == null) {
                    url = NULLCONTROLLER;
                } else if (button.equals("Login")) {
                    url = LOGINCONTROLLER;
                } else if (button.equals("SignUp")) {
                    url = REGISTERCONTROLLER;
                } else if (button.equals("Search")) {
                    url = SEARCHCONTROLLER;
                } else if (button.equals("Delete")) {
                    url = DELETECONTROLLER;
                } else if (button.equals("Update")) {
                    url = UPDATECONTROLLER;
                } else if (button.equals("Add To Cart")) {
                    url = ADDPRODUCTCONTROLLER;
                } else if (button.equals("Remove Product")) {
                    url = REMOVEPRODUCTCONTROLLER;
                } else if (button.equals("ViewCart")) {
                    url = VIEWCARTCONTROLLER;
                } else if (button.equals("LogOut")) {
                    url = LOGOUTSERVLET;
                }
            } finally {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);

                out.close();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "123456";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usr = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (userID.equals(usr) && password.equals(pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", "THOMAS");

            //30 * 60s
            session.setMaxInactiveInterval(30 * 60);

            response.sendRedirect("auth/PrivatePage");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
//            PrintWriter out = response.getWriter();
//            out.println("<font color=red> Failed");
//            rd.include(request, response);
        }

    }

}

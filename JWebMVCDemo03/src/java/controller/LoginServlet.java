/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Asus
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("txtUser");
        String password = request.getParameter("txtPassword");
        String rememberCheck = request.getParameter("rem");

        Cookie cUserName = new Cookie("cookuser", username);
        Cookie cPassword = new Cookie("cookpass", password);
        Cookie cRemember = new Cookie("cookrem", rememberCheck);
        try {
            if (rememberCheck != null) {
                cUserName.setMaxAge(60 * 60 * 60); 
                cPassword.setMaxAge(60 * 60 * 60);
                cRemember.setMaxAge(60 * 60 * 60);
            } else {
                cUserName.setMaxAge(0);
                cPassword.setMaxAge(0);
                cRemember.setMaxAge(0);
            }
            response.addCookie(cUserName);
            response.addCookie(cPassword);
            response.addCookie(cRemember);
            
            AccountDAO dao = new AccountDAO();
            Account acc = dao.login(username, password);

            if (acc == null) {
                request.setAttribute("ms", "Invaild usermame or password");
//                response.sendRedirect("login.jsp");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                response.sendRedirect("Detail.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("txtUser");
        String password = request.getParameter("txtPassword");

//        if (user.equals("abc") && password.equals("12345")) {
//            
//            request.getRequestDispatcher("welcome").forward(request, response);
//        } else {
//            response.sendRedirect("Login");
//        }
        try {
            AccountDAO dao = new AccountDAO();
            Account acc = dao.login(user, password);
            if(acc == null){
//                request.setAttribute("ms", "Invaild usermame or password");
                request.getRequestDispatcher("login.html").forward(request, response);
            }else{
                 request.getRequestDispatcher("/welcome").forward(request, response);
            }
        } catch (Exception e) {
        }
    }

}

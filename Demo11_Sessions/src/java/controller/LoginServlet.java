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
 * 1. tạo biến session
    2. truy xuất thông tin
3. xóa biến session
4.tạo web.xml cho (timeout)
5.luồn của login/ logout
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/dangnhap"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        if (ses.getAttribute("tennguoidung") != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ketqua.jsp");
            rd.forward(request, response);
        } else{
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("txtAccount");
        String pass = request.getParameter("txtPassword");

        if (account.equals("admin") && pass.equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("tennguoidung", account);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ketqua.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("ketqua.jsp");
        }

    }

}

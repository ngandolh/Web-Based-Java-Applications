/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Calculate.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double a = Double.parseDouble(request.getParameter("txtFirst"));
            double b = Double.parseDouble(request.getParameter("txtSecond"));
            double c = 0;
            String op = request.getParameter("btAction");
            if (op.equals("+")) {
                c = a + b;
                request.setAttribute("add", "selected");
            } else if (op.equals("-")) {
                c = a - b;
                request.setAttribute("sub", "selected");
            } else if (op.equals("*")) {
                c = a * b;
                request.setAttribute("multi", "selected");
            } else {
                if (b == 0) {
                    request.setAttribute("result", "Can not div 0");
                    request.setAttribute("aa", a);
                    request.setAttribute("bb", b);
                    request.setAttribute("divv", "selected");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Calculate.jsp");
                    rd.forward(request, response);
                    return;
                } else {
                    c = a / b;
                    request.setAttribute("divv", "selected");
                }

            }
            request.setAttribute("result", c);
            request.setAttribute("aa", a);
            request.setAttribute("bb", b);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Calculate.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/demoget"})
public class DemoGetFromJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher rd = getServletContext().getRequestDispatcher("/cong.jsp");
       rd.forward(request, response);
       
       double x = Double.parseDouble(request.getParameter("x"));
       double y = Double.parseDouble(request.getParameter("y"));
       double ketquacong = x + y;
       
    }
}

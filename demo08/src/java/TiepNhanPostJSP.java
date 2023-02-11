/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(urlPatterns = {"/ketquanhan"})
public class TiepNhanPostJSP extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double x = Double.parseDouble(request.getParameter("soX"));
        double y = Double.parseDouble(request.getParameter("soY"));
        
        PrintWriter out = response.getWriter();
        out.println("<h1>" + x*y+ "</h1>");
    }

}

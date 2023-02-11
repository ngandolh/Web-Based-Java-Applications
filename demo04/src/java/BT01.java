/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Color.red;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(urlPatterns = {"/chaoban"})
public class BT01 extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strName = request.getParameter("ten");
        
        PrintWriter out = response.getWriter();
        Date d = new Date();
        String strDate = d.toString();
        
        out.print("<h1> Chào bạn" + "</h1>");
        out.print("<h2 style='color: red;'>" + strDate + "</h2>");
//        out.print("<h2 style='color: red;'>" + d.toString() + "</h2>");
    }



}

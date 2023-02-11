/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ketqua"})
public class ShowDiem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double x = Double.parseDouble(request.getParameter("diemthi1"));
        double y = Double.parseDouble(request.getParameter("diemthi2"));
        double z = Double.parseDouble(request.getParameter("diemthi3"));
        double w = ((x+y+z)/3.0);
        PrintWriter out = response.getWriter();
        if (w >= 5.0) {
            out.println("<h1> Chuc mung ban</h1>");
        } else {
            out.println("<h1>Block 3 is coming </h1>");
        }
        
    }

}

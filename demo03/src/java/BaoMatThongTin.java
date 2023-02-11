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
@WebServlet(urlPatterns = {"/dangkytaikhoan"})
public class BaoMatThongTin extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usr = request.getParameter("taikhoan");
        String pass = request.getParameter("matkhau");
        
        PrintWriter out = response.getWriter();
        if (pass.equals("123456")){
            out.println("<h1> Fail </h1>");
        } else {
            out.println("<h1> Success:" + usr + "</h1>");
        }
    }

}

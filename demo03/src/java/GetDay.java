/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/GetDay"})
public class GetDay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//     2.Xây dựng yêu cầu để ngày trong tuần trên Server định dạng gọi yêu cầu
//        như sau: localhost..../..../getdayinweek
        Date d = new Date();
        int strDay = d.getDay();
        

        PrintWriter out = response.getWriter();
//        out.println("<h1>" + +"</h1>");
    }

}

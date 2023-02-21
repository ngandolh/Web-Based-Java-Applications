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
@WebServlet(urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        
        PrintWriter writer = response.getWriter();
        
        //build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your name is:" + username + "<br/>";
        htmlResponse += "Your password is: " + password + "</h2>";
        htmlResponse += "</html>";
                
        //return responsse
        writer.println(htmlResponse);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoginSevlet", urlPatterns = {"/login"})
public class LoginSevlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String checkBoxValue = request.getParameter("remember");
            boolean isChecked = "true".equals(checkBoxValue);
            String opp;
            if(username.equals("administrator")&&pass.equals("123")){
                if(isChecked){
                    HttpSession ss = request.getSession(true);
                    ss.setAttribute("passLong", true);
                    response.sendRedirect("detail.jsp");
                    
                    
                }else{
                    request.setAttribute("passShort", true);
                    request.getRequestDispatcher("detail.jsp").forward(request, response);
                }
                
            }else{
                String err="Your username or password is incorrect!";
                request.setAttribute("err", err);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
                    
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

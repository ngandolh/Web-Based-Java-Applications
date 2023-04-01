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

/**
 *
 * @author ACER
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/cal"})
public class CalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cal.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String err;
        double result = 0.0;
        try{
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2")); 
            String op = request.getParameter("op");
           
            
            switch(op){
                case "+":result=num1+num2;break;
                case "-":result=num1-num2;break;
                case "*":result=num1*num2;break;
                case "/":if(num2!=0){
                    result=num1/num2;
                }else{
                   err = "Cannot devide by 0!"; 
                   request.setAttribute("err", err);
                }
                break;
                
            }
            request.setAttribute("result",result);
            request.setAttribute("num1", num1);
            request.setAttribute("num2", num2);
            
            
        }catch(Exception e){
            err="Please enter number!";
            request.setAttribute("err", err);
            
        }finally{
            request.getRequestDispatcher("cal.jsp").forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repo.ProductData;

/**
 *
 * @author The Anh
 */
@WebServlet(name = "detail", urlPatterns = {"/trangchunangcao"})
public class advanceIndex extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ProductData.initalData();
        request.setAttribute("data", ProductData.listProduct);
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexnangcao.jsp");
        rd.forward(request, response);
        
    }

    

}

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
import model.Product;
import repo.ProductData;

/**
 *
 * @author The Anh
 */
@WebServlet(name = "Detail", urlPatterns = {"/chitiet"})
public class Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id= request.getParameter("maso");
        ProductData.initalData();
        Product p = new Product();
        for(Product x:ProductData.listProduct){
            if(x.getCode().equals(id)){
                p  = x;
            }
            request.setAttribute("data", p);
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail.jsp");
        rd.forward(request, response);
        
    }
    }
  
}

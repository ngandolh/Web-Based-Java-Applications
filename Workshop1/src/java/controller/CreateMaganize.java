/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MagazineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Magazine;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CreateMaganize", urlPatterns = {"/themmoi"})
public class CreateMaganize extends HttpServlet {
    
    private final MagazineDAO ObjectDao = new MagazineDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/create.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("txtId");
        String title = request.getParameter("txtTitle");
        String publisher = request.getParameter("txtPublisher");
        Double price = Double.parseDouble(request.getParameter("txtPrice"));
        
        try {
            Magazine item = new Magazine(id, title, publisher, price);
            ObjectDao.create(item);
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (Exception ex) {
            Logger.getLogger(CreateMaganize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}

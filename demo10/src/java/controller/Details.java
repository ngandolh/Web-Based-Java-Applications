/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Asus
 */
@WebServlet(name = "Details", urlPatterns = {"/chitiet"})
public class Details extends HttpServlet {

    private final ProductDao code = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Product> listItem = code.read();
            String _code = request.getParameter("maso");
            Product p = new Product();
            for (Product x : listItem) {
                if (x.getCode().equals(_code)) {
                    p = x;
                }
            }
            request.setAttribute("detailItem", p);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

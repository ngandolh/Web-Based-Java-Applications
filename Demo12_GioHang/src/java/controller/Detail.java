/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "Detail", urlPatterns = {"/Detail"})
public class Detail extends HttpServlet {
private final ProductDAO code = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listItem = code.read();
        String _code = request.getParameter("Id");
        Product p = new Product();
        for (Product x : listItem) {
            if (x.getId().equals(_code)) {
                p = x;
            }
        }
        request.setAttribute("detailItem", p);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail.jsp");
        rd.forward(request, response);

    }
}

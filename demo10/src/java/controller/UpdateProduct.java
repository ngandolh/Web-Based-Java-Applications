/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDao;
import java.io.IOException;
import java.sql.SQLException;
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
 * @author ASUS
 */
@WebServlet(name = "Update", urlPatterns = {"/chinhsua"})
public class UpdateProduct extends HttpServlet {

    private ProductDao objectDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("maso");
            Product item = objectDao.details(id);

            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/update.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("txtMaSo");
        String name = request.getParameter("txtTen");
        int quantity = Integer.parseInt(request.getParameter("txtSoLuong"));
        double price = Double.parseDouble(request.getParameter("txtDonGia"));

        try {
            Product item = new Product(code, name, quantity, price);
            objectDao.update(item);
            response.sendRedirect(request.getContextPath() + "/trangchu");
        } catch (Exception ex) {
//            SQLException ex
        Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

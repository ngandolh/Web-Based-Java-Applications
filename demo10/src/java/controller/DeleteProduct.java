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
@WebServlet(name = "DeleteProduct", urlPatterns = {"/xoa"})
public class DeleteProduct extends HttpServlet {

    private final ProductDao deleteProduct = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _delete = request.getParameter("maso");
        try {

//              deleteProduct.delete(_delete);
              ProductDao p = new ProductDao();
              p.delete(_delete);
            response.sendRedirect("trangchu");
        } catch (IOException e) {
            System.out.println(e);
//            SQLException ex
        }
//            Logger.getLogger(DeleteProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author Asus
 */
@WebServlet(urlPatterns = {"/themmoi"})
public class Create extends HttpServlet {

    private ProductDao objectDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/create.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _code = request.getParameter("txtMaSo");
        String _name = request.getParameter("txtTen");
        int _quantity = Integer.parseInt(request.getParameter("txtSoLuong"));
        double _price = Double.parseDouble(request.getParameter("txtDonGia"));

        try {
            Product item = new Product(_code, _name, _quantity, _price);
            objectDao.create(item);
            response.sendRedirect(request.getContextPath() + "/trangchu");
        } catch (IOException e) {
//            SQLException ex
//            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(e);

        }
    }

}

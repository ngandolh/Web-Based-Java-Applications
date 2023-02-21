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
@WebServlet(name = "UpdateMagazine", urlPatterns = {"/chinhsua"})
public class UpdateMagazine extends HttpServlet {

    private MagazineDAO objectDao = new MagazineDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String ids = request.getParameter("id");
            Magazine item = objectDao.details(ids);

            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/update.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UpdateMagazine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("txtID");
        String title = request.getParameter("txtTitle");
        String publisher = request.getParameter("txtPublisher");
        double price = Double.parseDouble(request.getParameter("txtPrice"));

        try {
            Magazine item = new Magazine(id, title, publisher, price);
            objectDao.update(item);
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (Exception ex) {
//            SQLException ex
            Logger.getLogger(UpdateMagazine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

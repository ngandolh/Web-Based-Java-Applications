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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "DeleteMagazine", urlPatterns = {"/xoa"})
public class DeleteMagazine extends HttpServlet {

    private final MagazineDAO deleteProduct = new MagazineDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteM = request.getParameter("id");
        try {
            MagazineDAO m = new MagazineDAO();
            m.delete(deleteM);
            response.sendRedirect("home");
        } catch (Exception ex) {
            Logger.getLogger(DeleteMagazine.class.getName()).log(Level.SEVERE, null, ex);

        }
        

        
    }

}

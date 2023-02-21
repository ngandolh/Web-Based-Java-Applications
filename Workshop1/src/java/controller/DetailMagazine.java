/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MagazineDAO;
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
import model.Magazine;

/**
 *
 * @author Asus
 */
@WebServlet(name = "Details", urlPatterns = {"/chitiet"})
public class DetailMagazine extends HttpServlet {

    private final MagazineDAO code = new MagazineDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Magazine> listItem = code.read();
            String _code = request.getParameter("id");
            Magazine p = new Magazine();
            for (Magazine x : listItem) {
                if (x.getId().equals(_code)) {
                    p = x;
                }
            }
            request.setAttribute("detailItem", p);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DetailMagazine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

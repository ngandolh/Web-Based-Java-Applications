/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author The Anh
 */
@WebServlet(urlPatterns = {"/auth/PrivatePage"})
public class PrivatePage extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/privatepage.jsp");
             rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(PublicPage.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(urlPatterns = {"/demo03"})
public class PassingDataJSP03 extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Double> arr = new ArrayList();
        arr.add(5.0);
        arr.add(10.0);
        arr.add(2.5);
        arr.add(19.30);
        
        request.setAttribute("item", arr);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/webpage03.jsp");
        rd.forward(request, response);
    }

 
}

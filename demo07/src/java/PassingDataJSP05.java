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
import model.Product;

/**
 *
 * @author Asus
 */
@WebServlet(urlPatterns = {"/demo05"})
public class PassingDataJSP05 extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Product p1 = new Product("SP001", "Pespi", 100, 12500);
       Product p2 = new Product("SP002", "Coca", 50, 1000);
       Product p3 = new Product("SP003", "Lua", 200, 9000);
       Product p4 = new Product("SP004", "Hen", 60, 12000);
       Product p5 = new Product("SP005", "Bus", 20, 11500);
       
       ArrayList<Product> arr = new ArrayList<Product>();
       arr.add(p1);
       arr.add(p2);
       arr.add(p3);
       arr.add(p4);
       arr.add(p5);
       request.setAttribute("item", arr);
       
       RequestDispatcher rd = getServletContext().getRequestDispatcher("/webpage05.jsp");
       rd.forward(request, response);
    }

    
}

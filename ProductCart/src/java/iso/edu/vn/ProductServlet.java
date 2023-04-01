/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso.edu.vn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    public static List<CartBean> lsCart = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String code;
            ProductDAO dao = new ProductDAO();
            Product pro = null;
            CartBean cart = new CartBean();
            if (action == null || action.equals("")) {
                request.getRequestDispatcher("view-products.jsp").forward(request, response);
                return;
            }
            switch (action) {
                case "AddCart":
                    code = request.getParameter("pId");
                    pro = dao.findByID(code);
                    if (pro != null)  {
                        cart.setPro(pro);
                        cart.setQuantity(1);
                        lsCart.add(cart);
                    }
                    System.out.println("Size:" + lsCart.size());
                    HttpSession session = request.getSession();
                    session.setAttribute("ListCard", lsCart);
                    request.getRequestDispatcher("view-products.jsp").forward(request, response);
                    break;
                case "DelCart":        
                    int id = Integer.parseInt(request.getParameter("pId"));
                    lsCart.remove(id);
                    request.getRequestDispatcher("view-card.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

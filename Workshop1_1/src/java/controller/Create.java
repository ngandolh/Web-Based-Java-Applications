package controller;

import dao.StudentDao;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet(name = "Create", urlPatterns = {"/student/create"})
public class Create extends HttpServlet {

    private StudentDao objectDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/create.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("Name");
        Boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
        Date date = Date.valueOf(request.getParameter("DOB"));
        
        try{
            Student item = new Student(name, gender, date);
            objectDao.create(item);
            response.sendRedirect(request.getContextPath() + "/student/list");
        } catch (SQLException ex) {
         Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

   

}

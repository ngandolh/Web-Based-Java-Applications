package controller;

import controller.Create;
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

@WebServlet(name = "Update", urlPatterns = {"/student/update"})

public class Update extends HttpServlet {

    private StudentDao objectDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("Id");
            Student item = objectDao.details(id);

            request.setAttribute("item", item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/update.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("Name");
        Boolean gender = Boolean.parseBoolean(request.getParameter("Gender"));
        Date date = Date.valueOf(request.getParameter("DOB"));
        int id = Integer.parseInt(request.getParameter("Id"));
        try {
            Student item = new Student(id, name, gender, date);
            objectDao.update(item);
            response.sendRedirect(request.getContextPath() + "/student/list");
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

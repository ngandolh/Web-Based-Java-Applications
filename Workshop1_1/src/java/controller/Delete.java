package controller;

import dao.StudentDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author The Anh
 */
@WebServlet(name = "Delete", urlPatterns = {"/student/delete"})
public class Delete extends HttpServlet {
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        StudentDao pd = new StudentDao();
        pd.delete(id);
        response.sendRedirect("list");
    }

}

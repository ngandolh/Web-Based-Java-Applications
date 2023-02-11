
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/BTGetPost"})
public class BTGetPost extends HttpServlet {

//    Result -> x + y
// /btgetpost>x=...&y=....
    //http://localhost:8084/demo03 /BTGetPost?x=10&y=5
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));

        PrintWriter out = response.getWriter();
        out.println("<h1>" + x + y + "</h1>");
    }

///btgetpost
//Result: so1*so2*so3
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double x = Double.parseDouble(request.getParameter("so1"));
        double y = Double.parseDouble(request.getParameter("so2"));
        double z = Double.parseDouble(request.getParameter("so3"));
        
        PrintWriter out = response.getWriter();
        out.println("<h1>" + x*y*z+ "</h1>");
    }

}

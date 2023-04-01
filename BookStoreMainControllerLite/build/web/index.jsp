<%-- 
    Document   : index
    Created on : Mar 14, 2023, 12:09:43 AM
    Author     : Admin
--%>
<%@page import="dto.BookDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! List<Book> listItem = new ArrayList<>(); %>
        <% 
        if (session.getAttribute("USER") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            BookDAO bdao = new BookDAO();
            listItem = bdao.read();
        }
        %>
        <h1>Welcomes ${sessionScope['USER'].getUsername()}</h1>
        <a href="MainController?btnAction=Logout">logout</a>
        <table border="1"> 
            <thead> 
                <tr> 
                    <th>Name</th> 
                    <th>Page</th> 
                    <th>Price</th>
                    <th>Author</th>
                </tr> 
            </thead>
            <tbody> 
                <% 
                    for (Book p : listItem) { 
                %> 
                <tr> 
                    <td><%=p.getName()%></td> 
                    <td><%=p.getPrice()%></td>  
                    <td><%=p.getPage()%></td> 
                    <td><%=p.getAuthor()%></td> 
                    
                </tr> 
                <% 
                    } 
                %> 
            </tbody> 
        </table>
    </body>
</html>

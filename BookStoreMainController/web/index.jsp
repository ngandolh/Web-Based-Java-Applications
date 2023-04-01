<%-- 
    Document   : index
    Created on : Mar 14, 2023, 12:09:43 AM
    Author     : Admin
--%>

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
        <% 
        if (session.getAttribute("USER") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
                    List<Book> list = (ArrayList) request.getAttribute("listItem"); 
                %> 

                <% 
                    for (Book p : list) { 
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

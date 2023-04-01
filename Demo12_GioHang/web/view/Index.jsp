<%-- 
    Document   : Index
    Created on : Feb 28, 2023, 3:35:21 PM
    Author     : Asus
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Product</title>
    </head>
    <body>
         <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>

                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Product> list = (ArrayList) request.getAttribute("listItem");
                %>

                <%
                    for (Product p : list) {
                %>

                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getName()%></td>
                    <td><%= p.getPrice() %></td>
                    <td><%=p.getQuantity() %></td>

                    <td> 
                        <a href="Detail?Id=<%=p.getId()%>">Xem</a>            
                        <a href="delete?Id=<%=p.getId()%>">Xóa</a>
                        <a href="">Mua</a>
                    </td>
                </tr>
                <%
                    }
                %>

            </tbody>
        </table>
        <a class="addnew" href="create" style=" text-decoration: none;  ">Create</a> 
    </body>
</html>

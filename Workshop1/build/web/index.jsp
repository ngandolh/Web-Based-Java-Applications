<%-- 
    Document   : index
    Created on : Feb 8, 2023, 9:34:38 PM
    Author     : Asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Magazine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome Page!!!</h1>
        <a href="themmoi" >Add a new Magazine</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Maz ID</th>
                    <th>Magazine Title</th>
                    <th>Publisher</th>
                    <th>Price</th>
                
                   <td colspan="3" style="font-weight: bold">Thao Tác</td>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Magazine> list = (ArrayList) request.getAttribute("listItem");
                %>

                <%
                    for (Magazine m : list) {

                %>
                <tr>
                    <td><%=m.getId()%></td>
                    <td><%=m.getTitle()%></td>
                    <td><%=m.getPublisher()%></td>
                    <td><%=m.getPrice()%></td>
                    <td><a href="chitiet?id=<%=m.getId() %>">Xem</a></td>
                    <td><a href="xoa?id=<%=m.getId() %> ">Delete</a></td>
                    <td><a href="chinhsua?id=<%=m.getId() %>">Update</a></td>
                </tr>

                <%
                    }
                %>

            </tbody>

            <!--                <button href="themmoi" type="submit">Add a new Maganize</button>-->
        </table>



    </body>
</html>

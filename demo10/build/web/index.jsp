<%-- 
    Document   : index
    Created on : Feb 3, 2023, 4:32:18 PM
    Author     : Asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <a href="themmoi">Create a new Product</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Detail</th>
                    <th>Remove</th>
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
                    <td><%=p.getCode()%></td>
                    <td><%=p.getName()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><%=p.getQuantity()%></td>
                    <td><a href="chitiet?maso=<%=p.getCode()%>">Xem</a></td>
                    <td><a href="xoa?maso=<%=p.getCode()%>" onclick="doDelete('<%=p.getCode()%>')" >Delete</a></td>
                    <td><a href="chinhsua?maso=<%=p.getCode()%>">Update</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>

            <script type="text/javascript">
                function deDelete(p.getCode()){
                    if (confirm("Are you want to delete Product with id=" + p.getCode() + "?"))
                        window.location = "delete?code=" + p.getCode();
                }
            </script>
    </body>

</html>

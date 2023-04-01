
<%@page import="java.util.ArrayList"%>
<%@page import="iso.edu.vn.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="iso.edu.vn.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h2>Products</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Ma SP</th>
                        <th>Ten SP</th>
                        <th>Gia</th>
                        <th>Cart</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Product> arrPro = new ArrayList<Product>();
                        ProductDAO dao = new ProductDAO();
                        arrPro = dao.getAll();
                        for (Product item : arrPro) {
                    %>
                     
                    <tr>
                        <td><%=item.getCode() %></td>
                        <td><%=item.getName() %></td>
                        <td><%=item.getPrice() %></td>
                        <td><a class="btn btn-primary btn-sm" href="ProductServlet?action=AddCart&pId=<%=item.getCode()%>">Add to Cart</a> </td>
                    </tr>
                   
                    <%
                        }
                    %>

                </tbody>
            </table>
            <a class="btn btn-primary btn-sm" href="view-card.jsp">View Cart</a>
        </div>
    </body>
</html>


<%@page import="java.util.ArrayList"%>
<%@page import="iso.edu.vn.Product"%>
<%@page import="iso.edu.vn.Product"%>
<%@page import="iso.edu.vn.CartBean"%>
<%@page import="iso.edu.vn.ProductServlet"%>
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
            <a class="btn btn-primary btn-sm" href="">Add more</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Ma SP</th>
                        <th>Ten SP</th>
                        <th>Gia</th>
                        <th>So Luong</th>
                        <th>Action</th>

                    </tr>
                </thead>
                <tbody>
                    <%   
                        int i;
                        for (i = 0; i < ProductServlet.lsCart.size(); i++) {
                            CartBean cart = ProductServlet.lsCart.get(i);
//                        ArrayList<CartBean> c = (ArrayList<CartBean>) request.getSession().getAttribute("ListCard");
//                        for (CartBean cart : c) {
                                
                    %>
                    <tr>
                        <td><%=i + 1 %></td>
                        <td><%=cart.getPro().getCode() %></td>
                        <td><%=cart.getPro().getName()%></td>
                        <td><%=cart.getPro().getPrice()%></td>
                        <td><%=cart.getQuantity() %></td>
                        <td><a class="btn btn-danger btn-sm" href="ProductServlet?action=DelCart&pId=<%=i %>">Remove</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>

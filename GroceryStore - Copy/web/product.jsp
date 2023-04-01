
<%@page import="dao.ProductDAO"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link href="./css/product.css" rel="stylesheet"/>

    </head>
    <body>
        <div class="container">
            <div class="header">
                <div></div>
                <h1 class="title">Welcome to Grocery Store!</h1>
                <div class="logout">
                    <a href="MainServlet?btAction=logout">Log out</a>
                </div>
            </div>

            <div class="content">
                <div class="content-1">
                    <form action="MainServlet" class="form">
                        <div class="select">
                            <h3>Choose book</h3> 
                            <select name="cboProduct">
                                <option>Canned Beer</option>
                                <option>Newspaper</option>
                                <option>Cleaner</option>
                                <option>Salt</option>
                                <option>Bottled water</option>
                                <option>Ice cream</option>
                            </select><br/>
                        </div>
                        <button type="submit" value="Add To Cart" name="btAction" class="button">Add To Cart</button>
                        <button type="submit" value="ViewCart" name="btAction" class="button">View Cart</button>
                    </form>
                </div>

                <div class="content-2">
                    <%
                        ArrayList<Product> list = new ArrayList<>();
                        list = ProductDAO.getProducts();
                    %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Title</th>
                                <th>Quantity</th>
                                <th>Price</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%
                                if (list != null && !list.isEmpty()) {
                                    for (Product product : list) {
                            %>
                        <form action='MainServlet'>
                            <tr>
                                <td><%= product.getProductId()%></td>                    
                                <td><%= product.getTitle()%></td>
                                <td><%= product.getQuantity()%></td>
                                <td><%= product.getPrice()%></td>
                            </tr>
                        </form>
                        <%
                                }
                            }
                        %>
                        </tbody>


                    </table>

                </div>
            </div>
        </div>
    </body>
</html>

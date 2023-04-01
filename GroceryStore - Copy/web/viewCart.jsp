
<%@page import="java.util.Map"%>
<%@page import="dto.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <link href="./css/viewCart.css" rel="stylesheet"/>

    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="header-link"><a href="product.jsp">Add More Items To Your Cart</a></div>
                <h1>Your Cart!</h1>
                <div class="logout">
                    <a href="MainServlet?btAction=logout">Log out</a>
                </div>
            </div> 

            <div class="content">
            <%
                if (session != null) {
                    CartObj cart = (CartObj) session.getAttribute("CART");
                    if (cart != null) {
                        if (cart.getItems() != null) {
            %>
                <table class="table">
                    <thead>
                        <tr>
                            <th>No.</th>  
                            <th>Title</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <form action="MainServlet">
                        <%
                            Map<String, Integer> items = cart.getItems();
                            int count = 0;
                            for (Map.Entry item : items.entrySet()) {
                        %>
                        <tr>
                            <td>
                                <%= ++count%>
                            </td>                                   
                            <td>
                                <%= item.getKey()%>  
                            </td>
                            <td>
                                <%= item.getValue()%>
                            </td>
                            <td>
                                <input type="checkbox" name="chkItem" value="<%= item.getKey()%>"
                            </td>
                        </tr>
                        <%
                            } //end for
                        %>
                        <tr>
                            <td colspan="3">
                            </td>
                            <td>
                                <input type="submit" value="Remove Product" name="btAction" class="button"/>
                            </td>
                        </tr>
                    </form>
                    </tbody>
                </table>
                <!--             
                <%
                                return;
                            } //end items
                        } //end if cart
                    } //end if session
%>
            </div>
        </div>
    </body>
</html>

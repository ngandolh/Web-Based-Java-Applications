<%-- 
    Document   : detail
    Created on : Jan 31, 2023, 4:34:26 PM
    Author     : The Anh
--%>

<%@page import="java.util.ArrayList"%>
<%@page language="java" %>
<%@page import="repo.ProductData"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sweet Drink!</h1>
        <h2>
            
          <h1><%
              Product pro = (Product)request.getAttribute("data");
             out.println(pro.getCode());
             out.println(pro.getName());
             out.println(pro.getQuantity());
             out.println(pro.getPrice());
             

              %> </h1>
        </h2>
    </body>
</html>

<%-- 
    Document   : webpage05
    Created on : Jan 13, 2023, 4:43:18 PM
    Author     : Asus
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%
            Product pro = (Product)request.getAttribute("item");
            out.print("ID:" + pro.getId() + "\n");
            out.print("Name:" + pro.getName() +"\n");
            out.print("Price:" + pro.getPrice() +"\n");
            out.print("Quatity:" + pro.getQuatity());
        %></h1>
    </body>
</html>

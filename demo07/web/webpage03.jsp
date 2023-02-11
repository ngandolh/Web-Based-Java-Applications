<%-- 
    Document   : webpage03
    Created on : Jan 13, 2023, 3:57:09 PM
    Author     : Asus
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%
            List<Double> ds = (ArrayList<Double>)request.getAttribute("item");
            double sum = 0.0;
            for (Double x : ds) {
                    sum = x + sum;
                }
            out.print(sum);
            %></h1>
    </body>
</html>

<%-- 
    Document   : myjsp
    Created on : Jan 10, 2023, 3:35:28 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2 style="color:red;">Thời gian hiện tại:
            <%
                Date currentDate = new Date();
                out.print(currentDate.toString());
            %>
        </h2>
    </body>
</html>

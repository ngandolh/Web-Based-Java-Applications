<%-- 
    Document   : webpage01
    Created on : Jan 13, 2023, 3:23:27 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Data gửi từ Servlet</h2>
        <h1><%= request.getAttribute("item") %></h1>
    </body>
</html>

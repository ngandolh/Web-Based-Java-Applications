<%-- 
    Document   : TestJSP
    Created on : Jan 5, 2023, 12:34:13 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Display Current date & time</h1>
        <% 
            Date date = new Date();
            out.print("<h2>" + date.toString() + "</h2>");
        %>
    </body>
</html>

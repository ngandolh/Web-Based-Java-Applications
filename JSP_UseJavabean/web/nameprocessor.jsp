<%-- 
    Document   : nameprocessor
    Created on : Jan 17, 2023, 9:41:54 PM
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
        <h1>Processing your name</h1>
        <jsp:useBean class="com.example.model.Users" id="user" scope="session"/>
        <jsp:setProperty name="user" property="name" param="name1"/>
        <a href="another.jsp">Another page</a>
    </body>
</html>

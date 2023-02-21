<%-- 
    Document   : another
    Created on : Jan 17, 2023, 9:45:43 PM
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
        <jsp:useBean class="com.example.model.Users" id="user" scope="session"/>
        <h1>Hello, <jsp:getProperty name="user" property="name"/></h1>
    </body>
</html>

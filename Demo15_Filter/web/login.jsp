<%-- 
    Document   : login
    Created on : Mar 7, 2023, 3:41:40 PM
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
        <form action="LoginServlet" method="POST">
            Username: <input type="text" name="user"></br>
            Password: <input type="password" name="pass"></br>
            <input type="submit" value="Login">
        </form>
        </br>
        <a href="index.html">HOME</a>
        <h3>${requestScope.ERROR}</h3>
    </body>
</html>

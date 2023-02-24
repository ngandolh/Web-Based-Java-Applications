<%-- 
    Document   : login
    Created on : Feb 24, 2023, 3:42:34 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="dangnhap" method="POST">
            Account:<input type="text" name="txtAccount"></br>
            Password: <input type="password" name="txtPassword"></br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>

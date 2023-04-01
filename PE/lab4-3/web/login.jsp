<%-- 
    Document   : login
    Created on : Feb 18, 2023, 9:51:37 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            span{
                display: inline-block;
                width: 80px;
                
            }
            input{
                padding: 4px;
                margin-bottom: 8px;
            }
            h4{
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="login" method="POST">
            <span>User: </span><input required type="text" name="username" placeholder="Enter Username..."><br>
            <span>Password: </span><input required type="password" name="password" placeholder="Enter Password..."><br>
            <input type="checkbox" name="remember" value="true">remember me
            <button type="submit">Login</button>
        </form>
        <h4>${err}</h4>
    </body>
</html>

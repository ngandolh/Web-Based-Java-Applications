<%-- 
    Document   : login
    Created on : Mar 7, 2023, 4:15:31 PM
    Author     : The Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            Username: <br>
            <input type="text" name="user" value="" /><br>
            Password: <br>
            <input type="password" name="pass" value="" /><br>
            <input type="submit" value="Login">
            
        </form> 
        <br/>
        <a href="index.html">HOME</a>
    </body>
</html>

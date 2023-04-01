<%-- 
    Document   : login
    Created on : Mar 13, 2023, 11:43:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <input type="text" name="txtUserID" placeholder="Username"/>
            <input type="password" name="txtPassword" placeholder="Password"/>
            <input type="submit" name="btnAction" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
         ${mess}
    </body>
</html>

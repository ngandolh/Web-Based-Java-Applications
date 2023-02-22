<%-- 
    Document   : login
    Created on : Feb 18, 2023, 10:09:37 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h3 style="color:red">${requestScope.ms}</h3>
    <c:set var="cookie" value="${pageContext.request.cookies}"></c:set>
    <form method="POST" action="Login">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="txtUser" value="${cookie.cUserName.value}"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="txtPassword" value="${cookie.cPassword.value}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="checkbox" 
                           ${cookie.cRemember!=null?'checked':''} name="rem" value="ON"/>Remember me</td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit" name="btAction">Login</button></td>
            </tr>

        </table>
    </form>
</body>
</html>

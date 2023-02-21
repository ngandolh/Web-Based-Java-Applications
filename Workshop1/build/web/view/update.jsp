<%-- 
    Document   : update
    Created on : Feb 9, 2023, 9:23:21 AM
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
        <h1>UPDATE Magazine</h1>
        <form action="chinhsua" method="POST">
            Enter ID:<input type="text" name="txtId" id="txtID" value="${requestScope.item.id}" readonly="true"><br/>
            Enter Title Magazine:<input type="text" name="txtTitle" id="txtTitle" value="${requestScope.item.title}"><br/>
            Enter Publisher:<input type="text" name="txtPublisher" id="txtPublisher" value="${requestScope.item.publisher}"><br/>
            Enter Price:<input type="text" name="txtPrice" id="txtPrice" value="${requestScope.item.price}"><br/>
            <input type="submit" value="UPDATE">
        </form>
        <a href="home">Home Page</a>
    </body>
</html>

<%-- 
    Document   : create
    Created on : Feb 9, 2023, 8:40:12 AM
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
        <h1>Add a new Magazine</h1>
        <form action="themmoi" method="POST">
            Enter ID:<input type="text" name="txtId" id="txtID"><br/>
            Enter Title Magazine:<input type="text" name="txtTitle" id="txtTitle"><br/>
            Enter Publisher:<input type="text" name="txtPublisher" id="txtPublisher"><br/>
            Enter Price:<input type="text" name="txtPrice" id="txtPrice"><br/>
            <input type="submit" value="ADD">
        </form>
        <a href="home">Home Page</a>
    </body>
</html>

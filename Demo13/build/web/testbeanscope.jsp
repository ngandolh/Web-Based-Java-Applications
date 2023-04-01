<%-- 
    Document   : testbeanscope
    Created on : Mar 3, 2023, 3:51:51 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Bean Scope</title>
    </head>
    <body>
        <jsp:useBean id="stu01" class="model.Student" scope="page">
           
        </jsp:useBean>
        <p>Student First Name:</p>
        <jsp:getProperty name="stu01" property="firstName"/>
        <p>Student Last Name:</p>
        <jsp:getProperty name="stu01" property="lastName"/>
        <p>Student Age:</p>
        <jsp:getProperty name="stu01" property="age"/>

    </body>
</html>

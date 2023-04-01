<%-- 
    Document   : demobeanjsp
    Created on : Mar 3, 2023, 3:18:37 PM
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
        <jsp:useBean id="stu01" class="model.Student" scope="session">
            <jsp:setProperty name="stu01" property="firstName" value="MR."/>
            <jsp:setProperty name="stu01" property="lastName" value="NAM"/>
            <jsp:setProperty name="stu01" property="age" value="10"/>
        </jsp:useBean>
        <p>Student First Name:</p>
        <jsp:getProperty name="stu01" property="firstName"/>
        <p>Student Last Name:</p>
        <jsp:getProperty name="stu01" property="lastName"/>
        <p>Student Age:</p>
        <jsp:getProperty name="stu01" property="age"/>

        <br/><a href="testbeanscope.jsp">Test bean Scope</a>
        
        <h1>Demo Bean</h1>
        <jsp:useBean id="mydate" class="java.util.Date"/>
        <p>The date/time is <%= mydate%></p>

        <jsp:useBean id="mydate2" class="java.util.Date"/>
        <p> The date/time thể hiện số 2 của Date Object </p>
        <%=mydate2.toString()%>
    </body>
</html>

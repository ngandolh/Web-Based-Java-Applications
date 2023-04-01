<%-- 
    Document   : privatepage
    Created on : Mar 7, 2023, 3:40:46 PM
    Author     : Asus
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRIVATE PAGE</h1>
        <%
            String userName = (String) session.getAttribute("username");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String strDate = simpleDateFormat.format(new Date());
        %>

        <h3><%=userName %>! Your are working on authorized web page.</h3>
        <h3>Today is <%=strDate %></h3>
        <!--../ => auth-->
        <a href="../index.html">HOME</a>
        |
        <a href="../LogoutServlet">Logout</a>
    </body>
</html>

<%-- 
    Document   : privatepage
    Created on : Mar 7, 2023, 3:48:45 PM
    Author     : The Anh
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
        <h1> HERE IS PUBLIC PAGE, EVERYONE CAN SEE IT </h1>
        <%
            String userName = (String) session.getAttribute("username");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String strDate = simpleDateFormat.format(new Date());
            %>
            
            <h3>Hi <%=userName %> ! You are authorized</h3>
            <h3>today is <%=strDate %></h3>
            <a href="../index.html">HOME</a>
            |
            <a href="../LogoutServlet">Logout</a>
    </body>
</html>

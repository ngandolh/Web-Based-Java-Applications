<%-- 
    Document   : myjs
    Created on : Jan 10, 2023, 3:57:43 PM
    Author     : Asus
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <img src="img/fpt.jpg" alt="FPT Logo">
        <link rel="stylesheet" hrf="css/mycss.css">
        <script type=""></script>
    </head>
    <body>
        
        <h1 style="color:red;">
            <% 
                Date currentDate = new Date();
                out.print(currentDate.toString());
            %>
        </h1>
        
        <button onclick="myAlert()">Show Client Time</button>
    </body>
</html>

<%-- 
    Document   : ketqua
    Created on : Feb 24, 2023, 3:58:03 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Result Login:</h1>
        <%
            String name = (String) request.getSession().getAttribute("tennguoidung");
            if (name == null) {
                out.print("Fail login");
            } else {
                out.print("Hello: " + name);
        %>
                </br><a href="dangxuat">OUT</a>
        <%
            }
        %>

    </body>
</html>

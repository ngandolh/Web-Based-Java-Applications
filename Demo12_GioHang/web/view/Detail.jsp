<%-- 
    Document   : Detail
    Created on : Feb 28, 2023, 3:35:30 PM
    Author     : Asus
--%>

<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
//            =request.getAttribute("item")
                Product pro = (Product) request.getAttribute("detailItem");
            %>
        </h1>
        <b>Detail Product:</b><br/>
        <% out.println("Code:" + pro.getId()); %><br/>
        <% out.println("Name:" + pro.getName()); %><br/>
        <% out.println("Price:" + pro.getPrice());%><br/>
        <% out.println("Quatity:" + pro.getQuantity());%><br/>

        <!--        <button href="trangchu" type="submit">Trang Chủ</button>-->
<!--        <a href="trangchu">Trang Chủ</a>-->
    </body>
</html>

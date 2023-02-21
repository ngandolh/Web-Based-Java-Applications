<%-- 
    Document   : detail
    Created on : Feb 9, 2023, 8:59:33 AM
    Author     : Asus
--%>

<%@page import="model.Magazine"%>
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
                Magazine pro = (Magazine) request.getAttribute("detailItem");
            %>
        </h1>
        <b>Detail Product:</b><br/>
        <% out.println("Code:" + pro.getId()); %><br/>
        <% out.println("Name:" + pro.getTitle()); %><br/>
        <% out.println("Price:" + pro.getPublisher());%><br/>
        <% out.println("Quatity:" + pro.getPrice());%><br/>

        <!--        <button href="trangchu" type="submit">Trang Chủ</button>-->
        <a href="home">Home Page</a>
    </body>
</html>

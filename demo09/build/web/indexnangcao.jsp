<%-- 
    Document   : index
    Created on : Jan 31, 2023, 3:29:36 PM
    Author     : The Anh
--%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" %>
<%@page import="repo.ProductData"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>danh sach san pham</title>
    </head>
    <style>
       
      
        th{
            padding: 10px;
        }
        td{
            padding: 10px;
        }
    </style>
    <body>
        <h1> Danh Sach San Pham </h1>
        <table class="tb" border="1">
            <thead>
                <tr>
                    <th>name</th>
                    <th>price</th>
                    <th>chi tiet</th>
                </tr>
            </thead>
      
            <body>
            <%
                ArrayList<Product> list = (ArrayList) request.getAttribute("data");
            %>
            
               <%
                for(Product p : list){
                %>
                <tr>
                    <td> <%= p.getName()%></td>
                    <td> <%= p.getPrice()%></td>
                    <td>
                        <a href="chitiet?maso=<%=p.getCode()%>"> xem </a>
                    </td>   
                </tr>
                <%
                    } list.clear();
                %>
                
        </tbody>
    </table>
    </body>
</html>

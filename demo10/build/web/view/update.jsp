<%-- 
    Document   : update.jsp
    Created on : Feb 7, 2023, 4:42:05 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <h1>Update</h1>
        <form action="chinhsua" method="POST">
            Enter code:<input type="text" name="txtMaSo" id="txtCode" value="${requestScope.item.code}" readonly="true"><br/>
            Enter name:<input type="text" name="txtTen" id="txtName" value="${requestScope.item.name}"><br/>
            Enter quantity:<input type="number" name="txtSoLuong" id="txtQuantity" value="${requestScope.item.quantity}"><br/>
            Enter price:<input type="number" name="txtDonGia" id="txtPrice" value="${requestScope.item.price}"><br/>
            <input type="submit" value="UPDATE">
            <!--            <button type="submit">UPDATE</button>-->
        </form>
        <a href="trangchu">Trang Chủ</a>
    </body>
</html>

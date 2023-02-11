<%-- 
    Document   : create
    Created on : Feb 7, 2023, 1:11:46 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
    </head>
    <body>
        <h1>Add a new Product</h1>
        <form action="themmoi" method="POST">
            Enter code:<input type="text" name="txtMaSo" id="txtCode"><br/>
            Enter name:<input type="text" name="txtTen" id="txtName"><br/>
            Enter quantity:<input type="number" name="txtSoLuong" id="txtQuantity"><br/>
            Enter price:<input type="number" name="txtDonGia" id="txtPrice"><br/>
            <input type="submit" value="SAVE"><br/>
        </form>
        
        <a href="trangchu">Trang Chủ</a>
    </body>
</html>

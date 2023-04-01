<%-- 
    Document   : cal
    Created on : Feb 18, 2023, 10:32:13 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
             span{
                display: inline-block;
                width: 80px;
                
            }
            input{
                padding: 4px;
                margin-bottom: 8px;
            }
            h4{
                color: red;
            }
            button{
                display: inline-block;
                margin: 8px 0px 0px 80px;
            }
        </style>
    </head>
    <body>
        <h1>Calculator</h1>
        <form method="POST" action="cal">
            <span>First:</span><input name="num1" required value="${num1}" placeholder="Enter number 1..."><br>
            <span>Second:</span><input name="num2" required value="${num2}" placeholder="Enter number 2..."><br>
            <span>Operator</span>
            <select name="op">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select><br>
            <button type="submit">Compute</button><br>
            <span>Result</span><input readonly value="${result}">
        </form>
        <h4>${err}</h4>
    </body>
</html>

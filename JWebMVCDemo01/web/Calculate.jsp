<%-- 
    Document   : Calculate
    Created on : Feb 17, 2023, 1:47:15 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CalServlet" method="POST">
            <table>
                <tr>
                    <td>First:</td><td><input type="text" name="txtFirst" value="${aa}"></td>
                </tr>
                <tr>
                    <td>Second:</td><td><input type="text" name="txtSecond" value="${bb}"></td>   
                </tr>
                <tr>
                    <td>Operation:</td>
                    <td><select name="btAction">
                            <option name="btn" value="+" ${add}>+</option>
                            <option name="btn" value="-" ${sub}>-</option>
                            <option name="btn" value="*" ${multi}>*</option>
                            <option name="btn" value="/" ${divv}>/</option>
                        </select><br/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" name="btAction">Compute</button></td>                   
                </tr>
                <tr>
                    <td> Result:</td><td><input type="text" value="<%= request.getAttribute("result")%>"></td>                  
                </tr>

            </table>

        </form>
    </body>
</html>

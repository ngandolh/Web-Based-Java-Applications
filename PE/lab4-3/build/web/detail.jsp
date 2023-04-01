<%-- 
    Document   : detail
    Created on : Feb 19, 2023, 8:33:39 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            boolean passLong=false,passShort=false;
            if(request.getAttribute("passShort")!=null){
                passShort =(Boolean) request.getAttribute("passShort");
            }
            HttpSession ss = request.getSession();
            if(ss.getAttribute("passLong")!=null){
                passLong =(Boolean) ss.getAttribute("passLong");
            }
            if(passLong||passShort){
 
        %>
        <h3>Hello: Administrator</h3>

        <%
            }else{
                response.sendRedirect("login");
                }
        %>
        
    </body>
</html>

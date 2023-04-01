<%-- 
    Document   : student
    Created on : Feb 18, 2023, 10:49:19 AM
    Author     : ACER
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                border-collapse: collapse;
            }
            th,td{
                border: 1px solid #eeee;
                padding: 12px 24px;
            }
            tr:nth-child(odd){
                background-color: #eeee;
            }
            th{
                background-color: green;
                color: white;
            }
            
            tr:hover{
                background-color: #dddd;
            }
            
            
        </style>
    </head>
    <body>
        <form action="student" method="POST">
            Number of Students:<input name="num" required value="${num}" type="number"><button type="submit">generate</button>
        </form>
        <%
        ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
            if(list!=null){
                
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>DOB</th>
            </tr>
        
        <%
            
            for(Student s : list){
                
            
        %>
        
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <%
                if(s.isGender()){
                     
            %>
                <td><input type="checkbox" checked></td>
            <%
                }else{
            %>
                <td><input type="checkbox"></td>
            <%
                }
            %>
            <td><%= sdf.format( s.getDOB()) %></td>
        </tr>
        <%
            }}
        %>
        </table>
        
    </body>
</html>

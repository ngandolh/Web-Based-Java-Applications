<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                    <th>Action</th>

                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Student> list = (ArrayList) request.getAttribute("listItem");
                %>

                <%
                    for (Student p : list) {
                %>

                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getName()%></td>
                    <td><%= p.isGender() ? "Male" : "Female"%></td>
                    <td><%=p.getDate()%></td>

                    <td> 
                        <a href="update?Id=<%=p.getId()%>">Update</a> |
                        <a href="delete?id=<%=p.getId()%>">Delete</a></td>
                </tr>
                <%
                    }
                %>

            </tbody>
        </table>
        <a class="addnew" href="create" style=" text-decoration: none;  ">Create</a> 
    </body>
</html>

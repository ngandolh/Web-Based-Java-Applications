


<%@page import="java.util.List"%>
<%@page import="dto.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link href="./css/search.css" rel="stylesheet"/>

    </head>
    <body>
        <div class="container">
            <div class="header">
                <font color="red">
                <%
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        String username = cookies[cookies.length - 1].getName();
                %>
                Welcome, <%= username%>
                
                <%
                    }
                %>
                </font>
                <h1 class="title">Search Page!</h1>
                <div class="logout">
                    <a href="MainServlet?btAction=logout">Log out</a>
                </div>
            </div>



            <div class="content">
                <form action="MainServlet" class="form">
                    <input type="text" name="txtSearchValue" value="" placeholder="Search By Lastname" class="search"/></br>
                    <input type="submit" value="Search" name="btAction" class="button" />
                </form>



                <%
                    String searchValue = request.getParameter("txtSearchValue");
                    if (searchValue != null) {
                        List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");  //vì getAttribute dc object nên phải ép kiểu về List
                        if (result != null) {
                %>
                <table>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Lastname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 0;
                            for (RegistrationDTO dto : result) {
                                String urlRewriting = "MainServlet?btAction=Delete&pk=" + dto.getUsername() + "&lastSearchValue=" + request.getParameter("txtSearchValue");
                        %>
                    <form action='MainServlet'>
                        <tr>
                            <td><%= ++count%></td>
                            <td><%= dto.getUsername()%><input type='hidden' name='txtUsername' value= "<%= dto.getUsername()%>"/></td>
                            <td><input type="text" name='txtPassword' value= "<%= dto.getPassword()%>" /></td>
                            <td><input type="text" name='txtLastname' value= "<%= dto.getLastname()%>" /></td>
                            <td><input type="checkbox" name='chkrole' value="admin" <% if (dto.isRole()) { %> checked="checked" <% }%> /></td>
                            <td class="deleButton"><a href= <%= urlRewriting%> >Delete</a></td>
                            <td><input type='hidden' name='lastSearchValue' value= "<%= searchValue%>"/><button type='submit' name='btAction' value ='Update'/>Update</button></td>
                        </tr>
                    </form>

                    <%
                        }
                    %>

                    </tbody>

                </table>


                <%
                } else {
                %>
                <h2 style='color:red'>No record is matched.</h2>        

                <%
                        }
                    }
                %>
            </div>

        </div>



    </body>
</html>

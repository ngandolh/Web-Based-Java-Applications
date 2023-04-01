<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Update</title>
    </head>
    <body>
        <h1> Update Product</h1>
        <form action="update" method="POST">
            <table>
                <tr>
                    <td>ID</td><td><input type="text" name="Id" value="${requestScope.item.id}" readonly></td>

                </tr>
                <tr>
                    <td>Name</td><td><input type="text" name="Name" value="${requestScope.item.name}"></td>
                </tr>
                <td>Gender</td>
                    <td>
                    <input type="radio" name="Gender" value="true" ${requestScope.item.gender ==true ? "checked" : ""}>Male
                    <input type="radio" name="Gender" value="false" ${requestScope.item.gender ==false ? "checked" : ""}>Female
                    </td>
                <tr>
                    <td>DOB:</td><td><input type="date" name="DOB" value="${requestScope.item.date}"></td>
                </tr>
            </table>
               
               <div> <button type="submit" > update </button> </div>
        </form>
                
        <a href="list"> Home</a>
    </body>
</html>
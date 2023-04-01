<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h1> Create New Student</h1>

        <form action="create" method="POST">
            <table>
                <tr>
                    <td>Name</td><td><input type="text" name="Name"></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="Gender" value="true" >Male
                        <input type="radio" name="Gender" value="false" >Female
                    </td>
                </tr>

                <tr>
                    <td>DOB:</td><td><input type="date" name="DOB"></td>
                </tr>
            </table>

            <div class="wrap"> <button class="button" type="submit" > Add New Student </button> </div>
        </form>
        <a href="list"> Home</a>
    </body>
</html>
<%@page language="java" %>
<html>
<body>
    <form action="/updateStudent">
        <label for="sid">Enter Student id : </label>
        <input type="text" id="sid" name="sid"></br>
        <label for="name">Enter Student Name : </label>
        <input type="text" id="name" name="name"></br>
        <label for="gender">Enter Student Gender : </label>
        <input type="text" id="gender" name="gender"></br>
        <input type="submit" name="Update">
    </form>
</body>
</html>
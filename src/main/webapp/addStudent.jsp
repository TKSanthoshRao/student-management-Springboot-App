<%@page language="java"%>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" type="text/css" href="addStudent.css">
</head>
<body>
<form action="/addStudent">
        <label for="name">Enter Student name : </label>
    <input type="text" id="name" name="name"></br>
        <label for="marks">Enter Student Marks : </label>
        <input type="text" id="marks" name="marks"></br>
        <label for="gender">Enter Student Gender</label>
        <input type="text" id="gender" name="gender"></br>
        <input type="submit" value="Press here">
</form>

</body>
</html>
<%-- 11d. Develop a JDBC project using JDBC to update the fields empno, empname and basicsalary into
the table Emp of the database Employee by getting the fields through JSP--%>

<html>
<body>

<h2>Update Employee Details</h2>

<form action="update.jsp" method="post">

    Emp No (to update): 
    <input type="text" name="empno"><br><br>

    New Name:
    <input type="text" name="empname"><br><br>

    New Salary:
    <input type="text" name="salary"><br><br>

    <input type="submit" value="Update Employee">

</form>

</body>
</html>
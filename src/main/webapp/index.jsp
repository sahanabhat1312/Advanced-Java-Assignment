<%-- 12d. Develop a JDBC project using MySQL to delete the records in the table Emp of the database Employee by getting the name starting with ‘S’   through keyboard using JSP and Generate the report of the remaining records as follows


Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : 101
Emp_Name: Ramesh'
Basic           : 25000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : 102
Emp_Name: Ravi
Basic           : 20000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
….
…

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--%>

<html>
<body>

<h2>Delete Employees Starting With Character</h2>

<form action="delete.jsp" method="post">

Enter Starting Letter:
<input type="text" name="ch"><br><br>

<input type="submit" value="Delete & Show Report">

</form>

</body>
</html>
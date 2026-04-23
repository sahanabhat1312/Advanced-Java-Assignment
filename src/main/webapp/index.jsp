<%-- 
12c. Develop a JDBC project using MySQL after appending  the fields empno,  empname and basicsalary into the table Emp of the database Employee in Mysql and by getting a character   through keyboard using JSP  and Generate the query report as follows

CREATE TABLE Emp (
  Emp_NO INTEGER PRIMARY KEY,
  Emp_Name TEXT NOT NULL,
  Basicsalary  INTEGER  
);

-- insert
INSERT INTO EMPLOYEE VALUES (101, 'Ramesh', 25000);
INSERT INTO EMPLOYEE VALUES (102, 'Ravi', 20000);
…..
Add 5 records into Emp table of Employee database through Java with JDBC 

and generate a salary report as follows by executing query Emp name starting with R

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
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

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
--%>

<html>
<body>

<h2>Employee Search Report</h2>

<form action="report.jsp" method="post">

Enter Starting Character:
<input type="text" name="ch"><br><br>

<input type="submit" value="Generate Report">

</form>

</body>
</html>
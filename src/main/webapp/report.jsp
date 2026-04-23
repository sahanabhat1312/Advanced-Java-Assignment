<%@ page import="java.sql.*" %>

<%
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/Employee",
    "root",
    "password"
);

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM Emp");
%>

<h2>Employee Report</h2>

<%
while(rs.next()) {
%>

Emp No: <%= rs.getInt("Emp_NO") %><br>
Name: <%= rs.getString("Emp_Name") %><br>
Salary: <%= rs.getInt("Basicsalary") %><br>
<hr>

<%
}
con.close();
%>
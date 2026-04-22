<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Salary Report</title>
</head>

<body>

<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>
<h2>Salary Report</h2>
<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

<%
int total = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee",
        "root",
        "password"
    );

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Emp");

    while(rs.next()) {

        int no = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        total += sal;
%>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : <%= no %>
Emp_Name   : <%= name %>
Basic      : <%= sal %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }
%>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Grand Salary : <%= total %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    rs.close();
    st.close();
    con.close();

} catch(Exception e) {
    out.println("<h3>Error: " + e + "</h3>");
}
%>

</body>
</html>
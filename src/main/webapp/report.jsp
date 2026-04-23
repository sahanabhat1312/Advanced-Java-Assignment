<%@ page import="java.sql.*" %>

<html>
<body>

<%
String ch = request.getParameter("ch");

int total = 0;

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee",
        "root",
        "password"
    );

    String sql = "SELECT * FROM Emp WHERE Emp_Name LIKE ?";
    PreparedStatement ps = con.prepareStatement(sql);

    ps.setString(1, ch + "%");

    ResultSet rs = ps.executeQuery();

%>

<pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    while(rs.next()) {

        int no = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        total += sal;

%>

<pre>
Emp_No     : <%= no %>
Emp_Name   : <%= name %>
Basic      : <%= sal %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }
%>

<pre>
Grand Salary : <%= total %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%

    rs.close();
    ps.close();
    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}

%>

</body>

</html>
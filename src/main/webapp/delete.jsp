<%@ page import="java.sql.*" %>

<html>
<body>

<%
String ch = request.getParameter("ch");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee",
        "root",
        "password"
    );

    // 🔥 STEP 1: DELETE query
    String deleteSQL = "DELETE FROM Emp WHERE Emp_Name LIKE ?";
    PreparedStatement ps = con.prepareStatement(deleteSQL);

    ps.setString(1, ch + "%");

    int deleted = ps.executeUpdate();

%>

<h3>Deleted Records: <%= deleted %></h3>
<hr>

<h2>Salary Report (Remaining Employees)</h2>

<%

    // 🔥 STEP 2: SELECT remaining records
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM emp");

    while(rs.next()) {
%>

<pre>
Emp_No     : <%= rs.getInt("Emp_NO") %>
Emp_Name   : <%= rs.getString("Emp_Name") %>
Basic      : <%= rs.getInt("Basicsalary") %>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
</pre>

<%
    }

    rs.close();
    ps.close();
    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}

%>

</body>
</html>
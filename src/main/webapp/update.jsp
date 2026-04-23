<%@ page import="java.sql.*" %>

<html>
<body>

<%
String empno = request.getParameter("empno");
String empname = request.getParameter("empname");
String salary = request.getParameter("salary");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee",
        "root",
        "password"
    );

    String sql = "UPDATE Emp SET Emp_Name=?, Basicsalary=? WHERE Emp_NO=?";
    PreparedStatement ps = con.prepareStatement(sql);

    ps.setString(1, empname);
    ps.setInt(2, Integer.parseInt(salary));
    ps.setInt(3, Integer.parseInt(empno));

    int i = ps.executeUpdate();

    if(i > 0) {
%>

        <h2 style="color:green;">Employee Updated Successfully!</h2>

<%
    } else {
%>

        <h2 style="color:red;">Employee Not Found!</h2>

<%
    }

    // 🔥 ALWAYS SHOW RESULT BELOW

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Emp");
%>

<h3>Employee Table</h3>
<table border="1">
<tr>
    <th>Emp No</th>
    <th>Name</th>
    <th>Salary</th>
</tr>

<%
    while(rs.next()) {
%>

<tr>
    <td><%= rs.getInt("Emp_NO") %></td>
    <td><%= rs.getString("Emp_Name") %></td>
    <td><%= rs.getInt("Basicsalary") %></td>
</tr>

<%
    }

    rs.close();
    ps.close();
    con.close();

} catch(Exception e) {
%>
    <h3 style="color:red;">Error: <%= e %></h3>
<%
}
%>

</table>

</body>
</html>
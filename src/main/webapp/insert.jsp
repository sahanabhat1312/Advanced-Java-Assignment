<%@ page import="java.sql.*" %>

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

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO Emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)"
    );

    ps.setInt(1, Integer.parseInt(empno));
    ps.setString(2, empname);
    ps.setInt(3, Integer.parseInt(salary));

    ps.executeUpdate();

    out.println("Employee Inserted Successfully!");
    out.println("<br><a href='index.jsp'>Back</a>");

    ps.close();
    con.close();

} catch(Exception e) {
    out.println("Error: " + e);
}
%>
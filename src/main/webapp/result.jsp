<%@ page session="true" %>
<html>
<body>

<%
    String name = request.getParameter("uname");
    String timeStr = request.getParameter("time");

    if (name != null && timeStr != null) {
        int time = Integer.parseInt(timeStr);

        session.setAttribute("username", name);
        session.setMaxInactiveInterval(time);
    }

    String uname = (String) session.getAttribute("username");
%>

<h2>Hello <%= uname %>!</h2>

<br>
<a href="check.jsp">Click here to check session</a>

</body>
</html>
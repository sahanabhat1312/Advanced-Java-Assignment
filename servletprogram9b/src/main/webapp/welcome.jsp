<%@ page session="true" %>
<html>
<body>

<%
    String name = request.getParameter("uname");

    if (name != null) {
        session.setAttribute("username", name);
        session.setMaxInactiveInterval(60); // 1 minute
    }

    String uname = (String) session.getAttribute("username");

    if (uname != null) {
%>
        <h2>Hello <%= uname %>!</h2>
<%
    } else {
%>
        <h2>Session Expired!</h2>
<%
    }
%>

</body>
</html>
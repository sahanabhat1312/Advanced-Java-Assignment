<%@ page session="true" %>
<html>
<body>

<%
    String uname = (String) session.getAttribute("username");

    if (uname != null) {
%>
        <h2>Session Active! Hello <%= uname %></h2>
<%
    } else {
%>
        <h2>Session Expired!</h2>
<%
    }
%>

</body>
</html>
<%@ page import="javax.servlet.http.*" %>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if(cookies != null) {
        for(Cookie c : cookies) {
%>
            <p>
                <b>Name:</b> <%= c.getName() %> <br>
                <b>Value:</b> <%= c.getValue() %> <br>
                <b>Max Age:</b> <%= c.getMaxAge() %> <br><br>
            </p>
<%
        }
    } else {
%>
        <p>No active cookies found.</p>
<%
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>
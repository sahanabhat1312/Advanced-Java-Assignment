<%--9.c Build a Session Management using JSP program for getting  session expiry time and your name through text box and press submit to display the message by greeting Hello your name!.
press the following link to check it within  the set session time  or wait there for the minutes set  to see the session expiry.--%>


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

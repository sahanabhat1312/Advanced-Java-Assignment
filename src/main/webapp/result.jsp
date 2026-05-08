<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Result</title>

<style>
    .result-container {
        width: 350px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ccc;
    }

    .message {
        color: green;
        margin-bottom: 20px;
    }

    .error {
        color: red;
    }
</style>

</head>
<body>

<div class="result-container">

    <h2>Student Result</h2>

    <div class="message">
        <%= request.getAttribute("message") %>
    </div>

    <% if(request.getAttribute("rollno") != null) { %>

        <h3>Submitted Data</h3>

        <p>Roll No :
            <%= request.getAttribute("rollno") %>
        </p>

        <p>Student Name :
            <%= request.getAttribute("studentname") %>
        </p>

        <p>Subject 1 :
            <%= request.getAttribute("sub1") %>
        </p>

        <p>Subject 2 :
            <%= request.getAttribute("sub2") %>
        </p>

        <p>Subject 3 :
            <%= request.getAttribute("sub3") %>
        </p>

        <p>Subject 4 :
            <%= request.getAttribute("sub4") %>
        </p>

        <p>Subject 5 :
            <%= request.getAttribute("sub5") %>
        </p>

        <p><b>Average :</b>
            <%= request.getAttribute("average") %>
        </p>

        <p><b>Result :</b>
            <%= request.getAttribute("result") %>
        </p>

    <% } %>

    <a href="index.jsp">Back to Form</a>

</div>

</body>
</html>
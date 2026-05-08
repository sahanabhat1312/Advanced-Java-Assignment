<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Result Form</title>

<style>
    .form-container {
        width: 350px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ccc;
    }

    .form-field {
        margin: 10px 0;
    }
</style>

</head>
<body>

<div class="form-container">

    <h2>Enter Student Details</h2>

    <form action="processResult" method="POST">

        <div class="form-field">
            <label>Roll No :</label>
            <input type="text" name="rollno" required>
        </div>

        <div class="form-field">
            <label>Student Name :</label>
            <input type="text" name="studentname" required>
        </div>

        <div class="form-field">
            <label>Subject 1 :</label>
            <input type="number" name="sub1" min="0" max="100" required>
        </div>

        <div class="form-field">
            <label>Subject 2 :</label>
            <input type="number" name="sub2" min="0" max="100" required>
        </div>

        <div class="form-field">
            <label>Subject 3 :</label>
            <input type="number" name="sub3" min="0" max="100" required>
        </div>

        <div class="form-field">
            <label>Subject 4 :</label>
            <input type="number" name="sub4" min="0" max="100" required>
        </div>

        <div class="form-field">
            <label>Subject 5 :</label>
            <input type="number" name="sub5" min="0" max="100" required>
        </div>

        <div class="form-field">
            <input type="submit" value="Submit">
        </div>

    </form>

</div>

</body>
</html>
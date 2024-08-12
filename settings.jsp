<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 8/10/24
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudyBuddy Settings</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: "Roboto", sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 2em;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 2em;
        }
        h2 {
            color: #007bff;
            font-weight: 500;
            margin-bottom: 1em;
        }
        .form-group {
            margin-bottom: 1em;
        }
        label {
            display: block;
            color: #333;
            margin-bottom: 0.5em;
        }
        input[type="text"],
        input[type="password"],
        input[type="file"],
        textarea {
            width: calc(100% - 14px);
            padding: 0.8em;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            height: 100px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 1em;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            width: 100%;
            margin-top: 1em;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Account Information</h2>
    <form method="post" action="updateAccountInfo" enctype="multipart/form-data">
        <div class="form-group">
            <label for="profilePicture">Set Profile Picture:</label>
            <input type="file" id="profilePicture" name="profilePicture">
        </div>

        <div class="form-group">
            <label for="bio">Set Bio:</label>
            <textarea id="bio" name="bio" placeholder="Tell us about yourself..."></textarea>
        </div>

        <div class="form-group">
            <label for="password">Set Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="firstName">Set First Name:</label>
            <input type="text" id="firstName" name="firstName" required>
        </div>

        <div class="form-group">
            <label for="lastName">Set Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>
        </div>

        <div class="form-group">
            <label for="gender">Set Gender:</label>
            <input type="text" id="gender" name="gender" required>
        </div>

        <div class="form-group">
            <label for="school">Set School:</label>
            <input type="text" id="school" name="school" required>
        </div>

        <div class="form-group">
            <label for="major">Set Major:</label>
            <input type="text" id="major" name="major" required>
        </div>

        <input type="submit" value="Update Account Information">
    </form>

    <div class="message">
        <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
    </div>
</div>
<div class="container">
    <h2>Course Information</h2>
    <form method="post" action="updateCourseInfo" enctype="multipart/form-data">
        <div class="form-group">
            <label for="course1">Set Course 1:</label>
            <input type="text" id="course1" name="course1">
        </div>

        <div class="form-group">
            <label for="course2">Set Course 2:</label>
            <input type="text" id="course2" name="course2">
        </div>

        <div class="form-group">
            <label for="course3">Set Course 3:</label>
            <input type="text" id="course3" name="course3">
        </div>

        <div class="form-group">
            <label for="course4">Set Course 4:</label>
            <input type="text" id="course4" name="course4">
        </div>

        <input type="submit" value="Update Course Information">
    </form>

    <div class="message1">
        <%= request.getAttribute("message1") != null ? request.getAttribute("message1") : "" %>
    </div>

</div>
</body>
</html>


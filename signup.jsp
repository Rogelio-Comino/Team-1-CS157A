<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudyBuddy Signup</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #007bff; /* Blue background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            position: relative; /* Positioning for the ribbon and image */
            overflow: hidden; /* Prevents scrolling */
        }
        .background-image {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 60%;
            background: url('images/istudent_picture.jpeg') no-repeat center center;
            background-size: cover;
            z-index: 1;
        }
        body::before {
            content: "";
            position: absolute;
            top: 30%;
            left: 0;
            width: 100%;
            height: 150px;
            background: linear-gradient(to bottom, #ffc107 0%, #ffc107 15%, #ffffff 15%, #ffffff 85%, #ffc107 85%, #ffc107 100%);
            z-index: 2;
        }
        .bottom-ribbon {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 30px;
            background: linear-gradient(to right, #ffffff, #ffc107);
            z-index: 2;
        }
        .signup-container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 2em;
            width: 360px;
            text-align: center;
            position: relative;
            z-index: 3;
        }
        .roboto-black-italic {
            font-family: "Roboto", sans-serif;
            font-weight: 900;
            font-style: italic;
            font-size: 3em;
        }
        h1 {
            color: #007bff;
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
        input[type="password"] {
            width: calc(100% - 14px);
            padding: 0.8em;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #0056b3;
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
            background-color: #003d80;
        }
        .already-have-account {
            margin-top: 1em;
            font-size: 15px;
        }
        .already-have-account a {
            color: #ffc107;
            text-decoration: none;
        }
        .already-have-account a:hover {
            text-decoration: underline;
        }
        .message {
            margin-top: 1em;
            font-size: 16px;
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="background-image"></div>
<div class="signup-container">
    <h1 class="roboto-black-italic">StudyBuddy</h1>
    <form method="post" action="signup">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label for="first_name">First Name:</label>
        <input type="text" id="first_name" name="first_name" required>

        <label for="last_name">Last Name:</label>
        <input type="text" id="last_name" name="last_name" required>

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" required>

        <label for="school">School:</label>
        <input type="text" id="school" name="school" required>

        <label for="major">Major:</label>
        <input type="text" id="major" name="major" required>

        <input type="submit" value="Sign Up">
    </form>

    <!-- Display the message, if any -->
    <div class="message">
        <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
    </div>

    <p class="already-have-account">
        Already have an account? <a href="index.jsp">Login here</a>
    </p>
</div>
<div class="bottom-ribbon"></div>
</body>
</html>

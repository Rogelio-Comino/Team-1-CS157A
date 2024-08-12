<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
<%@ page import="com.example.utils.*" %>
<%@ page import="java.sql.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudyBuddy Login</title>
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
            top: 0; /* Start from the top */
            left: 0;
            width: 100%; /* Cover full width */
            height: 60%; /* Cover full height */
            background: url('images/istudent_picture.jpeg') no-repeat center center; /* Ensure image aligns to center */
            background-size: cover; /* Ensure the image covers the area */
            z-index: 1; /* Ensure it stays behind the ribbon but in front of the body background */
        }
        body::before {
            content: "";
            position: absolute;
            top: 30%; /* Adjusts the vertical position of the ribbon to overlap partially with the login window */
            left: 0;
            width: 100%;
            height: 150px; /* Height of the ribbon */
            background: linear-gradient(to bottom, #ffc107 0%, #ffc107 15%, #ffffff 15%, #ffffff 85%, #ffc107 85%, #ffc107 100%);
            z-index: 2; /* Ensures it stays behind the login window but above the image */
        }
        .bottom-ribbon {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 30px; /* Thin ribbon height */
            background: linear-gradient(to right, #ffffff, #ffc107); /* Adjust colors as needed */
            z-index: 2; /* Ensure it stays above the blue background */
        }
        .login-container {
            background-color: #ffffff; /* White background for the form */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 2em;
            width: 300px;
            text-align: center;
            position: relative; /* Keeps it above the ribbon and image */
            z-index: 3;
        }
        .roboto-black-italic {
            font-family: "Roboto", sans-serif;
            font-weight: 900;
            font-style: italic;
            font-size: 3em;
        }
        h1 {
            color: #007bff; /* Blue color for the title */
            margin-bottom: 1em;
        }
        .form-group {
            margin-bottom: 1em;
        }
        label {
            display: block;
            color: #333; /* Dark text color for labels */
            margin-bottom: 0.5em;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 0.8em;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #0056b3; /* Blue button background */
            color: white;
            border: none;
            padding: 1em;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            width: 100%;
            margin-top: 1em; /* Add spacing between fields and button */
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #003d80; /* Darker blue on hover */
        }
        .forgot-password {
            margin-top: 1em;
        }
        .forgot-password a {
            color: #ffc107; /* Yellow color for the link */
            text-decoration: none;
        }
        .forgot-password a:hover {
            text-decoration: underline;
        }
        .forgot-password {
            margin-bottom: 1em; /* Adds space below the "Forgot Password?" link */
        }

        .sign-up a {
            color: #ffc107; /* Yellow color for the link */
            text-decoration: none;
        }

        .sign-up a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>
<div class="background-image"></div> <!-- Image sitting behind the ribbon but in front of the background -->
<div class="login-container">
    <h1 class="roboto-black-italic">StudyBuddy</h1> <!-- Direct HTML for static text -->
    <form action="login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button> <!-- Changed to match CSS -->
    </form>

    <!-- Forgot Password Link -->
    <div class="forgot-password">
        <a href="forgot-password">Forgot Password?</a>
    </div>
    <div class="sign-up">
        <a href="signup.jsp">Create an Account</a>
    </div>
</div>
<div class="bottom-ribbon"></div> <!-- Thin ribbon at the bottom -->
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 8/10/24
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meeting Request Sent</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff; /* Light blue background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            border: 5px solid #ffdd44; /* Yellow border */
        }
        .checkmark {
            color: #4CAF50; /* Green color */
            font-size: 50px;
        }
        .message {
            font-size: 24px;
            color: #00008b; /* Dark blue text */
            margin-top: 10px;
        }
        .button {
            margin-top: 20px;
        }
        .button a {
            text-decoration: none;
            color: #ffffff;
            background-color: #00008b; /* Dark blue background */
            padding: 10px 20px;
            border-radius: 5px;
            border: 2px solid #ffdd44; /* Yellow border */
            font-weight: bold;
            transition: background-color 0.3s, color 0.3s;
        }
        .button a:hover {
            background-color: #ffdd44; /* Yellow background on hover */
            color: #00008b; /* Dark blue text on hover */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="checkmark">&#10004;</div> <!-- Green check mark -->
    <div class="message">Meeting Request Sent!</div>
    <div class="button">
        <a href="profile.jsp">Go to Profile</a>
    </div>
</div>
</body>
</html>


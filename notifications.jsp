<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 8/10/24
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Notifications</title>
  <link rel="stylesheet" href="styles.css">
  <style>
    /* Add styles specific to the notifications page here */
    .notifications-container {
      margin: 50px auto;
      width: 80%;
      max-width: 600px;
      padding: 20px;
      background-color: #f8f9fa;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .notification {
      background-color: #ffffff;
      border: 1px solid #dee2e6;
      padding: 15px;
      margin-bottom: 10px;
      border-radius: 5px;
    }
    .notification h3 {
      margin: 0;
      color: #007bff;
    }
    .notification p {
      margin: 5px 0 0;
      color: #6c757d;
    }
  </style>
</head>
<body>
<div class="notifications-container">
  <h1>Your Notifications</h1>
  <!-- Sample Notifications -->
  <div class="notification">
    <h3>New Study Group Request</h3>
    <p>You have a new study group request for Course 1.</p>
  </div>
  <div class="notification">
    <h3>Meeting Reminder</h3>
    <p>Your study session for Course 2 starts in 1 hour.</p>
  </div>
  <!-- Add more notifications as needed -->
</div>
</body>
</html>

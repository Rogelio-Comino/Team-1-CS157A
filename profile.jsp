<%@ page import="com.example.utils.*" %>
<%@ page import="com.example.demoforwebapp.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.google.gson.Gson" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <!-- Link to Google Fonts for better typography -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <!-- FontAwesome for star icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Reset some default browser styles */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Roboto', sans-serif;
            background-color: #007bff; /* Blue background */
            padding: 20px;
        }

        .profile-container {
            max-width: 1200px; /* Keep the same or adjust if needed */
            margin: 0 auto;
            background-color: #ffffff;
            padding: 40px; /* Increased padding for more space inside */
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            position: relative;
            z-index: 2; /* Ensure it stays above the background */
            min-height: 800px; /* Set a minimum height */
        }

        .top-section {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
            position: relative;
        }

        .profile-image {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            background-color: #e0e0e0;
            background-image: url('images/istudent_picture.jpeg'); /* Replace with actual path or dynamic image source */
            background-size: cover;
            background-position: center;
            margin-right: 20px;
        }

        .user-details {
            flex: 1;
        }

        .user-details h1 {
            font-size: 2em;
            color: #333333;
            margin-bottom: 10px;
        }

        .rating {
            display: flex;
            align-items: center;
            font-size: 1.2em;
            color: #ffc107; /* Yellow color for stars */
            margin-bottom: 10px;
        }

        .stars-outer {
            display: inline-block;
            position: relative;
            font-family: FontAwesome;
        }

        .stars-outer::before {
            content: '\f005 \f005 \f005 \f005 \f005'; /* Five empty stars */
            font-family: FontAwesome;
            color: #e0e0e0; /* Grey color for empty stars */
        }

        .stars-inner {
            position: absolute;
            top: 0;
            left: 0;
            white-space: nowrap;
            overflow: hidden;
            color: #ffc107; /* Yellow color for filled stars */
        }

        .stars-inner::before {
            content: '\f005 \f005 \f005 \f005 \f005'; /* Five filled stars */
            font-family: FontAwesome;
        }

        .rating-text {
            margin-left: 10px;
            color: #333;
        }

        .bio {
            font-size: 1em;
            color: #666666;
            line-height: 1.6;
            margin-bottom: 30px;
        }

        .courses {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center; /* Center the course buttons */
        }

        .course-section h2 {
            font-size: 1.5em;
            color: #333333;
            margin-bottom: 10px;
            text-align: center;
        }

        .course-section {
            flex: 1 1 calc(50% - 20px); /* Two sections per row with spacing */
            background-color: #fafafa;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .result-button {
            display: block;
            width: 100%;
            background-color: #e0e0e0;
            padding: 10px;
            margin-bottom: 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            color: #333;
            transition: background-color 0.3s ease;
        }

        .result-button:hover {
            background-color: #d0d0d0;
        }

        .settings-button,
        .notifications-button,
        .logout-button {
            background-color: #007bff; /* Nice blue color */
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s ease;
            width: 180px; /* Fixed width for uniformity */
            text-align: center;
        }

        .settings-button:hover,
        .notifications-button:hover,
        .logout-button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }


        /* Responsive Design */
        @media (max-width: 768px) {
            .courses {
                flex-direction: column;
                align-items: center; /* Center courses vertically in smaller screens */
            }

            .course-section {
                flex: 1 1 100%;
            }

            .top-section {
                flex-direction: column;
                align-items: flex-start;
            }

            .profile-image {
                margin-bottom: 20px;
            }
        }
    </style>
</head>
<body>
<%
    //HttpSession session = request.getSession();
    String username = (String) session.getAttribute("username");
    Student currStudent = (Student) session.getAttribute("currStudent");
    String fName = (String) session.getAttribute("first_name");

    String userBio = (String) session.getAttribute("userBio");
    Double userRating = (Double) session.getAttribute("userRating");
    int starPercentage = userRating != null ? (int) (userRating / 5 * 100) : 0;

    String course1 = (String) session.getAttribute("course1");
    String course2 = (String) session.getAttribute("course2");
    String course3 = (String) session.getAttribute("course3");
    String course4 = (String) session.getAttribute("course4");
    ArrayList<String> list1 = (ArrayList<String>) session.getAttribute("course1List");
    ArrayList<String> list2 = (ArrayList<String>) session.getAttribute("course2List");
    ArrayList<String> list3 = (ArrayList<String>) session.getAttribute("course3List");
    ArrayList<String> list4 = (ArrayList<String>) session.getAttribute("course4List");

    if (username != null) {
%>
<!-- System Settings Button -->

<div class="profile-container">
    <!-- Add a new div to wrap the buttons -->

        <!-- System Settings Button -->
        <button class="settings-button" onclick="location.href='settings.jsp'">System Settings</button>
        <!-- Notifications Button -->
        <button class="notifications-button" onclick="location.href='notifications.jsp'">Notifications</button>
        <!-- Logout Button -->
        <button class="logout-button" onclick="location.href='LogoutServlet'">Logout</button>

    <div class="top-section">
        <div class="profile-image" style="background-image: url('<%= "images/istudent_picture.jpeg" %>');">
            <!-- Profile image is set via CSS background-image -->
        </div>
    </div>
    <div class="user-details">
        <h1>Welcome, <%= fName != null ? fName : "User" %>!</h1>
        <div class="rating">
            <div class="stars-outer">
                <div class="stars-inner" style="width: <%= starPercentage %>%;"></div>
            </div>
            <span class="rating-text"><%= userRating != null ? userRating : "0/5" %></span>
        </div>
        <div class="bio"><%= userBio != null ? userBio : "No bio available." %></div>
    </div>

    <!-- Updated Courses Section -->
    <div class="courses">
        <!-- Display Course 1 and its associated buttons -->
        <div class="course-section">
            <h2><%= course1 != null ? course1 : "Course 1" %></h2>
            <div class="results-container">
                <%
                    if (list1 != null) {
                        for (String item : list1) {
                %>
                <button class="result-button" onclick="window.location.href='meeting.jsp?course=<%= course1 %>&meeting=<%= item %>'"><%= item %></button>
                <%
                    }
                } else {
                %>
                <p>No participants available for this course.</p>
                <%
                    }
                %>
            </div>
        </div>

        <!-- Display Course 2 and its associated buttons -->
        <div class="course-section">
            <h2><%= course2 != null ? course2 : "Course 2" %></h2>
            <div class="results-container">
                <%
                    if (list2 != null) {
                        for (String item : list2) {
                %>
                <button class="result-button" onclick="window.location.href='meeting.jsp?course=<%= course2 %>&meeting=<%= item %>'"><%= item %></button>
                <%
                    }
                } else {
                %>
                <p>No participants available for this course.</p>
                <%
                    }
                %>
            </div>
        </div>

        <!-- Display Course 3 and its associated buttons -->
        <div class="course-section">
            <h2><%= course3 != null ? course3 : "Course 3" %></h2>
            <div class="results-container">
                <%
                    if (list3 != null) {
                        for (String item : list3) {
                %>
                <button class="result-button" onclick="window.location.href='meeting.jsp?course=<%= course3 %>&meeting=<%= item %>'"><%= item %></button>
                <%
                    }
                } else {
                %>
                <p>No participants available for this course.</p>
                <%
                    }
                %>
            </div>
        </div>

        <!-- Display Course 4 and its associated buttons -->
        <div class="course-section">
            <h2><%= course4 != null ? course4 : "Course 4" %></h2>
            <div class="results-container">
                <%
                    if (list4 != null) {
                        for (String item : list4) {
                %>
                <button class="result-button" onclick="window.location.href='meeting.jsp?course=<%= course4 %>&meeting=<%= item %>'"><%= item %></button>
                <%
                    }
                } else {
                %>
                <p>No participants available for this course.</p>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>

<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>
</body>
</html>

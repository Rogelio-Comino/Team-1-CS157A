package com.example.demoforwebapp;

import com.example.utils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Retrieve the username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Step 2: Set up the database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/StudyBuddy?useSSL=false";
        String dbUser = "root";
        String dbPassword = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 3: Load JDBC driver (optional in modern versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 4: Establish connection
            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // Step 5: Prepare SQL statement with placeholders
            String sql = "SELECT username, password FROM Account WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Step 6: Set the values for the placeholders
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Step 7: Execute the query
            resultSet = preparedStatement.executeQuery();

            // Step 8: Process the results
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            if (resultSet.next()) {

                out.println("<h1>Login successful!</h1>");
                out.println("<p>Welcome, " + username + ".</p>");
                // If login is successful, start a session and store user information
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);

                Student currStudent = DatabaseUtil.getAccountByUsername(username);
                String fName = currStudent.getFirstName(); // ------------> Retrieves first name
                Profile currProfile = currStudent.getCurrProfile();
                String profile_pic = currProfile.getProfilePic();  // ------------> Retrieves profile picture
                String bio = currProfile.getBio();                // ------------> Retrieves bio
                Double avg_rating = currProfile.getRatingScore();  // ------------> Retrieves average rating

                SystemSettings currSys = currProfile.getSettings();
                String course1 = currSys.course.getCourse1();  // ------------> Retrieves course 1 information
                String course2 = currSys.course.getCourse2();  // ------------> Retrieves course 2 information
                String course3 = currSys.course.getCourse3();  // ------------> Retrieves course 3 information
                String course4 = currSys.course.getCourse4();  // ------------> Retrieves course 4 information
                ArrayList<String> course1List = currSys.course.printMeetingListDetailsForCourse1();
                ArrayList<String> course2List = currSys.course.printMeetingListDetailsForCourse2();
                ArrayList<String> course3List = currSys.course.printMeetingListDetailsForCourse3();
                ArrayList<String> course4List = currSys.course.printMeetingListDetailsForCourse4();

                session.setAttribute("currStudent", currStudent);
                session.setAttribute("first_name", fName);      // -------------> Sets first name
                session.setAttribute("userRating", avg_rating);  // -------------> Sets average rating
                session.setAttribute("userBio", bio);             // -------------> Sets bio
                session.setAttribute("profile_pic", profile_pic);  // -------------> Sets profile picture
                session.setAttribute("course1", course1);       // -------------> Sets course 1 info
                session.setAttribute("course2", course2);       // -------------> Sets course 2 info
                session.setAttribute("course3", course3);       // -------------> Sets course 3 info
                session.setAttribute("course4", course4);       // -------------> Sets course 4 info
                session.setAttribute("course1List", course1List);  // -------------> Sets meeting list for course 1
                session.setAttribute("course2List", course2List);  // -------------> Sets meeting list for course 2
                session.setAttribute("course3List", course3List);  // -------------> Sets meeting list for course 3
                session.setAttribute("course4List", course4List);  // -------------> Sets meeting list for course 4

                // Forward the request to the next JSP
                RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
                dispatcher.forward(request, response);

                // Redirect to the profile page
                response.sendRedirect("profile.jsp");

            } else {
                out.println("<h1>Login failed!</h1>");
                out.println("<p>Invalid username or password.</p>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("Login failed", e);
        } finally {
            // Step 9: Clean up resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}

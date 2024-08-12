package com.example.demoforwebapp;

import com.example.utils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/StudyBuddy?useSSL=false";

        String dbUser = "root";
        String dbPassword = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String username = (String) request.getSession().getAttribute("username");

        Student currStudent = DatabaseUtil.getAccountByUsername(username);
        String fname = currStudent.getFirstName();   // ------------> Retrieves first name

        Profile currProfile = currStudent.getCurrProfile();
        String profile_pic = currProfile.getProfilePic();  // ------------> Retrieves profile picture
        String bio = currProfile.getBio();                // ------------> Retrieves bio
        Double avg_rating = currProfile.getRatingScore();  // ------------> Retrieves average rating

        SystemSettings currSys = currProfile.getSettings();
        String course1 = currSys.course.getCourse1();  // ------------> Retrieves course 1 information
        String course2 = currSys.course.getCourse2();  // ------------> Retrieves course 2 information
        String course3 = currSys.course.getCourse3();  // ------------> Retrieves course 3 information
        String course4 = currSys.course.getCourse4();  // ------------> Retrieves course 4 information

        request.setAttribute("first_name", fname);   // ------------->
        request.setAttribute("userRating", avg_rating);
        request.setAttribute("userBio", bio);
        request.setAttribute("profile_pic", profile_pic);
        request.setAttribute("course1", course1);
        request.setAttribute("course2", course2);
        request.setAttribute("course3", course3);
        request.setAttribute("course4", course4);

        // Forward the request to profile.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);

    }
}

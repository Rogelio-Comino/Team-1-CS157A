package com.example.demoforwebapp;

import com.example.utils.*;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/fetchStudentsForCourse1", "/fetchStudentsForCourse2", "/fetchStudentsForCourse3", "/fetchStudentsForCourse4"})
public class FetchCourseListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


        // Get the current student's profile
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            System.out.println("Username is null");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        System.out.println("Username: " + username);

        Student currStudent = DatabaseUtil.getAccountByUsername(username);
        if (currStudent == null) {
            System.out.println("Student object is null");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"error\":\"Student not found\"}");
            return;
        }

        Profile currProfile = currStudent.getCurrProfile();
        if (currProfile == null) {
            System.out.println("Profile object is null");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        SystemSettings sys = currProfile.getSettings();
        if (sys == null) {
            System.out.println("SystemSettings object is null");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ArrayList<String> studentList = null;

        // Determine which URL pattern was requested and call the appropriate method
        String requestUrl = request.getServletPath();
        System.out.println("Request URL: " + requestUrl);

        switch (requestUrl) {
            case "/fetchStudentsForCourse1":
                studentList = sys.course.printMeetingListDetailsForCourse1();
                break;
            case "/fetchStudentsForCourse2":
                studentList = sys.course.printMeetingListDetailsForCourse2();
                break;
            case "/fetchStudentsForCourse3":
                studentList = sys.course.printMeetingListDetailsForCourse3();
                break;
            case "/fetchStudentsForCourse4":
                studentList = sys.course.printMeetingListDetailsForCourse4();
                break;
            default:
                // Handle unexpected cases
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
        }

        // Convert the ArrayList to JSON format
        String json = new Gson().toJson(studentList);

        // Send the JSON response back to the client
        response.getWriter().write(json);
    }
}

package com.example.demoforwebapp;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.example.utils.*;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@WebServlet("/updateCourseInfo")
@MultipartConfig
public class CourseSettingsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Student currStudent = DatabaseUtil.getAccountByUsername(username);
        Profile currProfile = currStudent.getCurrProfile();
        SystemSettings currSys = currProfile.getSettings();

        String course1 = request.getParameter("course1");
        String course2 = request.getParameter("course2");
        String course3 = request.getParameter("course3");
        String course4 = request.getParameter("course4");

        try {
            currSys.course.setCourse1(course1);
            currSys.course.setCourse2(course2);
            currSys.course.setCourse3(course3);
            currSys.course.setCourse4(course4);

            request.setAttribute("message1", "Update Successful! <a href='index.jsp'>Return to Login</a>");

        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            // If there's an error during the creation/insertion, set a failure message
            request.setAttribute("message1", "Update Failed. Please try again. <a href='settings.jsp'>Try Again</a>");
        } finally {
            // Forward the request back to the settings page with a message
            RequestDispatcher dispatcher = request.getRequestDispatcher("settings.jsp");
            dispatcher.forward(request, response);
        }

        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

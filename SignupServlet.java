package com.example.demoforwebapp;

import java.io.IOException;
import com.example.utils.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve user information from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String school = request.getParameter("school");
        String major = request.getParameter("major");

        String date_created = "2024-08-06"; // Example creation date
        HttpSession session = request.getSession();
        session.setAttribute("date_created", date_created);

        try {
            // Create a new Student object, which automatically handles the database insertion
            new Student(username, password, firstName, lastName, gender, date_created, school, major);

            // If creation and insertion are successful, set a success message
            request.setAttribute("message", "Registration Successful! <a href='index.jsp'>Login here</a>");
        } catch (Exception e) {
            // If there's an error during the creation/insertion, set a failure message
            request.setAttribute("message", "Registration Failed. Please try again. <a href='signup.jsp'>Try Again</a>");
        } finally {
            // Forward the request back to the signup page with a message
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

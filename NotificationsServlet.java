package com.example.demoforwebapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/notifications")
public class NotificationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Here you would load notifications from the database or any other source
        // For now, let's just use some mock data

        ArrayList<String> notifications = new ArrayList<>();
        notifications.add("New Study Group Request for Course 1.");
        notifications.add("Reminder: Study session for Course 2 starts in 1 hour.");

        HttpSession session = request.getSession();
        session.setAttribute("notifications", notifications);

        // Forward to the notifications JSP
        request.getRequestDispatcher("notifications.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


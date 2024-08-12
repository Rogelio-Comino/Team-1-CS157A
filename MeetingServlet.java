package com.example.demoforwebapp;

import com.example.utils.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.example.utils.DatabaseUtil;

@WebServlet("/MeetingServlet")

public class MeetingServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Student currStudent = DatabaseUtil.getAccountByUsername(username);

        String course = request.getParameter("course");
        String meeting = request.getParameter("meeting");
        String buttonText = request.getParameter("buttonText");
        String index = request.getParameter("index");

        // Now you can use the 'index' to process the specific item
        int itemIndex = Integer.parseInt(index);
        // Do something with the index, course, and meeting information
    }
}

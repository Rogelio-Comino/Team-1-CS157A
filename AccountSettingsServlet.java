package com.example.demoforwebapp;

import com.example.utils.*;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;


@WebServlet("/updateAccountInfo")
@MultipartConfig
public class AccountSettingsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Student currStudent = DatabaseUtil.getAccountByUsername(username);

        String bio = request.getParameter("bio");
        String uName = request.getParameter("username");
        String pWord = request.getParameter("password");
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String school = request.getParameter("school");
        String major = request.getParameter("major");

        try {
            // Handle file upload
            Part profilePicPart = request.getPart("profilePicture");
            String profile_pic = null;
            if (profilePicPart != null && profilePicPart.getSize() > 0) {
                // Save the file to a location and get the path or URL
                // This is a placeholder for file handling code
                profile_pic = saveFile(profilePicPart);
            }


            currStudent.setPassword(pWord);
            currStudent.setFirstName(fName);
            currStudent.setLastName(lName);
            currStudent.setGender(gender);
            currStudent.setSchool(school);
            currStudent.setMajor(major);

            Profile currProfile = currStudent.getCurrProfile();
            currProfile.setBio(bio);
            if (profile_pic != null) {
                currProfile.setProfilePicture(profile_pic);
            }

            // If creation and insertion are successful, set a success message
            request.setAttribute("message", "Update Successful! <a href='index.jsp'>Return to Login</a>");

        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            // If there's an error during the creation/insertion, set a failure message
            request.setAttribute("message", "Update Failed. Please try again. <a href='settings.jsp'>Try Again</a>");
        } finally {
            // Forward the request back to the settings page with a message
            RequestDispatcher dispatcher = request.getRequestDispatcher("settings.jsp");
            dispatcher.forward(request, response);
        }
    }
    private String saveFile(Part filePart) throws IOException {
        String fileName = getFileName(filePart);

        if (fileName == null || fileName.isEmpty()) {
            throw new IOException("Invalid file name.");
        }

        // Define the path to save the file
        String savePath = getServletContext().getRealPath("/") + "images" + File.separator + fileName;

        // Check file size (e.g., limit to 5MB)
        if (filePart.getSize() > 5 * 1024 * 1024) {
            throw new IOException("File size exceeds the allowed limit.");
        }

        // Check file type (e.g., only allow images)
        String contentType = filePart.getContentType();
        if (!contentType.startsWith("image/")) {
            throw new IOException("Only image files are allowed.");
        }

        // Create the directory if it does not exist
        File saveDir = new File(getServletContext().getRealPath("/") + "images");
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        // Write the file to the directory
        try (InputStream input = filePart.getInputStream();
             FileOutputStream output = new FileOutputStream(savePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        return "images/" + fileName; // Return the path relative to the webapp root
    }

    private String getFileName(Part filePart) {
        // Get the content disposition header from the Part
        String contentDisposition = filePart.getHeader("content-disposition");

        // Extract the file name from the header
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String fileName = s.substring(s.indexOf('=') + 1).trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}

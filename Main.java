package com.example.utils;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scnr = new Scanner(System.in);

        // Test database connection separately






        Student currStudent = DatabaseUtil.getAccountByUsername("alice.jones@example.com");
        Profile currProfile = currStudent.getCurrProfile();

        Student newStudent = DatabaseUtil.getAccountByUsername("diana.miller@example.com");
        Profile newProfile = newStudent.getCurrProfile();

        //currProfile.sendMeetingRequest(newProfile);

        newProfile.checkNotifications();


        /*
        Profile currProfile = currStudent.getCurrProfile();
        System.out.println("Rating: ");
        System.out.println(currProfile.getRatingScore());
        SystemSettings sys = currProfile.getSettings();

        ArrayList<String> list = sys.course.printMeetingListDetailsForCourse1();
        for (String item : list) {
            System.out.println(item);
        }

         */










        /*
        //Logging in
        Student newStudent = Student.userAccountAuthentication("grace.taylor@example.com", "password567");

        Profile newProfile = newStudent.getCurrProfile(); // Retrieves Profile
        //SystemSettings sys = newProfile.getSettings(); // Retrieves SystemSettings
        //sys.course.printMeetingListDetailsForCourse1();

        //Logging in
        Student otherStudent = Student.userAccountAuthentication("jane.smith@example.com", "password456");
        Profile otherProfile = otherStudent.getCurrProfile(); // Retrieves Profile

        //newProfile.sendMeetingRequest(otherProfile);  // Sends meeting request
        otherProfile.checkNotifications();

         */

    }
}
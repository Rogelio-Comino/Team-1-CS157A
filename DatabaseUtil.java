package com.example.utils;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/StudyBuddy?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    // Test database connection separately
    public static void checkConnection() throws SQLException {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        if (con != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Database connection failed!");
        }
    }

    public DatabaseUtil() throws SQLException {
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static String executeStringQuery(String query, String nameOfColumn) {  // Retrieves String data from database
        String result = "abc";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next())
                result = rs.getString(nameOfColumn);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public static int executeIntQuery(String query, String nameOfColumn) { // Retrieves integer data from database
        int result = 0;
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next())
                result = rs.getInt(nameOfColumn);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public static Blob executeBlobQuery(String query, String nameOfColumn) {  // Retrieves String data from database
        Blob result = null;
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next())
                result = rs.getBlob(nameOfColumn);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public static Double executeDoubleQuery(String query, String nameOfColumn) {  // Retrieves String data from database
        Double result = null;
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next())
                result = rs.getDouble(nameOfColumn);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static void insertData(String tableName, String columnName, String data) { // Creates a new tuple and inserts String data
        String query = "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, data);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful!");
            } else {
                System.out.println("Insert failed.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void insertIntData(String tableName, String columnName, int data) { // Creates a new tuple and inserts integer data
        String query = "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, data);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful!");
            } else {
                System.out.println("Insert failed.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void deleteData(String tableName, String columnName, String data) { // Deletes specific tuple from a table
        String query = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, data);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Delete successful!");
            } else {
                System.out.println("Delete failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateStringAccountDetails(String username, String columnName, String newValue) {
        String query = "UPDATE Account SET " + columnName + " = ? WHERE username = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, newValue);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateIntAccountDetails(String username, String columnName, int newValue) {
        String query = "UPDATE Account SET " + columnName + " = ? WHERE username = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, newValue);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateStringStudentDetails(String username, String columnName, String newValue) {
        String query = "UPDATE Student SET " + columnName + " = ? WHERE username = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, newValue);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateIntStudentDetails(String username, String columnName, int newValue) {
        String query = "UPDATE Student SET " + columnName + " = ? WHERE username = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, newValue);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateIntProfileDetails(int profile_ID, String columnName, int newValue) {
        String query = "UPDATE Profile SET " + columnName + " = ? WHERE profile_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, newValue);
            pstmt.setInt(2, profile_ID);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateStringProfileDetails(int profile_ID, String columnName, String newValue) {
        String query = "UPDATE Profile SET " + columnName + " = ? WHERE profile_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, newValue);
            pstmt.setInt(2, profile_ID);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateStringProfileDetails(int profile_ID, String columnName, Blob newValue) {
        String query = "UPDATE Profile SET " + columnName + " = ? WHERE profile_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setBlob(1, newValue);
            pstmt.setInt(2, profile_ID);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateIntMeetingDetails(int meeting_ID, String columnName, int newValue) {
        String query = "UPDATE Meeting SET " + columnName + " = ? WHERE meeting_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, newValue);
            pstmt.setInt(2, meeting_ID);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateIntSystemSettingsDetails(int ss_ID, String columnName, int newValue) {
        String query = "UPDATE SystemSettings SET " + columnName + " = ? WHERE ss_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, newValue);
            pstmt.setInt(2, ss_ID);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static boolean executeUserAuthenticationQuery(String query) {  // Retrieves String data from database

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static Student getAccountByUsername(String username) {
        String sql = "SELECT * FROM Account NATURAL JOIN Student WHERE username = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gender = rs.getString("gender");
                String password = rs.getString("password");
                String dateCreated = rs.getString("date_created");
                String major = rs.getString("major");
                String school = rs.getString("school");
                int profile_ID = rs.getInt("profile_ID");

                return new Student(username, profile_ID);
            }
            else {
                System.out.println("User cannot be found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updateStringCourseDetails(int course_ID, String columnName, String newValue) {
        String query = "UPDATE Course SET " + columnName + " = ? WHERE course_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, newValue);
            pstmt.setInt(2, course_ID);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful for column: " + columnName);
            } else {
                System.out.println("Update failed. No rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //----------------------------------- POTENTIAL METHODS -------------------------------------------//

    /**
     * Retrieves the course ID associated with a given profile ID.
     *
     * @param profileID The ID of the profile whose associated course ID is to be retrieved.
     * @return The course ID if found; otherwise, -1.
     */

    public static int getCourseID(int profileID) {
        int courseID = -1; // default value if no course_ID is found
        String query = "SELECT SystemSettings.course_ID " +
                "FROM Profile " +
                "INNER JOIN SystemSettings ON Profile.ss_ID = SystemSettings.ss_ID " +
                "WHERE Profile.profile_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, profileID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                courseID = rs.getInt("course_ID");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return courseID;
    }

    /**
     * Retrieves the list of courses associated with a given course ID.
     *
     * @param courseID The ID of the course whose associated courses are to be retrieved.
     * @return An ArrayList containing the course names.
     */
    public static ArrayList<String> getUserCourses(int courseID) {
        ArrayList<String> usersCourses = new ArrayList<>();
        String query = "SELECT course1, course2, course3, course4 FROM Course WHERE course_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, courseID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usersCourses.add(rs.getString("course1"));
                usersCourses.add(rs.getString("course2"));
                usersCourses.add(rs.getString("course3"));
                usersCourses.add(rs.getString("course4"));
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return usersCourses;
    }

    /**
     * Retrieves a list of profile IDs for students enrolled in a given course.  // SEQUENCE POSITION: #2
     *
     * @param course The name of the course to search for.
     * @return An ArrayList containing the profile IDs of students enrolled in the course.
     */
    public static ArrayList<Integer> getProfileIDsByCourse(String course) {
        ArrayList<Integer> listOfProfileIDs = new ArrayList<>();
        String query = "SELECT s.profile_ID " +
                "FROM Student s " +
                "INNER JOIN Profile p ON s.profile_ID = p.profile_ID " +
                "INNER JOIN SystemSettings ss ON p.ss_ID = ss.ss_ID " +
                "INNER JOIN Course c ON ss.course_ID = c.course_ID " +
                "WHERE c.course1 = ? OR c.course2 = ? OR c.course3 = ? OR c.course4 = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, course);
            pstmt.setString(2, course);
            pstmt.setString(3, course);
            pstmt.setString(4, course);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                listOfProfileIDs.add(rs.getInt("profile_ID"));
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return listOfProfileIDs;
    }

}

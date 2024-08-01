import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost: 3306/StudyBuddyDB?autol";
    private static final String USER = "root";
    private static final String PASSWORD = "ThereisoneAllah1!";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static String executeStringQuery(String query, String nameOfColumn){
        String result = "abc";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){

            if (rs.next())
                result = rs.getString(nameOfColumn);
        }
        catch (SQLException e) {
            System.out.println("SQL exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static int executeIntQuery(String query, String nameOfColumn){
        int result = 0;
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)){

            if (rs.next())
                result = rs.getInt(nameOfColumn);
        }
        catch (SQLException e) {
            System.out.println("SQL exception: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static void insertData(String tableName, String columnName, String data) {
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

    //New insert int data
    public static void insertIntData(String tableName, String columnName, int data) {
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

    // New deleteData method
    public static void deleteData(String tableName, String columnName, String data) {
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


    public static void updateAccountDetails(String username, String columnName, String newValue) {
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

    public static Account getAccountByUsername(String username) {
        String sql = "SELECT * FROM Account WHERE username = ?";

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

                return new Account(username, firstName, lastName, gender, password, dateCreated);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
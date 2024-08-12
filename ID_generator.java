package com.example.utils;
import java.util.Random;
public class ID_generator {
    /**
     * Generates a unique ID for a specified table and column.
     *
     * This method generates a random 6-digit integer and checks if it already exists in the specified column
     * of the specified table. If the generated ID already exists, the method recurses to generate a new ID.
     *
     * @param table The name of the table where the ID will be used.
     * @param columnName The name of the column where the ID will be used.
     * @return A unique ID for the specified table and column.
     */
    public static int generateID(String table, String columnName) {
        Random random = new Random();
        int ID = random.nextInt(999999);
        boolean result = check4IDinDatabase(ID, table, columnName);
        if (result == true) {
            generateID(table, columnName);
        }
        return ID;
    }

    /**
     * Checks if a given ID already exists in a specified table and column.
     *
     * This method constructs and executes a SQL query to check if the given ID exists in the specified
     * column of the specified table. It returns true if the ID exists, and false otherwise.
     *
     * @param id The ID to check for existence in the database.
     * @param table The name of the table where the ID will be checked.
     * @param columnName The name of the column where the ID will be checked.
     * @return true if the ID exists in the specified table and column, false otherwise.
     */

    public static boolean check4IDinDatabase(int id, String table, String columnName) {
        String query = "SELECT `" + columnName + "` FROM `" + table + "` WHERE `" + columnName + "` = " + id;
        int result = DatabaseUtil.executeIntQuery(query, columnName);
        if (result == id) {
            return true;
        }
        else
            return false;
    }

}

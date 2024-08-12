package com.example.utils;

public class Account {

    protected String username;
    protected String password;
    protected String first_name;
    protected String last_name;
    protected String gender;
    protected String date_created;
    public Account() {

    }
    public Account(String username, String password, String first_name, String last_name, String gender, String date_created) {
        this.username = setUsername(username);
        this.password = setPassword(password);
        this.first_name = setFirstName(first_name);
        this.last_name = setLastName(last_name);
        this.gender = setGender(gender);
        this.date_created = setDateCreated(date_created);
    }

    //----------------------------------- SETTER METHODS -------------------------------------------//

    public final String setUsername(String username) {
        DatabaseUtil.insertData("Account", "username", username);
        return username;
    }
    public String setPassword(String password) {
        DatabaseUtil.updateStringAccountDetails(this.username, "password", password);
        return password;
    }
    public String setFirstName(String first_name) {
        DatabaseUtil.updateStringAccountDetails(this.username, "first_name", first_name);
        return first_name;
    }
    public String setLastName(String last_name) {
        DatabaseUtil.updateStringAccountDetails(this.username, "last_name", last_name);
        return last_name;
    }
    public String setGender(String gender) {
        DatabaseUtil.updateStringAccountDetails(this.username, "gender", gender);
        return gender;
    }
    public String setDateCreated(String date_created) {
        DatabaseUtil.updateStringAccountDetails(this.username, "date_created", date_created);
        return date_created;
    }

    //----------------------------------- GETTER METHODS -------------------------------------------//

    public String getUsername() {
        String query = "SELECT username FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "username");
        return result;
    }
    public String getPassword() {
        String query = "SELECT password FROM Account WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "password");
        return result;
    }
    public String getFirstName() {
        String query = "SELECT first_name FROM Account WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "first_name");
        return result;
    }
    public String getLastName() {
        String query = "SELECT last_name FROM Account WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "last_name");
        return result;
    }
    public String getGender() {
        String query = "SELECT gender FROM Account WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "gender");
        return result;
    }
    public String getDateCreated() {
        String query = "SELECT date_created FROM Account WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "date_created");
        return result;
    }

    //----------------------------------- ADDITIONAL METHODS -------------------------------------------//

    /**
     * Authenticates a user's account using the provided username and password.
     *
     * This method constructs a SQL query to verify the username and password against the database.
     * If the authentication is successful, it retrieves and returns the corresponding Account object.
     * If the authentication fails, it returns a new Account object and prints an error message.
     *
     * @param username The username of the account to be authenticated.
     * @param password The password of the account to be authenticated.
     * @return The authenticated Account object if credentials are correct; otherwise, a new Account object.
     *
     */
    public static Account userAccountAuthentication(String username, String password) {
        String query = "SELECT Account.username FROM Account WHERE username = '" + username + "' " +
                                    "AND password = '" + password + "'";
        boolean result = DatabaseUtil.executeUserAuthenticationQuery(query);
        if (result == true) {
            System.out.println("Welcome!");
            Account currAccount = DatabaseUtil.getAccountByUsername(username);
            return currAccount;
        }
        else
            System.out.println("Sorry! Username or password does not match our records");
        return new Account();
    }

}

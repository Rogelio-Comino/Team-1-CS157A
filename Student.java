package com.example.utils;
public class Student extends Account {
    private String school;
    private String major;
    private int profile_id;
    protected Profile currProfile;
    public Student() {

    }

    // This constructor is used for students who already have an account in the database.
    // It initializes the Student object with the provided username and profile_ID.
    // This is typically used during the login process.
    // It also creates a Profile object associated with this student, using the provided username and profile_ID.
    // This constructor is used by the getAccountByUsername() function in DatabaseUtil.java class
    public Student (String username, int profile_ID) {
        this.username = username;
        this.profile_id = profile_ID;
        currProfile = new Profile(this.username, this.profile_id);
    }

    // This constructor is used for creating a new student account.
    // It initializes the Student object with the provided details, including username, password, first name, last name, gender, date created, school, and major.
    // It calls the superclass constructor to set the common account details.
    // It sets the student-specific attributes: username, school, and major.
    // It generates a new profile_ID for the student.
    // It creates a new Profile object associated with this student, using the newly generated profile_ID.
    public Student(String username, String password, String first_name, String last_name, String gender, String date_created, String school, String major) {
        super(username, password, first_name, last_name, gender, date_created);
        setStudentUsername(username);
        this.school = setSchool(school);
        this.major = setMajor(major);
        this.profile_id = setProfileID();
        currProfile = new Profile(this.profile_id);
    }

    //----------------------------------- SETTER METHODS -------------------------------------------//

    public void setStudentUsername(String username) {
        DatabaseUtil.insertData("Student", "username", username);
    }
    public String setSchool(String school) {
        DatabaseUtil.updateStringStudentDetails(this.username, "school", school);
        return school;
    }
    public String setMajor(String major) {
        DatabaseUtil.updateStringStudentDetails(this.username, "major", major);
        return major;
    }
    public int setProfileID() {
        int p_id = ID_generator.generateID("Student", "profile_ID");
        String res = Integer.toString(p_id);
        while (res.length() != 6) {
            p_id = ID_generator.generateID("Student", "profile_ID");
            res = Integer.toString(p_id);
        }
        int officialNum = Integer.parseInt(res);
        DatabaseUtil.updateIntStudentDetails(this.username, "profile_ID", officialNum);
        return officialNum;
    }

    //----------------------------------- GETTER METHODS -------------------------------------------//
    public String getSchool() {
        String query = "SELECT school FROM Student WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "school");
        return result;
    }
    public String getMajor() {
        String query = "SELECT major FROM Student WHERE username = '" + this.username + "'";
        String result = DatabaseUtil.executeStringQuery(query, "major");
        return result;
    }
    public int getProfile_ID() {
        String query = "SELECT profile_ID FROM Student WHERE username = '" + this.username + "'";
        int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
        return result;
    }
    public Profile getCurrProfile() {
        return this.currProfile;
    }

    //----------------------------------- USER AUTHENTICATION METHOD -------------------------------------------//

    /**
     * This function authenticates a user by checking the provided username and password against the database.
     * It constructs a SQL query to select the username from the Account table where the username and password match the provided values.
     * It executes the query and returns a boolean result indicating whether the user is authenticated.
     *
     * @param username the username provided by the user for authentication
     * @param password the password provided by the user for authentication
     * @return a Student object representing the authenticated user if the authentication is successful, otherwise returns a new empty Student object
     */
    public static Student userAccountAuthentication(String username, String password) {
        String query = "SELECT Account.username FROM Account WHERE username = '" + username + "' " +
                "AND password = '" + password + "'";
        boolean result = DatabaseUtil.executeUserAuthenticationQuery(query);
        if (result == true) {
            System.out.println("Welcome!");
            Student currAccount = DatabaseUtil.getAccountByUsername(username);
            return currAccount;
        }
        else
            System.out.println("Sorry! Username or password does not match our records");
        return new Student();
    }
}

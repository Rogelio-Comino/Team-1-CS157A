public class Student extends Account {
    private String school;
    private String major;
    private Profile profile;

    public Student(){

    }

    // Constructor
    public Student(String username, String password, String first_name, String last_name, String gender, String date_created, String school, String major) {
        super(username, password, first_name, last_name, gender, date_created);
        this.school = school;
        this.major = major;
        this.profile = new Profile(username, password, first_name, last_name, gender, date_created, school, major);
    }

    //Setter Methods
    public void setSchool(String school){
        DatabaseUtil.updateAccountDetails(this.username, "school", school);
    }
    public void setMajor(String major){
        DatabaseUtil.updateAccountDetails(this.username, "major", major);
    }

    // Getters Method
    public String getSchool() {
        String query = "SELECT school FROM Student WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "school");
        return result;
    }

    public String getMajor() {
        String query = "SELECT major FROM Student WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "major");
        return result;
    }

    public int getProfile() {
        String query = "SELECT profile_ID FROM Student WHERE username = '" + this.username + "'    ";
        int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
        return result;
    }
}
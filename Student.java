public class Student extends Account {
    private String school;
    private String major;
    private Profile profile;

    // Constructor
    public Student(String username, String password, String first_name, String last_name, String gender, String date_created, String school, String major) {
        super(username, password, first_name, last_name, gender, date_created);
        this.school = school;
        this.major = major;
        this.profile = new Profile(username, password, first_name, last_name, gender, date_created, school, major);
    }

    //Setter Methods
    public void setSchool(String school){
        this.school = school;
    }
    public void setMajor(String major){
        this.major = major;
    }

    // Getters Method
    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public Profile getProfile() {
        return profile;
    }
}
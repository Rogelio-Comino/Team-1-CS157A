public class Student extends Account {
    private String school;
    private String major;
    private Profile profile;
    public Student() {

    }
    public Student(String username, String password, String first_name, String last_name, String date_created, String gender, String school, String major) {
        super(username, password, first_name, last_name, date_created, gender);
        this.school = school;
        this.major = major;
        this.profile = new Profile(username, password, first_name, last_name, date_created, gender, school, major);
    }

    // Setter methods
    public void setSchool(String school) {
        this.school = school;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    // Getter methods
    public String getSchool() {
        return this.school;
    }
    public String getMajor() {
        return this.major;
    }
    public Profile getProfile() {
        return this.profile;
    }
}

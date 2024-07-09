public class Account extends Courses {
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected String username;
    protected String password;
    protected String school;
    protected String major;
    protected Courses courses;

    public Account() {

    }
    public Account(String firstName, String lastName, String gender, String username, String password, String school, String major, Courses course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.school = school;
        this.major = major;
        this.courses = course;
    }
    //////////////// Setter Methods /////////////////
    public void setFirstName(String fName) {
        this.firstName = fName;
    }
    public void setLastNameName(String lName) {
        this.lastName = lName;
    }
    public void setGender(String gendr) {
        this.gender = gendr;
    }
    public void setUsername(String uname) {
        this.username = uname;
    }
    public void setPassword(String pword) {
        this.password = pword;
    }
    public void setSchool(String schoolName) {
        this.school = schoolName;
    }
    public void setMajor(String major1) {
        this.major = major1;
    }
    //////////////// Getter Methods /////////////////
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastNameName() {
        return this.lastName;
    }
    public String getGender() {
        return this.gender;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getSchool() {
        return this.school;
    }
    public String getMajor() {
        return this.major;
    }
    public void getCourselist() {
        int count = 1;
        for (String item : this.courses.courseList) {
            System.out.println(count + ") " + item);
            count++;
        }
    }
}

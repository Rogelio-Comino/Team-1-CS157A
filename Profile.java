public class Profile extends Rating {
    private int profile_ID;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String date_created;
    private String gender;
    private String school;
    private String major;
    private String bio;
    private String profile_pic;
    private Rating rating;
    private SystemSettings systemSettings;
    public Profile() {

    }
    public Profile(String username, String password, String first_name, String last_name, String date_created, String gender, String school, String major) {
        this.profile_ID = ID_generator.generateID();
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_created = date_created;
        this.gender = gender;
        this.school = school;
        this.major = major;
        this.bio = "";
        this.profile_pic = "";
        this.rating = new Rating();
        int ss_id = ID_generator.generateID();
        this.systemSettings = new SystemSettings(ss_id);

    }

    // Setter methods
    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    // Getter methods
    public int getProfile_ID(){
        return profile_ID;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getDateCreated() {
        return date_created;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public String getBio() {
        return bio;
    }

    public String getProfilePic() {
        return profile_pic;
    }
}

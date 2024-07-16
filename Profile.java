public class Profile {
    private int profile_ID;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String gender;
    private String date_created;
    private String school;
    private String major;
    private String bio;
    private String profile_pic;
    private Rating rating;

    public Profile(){
    }
    // Constructor
    public Profile(String username, String password, String first_name, String last_name, String gender, String date_created, String school, String major) {
        this.profile_ID = ID_generator.generateID();
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.date_created = date_created;
        this.school = school;
        this.major = major;
        this.bio = ""; // default bio
        this.profile_pic = ""; // default profile pic
        this.rating = new Rating();
    }


    //Setter Methods
    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePic(String profile_pic) {
        this.profile_pic = profile_pic;
    }


    // Getter Methods

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
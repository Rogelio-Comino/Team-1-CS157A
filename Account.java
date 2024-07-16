public class Account {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String gender;
    private String date_created;

    public Account(){

    }

    // Constructor
    public Account(String username, String password, String first_name, String last_name, String gender, String date_created) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.date_created = date_created;
    }


    // Setter Methods
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public void setDateCreated(String date_created) {
        this.date_created = date_created;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter Methods
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

}
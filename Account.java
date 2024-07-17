public class Account {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String date_created;
    private String gender;

    public Account() {

    }

    public Account(String username, String password, String first_name, String last_name, String date_created, String gender) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_created = date_created;
        this.gender = gender;
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
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getFirstName() {
        return this.first_name;
    }
    public String getLastName() {
        return this.last_name;
    }
    public String getDateCreated() {
        return this.date_created;
    }
    public String getGender() {
        return this.gender;
    }
}

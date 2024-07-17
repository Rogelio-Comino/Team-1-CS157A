public class Admin extends Account{
    private String admin_role;

    public Admin() {

    }
    public Admin(String username, String password, String first_name, String last_name, String date_created, String gender, String admin_role) {
        super (username, password, first_name, last_name, date_created, gender);
        this.admin_role = admin_role;
    }

    // Setter Methods
    public void setAdminRole(String admin_role) {
        this.admin_role = admin_role;
    }
    // Getter Methods
    public String getAdminRole() {
        return this.admin_role;
    }
}

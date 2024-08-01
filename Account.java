import java.util.Scanner;

public class Account {
    protected String username;
    protected String password;
    protected String first_name;
    protected String last_name;
    protected String gender;
    protected String date_created;

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
        DatabaseUtil.insertData("Account", "username", username);
        this.username = username;
    }
    public void setPassword(String password) {
        DatabaseUtil.updateAccountDetails(this.username, "password", password);
    }
    public void setFirstName(String first_name) {
        DatabaseUtil.updateAccountDetails(this.username, "first_name", first_name);
    }
    public void setLastName(String last_name) {
        DatabaseUtil.updateAccountDetails(this.username, "last_name", last_name);
    }
    public void setDateCreated(String date_created) {
        DatabaseUtil.updateAccountDetails(this.username, "date_created", date_created);
    }
    public void setGender(String gender) {
        DatabaseUtil.updateAccountDetails(this.username, "gender", gender);
    }

    // Getter Methods
    public String getUsername() {
        String query = "SELECT username FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "username");
        return result;
    }

    public String getPassword() {
        String query = "SELECT password FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "password");
        return result;
    }

    public String getFirstName() {
        String query = "SELECT first_name FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "first_name");
        return result;
    }

    public String getLastName() {
        String query = "SELECT last_name FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "last_name");
        return result;
    }

    public String getGender() {
        String query = "SELECT gender FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "gender");
        return result;
    }

    public String getDateCreated() {
        String query = "SELECT date_created FROM Account WHERE username = '" + this.username + "'    ";
        String result = DatabaseUtil.executeStringQuery(query, "date_created");
        return result;
    }

    // New deleteAccount method
    public static void deleteAccount(String username) {
        DatabaseUtil.deleteData("Account", "username", username);
    }


    public static void createStudentAccount(String first_name, String last_name, String gender, String username, String password){
        Scanner scnr = new Scanner(System.in);
        Account account = new Account();

        System.out.print("First name: ");
        first_name = scnr.nextLine();
        account.setFirstName(first_name);

        System.out.print("Last name: ");
        last_name = scnr.nextLine();
        account.setLastName(last_name);

        System.out.print("Gender: ");
        gender = scnr.nextLine();
        account.setGender(gender);

        System.out.print("Email: ");
        username = scnr.nextLine();
        account.setUsername(username);

        System.out.print("Password: ");
        password = scnr.nextLine();
        account.setPassword(password);

        System.out.println("Account created successfully!");

    }
    public static boolean userAuthentication(String username, String password) {
        boolean result = false;

        Account uname = DatabaseUtil.getAccountByUsername(username);

        if (uname != null && uname.getUsername().equals(username) && uname.getPassword().equals(password)) {
            return true;
        }

        return result;
    }
}

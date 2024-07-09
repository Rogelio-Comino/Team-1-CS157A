import java.util.Scanner;

abstract class Account {

    protected String first_name;
    protected String last_name;
    protected String email;
    protected String password;
    protected String gender;
    protected int age;
    protected String school;
    protected String major;

    //DEFAULT CONSTRUCTOR//
    public Account(){
    }

    //CONSTRUCTOR//
    public Account(String first_name, String last_name, String email, String password, String gender, int age, String school, String major) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.school = school;
        this.major = major;
    }

    //SETTER METHODS//
    public void setFirstName(String value){
        this.first_name = value;
    }
    public void setLastName (String value){
        this.last_name = value;
    }
    public void setEmail (String value){
        this.email = value;
    }
    public void setPassword (String value){
        this.password = value;
    }
    public void setGender (String value){
        this.gender = value;
    }
    public void setAge (int value){
        this.age = value;
    }
    public void setSchool(String value){
        this.school = value;
    }
    public void setMajor(String value){
       this. major = value;
    }

    //GETTER METHODS//
    public String getFirstName(){
        return first_name;
    }
    public String LastName(){
        return last_name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public String getSchool(){
        return school;
    }
    public String getMajor(){
        return major;
    }

    public void createAccount(){
        Scanner scnr = new Scanner(System.in);
        AccountDataBase accountDB = new AccountDataBase();

        System.out.println("Welcome to StudyBuddy!");
        System.out.println("Create a Free Account");

        System.out.println("Please Enter");
        System.out.println("");

        System.out.print("First Name: ");
        String firstNameInput = scnr.nextLine();
        setFirstName(firstNameInput);


        System.out.print("Last Name: ");
        String lastNameInput = scnr.nextLine();
        setLastName(lastNameInput);

        System.out.print("Email: ");
        String emailInput = scnr.nextLine();
        setEmail(emailInput);

        System.out.print("Password: ");
        String passwordInput = scnr.nextLine();
        setPassword(passwordInput);

        System.out.print("Gender: ");
        String genderInput = scnr.nextLine();
        setGender(genderInput);

        System.out.print("Age: ");
        int ageInput = scnr.nextInt();
        setAge(ageInput);

        System.out.print("School: ");
        String schoolInput = scnr.next();
        setSchool(schoolInput);

        System.out.print("Major: ");
        String majorInput = scnr.next();
        setMajor(majorInput);

        accountDB.addToDataBase(this);
    }

}

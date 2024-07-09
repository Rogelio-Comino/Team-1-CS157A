import java.util.HashSet;
import java.util.Scanner;

public class Menu extends Account {

    //DEFAULT CONSTRUCTOR//
    public Menu() {
    }

    public int mainMenu () {
        Scanner scnr = new Scanner(System.in);
        int option = 0;

            try {
                System.out.println("Welcome to StudyBuddy: Where you can find the study partner of your dreams! :\n" );
                System.out.println("Please Select an Option:");
                System.out.println("1.Login ");
                System.out.println("2.Create an Account");
                System.out.print("User Input: ");
                option = scnr.nextInt();
                System.out.println("");

                if (option == 1){
                    loginMenu();
                }

                else if (option == 2){
                    super.createAccount();
                }

                else if (option < 1 || option > 2){
                    System.out.println("Invalid input. Please enter a valid integer.");
                    System.out.println("");
                    mainMenu();
                }
            }
            catch(Exception e){
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.println("");
                mainMenu();
            }

        return option;
    }

    public void loginMenu(){
        Scanner scnr = new Scanner(System.in);

            System.out.println("Please Enter ");
            System.out.println("");

            System.out.print("username:");
            scnr.nextLine();

            System.out.print("password:");
            scnr.nextLine();

    }

    public void welcomeMenu(){
        System.out.print(" PROFILE PICTURE           ");
        System.out.println("Bio: -------------------");
        System.out.println("             -------------------");
        System.out.println("             -------------------");
        System.out.println("             -------------------");
        System.out.println("");
        System.out.println("Rating: ");
        System.out.println("");
        System.out.println("Dashboard");
        System.out.println("1. Notifications");
        System.out.println("2. Privacy Settings");
        System.out.println("Sign Out");
        System.out.println("");
        System.out.println("Courses: ");
    }

}

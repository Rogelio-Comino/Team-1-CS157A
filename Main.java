// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /* Static methods belong to the class rather than any instance of the class.
       This means you can call a static method without creating an instance of the class.
    */
    public static int mainMenuOption() {

        Scanner scnr = new Scanner(System.in);
        int option = 0;
        try {
            System.out.println("Please choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Create an account");
            option = scnr.nextInt();

            if (option < 1 || option > 2) {
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.println("");
                mainMenuOption();
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.out.println("");
            mainMenuOption();
        }
        return option;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Menu menu = new Menu();

        System.out.println("Welcome to StudyBuddy!");
        System.out.println("");

        int decision = mainMenuOption();
        if (decision == 1) {
            menu.loginPrompt();
        }
        else if (decision == 2) {
            menu.creatAccountPrompt();
        }
    }
}
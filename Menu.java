import java.util.Scanner;
public class Menu {

    public Menu(){
    }

    public void loginMenu(){
        Scanner scnr = new Scanner(System.in);
        Account account = new Account();

        System.out.println("Please Enter: ");

        System.out.print("First Name: ");
        account.setFirstName(scnr.nextLine());

        System.out.print("Last Name: ");
        account.setLastName(scnr.nextLine());

        System.out.print("Username: ");
        account.setUsername(scnr.nextLine());

        System.out.print("Password: ");
        account.setPassword(scnr.nextLine());

        System.out.print("Gender: ");
        account.setGender(scnr.nextLine());
    }
}


import java.util.Scanner;
public class Menu extends AccountDataBase {

    public static void postLogin(Account newAcc) {
            System.out.println("Welcome!");
            System.out.println("");
            homePage(newAcc);
    }
    public static void homePage(Account newAcc) {
        System.out.println("** PROFILE PICTURE **");
        System.out.println("");
        System.out.println("Bio: -------------------");
        System.out.println("     -------------------");
        System.out.println("     -------------------");
        System.out.println("     -------------------");
        System.out.println("");
        System.out.println("Rating: ");
        System.out.println("");
        System.out.println("Dashboard");
        System.out.println("1. Notifications");
        System.out.println("2. Privacy Settings");
        System.out.println("3. Sign Out");
        System.out.println("");
        System.out.println("Courses: " );
        newAcc.getCourselist();
    }
    public static void loginPrompt() {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String uname = scnr.next();
        System.out.print("Enter Password: ");
        String pword = scnr.next();
        boolean result = accountUserAuthentication(uname, pword);
        if (result == true) {
            Account newAcc = returnAccount(uname, pword);
            postLogin(newAcc);
        }
        else {
            System.out.println("Sorry! The username or password you entered does not match our records");
            System.out.println("Let's try again: ");
            loginPrompt();
        }
    }

        public void creatAccountPrompt() {
        Scanner scnr = new Scanner(System.in);
        Courses newCourse = new Courses();

        System.out.print("Enter your first name: ");
        String fn = scnr.next();
        System.out.print("Enter your last name: ");
        String ln = scnr.next();
        System.out.print("Enter your gender: ");
        String gndr = scnr.next();
        System.out.print("New Username: ");
        String una = scnr.next();
        System.out.print("New Password: ");
        String pwd = scnr.next();
        System.out.println("Enter your school name: ");
        scnr.nextLine();
        String sn = scnr.nextLine();
        System.out.println("Enter your major: ");
        String mj = scnr.nextLine();
        System.out.print("How many courses are you taking? ");
        int numClasses = scnr.nextInt();
        newCourse.numOfCourses(numClasses);
        Account account = new Account(fn, ln, gndr, una, pwd, sn, mj, newCourse);
        addToDataBase(account);
        System.out.println("");
        System.out.println("Congratulations! You have successfully created a new account");
        System.out.println("You will now be directed to the Homepage");
        System.out.println("");
        homePage(account);
        }
    }

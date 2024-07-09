
public class Main {
    public static void main(String[] args) {

        Menu option = new Menu();
        option.mainMenu();

        AccountDataBase account = new AccountDataBase();
        account.printAccount();
    }
}
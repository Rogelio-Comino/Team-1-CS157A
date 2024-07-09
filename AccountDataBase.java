import java.util.HashSet;
public class AccountDataBase extends Account{
    private static HashSet<Account> accountDB;
    public AccountDataBase() {
        accountDB = new HashSet<>();
    }

    public void addToDataBase (Account account) {
        accountDB.add(account);
    }
    public void printListOfAccounts() {
        int count = 1;
        for (Account item : accountDB) {
            System.out.print(count + ") " + "Username: " + item.username + "  |  Password: " + item.password);
            ++count;
        }
    }
    public static boolean accountUserAuthentication(String username, String password) {
        for (Account item : accountDB) {
            if (item.username.equals(username) && item.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static Account returnAccount(String username, String password) {
        Account acc = new Account();

        for (Account item : accountDB) {
            if (item.username.equals(username) && item.password.equals(password)) {
                return item;
            }
        }
        return acc;
    }
}

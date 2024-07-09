import java.util.HashSet;
public class AccountDataBase extends Account {

    private HashSet<Account> accountDataBase;

    public AccountDataBase() {
        accountDataBase = new HashSet<>();
    }

    public void addToDataBase(Account accountInfo) {
        accountDataBase.add(accountInfo);
    }

    public void printAccount() {
        for(Account item: accountDataBase){
            System.out.println("Username: " + item.email);
        }

    }
}

//index 0: Account 1(dhfbvdkfncdjcdcmndc)
//index 1: Account 2(jfhkdjcms;ldkndekds)
public class Main {

    public static void main(String args[]){

        /*Student student1 = new Student();
        student1.setUsername("bob.brown@example.com");
        System.out.println(student1.getUsername());
        student1.setPassword("password4");
        System.out.println(student1.getPassword());
        student1.setFirstName("Bob");
        System.out.println(student1.getFirstName());

        student1.setSchool("Science School");
        System.out.print(student1.getSchool());

         */
        /*Account account1 = DatabaseUtil.getAccountByUsername("mohammed.u.rahman@sjsu.edu");
        account1.setPassword("Apple123");
        account1.setFirstName("Mohammed");
        account1.setLastName("Rahman");
        account1.setGender("Male");
         */

        Account account2 = new Account();


        //DatabaseUtil.insertData("Account", "username", "mohrah510@gmail.com");


        Account.deleteAccount("mohrah510@gmail.com");


    }
}

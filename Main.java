// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Student firstStudent = new Student("raider.ike", "Apple123", "Isaac", "Cozar", "Male", "07-14-2024", "SJSU", "Software Engineering");
        Profile profile1 = firstStudent.getProfile();
        double rating = profile1.getHelpfulness();
        System.out.println(rating);


        int id = ID_generator.generateID();
        System.out.println(id);
    }
}
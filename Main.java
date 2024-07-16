public class Main {
    public static void main(String[] args) {
        Student student = new Student("johndoe", "password123", "John", "Doe", "Male", "2024-07-10", "Harvard", "Computer Science");
        Profile profile = student.getProfile();

        // Print profile details
        System.out.println("Profile ID: " + profile.getProfile_ID());
        System.out.println("Username: " + profile.getUsername());
        System.out.println("First Name: " + profile.getFirstName());
        System.out.println("Last Name: " + profile.getLastName());
        System.out.println("School: " + profile.getSchool());
        System.out.println("Major: " + profile.getMajor());
        System.out.println("Bio: " + profile.getBio());
        System.out.println("Profile Pic: " + profile.getProfilePic());

    }
}
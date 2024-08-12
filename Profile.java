package com.example.utils;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Blob;
public class Profile {
    private int profile_ID;
    private int notification_ID;
    private int rating_ID;
    private int ss_ID;
    private SystemSettings settings;
    private SystemSettings sys;
    private String bio;
    private String profile_pic;
    private String uselessName;
    public Profile() {

    }

    // Constructor for returning users with existing account details in the database
    public Profile(String uselessName, int profile_ID) {
        this.uselessName = uselessName;
        this.profile_ID = profile_ID;
        this.notification_ID = Notifications.getnotification_ID(this.profile_ID);
        this.rating_ID = getRating_ID(this.profile_ID);
        this.ss_ID = getSS_ID(this.profile_ID);
        settings = new SystemSettings(this.ss_ID, this.rating_ID);
        this.bio = getBio(this.profile_ID);
        this.profile_pic = getProfilePic(this.profile_ID);
    }

    // Constructor for creating new accounts
    public Profile(int profile_ID) {
        this.profile_ID = insertProfileIDintoDB(profile_ID);
        Notifications.setNotification_ID(this.profile_ID, "notification_ID", 0);
        this.notification_ID = Notifications.getnotification_ID(this.profile_ID);
        this.rating_ID = setRatingID();
        this.ss_ID = setSystemSettingsID();
        settings = new SystemSettings(this.ss_ID);
        this.bio = null;
        this.profile_pic = null;

    }


    //----------------------------------- SETTER METHODS -------------------------------------------//

    public int insertProfileIDintoDB(int id) {
        DatabaseUtil.insertIntData("Profile", "profile_ID", id);
        return id;
    }
    public int setRatingID() {
        int r_id = ID_generator.generateID("Profile", "rating_ID");
        String res = Integer.toString(r_id);
        while (res.length() != 5) {
            r_id = ID_generator.generateID("Profile", "rating_ID");
            res = Integer.toString(r_id);
        }
        int officialNum = Integer.parseInt(res);
        DatabaseUtil.updateIntProfileDetails(this.profile_ID, "rating_ID", officialNum);
        DatabaseUtil.insertIntData("Rating", "rating_ID", officialNum);
        return officialNum;
    }
    public int setSystemSettingsID() {
        int r_id = ID_generator.generateID("Profile", "ss_ID");
        String res = Integer.toString(r_id);
        while (res.length() != 4) {
            r_id = ID_generator.generateID("Profile", "ss_ID");
            res = Integer.toString(r_id);
        }
        int officialNum = Integer.parseInt(res);
        DatabaseUtil.updateIntProfileDetails(this.profile_ID, "ss_ID", officialNum);
        return officialNum;
    }

    public void setBio(String bio) {
        DatabaseUtil.updateStringProfileDetails(this.profile_ID, "bio", bio);
        this.bio = bio;
    }

    public void setProfilePicture(String profile_pic) {
        DatabaseUtil.updateStringProfileDetails(this.profile_ID, "profile_pic", profile_pic);
    }

    //----------------------------------- GETTER METHODS -------------------------------------------//

    public int getRating_ID() {
        String query = "SELECT rating_ID FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "rating_ID");
        return result;
    }

    public int getNotification_ID() {
        String query = "SELECT notification_ID FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "notification_ID");
        return result;
    }

    public int getRating_ID(int profile_ID) {
        String query = "SELECT rating_ID FROM Profile WHERE profile_ID = '" + profile_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "rating_ID");
        return result;
    }
    public int getSS_ID() {
        String query = "SELECT ss_ID FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "ss_ID");
        return result;
    }
    public int getSS_ID(int profile_ID) {
        String query = "SELECT ss_ID FROM Profile WHERE profile_ID = '" + profile_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "ss_ID");
        return result;
    }
    public int getProfile_ID() {
        String query = "SELECT profile_ID FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
        return result;
    }

    public SystemSettings getSettings() {
        return this.settings;
    }
    public String getBio(int profile_ID) {
        String query = "SELECT bio FROM Profile WHERE profile_ID = '" + profile_ID + "'";
        String result = DatabaseUtil.executeStringQuery(query, "bio");
        return result;
    }
    public String getBio() {
        String query = "SELECT bio FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        String result = DatabaseUtil.executeStringQuery(query, "bio");
        return result;
    }

    public String getProfilePic() {
        String query = "SELECT profile_pic FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        String result = DatabaseUtil.executeStringQuery(query, "profile_pic");
        return result;
    }

    public String getProfilePic(int profile_ID) {
        String query = "SELECT profile_pic FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        String result = DatabaseUtil.executeStringQuery(query, "profile_pic");
        return result;
    }

    public Double getRatingScore() {
        String query = "SELECT avg_rating FROM Rating JOIN Profile ON Rating.rating_ID = Profile.rating_ID" +
                " WHERE profile_ID = '" + this.profile_ID + "'";
        Double result = DatabaseUtil.executeDoubleQuery(query, "avg_rating");
        return result;
    }


    //-------------------------- METHODS FOR CREATING MEETINGS WITH OTHER USERS---------------------------------//


    public void sendMeetingRequest(Profile receiver) {
        int notificationID = 4;   // Message from DB = 4: "Meeting Request Sent"
        Notifications.setNotification_ID(this.profile_ID, "notification_ID", notificationID); // Updates sender's notification_ID in Profile in DB

        int tempMeeting_ID = ID_generator.generateID("Profile", "meeting_ID");                     //----
        DatabaseUtil.updateIntProfileDetails(this.profile_ID, "meeting_ID", tempMeeting_ID);            // 3 statements insert temp. meeting_ID
        DatabaseUtil.updateIntProfileDetails(receiver.getProfile_ID(), "meeting_ID", tempMeeting_ID);   //____

        // Notify receiver
        receiver.receiveMeetingRequest(1, this.profile_ID);   // Message from DB = 1: "New Meeting Request"
    }

    public void receiveMeetingRequest(int notificationID, int senderProfileID) {
        Notifications.setNotification_ID(this.profile_ID, "notification_ID", notificationID); // Updates receiver's notification_ID in Profile in DB
    }
    public void checkNotifications() {
        int n_ID = Notifications.getnotification_ID(this.profile_ID);
        String query1 = "SELECT meeting_ID FROM Profile WHERE profile_ID = '" + this.profile_ID + "'";
        String tempMeeting_ID = DatabaseUtil.executeStringQuery(query1, "meeting_ID");  // Retrieves tempMeeting_ID
        String query2 = "SELECT profile_ID FROM Profile WHERE profile_ID <> '" + this.profile_ID + "'" +
                "AND meeting_ID = '" + tempMeeting_ID + "'";
        int senderP_ID = DatabaseUtil.executeIntQuery(query2, "profile_ID");
        String query = "SELECT message FROM Notifications WHERE notification_ID = '" + n_ID + "'";
        String message = DatabaseUtil.executeStringQuery(query, "message");  // Retrieves message associated with current notification_ID
        String firstName = "SELECT a.first_name FROM Account a JOIN Student s ON a.username = s.username " +
                "JOIN Profile p ON s.profile_ID = p.profile_ID WHERE p.profile_ID <> '" + this.profile_ID + "'" +
                "AND p.meeting_ID = '" + tempMeeting_ID + "'";
        String result = DatabaseUtil.executeStringQuery(firstName, "first_name");  // Retrieves first_name from Sender
        System.out.println("Notifications: ");
        System.out.println("---------------");
        String m = "New Meeting Request";

        // Prints message associated with notification_ID and prompts user for response
        if (message.equals(m)) {
            System.out.println(message + " From " + result);
            System.out.println("Accept or Deny Meeting Request");
            boolean answer = respondToMeetingRequest();
            if (answer == true) {
                System.out.println("Great!");
                Meeting meeting = new Meeting(this.profile_ID, senderP_ID);
                meeting.confirmMeeting();  // Changes notification_ID for both sender and receiver
            }
            else {
                System.out.println("The meeting request has been denied.");
                Notifications.setNotification_ID(this.profile_ID, "notification_ID", 3);
                Notifications.setNotification_ID(senderP_ID, "notification_ID", 3);
            }
        }
        else {
            System.out.println(message);
        }
    }
    public boolean respondToMeetingRequest() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter: ");
        String receiversAnswer = scnr.nextLine();
        if (receiversAnswer.equals("Accept")) {
            return true;
        }
        return false;
    }

    public static Student generateProfileForStudent() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter name of student you want to create a meeting with: ");
        System.out.print("Name: ");

        String createMeeting = scnr.nextLine();
        String[] parts = createMeeting.split(" ");

        String firstName = parts[0];
        String lastName = parts[1];

        String query1 = "SELECT username FROM Account WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'";
        String query2 = "SELECT password FROM Account WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'";
        String username = DatabaseUtil.executeStringQuery(query1, "username");
        String password = DatabaseUtil.executeStringQuery(query2, "password");
        Student otherStudent = Student.userAccountAuthentication(username, password);
        return otherStudent;
    }
}


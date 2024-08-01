public class Notifications {
    public static void setNotification_ID(int notification_ID) {
        DatabaseUtil.insertIntData("Notifications", "notification_ID", notification_ID);
    }

    public static int getNotification_ID(String username) {
        String query = "SELECT notification_ID FROM Notification WHERE username = '" + username + "'";
        int result = DatabaseUtil.executeIntQuery(query, "notification_ID");
        return result;
    }
    public static String getNotificationID_message(int notification_ID) {
        String query = "SELECT message FROM Notification WHERE notification_ID = '" + notification_ID + "'";
        String result = DatabaseUtil.executeStringQuery(query, "notification_ID");
        return result;
    }
}

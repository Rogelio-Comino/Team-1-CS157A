package com.example.utils;
public class Notifications {
    public static void setNotification_ID(int profile_ID, String notification_ID, int id_value) {
        DatabaseUtil.updateIntProfileDetails(profile_ID, notification_ID, id_value);
    }

    public static int getnotification_ID(int p_id) {
        String query = "SELECT Profile.notification_ID FROM Profile WHERE profile_ID = '" + p_id + "'";
        int result = DatabaseUtil.executeIntQuery(query, "notification_ID");
        return result;
    }
    public static String getNotificationID_message(int notification_ID) {
        String query = "SELECT message FROM Notification WHERE notification_ID = '" + notification_ID + "'";
        String result = DatabaseUtil.executeStringQuery(query, "notification_ID");
        return result;
    }
}

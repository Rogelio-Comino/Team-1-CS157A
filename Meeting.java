package com.example.utils;
public class Meeting {
    private int meeting_ID;
    private int profile1_ID;  // receiver
    private int profile2_ID;  // sender
    private boolean isConfirmed;

    public Meeting(int profile1_ID, int profile2_ID) {
        this.profile1_ID = profile1_ID;
        this.profile2_ID = profile2_ID;
        this.isConfirmed = false;
        this.meeting_ID = generateMeetingID();
        createMeetingInDB();
    }

    private int generateMeetingID() {
        // Generates a unique 6-digit meeting ID
        int m_id = ID_generator.generateID("Profile", "meeting_ID");
        String res = Integer.toString(m_id);
        while (res.length() != 6) {
            m_id = ID_generator.generateID("Profile", "meeting_ID");
            res = Integer.toString(m_id);
        }
        int officialNum = Integer.parseInt(res);
        return officialNum;
    }

    private void createMeetingInDB() {
        // Inserts meeting details into Meeting and Profile tables in database
        DatabaseUtil.insertIntData("Meeting", "meeting_ID", this.meeting_ID);
        DatabaseUtil.updateIntMeetingDetails(this.meeting_ID, "sender", this.profile1_ID);
        DatabaseUtil.updateIntMeetingDetails(this.meeting_ID, "receiver", this.profile2_ID);
        DatabaseUtil.updateIntProfileDetails(this.profile1_ID, "meeting_ID", this.meeting_ID);
        DatabaseUtil.updateIntProfileDetails(this.profile2_ID, "meeting_ID", this.meeting_ID);

    }

    public void confirmMeeting() {
        // Updates notification_ID in Profile for both users
        this.isConfirmed = true;
        Notifications.setNotification_ID(this.profile1_ID, "notification_ID", 2);
        Notifications.setNotification_ID(this.profile2_ID, "notification_ID", 2);
    }
}

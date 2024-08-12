package com.example.utils;

import java.util.ArrayList;

public class SystemSettings {
    private int ss_ID;
    private int course_ID;
    private int characteristics_ID;
    public Course course;
    protected Course course1;
    private int randomNum;
    public SystemSettings() {

    }
    public SystemSettings(int ss_ID, int randomNum) {
        this.randomNum = randomNum;
        this.ss_ID = ss_ID;
        this.course_ID = getCourse_ID(this.ss_ID);
        course = new Course(this.course_ID, 1);
    }
    public SystemSettings(int ss_ID) {
        this.ss_ID = insertSystemSettingsIDintoDB(ss_ID);
        this.course_ID = setCourseID();
        course = new Course(this.course_ID);
    }
    public int insertSystemSettingsIDintoDB(int ss_ID) {
        DatabaseUtil.insertIntData("SystemSettings", "ss_ID", ss_ID);
        return ss_ID;
    }

    //----------------------------------- SETTER METHODS -------------------------------------------//

    public int setCourseID() {
        int c_id = ID_generator.generateID("SystemSettings", "course_ID");
        String res = Integer.toString(c_id);
        while (res.length() != 5) {
            c_id = ID_generator.generateID("SystemSettings", "course_ID");
            res = Integer.toString(c_id);
        }
        int officialNum = Integer.parseInt(res);
        DatabaseUtil.updateIntSystemSettingsDetails(this.ss_ID, "course_ID", officialNum);
        DatabaseUtil.insertIntData("Course", "course_ID", officialNum);
        return officialNum;
    }

    //----------------------------------- GETTER METHODS -------------------------------------------//

    public int getCourse_ID(int ss_ID) {
        String query = "SELECT course_ID FROM SystemSettings WHERE ss_ID = '" + ss_ID + "'";
        int result = DatabaseUtil.executeIntQuery(query, "course_ID");
        return result;
    }
    public Course getCourse() {
        return this.course;
    }

    //----------------------------------- NESTED CLASS -------------------------------------------//

    public static class Course {
        protected int course_ID;
        protected String course1;
        protected String course2;
        protected String course3;
        protected String course4;
        protected int randomNum;

        public Course() {

        }
        public Course(int course_ID, int randomNum) {
            this.randomNum = randomNum;
            this.course_ID = course_ID;
            this.course1 = getCourse1(this.course_ID);
            this.course2 = getCourse2(this.course_ID);
            this.course3 = getCourse3(this.course_ID);
            this.course4 = getCourse4(this.course_ID);
        }
        public Course(int course_ID) {
            this.course_ID = course_ID;
            this.course1 = null;
            this.course2 = null;
            this.course3 = null;
            this.course4 = null;
        }

        //----------------------------------- SETTER METHODS -------------------------------------------//

        public void setCourse1(String course1) {
            DatabaseUtil.updateStringCourseDetails(this.course_ID, "course1", course1);
        }
        public void setCourse2(String course2) {
            DatabaseUtil.updateStringCourseDetails(this.course_ID, "course2", course2);
        }
        public void setCourse3(String course3) {
            DatabaseUtil.updateStringCourseDetails(this.course_ID, "course3", course3);
        }
        public void setCourse4(String course4) {
            DatabaseUtil.updateStringCourseDetails(this.course_ID, "course4", course4);
        }

        //----------------------------------- GETTER METHODS -------------------------------------------//

        public String getCourse1() {
            String query = "SELECT course1 FROM Course WHERE course_ID = '" + this.course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course1");
            return result;
        }
        public String getCourse2() {
            String query = "SELECT course2 FROM Course WHERE course_ID = '" + this.course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course2");
            return result;
        }
        public String getCourse3() {
            String query = "SELECT course3 FROM Course WHERE course_ID = '" + this.course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course3");
            return result;
        }
        public String getCourse4() {
            String query = "SELECT course4 FROM Course WHERE course_ID = '" + this.course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course4");
            return result;
        }
        public int getCourse_ID() {
            String query = "SELECT course_ID FROM Course WHERE course_ID = '" + this.course_ID + "'";
            int result = DatabaseUtil.executeIntQuery(query, "course_ID");
            return result;
        }

        // ---------------------------------------------------------------------
        public String getCourse1(int course_ID) {
            String query = "SELECT course1 FROM Course WHERE course_ID = '" + course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course1");
            return result;
        }
        public String getCourse2(int course_ID) {
            String query = "SELECT course2 FROM Course WHERE course_ID = '" + course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course2");
            return result;
        }
        public String getCourse3(int course_ID) {
            String query = "SELECT course3 FROM Course WHERE course_ID = '" + course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course3");
            return result;
        }
        public String getCourse4(int course_ID) {
            String query = "SELECT course4 FROM Course WHERE course_ID = '" + course_ID + "'";
            String result = DatabaseUtil.executeStringQuery(query, "course4");
            return result;
        }

        /**
         * Generates a list of profile IDs of potential study buddies for a given course.  // SEQUENCE POSITION: #1
         *
         * @return An ArrayList containing the profile IDs of potential study buddies.
         */

        public ArrayList<Integer> generateMeetingListForCourse1() {
            int courseID = getCourse_ID();
            String course1 = getCourse1();
            ArrayList<Integer> potentialStudyBuddyList = DatabaseUtil.getProfileIDsByCourse(course1);
            String query = "SELECT s.profile_ID FROM Student s " +
                    "INNER JOIN Profile p ON s.profile_ID = p.profile_ID " +
                    "INNER JOIN SystemSettings ss ON p.ss_ID = ss.ss_ID " +
                    "WHERE ss.course_ID = '" + courseID + "'";
            int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
            if (potentialStudyBuddyList.contains(result)) {
                potentialStudyBuddyList.remove(Integer.valueOf(result));
            }
            return potentialStudyBuddyList;
        }
        public ArrayList<Integer> generateMeetingListForCourse2() {
            int courseID = getCourse_ID();
            String course2 = getCourse2();
            ArrayList<Integer> potentialStudyBuddyList = DatabaseUtil.getProfileIDsByCourse(course2);
            String query = "SELECT s.profile_ID FROM Student s " +
                    "INNER JOIN Profile p ON s.profile_ID = p.profile_ID " +
                    "INNER JOIN SystemSettings ss ON p.ss_ID = ss.ss_ID " +
                    "WHERE ss.course_ID = '" + courseID + "'";
            int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
            if (potentialStudyBuddyList.contains(result)) {
                potentialStudyBuddyList.remove(Integer.valueOf(result));
            }
            return potentialStudyBuddyList;
        }
        public ArrayList<Integer> generateMeetingListForCourse3() {
            int courseID = getCourse_ID();
            String course3 = getCourse3();
            ArrayList<Integer> potentialStudyBuddyList = DatabaseUtil.getProfileIDsByCourse(course3);
            String query = "SELECT s.profile_ID FROM Student s " +
                    "INNER JOIN Profile p ON s.profile_ID = p.profile_ID " +
                    "INNER JOIN SystemSettings ss ON p.ss_ID = ss.ss_ID " +
                    "WHERE ss.course_ID = '" + courseID + "'";
            int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
            if (potentialStudyBuddyList.contains(result)) {
                potentialStudyBuddyList.remove(Integer.valueOf(result));
            }
            return potentialStudyBuddyList;
        }
        public ArrayList<Integer> generateMeetingListForCourse4() {
            int courseID = getCourse_ID();
            String course4 = getCourse4();
            ArrayList<Integer> potentialStudyBuddyList = DatabaseUtil.getProfileIDsByCourse(course4);
            String query = "SELECT s.profile_ID FROM Student s " +
                    "INNER JOIN Profile p ON s.profile_ID = p.profile_ID " +
                    "INNER JOIN SystemSettings ss ON p.ss_ID = ss.ss_ID " +
                    "WHERE ss.course_ID = '" + courseID + "'";
            int result = DatabaseUtil.executeIntQuery(query, "profile_ID");
            if (potentialStudyBuddyList.contains(result)) {
                potentialStudyBuddyList.remove(Integer.valueOf(result));
            }
            return potentialStudyBuddyList;
        }

        public ArrayList<String> printMeetingListDetailsForCourse1() {
            ArrayList<Integer> list = generateMeetingListForCourse1();
            ArrayList<String> nameList = new ArrayList<>();
            for (int item : list) {
                String query = "SELECT a.first_name FROM Account a JOIN Student s ON a.username = s.username " +
                                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                                        "WHERE p.profile_ID = '" + item + "'";
                String fName = DatabaseUtil.executeStringQuery(query, "first_name");
                String query2 = "SELECT a.last_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String lName = DatabaseUtil.executeStringQuery(query2, "last_name");
                String query3 = "SELECT avg_rating FROM Rating JOIN Profile ON Rating.rating_ID = Profile.rating_ID " +
                                        "WHERE profile_ID = '" + item + "'";
                Double myDouble = DatabaseUtil.executeDoubleQuery(query3, "avg_rating");
                String rating = myDouble.toString();
                String finalString = fName + " " + lName + " - Rating: " + rating;
                nameList.add(finalString);
            }
            return nameList;
        }
        public ArrayList<String> printMeetingListDetailsForCourse2() {
            ArrayList<Integer> list = generateMeetingListForCourse2();
            ArrayList<String> nameList = new ArrayList<>();
            for (int item : list) {
                String query = "SELECT a.first_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String fName = DatabaseUtil.executeStringQuery(query, "first_name");
                String query2 = "SELECT a.last_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String lName = DatabaseUtil.executeStringQuery(query2, "last_name");
                String query3 = "SELECT avg_rating FROM Rating JOIN Profile ON Rating.rating_ID = Profile.rating_ID " +
                        "WHERE profile_ID = '" + item + "'";
                Double myDouble = DatabaseUtil.executeDoubleQuery(query3, "avg_rating");
                String rating = myDouble.toString();
                String finalString = fName + " " + lName + " - Rating: " + rating;
                nameList.add(finalString);
            }
            return nameList;
        }
        public ArrayList<String> printMeetingListDetailsForCourse3() {
            ArrayList<Integer> list = generateMeetingListForCourse3();
            ArrayList<String> nameList = new ArrayList<>();
            for (int item : list) {
                String query = "SELECT a.first_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String fName = DatabaseUtil.executeStringQuery(query, "first_name");
                String query2 = "SELECT a.last_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String lName = DatabaseUtil.executeStringQuery(query2, "last_name");
                String query3 = "SELECT avg_rating FROM Rating JOIN Profile ON Rating.rating_ID = Profile.rating_ID " +
                        "WHERE profile_ID = '" + item + "'";
                Double myDouble = DatabaseUtil.executeDoubleQuery(query3, "avg_rating");
                String rating = myDouble.toString();
                String finalString = fName + " " + lName + " - Rating: " + rating;
                nameList.add(finalString);
            }
            return nameList;
        }
        public ArrayList<String> printMeetingListDetailsForCourse4() {
            ArrayList<Integer> list = generateMeetingListForCourse4();
            ArrayList<String> nameList = new ArrayList<>();
            for (int item : list) {
                String query = "SELECT a.first_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String fName = DatabaseUtil.executeStringQuery(query, "first_name");
                String query2 = "SELECT a.last_name FROM Account a JOIN Student s ON a.username = s.username " +
                        "JOIN Profile p ON s.profile_ID = p.profile_ID " +
                        "WHERE p.profile_ID = '" + item + "'";
                String lName = DatabaseUtil.executeStringQuery(query2, "last_name");
                String query3 = "SELECT avg_rating FROM Rating JOIN Profile ON Rating.rating_ID = Profile.rating_ID " +
                        "WHERE profile_ID = '" + item + "'";
                Double myDouble = DatabaseUtil.executeDoubleQuery(query3, "avg_rating");
                String rating = myDouble.toString();
                String finalString = fName + " " + lName + " - Rating: " + rating;
                nameList.add(finalString);
            }
            return nameList;
        }
    }
}

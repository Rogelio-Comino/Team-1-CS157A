import java.util.ArrayList;
import java.util.Scanner;

public class SystemSettings {

    private int SS_ID;
    private ArrayList <Course> courseList;
    private PreferredPartnerCharacteristics pfc;

    public SystemSettings(){
    }

    public SystemSettings(int SS_ID){
        this.SS_ID = SS_ID;
        this.courseList = new ArrayList<>();
        this.pfc = new PreferredPartnerCharacteristics();
    }

    public void addNumOfCourses(int num){           //Sets the number of courses
        for (int i = 0; i < num; i++){
            Course newCourse = new Course();
            courseList.add(newCourse);
        }
    }

    public void setCourseInfo(){                    //Sets detailed course info
        Scanner scnr = new Scanner(System.in);
        int count = 1;

        for (Course item: courseList){              //Accesses each course in the list

            System.out.print("Course #" + count + " info");

            System.out.print("Department name:");
            String dptName = scnr.nextLine();
            item.setDepartment(dptName);            //Sets course department

            System.out.print("Course number:");
            int courseNum = scnr.nextInt();
            item.setCourse_num(courseNum);          //Sets course number

            System.out.print("Course name:");
            String courseName = scnr.nextLine();
            item.setCourse_name(courseName);        //Sets course name

            count++;
        }
    }

    public void setPreferredPartnerCharacteristicsInfo(){       //Sets preferred characteristics
        Scanner scnr = new Scanner(System.in);
        System.out.print("Preferred Partner Characteristics: ");


        System.out.print("Gender choice: ");
        String genderChoice = scnr.nextLine();
        pfc.setGender(genderChoice);                //Sets gender choice

        System.out.print("Professor first name: ");
        String prof_fname = scnr.nextLine();
        pfc.setProf_fname(prof_fname);              //Sets professor's first name

        System.out.print("Professor last name: ");
        String prof_lname = scnr.nextLine();
        pfc.setProf_lname(prof_lname);              //Sets professor's last name

        System.out.print("Course name: ");
        String course_name = scnr.nextLine();
        pfc.setCourse_name(course_name);            //Sets course name
    }


    //-------------------------------------ENCAPSULATED CLASSES------------------------------------------------

    public static class Course {
        private int course_ID;
        private String department;
        private int course_num;
        private String course_name;
        private int num_courses;
        private ArrayList<Profile> students_also_taking_course;

        public Course(){

        }

        public Course(int course_ID, String department, int course_num, String course_name){
            this.course_ID = course_ID;
            this.department = department;
            this.course_num = course_num;
            this.course_name = course_name;
        }

        // Setter Methods
        public void setCourse_ID(int course_ID) {
            this.course_ID = course_ID;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setCourse_num(int course_num) {
            this.course_num = course_num;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public void setNum_courses(int num_courses) {
            this.num_courses = num_courses;
        }

        // Getter Methods
        public int getCourse_ID() {
            return course_ID;
        }

        public String getDepartment() {
            return department;
        }

        public int getCourse_num() {
            return course_num;
        }

        public String getCourse_name() {
            return course_name;
        }

        public int getNum_courses() {
            return num_courses;
        }
    }

    public static class PreferredPartnerCharacteristics {

        private int characteristics_ID;
        private String gender;
        private String prof_fname;
        private String prof_lname;
        private String course_name;

        public PreferredPartnerCharacteristics(){
        }

        public PreferredPartnerCharacteristics(int characteristics_ID, String gender, String prof_fname, String prof_lname, String course_name){
            this.characteristics_ID = characteristics_ID;
            this.gender = gender;
            this.prof_fname = prof_fname;
            this.prof_lname = prof_lname;
            this.course_name = course_name;
        }

        //Setter Methods
        public void setGender(String gender){
            this.gender = gender;
        }
        public void setProf_fname(String prof_fname){
            this.prof_fname = prof_fname;
        }
        public void setProf_lname(String prof_lname){
            this.prof_lname = prof_lname;
        }
        public void setCourse_name(String course_name){
            this.course_name = course_name;
        }

        // Getter Methods
        public String getGender() {
            return this.gender;
        }
        public String getProf_fname() {
            return this.prof_fname;
        }
        public String getProf_lname() {
            return this.prof_lname;
        }
        public String getCourse_name() {
            return this.course_name;
        }

    }




}

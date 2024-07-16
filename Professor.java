public class Professor {

    private int  professor_ID;
    private String prof_fname;
    private String prof_lname;

    public Professor(){
    }

    public Professor(int professor_ID, String prof_fname, String prof_lname){
        this.professor_ID = professor_ID;
        this.prof_fname = prof_fname;
        this.prof_lname = prof_lname;
    }

    //Setter Methods
    public void setProf_fname(String prof_fname){
        this.prof_fname = prof_fname;
    }
    public void setProf_lname(String prof_lname){
        this.prof_lname = prof_lname;
    }

    //Getter Methods
    public String getProf_fname(){
        return prof_fname;
    }
    public String getProf_lname(){
        return prof_lname;
    }

}

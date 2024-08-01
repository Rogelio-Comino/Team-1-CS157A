import java.util.ArrayList;

public class Meeting {
    private int meeting_ID;
    private double time;
    private String location;
    private ArrayList<Student> participants;

    //public Meeting(){
    //}

    public Meeting(){
        this.meeting_ID = ID_generator.generateID();
    }


}

public class Rating {

    private int rating_ID;
    private double punctuality;
    private double helpfulness;
    private double overall_exp;
    private double avg_rating;

    public Rating(){
    }

    public Rating(double punctuality, double helpfulness, double overall_exp ){
        this.rating_ID = ID_generator.generateID();
        this.punctuality = punctuality;
        this.helpfulness = helpfulness;
        this.overall_exp = overall_exp;
        this.avg_rating = (overall_exp + helpfulness + punctuality) / 3.0;
    }

    // Setter methods
    public void setPunctuality(double punctuality) {
        this.punctuality = punctuality;
    }
    public void setHelpfulness(double helpfulness) {
        this.helpfulness = helpfulness;
    }
    public void setOverall_exp(double overall_exp) {
        this.overall_exp = overall_exp;
    }

    // Getter methods
    public int getRating_ID(){
        return this.rating_ID;
    }
    public double getPunctuality() {
        return this.punctuality;
    }
    public double getHelpfulness() {
        return this.helpfulness;
    }
    public double getOverall_exp() {
        return this.overall_exp;
    }
    public double getAvg_rating() {
        return this.avg_rating;
    }

}

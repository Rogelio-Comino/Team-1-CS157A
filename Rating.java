public class Rating {
    protected int rating_ID;
    protected double punctuality;
    protected double helpfulness;
    protected double overall_exp;
    protected double avg_rating;
    public Rating() {

    }
    public Rating(double punctuality, double helpfulness, double overall_exp) {
        this.rating_ID = ID_generator.generateID();
        this.punctuality = punctuality;
        this.helpfulness = helpfulness;
        this.overall_exp = overall_exp;
        this.avg_rating = (punctuality + helpfulness + overall_exp) / 3.0;
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
    public int getRating_ID() {
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

package id.ac.ukdw.fti.rpl.hardworkers.modal;

public class Event {
    private String title;
    private int startDate;
    private String verses;
    private String peoples;
    private String duration;

    // constructor
    // public Event(String title, String verses, String places) {
    //     this.title = title;
    //     this.verses = verses;
    //     this.places = places;
    // }
    // method setter
    public void setTitle(String title){
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setStartDate (int startDate){
        this.startDate = startDate;
    }
    public void setVerses(String verses){
        this.verses = verses;
    }
    public void setPeoples(String peoples){
        this.peoples = peoples;
    }

    //method getter
    public String getDuration() {
        return duration;
    }
    public String getTitle(){
        return this.title;
    }
    public int getStartDate(){
        return this.startDate;
    }
    public String getVerses(){
        return this.verses;
    }
    public String getPeoples(){
        if (this.peoples == null){
            return "null";
        }else{
            return this.peoples;
        }
    }

}


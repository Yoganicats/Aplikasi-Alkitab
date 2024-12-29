package id.ac.ukdw.fti.rpl.hardworkers.modal;

public class Peoples {
    private String peoples;
    private String verses;
    private int verseCount;
    private String displayTitle;
    private String eventsHere;

    //constructor
    // public Places(String places, String verseText, String displayTitle, int verseCount){
    //     this.places = places;
    //     this.verseText = verseText;
    //     this.displayTitle = displayTitle;
    //     this.verseCount = verseCount;
    // }

    public void setEventsHere(String eventsHere) {
        this.eventsHere = eventsHere;
    }

    //Method Setter
    public void setPeoples(String peoples){
        this.peoples = peoples;
    }
    public void setVerses(String verses){
        this.verses = verses;
    }
    public void setVerseCount(int verseCount){
        this.verseCount = verseCount;
    }
    public void setdisplayTitle (String displayTitle){
        this.displayTitle = displayTitle;
    }

    //Method Getter

    public String getEventsHere() {
        if(this.eventsHere == null){
            return "null123";
        }else{
            return this.eventsHere;
        }
        
    }

    public String getPeoples(){
        return this.peoples;

    }
    public String getVerse(){
        return this.verses;
    }
    public String getDisplayTitle(){
        return this.displayTitle;
    }
    public int verseCount(){
        return this.verseCount;
    }
}
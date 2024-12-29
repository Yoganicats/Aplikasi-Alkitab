package id.ac.ukdw.fti.rpl.hardworkers.modal;

public class VisualMethod {

    private String osisRef;
    private String verseText;
    private String people;
    private String verse;
    private String verseCount;
    private int peopleCount;
    private String peoples;
    private int peoplesCount;


    public VisualMethod(String verse, String verseCount) {
        this.verse = verse;
        this.verseCount = verseCount;
    }

    public VisualMethod(String people, int peopleCount, String peoples, int peoplesCount) {
        this.people = people;
        this.peopleCount = peopleCount;
        this.peoples = peoples;
        this.peoplesCount = peoplesCount;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getVerseCount() {
        return verseCount;
    }

    public void setVerseCount(String verseCount) {
        this.verseCount = verseCount;
    }

    public void setOsisRef(String osisRef) {
        this.osisRef = osisRef;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public void setPeople(String people){
        this.people = people;
    }

    public void setPeopleCount(int peopleCount){
        this.peopleCount = peopleCount;
    }
    public void setPeoples(String peoples){
        this.peoples = peoples;
    }

    public void setPlacesCount(int peoplesCount){
        this.peoplesCount = peoplesCount;
    }

    public String getOsisRef() {
        return osisRef;
    }

    public String getVerseText() {
        return verseText;
    }


    public String getPeople() {
        return people;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public String getPeoples() {
        return peoples;
    }

    public int getPlacesCount() {
        return peoplesCount;
    }

    
}

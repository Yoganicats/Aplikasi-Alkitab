package id.ac.ukdw.fti.rpl.hardworkers.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import id.ac.ukdw.fti.rpl.hardworkers.modal.Event;
import id.ac.ukdw.fti.rpl.hardworkers.modal.Peoples;
import id.ac.ukdw.fti.rpl.hardworkers.modal.Verses;
import id.ac.ukdw.fti.rpl.hardworkers.modal.VisualMethod;
import id.ac.ukdw.fti.rpl.hardworkers.modal.tampil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    
    final private String url = "jdbc:sqlite:vizbible.db";
    // final private String queryPeoples = "SELECT displayTitle FROM peoples";
    private Connection connection = null;
    public static Database instance = new Database();

    public Database(){
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection opeConnection(){
        return connection;
    }

    public ArrayList getAllVerses(){
        ArrayList<Verses> verses = new ArrayList<Verses>();
        String querySelect = "SELECT osisRef, verseText FROM verses";
        try {
            Statement statement  = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                verses.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return verses;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return verses;
    }

    public ArrayList getBook(){
        String queryBook = "SELECT DISTINCT(book) from verses";
        ArrayList<String> book = new ArrayList<String>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryBook);
        
            while(result.next()){
                book.add(result.getString("book"));
                
            }
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    public ArrayList getChapter(String kitab){
        String queryChapter = "SELECT DISTINCT(chapter) from verses WHERE book = '"+ kitab+"'";
        ArrayList<String> chapter = new ArrayList<String>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryChapter);
        
            while(result.next()){
                chapter.add(result.getString("chapter"));
                
            }
            return chapter;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chapter;
    }

    public ArrayList getVerseNum(String pasal){
        String queryNum = "SELECT (verseNum) from verses WHERE chapter = '"+ pasal +"'";
        ArrayList<Integer> verseNum = new ArrayList<Integer>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryNum);
        
            while(result.next()){
                verseNum.add(result.getInt("verseNum"));
                
            }
            return verseNum;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return verseNum;
    }
    public ArrayList getAyat(String kitab, String pasal, int ayat){
        String query = "SELECT osisRef, verseText, verseNum FROM verses WHERE book = '"+ kitab +"' AND chapter ='"+ pasal +"'";
        // System.out.println(query);
        ArrayList <tampil> hasil = new ArrayList<tampil>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
        
            while(result.next()){
                if (result.getInt("verseNum") >= ayat){
                    // System.out.println(result.getInt("verseNum"));
                    hasil.add(new tampil(result.getString("osisRef"), result.getString("verseText"), result.getInt("verseNum")));
                }
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
            return hasil;
        }
    }


    public ArrayList searchEvent(String cari){
        String query = "SELECT osisRef, verseText FROM verses WHERE eventsDescribed LIKE '%"+cari+"%'";
        // System.out.println(query);
        ArrayList<Verses> hasil = new ArrayList<Verses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return hasil;
        } 
    }
    public ArrayList searchPeoples(String cari){
        String query = "SELECT osisRef, verseText FROM verses WHERE peoples LIKE '%"+cari+"%'";
        // System.out.println(query);
        ArrayList<Verses> hasil = new ArrayList<Verses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return hasil;
        } 
    }
    public ArrayList homeSearch(String cari){
        String query = "SELECT osisRef, verseText FROM verses WHERE peoples LIKE '%"+cari+"%' OR eventsDescribed LIKE '%"+cari+"%'";
        // System.out.println(query);
        ArrayList<Verses> hasil = new ArrayList<Verses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return hasil;
        } 
    }
    public VisualMethod visualData(String cari){
        String query = "SELECT people, peopleCount,peoples,peoplesCount FROM verses WHERE osisRef = '"+cari+"'";
        // System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            return (new VisualMethod(result.getString("people"), result.getInt("peopleCount"), result.getString("peoples"), result.getInt("peoplesCount")));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String ambilNamaPeople(String id){
        String query = "SELECT displayTitle FROM people WHERE personLookup = '"+id+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                return result.getString("displayTitle");
            }
            return result.getString("displayTitle");
        } catch (Exception e) {
            return (e.getMessage());
        }
        
        
    }

    public String ambilNamaPeoples(String id){
        String query = "SELECT displayTitle FROM peoples WHERE peopleLookup = '"+id+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                 return result.getString("displayTitle");
            }
            return result.getString("displayTitle");
        } catch (Exception e) {
            return (e.getMessage());
        }
        
    }

    ObservableList<Event>events = FXCollections.observableArrayList();
    public ObservableList<Event> visEvent(){
        String query = "SELECT verses, title, locations FROM events";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                Event event = new Event();
                event.setVerses(result.getString("verses"));
                event.setTitle(result.getString("title"));
                event.setPeoples(result.getString("locations"));
                events.add(event);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return events;
        
    }
    ObservableList<Peoples>peoples = FXCollections.observableArrayList();
    public ObservableList<Peoples> visPeoples() {
        String query = "SELECT verses, displayTitle, eventsHere FROM peoples";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                Peoples people = new Peoples();
                people.setVerses(result.getString("verses"));
                people.setdisplayTitle(result.getString("displayTitle"));
                people.setEventsHere(result.getString("eventsHere"));
                peoples.add(people);
            } 
        } catch (Exception e) {
            //TODO: handle exception
        }
        return peoples;
    }

}

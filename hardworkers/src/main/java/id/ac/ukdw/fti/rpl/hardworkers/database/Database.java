package id.ac.ukdw.fti.rpl.hardworkers.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import id.ac.ukdw.fti.rpl.hardworkers.modal.Verses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    
    final private String url = "jdbc:sqlite:vizbible.db";
    final private String querySelect = "SELECT osisRef, verseText, eventsDescribed, people FROM verses";
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

    public ObservableList<Verses> getAllVerses(){
        ObservableList<Verses> verses = FXCollections.observableArrayList();
        try {
            
            Statement statement  = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                Verses verse = new Verses();
                verse.setVerse(result.getString("osisRef"));
                verse.setVerseText(result.getString("verseText"));
                verse.setEventsDescribed(result.getString("eventsDescribed"));
                verse.setPeople(result.getString("people"));
                verses.add(verse);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return verses;
    }
}

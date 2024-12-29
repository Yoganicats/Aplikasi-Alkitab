package id.ac.ukdw.fti.rpl.hardworkers;

import java.net.URL;
// import java.util.Observable;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.hardworkers.database.Database;
import id.ac.ukdw.fti.rpl.hardworkers.modal.Verses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class FXMLController implements Initializable{
    private ObservableList<Verses> verses = FXCollections.observableArrayList();
    
    @FXML
    private Text app_title;
    
    @FXML
    private TextField search_bar;

    @FXML
    private Button search_btn;

    @FXML
    private TableView<Verses> info_table;

    @FXML
    private TableColumn<Verses, String> ayat_show;

    @FXML
    private TableColumn<Verses, String> text_show;

    @FXML
    private TableColumn<Verses, String> event_show;

    @FXML
    private TableColumn<Verses, String> people_show;

    @FXML
    private TableColumn<Verses, String> graph_show;

    @FXML
    private TableView<?> graph_table;

    @FXML
    void search(ActionEvent event) {
        info_table.getItems().clear();
    }

    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllVerses();
        ayat_show.setCellValueFactory(new PropertyValueFactory<Verses, String>("verse"));
        text_show.setCellValueFactory(new PropertyValueFactory<Verses, String>("verseText"));
        event_show.setCellValueFactory(new PropertyValueFactory<Verses, String>("eventsDescribed"));
        people_show.setCellValueFactory(new PropertyValueFactory<Verses, String>("people"));
        info_table.setItems(verses);
        
        FilteredList <Verses> filteredData =  new  FilteredList<>(verses,searching -> true);
        search_bar.textProperty().addListener((Observable, oldValue, newValue)->{
            filteredData.setPredicate(verses ->{
                if (newValue==null || newValue.isEmpty()){
                    return true;
                }
                String lowerCase = newValue.toLowerCase();
                if(verses.getVerse().toLowerCase().indexOf(lowerCase)!=-1){
                    return true;
                }
                if(verses.getVerseText().toLowerCase().indexOf(lowerCase)!=-1){
                    return true;
                }
                if(verses.getEventsDescribed().toLowerCase().indexOf(lowerCase)!=-1){
                    return true;
                }
                if(verses.getPeople().toLowerCase().indexOf(lowerCase)!=-1){
                    return true;
                }
                else{
                    return false;
                }
            });
        });

        SortedList <Verses> sortingData = new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(info_table.comparatorProperty());
        info_table.setItems(sortingData);
        
    }
    
}

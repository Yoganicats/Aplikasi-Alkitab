package id.ac.ukdw.fti.rpl.hardworkers;

import java.net.URL;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.hardworkers.database.Database;
import id.ac.ukdw.fti.rpl.hardworkers.modal.Peoples;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class visPeoplesController implements Initializable{

    Database db = new Database();
    
    @FXML
    private AnchorPane visualisasiPeoples;

    @FXML
    private AreaChart<NumberAxis, CategoryAxis> areaChart;

    @FXML
    private CategoryAxis catAxis;

    @FXML
    private NumberAxis numAxis;

    private ObservableList<Peoples> peoples = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            peoples = Database.instance.visPeoples();
            XYChart.Series dataResult = new XYChart.Series();
            dataResult.setName("Peoples");
            areaChart.setLegendVisible(false);
            for(int i = peoples.size()-1; i>-0; i--){
                System.out.println(peoples.get(i).getDisplayTitle());
                System.out.println(peoples.get(i).getEventsHere().split(",").length);
                dataResult.getData().add(new BarChart.Data(peoples.get(i).getDisplayTitle(),peoples.get(i).getEventsHere().split(",").length));
            }
            areaChart.getData().add(dataResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }

    
}


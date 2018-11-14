import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class GUI_controller {
    @FXML
    private Button wbutton;

    @FXML
    private Label left_status;

    @FXML
    private Label right_status;

    @FXML
    private DatePicker in_birthday;

    @FXML
    private DatePicker in_date;

    @FXML
    private TextField in_name;

    @FXML
    private TextField in_lastname;

    @FXML
    private TextField in_treatment;

    @FXML
    private TextField in_village;

    @FXML
    private TextField in_telephone;

    @FXML
    private TableView table;

    @FXML
    private AnchorPane left_anchor;

    @FXML
    private AnchorPane main_anchor;

    private ObservableList<Person> data;

    public void pushedLowerButton(ActionEvent actionEvent) {


        /**
         * Submit button
         * t-odo:
         * Hinzufügen von Spalten +
         * Entfernen von Spalten  -
         * Einfügen von Zeilen    +
         */

        left_status.setText("SET NAME TO " + in_name.getText());
        table.getColumns().clear();

        TableCreator tc = new TableCreator();
        data = tc.getInitialTableData();
        TableColumn fnameCol = new TableColumn("First Name");
        TableColumn snameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        // PropertyValueFactory String has to be according to Person Class
        fnameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstname")
        );
        snameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastname")
        );
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("location")
        );
        table.setItems(data);

        table.getColumns().addAll(fnameCol, snameCol, emailCol);
    }

    public void startOnlineCheck(){
        Connectivity con = new Connectivity();
        con.setLabel(right_status);
        right_status.setText("<checking connection status>");
        Timeline fiveSecondsOnlineCheck = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                long startTime = System.currentTimeMillis();
                if (con.isReachable("216.58.207.67", 80, 1000)) { //google 216.58.207.67 - port 80 webserver
                    right_status.setText("Online");
                    right_status.setTextFill(Color.LIMEGREEN);
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    left_status.setText("Ping: " + Long.toString(elapsedTime) + "ms");
                } else {
                    right_status.setText("Offline");
                    right_status.setTextFill(Color.RED);
                    left_status.setText("<host unreachable>");
                }
            }
        }));
        fiveSecondsOnlineCheck.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsOnlineCheck.play();
    }


    public void makeAScene(){
        GridPane gridPane = new GridPane();
        gridPane.addColumn(2);
        gridPane.addRow(5);
        AnchorPane.setTopAnchor(gridPane, 10.0);
        left_anchor.getChildren().add(gridPane);
    }

    public void changeScene(){
        try {
            Object load = FXMLLoader.load(getClass().getResource("Pane_Search_Person.fxml"));
            left_anchor.getChildren().setAll((Node) load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeToPaneInsertPerson(){
        try {
            Object load = FXMLLoader.load(getClass().getResource("Pane_Insert_Person.fxml"));
            main_anchor.getChildren().setAll((Node) load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeToPaneSearchPerson(){
        try {
            Object load = FXMLLoader.load(getClass().getResource("Pane_Search_Person.fxml"));
            main_anchor.getChildren().setAll((Node) load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void infoFunction(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help Window");
        alert.setHeaderText("Hello fellow this is the help section!");
        alert.setContentText("To switch Panes select switch Panes");

        alert.showAndWait();
    }

    public void initialize(){
        startOnlineCheck();
    }
}
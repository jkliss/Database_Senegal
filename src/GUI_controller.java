import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

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

    private ObservableList<Person> data;

    public void pushedLowerButton(javafx.event.ActionEvent actionEvent) {
        /**
         * Submit button
         * Todo:
         * Hinzufügen von Spalten +
         * Entfernen von Spalten  -
         * Einfügen von Zeilen    -
         */

        //Window owner = wbutton.getScene().getWindow();

        left_status.setText("SET NAME TO " + in_name.getText());

        TableCreator tc = new TableCreator();
        data = tc.getInitialTableData();
        TableColumn firstCol = new TableColumn("Primary");
        TableColumn secondCol = new TableColumn("Secondary");
        firstCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstName")
        );
        secondCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstName")
        );
        table.setItems(data);

        table.getColumns().addAll(firstCol, secondCol);
    }

    public void startOnlineCheck(){
        Connectivity con = new Connectivity();
        con.setLabel(right_status);
        right_status.setText("<checking...>");
        Timeline fiveSecondsOnlineCheck = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (con.pingServer("127.0.0.1")) {
                    right_status.setText("Online");
                } else {
                    right_status.setText("Offline");
                }
            }
        }));
        fiveSecondsOnlineCheck.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsOnlineCheck.play();
    }
}
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Window;



public class GUI_controller {
    @FXML
    private Button wbutton;

    @FXML
    private Label left_status;

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

    public void pushedLowerButton(javafx.event.ActionEvent actionEvent) {
        Window owner = wbutton.getScene().getWindow();
        left_status.setText("SET NAME TO " + in_name.getText());
        TableColumn<String, String> uname_col = new TableColumn<String, String>("User Name");
    }
}
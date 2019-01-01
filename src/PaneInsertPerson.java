import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaneInsertPerson {
    @FXML
    TableView table;

    private ObservableList<Person> data;


    public void pushedLowerButton(ActionEvent actionEvent) {
        TableCreator tableCreator = new TableCreator();
        tableCreator.basicTable(table);
        System.out.println("pressed in new view");
    }
}

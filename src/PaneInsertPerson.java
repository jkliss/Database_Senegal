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
}

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class PaneSearchPerson {
    @FXML
    private TableView table;

    public void pushedLowerButton(){
        TableCreator tableCreator = new TableCreator();
        tableCreator.searchTable(table);
        System.out.println("pressed in new view");
    }
}


import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.LinkedList;

public class TableCreator {
    private ObservableList<Person> data;
    private TableView<Person> table;

    public TableColumn createTable(){
        TableColumn<String, String> createdTable = new TableColumn<String, String>("User Name");

        return createdTable;
    }

    public LinkedList<TableColumn<String, String>> TableColumn(String[] namelist, String[] elementlist){
        LinkedList<TableColumn<String, String>> tableColumns = new LinkedList<>();
        for(int i = 0; i < namelist.length; i++){
            TableColumn<String, String> tmpTableColumn = new TableColumn<>(namelist[i]);
            for(int j = 0; j < elementlist.length; j++){
                tmpTableColumn.cellFactoryProperty();
            }
        }
        return tableColumns;
    }

    public void setData(ObservableList<Person> data) {
        getInitialTableData();
        table.setItems(data);
    }

    public ObservableList<Person> getInitialTableData(){
        data = FXCollections.observableArrayList(    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com"));
        return data;
    }

    public TableView basicTable(TableView table){
        table.getColumns().clear();

        data = getInitialTableData();
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
        return table;
    }

    public TableView searchTable(TableView table, ObservableList<Person> data){
        table.getColumns().clear();
        TableColumn fnameCol = new TableColumn("First Name");
        TableColumn snameCol = new TableColumn("Last Name");
        // PropertyValueFactory String has to be according to Person Class
        fnameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstname")
        );
        snameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastname")
        );
        table.setItems(data);

        table.getColumns().addAll(fnameCol, snameCol);
        return table;
    }
}

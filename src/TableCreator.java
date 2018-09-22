import javafx.scene.control.TableColumn;

import java.util.LinkedList;

public class TableCreator {
    public TableColumn createTable(){
        TableColumn<String, String> createdTable = new TableColumn<String, String>("User Name");;

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
}

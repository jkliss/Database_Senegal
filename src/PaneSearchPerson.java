import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaneSearchPerson {
    @FXML
    private TableView table;

    @FXML
    private TextField in_name;

    @FXML
    private TextField in_lastname;

    public void pushedLowerButton(){
        IOManager ioManager = GUI_controller.ioManager;
        ObservableList<Person> data = searchPerson(ioManager.connection);
        TableCreator tableCreator = new TableCreator();
        tableCreator.searchTable(table, data);
        System.out.println("pressed in new view");
    }

    public ObservableList<Person> searchPerson(Connection connection){
        ObservableList<Person> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM doctor WHERE family_name ALIKE \"%"+in_lastname.getText()+"%\" and first_name = \"%"+in_name.getText()+"%\"";
        System.out.println("[*] "+query+":");
        Statement stmt = null;
        try {

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int DoctorID = rs.getInt("DoctorID");
                String family_name = rs.getString("family_name");
                String first_name = rs.getString("first_name");
                String password = rs.getString("password");
                String timestamp = rs.getString("last_access");
                data.add(new Person(first_name, family_name,password));
                System.out.println("[+] "+DoctorID+"\t"+family_name+"\t"+first_name+"\t"+password+"\t"+ timestamp);
            }

            // is it usefull to close the object? any autoclose option?
            stmt.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return data;
    }
}

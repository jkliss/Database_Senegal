import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class PaneAddTreatment {
    @FXML
    TableView table;

    @FXML
    DatePicker in_date;

    @FXML
    TextField in_name;

    @FXML
    TextField in_lastname;

    @FXML
    private DatePicker in_birthday;

    @FXML
    private TextField in_treatment;

    @FXML
    private TextField in_village;

    @FXML
    private TextField in_telephone;

    @FXML
    private TextField in_address;

    @FXML
    private TextField in_email;

    private ObservableList<Person> data;


    public void pushedLowerButton(){
        IOManager ioManager = GUI_controller.ioManager;
        ObservableList<Person> data = insertPerson(ioManager.connection);
        TableCreator tableCreator = new TableCreator();
        tableCreator.insertResultTable(table, data);
        System.out.println("pressed in new view");
    }

    public void pushedLowerLeftButton(){
        IOManager ioManager = GUI_controller.ioManager;
        ObservableList<Person> data = showPerson(ioManager.connection);
        TableCreator tableCreator = new TableCreator();
        tableCreator.insertResultTable(table, data);
        System.out.println("pressed in new view");
    }

    public ObservableList<Person> showPerson(Connection connection){
        ObservableList<Person> data = FXCollections.observableArrayList();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String select_query = "SELECT * FROM mydb.patient";
            ResultSet rs = stmt.executeQuery(select_query);
            while (rs.next()) {
                int doctorID = rs.getInt("PatientID");
                String family_name = rs.getString("family_name");
                String first_name = rs.getString("first_name");
                String rbirthday = rs.getString("birthday");
                String raddress = rs.getString("address");
                String remail = rs.getString("email");
                String rtelephone = rs.getString("telephone_number");
                String rothers = rs.getString("others");
                data.add(new Person(doctorID, first_name, family_name, rothers , rbirthday, raddress, remail, rtelephone));
            }

            stmt.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return data;

    }

    public ObservableList<Person> insertPerson(Connection connection){
        ObservableList<Person> data = FXCollections.observableArrayList();
        String name = in_name.getText();
        String last_name = in_lastname.getText();
        String date = "";
        try{
            date = in_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        String birthday = "";
        try{
            birthday = in_birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception ex){
            ex.printStackTrace();
        }

        String treatment = in_treatment.getText();
        String village = in_village.getText();
        String address = in_address.getText();
        String email = in_email.getText();
        String telephone = in_telephone.getText();

        String query = "INSERT INTO mydb.patient (PatientID, family_name, first_name, birthday, address, email, telephone_number,others) VALUES (" + ThreadLocalRandom.current().nextInt(1, 10000 + 1) + ", \"" + last_name + "\", \"" + name + "\", \"" + birthday +"\" , \"" + address + "\",\"" + email + "\", \"" + telephone + "\", \"" + treatment + "\");\n";
        System.out.println("[*] "+query+":");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            String select_query = "SELECT * FROM mydb.patient";
            ResultSet rs = stmt.executeQuery(select_query);
            while (rs.next()) {
                int doctorID = rs.getInt("PatientID");
                String family_name = rs.getString("family_name");
                String first_name = rs.getString("first_name");
                String rbirthday = rs.getString("birthday");
                String raddress = rs.getString("address");
                String remail = rs.getString("email");
                String rtelephone = rs.getString("telephone_number");
                String rothers = rs.getString("others");
                data.add(new Person(doctorID, first_name, family_name, rothers , rbirthday, raddress, remail, rtelephone));
                System.out.println("[+] "+doctorID+"\t"+family_name+"\t"+first_name+"\t");
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

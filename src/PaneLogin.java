import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PaneLogin {

    @FXML
    private TextField in_name;

    @FXML
    private TextField in_port;

    @FXML
    private TextField in_password;

    @FXML
    private TextField in_host;

    private String port = "";

    private String host = "";

    private String name = "";

    private String password = "";

    private boolean connected = false;

    public void start_session(){
        name = in_name.getText();
        host = in_host.getText();
        port = in_port.getText();
        password = in_password.getText();
        System.out.println("Start Session with credentials: " + host + ":" + port + " " + name + " " + password);
        connected = GUI_controller.ioManager.connectToMysql("host=" + host + ",port="+ port + ",serverTimezone=UTC,useSSL=false,verifyServerCertificate=true,allowPublicKeyRetrieval=true", "mydb", name, password);
        if(!connected){
            System.out.println("[-] Could not establish connection");
            connected = false;
        } else {
            System.out.println("[+] Connected to MySQL DB");
            connected = true;
        }
    }

}

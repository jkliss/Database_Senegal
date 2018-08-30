import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Window;
import sun.awt.WindowIDProvider;

import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI_controller {
    @FXML
    private Button wbutton;

    @FXML
    private Label left_status;


    public void pushedLowerButton(javafx.event.ActionEvent actionEvent) {
        Window owner = wbutton.getScene().getWindow();
        left_status.setText("SET NAME TO ");
    }
}
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GUI_design.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);

        primaryStage.setTitle("Base de données des médecins");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
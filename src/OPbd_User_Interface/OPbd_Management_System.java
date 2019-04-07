package OPbd_User_Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SinaM
 */
public class OPbd_Management_System extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        
        Scene scene = new Scene(root);
        
        String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("OPbd Management System");
        stage.setMaximized(true);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

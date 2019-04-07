/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPbd_User_Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class ViewAllController implements Initializable {

    @FXML private javafx.scene.image.ImageView logo, adding, editing, deleting;
    @FXML private TableView dataTable;
    @FXML private TableColumn columnIndex, columnTitle, columnGenre, columnRelease, columnPublisher, columnDeveloper, columnESRB, columnRating;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logo.setOnMouseClicked((MouseEvent clickLogo) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = (Stage) logo.getScene().getWindow();
                stage.setScene(new Scene(root));

                stage.setTitle("OPbd Management System");
                stage.setMaximized(true);

                String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
                root.getStylesheets().add(css);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //----------Adding Page Pop-Up----------\\
        adding.setOnMouseClicked(new EventHandler<MouseEvent>() { // Anonymous EventHandler
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Adding.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initStyle(StageStyle.DECORATED);
                    stage.setScene(new Scene(root));

                    stage.setTitle("OPbd Management System");
                    stage.setResizable(false);
                    String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
                    root.getStylesheets().add(css);

                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //----------Deleting Page Pop-Up----------\\
        deleting.setOnMouseClicked((MouseEvent event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Deleting.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setScene(new Scene(root));

                stage.setTitle("OPbd Management System");
                stage.setResizable(false);
                String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
                root.getStylesheets().add(css);

                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        editing.setOnMouseClicked((MouseEvent event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editing.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setScene(new Scene(root));

                stage.setTitle("OPbd Management System");
                stage.setResizable(false);
                String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
                root.getStylesheets().add(css);

                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
}

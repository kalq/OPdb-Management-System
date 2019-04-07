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
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.*;

/**
 *
 * @author SinaM
 */
public class HomeController implements Initializable {

    @FXML
    private Rectangle newGame, oldGame;
    @FXML
    private ImageView viewing, adding, editing, deleting;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxStyles();
        homePage_events();

    }

    public void fxStyles() {
        //-----------Setting Rectangle Styles------------//
        newGame.setFill(Color.TRANSPARENT);
        newGame.setStroke(Color.rgb(0, 255, 20));
        newGame.setStrokeWidth(3);
        oldGame.setFill(Color.TRANSPARENT);
        oldGame.setStroke(Color.rgb(0, 255, 20));
        oldGame.setStrokeWidth(3);
    }

    //----------This method contains all of the home page events-----------\\
    public void homePage_events() {
        //---------For View Mode Page------------\\
        viewing.setOnMouseClicked((MouseEvent event) -> { // Lambda Expression
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAll.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = (Stage) viewing.getScene().getWindow();
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

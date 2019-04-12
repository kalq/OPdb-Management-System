/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPbd_User_Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.*;
import poojas.angels.*;

/**
 *
 * @author SinaM
 */
public class HomeController implements Initializable {

    @FXML
    private ImageView adding, editing, deleting;
    @FXML
    private TableView dataTable;
    @FXML
    private TableColumn columnIndex, columnPlatform, columnTitle, columnGenre, columnRelease, columnPublisher, columnDeveloper, columnESRB, columnRating;

    /**
     * @method fillTable() creates the items using FXCollections, and targets
     * all of the columns in the home page
     */
    private void fillTable() {
        ArrayList<VideoGame> games = new ArrayList<>(FileManager.getGameList().getGames());
        ObservableList<VideoGame> g = FXCollections.observableList(games);
        columnIndex.setCellValueFactory(new PropertyValueFactory<>("index"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        columnRelease.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        columnDeveloper.setCellValueFactory(new PropertyValueFactory<>("developer"));
        columnPlatform.setCellValueFactory(new PropertyValueFactory<>("platform"));
        columnESRB.setCellValueFactory(new PropertyValueFactory<>("esrb"));
        columnRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        dataTable.setItems(g);

    }

    @FXML
    private void refreshPage(ActionEvent event) {
        FileManager.readDatabase();
        fillTable();
        FileManager.resetIndex();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            homePage_events();
            
            FileManager.readDatabase();
            fillTable();
    }

    /**
     * @method This method contains all Mouse-Click EventHandlers for Adding,
     * Editing and Deleting ImageViews
     */
    public void homePage_events() {

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

        //Editing page pop-up
        editing.setOnMouseClicked((MouseEvent event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/multipleEditFXML/Editing.fxml"));
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

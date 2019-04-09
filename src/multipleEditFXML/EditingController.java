/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleEditFXML;

import OPbd_User_Interface.OPbd_Management_System;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class EditingController implements Initializable {

    @FXML
    private Button btnCancel, btnEdit;
    @FXML
    private ChoiceBox choiceEdit;

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    /**
     * @method editAction() uses a switch statement to check the string of what
     * users selected in the ChoiceBox options, and if the string matches the
     * case condition, it will load to that specific FXML page for editing their
     * chosen field.
     * 
     * @throws IOException
     */
    @FXML
    private void editAction() throws IOException {
        final String CSS = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
        final Stage CHANGE = (Stage) btnEdit.getScene().getWindow(); //Grabs the Editing.fxml window
        FXMLLoader fxmlLoader;
        //This switch statement checks to see what choice the user has made
        switch (choiceEdit.getSelectionModel().getSelectedItem().toString()) {
            //if the user's choice is equal to Title, go to EditTitle.fxml page
            case "Title":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditTitle.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "Genre":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditGenre.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "Publisher":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditPublisher.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "Platform":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditPlatform.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "Developer":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditDeveloper.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "Release":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditRelease.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "ESRB":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditESRB.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
            case "Rating":
                fxmlLoader = new FXMLLoader(getClass().getResource("EditRating.fxml"));
                root = (Parent) fxmlLoader.load();
                CHANGE.setScene(new Scene(root));
                CHANGE.setTitle("OPbd Management System");
                root.getStylesheets().add(CSS);
                CHANGE.show();
                break;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

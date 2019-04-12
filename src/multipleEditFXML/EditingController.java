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
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import poojas.angels.FileManager;

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
    private TextField txtSelectIndex;

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
     * @note: We have multiple controllers for all the editing pages because the
     * Objects we created in FXML documents could not be passed to a single
     * controller without Exceptions.
     *
     * @throws IOException
     */
    @FXML
    private void editAction() throws IOException {

        //-----Index Exception Handling------\\
        try {
            if (Integer.parseInt(txtSelectIndex.getText()) > FileManager.testIndex() || Integer.parseInt(txtSelectIndex.getText()) == 0) {
                throw new RuntimeException();
            }

            final String CSS = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
            final Stage CHANGE = (Stage) btnEdit.getScene().getWindow(); //Grabs the Editing.fxml window
            FXMLLoader fxmlLoader;
            //This switch statement checks to see what choice the user has made
            switch (choiceEdit.getSelectionModel().getSelectedItem().toString()) {
                //if the user's choice is equal to Title, go to EditTitle.fxml page
                case "Title":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditTitle.fxml"));
                    Parent root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Title page
                    EditTitleController indexTitle = fxmlLoader.getController();
                    indexTitle.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "Genre":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditGenre.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Genre page
                    EditGenreController indexGenre = fxmlLoader.getController();
                    indexGenre.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "Publisher":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditPublisher.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Publisher page
                    EditPublisherController indexPublisher = fxmlLoader.getController();
                    indexPublisher.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "Platform":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditPlatform.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Platform page
                    EditPlatformController indexPlatform = fxmlLoader.getController();
                    indexPlatform.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "Developer":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditDeveloper.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Developer page
                    EditDeveloperController indexDeveloper = fxmlLoader.getController();
                    indexDeveloper.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "Release":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditRelease.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Release page
                    EditReleaseController indexRelease = fxmlLoader.getController();
                    indexRelease.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "ESRB":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditESRB.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit ESRB page
                    EditESRBController indexESRB = fxmlLoader.getController();
                    indexESRB.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
                case "Rating":
                    fxmlLoader = new FXMLLoader(getClass().getResource("EditRating.fxml"));
                    root = (Parent) fxmlLoader.load();

                    // Pass index to Edit Title page
                    EditRatingController indexRate = fxmlLoader.getController();
                    indexRate.transferIndex(txtSelectIndex.getText());

                    CHANGE.setScene(new Scene(root));
                    CHANGE.setTitle("OPbd Management System");
                    root.getStylesheets().add(CSS);
                    CHANGE.show();
                    break;
            }
        } catch (NumberFormatException NaN) {
            //The only case where this happens is if the user doesn't enter anything in the TextField.
            Alert myAlert = new Alert(Alert.AlertType.ERROR);
            myAlert.setTitle("Error: NumberFormatException");
            myAlert.setContentText("Your input is not number! You must enter a number for the specified index.");
            myAlert.showAndWait();
        } catch (RuntimeException zero) { //The index in OPdb cannot be zero and can't be higher than testIndex() method return value.
            Alert myAlert = new Alert(Alert.AlertType.ERROR);
            myAlert.setTitle("Error: Non-Existent");
            myAlert.setContentText("The index you entered does not exist in our records.");
            myAlert.showAndWait();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //For limiting the index value to only two characters and numbers only
        txtSelectIndex.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[0-9]{0,2}$")) {
                txtSelectIndex.setText(oldValue);
            }
        });
    }

}

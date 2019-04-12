/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPbd_User_Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import poojas.angels.FileManager;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class DeletingController implements Initializable {

    @FXML
    private TextField txtSelectIndex;
    @FXML
    private Button btnCancel, btnDelete;

    /**
     * @method cancelAction() is for closing the window if the user wants to
     * cancel what they're doing.
     */
    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    /**
     * @method deleteAction() in DeletingController creates a pop-up FXML page
     * for confirmation
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void deleteAction(ActionEvent event) throws IOException {
        try {
            if(Integer.parseInt(txtSelectIndex.getText()) > FileManager.testIndex() || Integer.parseInt(txtSelectIndex.getText()) == 0){
                throw new RuntimeException();
            }
            

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConfirmDelete.fxml"));
            Parent root = (Parent) fxmlLoader.load();

            // Pass index to confirm page
            ConfirmDeleteController confirmDeleteController = fxmlLoader.getController();
            confirmDeleteController.setIndex(txtSelectIndex.getText());

            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root));

            stage.setTitle("OPbd Management System");
            stage.setResizable(false);
            String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
            root.getStylesheets().add(css);

            stage.show();
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

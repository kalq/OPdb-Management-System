/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleEditFXML;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import poojas.angels.FileManager;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class EditTitleController implements Initializable {

    @FXML
    private Label lblIndex;
    @FXML
    private TextField txtGameName;
    @FXML
    private Button btnCancel, btnEdit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //For limiting the Publisher limit to only 20 characters to be typed
        txtGameName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[ a-zA-Z0-9]{0,20}$")) { //Only Letters up to 20 characters
                txtGameName.setText(oldValue);
            }
        });
        
    }

    /**
     * @method cancelAction() closes window of program if user clicks cancel
     * button
     */
    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    /**
     * @method comfirmAction() in EditTitleController changes the Game Title of
     * specified index
     *
     * @param event
     */
    @FXML
    private void confirmAction(ActionEvent event) throws FileNotFoundException, IOException {
        
        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "name", txtGameName.getText());
        FileManager.resetIndex();
        
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        
    }

    //Collects selected index from Edit choosing page
    public void transferIndex(String index) {

        lblIndex.setText(index);

    }

}

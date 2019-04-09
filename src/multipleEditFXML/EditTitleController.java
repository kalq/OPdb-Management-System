/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleEditFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        // TODO
    }    
    /**
     * @method cancelAction() closes window of program if user clicks cancel button
     */
    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }
    
    /**
     * @method comfirmAction() in EditTitleController changes the Game Title of specified index
     * 
     * @param event 
     */
    @FXML
    private void confirmAction(ActionEvent event) {
        
    }
    
}

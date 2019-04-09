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
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class EditPlatformController implements Initializable {

    @FXML
    private ComboBox cmbPlatform;
    @FXML
    private Button btnCancel, btnEdit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ComboBox Platform items
        cmbPlatform.getItems().addAll(
                "Nintendo 64",
                "GameCube",
                "Wii",
                "Wii U",
                "Switch",
                "Playstation",
                "Playstation 2",
                "Playstation 3",
                "Playstation 4",
                "Xbox",
                "Xbox 360",
                "Xbox One",
                "Windows",
                "MacOS",
                "Linux"
                
        );
    }    

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    @FXML
    private void confirmAction(ActionEvent event) {
    }
    
}

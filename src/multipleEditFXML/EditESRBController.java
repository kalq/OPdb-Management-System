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
public class EditESRBController implements Initializable {

    @FXML
    private Button btnCancel, btnEdit;
    @FXML
    private ComboBox cmbRating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbRating.getItems().addAll(
                "Preschool",
                "Everyone",
                "10+",
                "13+",
                "17+",
                "18+"
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

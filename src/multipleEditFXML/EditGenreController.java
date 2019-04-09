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
public class EditGenreController implements Initializable {

    @FXML
    private Button btnCancel, btnEdit;
    @FXML
    private ComboBox cmbGenre;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbGenre.getItems().addAll(
                "Action & Adventure",
                "Role-Playing Game",
                "Massive Online Multiplayer",
                "First-Person Shooter",
                "Indie Game"
        );
    }    

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the EditGenre.fxml window
        stage.close();
    }

    @FXML
    private void confirmAction(ActionEvent event) {
    }
    
}

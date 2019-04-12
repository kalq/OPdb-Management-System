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
import poojas.angels.FileManager;

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
    @FXML
    private Label lblIndex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbGenre.getItems().addAll(
                "Action",
                "RPG",
                "MMO",
                "Shooter",
                "Indie"
        );
    }

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the EditGenre.fxml window
        stage.close();
    }
    
    /**
     * @method confirmAction() uses the editRecord method from FileManager class
     * to make changes after they confirm the edit.
     * @param event
     */
    @FXML
    private void confirmAction(ActionEvent event) {

        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "genre", cmbGenre.getSelectionModel().getSelectedItem().toString());
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void transferIndex(String index) {
        lblIndex.setText(index);
    }
}

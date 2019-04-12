/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleEditFXML;

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
public class EditPublisherController implements Initializable {

    @FXML
    private TextField txtSelectIndex;
    @FXML
    private Label lblWhichCat, lblIndex;
    @FXML
    private Button btnCancel, btnEdit;
    @FXML
    TextField txtPublisher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //For limiting the Title limit to only 20 characters to be typed
        txtPublisher.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[a-zA-Z]{0,20}$")) {
                txtPublisher.setText(oldValue);
            }
        });
    }

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    @FXML
    private void confirmAction(ActionEvent event) {
        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "publisher", txtPublisher.getText());
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void transferIndex(String index) {
        lblIndex.setText(index);
    }

}

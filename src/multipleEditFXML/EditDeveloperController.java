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
public class EditDeveloperController implements Initializable {

    @FXML
    private Button btnCancel, btnEdit;
    @FXML
    private Label lblIndex;
    @FXML
    private TextField txtDeveloper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //For limiting the Developer limit to only 20 characters to be typed
        txtDeveloper.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[a-zA-Z]{0,20}$")) {
                txtDeveloper.setText(oldValue);
            }
        });
    }    

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); 
        stage.close();
    }

    @FXML
    private void confirmAction(ActionEvent event) {
        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "developer", txtDeveloper.getText()); //FileManager method does the work
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferIndex(String index) {
        lblIndex.setText(index);
    }
    
}

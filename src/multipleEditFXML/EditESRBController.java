package multipleEditFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.stage.Stage;
import poojas.angels.ESRB;
import poojas.angels.FileManager;

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
    @FXML
    private Label lblIndex;

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
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    /**
     * @method confirmAction() uses the editRecord method from FileManager class
     * to make changes after they confirm the edit.
     * @param event
     */
    @FXML
    private void confirmAction(ActionEvent event) {
        ESRB esrb = null;
        for(ESRB value : ESRB.values()) {
            if(value.getAgeRange().equalsIgnoreCase(cmbRating.getSelectionModel().getSelectedItem().toString()))
                esrb = value;
        }
        
        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "esrb", esrb.toString());
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferIndex(String index) {
        lblIndex.setText(index);
    }
}

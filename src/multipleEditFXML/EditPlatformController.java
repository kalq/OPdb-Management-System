package multipleEditFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import poojas.angels.FileManager;
import poojas.angels.Platform;

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
    @FXML
    private Label lblIndex;

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
    
    /**
     * @method confirmAction() uses the editRecord method from FileManager class
     * to make changes after they confirm the edit.
     * @param event
     */
    @FXML
    private void confirmAction(ActionEvent event) {
        Platform platform = null;
        for(Platform value : Platform.values()) {
            if(value.getName().equalsIgnoreCase(cmbPlatform.getSelectionModel().getSelectedItem().toString()))
                platform = value;
        }
        
        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "platform", platform.toString());
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferIndex(String index) {
        lblIndex.setText(index);
    }
    
}

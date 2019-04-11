package OPbd_User_Interface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import poojas.angels.FileManager;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class ConfirmDeleteController implements Initializable {

    @FXML private Label lblIndex;
    @FXML private Button btnCancel, btnDelete;
    
    @FXML
    private void cancelAction(){
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }
    /**
     * @method deleteAction in ConfirmDeleteController sets the fixed string of that record to null and changes indexes
     */
    @FXML
    private void deleteAction(){
        FileManager.deleteRecord(Integer.parseInt(lblIndex.getText()) - 1);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void transferIndex(String index) {
        lblIndex.setText(index);
    }
}

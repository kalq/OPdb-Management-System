/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPbd_User_Interface;

import java.net.URL;
import java.util.ResourceBundle;
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
public class DeletingController implements Initializable {

    @FXML
    private Label lblSelect;
    @FXML
    private Label lblSelectIndex;
    @FXML
    private TextField txtSelectIndex;
    @FXML
    private Label lblSearchBy;
    @FXML
    private Label lblSelectTitle;
    @FXML
    private TextField txtSelectTitle;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnDelete;

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

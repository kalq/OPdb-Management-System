/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPbd_User_Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class EditingController implements Initializable {

    @FXML
    private Button btnCancel, btnEdit;

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    //Editing Event
    @FXML
    private void editAction() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAll.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = (Stage) btnEdit.getScene().getWindow(); //Grabs the Deleting.fxml window
//        stage.setScene
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

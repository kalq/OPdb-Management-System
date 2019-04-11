/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPbd_User_Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class DeletingController implements Initializable {

    @FXML
    private TextField txtSelectIndex, txtSelectTitle;
    @FXML
    private Button btnCancel, btnDelete;

    /**
     * @method cancelAction() is for closing the window if the user wants to
     * cancel what they're doing.
     */
    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Deleting.fxml window
        stage.close();
    }

    /**
     * @method deleteAction() in DeletingController creates a pop-up FXML page for confirmation
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void deleteAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConfirmDelete.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        
        // Pass index to confirm page
        ConfirmDeleteController confirmDeleteController = fxmlLoader.getController();
        confirmDeleteController.transferIndex(txtSelectIndex.getText());
        
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(new Scene(root));

        stage.setTitle("OPbd Management System");
        stage.setResizable(false);
        String css = OPbd_Management_System.class.getResource("OPbd.css").toExternalForm();
        root.getStylesheets().add(css);

        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

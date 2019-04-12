package multipleEditFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import poojas.angels.FileManager;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class EditRatingController implements Initializable {

    @FXML
    private Label lblIndex, lblGameRate, lblCount;
    @FXML
    private Slider sliderGameRate;
    @FXML
    private Button btnCancel, btnEdit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //For showing integer value of slider
        sliderGameRate.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) { //Requires 3 arguments for ChangeListener to work
                lblCount.textProperty().setValue(
                        String.valueOf((int) sliderGameRate.getValue()));
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
        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "rating", lblCount.getText());
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    public void transferIndex(String index) {
        lblIndex.setText(index);
    }
    
}

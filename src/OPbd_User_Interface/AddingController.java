package OPbd_User_Interface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class AddingController implements Initializable {

    @FXML
    private Label lblCount;
    @FXML
    private Slider sliderGameRate;
    @FXML
    private ComboBox cmbRating;
    @FXML
    private DatePicker releaseDate;

    @FXML
    private javafx.scene.control.Button btnCancel;

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Adding.fxml window
        stage.close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
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

        cmbRating.getItems().addAll(
                "s@example.com",
                "i@example.com",
                "e@example.com",
                "m@example.com"
        );
    }

}

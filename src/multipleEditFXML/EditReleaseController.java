package multipleEditFXML;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import poojas.angels.FileManager;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class EditReleaseController implements Initializable {

    @FXML
    private DatePicker releaseDate;
    @FXML
    private Button btnCancel, btnEdit;
    @FXML
    private Label lblIndex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void confirmAction(ActionEvent event) throws FileNotFoundException, IOException {

        FileManager.editRecord(Integer.parseInt(lblIndex.getText()), "date", dateToString(releaseDate));
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();

    }

    public void transferIndex(String index) {
        lblIndex.setText(index);
    }

    public String dateToString(DatePicker date) {
        String pattern = "dd/MM/yyyy";
        return date.getValue().format(DateTimeFormatter.ofPattern(pattern));
    }
}

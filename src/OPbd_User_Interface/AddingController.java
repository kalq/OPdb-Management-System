package OPbd_User_Interface;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import poojas.angels.*;

/**
 * FXML Controller class
 *
 * @author SinaM
 */
public class AddingController implements Initializable {

    @FXML
    private Label lblCount; //TODO --> extract Slider number for file writing
    @FXML
    private Slider sliderGameRate; //This is just the slider, must extract lblCount number
    @FXML
    private ComboBox cmbRating, cmbGenre, cmbPlatform; //TODO --> extract dropbox for file writing
    @FXML
    private DatePicker releaseDate; //TODO --> extract date as string for records
    @FXML
    private TextField txtGameName, txtPublisher, txtDeveloper;
    @FXML
    private Button btnCancel, btnAdd;

    @FXML
    private void addAction() throws IOException {
        
        ESRB esrb = null;
        for(ESRB value : ESRB.values()) {
            if(value.getAgeRange().equalsIgnoreCase(cmbRating.getSelectionModel().getSelectedItem().toString()))
                esrb = value;
        }
        
        Platform platform = null;
        for(Platform value : Platform.values()) {
            if(value.getName().equalsIgnoreCase(cmbPlatform.getSelectionModel().getSelectedItem().toString()))
                platform = value;
        }
        
        FileManager.getGameList().addGame(
                new VideoGame(txtGameName.getText(),cmbGenre.getSelectionModel().getSelectedItem().toString(),
                        dateToString(releaseDate), Integer.parseInt(lblCount.getText()),
                        esrb,
                        platform,
                        txtPublisher.getText(), txtDeveloper.getText()));
        
        
        FileManager.writeRecord(txtGameName.getText(),cmbGenre.getSelectionModel().getSelectedItem().toString(),
                        dateToString(releaseDate), lblCount.getText(),
                        cmbRating.getSelectionModel().getSelectedItem().toString(),
                        cmbPlatform.getSelectionModel().getSelectedItem().toString(),
                        txtPublisher.getText(), txtDeveloper.getText());

        Stage stage = (Stage) btnAdd.getScene().getWindow(); //Grabs the Adding.fxml window
        stage.close(); //Closes FXML page
    }

    @FXML
    private void cancelAction() {
        Stage stage = (Stage) btnCancel.getScene().getWindow(); //Grabs the Adding.fxml window
        stage.close(); //Closes FXML page
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //For showing integer value of slider, there must be an event listener. Otherwise it's a large double number by default.
        sliderGameRate.valueProperty().addListener(new ChangeListener() { //Anonymous Event using ChangeListener class
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) { //Requires 3 arguments for ChangeListener to work
                lblCount.textProperty().setValue(String.valueOf((int) sliderGameRate.getValue()));
            }
        });

        //ComboBox ESRB items
        cmbRating.getItems().addAll(
                "Preschool",
                "Everyone",
                "10+",
                "13+",
                "17+",
                "18+"
        );
        //ComboBox Genre items
        cmbGenre.getItems().addAll(
                "Action & Adventure",
                "Role-Playing Game",
                "Massive Online Multiplayer",
                "First-Person Shooter",
                "Indie Game"
        );
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
        /*FXCollections wouldn't let me use fx:factory multiple times for ComboBox items, 
            so they must be in initialize method.*/
    }

    public String dateToString(DatePicker date) {
        String pattern = "dd/MM/yyyy";
        return date.getValue().format(DateTimeFormatter.ofPattern(pattern));
    }
}

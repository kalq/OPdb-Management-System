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
    private Label lblCount, lblIndex;
    @FXML
    private Slider sliderGameRate; //This is just the slider, must extract lblCount number
    @FXML
    private ComboBox cmbRating, cmbGenre, cmbPlatform;
    @FXML
    private DatePicker releaseDate;
    @FXML
    private TextField txtGameName, txtPublisher, txtDeveloper;
    @FXML
    private Button btnCancel, btnAdd;

    /**
     * @method addAction() is for checking and validating the new data entered
     * before writing it in fixed record size.
     * @throws IOException
     */
    @FXML
    private void addAction() throws IOException {

        //-------Data Validation Section--------\\
        try { //Any errors in this try block will be caught and an error message will pop up

            if (txtGameName.getText().equals("") || txtPublisher.getText().equals("") || txtDeveloper.getText().equals("")) {
                throw new Exception(); //Because these text fields are empty
            }

            //Validates ESRB value that was entered
            ESRB esrb = null;
            for (ESRB value : ESRB.values()) {
                if (value.getAgeRange().equalsIgnoreCase(cmbRating.getSelectionModel().getSelectedItem().toString())) {
                    esrb = value;
                }
            }
            
            //Validates Platform value entered
            Platform platform = null;
            for (Platform value : Platform.values()) {
                if (value.getName().equalsIgnoreCase(cmbPlatform.getSelectionModel().getSelectedItem().toString())) {
                    platform = value;
                }
            }
            
            //Adds a new VideoGame object to the game list in FileManager
            FileManager.getGameList().addGame(
                    new VideoGame(txtGameName.getText(), cmbGenre.getSelectionModel().getSelectedItem().toString(),
                            dateToString(releaseDate), Integer.parseInt(lblCount.getText()),
                            esrb,
                            platform,
                            txtPublisher.getText(), txtDeveloper.getText()));
            
            //Writes all the new data entered in the file.
            FileManager.writeRecord(txtGameName.getText(), cmbGenre.getSelectionModel().getSelectedItem().toString(),
                    dateToString(releaseDate), lblCount.getText(),
                    esrb.toString(),
                    platform.toString(),
                    txtPublisher.getText(), txtDeveloper.getText());

            FileManager.resetIndex();

            Stage stage = (Stage) btnAdd.getScene().getWindow(); //Grabs the Adding.fxml window
            stage.close(); //Closes FXML page
        } catch (Exception e) { //The only case where this won't work is if a form option wasn't filled.
            Alert myAlert = new Alert(Alert.AlertType.ERROR);
            myAlert.setTitle("Error: Empty Field(s)");
            myAlert.setContentText("Please make sure to fill in all form fields before adding them to OPdb's records.");
            myAlert.showAndWait();
        }
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
        releaseDate.setEditable(false); //User can only select date, not type in textfield
        //For showing integer value of slider, there must be an event listener. Otherwise it's a large double number by default.
        sliderGameRate.valueProperty().addListener(new ChangeListener() { //Anonymous Event using ChangeListener class
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) { //Requires 3 arguments for ChangeListener to work
                lblCount.textProperty().setValue(String.valueOf((int) sliderGameRate.getValue()));
            }
        });

        //For limiting the Publisher limit to only 20 characters to be typed
        txtGameName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[ a-zA-Z0-9]{0,20}$")) { //Only Letters up to 20 characters
                txtGameName.setText(oldValue);
            }
        });
        //For limiting the Title limit to only 20 characters to be typed
        txtPublisher.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[a-zA-Z]{0,20}$")) {
                txtPublisher.setText(oldValue);
            }
        });
        //For limiting the Developer limit to only 20 characters to be typed
        txtDeveloper.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("^[a-zA-Z]{0,20}$")) {
                txtDeveloper.setText(oldValue);
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
                "Action",
                "RPG",
                "MMO",
                "Shooter",
                "Indie"
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

    /**
     * @method dateToString() converts DatePicker object's value to a string
     * @param date
     * @return
     */
    public String dateToString(DatePicker date) {
        String pattern = "dd/MM/yyyy";
        return date.getValue().format(DateTimeFormatter.ofPattern(pattern));
    }
}

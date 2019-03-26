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
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;

/**
 *
 * @author SinaM
 */
public class FXMLDocumentController implements Initializable {
    @FXML private Rectangle newGame, oldGame, archive;
    @FXML private Label lblNewest, lblOldest;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //-----------Setting Rectangle Style------------//
        newGame.setFill(Color.TRANSPARENT);
        newGame.setStroke(Color.rgb(0, 255, 20));
        newGame.setStrokeWidth(3);
        oldGame.setFill(Color.TRANSPARENT);
        oldGame.setStroke(Color.rgb(0, 255, 20));
        oldGame.setStrokeWidth(3);
        archive.setFill(Color.TRANSPARENT);
        archive.setStroke(Color.rgb(0, 255, 20));
        archive.setStrokeWidth(3);
        
        //-----------Setting Label Properties----------//
        lblNewest.setTextFill(Color.rgb(0, 255, 20));
        lblOldest.setTextFill(Color.rgb(0, 255, 20));
    }
    
}

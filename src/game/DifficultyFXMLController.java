/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class DifficultyFXMLController implements Initializable {

    @FXML
    private Button hardId;
    @FXML
    private Button easyId;
    @FXML
    private Button backBtn;
 @FXML
    private AnchorPane difficultyPane;
    public static boolean isDifficult;
    @FXML
    private Button hardId1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * choose hard game 
     *
     * @param event
     */
    @FXML
    private void chooseHard(ActionEvent event) {
        isDifficult=true;
          try {
            Pane main = FXMLLoader.load(getClass().getResource("OnePlayerFXML.fxml"));
            difficultyPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    /**
     * choose easy game
     *
     * @param event
     */
    @FXML
    private void chooseEasy(ActionEvent event) {
        isDifficult=false;
          try {
            Pane main = FXMLLoader.load(getClass().getResource("OnePlayerFXML.fxml"));
            difficultyPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    /**
     *  to go to menu
     *
     * @param event
     */
    @FXML
    private void goToMainMenu(ActionEvent event) {
        
        try {
            Pane main = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
            difficultyPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

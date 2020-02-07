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
public class MainXMLController implements Initializable {

    @FXML
    private Button onePlayerBtn;
    @FXML
    private Button onlineBtn;
    @FXML
    private Button twoPlayerBtn;

    @FXML
    private Pane AnchorPane;
    @FXML
    private Button replays;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    /**
     * Redirect to AI screen
     *
     * @param event
     */
    @FXML
    private void goToAIScene(ActionEvent event) {
        try {
            Pane main = FXMLLoader.load(getClass().getResource("DifficultyFXML.fxml"));
            AnchorPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     /**
     * Redirect to friend vs friend screen
     *
     * @param event
     */
    @FXML
    private void goToTowPlayerScene(ActionEvent event) {
        try {
            Pane main = FXMLLoader.load(getClass().getResource("TwoPlayerFXML.fxml"));
            AnchorPane.getChildren().setAll(main);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     /**
     * Redirect to Login screen
     *
     * @param event
     */

    @FXML
    private void goToLogin(ActionEvent event) {

        try {
            Pane main = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            AnchorPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     /**
     * Redirect to saved vedios 
     *
     * @param event
     */
    @FXML
    private void goToList(ActionEvent event) {
         try {
            Pane main = FXMLLoader.load(getClass().getResource("Replays.fxml"));
            AnchorPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

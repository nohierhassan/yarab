/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;




import static game.LoginFXMLController.userName;

import java.io.IOException;
import java.net.URL;

import java.rmi.RemoteException;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;


/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class OnlineRoomFXMLController implements Initializable {

    @FXML
    private AnchorPane roomPane;
    @FXML
    private ListView<String> playersListView;
    @FXML
    private Button playBtn;

   // public static RemoteServer server;
    private Registry reg;
    private String currentUsername;

    //public static ClientImpl player;
    public static String opnent1;
    public static String opnent2;
    public static boolean isFirstPlayer;
    @FXML
    private Label playerName;
    @FXML
    private Label score;

    ArrayList<String> users;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

                    currentUsername = userName;

         /*try {
            // TODO
            reg = LocateRegistry.getRegistry("172.16.5.220", 6000);
           try {
                server = (RemoteServer) reg.lookup("service");
            } catch (NotBoundException ex) {
                ex.printStackTrace();
            } catch (AccessException ex) {
                ex.printStackTrace();
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }*/

//        try {
//            player = new ClientImpl(this);
//            server.addUsername(currentUsername, player);
//
//            users = server.getAllUsers(currentUsername);
//            for (String user : users) {
//                playersListView.getItems().add(user);
//            }
//        } catch (RemoteException ex) {
//            ex.printStackTrace();
//        }

//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                closeWindow();
//            }
//        });
    }

    /**
     * to close Window
     */
//    public void closeWindow() {
//        try {
//            server.closeRoom(currentUsername);
//        } catch (RemoteException ex) {
//            ex.printStackTrace();
//        }
//    }

     /**
     * when select name from list , show its score
           * @param event
     */
    @FXML
    private void selectItem(MouseEvent event) {
        if (playersListView.getSelectionModel().getSelectedItem() != null) {
            playerName.setText("name : " + String.valueOf(playersListView.getSelectionModel().getSelectedItem()));
//            ClientDAO clientdtat = new ClientDAO();
//            Client player = clientdtat.retrieve(playersListView.getSelectionModel().getSelectedItem());
            //score.setText("Score : " + String.valueOf(player.getScore()));
        } else {
            playerName.setText("");
            score.setText("");
        }
    }

     /**
     * send request to player 
           * @param event
     */
//    @FXML
//    private void gameButton(ActionEvent event) {
//        try {
//            if (playersListView.getSelectionModel().getSelectedItem() != null) {
//                // send to server and server will send to another client 
//                server.request(currentUsername, playersListView.getSelectionModel().getSelectedItem());
//            }
//        } catch (RemoteException e1) {
//            e1.printStackTrace();
//        }
//
//    }

     /**
     * add player to list view
           * @param username
     */
    public void addUserToMenu(String username) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                playersListView.getItems().add(username);
            }
        });
    }

       /**
     * remove player to list view
           * @param username
     */
    public void removeUserFromMenu(String username) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                playersListView.getItems().remove(username);
            }
        });
    }

      /**
     * get Current UserName
     */
    public String getCurrentUserName() {
        return currentUsername;
    }

     /**
     * get Current UserName
               * @param username

     */
    public void checkRequest(String username) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText(" Game Invitation");
                alert.setContentText("Are you ok with this?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    // ... user chose OK
//                    try {
//                        server.requestStatus(username, currentUsername, true);
//                    } catch (RemoteException ex) {
//                        ex.printStackTrace();
//                    }
                } else {
                    // ... user chose CANCEL or closed the dialog
//                    try {
//                        server.requestStatus(username, currentUsername, false);
//                    } catch (RemoteException ex) {
//                        ex.printStackTrace();
//                    }
                }
            }
        });

    }

     /**
     * when deny the request 
     *
     */
    public void requestDenied() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Deny ");
                alert.setHeaderText("Opnent deny your request");
                alert.setContentText("Opnent deny your request");
                alert.showAndWait();
            }
        });

    }

    /**
     * when deny the request 
                * @param player1
           * @param player2
           * @param turn

     */
    public void openGame(String player1, String player2, boolean turn) {
        opnent1 = player1;
        opnent2 = player2;
        isFirstPlayer = turn;

        System.out.println("start game");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Pane main = FXMLLoader.load(getClass().getResource("OnlineGameFXML.fxml"));
                    roomPane.getChildren().setAll(main);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

      /**
     * when deny the request 
                * @param event
     */
    @FXML
    private void backToMain(ActionEvent event) {
//        try {
//            server.closeRoom(currentUsername);
//        } catch (RemoteException ex) {
//            ex.printStackTrace();
//        }
         try {
                    Pane main = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
                    roomPane.getChildren().setAll(main);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }

}

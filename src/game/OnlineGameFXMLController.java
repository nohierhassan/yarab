/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import com.teamdev.jxcapture.Codec;
import com.teamdev.jxcapture.EncodingParameters;
import com.teamdev.jxcapture.VideoCapture;
import com.teamdev.jxcapture.video.Desktop;
import static game.Game.primaryStage;

import static game.OnlineRoomFXMLController.isFirstPlayer;
import static game.OnlineRoomFXMLController.opnent1;
import static game.OnlineRoomFXMLController.opnent2;


import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class OnlineGameFXMLController implements Initializable {

    // media 
    private boolean isFirst = true;
    private static int loc;
    private Boolean place1 = true, place2 = true, place3 = true,
            place4 = true, place5 = true, place6 = true,
            place7 = true, place8 = true, place9 = true, stopPress = true;
    private ArrayList<Integer> resultat1, resultat2;
    // Every possibilities of winning
    private ArrayList<Integer> win1, win2, win3, win4,
            win5, win6, win7, win8;
    private int player1Score, player2Score, tieScore;
    private VideoCapture videoCapture;

    // Stores if someone won or tied
    private Boolean win = false, tie = false, turn = true;
    // mvement num 
    private int movement = 1;

    private boolean isFirstPlayerWin, isSecondPlayerWin;
    @FXML
    private AnchorPane GamePane;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button backBtn;
    @FXML
    private Button resetBtn;
    @FXML
    private Label firstPlayerScore;
    @FXML
    private Label secondPlayerScore;
    @FXML
    private Label firstPlayerName;
    @FXML
    private Label secondPlayerName;
    @FXML
    private Button recordBtn;
    @FXML
    private Button stopBtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        resultat1 = new ArrayList<Integer>();
        resultat2 = new ArrayList<Integer>();
        // Defines every possibilities of winning
        win1 = new ArrayList<Integer>();
        win2 = new ArrayList<Integer>();
        win3 = new ArrayList<Integer>();
        win4 = new ArrayList<Integer>();
        win5 = new ArrayList<Integer>();
        win6 = new ArrayList<Integer>();
        win7 = new ArrayList<Integer>();
        win8 = new ArrayList<Integer>();

        win1.add(1);
        win1.add(2);
        win1.add(3);
        win2.add(4);
        win2.add(5);
        win2.add(6);
        win3.add(7);
        win3.add(8);
        win3.add(9);
        win4.add(1);
        win4.add(4);
        win4.add(7);
        win5.add(2);
        win5.add(5);
        win5.add(8);
        win6.add(3);
        win6.add(6);
        win6.add(9);
        win7.add(1);
        win7.add(5);
        win7.add(9);
        win8.add(3);
        win8.add(5);
        win8.add(7);

        firstPlayerName.setText(opnent1);
        secondPlayerName.setText(opnent2);

        
        
        isFirst = isFirstPlayer;
        turn = isFirstPlayer;

//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                closeWindow();
//            }
//        });

    }

   // public void closeWindow() {
      //  try {
         //   server.closeGame(opnent2);
       // } catch (RemoteException ex) {
       //     ex.printStackTrace();
       // }
   // }

    /**
     * When click on first cell
     *
     * @param event
     */
    @FXML
    private void cell00Click(ActionEvent event) {

        if (place1 && !win && !tie && turn) {
            place1 = false;
            turn = false;
            loc = 1;
            movement++;
            //try {
           //     server.playMove(loc, opnent2);
           // } catch (RemoteException ex) {
           //     ex.printStackTrace();
          //  }

            if (isFirst) {
                btn1.setText(drawX());
                resultat1.add(loc);
            } else {
                btn1.setText(draw0());
                resultat1.add(loc);
            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        }
    }

    /**
     * When click on second cell
     *
     * @param event
     */
    @FXML
    private void cell01Click(ActionEvent event) {
        if (place2 && !win && !tie && turn) {
            loc = 2;
            place2 = false;
            turn = false;

            movement++;
          //  try {
           //     server.playMove(loc, opnent2);
           // } catch (RemoteException ex) {
           //     ex.printStackTrace();
           // }
            if (isFirst) {
                btn2.setText(drawX());
                resultat1.add(loc);

            } else {
                btn2.setText(draw0());
                resultat1.add(loc);

            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }

        }
    }

    /**
     * When click on third cell
     *
     * @param event
     */
    @FXML
    private void cell03Click(ActionEvent event) {
        if (place3 && !win && !tie && turn) {
            loc = 3;
            place3 = false;
            turn = false;

            movement++;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn3.setText(drawX());
                resultat1.add(loc);

            } else {
                btn3.setText(draw0());
                resultat1.add(loc);

            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }

        }
    }

    /**
     * When click on forth cell
     *
     * @param event
     */
    @FXML
    private void cell10Click(ActionEvent event) {
        if (place4 && !win && !tie && turn) {
            loc = 4;
            place4 = false;
            turn = false;

            movement++;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn4.setText(drawX());
                resultat1.add(loc);

            } else {
                btn4.setText(draw0());
                resultat1.add(loc);

            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        }
    }

    /**
     * When click on fifth cell
     *
     * @param event
     */
    @FXML
    private void cell11Click(ActionEvent event) {
        if (place5 && !win && !tie && turn) {
            loc = 5;
            place5 = false;
            turn = false;

            movement++;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn5.setText(drawX());
                resultat1.add(loc);

            } else {
                btn5.setText(draw0());
                resultat1.add(loc);
            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }

        }

    }

    /**
     * When click on sixth cell
     *
     * @param event
     */
    @FXML
    private void cell12Click(ActionEvent event) {
        if (place6 && !win && !tie && turn) {
            loc = 6;
            place6 = false;
            turn = false;

            movement++;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn6.setText(drawX());
                resultat1.add(loc);

            } else {
                btn6.setText(draw0());
                resultat1.add(loc);

            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        }

    }

    /**
     * When click on seventh cell
     *
     * @param event
     */
    @FXML
    private void cell20Click(ActionEvent event) {
        if (place7 && !win && !tie && turn) {
            place7 = false;
            turn = false;

            movement++;

            loc = 7;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn7.setText(drawX());
                resultat1.add(loc);

            } else {
                btn7.setText(draw0());
                resultat1.add(loc);

            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        }

    }

    /**
     * When click on eighth cell
     *
     * @param event
     */
    @FXML
    private void cell21Click(ActionEvent event) {
        if (place8 && !win && !tie && turn) {
            place8 = false;
            turn = false;

            movement++;
            loc = 8;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn8.setText(drawX());
                resultat1.add(loc);

            } else {
                btn8.setText(draw0());
                resultat1.add(loc);

            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        }
    }

    /**
     * When click on ninth cell
     *
     * @param event
     */
    @FXML
    private void cell22Click(ActionEvent event) {
        if (place9 && !win && !tie && turn) {
            place9 = false;
            turn = false;
            movement++;
            loc = 9;
//            try {
//                server.playMove(loc, opnent2);
//            } catch (RemoteException ex) {
//                ex.printStackTrace();
//            }
            if (isFirst) {
                btn9.setText(drawX());
                resultat1.add(loc);
            } else {
                btn9.setText(draw0());
                resultat1.add(loc);
            }
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        }

    }

    /**
     * determine the first player
     *
     * @param turn
     */
    public void changeTurn(boolean turn) {
        this.turn = turn;
        this.isFirst = turn;
    }

    /**
     * to put Tocken at another client
     *
     * @param position
     */
    public void putTocken(int position) {
        System.out.print(opnent2 + " ," + opnent1 + "loc :" + loc);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                turn = true;
                if (movement < 9) {
                    loc = position;
                    if (loc == 1) {
                        place1 = false;
                        movement++;
                        if (!isFirst) {
                            btn1.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn1.setText(draw0());
                            resultat2.add(loc);

                        }

                    } else if (loc == 2) {
                        place2 = false;
                        movement++;
                        if (!isFirst) {
                            btn2.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn2.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 3) {
                        place3 = false;
                        movement++;

                        if (!isFirst) {
                            btn3.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn3.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 4) {
                        place4 = false;
                        movement++;

                        if (!isFirst) {
                            btn4.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn4.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 5) {
                        place5 = false;
                        movement++;

                        if (!isFirst) {
                            btn5.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn5.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 6) {
                        place6 = false;
                        movement++;

                        if (!isFirst) {
                            btn6.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn6.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 7) {
                        place7 = false;
                        movement++;

                        if (!isFirst) {
                            btn7.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn7.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 8) {
                        place8 = false;
                        movement++;

                        if (!isFirst) {
                            btn8.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn8.setText(draw0());
                            resultat2.add(loc);

                        }
                    } else if (loc == 9) {
                        place9 = false;
                        movement++;
                        if (!isFirst) {
                            btn9.setText(drawX());
                            resultat2.add(loc);

                        } else {
                            btn9.setText(draw0());
                            resultat2.add(loc);

                        }
                    }

                    if (movement >= 5) {
                        checkWinning();
                    }
                    if (movement >= 9) {
                        checkTie();
                    }
                }
            }
        });

    }

    /**
     * to back to room
     *
     * @param event
     */
    @FXML
    private void onBack(ActionEvent event) {
//        try {
//            server.closeGame(opnent2);
//        } catch (RemoteException ex) {
//            ex.printStackTrace();
//        }
        try {
            Pane main = FXMLLoader.load(getClass().getResource("OnlineRoomFXML.fxml"));
            GamePane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * to record Click
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void recordClick(ActionEvent event) throws IOException {

        stopPress = false;
        videoCapture = VideoCapture.create();
        videoCapture.setVideoSource(new Desktop());
        java.util.List<Codec> videoCodecs = videoCapture.getVideoCodecs();
        System.out.println(videoCodecs);
        Codec videoCodec = videoCodecs.get(0);
        EncodingParameters encodingParameters = new EncodingParameters(new File("Replays//Replay" + firstPlayerName.getText().trim() + "VS" + secondPlayerName.getText().trim() + System.currentTimeMillis() + ".mp4"));
        encodingParameters.setSize(new Dimension(1000, 600));
        encodingParameters.setBitrate(800000);
        encodingParameters.setFramerate(10);
        encodingParameters.setCodec(videoCodec);
        videoCapture.setEncodingParameters(encodingParameters);
        videoCapture.start();
    }

    /**
     * to stop Click
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void stopClick(ActionEvent event) {
        if (!stopPress) {
            videoCapture.stop();
            stopPress = true;
        } else {
            JOptionPane.showMessageDialog(null, "Please start recording");
        }
    }

    /**
     * to terminate the session
     *
     */
    public void terminate() {
        Platform.runLater(() -> {
            
            JOptionPane.showMessageDialog(null, "Another Player disconnected");

            try {
                Pane main = FXMLLoader.load(getClass().getResource("OnlineRoomFXML.fxml"));
                GamePane.getChildren().setAll(main);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    /**
     * to reset the screen
     *
     * @param event
     */
    @FXML
    private void onReset(ActionEvent event) {
        /*  try {
            server.resetGame(opnent2);
        } catch (RemoteException ex) {
ex.printStackTrace();
        }
        restart();
         */
    }

    /**
     * to check the tie
     */
    public void checkTie() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (win != true && tie == false) {
                    tie = true;
                    String st = "Tie";
                    JOptionPane.showMessageDialog(null, st);
                    tieScore = tieScore + 1;
                    restart();

                }
            }
        });
    }

    /**
     * to draw x
     */
    public String drawX() {
        // isFirst = false;
        return "X";
    }

    /**
     * to draw x
     */
    public String draw0() {
//        isFirst = true;
        return "O";
    }

    /**
     * to check winning
     */
    public void checkWinning() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Checks if someone wins
                if (resultat1.containsAll(win1)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
                    //JOptionPane.showMessageDialog(null, st);
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win1)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    //winText.setText("win");
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win2)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
                    // JOptionPane.showMessageDialog(null, st);
                    //winText.setText("win");
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win2)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    // winText.setText("win");
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win3)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    // winText.setText("win");
                    String st = "you win";
                    // JOptionPane.showMessageDialog(null, st);
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win3)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    //winText.setText("win");
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win4)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
                    // JOptionPane.showMessageDialog(null, st);
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win4)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    // winText.setText("win");
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win5)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
//                    JOptionPane.showMessageDialog(null, st);
                    // winText.setText("win");
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win5)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win6)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
                    // JOptionPane.showMessageDialog(null, st);
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win6)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    //winText.setText("win");
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win7)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
                    // JOptionPane.showMessageDialog(null, st);
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win7)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    player2Score = player2Score + 1;
                } else if (resultat1.containsAll(win8)) {
                    win = true;
                    isFirstPlayerWin = true;
                    isSecondPlayerWin = false;
                    String st = "you win";
                    //JOptionPane.showMessageDialog(null, st);
                    player1Score = player1Score + 1;
                } else if (resultat2.containsAll(win8)) {
                    win = true;
                    isFirstPlayerWin = false;
                    isSecondPlayerWin = true;
                    String st = "you lose";
                    JOptionPane.showMessageDialog(null, st);
                    player2Score = player2Score + 1;
                }

                if (win) {
                    firstPlayerScore.setText("Score : " + String.valueOf(player1Score));
                    secondPlayerScore.setText("Score : " + String.valueOf(player2Score));
                    movement = 10;

                    if (isFirstPlayerWin) {
//                        try {
//                            //ClientDAO clientdtat = new ClientDAO();
//                            //int isUpdated = clientdtat.update(opnent1);
//                            server.updateScore(opnent1);
//                        } catch (RemoteException ex) {
//                            ex.printStackTrace();
//                        }
                        restart();
                        playVedio();

                    } else {
                        restart();
                    }
                    // mediaView.setMediaPlayer(player);
                    // player.play();
                }
            }
        });

    }

    /**
     * to restart the game
     */
    public void restart() {

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        //winText.setText("");
        win = false;
        tie = false;
        resultat1.clear();
        resultat2.clear();
        place1 = true;
        place2 = true;
        place3 = true;
        place4 = true;
        place5 = true;
        place6 = true;
        place7 = true;
        place8 = true;
        place9 = true;
        movement = 0;
        loc = 0;
    }

    /**
     * to play the video when win
     *
     */
    public void playVedio() {
        String workingDir = System.getProperty("user.dir");
        File f = new File(workingDir, "src//game//music//videoplayback.mp4");
        Media m = new Media(f.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);
        MediaView mv = new MediaView(mp);
        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().add(mv);
        Scene scene = new Scene(borderPane, 600, 300);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("You won!");
        stage.show();
        mp.play();
    }

}

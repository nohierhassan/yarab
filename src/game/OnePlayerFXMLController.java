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
import static game.DifficultyFXMLController.isDifficult;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class OnePlayerFXMLController implements Initializable {

    private static int loc;
    private int movement = 1;
    private boolean isFirst = true;
 

    private Boolean place1 = true, place2 = true, place3 = true, place4 = true, place5 = true, place6 = true,
            place7 = true, place8 = true, place9 = true, stopPress = true;
    private ArrayList<Integer> firstPlayerTockens, secondPlayerTockens;
    // Every possibilities of winning
    private ArrayList<Integer> firstWinPossibility, secondWinPossibility,
            thirdWinPossibility, forthWinPossibility, fifthWinPossibility,
            sixthWinPossibility, seventhWinPossibility, eighthWinPossibility;
    private VideoCapture videoCapture;

    // Places where AI can block
    private ArrayList<Integer> block1, block2, block3, block4, block5, block6, block7, block8, block9, block10, block11,
            block12, block13, block14, block15, block16, block17, block18, block19, block20, block21, block22, block23,
            block24;
    private Boolean loop1 = true, loop2 = true, loop3 = true, loop4 = true, loop5 = true, loop6 = true, loop7 = true,
            loop8 = true, loop9 = true, loop10 = true, loop11 = true, loop12 = true, loop13 = true, loop14 = true,
            loop15 = true, loop16 = true, loop17 = true, loop18 = true, loop19 = true, loop20 = true, loop21 = true,
            loop22 = true, loop23 = true, loop24 = true, loop25 = true, loop26 = true, loop27 = true, loop28 = true,
            loop29 = true, loop30 = true, loop31 = true, loop32 = true, loop33 = true, loop34 = true, loop35 = true;

    private int player1Score, player2Score, tieScore;

    // Stores if someone won or tied
    private Boolean win = false, tie = false;
    @FXML
    private AnchorPane onePlayerPane;
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

        firstPlayerName.setText("You");
        secondPlayerName.setText("Computer");

        firstPlayerTockens = new ArrayList<Integer>();
        secondPlayerTockens = new ArrayList<Integer>();
        // Defines every possibilities of winning
        firstWinPossibility = new ArrayList<Integer>();
        secondWinPossibility = new ArrayList<Integer>();
        thirdWinPossibility = new ArrayList<Integer>();
        forthWinPossibility = new ArrayList<Integer>();
        fifthWinPossibility = new ArrayList<Integer>();
        sixthWinPossibility = new ArrayList<Integer>();
        seventhWinPossibility = new ArrayList<Integer>();
        eighthWinPossibility = new ArrayList<Integer>();

        firstWinPossibility.add(1);
        firstWinPossibility.add(2);
        firstWinPossibility.add(3);
        secondWinPossibility.add(4);
        secondWinPossibility.add(5);
        secondWinPossibility.add(6);
        thirdWinPossibility.add(7);
        thirdWinPossibility.add(8);
        thirdWinPossibility.add(9);
        forthWinPossibility.add(1);
        forthWinPossibility.add(4);
        forthWinPossibility.add(7);
        fifthWinPossibility.add(2);
        fifthWinPossibility.add(5);
        fifthWinPossibility.add(8);
        sixthWinPossibility.add(3);
        sixthWinPossibility.add(6);
        sixthWinPossibility.add(9);
        seventhWinPossibility.add(1);
        seventhWinPossibility.add(5);
        seventhWinPossibility.add(9);
        eighthWinPossibility.add(3);
        eighthWinPossibility.add(5);
        eighthWinPossibility.add(7);

//        gameMediaPlayer = new MediaPlayer(new Media(new File("src//game//music//backAudio.mp3").toURI().toString()));
//        gameMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        gameMediaPlayer.play();
//        failMediaPlayer = new MediaPlayer(new Media(new File("src//game//music//fail.mp3").toURI().toString()));
//        failMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    /**
     * When click on first cell
     *
     * @param event
     */
    @FXML
    private void cell00Click(ActionEvent event) {

        if (place1 && !win && !tie) {
            place1 = false;
            movement++;
            loc = 1;
            btn1.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on second cell
     *
     * @param event
     */
    @FXML
    private void cell01Click(ActionEvent event) {
        if (place2 && !win && !tie) {
            loc = 2;
            movement++;

            place2 = false;
            btn2.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on third cell
     *
     * @param event
     */
    @FXML
    private void cell03Click(ActionEvent event) {
        if (place3 && !win && !tie) {
            loc = 3;
            movement++;

            place3 = false;
            btn3.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on forth cell
     *
     * @param event
     */
    @FXML
    private void cell10Click(ActionEvent event) {
        if (place4 && !win && !tie) {
            loc = 4;
            movement++;

            place4 = false;
            btn4.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on fifth cell
     *
     * @param event
     */
    @FXML
    private void cell11Click(ActionEvent event) {
        if (place5 && !win && !tie) {
            loc = 5;
            movement++;

            place5 = false;
            btn5.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();

        }
    }

    /**
     * When click on sixth cell
     *
     * @param event
     */
    @FXML
    private void cell12Click(ActionEvent event) {
        if (place6 && !win && !tie) {
            place6 = false;
            loc = 6;
            movement++;

            btn6.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on seventh cell
     *
     * @param event
     */
    @FXML
    private void cell20Click(ActionEvent event) {
        if (place7 && !win && !tie) {
            place7 = false;
            loc = 7;
            movement++;

            btn7.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on eighth cell
     *
     * @param event
     */
    @FXML
    private void cell21Click(ActionEvent event) {
        if (place8 && !win && !tie) {
            place8 = false;
            loc = 8;
            movement++;

            btn8.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * When click on ninth cell
     *
     * @param event
     */
    @FXML
    private void cell22Click(ActionEvent event) {
        if (place9 && !win && !tie) {
            place9 = false;
            loc = 9;
            movement++;

            btn9.setText(drawX());
            firstPlayerTockens.add(loc);
            computerTurn();
        }
    }

    /**
     * to back to main page
     *
     * @param event
     */
    @FXML
    private void onBack(ActionEvent event) {
//        gameMediaPlayer.stop();
//        failMediaPlayer.stop();

        try {
            Pane main = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
            onePlayerPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * to start new game
     *
     * @param event
     */
    @FXML
    private void onReset(ActionEvent event) {
        restart();

    }

    /**
     * to start record the game
     *
     * @param event
     */
    @FXML
    private void recordClick(ActionEvent event) throws IOException {
        stopPress = false;
        videoCapture = VideoCapture.create();
        videoCapture.setVideoSource(new Desktop());
        java.util.List<Codec> videoCodecs = videoCapture.getVideoCodecs();
        System.out.println(videoCodecs);
        Codec videoCodec = videoCodecs.get(0);
        EncodingParameters encodingParameters = new EncodingParameters(new File("Replays//ReplayOneVsComputer" + System.currentTimeMillis() + ".mp4"));
        encodingParameters.setSize(new Dimension(1000, 600));
        encodingParameters.setBitrate(800000);
        encodingParameters.setFramerate(10);
        encodingParameters.setCodec(videoCodec);
        videoCapture.setEncodingParameters(encodingParameters);
        videoCapture.start();
    }

    /**
     * to stop record the game
     *
     * @param event
     */
    @FXML
    private void stopClick(ActionEvent event) {
        if (!stopPress) {
            videoCapture.stop();
            String workingDir = System.getProperty("user.dir");
            //show video
           /* File f = new File(workingDir, "videoplayback.mp4");
            Media m = new Media(f.toURI().toString());
            MediaPlayer mp = new MediaPlayer(m);
            MediaView mv = new MediaView(mp);
            BorderPane borderPane = new BorderPane();
            borderPane.getChildren().add(mv);
            Scene scene = new Scene(borderPane, 600, 600);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("You won!");
            stage.show();
            mp.play();
            */
            stopPress = true;
        } else {
            JOptionPane.showMessageDialog(null, "Please start recording");
        }
    }

    /**
     * to check the tie
     *
     */
    public void checkTie() {
        if (win != true && tie == false) {
            tie = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();

            String st = "Tie";
            JOptionPane.showMessageDialog(null, st);
            tieScore = tieScore + 1;
        }
    }

    /**
     * to draw x
     *
     * @return player symbol
     */
    public String drawX() {
        return "X";
        
    }

    /**
     * to draw o
     *
     * @return computer player symbol
     */
    public String draw0() {
        return "O";
    }

    /**
     * easy computer movement (max - min) + 1) + min
     *
     */
    public void easyComputer() {
        if (movement < 9) {
            int rand = 1 + (int) (Math.random() * ((9 - 1) + 1));
            while (firstPlayerTockens.contains(rand) || secondPlayerTockens.contains(rand)) {
                rand = 1 + (int) (Math.random() * ((9 - 1) + 1));
            }
            loc = rand;
            if (loc == 1) {
                place1 = false;
                movement++;
                btn1.setText(draw0());
            } else if (loc == 2) {
                place2 = false;
                movement++;

                btn2.setText(draw0());
            } else if (loc == 3) {
                place3 = false;
                movement++;

                btn3.setText(draw0());
            } else if (loc == 4) {
                place4 = false;
                movement++;

                btn4.setText(draw0());
            } else if (loc == 5) {
                place5 = false;
                movement++;

                btn5.setText(draw0());
            } else if (loc == 6) {
                place6 = false;
                movement++;

                btn6.setText(draw0());
            } else if (loc == 7) {
                place7 = false;
                movement++;

                btn7.setText(draw0());
            } else if (loc == 8) {
                place8 = false;
                movement++;

                btn8.setText(draw0());
            } else if (loc == 9) {
                place9 = false;
                movement++;

                btn9.setText(draw0());
            }
            secondPlayerTockens.add(loc);

            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
        } else if (movement == 9) {
            checkWinning();
            checkTie();
        }

    }

    /**
     * computer level
     *
     */
    public void computerTurn() {
        if (isDifficult) {
            hardComputer();
        } else {
            easyComputer();
        }
    }

    /**
     * to check the winning
     *
     */
    public void checkWinning() {
        // Checks if someone wins
        if (firstPlayerTockens.containsAll(firstWinPossibility)) {
            win = true;
            String st = "you win";
            //JOptionPane.showMessageDialog(null, st);
            playVedio();

            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(firstWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();
            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(secondWinPossibility)) {
            win = true;
            String st = "you win";
            //JOptionPane.showMessageDialog(null, st);
            playVedio();

            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(secondWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();

            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(thirdWinPossibility)) {
            win = true;
            String st = "you win";
            //JOptionPane.showMessageDialog(null, st);
            playVedio();

            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(thirdWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();

            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(forthWinPossibility)) {
            win = true;
            String st = "you win";
            // JOptionPane.showMessageDialog(null, st);
            playVedio();

            //winText.setText("win");
            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(forthWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();
            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);

            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(fifthWinPossibility)) {
            win = true;
            String st = "you win";
            //JOptionPane.showMessageDialog(null, st);
            playVedio();

            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(fifthWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();

            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(sixthWinPossibility)) {
            win = true;
            String st = "you win";
            //JOptionPane.showMessageDialog(null, st);
            playVedio();

            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(sixthWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();
            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(seventhWinPossibility)) {
            win = true;
            String st = "you win";
            //JOptionPane.showMessageDialog(null, st);
            playVedio();

            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(seventhWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();

            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            //winText.setText("win");
            player2Score = player2Score + 1;
        } else if (firstPlayerTockens.containsAll(eighthWinPossibility)) {
            win = true;
            String st = "you win";
            // JOptionPane.showMessageDialog(null, st);
            playVedio();

            //winText.setText("win");
            player1Score = player1Score + 1;
        } else if (secondPlayerTockens.containsAll(eighthWinPossibility)) {
            win = true;
//            gameMediaPlayer.stop();
//            failMediaPlayer.play();

            String st = "you lose";
            JOptionPane.showMessageDialog(null, st);
            player2Score = player2Score + 1;
        }

        if (win) {
            firstPlayerScore.setText("Score : " + String.valueOf(player1Score));
            secondPlayerScore.setText("Score : " + String.valueOf(player2Score));

            movement = 10;
        }

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
        Scene scene = new Scene(borderPane, 600, 350);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("You won!");
        stage.show();
        mp.play();
    }

    /**
     * to restart the game
     *
     */
    public void restart() {
//        failMediaPlayer.stop();
//        gameMediaPlayer.play();

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        win = false;
        tie = false;
        firstPlayerTockens.clear();
        secondPlayerTockens.clear();
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

        // au
        loop1 = true;
        loop2 = true;
        loop3 = true;
        loop4 = true;
        loop5 = true;
        loop6 = true;
        loop7 = true;
        loop8 = true;
        loop9 = true;
        loop10 = true;
        loop11 = true;
        loop12 = true;
        loop13 = true;
        loop14 = true;
        loop15 = true;
        loop16 = true;
        loop17 = true;
        loop18 = true;
        loop19 = true;
        loop20 = true;
        loop21 = true;
        loop22 = true;
        loop23 = true;
        loop24 = true;
        loop25 = true;
        loop26 = true;
        loop27 = true;
        loop28 = true;
        loop29 = true;
        loop30 = true;
        loop31 = true;
        loop32 = true;
        loop33 = true;
        loop34 = true;
        loop35 = true;
    }

    /**
     * to play in a hard game
     *
     */
    public void hardComputer() {
        block1 = new ArrayList<Integer>();
        block2 = new ArrayList<Integer>();
        block3 = new ArrayList<Integer>();
        block4 = new ArrayList<Integer>();
        block5 = new ArrayList<Integer>();
        block6 = new ArrayList<Integer>();
        block7 = new ArrayList<Integer>();
        block8 = new ArrayList<Integer>();
        block9 = new ArrayList<Integer>();
        block10 = new ArrayList<Integer>();
        block11 = new ArrayList<Integer>();
        block12 = new ArrayList<Integer>();
        block13 = new ArrayList<Integer>();
        block14 = new ArrayList<Integer>();
        block15 = new ArrayList<Integer>();
        block16 = new ArrayList<Integer>();
        block17 = new ArrayList<Integer>();
        block18 = new ArrayList<Integer>();
        block19 = new ArrayList<Integer>();
        block20 = new ArrayList<Integer>();
        block21 = new ArrayList<Integer>();
        block22 = new ArrayList<Integer>();
        block23 = new ArrayList<Integer>();
        block24 = new ArrayList<Integer>();

        block1.add(1);
        block1.add(2);
        block2.add(4);
        block2.add(5);
        block3.add(7);
        block3.add(8);
        block4.add(2);
        block4.add(3);
        block5.add(5);
        block5.add(6);
        block6.add(8);
        block6.add(9);
        block7.add(7);
        block7.add(4);
        block8.add(8);
        block8.add(5);
        block9.add(9);
        block9.add(6);
        block10.add(1);
        block10.add(4);
        block11.add(2);
        block11.add(5);
        block12.add(3);
        block12.add(6);
        block13.add(5);
        block13.add(9);
        block14.add(1);
        block14.add(5);
        block15.add(7);
        block15.add(5);
        block16.add(5);
        block16.add(3);
        block17.add(1);
        block17.add(7);
        block18.add(2);
        block18.add(8);
        block19.add(3);
        block19.add(9);
        block20.add(1);
        block20.add(3);
        block21.add(4);
        block21.add(6);
        block22.add(7);
        block22.add(9);
        block23.add(1);
        block23.add(9);
        block24.add(7);
        block24.add(3);

        // Puts computer token
        if (firstPlayerTockens.isEmpty() == false) {
            if (secondPlayerTockens.containsAll(block1) && loop1 && place3) {
                loop1 = false;
                place3 = false;
                secondPlayerTockens.add(3);
                movement++;
                btn3.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block2) && loop2 && place6) {
                loop2 = false;
                place6 = false;
                secondPlayerTockens.add(6);
                movement++;
                btn6.setText(draw0());

            } else if (secondPlayerTockens.containsAll(block3) && loop3 && place9) {
                loop3 = false;
                place9 = false;
                secondPlayerTockens.add(9);
                movement++;
                btn9.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block4) && loop4 && place1) {
                loop4 = false;
                place1 = false;
                secondPlayerTockens.add(1);
                movement++;
                btn1.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block5) && loop5 && place4) {
                loop5 = false;
                place4 = false;
                secondPlayerTockens.add(4);
                movement++;
                btn4.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block6) && loop6 && place7) {
                loop6 = false;
                place7 = false;
                secondPlayerTockens.add(7);
                movement++;
                btn7.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block7) && loop7 && place1) {
                loop7 = false;
                place1 = false;
                secondPlayerTockens.add(1);
                movement++;
                btn1.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block8) && loop8 && place2) {
                loop8 = false;
                place2 = false;
                secondPlayerTockens.add(2);
                movement++;
                btn2.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block9) && loop9 && place3) {
                loop9 = false;
                place3 = false;
                secondPlayerTockens.add(3);
                movement++;
                btn3.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block10) && loop10 && place7) {
                loop10 = false;
                place7 = false;
                secondPlayerTockens.add(7);
                movement++;
                btn7.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block11) && loop11 && place8) {
                loop11 = false;
                place8 = false;
                secondPlayerTockens.add(8);
                movement++;
                btn8.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block12) && loop12 && place9) {
                loop12 = false;
                place9 = false;
                secondPlayerTockens.add(9);
                movement++;
                btn9.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block13) && loop13 && place1) {
                loop13 = false;
                place1 = false;
                secondPlayerTockens.add(1);
                movement++;
                btn1.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block14) && loop14 && place9) {
                loop14 = false;
                place9 = false;
                secondPlayerTockens.add(9);
                movement++;
                btn9.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block15) && loop15 && place3) {
                loop15 = false;
                place3 = false;
                secondPlayerTockens.add(3);
                movement++;
                btn3.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block16) && loop16 && place7) {
                loop16 = false;
                place7 = false;
                secondPlayerTockens.add(7);
                movement++;
                btn7.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block17) && loop22 && place4) {
                loop22 = false;
                place4 = false;
                secondPlayerTockens.add(4);
                movement++;
                btn4.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block18) && loop23 && place5) {
                loop23 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block19) && loop24 && place6) {
                loop24 = false;
                place6 = false;
                secondPlayerTockens.add(6);
                movement++;
                btn6.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block20) && loop25 && place2) {
                loop25 = false;
                place2 = false;
                secondPlayerTockens.add(2);
                movement++;
                btn2.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block21) && loop26 && place5) {
                loop26 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block22) && loop27 && place8) {
                loop27 = false;
                place8 = false;
                secondPlayerTockens.add(8);
                movement++;
                btn8.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block23) && loop28 && place5) {
                loop28 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (secondPlayerTockens.containsAll(block24) && loop29 && place5) {
                loop29 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block1) && loop1 && place3) {
                loop1 = false;
                place3 = false;
                secondPlayerTockens.add(3);
                movement++;
                btn3.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block2) && loop2 && place6) {
                loop2 = false;
                place6 = false;
                secondPlayerTockens.add(6);
                movement++;
                btn6.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block3) && loop3 && place9) {
                loop3 = false;
                place9 = false;
                secondPlayerTockens.add(9);
                movement++;
                btn9.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block4) && loop4 && place1) {
                loop4 = false;
                place1 = false;
                secondPlayerTockens.add(1);
                movement++;
                btn1.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block5) && loop5 && place4) {
                loop5 = false;
                place4 = false;
                secondPlayerTockens.add(4);
                movement++;
                btn4.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block6) && loop6 && place7) {
                loop6 = false;
                place7 = false;
                secondPlayerTockens.add(7);
                movement++;
                btn7.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block7) && loop7 && place1) {
                loop7 = false;
                place1 = false;
                secondPlayerTockens.add(1);
                movement++;
                btn1.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block8) && loop8 && place2) {
                loop8 = false;
                place2 = false;
                secondPlayerTockens.add(2);
                movement++;
                btn2.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block9) && loop9 && place3) {
                loop9 = false;
                place3 = false;
                secondPlayerTockens.add(3);
            } else if (firstPlayerTockens.containsAll(block10) && loop10 && place7) {
                loop10 = false;
                place7 = false;
                secondPlayerTockens.add(7);
                movement++;
                btn7.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block11) && loop11 && place8) {
                loop11 = false;
                place8 = false;
                secondPlayerTockens.add(8);
                movement++;
                btn8.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block12) && loop12 && place9) {
                loop12 = false;
                place9 = false;
                secondPlayerTockens.add(9);
                movement++;
                btn9.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block13) && loop13 && place1) {
                loop13 = false;
                place1 = false;
                secondPlayerTockens.add(1);
                movement++;
                btn1.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block14) && loop14 && place9) {
                loop14 = false;
                place9 = false;
                secondPlayerTockens.add(9);
                movement++;
                btn9.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block15) && loop15 && place3) {
                loop15 = false;
                place3 = false;
                secondPlayerTockens.add(3);
                movement++;
                btn3.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block16) && loop16 && place7) {
                loop16 = false;
                place7 = false;
                secondPlayerTockens.add(7);
                movement++;
                btn7.setText(draw0());
            } else if (firstPlayerTockens.contains(1) && loop17 && place5) {
                loop17 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.contains(3) && loop18 && place5) {
                loop18 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.contains(7) && loop19 && place5) {
                loop19 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.contains(9) && loop20 && place5) {
                loop20 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.contains(5) && loop21) {
                loop21 = false;
                if (place1) {
                    place1 = false;
                    secondPlayerTockens.add(1);
                    movement++;
                    btn1.setText(draw0());
                } else if (place3) {
                    place3 = false;
                    secondPlayerTockens.add(3);
                    movement++;
                    btn3.setText(draw0());
                } else if (place7) {
                    place7 = false;
                    secondPlayerTockens.add(7);
                    movement++;
                    btn7.setText(draw0());
                } else if (place9) {
                    place9 = false;
                    secondPlayerTockens.add(9);
                    movement++;
                    btn9.setText(draw0());
                }
            } else if (firstPlayerTockens.containsAll(block17) && loop22 && place4) {
                loop22 = false;
                place4 = false;
                secondPlayerTockens.add(4);
                movement++;
                btn4.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block18) && loop23 && place5) {
                loop23 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block19) && loop24 && place6) {
                loop24 = false;
                place6 = false;
                secondPlayerTockens.add(6);
                movement++;
                btn6.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block20) && loop25 && place2) {
                loop25 = false;
                place2 = false;
                secondPlayerTockens.add(2);
                movement++;
                btn2.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block21) && loop26 && place5) {
                loop26 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block22) && loop27 && place8) {
                loop27 = false;
                place8 = false;
                secondPlayerTockens.add(8);
                movement++;
                btn8.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block23) && loop28 && place5) {
                loop28 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.containsAll(block24) && loop29 && place5) {
                loop29 = false;
                place5 = false;
                secondPlayerTockens.add(5);
                movement++;
                btn5.setText(draw0());
            } else if (firstPlayerTockens.contains(2) && loop30) {
                loop30 = false;
                if (place1) {
                    place1 = false;
                    secondPlayerTockens.add(1);
                    movement++;
                    btn1.setText(draw0());
                } else if (place3) {
                    place3 = false;
                    secondPlayerTockens.add(3);
                    movement++;
                    btn3.setText(draw0());
                } else if (place7) {
                    place7 = false;
                    secondPlayerTockens.add(7);
                    movement++;
                    btn7.setText(draw0());
                } else if (place9) {
                    place9 = false;
                    secondPlayerTockens.add(9);
                    movement++;
                    btn9.setText(draw0());
                }
            } else if (firstPlayerTockens.contains(4) && loop31) {
                loop31 = false;
                if (place1) {
                    place1 = false;
                    secondPlayerTockens.add(1);
                    movement++;
                    btn1.setText(draw0());
                } else if (place3) {
                    place3 = false;
                    secondPlayerTockens.add(3);
                    movement++;
                    btn3.setText(draw0());
                } else if (place7) {
                    place7 = false;
                    secondPlayerTockens.add(7);
                    movement++;
                    btn7.setText(draw0());
                } else if (place9) {
                    place9 = false;
                    secondPlayerTockens.add(9);
                    movement++;
                    btn9.setText(draw0());
                }
            } else if (firstPlayerTockens.contains(8) && loop32) {
                loop32 = false;
                if (place1) {
                    place1 = false;
                    secondPlayerTockens.add(1);
                    movement++;
                    btn1.setText(draw0());
                } else if (place3) {
                    place3 = false;
                    secondPlayerTockens.add(3);
                    movement++;
                    btn3.setText(draw0());
                } else if (place7) {
                    place7 = false;
                    secondPlayerTockens.add(7);
                    movement++;
                    btn7.setText(draw0());
                } else if (place9) {
                    place9 = false;
                    secondPlayerTockens.add(9);
                    movement++;
                    btn9.setText(draw0());
                }
            } else if (firstPlayerTockens.contains(6) && loop33) {
                loop33 = false;
                if (place1) {
                    place1 = false;
                    secondPlayerTockens.add(1);
                    movement++;
                    btn1.setText(draw0());
                } else if (place3) {
                    place3 = false;
                    secondPlayerTockens.add(3);
                    movement++;
                    btn3.setText(draw0());
                } else if (place7) {
                    place7 = false;
                    secondPlayerTockens.add(7);
                    movement++;
                    btn7.setText(draw0());
                } else if (place9) {
                    place9 = false;
                    secondPlayerTockens.add(9);
                    movement++;
                    btn9.setText(draw0());
                }
            } else if (firstPlayerTockens.containsAll(block24) && loop34) {
                loop34 = false;
                if (place2) {
                    place2 = false;
                    secondPlayerTockens.add(2);
                    movement++;
                    btn2.setText(draw0());
                } else if (place4) {
                    place4 = false;
                    secondPlayerTockens.add(4);
                    movement++;
                    btn4.setText(draw0());
                } else if (place6) {
                    place6 = false;
                    secondPlayerTockens.add(6);
                    movement++;
                    btn6.setText(draw0());
                } else if (place8) {
                    place8 = false;
                    secondPlayerTockens.add(8);
                    movement++;
                    btn8.setText(draw0());
                }
            } else if (firstPlayerTockens.containsAll(block23) && loop35) {
                loop35 = false;
                if (place2) {
                    place2 = false;
                    secondPlayerTockens.add(2);
                    movement++;
                    btn2.setText(draw0());
                } else if (place4) {
                    place4 = false;
                    secondPlayerTockens.add(4);
                    movement++;
                    btn4.setText(draw0());
                } else if (place6) {
                    place6 = false;
                    secondPlayerTockens.add(6);
                    movement++;
                    btn6.setText(draw0());
                } else if (place8) {
                    place8 = false;
                    secondPlayerTockens.add(8);
                    movement++;
                    btn8.setText(draw0());
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

}

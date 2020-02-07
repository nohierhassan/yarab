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
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class TwoPlayerFXMLController implements Initializable {

    // media 
    //private MediaPlayer gameMediaPlayer, failMediaPlayer;
    private boolean isFirst = true;
    private static int loc;
    private Boolean place1 = true, place2 = true, place3 = true,
            place4 = true, place5 = true, place6 = true,
            place7 = true, place8 = true, place9 = true, stopPress=true;
    private ArrayList<Integer> firstPlayerTockens, secondPlayerTockens,gameTockens;
    // Every possibilities of winning
    private ArrayList<Integer> firstWinPossibility, secondWinPossibility,
            thirdWinPossibility, forthWinPossibility, fifthWinPossibility,
            sixthWinPossibility, seventhWinPossibility, eighthWinPossibility;
    private int player1Score, player2Score, tieScore;
    private VideoCapture videoCapture;
    private static int  gameOrder = 0;

    // Stores if someone won or tied
    private Boolean win = false, tie = false;
    private int movement = 1;

    @FXML
    private AnchorPane towPlayerPane;
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
    private MediaView mediaView;

    @FXML
    private Label firstPlayerScore;
    @FXML
    private Label firstPlayerName;
    @FXML
    private Label secondPlayerName;
    @FXML
    private Label secondPlayerScore;

    MediaPlayer player;
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

        firstPlayerName.setText("You");
        secondPlayerName.setText("Friend");

        firstPlayerTockens = new ArrayList<Integer>();
        secondPlayerTockens = new ArrayList<Integer>();
        gameTockens = new ArrayList<Integer>();
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
        //player = new MediaPlayer(new Media(new File("src//game//music//vedio.mp4").toURI().toString()));//Media(getClass().getResource("src//game//music//video.mp4").toExternalForm()));
        firstPlayerName.setText(JOptionPane.showInputDialog("First Player", "Enter Your Name"));
        secondPlayerName.setText(JOptionPane.showInputDialog("Second Player", "Enter Your Name"));
        gameOrder++;
        System.out.println("The game order is initialize "+gameOrder);
        
        System.out.println(firstPlayerName.getText());
        System.out.println(secondPlayerName.getText());
        System.out.println("**********************************");
        addInDB();
    }

    /**
     * When click on first cell
     *
     * @param event
     */
    private void printGames(ArrayList<Integer> list)
    {
        for (int item : list)       
        {
            System.out.println(item);
        }
    }
    private void makeGameOrders(ArrayList<Integer> first,ArrayList<Integer> second)
    {
        boolean flag = false;
        while(! flag)
        {
//            if(first.ne)
        }
    
    }
    private boolean addGames(int num)
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/southwind";
            String user = "non";
            String password = "Java123$";
            
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt =con.prepareStatement("insert into games (num,gameorder) values (?,?)");
            stmt.setInt(1, num);
            stmt.setInt(2,gameOrder);
            
            
            int rs = stmt.executeUpdate();
            con.close();
            
        }
        catch(SQLException ex)
        {
                ex.printStackTrace();
                return false;
        }
        return true;
    }
      private void addInDB()
    {
        try
        {
             String url = "jdbc:mysql://localhost:3306/southwind";
            String user = "non";
            String password = "Java123$";
            
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt =con.prepareStatement("insert into names (gameorder,fplayer,splayer) values (?,?,?)");
            stmt.setInt(1,gameOrder);
            stmt.setString(2,firstPlayerName.getText());
            stmt.setString(3,secondPlayerName.getText());
            
            
            
            int rs = stmt.executeUpdate();
            con.close();
            
        }
        catch(SQLException ex)
        {
                ex.printStackTrace();
                
        }
      
    }

    @FXML
    private void cell00Click(ActionEvent event) {
        if (place1 && !win && !tie) {
            place1 = false;
            loc = 1;
            movement++;
            if (isFirst) {
                btn1.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);
            } else {
                btn1.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);
            }
            addGames(loc);
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
        if (place2 && !win && !tie) {
            loc = 2;
            place2 = false;
            movement++;

            if (isFirst) {
                btn2.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn2.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);

            }
            addGames(loc);
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
        if (place3 && !win && !tie) {
            loc = 3;
            place3 = false;
            movement++;

            if (isFirst) {
                btn3.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn3.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);

            }
            addGames(loc);
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
        if (place4 && !win && !tie) {
            loc = 4;
            place4 = false;
            movement++;

            if (isFirst) {
                btn4.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn4.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);

            }
            addGames(loc);
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
        if (place5 && !win && !tie) {
            loc = 5;
            place5 = false;
            movement++;

            if (isFirst) {
                btn5.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn5.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);
            }
            addGames(loc);
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
        if (place6 && !win && !tie) {
            loc = 6;
            place6 = false;
            movement++;

            if (isFirst) {
                btn6.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn6.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);

            }
            addGames(loc);
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
        if (place7 && !win && !tie) {
            place7 = false;
            movement++;

            loc = 7;
            if (isFirst) {
                btn7.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn7.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);

            }
            addGames(loc);
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
        if (place8 && !win && !tie) {
            place8 = false;
            movement++;

            loc = 8;
            if (isFirst) {
                btn8.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);

            } else {
                btn8.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);

            }
            addGames(loc);
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
        if (place9 && !win && !tie) {
            place9 = false;
            movement++;
            loc = 9;
            if (isFirst) {
                btn9.setText(drawX());
                firstPlayerTockens.add(loc);
                gameTockens.add(loc);
            } else {
                btn9.setText(draw0());
                secondPlayerTockens.add(loc);
                gameTockens.add(loc);
            }
            addGames(loc);
            if (movement >= 5) {
                checkWinning();
            }
            if (movement >= 9) {
                checkTie();
            }
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
            towPlayerPane.getChildren().setAll(main);

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
        @FXML
    private void recordClick(ActionEvent event) throws IOException {

        stopPress = false;
        videoCapture = VideoCapture.create();
        videoCapture.setVideoSource(new Desktop());
        java.util.List<Codec> videoCodecs = videoCapture.getVideoCodecs();
        System.out.println(videoCodecs);
        Codec videoCodec = videoCodecs.get(0);
        EncodingParameters encodingParameters = new EncodingParameters(new File("Replays//Replay"+firstPlayerName.getText().trim()+"VS"+secondPlayerName.getText().trim()+System.currentTimeMillis()+".mp4"));
        encodingParameters.setSize(new Dimension(1000, 600));
        encodingParameters.setBitrate(800000);
        encodingParameters.setFramerate(10);
        encodingParameters.setCodec(videoCodec);
        videoCapture.setEncodingParameters(encodingParameters);
        videoCapture.start();
}
    /**
     * to stop recording 
     * @param event
     *
     */

    @FXML
    private void stopClick(ActionEvent event) {
        if(!stopPress)
        {
            videoCapture.stop();
            stopPress = true;
        }
        else{
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
     * to draw x and change the turn of player
     *
     * @return first player symbol
     *
     */
    public String drawX() {
        isFirst = false;
        return "X";
    }

    /**
     * to draw o and change the turn of player
     *
     * @return second player symbol
     */
    public String draw0() {
        isFirst = true;
        return "O";
    }

    /**
     * to check the winning
     *
     */
    public void checkWinning() {
        // Checks if someone wins
        if (firstPlayerTockens.containsAll(firstWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player1Score = player1Score + 1;
            printGames(gameTockens);
            
        } else if (secondPlayerTockens.containsAll(firstWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName.getText() + " wins");
            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(secondWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player1Score = player1Score + 1;
            printGames(gameTockens);
        } else if (secondPlayerTockens.containsAll(secondWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName.getText() + " wins");

            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(thirdWinPossibility)) {
            win = true;
            // winText.setText("win");
            player1Score = player1Score + 1;
            printGames(gameTockens);
        } else if (secondPlayerTockens.containsAll(thirdWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName.getText() + " wins");

            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(forthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player1Score = player1Score + 1;
            printGames(gameTockens);
        } else if (secondPlayerTockens.containsAll(forthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName.getText() + " wins");

            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(fifthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player1Score = player1Score + 1;
            printGames(gameTockens);
        } else if (secondPlayerTockens.containsAll(fifthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName + " wins");

            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(sixthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player1Score = player1Score + 1;
            printGames(gameTockens);
        } else if (secondPlayerTockens.containsAll(sixthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(seventhWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");

            player1Score = player1Score + 1;
            printGames(gameTockens);
        } else if (secondPlayerTockens.containsAll(seventhWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName.getText() + " wins");

            player2Score = player2Score + 1;
            printGames(gameTockens);
        } else if (firstPlayerTockens.containsAll(eighthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, firstPlayerName.getText() + " wins");
            player1Score = player1Score + 1;
            printGames(gameTockens);;
        } else if (secondPlayerTockens.containsAll(eighthWinPossibility)) {
            win = true;
            JOptionPane.showMessageDialog(null, secondPlayerName.getText() + " wins");
            player2Score = player2Score + 1;
            printGames(gameTockens);
        }

        if (win) {
            firstPlayerScore.setText("Score : " + String.valueOf(player1Score));
            secondPlayerScore.setText("Score : " + String.valueOf(player2Score));
            movement = 10;

        }

    }

    /**
     * to restart the game
     *
     */
    public void restart() {
//        failMediaPlayer.stop();
//        gameMediaPlayer.play();
        gameOrder++;
//        System.out.println("The game order is "+gameOrder);
//        System.out.println(firstPlayerName.getText());
//        System.out.println(secondPlayerName.getText());
//        System.out.println("**********************************");
        addInDB();
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
    }

}

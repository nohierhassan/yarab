/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * FXML Controller class
 *
 * @author yasmine
 */
public class ReplaysController implements Initializable {

    @FXML
    private ListView<String> replays;
    private File[] listOfFiles;
    @FXML
    private Button back;
    Queue<String> fplayers = new LinkedList<>();
      Queue<String> splayers = new LinkedList<>();
     
    @FXML
    private AnchorPane replayPane;
    // to know how many games are in the DB
    protected int checkDB()
    {
        int retval = -1;
        
         try
        {
            String url = "jdbc:mysql://localhost:3306/southwind";
            String user = "non";
            String password = "Java123$";
            String query1 = "select count(distinct(gameorder)) as gameorder from games";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            
           
            
            while(rs1.next())
                {
                   retval = rs1.getInt("gameorder");
           
                }
            
            st1.close();
            con.close();
            
        }
        
        catch(SQLException ex)
        {
                ex.printStackTrace();
                
        }
         finally
         {
             return retval;
         }
        
    }
    
    protected void addNames()
    {
        // try to access the DB to get all the names of the played games.
        try
        {
            String url = "jdbc:mysql://localhost:3306/southwind";
            String user = "non";
            String password = "Java123$";
            String query1 = "select * from names";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            
           
            
            while(rs1.next())
                {
//                   retval = rs1.getInt("gameCount");
                    fplayers.add(rs1.getString("fplayer"));
                    splayers.add(rs1.getString("splayer"));
   
                }
            
            st1.close();
            con.close();
            
        }
        catch(SQLException ex)
        {
                ex.printStackTrace();
                
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("in the replay");
//        gameMediaPlayer = new MediaPlayer(new Media(new File("src//game//music//backAudio.mp3").toURI().toString()));
//        gameMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        gameMediaPlayer.play();
//        failMediaPlayer = new MediaPlayer(new Media(new File("src//game//music//fail.mp3").toURI().toString()));
//        failMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        File folder = new File("Replays");
//        listOfFiles = folder.listFiles();
//        for (int i = 0; i < listOfFiles.length; i++) {
//            if (listOfFiles[i].isFile()) {
//                replays.getItems().add(listOfFiles[i].getName());
//            } else if (listOfFiles[i].isDirectory()) {
//            }
//        }

     // # to get all the names from the DB.
     addNames();
        System.out.println(checkDB());
     for(int i=0;i<checkDB();i++)
     {
         String str = fplayers.remove()+"VS"+splayers.remove();
         System.out.println(str);
         replays.getItems().add(str);
     }
     
        
    }

    @FXML
    private void openVideo(MouseEvent event) {
        if (replays.getSelectionModel().getSelectedItem() != null) {
            try {
                String path=replays.getSelectionModel().getSelectedItem().trim();
                Desktop.getDesktop().open(new File("Replays//"+path));
            } catch (IOException ex) {
                Logger.getLogger(ReplaysController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     @FXML
    private void onBack(ActionEvent event) {
//        gameMediaPlayer.stop();
//        failMediaPlayer.stop();

        try {
            Pane main = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
            replayPane.getChildren().setAll(main);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

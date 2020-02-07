/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author yasmine
 */
public class Game extends Application {
        private Image applicationIcon;

        public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
         primaryStage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
          applicationIcon = new Image(new File("src//game//img//icon.png").toURI().toString());
        stage.getIcons().add(applicationIcon);
        
        Scene scene = new Scene(root);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

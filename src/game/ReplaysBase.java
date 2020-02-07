package game;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class ReplaysBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ListView replays;
    protected final Button back;

    public ReplaysBase() {

        imageView = new ImageView();
        replays = new ListView();
        back = new Button();

        setPrefHeight(650.0);
        setPrefWidth(650.0);

        imageView.setFitHeight(728.0);
        imageView.setFitWidth(714.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("img/background.jpeg").toExternalForm()));

        replays.setFixedCellSize(0.0);
        replays.setOnMouseClicked(this::openVideo);
        replays.setPrefHeight(567.0);
        replays.setPrefWidth(650.0);
        replays.getStylesheets().add("/game/list.css");
        

        back.setLayoutX(7.0);
        back.setLayoutY(576.0);
        back.setMnemonicParsing(false);
        back.setOnAction(this::onBack);
        back.setPrefHeight(74.0);
        back.setPrefWidth(170.0);
        back.setStyle("-fx-background-color: transparent;");
        back.setText("WHITE");
        back.setTextFill(javafx.scene.paint.Color.valueOf("#ff892efc"));
        back.setFont(new Font("Britannic Bold", 40.0));

        getChildren().add(imageView);
        getChildren().add(replays);
        getChildren().add(back);

    }

    protected abstract void openVideo(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void onBack(javafx.event.ActionEvent actionEvent);

}

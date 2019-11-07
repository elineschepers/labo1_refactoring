package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ItemListener;

public class FxApp {

    private Stage stage = new Stage();
    private Scene playerScene;
    private Label diceLabel;
    private Button playButton;
    private Label messageLabel;

    private int spelerNummer;

    public FxApp(int spelerNummer){
        VBox root = new VBox();
        this.spelerNummer = spelerNummer;
        diceLabel = new javafx.scene.control.Label("beurt 1: ");
        playButton = new Button("Werp dobbelstenen");
        root.getChildren().add(playButton);

        //playButton.setOnAction(new PlayerView.ThrowDicesHandler());
        playButton.setDisable(true);
        messageLabel = new Label("Spel nog niet gestart");
        root.getChildren().add(messageLabel);
        layoutComponents();
        stage.setScene(playerScene);
        stage.setTitle("Speler "+spelerNummer);
        stage.setResizable(false);
        stage.setX(100+(spelerNummer-1) * 350);
        stage.setY(200);
        stage.show();
    }

    private void layoutComponents() {
        VBox root = new VBox(10);
        playerScene = new Scene(root,250,100);
        root.getChildren().add(diceLabel);
        root.getChildren().add(messageLabel);
    }

}
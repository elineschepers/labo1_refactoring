package view;

import domain.Dice;
import domain.DiceGame;
import domain.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView implements Observer {
	private Stage stage = new Stage();

	private DiceGame diceGame; //todo
	private Scene playerScene;
	private Label diceLabel;
	private Button playButton;
	private Label messageLabel; 
	
	private int spelerNummer, aantalBeurtenGespeeld, vorigeResultaat, huidigeResultaat, totaalResultaat;
	
	public PlayerView(int spelerNummer){
		diceGame = new DiceGame();

		this.spelerNummer = spelerNummer;

		diceLabel = new Label("Beurt 1: ");

		playButton = new Button("Werp dobbelstenen");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);

		messageLabel = new Label("Spel nog niet gestart");

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
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);			
	}
	
	public void isAanBeurt(boolean aanBeurt){
		playButton.setDisable(!aanBeurt);		
	}

	@Override
	public void update(int spelerNummer, int aantalBeurtenGespeeld, int vorigeResultaat, int huidigeResultaat, int totaalResultaat) {
		this.spelerNummer = spelerNummer;
		this.aantalBeurtenGespeeld = aantalBeurtenGespeeld;
		this.vorigeResultaat = vorigeResultaat;
		this.huidigeResultaat = huidigeResultaat;
		this.totaalResultaat = totaalResultaat;
	}

	class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	diceGame.verwerkWorp(spelerNummer);
        }
    }
}

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
	private DiceGame dicegame;

	private Scene playerScene;
	private Label diceLabel;
	private Button playButton;
	private Label messageLabel; 
	
	private int spelerNummer, aantalBeurtenGespeeld, vorigeResultaat, huidigeResultaat, totaalResultaat;
	
	public PlayerView(DiceGame dg, int nr){
		diceLabel = new Label("Beurt " + dg.getSpelerBySpelersnr(nr).getAantalBeurtenGespeeld() + ":");
		playButton = new Button("Werp dobbelstenen");
		
		/*
		if (nr == 1 &&
			dg.getSpelerBySpelersnr(1).getAantalBeurtenGespeeld() == dg.getSpelerBySpelersnr(2).getAantalBeurtenGespeeld() &&
			dg.getSpelerBySpelersnr(1).getAantalBeurtenGespeeld() == dg.getSpelerBySpelersnr(3).getAantalBeurtenGespeeld()) {
			playButton = new Button("Werp dobbelstenen");
		} else if (nr == 2 &&
				   dg.getSpelerBySpelersnr(2).getAantalBeurtenGespeeld() < dg.getSpelerBySpelersnr(1).getAantalBeurtenGespeeld() &&
		 		   dg.getSpelerBySpelersnr(2).getAantalBeurtenGespeeld() == dg.getSpelerBySpelersnr(3).getAantalBeurtenGespeeld()) {
			playButton = new Button("Werp dobbelstenen");
		} else if (nr == 3 &&
				   dg.getSpelerBySpelersnr(3).getAantalBeurtenGespeeld() < dg.getSpelerBySpelersnr(2).getAantalBeurtenGespeeld()) {
			playButton = new Button("Werp dobbelstenen");
		} else {
			playButton = new Button("Werp dobbelstenen");
			playButton.setDisable(true);
		} */

		setItems(dg, nr);

		playButton.setOnAction(new ThrowDicesHandler());

		if (vorigeResultaat == 0 && huidigeResultaat == 0 && totaalResultaat == 0) {
			messageLabel = new Label("Spel nog niet gestart");
		} else {
			messageLabel = new Label("Net behaald resultaat: " + huidigeResultaat);
		}

		layoutComponents();

		stage.setScene(playerScene);
		stage.setTitle("Speler "+ spelerNummer);
		stage.setResizable(false);		
		stage.setX(100+(spelerNummer-1) * 350);
		stage.setY(200);
		stage.show();
	}

	public void setItems(DiceGame dg, int nr) {
		dicegame = dg;
		spelerNummer = nr;
	}

	public int getSpelersNr() {
		return spelerNummer;
	}

	public DiceGame getGame() {
		return dicegame;
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

		diceLabel.setText("Beurt " + getGame().getSpelerBySpelersnr(getSpelersNr()).getAantalBeurtenGespeeld() + ":");
		messageLabel.setText("Score van deze worp: " + huidigeResultaat);
	}

	class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	getGame().verwerkWorp(getGame().getSpelerBySpelersnr(getSpelersNr()));
        }
    }
}

package view;

import domain.Observer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoreView implements Observer {
	private Stage stage = new Stage();
	private Scene scoreScene;
	private Label scoreLabel;

	private int spelernr1Tot, spelernr2Tot;
	private int spelerNummer, aantalBeurtenGespeeld, vorigeResultaat, huidigeResultaat, totaalResultaat;
		
	public ScoreView(){
		scoreLabel = new Label();
		scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");

		layoutComponents();
		stage.setScene(scoreScene);
		stage.setTitle("Overzicht scores");
		stage.setResizable(false);		
		stage.setX(100);
		stage.setY(400);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox();
		scoreScene = new Scene(root,400,200);
		root.getChildren().add(scoreLabel);
	}

	private void saveStatsSp1(int totaal) {
		this.spelernr1Tot = totaal;
	}

	private void saveStatsSp2(int totaal) {
		this.spelernr2Tot = totaal;
	}

	private int getStatSp1() {
		return spelernr1Tot;
	}

	private int getStatSp2() {
		return spelernr2Tot;
	}

	
	private void voegScoreLijnToe(int statSp3){
		scoreLabel.setText(scoreLabel.getText() + "\n" + "Beurt 1: sp1: " + getStatSp1() + " sp2: " + getStatSp2() + " sp3: " + statSp3);
	}

	@Override
	public void update(int spelerNummer, int aantalBeurtenGespeeld, int vorigeResultaat, int huidigeResultaat, int totaalResultaat) {
		this.spelerNummer = spelerNummer;
		this.aantalBeurtenGespeeld = aantalBeurtenGespeeld;
		this.vorigeResultaat = vorigeResultaat;
		this.huidigeResultaat = huidigeResultaat;
		this.totaalResultaat = totaalResultaat;

		if (spelerNummer == 1) {
			this.saveStatsSp1(totaalResultaat);
		} else if (spelerNummer == 2) {
			this.saveStatsSp2(totaalResultaat);
		} else if (spelerNummer == 3) {
			this.voegScoreLijnToe(totaalResultaat);
		}
	}
}

package application;
	
import domain.Dice;
import domain.DiceGame;
import domain.Observable;
import domain.Player;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableArray;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		DiceGame dg = new DiceGame();

		Player p1 = new Player("Eline", 1);
		Player p2 = new Player("Keanu", 2);
		Player p3 = new Player("Phloy", 3);

		dg.addPlayerToGame(p1);
		dg.addPlayerToGame(p2);
		dg.addPlayerToGame(p3);

		PlayerView pv1 = new PlayerView(dg, p1.getSpelersnummer());
		PlayerView pv2 = new PlayerView(dg, p2.getSpelersnummer());
		PlayerView pv3 = new PlayerView(dg, p3.getSpelersnummer());

		ScoreView sv = new ScoreView();

		p1.addObserver(pv1);
		p1.addObserver(sv);

		p2.addObserver(pv2);
		p2.addObserver(sv);

		p3.addObserver(pv3);
		p3.addObserver(sv);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

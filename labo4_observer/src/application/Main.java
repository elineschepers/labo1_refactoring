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
		Player p = new Player();
		PlayerView pv = new PlayerView(p.getSpelersnummer());
		ScoreView sv = new ScoreView();

		p.addObserver(pv);
		p.addObserver(sv);

		DiceGame dg = new DiceGame();

		Player p1 = new Player("Eline", 1);
		Player p2 = new Player("Keanu", 2);
		Player p3 = new Player("Phloy", 3);

		dg.addPlayerToGame(p1);
		dg.addPlayerToGame(p2);
		dg.addPlayerToGame(p3);

		dg.verwerkWorp();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

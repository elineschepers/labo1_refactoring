package application;
	
import domain.Dice;
import domain.DiceGame;
import domain.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		DiceGame dg = new DiceGame();
		dg.StartGame();

		Player p1 = new Player("Eline", 1);
		Player p2 = new Player("Keanu", 2);
		Player p3 = new Player("Phloy", 3);

		dg.addPlayerToGame(p1);
		dg.addPlayerToGame(p2);
		dg.addPlayerToGame(p3);

		//p1.addObserver();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

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
<<<<<<< Updated upstream
/*
=======
>>>>>>> Stashed changes
		new ScoreView();

			new ScoreView();

		PlayerView pv3 = new PlayerView(3);
		PlayerView pv2 = new PlayerView(2);
		PlayerView pv1 = new PlayerView(1);		
		pv1.isAanBeurt(true);
<<<<<<< Updated upstream
*/
=======


		dg.StartGame();


>>>>>>> Stashed changes
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

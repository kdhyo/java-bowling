package bowling;

import bowling.domain.Player;
import bowling.view.InputView;
import bowling.view.ScoreBoard;

public class BowlingGameApplication {

	private BowlingGameApplication() {
	}

	public static void main(String[] args) {
		String name = InputView.name();
		Player player = new Player(name);

		ScoreBoard.view(player.getFrame(), player.getName());
		while (player.isNotGameEnd()) {
			int score = InputView.score(player.currentRound());
			player = player.bowling(score);
			ScoreBoard.view(player.getFrame(), player.getName());
		}

	}

}

package bowling.view;

import bowling.domain.frame.Frame;
import java.util.List;

public class ScoreBoard {

	private static final String ROUND_BOARD = "|  NAME  |   01   |   02   |   03   |   04   |   05   |   06   |   07   |   08   |   09   |   10   |";
	private static final String NAME_FORMAT = "|   %-3s  |";
	private static final String FRAME_FORMAT = "  %-5s |";
	private static final String DEFAULT_FORMAT = "        |";
	private static final int LAST_ROUND = 10;

	private ScoreBoard() {
	}

	public static void view(List<Frame> frames, String name) {
		System.out.println(ROUND_BOARD);

		StringBuilder scoreBoard = scoreBoardStart(name);
		int currentRound = frames.size();

		for (Frame frame : frames) {
			scoreBoard.append(String.format(FRAME_FORMAT, frame.frameScore()));
		}

		for (int i = currentRound; i < LAST_ROUND; i++) {
			scoreBoard.append(DEFAULT_FORMAT);
		}

		System.out.println(scoreBoard);
	}

	private static StringBuilder scoreBoardStart(String name) {
		return new StringBuilder(String.format(NAME_FORMAT, name));
	}

}
package bowling.domain.state;

import bowling.domain.Pins;

public class StartState implements State {

	private static final String FRAME_SCORE = "";

	public StartState() {
	}

	@Override
	public State bowling(Pins pins) {
		if (pins.isStrike()) {
			return new Strike();
		}
		return new NextState(pins);
	}

	@Override
	public boolean isCompleted() {
		return false;
	}

	@Override
	public String frameScore() {
		return FRAME_SCORE;
	}
}

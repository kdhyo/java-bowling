package bowling.domain.state;

import bowling.domain.Pins;

public class NextState implements State {

	@Override
	public State bowling(Pins pins) {
		return null;
	}

	@Override
	public boolean isCompleted() {
		return false;
	}

	@Override
	public String frameScore() {
		return null;
	}
}

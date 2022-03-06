package bowling.domain.state;

import bowling.domain.Pins;

public class Spare implements State {

	private final Pins pins;

	public Spare(Pins pins) {
		this.pins = pins;
	}

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

package bowling.domain.state;

import bowling.domain.Pins;

public class Miss implements State {

	private final Pins firstPins;
	private final Pins secondPins;

	public Miss(Pins firstPins, Pins secondPins) {
		this.firstPins = firstPins;
		this.secondPins = secondPins;
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

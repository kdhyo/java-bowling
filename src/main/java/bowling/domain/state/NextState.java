package bowling.domain.state;

import bowling.domain.Pins;

public class NextState implements State {

	private final Pins pins;

	public NextState(Pins pins) {
		this.pins = pins;
	}

	@Override
	public State bowling(Pins pins) {
		if (this.pins.isSpare(pins)) {
			return new Spare(this.pins);
		}

		Pins nextPins = this.pins.nextPins(pins);
		return new Miss(this.pins, nextPins);
	}

	@Override
	public boolean isCompleted() {
		return false;
	}

	@Override
	public String frameScore() {
		return String.valueOf(pins.pins());
	}

}

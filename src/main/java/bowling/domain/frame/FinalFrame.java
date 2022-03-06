package bowling.domain.frame;

import bowling.domain.Pins;

public class FinalFrame implements Frame {

	private final Pins firstPin;
	private final Pins secondPin;
	private final Pins bonusPin;

	public FinalFrame() {
		this(null, null, null);
	}

	private FinalFrame(Pins firstPin, Pins secondPin, Pins bonusPin) {
		this.firstPin = firstPin;
		this.secondPin = secondPin;
		this.bonusPin = bonusPin;
	}

	@Override
	public Frame bowling(int pins) {
		return null;
	}

	@Override
	public Frame nextFrame() {
		throw new RuntimeException("마지막 프레임 입니다.");
	}

	@Override
	public boolean isNext() {
		return false;
	}

	@Override
	public boolean hasGameEnd() {
		if (bonusPin != null || (firstPin != null && secondPin != null && firstPin.isSpare(secondPin))) {
			return true;
		}
		return false;
	}

}

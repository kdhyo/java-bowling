package bowling.domain.frame;

import bowling.domain.Pins;

public class FinalFrame implements Frame {

	private static final int ROUND = 10;
	private static final String EMPTY = "";

	private final Pins firstPin;
	private final Pins secondPin;
	private final Pins bonusPin;

	public FinalFrame() {
		this(null, null, null);
	}

	public FinalFrame(Pins firstPin) {
		this(firstPin, null, null);
	}

	public FinalFrame(Pins firstPin, Pins secondPin) {
		this(firstPin, secondPin, null);
	}

	private FinalFrame(Pins firstPin, Pins secondPin, Pins bonusPin) {
		this.firstPin = firstPin;
		this.secondPin = secondPin;
		this.bonusPin = bonusPin;
	}

	@Override
	public Frame bowling(int pins) {
		if (firstPin == null) {
			return new FinalFrame(Pins.hit(pins));
		}

		if (secondPin == null) {
			return new FinalFrame(firstPin, firstPin.nextPins(pins));
		}

		if (hasGameEnd()) {
			throw new RuntimeException("종료된 게임 입니다.");
		}

		return new FinalFrame(firstPin, secondPin, Pins.hit(pins));
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
		if (bonusPin != null) {
			return true;
		}

		if (firstPin != null && firstPin.isStrike()) {
			return false;
		}

		if (firstPin != null && secondPin != null) {
			return !firstPin.isSpare(secondPin);
		}

		return false;
	}

	@Override
	public String frameScore() {
		if (firstPin != null && secondPin != null && bonusPin != null) {
			StringBuilder sb = new StringBuilder();
			if (firstPin.isSpare(secondPin)) {
				sb.append(String.format("%d|/", firstPin.pins()));
				if (bonusPin.isStrike()) {
					sb.append("X");
					return sb.toString();
				}
				sb.append(String.format("|%d", bonusPin.pins()));
				return sb.toString();
			}
		}


		if (firstPin == null) {
			return EMPTY;
		}

		if (firstPin.isStrike()) {
			return "X";
		}

		return null;
	}

}

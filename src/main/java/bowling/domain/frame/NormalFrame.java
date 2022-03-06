package bowling.domain.frame;

import bowling.domain.Pins;

public class NormalFrame implements Frame {

	private static final int FIRST_ROUND = 1;
	private static final int LAST_ROUND = 10;
	private static final String EMPTY = "";

	private final Pins firstPin;
	private final Pins secondPin;
	private final int round;

	public static Frame start() {
		return new NormalFrame(null, null, FIRST_ROUND);
	}

	private NormalFrame(int nextRound) {
		this(null, null, nextRound);
	}

	private NormalFrame(Pins firstPin, int round) {
		this(firstPin, null, round);
	}

	private NormalFrame(Pins firstPin, Pins secondPin, int round) {
		this.firstPin = firstPin;
		this.secondPin = secondPin;
		this.round = round;
	}

	@Override
	public Frame bowling(int pins) {
		if (isNext()) {
			throw new RuntimeException("현재 프레임은 완료된 프레임 입니다.");
		}

		if (firstPin == null) {
			return new NormalFrame(Pins.hit(pins), round);
		}

		Pins secondPins = firstPin.nextPins(pins);
		return new NormalFrame(firstPin, secondPins, round);
	}

	@Override
	public Frame nextFrame() {
		if (isNext()) {
			int nextRound = round + 1;
			return nextFrame(nextRound);
		}

		throw new RuntimeException("다음 프레임으로 넘어갈 수 없습니다.");
	}

	@Override
	public boolean isNext() {
		return (firstPin != null && firstPin.isStrike()) || secondPin != null;
	}

	@Override
	public boolean hasGameEnd() {
		return false;
	}

	@Override
	public String frameScore() {
		if (firstPin == null) {
			return EMPTY;
		}

		if (firstPin.isStrike()) {
			return "X";
		}

		if (firstPin.isSpare(secondPin)) {
			return String.format("%d|/", firstPin.pins());
		}

		return String.format("%d|%d", firstPin.pins(), secondPin.pins());
	}

	private Frame nextFrame(int nextRound) {
		if (nextRound == LAST_ROUND) {
			return new FinalFrame();
		}
		return new NormalFrame(nextRound);
	}

}

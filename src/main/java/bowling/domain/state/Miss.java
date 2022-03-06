package bowling.domain.state;

import bowling.domain.Pins;

public class Miss implements State {

	private static final String FRAME_SCORE_FORMAT = "%d|%d";

	private final Pins firstPins;
	private final Pins secondPins;

	public Miss(Pins firstPins, Pins secondPins) {
		valid(firstPins, secondPins);
		this.firstPins = firstPins;
		this.secondPins = secondPins;
	}

	private void valid(Pins firstPins, Pins secondPins) {
		if (firstPins.isStrike() || firstPins.isSpare(secondPins)) {
			throw new IllegalArgumentException("올바르지 않은 점수 입니다.");
		}
	}

	@Override
	public State bowling(Pins pins) {
		throw new RuntimeException("종료된 프레임 입니다. 새 프레임 혹은 새 게임을 시작해주세요.");
	}

	@Override
	public boolean isCompleted() {
		return true;
	}

	@Override
	public String frameScore() {
		return String.format(FRAME_SCORE_FORMAT, firstPins.pins(), secondPins.pins());
	}
}

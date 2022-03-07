package bowling.domain.state;

import bowling.domain.Pins;

public class Spare implements State {

	private static final String FRAME_SCORE_FORMAT = "%s|/";

	private final Pins pins;

	public Spare(Pins pins) {
		valid(pins);
		this.pins = pins;
	}

	private void valid(Pins pins) {
		if (pins.isStrike()) {
			throw new IllegalArgumentException("해당 공은 스트라이크 입니다.");
		}
	}

	@Override
	public State bowling(Pins pins) {
		throw new RuntimeException("스페어로 남아있는 핀이 없습니다. 새 프레임 혹은 새 게임을 시작해주세요.");
	}

	@Override
	public boolean isCompleted() {
		return true;
	}

	@Override
	public String frameScore() {
		return String.format(FRAME_SCORE_FORMAT, pins.pins());
	}

}

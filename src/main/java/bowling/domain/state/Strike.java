package bowling.domain.state;

import bowling.domain.Pins;

public class Strike implements State {

	private static final String FRAME_SCORE_FORMAT = "X";

	@Override
	public State bowling(Pins pins) {
		throw new RuntimeException("스트라이크로 남아있는 핀이 없습니다. 새 프레임 혹은 새 게임을 시작해주세요.");
	}

	@Override
	public boolean isCompleted() {
		return true;
	}

	@Override
	public String frameScore() {
		return FRAME_SCORE_FORMAT;
	}
}

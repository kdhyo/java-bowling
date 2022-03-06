package bowling.domain.frame;

import bowling.domain.Pins;
import bowling.domain.state.StartState;
import bowling.domain.state.State;

public class NormalFrame implements Frame {

	private static final int FIRST_ROUND = 1;
	private static final int LAST_ROUND = 10;

	private final State state;
	private final int round;

	public static Frame start() {
		return new NormalFrame(FIRST_ROUND);
	}

	private NormalFrame(int round) {
		this(new StartState(), round);
	}

	private NormalFrame(State state, int round) {
		this.state = state;
		this.round = round;
	}

	@Override
	public Frame bowling(int pins) {
		if (isNext()) {
			throw new RuntimeException("현재 프레임은 완료된 프레임 입니다.");
		}

		return new NormalFrame(state.bowling(Pins.hit(pins)), round);
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
		return state.isCompleted();
	}

	@Override
	public boolean hasGameEnd() {
		return false;
	}

	@Override
	public String frameScore() {
		return state.frameScore();
	}

	private Frame nextFrame(int nextRound) {
		if (nextRound == LAST_ROUND) {
			return new FinalFrame();
		}
		return new NormalFrame(nextRound);
	}

}

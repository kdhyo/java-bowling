package bowling.domain.frame;

import bowling.domain.Pins;
import bowling.domain.state.Miss;
import bowling.domain.state.Spare;
import bowling.domain.state.StartState;
import bowling.domain.state.State;
import bowling.domain.state.Strike;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class FinalFrame implements Frame {

	private static final String DELIMITER = "|";
	private static final int MAXIMUM_COUNT = 3;
	private static final int END_COUNT = 0;

	private final Deque<State> states;
	private final int count;

	public FinalFrame() {
		this(new ArrayDeque<>(Collections.singletonList(new StartState())), MAXIMUM_COUNT);
	}

	private FinalFrame(Deque<State> states, int count) {
		this.states = states;
		this.count = count;
	}

	@Override
	public Frame bowling(int pins) {
		if (hasGameEnd()) {
			throw new RuntimeException("종료된 게임 입니다.");
		}

		if (hasNextStep()) {
			states.addLast(new StartState());
		}

		State currentState = states.removeLast();
		currentState = currentState.bowling(Pins.hit(pins));
		states.addLast(currentState);

		return new FinalFrame(states, count - 1);
	}

	@Override
	public Frame nextFrame() {
		throw new RuntimeException("마지막 프레임 입니다.");
	}

	@Override
	public String frameScore() {
		return states.stream()
			.map(State::frameScore)
			.collect(Collectors.joining(DELIMITER));
	}

	@Override
	public boolean isNext() {
		return false;
	}

	@Override
	public boolean hasGameEnd() {
		State first = states.peekFirst();

		if (first instanceof Miss) {
			return true;
		}

		return hasMaxPins(first) && count == END_COUNT;
	}

	private boolean hasMaxPins(State first) {
		return first instanceof Strike || first instanceof Spare;
	}

	private boolean hasNextStep() {
		return hasMaxPins(this.states.peekLast()) && this.count > END_COUNT;
	}

}

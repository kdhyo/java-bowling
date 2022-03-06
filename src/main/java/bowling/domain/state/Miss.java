package bowling.domain.state;

public class Miss implements State {

	@Override
	public State bowling(int pins) {
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

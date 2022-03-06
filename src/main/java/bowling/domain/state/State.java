package bowling.domain.state;

import bowling.domain.Pins;

public interface State {

	State bowling(Pins pins);

	boolean isCompleted();

	String frameScore();

}

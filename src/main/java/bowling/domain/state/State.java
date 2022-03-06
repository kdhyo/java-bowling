package bowling.domain.state;

public interface State {

	State bowling(int pins);

	boolean isCompleted();

	String frameScore();

}

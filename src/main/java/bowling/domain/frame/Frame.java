package bowling.domain.frame;

public interface Frame {

	Frame bowling(int pins);

	Frame nextFrame();

	boolean isNext();

	boolean hasGameEnd();

}

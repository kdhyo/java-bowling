package bowling.domain.frame;

import bowling.domain.Pins;

public interface Frame {

	Frame bowling(int pins);

	Frame nextFrame();

	boolean isNext();

}

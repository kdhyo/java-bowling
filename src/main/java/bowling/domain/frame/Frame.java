package bowling.domain.frame;

import bowling.domain.Pins;

public interface Frame {

	Frame bowling(Pins pins);

	boolean isNext();

}

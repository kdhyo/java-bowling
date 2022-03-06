package bowling.domain.frame;

import bowling.domain.Pins;

public class NormalFrame implements Frame {

	@Override
	public Frame bowling(Pins pins) {
		return null;
	}

	@Override
	public boolean isNext() {
		return false;
	}

}

package bowling.domain.frame;

import bowling.domain.Pins;
import org.omg.CORBA.PRIVATE_MEMBER;

public class NormalFrame implements Frame {

	private static final int FIRST_ROUND = 1;
	private static final int LAST_ROUND = 10;

	private final int round;

	public static Frame start() {
		return new NormalFrame(FIRST_ROUND);
	}

	private NormalFrame(int round) {
		this.round = round;
	}

	@Override
	public Frame bowling(Pins pins) {
		return null;
	}

	@Override
	public boolean isNext() {
		return false;
	}

}

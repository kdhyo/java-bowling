package bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pins {

	private static final int MINIMUM_PIN_SIZE = 0;
	private static final int MAXIMUM_PIN_SIZE = 10;

	private static final List<Pins> PINS;

	private final int pins;

	static {
		PINS = IntStream.rangeClosed(MINIMUM_PIN_SIZE, MAXIMUM_PIN_SIZE)
			.mapToObj(Pins::new)
			.collect(Collectors.toCollection(ArrayList::new));
	}

	private Pins(int pins) {
		this.pins = pins;
	}

	public static Pins hit(int pins) {
		try {
			return PINS.get(pins);
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(String.format("핀의 수는 %d ~ %d 사이만 쓰러트릴 수 있습니다.", MINIMUM_PIN_SIZE, MAXIMUM_PIN_SIZE));
		}
	}

	public boolean isStrike() {
		return this.pins == MAXIMUM_PIN_SIZE;
	}

	public Pins nextPins(int pins) {
		if (this.pins + pins > MAXIMUM_PIN_SIZE) {
			throw new IllegalArgumentException(String.format("핀의 수는 %d ~ %d 사이만 쓰러트릴 수 있습니다.", MINIMUM_PIN_SIZE, MAXIMUM_PIN_SIZE));
		}
		return PINS.get(pins);
	}
}

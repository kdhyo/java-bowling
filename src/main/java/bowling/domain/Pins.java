package bowling.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Pins {

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 10;
    private static final Map<Integer, Pins> CACHE_PINS;

    private final int fallenPins;

    static {
        CACHE_PINS = new HashMap<>();
        IntStream.rangeClosed(MINIMUM, MAXIMUM)
            .forEach(num -> CACHE_PINS.put(num, new Pins(num)));
    }

    private Pins(int pins) {
        this.fallenPins = pins;
    }

    public static Pins of(int count) {
        valid(count);
        return CACHE_PINS.get(count);
    }

    public boolean isStrike() {
        return this.fallenPins == MAXIMUM;
    }

    public boolean isSpare(Pins pins) {
        return this.fallenPins < MAXIMUM && (this.fallenPins + pins.fallenPins) == MAXIMUM;
    }

    public boolean isGutter() {
        return this.fallenPins == MINIMUM;
    }

    public int fallenPins() {
        return this.fallenPins;
    }

    private static void valid(int pins) {
        if (pins < MINIMUM) {
            throw new IllegalArgumentException(String.format("쓰러트린 핀의 수는 %d 개 보다 작을 수 없습니다.", MINIMUM));
        }

        if (pins > MAXIMUM) {
            throw new IllegalArgumentException(String.format("쓰러트린 핀의 수는 %d 개 보다 클 수 없습니다.", MAXIMUM));
        }
    }

}

package bowling.domain.state;

import bowling.domain.Pins;

public class Mess extends Finished {

    private static final String MARKING = "%s|%s";
    private static final String ZERO_MARKING = "-";
    private static final int MAX_PINS_COUNT = 9;

    private final Pins firstPins;
    private final Pins secondPins;

    public Mess(Pins firstPins, Pins secondPins) {
        valid(firstPins, secondPins);
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    @Override
    public String mark() {
        return String.format(MARKING, countOfString(firstPins), countOfString(secondPins));
    }

    private String countOfString(Pins pins) {
        if (pins.isGutter()) {
            return ZERO_MARKING;
        }
        return String.valueOf(pins.fallenPins());
    }

    private void valid(Pins firstPins, Pins secondPins) {
        if (firstPins.sumFallenPins(secondPins) > MAX_PINS_COUNT) {
            throw new IllegalArgumentException(String.format("쓰러진 핀의 최대 수는 %d을 넘을 수 없습니다.", MAX_PINS_COUNT));
        }
    }

}

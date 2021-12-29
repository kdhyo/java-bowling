package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;

class StrikeTest {

    @Test
    void create() {
        assertThat(new Strike(Pins.of(10))).isInstanceOf(Strike.class);
    }

    @Test
    void notStrike() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Strike(Pins.of(9)));
    }

    @Test
    void isFinished() {
        assertThat(new Strike(Pins.of(10)).isFinished()).isTrue();
    }

}
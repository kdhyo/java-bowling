package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PinsTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	void 생성_성공(int pins) {
		assertThat(new Pins(pins)).isInstanceOf(Pins.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -2, 11, 12})
	void 잘못된_핀_수(int pins) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Pins(pins));
	}

}

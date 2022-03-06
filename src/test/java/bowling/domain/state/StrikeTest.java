package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StrikeTest {

	@Test
	void 추가_bowling_시_예외처리() {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> Strike.strike(Pins.hit(10)).bowling(Pins.hit(1)));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
	void 미스가_아닌_경우(int pins) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Strike.strike(Pins.hit(pins)));
	}

	@Test
	void 완료상태() {
		assertThat(Strike.strike(Pins.hit(10)).isCompleted()).isTrue();
	}

	@Test
	void frameScore() {
		assertThat(Strike.strike(Pins.hit(10)).frameScore()).isEqualTo("X");
	}

}
package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpareTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	void 추가_bowling_시_예외처리(int pins) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Spare(Pins.hit(1)).bowling(Pins.hit(pins)));
	}

	@Test
	void 스페어가_아닌_경우() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Spare(Pins.hit(10)));
	}

	@Test
	void 완료상태() {
		assertThat(new Spare(Pins.hit(9)).isCompleted()).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void frameScore(int pins) {
		assertThat(new Spare(Pins.hit(pins)).frameScore()).isEqualTo(String.valueOf(String.format("%d|/", pins)));
	}

}
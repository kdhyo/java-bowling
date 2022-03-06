package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;

class MissTest {

	@Test
	void 추가_bowling_시_예외처리() {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Miss(Pins.hit(5), Pins.hit(4)).bowling(Pins.hit(1)));
	}

	@Test
	void 미스가_아닌_경우() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Miss(Pins.hit(10), Pins.hit(0)));

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Miss(Pins.hit(9), Pins.hit(1)));
	}

	@Test
	void 완료상태() {
		assertThat(new Miss(Pins.hit(0), Pins.hit(9)).isCompleted()).isTrue();
	}

	@Test
	void frameScore() {
		assertThat(new Miss(Pins.hit(5), Pins.hit(4)).frameScore()).isEqualTo("5|4");
	}

}
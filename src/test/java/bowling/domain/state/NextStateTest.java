package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NextStateTest {

	@Test
	void 스페어_생성() {
		NextState state = new NextState(Pins.hit(6));
		assertThat(state.bowling(Pins.hit(4))).isInstanceOf(Spare.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
	void 미스_생성(int pins) {
		NextState state = new NextState(Pins.hit(1));
		assertThat(state.bowling(Pins.hit(pins))).isInstanceOf(Miss.class);
	}

	@Test
	void 완료상태() {
		assertThat(new NextState(Pins.hit(1)).isCompleted()).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void frameScore(int pins) {
		assertThat(new NextState(Pins.hit(pins)).frameScore()).isEqualTo(String.valueOf(pins));
	}

}
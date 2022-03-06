package bowling.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.Pins;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StartStateTest {

	@Test
	void 스트라이크_생성() {
		StartState state = new StartState();
		assertThat(state.bowling(Pins.hit(10))).isInstanceOf(Strike.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void 다음상태_생성(int pins) {
		StartState state = new StartState();
		assertThat(state.bowling(Pins.hit(pins))).isInstanceOf(NextState.class);
	}

	@Test
	void 완료상태() {
		assertThat(new StartState().isCompleted()).isFalse();
	}

	@Test
	void frameScore() {
		assertThat(new StartState().frameScore()).isEqualTo("");
	}

}
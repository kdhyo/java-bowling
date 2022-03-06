package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FinalFrameTest {

	private Frame frame;

	@BeforeEach
	void init() {
		frame = new FinalFrame();
	}

	@Test
	void 스페어_보너스게임_진행() {
		frame = frame.bowling(5);
		frame = frame.bowling(5);
		frame = frame.bowling(10);

		assertThat(frame.hasGameEnd()).isTrue();
	}

	@Test
	void 스트라이크_보너스게임_진행() {
		frame = frame.bowling(10);
		frame = frame.bowling(10);
		frame = frame.bowling(10);

		assertThat(frame.hasGameEnd()).isTrue();
	}

	@Test
	void 보너스게임_실패() {
		frame = frame.bowling(5);
		frame = frame.bowling(4);
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> frame.bowling(10));
	}

	@Test
	void 게임종료후_게임진행시_예외처리() {
		frame = frame.bowling(10);
		frame = frame.bowling(10);
		frame = frame.bowling(10);

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> frame.bowling(10));
	}

}
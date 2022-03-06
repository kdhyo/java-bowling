package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FramesTest {

	private Frames frames;

	@BeforeEach
	void init() {
		frames = new Frames();
	}

	@Test
	void 마지막_프레임까지_진행() {
		while (frames.isNotGameEnd()) {
			frames = frames.bowling(10);
		}

		assertThat(frames.currentRound()).isEqualTo(10);
	}

	@Test
	void 게임종료_예외처리() {
		while (frames.isNotGameEnd()) {
			frames = frames.bowling(10);
		}

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> frames.bowling(10));
	}

}

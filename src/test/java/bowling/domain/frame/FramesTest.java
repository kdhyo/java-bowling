package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;

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
		if (frames.isNotGameEnd()) {
			frames = frames.bowl(10);
		}
		
		assertThat(frames.isRound()).isEqaulTo(10);
	}

}

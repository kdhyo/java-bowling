package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NormalFrameTest {

	@Test
	void 게임시작() {
		assertThat(NormalFrame.start()).isInstanceOf(NormalFrame.class);
	}

}
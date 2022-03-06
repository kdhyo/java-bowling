package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.domain.Pins;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NormalFrameTest {

	@Test
	void 게임시작() {
		assertThat(NormalFrame.start()).isInstanceOf(NormalFrame.class);
	}

	@Test
	@DisplayName("NormalFrame 스트라이크 9번 시 마지막 FinalFrame 객체 체크")
	void bowling() {
		// given
		Frame frame = NormalFrame.start();

		// when
		for (int i = 0; i < 9; i++) {
			frame = frame.bowling(Pins.hit(10));
		}

		// then
		assertThat(frame).isInstanceOf(FinalFrame.class);
	}

}
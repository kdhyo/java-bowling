package bowling.domain.frame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NormalFrameTest {

	private Frame frame;

	@BeforeEach
	void init() {
		frame = NormalFrame.start();
	}

	@Test
	void 게임시작() {
		assertThat(NormalFrame.start()).isInstanceOf(NormalFrame.class);
	}

	@Test
	void 다음프레임_생성() {
		frame = frame.bowling(10);

		assertThat(frame.isNext()).isTrue();
		assertThat(frame.nextFrame()).isNotEqualTo(frame);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void 다음프레임_생성실패(int pins) {
		frame = frame.bowling(pins);

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> frame.nextFrame());
	}

	@Test
	void 한프레임내_핀수_초과() {
		frame = frame.bowling(6);

		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> frame.bowling(5));
	}

	@Test
	@DisplayName("NormalFrame 스트라이크 9번 시 마지막 FinalFrame 객체 체크")
	void bowling() {
		for (int i = 0; i < 9; i++) {
			frame = frame.bowling(10);
			frame = frame.nextFrame();
		}

		assertThat(frame).isInstanceOf(FinalFrame.class);
	}

}
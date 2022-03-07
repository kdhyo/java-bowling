package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class ScoreTest {

	@Test
	void 생성_성공() {
		assertThat(new Score(10, 2)).isInstanceOf(Score.class);
	}

	@Test
	void 점수_최소보다_낮을시_예외처리() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Score(-1, 2));
	}

	@Test
	void 점수_최대보다_높을경우_예외처리() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Score(301, 0));
	}

	@Test
	void 최대점수_추가라운드_예외처리() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Score(300, 1));
	}

}

package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

	@Test
	void 생성_성공() {
		Player player = new Player("DHK");
		assertThat(player.getName()).isEqualTo("DHK");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void 인수가_없는경우(String name) {
		assertThatExceptionOfType(NullPointerException.class)
			.isThrownBy(() -> new Player(name));
	}

	@ParameterizedTest
	@ValueSource(strings = {"D", "DH"})
	void 이름이_길이가_최소보다_작을경우(String name) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Player(name));
	}

	@ParameterizedTest
	@ValueSource(strings = {"SKTT1", "DONGHYO", "YOON"})
	void 이름이_길이가_최대보다_클경우(String name) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Player(name));
	}

}

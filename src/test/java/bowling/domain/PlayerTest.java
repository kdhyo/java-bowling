package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void 생성_성공() {
		assertThat(new Player("DHK")).isInstanceOf(Player.class);
	}

}

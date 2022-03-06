package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void 생성_성공() {
		Player player = new Player("DHK");
		assertThat(player.getName()).isEqualTo("DHK");
	}

	@Test
	void 게임진행() {
		Player player = new Player("DHK");

		player.bowling(10);
		player.bowling(5);
		player.bowling(5);
		player.bowling(8);
		player.bowling(2);
		player.bowling(0);
		player.bowling(0);
		player.bowling(10);
		player.bowling(8);
		player.bowling(0);
		player.bowling(9);
		player.bowling(1);
		player.bowling(10);
		player.bowling(10);
		player.bowling(10);
		player.bowling(10);
		player.bowling(10);

		assertThat(player.isNotGameEnd()).isFalse();
	}


}

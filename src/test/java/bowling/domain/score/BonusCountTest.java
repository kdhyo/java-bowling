package bowling.domain.score;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusCountTest {

	@Test
	void 스트라이크_생성() {
		BonusCount bonusCount = BonusCount.strike();

		assertAll(
			() -> assertThat(bonusCount).isEqualTo(new BonusCount(2)),
			() -> assertThat(bonusCount.hasBonus()).isTrue()
		);
	}

	@Test
	void 스페어_생성() {
		BonusCount bonusCount = BonusCount.spare();

		assertAll(
			() -> assertThat(bonusCount).isEqualTo(new BonusCount(1)),
			() -> assertThat(bonusCount.hasBonus()).isTrue()
		);
	}

	@Test
	void 미스_생성() {
		BonusCount bonusCount = BonusCount.miss();

		assertAll(
			() -> assertThat(bonusCount).isEqualTo(new BonusCount(0)),
			() -> assertThat(bonusCount.hasBonus()).isFalse()
		);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	void 보너스범위_예외처리(int bonusCount) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new BonusCount(bonusCount));
	}

	@Test
	void decrease_감소확인() {
		BonusCount bonusCount = BonusCount.spare();
		BonusCount decreaseCount = bonusCount.decrease();

		assertThat(decreaseCount).isEqualTo(new BonusCount(0));
	}

}
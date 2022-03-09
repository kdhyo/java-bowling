package bowling.domain.score;

import java.util.Objects;

public class BonusCount {

	private static final int MINIMUM_COUNT = 0;
	private static final int MAXIMUM_COUNT = 2;
	private static final int STRIKE = 2;
	private static final int SPARE = 1;
	private static final int MISS = 0;

	private final int bonusCount;

	public BonusCount(int bonusCount) {
		valid(bonusCount);
		this.bonusCount = bonusCount;
	}

	public static BonusCount strike() {
		return new BonusCount(STRIKE);
	}

	public static BonusCount spare() {
		return new BonusCount(SPARE);
	}

	public static BonusCount miss() {
		return new BonusCount(MISS);
	}

	public boolean hasBonus() {
		return bonusCount > MINIMUM_COUNT;
	}

	public BonusCount decrease() {
		return new BonusCount(this.bonusCount - 1);
	}

	private void valid(int bonusCount) {
		if (MINIMUM_COUNT > bonusCount || bonusCount > MAXIMUM_COUNT) {
			throw new IllegalArgumentException(String.format("보너스 횟수는 %d ~ %d 사이만 가능합니다.", MINIMUM_COUNT, MAXIMUM_COUNT));
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BonusCount that = (BonusCount) o;
		return bonusCount == that.bonusCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonusCount);
	}

}

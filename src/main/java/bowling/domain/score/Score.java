package bowling.domain.score;

public class Score {

	private static final int MINIMUM_SCORE = 0;
	private static final int MAXIMUM_SCORE = 300;
	private static final int MINIMUM_BONUS = 0;
	private static final int MAXIMUM_BONUS = 2;

	private final int currentScore;
	private final int bonusCount;

	public Score(int currentScore, int bonusCount) {
		valid(currentScore, bonusCount);
		this.currentScore = currentScore;
		this.bonusCount = bonusCount;
	}

	public boolean hasBonus() {
		return bonusCount > MINIMUM_BONUS;
	}

	public Score addBonusScore(int currentScore) {
		int bonusCount = this.bonusCount - 1;
		if (bonusCount < MINIMUM_BONUS) {
			throw new RuntimeException("보너스 점수를 더할 수 없습니다.");
		}
		return new Score(this.currentScore + currentScore, bonusCount);
	}

	private void valid(int currentScore, int bonusCount) {
		if (MINIMUM_SCORE > currentScore || currentScore > MAXIMUM_SCORE) {
			throw new IllegalArgumentException(String.format("%d ~ %d 사이만 점수로 가능합니다.", MINIMUM_SCORE, MAXIMUM_SCORE));
		}

		if (MINIMUM_BONUS > bonusCount || bonusCount > MAXIMUM_BONUS) {
			throw new IllegalArgumentException(String.format("%d ~ %d 사이만 보너스 점수가 가능합니다.", MINIMUM_BONUS, MAXIMUM_BONUS));
		}

		if (MAXIMUM_SCORE == currentScore && bonusCount > MINIMUM_BONUS) {
			throw new IllegalArgumentException("최고 점수에서는 보너스점수를 받을 수 없습니다.");
		}
	}

}

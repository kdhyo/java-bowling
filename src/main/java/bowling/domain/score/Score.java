package bowling.domain.score;

public class Score {

	private static final int MINIMUM_SCORE = 0;
	private static final int MAXIMUM_SCORE = 30;
	private static final int MAXIMUM_PINS = 10;

	private final int currentScore;
	private final BonusCount bonusCount;

	public Score(int currentScore, int bonusCount) {
		this(currentScore, new BonusCount(bonusCount));
	}

	public Score(int currentScore, BonusCount bonusCount) {
		valid(currentScore);
		this.currentScore = currentScore;
		this.bonusCount = bonusCount;
	}

	public static Score strike() {
		return new Score(MAXIMUM_PINS, BonusCount.strike());
	}

	public static Score spare() {
		return new Score(MAXIMUM_PINS, BonusCount.strike());
	}

	public static Score miss(int score) {
		return new Score(score, BonusCount.strike());
	}

	public boolean hasBonus() {
		return bonusCount.hasBonus();
	}

	public Score addBonusScore(int currentScore) {
		return new Score(this.currentScore + currentScore, bonusCount.decrease());
	}

	private void valid(int currentScore) {
		if (MINIMUM_SCORE > currentScore || currentScore > MAXIMUM_SCORE) {
			throw new IllegalArgumentException(String.format("%d ~ %d 사이만 점수로 가능합니다.", MINIMUM_SCORE, MAXIMUM_SCORE));
		}
	}

}

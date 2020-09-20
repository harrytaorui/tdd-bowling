import java.util.stream.Stream;

public class BowlingGame {
	private static final int MAX_SCORE_PER_FRAME = 10;
	private int finalScore;
	private int[] rolls;

	public BowlingGame(String code) {
		rolls = getRolls(code);
		finalScore = countScore();
	}

	public int[] getRolls(String code) {
		return Stream.of(code.split(",")).mapToInt(Integer::parseInt).toArray();
	}

	public int countScore() {
		int frameIndex = 0;
		for (int frame = 1; frame < 11; frame++) {
			if (isStrike(frameIndex)) {
				finalScore += MAX_SCORE_PER_FRAME + strikeBonus(frameIndex);
				frameIndex++;
			} else if (isSpare(frameIndex)) {
				finalScore += MAX_SCORE_PER_FRAME + spareBonus(frameIndex);
				frameIndex += 2;
			} else {
				finalScore += rolls[frameIndex] + rolls[frameIndex + 1];
				frameIndex += 2;
			}
		}
		return finalScore;
	}


	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == MAX_SCORE_PER_FRAME;
	}

	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1] == MAX_SCORE_PER_FRAME;
	}

	private int strikeBonus(int frameIndex) {
		return isStrike(frameIndex + 1) ?
				MAX_SCORE_PER_FRAME + countFrameScore(frameIndex + 2) :
				countFrameScore(frameIndex + 1) + countFrameScore(frameIndex + 3);
	}

	private int spareBonus(int frameIndex) {
		return countFrameScore(frameIndex + 2);
	}

	private int countFrameScore(int frameIndex) {
		if (frameIndex > rolls.length - 1) {
			return 0;
		}
		return isStrike(frameIndex) || frameIndex == rolls.length - 1 ?
				rolls[frameIndex] : rolls[frameIndex] + rolls[frameIndex + 1];
	}

	public int getScore() {
		return finalScore;
	}
}

import static org.junit.Assert.*;
import org.junit.Test;

public class BowlingGameTest {
	@Test
	public void NO_Score_Test() {
		final int expectScore = 0;
		BowlingGame bowlingGame =
				new BowlingGame("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0");
		int actualScore = bowlingGame.getScore();
		assertEquals(expectScore, actualScore);
	}
}

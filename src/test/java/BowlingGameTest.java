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


	@Test
	public void Full_Strike_Test() {
		final int expectScore = 300;
		BowlingGame bowlingGame =
				new BowlingGame("10,10,10,10,10,10,10,10,10,10,10,10");
		int actualScore = bowlingGame.getScore();
		assertEquals(expectScore,actualScore);
	}

	@Test
	public void NO_Strike_With_Spare_Test() {
		final int expectScore = 91;
		BowlingGame bowlingGame =
				new BowlingGame("2,3,4,5,1,7,8,2,2,4,1,2,5,2,3,7,9,0,2,7");
		int actualScore = bowlingGame.getScore();
		assertEquals(expectScore, actualScore);
	}

	@Test
	public void Strike_And_Spare_Test() {
		final int expectScore = 95;
		BowlingGame bowlingGame =
				new BowlingGame("2,3,4,5,1,7,8,2,10,4,1,2,5,2,3,7,3,0,2");
		int actualScore = bowlingGame.getScore();
		assertEquals(expectScore, actualScore);
	}
}

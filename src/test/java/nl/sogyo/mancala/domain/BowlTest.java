package nl.sogyo.mancala.domain;
import org.junit.Assert;
import org.junit.Test;
import nl.sogyo.mancala.*;

public class BowlTest {
	
	@Test
	public void testGetStonesAtStart() {
		Bowl b = new Bowl(13);
		Assert.assertEquals(b.getNumStones(), 4);
	}
	
	@Test
	public void testGetStonesNextBowl() {
		Bowl b = new Bowl(13);
		Assert.assertEquals(b.getBowl(1).getNumStones(), 4);
	}
}

package nl.sogyo.mancala.domain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import nl.sogyo.mancala.*;

public class BowlTest {
	Player p1;
	Player p2;
	private int bowlSize;
	private Bowl b;
	
	@Test
	public void testGetStonesAtStart() {
		Assert.assertEquals(b.getNumStones(), bowlSize);
	}
	
	@Test
	public void testGetStonesNextBowl() {
		Assert.assertEquals(b.getBowl(1).getNumStones(),bowlSize - 1);
	}
	
	@Test
	public void testGetAllStones() {
		for (int i = 1; i < bowlSize; i++) {
			Assert.assertEquals(b.getBowl(i).getNumStones(),bowlSize - i);
		}
	}
	
	@Test 
	public void testGetFirstBowlStonesThroughLoop() {
		Assert.assertEquals(b.getBowl(14).getNumStones(),bowlSize);
	}
	
	@Test 
	public void testGetAllStonesThroughLoop() {
		for (int i = 14; i < bowlSize*2; i++) {
			Assert.assertEquals(b.getBowl(i).getNumStones(),bowlSize*2 - i + 1);
		}
	}
	
	@Test 
	public void testGetFirstKalaha() {
		Assert.assertEquals(b.getKalaha().getNumStones(),bowlSize - 6);
	}
	
	@Test
	public void testPassThreeStones() {
		b.pass(3);
		for (int i = 1; i < 4; i++) {
			Assert.assertEquals(b.getBowl(i).getNumStones(),bowlSize - i + 1);
		}
	}
	
	@Ignore @Test
	public void testPassOtherUserKalaha() {
		b.getBowl(12).pass(4);
		Assert.assertEquals(b.getBowl(13).getNumStones(),0);
	}
	
	@Test 
	public void testPlayerHasOpponent() {
		Assert.assertTrue(p1.getOpponent().isMyTurn());
		Assert.assertTrue(p2.getOpponent().isMyTurn());
	}
	
	@Before
	public void setup() {
		p1 = new Player(p2 = new Player(p1));
		p2 = new Player(p1);
		bowlSize = 13;
		b = new Bowl(bowlSize);
	}
	
}

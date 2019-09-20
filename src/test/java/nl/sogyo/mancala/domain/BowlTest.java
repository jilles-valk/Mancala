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
		Assert.assertEquals(4, b.getNumStones());
	}
	
	@Test
	public void testGetStonesNextBowl() {
		Assert.assertEquals(4, b.getBowl(1).getNumStones());
	}

	@Test 
	public void testGetFirstKalaha() {
		Assert.assertEquals(0, b.getKalaha().getNumStones());
	}
	
	@Test
	public void testPassThreeStones() {
		b.play(0);
		for (int i = 1; i < 5; i++) {
			Assert.assertEquals(4 + 1, b.getBowl(i).getNumStones());
		}
		Assert.assertEquals(4, b.getBowl(5).getNumStones());
	}
	
	@Test
	public void testPassOtherUserKalaha() {
		b.play(5);
		Assert.assertEquals(1, b.getKalaha().getNumStones());
		b.play(11);
		Assert.assertEquals(1, b.getBowl(11).getKalaha().getNumStones());
	}
	
	@Test 
	public void testBowlHasCorrectPlayer() {
		Assert.assertEquals(b.getPlayer().isMyTurn(), true);
		for (int i = 1; i < bowlSize+1; i++) {
			Assert.assertEquals(i <= 6, b.getBowl(i).getPlayer().isMyTurn());
		}
	}
	
	@Test 
	public void testPlay() {
		int toPlay = 4;
		b.play(toPlay);
		if (toPlay == 0) {
			Assert.assertEquals(0, b.getNumStones());
			Assert.assertEquals(5, b.getBowl(1).getNumStones());
		}
		else {
			Assert.assertEquals(0, b.getBowl(toPlay).getNumStones());
			Assert.assertEquals(5, b.getBowl(toPlay).getBowl(1).getNumStones());
		}
	}
	
	@Test
	public void testPlayKalaha() {
		b.play(6);
		Assert.assertEquals(0, b.getKalaha().getNumStones());
		Assert.assertEquals(4, b.getKalaha().getBowl(1).getNumStones());
	}
	
	@Ignore @Test //works when initial numStones is 1
	public void testIsGameOver() {
		for (int i = 0; i < 6; i++) {
			b.play(i);
		}
		Assert.assertTrue(b.isGameOver(0, 0));
	}
	
	@Test 
	public void testSwitchTurn() {
		Assert.assertTrue(b.getPlayer().isMyTurn());
		b.play(1);
		Assert.assertFalse(b.getPlayer().isMyTurn());
	}
	
	@Test
	public void testEndInEmptyBowlCurrentPlayer() {
		b.play(4);
		Assert.assertEquals(0, b.getBowl(4).getNumStones());
		b.play(7);
		Assert.assertEquals(0, b.getBowl(7).getNumStones());
		Assert.assertEquals(4, b.getNumStones());
		b.play(0);
		Assert.assertEquals(0, b.getBowl(4).getNumStones());
		Assert.assertEquals(8, b.getKalaha().getNumStones());
	}
	
	@Test
	public void testEndInEmptyBowlOtherPlayer() {
		b.play(0);
		Assert.assertEquals(0, b.getNumStones());
		b.play(10);
		Assert.assertEquals(1, b.getBowl(10).getKalaha().getNumStones());
		Assert.assertEquals(0, b.getKalaha().getNumStones());
		Assert.assertEquals(5, b.getBowl(1).getNumStones());
	}
	
	@Before
	public void setup() {
		p1 = new Player(true);
		p2 = p1.getOpponent();
		bowlSize = 13;
		b = new Bowl(p1, bowlSize);
	}
	
}

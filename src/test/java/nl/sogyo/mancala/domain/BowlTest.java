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
		Assert.assertEquals("[4]", b.getBowlInfo(0));
	}
	
	@Test
	public void testGetStonesNextBowl() {
		Assert.assertEquals("[4]", b.getBowlInfo(1));
	}

	@Test 
	public void testGetFirstKalaha() {
		Assert.assertEquals("{0}", b.getBowlInfo(6));
	}
	
	@Test
	public void testPassThreeStones() {
		b.play(0);
		for (int i = 1; i < 5; i++) {
			Assert.assertEquals("[5]", b.getBowlInfo(i));
		}
		Assert.assertEquals("[4]", b.getBowlInfo(5));
	}
	
	@Test
	public void testPassOtherUserKalaha() {
		b.play(0);
		b.play(8);
		b.play(1);
		b.play(8);
		b.play(2);
		b.play(7);
		b.play(3);
		b.play(9);
		b.play(1);
		b.play(10);
		Assert.assertEquals("{2}", b.getBowlInfo(13));
		b.play(4);
		Assert.assertEquals("{4}", b.getBowlInfo(6));
		Assert.assertEquals("{2}", b.getBowlInfo(13));
	}
	
	@Test 
	public void testPlay() {
		int toPlay = 4;
		b.play(toPlay);
		Assert.assertEquals("[0]", b.getBowlInfo(toPlay));
		Assert.assertEquals("[5]", b.getBowlInfo(toPlay + 4));
		Assert.assertEquals("[4]", b.getBowlInfo(toPlay + 5));
	}

	@Test
	public void testPlayKalaha() {
		b.play(6);
		Assert.assertEquals("{0}", b.getBowlInfo(6));
		Assert.assertEquals("[4]", b.getBowlInfo(7));
		b.play(0);
		Assert.assertEquals("[0]", b.getBowlInfo(0));
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
		b.play(1);
		Assert.assertEquals("[0]", b.getBowlInfo(1));
		b.play(2);
		Assert.assertEquals("[0]", b.getBowlInfo(1));
		b.play(7);
		Assert.assertEquals("[0]", b.getBowlInfo(7));
	}
	
	@Test
	public void testEndInEmptyBowlCurrentPlayer() {
		b.play(4);
		Assert.assertEquals("[0]", b.getBowlInfo(4));
		b.play(7);
		Assert.assertEquals("[0]", b.getBowlInfo(7));
		b.play(0);
		Assert.assertEquals("[0]", b.getBowlInfo(0));
		Assert.assertEquals("{8}", b.getBowlInfo(6));
	}
	
	@Test
	public void testEndInEmptyBowlOtherPlayer() {
		b.play(0);
		Assert.assertEquals("[0]", b.getBowlInfo(0));
		b.play(10);
		Assert.assertEquals("{1}", b.getBowlInfo(13));
		Assert.assertEquals("{0}", b.getBowlInfo(6));
		Assert.assertEquals("[1]", b.getBowlInfo(0));
		Assert.assertEquals("[5]", b.getBowlInfo(12));
	}
	
	@Test
	public void testTakeStonesWhenPutDuringCurrentTurn() {
		b.play(5);
		b.play(7);
		b.play(2);
		b.play(5);
		b.play(1);
		b.play(10);
		b.play(4);
		b.play(8);
		b.play(0);
		b.play(2);
		b.play(7);
		b.play(3);
		b.play(7);
		b.play(1);
		b.play(10);
		b.play(8);
		b.play(4);
		b.play(5);
		b.play(7);
		b.play(3);
		b.play(9);
		Assert.assertEquals("[0]", b.getBowlInfo(9));
		Assert.assertEquals("[0]", b.getBowlInfo(5));
		Assert.assertEquals("[0]", b.getBowlInfo(7));
		Assert.assertEquals("{11}", b.getBowlInfo(13));
		
	}
	
	@Before
	public void setup() {
		p1 = new Player(true);
		p2 = p1.getOpponent();
		bowlSize = 13;
		b = new Bowl(p1, bowlSize);
	}
	
}

package nl.sogyo.mancala.domain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import nl.sogyo.mancala.*;

public class PlayerTest {
	Player p1;
	Player p2;
	
	@Test 
	public void testPlayerHasOpponentTurn() {
		Assert.assertTrue(p1.isMyTurn());
		Assert.assertFalse(p1.getOpponent().isMyTurn());
		Assert.assertFalse(p2.isMyTurn());
		Assert.assertTrue(p2.getOpponent().isMyTurn());
	}
	
	@Test
	public void testSwitchTurn() {
		p1.switchTurn();
		Assert.assertFalse(p1.isMyTurn());
		Assert.assertTrue(p1.getOpponent().isMyTurn());
		Assert.assertTrue(p2.isMyTurn());
		Assert.assertFalse(p2.getOpponent().isMyTurn());
	}
	
	@Before
	public void setup() {
		p1 = new Player(true);
		p2 = p1.getOpponent();
	}
}

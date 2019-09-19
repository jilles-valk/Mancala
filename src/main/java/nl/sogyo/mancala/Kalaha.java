package nl.sogyo.mancala;

public class Kalaha extends AbstractBowl{

	public Kalaha(Player p1, AbstractBowl first, AbstractBowl next, int size) {
		super(p1, first, next, size);
		numStones = 0;
	}
	
	public AbstractBowl getKalaha() {
		return this;
	}
	
	public void pass(int numStonesPrevABowl) {
		next.pass(numStonesPrevABowl);
		if (player.isMyTurn()) {
			numStones++;
		}
	}
	
	public void passToKalaha(int numStones) {
		this.numStones += numStones;
	}
	public int bowlsUntillKalaha(int bowlsUpToHere) {
		return bowlsUpToHere;
	}

	public void play(int bowlNum) {
		if (bowlNum != 0) {
			next.play(bowlNum - 1);
		}
}
	
	public boolean isGameOver() {
		return true;
	}

}

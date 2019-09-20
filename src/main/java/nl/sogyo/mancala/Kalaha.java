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
		if (player.isMyTurn()) {
			if (numStonesPrevABowl != 1) {
				next.pass(numStonesPrevABowl - 1);
				numStones++;
			}
			else {
				numStones++;
			}
		}
		else {
			next.pass(numStonesPrevABowl);
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

	public boolean isGameOver(int timesPassedKalaha) {
		if (player.isMyTurn()) {
			return true;
		}
		return next.isGameOver(timesPassedKalaha);
	}

	public String getBowlInfo(int bowlsNext) {
		if (bowlsNext == 0) {
			return "{" + numStones + "}"; 
		}
		else {
			return next.getBowlInfo(bowlsNext - 1);
		}
	}
}

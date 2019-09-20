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

	public boolean isGameOver(int timesPassedKalaha, int timesZero) {
		if (timesZero == 6 && player.isMyTurn()) {
			return true;
		}
		if (player.isMyTurn() && timesPassedKalaha == 2) {
			return false;
		}
		return next.isGameOver(timesPassedKalaha + 1, 0);
	}

	public String getBowlInfo(int bowlsNext) {
		if (bowlsNext == 0) {
			return "{" + numStones + "}"; 
		}
		else {
			return next.getBowlInfo(bowlsNext - 1);
		}
	}
	
	protected Player getWinner() {
		if (next.getKalaha().numStones > numStones) {
			return player.getOpponent();
		}
		return player;
	}
}

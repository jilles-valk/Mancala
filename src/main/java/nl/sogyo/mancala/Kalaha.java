package nl.sogyo.mancala;

public class Kalaha extends AbstractBowl{

	public Kalaha(Player p1, AbstractBowl first, int numBowlsLeftToGo) {
		super(p1, first, numBowlsLeftToGo);
		numStones = 0;
	}

	public Kalaha getKalaha() {
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
		if (player.isMyTurn()) {
			this.numStones += numStones;
		}
		else {
			next.passToKalaha(numStones);
		}
	}
	public int bowlsUntillKalaha(int bowlsUpToHere) {
		return bowlsUpToHere;
	}

	public void play(int bowlNum) {
		if (bowlNum != 0) {
			super.play(bowlNum);
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

	public String getBowlInfo(int numBowlsRight) {
		if (numBowlsRight == 0) {
			return "{" + numStones + "}"; 
		}
		else {
			return next.getBowlInfo(numBowlsRight - 1);
		}
	}
	
	public Player getWinner() {
		if (next.getKalaha().numStones > numStones) {
			return player.getOpponent();
		}
		return player;
	}
}

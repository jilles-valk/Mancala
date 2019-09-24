package nl.sogyo.mancala;

public abstract class AbstractBowl {
	protected Player player;
	protected AbstractBowl next;
	protected int numStones;
	
	public AbstractBowl(Player p1, AbstractBowl first, int numBowlsLeftToGo) {
		if (numBowlsLeftToGo == 8 || numBowlsLeftToGo == 1) {
			this.next = new Kalaha(p1, first, numBowlsLeftToGo - 1);
		}
		else if (numBowlsLeftToGo == 0) {
			this.next = first;
		}
		else {
			this.next = new Bowl(p1, first, numBowlsLeftToGo - 1);
		}
		
		if (numBowlsLeftToGo >= 7) {
			player = p1;
		}
		else {
			player = p1.getOpponent();
		}
	}
	
	public AbstractBowl(Player p1, int size) {
		this.next = new Bowl(p1, this, size - 1);
		player = p1;
	}
	
	protected void pass(int numStonesFromPrevABowl) {
		if (numStonesFromPrevABowl != 1) {
			numStones++;
			next.pass(numStonesFromPrevABowl - 1);
		}
		else {
			endOfTurn();
		}
	}
	
	private void endOfTurn() {
		if (numStones == 0 && player.isMyTurn()) {
			passAllToKalaha(bowlsUntillKalaha(0) * 2);
		}
		else {
			numStones++;
		}
		player.switchTurn();
	}
	
	private void passAllToKalaha(int numBowlsRight) {
		if (numBowlsRight == 0) {
			passToKalaha(numStones + 1);
			numStones = 0;
		}
		else {
			next.passAllToKalaha(numBowlsRight - 1);
		}
	}
	
	protected void passToKalaha(int numStones) {
		next.passToKalaha(numStones);
	}
	
	protected int bowlsUntillKalaha(int bowlsUpToHere) {
		return next.bowlsUntillKalaha(bowlsUpToHere + 1);
	}

	public void play(int bowlNum) {
		if (bowlNum == 0) {
			if (player.isMyTurn() && numStones != 0) {
				
				next.pass(numStones);
				numStones = 0;
			}
		}
		else {
			next.play(bowlNum - 1);
		}
	}
	
	public abstract boolean isGameOver(int timesPassedKalaha, int numZero);

	public abstract Player getWinner(int otherPlayersStones);
	
	public abstract String getBowlInfo(int bowlsNext);
}

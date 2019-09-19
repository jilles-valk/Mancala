package nl.sogyo.mancala;

public abstract class AbstractBowl {
	protected Player player;
	protected AbstractBowl next;
	protected int numStones;
	
	public AbstractBowl(Player p1, AbstractBowl first, AbstractBowl next, int size) {
		if (size == 8 || size == 1) {
			this.next = new Kalaha(p1, first, next, size - 1);
		}
		else if (size == 0) {
			this.next = first;
		}
		else {
			this.next = new Bowl(p1, first, next, size - 1);
		}
		
		if (size >= 7) {
			player = p1;
		}
		else {
			player = p1.getOpponent();
		}
		
	}
	
	public AbstractBowl(Player p1, int size) {
		this.next = new Bowl(p1, this, null, size - 1);
		player = p1;
	}

	
	public Player getPlayer() {
		return player;
	}
	
	public int getNumStones() {
		return numStones;
	}
	
	public void pass(int numStonesFromPrevABowl) {
		if (numStonesFromPrevABowl != 0) {
			next.pass(numStonesFromPrevABowl - 1);
		}
		if (numStones != 0) {
			numStones++;
		}
		else {
			passToKalaha(getBowl(bowlsUntillKalaha(0) * 2 + 1).takeStones() + 1);
		}	
	}
	
	public void passToKalaha(int numStones) {
		next.passToKalaha(numStones);
	}
	public int bowlsUntillKalaha(int bowlsUpToHere) {
		return next.bowlsUntillKalaha(bowlsUpToHere + 1);
	}
	
	private int takeStones() {
		int stonesToReturn = numStones;
		numStones = 0;
		return stonesToReturn;
	}
	
	public AbstractBowl getBowl(int numBowlsRight) {
		if (numBowlsRight == 1) {
			return next;
		}
		else {
			return next.getBowl(numBowlsRight - 1);
		}
	}
	
	public AbstractBowl getKalaha() {
		return next.getKalaha();
	}

	public void play(int bowlNum) {
		if (bowlNum == 0) {
			next.pass(numStones);
			numStones = 0;
			player.switchTurn();
		}
		else {
			next.play(bowlNum - 1);
		}
	}
	
	public boolean isGameOver() {
		if (numStones == 0) {
			return next.isGameOver();
		}
		return false;
	}
}

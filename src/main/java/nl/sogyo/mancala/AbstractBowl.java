package nl.sogyo.mancala;

public abstract class AbstractBowl {
	protected AbstractBowl next;
	protected int numStones;
	
	public AbstractBowl(AbstractBowl first, AbstractBowl next, int size) {
		if (size == 8 || size == 1) {
			this.next = new Kalaha(first, next, size - 1);
		}
		else if (size == 0) {
			this.next = first;
		}
		else {
			this.next = new Bowl(first, next, size - 1);
		}
		
		
		numStones = 4;
	}
	
	public AbstractBowl() {
		next = null;
		numStones = 4;
	}
	
	public int getNumStones() {
		return numStones;
	}
	
	public AbstractBowl getBowl(int numBowlsRight) {
		if (numBowlsRight == 1) {
			return next;
		}
		else {
			next.getBowl(numBowlsRight - 1);
		}
		return null;
	}
}

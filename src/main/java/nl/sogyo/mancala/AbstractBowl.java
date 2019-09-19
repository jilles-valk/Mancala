package nl.sogyo.mancala;

public abstract class AbstractBowl {
	protected AbstractBowl next;
	protected int numStones;
	
	public AbstractBowl(AbstractBowl first, AbstractBowl next, int size) {
//		if (size == 13) {
//			first = this;
//		}
		if (size == 8 || size == 1) {
			this.next = new Kalaha(first, next, size - 1);
		}
		else if (size == 0) {
			this.next = first;
		}
		else {
			this.next = new Bowl(first, next, size - 1);
		}
		
		numStones = size;
	}
	
	public AbstractBowl(int size) {
		this.next = new Bowl(this, null, size - 1);
		numStones = size;
	}

	
	public int getNumStones() {
		return numStones;
	}
	
	/* Needs more work: should not pass other players Kalaha, 
	 * should do something when end in Kalaha, 
	 * should do something when end in empty from same player.
	 */
	public void pass(int numStonesPrevABowl) {
		if (numStonesPrevABowl != 0) {
			next.pass(numStonesPrevABowl - 1);
		}
		numStones++;
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
}

package nl.sogyo.mancala;

public class Bowl extends AbstractBowl{

	public Bowl(Player p1, AbstractBowl first, AbstractBowl next, int size) {
		super(p1, first, next, size);
		numStones = 4;
	}

	public Bowl(Player p1, int size) {
		super(p1, size);
		numStones = 4;
	}
	
	public String getBowlInfo(int bowlsNext) {
		if (bowlsNext == 0) {
			return "[" + numStones + "]"; 
		}
		else {
			return next.getBowlInfo(bowlsNext - 1);
		}
	}
}

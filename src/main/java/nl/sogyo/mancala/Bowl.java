package nl.sogyo.mancala;

public class Bowl extends AbstractBowl{

	public Bowl(Player p1, AbstractBowl first, int numBowlsLeftToGo) {
		super(p1, first, numBowlsLeftToGo);
		numStones = 4;
	}

	public Bowl(Player p1, int numBowlsLeftToGo) {
		super(p1, numBowlsLeftToGo);
		numStones = 4;
	}
	
	public boolean isGameOver(int timesPassedKalaha, int numZero) {
		if (numStones == 0) {
			return next.isGameOver(timesPassedKalaha, numZero + 1);
		}
		return next.isGameOver(timesPassedKalaha, numZero);
	}
	
	public Player getWinner(int otherPlayersStones) {
		return next.getWinner(otherPlayersStones);
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

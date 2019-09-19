package nl.sogyo.mancala;

public class Player {
	private boolean isMyTurn;
	private Player opponent;

	public Player() {
		opponent = new Player(this);
		isMyTurn = true;
	}
	
	public Player(Player opponent) {
		this.opponent = opponent;
		isMyTurn = false;
	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public Player getOpponent() {
		return opponent;
	}
	
	
}

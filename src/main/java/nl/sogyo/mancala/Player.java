package nl.sogyo.mancala;

public class Player {
	private boolean isMyTurn;
	private Player opponent;
	
	public Player(boolean isMyTurn) {
		this.opponent = new Player(this, !isMyTurn);
		this.isMyTurn = isMyTurn;
	}
	
	private Player(Player player, boolean isMyTurn) {
		opponent = player;
		this.isMyTurn = isMyTurn;
	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public Player getOpponent() {
		return opponent;
	}
	
	public void switchTurn() {
		getOpponent().isMyTurn = isMyTurn;
		isMyTurn = !isMyTurn;
	}
	
}

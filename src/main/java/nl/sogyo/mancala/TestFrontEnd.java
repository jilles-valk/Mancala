package nl.sogyo.mancala;

import java.util.Scanner;

public class TestFrontEnd {
	private Player p1;
	private Player p2;
	private int bowlSize;
	private Bowl b;

	public TestFrontEnd() {
		p1 = new Player(true);
		p2 = p1.getOpponent();
		bowlSize = 13;
		int toPlay = -1;
		b = new Bowl(p1, bowlSize);
		Scanner input = new Scanner(System.in);

//		startUp();
		
		while (!b.isGameOver(0, 0)) {
			printBoard();
			if (input.hasNextInt()){
				toPlay = input.nextInt();
				if (toPlay >= 0 && toPlay <= 13) {
					b.play(toPlay);
				}
			}
		}
		if (b.getWinner(-1).isMyTurn() == p1.isMyTurn()) {
			System.out.println("Player 1 has won!");
		}
		else {
			System.out.println("Player 2 has won!");
		}
		input.close();
	}

	public void printBoard() {
		if (p1.isMyTurn()) {
			System.out.println("Player: 1");
		}
		else {
			System.out.println("Player: 2");
		}
		System.out.print("   ");
		for (int bowlNum = 12; bowlNum > 6; bowlNum--) {
			System.out.print(b.getBowlInfo(bowlNum));
		}
		System.out.println();
		System.out.println(b.getBowlInfo(13) + "                  " + b.getBowlInfo(6));
		System.out.print("   ");
		for (int bowlNum = 0; bowlNum < 6; bowlNum++) {
			System.out.print(b.getBowlInfo(bowlNum));
		}
		System.out.println();
	}
	
	private void startUp() {
		b.play(0);
		b.play(7);
		b.play(1);
		b.play(8);
		b.play(2);
		b.play(9);
		b.play(3);
		b.play(4);
		b.play(12);
		b.play(11);
		b.play(10);
		b.play(11);
		b.play(5);
		b.play(12);
		b.play(0);
		b.play(7);
		b.play(1);
		printBoard();
		b.play(8);
		printBoard();
	}

}

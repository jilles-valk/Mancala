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

		while (true) {
			printBoard();
			if (input.hasNextInt()){
				toPlay = input.nextInt();
				if (toPlay >= 0 && toPlay <= 13) {
					b.play(toPlay);
				}
			}
		}
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

}

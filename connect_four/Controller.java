package connect_four;

import java.util.Scanner;

public class Controller {
	private Set SETR = new Set(Color.RED);
	private Set SETY = new Set(Color.YELLOW);
	private Grid G = new Grid();
	private Player PlayerR, PlayerY;
	private int t = (int) (Math.random() * 2);
	private Player endWinner;

	private void switchPlayer() {
		t++;
		t = t % 2;

	}

	public Controller(String nameR, String nameY) {
		PlayerR = new Human(nameR, SETR, G);
		PlayerY = new Human(nameY, SETY, G);
	}

	public Controller(String name) {
		PlayerR = new Human(name, SETR, G);
		PlayerY = new AI("AI", SETY, G);
	}

	public void Start() {
		Player[] TPlayer = { PlayerR, PlayerY };
		System.out.println("Welocme to Connect 4. Player " + TPlayer[t].getName() + " is the "
				+ TPlayer[t].getSet().getColor() + ", and Player " + TPlayer[(t + 1) % 2].getName() + " is the "
				+ TPlayer[(t + 1) % 2].getSet().getColor() + "\nPress e to start:");
		Scanner enter = new Scanner(System.in);
		enter.next();
		G.displayGrid();
		while (true) {

			if (TPlayer[t].getSet().getNbToken() <= 0 && TPlayer[(t + 1) % 2].getSet().getNbToken() <= 0) {
				endWinner = null;
				break;
			}
			try {
				if (TPlayer[t] instanceof AI) {
					System.out.println("The computer will play");
					TPlayer[t].dropAt((byte) ((int) (Math.random() * 7)));
				} else {
					System.out.print("Player " + TPlayer[t].getSet().getColor()
							+ " turn, please enter your column, press -1 to withdraw (you will lose): ");
					Scanner in = new Scanner(System.in);
					byte col;
					if (in.hasNextByte()) {
						col = in.nextByte();
					} else
						throw new Exception("Only number between 1 and 7");

					if (col == -1) {
						System.out.println("Player " + TPlayer[t].getName() + " has withdraw the game");
						endWinner = TPlayer[(++t) % 2];
						break;
					}
					TPlayer[t].dropAt((byte) (col - 1));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			G.displayGrid();
			if (TPlayer[t].checkWin()) {
				endWinner = TPlayer[t];
				break;
			}
			switchPlayer();

		}
		if (endWinner == null)
			System.out.println("-The game end with a draw-");
		else if (endWinner instanceof AI)
			System.out.println("You lose :(");
		else
			System.out.println("congratulation " + endWinner.getName() + ", you win the game!");
	}

}

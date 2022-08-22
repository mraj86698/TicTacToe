package TicTac;

public class TicTacMain {

	public static void main(String args[]) {

		System.out.println("Welcome to Tic Tac Toe Game");
		TicTac board = new TicTac();
		do {
			// create new board
			board.createBoard();
			// asking for choice of char
			char[] input = board.getInput();
			// display empty board
			System.out.println("Displaying empty board->");
			board.showBoard();
			// Initiating toss
			int toss = board.toss();
			switch (toss) {
			case 1: {
				do {
					board.playerMove(input);
					board.showBoard();
					// check for game over
					if (board.checkGameOver(input, 0)) {
						break;
					}
					board.compMove(input);
					board.showBoard();
				} while (!board.checkGameOver(input, 1));
				break;
			}
			case 0: {
				do {
					board.compMove(input);
					board.showBoard();
					// check for game over
					if (board.checkGameOver(input, 1)) {
						break;
					}
					board.playerMove(input);
					board.showBoard();
				} while (!board.checkGameOver(input, 0));
				break;
				}
			}
		} while (board.askRematch());
		System.out.println("Program End.");
	}
}

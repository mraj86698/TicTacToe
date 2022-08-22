package TicTac;

public class TicTacMain {

	public static void main(String args[]) {

		System.out.println("Welcome to Tic Tac Toe Game");
		TicTac board = new TicTac();
		//create new board
		board.createBoard();
		//asking for choice of char
		char[] input=board.getInput();

	}

}

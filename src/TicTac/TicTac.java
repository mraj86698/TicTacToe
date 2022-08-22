package TicTac;

import java.util.Scanner;

public class TicTac {

	char[] board = new char[10];
	static Scanner sc=new Scanner(System.in);
	/**
	 * Creating a TicTacToe Board
	 * It takes board array indexes from 1 to 9 using for loop
	 * Assign empty space to each element in the board.
	 * @return Board
	 */

	public char[] createBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = 0;
		}
		return board;
	}

}

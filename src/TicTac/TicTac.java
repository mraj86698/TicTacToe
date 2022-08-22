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
	/**
	 * Determine Player & Computer to Play the Game.
	 * It takes input from the user.
	 * if user letter is 'X' then computer letter is become 'O' otherwise it becomes 'X'
	 * @return X & O
	 */

	public char[] getInput() {
		char x='x';
		char o='o';
		char[] output=new char[2];
		System.out.println("Please enter a character X or O");
		String input=(sc.next()).toLowerCase();
		char mark=input.charAt(0);
		if (mark==x) {
			System.out.println("User has entered: "+x);
			output[0]=x;
			System.out.println("Computer has entered:  "+o);
			output[1]=o;
		}else if(mark==o) {
			System.out.println("User has entered: "+o);
			output[0]=o;
			System.out.println("Computer has entered: "+x);
			output[1]=x;
		}else {
			System.out.println("Unknown entry.");
		}
		return output;
	}

}

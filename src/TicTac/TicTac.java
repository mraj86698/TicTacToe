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
	/**
	 * To Display The Current Board
	 */
	public int showBoard() {
		for(int i=1;i<10;i++) {
			if (i%3==0)
				System.out.println(board[i]);
			else
				System.out.print(board[i]+" | ");
		}
		return 0;
	}
	/**
	 * Method to make user to move to desired location.
	 * It takes user input from index 1 to 9.
	 * If you enter invalid index or try to move to occupied index.
	 * It prints error message else it moves the user letter to desired location.
	 * @param i
	 */
	public int checkMoveOk(int index) {

		if (index>=1 && index<=9) {
			if ((board[index])==0) {
				return index;
			}else {
				return 0;
			}
		}else {
			System.out.println("Index out of bounds!");
			return 0;
		}
	}

}

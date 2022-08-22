package TicTac;

import java.util.Random;
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
	/**
	 * Method to check if space is available in the board.
	 * It checks free space is available or not before make a move.
	 * Count the number of spaces available.It extends UC4.
	 * @param input
	 */

	public void playerMove(char[] input) {
		int index;
		do {
			System.out.print("Enter position - ");
			int in=sc.nextInt();
			index=checkMoveOk(in);
			if (index==0) {
				System.out.println("Cannot make move.");
			}else {
				board[index]=input[0];
				break;
			}
		}while(index!=0);
	}
	/**
	 * Method to check who plays first computer or user
	 * Random generates two values 0 and 1.
	 * if it is 0,it prints computer play first
	 * otherwise user plays first
	 * @return
	 */

	public int toss() {
		Random  r=new Random();
		int randomNum=r.nextInt(2);
		System.out.println(randomNum);
		if(randomNum==0) {
			System.out.println("Computer won the Toss.");
		}else {
			System.out.println("User won the Toss.");
		}
		return randomNum;
	}
	/**Method to check if Win/Tie/Loss Cond. is fulfilled
	 * @param CharArray containing x and o
	 * @param player
	 * @return 0-Game Continues <br>
	 * 1-Game Over Cond.
	 */

	public int getWinOrTie(char[] input,int player) {
		char playerMove=input[player];
		//Win Cond.
		if(
				//Horizontal Win Cond.
				(board[1]==playerMove && board[2]==playerMove && board[3]==playerMove) ||
				(board[4]==playerMove && board[5]==playerMove && board[6]==playerMove) ||
				(board[7]==playerMove && board[8]==playerMove && board[9]==playerMove) ||

				//Vertical Win Cond.
				(board[1]==playerMove && board[4]==playerMove && board[7]==playerMove) ||
				(board[2]==playerMove && board[5]==playerMove && board[8]==playerMove) ||
				(board[3]==playerMove && board[6]==playerMove && board[9]==playerMove) ||

				//Cross Win Cond.
				(board[1]==playerMove && board[5]==playerMove && board[9]==playerMove) ||
				(board[3]==playerMove && board[5]==playerMove && board[7]==playerMove)
				)
		{
			if (player==0) {
				System.out.println("User has won!!");
			}else {
				System.out.println("Computer has won!!");
			}
			//1 returned to show game has ended.
			return 1;
		}
		//No win - No Tie
		for(int i=1;i<10;i++) {
			if (checkMoveOk(i)!=0) {
				if (player==0) {
					System.out.println("Computer's Move.");
				}else {
					System.out.println("Player's Move");
				}
				//0 returned to switch moves
				return 0;
			}
		}
		//Last Cond-Tie
		System.out.println("Its a tie.");
		//1 returned to show game has ended.
		return 1;
	}

}

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
	/**Provides Computer logic to move a win position.
	 * @param CharArray containing x and o
	 */
	public boolean computerMoveToWin(char[] input) {
		//choose which char to put in board
		char computer=input[1];

		//makes Comp move in order to win
		if(board[1]==computer && board[2]==computer && board[3]==0)
			board[3] = computer;
		else if(board[1]==computer && board[2]==0 && board[3]==computer)
			board[2] = computer;
		else if(board[1]==0 && board[2]==computer && board[3]==computer)
			board[1] = computer;
		else if(board[4]==computer && board[5]==computer && board[6]==0)
			board[6] = computer;
		else if(board[4]==computer && board[5]==0 && board[6]==computer)
			board[5] = computer;
		else if(board[4]==0 && board[5]==computer && board[6]==computer)
			board[4] = computer;
		else if(board[7]==computer && board[8]==computer && board[9]==0)
			board[9] = computer;
		else if(board[7]==computer && board[8]==0 && board[9]==computer)
			board[8] = computer;
		else if(board[7]==0 && board[8]==computer && board[9]==computer)
			board[7] = computer;
		else if(board[1]==computer && board[4]==computer && board[7]==0)
			board[7] = computer;
		else if(board[1]==computer && board[4]==0 && board[7]==computer)
			board[4] = computer;
		else if(board[1]==0 && board[4]==computer && board[7]==computer)
			board[1] = computer;
		else if(board[2]==computer && board[5]==computer && board[8]==0)
			board[8] = computer;
		else if(board[2]==computer && board[5]==0 && board[8]==computer)
			board[5] = computer;
		else if(board[2]==0 && board[5]==computer && board[8]==computer)
			board[2] = computer;
		else if(board[3]==computer && board[6]==computer && board[9]==0)
			board[9] = computer;
		else if(board[3]==computer && board[6]==0 && board[9]==computer)
			board[6] = computer;
		else if(board[3]==0 && board[6]==computer && board[9]==computer)
			board[3] = computer;
		else if(board[1]==computer && board[5]==computer && board[9]==0)
			board[9] = computer;
		else if(board[1]==computer && board[5]==0 && board[9]==computer)
			board[5] = computer;
		else if(board[1]==0 && board[5]==computer && board[9]==computer)
			board[1] = computer;
		else if(board[3]==computer && board[5]==computer && board[7]==0)
			board[7] = computer;
		else if(board[3]==computer && board[5]==0 && board[7]==computer)
			board[5] = computer;
		else if(board[3]==0 && board[5]==computer && board[7]==computer)
			board[3] = computer;
		else
			return false;
		return true;
	}
	/**Provides Computer logic to block player from winning.
	 * @param CharArray containing x and o
	 * @return true-Move completed <br>
	 * false-Move Not Possible
	 */
	public boolean computerMoveToBlockPlayerWin(char[] input) {
		//find char of Player and Comp
		char player=input[0];
		char computer=input[1];

		//makes Comp move in order to block player get sequence
		if(board[1]==player && board[2]==player && board[3]==0)
			board[3] = computer;
		else if(board[1]==player && board[2]==0 && board[3]==player)
			board[2] = computer;
		else if(board[1]==0 && board[2]==player && board[3]==player)
			board[1] = computer;
		else if(board[4]==player && board[5]==player && board[6]==0)
			board[6] = computer;
		else if(board[4]==player && board[5]==0 && board[6]==player)
			board[5] = computer;
		else if(board[4]==0 && board[5]==player && board[6]==player)
			board[4] = computer;
		else if(board[7]==player && board[8]==player && board[9]==0)
			board[9] = computer;
		else if(board[7]==player && board[8]==0 && board[9]==player)
			board[8] = computer;
		else if(board[7]==0 && board[8]==player && board[9]==player)
			board[7] = computer;
		else if(board[1]==player && board[4]==player && board[7]==0)
			board[7] = computer;
		else if(board[1]==player && board[4]==0 && board[7]==player)
			board[4] = computer;
		else if(board[1]==0 && board[4]==player && board[7]==player)
			board[1] = computer;
		else if(board[2]==player && board[5]==player && board[8]==0)
			board[8] = computer;
		else if(board[2]==player && board[5]==0 && board[8]==player)
			board[5] = computer;
		else if(board[2]==0 && board[5]==player && board[8]==player)
			board[2] = computer;
		else if(board[3]==player && board[6]==player && board[9]==0)
			board[9] = computer;
		else if(board[3]==player && board[6]==0 && board[9]==player)
			board[6] = computer;
		else if(board[3]==0 && board[6]==player && board[9]==player)
			board[3] = computer;
		else if(board[1]==player && board[5]==player && board[9]==0)
			board[9] = computer;
		else if(board[1]==player && board[5]==0 && board[9]==player)
			board[5] = computer;
		else if(board[1]==0 && board[5]==player && board[9]==player)
			board[1] = computer;
		else if(board[3]==player && board[5]==player && board[7]==0)
			board[7] = computer;
		else if(board[3]==player && board[5]==0 && board[7]==player)
			board[5] = computer;
		else if(board[3]==0 && board[5]==player && board[7]==player)
			board[3] = computer;
		else {
			return false;
		}
		return true;
	}
	/**Provides Computer logic to take available corners
	 * @param CharArray containing x and o
	 * @return true-Move completed <br>
	 * false-Move Not Possible
	 */
	public boolean computerMoveToTakeCorner(char[] input) {
		//choose which char to put in board
		char computer=input[1];

		//move to take corner
		if(checkMoveOk(1)!=0)
			board[1] = computer;
		else if(checkMoveOk(3)!=0)
			board[3] = computer;
		else if(checkMoveOk(7)!=0)
			board[7] = computer;
		else if(checkMoveOk(9)!=0)
			board[9] = computer;
		else
			return false;
		return true;
	}
	/**Provides Computer logic to take center and available spaces
	 * @param CharArray containing x and o
	 *
	 */
	public void computerMoveToAvailableSpace(char[] input) {
		//choose which char to put in board
		char compLetter=input[1];

		//move to take center
		if(checkMoveOk(5)!=0)
			board[5] = compLetter;
		//move to take rest positions
		else if(checkMoveOk(2)!=0)
			board[2] = compLetter;
		else if(checkMoveOk(4)!=0)
			board[4] = compLetter;
		else if(checkMoveOk(6)!=0)
			board[6] = compLetter;
		else if(checkMoveOk(8)!=0)
			board[8] = compLetter;
	}
	/**
	 * Internally calls all Computer Move sub methods
	 * @param CharArray containing x and o
	 */
	public void compMove(char[] input) {
		//Calling all computer movement sub-methods sequentially.
		if(!computerMoveToWin(input)) {
			if(!computerMoveToBlockPlayerWin(input)) {
				if(!computerMoveToTakeCorner(input)) {
					if(!computerMoveToTakeCorner(input)) {
						computerMoveToAvailableSpace(input);
					}
				}
			}
		}
	}

	/**Checks for game end condition
	 * @param CharArray containing x and o
	 * @param player
	 * @return true-Game Over <br>
	 * false-Game Continues
	 */
	public boolean checkGameOver(char[] input,int player) {
		int gameStatus=getWinOrTie(input, player);
		if(gameStatus==1)
			System.out.println("-----Game Over-----");
		else
			return false;
		return true;
	}

}

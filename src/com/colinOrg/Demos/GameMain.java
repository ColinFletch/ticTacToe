package com.colinOrg.Demos;

import java.util.Scanner;

public class GameMain {

	/**
	 *Main Class for Tic-Tac-Toe. 
	 *Overall controller of the game.
	 */
	
	private Board board;
	private GameState currentState;
	private Seed currentPlayer;
	
	private static Scanner in = new Scanner(System.in);
	
	/** Constructor for game */
	public GameMain() {
		board = new Board(); //allocate Board for Game.
	
	
	//initialize game-board and current status
	initGame();
	// PLay game once. Players CROSS / NOUGHT alternate
	do{
		playerMove(currentPlayer); //update content.
		board.paint();		//have board paint itself
		updateGame(currentPlayer); //update currentState
		
		//Print Msg if Game Over
		if(currentState ==GameState.CROSS_WON) {
			System.out.println("'X' won! Bye!");
		} else if (currentState == GameState.NOUGHT_WON) {
			System.out.println("'O' won! Bye!");
		} else if (currentState == GameState.DRAW) {
			System.out.println("It's a Draw! Bye!");
		}
		//Switch player
		currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
		
		} while (currentState == GameState.PLAYING);
	}
/** Initialize game-board contents and current states */
	public void initGame() {
		board.init();  // Clear contents
		currentPlayer = Seed.CROSS; //CROSS is First
		currentState = GameState.PLAYING; // Ready!
	}
	
	/** The player with "theSeed" moves. we check
	 * input, then update cells content
	 * board's currentRow and currentCol.
	 */
	public void playerMove(Seed theSeed) {
	
		boolean validInput = false;
		do {
			if (theSeed == Seed.CROSS) {
				System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
			} else {
			System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");	
			}
			int row = in.nextInt() -1;
			int col = in.nextInt() -1;
			if(row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS && 
					board.cells[row][col].content == Seed.EMPTY) {
				board.cells[row][col].content = theSeed;
				board.currentRow = row;
				board.currentCol = col;
				validInput = true; //input works, exit loop!
			} else {
				System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. try again...");
			}
	} while (!validInput);
	}
	/** Update currentState after player with "theSeed" has moved   */
	public void updateGame(Seed theSeed) {
		if (board.hasWon(theSeed)) { // Check if Won
			currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
		} else if (board.isDraw()){ // Check if Stalemate
			currentState = GameState.DRAW;
		}
		// Otherwise, continue Playing.
		}

	/**  The main() method */
	public static void main(String[] args) {
		new GameMain(); //Let the Constructor Work.
	}
}
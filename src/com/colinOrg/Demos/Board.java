package com.colinOrg.Demos;

/*Boad Class models the game board. */

public class Board {

	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	Cell[][] cells; //Composition of board (ROWS x COLS)
	int currentRow, currentCol; //Current seed's position.
	
	/**Constructor **/
	public Board() {
		cells = new Cell[ROWS][COLS]; //Allocate Array
		for (int row = 0; row<ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	
	/** Initialize contents of game board */
	public void init() {
		for (int row = 0; row <  ROWS; row ++) {
			for (int col = 0; col < COLS; col++) {
				cells[row][col].clear();
			}
		}	
	}
	
	/** return true if it's a draw */
	public boolean isDraw() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col <COLS; col++) {
				if(cells[row][col].content == Seed.EMPTY) {
					return false; // if empty found, exit. No draw.
				}
			}
		}
		return true;  //if no empty cell; it's a draw.
		}
	
	/** Return true if the player with "theSeed" has won after placing at
    (currentRow, currentCol) */
	public boolean hasWon(Seed theSeed) {
	      return (cells[currentRow][0].content == theSeed         // 3-in-the-row
	                   && cells[currentRow][1].content == theSeed
	                   && cells[currentRow][2].content == theSeed
	              || cells[0][currentCol].content == theSeed      // 3-in-the-column
	                   && cells[1][currentCol].content == theSeed
	                   && cells[2][currentCol].content == theSeed
	              || currentRow == currentCol            // 3-in-the-diagonal
	                   && cells[0][0].content == theSeed
	                   && cells[1][1].content == theSeed
	                   && cells[2][2].content == theSeed
	              || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
	                   && cells[0][2].content == theSeed
	                   && cells[1][1].content == theSeed
	                   && cells[2][0].content == theSeed);
	   }
	
	/**Paint Cell*/
	public void paint() {
		for (int row = 0; row<ROWS; row++) {
			for(int col=0;col<COLS; col++) {
				cells[row][col].paint(); //cells update themselves.
			}
			System.out.println();
			if(row < ROWS -1){
				System.out.println("----------");
			}
		}
	}
}

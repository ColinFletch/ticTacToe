package com.colinOrg.Demos;
/* Cell Class models individual Cell objects */

public class Cell {

	//Seed to determine cell's state - EMPTY/CROSS/NOUGHT
	Seed content;
	
	int row, col; 
	
	/** Cell constructor method to initialize **/
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();  //used to clear cell state.
		
	}
	
	public void clear() {
		content = Seed.EMPTY;
	}
	
	/** Paint Itself As Taken **/
	public void paint() {
		switch (content) {
		case CROSS: System.out.print(" X "); break;
		case NOUGHT: System.out.print(" O "); break;
		case EMPTY: System.out.print("  "); break;
		}
	}
}

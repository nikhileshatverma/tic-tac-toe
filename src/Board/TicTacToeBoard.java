package Board;

import game.Cell;
import game.Board;

public class TicTacToeBoard extends Board {
    String[][] cells = new String[3][3];

    public String getcells(int row, int col) {
        return cells[row][col];
    }

    public void setcells(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()] = symbol;  // Fixed method name getcol() to getCol()
    }
}

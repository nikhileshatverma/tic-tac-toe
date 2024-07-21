package game;

public class Cell {
    private int row, col;  // Made row and col private

    public Cell(int row, int col) {  // Added a constructor to initialize row and col
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;  // Fixed method name getcol() to getCol()
    }
}

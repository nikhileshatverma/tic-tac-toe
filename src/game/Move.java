package game;

public class Move {
    private Cell cell;

    public Move(Cell cell) {  // Added constructor to initialize cell
        this.cell = cell;
    }

    public Cell getcell() {
        return cell;  // Fixed to return the instance variable
    }
}

package game;

public class GameResult {
    private boolean isOver;
    private String winner;  // Made fields private

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getWinner() {
        return winner;
    }
}

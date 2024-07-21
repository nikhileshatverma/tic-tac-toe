package game;

public class Player {
    private String playSymbol;

    public Player(String playSymbol) {
        this.playSymbol = playSymbol;
    }

    public String symbol() {
        return playSymbol;
    }
}

package TicTacToe;

public class Piece {
    private final char symbol;

    public Piece(char symbol){this.symbol = symbol;}

    public char getSymbol(){return this.symbol;}

    @Override
    public String toString() {
        return "" + getSymbol();
    }
}

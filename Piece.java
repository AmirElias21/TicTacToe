package TicTacToe;

public enum Piece {
    X('X'), O('O'), EMPTY('-'), TIE('T');

    private final char symbol;

    Piece(char symbol) {
        this.symbol = symbol;
    }
    

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}

package TicTacToe;

public class Player {
    private String name; // will create read and write into file later in the code
    
    private Piece piece;


    private int winCount; // will create read and write into file later in the code
    private int loseCount; // will create read and write into file later in the code
    private int tieCount;

    private int winStreak; // will create read and write into file later in the code
    private int loseStreak; // will create read and write into file later in the code

    public Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
    }

    public void updateWinCount(){
        winCount++;
    }
    public void updateLoseCount(){
        loseCount++;
    }
    public void updateTieCount(){
        tieCount++;
    }

    public Piece getSymbol(){
        return this.piece;
    }

    public String getName(){
        return this.name;
    }
}

package TicTacToe;

public class Player {
    private String name; // will create read and write into file later in the code
    
    private int x_or_o;
    private int winCount; // will create read and write into file later in the code
    private int loseCount; // will create read and write into file later in the code
    private int tieCount;

    private int winStreak; // will create read and write into file later in the code
    private int loseStreak; // will create read and write into file later in the code

    public Player(String name, int x_or_o){
        this.name = name;
        this.x_or_o = x_or_o;
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

    public int getSymbol(){
        return this.x_or_o;
    }

    public String getName(){
        return this.name;
    }
}

package TicTacToe;

import java.util.Scanner;

public class Board{
    private Piece x = new Piece('X');
    private Piece o = new Piece('O');
    
    private String empty = "-";
    private String displayBoard;

    private int x_score;
    private int o_score;

    private final int SIZE = 3;

    private int[][] board = new int[SIZE][SIZE];

    public Board(){
        updateBoardDisplay();
    }



    public void placeSymbol (int cor_x, int cor_y, int x_or_o){
        if(isEmpty(cor_x, cor_y)){
            if(validate(cor_x, cor_y)){
                this.board[cor_x][cor_y] = x_or_o;
            }
        }
    }

    private void updateBoardDisplay(){
        String temp = "";
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(!isEmpty(row, col)){
                    if(this.board[row][col] == 1){
                        temp += x;
                    }else if(this.board[row][col] == 2){
                        temp += o;
                    }
                }else{
                    temp += empty;
                }
                if(col != 2){
                    temp += " | ";
                }
            }
            if(row != 2){
                temp += "\n--+---+--";
            }
            temp += "\n";
        }
        displayBoard = temp;
    }

    public void playerTurn(Player player){
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        while(true){
            System.out.println(player.getName() + "'s turn:");
            System.out.print("Row: ");
            row = scan.nextInt() - 1;
            if(row >= 0 && row <= 3){
                System.out.print("Col: ");
                col = scan.nextInt() - 1;
                if(col >= 0 && col <= 3){
                    if(validate(row, col)){
                        placeSymbol(row, col, player.getSymbol());
                        updateBoardDisplay();
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
    
    private void gameOver(){
        for(int[] row : this.board){
            for(int col : row){
                col = 0;
            }
        }
    }
    
    
    private boolean isEmpty(int cor_x, int cor_y){
        return board[cor_x][cor_y] == 0;
    }

    private boolean validate(int pos_x, int pos_y){
        return this.board[pos_x][pos_y] == 1 ? false : this.board[pos_x][pos_y] == 2 ? false : true;
    }

    // Check win condition
    private int checkRows(){
        for(int row = 0; row < SIZE; row++){
            if(isEmpty(row, 0)){
                continue;
            }
            if(this.board[row][0] == this.board[row][1] && this.board[row][0] == this.board[row][2]){
                if(isX(row, 0)){
                    return 1;
                }else{
                    return 2;
                }
            }

        }
        return 0;
    }

    private int checkCols(){
        for(int col = 0; col < SIZE; col++){
            if(isEmpty(0, col)){
                continue;
            }
            if(this.board[0][col] == this.board[1][col] && this.board[0][col] == this.board[2][col]){
                if(isX(0, col)){
                    return 1;
                }else{
                    return 2;
                }
            }
        }
        return 0;
    }   

    private int checkLeftToRightDiagonal(){
        if(isEmpty(0,0)){
            return 0;
        }
        if((this.board[0][0] == this.board[1][1]) && (this.board[0][0] == this.board[2][2])){
            if(isX(0, 0)){
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }
    
    private int checkRightToLeftDiagonal(){
        if(isEmpty(0,2)){
            return 0;
        }
        if((this.board[0][2] == this.board[1][1]) && (this.board[0][2] == this.board[2][0])){
            if(isX(0, 2)){
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }

    
    public int getWinner(Player player1, Player player2){
        if(checkTie()){
            System.out.println("Its a tie!");
            player1.updateTieCount();
            player2.updateTieCount();
            gameOver();
            return 3;
        }

        int winnerSymbol = checkRows();

        if(winnerSymbol == 0){ 
            winnerSymbol = checkCols();
        }

        if(winnerSymbol == 0){
             winnerSymbol = checkRightToLeftDiagonal();
        }

        if(winnerSymbol == 0){
             winnerSymbol = checkLeftToRightDiagonal();
        }

        if(winnerSymbol == player1.getSymbol()) {
            System.out.println(player1.getName() + " won!");
            player1.updateWinCount();
            player2.updateLoseCount();
            gameOver();
            return player1.getSymbol();  // Indicate player1 won
        }

        if(winnerSymbol == player2.getSymbol()) {
            System.out.println(player2.getName() + " won!");
            player2.updateWinCount();
            player1.updateLoseCount();
            gameOver();
            return player2.getSymbol();  // Indicate player2 won
        }

        return 0; // No winner yet
   }

    public boolean checkTie(){
        int countEmpty = 0;
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(isEmpty(row, col)){
                    countEmpty++;
                }
            }
        }
        return countEmpty <= 0;
   } 
   
   private boolean isX(int pos_x, int pos_y){
        return this.board[pos_x][pos_y] == 1;
    }
  
    private boolean isY(int pos_x, int pos_y){
        return this.board[pos_x][pos_y] == 2;
    }

    
    @Override
    public String toString() {
        return this.displayBoard;
    }


}
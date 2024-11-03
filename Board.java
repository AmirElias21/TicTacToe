package TicTacToe;

import java.util.Scanner;

public class Board{
    private Piece x = Piece.X;
    private Piece o = Piece.O;
    private Piece empty = Piece.EMPTY;
    
    private String displayBoard;

    private final int SIZE = 3;

    private Piece[][] board = new Piece[SIZE][SIZE];

    public Board(){
        cleanBoard();
        updateBoardDisplay();
    }



    public void placeSymbol (int cor_x, int cor_y, Piece piece){
        if(isEmpty(cor_x, cor_y)){
            this.board[cor_x][cor_y] = piece;
        }
    }

    private void updateBoardDisplay(){
        String temp = "";
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(!isEmpty(row, col)){
                    if(this.board[row][col] == Piece.X){
                        temp += x;
                    }else if(this.board[row][col] == Piece.O){
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
                    if(isEmpty(row, col)){
                        placeSymbol(row, col, player.getSymbol());
                        updateBoardDisplay();
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
    
    private void cleanBoard(){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                this.board[row][col] = Piece.EMPTY;
            }
        }
        updateBoardDisplay();
    }
    
    
    private boolean isEmpty(int cor_x, int cor_y){
        return board[cor_x][cor_y] == Piece.EMPTY;
    }

    // Check win condition
    private Piece checkRows(){
        for(int row = 0; row < SIZE; row++){
            if(isEmpty(row, 0)){
                continue;
            }
            if(this.board[row][0] == this.board[row][1] && this.board[row][0] == this.board[row][2]){
                if(this.board[row][0] == Piece.X){
                    return Piece.X;
                }else{
                    return Piece.O;
                }
            }

        }
        return Piece.EMPTY;
    }

    private Piece checkCols(){
        for(int col = 0; col < SIZE; col++){
            if(isEmpty(0, col)){
                continue;
            }
            if(this.board[0][col] == this.board[1][col] && this.board[0][col] == this.board[2][col]){
                if(this.board[0][col] == Piece.X){
                    return Piece.X;
                }else{
                    return Piece.O;
                }
            }
        }
        return Piece.EMPTY;
    }   

    private Piece checkLeftToRightDiagonal(){
        if(isEmpty(0,0)){
            return Piece.EMPTY;
        }
        if((this.board[0][0] == this.board[1][1]) && (this.board[0][0] == this.board[2][2])){
            if(this.board[0][0] == Piece.X){
                return Piece.X;
            }else{
                return Piece.O;
            }
        }
        return Piece.EMPTY;
    }
    
    private Piece checkRightToLeftDiagonal(){
        if(isEmpty(0,2)){
            return Piece.EMPTY;
        }
        if((this.board[0][2] == this.board[1][1]) && (this.board[0][2] == this.board[2][0])){
            if(this.board[0][2] == Piece.X){
                return Piece.X;
            }else{
                return Piece.O;
            }
        }
        return Piece.EMPTY;
    }

    
    public Piece getWinner(Player player1, Player player2){
        Piece winnerSymbol = checkRows();

        if(winnerSymbol == Piece.EMPTY){
            winnerSymbol = checkCols();
        }

        if(winnerSymbol == Piece.EMPTY){
            winnerSymbol = checkRightToLeftDiagonal();
        }

        if(winnerSymbol == Piece.EMPTY){
            winnerSymbol = checkLeftToRightDiagonal();
        }
    
        if(winnerSymbol == Piece.TIE || checkTie()){
            System.out.println("It's a tie!");
            player1.updateTieCount();
            player2.updateTieCount();
            cleanBoard();
            return Piece.TIE;
        }
    
        if(winnerSymbol == player1.getSymbol()) {
            System.out.println(player1.getName() + " won!");
            player1.updateWinCount();
            player2.updateLoseCount();
            cleanBoard();
            return player1.getSymbol();
        }
    
        if(winnerSymbol == player2.getSymbol()) {
            System.out.println(player2.getName() + " won!");
            player2.updateWinCount();
            player1.updateLoseCount();
            cleanBoard();
            return player2.getSymbol();
        }
    
        return Piece.EMPTY; // No winner yet
    }
    

    public boolean checkTie(){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(isEmpty(row, col)){
                    return false; // As soon as an empty cell is found, it’s not a tie
                }
            }
        }
        return true; // if No empty cells found, then it's a tie
    }
    
    @Override
    public String toString() {
        return this.displayBoard;
    }


}
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



    private void placeSymbol (int cor_x, int cor_y, int x_or_o){
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
                if(isEmpty(row, col)){
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

    private void playerTurn(Player player){
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        while(true){
            System.out.println("Row: ");
            row = scan.nextInt();
            if(row >= 0 && row <= 3){
                System.out.println("Col: ");
                col = scan.nextInt();
                if(col >= 0 && col <= 3){
                    placeSymbol(row, col, player.getSymbol());
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
        return board[cor_x][cor_y] != 0;
    }

    private boolean validate(int pos_x, int pos_y){
        return this.board[pos_x][pos_y] == 1 ? false : this.board[pos_x][pos_y] == 2 ? false : true;
    }

    // Check win condition
    private boolean checkRows(){
        for(int row = 0; row < SIZE; row++){
            if(isEmpty(row, 0)){
                continue;
            }
            return this.board[row][0] == this.board[row][1] && this.board[row][0] == this.board[row][2];
        }
        return false;
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
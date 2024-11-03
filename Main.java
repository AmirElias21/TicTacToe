package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void menu(int choice){
        switch (choice) {
            case 1:
                
                break;

            case 2:

                break;
        
            default:
                break;
        }

    }

    public static void displayMenu(){
        System.out.println("1. Player Vs Player\n2.Player vs A.I\n3.A.I Vs A.I");
    }

    public int getUserInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choice: ");
        return scan.nextInt();
    }

    public static void run(){
        Board board = new Board();
        System.out.println(board);

        Player player1 = new Player("Amir", 1);
        Player player2 = new Player("Kemoy", 2);

        while(true){
            board.playerTurn(player1);
            System.out.println(board);
            if(board.getWinner(player1, player2) != 0){
                break;
            }
            if(board.getWinner(player1, player2) == 3){
                break;
            }
            board.playerTurn(player2);
            System.out.println(board);
            if(board.getWinner(player1, player2) != 0){
                break;
            }
            if(board.getWinner(player1, player2) == 3){
                break;
            }
        }
    }


}

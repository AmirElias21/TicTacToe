package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
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
}

# TicTacToe

A Java console project for two people playing tic-tac-toe on the same computer. The current version prints a 3x3 board and takes turns using row and column input.

## Status

Work in progress. The console game has X/O pieces, checks rows, columns, and diagonals, and updates player win, loss, and tie counters in memory. Player names are currently hardcoded in `Main.java`.

The menu, AI opponents, saved game history, accounts, leaderboard, and JavaFX interface are unfinished or planned. `GameHistory.java` is a placeholder. The [to-do list](TicTacToe_Project_ToDo_List.txt) contains plans and may not reflect what is already implemented.

## Run locally

Install a Java Development Kit (JDK) with `javac` and `java` available in your terminal. From the repository folder:

```sh
javac -d out Board.java GameHistory.java Main.java Piece.java Player.java
java -cp out TicTacToe.Main
```

Enter a row and column from 1 to 3 when prompted. X plays first. Use numbers only; nonnumeric input is not handled and can stop the program.

## Known limitations

- The program runs one game, with no replay menu connected yet.
- A full board is checked for a tie before a win, so a winning move in the last empty square can be reported as a tie.
- Player counters are not saved between runs, and there is no graphical interface or AI opponent yet.

## Source files

- `Main.java`: starts the console game and switches turns.
- `Board.java`: stores and displays the board and checks game results.
- `Player.java` and `Piece.java`: represent players, counters, and board symbols.
- `GameHistory.java`: placeholder for future history tracking.

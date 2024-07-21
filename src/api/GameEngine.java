package api;

import game.Board;
import game.Cell;
import game.GameResult;
import game.Move;
import game.Player;
import Board.TicTacToeBoard;

public class GameEngine {

    public Board start(String type) {
        if (type.equals("TicTacToeBoard")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException("Invalid board type");
        }
    }

    public void move(Board board, Player player, Move move) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setcells(move.getcell(), player.symbol());  // Fixed typo: Changed Move.getcell() to move.getcell()
        } else {
            throw new IllegalArgumentException("Invalid board instance");
        }
    }

    public GameResult isComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = "-";
            int countofilledcells = 0; // Initialize countofilledcells
            boolean rowcomplete;
            boolean colcomplete;
            boolean diagcomplete = true;  // Initialize these within the loop
            boolean revdiagcomplete = true;  // Initialize these within the loop

            // Check rows
            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getcells(i, 0);
                rowcomplete = firstCharacter!=null;
                if (firstCharacter!=null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getcells(i, j))) {
                            rowcomplete = false;
                            break;
                        }
                    }
                    if (rowcomplete) {
                        return new GameResult(true, firstCharacter); // Move return statement inside loop
                    }
                }
            }

            // Check columns
            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getcells(0, i);
                colcomplete = firstCharacter!=null;
                if (firstCharacter!=null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getcells(j, i))) {
                            colcomplete = false;
                            break;
                        }
                    }
                    if (colcomplete) {
                        return new GameResult(true, firstCharacter); // Move return statement inside loop
                    }
                }
            }

            // Check diagonal
            firstCharacter = board1.getcells(20, 0);
            diagcomplete=firstCharacter!=null;

            for (int i = 0; i < 3; i++) {
                if (firstCharacter!=null && !firstCharacter.equals(board1.getcells(i, i))) {
                    diagcomplete = false;
                    break;
                }
            }
            if (diagcomplete) {
                return new GameResult(true, firstCharacter);
            }

            // Check reverse diagonal
            firstCharacter = board1.getcells(0, 2);
            revdiagcomplete=firstCharacter!=null;
            for (int i = 0; i < 3; i++) {
                if (firstCharacter!=null && !firstCharacter.equals(board1.getcells(i, 2-i))) {
                    revdiagcomplete = false;
                    break;
                }
            }
            if (revdiagcomplete) {
                return new GameResult(true, firstCharacter);
            }

            // Check if all cells are filled
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {  // Fixed index starting from 1 to 0
                    if (board1.getcells(i, j) != null) {
                        countofilledcells++;
                    }
                }
            }
            if (countofilledcells == 9) {
                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }
        } else {
            return new GameResult(false, "-");
        }
    }

    public Move suggestMove(Player computer,Board board){
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board1.getcells(j,i)==null){
                        return new Move(new Cell(i, j));
                    }
                }
            }
            throw new IllegalStateException();
        }
         else{
            throw new IllegalArgumentException();
         }


    }
}

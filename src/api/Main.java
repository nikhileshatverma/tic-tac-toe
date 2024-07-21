package api;
import java.util.Scanner;


import api.GameEngine;
import game.Board;
import game.Move;
import game.Player;
import game.Cell;
public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board=gameEngine.start("TicTacToeBoard");
        while (!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("0");
            Player opponent = new Player("X");
            System.out.println("Make Your Own Move");
            Scanner sc = new Scanner(System.in);
            int row, col; 
            
            System.out.println("Enter row and column:");
            System.out.println(board);
            row = sc.nextInt();
            col = sc.nextInt();
            Move oppMove = new Move(new Cell(row,col));
            gameEngine.move(board, opponent, oppMove);
            if(!gameEngine.isComplete(board).isOver()){
                Move computerMove = gameEngine.suggestMove(computer,board);
                gameEngine.move(board, computer, computerMove);
            }
        }
        System.out.println("Game Result : "+ gameEngine.isComplete(board));
        System.out.println(board);

    }
}

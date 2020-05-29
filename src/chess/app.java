package chess;

import chess.board.Board;
import chess.board.Tile;

public class app {
        
        public static void main(String[] args) {
                
                Board board = new Board();
                board.run();

                board.printBoard();
        }
}
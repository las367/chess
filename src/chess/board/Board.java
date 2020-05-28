package chess.board;

import java.util.LinkedList;

import chess.pieces.Piece;

public class Board {
        
        private Tile[][] gameBoard;

        // list of player's pieces killed by opponent
        private LinkedList<Piece> killListPlayer;

        // the other way around.
        private LinkedList<Piece> killListOpp;

        public Board () {

                gameBoard = new Tile[8][8];
        }

        // TODO: add function -> constructor -> create boards with pieces and tiles.

        /**
         * format the needed position -> easier access to tiles!
         * @param x x position according to the board
         * @param y y pos according to the board
         * @return formatted position -> as shown in the protocol (0, ... 63)
         */
        public int createPos ( int x, int y ) {

                return y * 8 + x;
        }

        /**
         * format pos -> to arrays of indeces -> fatser acces to array.
         * @param pos
         * @return
         */
        public int[] posToIndex ( int pos ) {

                return new int[]{ pos % 8, pos / 8 };
        }

        private void createBoard () {

                for ( int i = 0; i < 8; i++ ) {
                        boolean startWithBlack = i % 2 == 0;
                        for ( int j = 0; j < 8; j++ ) {
                                
                                boolean indexIsEven = j % 2 == 0;
                                TileColors color = startWithBlack ? ( 
                                        indexIsEven ? TileColors.BLACK : TileColors.WHITE
                                ) : (
                                        indexIsEven ? TileColors.WHITE : TileColors.BLACK
                                );

                                gameBoard[i][j] = new Tile(color, createPos(j, i));
                        }
                }
        }

        public void printBoard () {

                for ( int i = 0; i < gameBoard.length; i++ ) {
                        for ( int j = 0; j < gameBoard[i].length; j++ ) {
                                System.out.print( gameBoard[i][j] + "  " );
                        }
                        System.out.println();
                }
        }

        public void run () {
                createBoard();
        }
}
package chess.board;

import java.util.LinkedList;

import chess.pieces.Piece;
import chess.pieces.PieceColors;
import chess.pieces.pieceCollections.*;

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

                // creating board with its tiles.
                for ( int i = 0; i < gameBoard.length; i++ ) {

                        // check if board[i] starts with black tile.
                        boolean startWithBlack = i % 2 == 0;
                        for ( int j = 0; j < gameBoard[i].length; j++ ) {
                                
                                boolean indexIsEven = j % 2 == 0;
                                // decide which color should the tile be.
                                TileColors color = startWithBlack ? ( 
                                        indexIsEven ? TileColors.BLACK : TileColors.WHITE
                                ) : (
                                        indexIsEven ? TileColors.WHITE : TileColors.BLACK
                                );

                                // assign a tile for every place of the board.
                                gameBoard[i][j] = new Tile(color, createPos(j, i));
                        }
                }

                createPieces();
        }

        private void createPieces () {

                try {
                        firstRowCreation(0);
                        firstRowCreation(gameBoard.length - 1);
                        System.out.println("First row creation succeeded!");

                        secondRowCreation(1);
                        secondRowCreation(gameBoard.length - 2);
                        System.out.println("Second row creation succeeded!");

                        System.out.println("Board creation succeeded.");
                } catch ( CreateBoardException ex ) {

                        System.out.println("Error on creating the board.");
                        System.out.println(ex.getMessage());

                } catch ( Exception ex ) {

                        System.out.println("Board.createPieces()");
                        System.out.println(ex.getMessage());
                }
        }

        private void firstRowCreation ( int rowIndex ) throws CreateBoardException {

                // if the rowIndex provided is not where it should be, throw an error.
                if ( rowIndex != 0 && rowIndex != gameBoard.length - 1 ) throw new CreateBoardException("Error generating pieces on the first row!");

                // white color should always start on the first and second row! blac -> 7th and 8th
                PieceColors color = rowIndex == 0 ? PieceColors.WHITE : PieceColors.BLACK;

                for ( int i = 0; i < gameBoard[rowIndex].length; i++ ) {

                        Tile nowObserving = gameBoard[rowIndex][i];
                        nowObserving.setIsOccupied(true);

                        int position = createPos(i, rowIndex);
                        Piece piece;

                        // Piece creation based on its indeces.
                        if ( i == 0 || i == 7 ) {

                                piece = new Rook(color, position);
                        } else if ( i == 1 || i == 6 ) {

                                piece = new Knight(color, position);
                        } else if ( i == 2 || i == 5 ) {
                                
                                piece = new Bishop(color, position);
                        } else if ( i == 3 ) {

                                piece = new King(color, position);
                        } else {

                                piece = new Queen(color, position);
                        }

                        // set a position holder (piece) for each tile.
                        nowObserving.setPosHolder(piece);
                }
        }

        private void secondRowCreation ( int rowIndex ) throws CreateBoardException {

                // if the rowIndex provided is not where it should be, throw an error.
                if ( rowIndex != 1 && rowIndex != gameBoard.length - 2 ) throw new CreateBoardException("Error generating pieces on the second row!");

                // white color should always start on the first and second row! blac -> 7th and 8th
                PieceColors color = rowIndex == 1 ? PieceColors.WHITE : PieceColors.BLACK;
                
                for ( int i = 0; i < gameBoard[rowIndex].length; i++ ) {

                        Tile nowObserving = gameBoard[rowIndex][i];
                        int position = createPos(i, rowIndex);

                        nowObserving.setIsOccupied(true);
                        // assign the piece -> pawn at the right place..
                        nowObserving.setPosHolder(new Pawn(color, position));
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

        public Tile getTile (int pos) {

                int[] coordinates = posToIndex(pos);

                return gameBoard[ coordinates[0] ][ coordinates[1] ];
        }

        public void run () {
                createBoard();
        }
}
package chess;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.board.Board;
import chess.board.Tile;
import chess.board.TileColors;
import chess.pieces.Piece;
import chess.pieces.PieceColors;
import chess.pieces.pieceCollections.*;

public class BoardTest {

        private Board board = new Board();
        
        @Test
        public void createPos () {

                int x = 1;
                int y = 1;

                int expectedFromBoard = 9;

                assertEquals("returns create position correctly", expectedFromBoard, board.createPos(x, y));
        }

        @Test
        public void posToIndex () {
                
                int[] expectedIndeces = new int[]{ 4, 1 };
                int pos = 12;

                assertArrayEquals("returns postoindex correctly", expectedIndeces, board.posToIndex(pos));
        }

        @Test 
        public void boardCreation () {

                board.run();

                int expectedPos = 4;

                // mock data taken from protocol
                Piece mockPiece = new King( PieceColors.WHITE, expectedPos );
                Tile expectedTile = new Tile( TileColors.BLACK , expectedPos );

                expectedTile.setIsOccupied(true);
                expectedTile.setPosHolder(mockPiece);

                Tile actual = board.getTile(expectedPos);

                assertEquals("Certain tile from board is equals to board from the protocol", true, expectedTile.equals(actual));
        }
}
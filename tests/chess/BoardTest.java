package chess;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.board.Board;

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
}
package chess;

import org.junit.Test;
import org.junit.Assert.*;

import chess.engine.ChessEngine;

public class ChessTest {
        
        @Test
        void usageTest () {
                
                // declare game + receiver
                ChessEngine game1 = null;
                ChessEngine game2 = null;

                // initialize sender with each receivers -> sender1 has receiver2 and so on.
                ShortCut sender1 = new ShortCut( game2 );
                ShortCut sender2 = new ShortCut( game1 );

                // initialize game1 + game2 here
                game1 = new ChessEngine(sender1);
                game2 = new ChessEngine(sender2);
        }
}
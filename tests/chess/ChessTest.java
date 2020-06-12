package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import chess.engine.ChessEngine;
import chess.engine.ChessStates;
import chess.engine.OutOfStateException;
import chess.pieces.PieceColors;

public class ChessTest {

        // initialize sender with each receivers -> sender1 has receiver2 and so on.
        private ShortCut sender1 = new ShortCut();
        private ShortCut sender2 = new ShortCut();

        // declare game + receiver
        private ChessEngine game1 = new ChessEngine( sender1 );
        private ChessEngine game2 = new ChessEngine( sender2 );

        // mock connection here
        // sender1.setReceiver(game2);
        // sender2.setReceiver(game1);
        
        @Test
        public void startStateTest () {

                assertEquals( "game 1 should be on start state", ChessStates.START, game1.getState() );
                assertEquals( "game 2 should also be on start state", ChessStates.START, game2.getState() );
        }

        @Test
        public void diceTest () {

                sender1.setReceiver(game2);
                sender2.setReceiver(game1);

                boolean diceSent = game1.doDice();
                assertTrue( "Dice is sent by game1", diceSent );
        }

        @Test
        public void diceTestState () throws Exception {

                sender1.setReceiver(game2);
                sender2.setReceiver(game1);

                ChessUsage activeGame;
                boolean firstDice = game1.doDice();
                game2.doDice();

                // if dice is not successful -> fail.
                // can't seem to do two dices at once..
                if ( firstDice ) {

                        // find which game is active
                        activeGame = game1.isActive() ? game1 : game2;
                        // assert once again if the game
                        assertEquals( "Game should be active", ChessStates.ACTIVE, activeGame.getState() );

                } else fail();
        }

        @Test
        public void colorTest () throws Exception {

                sender1.setReceiver(game2);
                sender2.setReceiver(game1);

                game1.doDice();
                game2.doDice();
                ChessUsage activeGame = game1.isActive() ? game1 : game2;

                // active game should have white color!
                assertEquals( "Active game does have white piece color", PieceColors.WHITE, activeGame.getColor() ) ;
        }

        @Test 
        public void initBoardTest () {

                sender1.setReceiver(game2);
                sender2.setReceiver(game1);

                game1.doDice();
                // game2.doDice();

                try {
                        game1.doInitBoard();
                } catch ( OutOfStateException ex ) {
                        
                        System.out.print("passed init board test if game is not ready.");
                }

                game2.doDice();

                try {
                        game1.doInitBoard();
                        game2.doInitBoard();

                        
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                        fail();
                }
        }
}
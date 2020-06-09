package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Assert.*;

import chess.engine.ChessEngine;
import chess.engine.ChessStates;

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
        public void colorTest () throws Exception {

                sender1.setReceiver(game2);
                sender2.setReceiver(game1);

                ChessUsage activeGame;
                boolean firstDice = game1.doDice();
                boolean secondDice = game2.doDice();

                // if dice is not successful -> fail.
                // can't seem to do two dices at once..
                if ( firstDice ) {

                        // find which game is active
                        activeGame = game1.isActive() ? game1 : game2;
                        // assert once again if the game
                        assertEquals( "Game should be active", ChessStates.ACTIVE, activeGame.getState() );

                } else if ( secondDice ) {

                        throw new Exception("first dice");
                } else {

                        throw new Exception("Second dice");
                }
        }
}
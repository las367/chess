package chess;

import chess.engine.ChessStates;
import chess.engine.OutOfStateException;
import chess.pieces.PieceColors;

public interface ChessUsage {
        
        boolean isActive ();

        // calls the method dice() in the Engine -> returns true if successful
        boolean doDice ();

        boolean doDiceDebug (int dice);

        ChessStates getState ();

        PieceColors getColor ();

        void doPrintField ();

        void doInitBoard() throws OutOfStateException;
}
package chess;

import chess.engine.ChessStates;
import chess.pieces.PieceColors;

public interface ChessUsage {
        
        boolean isActive ();

        // calls the method dice() in the Engine -> returns true if successful
        boolean doDice ();

        ChessStates getState ();

        PieceColors getColor ();
}
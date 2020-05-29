package chess.pieces.pieceCollections;

import chess.pieces.IPiece;
import chess.pieces.Piece;
import chess.pieces.PieceColors;
import chess.pieces.PieceTypes;

public class Bishop extends Piece implements IPiece {

	public Bishop(PieceColors color, int pos) {
		super(color, PieceTypes.BISHOP, pos);
	}

	@Override
	public boolean canMove(int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}
        
}
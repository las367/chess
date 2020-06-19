package chess.pieces.pieceCollections;

import chess.pieces.IPiece;
import chess.pieces.Piece;
import chess.pieces.PieceColors;
import chess.pieces.PieceTypes;

public class Pawn extends Piece implements IPiece {

	public Pawn(PieceColors color, int pos) {
		super(color, PieceTypes.PAWN, pos);
		//TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}
        
}
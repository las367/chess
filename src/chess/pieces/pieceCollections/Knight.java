package chess.pieces.pieceCollections;

import chess.pieces.IPiece;
import chess.pieces.Piece;
import chess.pieces.PieceColors;
import chess.pieces.PieceTypes;

public class Knight extends Piece implements IPiece {

	public Knight(PieceColors color, int pos) {
		super(color, PieceTypes.KNIGHTS, pos);
		//TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}
        
}
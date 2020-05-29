package chess.pieces;

public class Piece {

        // color and type of the Piece -> from enums.
        protected PieceColors color;
        protected PieceTypes type;

        protected int pos;

        public Piece (PieceColors color, PieceTypes type, int pos) {
                this.color = color;
                this.type = type;
                this.pos = pos;
        }
        
        public int getPos() {
                return this.pos;
        }

        public void setPos(int pos) {
                this.pos = pos;
        }

}
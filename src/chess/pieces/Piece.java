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

        public PieceColors getColor() {
                return this.color;
        }

        public PieceTypes getType() {
                return this.type;
        }

        @Override
        public boolean equals (Object obj) {

                Piece piece = (Piece) obj;

                if ( piece.getType() != type ) return false;
                if ( piece.getColor() != color ) return false;
                if ( piece.getPos() != pos ) return false;

                return true;
        }
}
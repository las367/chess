package chess.pieces;

public class Piece {

        // color and type of the Piece -> from enums.
        protected PieceColors color;
        protected PieceTypes type;

        protected int posX;
        protected int posY;

        public Piece (PieceColors color, PieceTypes type, int posX, int posY) {
                this.color = color;
                this.type = type;
                this.posX = posX;
                this.posY = posY;
        }
        
        public int getPosX() {
                return this.posX;
        }

        public void setPosX(int posX) {
                this.posX = posX;
        }

        public int getPosY() {
                return this.posY;
        }

        public void setPosY(int posY) {
                this.posY = posY;
        }

}
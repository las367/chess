package chess.board;

import chess.pieces.Piece;

public class Tile {
        
        // color -> black or white?
        private TileColors tileColor;

        // is the tile occupied by a piece?
        private boolean isOccupied;

        // positions of the tile.
        private int pos;

        private Piece posHolder;

        public Tile (TileColors tileColor, int pos) {
                this.tileColor = tileColor;
                this.pos = pos;
        }


        public boolean getIsOccupied() {
                return this.isOccupied;
        }

        public void setIsOccupied(boolean isOccupied) {
                this.isOccupied = isOccupied;
        }

        public Piece getPosHolder() {
                return this.posHolder;
        }

        public void setPosHolder(Piece posHolder) {
                this.posHolder = posHolder;
        }


        @Override
        public String toString() {
                return "{" +
                        " tileColor='" + tileColor + "'" +
                        ", isOccupied='" + getIsOccupied() + "'" +
                        ", pos='" + pos + "'" +
                        ", posHolder='" + getPosHolder() + "'" +
                        "}";
        }        
}
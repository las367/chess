package chess.board;

import chess.pieces.Piece;

public class Tile {
        
        // color -> black or white?
        private TileColors tileColor;

        // is the tile occupied by a piece?
        private boolean isOccupied;

        // positions of the tile.
        private int posX;
        private int posY;

        private Piece posHolder;

        public Tile (TileColors tileColor, int posX, int posY) {
                this.tileColor = tileColor;
                this.posX = posX;
                this.posY = posY;
        }

        public Tile (TileColors tileColor, boolean isOccupied, int posX, int posY, Piece posHolder) {
                this.tileColor = tileColor;
                this.isOccupied = isOccupied;
                this.posX = posX;
                this.posY = posY;
                this.posHolder = posHolder;
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

}
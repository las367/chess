package chess.engine;

import java.io.IOException;
import java.util.Random;

import chess.ChessUsage;
import chess.board.Board;
import chess.pieces.PieceColors;
import chess.protocolBinding.Receiver;
import chess.protocolBinding.Sender;

public class ChessEngine implements IEngine, Receiver, ChessUsage {

        Sender out;
        ChessStates state;
        Board gameBoard;       
        int dice;

        PieceColors playerColor;

        private final String mNotConnected = "Softwares are not yet connected!";

        // intialize in, out and start state here!
        public ChessEngine ( Sender out ) {

                state = ChessStates.START;
                this.out = out;
        }

        // to create strings with data and IDs appended at start.
        private String formatString (int actionId, int[] dataArray) {

                StringBuilder builder = new StringBuilder();

                builder.append(actionId);

                for ( int i : dataArray ) {
                        builder.append(i);
                }

                return builder.toString();
        }

        ////////////////
        ////////////////
        ////////////////
        // ENGINE SIDE //
        ////////////////
        ////////////////
        ////////////////

        @Override
        public void dice() throws OutOfStateException {

                if ( state != ChessStates.START ) throw new OutOfStateException(mNotConnected);

                Random random = new Random();
                dice = random.nextInt(101);       

                // bigger num -> choose color, smaller -> wait for color.
                state = ChessStates.WAIT;

                try {
                        out.sendDice(dice);
                } catch ( IOException ex ) {

                        // TODO: handle errror
                        ex.printStackTrace();
                }
        }

	@Override
	public void chooseColor(boolean white) throws OutOfStateException {
                
                if ( state != ChessStates.CHOOSING_COLOR ) throw new OutOfStateException(mNotConnected);
                
                // if white -> set the player's piece to white AND set state to active
                if ( white ) {

                        playerColor = PieceColors.WHITE;
                        state = ChessStates.ACTIVE;

                        try {
                                // player with the bigger color is the one sending the color!
                                out.sendChooseCholor(false);
                        } catch ( IOException ex ) {
        
                                // TODO: error hendlings
                                ex.printStackTrace();
                        }

                } else {

                        playerColor = PieceColors.BLACK;
                        state = ChessStates.PASSIVE;
                }
	}

	@Override
	public void move(int from, int to) throws OutOfStateException {

                if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");
                
                // TODO: Integration with GUI?

                state = ChessStates.PASSIVE;

                try {

                        out.sendMove(from, to);
                } catch ( IOException ex ) {

                        // TODO: error handling
                        ex.printStackTrace();
                }
	}

	@Override
	public void movePawnRule(int from, int figureType) throws OutOfStateException {

		if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");
                
                // TODO
                
                state = ChessStates.PASSIVE;
                
                try {

                        out.sendMovePawnRule(from, figureType);
                } catch ( IOException ex ) {

                        // TODO: error handling
                        ex.printStackTrace();
                }
	}

	@Override
	public void rochade(int from) throws OutOfStateException {

                if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");
                
                // TODO
                switch ( from ) {
                        case 1: 
                                // Dame
                                break;
                        case 2:
                                // Turm
                                break;
                        case 3:
                                // Springer
                                break;
                        case 4:
                                // Laeufer
                                break;
                        default:
                                // error handling
                                break;
                }
                
                state = ChessStates.PASSIVE;
	}

	@Override
	public void endGame(int reason) throws OutOfStateException {
                
                if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");

                switch ( reason ) {
                        case 0: 
                                // checkmate!
                                break;
                        case 1:
                                // stalemate
                                break;
                        case 2:
                                // abandon
                                break;
                        default:
                                // error handling
                                break;
                }

                state = ChessStates.END;
	}

	@Override
	public void proposalEnd(int reason) throws OutOfStateException {
		
                if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");
                
                state = ChessStates.WAIT;
	}

	@Override
	public void proposalAnswer(boolean accept) throws OutOfStateException {

                if ( state != ChessStates.ANSWERING ) throw new OutOfStateException("Player is not on active state!");

                state = accept ? ChessStates.END : ChessStates.PASSIVE;
	}

	public String sayHelloWorld() {
                return "Hello World!";
        }

        ///////////////////
        ///////////////////
        ///////////////////
        // RECEIVER SIDE //
        ///////////////////
        ///////////////////
        ///////////////////

	@Override
	public String[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readDice(int random) throws IOException, OutOfStateException {
                
                if ( state == ChessStates.START ) dice();
                else if ( state != ChessStates.WAIT ) throw new OutOfStateException(mNotConnected);
                
                if ( random == dice ) {

                        state = ChessStates.START;
                        dice();
                } else {

                        boolean isBigger = dice > random;
                        // player with the bigger number gets to choose the color
                        state = isBigger ? ChessStates.CHOOSING_COLOR : ChessStates.WAIT_FOR_COLOR; 
                        if ( isBigger ) chooseColor(true);
                }
        }
        
        @Override
	public void readChooseColor(boolean white) throws IOException, OutOfStateException {
                
                // Here -> when the player got smaller number than the opponents' -> wait for color provided by the opponent.
                if ( state != ChessStates.WAIT_FOR_COLOR ) throw new OutOfStateException("Out of State");
                state = ChessStates.CHOOSING_COLOR;

                chooseColor(white);
	}

	@Override
	public void readMove(int from, int to) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMovePawnRule(int from, int figureType) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readRochade(int from) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readEndGame(int reason) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readProposalEnd(int reason) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readProposalAnswer(boolean accept) throws IOException {
		// TODO Auto-generated method stub
		
        }
        
        //////////////
        //////////////
        //////////////
        // GUI SIDE //
        //////////////
        //////////////
        //////////////

        ////////////////
        ////////////////
        ////////////////
        // USAGE SIDE //
        ////////////////
        ////////////////
        ////////////////

        @Override
	public boolean isActive() {
                
                return state == ChessStates.ACTIVE;
        }
        
        @Override
        public boolean doDice () {

                try {
                        dice();
                        return true;
                } catch ( OutOfStateException ex ) {

                        return false;
                }
        }

        @Override
        public ChessStates getState () { return state; }

        @Override
        public PieceColors getColor () { return playerColor; } 
}
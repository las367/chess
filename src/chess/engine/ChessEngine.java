package chess.engine;

import java.util.Random;

import chess.board.Board;
import chess.protocolBinding.Receiver;
import chess.protocolBinding.Sender;

public class ChessEngine implements IEngine {

        Sender out;
        Receiver in;
        ChessStates state;
        Board gameBoard;       

        // intialize in, out and start state here!
        public ChessEngine() {

                state = ChessStates.START;
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

        @Override
        public void dice() throws OutOfStateException {

                if ( state != ChessStates.START ) throw new OutOfStateException("Softwares are not yet connected!");

                Random random = new Random();
                int num = random.nextInt(101);       

                // bigger num -> choose color, smaller -> wait for color.
                state = ChessStates.WAIT;
        }

	@Override
	public void chooseColor(boolean white) throws OutOfStateException {
                
                if ( state != ChessStates.CHOOSING_COLOR ) throw new OutOfStateException("Softwares are not yet connected!");

                state = white ? ChessStates.ACTIVE : ChessStates.PASSIVE;
	}

	@Override
	public void move(int from, int to) throws OutOfStateException {

                if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");
                
                // TODO

                state = ChessStates.PASSIVE;
	}

	@Override
	public void movePawnRule(int from, int figureType) throws OutOfStateException {

		if ( state != ChessStates.ACTIVE ) throw new OutOfStateException("Player is not on active state!");
                
                // TODO
                
                state = ChessStates.PASSIVE;	
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
}
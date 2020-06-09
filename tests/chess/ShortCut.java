package chess;

import java.io.IOException;

import chess.engine.OutOfStateException;
import chess.protocolBinding.Receiver;
import chess.protocolBinding.Sender;

// mock connection with another client.
public class ShortCut implements Sender {

        // receiver here -> receiver from another client.
        private final Receiver receiver;

        public ShortCut (Receiver receiver) { 

                this.receiver = receiver;
        }


	@Override
	public void write(String message) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDice(int random) throws IOException {

                try {
                        receiver.readDice(random);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendChooseCholor(boolean white) throws IOException {
		
		try {
                        receiver.readChooseColor(white);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendMove(int from, int to) throws IOException {
		
		try {
                        receiver.readMove(from, to);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendMovePawnRule(int from, int figureType) throws IOException {
		
		try {
                        receiver.readMovePawnRule(from, figureType);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendRochade(int from) throws IOException {
		
		try {
                        receiver.readRochade(from);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendEndGame(int reason) throws IOException {
		
		try {
                        receiver.readEndGame(reason);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendProposalEnd(int reason) throws IOException {
                
                try {
                        receiver.readProposalEnd(reason);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

	@Override
	public void sendProposalAnswer(boolean accept) throws IOException {
		
		try {
                        receiver.readProposalAnswer(accept);
                } catch ( OutOfStateException ex ) {

                        ex.printStackTrace();
                }
	}

}

package chess.protocolBinding;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Class to bind TCP Connection with another client.
 * Methods -> based on sender interface and 
 */
public class StreamBindingSender implements Sender {

        private final DataOutputStream dos;

        public StreamBindingSender ( OutputStream os ) {
                dos = new DataOutputStream(os);
        }       

	@Override
	public void write(String message) {
                
                // TODO: helper method?
	}

	@Override
	public void sendDice(int random) throws IOException {

                dos.writeInt(ActionID.DICE);
                dos.writeInt(random);
	}

	@Override
	public void sendChooseCholor(boolean white) throws IOException {
		
		dos.writeInt(ActionID.CHOOSE_COLOR);
		dos.writeBoolean(white);
	}

	@Override
	public void sendMove(int from, int to) throws IOException {

                dos.writeInt(ActionID.MOVE);
                dos.writeInt(from);
                dos.writeInt(to);
	}

	@Override
	public void sendMovePawnRule(int from, int figureType) throws IOException {

                dos.writeInt(ActionID.MOVE_PAWN_RULE);
                dos.writeInt(from);
                dos.writeInt(figureType);
	}

	@Override
	public void sendRochade(int from) throws IOException {

                dos.writeInt(ActionID.ROCHADE);
                dos.writeInt(from);
	}

	@Override
	public void sendEndGame(int reason) throws IOException {

                dos.writeInt(ActionID.END_GAME);
                dos.writeInt(reason);
	}

	@Override
	public void sendProposalEnd(int reason) throws IOException {

                dos.writeInt(ActionID.PROPOSAL_END);
                dos.writeInt(reason);
	}

	@Override
	public void sendProposalAnswer(boolean accept) throws IOException {
		
		dos.writeInt(ActionID.PROPOSAL_ANSWER);
                dos.writeBoolean(accept);
	}
        
}
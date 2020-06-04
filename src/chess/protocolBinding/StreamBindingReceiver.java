package chess.protocolBinding;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class for TCP Binding -> would run as a thread an has receiver attribute -> direct access to the engine??
 * 
 * TODO: implement outofstateexception on the binding?
 */
public class StreamBindingReceiver extends Thread {

        private final DataInputStream dis;
        private final Receiver receiver;

        public StreamBindingReceiver (InputStream is, Receiver receiver) {

                dis = new DataInputStream(is);
                this.receiver = receiver;
        }

        public void run () {

                boolean isRunning = true;

                while ( isRunning ) {
                        try {
                                // cmd as in command -> which method should be ran
                                int cmd = dis.readInt();

                                switch ( cmd ) {

                                        case ActionID.DICE: 
                                                readDice();
                                                break;
                                        case ActionID.MOVE:
                                                readMove();
                                                break;
                                        case ActionID.MOVE_PAWN_RULE:
                                                readMovePawnRule();
                                                break;
                                        case ActionID.ROCHADE:
                                                readRochade();
                                                break;
                                        case ActionID.END_GAME:
                                                readEndGame();
                                                break;
                                        case ActionID.PROPOSAL_END:
                                                readProposalEnd();
                                                break;
                                        default: 
                                                throw new UnknownCommadException("Unknown command found");

                                }
                        } catch ( IOException ex ) {
                                ex.printStackTrace();
                                isRunning = false;
                        } catch ( UnknownCommadException ex ) {
                                System.err.print( ex.getMessage() );
                                ex.printStackTrace();
                                isRunning = false;
                        }
                }
        }

	public String[] read() {
                // TODO helper method?
		return null;
	}

	public void readDice() throws IOException {
                
                int random = dis.readInt();
                receiver.readDice(random);
	}

	public void readMove() throws IOException {

                int from = dis.readInt();
                int to = dis.readInt();
                receiver.readMove(from, to);
	}

	public void readMovePawnRule() throws IOException {

                int from = dis.readInt();
                int figureType = dis.readInt();
                receiver.readMovePawnRule(from, figureType);
	}

	public void readRochade() throws IOException {

                int from = dis.readInt();
                receiver.readRochade(from);
	}

	public void readEndGame() throws IOException {

                int reason = dis.readInt();
                receiver.readEndGame(reason);
	}

	public void readProposalEnd() throws IOException {

                int reason = dis.readInt();
                receiver.readProposalEnd(reason);
	}

	public void readProposalAnswer() throws IOException {
                
                boolean accept = dis.readBoolean();
                receiver.readProposalAnswer(accept);
	}
        
}
package chess.protocolBinding;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBindingReceiver extends Thread implements Receiver  {

        private final DataInputStream dis;

        public StreamBindingReceiver (InputStream is) {
                dis = new DataInputStream(is);
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
                        } catch ( UnknownCommadException ex ) {
                                ex.printStackTrace();
                        }
                }
        }

	@Override
	public String[] read() {
                // TODO helper method?
		return null;
	}

	@Override
	public void readDice() throws IOException {
                
                int random = dis.readInt();
	}

	@Override
	public void readMove() throws IOException {

                int from = dis.readInt();
                int to = dis.readInt();
	}

	@Override
	public void readMovePawnRule() throws IOException {

                int from = dis.readInt();
                int figureType = dis.readInt();
	}

	@Override
	public void readRochade() throws IOException {

                int from = dis.readInt();
	}

	@Override
	public void readEndGame() throws IOException {

                int reason = dis.readInt();
	}

	@Override
	public void readProposalEnd() throws IOException {

                int reason = dis.readInt();
	}

	@Override
	public void readProposalAnswer() throws IOException {
                
                boolean accept = dis.readBoolean();
	}
        
}
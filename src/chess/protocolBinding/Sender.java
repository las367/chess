package chess.protocolBinding;

import java.io.IOException;

public interface Sender {

        void write (String message) throws IOException;

        void sendDice (int random) throws IOException;

        void sendMove (int from, int to) throws IOException;

        void sendMovePawnRule (int from, int figureType) throws IOException;

        void sendRochade (int from) throws IOException;

        void sendEndGame (int reason) throws IOException;

        void sendProposalEnd (int reason) throws IOException;

        void sendProposalAnswer (boolean accept) throws IOException;
}
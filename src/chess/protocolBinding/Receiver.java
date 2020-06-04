package chess.protocolBinding;

import java.io.IOException;

public interface Receiver {

        /**
         * receive an array of string from inputstream!
         * @return array of string!
         */
        String[] read ();

        void readDice (int random) throws IOException;

        void readMove (int from, int to) throws IOException;

        void readMovePawnRule (int from, int figureType) throws IOException;

        void readRochade (int from) throws IOException;

        void readEndGame (int reason) throws IOException;

        void readProposalEnd (int reason) throws IOException;

        void readProposalAnswer (boolean accept) throws IOException;
}
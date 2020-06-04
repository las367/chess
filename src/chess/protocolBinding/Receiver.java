package chess.protocolBinding;

import java.io.IOException;

public interface Receiver {

        /**
         * receive an array of string from inputstream!
         * @return array of string!
         */
        String[] read ();

        void readDice () throws IOException;

        void readMove () throws IOException;

        void readMovePawnRule () throws IOException;

        void readRochade () throws IOException;

        void readEndGame () throws IOException;

        void readProposalEnd () throws IOException;

        void readProposalAnswer () throws IOException;
}
package chess.protocolBinding;

import java.io.IOException;

import chess.engine.OutOfStateException;

public interface Receiver {

        /**
         * receive an array of string from inputstream!
         * @return array of string!
         */
        String[] read ();

        void readDice (int random) throws IOException, OutOfStateException;

        void readMove (int from, int to) throws IOException, OutOfStateException;

        void readMovePawnRule (int from, int figureType) throws IOException, OutOfStateException;

        void readRochade (int from) throws IOException, OutOfStateException;

        void readEndGame (int reason) throws IOException, OutOfStateException;

        void readProposalEnd (int reason) throws IOException, OutOfStateException;

        void readProposalAnswer (boolean accept) throws IOException, OutOfStateException;
}
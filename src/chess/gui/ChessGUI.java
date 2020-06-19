package chess.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGUI {

        public static void main (String[] args) {
                
                System.out.print("Whats Up!\n");

                // add buffered reader for user input -> system in = stdin command line!
                BufferedReader userIn = new BufferedReader( new InputStreamReader(System.in) );
                boolean again = true; // loop var for looping the UI

                while (again) {

                        try {
                                // read user input
                                String inputString = userIn.readLine();
                                System.out.printf("Boom Boom: %s\n", inputString);
                                again = false;
                        } catch (IOException ex) {
                                ex.printStackTrace();
                        }
                }
        }
}
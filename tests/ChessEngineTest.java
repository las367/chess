import chess.engine.ChessEngine;

import static org.junit.Assert.*;
import org.junit.Test;

public class ChessEngineTest {

        @Test
        public void testHelloWorld() {

                ChessEngine engine = new ChessEngine();

                String helloWorld = engine.sayHelloWorld();
                String expected = "Hello World!";

                assertEquals("Comparing Hello World", true, helloWorld.equals(expected));
        }
}       
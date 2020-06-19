package chess.engine;

public class OutOfStateException extends Exception {
    
    public OutOfStateException (String errorMessage) {
        super(errorMessage);
    } 
    
}
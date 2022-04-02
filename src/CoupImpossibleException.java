public class CoupImpossibleException extends Exception {
    public CoupImpossibleException() {
        super("Coup impossible");
    }

    public CoupImpossibleException(String message) {
        super(message);
    }
}

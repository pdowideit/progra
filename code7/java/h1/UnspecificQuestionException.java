package people;

public class UnspecificQuestionException extends Exception {
    public UnspecificQuestionException() {
        super("Unspecific Question");
    }

    public UnspecificQuestionException(String error) {
        super(error);
    }
}
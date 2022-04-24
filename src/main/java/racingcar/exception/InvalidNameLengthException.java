package racingcar.exception;

public class InvalidNameLengthException extends IllegalArgumentException implements ErrorMessageHandler {

    private static final String ERROR_MESSAGE = "Invalid name length.";

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}

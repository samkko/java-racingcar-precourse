package racingcar.exception;

public interface ErrorMessageHandler {

    String getErrorMessage();

    default String getFormattedErrorMessage() {
        return "[ERROR] " + getErrorMessage();
    }
}

package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.ViewController;
import racingcar.exception.MessageException;
import racingcar.model.GameCount;
import racingcar.model.RacingCars;
import racingcar.view.ConsoleOutputView;
import racingcar.view.NextStepInputView;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application {

    private static final ViewController viewController = new ViewController(new NextStepInputView(), new ConsoleOutputView());
    private static final GameController gameController = new GameController();

    public static void main(String[] args) {

        RacingCars racingCars = null;
        GameCount gameCount = null;

        while(!racingCarInputSuccess());
        while(!gameCountInputSuccess());
        gameController.play();
        viewController.printMessageWithNewLine("실행 결과");
        viewController.printMessage(gameController.getGameResult());
        viewController.printMessageWithNewLine("최종 우승자: " + gameController.getWinners());
    }

    private static boolean racingCarInputSuccess() {
        try {
            gameController.initRacingCars(viewController.getCarNames());
        } catch (IllegalArgumentException e) {
            if(e instanceof MessageException) {
                viewController.printMessageWithNewLine(((MessageException) e).getFormattedErrorMessage());
                return false;
            }
        }

        return true;
    }

    private static boolean gameCountInputSuccess() {
        try {
            gameController.initGameCount(viewController.getGameCount());
        } catch (IllegalArgumentException e) {
            if(e instanceof MessageException) {
                viewController.printMessageWithNewLine(((MessageException) e).getFormattedErrorMessage());
                return false;
            }
        }

        return true;
    }
}

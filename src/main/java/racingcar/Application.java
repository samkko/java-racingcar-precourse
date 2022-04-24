package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.ViewController;
import racingcar.view.ConsoleOutputView;
import racingcar.view.NextStepInputView;

public class Application {

    private static final ViewController viewController = new ViewController(new NextStepInputView(), new ConsoleOutputView());
    private static final GameController gameController = new GameController();

    public static void main(String[] args) {

        gameController.initGame(viewController.getCarNames(), viewController.getGameCount());
        gameController.play();
    }
}

package racingcar.controller;

import racingcar.model.GameCount;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class GameController {

    private RacingCars racingCars;
    private GameCount gameCount;

    public void initGame(String carNamesInput, String gameCountInput) {
        racingCars = RacingCars.createRacingCarsFromInput(carNamesInput);
        gameCount = new GameCount(gameCountInput);
    }

    public void play() {

        while(gameCount.isEnd()) {
            moveCars();
            gameCount.play();
        }
    }

    private void moveCars() {
        for(RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }
}

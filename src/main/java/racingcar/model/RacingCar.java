package racingcar.model;

import racingcar.exception.InvalidNameLengthException;

public class RacingCar {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;

    private final String name;
    private final MovingStrategy movingStrategy;
    private int distance;

    private RacingCar(String name, MovingStrategy movingStrategy) {
        validateName(name);
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCar createRacingCarWithMovingStrategy(String name, MovingStrategy movingStrategy) {
        return new RacingCar(name, movingStrategy);
    }

    public static RacingCar createRacingCarWithDefaultStrategy(String name) {
        return new RacingCar(name, RandomMovingStrategy.getInstance());
    }

    private void validateName(String name) {
        if(name.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new InvalidNameLengthException();
        }
    }

    public void move() {
        if(movingStrategy.move()) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

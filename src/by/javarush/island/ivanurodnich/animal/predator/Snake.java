package by.javarush.island.ivanurodnich.animal.predator;

import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.directions.DrivingDirectionsEnum;

public class Snake extends Predator {
    @Override
    public DrivingDirectionsEnum choseDirection() {
        return null;
    }

    @Override
    public AnimalEnum getAnimal() {
        return AnimalEnum.SNAKE;
    }
}

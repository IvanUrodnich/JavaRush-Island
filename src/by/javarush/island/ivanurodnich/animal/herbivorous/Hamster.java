package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.directions.DrivingDirectionsEnum;

public class Hamster extends Herbivorous{
    @Override
    public DrivingDirectionsEnum choseDirection() {
        return null;
    }

    @Override
    public AnimalEnum getAnimal() {
        return AnimalEnum.HAMSTER;
    }
}

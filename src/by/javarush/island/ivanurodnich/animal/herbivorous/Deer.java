package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;
import by.javarush.island.ivanurodnich.animal.directions.DrivingDirectionsEnum;

public class Deer extends Herbivorous{
    @Override
    public DrivingDirectionsEnum choseDirection() {
        return null;
    }

    @Override
    public AnimalTypeEnum getAnimalType() {
        return null;
    }

    @Override
    public AnimalEnum getAnimal() {
        return AnimalEnum.DEER;
    }
}

package by.javarush.island.ivanurodnich.animal.predator;

import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;

public class Bear extends Predator {

    @Override
    public AnimalEnum getAnimal() {
        return AnimalEnum.BEAR;
    }
}

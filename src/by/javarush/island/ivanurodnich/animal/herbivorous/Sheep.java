package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;

public class Sheep extends Herbivorous{


    @Override
    public AnimalTypeEnum getAnimalType() {
        return null;
    }

    @Override
    public AnimalEnum getAnimal() {
        return AnimalEnum.SHEEP;
    }
}

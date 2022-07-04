package by.javarush.island.ivanurodnich.animal.predator;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;

public abstract class Predator extends Animal {
    @Override
    public void eat() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public AnimalTypeEnum getAnimalType() {
        return AnimalTypeEnum.PREDATOR;
    }
}

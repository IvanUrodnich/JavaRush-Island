package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.AnimalEnum;

public class Duck extends Herbivorous{
    @Override
    public AnimalEnum getAnimal() {
        return AnimalEnum.DUCK;
    }
}

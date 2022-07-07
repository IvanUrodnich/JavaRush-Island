package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;
import by.javarush.island.ivanurodnich.cell.Cell;

public abstract class Herbivorous extends Animal {

    @Override
    public void eat(Cell cell) {

    }

    @Override
    public void multiply() {

    }

    @Override
    public AnimalTypeEnum getAnimalType() {
        return AnimalTypeEnum.HERBIVOROUS;
    }


}

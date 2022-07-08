package by.javarush.island.ivanurodnich.animal.predator;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;
import by.javarush.island.ivanurodnich.cell.Cell;

import java.util.Set;

public abstract class Predator extends Animal {
    @Override
    public void eat(Cell cell) {
    boolean isAteFull;
    Set<AnimalEnum> animalEnumSet = getFoodChances().keySet();

    }

    @Override
    public void multiply() {

    }

    @Override
    public AnimalTypeEnum getAnimalType() {
        return AnimalTypeEnum.PREDATOR;
    }
}

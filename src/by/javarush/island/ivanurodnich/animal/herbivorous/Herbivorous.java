package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;
import by.javarush.island.ivanurodnich.animal.directions.DrivingDirectionsEnum;
import by.javarush.island.ivanurodnich.cell.Cell;

public abstract class Herbivorous extends Animal {
    public boolean isNotVegan() {
        return false;
    }

    @Override
    public void eat(Cell cell) {
        if (isLive()) {
            boolean isAteFull = false;
            if (isNotVegan()) {
                // TODo (для утки)
                isAteFull = cell.getPlants().reduceAmount(getCharacteristic().getEnergy());
            } else {
                isAteFull = cell.getPlants().reduceAmount(getCharacteristic().getEnergy());
            }
            if (isAteFull) {
                resetHugerCounter();
            } else {
                addOneTackHunger();
            }
        }
    }

    @Override
    public void multiply() {

    }

    @Override
    public DrivingDirectionsEnum choseDirection() {
        return null;
    }
}

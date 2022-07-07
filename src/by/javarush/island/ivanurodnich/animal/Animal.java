package by.javarush.island.ivanurodnich.animal;

import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.animal.characteristic.CharacteristicDto;
import by.javarush.island.ivanurodnich.animal.directions.DrivingDirectionsEnum;
import by.javarush.island.ivanurodnich.cell.Cell;

public abstract class Animal {

    //количество голода
    private int amountOfHunger = 0;

    protected CharacteristicDto getCharacteristic() {
        return Characteristic.getCharacteristicDto(getAnimal());
    }

    public abstract void eat(Cell cell);

    public abstract void multiply();

    //направление движения
    public abstract DrivingDirectionsEnum choseDirection();

    public abstract AnimalTypeEnum getAnimalType();

    public abstract AnimalEnum getAnimal();


    public int getAmountOfHunger() {
        return amountOfHunger;
    }

    // добавить счётчик голода + 1 так
    public void addOneTackHunger() {
        amountOfHunger++;
    }

    //сбросить счётчик голода
    public void resetHugerCounter() {
        this.amountOfHunger = 0;
    }

    public boolean isLive() {
        return true;
    }
}

package by.javarush.island.ivanurodnich.animal.task;

import by.javarush.island.ivanurodnich.cell.Cell;

public class CellTask implements Runnable{
    private final Cell cell;

    public CellTask(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        //растения растут
        cell.getPlants().plantGrew();
        //животное кушает
        cell.getAnimals().forEach(animal -> animal.eat(cell));
    }
}

package by.javarush.island.ivanurodnich.location;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalFactory;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.animal.characteristic.CharacteristicDto;
import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.plants.Plants;

public class Location {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;

    private final Cell[][] island = new Cell[HEIGHT][WIDTH];

    public Location() {
        init();
        initAnimalAndPlants();
    }

    public void init() {
        System.out.println("Инициализация поля island");
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                island[i][j] = new Cell();
            }
        }
        System.out.println("Инициализация поля island завершена");
    }

    private void initAnimalAndPlants() {
        for (Cell[] cells : island) {
            for (Cell cell : cells) {
                initAnimal(cell);
                int amountPlantsInCell = (int) (Math.random() * 10000);
                cell.getPlants().setAmount(amountPlantsInCell);
            }
        }
    }

    private static void initAnimal(Cell cell) {
        for (AnimalEnum value : AnimalEnum.values()) {
            CharacteristicDto characteristicDto = Characteristic.getCharacteristicDto(value);
            int amountAnimalInCell = (int) (Math.random() * characteristicDto.getMaxAmount());
            for (int i = 0; i < amountAnimalInCell; i++) {
                cell.getAnimals().add(AnimalFactory.getAnimal(value));
            }
        }
    }

    public Cell[][] getIsland() {
        return island;
    }
}

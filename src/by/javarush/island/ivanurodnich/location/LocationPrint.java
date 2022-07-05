package by.javarush.island.ivanurodnich.location;

import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.plants.Plants;

public class LocationPrint {
    public static void print(Cell[][] island) {
        for (int i = 0; i < island.length; i++) {
            for(int j = 0; j < island[i].length; j++) {
                System.out.printf("клетка[%d][%d] Старт%n", i, j);
                printCell(island[i][j]);
                System.out.println("test");
                System.out.printf("клетка[%d][%d] Финиш%n", i, j);
            }
        }
    }

    public static void printCell(Cell cell) {
        Plants plants = cell.getPlants();
        System.out.println("Растений осталось: " + plants.getAmount());
    }
}

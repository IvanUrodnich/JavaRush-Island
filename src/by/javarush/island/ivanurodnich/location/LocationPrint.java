package by.javarush.island.ivanurodnich.location;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.plants.Plants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        System.out.println("Растений осталось: - " + plants.getAmount());
        System.out.println("Животных осталось: - " + cell.getAnimals().size());

        //группировка списка животных по типу животного
        Map<AnimalEnum, List<Animal>> animalEnumListMap = cell.getAnimals().stream()
                .collect(Collectors.groupingBy(Animal::getAnimal));
        //Проход по animalEnumListMap, для каждого типа животных свой список животных
        for (Map.Entry<AnimalEnum, List<Animal>> animalEnumListEntry : animalEnumListMap.entrySet()) {
            AnimalEnum key = animalEnumListEntry.getKey();
            int size = animalEnumListEntry.getValue().size();
            System.out.println("Всего в клетке " + key.getDescription() + " - " + size);
            long count = animalEnumListEntry.getValue().stream()
                    .filter(animal -> animal.getAmountOfHunger() == 0)
                    .count();
            System.out.println(key.getDescription() + "Всего поело - " + count + ", голодных - " + (size - count));
        }
        System.out.println("Животных пришло - " + cell.getTotalAnimalsCame());
        System.out.println("Животных ушло - " + cell.getTotalAnimalsGone());
        System.out.println("Животных умерло голодными - " + cell.getDeadAnimals());
        System.out.println("Животных съедено - " + cell.getEatenAnimals());
        cell.resetCounters();
    }
}

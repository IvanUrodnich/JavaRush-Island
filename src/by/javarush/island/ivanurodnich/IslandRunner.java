package by.javarush.island.ivanurodnich;

import by.javarush.island.ivanurodnich.animal.chances.FoodChances;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.animal.task.LocationTask;
import by.javarush.island.ivanurodnich.location.Location;
import by.javarush.island.ivanurodnich.location.LocationPrint;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class IslandRunner {

    private static final int STEP_COUNT = 20;

    public static void main(String[] args) {

        //создаём остров
        Location location = new Location();
        //печатаем остров
        LocationPrint.print(location.getIsland());

        //Запуск ходов на острове
        for (int i = 0; i < STEP_COUNT; i++) {
            System.out.printf("Расчёт хода номер = %d НАЧАТ%n", i + 1);
            new LocationTask(location).run();
            System.out.printf("Расчёт хода номер = %d ЗАВЕРШЕН%n", i + 1);
        }

        System.out.println("ВРЕМЯ ПОКИНУТЬ ОСТРОВ ! ! !");
    }
}


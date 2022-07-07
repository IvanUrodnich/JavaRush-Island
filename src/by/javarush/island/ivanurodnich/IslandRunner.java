package by.javarush.island.ivanurodnich;

import by.javarush.island.ivanurodnich.animal.chances.FoodChances;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.location.Location;
import by.javarush.island.ivanurodnich.location.LocationPrint;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class IslandRunner {

    private static final int STEP_COUNT = 2;

    public static void main(String[] args) {

        FoodChances foodChances = new FoodChances();
        //создаём остров
        Location location = new Location();
        //печатаем остров
        LocationPrint.print(location.getIsland());

    }
}


package by.javarush.island.ivanurodnich;

import by.javarush.island.ivanurodnich.animal.chances.FoodChances;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.location.Location;
import by.javarush.island.ivanurodnich.location.LocationPrint;

public class IslandRunner {
    public static void main(String[] args) {
        FoodChances foodChances = new FoodChances();
        Characteristic characteristic = new Characteristic();
        Location location = new Location(characteristic);
        LocationPrint.print(location.getIsland());
    }
}

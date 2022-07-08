package by.javarush.island.ivanurodnich.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static boolean getRandomBoolean ( int probability) {
        int randomValue = ThreadLocalRandom.current().nextInt(100);
        return randomValue <=probability;
    }
}

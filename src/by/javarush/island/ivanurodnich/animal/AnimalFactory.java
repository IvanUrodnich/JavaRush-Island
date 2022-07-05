package by.javarush.island.ivanurodnich.animal;

import by.javarush.island.ivanurodnich.animal.herbivorous.*;
import by.javarush.island.ivanurodnich.animal.predator.*;

public class AnimalFactory {
    /* фабрика по созданию животных

     */

    public static Animal getAnimal(AnimalEnum animalEnum) {
        return switch (animalEnum) {
            case WOLF -> new Wolf();
            case SNAKE -> new Snake();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case HARE -> new Hare();
            case HAMSTER -> new Hamster();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case KANGAROO -> new Kangaroo();
            case COW -> new Cow();
            case DUCK -> new Duck();
            case CATERPILLAR -> new Caterpillar();
        };
    }
}

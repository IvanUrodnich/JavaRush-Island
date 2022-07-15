package by.javarush.island.ivanurodnich.cell;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.plants.Plants;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Animal> animals = new ArrayList<>();
    private Plants plants = new Plants();

    //ушло животных всего
    private int totalAnimalsGone = 0;

    //пришло животных всего
    private int totalAnimalsCame = 0;

    //Умерло животных
    private int deadAnimals = 0;

    //Съедено животных
    private int eatenAnimals = 0;

    public void resetCounters() {
        totalAnimalsCame = 0;
        totalAnimalsGone = 0;
        deadAnimals = 0;
        eatenAnimals = 0;
    }

    //увеличить счётчик на одно животное, которое ушло
    public void addToTotalAnimalsGone() {
        this.totalAnimalsGone++;
    }

    //увеличить счётчик на одно животное, которое пришло
    public void addOneToTotalAnimalsCame() {
        this.totalAnimalsCame++;
    }

    //увеличить счётчик на одно животное, которое съедено
    public void addOneToEatenAnimals() {
        this.eatenAnimals++;
    }

    //увеличить счётчик на одно животное, которое умерло
    public void addOneToDead() {
        this.deadAnimals++;
    }

    public int getTotalAnimalsGone() {
        return totalAnimalsGone;
    }

    public int getTotalAnimalsCame() {
        return totalAnimalsCame;
    }

    public int getDeadAnimals() {
        return deadAnimals;
    }

    public int getEatenAnimals() {
        return eatenAnimals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }



    public Plants getPlants() {
        return plants;
    }

    public void setPlants(Plants plants) {
        this.plants = plants;
    }
}

package by.javarush.island.ivanurodnich.animal.predator;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.utils.Utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    @Override
    public void eat(Cell cell) {
    boolean isAteFull;
    //получение списка животных, которых сможем съесть
    Set<AnimalEnum> animalEnumSet = getFoodChances().keySet();
        List<Animal> collect = cell.getAnimals().stream()
                .filter(Animal::isLive)
                .filter(animal -> animalEnumSet.contains(animal.getAnimal())).toList();
        double energy = getCharacteristic().getEnergy();
        for (Animal animal : collect) {
            //тип животного, которого едим
            AnimalEnum animalEnum = animal.getAnimal();
            boolean randomBoolean = Utils.getRandomBoolean(getFoodChances().get(animalEnum));
            if (randomBoolean) {
                //масса животного, которого едим
                double weight = Characteristic.getCharacteristicDto(animalEnum).getWeight();
                energy = energy - weight;
                //помечаем что животное съедено
                animal.killAnimal();
            }
            if (energy <= 0)
                break;
        }
            if (energy > 0) {
                isAteFull = cell.getPlants().reduceAmount(energy);
            } else
                isAteFull = true;
            //проверяем наелось ли животное - сброли счётчик голода, иначе добавляем ход
        if (isAteFull) {
            resetHugerCounter();
        } else {
            addOneTackHunger();
        }
    }

    @Override
    public void multiply() {

    }

    @Override
    public AnimalTypeEnum getAnimalType() {
        return AnimalTypeEnum.PREDATOR;
    }
}

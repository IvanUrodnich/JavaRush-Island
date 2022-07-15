package by.javarush.island.ivanurodnich.animal.herbivorous;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalTypeEnum;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.utils.Utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Herbivorous extends Animal {
    public boolean isNotVegan() {
        return false;
    }

    @Override
    public void eat(Cell cell) {
        //если животное живое
        if (isLive()) {
            boolean isAteFull;
            if (isNotVegan()) {
                //Псевдотравоядный кушает
                Set<AnimalEnum> animalEnums = getFoodChances().keySet();
                //получаем список животных, которых можем скушать
                List<Animal> collect = cell.getAnimals().stream()
                        .filter(Animal::isLive)
                        .filter(animal -> animalEnums.contains(animal.getAnimal())).toList();
                double energy = getCharacteristic().getEnergy();

                for (Animal animal : collect) {
                    //тип животного, которого едим
                    AnimalEnum animalEnum = animal.getAnimal();

                    boolean randomBoolean = Utils.getRandomBoolean(getFoodChances().get(animalEnum));
                    if (randomBoolean) {
                        //масса животного, которого едим
                        double weight = Characteristic.getCharacteristicDto(animalEnum).getWeight();
                        energy = energy - weight;
                        animal.killAnimal();
                    }

                    if (energy <= 0)
                        break;
                }
                //Если животными не наелись, кушаем траву
                if (energy > 0) {
                    isAteFull = cell.getPlants().reduceAmount(energy);
                } else isAteFull = true;
            } else {
                isAteFull = cell.getPlants().reduceAmount(getCharacteristic().getEnergy());
            }
            // проверяем наелось ли животное - сбросили счётчик голода, иначе добавляем +1ход
            if (isAteFull) {
                resetHugerCounter();
            } else {
                addOneTackHunger();
            }
        }

    }

}

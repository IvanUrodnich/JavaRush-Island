package by.javarush.island.ivanurodnich.animal.task;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.animal.AnimalEnum;
import by.javarush.island.ivanurodnich.animal.AnimalFactory;
import by.javarush.island.ivanurodnich.animal.characteristic.Characteristic;
import by.javarush.island.ivanurodnich.animal.characteristic.CharacteristicDto;
import by.javarush.island.ivanurodnich.cell.Cell;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CellTask implements Runnable{
    private final Cell cell;

    public CellTask(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        //растения растут
        cell.getPlants().plantGrew();
        //животное кушает
        cell.getAnimals().forEach(animal -> animal.eat(cell));
        //животные, которые голодыне уже N ходов умираю
        cell.getAnimals().forEach(animal -> {
            if (animal.getAmountOfHunger() > animal.getCharacteristic().getCountLife())
                animal.killAnimal();
        });
        //поиск животных, которые мертвы
        List<Animal> notLiveAnimalList = cell.getAnimals().stream()
                .filter(animal -> !animal.isLive()).toList();
        //удаляем мертвых животныъ
        cell.getAnimals().removeAll(notLiveAnimalList);
        //размножение
        //Подсчёт количества животных, готовых к размножению
        Map<AnimalEnum, Long> countMultiply = cell.getAnimals().stream()
                .filter(Animal::multiply)
                .collect(Collectors.groupingBy(
                        Animal::getAnimal,
                        Collectors.counting()
                ));

        //Сколько животных на клетке
        Map<AnimalEnum, Long> countAnimal = cell.getAnimals().stream()
                .collect(Collectors.groupingBy(
                        Animal::getAnimal,
                        Collectors.counting()
                ));

        // для каждого вида животных
        countMultiply.forEach((animalEnum, aLong) -> {
            //получаем информацию о животных
            CharacteristicDto characteristicDto = Characteristic.getCharacteristicDto(animalEnum);
            //проходим по каждому второму животному ( 2 животных порождают одного нового)
            for (int i = 0; i < aLong; i++) {
                Long aLong1 = countAnimal.get(animalEnum);
                //пока в клетке есть место для нового животного - создаем и помещаем к животным
                if (characteristicDto.getMaxAmount() > aLong1) {
                    cell.getAnimals().add(AnimalFactory.getAnimal(animalEnum));
                    countAnimal.put(animalEnum, ++aLong1);
                } else break;

            }
        });
    }
}

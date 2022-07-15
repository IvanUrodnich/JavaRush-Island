package by.javarush.island.ivanurodnich.animal.task;

import by.javarush.island.ivanurodnich.animal.Animal;
import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.location.Location;
import by.javarush.island.ivanurodnich.location.LocationPrint;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class LocationTask implements Runnable {

    private final Location location;

    public LocationTask(Location location) {
        this.location = location;
    }

    @Override
    public void run() {

        final Cell[][] island = location.getIsland();
        //обработка клеток каждая в своём потоке
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        List<Future<?>> futures = new ArrayList<>();
        Arrays.stream(island)
                .flatMap(Arrays::stream)
                .forEach(cell -> futures.add(scheduledExecutorService.submit(new CellTask(cell))));
        //нужно подождать выполнение всех потоков
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception ignored) {
            }
        }
        scheduledExecutorService.shutdown();

        //движения живтоных
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                // в каждой клетке
                int finalI = i;
                int finalJ = j;
                //создаем список животных, которые ушли с клетки
                List<Animal> removedList = new ArrayList<>();
                //для каждого животного, который готов ходить
                island[i][j].getAnimals().stream()
                        .filter(Animal::isReadyToMove)
                        .forEach(animal -> {
                            //вычисляем скорость
                            int movementSpeed = animal.movementSpeed();
                            //получаем список клеток куда можем ходить
                            List<Cell> listMovedAnimal = getListMovedAnimal(island, finalI, finalJ, movementSpeed);
                            //перемешиваем список
                            Collections.shuffle(listMovedAnimal);
                            //смотрим сколько животных в клетке
                            for (Cell cell : listMovedAnimal) {
                                long countAnimals = cell.getAnimals().stream()
                                        .filter(animal1 -> animal1.getAnimal() == animal.getAnimal())
                                        .count();

                                //если есть место для животного
                                if (countAnimals < animal.getCharacteristic().getMaxAmount()) {
                                    //добавляем животное в новую клетку
                                    cell.getAnimals().add(animal);
                                    //увеличиваем счётчик на 1 кода животное пришло
                                    cell.addOneToTotalAnimalsCame();
                                    //помечаем животное для исключения в этом списке
                                    removedList.add(animal);
                                    animal.setReadyToMove(false);
                                    break;
                                }
                            }
                        });
                //удаляем животных, которые ушли
                island[i][j].getAnimals().removeAll(removedList);
                //помечаем сколько животных ушло
                island[i][j].addToTotalAnimalsGone(removedList.size());
            }
        }

        //После хода всех животных ставим флаг для следующего хода
        for (Cell[] cells : island) {
            for (Cell cell : cells) {
                cell.getAnimals().forEach(animal -> animal.setReadyToMove(true));
            }
        }

        LocationPrint.print(location.getIsland());

    }

    //получение списка возможных ходов животного
    public static List<Cell> getListMovedAnimal(Cell[][] island, final int i, final int j, int movementSpeed) {
        List<Cell> result = new ArrayList<>();
        int left = Math.max(j - movementSpeed, 0);
        int right = Math.min(j + movementSpeed, island[j].length - 1);
        int down = Math.min(i + movementSpeed, island.length - 1);
        int up = Math.max(i - movementSpeed, 0);

        for (int k = up; k <= down; k++) {
            for (int l = left; l <= right; l++) {
                if (!(k == i && l == j)) {
                    result.add(island[k][l]);
                }
            }
        } return result;
    }
}


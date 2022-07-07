package by.javarush.island.ivanurodnich.animal.task;

import by.javarush.island.ivanurodnich.cell.Cell;
import by.javarush.island.ivanurodnich.location.Location;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LocationTask implements Runnable{

    private final Location location;

    public LocationTask(Location location) {
        this.location = location;
    }

    @Override
    public void run() {

        final Cell[][] island = location.getIsland();
        //обработка клеток каждая в своём потоке
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        Arrays.stream(island)
                .flatMap(Arrays::stream)
                .forEach(cell -> scheduledExecutorService.submit(new CellTask(cell)));
        }
    }


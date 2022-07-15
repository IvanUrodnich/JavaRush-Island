package by.javarush.island.ivanurodnich.animal;

public enum AnimalEnum {

    WOLF(AnimalTypeEnum.PREDATOR,"Волк"),
    SNAKE(AnimalTypeEnum.PREDATOR, "Змея"),
    FOX(AnimalTypeEnum.PREDATOR, "Лиса"),
    BEAR(AnimalTypeEnum.PREDATOR, "Медведь"),
    EAGLE(AnimalTypeEnum.PREDATOR, "Орел"),
    HORSE(AnimalTypeEnum.HERBIVOROUS, "Лошадь"),
    DEER(AnimalTypeEnum.HERBIVOROUS, "Олень"),
    HARE(AnimalTypeEnum.HERBIVOROUS, "Заяц"),
    HAMSTER(AnimalTypeEnum.HERBIVOROUS, "Хомяк"),
    GOAT(AnimalTypeEnum.HERBIVOROUS, "Коза"),
    SHEEP(AnimalTypeEnum.HERBIVOROUS, "Овца"),
    KANGAROO(AnimalTypeEnum.HERBIVOROUS, "Кенгуру"),
    COW(AnimalTypeEnum.HERBIVOROUS, "Корова"),
    DUCK(AnimalTypeEnum.HERBIVOROUS, "Утка"),
    CATERPILLAR(AnimalTypeEnum.HERBIVOROUS, "Гусеницв");

    private final AnimalTypeEnum animalTypeEnum;
    private final String description;


    AnimalEnum(AnimalTypeEnum animalTypeEnum, String description) {
        this.animalTypeEnum = animalTypeEnum;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public AnimalTypeEnum getAnimalTypeEnum() {
        return animalTypeEnum;
    }
}

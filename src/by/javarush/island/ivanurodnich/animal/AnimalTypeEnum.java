package by.javarush.island.ivanurodnich.animal;

public enum AnimalTypeEnum {
    PREDATOR("Хищник"),
    HERBIVOROUS("Травоядный");

    private final String description;

    AnimalTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

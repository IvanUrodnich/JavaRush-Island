package by.javarush.island.ivanurodnich.animal.characteristic;

public class CharacteristicDto {
    //масса животного
    private double weight;

    //максимальное количество животных одного вида на клетке
    private int maxAmount;

    //скорость перемещения клеток за ход
    private int moveSpeed;

    //количество кг для полного насыщения
    private double energy;

    //сколько может жить животное после падения шкалы сытости до нуля
    private int countLife;

    public CharacteristicDto(double weight, int maxAmount, int moveSpeed, double energy, int countLife) {
        this.weight = weight;
        this.maxAmount = maxAmount;
        this.moveSpeed = moveSpeed;
        this.energy = energy;
        this.countLife = countLife;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getCountLife() {
        return countLife;
    }

    public void setCountLife(int countLife) {
        this.countLife = countLife;
    }
}

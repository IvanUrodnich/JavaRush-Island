package by.javarush.island.ivanurodnich.plants;

public class Plants {
    private double amount = 0;

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // уменьшение количества растений
    public boolean reduceAmount (double i) {
        amount = amount - i;
        if (amount < 0) {
            amount = 0;
            return false;
        }
        return true;
    }

    //увеличение количества растений на 5%
    public void plantGrew() {
        amount = (amount / 100 * 5);
    }
}

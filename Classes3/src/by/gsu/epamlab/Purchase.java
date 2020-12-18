package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public static final String NAME = "STEEL";
    public static final int PRICE = 300;
    private int number;
    private double discount;
    private WeekDay weekDay;

    public Purchase() {
    }

    public Purchase(int number, double discount, WeekDay weekDay) {
        this.number = number;
        this.discount = discount;
        this.weekDay = weekDay;
    }

    public Purchase(int number, double percent, int day) {
        this(number, percent, WeekDay.values()[day]);
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getCost() {
        return (int) Math.round(PRICE * this.number * (100 - this.discount) / 100 / 100) * 100;
    }

    @Override
    public String toString() {
        return number + ";" + discount + ";" + weekDay + ";" + Functions.bynToString(getCost());
    }

    @Override
    public int compareTo(Purchase o) {
        return this.number - o.number;
    }

}

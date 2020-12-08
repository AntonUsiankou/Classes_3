package by.gsu.epamlab;

public class Purchase implements Comparable <Purchase>{
    public static final String NAME = "STEEL";
    public static final int PRICE = 300;
    private int number;
    private double discount;
    private WeekDay weekDay;

    public Purchase(){
    }

    public Purchase (int number, double discount, WeekDay weekDay){
        this.number = number;
        this.discount = discount;
        this.weekDay = weekDay;
    }
    public Purchase (int number, double percent, int day) {
        this(number, percent, WeekDay.values()[day]);
    }
    public static String getNAME() {
        return NAME;
    }
    public static int getPRICE() {
        return PRICE;
    }
    public int getNumber() {
        return number;
    }
    public double getDiscount() {
        return discount;
    }
    public WeekDay getWeekDay() { return weekDay;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getCost(){
        return (int) Math.round(getPRICE() * this.number * (100 - this.discount)/100);
    }

    @Override
    public String toString() {
        return  number + ";" + discount + ";" + weekDay + ";" + ToByn.toByn(getCost());
    }

    @Override
    public int compareTo(Purchase o) {
        return this.number - o.number;
    }

}

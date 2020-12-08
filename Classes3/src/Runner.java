import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.ToByn;
import by.gsu.epamlab.WeekDay;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            sc.useLocale(Locale.ENGLISH);

            Purchase[] purchases;
            final int PURCHASES_NUMBER = sc.nextInt();
            if (PURCHASES_NUMBER >= 0 && PURCHASES_NUMBER <= 10) {
                purchases = new Purchase[PURCHASES_NUMBER];

                for (int i = 0; i < PURCHASES_NUMBER; i++) {
                    int number = sc.nextInt();
                    double discount = sc.nextDouble();
                    int day = sc.nextInt();

                    purchases[i] = new Purchase(number, discount, day);
                }
                printPurchases(purchases);

                double averageCost = 0.0;
                double sumInMonday = 0.0;
                WeekDay currentDay = null;

                double priceOfDayByOneItem = 0.0;
                for (Purchase purchase : purchases) {
                    averageCost += Double.valueOf(ToByn.toByn(purchase.getCost()));
                    if (purchase.getWeekDay() == WeekDay.MONDAY){ sumInMonday += Double.valueOf(ToByn.toByn(purchase.getCost()));
                    if (priceOfDayByOneItem < purchase.getCost()) {
                        priceOfDayByOneItem = purchase.getCost();
                        currentDay = purchase.getWeekDay();
                    }
                }
}
                if (PURCHASES_NUMBER > 0){ averageCost /= purchases.length;}

                System.out.println("Mean cost = " + String.format("%.3f", averageCost));
                System.out.println("The total cost in Monday = " + String.format("%.2f", sumInMonday));
                System.out.println("The day with the maximum cost purchase is " + currentDay);
                Arrays.sort(purchases);

                printPurchases(purchases);

                Comparator<Purchase> c = new Comparator<Purchase>() {
                    @Override
                    public int compare(Purchase o1, Purchase o2) {
                        if (o1.getNumber() == o2.getNumber()) return 0;
                        return -1;
                    }
                };
                System.out.println(purchases[Arrays.binarySearch(purchases, new Purchase(5, 0, 0), c)]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    private static void printPurchases(Purchase[] purchases) {
        System.out.println(Purchase.NAME);
        System.out.println(Purchase.PRICE);

        for(int i = 0; i < purchases.length; i++) {
            System.out.println(purchases[i]);
        }
    }
}

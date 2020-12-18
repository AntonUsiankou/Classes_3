import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.Functions;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static void printPurchases(Purchase[] purchases) {
        System.out.println("\nNAME - " + Purchase.NAME + ", PRICE_BYN - " + Functions.bynToString(Purchase.PRICE));

        for (int i = 0; i < purchases.length; i++) {
            System.out.println(purchases[i]);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = new Purchase(sc.nextInt(), sc.nextDouble(), sc.nextInt());
            }
            printPurchases(purchases);

            double averageCost = 0.0;
            int sumInMonday = 0;
            WeekDay currentDay = null;
            double priceOfDayByOneItem = 0.0;

            for (Purchase purchase : purchases) {
                int cost = purchase.getCost();
                averageCost += cost;
                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    sumInMonday += cost;
                }
                if (priceOfDayByOneItem <= cost) {
                    priceOfDayByOneItem = cost;
                    currentDay = purchase.getWeekDay();
                }
            }
            if (purchases.length > 0) {
                averageCost /= purchases.length;
            }

            System.out.printf(Locale.ENGLISH, "\nThe mean cost is %.3f %n", averageCost / 100);
            System.out.println("The total cost in Monday = " + Functions.bynToString(sumInMonday));
            System.out.println("The day with the maximum cost purchase is " + currentDay);

            Arrays.sort(purchases);
            printPurchases(purchases);

            Purchase key = new Purchase(5, 0, null);
            int pos = Arrays.binarySearch(purchases, key);
            if (pos >= 0) {
                System.out.println("\nPurchase with number = 5: " + purchases[pos]);
            } else {
                System.out.println("\nRequired purchase is not found");
            }


        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}

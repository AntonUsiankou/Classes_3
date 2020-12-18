package by.gsu.epamlab;

public class Functions {
    public static String bynToString(int kopecks) {
        return kopecks / 100 + "." + kopecks % 100 / 10 + kopecks % 10;
    }
}
